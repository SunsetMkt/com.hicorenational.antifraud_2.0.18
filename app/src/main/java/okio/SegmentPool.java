package okio;

import p286h.C5715y1;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: SegmentPool.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000bJ\u0006\u0010\u0013\u001a\u00020\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0014"}, m23546d2 = {"Lokio/SegmentPool;", "", "()V", "MAX_SIZE", "", "byteCount", "getByteCount", "()J", "setByteCount", "(J)V", "next", "Lokio/Segment;", "getNext", "()Lokio/Segment;", "setNext", "(Lokio/Segment;)V", "recycle", "", "segment", "take", "okio"}, m23547k = 1, m23548mv = {1, 1, 16})
/* loaded from: classes2.dex */
public final class SegmentPool {
    public static final SegmentPool INSTANCE = new SegmentPool();
    public static final long MAX_SIZE = 65536;
    private static long byteCount;

    @InterfaceC5817e
    private static Segment next;

    private SegmentPool() {
    }

    public final long getByteCount() {
        return byteCount;
    }

    @InterfaceC5817e
    public final Segment getNext() {
        return next;
    }

    public final void recycle(@InterfaceC5816d Segment segment) {
        C5544i0.m22546f(segment, "segment");
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        if (segment.shared) {
            return;
        }
        synchronized (this) {
            long j2 = 8192;
            if (byteCount + j2 > 65536) {
                return;
            }
            byteCount += j2;
            segment.next = next;
            segment.limit = 0;
            segment.pos = segment.limit;
            next = segment;
            C5715y1 c5715y1 = C5715y1.f20665a;
        }
    }

    public final void setByteCount(long j2) {
        byteCount = j2;
    }

    public final void setNext(@InterfaceC5817e Segment segment) {
        next = segment;
    }

    @InterfaceC5816d
    public final Segment take() {
        synchronized (this) {
            Segment segment = next;
            if (segment == null) {
                return new Segment();
            }
            next = segment.next;
            segment.next = null;
            byteCount -= 8192;
            return segment;
        }
    }
}
