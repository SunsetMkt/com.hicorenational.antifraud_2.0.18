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
/* renamed from: h.k2.l.a */
/* loaded from: classes2.dex */
public abstract class AbstractC5366a implements InterfaceC5370e.b {

    /* renamed from: b */
    @InterfaceC5816d
    private final InterfaceC5370e.c<?> f20240b;

    public AbstractC5366a(@InterfaceC5816d InterfaceC5370e.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        this.f20240b = cVar;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b, p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5817e
    /* renamed from: a */
    public <E extends InterfaceC5370e.b> E mo22026a(@InterfaceC5816d InterfaceC5370e.c<E> cVar) {
        C5544i0.m22546f(cVar, "key");
        return (E) InterfaceC5370e.b.a.m22040a(this, cVar);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b, p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: b */
    public InterfaceC5370e mo22028b(@InterfaceC5816d InterfaceC5370e.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        return InterfaceC5370e.b.a.m22043b(this, cVar);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b, p286h.p294k2.p295l.InterfaceC5370e
    public <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5370e.b, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "operation");
        return (R) InterfaceC5370e.b.a.m22042a(this, r, interfaceC5510p);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b
    @InterfaceC5816d
    public InterfaceC5370e.c<?> getKey() {
        return this.f20240b;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: a */
    public InterfaceC5370e mo22027a(@InterfaceC5816d InterfaceC5370e interfaceC5370e) {
        C5544i0.m22546f(interfaceC5370e, C3397d.f11892R);
        return InterfaceC5370e.b.a.m22041a(this, interfaceC5370e);
    }
}
