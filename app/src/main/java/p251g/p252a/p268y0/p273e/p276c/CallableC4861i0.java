package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;

/* compiled from: MaybeFromCallable.java */
/* renamed from: g.a.y0.e.c.i0 */
/* loaded from: classes2.dex */
public final class CallableC4861i0<T> extends AbstractC4533s<T> implements Callable<T> {

    /* renamed from: a */
    final Callable<? extends T> f18626a;

    public CallableC4861i0(Callable<? extends T> callable) {
        this.f18626a = callable;
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
            T call = this.f18626a.call();
            if (m18189b.isDisposed()) {
                return;
            }
            if (call == null) {
                interfaceC4559v.onComplete();
            } else {
                interfaceC4559v.onSuccess(call);
            }
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
        return this.f18626a.call();
    }
}
