package p286h.p294k2.p295l.p299p;

import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p309q2.p310s.InterfaceC5506l;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.h */
/* loaded from: classes2.dex */
final class C5391h<R> implements InterfaceC5506l<InterfaceC5368c<? super R>, Object> {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5506l<InterfaceC5358d<? super R>, Object> f20283a;

    /* JADX WARN: Multi-variable type inference failed */
    public C5391h(@InterfaceC5816d InterfaceC5506l<? super InterfaceC5358d<? super R>, ? extends Object> interfaceC5506l) {
        C5544i0.m22546f(interfaceC5506l, "function");
        this.f20283a = interfaceC5506l;
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5506l<InterfaceC5358d<? super R>, Object> m22100a() {
        return this.f20283a;
    }

    @Override // p286h.p309q2.p310s.InterfaceC5506l
    @InterfaceC5817e
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public Object invoke(@InterfaceC5816d InterfaceC5368c<? super R> interfaceC5368c) {
        C5544i0.m22546f(interfaceC5368c, "continuation");
        return this.f20283a.invoke(C5387d.m22088a(interfaceC5368c));
    }
}
