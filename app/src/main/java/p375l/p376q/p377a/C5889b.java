package p375l.p376q.p377a;

import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p375l.C5884m;
import p375l.InterfaceC5873b;
import p375l.InterfaceC5875d;

/* compiled from: CallEnqueueObservable.java */
/* renamed from: l.q.a.b */
/* loaded from: classes2.dex */
final class C5889b<T> extends AbstractC4469b0<C5884m<T>> {

    /* renamed from: a */
    private final InterfaceC5873b<T> f21335a;

    /* compiled from: CallEnqueueObservable.java */
    /* renamed from: l.q.a.b$a */
    private static final class a<T> implements InterfaceC4552c, InterfaceC5875d<T> {

        /* renamed from: a */
        private final InterfaceC5873b<?> f21336a;

        /* renamed from: b */
        private final InterfaceC4514i0<? super C5884m<T>> f21337b;

        /* renamed from: c */
        private volatile boolean f21338c;

        /* renamed from: d */
        boolean f21339d = false;

        a(InterfaceC5873b<?> interfaceC5873b, InterfaceC4514i0<? super C5884m<T>> interfaceC4514i0) {
            this.f21336a = interfaceC5873b;
            this.f21337b = interfaceC4514i0;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f21338c = true;
            this.f21336a.cancel();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f21338c;
        }

        @Override // p375l.InterfaceC5875d
        public void onFailure(InterfaceC5873b<T> interfaceC5873b, Throwable th) {
            if (interfaceC5873b.isCanceled()) {
                return;
            }
            try {
                this.f21337b.onError(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                C4476a.m17152b(new C4560a(th, th2));
            }
        }

        @Override // p375l.InterfaceC5875d
        public void onResponse(InterfaceC5873b<T> interfaceC5873b, C5884m<T> c5884m) {
            if (this.f21338c) {
                return;
            }
            try {
                this.f21337b.onNext(c5884m);
                if (this.f21338c) {
                    return;
                }
                this.f21339d = true;
                this.f21337b.onComplete();
            } catch (Throwable th) {
                if (this.f21339d) {
                    C4476a.m17152b(th);
                    return;
                }
                if (this.f21338c) {
                    return;
                }
                try {
                    this.f21337b.onError(th);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    C4476a.m17152b(new C4560a(th, th2));
                }
            }
        }
    }

    C5889b(InterfaceC5873b<T> interfaceC5873b) {
        this.f21335a = interfaceC5873b;
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super C5884m<T>> interfaceC4514i0) {
        InterfaceC5873b<T> clone = this.f21335a.clone();
        a aVar = new a(clone, interfaceC4514i0);
        interfaceC4514i0.onSubscribe(aVar);
        clone.mo24747a(aVar);
    }
}
