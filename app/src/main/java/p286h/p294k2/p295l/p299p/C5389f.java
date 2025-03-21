package p286h.p294k2.p295l.p299p;

import com.umeng.analytics.pro.C3397d;
import p286h.p294k2.InterfaceC5359e;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p294k2.p295l.InterfaceC5369d;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.f */
/* loaded from: classes2.dex */
final class C5389f implements InterfaceC5369d {

    /* renamed from: b */
    @InterfaceC5816d
    private final InterfaceC5359e f20280b;

    public C5389f(@InterfaceC5816d InterfaceC5359e interfaceC5359e) {
        C5544i0.m22546f(interfaceC5359e, "interceptor");
        this.f20280b = interfaceC5359e;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b, p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5817e
    /* renamed from: a */
    public <E extends InterfaceC5370e.b> E mo22026a(@InterfaceC5816d InterfaceC5370e.c<E> cVar) {
        C5544i0.m22546f(cVar, "key");
        return (E) InterfaceC5369d.a.m22035a(this, cVar);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b, p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: b */
    public InterfaceC5370e mo22028b(@InterfaceC5816d InterfaceC5370e.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        return InterfaceC5369d.a.m22038b(this, cVar);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b, p286h.p294k2.p295l.InterfaceC5370e
    public <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5370e.b, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "operation");
        return (R) InterfaceC5369d.a.m22037a(this, r, interfaceC5510p);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e.b
    @InterfaceC5816d
    public InterfaceC5370e.c<?> getKey() {
        return InterfaceC5369d.f20243a;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5359e m22098a() {
        return this.f20280b;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5370e
    @InterfaceC5816d
    /* renamed from: a */
    public InterfaceC5370e mo22027a(@InterfaceC5816d InterfaceC5370e interfaceC5370e) {
        C5544i0.m22546f(interfaceC5370e, C3397d.f11892R);
        return InterfaceC5369d.a.m22036a(this, interfaceC5370e);
    }

    @Override // p286h.p294k2.p295l.InterfaceC5369d
    @InterfaceC5816d
    /* renamed from: a */
    public <T> InterfaceC5368c<T> mo22034a(@InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        C5544i0.m22546f(interfaceC5368c, "continuation");
        return C5387d.m22091a(this.f20280b.mo22001b(C5387d.m22088a(interfaceC5368c)));
    }
}
