package h.a.y0.e.d;

import java.util.Iterator;

/* JADX INFO: compiled from: ObservableFromIterable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d1<T> extends h.a.b0<T> {
    final Iterable<? extends T> a;

    /* JADX INFO: compiled from: ObservableFromIterable.java */
    static final class a<T> extends h.a.y0.d.c<T> {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Iterator<? extends T> f11291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f11292c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11293d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        boolean f11294e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f11295f;

        a(h.a.i0<? super T> i0Var, Iterator<? extends T> it) {
            this.a = i0Var;
            this.f11291b = it;
        }

        void a() {
            while (!isDisposed()) {
                try {
                    this.a.onNext(h.a.y0.b.b.a((Object) this.f11291b.next(), "The iterator returned a null value"));
                    if (isDisposed()) {
                        return;
                    }
                    try {
                        if (!this.f11291b.hasNext()) {
                            if (isDisposed()) {
                                return;
                            }
                            this.a.onComplete();
                            return;
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.a.onError(th);
                        return;
                    }
                } catch (Throwable th2) {
                    h.a.v0.b.b(th2);
                    this.a.onError(th2);
                    return;
                }
            }
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.f11294e = true;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11292c = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11292c;
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.f11294e;
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() {
            if (this.f11294e) {
                return null;
            }
            if (!this.f11295f) {
                this.f11295f = true;
            } else if (!this.f11291b.hasNext()) {
                this.f11294e = true;
                return null;
            }
            return (T) h.a.y0.b.b.a((Object) this.f11291b.next(), "The iterator returned a null value");
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f11293d = true;
            return 1;
        }
    }

    public d1(Iterable<? extends T> iterable) {
        this.a = iterable;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        try {
            Iterator<? extends T> it = this.a.iterator();
            try {
                if (!it.hasNext()) {
                    h.a.y0.a.e.complete(i0Var);
                    return;
                }
                a aVar = new a(i0Var, it);
                i0Var.onSubscribe(aVar);
                if (aVar.f11293d) {
                    return;
                }
                aVar.a();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                h.a.y0.a.e.error(th, i0Var);
            }
        } catch (Throwable th2) {
            h.a.v0.b.b(th2);
            h.a.y0.a.e.error(th2, i0Var);
        }
    }
}
