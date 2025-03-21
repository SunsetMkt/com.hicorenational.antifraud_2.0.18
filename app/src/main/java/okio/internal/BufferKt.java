package okio.internal;

import androidx.exifinterface.media.ExifInterface;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3393cw;
import java.io.EOFException;
import okio.Buffer;
import okio.ByteString;
import okio.Options;
import okio.Platform;
import okio.Segment;
import okio.SegmentPool;
import okio.SegmentedByteString;
import okio.Sink;
import okio.Source;
import okio.Utf8;
import okio.Util;
import p286h.C5230f1;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5291q;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5556m0;
import p286h.p309q2.p311t.C5558n;
import p286h.p323z2.C5736h0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Buffer.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000v\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0005\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\bH\u0000\u001a\r\u0010\u0011\u001a\u00020\u0012*\u00020\u0013H\u0080\b\u001a\r\u0010\u0014\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\r\u0010\u0015\u001a\u00020\u0013*\u00020\u0013H\u0080\b\u001a%\u0010\u0016\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\u0017\u0010\u001a\u001a\u00020\n*\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0080\b\u001a\u0015\u0010\u001d\u001a\u00020\u001e*\u00020\u00132\u0006\u0010\u001f\u001a\u00020\u0005H\u0080\b\u001a\r\u0010 \u001a\u00020\b*\u00020\u0013H\u0080\b\u001a%\u0010!\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\"\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\u00052\u0006\u0010$\u001a\u00020\u0005H\u0080\b\u001a\u001d\u0010!\u001a\u00020\u0005*\u00020\u00132\u0006\u0010\u000e\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a\u001d\u0010&\u001a\u00020\u0005*\u00020\u00132\u0006\u0010'\u001a\u00020%2\u0006\u0010#\u001a\u00020\u0005H\u0080\b\u001a-\u0010(\u001a\u00020\n*\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020%2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0080\b\u001a\u0015\u0010)\u001a\u00020\b*\u00020\u00132\u0006\u0010*\u001a\u00020\u0001H\u0080\b\u001a%\u0010)\u001a\u00020\b*\u00020\u00132\u0006\u0010*\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0080\b\u001a\u001d\u0010)\u001a\u00020\u0005*\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010+\u001a\u00020\u0005*\u00020\u00132\u0006\u0010*\u001a\u00020,H\u0080\b\u001a\r\u0010-\u001a\u00020\u001e*\u00020\u0013H\u0080\b\u001a\r\u0010.\u001a\u00020\u0001*\u00020\u0013H\u0080\b\u001a\u0015\u0010.\u001a\u00020\u0001*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\r\u0010/\u001a\u00020%*\u00020\u0013H\u0080\b\u001a\u0015\u0010/\u001a\u00020%*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\r\u00100\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\u0015\u00101\u001a\u00020\u0012*\u00020\u00132\u0006\u0010*\u001a\u00020\u0001H\u0080\b\u001a\u001d\u00101\u001a\u00020\u0012*\u00020\u00132\u0006\u0010*\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\r\u00102\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\r\u00103\u001a\u00020\b*\u00020\u0013H\u0080\b\u001a\r\u00104\u001a\u00020\u0005*\u00020\u0013H\u0080\b\u001a\r\u00105\u001a\u000206*\u00020\u0013H\u0080\b\u001a\u0015\u00107\u001a\u000208*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\r\u00109\u001a\u00020\b*\u00020\u0013H\u0080\b\u001a\u000f\u0010:\u001a\u0004\u0018\u000108*\u00020\u0013H\u0080\b\u001a\u0015\u0010;\u001a\u000208*\u00020\u00132\u0006\u0010<\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010=\u001a\u00020\b*\u00020\u00132\u0006\u0010>\u001a\u00020?H\u0080\b\u001a\u0015\u0010@\u001a\u00020\u0012*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\r\u0010A\u001a\u00020%*\u00020\u0013H\u0080\b\u001a\u0015\u0010A\u001a\u00020%*\u00020\u00132\u0006\u0010\u0019\u001a\u00020\bH\u0080\b\u001a\u0015\u0010B\u001a\u00020\f*\u00020\u00132\u0006\u0010C\u001a\u00020\bH\u0080\b\u001a\u0015\u0010D\u001a\u00020\u0013*\u00020\u00132\u0006\u0010E\u001a\u00020\u0001H\u0080\b\u001a%\u0010D\u001a\u00020\u0013*\u00020\u00132\u0006\u0010E\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\bH\u0080\b\u001a\u001d\u0010D\u001a\u00020\u0012*\u00020\u00132\u0006\u0010E\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a)\u0010D\u001a\u00020\u0013*\u00020\u00132\u0006\u0010F\u001a\u00020%2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\bH\u0080\b\u001a\u001d\u0010D\u001a\u00020\u0013*\u00020\u00132\u0006\u0010E\u001a\u00020G2\u0006\u0010\u0019\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010H\u001a\u00020\u0005*\u00020\u00132\u0006\u0010E\u001a\u00020GH\u0080\b\u001a\u0015\u0010I\u001a\u00020\u0013*\u00020\u00132\u0006\u0010\"\u001a\u00020\bH\u0080\b\u001a\u0015\u0010J\u001a\u00020\u0013*\u00020\u00132\u0006\u0010K\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010L\u001a\u00020\u0013*\u00020\u00132\u0006\u0010K\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010M\u001a\u00020\u0013*\u00020\u00132\u0006\u0010N\u001a\u00020\bH\u0080\b\u001a\u0015\u0010O\u001a\u00020\u0013*\u00020\u00132\u0006\u0010K\u001a\u00020\u0005H\u0080\b\u001a\u0015\u0010P\u001a\u00020\u0013*\u00020\u00132\u0006\u0010Q\u001a\u00020\bH\u0080\b\u001a%\u0010R\u001a\u00020\u0013*\u00020\u00132\u0006\u0010S\u001a\u0002082\u0006\u0010T\u001a\u00020\b2\u0006\u0010U\u001a\u00020\bH\u0080\b\u001a\u0015\u0010V\u001a\u00020\u0013*\u00020\u00132\u0006\u0010W\u001a\u00020\bH\u0080\b\u001a\u0014\u0010X\u001a\u000208*\u00020\u00132\u0006\u0010Y\u001a\u00020\u0005H\u0000\u001a<\u0010Z\u001a\u0002H[\"\u0004\b\u0000\u0010[*\u00020\u00132\u0006\u0010#\u001a\u00020\u00052\u001a\u0010\\\u001a\u0016\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u0002H[0]H\u0080\b¢\u0006\u0002\u0010^\u001a\u001e\u0010_\u001a\u00020\b*\u00020\u00132\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010`\u001a\u00020\nH\u0000\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0006\u001a\u00020\u0005X\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0007\u001a\u00020\bX\u0080T¢\u0006\u0002\n\u0000¨\u0006a"}, m23546d2 = {"HEX_DIGIT_BYTES", "", "getHEX_DIGIT_BYTES", "()[B", "OVERFLOW_DIGIT_START", "", "OVERFLOW_ZONE", "SEGMENTING_THRESHOLD", "", "rangeEquals", "", "segment", "Lokio/Segment;", "segmentPos", "bytes", "bytesOffset", "bytesLimit", "commonClear", "", "Lokio/Buffer;", "commonCompleteSegmentByteCount", "commonCopy", "commonCopyTo", "out", "offset", "byteCount", "commonEquals", DispatchConstants.OTHER, "", "commonGet", "", "pos", "commonHashCode", "commonIndexOf", "b", "fromIndex", "toIndex", "Lokio/ByteString;", "commonIndexOfElement", "targetBytes", "commonRangeEquals", "commonRead", "sink", "commonReadAll", "Lokio/Sink;", "commonReadByte", "commonReadByteArray", "commonReadByteString", "commonReadDecimalLong", "commonReadFully", "commonReadHexadecimalUnsignedLong", "commonReadInt", "commonReadLong", "commonReadShort", "", "commonReadUtf8", "", "commonReadUtf8CodePoint", "commonReadUtf8Line", "commonReadUtf8LineStrict", "limit", "commonSelect", "options", "Lokio/Options;", "commonSkip", "commonSnapshot", "commonWritableSegment", "minimumCapacity", "commonWrite", "source", "byteString", "Lokio/Source;", "commonWriteAll", "commonWriteByte", "commonWriteDecimalLong", "v", "commonWriteHexadecimalUnsignedLong", "commonWriteInt", C3351bh.f11581aF, "commonWriteLong", "commonWriteShort", C3351bh.f11580aE, "commonWriteUtf8", "string", "beginIndex", "endIndex", "commonWriteUtf8CodePoint", "codePoint", "readUtf8Line", "newline", "seek", ExifInterface.GPS_DIRECTION_TRUE, "lambda", "Lkotlin/Function2;", "(Lokio/Buffer;JLkotlin/jvm/functions/Function2;)Ljava/lang/Object;", "selectPrefix", "selectTruncated", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class BufferKt {

    @InterfaceC5816d
    private static final byte[] HEX_DIGIT_BYTES = Platform.asUtf8ToByteArray("0123456789abcdef");
    public static final long OVERFLOW_DIGIT_START = -7;
    public static final long OVERFLOW_ZONE = -922337203685477580L;
    public static final int SEGMENTING_THRESHOLD = 4096;

    public static final void commonClear(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonClear");
        buffer.skip(buffer.size());
    }

    public static final long commonCompleteSegmentByteCount(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonCompleteSegmentByteCount");
        long size = buffer.size();
        if (size == 0) {
            return 0L;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            C5544i0.m22545f();
        }
        return (segment2.limit >= 8192 || !segment2.owner) ? size : size - (r2 - segment2.pos);
    }

    @InterfaceC5816d
    public static final Buffer commonCopy(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonCopy");
        Buffer buffer2 = new Buffer();
        if (buffer.size() == 0) {
            return buffer2;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        Segment sharedCopy = segment.sharedCopy();
        buffer2.head = sharedCopy;
        sharedCopy.prev = buffer2.head;
        sharedCopy.next = sharedCopy.prev;
        for (Segment segment2 = segment.next; segment2 != segment; segment2 = segment2.next) {
            Segment segment3 = sharedCopy.prev;
            if (segment3 == null) {
                C5544i0.m22545f();
            }
            if (segment2 == null) {
                C5544i0.m22545f();
            }
            segment3.push(segment2.sharedCopy());
        }
        buffer2.setSize$okio(buffer.size());
        return buffer2;
    }

    @InterfaceC5816d
    public static final Buffer commonCopyTo(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Buffer buffer2, long j2, long j3) {
        C5544i0.m22546f(buffer, "$this$commonCopyTo");
        C5544i0.m22546f(buffer2, "out");
        Util.checkOffsetAndCount(buffer.size(), j2, j3);
        if (j3 == 0) {
            return buffer;
        }
        buffer2.setSize$okio(buffer2.size() + j3);
        Segment segment = buffer.head;
        while (true) {
            if (segment == null) {
                C5544i0.m22545f();
            }
            int i2 = segment.limit;
            int i3 = segment.pos;
            if (j2 < i2 - i3) {
                break;
            }
            j2 -= i2 - i3;
            segment = segment.next;
        }
        while (j3 > 0) {
            if (segment == null) {
                C5544i0.m22545f();
            }
            Segment sharedCopy = segment.sharedCopy();
            sharedCopy.pos += (int) j2;
            sharedCopy.limit = Math.min(sharedCopy.pos + ((int) j3), sharedCopy.limit);
            Segment segment2 = buffer2.head;
            if (segment2 == null) {
                sharedCopy.prev = sharedCopy;
                sharedCopy.next = sharedCopy.prev;
                buffer2.head = sharedCopy.next;
            } else {
                if (segment2 == null) {
                    C5544i0.m22545f();
                }
                Segment segment3 = segment2.prev;
                if (segment3 == null) {
                    C5544i0.m22545f();
                }
                segment3.push(sharedCopy);
            }
            j3 -= sharedCopy.limit - sharedCopy.pos;
            segment = segment.next;
            j2 = 0;
        }
        return buffer;
    }

    public static final boolean commonEquals(@InterfaceC5816d Buffer buffer, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(buffer, "$this$commonEquals");
        if (buffer == obj) {
            return true;
        }
        if (!(obj instanceof Buffer)) {
            return false;
        }
        Buffer buffer2 = (Buffer) obj;
        if (buffer.size() != buffer2.size()) {
            return false;
        }
        if (buffer.size() == 0) {
            return true;
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        Segment segment2 = buffer2.head;
        if (segment2 == null) {
            C5544i0.m22545f();
        }
        int i2 = segment.pos;
        int i3 = segment2.pos;
        Segment segment3 = segment2;
        int i4 = i2;
        int i5 = i3;
        long j2 = 0;
        while (j2 < buffer.size()) {
            long min = Math.min(segment.limit - i4, segment3.limit - i5);
            long j3 = 0;
            while (j3 < min) {
                int i6 = i4 + 1;
                int i7 = i5 + 1;
                if (segment.data[i4] != segment3.data[i5]) {
                    return false;
                }
                j3++;
                i4 = i6;
                i5 = i7;
            }
            if (i4 == segment.limit) {
                Segment segment4 = segment.next;
                if (segment4 == null) {
                    C5544i0.m22545f();
                }
                segment = segment4;
                i4 = segment4.pos;
            }
            if (i5 == segment3.limit) {
                segment3 = segment3.next;
                if (segment3 == null) {
                    C5544i0.m22545f();
                }
                i5 = segment3.pos;
            }
            j2 += min;
        }
        return true;
    }

    public static final byte commonGet(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonGet");
        Util.checkOffsetAndCount(buffer.size(), j2, 1L);
        Segment segment = buffer.head;
        if (segment == null) {
            Segment segment2 = null;
            C5544i0.m22545f();
            return segment2.data[(int) ((segment2.pos + j2) - (-1))];
        }
        if (buffer.size() - j2 < j2) {
            long size = buffer.size();
            while (size > j2) {
                segment = segment.prev;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                size -= segment.limit - segment.pos;
            }
            if (segment == null) {
                C5544i0.m22545f();
            }
            return segment.data[(int) ((segment.pos + j2) - size)];
        }
        long j3 = 0;
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                C5544i0.m22545f();
            }
            j3 = j4;
        }
        if (segment == null) {
            C5544i0.m22545f();
        }
        return segment.data[(int) ((segment.pos + j2) - j3)];
    }

    public static final int commonHashCode(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonHashCode");
        Segment segment = buffer.head;
        if (segment == null) {
            return 0;
        }
        int i2 = 1;
        do {
            int i3 = segment.limit;
            for (int i4 = segment.pos; i4 < i3; i4++) {
                i2 = (i2 * 31) + segment.data[i4];
            }
            segment = segment.next;
            if (segment == null) {
                C5544i0.m22545f();
            }
        } while (segment != buffer.head);
        return i2;
    }

    public static final long commonIndexOf(@InterfaceC5816d Buffer buffer, byte b2, long j2, long j3) {
        Segment segment;
        int i2;
        C5544i0.m22546f(buffer, "$this$commonIndexOf");
        long j4 = 0;
        if (!(0 <= j2 && j3 >= j2)) {
            throw new IllegalArgumentException(("size=" + buffer.size() + " fromIndex=" + j2 + " toIndex=" + j3).toString());
        }
        if (j3 > buffer.size()) {
            j3 = buffer.size();
        }
        if (j2 == j3 || (segment = buffer.head) == null) {
            return -1L;
        }
        if (buffer.size() - j2 < j2) {
            j4 = buffer.size();
            while (j4 > j2) {
                segment = segment.prev;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                j4 -= segment.limit - segment.pos;
            }
            if (segment != null) {
                while (j4 < j3) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + j3) - j4);
                    i2 = (int) ((segment.pos + j2) - j4);
                    while (i2 < min) {
                        if (bArr[i2] != b2) {
                            i2++;
                        }
                    }
                    j2 = (segment.limit - segment.pos) + j4;
                    segment = segment.next;
                    if (segment == null) {
                        C5544i0.m22545f();
                    }
                    j4 = j2;
                }
            }
            return -1L;
        }
        while (true) {
            long j5 = (segment.limit - segment.pos) + j4;
            if (j5 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                C5544i0.m22545f();
            }
            j4 = j5;
        }
        if (segment != null) {
            while (j4 < j3) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min(segment.limit, (segment.pos + j3) - j4);
                i2 = (int) ((segment.pos + j2) - j4);
                while (i2 < min2) {
                    if (bArr2[i2] != b2) {
                        i2++;
                    }
                }
                j2 = (segment.limit - segment.pos) + j4;
                segment = segment.next;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                j4 = j2;
            }
        }
        return -1L;
        return (i2 - segment.pos) + j4;
    }

    public static final long commonIndexOfElement(@InterfaceC5816d Buffer buffer, @InterfaceC5816d ByteString byteString, long j2) {
        int i2;
        int i3;
        C5544i0.m22546f(buffer, "$this$commonIndexOfElement");
        C5544i0.m22546f(byteString, "targetBytes");
        long j3 = 0;
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("fromIndex < 0: " + j2).toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            return -1L;
        }
        if (buffer.size() - j2 < j2) {
            j3 = buffer.size();
            while (j3 > j2) {
                segment = segment.prev;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                j3 -= segment.limit - segment.pos;
            }
            if (segment != null) {
                if (byteString.size() == 2) {
                    byte b2 = byteString.getByte(0);
                    byte b3 = byteString.getByte(1);
                    while (j3 < buffer.size()) {
                        byte[] bArr = segment.data;
                        i2 = (int) ((segment.pos + j2) - j3);
                        int i4 = segment.limit;
                        while (i2 < i4) {
                            byte b4 = bArr[i2];
                            if (b4 != b2 && b4 != b3) {
                                i2++;
                            }
                            i3 = segment.pos;
                        }
                        j2 = (segment.limit - segment.pos) + j3;
                        segment = segment.next;
                        if (segment == null) {
                            C5544i0.m22545f();
                        }
                        j3 = j2;
                    }
                } else {
                    byte[] internalArray$okio = byteString.internalArray$okio();
                    while (j3 < buffer.size()) {
                        byte[] bArr2 = segment.data;
                        i2 = (int) ((segment.pos + j2) - j3);
                        int i5 = segment.limit;
                        while (i2 < i5) {
                            byte b5 = bArr2[i2];
                            for (byte b6 : internalArray$okio) {
                                if (b5 == b6) {
                                    i3 = segment.pos;
                                }
                            }
                            i2++;
                        }
                        j2 = (segment.limit - segment.pos) + j3;
                        segment = segment.next;
                        if (segment == null) {
                            C5544i0.m22545f();
                        }
                        j3 = j2;
                    }
                }
            }
            return -1L;
        }
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j2) {
                break;
            }
            segment = segment.next;
            if (segment == null) {
                C5544i0.m22545f();
            }
            j3 = j4;
        }
        if (segment != null) {
            if (byteString.size() == 2) {
                byte b7 = byteString.getByte(0);
                byte b8 = byteString.getByte(1);
                while (j3 < buffer.size()) {
                    byte[] bArr3 = segment.data;
                    i2 = (int) ((segment.pos + j2) - j3);
                    int i6 = segment.limit;
                    while (i2 < i6) {
                        byte b9 = bArr3[i2];
                        if (b9 != b7 && b9 != b8) {
                            i2++;
                        }
                        i3 = segment.pos;
                    }
                    j2 = (segment.limit - segment.pos) + j3;
                    segment = segment.next;
                    if (segment == null) {
                        C5544i0.m22545f();
                    }
                    j3 = j2;
                }
            } else {
                byte[] internalArray$okio2 = byteString.internalArray$okio();
                while (j3 < buffer.size()) {
                    byte[] bArr4 = segment.data;
                    i2 = (int) ((segment.pos + j2) - j3);
                    int i7 = segment.limit;
                    while (i2 < i7) {
                        byte b10 = bArr4[i2];
                        for (byte b11 : internalArray$okio2) {
                            if (b10 == b11) {
                                i3 = segment.pos;
                            }
                        }
                        i2++;
                    }
                    j2 = (segment.limit - segment.pos) + j3;
                    segment = segment.next;
                    if (segment == null) {
                        C5544i0.m22545f();
                    }
                    j3 = j2;
                }
            }
        }
        return -1L;
        return (i2 - i3) + j3;
    }

    public static final boolean commonRangeEquals(@InterfaceC5816d Buffer buffer, long j2, @InterfaceC5816d ByteString byteString, int i2, int i3) {
        C5544i0.m22546f(buffer, "$this$commonRangeEquals");
        C5544i0.m22546f(byteString, "bytes");
        if (j2 < 0 || i2 < 0 || i3 < 0 || buffer.size() - j2 < i3 || byteString.size() - i2 < i3) {
            return false;
        }
        for (int i4 = 0; i4 < i3; i4++) {
            if (buffer.getByte(i4 + j2) != byteString.getByte(i2 + i4)) {
                return false;
            }
        }
        return true;
    }

    public static final int commonRead(@InterfaceC5816d Buffer buffer, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(buffer, "$this$commonRead");
        C5544i0.m22546f(bArr, "sink");
        return buffer.read(bArr, 0, bArr.length);
    }

    public static final long commonReadAll(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Sink sink) {
        C5544i0.m22546f(buffer, "$this$commonReadAll");
        C5544i0.m22546f(sink, "sink");
        long size = buffer.size();
        if (size > 0) {
            sink.write(buffer, size);
        }
        return size;
    }

    public static final byte commonReadByte(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonReadByte");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        int i4 = i2 + 1;
        byte b2 = segment.data[i2];
        buffer.setSize$okio(buffer.size() - 1);
        if (i4 == i3) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i4;
        }
        return b2;
    }

    @InterfaceC5816d
    public static final byte[] commonReadByteArray(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonReadByteArray");
        return buffer.readByteArray(buffer.size());
    }

    @InterfaceC5816d
    public static final ByteString commonReadByteString(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonReadByteString");
        return buffer.readByteString(buffer.size());
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x00b4  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c6  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x00ca A[EDGE_INSN: B:51:0x00ca->B:45:0x00ca BREAK  A[LOOP:0: B:4:0x0017->B:50:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x00c1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadDecimalLong(@p324i.p336c.p337a.InterfaceC5816d okio.Buffer r17) {
        /*
            Method dump skipped, instructions count: 222
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadDecimalLong(okio.Buffer):long");
    }

    public static final void commonReadFully(@InterfaceC5816d Buffer buffer, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(buffer, "$this$commonReadFully");
        C5544i0.m22546f(bArr, "sink");
        int i2 = 0;
        while (i2 < bArr.length) {
            int read = buffer.read(bArr, i2, bArr.length - i2);
            if (read == -1) {
                throw new EOFException();
            }
            i2 += read;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b7 A[EDGE_INSN: B:42:0x00b7->B:39:0x00b7 BREAK  A[LOOP:0: B:4:0x0012->B:41:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final long commonReadHexadecimalUnsignedLong(@p324i.p336c.p337a.InterfaceC5816d okio.Buffer r15) {
        /*
            java.lang.String r0 = "$this$commonReadHexadecimalUnsignedLong"
            p286h.p309q2.p311t.C5544i0.m22546f(r15, r0)
            long r0 = r15.size()
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 == 0) goto Lc1
            r0 = 0
            r4 = r2
            r1 = 0
        L12:
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L19
            p286h.p309q2.p311t.C5544i0.m22545f()
        L19:
            byte[] r7 = r6.data
            int r8 = r6.pos
            int r9 = r6.limit
        L1f:
            if (r8 >= r9) goto La1
            r10 = r7[r8]
            r11 = 48
            byte r11 = (byte) r11
            if (r10 < r11) goto L30
            r12 = 57
            byte r12 = (byte) r12
            if (r10 > r12) goto L30
            int r11 = r10 - r11
            goto L4a
        L30:
            r11 = 97
            byte r11 = (byte) r11
            if (r10 < r11) goto L3f
            r12 = 102(0x66, float:1.43E-43)
            byte r12 = (byte) r12
            if (r10 > r12) goto L3f
        L3a:
            int r11 = r10 - r11
            int r11 = r11 + 10
            goto L4a
        L3f:
            r11 = 65
            byte r11 = (byte) r11
            if (r10 < r11) goto L82
            r12 = 70
            byte r12 = (byte) r12
            if (r10 > r12) goto L82
            goto L3a
        L4a:
            r12 = -1152921504606846976(0xf000000000000000, double:-3.105036184601418E231)
            long r12 = r12 & r4
            int r14 = (r12 > r2 ? 1 : (r12 == r2 ? 0 : -1))
            if (r14 != 0) goto L5a
            r10 = 4
            long r4 = r4 << r10
            long r10 = (long) r11
            long r4 = r4 | r10
            int r8 = r8 + 1
            int r0 = r0 + 1
            goto L1f
        L5a:
            okio.Buffer r15 = new okio.Buffer
            r15.<init>()
            okio.Buffer r15 = r15.writeHexadecimalUnsignedLong(r4)
            okio.Buffer r15 = r15.writeByte(r10)
            java.lang.NumberFormatException r0 = new java.lang.NumberFormatException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Number too large: "
            r1.append(r2)
            java.lang.String r15 = r15.readUtf8()
            r1.append(r15)
            java.lang.String r15 = r1.toString()
            r0.<init>(r15)
            throw r0
        L82:
            if (r0 == 0) goto L86
            r1 = 1
            goto La1
        L86:
            java.lang.NumberFormatException r15 = new java.lang.NumberFormatException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expected leading [0-9a-fA-F] character but was 0x"
            r0.append(r1)
            java.lang.String r1 = okio.Util.toHexString(r10)
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            throw r15
        La1:
            if (r8 != r9) goto Laf
            okio.Segment r7 = r6.pop()
            r15.head = r7
            okio.SegmentPool r7 = okio.SegmentPool.INSTANCE
            r7.recycle(r6)
            goto Lb1
        Laf:
            r6.pos = r8
        Lb1:
            if (r1 != 0) goto Lb7
            okio.Segment r6 = r15.head
            if (r6 != 0) goto L12
        Lb7:
            long r1 = r15.size()
            long r6 = (long) r0
            long r1 = r1 - r6
            r15.setSize$okio(r1)
            return r4
        Lc1:
            java.io.EOFException r15 = new java.io.EOFException
            r15.<init>()
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: okio.internal.BufferKt.commonReadHexadecimalUnsignedLong(okio.Buffer):long");
    }

    public static final int commonReadInt(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonReadInt");
        if (buffer.size() < 4) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 4) {
            return (buffer.readByte() & C5230f1.f20085c) | ((buffer.readByte() & C5230f1.f20085c) << 24) | ((buffer.readByte() & C5230f1.f20085c) << 16) | ((buffer.readByte() & C5230f1.f20085c) << 8);
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & C5230f1.f20085c) << 24) | ((bArr[i4] & C5230f1.f20085c) << 16);
        int i7 = i5 + 1;
        int i8 = i6 | ((bArr[i5] & C5230f1.f20085c) << 8);
        int i9 = i7 + 1;
        int i10 = i8 | (bArr[i7] & C5230f1.f20085c);
        buffer.setSize$okio(buffer.size() - 4);
        if (i9 == i3) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i9;
        }
        return i10;
    }

    public static final long commonReadLong(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonReadLong");
        if (buffer.size() < 8) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 8) {
            return ((buffer.readInt() & 4294967295L) << 32) | (4294967295L & buffer.readInt());
        }
        byte[] bArr = segment.data;
        long j2 = (bArr[i2] & 255) << 56;
        long j3 = j2 | ((bArr[r6] & 255) << 48);
        long j4 = j3 | ((bArr[r1] & 255) << 40);
        int i4 = i2 + 1 + 1 + 1 + 1;
        long j5 = ((bArr[r6] & 255) << 32) | j4;
        long j6 = j5 | ((bArr[i4] & 255) << 24);
        long j7 = j6 | ((bArr[r8] & 255) << 16);
        long j8 = j7 | ((bArr[r1] & 255) << 8);
        int i5 = i4 + 1 + 1 + 1 + 1;
        long j9 = j8 | (bArr[r8] & 255);
        buffer.setSize$okio(buffer.size() - 8);
        if (i5 == i3) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return j9;
    }

    public static final short commonReadShort(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonReadShort");
        if (buffer.size() < 2) {
            throw new EOFException();
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        int i2 = segment.pos;
        int i3 = segment.limit;
        if (i3 - i2 < 2) {
            return (short) ((buffer.readByte() & C5230f1.f20085c) | ((buffer.readByte() & C5230f1.f20085c) << 8));
        }
        byte[] bArr = segment.data;
        int i4 = i2 + 1;
        int i5 = i4 + 1;
        int i6 = ((bArr[i2] & C5230f1.f20085c) << 8) | (bArr[i4] & C5230f1.f20085c);
        buffer.setSize$okio(buffer.size() - 2);
        if (i5 == i3) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        } else {
            segment.pos = i5;
        }
        return (short) i6;
    }

    @InterfaceC5816d
    public static final String commonReadUtf8(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonReadUtf8");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (buffer.size() < j2) {
            throw new EOFException();
        }
        if (j2 == 0) {
            return "";
        }
        Segment segment = buffer.head;
        if (segment == null) {
            C5544i0.m22545f();
        }
        int i2 = segment.pos;
        if (i2 + j2 > segment.limit) {
            return _Utf8Kt.commonToUtf8String$default(buffer.readByteArray(j2), 0, 0, 3, null);
        }
        int i3 = (int) j2;
        String commonToUtf8String = _Utf8Kt.commonToUtf8String(segment.data, i2, i2 + i3);
        segment.pos += i3;
        buffer.setSize$okio(buffer.size() - j2);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return commonToUtf8String;
    }

    public static final int commonReadUtf8CodePoint(@InterfaceC5816d Buffer buffer) {
        int i2;
        int i3;
        int i4;
        C5544i0.m22546f(buffer, "$this$commonReadUtf8CodePoint");
        if (buffer.size() == 0) {
            throw new EOFException();
        }
        byte b2 = buffer.getByte(0L);
        if ((b2 & C5558n.f20401a) == 0) {
            i2 = b2 & C5558n.f20402b;
            i3 = 1;
            i4 = 0;
        } else if ((b2 & 224) == 192) {
            i2 = b2 & 31;
            i3 = 2;
            i4 = 128;
        } else if ((b2 & 240) == 224) {
            i2 = b2 & C3393cw.f11873m;
            i3 = 3;
            i4 = 2048;
        } else {
            if ((b2 & 248) != 240) {
                buffer.skip(1L);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = b2 & 7;
            i3 = 4;
            i4 = 65536;
        }
        long j2 = i3;
        if (buffer.size() < j2) {
            throw new EOFException("size < " + i3 + ": " + buffer.size() + " (to read code point prefixed 0x" + Util.toHexString(b2) + ')');
        }
        for (int i5 = 1; i5 < i3; i5++) {
            long j3 = i5;
            byte b3 = buffer.getByte(j3);
            if ((b3 & 192) != 128) {
                buffer.skip(j3);
                return Utf8.REPLACEMENT_CODE_POINT;
            }
            i2 = (i2 << 6) | (b3 & Utf8.REPLACEMENT_BYTE);
        }
        buffer.skip(j2);
        return i2 > 1114111 ? Utf8.REPLACEMENT_CODE_POINT : ((55296 <= i2 && 57343 >= i2) || i2 < i4) ? Utf8.REPLACEMENT_CODE_POINT : i2;
    }

    @InterfaceC5817e
    public static final String commonReadUtf8Line(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonReadUtf8Line");
        long indexOf = buffer.indexOf((byte) 10);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (buffer.size() != 0) {
            return buffer.readUtf8(buffer.size());
        }
        return null;
    }

    @InterfaceC5816d
    public static final String commonReadUtf8LineStrict(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonReadUtf8LineStrict");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("limit < 0: " + j2).toString());
        }
        long j3 = C5556m0.f20396b;
        if (j2 != C5556m0.f20396b) {
            j3 = j2 + 1;
        }
        byte b2 = (byte) 10;
        long indexOf = buffer.indexOf(b2, 0L, j3);
        if (indexOf != -1) {
            return readUtf8Line(buffer, indexOf);
        }
        if (j3 < buffer.size() && buffer.getByte(j3 - 1) == ((byte) 13) && buffer.getByte(j3) == b2) {
            return readUtf8Line(buffer, j3);
        }
        Buffer buffer2 = new Buffer();
        buffer.copyTo(buffer2, 0L, Math.min(32, buffer.size()));
        throw new EOFException("\\n not found: limit=" + Math.min(buffer.size(), j2) + " content=" + buffer2.readByteString().hex() + C5736h0.f20702E);
    }

    public static final int commonSelect(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Options options) {
        C5544i0.m22546f(buffer, "$this$commonSelect");
        C5544i0.m22546f(options, "options");
        int selectPrefix$default = selectPrefix$default(buffer, options, false, 2, null);
        if (selectPrefix$default == -1) {
            return -1;
        }
        buffer.skip(options.getByteStrings$okio()[selectPrefix$default].size());
        return selectPrefix$default;
    }

    public static final void commonSkip(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonSkip");
        while (j2 > 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                throw new EOFException();
            }
            int min = (int) Math.min(j2, segment.limit - segment.pos);
            long j3 = min;
            buffer.setSize$okio(buffer.size() - j3);
            j2 -= j3;
            segment.pos += min;
            if (segment.pos == segment.limit) {
                buffer.head = segment.pop();
                SegmentPool.INSTANCE.recycle(segment);
            }
        }
    }

    @InterfaceC5816d
    public static final ByteString commonSnapshot(@InterfaceC5816d Buffer buffer) {
        C5544i0.m22546f(buffer, "$this$commonSnapshot");
        if (buffer.size() <= ((long) Integer.MAX_VALUE)) {
            return buffer.snapshot((int) buffer.size());
        }
        throw new IllegalStateException(("size > Int.MAX_VALUE: " + buffer.size()).toString());
    }

    @InterfaceC5816d
    public static final Segment commonWritableSegment(@InterfaceC5816d Buffer buffer, int i2) {
        C5544i0.m22546f(buffer, "$this$commonWritableSegment");
        if (!(i2 >= 1 && i2 <= 8192)) {
            throw new IllegalArgumentException("unexpected capacity".toString());
        }
        Segment segment = buffer.head;
        if (segment == null) {
            Segment take = SegmentPool.INSTANCE.take();
            buffer.head = take;
            take.prev = take;
            take.next = take;
            return take;
        }
        if (segment == null) {
            C5544i0.m22545f();
        }
        Segment segment2 = segment.prev;
        if (segment2 == null) {
            C5544i0.m22545f();
        }
        return (segment2.limit + i2 > 8192 || !segment2.owner) ? segment2.push(SegmentPool.INSTANCE.take()) : segment2;
    }

    @InterfaceC5816d
    public static final Buffer commonWrite(@InterfaceC5816d Buffer buffer, @InterfaceC5816d ByteString byteString, int i2, int i3) {
        C5544i0.m22546f(buffer, "$this$commonWrite");
        C5544i0.m22546f(byteString, "byteString");
        byteString.write$okio(buffer, i2, i3);
        return buffer;
    }

    public static /* synthetic */ Buffer commonWrite$default(Buffer buffer, ByteString byteString, int i2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            i3 = byteString.size();
        }
        C5544i0.m22546f(buffer, "$this$commonWrite");
        C5544i0.m22546f(byteString, "byteString");
        byteString.write$okio(buffer, i2, i3);
        return buffer;
    }

    public static final long commonWriteAll(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Source source) {
        C5544i0.m22546f(buffer, "$this$commonWriteAll");
        C5544i0.m22546f(source, "source");
        long j2 = 0;
        while (true) {
            long read = source.read(buffer, 8192);
            if (read == -1) {
                return j2;
            }
            j2 += read;
        }
    }

    @InterfaceC5816d
    public static final Buffer commonWriteByte(@InterfaceC5816d Buffer buffer, int i2) {
        C5544i0.m22546f(buffer, "$this$commonWriteByte");
        Segment writableSegment$okio = buffer.writableSegment$okio(1);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        writableSegment$okio.limit = i3 + 1;
        bArr[i3] = (byte) i2;
        buffer.setSize$okio(buffer.size() + 1);
        return buffer;
    }

    @InterfaceC5816d
    public static final Buffer commonWriteDecimalLong(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonWriteDecimalLong");
        if (j2 == 0) {
            return buffer.writeByte(48);
        }
        boolean z = false;
        int i2 = 1;
        if (j2 < 0) {
            j2 = -j2;
            if (j2 < 0) {
                return buffer.writeUtf8("-9223372036854775808");
            }
            z = true;
        }
        if (j2 >= 100000000) {
            i2 = j2 < 1000000000000L ? j2 < 10000000000L ? j2 < 1000000000 ? 9 : 10 : j2 < 100000000000L ? 11 : 12 : j2 < 1000000000000000L ? j2 < 10000000000000L ? 13 : j2 < 100000000000000L ? 14 : 15 : j2 < 100000000000000000L ? j2 < 10000000000000000L ? 16 : 17 : j2 < 1000000000000000000L ? 18 : 19;
        } else if (j2 >= C2084a.f6135q) {
            i2 = j2 < 1000000 ? j2 < 100000 ? 5 : 6 : j2 < 10000000 ? 7 : 8;
        } else if (j2 >= 100) {
            i2 = j2 < 1000 ? 3 : 4;
        } else if (j2 >= 10) {
            i2 = 2;
        }
        if (z) {
            i2++;
        }
        Segment writableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit + i2;
        while (j2 != 0) {
            long j3 = 10;
            i3--;
            bArr[i3] = getHEX_DIGIT_BYTES()[(int) (j2 % j3)];
            j2 /= j3;
        }
        if (z) {
            bArr[i3 - 1] = (byte) 45;
        }
        writableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + i2);
        return buffer;
    }

    @InterfaceC5816d
    public static final Buffer commonWriteHexadecimalUnsignedLong(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonWriteHexadecimalUnsignedLong");
        if (j2 == 0) {
            return buffer.writeByte(48);
        }
        long j3 = (j2 >>> 1) | j2;
        long j4 = j3 | (j3 >>> 2);
        long j5 = j4 | (j4 >>> 4);
        long j6 = j5 | (j5 >>> 8);
        long j7 = j6 | (j6 >>> 16);
        long j8 = j7 | (j7 >>> 32);
        long j9 = j8 - ((j8 >>> 1) & 6148914691236517205L);
        long j10 = ((j9 >>> 2) & 3689348814741910323L) + (j9 & 3689348814741910323L);
        long j11 = ((j10 >>> 4) + j10) & 1085102592571150095L;
        long j12 = j11 + (j11 >>> 8);
        long j13 = j12 + (j12 >>> 16);
        int i2 = (int) ((((j13 & 63) + ((j13 >>> 32) & 63)) + 3) / 4);
        Segment writableSegment$okio = buffer.writableSegment$okio(i2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        for (int i4 = (i3 + i2) - 1; i4 >= i3; i4--) {
            bArr[i4] = getHEX_DIGIT_BYTES()[(int) (15 & j2)];
            j2 >>>= 4;
        }
        writableSegment$okio.limit += i2;
        buffer.setSize$okio(buffer.size() + i2);
        return buffer;
    }

    @InterfaceC5816d
    public static final Buffer commonWriteInt(@InterfaceC5816d Buffer buffer, int i2) {
        C5544i0.m22546f(buffer, "$this$commonWriteInt");
        Segment writableSegment$okio = buffer.writableSegment$okio(4);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 24) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((i2 >>> 16) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((i2 >>> 8) & 255);
        bArr[i6] = (byte) (i2 & 255);
        writableSegment$okio.limit = i6 + 1;
        buffer.setSize$okio(buffer.size() + 4);
        return buffer;
    }

    @InterfaceC5816d
    public static final Buffer commonWriteLong(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonWriteLong");
        Segment writableSegment$okio = buffer.writableSegment$okio(8);
        byte[] bArr = writableSegment$okio.data;
        int i2 = writableSegment$okio.limit;
        int i3 = i2 + 1;
        bArr[i2] = (byte) ((j2 >>> 56) & 255);
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((j2 >>> 48) & 255);
        int i5 = i4 + 1;
        bArr[i4] = (byte) ((j2 >>> 40) & 255);
        int i6 = i5 + 1;
        bArr[i5] = (byte) ((j2 >>> 32) & 255);
        int i7 = i6 + 1;
        bArr[i6] = (byte) ((j2 >>> 24) & 255);
        int i8 = i7 + 1;
        bArr[i7] = (byte) ((j2 >>> 16) & 255);
        int i9 = i8 + 1;
        bArr[i8] = (byte) ((j2 >>> 8) & 255);
        bArr[i9] = (byte) (j2 & 255);
        writableSegment$okio.limit = i9 + 1;
        buffer.setSize$okio(buffer.size() + 8);
        return buffer;
    }

    @InterfaceC5816d
    public static final Buffer commonWriteShort(@InterfaceC5816d Buffer buffer, int i2) {
        C5544i0.m22546f(buffer, "$this$commonWriteShort");
        Segment writableSegment$okio = buffer.writableSegment$okio(2);
        byte[] bArr = writableSegment$okio.data;
        int i3 = writableSegment$okio.limit;
        int i4 = i3 + 1;
        bArr[i3] = (byte) ((i2 >>> 8) & 255);
        bArr[i4] = (byte) (i2 & 255);
        writableSegment$okio.limit = i4 + 1;
        buffer.setSize$okio(buffer.size() + 2);
        return buffer;
    }

    @InterfaceC5816d
    public static final Buffer commonWriteUtf8(@InterfaceC5816d Buffer buffer, @InterfaceC5816d String str, int i2, int i3) {
        C5544i0.m22546f(buffer, "$this$commonWriteUtf8");
        C5544i0.m22546f(str, "string");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex < 0: " + i2).toString());
        }
        if (!(i3 >= i2)) {
            throw new IllegalArgumentException(("endIndex < beginIndex: " + i3 + " < " + i2).toString());
        }
        if (!(i3 <= str.length())) {
            throw new IllegalArgumentException(("endIndex > string.length: " + i3 + " > " + str.length()).toString());
        }
        while (i2 < i3) {
            char charAt = str.charAt(i2);
            if (charAt < 128) {
                Segment writableSegment$okio = buffer.writableSegment$okio(1);
                byte[] bArr = writableSegment$okio.data;
                int i4 = writableSegment$okio.limit - i2;
                int min = Math.min(i3, 8192 - i4);
                int i5 = i2 + 1;
                bArr[i2 + i4] = (byte) charAt;
                while (i5 < min) {
                    char charAt2 = str.charAt(i5);
                    if (charAt2 >= 128) {
                        break;
                    }
                    bArr[i5 + i4] = (byte) charAt2;
                    i5++;
                }
                int i6 = writableSegment$okio.limit;
                int i7 = (i4 + i5) - i6;
                writableSegment$okio.limit = i6 + i7;
                buffer.setSize$okio(buffer.size() + i7);
                i2 = i5;
            } else {
                if (charAt < 2048) {
                    Segment writableSegment$okio2 = buffer.writableSegment$okio(2);
                    byte[] bArr2 = writableSegment$okio2.data;
                    int i8 = writableSegment$okio2.limit;
                    bArr2[i8] = (byte) ((charAt >> 6) | 192);
                    bArr2[i8 + 1] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio2.limit = i8 + 2;
                    buffer.setSize$okio(buffer.size() + 2);
                } else if (charAt < 55296 || charAt > 57343) {
                    Segment writableSegment$okio3 = buffer.writableSegment$okio(3);
                    byte[] bArr3 = writableSegment$okio3.data;
                    int i9 = writableSegment$okio3.limit;
                    bArr3[i9] = (byte) ((charAt >> '\f') | 224);
                    bArr3[i9 + 1] = (byte) ((63 & (charAt >> 6)) | 128);
                    bArr3[i9 + 2] = (byte) ((charAt & '?') | 128);
                    writableSegment$okio3.limit = i9 + 3;
                    buffer.setSize$okio(buffer.size() + 3);
                } else {
                    int i10 = i2 + 1;
                    char charAt3 = i10 < i3 ? str.charAt(i10) : (char) 0;
                    if (charAt > 56319 || 56320 > charAt3 || 57343 < charAt3) {
                        buffer.writeByte(63);
                        i2 = i10;
                    } else {
                        int i11 = (((charAt & 1023) << 10) | (charAt3 & 1023)) + 65536;
                        Segment writableSegment$okio4 = buffer.writableSegment$okio(4);
                        byte[] bArr4 = writableSegment$okio4.data;
                        int i12 = writableSegment$okio4.limit;
                        bArr4[i12] = (byte) ((i11 >> 18) | 240);
                        bArr4[i12 + 1] = (byte) (((i11 >> 12) & 63) | 128);
                        bArr4[i12 + 2] = (byte) (((i11 >> 6) & 63) | 128);
                        bArr4[i12 + 3] = (byte) ((i11 & 63) | 128);
                        writableSegment$okio4.limit = i12 + 4;
                        buffer.setSize$okio(buffer.size() + 4);
                        i2 += 2;
                    }
                }
                i2++;
            }
        }
        return buffer;
    }

    @InterfaceC5816d
    public static final Buffer commonWriteUtf8CodePoint(@InterfaceC5816d Buffer buffer, int i2) {
        C5544i0.m22546f(buffer, "$this$commonWriteUtf8CodePoint");
        if (i2 < 128) {
            buffer.writeByte(i2);
        } else if (i2 < 2048) {
            Segment writableSegment$okio = buffer.writableSegment$okio(2);
            byte[] bArr = writableSegment$okio.data;
            int i3 = writableSegment$okio.limit;
            bArr[i3] = (byte) ((i2 >> 6) | 192);
            bArr[i3 + 1] = (byte) ((i2 & 63) | 128);
            writableSegment$okio.limit = i3 + 2;
            buffer.setSize$okio(buffer.size() + 2);
        } else if (55296 <= i2 && 57343 >= i2) {
            buffer.writeByte(63);
        } else if (i2 < 65536) {
            Segment writableSegment$okio2 = buffer.writableSegment$okio(3);
            byte[] bArr2 = writableSegment$okio2.data;
            int i4 = writableSegment$okio2.limit;
            bArr2[i4] = (byte) ((i2 >> 12) | 224);
            bArr2[i4 + 1] = (byte) (((i2 >> 6) & 63) | 128);
            bArr2[i4 + 2] = (byte) ((i2 & 63) | 128);
            writableSegment$okio2.limit = i4 + 3;
            buffer.setSize$okio(buffer.size() + 3);
        } else {
            if (i2 > 1114111) {
                throw new IllegalArgumentException("Unexpected code point: 0x" + Util.toHexString(i2));
            }
            Segment writableSegment$okio3 = buffer.writableSegment$okio(4);
            byte[] bArr3 = writableSegment$okio3.data;
            int i5 = writableSegment$okio3.limit;
            bArr3[i5] = (byte) ((i2 >> 18) | 240);
            bArr3[i5 + 1] = (byte) (((i2 >> 12) & 63) | 128);
            bArr3[i5 + 2] = (byte) (((i2 >> 6) & 63) | 128);
            bArr3[i5 + 3] = (byte) ((i2 & 63) | 128);
            writableSegment$okio3.limit = i5 + 4;
            buffer.setSize$okio(buffer.size() + 4);
        }
        return buffer;
    }

    @InterfaceC5816d
    public static final byte[] getHEX_DIGIT_BYTES() {
        return HEX_DIGIT_BYTES;
    }

    public static final boolean rangeEquals(@InterfaceC5816d Segment segment, int i2, @InterfaceC5816d byte[] bArr, int i3, int i4) {
        C5544i0.m22546f(segment, "segment");
        C5544i0.m22546f(bArr, "bytes");
        int i5 = segment.limit;
        byte[] bArr2 = segment.data;
        while (i3 < i4) {
            if (i2 == i5) {
                segment = segment.next;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                byte[] bArr3 = segment.data;
                bArr2 = bArr3;
                i2 = segment.pos;
                i5 = segment.limit;
            }
            if (bArr2[i2] != bArr[i3]) {
                return false;
            }
            i2++;
            i3++;
        }
        return true;
    }

    @InterfaceC5816d
    public static final String readUtf8Line(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$readUtf8Line");
        if (j2 > 0) {
            long j3 = j2 - 1;
            if (buffer.getByte(j3) == ((byte) 13)) {
                String readUtf8 = buffer.readUtf8(j3);
                buffer.skip(2L);
                return readUtf8;
            }
        }
        String readUtf82 = buffer.readUtf8(j2);
        buffer.skip(1L);
        return readUtf82;
    }

    public static final <T> T seek(@InterfaceC5816d Buffer buffer, long j2, @InterfaceC5816d InterfaceC5510p<? super Segment, ? super Long, ? extends T> interfaceC5510p) {
        C5544i0.m22546f(buffer, "$this$seek");
        C5544i0.m22546f(interfaceC5510p, "lambda");
        Segment segment = buffer.head;
        if (segment == null) {
            return interfaceC5510p.invoke(null, -1L);
        }
        if (buffer.size() - j2 < j2) {
            long size = buffer.size();
            while (size > j2) {
                segment = segment.prev;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                size -= segment.limit - segment.pos;
            }
            return interfaceC5510p.invoke(segment, Long.valueOf(size));
        }
        long j3 = 0;
        while (true) {
            long j4 = (segment.limit - segment.pos) + j3;
            if (j4 > j2) {
                return interfaceC5510p.invoke(segment, Long.valueOf(j3));
            }
            segment = segment.next;
            if (segment == null) {
                C5544i0.m22545f();
            }
            j3 = j4;
        }
    }

    public static final int selectPrefix(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Options options, boolean z) {
        int i2;
        int i3;
        C5544i0.m22546f(buffer, "$this$selectPrefix");
        C5544i0.m22546f(options, "options");
        Segment segment = buffer.head;
        if (segment == null) {
            return z ? -2 : -1;
        }
        byte[] bArr = segment.data;
        int i4 = segment.pos;
        int i5 = segment.limit;
        int[] trie$okio = options.getTrie$okio();
        int i6 = i4;
        int i7 = i5;
        int i8 = -1;
        Segment segment2 = segment;
        byte[] bArr2 = bArr;
        int i9 = 0;
        loop0: while (true) {
            int i10 = i9 + 1;
            int i11 = trie$okio[i9];
            int i12 = i10 + 1;
            int i13 = trie$okio[i10];
            if (i13 != -1) {
                i8 = i13;
            }
            if (segment2 == null) {
                break;
            }
            if (i11 >= 0) {
                i2 = i6 + 1;
                int i14 = bArr2[i6] & C5230f1.f20085c;
                int i15 = i12 + i11;
                while (i12 != i15) {
                    if (i14 == trie$okio[i12]) {
                        i3 = trie$okio[i12 + i11];
                        if (i2 == i7) {
                            Segment segment3 = segment2.next;
                            if (segment3 == null) {
                                C5544i0.m22545f();
                            }
                            int i16 = segment3.pos;
                            bArr2 = segment3.data;
                            i7 = segment3.limit;
                            i2 = i16;
                            segment2 = segment3 == segment ? null : segment3;
                        }
                    } else {
                        i12++;
                    }
                }
                return i8;
            }
            int i17 = i12 + (i11 * (-1));
            while (true) {
                int i18 = i6 + 1;
                int i19 = i12 + 1;
                if ((bArr2[i6] & C5230f1.f20085c) != trie$okio[i12]) {
                    return i8;
                }
                boolean z2 = i19 == i17;
                if (i18 == i7) {
                    if (segment2 == null) {
                        C5544i0.m22545f();
                    }
                    Segment segment4 = segment2.next;
                    if (segment4 == null) {
                        C5544i0.m22545f();
                    }
                    int i20 = segment4.pos;
                    bArr2 = segment4.data;
                    i7 = segment4.limit;
                    if (segment4 != segment) {
                        segment2 = segment4;
                        i18 = i20;
                    } else {
                        if (!z2) {
                            break loop0;
                        }
                        i18 = i20;
                        segment2 = null;
                    }
                }
                if (z2) {
                    i3 = trie$okio[i19];
                    i2 = i18;
                    break;
                }
                i6 = i18;
                i12 = i19;
            }
            if (i3 >= 0) {
                return i3;
            }
            i9 = -i3;
            i6 = i2;
        }
        if (z) {
            return -2;
        }
        return i8;
    }

    public static /* synthetic */ int selectPrefix$default(Buffer buffer, Options options, boolean z, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z = false;
        }
        return selectPrefix(buffer, options, z);
    }

    public static final int commonRead(@InterfaceC5816d Buffer buffer, @InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(buffer, "$this$commonRead");
        C5544i0.m22546f(bArr, "sink");
        Util.checkOffsetAndCount(bArr.length, i2, i3);
        Segment segment = buffer.head;
        if (segment == null) {
            return -1;
        }
        int min = Math.min(i3, segment.limit - segment.pos);
        byte[] bArr2 = segment.data;
        int i4 = segment.pos;
        C5291q.m20196a(bArr2, bArr, i2, i4, i4 + min);
        segment.pos += min;
        buffer.setSize$okio(buffer.size() - min);
        if (segment.pos == segment.limit) {
            buffer.head = segment.pop();
            SegmentPool.INSTANCE.recycle(segment);
        }
        return min;
    }

    @InterfaceC5816d
    public static final byte[] commonReadByteArray(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonReadByteArray");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (buffer.size() < j2) {
            throw new EOFException();
        }
        byte[] bArr = new byte[(int) j2];
        buffer.readFully(bArr);
        return bArr;
    }

    @InterfaceC5816d
    public static final ByteString commonReadByteString(@InterfaceC5816d Buffer buffer, long j2) {
        C5544i0.m22546f(buffer, "$this$commonReadByteString");
        if (!(j2 >= 0 && j2 <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException(("byteCount: " + j2).toString());
        }
        if (buffer.size() < j2) {
            throw new EOFException();
        }
        if (j2 < 4096) {
            return new ByteString(buffer.readByteArray(j2));
        }
        ByteString snapshot = buffer.snapshot((int) j2);
        buffer.skip(j2);
        return snapshot;
    }

    @InterfaceC5816d
    public static final Buffer commonWrite(@InterfaceC5816d Buffer buffer, @InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(buffer, "$this$commonWrite");
        C5544i0.m22546f(bArr, "source");
        return buffer.write(bArr, 0, bArr.length);
    }

    @InterfaceC5816d
    public static final Buffer commonWrite(@InterfaceC5816d Buffer buffer, @InterfaceC5816d byte[] bArr, int i2, int i3) {
        C5544i0.m22546f(buffer, "$this$commonWrite");
        C5544i0.m22546f(bArr, "source");
        long j2 = i3;
        Util.checkOffsetAndCount(bArr.length, i2, j2);
        int i4 = i3 + i2;
        while (i2 < i4) {
            Segment writableSegment$okio = buffer.writableSegment$okio(1);
            int min = Math.min(i4 - i2, 8192 - writableSegment$okio.limit);
            int i5 = i2 + min;
            C5291q.m20196a(bArr, writableSegment$okio.data, writableSegment$okio.limit, i2, i5);
            writableSegment$okio.limit += min;
            i2 = i5;
        }
        buffer.setSize$okio(buffer.size() + j2);
        return buffer;
    }

    public static final void commonReadFully(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Buffer buffer2, long j2) {
        C5544i0.m22546f(buffer, "$this$commonReadFully");
        C5544i0.m22546f(buffer2, "sink");
        if (buffer.size() >= j2) {
            buffer2.write(buffer, j2);
        } else {
            buffer2.write(buffer, buffer.size());
            throw new EOFException();
        }
    }

    @InterfaceC5816d
    public static final ByteString commonSnapshot(@InterfaceC5816d Buffer buffer, int i2) {
        C5544i0.m22546f(buffer, "$this$commonSnapshot");
        if (i2 == 0) {
            return ByteString.EMPTY;
        }
        Util.checkOffsetAndCount(buffer.size(), 0L, i2);
        int i3 = 0;
        Segment segment = buffer.head;
        int i4 = 0;
        int i5 = 0;
        while (i4 < i2) {
            if (segment == null) {
                C5544i0.m22545f();
            }
            int i6 = segment.limit;
            int i7 = segment.pos;
            if (i6 != i7) {
                i4 += i6 - i7;
                i5++;
                segment = segment.next;
            } else {
                throw new AssertionError("s.limit == s.pos");
            }
        }
        byte[][] bArr = new byte[i5][];
        int[] iArr = new int[i5 * 2];
        Segment segment2 = buffer.head;
        int i8 = 0;
        while (i3 < i2) {
            if (segment2 == null) {
                C5544i0.m22545f();
            }
            bArr[i8] = segment2.data;
            i3 += segment2.limit - segment2.pos;
            iArr[i8] = Math.min(i3, i2);
            iArr[bArr.length + i8] = segment2.pos;
            segment2.shared = true;
            i8++;
            segment2 = segment2.next;
        }
        return new SegmentedByteString(bArr, iArr);
    }

    @InterfaceC5816d
    public static final Buffer commonWrite(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Source source, long j2) {
        C5544i0.m22546f(buffer, "$this$commonWrite");
        C5544i0.m22546f(source, "source");
        while (j2 > 0) {
            long read = source.read(buffer, j2);
            if (read == -1) {
                throw new EOFException();
            }
            j2 -= read;
        }
        return buffer;
    }

    public static final long commonRead(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Buffer buffer2, long j2) {
        C5544i0.m22546f(buffer, "$this$commonRead");
        C5544i0.m22546f(buffer2, "sink");
        if (!(j2 >= 0)) {
            throw new IllegalArgumentException(("byteCount < 0: " + j2).toString());
        }
        if (buffer.size() == 0) {
            return -1L;
        }
        if (j2 > buffer.size()) {
            j2 = buffer.size();
        }
        buffer2.write(buffer, j2);
        return j2;
    }

    public static final void commonWrite(@InterfaceC5816d Buffer buffer, @InterfaceC5816d Buffer buffer2, long j2) {
        Segment segment;
        C5544i0.m22546f(buffer, "$this$commonWrite");
        C5544i0.m22546f(buffer2, "source");
        if (buffer2 != buffer) {
            Util.checkOffsetAndCount(buffer2.size(), 0L, j2);
            while (j2 > 0) {
                Segment segment2 = buffer2.head;
                if (segment2 == null) {
                    C5544i0.m22545f();
                }
                int i2 = segment2.limit;
                if (buffer2.head == null) {
                    C5544i0.m22545f();
                }
                if (j2 < i2 - r2.pos) {
                    Segment segment3 = buffer.head;
                    if (segment3 != null) {
                        if (segment3 == null) {
                            C5544i0.m22545f();
                        }
                        segment = segment3.prev;
                    } else {
                        segment = null;
                    }
                    if (segment != null && segment.owner) {
                        if ((segment.limit + j2) - (segment.shared ? 0 : segment.pos) <= 8192) {
                            Segment segment4 = buffer2.head;
                            if (segment4 == null) {
                                C5544i0.m22545f();
                            }
                            segment4.writeTo(segment, (int) j2);
                            buffer2.setSize$okio(buffer2.size() - j2);
                            buffer.setSize$okio(buffer.size() + j2);
                            return;
                        }
                    }
                    Segment segment5 = buffer2.head;
                    if (segment5 == null) {
                        C5544i0.m22545f();
                    }
                    buffer2.head = segment5.split((int) j2);
                }
                Segment segment6 = buffer2.head;
                if (segment6 == null) {
                    C5544i0.m22545f();
                }
                long j3 = segment6.limit - segment6.pos;
                buffer2.head = segment6.pop();
                Segment segment7 = buffer.head;
                if (segment7 == null) {
                    buffer.head = segment6;
                    segment6.prev = segment6;
                    segment6.next = segment6.prev;
                } else {
                    if (segment7 == null) {
                        C5544i0.m22545f();
                    }
                    Segment segment8 = segment7.prev;
                    if (segment8 == null) {
                        C5544i0.m22545f();
                    }
                    segment8.push(segment6).compact();
                }
                buffer2.setSize$okio(buffer2.size() - j3);
                buffer.setSize$okio(buffer.size() + j3);
                j2 -= j3;
            }
            return;
        }
        throw new IllegalArgumentException("source == this".toString());
    }

    public static final long commonIndexOf(@InterfaceC5816d Buffer buffer, @InterfaceC5816d ByteString byteString, long j2) {
        long j3 = j2;
        C5544i0.m22546f(buffer, "$this$commonIndexOf");
        C5544i0.m22546f(byteString, "bytes");
        if (!(byteString.size() > 0)) {
            throw new IllegalArgumentException("bytes is empty".toString());
        }
        long j4 = 0;
        if (j3 >= 0) {
            Segment segment = buffer.head;
            if (segment == null) {
                return -1L;
            }
            if (buffer.size() - j3 < j3) {
                long size = buffer.size();
                while (size > j3) {
                    segment = segment.prev;
                    if (segment == null) {
                        C5544i0.m22545f();
                    }
                    size -= segment.limit - segment.pos;
                }
                if (segment == null) {
                    return -1L;
                }
                byte[] internalArray$okio = byteString.internalArray$okio();
                byte b2 = internalArray$okio[0];
                int size2 = byteString.size();
                long size3 = (buffer.size() - size2) + 1;
                while (size < size3) {
                    byte[] bArr = segment.data;
                    int min = (int) Math.min(segment.limit, (segment.pos + size3) - size);
                    for (int i2 = (int) ((segment.pos + j3) - size); i2 < min; i2++) {
                        if (bArr[i2] == b2 && rangeEquals(segment, i2 + 1, internalArray$okio, 1, size2)) {
                            return (i2 - segment.pos) + size;
                        }
                    }
                    j3 = size + (segment.limit - segment.pos);
                    segment = segment.next;
                    if (segment == null) {
                        C5544i0.m22545f();
                    }
                    size = j3;
                }
                return -1L;
            }
            while (true) {
                long j5 = (segment.limit - segment.pos) + j4;
                if (j5 > j3) {
                    break;
                }
                segment = segment.next;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                j4 = j5;
            }
            if (segment == null) {
                return -1L;
            }
            byte[] internalArray$okio2 = byteString.internalArray$okio();
            byte b3 = internalArray$okio2[0];
            int size4 = byteString.size();
            long j6 = j4;
            long size5 = (buffer.size() - size4) + 1;
            while (j6 < size5) {
                byte[] bArr2 = segment.data;
                int min2 = (int) Math.min(segment.limit, (segment.pos + size5) - j6);
                for (int i3 = (int) ((segment.pos + j3) - j6); i3 < min2; i3++) {
                    if (bArr2[i3] == b3 && rangeEquals(segment, i3 + 1, internalArray$okio2, 1, size4)) {
                        return (i3 - segment.pos) + j6;
                    }
                }
                j3 = j6 + (segment.limit - segment.pos);
                segment = segment.next;
                if (segment == null) {
                    C5544i0.m22545f();
                }
                j6 = j3;
            }
            return -1L;
        }
        throw new IllegalArgumentException(("fromIndex < 0: " + j3).toString());
    }
}
