package p286h.p319v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import p286h.C5215b2;
import p286h.C5341j1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: UIntRange.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m23546d2 = {"Lkotlin/ranges/UIntRange;", "Lkotlin/ranges/UIntProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/UInt;", "start", "endInclusive", "(IILkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/UInt;", "getStart", "contains", "", SurveyH5Bean.VALUE, "contains-WZ4Q5Ns", "(I)Z", "equals", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.v2.t */
/* loaded from: classes2.dex */
public final class C5651t extends C5649r implements InterfaceC5638g<C5341j1> {

    /* renamed from: e */
    @InterfaceC5816d
    private static final C5651t f20538e;

    /* renamed from: f */
    public static final a f20539f;

    /* compiled from: UIntRange.kt */
    /* renamed from: h.v2.t$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5651t m23172a() {
            return C5651t.f20538e;
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    static {
        C5586v c5586v = null;
        f20539f = new a(c5586v);
        f20538e = new C5651t(-1, 0, c5586v);
    }

    private C5651t(int i2, int i3) {
        super(i2, i3, 1, null);
    }

    /* renamed from: a */
    public boolean m23171a(int i2) {
        return C5215b2.m18812a(getFirst(), i2) <= 0 && C5215b2.m18812a(i2, getLast()) <= 0;
    }

    @Override // p286h.p319v2.InterfaceC5638g
    public /* bridge */ /* synthetic */ boolean contains(C5341j1 c5341j1) {
        return m23171a(c5341j1.m21968a());
    }

    @Override // p286h.p319v2.C5649r
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5651t) {
            if (!isEmpty() || !((C5651t) obj).isEmpty()) {
                C5651t c5651t = (C5651t) obj;
                if (getFirst() != c5651t.getFirst() || getLast() != c5651t.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p286h.p319v2.C5649r
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (getFirst() * 31) + getLast();
    }

    @Override // p286h.p319v2.C5649r, p286h.p319v2.InterfaceC5638g
    public boolean isEmpty() {
        return C5215b2.m18812a(getFirst(), getLast()) > 0;
    }

    @Override // p286h.p319v2.C5649r
    @InterfaceC5816d
    public String toString() {
        return C5341j1.m21963n(getFirst()) + ".." + C5341j1.m21963n(getLast());
    }

    public /* synthetic */ C5651t(int i2, int i3, C5586v c5586v) {
        this(i2, i3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public C5341j1 getEndInclusive() {
        return C5341j1.m21921a(getLast());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public C5341j1 getStart() {
        return C5341j1.m21921a(getFirst());
    }
}
