package p286h.p294k2.p295l.p297o.p298a;

import com.umeng.analytics.pro.C3397d;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p294k2.p295l.InterfaceC5369d;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p309q2.InterfaceC5481e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CoroutineIntrinsics.kt */
@InterfaceC5481e(name = "CoroutineIntrinsics")
/* renamed from: h.k2.l.o.a.b */
/* loaded from: classes2.dex */
public final class C5383b {
    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5368c<T> m22083a(@InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        InterfaceC5368c<T> interfaceC5368c2;
        C5544i0.m22546f(interfaceC5368c, "continuation");
        AbstractC5382a abstractC5382a = !(interfaceC5368c instanceof AbstractC5382a) ? null : interfaceC5368c;
        return (abstractC5382a == null || (interfaceC5368c2 = (InterfaceC5368c<T>) abstractC5382a.getFacade()) == null) ? interfaceC5368c : interfaceC5368c2;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @InterfaceC5816d
    /* renamed from: a */
    public static final <T> InterfaceC5368c<T> m22084a(@InterfaceC5816d InterfaceC5370e interfaceC5370e, @InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        InterfaceC5368c<T> mo22034a;
        C5544i0.m22546f(interfaceC5370e, C3397d.f11892R);
        C5544i0.m22546f(interfaceC5368c, "continuation");
        InterfaceC5369d interfaceC5369d = (InterfaceC5369d) interfaceC5370e.mo22026a(InterfaceC5369d.f20243a);
        return (interfaceC5369d == null || (mo22034a = interfaceC5369d.mo22034a(interfaceC5368c)) == null) ? interfaceC5368c : mo22034a;
    }
}
