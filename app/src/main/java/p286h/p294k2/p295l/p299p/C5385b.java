package p286h.p294k2.p295l.p299p;

import com.umeng.analytics.pro.C3397d;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5359e;
import p286h.p294k2.InterfaceC5361g;
import p286h.p294k2.p295l.InterfaceC5369d;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.b */
/* loaded from: classes2.dex */
final class C5385b implements InterfaceC5359e {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5369d f20275a;

    public C5385b(@InterfaceC5816d InterfaceC5369d interfaceC5369d) {
        C5544i0.m22546f(interfaceC5369d, "interceptor");
        this.f20275a = interfaceC5369d;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5369d m22086a() {
        return this.f20275a;
    }

    @Override // p286h.p294k2.InterfaceC5359e
    @InterfaceC5816d
    /* renamed from: b */
    public <T> InterfaceC5358d<T> mo22001b(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        C5544i0.m22546f(interfaceC5358d, "continuation");
        return C5387d.m22088a(this.f20275a.mo22034a(C5387d.m22091a(interfaceC5358d)));
    }

    @Override // p286h.p294k2.InterfaceC5361g.b, p286h.p294k2.InterfaceC5361g
    public <R> R fold(R r, @InterfaceC5816d InterfaceC5510p<? super R, ? super InterfaceC5361g.b, ? extends R> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "operation");
        return (R) InterfaceC5359e.a.m22004a(this, r, interfaceC5510p);
    }

    @Override // p286h.p294k2.InterfaceC5359e, p286h.p294k2.InterfaceC5361g.b, p286h.p294k2.InterfaceC5361g
    @InterfaceC5817e
    public <E extends InterfaceC5361g.b> E get(@InterfaceC5816d InterfaceC5361g.c<E> cVar) {
        C5544i0.m22546f(cVar, "key");
        return (E) InterfaceC5359e.a.m22002a(this, cVar);
    }

    @Override // p286h.p294k2.InterfaceC5361g.b
    @InterfaceC5816d
    public InterfaceC5361g.c<?> getKey() {
        return InterfaceC5359e.f20232V;
    }

    @Override // p286h.p294k2.InterfaceC5359e, p286h.p294k2.InterfaceC5361g.b, p286h.p294k2.InterfaceC5361g
    @InterfaceC5816d
    public InterfaceC5361g minusKey(@InterfaceC5816d InterfaceC5361g.c<?> cVar) {
        C5544i0.m22546f(cVar, "key");
        return InterfaceC5359e.a.m22006b(this, cVar);
    }

    @Override // p286h.p294k2.InterfaceC5361g
    @InterfaceC5816d
    public InterfaceC5361g plus(@InterfaceC5816d InterfaceC5361g interfaceC5361g) {
        C5544i0.m22546f(interfaceC5361g, C3397d.f11892R);
        return InterfaceC5359e.a.m22003a(this, interfaceC5361g);
    }

    @Override // p286h.p294k2.InterfaceC5359e
    /* renamed from: a */
    public void mo22000a(@InterfaceC5816d InterfaceC5358d<?> interfaceC5358d) {
        C5544i0.m22546f(interfaceC5358d, "continuation");
        InterfaceC5359e.a.m22005a(this, interfaceC5358d);
    }
}
