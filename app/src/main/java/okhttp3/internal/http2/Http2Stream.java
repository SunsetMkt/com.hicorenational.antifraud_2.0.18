package okhttp3.internal.http2;

import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.SocketTimeoutException;
import java.util.ArrayList;
import java.util.List;
import okio.AsyncTimeout;
import okio.Buffer;
import okio.BufferedSource;
import okio.Sink;
import okio.Source;
import okio.Timeout;

/* loaded from: classes2.dex */
public final class Http2Stream {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    long bytesLeftInWriteWindow;
    final Http2Connection connection;
    private boolean hasResponseHeaders;

    /* renamed from: id */
    final int f21461id;
    private final List<Header> requestHeaders;
    private List<Header> responseHeaders;
    final FramingSink sink;
    private final FramingSource source;
    long unacknowledgedBytesRead = 0;
    final StreamTimeout readTimeout = new StreamTimeout();
    final StreamTimeout writeTimeout = new StreamTimeout();
    ErrorCode errorCode = null;

    final class FramingSink implements Sink {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private static final long EMIT_BUFFER_SIZE = 16384;
        boolean closed;
        boolean finished;
        private final Buffer sendBuffer = new Buffer();

        FramingSink() {
        }

        private void emitFrame(boolean z) throws IOException {
            long min;
            synchronized (Http2Stream.this) {
                Http2Stream.this.writeTimeout.enter();
                while (Http2Stream.this.bytesLeftInWriteWindow <= 0 && !this.finished && !this.closed && Http2Stream.this.errorCode == null) {
                    try {
                        Http2Stream.this.waitForIo();
                    } finally {
                    }
                }
                Http2Stream.this.writeTimeout.exitAndThrowIfTimedOut();
                Http2Stream.this.checkOutNotClosed();
                min = Math.min(Http2Stream.this.bytesLeftInWriteWindow, this.sendBuffer.size());
                Http2Stream.this.bytesLeftInWriteWindow -= min;
            }
            Http2Stream.this.writeTimeout.enter();
            try {
                Http2Stream.this.connection.writeData(Http2Stream.this.f21461id, z && min == this.sendBuffer.size(), this.sendBuffer, min);
            } finally {
            }
        }

        @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            synchronized (Http2Stream.this) {
                if (this.closed) {
                    return;
                }
                if (!Http2Stream.this.sink.finished) {
                    if (this.sendBuffer.size() > 0) {
                        while (this.sendBuffer.size() > 0) {
                            emitFrame(true);
                        }
                    } else {
                        Http2Stream http2Stream = Http2Stream.this;
                        http2Stream.connection.writeData(http2Stream.f21461id, true, null, 0L);
                    }
                }
                synchronized (Http2Stream.this) {
                    this.closed = true;
                }
                Http2Stream.this.connection.flush();
                Http2Stream.this.cancelStreamIfNecessary();
            }
        }

        @Override // okio.Sink, java.io.Flushable
        public void flush() throws IOException {
            synchronized (Http2Stream.this) {
                Http2Stream.this.checkOutNotClosed();
            }
            while (this.sendBuffer.size() > 0) {
                emitFrame(false);
                Http2Stream.this.connection.flush();
            }
        }

        @Override // okio.Sink
        public Timeout timeout() {
            return Http2Stream.this.writeTimeout;
        }

