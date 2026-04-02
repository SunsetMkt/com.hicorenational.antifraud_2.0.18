package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: ObservableRepeatUntil.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k2<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.e f11446b;

    /* JADX INFO: compiled from: ObservableRepeatUntil.java */
    static final class a<T> extends AtomicInteger implements h.a.i0<T> {
        private static final long serialVersionUID = -7098360935104053232L;
        final h.a.i0<? super T> actual;
        final h.a.y0.a.k sd;
        final h.a.g0<? extends T> source;
        final h.a.x0.e stop;

        a(h.a.i0<? super T> i0Var, h.a.x0.e eVar, h.a.y0.a.k kVar, h.a.g0<? extends T> g0Var) {
            this.actual = i0Var;
            this.sd = kVar;
            this.source = g0Var;
            this.stop = eVar;
        }

        @Override // h.a.i0
        public void onComplete() {
            try {
                if (this.stop.getAsBoolean()) {
                    this.actual.onComplete();
                } else {
                    subscribeNext();
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.actual.onError(th);
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.sd.replace(cVar);
        }

        void subscribeNext() {
            if (getAndIncrement() == 0) {
                int iAddAndGet = 1;
                do {
                    this.source.subscribe(this);
                    iAddAndGet = addAndGet(-iAddAndGet);
                } while (iAddAndGet != 0);
            }
        }
    }

    public k2(h.a.b0<T> b0Var, h.a.x0.e eVar) {
        super(b0Var);
        this.f11446b = eVar;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        h.a.y0.a.k kVar = new h.a.y0.a.k();
        i0Var.onSubscribe(kVar);
        new a(i0Var, this.f11446b, kVar, this.a).subscribeNext();
    }
}
