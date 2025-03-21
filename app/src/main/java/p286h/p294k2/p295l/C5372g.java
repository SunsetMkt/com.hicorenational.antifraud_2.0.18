package p286h.p294k2.p295l;

import com.umeng.analytics.pro.C3397d;
import p286h.InterfaceC5610t0;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutineContextImpl.kt */
@InterfaceC5610t0(version = "1.1")
/* renamed from: h.k2.l.g */
/* loaded from: classes2.dex */
public final class C5372g implements InterfaceC5370e {

    /* renamed from: b */
    public static final C5372g f20245b = new C5372g();

    private C5372g() {
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5817e
    /* renamed from: a */
    public <E extends InterfaceC5370e.b> E mo22026a(@InterfaceC5816d InterfaceC5370e.c<E> cVar) {
        C5544i0.m22546f(cVar, "key");
        return null;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: a */
    public InterfaceC5370e mo22027a(@InterfaceC5816d InterfaceC5370e interfaceC5370e) {
        C5544i0.m22546f(interfaceC5370e, C3397d.f11892R);
        return interfaceC5370e;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: b */
    public InterfaceC5370e mo22028b(@InterfaceC5816d InterfaceC5370e.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        return this;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    public <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5370e.b, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "operation");
        return r;
    }

    public int hashCode() {
        return 0;
    }

    @InterfaceC5816d
    public String toString() {
        return "EmptyCoroutineContext";
    }
}
