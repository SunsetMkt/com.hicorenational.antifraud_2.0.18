package p286h.p294k2.p295l.p299p;

import p286h.InterfaceC5610t0;
import p286h.p294k2.C5363i;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5359e;
import p286h.p294k2.InterfaceC5361g;
import p286h.p294k2.p295l.C5372g;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p294k2.p295l.InterfaceC5369d;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.d */
/* loaded from: classes2.dex */
public final class C5387d {
    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5368c<T> m22091a(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        InterfaceC5368c<T> m22087a;
        C5544i0.m22546f(interfaceC5358d, "$this$toExperimentalContinuation");
        C5386c c5386c = (C5386c) (!(interfaceC5358d instanceof C5386c) ? null : interfaceC5358d);
        return (c5386c == null || (m22087a = c5386c.m22087a()) == null) ? new C5390g(interfaceC5358d) : m22087a;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5358d<T> m22088a(@InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        InterfaceC5358d<T> m22099a;
        C5544i0.m22546f(interfaceC5368c, "$this$toContinuation");
        C5390g c5390g = (C5390g) (!(interfaceC5368c instanceof C5390g) ? null : interfaceC5368c);
        return (c5390g == null || (m22099a = c5390g.m22099a()) == null) ? new C5386c(interfaceC5368c) : m22099a;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final InterfaceC5370e m22093a(@InterfaceC5816d InterfaceC5361g interfaceC5361g) {
        InterfaceC5370e interfaceC5370e;
        C5544i0.m22546f(interfaceC5361g, "$this$toExperimentalCoroutineContext");
        InterfaceC5359e interfaceC5359e = (InterfaceC5359e) interfaceC5361g.get(InterfaceC5359e.f20232V);
        C5384a c5384a = (C5384a) interfaceC5361g.get(C5384a.f20273c);
        InterfaceC5361g minusKey = interfaceC5361g.minusKey(InterfaceC5359e.f20232V).minusKey(C5384a.f20273c);
        if (c5384a == null || (interfaceC5370e = c5384a.m22085a()) == null) {
            interfaceC5370e = C5372g.f20245b;
        }
        if (minusKey != C5363i.INSTANCE) {
            interfaceC5370e = interfaceC5370e.mo22027a(new C5388e(minusKey));
        }
        return interfaceC5359e == null ? interfaceC5370e : interfaceC5370e.mo22027a(m22092a(interfaceC5359e));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final InterfaceC5361g m22090a(@InterfaceC5816d InterfaceC5370e interfaceC5370e) {
        InterfaceC5361g interfaceC5361g;
        C5544i0.m22546f(interfaceC5370e, "$this$toCoroutineContext");
        InterfaceC5369d interfaceC5369d = (InterfaceC5369d) interfaceC5370e.mo22026a(InterfaceC5369d.f20243a);
        C5388e c5388e = (C5388e) interfaceC5370e.mo22026a(C5388e.f20278d);
        InterfaceC5370e mo22028b = interfaceC5370e.mo22028b(InterfaceC5369d.f20243a).mo22028b(C5388e.f20278d);
        if (c5388e == null || (interfaceC5361g = c5388e.m22097a()) == null) {
            interfaceC5361g = C5363i.INSTANCE;
        }
        if (mo22028b != C5372g.f20245b) {
            interfaceC5361g = interfaceC5361g.plus(new C5384a(mo22028b));
        }
        return interfaceC5369d == null ? interfaceC5361g : interfaceC5361g.plus(m22089a(interfaceC5369d));
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final InterfaceC5369d m22092a(@InterfaceC5816d InterfaceC5359e interfaceC5359e) {
        InterfaceC5369d m22086a;
        C5544i0.m22546f(interfaceC5359e, "$this$toExperimentalContinuationInterceptor");
        C5385b c5385b = (C5385b) (!(interfaceC5359e instanceof C5385b) ? null : interfaceC5359e);
        return (c5385b == null || (m22086a = c5385b.m22086a()) == null) ? new C5389f(interfaceC5359e) : m22086a;
    }

    @InterfaceC5610t0(version = "1.3")
    @InterfaceC5816d
    /* renamed from: a */
    public static final InterfaceC5359e m22089a(@InterfaceC5816d InterfaceC5369d interfaceC5369d) {
        InterfaceC5359e m22098a;
        C5544i0.m22546f(interfaceC5369d, "$this$toContinuationInterceptor");
        C5389f c5389f = (C5389f) (!(interfaceC5369d instanceof C5389f) ? null : interfaceC5369d);
        return (c5389f == null || (m22098a = c5389f.m22098a()) == null) ? new C5385b(interfaceC5369d) : m22098a;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <R> InterfaceC5506l<InterfaceC5368c<? super R>, Object> m22094a(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5358d<? super R>, ? extends Object> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5506l, "$this$toExperimentalSuspendFunction");
        return new C5391h(interfaceC5506l);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T1, R> InterfaceC5510p<T1, InterfaceC5368c<? super R>, Object> m22095a(@InterfaceC5816d InterfaceC5510p<? super T1, ? super InterfaceC5358d<? super R>, ? extends Object> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "$this$toExperimentalSuspendFunction");
        return new C5392i(interfaceC5510p);
    }

    @InterfaceC5816d
    /* renamed from: a */
    public static final <T1, T2, R> InterfaceC5511q<T1, T2, InterfaceC5368c<? super R>, Object> m22096a(@InterfaceC5816d InterfaceC5511q<? super T1, ? super T2, ? super InterfaceC5358d<? super R>, ? extends Object> interfaceC5511q) {
        C5544i0.m22546f(interfaceC5511q, "$this$toExperimentalSuspendFunction");
        return new C5393j(interfaceC5511q);
    }
}
