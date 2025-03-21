package okio.internal;

import h.q2.t.i0;
import h.q2.t.m0;
import h.y;
import i.c.a.d;
import i.c.a.e;
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

/* compiled from: RealBufferedSource.kt */
@y(bv = {1, 0, 3}, d1 = {"\u0000j\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0080\b\u001a\r\u0010\u0003\u001a\u00020\u0004*\u00020\u0002H\u0080\b\u001a%\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\u0005\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\u001d\u0010\r\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u000e\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u000f\u001a\u00020\u0010*\u00020\u0002H\u0080\b\u001a-\u0010\u0011\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0012\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010\u001a\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u001bH\u0080\b\u001a\r\u0010\u001c\u001a\u00020\b*\u00020\u0002H\u0080\b\u001a\r\u0010\u001d\u001a\u00020\u0018*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u0018*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001e\u001a\u00020\f*\u00020\u0002H\u0080\b\u001a\u0015\u0010\u001e\u001a\u00020\f*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010\u001f\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\u0015\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0018H\u0080\b\u001a\u001d\u0010 \u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00192\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010!\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010\"\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010#\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\r\u0010$\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010%\u001a\u00020\u0006*\u00020\u0002H\u0080\b\u001a\r\u0010&\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010(\u001a\u00020'*\u00020\u0002H\u0080\b\u001a\r\u0010)\u001a\u00020**\u00020\u0002H\u0080\b\u001a\u0015\u0010)\u001a\u00020**\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u0010+\u001a\u00020\u0014*\u00020\u0002H\u0080\b\u001a\u000f\u0010,\u001a\u0004\u0018\u00010**\u00020\u0002H\u0080\b\u001a\u0015\u0010-\u001a\u00020**\u00020\u00022\u0006\u0010.\u001a\u00020\u0006H\u0080\b\u001a\u0015\u0010/\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00100\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0014*\u00020\u00022\u0006\u00102\u001a\u000203H\u0080\b\u001a\u0015\u00104\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u0006H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0002H\u0080\b\u001a\r\u00107\u001a\u00020**\u00020\u0002H\u0080\b¨\u00068"}, d2 = {"commonClose", "", "Lokio/RealBufferedSource;", "commonExhausted", "", "commonIndexOf", "", "b", "", "fromIndex", "toIndex", "bytes", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonPeek", "Lokio/BufferedSource;", "commonRangeEquals", "offset", "bytesOffset", "", "byteCount", "commonRead", "sink", "", "Lokio/Buffer;", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadIntLe", "commonReadLong", "commonReadLongLe", "commonReadShort", "", "commonReadShortLe", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonRequest", "commonRequire", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonTimeout", "Lokio/Timeout;", "commonToString", "okio"}, k = 2, mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class RealBufferedSourceKt {
    public static final void commonClose(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonClose");
        if (realBufferedSource.closed) {
            return;
        }
        realBufferedSource.closed = true;
        realBufferedSource.source.close();
        realBufferedSource.bufferField.clear();
    }

    public static final boolean commonExhausted(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonExhausted");
        if (!realBufferedSource.closed) {
            return realBufferedSource.bufferField.exhausted() && realBufferedSource.source.read(realBufferedSource.bufferField, (long) 8192) == -1;
        }
        throw new IllegalStateException("closed".toString());
    }

    public static final long commonIndexOf(@d RealBufferedSource realBufferedSource, byte b2, long j2, long j3) {
        i0.f(realBufferedSource, "$this$commonIndexOf");
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

    public static final long commonIndexOfElement(@d RealBufferedSource realBufferedSource, @d ByteString byteString, long j2) {
        i0.f(realBufferedSource, "$this$commonIndexOfElement");
        i0.f(byteString, "targetBytes");
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

    @d
    public static final BufferedSource commonPeek(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonPeek");
        return Okio.buffer(new PeekSource(realBufferedSource));
    }

    public static final boolean commonRangeEquals(@d RealBufferedSource realBufferedSource, long j2, @d ByteString byteString, int i2, int i3) {
        i0.f(realBufferedSource, "$this$commonRangeEquals");
        i0.f(byteString, "bytes");
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

    public static final long commonRead(@d RealBufferedSource realBufferedSource, @d Buffer buffer, long j2) {
        i0.f(realBufferedSource, "$this$commonRead");
        i0.f(buffer, "sink");
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

    public static final long commonReadAll(@d RealBufferedSource realBufferedSource, @d Sink sink) {
        i0.f(realBufferedSource, "$this$commonReadAll");
        i0.f(sink, "sink");
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

    public static final byte commonReadByte(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadByte");
        realBufferedSource.require(1L);
        return realBufferedSource.bufferField.readByte();
    }

    @d
    public static final byte[] commonReadByteArray(@d RealBufferedSource realBufferedSource, long j2) {
        i0.f(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readByteArray(j2);
    }

    @d
    public static final ByteString commonReadByteString(@d RealBufferedSource realBufferedSource, long j2) {
        i0.f(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readByteString(j2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0031, code lost:
    
        if (r4 == 0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0034, code lost:
    
        r10 = new java.lang.StringBuilder();
        r10.append("Expected leading [0-9] or '-' character but was 0x");
        r0 = h.z2.d.a(16);
        r0 = h.z2.d.a(r0);
        r0 = java.lang.Integer.toString(r8, r0);
        h.q2.t.i0.a((java.lang.Object) r0, "java.lang.Integer.toStri…(this, checkRadix(radix))");
        r10.append(r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005d, code lost:
    
        throw new java.lang.NumberFormatException(r10.toString());
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@i.c.a.d okio.RealBufferedSource r10) {
        /*
            java.lang.String r0 = "$this$commonReadDecimalLong"
            h.q2.t.i0.f(r10, r0)
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
            int r0 = h.z2.c.a(r0)
            int r0 = h.z2.c.a(r0)
            java.lang.String r0 = java.lang.Integer.toString(r8, r0)
            java.lang.String r1 = "java.lang.Integer.toStri…(this, checkRadix(radix))"
            h.q2.t.i0.a(r0, r1)
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

    public static final void commonReadFully(@d RealBufferedSource realBufferedSource, @d byte[] bArr) {
        i0.f(realBufferedSource, "$this$commonReadFully");
        i0.f(bArr, "sink");
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

    public static final long commonReadHexadecimalUnsignedLong(@d RealBufferedSource realBufferedSource) {
        byte b2;
        int a2;
        int a3;
        i0.f(realBufferedSource, "$this$commonReadHexadecimalUnsignedLong");
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
            a2 = h.z2.d.a(16);
            a3 = h.z2.d.a(a2);
            String num = Integer.toString(b2, a3);
            i0.a((Object) num, "java.lang.Integer.toStri…(this, checkRadix(radix))");
            sb.append(num);
            throw new NumberFormatException(sb.toString());
        }
        return realBufferedSource.bufferField.readHexadecimalUnsignedLong();
    }

    public static final int commonReadInt(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadInt");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readInt();
    }

    public static final int commonReadIntLe(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadIntLe");
        realBufferedSource.require(4L);
        return realBufferedSource.bufferField.readIntLe();
    }

    public static final long commonReadLong(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadLong");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLong();
    }

    public static final long commonReadLongLe(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadLongLe");
        realBufferedSource.require(8L);
        return realBufferedSource.bufferField.readLongLe();
    }

    public static final short commonReadShort(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadShort");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShort();
    }

    public static final short commonReadShortLe(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadShortLe");
        realBufferedSource.require(2L);
        return realBufferedSource.bufferField.readShortLe();
    }

    @d
    public static final String commonReadUtf8(@d RealBufferedSource realBufferedSource, long j2) {
        i0.f(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.require(j2);
        return realBufferedSource.bufferField.readUtf8(j2);
    }

    public static final int commonReadUtf8CodePoint(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadUtf8CodePoint");
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

    @e
    public static final String commonReadUtf8Line(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadUtf8Line");
        long indexOf = realBufferedSource.indexOf((byte) 10);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (realBufferedSource.bufferField.size() != 0) {
            return realBufferedSource.readUtf8(realBufferedSource.bufferField.size());
        }
        return null;
    }

    @d
    public static final String commonReadUtf8LineStrict(@d RealBufferedSource realBufferedSource, long j2) {
        i0.f(realBufferedSource, "$this$commonReadUtf8LineStrict");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = j2 == m0.f16408b ? Long.MAX_VALUE : j2 + 1;
        byte b2 = (byte) 10;
        long indexOf = realBufferedSource.indexOf(b2, 0L, j3);
        if (indexOf != -1) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, indexOf);
        }
        if (j3 < m0.f16408b && realBufferedSource.request(j3) && realBufferedSource.bufferField.getByte(j3 - 1) == ((byte) 13) && realBufferedSource.request(1 + j3) && realBufferedSource.bufferField.getByte(j3) == b2) {
            return BufferKt.readUtf8Line(realBufferedSource.bufferField, j3);
        }
        Buffer buffer = new Buffer();
        Buffer buffer2 = realBufferedSource.bufferField;
        buffer2.copyTo(buffer, 0L, Math.min(32, buffer2.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(realBufferedSource.bufferField.size(), j2) + " content=" + buffer.readByteString().hex() + "…");
    }

    public static final boolean commonRequest(@d RealBufferedSource realBufferedSource, long j2) {
        i0.f(realBufferedSource, "$this$commonRequest");
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

    public static final void commonRequire(@d RealBufferedSource realBufferedSource, long j2) {
        i0.f(realBufferedSource, "$this$commonRequire");
        if (!realBufferedSource.request(j2)) {
            throw new EOFException();
        }
    }

    public static final int commonSelect(@d RealBufferedSource realBufferedSource, @d Options options) {
        i0.f(realBufferedSource, "$this$commonSelect");
        i0.f(options, "options");
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

    public static final void commonSkip(@d RealBufferedSource realBufferedSource, long j2) {
        i0.f(realBufferedSource, "$this$commonSkip");
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

    @d
    public static final Timeout commonTimeout(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonTimeout");
        return realBufferedSource.source.timeout();
    }

    @d
    public static final String commonToString(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonToString");
        return "buffer(" + realBufferedSource.source + ')';
    }

    @d
    public static final byte[] commonReadByteArray(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadByteArray");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteArray();
    }

    @d
    public static final ByteString commonReadByteString(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadByteString");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readByteString();
    }

    @d
    public static final String commonReadUtf8(@d RealBufferedSource realBufferedSource) {
        i0.f(realBufferedSource, "$this$commonReadUtf8");
        realBufferedSource.bufferField.writeAll(realBufferedSource.source);
        return realBufferedSource.bufferField.readUtf8();
    }

    public static final void commonReadFully(@d RealBufferedSource realBufferedSource, @d Buffer buffer, long j2) {
        i0.f(realBufferedSource, "$this$commonReadFully");
        i0.f(buffer, "sink");
        try {
            realBufferedSource.require(j2);
            realBufferedSource.bufferField.readFully(buffer, j2);
        } catch (EOFException e2) {
            buffer.writeAll(realBufferedSource.bufferField);
            throw e2;
        }
    }

    public static final long commonIndexOf(@d RealBufferedSource realBufferedSource, @d ByteString byteString, long j2) {
        i0.f(realBufferedSource, "$this$commonIndexOf");
        i0.f(byteString, "bytes");
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

    public static final int commonRead(@d RealBufferedSource realBufferedSource, @d byte[] bArr, int i2, int i3) {
        i0.f(realBufferedSource, "$this$commonRead");
        i0.f(bArr, "sink");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        if (realBufferedSource.bufferField.size() == 0 && realBufferedSource.source.read(realBufferedSource.bufferField, 8192) == -1) {
            return -1;
        }
        return realBufferedSource.bufferField.read(bArr, i2, (int) Math.min(j2, realBufferedSource.bufferField.size()));
    }
}
