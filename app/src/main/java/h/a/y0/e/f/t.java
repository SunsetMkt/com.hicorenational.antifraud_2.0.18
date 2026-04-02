package h.a.y0.e.f;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: SingleEquals.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t<T> extends h.a.k0<Boolean> {
    final h.a.q0<? extends T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.q0<? extends T> f11885b;

    /* JADX INFO: compiled from: SingleEquals.java */
    static class a<T> implements h.a.n0<T> {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final h.a.u0.b f11886b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Object[] f11887c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final h.a.n0<? super Boolean> f11888d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final AtomicInteger f11889e;

        a(int i2, h.a.u0.b bVar, Object[] objArr, h.a.n0<? super Boolean> n0Var, AtomicInteger atomicInteger) {
            this.a = i2;
            this.f11886b = bVar;
            this.f11887c = objArr;
            this.f11888d = n0Var;
            this.f11889e = atomicInteger;
        }

        @Override // h.a.n0
        public void onError(Throwable th) {
            int i2;
            do {
                i2 = this.f11889e.get();
                if (i2 >= 2) {
                    h.a.c1.a.b(th);
                    return;
                }
            } while (!this.f11889e.compareAndSet(i2, 2));
            this.f11886b.dispose();
            this.f11888d.onError(th);
        }

        @Override // h.a.n0
        public void onSubscribe(h.a.u0.c cVar) {
            this.f11886b.b(cVar);
        }

        @Override // h.a.n0
        public void onSuccess(T t) {
            this.f11887c[this.a] = t;
            if (this.f11889e.incrementAndGet() == 2) {
                h.a.n0<? super Boolean> n0Var = this.f11888d;
                Object[] objArr = this.f11887c;
                n0Var.onSuccess(Boolean.valueOf(h.a.y0.b.b.a(objArr[0], objArr[1])));
            }
        }
    }

    public t(h.a.q0<? extends T> q0Var, h.a.q0<? extends T> q0Var2) {
        this.a = q0Var;
        this.f11885b = q0Var2;
    }

    @Override // h.a.k0
    protected void b(h.a.n0<? super Boolean> n0Var) {
        AtomicInteger atomicInteger = new AtomicInteger();
        Object[] objArr = {null, null};
        h.a.u0.b bVar = new h.a.u0.b();
        n0Var.onSubscribe(bVar);
        this.a.a(new a(0, bVar, objArr, n0Var, atomicInteger));
        this.f11885b.a(new a(1, bVar, objArr, n0Var, atomicInteger));
    }
}
