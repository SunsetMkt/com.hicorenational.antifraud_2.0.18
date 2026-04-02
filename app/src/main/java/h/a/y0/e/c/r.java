package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: MaybeDoFinally.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public final class r<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.a f11182b;

    /* JADX INFO: compiled from: MaybeDoFinally.java */
    static final class a<T> extends AtomicInteger implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 4109457741734051389L;
        final h.a.v<? super T> actual;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        h.a.u0.c f11183d;
        final h.a.x0.a onFinally;

        a(h.a.v<? super T> vVar, h.a.x0.a aVar) {
            this.actual = vVar;
            this.onFinally = aVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11183d.dispose();
            runFinally();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11183d.isDisposed();
        }

        @Override // h.a.v
        public void onComplete() {
            this.actual.onComplete();
            runFinally();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            this.actual.onError(th);
            runFinally();
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11183d, cVar)) {
                this.f11183d = cVar;
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
            runFinally();
        }

        void runFinally() {
            if (compareAndSet(0, 1)) {
                try {
                    this.onFinally.run();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    h.a.c1.a.b(th);
                }
            }
        }
    }

    public r(h.a.y<T> yVar, h.a.x0.a aVar) {
        super(yVar);
        this.f11182b = aVar;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11182b));
    }
}
