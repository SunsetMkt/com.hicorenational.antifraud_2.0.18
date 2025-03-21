package p251g.p252a.p264u0;

import java.util.concurrent.Future;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p267x0.InterfaceC4570a;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4600a;
import p251g.p252a.p268y0.p270b.C4601b;
import p324i.p338d.InterfaceC5823d;

/* compiled from: Disposables.java */
/* renamed from: g.a.u0.d */
/* loaded from: classes2.dex */
public final class C4553d {
    private C4553d() {
        throw new IllegalStateException("No instances!");
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static InterfaceC4552c m18186a(@InterfaceC4546f Runnable runnable) {
        C4601b.m18284a(runnable, "run is null");
        return new C4556g(runnable);
    }

    @InterfaceC4546f
    /* renamed from: b */
    public static InterfaceC4552c m18189b() {
        return m18186a(C4600a.f17514b);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static InterfaceC4552c m18184a(@InterfaceC4546f InterfaceC4570a interfaceC4570a) {
        C4601b.m18284a(interfaceC4570a, "run is null");
        return new C4550a(interfaceC4570a);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static InterfaceC4552c m18187a(@InterfaceC4546f Future<?> future) {
        C4601b.m18284a(future, "future is null");
        return m18188a(future, true);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static InterfaceC4552c m18188a(@InterfaceC4546f Future<?> future, boolean z) {
        C4601b.m18284a(future, "future is null");
        return new C4554e(future, z);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static InterfaceC4552c m18185a(@InterfaceC4546f InterfaceC5823d interfaceC5823d) {
        C4601b.m18284a(interfaceC5823d, "subscription is null");
        return new C4558i(interfaceC5823d);
    }

    @InterfaceC4546f
    /* renamed from: a */
    public static InterfaceC4552c m18183a() {
        return EnumC4593e.INSTANCE;
    }
}
