package okio;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: InflaterSource.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0006\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0007J\b\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0016J\u0006\u0010\u0013\u001a\u00020\u000bJ\b\u0010\u0014\u001a\u00020\rH\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0017"}, m23546d2 = {"Lokio/InflaterSource;", "Lokio/Source;", "source", "inflater", "Ljava/util/zip/Inflater;", "(Lokio/Source;Ljava/util/zip/Inflater;)V", "Lokio/BufferedSource;", "(Lokio/BufferedSource;Ljava/util/zip/Inflater;)V", "bufferBytesHeldByInflater", "", "closed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "refill", "releaseInflatedBytes", "timeout", "Lokio/Timeout;", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class InflaterSource implements Source {
    private int bufferBytesHeldByInflater;
    private boolean closed;
    private final Inflater inflater;
    private final BufferedSource source;

    public InflaterSource(@InterfaceC5816d BufferedSource bufferedSource, @InterfaceC5816d Inflater inflater) {
        C5544i0.m22546f(bufferedSource, "source");
        C5544i0.m22546f(inflater, "inflater");
        this.source = bufferedSource;
        this.inflater = inflater;
    }

    private final void releaseInflatedBytes() {
        int i2 = this.bufferBytesHeldByInflater;
        if (i2 == 0) {
            return;
        }
        int remaining = i2 - this.inflater.getRemaining();
        this.bufferBytesHeldByInflater -= remaining;
        this.source.skip(remaining);
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() throws IOException {
        if (this.closed) {
            return;
        }
        this.inflater.end();
        this.closed = true;
        this.source.close();
    }

    @Override // okio.Source
    public long read(@InterfaceC5816d Buffer buffer, long j2) throws IOException {
        boolean refill;
        C5544i0.m22546f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j2 == 0) {
            return 0L;
        }
        do {
            refill = refill();
            try {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                int inflate = this.inflater.inflate(writableSegment$okio.data, writableSegment$okio.limit, (int) Math.min(j2, 8192 - writableSegment$okio.limit));
                if (inflate > 0) {
                    writableSegment$okio.limit += inflate;
                    long j3 = inflate;
                    buffer.setSize$okio(buffer.size() + j3);
                    return j3;
                }
                if (!this.inflater.finished() && !this.inflater.needsDictionary()) {
                }
                releaseInflatedBytes();
                if (writableSegment$okio.pos != writableSegment$okio.limit) {
                    return -1L;
                }
                buffer.head = writableSegment$okio.pop();
                SegmentPool.INSTANCE.recycle(writableSegment$okio);
                return -1L;
            } catch (DataFormatException e2) {
                throw new IOException(e2);
            }
        } while (!refill);
        throw new EOFException("source exhausted prematurely");
    }

    public final boolean refill() throws IOException {
        if (!this.inflater.needsInput()) {
            return false;
        }
        releaseInflatedBytes();
        if (!(this.inflater.getRemaining() == 0)) {
            throw new IllegalStateException("?".toString());
        }
        if (this.source.exhausted()) {
            return true;
        }
        Segment segment = this.source.getBuffer().head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        int i2 = segment.limit;
        int i3 = segment.pos;
        this.bufferBytesHeldByInflater = i2 - i3;
        this.inflater.setInput(segment.data, i3, this.bufferBytesHeldByInflater);
        return false;
    }

    @Override // okio.Source
    @InterfaceC5816d
    public Timeout timeout() {
        return this.source.timeout();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InflaterSource(@InterfaceC5816d Source source, @InterfaceC5816d Inflater inflater) {
        this(Okio.buffer(source), inflater);
        C5544i0.m22546f(source, "source");
        C5544i0.m22546f(inflater, "inflater");
    }
}