        @Override // okio.Sink
        public void write(Buffer buffer, long j2) throws IOException {
            this.sendBuffer.write(buffer, j2);
            while (this.sendBuffer.size() >= 16384) {
                emitFrame(false);
            }
        }
    }

    private final class FramingSource implements Source {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        boolean closed;
        boolean finished;
        private final long maxByteCount;
        private final Buffer receiveBuffer = new Buffer();
        private final Buffer readBuffer = new Buffer();

        FramingSource(long j2) {
            this.maxByteCount = j2;
        }

        private void updateConnectionFlowControl(long j2) {
            Http2Stream.this.connection.updateConnectionFlowControl(j2);
        }

        private void waitUntilReadable() throws IOException {
            Http2Stream.this.readTimeout.enter();
            while (this.readBuffer.size() == 0 && !this.finished && !this.closed && Http2Stream.this.errorCode == null) {
                try {
                    Http2Stream.this.waitForIo();
                } finally {
                    Http2Stream.this.readTimeout.exitAndThrowIfTimedOut();
                }
            }
        }

        @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
        public void close() throws IOException {
            long size;
            synchronized (Http2Stream.this) {
                this.closed = true;
                size = this.readBuffer.size();
                this.readBuffer.clear();
                Http2Stream.this.notifyAll();
            }
            if (size > 0) {
                updateConnectionFlowControl(size);
            }
            Http2Stream.this.cancelStreamIfNecessary();
        }

        @Override // okio.Source
        public long read(Buffer buffer, long j2) throws IOException {
            ErrorCode errorCode;
            long j3;
            if (j2 < 0) {
                throw new IllegalArgumentException("byteCount < 0: " + j2);
            }
            synchronized (Http2Stream.this) {
                waitUntilReadable();
                if (this.closed) {
                    throw new IOException("stream closed");
                }
                errorCode = Http2Stream.this.errorCode;
                if (this.readBuffer.size() > 0) {
                    j3 = this.readBuffer.read(buffer, Math.min(j2, this.readBuffer.size()));
                    Http2Stream.this.unacknowledgedBytesRead += j3;
                } else {
                    j3 = -1;
                }
                if (errorCode == null && Http2Stream.this.unacknowledgedBytesRead >= Http2Stream.this.connection.okHttpSettings.getInitialWindowSize() / 2) {
                    Http2Stream.this.connection.writeWindowUpdateLater(Http2Stream.this.f21461id, Http2Stream.this.unacknowledgedBytesRead);
                    Http2Stream.this.unacknowledgedBytesRead = 0L;
                }
            }
            if (j3 != -1) {
                updateConnectionFlowControl(j3);
                return j3;
            }
            if (errorCode == null) {
                return -1L;
            }
            throw new StreamResetException(errorCode);
        }

        void receive(BufferedSource bufferedSource, long j2) throws IOException {
            boolean z;
            boolean z2;
            boolean z3;
            while (j2 > 0) {
                synchronized (Http2Stream.this) {
                    z = this.finished;
                    z2 = true;
                    z3 = this.readBuffer.size() + j2 > this.maxByteCount;
                }
                if (z3) {
                    bufferedSource.skip(j2);
                    Http2Stream.this.closeLater(ErrorCode.FLOW_CONTROL_ERROR);
                    return;
                }
                if (z) {
                    bufferedSource.skip(j2);
                    return;
                }
                long read = bufferedSource.read(this.receiveBuffer, j2);
                if (read == -1) {
                    throw new EOFException();
                }
                j2 -= read;
                synchronized (Http2Stream.this) {
                    if (this.readBuffer.size() != 0) {
                        z2 = false;
                    }
                    this.readBuffer.writeAll(this.receiveBuffer);
                    if (z2) {
                        Http2Stream.this.notifyAll();
                    }
                }
            }
        }

        @Override // okio.Source
        public Timeout timeout() {
            return Http2Stream.this.readTimeout;
        }
    }

    class StreamTimeout extends AsyncTimeout {
        StreamTimeout() {
        }

        public void exitAndThrowIfTimedOut() throws IOException {
            if (exit()) {
                throw newTimeoutException(null);
            }
        }

        @Override // okio.AsyncTimeout
        protected IOException newTimeoutException(IOException iOException) {
            SocketTimeoutException socketTimeoutException = new SocketTimeoutException("timeout");
            if (iOException != null) {
                socketTimeoutException.initCause(iOException);
            }
            return socketTimeoutException;
        }

        @Override // okio.AsyncTimeout
        protected void timedOut() {
            Http2Stream.this.closeLater(ErrorCode.CANCEL);
        }
    }

    Http2Stream(int i2, Http2Connection http2Connection, boolean z, boolean z2, List<Header> list) {
        if (http2Connection == null) {
            throw new NullPointerException("connection == null");
        }
        if (list == null) {
            throw new NullPointerException("requestHeaders == null");
        }
        this.f21461id = i2;
        this.connection = http2Connection;
        this.bytesLeftInWriteWindow = http2Connection.peerSettings.getInitialWindowSize();
        this.source = new FramingSource(http2Connection.okHttpSettings.getInitialWindowSize());
        this.sink = new FramingSink();
        this.source.finished = z2;
        this.sink.finished = z;
        this.requestHeaders = list;
    }

    private boolean closeInternal(ErrorCode errorCode) {
        synchronized (this) {
            if (this.errorCode != null) {
                return false;
            }
            if (this.source.finished && this.sink.finished) {
                return false;
            }
            this.errorCode = errorCode;
            notifyAll();
            this.connection.removeStream(this.f21461id);
            return true;
        }
    }

    void addBytesToWriteWindow(long j2) {
        this.bytesLeftInWriteWindow += j2;
        if (j2 > 0) {
            notifyAll();
        }
    }

    void cancelStreamIfNecessary() throws IOException {
        boolean z;
        boolean isOpen;
        synchronized (this) {
            z = !this.source.finished && this.source.closed && (this.sink.finished || this.sink.closed);
            isOpen = isOpen();
        }
        if (z) {
            close(ErrorCode.CANCEL);
        } else {
            if (isOpen) {
                return;
            }
            this.connection.removeStream(this.f21461id);
        }
    }

    void checkOutNotClosed() throws IOException {
        FramingSink framingSink = this.sink;
        if (framingSink.closed) {
            throw new IOException("stream closed");
        }
        if (framingSink.finished) {
            throw new IOException("stream finished");
        }
        ErrorCode errorCode = this.errorCode;
        if (errorCode != null) {
            throw new StreamResetException(errorCode);
        }
    }

    public void close(ErrorCode errorCode) throws IOException {
        if (closeInternal(errorCode)) {
            this.connection.writeSynReset(this.f21461id, errorCode);
        }
    }

    public void closeLater(ErrorCode errorCode) {
        if (closeInternal(errorCode)) {
            this.connection.writeSynResetLater(this.f21461id, errorCode);
        }
    }

    public Http2Connection getConnection() {
        return this.connection;
    }

    public synchronized ErrorCode getErrorCode() {
        return this.errorCode;
    }

    public int getId() {
        return this.f21461id;
    }

    public List<Header> getRequestHeaders() {
        return this.requestHeaders;
    }

    public Sink getSink() {
        synchronized (this) {
            if (!this.hasResponseHeaders && !isLocallyInitiated()) {
                throw new IllegalStateException("reply before requesting the sink");
            }
        }
        return this.sink;
    }

    public Source getSource() {
        return this.source;
    }

    public boolean isLocallyInitiated() {
        return this.connection.client == ((this.f21461id & 1) == 1);
    }

    public synchronized boolean isOpen() {
        if (this.errorCode != null) {
            return false;
        }
        if ((this.source.finished || this.source.closed) && (this.sink.finished || this.sink.closed)) {
            if (this.hasResponseHeaders) {
                return false;
            }
        }
        return true;
    }

    public Timeout readTimeout() {
        return this.readTimeout;
    }

    void receiveData(BufferedSource bufferedSource, int i2) throws IOException {
        this.source.receive(bufferedSource, i2);
    }

    void receiveFin() {
        boolean isOpen;
        synchronized (this) {
            this.source.finished = true;
            isOpen = isOpen();
            notifyAll();
        }
        if (isOpen) {
            return;
        }
        this.connection.removeStream(this.f21461id);
    }

    void receiveHeaders(List<Header> list) {
        boolean z;
        synchronized (this) {
            z = true;
            this.hasResponseHeaders = true;
            if (this.responseHeaders == null) {
                this.responseHeaders = list;
                z = isOpen();
                notifyAll();
            } else {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(this.responseHeaders);
                arrayList.add(null);
                arrayList.addAll(list);
                this.responseHeaders = arrayList;
            }
        }
        if (z) {
            return;
        }
        this.connection.removeStream(this.f21461id);
    }

    synchronized void receiveRstStream(ErrorCode errorCode) {
        if (this.errorCode == null) {
            this.errorCode = errorCode;
            notifyAll();
        }
    }

    public void sendResponseHeaders(List<Header> list, boolean z) throws IOException {
        boolean z2;
        boolean z3;
        if (list == null) {
            throw new NullPointerException("responseHeaders == null");
        }
        synchronized (this) {
            this.hasResponseHeaders = true;
            if (z) {
                z2 = false;
                z3 = false;
            } else {
                this.sink.finished = true;
                z2 = true;
                z3 = true;
            }
        }
        if (!z2) {
            synchronized (this.connection) {
                z2 = this.connection.bytesLeftInWriteWindow == 0;
            }
        }
        this.connection.writeSynReply(this.f21461id, z3, list);
        if (z2) {
            this.connection.flush();
        }
    }

    public synchronized List<Header> takeResponseHeaders() throws IOException {
        List<Header> list;
        if (!isLocallyInitiated()) {
            throw new IllegalStateException("servers cannot read response headers");
        }
        this.readTimeout.enter();
        while (this.responseHeaders == null && this.errorCode == null) {
            try {
                waitForIo();
            } catch (Throwable th) {
                this.readTimeout.exitAndThrowIfTimedOut();
                throw th;
            }
        }
        this.readTimeout.exitAndThrowIfTimedOut();
        list = this.responseHeaders;
        if (list == null) {
            throw new StreamResetException(this.errorCode);
        }
        this.responseHeaders = null;
        return list;
    }

    void waitForIo() throws InterruptedIOException {
        try {
            wait();
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            throw new InterruptedIOException();
        }
    }

    public Timeout writeTimeout() {
        return this.writeTimeout;
    }
}
