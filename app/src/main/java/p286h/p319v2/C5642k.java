package p286h.p319v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: Ranges.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0014B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006J\u0011\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002J\u0013\u0010\r\u001a\u00020\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0096\u0002J\b\u0010\u0010\u001a\u00020\u0003H\u0016J\b\u0010\u0011\u001a\u00020\u000bH\u0016J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u0014\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0014\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\b¨\u0006\u0015"}, m23546d2 = {"Lkotlin/ranges/IntRange;", "Lkotlin/ranges/IntProgression;", "Lkotlin/ranges/ClosedRange;", "", "start", "endInclusive", "(II)V", "getEndInclusive", "()Ljava/lang/Integer;", "getStart", "contains", "", SurveyH5Bean.VALUE, "equals", DispatchConstants.OTHER, "", "hashCode", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.v2.k */
/* loaded from: classes2.dex */
public final class C5642k extends C5640i implements InterfaceC5638g<Integer> {

    /* renamed from: f */
    public static final a f20519f = new a(null);

    /* renamed from: e */
    @InterfaceC5816d
    private static final C5642k f20518e = new C5642k(1, 0);

    /* compiled from: Ranges.kt */
    /* renamed from: h.v2.k$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5642k m23026a() {
            return C5642k.f20518e;
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    public C5642k(int i2, int i3) {
        super(i2, i3, 1);
    }

    /* renamed from: a */
    public boolean m23025a(int i2) {
        return getFirst() <= i2 && i2 <= getLast();
    }

    @Override // p286h.p319v2.InterfaceC5638g
    public /* bridge */ /* synthetic */ boolean contains(Integer num) {
        return m23025a(num.intValue());
    }

    @Override // p286h.p319v2.C5640i
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5642k) {
            if (!isEmpty() || !((C5642k) obj).isEmpty()) {
                C5642k c5642k = (C5642k) obj;
                if (getFirst() != c5642k.getFirst() || getLast() != c5642k.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p286h.p319v2.C5640i
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // p286h.p319v2.C5640i, p286h.p319v2.InterfaceC5638g
    public boolean isEmpty() {
        return getFirst() > getLast();
    }

    @Override // p286h.p319v2.C5640i
    @InterfaceC5816d
    public String toString() {
        return getFirst() + ".." + getLast();
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Integer getEndInclusive() {
        return Integer.valueOf(getLast());
    }

    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public Integer getStart() {
        return Integer.valueOf(getFirst());
    }
}
