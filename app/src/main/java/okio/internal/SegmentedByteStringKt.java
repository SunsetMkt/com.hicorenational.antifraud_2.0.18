package okio.internal;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import okio.Buffer;
import okio.ByteString;
import okio.Segment;
import okio.SegmentedByteString;
import okio.Util;
import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p289g2.C5282n;
import p286h.p289g2.C5291q;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SegmentedByteString.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000R\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0005\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012\u0006\u0010\u0005\u001a\u00020\u0001H\u0000\u001a\u0017\u0010\u0006\u001a\u00020\u0007*\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0080\b\u001a\r\u0010\u000b\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\r\u0010\f\u001a\u00020\u0001*\u00020\bH\u0080\b\u001a\u0015\u0010\r\u001a\u00020\u000e*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a-\u0010\u0010\u001a\u00020\u0007*\u00020\b2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00152\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001a\u001d\u0010\u0016\u001a\u00020\u0015*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u0001H\u0080\b\u001a\r\u0010\u0019\u001a\u00020\u0012*\u00020\bH\u0080\b\u001a%\u0010\u001a\u001a\u00020\u001b*\u00020\b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0011\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u0001H\u0080\b\u001aZ\u0010\u001e\u001a\u00020\u001b*\u00020\b2K\u0010\u001f\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001b0 H\u0080\b\u001aj\u0010\u001e\u001a\u00020\u001b*\u00020\b2\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00012K\u0010\u001f\u001aG\u0012\u0013\u0012\u00110\u0012¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(#\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0011\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b!\u0012\b\b\"\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u001b0 H\u0082\b\u001a\u0014\u0010$\u001a\u00020\u0001*\u00020\b2\u0006\u0010\u000f\u001a\u00020\u0001H\u0000¨\u0006%"}, m23546d2 = {"binarySearch", "", "", SurveyH5Bean.VALUE, "fromIndex", "toIndex", "commonEquals", "", "Lokio/SegmentedByteString;", DispatchConstants.OTHER, "", "commonGetSize", "commonHashCode", "commonInternalGet", "", "pos", "commonRangeEquals", "offset", "", "otherOffset", "byteCount", "Lokio/ByteString;", "commonSubstring", "beginIndex", "endIndex", "commonToByteArray", "commonWrite", "", "buffer", "Lokio/Buffer;", "forEachSegment", "action", "Lkotlin/Function3;", "Lkotlin/ParameterName;", CommonNetImpl.NAME, "data", "segment", "okio"}, m23547k = 2, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SegmentedByteStringKt {
    public static final int binarySearch(@InterfaceC5816d int[] iArr, int i2, int i3, int i4) {
        C5544i0.m22546f(iArr, "$this$binarySearch");
        int i5 = i4 - 1;
        while (i3 <= i5) {
            int i6 = (i3 + i5) >>> 1;
            int i7 = iArr[i6];
            if (i7 < i2) {
                i3 = i6 + 1;
            } else {
                if (i7 <= i2) {
                    return i6;
                }
                i5 = i6 - 1;
            }
        }
        return (-i3) - 1;
    }

    public static final boolean commonEquals(@InterfaceC5816d SegmentedByteString segmentedByteString, @InterfaceC5817e Object obj) {
        C5544i0.m22546f(segmentedByteString, "$this$commonEquals");
        if (obj == segmentedByteString) {
            return true;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            if (byteString.size() == segmentedByteString.size() && segmentedByteString.rangeEquals(0, byteString, 0, segmentedByteString.size())) {
                return true;
            }
        }
        return false;
    }

    public static final int commonGetSize(@InterfaceC5816d SegmentedByteString segmentedByteString) {
        C5544i0.m22546f(segmentedByteString, "$this$commonGetSize");
        return segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1];
    }

    public static final int commonHashCode(@InterfaceC5816d SegmentedByteString segmentedByteString) {
        C5544i0.m22546f(segmentedByteString, "$this$commonHashCode");
        int hashCode$okio = segmentedByteString.getHashCode$okio();
        if (hashCode$okio != 0) {
            return hashCode$okio;
        }
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 1;
        int i4 = 0;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory$okio()[length + i2];
            int i6 = segmentedByteString.getDirectory$okio()[i2];
            byte[] bArr = segmentedByteString.getSegments$okio()[i2];
            int i7 = (i6 - i4) + i5;
            while (i5 < i7) {
                i3 = (i3 * 31) + bArr[i5];
                i5++;
            }
            i2++;
            i4 = i6;
        }
        segmentedByteString.setHashCode$okio(i3);
        return i3;
    }

    public static final byte commonInternalGet(@InterfaceC5816d SegmentedByteString segmentedByteString, int i2) {
        C5544i0.m22546f(segmentedByteString, "$this$commonInternalGet");
        Util.checkOffsetAndCount(segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length - 1], i2, 1L);
        int segment = segment(segmentedByteString, i2);
        return segmentedByteString.getSegments$okio()[segment][(i2 - (segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1])) + segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment]];
    }

    public static final boolean commonRangeEquals(@InterfaceC5816d SegmentedByteString segmentedByteString, int i2, @InterfaceC5816d ByteString byteString, int i3, int i4) {
        C5544i0.m22546f(segmentedByteString, "$this$commonRangeEquals");
        C5544i0.m22546f(byteString, DispatchConstants.OTHER);
        if (i2 < 0 || i2 > segmentedByteString.size() - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int segment = segment(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i7 = segmentedByteString.getDirectory$okio()[segment] - i6;
            int i8 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i5, i7 + i6) - i2;
            if (!byteString.rangeEquals(i3, segmentedByteString.getSegments$okio()[segment], i8 + (i2 - i6), min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            segment++;
        }
        return true;
    }

    @InterfaceC5816d
    public static final ByteString commonSubstring(@InterfaceC5816d SegmentedByteString segmentedByteString, int i2, int i3) {
        C5544i0.m22546f(segmentedByteString, "$this$commonSubstring");
        if (!(i2 >= 0)) {
            throw new IllegalArgumentException(("beginIndex=" + i2 + " < 0").toString());
        }
        if (!(i3 <= segmentedByteString.size())) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " > length(" + segmentedByteString.size() + ')').toString());
        }
        int i4 = i3 - i2;
        if (!(i4 >= 0)) {
            throw new IllegalArgumentException(("endIndex=" + i3 + " < beginIndex=" + i2).toString());
        }
        if (i2 == 0 && i3 == segmentedByteString.size()) {
            return segmentedByteString;
        }
        if (i2 == i3) {
            return ByteString.EMPTY;
        }
        int segment = segment(segmentedByteString, i2);
        int segment2 = segment(segmentedByteString, i3 - 1);
        byte[][] bArr = (byte[][]) C5282n.m20058a(segmentedByteString.getSegments$okio(), segment, segment2 + 1);
        int[] iArr = new int[bArr.length * 2];
        if (segment <= segment2) {
            int i5 = segment;
            int i6 = 0;
            while (true) {
                iArr[i6] = Math.min(segmentedByteString.getDirectory$okio()[i5] - i2, i4);
                int i7 = i6 + 1;
                iArr[i6 + bArr.length] = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + i5];
                if (i5 == segment2) {
                    break;
                }
                i5++;
                i6 = i7;
            }
        }
        int i8 = segment != 0 ? segmentedByteString.getDirectory$okio()[segment - 1] : 0;
        int length = bArr.length;
        iArr[length] = iArr[length] + (i2 - i8);
        return new SegmentedByteString(bArr, iArr);
    }

    @InterfaceC5816d
    public static final byte[] commonToByteArray(@InterfaceC5816d SegmentedByteString segmentedByteString) {
        C5544i0.m22546f(segmentedByteString, "$this$commonToByteArray");
        byte[] bArr = new byte[segmentedByteString.size()];
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        while (i2 < length) {
            int i5 = segmentedByteString.getDirectory$okio()[length + i2];
            int i6 = segmentedByteString.getDirectory$okio()[i2];
            int i7 = i6 - i3;
            C5291q.m20196a(segmentedByteString.getSegments$okio()[i2], bArr, i4, i5, i5 + i7);
            i4 += i7;
            i2++;
            i3 = i6;
        }
        return bArr;
    }

    public static final void commonWrite(@InterfaceC5816d SegmentedByteString segmentedByteString, @InterfaceC5816d Buffer buffer, int i2, int i3) {
        C5544i0.m22546f(segmentedByteString, "$this$commonWrite");
        C5544i0.m22546f(buffer, "buffer");
        int i4 = i3 + i2;
        int segment = segment(segmentedByteString, i2);
        while (i2 < i4) {
            int i5 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i6 = segmentedByteString.getDirectory$okio()[segment] - i5;
            int i7 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i4, i6 + i5) - i2;
            int i8 = i7 + (i2 - i5);
            Segment segment2 = new Segment(segmentedByteString.getSegments$okio()[segment], i8, i8 + min, true, false);
            Segment segment3 = buffer.head;
            if (segment3 == null) {
                segment2.prev = segment2;
                segment2.next = segment2.prev;
                buffer.head = segment2.next;
            } else {
                if (segment3 == null) {
                    C5544i0.m22545f();
                }
                Segment segment4 = segment3.prev;
                if (segment4 == null) {
                    C5544i0.m22545f();
                }
                segment4.push(segment2);
            }
            i2 += min;
            segment++;
        }
        buffer.setSize$okio(buffer.size() + segmentedByteString.size());
    }

    public static final void forEachSegment(@InterfaceC5816d SegmentedByteString segmentedByteString, @InterfaceC5816d InterfaceC5511q<? super byte[], ? super Integer, ? super Integer, C5715y1> interfaceC5511q) {
        C5544i0.m22546f(segmentedByteString, "$this$forEachSegment");
        C5544i0.m22546f(interfaceC5511q, "action");
        int length = segmentedByteString.getSegments$okio().length;
        int i2 = 0;
        int i3 = 0;
        while (i2 < length) {
            int i4 = segmentedByteString.getDirectory$okio()[length + i2];
            int i5 = segmentedByteString.getDirectory$okio()[i2];
            interfaceC5511q.invoke(segmentedByteString.getSegments$okio()[i2], Integer.valueOf(i4), Integer.valueOf(i5 - i3));
            i2++;
            i3 = i5;
        }
    }

    public static final int segment(@InterfaceC5816d SegmentedByteString segmentedByteString, int i2) {
        C5544i0.m22546f(segmentedByteString, "$this$segment");
        int binarySearch = binarySearch(segmentedByteString.getDirectory$okio(), i2 + 1, 0, segmentedByteString.getSegments$okio().length);
        return binarySearch >= 0 ? binarySearch : ~binarySearch;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void forEachSegment(@InterfaceC5816d SegmentedByteString segmentedByteString, int i2, int i3, InterfaceC5511q<? super byte[], ? super Integer, ? super Integer, C5715y1> interfaceC5511q) {
        int segment = segment(segmentedByteString, i2);
        while (i2 < i3) {
            int i4 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i5 = segmentedByteString.getDirectory$okio()[segment] - i4;
            int i6 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i3, i5 + i4) - i2;
            interfaceC5511q.invoke(segmentedByteString.getSegments$okio()[segment], Integer.valueOf(i6 + (i2 - i4)), Integer.valueOf(min));
            i2 += min;
            segment++;
        }
    }

    public static final boolean commonRangeEquals(@InterfaceC5816d SegmentedByteString segmentedByteString, int i2, @InterfaceC5816d byte[] bArr, int i3, int i4) {
        C5544i0.m22546f(segmentedByteString, "$this$commonRangeEquals");
        C5544i0.m22546f(bArr, DispatchConstants.OTHER);
        if (i2 < 0 || i2 > segmentedByteString.size() - i4 || i3 < 0 || i3 > bArr.length - i4) {
            return false;
        }
        int i5 = i4 + i2;
        int segment = segment(segmentedByteString, i2);
        while (i2 < i5) {
            int i6 = segment == 0 ? 0 : segmentedByteString.getDirectory$okio()[segment - 1];
            int i7 = segmentedByteString.getDirectory$okio()[segment] - i6;
            int i8 = segmentedByteString.getDirectory$okio()[segmentedByteString.getSegments$okio().length + segment];
            int min = Math.min(i5, i7 + i6) - i2;
            if (!Util.arrayRangeEquals(segmentedByteString.getSegments$okio()[segment], i8 + (i2 - i6), bArr, i3, min)) {
                return false;
            }
            i3 += min;
            i2 += min;
            segment++;
        }
        return true;
    }
}
