package p251g.p252a.p268y0.p273e.p275b;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.C5156f;
import p324i.p338d.InterfaceC5822c;

/* compiled from: FlowableFromCallable.java */
/* renamed from: g.a.y0.e.b.e1 */
/* loaded from: classes2.dex */
public final class CallableC4712e1<T> extends AbstractC4519l<T> implements Callable<T> {

    /* renamed from: b */
    final Callable<? extends T> f17854b;

    public CallableC4712e1(Callable<? extends T> callable) {
        this.f17854b = callable;
    }

    @Override // java.util.concurrent.Callable
    public T call() throws Exception {
        return (T) C4601b.m18284a((Object) this.f17854b.call(), "The callable returned a null value");
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    public void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        C5156f c5156f = new C5156f(interfaceC5822c);
        interfaceC5822c.onSubscribe(c5156f);
        try {
            c5156f.complete(C4601b.m18284a((Object) this.f17854b.call(), "The callable returned a null value"));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            interfaceC5822c.onError(th);
        }
    }
}
