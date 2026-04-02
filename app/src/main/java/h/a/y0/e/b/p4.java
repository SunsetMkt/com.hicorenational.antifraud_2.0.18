package h.a.y0.e.b;

import h.a.j0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: FlowableWindowTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p4<T> extends h.a.y0.e.b.a<T, h.a.l<T>> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10887c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f10888d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final TimeUnit f10889e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.j0 f10890f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final long f10891g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final int f10892h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final boolean f10893i;

    /* JADX INFO: compiled from: FlowableWindowTimed.java */
    static final class a<T> extends h.a.y0.h.m<T, Object, h.a.l<T>> implements j.d.d {
        final long m0;
        final TimeUnit n0;
        final h.a.j0 o0;
        final int p0;
        final boolean q0;
        final long r0;
        final j0.c s0;
        long t0;
        long u0;
        j.d.d v0;
        h.a.d1.g<T> w0;
        volatile boolean x0;
        final h.a.y0.a.k y0;

        /* JADX INFO: renamed from: h.a.y0.e.b.p4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: FlowableWindowTimed.java */
        static final class RunnableC0195a implements Runnable {
            final long a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final a<?> f10894b;

            RunnableC0195a(long j2, a<?> aVar) {
                this.a = j2;
                this.f10894b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f10894b;
                if (((h.a.y0.h.m) aVar).j0) {
                    aVar.x0 = true;
                    aVar.dispose();
                } else {
                    ((h.a.y0.h.m) aVar).i0.offer(this);
                }
                if (aVar.b()) {
                    aVar.f();
                }
            }
        }

        a(j.d.c<? super h.a.l<T>> cVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2, long j3, boolean z) {
            super(cVar, new h.a.y0.f.a());
            this.y0 = new h.a.y0.a.k();
            this.m0 = j2;
            this.n0 = timeUnit;
            this.o0 = j0Var;
            this.p0 = i2;
            this.r0 = j3;
            this.q0 = z;
            if (z) {
                this.s0 = j0Var.a();
            } else {
                this.s0 = null;
            }
        }

        @Override // j.d.d
        public void cancel() {
            this.j0 = true;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this.y0);
            j0.c cVar = this.s0;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0066  */
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void f() {
            h.a.y0.c.o oVar = this.i0;
            j.d.c<? super V> cVar = this.h0;
            h.a.d1.g<T> gVar = this.w0;
            int iA = 1;
            while (!this.x0) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof RunnableC0195a;
                if (z && (z2 || z3)) {
                    this.w0 = null;
                    oVar.clear();
                    Throwable th = this.l0;
                    if (th != null) {
                        ((h.a.d1.g) gVar).onError(th);
                    } else {
                        ((h.a.d1.g) gVar).onComplete();
                    }
                    dispose();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else {
                    int i2 = iA;
                    if (z3) {
                        RunnableC0195a runnableC0195a = (RunnableC0195a) objPoll;
                        if (!this.q0) {
                            gVar = gVar;
                            if (this.u0 == runnableC0195a.a) {
                                ((h.a.d1.g) gVar).onComplete();
                                this.t0 = 0L;
                                h.a.d1.g<T> gVarM = h.a.d1.g.m(this.p0);
                                this.w0 = gVarM;
                                long jRequested = requested();
                                if (jRequested == 0) {
                                    this.w0 = null;
                                    this.i0.clear();
                                    this.v0.cancel();
                                    cVar.onError(new h.a.v0.c("Could not deliver first window due to lack of requests."));
                                    dispose();
                                    return;
                                }
                                cVar.onNext(gVarM);
                                gVar = gVarM;
                                if (jRequested != i.q2.t.m0.f12222b) {
                                    a(1L);
                                    gVar = gVarM;
                                }
                            }
                        }
                    } else {
                        ((h.a.d1.g) gVar).onNext(h.a.y0.j.q.getValue(objPoll));
                        long j2 = this.t0 + 1;
                        if (j2 >= this.r0) {
                            this.u0++;
                            this.t0 = 0L;
                            ((h.a.d1.g) gVar).onComplete();
                            long jRequested2 = requested();
                            if (jRequested2 == 0) {
                                this.w0 = null;
                                this.v0.cancel();
                                this.h0.onError(new h.a.v0.c("Could not deliver window due to lack of requests"));
                                dispose();
                                return;
                            }
                            h.a.d1.g<T> gVarM2 = h.a.d1.g.m(this.p0);
                            this.w0 = gVarM2;
                            this.h0.onNext(gVarM2);
                            if (jRequested2 != i.q2.t.m0.f12222b) {
                                a(1L);
                            }
                            if (this.q0) {
                                h.a.u0.c cVar2 = this.y0.get();
                                cVar2.dispose();
                                j0.c cVar3 = this.s0;
                                RunnableC0195a runnableC0195a2 = new RunnableC0195a(this.u0, this);
                                long j3 = this.m0;
                                h.a.u0.c cVarA = cVar3.a(runnableC0195a2, j3, j3, this.n0);
                                if (!this.y0.compareAndSet(cVar2, cVarA)) {
                                    cVarA.dispose();
                                }
                            }
                            gVar = gVarM2;
                        } else {
                            this.t0 = j2;
                            gVar = gVar;
                        }
                    }
                    iA = i2;
                }
            }
            this.v0.cancel();
            oVar.clear();
            dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onComplete();
            dispose();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onError(th);
            dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.x0) {
                return;
            }
            if (e()) {
                h.a.d1.g<T> gVar = this.w0;
                gVar.onNext(t);
                long j2 = this.t0 + 1;
                if (j2 >= this.r0) {
                    this.u0++;
                    this.t0 = 0L;
                    gVar.onComplete();
                    long jRequested = requested();
                    if (jRequested == 0) {
                        this.w0 = null;
                        this.v0.cancel();
                        this.h0.onError(new h.a.v0.c("Could not deliver window due to lack of requests"));
                        dispose();
                        return;
                    }
                    h.a.d1.g<T> gVarM = h.a.d1.g.m(this.p0);
                    this.w0 = gVarM;
                    this.h0.onNext(gVarM);
                    if (jRequested != i.q2.t.m0.f12222b) {
                        a(1L);
                    }
                    if (this.q0) {
                        h.a.u0.c cVar = this.y0.get();
                        cVar.dispose();
                        j0.c cVar2 = this.s0;
                        RunnableC0195a runnableC0195a = new RunnableC0195a(this.u0, this);
                        long j3 = this.m0;
                        h.a.u0.c cVarA = cVar2.a(runnableC0195a, j3, j3, this.n0);
                        if (!this.y0.compareAndSet(cVar, cVarA)) {
                            cVarA.dispose();
                        }
                    }
                } else {
                    this.t0 = j2;
                }
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
            h.a.u0.c cVarA;
            if (h.a.y0.i.j.validate(this.v0, dVar)) {
                this.v0 = dVar;
                j.d.c<? super V> cVar = this.h0;
                cVar.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                h.a.d1.g<T> gVarM = h.a.d1.g.m(this.p0);
                this.w0 = gVarM;
                long jRequested = requested();
                if (jRequested == 0) {
                    this.j0 = true;
                    dVar.cancel();
                    cVar.onError(new h.a.v0.c("Could not deliver initial window due to lack of requests."));
                    return;
                }
                cVar.onNext(gVarM);
                if (jRequested != i.q2.t.m0.f12222b) {
                    a(1L);
                }
                RunnableC0195a runnableC0195a = new RunnableC0195a(this.u0, this);
                if (this.q0) {
                    j0.c cVar2 = this.s0;
                    long j2 = this.m0;
                    cVarA = cVar2.a(runnableC0195a, j2, j2, this.n0);
                } else {
                    h.a.j0 j0Var = this.o0;
                    long j3 = this.m0;
                    cVarA = j0Var.a(runnableC0195a, j3, j3, this.n0);
                }
                if (this.y0.replace(cVarA)) {
                    dVar.request(i.q2.t.m0.f12222b);
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }
    }

    /* JADX INFO: compiled from: FlowableWindowTimed.java */
    static final class b<T> extends h.a.y0.h.m<T, Object, h.a.l<T>> implements h.a.q<T>, j.d.d, Runnable {
        static final Object u0 = new Object();
        final long m0;
        final TimeUnit n0;
        final h.a.j0 o0;
        final int p0;
        j.d.d q0;
        h.a.d1.g<T> r0;
        final h.a.y0.a.k s0;
        volatile boolean t0;

        b(j.d.c<? super h.a.l<T>> cVar, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2) {
            super(cVar, new h.a.y0.f.a());
            this.s0 = new h.a.y0.a.k();
            this.m0 = j2;
            this.n0 = timeUnit;
            this.o0 = j0Var;
            this.p0 = i2;
        }

        @Override // j.d.d
        public void cancel() {
            this.j0 = true;
        }

        public void dispose() {
            h.a.y0.a.d.dispose(this.s0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0024, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x0028, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002b, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0018, code lost:
        
            r10.r0 = null;
            r0.clear();
            dispose();
            r0 = r10.l0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0022, code lost:
        
            if (r0 == null) goto L11;
         */
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
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        void f() {
            h.a.y0.c.o oVar = this.i0;
            j.d.c<? super V> cVar = this.h0;
            h.a.d1.g<T> gVar = this.r0;
            int iA = 1;
            while (true) {
                boolean z = this.t0;
                boolean z2 = this.k0;
                Object objPoll = oVar.poll();
                if (z2 && (objPoll == null || objPoll == u0)) {
                    break;
                }
                if (objPoll == null) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll == u0) {
                    gVar.onComplete();
                    if (z) {
                        this.q0.cancel();
                    } else {
                        gVar = (h.a.d1.g<T>) h.a.d1.g.m(this.p0);
                        this.r0 = gVar;
                        long jRequested = requested();
                        if (jRequested == 0) {
                            this.r0 = null;
                            this.i0.clear();
                            this.q0.cancel();
                            dispose();
                            cVar.onError(new h.a.v0.c("Could not deliver first window due to lack of requests."));
                            return;
                        }
                        cVar.onNext(gVar);
                        if (jRequested != i.q2.t.m0.f12222b) {
                            a(1L);
                        }
                    }
                } else {
                    gVar.onNext(h.a.y0.j.q.getValue(objPoll));
                }
            }
        }

        @Override // j.d.c
        public void onComplete() {
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onComplete();
            dispose();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onError(th);
            dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (this.t0) {
                return;
            }
            if (e()) {
                this.r0.onNext(t);
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
            if (h.a.y0.i.j.validate(this.q0, dVar)) {
                this.q0 = dVar;
                this.r0 = h.a.d1.g.m(this.p0);
                j.d.c<? super V> cVar = this.h0;
                cVar.onSubscribe(this);
                long jRequested = requested();
                if (jRequested == 0) {
                    this.j0 = true;
                    dVar.cancel();
                    cVar.onError(new h.a.v0.c("Could not deliver first window due to lack of requests."));
                    return;
                }
                cVar.onNext(this.r0);
                if (jRequested != i.q2.t.m0.f12222b) {
                    a(1L);
                }
                if (this.j0) {
                    return;
                }
                h.a.y0.a.k kVar = this.s0;
                h.a.j0 j0Var = this.o0;
                long j2 = this.m0;
                if (kVar.replace(j0Var.a(this, j2, j2, this.n0))) {
                    dVar.request(i.q2.t.m0.f12222b);
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
                this.t0 = true;
                dispose();
            }
            this.i0.offer((U) u0);
            if (b()) {
                f();
            }
        }
    }

    /* JADX INFO: compiled from: FlowableWindowTimed.java */
    static final class c<T> extends h.a.y0.h.m<T, Object, h.a.l<T>> implements j.d.d, Runnable {
        final long m0;
        final long n0;
        final TimeUnit o0;
        final j0.c p0;
        final int q0;
        final List<h.a.d1.g<T>> r0;
        j.d.d s0;
        volatile boolean t0;

        /* JADX INFO: compiled from: FlowableWindowTimed.java */
        final class a implements Runnable {
            private final h.a.d1.g<T> a;

            a(h.a.d1.g<T> gVar) {
                this.a = gVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.a);
            }
        }

        /* JADX INFO: compiled from: FlowableWindowTimed.java */
        static final class b<T> {
            final h.a.d1.g<T> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final boolean f10896b;

            b(h.a.d1.g<T> gVar, boolean z) {
                this.a = gVar;
                this.f10896b = z;
            }
        }

        c(j.d.c<? super h.a.l<T>> cVar, long j2, long j3, TimeUnit timeUnit, j0.c cVar2, int i2) {
            super(cVar, new h.a.y0.f.a());
            this.m0 = j2;
            this.n0 = j3;
            this.o0 = timeUnit;
            this.p0 = cVar2;
            this.q0 = i2;
            this.r0 = new LinkedList();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(h.a.d1.g<T> gVar) {
            this.i0.offer((U) new b(gVar, false));
            if (b()) {
                f();
            }
        }

        @Override // j.d.d
        public void cancel() {
            this.j0 = true;
        }

        public void dispose() {
            this.p0.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void f() {
            h.a.y0.c.o oVar = this.i0;
            j.d.c<? super V> cVar = this.h0;
            List<h.a.d1.g<T>> list = this.r0;
            int iA = 1;
            while (!this.t0) {
                boolean z = this.k0;
                Object objPoll = oVar.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof b;
                if (z && (z2 || z3)) {
                    oVar.clear();
                    Throwable th = this.l0;
                    if (th != null) {
                        Iterator<h.a.d1.g<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<h.a.d1.g<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    list.clear();
                    dispose();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) objPoll;
                    if (!bVar.f10896b) {
                        list.remove(bVar.a);
                        bVar.a.onComplete();
                        if (list.isEmpty() && this.j0) {
                            this.t0 = true;
                        }
                    } else if (!this.j0) {
                        long jRequested = requested();
                        if (jRequested != 0) {
                            h.a.d1.g<T> gVarM = h.a.d1.g.m(this.q0);
                            list.add(gVarM);
                            cVar.onNext(gVarM);
                            if (jRequested != i.q2.t.m0.f12222b) {
                                a(1L);
                            }
                            this.p0.a(new a(gVarM), this.m0, this.o0);
                        } else {
                            cVar.onError(new h.a.v0.c("Can't emit window due to lack of requests"));
                        }
                    }
                } else {
                    Iterator<h.a.d1.g<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.s0.cancel();
            dispose();
            oVar.clear();
            list.clear();
        }

        @Override // j.d.c
        public void onComplete() {
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onComplete();
            dispose();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.l0 = th;
            this.k0 = true;
            if (b()) {
                f();
            }
            this.h0.onError(th);
            dispose();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // j.d.c
        public void onNext(T t) {
            if (e()) {
                Iterator<h.a.d1.g<T>> it = this.r0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.i0.offer((U) t);
                if (!b()) {
                    return;
                }
            }
            f();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s0, dVar)) {
                this.s0 = dVar;
                this.h0.onSubscribe(this);
                if (this.j0) {
                    return;
                }
                long jRequested = requested();
                if (jRequested == 0) {
                    dVar.cancel();
                    this.h0.onError(new h.a.v0.c("Could not emit the first window due to lack of requests"));
                    return;
                }
                h.a.d1.g<T> gVarM = h.a.d1.g.m(this.q0);
                this.r0.add(gVarM);
                this.h0.onNext(gVarM);
                if (jRequested != i.q2.t.m0.f12222b) {
                    a(1L);
                }
                this.p0.a(new a(gVarM), this.m0, this.o0);
                j0.c cVar = this.p0;
                long j2 = this.n0;
                cVar.a(this, j2, j2, this.o0);
                dVar.request(i.q2.t.m0.f12222b);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            b(j2);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            Object bVar = new b(h.a.d1.g.m(this.q0), true);
            if (!this.j0) {
                this.i0.offer((U) bVar);
            }
            if (b()) {
                f();
            }
        }
    }

    public p4(h.a.l<T> lVar, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, long j4, int i2, boolean z) {
        super(lVar);
        this.f10887c = j2;
        this.f10888d = j3;
        this.f10889e = timeUnit;
        this.f10890f = j0Var;
        this.f10891g = j4;
        this.f10892h = i2;
        this.f10893i = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super h.a.l<T>> cVar) {
        h.a.g1.e eVar = new h.a.g1.e(cVar);
        long j2 = this.f10887c;
        long j3 = this.f10888d;
        if (j2 != j3) {
            this.f10561b.a((h.a.q) new c(eVar, j2, j3, this.f10889e, this.f10890f.a(), this.f10892h));
            return;
        }
        long j4 = this.f10891g;
        if (j4 == i.q2.t.m0.f12222b) {
            this.f10561b.a((h.a.q) new b(eVar, j2, this.f10889e, this.f10890f, this.f10892h));
        } else {
            this.f10561b.a((h.a.q) new a(eVar, j2, this.f10889e, this.f10890f, this.f10892h, j4, this.f10893i));
        }
    }
}
