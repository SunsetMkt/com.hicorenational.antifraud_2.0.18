package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.C4630l;

/* compiled from: ObservableFromCallable.java */
/* renamed from: g.a.y0.e.d.b1 */
/* loaded from: classes2.dex */
public final class CallableC4915b1<T> extends AbstractC4469b0<T> implements Callable<T> {

    /* renamed from: a */
    final Callable<? extends T> f18789a;

    public CallableC4915b1(Callable<? extends T> callable) {
        this.f18789a = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) C4601b.m18284a((Object) this.f18789a.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    public void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C4630l c4630l = new C4630l(interfaceC4514i0);
        interfaceC4514i0.onSubscribe(c4630l);
        if (c4630l.isDisposed()) {
            return;
        }
        try {
            c4630l.complete(C4601b.m18284a((Object) this.f18789a.call(), "Callable returned null"));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            if (c4630l.isDisposed()) {
                C4476a.m17152b(th);
            } else {
                interfaceC4514i0.onError(th);
            }
        }
    }
}
