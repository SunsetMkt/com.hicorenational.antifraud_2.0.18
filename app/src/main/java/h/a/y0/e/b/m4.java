package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableWindowBoundary.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m4<T, B> extends h.a.y0.e.b.a<T, h.a.l<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<B> f10810c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10811d;

    /* JADX INFO: compiled from: FlowableWindowBoundary.java */
    static final class a<T, B> extends h.a.g1.b<B> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T, B> f10812b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10813c;

        a(b<T, B> bVar) {
            this.f10812b = bVar;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10813c) {
                return;
            }
            this.f10813c = true;
            this.f10812b.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10813c) {
                h.a.c1.a.b(th);
            } else {
                this.f10813c = true;
                this.f10812b.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(B b2) {
            if (this.f10813c) {
                return;
            }
            this.f10812b.g();
        }
    }

    /* JADX INFO: compiled from: FlowableWindowBoundary.java */
    static final class b<T, B> extends h.a.y0.h.m<T, Object, h.a.l<T>> implements j.d.d {
        static final Object s0 = new Object();
        final j.d.b<B> m0;
        final int n0;
        j.d.d o0;
        final AtomicReference<h.a.u0.c> p0;
        h.a.d1.g<T> q0;
        final AtomicLong r0;

        b(j.d.c<? super h.a.l<T>> cVar, j.d.b<B> bVar, int i2) {
            super(cVar, new h.a.y0.f.a());
            this.p0 = new AtomicReference<>();
            this.r0 = new AtomicLong();
            this.m0 = bVar;
            this.n0 = i2;
            this.r0.lazySet(1L);
        }

        @Override // h.a.y0.h.m, h.a.y0.j.u
        public boolean a(j.d.c<? super h.a.l<T>> cVar, Object obj) {
            return false;
        }

        @Override // j.d.d
        public void cancel() {
            this.j0 = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [h.a.d1.g<T>] */
        /* JADX WARN: Type inference fix 'apply assigned field type' failed
        java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
        	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:593)
        	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
        	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
        	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
         */
        void f() {
            h.a.y0.c.o oVar = this.i0;
            j.d.c<? super V> cVar = this.h0;
            h.a.d1.g<T> gVar = this.q0;
            int iA = 1;
            while (true) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                if (z && z2) {
                    h.a.y0.a.d.dispose(this.p0);
                    Throwable th = this.l0;
                    if (th != null) {
                        gVar.onError(th);
                        return;
                    } else {
                        gVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll == s0) {
                    gVar.onComplete();
                    if (this.r0.decrementAndGet() == 0) {
                        h.a.y0.a.d.dispose(this.p0);
                        return;
                    }
                    if (!this.j0) {
                        gVar = (h.a.d1.g<T>) h.a.d1.g.m(this.n0);
                        long jRequested = requested();
                        if (jRequested != 0) {
                            this.r0.getAndIncrement();
                            cVar.onNext(gVar);
                            if (jRequested != i.q2.t.m0.f12222b) {
                                a(1L);
                            }
                            this.q0 = gVar;
                        } else {
                            this.j0 = true;
                            cVar.onError(new h.a.v0.c("Could not deliver new window due to lack of requests"));
                        }
                    }
                } else {
                    gVar.onNext(h.a.y0.j.q.getValue(objPoll));
                }
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void g() {
            this.i0.offer((U) s0);
            if (b()) {
                f();
            }
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.k0) {
                return;
            }
            this.k0 = true;
            if (b()) {
                f();
            }
            if (this.r0.decrementAndGet() == 0) {
                h.a.y0.a.d.dispose(this.p0);
            }
            this.h0.onComplete();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.k0) {
                h.a.c1.a.b(th);
                return;
            }
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            if (this.r0.decrementAndGet() == 0) {
                h.a.y0.a.d.dispose(this.p0);
            }
            this.h0.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (e()) {
                this.q0.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.i0.offer((U) h.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            f();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.o0, dVar)) {
                this.o0 = dVar;
                j.d.c<? super V> cVar = this.h0;
                cVar.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                h.a.d1.g<T> gVarM = h.a.d1.g.m(this.n0);
                long jRequested = requested();
                if (jRequested == 0) {
                    cVar.onError(new h.a.v0.c("Could not deliver first window due to lack of requests"));
                    return;
                }
                cVar.onNext(gVarM);
                if (jRequested != i.q2.t.m0.f12222b) {
                    a(1L);
                }
                this.q0 = gVarM;
                a aVar = new a(this);
                if (this.p0.compareAndSet(null, aVar)) {
                    this.r0.getAndIncrement();
                    dVar.request(i.q2.t.m0.f12222b);
                    this.m0.subscribe(aVar);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }
    }

    public m4(h.a.l<T> lVar, j.d.b<B> bVar, int i2) {
        super(lVar);
        this.f10810c = bVar;
        this.f10811d = i2;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super h.a.l<T>> cVar) {
        this.f10561b.a((h.a.q) new b(new h.a.g1.e(cVar), this.f10810c, this.f10811d));
    }
}
