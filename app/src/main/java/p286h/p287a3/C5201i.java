package p286h.p287a3;

import com.umeng.analytics.pro.C3351bh;
import java.util.concurrent.TimeUnit;
import p286h.C5718z;
import p286h.InterfaceC5610t0;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: DurationUnit.kt */
/* renamed from: h.a3.i */
/* loaded from: classes2.dex */
class C5201i extends C5200h {
    @InterfaceC5202j
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final String m18781a(@InterfaceC5816d TimeUnit timeUnit) {
        C5544i0.m22546f(timeUnit, "$this$shortName");
        switch (C5198f.f20068a[timeUnit.ordinal()]) {
            case 1:
                return "ns";
            case 2:
                return "us";
            case 3:
                return "ms";
            case 4:
                return C3351bh.f11580aE;
            case 5:
                return "m";
            case 6:
                return C3351bh.f11585aJ;
            case 7:
                return "d";
            default:
                throw new C5718z();
        }
    }
}
