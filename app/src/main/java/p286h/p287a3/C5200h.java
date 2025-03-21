package p286h.p287a3;

import java.util.concurrent.TimeUnit;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: DurationUnitJvm.kt */
/* renamed from: h.a3.h */
/* loaded from: classes2.dex */
class C5200h {
    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static final double m18779a(double d2, @InterfaceC5816d TimeUnit timeUnit, @InterfaceC5816d TimeUnit timeUnit2) {
        C5544i0.m22546f(timeUnit, "sourceUnit");
        C5544i0.m22546f(timeUnit2, "targetUnit");
        long convert = timeUnit2.convert(1L, timeUnit);
        return convert > 0 ? d2 * convert : d2 / timeUnit.convert(1L, timeUnit2);
    }

    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    /* renamed from: a */
    public static /* synthetic */ void m18780a() {
    }
}
