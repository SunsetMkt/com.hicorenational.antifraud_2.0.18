package p286h.p294k2.p295l.p299p;

import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p309q2.p310s.InterfaceC5510p;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.i */
/* loaded from: classes2.dex */
final class C5392i<T1, R> implements InterfaceC5510p<T1, InterfaceC5368c<? super R>, Object> {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5510p<T1, InterfaceC5358d<? super R>, Object> f20284a;

    /* JADX WARN: Multi-variable type inference failed */
    public C5392i(@InterfaceC5816d InterfaceC5510p<? super T1, ? super InterfaceC5358d<? super R>, ? extends Object> interfaceC5510p) {
        C5544i0.m22546f(interfaceC5510p, "function");
        this.f20284a = interfaceC5510p;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5510p<T1, InterfaceC5358d<? super R>, Object> m22102a() {
        return this.f20284a;
    }

    @Override // p286h.p309q2.p310s.InterfaceC5510p
    @InterfaceC5817e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(T1 t1, @InterfaceC5816d InterfaceC5368c<? super R> interfaceC5368c) {
        C5544i0.m22546f(interfaceC5368c, "continuation");
        return this.f20284a.invoke(t1, C5387d.m22088a(interfaceC5368c));
    }
}
