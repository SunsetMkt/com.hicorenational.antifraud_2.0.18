package p251g.p252a.p268y0.p273e.p279f;

import java.util.concurrent.Callable;
import p000a.p001a.InterfaceC0000a;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;

/* compiled from: SingleFromCallable.java */
/* renamed from: g.a.y0.e.f.a0 */
/* loaded from: classes2.dex */
public final class C5062a0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final Callable<? extends T> f19665a;

    public C5062a0(Callable<? extends T> callable) {
        this.f19665a = callable;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        InterfaceC4552c m18189b = C4553d.m18189b();
        interfaceC4524n0.onSubscribe(m18189b);
        if (m18189b.isDisposed()) {
            return;
        }
        try {
            InterfaceC0000a interfaceC0000a = (Object) C4601b.m18284a((Object) this.f19665a.call(), "The callable returned a null value");
            if (m18189b.isDisposed()) {
                return;
            }
            interfaceC4524n0.onSuccess(interfaceC0000a);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            if (m18189b.isDisposed()) {
                C4476a.m17152b(th);
            } else {
                interfaceC4524n0.onError(th);
            }
        }
    }
}
