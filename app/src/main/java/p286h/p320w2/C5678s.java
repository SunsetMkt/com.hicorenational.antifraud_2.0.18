package p286h.p320w2;

import anet.channel.strategy.dispatch.DispatchConstants;
import p286h.InterfaceC5610t0;
import p286h.InterfaceC5713y;
import p286h.p309q2.p311t.C5544i0;
import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: KType.kt */
@InterfaceC5610t0(version = "1.1")
@InterfaceC5713y(m23544bv = {1, 0, 3}, m23545d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0003J!\u0010\r\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u0016"}, m23546d2 = {"Lkotlin/reflect/KTypeProjection;", "", "variance", "Lkotlin/reflect/KVariance;", "type", "Lkotlin/reflect/KType;", "(Lkotlin/reflect/KVariance;Lkotlin/reflect/KType;)V", "getType", "()Lkotlin/reflect/KType;", "getVariance", "()Lkotlin/reflect/KVariance;", "component1", "component2", "copy", "equals", "", DispatchConstants.OTHER, "hashCode", "", "toString", "", "Companion", "kotlin-stdlib"}, m23547k = 1, m23548mv = {1, 1, 16})
/* renamed from: h.w2.s */
/* loaded from: classes2.dex */
public final class C5678s {

    /* renamed from: a */
    @InterfaceC5817e
    private final EnumC5679t f20553a;

    /* renamed from: b */
    @InterfaceC5817e
    private final InterfaceC5676q f20554b;

    /* renamed from: d */
    public static final a f20552d = new a(null);

    /* renamed from: c */
    @InterfaceC5816d
    private static final C5678s f20551c = new C5678s(null, null);

    /* compiled from: KType.kt */
    /* renamed from: h.w2.s$a */
    public static final class a {
        private a() {
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5678s m23271a() {
            return C5678s.f20551c;
        }

        @InterfaceC5816d
        /* renamed from: b */
        public final C5678s m23273b(@InterfaceC5816d InterfaceC5676q interfaceC5676q) {
            C5544i0.m22546f(interfaceC5676q, "type");
            return new C5678s(EnumC5679t.OUT, interfaceC5676q);
        }

        @InterfaceC5816d
        /* renamed from: c */
        public final C5678s m23274c(@InterfaceC5816d InterfaceC5676q interfaceC5676q) {
            C5544i0.m22546f(interfaceC5676q, "type");
            return new C5678s(EnumC5679t.INVARIANT, interfaceC5676q);
        }

        public /* synthetic */ a(C5586v c5586v) {
            this();
        }

        @InterfaceC5816d
        /* renamed from: a */
        public final C5678s m23272a(@InterfaceC5816d InterfaceC5676q interfaceC5676q) {
            C5544i0.m22546f(interfaceC5676q, "type");
            return new C5678s(EnumC5679t.IN, interfaceC5676q);
        }
    }

    public C5678s(@InterfaceC5817e EnumC5679t enumC5679t, @InterfaceC5817e InterfaceC5676q interfaceC5676q) {
        this.f20553a = enumC5679t;
        this.f20554b = interfaceC5676q;
    }

    /* renamed from: a */
    public static /* synthetic */ C5678s m23264a(C5678s c5678s, EnumC5679t enumC5679t, InterfaceC5676q interfaceC5676q, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            enumC5679t = c5678s.f20553a;
        }
        if ((i2 & 2) != 0) {
            interfaceC5676q = c5678s.f20554b;
        }
        return c5678s.m23266a(enumC5679t, interfaceC5676q);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C5678s m23266a(@InterfaceC5817e EnumC5679t enumC5679t, @InterfaceC5817e InterfaceC5676q interfaceC5676q) {
        return new C5678s(enumC5679t, interfaceC5676q);
    }

    @InterfaceC5817e
    /* renamed from: a */
    public final EnumC5679t m23267a() {
        return this.f20553a;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public final InterfaceC5676q m23268b() {
        return this.f20554b;
    }

    @InterfaceC5817e
    /* renamed from: c */
    public final InterfaceC5676q m23269c() {
        return this.f20554b;
    }

    @InterfaceC5817e
    /* renamed from: d */
    public final EnumC5679t m23270d() {
        return this.f20553a;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5678s)) {
            return false;
        }
        C5678s c5678s = (C5678s) obj;
        return C5544i0.m22531a(this.f20553a, c5678s.f20553a) && C5544i0.m22531a(this.f20554b, c5678s.f20554b);
    }

    public int hashCode() {
        EnumC5679t enumC5679t = this.f20553a;
        int hashCode = (enumC5679t != null ? enumC5679t.hashCode() : 0) * 31;
        InterfaceC5676q interfaceC5676q = this.f20554b;
        return hashCode + (interfaceC5676q != null ? interfaceC5676q.hashCode() : 0);
    }

    @InterfaceC5816d
    public String toString() {
        return "KTypeProjection(variance=" + this.f20553a + ", type=" + this.f20554b + ")";
    }
}
