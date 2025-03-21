package p286h.p309q2.p311t;

import java.util.Collection;
import p286h.InterfaceC5610t0;
import p286h.p309q2.C5488l;
import p286h.p320w2.InterfaceC5661b;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: PackageReference.kt */
@InterfaceC5610t0(version = "1.1")
/* renamed from: h.q2.t.x0 */
/* loaded from: classes2.dex */
public final class C5591x0 implements InterfaceC5580s {

    /* renamed from: a */
    @InterfaceC5816d
    private final Class<?> f20442a;

    /* renamed from: b */
    private final String f20443b;

    public C5591x0(@InterfaceC5816d Class<?> cls, @InterfaceC5816d String str) {
        C5544i0.m22546f(cls, "jClass");
        C5544i0.m22546f(str, "moduleName");
        this.f20442a = cls;
        this.f20443b = str;
    }

    @Override // p286h.p320w2.InterfaceC5665f
    @InterfaceC5816d
    /* renamed from: a */
    public Collection<InterfaceC5661b<?>> mo22670a() {
        throw new C5488l();
    }

    public boolean equals(@InterfaceC5817e Object obj) {
        return (obj instanceof C5591x0) && C5544i0.m22531a(mo22654m(), ((C5591x0) obj).mo22654m());
    }

    public int hashCode() {
        return mo22654m().hashCode();
    }

    @Override // p286h.p309q2.p311t.InterfaceC5580s
    @InterfaceC5816d
    /* renamed from: m */
    public Class<?> mo22654m() {
        return this.f20442a;
    }

    @InterfaceC5816d
    public String toString() {
        return mo22654m().toString() + " (Kotlin reflection is not available)";
    }
}
