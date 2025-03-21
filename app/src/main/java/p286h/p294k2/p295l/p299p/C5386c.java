package p286h.p294k2.p295l.p299p;

import p286h.C5475q0;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5361g;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.c */
/* loaded from: classes2.dex */
final class C5386c<T> implements InterfaceC5358d<T> {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5361g f20276a;

    /* renamed from: b */
    @InterfaceC5816d
    private final InterfaceC5368c<T> f20277b;

    /* JADX WARN: Multi-variable type inference failed */
    public C5386c(@InterfaceC5816d InterfaceC5368c<? super T> interfaceC5368c) {
        C5544i0.m22546f(interfaceC5368c, "continuation");
        this.f20277b = interfaceC5368c;
        this.f20276a = C5387d.m22090a(this.f20277b.getContext());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5368c<T> m22087a() {
        return this.f20277b;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    @InterfaceC5816d
    public InterfaceC5361g getContext() {
        return this.f20276a;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    public void resumeWith(@InterfaceC5816d Object obj) {
        if (C5475q0.m26861isSuccessimpl(obj)) {
            this.f20277b.resume(obj);
        }
        Throwable m26858exceptionOrNullimpl = C5475q0.m26858exceptionOrNullimpl(obj);
        if (m26858exceptionOrNullimpl != null) {
            this.f20277b.resumeWithException(m26858exceptionOrNullimpl);
        }
    }
}
