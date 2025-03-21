package okio.internal;

import com.umeng.analytics.pro.C3351bh;
import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSink;
import okio.ByteString;
import okio.RealBufferedSink;
import okio.Sink;
import okio.Source;
import okio.Timeout;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: RealBufferedSink.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0015\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0005\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0007\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\t\u001a\u00020\n*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\rH\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0080\b\u001a\u001d\u0010\u000b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\f\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u0016\u001a\u00020\u0012*\u00020\u00022\u0006\u0010\f\u001a\u00020\u0015H\u0080\b\u001a\u0015\u0010\u0017\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u0019\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001b\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010\u001c\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001d\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010\u001f\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u0012H\u0080\b\u001a\u0015\u0010!\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010#\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\"\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\nH\u0080\b\u001a%\u0010$\u001a\u00020\u0004*\u00020\u00022\u0006\u0010%\u001a\u00020\n2\u0006\u0010&\u001a\u00020\u000f2\u0006\u0010'\u001a\u00020\u000fH\u0080\b\u001a\u0015\u0010(\u001a\u00020\u0004*\u00020\u00022\u0006\u0010)\u001a\u00020\u000fH\u0080\b¨\u0006*"}, m23546d2 = {"commonClose", "", "Lokio/RealBufferedSink;", "commonEmit", "Lokio/BufferedSink;", "commonEmitCompleteSegments", "commonFlush", "commonTimeout", "Lokio/Timeout;", "commonToString", "", "commonWrite", "source", "", "offset", "", "byteCount", "Lokio/Buffer;", "", "byteString", "Lokio/ByteString;", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "b", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", C3351bh.f11581aF, "commonWriteIntLe", "commonWriteLong", "commonWriteLongLe", "commonWriteShort", C3351bh.f11580aE, "commonWriteShortLe", "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RealBufferedSinkKt {
    public static final void commonClose(@InterfaceC5816d RealBufferedSink realBufferedSink) {
        C5544i0.m22546f(realBufferedSink, "$this$commonClose");
        if (realBufferedSink.closed) {
            return;
        }
        Throwable th = null;
        try {
            if (realBufferedSink.bufferField.size() > 0) {
                realBufferedSink.sink.write(realBufferedSink.bufferField, realBufferedSink.bufferField.size());
            }
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            realBufferedSink.sink.close();
        } catch (Throwable th3) {
            if (th == null) {
                th = th3;
            }
        }
        realBufferedSink.closed = true;
        if (th != null) {
            throw th;
        }
    }

    @InterfaceC5816d
    public static final BufferedSink commonEmit(@InterfaceC5816d RealBufferedSink realBufferedSink) {
        C5544i0.m22546f(realBufferedSink, "$this$commonEmit");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long size = realBufferedSink.bufferField.size();
        if (size > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, size);
        }
        return realBufferedSink;
    }

    @InterfaceC5816d
    public static final BufferedSink commonEmitCompleteSegments(@InterfaceC5816d RealBufferedSink realBufferedSink) {
        C5544i0.m22546f(realBufferedSink, "$this$commonEmitCompleteSegments");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        long completeSegmentByteCount = realBufferedSink.bufferField.completeSegmentByteCount();
        if (completeSegmentByteCount > 0) {
            realBufferedSink.sink.write(realBufferedSink.bufferField, completeSegmentByteCount);
        }
        return realBufferedSink;
    }

    public static final void commonFlush(@InterfaceC5816d RealBufferedSink realBufferedSink) {
        C5544i0.m22546f(realBufferedSink, "$this$commonFlush");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSink.bufferField.size() > 0) {
            Sink sink = realBufferedSink.sink;
            Buffer buffer = realBufferedSink.bufferField;
            sink.write(buffer, buffer.size());
        }
        realBufferedSink.sink.flush();
    }

    @InterfaceC5816d
    public static final Timeout commonTimeout(@InterfaceC5816d RealBufferedSink realBufferedSink) {
        C5544i0.m22546f(realBufferedSink, "$this$commonTimeout");
        return realBufferedSink.sink.timeout();
    }

    @InterfaceC5816d
    public static final String commonToString(@InterfaceC5816d RealBufferedSink realBufferedSink) {
        C5544i0.m22546f(realBufferedSink, "$this$commonToString");
        return "buffer(" + realBufferedSink.sink + ')';
    }

    public static final void commonWrite(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWrite");
        C5544i0.m22546f(buffer, "source");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.write(buffer, j2);
        realBufferedSink.emitCompleteSegments();
    }

    public static final long commonWriteAll(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d Source source) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteAll");
        C5544i0.m22546f(source, "source");
        long j2 = 0;
        while (true) {
            long read = source.read(realBufferedSink.bufferField, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
            realBufferedSink.emitCompleteSegments();
        }
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteByte(@InterfaceC5816d RealBufferedSink realBufferedSink, int i2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteByte");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeByte(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteDecimalLong(@InterfaceC5816d RealBufferedSink realBufferedSink, long j2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteDecimalLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeDecimalLong(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteHexadecimalUnsignedLong(@InterfaceC5816d RealBufferedSink realBufferedSink, long j2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteHexadecimalUnsignedLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeHexadecimalUnsignedLong(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteInt(@InterfaceC5816d RealBufferedSink realBufferedSink, int i2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteInt");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeInt(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteIntLe(@InterfaceC5816d RealBufferedSink realBufferedSink, int i2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteIntLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeIntLe(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteLong(@InterfaceC5816d RealBufferedSink realBufferedSink, long j2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteLong");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLong(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteLongLe(@InterfaceC5816d RealBufferedSink realBufferedSink, long j2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteLongLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeLongLe(j2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteShort(@InterfaceC5816d RealBufferedSink realBufferedSink, int i2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteShort");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShort(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteShortLe(@InterfaceC5816d RealBufferedSink realBufferedSink, int i2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteShortLe");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeShortLe(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteUtf8(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d String str) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteUtf8");
        C5544i0.m22546f(str, "string");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8(str);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteUtf8CodePoint(@InterfaceC5816d RealBufferedSink realBufferedSink, int i2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteUtf8CodePoint");
        if (!(!realBufferedSink.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        realBufferedSink.bufferField.writeUtf8CodePoint(i2);
        return realBufferedSink.emitCompleteSegments();
    }

    @InterfaceC5816d
    public static final BufferedSink commonWrite(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWrite");
        C5544i0.m22546f(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @InterfaceC5816d
    public static final BufferedSink commonWriteUtf8(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d String str, int i2, int i3) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWriteUtf8");
        C5544i0.m22546f(str, "string");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.writeUtf8(str, i2, i3);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @InterfaceC5816d
    public static final BufferedSink commonWrite(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d ByteString byteString, int i2, int i3) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWrite");
        C5544i0.m22546f(byteString, "byteString");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(byteString, i2, i3);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @InterfaceC5816d
    public static final BufferedSink commonWrite(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWrite");
        C5544i0.m22546f(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @InterfaceC5816d
    public static final BufferedSink commonWrite(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWrite");
        C5544i0.m22546f(bArr, "source");
        if (!realBufferedSink.closed) {
            realBufferedSink.bufferField.write(bArr, i2, i3);
            return realBufferedSink.emitCompleteSegments();
        }
        throw new IllegalStateException("closed".toString());
    }

    @InterfaceC5816d
    public static final BufferedSink commonWrite(@InterfaceC5816d RealBufferedSink realBufferedSink, @InterfaceC5816d Source source, long j2) {
        C5544i0.m22546f(realBufferedSink, "$this$commonWrite");
        C5544i0.m22546f(source, "source");
        while (j2 > 0) {
            long read = source.read(realBufferedSink.bufferField, j2);
            if (read != -1) {
                j2 -= read;
                realBufferedSink.emitCompleteSegments();
            } else {
                throw new EOFException();
            }
        }
        return realBufferedSink;
    }
}
