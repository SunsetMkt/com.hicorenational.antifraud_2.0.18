package p251g.p252a.p268y0.p281g;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4474c;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.p256d1.AbstractC4481c;
import p251g.p252a.p256d1.C4485g;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p267x0.InterfaceC4584o;

/* compiled from: SchedulerWhen.java */
@InterfaceC4545e
/* renamed from: g.a.y0.g.p */
/* loaded from: classes2.dex */
public class C5127p extends AbstractC4516j0 implements InterfaceC4552c {

    /* renamed from: e */
    static final InterfaceC4552c f19912e = new g();

    /* renamed from: f */
    static final InterfaceC4552c f19913f = C4553d.m18183a();

    /* renamed from: b */
    private final AbstractC4516j0 f19914b;

    /* renamed from: c */
    private final AbstractC4481c<AbstractC4519l<AbstractC4474c>> f19915c = C4485g.m17258a0().m17229X();

    /* renamed from: d */
    private InterfaceC4552c f19916d;

    /* compiled from: SchedulerWhen.java */
    /* renamed from: g.a.y0.g.p$a */
    static final class a implements InterfaceC4584o<f, AbstractC4474c> {

        /* renamed from: a */
        final AbstractC4516j0.c f19917a;

        /* compiled from: SchedulerWhen.java */
        /* renamed from: g.a.y0.g.p$a$a, reason: collision with other inner class name */
        final class C7427a extends AbstractC4474c {

            /* renamed from: a */
            final f f19918a;

            C7427a(f fVar) {
                this.f19918a = fVar;
            }

            @Override // p251g.p252a.AbstractC4474c
            /* renamed from: b */
            protected void mo17086b(InterfaceC4491f interfaceC4491f) {
                interfaceC4491f.onSubscribe(this.f19918a);
                this.f19918a.call(a.this.f19917a, interfaceC4491f);
            }
        }

        a(AbstractC4516j0.c cVar) {
            this.f19917a = cVar;
        }

        @Override // p251g.p252a.p267x0.InterfaceC4584o
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public AbstractC4474c apply(f fVar) {
            return new C7427a(fVar);
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: g.a.y0.g.p$b */
    static class b extends f {
        private final Runnable action;
        private final long delayTime;
        private final TimeUnit unit;

        b(Runnable runnable, long j2, TimeUnit timeUnit) {
            this.action = runnable;
            this.delayTime = j2;
            this.unit = timeUnit;
        }

        @Override // p251g.p252a.p268y0.p281g.C5127p.f
        protected InterfaceC4552c callActual(AbstractC4516j0.c cVar, InterfaceC4491f interfaceC4491f) {
            return cVar.mo17283a(new d(this.action, interfaceC4491f), this.delayTime, this.unit);
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: g.a.y0.g.p$c */
    static class c extends f {
        private final Runnable action;

        c(Runnable runnable) {
            this.action = runnable;
        }

        @Override // p251g.p252a.p268y0.p281g.C5127p.f
        protected InterfaceC4552c callActual(AbstractC4516j0.c cVar, InterfaceC4491f interfaceC4491f) {
            return cVar.mo17282a(new d(this.action, interfaceC4491f));
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: g.a.y0.g.p$d */
    static class d implements Runnable {

        /* renamed from: a */
        final InterfaceC4491f f19920a;

        /* renamed from: b */
        final Runnable f19921b;

        d(Runnable runnable, InterfaceC4491f interfaceC4491f) {
            this.f19921b = runnable;
            this.f19920a = interfaceC4491f;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f19921b.run();
            } finally {
                this.f19920a.onComplete();
            }
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: g.a.y0.g.p$f */
    static abstract class f extends AtomicReference<InterfaceC4552c> implements InterfaceC4552c {
        f() {
            super(C5127p.f19912e);
        }

        void call(AbstractC4516j0.c cVar, InterfaceC4491f interfaceC4491f) {
            InterfaceC4552c interfaceC4552c = get();
            if (interfaceC4552c != C5127p.f19913f && interfaceC4552c == C5127p.f19912e) {
                InterfaceC4552c callActual = callActual(cVar, interfaceC4491f);
                if (compareAndSet(C5127p.f19912e, callActual)) {
                    return;
                }
                callActual.dispose();
            }
        }

        protected abstract InterfaceC4552c callActual(AbstractC4516j0.c cVar, InterfaceC4491f interfaceC4491f);

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            InterfaceC4552c interfaceC4552c;
            InterfaceC4552c interfaceC4552c2 = C5127p.f19913f;
            do {
                interfaceC4552c = get();
                if (interfaceC4552c == C5127p.f19913f) {
                    return;
                }
            } while (!compareAndSet(interfaceC4552c, interfaceC4552c2));
            if (interfaceC4552c != C5127p.f19912e) {
                interfaceC4552c.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return get().isDisposed();
        }
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: g.a.y0.g.p$g */
    static final class g implements InterfaceC4552c {
        g() {
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return false;
        }
    }

    public C5127p(InterfaceC4584o<AbstractC4519l<AbstractC4519l<AbstractC4474c>>, AbstractC4474c> interfaceC4584o, AbstractC4516j0 abstractC4516j0) {
        this.f19914b = abstractC4516j0;
        try {
            this.f19916d = interfaceC4584o.apply(this.f19915c).m17109l();
        } catch (Throwable th) {
            C4561b.m18198a(th);
        }
    }

    @Override // p251g.p252a.AbstractC4516j0
    @InterfaceC4546f
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        AbstractC4516j0.c mo17277a = this.f19914b.mo17277a();
        AbstractC4481c<T> m17229X = C4485g.m17258a0().m17229X();
        AbstractC4519l<AbstractC4474c> m17978o = m17229X.m17978o(new a(mo17277a));
        e eVar = new e(m17229X, mo17277a);
        this.f19915c.onNext(m17978o);
        return eVar;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        this.f19916d.dispose();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f19916d.isDisposed();
    }

    /* compiled from: SchedulerWhen.java */
    /* renamed from: g.a.y0.g.p$e */
    static final class e extends AbstractC4516j0.c {

        /* renamed from: a */
        private final AtomicBoolean f19922a = new AtomicBoolean();

        /* renamed from: b */
        private final AbstractC4481c<f> f19923b;

        /* renamed from: c */
        private final AbstractC4516j0.c f19924c;

        e(AbstractC4481c<f> abstractC4481c, AbstractC4516j0.c cVar) {
            this.f19923b = abstractC4481c;
            this.f19924c = cVar;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17283a(@InterfaceC4546f Runnable runnable, long j2, @InterfaceC4546f TimeUnit timeUnit) {
            b bVar = new b(runnable, j2, timeUnit);
            this.f19923b.onNext(bVar);
            return bVar;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f19922a.compareAndSet(false, true)) {
                this.f19923b.onComplete();
                this.f19924c.dispose();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f19922a.get();
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        @InterfaceC4546f
        /* renamed from: a */
        public InterfaceC4552c mo17282a(@InterfaceC4546f Runnable runnable) {
            c cVar = new c(runnable);
            this.f19923b.onNext(cVar);
            return cVar;
        }
    }
}
