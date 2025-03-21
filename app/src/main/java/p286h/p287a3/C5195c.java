package p286h.p287a3;

import p286h.p309q2.p311t.C5586v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: TimeSource.kt */
@InterfaceC5202j
/* renamed from: h.a3.c */
/* loaded from: classes2.dex */
final class C5195c extends AbstractC5207o {

    /* renamed from: a */
    @InterfaceC5816d
    private final AbstractC5207o f20062a;

    /* renamed from: b */
    private final double f20063b;

    private C5195c(AbstractC5207o abstractC5207o, double d2) {
        this.f20062a = abstractC5207o;
        this.f20063b = d2;
    }

    @Override // p286h.p287a3.AbstractC5207o
    /* renamed from: a */
    public double mo18668a() {
        return C5196d.m18696e(this.f20062a.mo18668a(), this.f20063b);
    }

    @Override // p286h.p287a3.AbstractC5207o
    @InterfaceC5816d
    /* renamed from: b */
    public AbstractC5207o mo18669b(double d2) {
        return new C5195c(this.f20062a, C5196d.m18700f(this.f20063b, d2), null);
    }

    /* renamed from: d */
    public final double m18672d() {
        return this.f20063b;
    }

    @InterfaceC5816d
    /* renamed from: e */
    public final AbstractC5207o m18673e() {
        return this.f20062a;
    }

    public /* synthetic */ C5195c(AbstractC5207o abstractC5207o, double d2, C5586v c5586v) {
        this(abstractC5207o, d2);
    }
}
