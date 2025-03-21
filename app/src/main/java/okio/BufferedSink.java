package okio;

import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;
import java.nio.charset.Charset;
import p286h.EnumC5220d;
import p286h.InterfaceC5216c;
import p286h.InterfaceC5467o0;
import p286h.InterfaceC5713y;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: BufferedSink.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u00012\u00020\u0002J\b\u0010\u0003\u001a\u00020\u0004H'J\b\u0010\u0007\u001a\u00020\u0000H&J\b\u0010\b\u001a\u00020\u0000H&J\b\u0010\t\u001a\u00020\nH&J\b\u0010\u000b\u001a\u00020\fH&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000fH&J \u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0010\u0010\r\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0014H&J \u0010\r\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0011H&J\u0018\u0010\r\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u0016H&J\u0010\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000e\u001a\u00020\u0015H&J\u0010\u0010\u0018\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0011H&J\u0010\u0010\u001a\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010\u001c\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010\u001d\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011H&J\u0010\u0010\u001f\u001a\u00020\u00002\u0006\u0010\u001e\u001a\u00020\u0011H&J\u0010\u0010 \u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010!\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0016H&J\u0010\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0011H&J\u0010\u0010$\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0011H&J\u0018\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)H&J(\u0010%\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)H&J\u0010\u0010,\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'H&J \u0010,\u001a\u00020\u00002\u0006\u0010&\u001a\u00020'2\u0006\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u0011H&J\u0010\u0010-\u001a\u00020\u00002\u0006\u0010.\u001a\u00020\u0011H&R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006/"}, m23546d2 = {"Lokio/BufferedSink;", "Lokio/Sink;", "Ljava/nio/channels/WritableByteChannel;", "buffer", "Lokio/Buffer;", "getBuffer", "()Lokio/Buffer;", "emit", "emitCompleteSegments", "flush", "", "outputStream", "Ljava/io/OutputStream;", "write", "source", "", "offset", "", "byteCount", "byteString", "Lokio/ByteString;", "Lokio/Source;", "", "writeAll", "writeByte", "b", "writeDecimalLong", "v", "writeHexadecimalUnsignedLong", "writeInt", C3351bh.f11581aF, "writeIntLe", "writeLong", "writeLongLe", "writeShort", C3351bh.f11580aE, "writeShortLe", "writeString", "string", "", "charset", "Ljava/nio/charset/Charset;", "beginIndex", "endIndex", "writeUtf8", "writeUtf8CodePoint", "codePoint", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public interface BufferedSink extends Sink, WritableByteChannel {
    @InterfaceC5216c(level = EnumC5220d.WARNING, message = "moved to val: use getBuffer() instead", replaceWith = @InterfaceC5467o0(expression = "buffer", imports = {}))
    @InterfaceC5816d
    Buffer buffer();

    @InterfaceC5816d
    BufferedSink emit() throws IOException;

    @InterfaceC5816d
    BufferedSink emitCompleteSegments() throws IOException;

    @Override // okio.Sink, java.io.Flushable
    void flush() throws IOException;

    @InterfaceC5816d
    Buffer getBuffer();

    @InterfaceC5816d
    OutputStream outputStream();

    @InterfaceC5816d
    BufferedSink write(@InterfaceC5816d ByteString byteString) throws IOException;

    @InterfaceC5816d
    BufferedSink write(@InterfaceC5816d ByteString byteString, int i2, int i3) throws IOException;

    @InterfaceC5816d
    BufferedSink write(@InterfaceC5816d Source source, long j2) throws IOException;

    @InterfaceC5816d
    BufferedSink write(@InterfaceC5816d byte[] bArr) throws IOException;

    @InterfaceC5816d
    BufferedSink write(@InterfaceC5816d byte[] bArr, int i2, int i3) throws IOException;

    long writeAll(@InterfaceC5816d Source source) throws IOException;

    @InterfaceC5816d
    BufferedSink writeByte(int i2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeDecimalLong(long j2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeHexadecimalUnsignedLong(long j2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeInt(int i2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeIntLe(int i2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeLong(long j2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeLongLe(long j2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeShort(int i2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeShortLe(int i2) throws IOException;

    @InterfaceC5816d
    BufferedSink writeString(@InterfaceC5816d String str, int i2, int i3, @InterfaceC5816d Charset charset) throws IOException;

    @InterfaceC5816d
    BufferedSink writeString(@InterfaceC5816d String str, @InterfaceC5816d Charset charset) throws IOException;

    @InterfaceC5816d
    BufferedSink writeUtf8(@InterfaceC5816d String str) throws IOException;

    @InterfaceC5816d
    BufferedSink writeUtf8(@InterfaceC5816d String str, int i2, int i3) throws IOException;

    @InterfaceC5816d
    BufferedSink writeUtf8CodePoint(int i2) throws IOException;
}
