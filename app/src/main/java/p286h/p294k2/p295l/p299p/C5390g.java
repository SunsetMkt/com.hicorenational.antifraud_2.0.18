package p286h.p294k2.p295l.p299p;

import p286h.C5475q0;
import p286h.C5597r0;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.p295l.InterfaceC5368c;
import p286h.p294k2.p295l.InterfaceC5370e;
import p286h.p309q2.p311t.C5544i0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: CoroutinesMigration.kt */
/* renamed from: h.k2.l.p.g */
/* loaded from: classes2.dex */
final class C5390g<T> implements InterfaceC5368c<T> {

    /* renamed from: a */
    @InterfaceC5816d
    private final InterfaceC5370e f20281a;

    /* renamed from: b */
    @InterfaceC5816d
    private final InterfaceC5358d<T> f20282b;

    /* JADX WARN: Multi-variable type inference failed */
    public C5390g(@InterfaceC5816d InterfaceC5358d<? super T> interfaceC5358d) {
        C5544i0.m22546f(interfaceC5358d, "continuation");
        this.f20282b = interfaceC5358d;
        this.f20281a = C5387d.m22093a(this.f20282b.getContext());
    }

    @InterfaceC5816d
    /* renamed from: a */
    public final InterfaceC5358d<T> m22099a() {
        return this.f20282b;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    @InterfaceC5816d
    public InterfaceC5370e getContext() {
        return this.f20281a;
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    public void resume(T t) {
        InterfaceC5358d<T> interfaceC5358d = this.f20282b;
        C5475q0.a aVar = C5475q0.Companion;
        interfaceC5358d.resumeWith(C5475q0.m26855constructorimpl(t));
    }

    @Override // p286h.p294k2.p295l.InterfaceC5368c
    public void resumeWithException(@InterfaceC5816d Throwable th) {
        C5544i0.m22546f(th, "exception");
        InterfaceC5358d<T> interfaceC5358d = this.f20282b;
        C5475q0.a aVar = C5475q0.Companion;
        interfaceC5358d.resumeWith(C5475q0.m26855constructorimpl(C5597r0.m22715a(th)));
    }
}
