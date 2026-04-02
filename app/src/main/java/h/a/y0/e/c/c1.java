package h.a.y0.e.c;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: MaybeSubscribeOn.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c1<T> extends h.a.y0.e.c.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f11117b;

    /* JADX INFO: compiled from: MaybeSubscribeOn.java */
    static final class a<T> extends AtomicReference<h.a.u0.c> implements h.a.v<T>, h.a.u0.c {
        private static final long serialVersionUID = 8571289934935992137L;
        final h.a.v<? super T> actual;
        final h.a.y0.a.k task = new h.a.y0.a.k();

        a(h.a.v<? super T> vVar) {
            this.actual = vVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
            this.task.dispose();
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
            this.actual.onError(th);
        }

        @Override // h.a.v
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }

        @Override // h.a.v, h.a.n0
        public void onSuccess(T t) {
            this.actual.onSuccess(t);
        }
    }

    /* JADX INFO: compiled from: MaybeSubscribeOn.java */
    static final class b<T> implements Runnable {
        final h.a.v<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.y<T> f11118b;

        b(h.a.v<? super T> vVar, h.a.y<T> yVar) {
            this.a = vVar;
            this.f11118b = yVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f11118b.a(this.a);
        }
    }

    public c1(h.a.y<T> yVar, h.a.j0 j0Var) {
        super(yVar);
        this.f11117b = j0Var;
    }

    @Override // h.a.s
    protected void b(h.a.v<? super T> vVar) {
        a aVar = new a(vVar);
        vVar.onSubscribe(aVar);
        aVar.task.replace(this.f11117b.a(new b(aVar, this.a)));
    }
}
