package h.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: FlowableUsing.java */
/* JADX INFO: loaded from: classes2.dex */
public final class k4<T, D> extends h.a.l<T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Callable<? extends D> f10744b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super D, ? extends j.d.b<? extends T>> f10745c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.g<? super D> f10746d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f10747e;

    /* JADX INFO: compiled from: FlowableUsing.java */
    static final class a<T, D> extends AtomicBoolean implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = 5904473792286235046L;
        final j.d.c<? super T> actual;
        final h.a.x0.g<? super D> disposer;
        final boolean eager;
        final D resource;
        j.d.d s;

        a(j.d.c<? super T> cVar, D d2, h.a.x0.g<? super D> gVar, boolean z) {
            this.actual = cVar;
            this.resource = d2;
            this.disposer = gVar;
            this.eager = z;
        }

        @Override // j.d.d
        public void cancel() {
            disposeAfter();
            this.s.cancel();
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

        @Override // j.d.c
        public void onComplete() {
            if (!this.eager) {
                this.actual.onComplete();
                this.s.cancel();
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
            this.s.cancel();
            this.actual.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (!this.eager) {
                this.actual.onError(th);
                this.s.cancel();
                disposeAfter();
                return;
            }
            Throwable th2 = null;
            if (compareAndSet(false, true)) {
                try {
                    this.disposer.accept(this.resource);
                } catch (Throwable th3) {
                    th2 = th3;
                    h.a.v0.b.b(th2);
                }
            }
            this.s.cancel();
            if (th2 != null) {
                this.actual.onError(new h.a.v0.a(th, th2));
            } else {
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            this.actual.onNext(t);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.s.request(j2);
        }
    }

    public k4(Callable<? extends D> callable, h.a.x0.o<? super D, ? extends j.d.b<? extends T>> oVar, h.a.x0.g<? super D> gVar, boolean z) {
        this.f10744b = callable;
        this.f10745c = oVar;
        this.f10746d = gVar;
        this.f10747e = z;
    }

    @Override // h.a.l
    public void d(j.d.c<? super T> cVar) {
        try {
            D dCall = this.f10744b.call();
            try {
                ((j.d.b) h.a.y0.b.b.a(this.f10745c.apply(dCall), "The sourceSupplier returned a null Publisher")).subscribe(new a(cVar, dCall, this.f10746d, this.f10747e));
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                try {
                    this.f10746d.accept(dCall);
                    h.a.y0.i.g.error(th, cVar);
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    h.a.y0.i.g.error(new h.a.v0.a(th, th2), cVar);
                }
            }
        } catch (Throwable th3) {
            h.a.v0.b.b(th3);
            h.a.y0.i.g.error(th3, cVar);
        }
    }
}
