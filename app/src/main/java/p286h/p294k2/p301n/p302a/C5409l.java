package p286h.p294k2.p301n.p302a;

import p286h.C5475q0;
import p286h.C5597r0;
import p286h.C5715y1;
import p286h.p294k2.C5363i;
import p286h.p294k2.InterfaceC5358d;
import p286h.p294k2.InterfaceC5361g;
import p324i.p336c.p337a.InterfaceC5816d;
import p324i.p336c.p337a.InterfaceC5817e;

/* compiled from: RunSuspend.kt */
/* renamed from: h.k2.n.a.l */
/* loaded from: classes2.dex */
final class C5409l implements InterfaceC5358d<C5715y1> {

    /* renamed from: a */
    @InterfaceC5817e
    private C5475q0<C5715y1> f20296a;

    /* renamed from: a */
    public final void m22146a(@InterfaceC5817e C5475q0<C5715y1> c5475q0) {
        this.f20296a = c5475q0;
    }

    @InterfaceC5817e
    /* renamed from: b */
    public final C5475q0<C5715y1> m22147b() {
        return this.f20296a;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    @InterfaceC5816d
    public InterfaceC5361g getContext() {
        return C5363i.INSTANCE;
    }

    @Override // p286h.p294k2.InterfaceC5358d
    public void resumeWith(@InterfaceC5816d Object obj) {
        synchronized (this) {
            this.f20296a = C5475q0.m26854boximpl(obj);
            notifyAll();
            C5715y1 c5715y1 = C5715y1.f20665a;
        }
    }

    /* renamed from: a */
    public final void m22145a() {
        synchronized (this) {
            while (true) {
                C5475q0<C5715y1> c5475q0 = this.f20296a;
                if (c5475q0 == null) {
                    wait();
                } else {
                    C5597r0.m22717b(c5475q0.m26863unboximpl());
                }
            }
        }
    }
}
