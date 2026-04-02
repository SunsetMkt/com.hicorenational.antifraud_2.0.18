package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeOnErrorNext.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z0<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.x0.o<? super Throwable, ? extends h.a.y<? extends T>> f11210b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final boolean f11211c;

    /* JADX INFO: compiled from: MaybeOnErrorNext.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 2026620218879969836L;
        final h.a.v<? super T> actual;
        final boolean allowFatal;
        final h.a.x0.o<? super Throwable, ? extends h.a.y<? extends T>> resumeFunction;

        /* JADX INFO: renamed from: h.a.y0.e.c.z0$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: MaybeOnErrorNext.java */
        static final class C0208a<T> implements h.a.v<T> {
            final h.a.v<? super T> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final AtomicReference<h.a.u0.c> f11212b;

            C0208a(h.a.v<? super T> vVar, AtomicReference<h.a.u0.c> atomicReference) {
                this.a = vVar;
                this.f11212b = atomicReference;
            }

            @Override // h.a.v
            public void onComplete() {
                this.a.onComplete();
            }

            @Override // h.a.v
            public void onError(Throwable th) {
                this.a.onError(th);
            }

            @Override // h.a.v
            public void onSubscribe(h.a.u0.c cVar) {
                h.a.y0.a.d.setOnce(this.f11212b, cVar);
            }

            @Override // h.a.v, h.a.n0
            public void onSuccess(T t) {
                this.a.onSuccess(t);
            }
        }

        a(h.a.v<? super T> vVar, h.a.x0.o<? super Throwable, ? extends h.a.y<? extends T>> oVar, boolean z) {
            this.actual = vVar;
            this.resumeFunction = oVar;
            this.allowFatal = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.v
        public void onComplete() {
            this.actual.onComplete();
        }

        @Override // h.a.v
        public void onError(Throwable th) {
            if (!this.allowFatal && !(th instanceof Exception)) {
                this.actual.onError(th);
                return;
            }
            try {
                h.a.y yVar = (h.a.y) h.a.y0.b.b.a(this.resumeFunction.apply(th), "The resumeFunction returned a null MaybeSource");
                h.a.y0.a.d.replace(this, null);
                yVar.a(new C0208a(this.actual, this));
            } catch (Throwable th2) {
                h.a.v0.b.b(th2);
                this.actual.onError(new h.a.v0.a(th, th2));
            }
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.setOnce(this, cVar)) {
                this.actual.onSubscribe(this);
            }
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    public z0(h.a.y<T> yVar, h.a.x0.o<? super Throwable, ? extends h.a.y<? extends T>> oVar, boolean z) {
        super(yVar);
        this.f11210b = oVar;
        this.f11211c = z;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        this.a.a(new a(vVar, this.f11210b, this.f11211c));
    }
}
