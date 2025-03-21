package okio;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import p286h.C5226e1;
import p286h.C5715y1;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5535f0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Pipe.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u001e\u001a\u00020\u001f2\u0006\u0010\u0011\u001a\u00020\nJ\r\u0010\u0011\u001a\u00020\nH\u0007¢\u0006\u0002\b J\r\u0010\u0018\u001a\u00020\u0019H\u0007¢\u0006\u0002\b!J&\u0010\"\u001a\u00020\u001f*\u00020\n2\u0017\u0010#\u001a\u0013\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u001f0$¢\u0006\u0002\b%H\u0082\bR\u0014\u0010\u0005\u001a\u00020\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0011\u001a\u00020\n8G¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\fR\u001a\u0010\u0012\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0013\u0010\u0018\u001a\u00020\u00198G¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u001aR\u001a\u0010\u001b\u001a\u00020\u0013X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u0015\"\u0004\b\u001d\u0010\u0017¨\u0006&"}, m23546d2 = {"Lokio/Pipe;", "", "maxBufferSize", "", "(J)V", "buffer", "Lokio/Buffer;", "getBuffer$okio", "()Lokio/Buffer;", "foldedSink", "Lokio/Sink;", "getFoldedSink$okio", "()Lokio/Sink;", "setFoldedSink$okio", "(Lokio/Sink;)V", "getMaxBufferSize$okio", "()J", "sink", "sinkClosed", "", "getSinkClosed$okio", "()Z", "setSinkClosed$okio", "(Z)V", "source", "Lokio/Source;", "()Lokio/Source;", "sourceClosed", "getSourceClosed$okio", "setSourceClosed$okio", "fold", "", "-deprecated_sink", "-deprecated_source", "forward", "block", "Lkotlin/Function1;", "Lkotlin/ExtensionFunctionType;", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class Pipe {

    @InterfaceC5816d
    private final Buffer buffer = new Buffer();

    @InterfaceC5817e
    private Sink foldedSink;
    private final long maxBufferSize;

    @InterfaceC5816d
    private final Sink sink;
    private boolean sinkClosed;

    @InterfaceC5816d
    private final Source source;
    private boolean sourceClosed;

    public Pipe(long j2) {
        this.maxBufferSize = j2;
        if (this.maxBufferSize >= 1) {
            this.sink = new Sink() { // from class: okio.Pipe$sink$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    boolean hasDeadline;
                    synchronized (Pipe.this.getBuffer$okio()) {
                        if (Pipe.this.getSinkClosed$okio()) {
                            return;
                        }
                        Sink foldedSink$okio = Pipe.this.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            Pipe.this.setSinkClosed$okio(true);
                            Buffer buffer$okio = Pipe.this.getBuffer$okio();
                            if (buffer$okio == null) {
                                throw new C5226e1("null cannot be cast to non-null type java.lang.Object");
                            }
                            buffer$okio.notifyAll();
                            foldedSink$okio = null;
                        }
                        C5715y1 c5715y1 = C5715y1.f20665a;
                        if (foldedSink$okio != null) {
                            Pipe pipe = Pipe.this;
                            Timeout timeout = foldedSink$okio.timeout();
                            Timeout timeout2 = pipe.sink().timeout();
                            long timeoutNanos = timeout.timeoutNanos();
                            timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                            if (!timeout.hasDeadline()) {
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                                }
                                try {
                                    foldedSink$okio.close();
                                    if (hasDeadline) {
                                        return;
                                    } else {
                                        return;
                                    }
                                } finally {
                                    timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                    if (timeout2.hasDeadline()) {
                                        timeout.clearDeadline();
                                    }
                                }
                            }
                            long deadlineNanoTime = timeout.deadlineNanoTime();
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                            }
                            try {
                                foldedSink$okio.close();
                            } finally {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.deadlineNanoTime(deadlineNanoTime);
                                }
                            }
                        }
                    }
                }

                @Override // okio.Sink, java.io.Flushable
                public void flush() {
                    Sink foldedSink$okio;
                    boolean hasDeadline;
                    synchronized (Pipe.this.getBuffer$okio()) {
                        if (!(!Pipe.this.getSinkClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        foldedSink$okio = Pipe.this.getFoldedSink$okio();
                        if (foldedSink$okio == null) {
                            if (Pipe.this.getSourceClosed$okio() && Pipe.this.getBuffer$okio().size() > 0) {
                                throw new IOException("source is closed");
                            }
                            foldedSink$okio = null;
                        }
                        C5715y1 c5715y1 = C5715y1.f20665a;
                    }
                    if (foldedSink$okio != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = foldedSink$okio.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                foldedSink$okio.flush();
                                if (hasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            foldedSink$okio.flush();
                        } finally {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                        }
                    }
                }

                @Override // okio.Sink
                @InterfaceC5816d
                public Timeout timeout() {
                    return this.timeout;
                }

                @Override // okio.Sink
                public void write(@InterfaceC5816d Buffer buffer, long j3) {
                    Sink sink;
                    boolean hasDeadline;
                    C5544i0.m22546f(buffer, "source");
                    synchronized (Pipe.this.getBuffer$okio()) {
                        if (!(!Pipe.this.getSinkClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        while (true) {
                            if (j3 <= 0) {
                                sink = null;
                                break;
                            }
                            sink = Pipe.this.getFoldedSink$okio();
                            if (sink != null) {
                                break;
                            }
                            if (Pipe.this.getSourceClosed$okio()) {
                                throw new IOException("source is closed");
                            }
                            long maxBufferSize$okio = Pipe.this.getMaxBufferSize$okio() - Pipe.this.getBuffer$okio().size();
                            if (maxBufferSize$okio == 0) {
                                this.timeout.waitUntilNotified(Pipe.this.getBuffer$okio());
                            } else {
                                long min = Math.min(maxBufferSize$okio, j3);
                                Pipe.this.getBuffer$okio().write(buffer, min);
                                j3 -= min;
                                Buffer buffer$okio = Pipe.this.getBuffer$okio();
                                if (buffer$okio == null) {
                                    throw new C5226e1("null cannot be cast to non-null type java.lang.Object");
                                }
                                buffer$okio.notifyAll();
                            }
                        }
                        C5715y1 c5715y1 = C5715y1.f20665a;
                    }
                    if (sink != null) {
                        Pipe pipe = Pipe.this;
                        Timeout timeout = sink.timeout();
                        Timeout timeout2 = pipe.sink().timeout();
                        long timeoutNanos = timeout.timeoutNanos();
                        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
                        if (!timeout.hasDeadline()) {
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
                            }
                            try {
                                sink.write(buffer, j3);
                                if (hasDeadline) {
                                    return;
                                } else {
                                    return;
                                }
                            } finally {
                                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                                if (timeout2.hasDeadline()) {
                                    timeout.clearDeadline();
                                }
                            }
                        }
                        long deadlineNanoTime = timeout.deadlineNanoTime();
                        if (timeout2.hasDeadline()) {
                            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
                        }
                        try {
                            sink.write(buffer, j3);
                        } finally {
                            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                            if (timeout2.hasDeadline()) {
                                timeout.deadlineNanoTime(deadlineNanoTime);
                            }
                        }
                    }
                }
            };
            this.source = new Source() { // from class: okio.Pipe$source$1
                private final Timeout timeout = new Timeout();

                @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
                public void close() {
                    synchronized (Pipe.this.getBuffer$okio()) {
                        Pipe.this.setSourceClosed$okio(true);
                        Buffer buffer$okio = Pipe.this.getBuffer$okio();
                        if (buffer$okio == null) {
                            throw new C5226e1("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer$okio.notifyAll();
                        C5715y1 c5715y1 = C5715y1.f20665a;
                    }
                }

                @Override // okio.Source
                public long read(@InterfaceC5816d Buffer buffer, long j3) {
                    C5544i0.m22546f(buffer, "sink");
                    synchronized (Pipe.this.getBuffer$okio()) {
                        if (!(!Pipe.this.getSourceClosed$okio())) {
                            throw new IllegalStateException("closed".toString());
                        }
                        while (Pipe.this.getBuffer$okio().size() == 0) {
                            if (Pipe.this.getSinkClosed$okio()) {
                                return -1L;
                            }
                            this.timeout.waitUntilNotified(Pipe.this.getBuffer$okio());
                        }
                        long read = Pipe.this.getBuffer$okio().read(buffer, j3);
                        Buffer buffer$okio = Pipe.this.getBuffer$okio();
                        if (buffer$okio == null) {
                            throw new C5226e1("null cannot be cast to non-null type java.lang.Object");
                        }
                        buffer$okio.notifyAll();
                        return read;
                    }
                }

                @Override // okio.Source
                @InterfaceC5816d
                public Timeout timeout() {
                    return this.timeout;
                }
            };
        } else {
            throw new IllegalArgumentException(("maxBufferSize < 1: " + this.maxBufferSize).toString());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void forward(@InterfaceC5816d Sink sink, InterfaceC5506l<? super Sink, C5715y1> interfaceC5506l) {
        Timeout timeout = sink.timeout();
        Timeout timeout2 = sink().timeout();
        long timeoutNanos = timeout.timeoutNanos();
        timeout.timeout(Timeout.Companion.minTimeout(timeout2.timeoutNanos(), timeout.timeoutNanos()), TimeUnit.NANOSECONDS);
        if (!timeout.hasDeadline()) {
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(timeout2.deadlineNanoTime());
            }
            try {
                interfaceC5506l.invoke(sink);
                return;
            } finally {
                C5535f0.m22474b(1);
                timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
                if (timeout2.hasDeadline()) {
                    timeout.clearDeadline();
                }
                C5535f0.m22471a(1);
            }
        }
        long deadlineNanoTime = timeout.deadlineNanoTime();
        if (timeout2.hasDeadline()) {
            timeout.deadlineNanoTime(Math.min(timeout.deadlineNanoTime(), timeout2.deadlineNanoTime()));
        }
        try {
            interfaceC5506l.invoke(sink);
        } finally {
            C5535f0.m22474b(1);
            timeout.timeout(timeoutNanos, TimeUnit.NANOSECONDS);
            if (timeout2.hasDeadline()) {
                timeout.deadlineNanoTime(deadlineNanoTime);
            }
            C5535f0.m22471a(1);
        }
    }

    @InterfaceC5481e(name = "-deprecated_sink")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to val", replaceWith = @InterfaceC5467o0(expression = "sink", imports = {}))
    @InterfaceC5816d
    /* renamed from: -deprecated_sink, reason: not valid java name */
    public final Sink m26884deprecated_sink() {
        return this.sink;
    }

    @InterfaceC5481e(name = "-deprecated_source")
    @InterfaceC5216c(level = EnumC5220d.ERROR, message = "moved to val", replaceWith = @InterfaceC5467o0(expression = "source", imports = {}))
    @InterfaceC5816d
    /* renamed from: -deprecated_source, reason: not valid java name */
    public final Source m26885deprecated_source() {
        return this.source;
    }

    public final void fold(@InterfaceC5816d Sink sink) throws IOException {
        boolean z;
        Buffer buffer;
        C5544i0.m22546f(sink, "sink");
        while (true) {
            synchronized (this.buffer) {
                if (!(this.foldedSink == null)) {
                    throw new IllegalStateException("sink already folded".toString());
                }
                if (this.buffer.exhausted()) {
                    this.sourceClosed = true;
                    this.foldedSink = sink;
                    return;
                }
                z = this.sinkClosed;
                buffer = new Buffer();
                buffer.write(this.buffer, this.buffer.size());
                Buffer buffer2 = this.buffer;
                if (buffer2 == null) {
                    throw new C5226e1("null cannot be cast to non-null type java.lang.Object");
                }
                buffer2.notifyAll();
                C5715y1 c5715y1 = C5715y1.f20665a;
            }
            try {
                sink.write(buffer, buffer.size());
                if (z) {
                    sink.close();
                } else {
                    sink.flush();
                }
            } catch (Throwable th) {
                synchronized (this.buffer) {
                    this.sourceClosed = true;
                    Buffer buffer3 = this.buffer;
                    if (buffer3 == null) {
                        throw new C5226e1("null cannot be cast to non-null type java.lang.Object");
                    }
                    buffer3.notifyAll();
                    C5715y1 c5715y12 = C5715y1.f20665a;
                    throw th;
                }
            }
        }
    }

    @InterfaceC5816d
    public final Buffer getBuffer$okio() {
        return this.buffer;
    }

    @InterfaceC5817e
    public final Sink getFoldedSink$okio() {
        return this.foldedSink;
    }

    public final long getMaxBufferSize$okio() {
        return this.maxBufferSize;
    }

    public final boolean getSinkClosed$okio() {
        return this.sinkClosed;
    }

    public final boolean getSourceClosed$okio() {
        return this.sourceClosed;
    }

    public final void setFoldedSink$okio(@InterfaceC5817e Sink sink) {
        this.foldedSink = sink;
    }

    public final void setSinkClosed$okio(boolean z) {
        this.sinkClosed = z;
    }

    public final void setSourceClosed$okio(boolean z) {
        this.sourceClosed = z;
    }

    @InterfaceC5481e(name = "sink")
    @InterfaceC5816d
    public final Sink sink() {
        return this.sink;
    }

    @InterfaceC5481e(name = "source")
    @InterfaceC5816d
    public final Source source() {
        return this.source;
    }
}
