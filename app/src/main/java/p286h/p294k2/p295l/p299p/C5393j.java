package p286h.p294k2.p295l.p299p;

import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p309q2.p310s.InterfaceC5511q;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.j */
/* loaded from: classes2.dex */
final class C5393j<T1, T2, R> implements InterfaceC5511q<T1, T2, InterfaceC5368c<? super R>, Object> {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5511q<T1, T2, InterfaceC5358d<? super R>, Object> f20285a;

    /* JADX WARN: Multi-variable type inference failed */
    public C5393j(@InterfaceC5816d InterfaceC5511q<? super T1, ? super T2, ? super InterfaceC5358d<? super R>, ? extends Object> interfaceC5511q) {
        C5544i0.m22546f(interfaceC5511q, "function");
        this.f20285a = interfaceC5511q;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5511q<T1, T2, InterfaceC5358d<? super R>, Object> m22104a() {
        return this.f20285a;
    }

    @Override // p286h.p309q2.p310s.InterfaceC5511q
    @InterfaceC5817e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(T1 t1, T2 t2, @InterfaceC5816d InterfaceC5368c<? super R> interfaceC5368c) {
        C5544i0.m22546f(interfaceC5368c, "continuation");
        return this.f20285a.invoke(t1, t2, C5387d.m22088a(interfaceC5368c));
    }
}
