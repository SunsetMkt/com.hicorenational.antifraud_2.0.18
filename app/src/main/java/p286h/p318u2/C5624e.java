package p286h.p318u2;

import java.util.Random;
import p286h.InterfaceC5610t0;
import p286h.p304m2.C5432l;
import p286h.p304m2.InterfaceC5426f;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: PlatformRandom.kt */
/* renamed from: h.u2.e */
/* loaded from: classes2.dex */
public final class C5624e {
    /* renamed from: a */
    public static final double m22952a(int i2, int i3) {
        return ((i2 << 27) + i3) / 9007199254740992L;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final Random m22955a(@InterfaceC5816d AbstractC5625f abstractC5625f) {
        Random mo22951g;
        C5544i0.m22546f(abstractC5625f, "$this$asJavaRandom");
        AbstractC5620a abstractC5620a = (AbstractC5620a) (!(abstractC5625f instanceof AbstractC5620a) ? null : abstractC5625f);
        return (abstractC5620a == null || (mo22951g = abstractC5620a.mo22951g()) == null) ? new C5622c(abstractC5625f) : mo22951g;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final AbstractC5625f m22954a(@InterfaceC5816d Random random) {
        AbstractC5625f impl;
        C5544i0.m22546f(random, "$this$asKotlinRandom");
        C5622c c5622c = (C5622c) (!(random instanceof C5622c) ? null : random);
        return (c5622c == null || (impl = c5622c.getImpl()) == null) ? new C5623d(random) : impl;
    }

    @InterfaceC5426f
    /* renamed from: a */
    private static final AbstractC5625f m22953a() {
        return C5432l.f20299a.m22176a();
    }
}
