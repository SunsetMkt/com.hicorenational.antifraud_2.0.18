package p251g.p252a.p268y0.p273e.p274a;

import java.util.concurrent.Callable;
import p251g.p252a.AbstractC4518k0;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4513i;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;

/* compiled from: CompletableToSingle.java */
/* renamed from: g.a.y0.e.a.n0 */
/* loaded from: classes2.dex */
public final class C4672n0<T> extends AbstractC4518k0<T> {

    /* renamed from: a */
    final InterfaceC4513i f17727a;

    /* renamed from: b */
    final Callable<? extends T> f17728b;

    /* renamed from: c */
    final T f17729c;

    /* compiled from: CompletableToSingle.java */
    /* renamed from: g.a.y0.e.a.n0$a */
    final class a implements InterfaceC4491f {

        /* renamed from: a */
        private final InterfaceC4524n0<? super T> f17730a;

        a(InterfaceC4524n0<? super T> interfaceC4524n0) {
            this.f17730a = interfaceC4524n0;
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onComplete() {
            T call;
            C4672n0 c4672n0 = C4672n0.this;
            Callable<? extends T> callable = c4672n0.f17728b;
            if (callable != null) {
                try {
                    call = callable.call();
                } catch (Throwable th) {
                    C4561b.m18199b(th);
                    this.f17730a.onError(th);
                    return;
                }
            } else {
                call = c4672n0.f17729c;
            }
            if (call == null) {
                this.f17730a.onError(new NullPointerException("The value supplied is null"));
            } else {
                this.f17730a.onSuccess(call);
            }
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onError(Throwable th) {
            this.f17730a.onError(th);
        }

        @Override // p251g.p252a.InterfaceC4491f
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
            this.f17730a.onSubscribe(interfaceC4552c);
        }
    }

    public C4672n0(InterfaceC4513i interfaceC4513i, Callable<? extends T> callable, T t) {
        this.f17727a = interfaceC4513i;
        this.f17729c = t;
        this.f17728b = callable;
    }

    @Override // p251g.p252a.AbstractC4518k0
    /* renamed from: b */
    protected void mo17357b(InterfaceC4524n0<? super T> interfaceC4524n0) {
        this.f17727a.mo17074a(new a(interfaceC4524n0));
    }
}
