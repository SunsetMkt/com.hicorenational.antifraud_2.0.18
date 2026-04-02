package h.a.y0.e.d;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ObservableUsing.java */
/* JADX INFO: loaded from: classes2.dex */
public final class x3<T, D> extends h.a.b0<T> {
    final Callable<? extends D> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super D, ? extends h.a.g0<? extends T>> f11706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.g<? super D> f11707c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final boolean f11708d;

    /* JADX INFO: compiled from: ObservableUsing.java */
    static final class a<T, D> extends AtomicBoolean implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = 5904473792286235046L;
        final h.a.i0<? super T> actual;
        final h.a.x0.g<? super D> disposer;
        final boolean eager;
        final D resource;
        h.a.u0.c s;

        a(h.a.i0<? super T> i0Var, D d2, h.a.x0.g<? super D> gVar, boolean z) {
            this.actual = i0Var;
            this.resource = d2;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            disposeAfter();
            this.s.dispose();
        }

        void disposeAfter() {
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get();
        }

        @Override // h.a.i0
        public void onComplete() {
            if (!this.eager) {
                this.actual.onComplete();
                this.s.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.actual.onError(th);
                    return;
                }
            }
            this.s.dispose();
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (!this.eager) {
                this.actual.onError(th);
                this.s.dispose();
                disposeAfter();
                return;
            }
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    th = new h.a.v0.a(th, th2);
                }
            }
            this.s.dispose();
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public x3(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends h.a.g0<? extends T>> oVar, h.a.x0.g<? super D> gVar, boolean z) {
        this.a = callable;
        this.f11706b = oVar;
        this.f11707c = gVar;
        this.f11708d = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        try {
            D dCall = this.a.call();
            try {
                ((h.a.g0) h.a.y0.b.b.a(this.f11706b.apply(dCall), "The sourceSupplier returned a null ObservableSource")).subscribe(new a(i0Var, dCall, this.f11707c, this.f11708d));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                try {
                    this.f11707c.accept(dCall);
                    h.a.y0.a.e.error(th, i0Var);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    h.a.y0.a.e.error(new h.a.v0.a(th, th2), i0Var);
                }
            }
        } catch (Throwable th3) {
            h.a.v0.b.b(th3);
            h.a.y0.a.e.error(th3, i0Var);
        }
    }
}
