package h.a.y0.g;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SchedulerWhen.java */
/* JADX INFO: loaded from: classes2.dex */
@h.a.t0.e
public class p extends j0 implements h.a.u0.c {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final h.a.u0.c f11978e = new g();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final h.a.u0.c f11979f = h.a.u0.d.a();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final j0 f11980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final h.a.d1.c<h.a.l<h.a.c>> f11981c = h.a.d1.g.a0().X();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private h.a.u0.c f11982d;

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static final class a implements h.a.x0.o<f, h.a.c> {
        final j0.c a;

        /* JADX INFO: renamed from: h.a.y0.g.p$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: SchedulerWhen.java */
        final class C0232a extends h.a.c {
            final f a;

            C0232a(f fVar) {
                this.a = fVar;
            }

            @Override // h.a.c
            protected void b(h.a.f fVar) {
                fVar.onSubscribe(this.a);
                this.a.call(a.this.a, fVar);
            }
        }

        a(j0.c cVar) {
            this.a = cVar;
        }

        @Override // h.a.x0.o
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public h.a.c apply(f fVar) {
            return new C0232a(fVar);
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static class b extends f {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        b(Runnable runnable, long j2, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j2;
            this.unit = timeUnit;
        }

        @Override // h.a.y0.g.p.f
        protected h.a.u0.c callActual(j0.c cVar, h.a.f fVar) {
            return cVar.a(new d(this.action, fVar), this.delayTime, this.unit);
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static class c extends f {
        private final Runnable action;

        c(Runnable runnable) {
            this.action = runnable;
        }

        @Override // h.a.y0.g.p.f
        protected h.a.u0.c callActual(j0.c cVar, h.a.f fVar) {
            return cVar.a(new d(this.action, fVar));
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static class d implements Runnable {
        final h.a.f a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Runnable f11984b;

        d(Runnable runnable, h.a.f fVar) {
            this.f11984b = runnable;
            this.a = fVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f11984b.run();
            } finally {
                this.a.onComplete();
            }
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static abstract class f extends AtomicReference<h.a.u0.c> implements h.a.u0.c {
        f() {
            super(p.f11978e);
        }

        void call(j0.c cVar, h.a.f fVar) {
            h.a.u0.c cVar2 = get();
            if (cVar2 != p.f11979f && cVar2 == p.f11978e) {
                h.a.u0.c cVarCallActual = callActual(cVar, fVar);
                if (compareAndSet(p.f11978e, cVarCallActual)) {
                    return;
                }
                cVarCallActual.dispose();
            }
        }

        protected abstract h.a.u0.c callActual(j0.c cVar, h.a.f fVar);

        @Override // h.a.u0.c
        public void dispose() {
            h.a.u0.c cVar;
            h.a.u0.c cVar2 = p.f11979f;
            do {
                cVar = get();
                if (cVar == p.f11979f) {
                    return;
                }
            } while (!compareAndSet(cVar, cVar2));
            if (cVar != p.f11978e) {
                cVar.dispose();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static final class g implements h.a.u0.c {
        g() {
        }

        @Override // h.a.u0.c
        public void dispose() {
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return false;
        }
    }

    public p(h.a.x0.o<h.a.l<h.a.l<h.a.c>>, h.a.c> oVar, j0 j0Var) {
        this.f11980b = j0Var;
        try {
            this.f11982d = oVar.apply(this.f11981c).l();
        } catch (Throwable th) {
            h.a.v0.b.a(th);
        }
    }

    @Override // h.a.j0
    @h.a.t0.f
    public j0.c a() {
        j0.c cVarA = this.f11980b.a();
        h.a.d1.c<T> cVarX = h.a.d1.g.a0().X();
        h.a.l<h.a.c> lVarO = cVarX.o(new a(cVarA));
        e eVar = new e(cVarX, cVarA);
        this.f11981c.onNext(lVarO);
        return eVar;
    }

    @Override // h.a.u0.c
    public void dispose() {
        this.f11982d.dispose();
    }

    @Override // h.a.u0.c
    public boolean isDisposed() {
        return this.f11982d.isDisposed();
    }

    /* JADX INFO: compiled from: SchedulerWhen.java */
    static final class e extends j0.c {
        private final AtomicBoolean a = new AtomicBoolean();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final h.a.d1.c<f> f11985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final j0.c f11986c;

        e(h.a.d1.c<f> cVar, j0.c cVar2) {
            this.f11985b = cVar;
            this.f11986c = cVar2;
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable, long j2, @h.a.t0.f TimeUnit timeUnit) {
            b bVar = new b(runnable, j2, timeUnit);
            this.f11985b.onNext(bVar);
            return bVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.a.compareAndSet(false, true)) {
                this.f11985b.onComplete();
                this.f11986c.dispose();
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.a.get();
        }

        @Override // h.a.j0.c
        @h.a.t0.f
        public h.a.u0.c a(@h.a.t0.f Runnable runnable) {
            c cVar = new c(runnable);
            this.f11985b.onNext(cVar);
            return cVar;
        }
    }
}
