package h.a.y0.e.b;

import h.a.j0;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableBufferTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q<T, U extends Collection<? super T>> extends h.a.y0.e.b.a<T, U> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10897c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f10898d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final TimeUnit f10899e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.j0 f10900f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Callable<U> f10901g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f10902h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f10903i;

    /* JADX INFO: compiled from: FlowableBufferTimed.java */
    static final class a<T, U extends Collection<? super T>> extends h.a.y0.h.m<T, U, U> implements j.d.d, Runnable, h.a.u0.c {
        final Callable<U> m0;
        final long n0;
        final TimeUnit o0;
        final int p0;
        final boolean q0;
        final j0.c r0;
        U s0;
        h.a.u0.c t0;
        j.d.d u0;
        long v0;
        long w0;

        a(j.d.c<? super U> cVar, Callable<U> callable, long j2, TimeUnit timeUnit, int i2, boolean z, j0.c cVar2) {
            super(cVar, new h.a.y0.f.a());
            this.m0 = callable;
            this.n0 = j2;
            this.o0 = timeUnit;
            this.p0 = i2;
            this.q0 = z;
            this.r0 = cVar2;
        }

        @Override // h.a.y0.h.m, h.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(j.d.c cVar, Object obj) {
            return a((j.d.c<? super Collection>) cVar, (Collection) obj);
        }

        @Override // j.d.d
        public void cancel() {
            if (this.j0) {
                return;
            }
            this.j0 = true;
            dispose();
        }

        @Override // h.a.u0.c
        public void dispose() {
            synchronized (this) {
                this.s0 = null;
            }
            this.u0.cancel();
            this.r0.dispose();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.r0.isDisposed();
        }

        @Override // j.d.c
        public void onComplete() {
            U u;
            synchronized (this) {
                u = this.s0;
                this.s0 = null;
            }
            this.i0.offer(u);
            this.k0 = true;
            if (b()) {
                h.a.y0.j.v.a((h.a.y0.c.n) this.i0, (j.d.c) this.h0, false, (h.a.u0.c) this, (h.a.y0.j.u) this);
            }
            this.r0.dispose();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            synchronized (this) {
                this.s0 = null;
            }
            this.h0.onError(th);
            this.r0.dispose();
        }

        @Override // j.d.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.s0;
                if (u == null) {
                    return;
                }
                u.add(t);
                if (u.size() < this.p0) {
                    return;
                }
                this.s0 = null;
                this.v0++;
                if (this.q0) {
                    this.t0.dispose();
                }
                b(u, false, this);
                try {
                    U u2 = (U) h.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    synchronized (this) {
                        this.s0 = u2;
                        this.w0++;
                    }
                    if (this.q0) {
                        j0.c cVar = this.r0;
                        long j2 = this.n0;
                        this.t0 = cVar.a(this, j2, j2, this.o0);
                    }
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    this.h0.onError(th);
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.u0, dVar)) {
                this.u0 = dVar;
                try {
                    this.s0 = (U) h.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    this.h0.onSubscribe(this);
                    j0.c cVar = this.r0;
                    long j2 = this.n0;
                    this.t0 = cVar.a(this, j2, j2, this.o0);
                    dVar.request(i.q2.t.m0.f12222b);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.r0.dispose();
                    dVar.cancel();
                    h.a.y0.i.g.error(th, this.h0);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                U u = (U) h.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    U u2 = this.s0;
                    if (u2 != null && this.v0 == this.w0) {
                        this.s0 = u;
                        b(u2, false, this);
                    }
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(j.d.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }
    }

    /* JADX INFO: compiled from: FlowableBufferTimed.java */
    static final class b<T, U extends Collection<? super T>> extends h.a.y0.h.m<T, U, U> implements j.d.d, Runnable, h.a.u0.c {
        final Callable<U> m0;
        final long n0;
        final TimeUnit o0;
        final h.a.j0 p0;
        j.d.d q0;
        U r0;
        final AtomicReference<h.a.u0.c> s0;

        b(j.d.c<? super U> cVar, Callable<U> callable, long j2, TimeUnit timeUnit, h.a.j0 j0Var) {
            super(cVar, new h.a.y0.f.a());
            this.s0 = new AtomicReference<>();
            this.m0 = callable;
            this.n0 = j2;
            this.o0 = timeUnit;
            this.p0 = j0Var;
        }

        @Override // h.a.y0.h.m, h.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(j.d.c cVar, Object obj) {
            return a((j.d.c<? super Collection>) cVar, (Collection) obj);
        }

        @Override // j.d.d
        public void cancel() {
            this.q0.cancel();
            h.a.y0.a.d.dispose(this.s0);
        }

        @Override // h.a.u0.c
        public void dispose() {
            cancel();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.s0.get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // j.d.c
        public void onComplete() {
            h.a.y0.a.d.dispose(this.s0);
            synchronized (this) {
                U u = this.r0;
                if (u == null) {
                    return;
                }
                this.r0 = null;
                this.i0.offer(u);
                this.k0 = true;
                if (b()) {
                    h.a.y0.j.v.a((h.a.y0.c.n) this.i0, (j.d.c) this.h0, false, (h.a.u0.c) this, (h.a.y0.j.u) this);
                }
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            h.a.y0.a.d.dispose(this.s0);
            synchronized (this) {
                this.r0 = null;
            }
            this.h0.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            synchronized (this) {
                U u = this.r0;
                if (u != null) {
                    u.add(t);
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                try {
                    this.r0 = (U) h.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    this.h0.onSubscribe(this);
                    if (this.j0) {
                        return;
                    }
                    dVar.request(i.q2.t.m0.f12222b);
                    h.a.j0 j0Var = this.p0;
                    long j2 = this.n0;
                    h.a.u0.c cVarA = j0Var.a(this, j2, j2, this.o0);
                    if (this.s0.compareAndSet(null, cVarA)) {
                        return;
                    }
                    cVarA.dispose();
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    cancel();
                    h.a.y0.i.g.error(th, this.h0);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }

        @Override // java.lang.Runnable
        public void run() {
            U u;
            try {
                U u2 = (U) h.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    u = this.r0;
                    if (u != null) {
                        this.r0 = u2;
                    }
                }
                if (u == null) {
                    h.a.y0.a.d.dispose(this.s0);
                } else {
                    a(u, false, this);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        public boolean a(j.d.c<? super U> cVar, U u) {
            this.h0.onNext((Object) u);
            return true;
        }
    }

    /* JADX INFO: compiled from: FlowableBufferTimed.java */
    static final class c<T, U extends Collection<? super T>> extends h.a.y0.h.m<T, U, U> implements j.d.d, Runnable {
        final Callable<U> m0;
        final long n0;
        final long o0;
        final TimeUnit p0;
        final j0.c q0;
        final List<U> r0;
        j.d.d s0;

        /* JADX INFO: compiled from: FlowableBufferTimed.java */
        final class a implements Runnable {
            private final U a;

            a(U u) {
                this.a = u;
            }

            @Override // java.lang.Runnable
            public void run() {
                synchronized (c.this) {
                    c.this.r0.remove(this.a);
                }
                c cVar = c.this;
                cVar.b(this.a, false, cVar.q0);
            }
        }

        c(j.d.c<? super U> cVar, Callable<U> callable, long j2, long j3, TimeUnit timeUnit, j0.c cVar2) {
            super(cVar, new h.a.y0.f.a());
            this.m0 = callable;
            this.n0 = j2;
            this.o0 = j3;
            this.p0 = timeUnit;
            this.q0 = cVar2;
            this.r0 = new LinkedList();
        }

        @Override // h.a.y0.h.m, h.a.y0.j.u
        public /* bridge */ /* synthetic */ boolean a(j.d.c cVar, Object obj) {
            return a((j.d.c<? super Collection>) cVar, (Collection) obj);
        }

        @Override // j.d.d
        public void cancel() {
            f();
            this.s0.cancel();
            this.q0.dispose();
        }

        void f() {
            synchronized (this) {
                this.r0.clear();
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onComplete() {
            ArrayList arrayList;
            synchronized (this) {
                arrayList = new ArrayList(this.r0);
                this.r0.clear();
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                this.i0.offer((U) ((Collection) it.next()));
            }
            this.k0 = true;
            if (b()) {
                h.a.y0.j.v.a((h.a.y0.c.n) this.i0, (j.d.c) this.h0, false, (h.a.u0.c) this.q0, (h.a.y0.j.u) this);
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.k0 = true;
            this.q0.dispose();
            f();
            this.h0.onError(th);
        }

        @Override // j.d.c
        public void onNext(T t) {
            synchronized (this) {
                Iterator<U> it = this.r0.iterator();
                while (it.hasNext()) {
                    it.next().add(t);
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s0, dVar)) {
                this.s0 = dVar;
                try {
                    Collection collection = (Collection) h.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                    this.r0.add((U) collection);
                    this.h0.onSubscribe(this);
                    dVar.request(i.q2.t.m0.f12222b);
                    j0.c cVar = this.q0;
                    long j2 = this.o0;
                    cVar.a(this, j2, j2, this.p0);
                    this.q0.a(new a(collection), this.n0, this.p0);
                } catch (Throwable th) {
                    h.a.v0.b.b(th);
                    this.q0.dispose();
                    dVar.cancel();
                    h.a.y0.i.g.error(th, this.h0);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.j0) {
                return;
            }
            try {
                Collection collection = (Collection) h.a.y0.b.b.a(this.m0.call(), "The supplied buffer is null");
                synchronized (this) {
                    if (this.j0) {
                        return;
                    }
                    this.r0.add((U) collection);
                    this.q0.a(new a(collection), this.n0, this.p0);
                }
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                cancel();
                this.h0.onError(th);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public boolean a(j.d.c<? super U> cVar, U u) {
            cVar.onNext(u);
            return true;
        }
    }

    public q(h.a.l<T> lVar, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, Callable<U> callable, int i2, boolean z) {
        super(lVar);
        this.f10897c = j2;
        this.f10898d = j3;
        this.f10899e = timeUnit;
        this.f10900f = j0Var;
        this.f10901g = callable;
        this.f10902h = i2;
        this.f10903i = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super U> cVar) {
        if (this.f10897c == this.f10898d && this.f10902h == Integer.MAX_VALUE) {
            this.f10561b.a((h.a.q) new b(new h.a.g1.e(cVar), this.f10901g, this.f10897c, this.f10899e, this.f10900f));
            return;
        }
        j0.c cVarA = this.f10900f.a();
        if (this.f10897c == this.f10898d) {
            this.f10561b.a((h.a.q) new a(new h.a.g1.e(cVar), this.f10901g, this.f10897c, this.f10899e, this.f10902h, this.f10903i, cVarA));
        } else {
            this.f10561b.a((h.a.q) new c(new h.a.g1.e(cVar), this.f10901g, this.f10897c, this.f10898d, this.f10899e, cVarA));
        }
    }
}
