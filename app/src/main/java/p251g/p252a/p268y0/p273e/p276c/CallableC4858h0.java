package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4570a;

/* compiled from: MaybeFromAction.java */
/* renamed from: g.a.y0.e.c.h0 */
/* loaded from: classes2.dex */
public final class CallableC4858h0<T> extends AbstractC4533s<T> implements Callable<T> {

    /* renamed from: a */
    final InterfaceC4570a f18620a;

    public CallableC4858h0(InterfaceC4570a interfaceC4570a) {
        this.f18620a = interfaceC4570a;
    }

    @Override // p251g.p252a.AbstractC4533s
    /* renamed from: b */
    protected void mo17327b(InterfaceC4559v<? super T> interfaceC4559v) {
        InterfaceC4552c m18189b = C4553d.m18189b();
        interfaceC4559v.onSubscribe(m18189b);
        if (m18189b.isDisposed()) {
            return;
        }
        try {
            this.f18620a.run();
            if (m18189b.isDisposed()) {
                return;
            }
            interfaceC4559v.onComplete();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            if (m18189b.isDisposed()) {
                C4476a.m17152b(th);
            } else {
                interfaceC4559v.onError(th);
            }
        }
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        this.f18620a.run();
        return null;
    }
}
