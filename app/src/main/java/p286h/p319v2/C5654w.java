package p286h.p319v2;

import anet.channel.strategy.dispatch.DispatchConstants;
import bean.SurveyH5Bean;
import p286h.C5215b2;
import p286h.C5441n1;
import p286h.InterfaceC5352k;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: ULongRange.kt */
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00172\u00020\u00012\b\u0012\u0004\u0012\u00020\u00030\u0002:\u0001\u0017B\u0018\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003ø\u0001\u0000¢\u0006\u0002\u0010\u0006J\u001b\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0003H\u0096\u0002ø\u0001\u0000¢\u0006\u0004\b\r\u0010\u000eJ\u0013\u0010\u000f\u001a\u00020\u000b2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0096\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u000bH\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016R\u0017\u0010\u0005\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u0017\u0010\u0004\u001a\u00020\u00038VX\u0096\u0004ø\u0001\u0000¢\u0006\u0006\u001a\u0004\b\t\u0010\bø\u0001\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0018"}, m23546d2 = {"Lkotlin/ranges/ULongRange;", "Lkotlin/ranges/ULongProgression;", "Lkotlin/ranges/ClosedRange;", "Lkotlin/ULong;", "start", "endInclusive", "(JJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "getEndInclusive", "()Lkotlin/ULong;", "getStart", "contains", "", SurveyH5Bean.VALUE, "contains-VKZWuLQ", "(J)Z", "equals", DispatchConstants.OTHER, "", "hashCode", "", "isEmpty", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
@InterfaceC5610t0(version = "1.3")
@InterfaceC5352k
/* renamed from: h.v2.w */
/* loaded from: classes2.dex */
public final class C5654w extends C5652u implements InterfaceC5638g<C5441n1> {

    /* renamed from: f */
    public static final a f20549f = new a(null);

    /* renamed from: e */
    @InterfaceC5816d
    private static final C5654w f20548e = new C5654w(-1, 0, null);

    /* compiled from: ULongRange.kt */
    /* renamed from: h.v2.w$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5654w m23177a() {
            return C5654w.f20548e;
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }
    }

    private C5654w(long j2, long j3) {
        super(j2, j3, 1L, null);
    }

    /* renamed from: a */
    public boolean m23176a(long j2) {
        return C5215b2.m18813a(getFirst(), j2) <= 0 && C5215b2.m18813a(j2, getLast()) <= 0;
    }

    @Override // p286h.p319v2.InterfaceC5638g
    public /* bridge */ /* synthetic */ boolean contains(C5441n1 c5441n1) {
        return m23176a(c5441n1.m22244a());
    }

    @Override // p286h.p319v2.C5652u
    public boolean equals(@InterfaceC5817e Object obj) {
        if (obj instanceof C5654w) {
            if (!isEmpty() || !((C5654w) obj).isEmpty()) {
                C5654w c5654w = (C5654w) obj;
                if (getFirst() != c5654w.getFirst() || getLast() != c5654w.getLast()) {
                }
            }
            return true;
        }
        return false;
    }

    @Override // p286h.p319v2.C5652u
    public int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return ((int) C5441n1.m22205c(getLast() ^ C5441n1.m22205c(getLast() >>> 32))) + (((int) C5441n1.m22205c(getFirst() ^ C5441n1.m22205c(getFirst() >>> 32))) * 31);
    }

    @Override // p286h.p319v2.C5652u, p286h.p319v2.InterfaceC5638g
    public boolean isEmpty() {
        return C5215b2.m18813a(getFirst(), getLast()) > 0;
    }

    @Override // p286h.p319v2.C5652u
    @InterfaceC5816d
    public String toString() {
        return C5441n1.m22239n(getFirst()) + ".." + C5441n1.m22239n(getLast());
    }

    public /* synthetic */ C5654w(long j2, long j3, C5586v c5586v) {
        this(j2, j3);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public C5441n1 getEndInclusive() {
        return C5441n1.m22197a(getLast());
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // p286h.p319v2.InterfaceC5638g
    @InterfaceC5816d
    public C5441n1 getStart() {
        return C5441n1.m22197a(getFirst());
    }
}
