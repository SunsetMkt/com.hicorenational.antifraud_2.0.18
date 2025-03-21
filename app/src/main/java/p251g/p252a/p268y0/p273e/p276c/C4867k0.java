package p251g.p252a.p268y0.p273e.p276c;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p251g.p252a.AbstractC4533s;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: MaybeFromFuture.java */
/* renamed from: g.a.y0.e.c.k0 */
/* loaded from: classes2.dex */
public final class C4867k0<T> extends AbstractC4533s<T> {

    /* renamed from: a */
    final Future<? extends T> f18637a;

    /* renamed from: b */
    final long f18638b;

    /* renamed from: c */
    final TimeUnit f18639c;

    public C4867k0(Future<? extends T> future, long j2, TimeUnit timeUnit) {
        this.f18637a = future;
        this.f18638b = j2;
        this.f18639c = timeUnit;
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
            T t = this.f18638b <= 0 ? this.f18637a.get() : this.f18637a.get(this.f18638b, this.f18639c);
            if (m18189b.isDisposed()) {
                return;
            }
            if (t == null) {
                interfaceC4559v.onComplete();
            } else {
                interfaceC4559v.onSuccess(t);
            }
        } catch (InterruptedException e2) {
            if (m18189b.isDisposed()) {
                return;
            }
            interfaceC4559v.onError(e2);
        } catch (ExecutionException e3) {
            if (m18189b.isDisposed()) {
                return;
            }
            interfaceC4559v.onError(e3.getCause());
        } catch (TimeoutException e4) {
            if (m18189b.isDisposed()) {
                return;
            }
            interfaceC4559v.onError(e4);
        }
    }
}
