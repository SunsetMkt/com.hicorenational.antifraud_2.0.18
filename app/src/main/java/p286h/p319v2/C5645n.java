package p286h.p319v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Ranges.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0015B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\b\u0010\u0013\u001a\u00020\u0014H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0016"}, m23546d2 = {"Lkotlin/ranges/LongRange;", "Lkotlin/ranges/LongProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(JJ)V", "getEndInclusive", "()Ljava/lang/Long;", "getStart", "contains", "", SurveyH5Bean.VALUE, "equals", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.v2.n */
/* loaded from: classes2.dex */
public final class C5645n extends C5643l implements InterfaceC5638g<Long> {

    /* renamed from: f */
    public static final a f20529f = new a(null);

    /* renamed from: e */
    @InterfaceC5816d
    private static final C5645n f20528e = new C5645n(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: h.v2.n$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5645n m23032a() {
            return C5645n.f20528e;
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public C5645n(long j2, long j3) {
        super(j2, j3, 1L);
    }

    /* renamed from: a */
    public boolean m23031a(long j2) {
        return getFirst() <= j2 && j2 <= getLast();
    }

    @Override // p286h.p319v2.InterfaceC5638g
    public /* bridge */ /* synthetic */ boolean contains(Long l2) {
        return m23031a(l2.longValue());
    }

    @Override // p286h.p319v2.C5643l
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5645n) {
            if (!isEmpty() || !((C5645n) obj).isEmpty()) {
                C5645n c5645n = (C5645n) obj;
                if (getFirst() != c5645n.getFirst() || getLast() != c5645n.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p286h.p319v2.C5643l
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (int) ((31 * (getFirst() ^ (getFirst() >>> 32))) + (getLast() ^ (getLast() >>> 32)));
    }

    @Override // p286h.p319v2.C5643l, p286h.p319v2.InterfaceC5638g
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // p286h.p319v2.C5643l
    @InterfaceC5816d
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Long getEndInclusive() {
        return Long.valueOf(getLast());
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Long getStart() {
        return Long.valueOf(getFirst());
    }
}
