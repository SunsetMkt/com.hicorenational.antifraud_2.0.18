package okio;

import java.io.OutputStream;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: JvmOkio.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010\u0007\u001a\u00020\bH\u0016J\b\u0010\t\u001a\u00020\bH\u0016J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\b\u0010\n\u001a\u00020\u000bH\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, m23546d2 = {"Lokio/OutputStreamSink;", "Lokio/Sink;", "out", "Ljava/io/OutputStream;", "timeout", "Lokio/Timeout;", "(Ljava/io/OutputStream;Lokio/Timeout;)V", "close", "", "flush", "toString", "", "write", "source", "Lokio/Buffer;", "byteCount", "", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
final class OutputStreamSink implements Sink {
    private final OutputStream out;
    private final Timeout timeout;

    public OutputStreamSink(@InterfaceC5816d OutputStream outputStream, @InterfaceC5816d Timeout timeout) {
        C5544i0.m22546f(outputStream, "out");
        C5544i0.m22546f(timeout, "timeout");
        this.out = outputStream;
        this.timeout = timeout;
    }

    @Override // okio.Sink, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        this.out.close();
    }

    @Override // okio.Sink, java.io.Flushable
    public void flush() {
        this.out.flush();
    }

    @Override // okio.Sink
    @InterfaceC5816d
    public Timeout timeout() {
        return this.timeout;
    }

    @InterfaceC5816d
    public String toString() {
        return "sink(" + this.out + ')';
    }

    @Override // okio.Sink
    public void write(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "source");
        Util.checkOffsetAndCount(buffer.size(), 0L, j2);
        while (j2 > 0) {
            this.timeout.throwIfReached();
            Segment segment = buffer.head;
            if (segment == null) {
                C5544i0.m22545f();
            }
            int min = (int) Math.min(j2, segment.limit - segment.pos);
            this.out.write(segment.data, segment.pos, min);
            segment.pos += min;
            long j3 = min;
            j2 -= j3;
            buffer.setSize$okio(buffer.size() - j3);
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }
}
