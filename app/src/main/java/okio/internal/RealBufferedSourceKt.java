package okio.internal;

import java.io.EOFException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Options;
import okio.PeekSource;
import okio.RealBufferedSource;
import okio.Sink;
import okio.Timeout;
import okio.Util;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5556m0;
import p286h.p323z2.C5727d;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: RealBufferedSource.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b¨\u00068"}, m23546d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RealBufferedSourceKt {
    public static final void commonClose(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonClose");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonExhausted");
        if (!realBufferedSource.closed) {
            return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(@InterfaceC5816d RealBufferedSource realBufferedSource, byte b2, long j2, long j3) {
        C5544i0.m22546f(realBufferedSource, "$this$commonIndexOf");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        while (j2 < j3) {
            long indexOf = realBufferedSource.bufferField.indexOf(b2, j2, j3);
            if (indexOf == -1) {
                long size = realBufferedSource.bufferField.size();
                if (size >= j3 || realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                    break;
                }
                j2 = Math.max(j2, size);
            } else {
                return indexOf;
            }
        }
        return -1L;
    }

    public static final long commonIndexOfElement(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d ByteString byteString, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonIndexOfElement");
        C5544i0.m22546f(byteString, "targetBytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOfElement = realBufferedSource.bufferField.indexOfElement(byteString, j2);
            if (indexOfElement != -1) {
                return indexOfElement;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, size);
        }
    }

    @InterfaceC5816d
    public static final BufferedSource commonPeek(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonPeek");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2, @InterfaceC5816d ByteString byteString, int i2, int i3) {
        C5544i0.m22546f(realBufferedSource, "$this$commonRangeEquals");
        C5544i0.m22546f(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (j2 < 0 || i2 < 0 || i3 < 0 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            long j3 = i4 + j2;
            if (!realBufferedSource.request(1 + j3) || realBufferedSource.bufferField.getByte(j3) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final long commonRead(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonRead");
        C5544i0.m22546f(buffer, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(true ^ realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1L;
        }
        return realBufferedSource.bufferField.read(buffer, Math.min(j2, realBufferedSource.bufferField.size()));
    }

    public static final long commonReadAll(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d Sink sink) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadAll");
        C5544i0.m22546f(sink, "sink");
        long j2 = 0;
        while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1) {
            long completeSegmentByteCount = realBufferedSource.bufferField.completeSegmentByteCount();
            if (completeSegmentByteCount > 0) {
                j2 += completeSegmentByteCount;
                sink.write(realBufferedSource.bufferField, completeSegmentByteCount);
            }
        }
        if (realBufferedSource.bufferField.size() <= 0) {
            return j2;
        }
        long size = j2 + realBufferedSource.bufferField.size();
        Buffer buffer = realBufferedSource.bufferField;
        sink.write(buffer, buffer.size());
        return size;
    }

    public static final byte commonReadByte(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadByte");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    @InterfaceC5816d
    public static final byte[] commonReadByteArray(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readByteArray(j2);
    }

    @InterfaceC5816d
    public static final ByteString commonReadByteString(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readByteString(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r10 = new java.lang.StringBuilder();
        r10.append("Expected leading [0-9] or '-' character but was 0x");
        r0 = p286h.p323z2.C5727d.m23807a(16);
        r0 = p286h.p323z2.C5727d.m23807a(r0);
        r0 = java.lang.Integer.toString(r8, r0);
        p286h.p309q2.p311t.C5544i0.m22521a((java.lang.Object) r0, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r10.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        throw new java.lang.NumberFormatException(r10.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@p324i.p336c.p337a.InterfaceC5816d okio.RealBufferedSource r10) {
        /*
            java.lang.String r0 = "$this$commonReadDecimalLong"
            p286h.p309q2.p311t.C5544i0.m22546f(r10, r0)
            r0 = 1
            r10.require(r0)
            r2 = 0
            r4 = r2
        Ld:
            long r6 = r4 + r0
            boolean r8 = r10.request(r6)
            if (r8 == 0) goto L5e
            okio.Buffer r8 = r10.bufferField
            byte r8 = r8.getByte(r4)
            r9 = 48
            byte r9 = (byte) r9
            if (r8 < r9) goto L25
            r9 = 57
            byte r9 = (byte) r9
            if (r8 <= r9) goto L2f
        L25:
            int r9 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r9 != 0) goto L31
            r4 = 45
            byte r4 = (byte) r4
            if (r8 == r4) goto L2f
            goto L31
        L2f:
            r4 = r6
            goto Ld
        L31:
            if (r9 == 0) goto L34
            goto L5e
        L34:
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r0 = "Expected leading [0-9] or '-' character but was 0x"
            r10.append(r0)
            r0 = 16
            int r0 = p286h.p323z2.C5725c.m23648a(r0)
            int r0 = p286h.p323z2.C5725c.m23648a(r0)
            java.lang.String r0 = java.lang.Integer.toString(r8, r0)
            java.lang.String r1 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            p286h.p309q2.p311t.C5544i0.m22521a(r0, r1)
            r10.append(r0)
            java.lang.String r10 = r10.toString()
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            r0.<init>(r10)
            throw r0
        L5e:
            okio.Buffer r10 = r10.bufferField
            long r0 = r10.readDecimalLong()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.RealBufferedSourceKt.commonReadDecimalLong(okio.RealBufferedSource):long");
    }

    public static final void commonReadFully(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadFully");
        C5544i0.m22546f(bArr, "sink");
        try {
            realBufferedSource.require(bArr.length);
            realBufferedSource.bufferField.readFully(bArr);
        } catch (EOFException e2) {
            int i2 = 0;
            while (realBufferedSource.bufferField.size() > 0) {
                Buffer buffer = realBufferedSource.bufferField;
                int read = buffer.read(bArr, i2, (int) buffer.size());
                if (read == -1) {
                    throw new AssertionError();
                }
                i2 += read;
            }
            throw e2;
        }
    }

    public static final long commonReadHexadecimalUnsignedLong(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        byte b2;
        int m23807a;
        int m23807a2;
        C5544i0.m22546f(realBufferedSource, "$this$commonReadHexadecimalUnsignedLong");
        realBufferedSource.require(1L);
        int i2 = 0;
        while (true) {
            int i3 = i2 + 1;
            if (!realBufferedSource.request(i3)) {
                break;
            }
            b2 = realBufferedSource.bufferField.getByte(i2);
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
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadInt");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadIntLe");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadLong");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadLongLe");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadShort");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadShortLe");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    @InterfaceC5816d
    public static final String commonReadUtf8(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readUtf8(j2);
    }

    public static final int commonReadUtf8CodePoint(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadUtf8CodePoint");
        realBufferedSource.require(1L);
        byte b2 = realBufferedSource.bufferField.getByte(0L);
        if ((b2 & 224) == 192) {
            realBufferedSource.require(2L);
        } else if ((b2 & 240) == 224) {
            realBufferedSource.require(3L);
        } else if ((b2 & 248) == 240) {
            realBufferedSource.require(4L);
        }
        return realBufferedSource.bufferField.readUtf8CodePoint();
    }

    @InterfaceC5817e
    public static final String commonReadUtf8Line(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadUtf8Line");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    @InterfaceC5816d
    public static final String commonReadUtf8LineStrict(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadUtf8LineStrict");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = j2 == C5556m0.f20396b ? Long.MAX_VALUE : j2 + 1;
        byte b2 = (byte) 10;
        long indexOf = realBufferedSource.indexOf(b2, 0L, j3);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (j3 < C5556m0.f20396b && realBufferedSource.request(j3) && realBufferedSource.bufferField.getByte(j3 - 1) == ((byte) 13) && realBufferedSource.request(1 + j3) && realBufferedSource.bufferField.getByte(j3) == b2) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, j3);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j2) + " content=" + buffer.readByteString().hex() + "…");
    }

    public static final boolean commonRequest(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonRequest");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (realBufferedSource.bufferField.size() < j2) {
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return false;
            }
        }
        return true;
    }

    public static final void commonRequire(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonRequire");
        if (!realBufferedSource.request(j2)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d Options options) {
        C5544i0.m22546f(realBufferedSource, "$this$commonSelect");
        C5544i0.m22546f(options, "options");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        do {
            int selectPrefix = BufferKt.selectPrefix(realBufferedSource.bufferField, options, true);
            if (selectPrefix != -2) {
                if (selectPrefix == -1) {
                    return -1;
                }
                realBufferedSource.bufferField.skip(options.getByteStrings$okio()[selectPrefix].size());
                return selectPrefix;
            }
        } while (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) != -1);
        return -1;
    }

    public static final void commonSkip(@InterfaceC5816d RealBufferedSource realBufferedSource, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonSkip");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (j2 > 0) {
            if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                throw new EOFException();
            }
            long min = Math.min(j2, realBufferedSource.bufferField.size());
            realBufferedSource.bufferField.skip(min);
            j2 -= min;
        }
    }

    @InterfaceC5816d
    public static final Timeout commonTimeout(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonTimeout");
        return realBufferedSource.source.timeout();
    }

    @InterfaceC5816d
    public static final String commonToString(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonToString");
        return "buffer(" + realBufferedSource.source + ')';
    }

    @InterfaceC5816d
    public static final byte[] commonReadByteArray(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    @InterfaceC5816d
    public static final ByteString commonReadByteString(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    @InterfaceC5816d
    public static final String commonReadUtf8(@InterfaceC5816d RealBufferedSource realBufferedSource) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonReadFully");
        C5544i0.m22546f(buffer, "sink");
        try {
            realBufferedSource.require(j2);
            realBufferedSource.bufferField.readFully(buffer, j2);
        } catch (EOFException e2) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e2;
        }
    }

    public static final long commonIndexOf(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d ByteString byteString, long j2) {
        C5544i0.m22546f(realBufferedSource, "$this$commonIndexOf");
        C5544i0.m22546f(byteString, "bytes");
        if (!(!realBufferedSource.closed)) {
            throw new IllegalStateException("closed".toString());
        }
        while (true) {
            long indexOf = realBufferedSource.bufferField.indexOf(byteString, j2);
            if (indexOf != -1) {
                return indexOf;
            }
            long size = realBufferedSource.bufferField.size();
            if (realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
                return -1L;
            }
            j2 = Math.max(j2, (size - byteString.size()) + 1);
        }
    }

    public static final int commonRead(@InterfaceC5816d RealBufferedSource realBufferedSource, @InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(realBufferedSource, "$this$commonRead");
        C5544i0.m22546f(bArr, "sink");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i2, (int) Math.min(j2, realBufferedSource.bufferField.size()));
    }
}
