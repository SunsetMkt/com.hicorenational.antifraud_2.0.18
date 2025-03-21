package p286h.p287a3;

import p286h.InterfaceC5610t0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: TimeSource.kt */
@InterfaceC5202j
@InterfaceC5610t0(version = "1.3")
/* renamed from: h.a3.o */
/* loaded from: classes2.dex */
public abstract class AbstractC5207o {
    /* renamed from: a */
    public abstract double mo18668a();

    @InterfaceC5816d
    /* renamed from: a */
    public AbstractC5207o m18792a(double d2) {
        return mo18669b(C5196d.m18723y(d2));
    }

    @InterfaceC5816d
    /* renamed from: b */
    public AbstractC5207o mo18669b(double d2) {
        return new C5195c(this, d2, null);
    }

    /* renamed from: c */
    public final boolean m18794c() {
        return !C5196d.m18717s(mo18668a());
    }

    /* renamed from: b */
    public final boolean m18793b() {
        return C5196d.m18717s(mo18668a());
    }
}
