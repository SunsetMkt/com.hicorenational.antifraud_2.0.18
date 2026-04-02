package h.a.y0.e.d;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: ObservableBuffer.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m<T, U extends Collection<? super T>> extends h.a.y0.e.d.a<T, U> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f11461b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final int f11462c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<U> f11463d;

    /* JADX INFO: compiled from: ObservableBuffer.java */
    static final class a<T, U extends Collection<? super T>> implements h.a.i0<T>, h.a.u0.c {
        final h.a.i0<? super U> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f11464b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Callable<U> f11465c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        U f11466d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f11467e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        h.a.u0.c f11468f;

        a(h.a.i0<? super U> i0Var, int i2, Callable<U> callable) {
            this.a = i0Var;
            this.f11464b = i2;
            this.f11465c = callable;
        }

        boolean a() {
            try {
                this.f11466d = (U) h.a.y0.b.b.a(this.f11465c.call(), "Empty buffer supplied");
                return true;
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.f11466d = null;
                h.a.u0.c cVar = this.f11468f;
                if (cVar == null) {
                    h.a.y0.a.e.error(th, this.a);
                    return false;
                }
                cVar.dispose();
                this.a.onError(th);
                return false;
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11468f.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11468f.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            U u = this.f11466d;
            this.f11466d = null;
            if (u != null && !u.isEmpty()) {
                this.a.onNext(u);
            }
            this.a.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.f11466d = null;
            this.a.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            U u = this.f11466d;
            if (u != null) {
                u.add(t);
                int i2 = this.f11467e + 1;
                this.f11467e = i2;
                if (i2 >= this.f11464b) {
                    this.a.onNext(u);
                    this.f11467e = 0;
                    a();
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.f11468f, cVar)) {
                this.f11468f = cVar;
                this.a.onSubscribe(this);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableBuffer.java */
    static final class b<T, U extends Collection<? super T>> extends AtomicBoolean implements h.a.i0<T>, h.a.u0.c {
        private static final long serialVersionUID = -8223395059921494546L;
        final h.a.i0<? super U> actual;
        final Callable<U> bufferSupplier;
        final ArrayDeque<U> buffers = new ArrayDeque<>();
        final int count;
        long index;
        h.a.u0.c s;
        final int skip;

        b(h.a.i0<? super U> i0Var, int i2, int i3, Callable<U> callable) {
            this.actual = i0Var;
            this.count = i2;
            this.skip = i3;
            this.bufferSupplier = callable;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.s.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.s.isDisposed();
        }

        @Override // h.a.i0
        public void onComplete() {
            while (!this.buffers.isEmpty()) {
                this.actual.onNext(this.buffers.poll());
            }
            this.actual.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.buffers.clear();
            this.actual.onError(th);
        }

        @Override // h.a.i0
        public void onNext(T t) {
            long j2 = this.index;
            this.index = 1 + j2;
            if (j2 % ((long) this.skip) == 0) {
                try {
                    this.buffers.offer((U) ((Collection) h.a.y0.b.b.a(this.bufferSupplier.call(), "The bufferSupplier returned a null collection. Null values are generally not allowed in 2.x operators and sources.")));
                } catch (Throwable th) {
                    this.buffers.clear();
                    this.s.dispose();
                    this.actual.onError(th);
                    return;
                }
            }
            Iterator<U> it = this.buffers.iterator();
            while (it.hasNext()) {
                U next = it.next();
                next.add(t);
                if (this.count <= next.size()) {
                    it.remove();
                    this.actual.onNext(next);
                }
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.s, cVar)) {
                this.s = cVar;
                this.actual.onSubscribe(this);
            }
        }
    }

    public m(h.a.g0<T> g0Var, int i2, int i3, Callable<U> callable) {
        super(g0Var);
        this.f11461b = i2;
        this.f11462c = i3;
        this.f11463d = callable;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super U> i0Var) {
        int i2 = this.f11462c;
        int i3 = this.f11461b;
        if (i2 != i3) {
            this.a.subscribe(new b(i0Var, i3, i2, this.f11463d));
            return;
        }
        a aVar = new a(i0Var, i3, this.f11463d);
        if (aVar.a()) {
            this.a.subscribe(aVar);
        }
    }
}
