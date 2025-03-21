package p251g.p252a.p268y0.p273e.p277d;

import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p272d.C4630l;

/* compiled from: ObservableFromFuture.java */
/* renamed from: g.a.y0.e.d.c1 */
/* loaded from: classes2.dex */
public final class C4921c1<T> extends AbstractC4469b0<T> {

    /* renamed from: a */
    final Future<? extends T> f18828a;

    /* renamed from: b */
    final long f18829b;

    /* renamed from: c */
    final TimeUnit f18830c;

    public C4921c1(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f18828a = future;
        this.f18829b = j2;
        this.f18830c = timeUnit;
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
            c4630l.complete(C4601b.m18284a((Object) (this.f18830c != null ? this.f18828a.get(this.f18829b, this.f18830c) : this.f18828a.get()), "Future returned null"));
        } catch (Throwable th) {
            C4561b.m18199b(th);
            if (c4630l.isDisposed()) {
                return;
            }
            interfaceC4514i0.onError(th);
        }
    }
}
