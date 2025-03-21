package okio;

import com.tencent.open.SocialConstants;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import okio.internal.BufferKt;
import p286h.C5230f1;
import p286h.InterfaceC5713y;
import p286h.p309q2.InterfaceC5479c;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5556m0;
import p286h.p323z2.C5727d;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: RealBufferedSource.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\u0010\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u0018H\u0016J\u0018\u0010\u0019\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\rH\u0016J\b\u0010\u001e\u001a\u00020\u0001H\u0016J\u0018\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J(\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u00122\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020&H\u0016J\u0010\u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'H\u0016J \u0010$\u001a\u00020\"2\u0006\u0010%\u001a\u00020'2\u0006\u0010 \u001a\u00020\"2\u0006\u0010#\u001a\u00020\"H\u0016J\u0018\u0010$\u001a\u00020\u00122\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010(\u001a\u00020\u00122\u0006\u0010%\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020\u0014H\u0016J\b\u0010+\u001a\u00020'H\u0016J\u0010\u0010+\u001a\u00020'2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010,\u001a\u00020\u0018H\u0016J\u0010\u0010,\u001a\u00020\u00182\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010-\u001a\u00020\u0012H\u0016J\u0010\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020'H\u0016J\u0018\u0010.\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010/\u001a\u00020\u0012H\u0016J\b\u00100\u001a\u00020\"H\u0016J\b\u00101\u001a\u00020\"H\u0016J\b\u00102\u001a\u00020\u0012H\u0016J\b\u00103\u001a\u00020\u0012H\u0016J\b\u00104\u001a\u000205H\u0016J\b\u00106\u001a\u000205H\u0016J\u0010\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:H\u0016J\u0018\u00107\u001a\u0002082\u0006\u0010#\u001a\u00020\u00122\u0006\u00109\u001a\u00020:H\u0016J\b\u0010;\u001a\u000208H\u0016J\u0010\u0010;\u001a\u0002082\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010<\u001a\u00020\"H\u0016J\n\u0010=\u001a\u0004\u0018\u000108H\u0016J\b\u0010>\u001a\u000208H\u0016J\u0010\u0010>\u001a\u0002082\u0006\u0010?\u001a\u00020\u0012H\u0016J\u0010\u0010@\u001a\u00020\r2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010A\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\u0010\u0010B\u001a\u00020\"2\u0006\u0010C\u001a\u00020DH\u0016J\u0010\u0010E\u001a\u00020\u000f2\u0006\u0010#\u001a\u00020\u0012H\u0016J\b\u0010F\u001a\u00020GH\u0016J\b\u0010H\u001a\u000208H\u0016R\u001b\u0010\u0005\u001a\u00020\u00068Ö\u0002X\u0096\u0004¢\u0006\f\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, m23546d2 = {"Lokio/RealBufferedSource;", "Lokio/BufferedSource;", "source", "Lokio/Source;", "(Lokio/Source;)V", "buffer", "Lokio/Buffer;", "buffer$annotations", "()V", "getBuffer", "()Lokio/Buffer;", "bufferField", "closed", "", "close", "", "exhausted", "indexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "indexOfElement", "targetBytes", "inputStream", "Ljava/io/InputStream;", "isOpen", "peek", "rangeEquals", "offset", "bytesOffset", "", "byteCount", "read", "sink", "Ljava/nio/ByteBuffer;", "", "readAll", "Lokio/Sink;", "readByte", "readByteArray", "readByteString", "readDecimalLong", "readFully", "readHexadecimalUnsignedLong", "readInt", "readIntLe", "readLong", "readLongLe", "readShort", "", "readShortLe", "readString", "", "charset", "Ljava/nio/charset/Charset;", "readUtf8", "readUtf8CodePoint", "readUtf8Line", "readUtf8LineStrict", "limit", SocialConstants.TYPE_REQUEST, "require", "select", "options", "Lokio/Options;", "skip", "timeout", "Lokio/Timeout;", "toString", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RealBufferedSource implements BufferedSource {

    @InterfaceC5479c
    @InterfaceC5816d
    public final Buffer bufferField;

    @InterfaceC5479c
    public boolean closed;

    @InterfaceC5479c
    @InterfaceC5816d
    public final Source source;

    public RealBufferedSource(@InterfaceC5816d Source source) {
        C5544i0.m22546f(source, "source");
        this.source = source;
        this.bufferField = new Buffer();
    }

    public static /* synthetic */ void buffer$annotations() {
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @InterfaceC5816d
    public Buffer buffer() {
        return this.bufferField;
    }

    @Override // okio.Source, java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        if (this.closed) {
            return;
        }
        this.closed = true;
        this.source.close();
        this.bufferField.clear();
    }

    @Override // okio.BufferedSource
    public boolean exhausted() {
        if (!this.closed) {
            return this.bufferField.exhausted() && this.source.read(this.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource, okio.BufferedSink
    @InterfaceC5816d
    public Buffer getBuffer() {
        return this.bufferField;
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2) {
        return indexOf(b2, 0L, C5556m0.f20396b);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "targetBytes");
        return indexOfElement(byteString, 0L);
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public InputStream inputStream() {
        return new InputStream() { // from class: okio.RealBufferedSource$inputStream$1
            @Override // java.io.InputStream
            public int available() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                return (int) Math.min(realBufferedSource.bufferField.size(), Integer.MAX_VALUE);
            }

            @Override // java.io.InputStream, java.io.Closeable, java.lang.AutoCloseable
            public void close() {
                RealBufferedSource.this.close();
            }

            @Override // java.io.InputStream
            public int read() {
                RealBufferedSource realBufferedSource = RealBufferedSource.this;
                if (realBufferedSource.closed) {
                    throw new IOException("closed");
                }
                if (realBufferedSource.bufferField.size() == 0) {
                    RealBufferedSource realBufferedSource2 = RealBufferedSource.this;
                    if (realBufferedSource2.source.read(realBufferedSource2.bufferField, 8192) == -1) {
                        return -1;
                    }
                }
                return RealBufferedSource.this.bufferField.readByte() & C5230f1.f20085c;
            }

            @InterfaceC5816d
            public String toString() {
                return RealBufferedSource.this + ".inputStream()";
            }

            @Override // java.io.InputStream
            public int read(@InterfaceC5816d byte[] bArr, int i2, int i3) {
                C5544i0.m22546f(bArr, "data");
                if (!RealBufferedSource.this.closed) {
                    Util.checkOffsetAndCount(bArr.length, i2, i3);
                    if (RealBufferedSource.this.bufferField.size() == 0) {
                        RealBufferedSource realBufferedSource = RealBufferedSource.this;
                        if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                            return -1;
                        }
                    }
                    return RealBufferedSource.this.bufferField.read(bArr, i2, i3);
                }
                throw new IOException("closed");
            }
        };
    }

    @Override // java.nio.channels.Channel
    public boolean isOpen() {
        return !this.closed;
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public BufferedSource peek() {
        return Okio.buffer(new PeekSource(this));
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, @InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "bytes");
        return rangeEquals(j2, byteString, 0, byteString.size());
    }

    @Override // okio.BufferedSource
    public int read(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "sink");
        return read(bArr, 0, bArr.length);
    }

    @Override // okio.BufferedSource
    public long readAll(@InterfaceC5816d Sink sink) {
        C5544i0.m22546f(sink, "sink");
        long j2 = 0;
        while (this.source.read(this.bufferField, 8192) != -1) {
            long completeSegmentByteCount = this.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j2 += completeSegmentByteCount;
                sink.write(this.bufferField, completeSegmentByteCount);
            }
        }
        if (this.bufferField.size() <= 0) {
            return j2;
        }
        long size = j2 + this.bufferField.size();
        Buffer buffer = this.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    @Override // okio.BufferedSource
    public byte readByte() {
        require(1L);
        return this.bufferField.readByte();
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public byte[] readByteArray() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteArray();
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public ByteString readByteString() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readByteString();
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x002c, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x002f, code lost:
    
        r0 = new java.lang.StringBuilder();
        r0.append("Expected leading [0-9] or '-' character but was 0x");
        r1 = p286h.p323z2.C5727d.m23807a(16);
        r1 = p286h.p323z2.C5727d.m23807a(r1);
        r1 = java.lang.Integer.toString(r8, r1);
        p286h.p309q2.p311t.C5544i0.m22521a((java.lang.Object) r1, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r0.append(r1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        throw new java.lang.NumberFormatException(r0.toString());
     */
    @Override // okio.BufferedSource
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public long readDecimalLong() {
        /*
            r10 = this;
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        L8:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L59
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L20
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2a
        L20:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L2c
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L2a
            goto L2c
        L2a:
            r4 = r6
            goto L8
        L2c:
            if (r9 == 0) goto L2f
            goto L59
        L2f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9] or '-' character but was 0x"
            r0.append(r1)
            r1 = 16
            int r1 = p286h.p323z2.C5725c.m23648a(r1)
            int r1 = p286h.p323z2.C5725c.m23648a(r1)
            java.lang.String r1 = java.lang.Integer.toString(r8, r1)
            java.lang.String r2 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            p286h.p309q2.p311t.C5544i0.m22521a(r1, r2)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.NumberFormatException r1 = new java.lang.NumberFormatException
            r1.<init>(r0)
            throw r1
        L59:
            okio.Buffer r0 = r10.bufferField
            long r0 = r0.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.RealBufferedSource.readDecimalLong():long");
    }

    @Override // okio.BufferedSource
    public void readFully(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "sink");
        try {
            require(bArr.length);
            this.bufferField.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (this.bufferField.size() > 0) {
                Buffer buffer = this.bufferField;
                int read = buffer.read(bArr, i2, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i2 += read;
            }
            throw e2;
        }
    }

    @Override // okio.BufferedSource
    public long readHexadecimalUnsignedLong() {
        byte b2;
        int m23807a;
        int m23807a2;
        require(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!request(i3)) {
                break;
            }
            b2 = this.bufferField.getByte(i2);
            if ((b2 < ((byte) 48) || b2 > ((byte) 57)) && ((b2 < ((byte) 97) || b2 > ((byte) 102)) && (b2 < ((byte) 65) || b2 > ((byte) 70)))) {
                break;
            }
            i2 = i3;
        }
        if (i2 == 0) {
            StringBuilder sb = new StringBuilder();
            sb.append("Expected leading [0-9a-fA-F] character but was 0x");
            m23807a = C5727d.m23807a(16);
            m23807a2 = C5727d.m23807a(m23807a);
            String num = Integer.toString(b2, m23807a2);
            C5544i0.m22521a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return this.bufferField.readHexadecimalUnsignedLong();
    }

    @Override // okio.BufferedSource
    public int readInt() {
        require(4L);
        return this.bufferField.readInt();
    }

    @Override // okio.BufferedSource
    public int readIntLe() {
        require(4L);
        return this.bufferField.readIntLe();
    }

    @Override // okio.BufferedSource
    public long readLong() {
        require(8L);
        return this.bufferField.readLong();
    }

    @Override // okio.BufferedSource
    public long readLongLe() {
        require(8L);
        return this.bufferField.readLongLe();
    }

    @Override // okio.BufferedSource
    public short readShort() {
        require(2L);
        return this.bufferField.readShort();
    }

    @Override // okio.BufferedSource
    public short readShortLe() {
        require(2L);
        return this.bufferField.readShortLe();
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public String readString(long j2, @InterfaceC5816d Charset charset) {
        C5544i0.m22546f(charset, "charset");
        require(j2);
        return this.bufferField.readString(j2, charset);
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public String readUtf8() {
        this.bufferField.writeAll(this.source);
        return this.bufferField.readUtf8();
    }

    @Override // okio.BufferedSource
    public int readUtf8CodePoint() {
        require(1L);
        byte b2 = this.bufferField.getByte(0L);
        if ((b2 & 224) == 192) {
            require(2L);
        } else if ((b2 & 240) == 224) {
            require(3L);
        } else if ((b2 & 248) == 240) {
            require(4L);
        }
        return this.bufferField.readUtf8CodePoint();
    }

    @Override // okio.BufferedSource
    @InterfaceC5817e
    public String readUtf8Line() {
        long indexOf = indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this.bufferField, indexOf);
        }
        if (this.bufferField.size() != 0) {
            return readUtf8(this.bufferField.size());
        }
        return null;
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public String readUtf8LineStrict() {
        return readUtf8LineStrict(C5556m0.f20396b);
    }

    @Override // okio.BufferedSource
    public boolean request(long j2) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (this.bufferField.size() < j2) {
            if (this.source.read(this.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    @Override // okio.BufferedSource
    public void require(long j2) {
        if (!request(j2)) {
            throw new EOFException();
        }
    }

    @Override // okio.BufferedSource
    public int select(@InterfaceC5816d Options options) {
        C5544i0.m22546f(options, "options");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int selectPrefix = BufferKt.selectPrefix(this.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix == -1) {
                    return -1;
                }
                this.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                return selectPrefix;
            }
        } while (this.source.read(this.bufferField, 8192) != -1);
        return -1;
    }

    @Override // okio.BufferedSource
    public void skip(long j2) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, this.bufferField.size());
            this.bufferField.skip(min);
            j2 -= min;
        }
    }

    @Override // okio.Source
    @InterfaceC5816d
    public Timeout timeout() {
        return this.source.timeout();
    }

    @InterfaceC5816d
    public String toString() {
        return "buffer(" + this.source + ')';
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2) {
        return indexOf(b2, j2, C5556m0.f20396b);
    }

    @Override // okio.BufferedSource
    public long indexOfElement(@InterfaceC5816d ByteString byteString, long j2) {
        C5544i0.m22546f(byteString, "targetBytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOfElement = this.bufferField.indexOfElement(byteString, j2);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
    }

    @Override // okio.Source
    public long read(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(true ^ this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1L;
        }
        return this.bufferField.read(buffer, Math.min(j2, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public String readUtf8LineStrict(long j2) {
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = j2 == C5556m0.f20396b ? Long.MAX_VALUE : j2 + 1;
        byte b2 = (byte) 10;
        long indexOf = indexOf(b2, 0L, j3);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(this.bufferField, indexOf);
        }
        if (j3 < C5556m0.f20396b && request(j3) && this.bufferField.getByte(j3 - 1) == ((byte) 13) && request(1 + j3) && this.bufferField.getByte(j3) == b2) {
            return BufferKt.readUtf8Line(this.bufferField, j3);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = this.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(this.bufferField.size(), j2) + " content=" + buffer.readByteString().hex() + "…");
    }

    @Override // okio.BufferedSource
    public long indexOf(@InterfaceC5816d ByteString byteString) {
        C5544i0.m22546f(byteString, "bytes");
        return indexOf(byteString, 0L);
    }

    @Override // okio.BufferedSource
    public boolean rangeEquals(long j2, @InterfaceC5816d ByteString byteString, int i2, int i3) {
        C5544i0.m22546f(byteString, "bytes");
        if (!this.closed) {
            if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
                return false;
            }
            for (int i4 = 0; i4 < i3; i4++) {
                long j3 = i4 + j2;
                if (!request(1 + j3) || this.bufferField.getByte(j3) != byteString.getByte(i2 + i4)) {
                    return false;
                }
            }
            return true;
        }
        throw new IllegalStateException("closed".toString());
    }

    @Override // okio.BufferedSource
    public long indexOf(byte b2, long j2, long j3) {
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        while (j2 < j3) {
            long indexOf = this.bufferField.indexOf(b2, j2, j3);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.size();
            if (size >= j3 || this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
        return -1L;
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public String readString(@InterfaceC5816d Charset charset) {
        C5544i0.m22546f(charset, "charset");
        this.bufferField.writeAll(this.source);
        return this.bufferField.readString(charset);
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public byte[] readByteArray(long j2) {
        require(j2);
        return this.bufferField.readByteArray(j2);
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public ByteString readByteString(long j2) {
        require(j2);
        return this.bufferField.readByteString(j2);
    }

    @Override // okio.BufferedSource
    @InterfaceC5816d
    public String readUtf8(long j2) {
        require(j2);
        return this.bufferField.readUtf8(j2);
    }

    @Override // okio.BufferedSource
    public void readFully(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "sink");
        try {
            require(j2);
            this.bufferField.readFully(buffer, j2);
        } catch (EOFException e2) {
            buffer.writeAll(this.bufferField);
            throw e2;
        }
    }

    @Override // okio.BufferedSource
    public int read(@InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(bArr, "sink");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(bArr, i2, (int) Math.min(j2, this.bufferField.size()));
    }

    @Override // okio.BufferedSource
    public long indexOf(@InterfaceC5816d ByteString byteString, long j2) {
        C5544i0.m22546f(byteString, "bytes");
        if (!(!this.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOf = this.bufferField.indexOf(byteString, j2);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = this.bufferField.size();
            if (this.source.read(this.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (size - byteString.size()) + 1);
        }
    }

    @Override // java.nio.channels.ReadableByteChannel
    public int read(@InterfaceC5816d ByteBuffer byteBuffer) {
        C5544i0.m22546f(byteBuffer, "sink");
        if (this.bufferField.size() == 0 && this.source.read(this.bufferField, 8192) == -1) {
            return -1;
        }
        return this.bufferField.read(byteBuffer);
    }
}
