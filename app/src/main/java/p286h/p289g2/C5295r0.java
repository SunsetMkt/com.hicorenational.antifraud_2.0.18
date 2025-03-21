package p286h.p289g2;

import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: IndexedValue.kt */
/* renamed from: h.g2.r0 */
/* loaded from: classes2.dex */
public final class C5295r0<T> {

    /* renamed from: a */
    private final int f20179a;

    /* renamed from: b */
    private final T f20180b;

    public C5295r0(int i2, T t) {
        this.f20179a = i2;
        this.f20180b = t;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: a */
    public static /* synthetic */ C5295r0 m21662a(C5295r0 c5295r0, int i2, Object obj, int i3, Object obj2) {
        if ((i3 & 1) != 0) {
            i2 = c5295r0.f20179a;
        }
        if ((i3 & 2) != 0) {
            obj = c5295r0.f20180b;
        }
        return c5295r0.m21664a(i2, obj);
    }

    /* renamed from: a */
    public final int m21663a() {
        return this.f20179a;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final C5295r0<T> m21664a(int i2, T t) {
        return new C5295r0<>(i2, t);
    }

    /* renamed from: b */
    public final T m21665b() {
        return this.f20180b;
    }

    /* renamed from: c */
    public final int m21666c() {
        return this.f20179a;
    }

    /* renamed from: d */
    public final T m21667d() {
        return this.f20180b;
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C5295r0)) {
            return false;
        }
        C5295r0 c5295r0 = (C5295r0) obj;
        return this.f20179a == c5295r0.f20179a && C5544i0.m22531a(this.f20180b, c5295r0.f20180b);
    }

    public int hashCode() {
        int i2 = this.f20179a * 31;
        T t = this.f20180b;
        return i2 + (t != null ? t.hashCode() : 0);
    }

    @InterfaceC5816d
    public String toString() {
        return "IndexedValue(index=" + this.f20179a + ", value=" + this.f20180b + ")";
    }
}
