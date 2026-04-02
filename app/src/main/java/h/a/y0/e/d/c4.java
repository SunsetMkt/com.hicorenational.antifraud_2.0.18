package h.a.y0.e.d;

import h.a.j0;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableWindowTimed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c4<T> extends h.a.y0.e.d.a<T, h.a.b0<T>> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11278b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11279c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f11280d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.j0 f11281e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f11282f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final int f11283g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final boolean f11284h;

    /* JADX INFO: compiled from: ObservableWindowTimed.java */
    static final class a<T> extends h.a.y0.d.w<T, Object, h.a.b0<T>> implements h.a.u0.c {
        final long K;
        final TimeUnit L;
        final h.a.j0 M;
        final int N;
        final boolean O;
        final long b0;
        final j0.c c0;
        long d0;
        long e0;
        h.a.u0.c f0;
        h.a.f1.j<T> g0;
        volatile boolean h0;
        final AtomicReference<h.a.u0.c> i0;

        /* JADX INFO: renamed from: h.a.y0.e.d.c4$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: ObservableWindowTimed.java */
        static final class RunnableC0210a implements Runnable {
            final long a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final a<?> f11285b;

            RunnableC0210a(long j2, a<?> aVar) {
                this.a = j2;
                this.f11285b = aVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                a<?> aVar = this.f11285b;
                if (((h.a.y0.d.w) aVar).H) {
                    aVar.h0 = true;
                    aVar.f();
                } else {
                    ((h.a.y0.d.w) aVar).G.offer(this);
                }
                if (aVar.b()) {
                    aVar.g();
                }
            }
        }

        a(h.a.i0<? super h.a.b0<T>> i0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2, long j3, boolean z) {
            super(i0Var, new h.a.y0.f.a());
            this.i0 = new AtomicReference<>();
            this.K = j2;
            this.L = timeUnit;
            this.M = j0Var;
            this.N = i2;
            this.b0 = j3;
            this.O = z;
            if (z) {
                this.c0 = j0Var.a();
            } else {
                this.c0 = null;
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            h.a.y0.a.d.dispose(this.i0);
            j0.c cVar = this.c0;
            if (cVar != null) {
                cVar.dispose();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r1v0, types: [h.a.i0, h.a.i0<? super V>] */
        /* JADX WARN: Type inference failed for: r4v8, types: [h.a.f1.j] */
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
        void g() {
            h.a.y0.f.a aVar = (h.a.y0.f.a) this.G;
            ?? r1 = this.F;
            h.a.f1.j jVar = this.g0;
            int iA = 1;
            while (!this.h0) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof RunnableC0210a;
                if (z && (z2 || z3)) {
                    this.g0 = null;
                    aVar.clear();
                    f();
                    Throwable th = this.J;
                    if (th != null) {
                        jVar.onError(th);
                        return;
                    } else {
                        jVar.onComplete();
                        return;
                    }
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    RunnableC0210a runnableC0210a = (RunnableC0210a) objPoll;
                    if (this.O || this.e0 == runnableC0210a.a) {
                        jVar.onComplete();
                        this.d0 = 0L;
                        jVar = (h.a.f1.j<T>) h.a.f1.j.i(this.N);
                        this.g0 = jVar;
                        r1.onNext(jVar);
                    }
                } else {
                    jVar.onNext(h.a.y0.j.q.getValue(objPoll));
                    long j2 = this.d0 + 1;
                    if (j2 >= this.b0) {
                        this.e0++;
                        this.d0 = 0L;
                        jVar.onComplete();
                        jVar = (h.a.f1.j<T>) h.a.f1.j.i(this.N);
                        this.g0 = jVar;
                        this.F.onNext(jVar);
                        if (this.O) {
                            h.a.u0.c cVar = this.i0.get();
                            cVar.dispose();
                            j0.c cVar2 = this.c0;
                            RunnableC0210a runnableC0210a2 = new RunnableC0210a(this.e0, this);
                            long j3 = this.K;
                            h.a.u0.c cVarA = cVar2.a(runnableC0210a2, j3, j3, this.L);
                            if (!this.i0.compareAndSet(cVar, cVarA)) {
                                cVarA.dispose();
                            }
                        }
                    } else {
                        this.d0 = j2;
                    }
                }
            }
            this.f0.dispose();
            aVar.clear();
            f();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onComplete();
            f();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.J = th;
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onError(th);
            f();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (this.h0) {
                return;
            }
            if (e()) {
                h.a.f1.j<T> jVar = this.g0;
                jVar.onNext(t);
                long j2 = this.d0 + 1;
                if (j2 >= this.b0) {
                    this.e0++;
                    this.d0 = 0L;
                    jVar.onComplete();
                    h.a.f1.j<T> jVarI = h.a.f1.j.i(this.N);
                    this.g0 = jVarI;
                    this.F.onNext(jVarI);
                    if (this.O) {
                        this.i0.get().dispose();
                        j0.c cVar = this.c0;
                        RunnableC0210a runnableC0210a = new RunnableC0210a(this.e0, this);
                        long j3 = this.K;
                        h.a.y0.a.d.replace(this.i0, cVar.a(runnableC0210a, j3, j3, this.L));
                    }
                } else {
                    this.d0 = j2;
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer((U) h.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            g();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.u0.c cVarA;
            if (h.a.y0.a.d.validate(this.f0, cVar)) {
                this.f0 = cVar;
                h.a.i0<? super V> i0Var = this.F;
                i0Var.onSubscribe(this);
                if (this.H) {
                    return;
                }
                h.a.f1.j<T> jVarI = h.a.f1.j.i(this.N);
                this.g0 = jVarI;
                i0Var.onNext(jVarI);
                RunnableC0210a runnableC0210a = new RunnableC0210a(this.e0, this);
                if (this.O) {
                    j0.c cVar2 = this.c0;
                    long j2 = this.K;
                    cVarA = cVar2.a(runnableC0210a, j2, j2, this.L);
                } else {
                    h.a.j0 j0Var = this.M;
                    long j3 = this.K;
                    cVarA = j0Var.a(runnableC0210a, j3, j3, this.L);
                }
                h.a.y0.a.d.replace(this.i0, cVarA);
            }
        }
    }

    /* JADX INFO: compiled from: ObservableWindowTimed.java */
    static final class b<T> extends h.a.y0.d.w<T, Object, h.a.b0<T>> implements h.a.i0<T>, h.a.u0.c, Runnable {
        static final Object e0 = new Object();
        final long K;
        final TimeUnit L;
        final h.a.j0 M;
        final int N;
        h.a.u0.c O;
        h.a.f1.j<T> b0;
        final AtomicReference<h.a.u0.c> c0;
        volatile boolean d0;

        b(h.a.i0<? super h.a.b0<T>> i0Var, long j2, TimeUnit timeUnit, h.a.j0 j0Var, int i2) {
            super(i0Var, new h.a.y0.f.a());
            this.c0 = new AtomicReference<>();
            this.K = j2;
            this.L = timeUnit;
            this.M = j0Var;
            this.N = i2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            h.a.y0.a.d.dispose(this.c0);
        }

        /* JADX WARN: Code restructure failed: missing block: B:10:0x0026, code lost:
        
            r2.onError(r0);
         */
        /* JADX WARN: Code restructure failed: missing block: B:11:0x002a, code lost:
        
            r2.onComplete();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x002d, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
        
            return;
         */
        /* JADX WARN: Code restructure failed: missing block: B:8:0x0019, code lost:
        
            r7.b0 = null;
            r0.clear();
            f();
            r0 = r7.J;
         */
        /* JADX WARN: Code restructure failed: missing block: B:9:0x0024, code lost:
        
            if (r0 == null) goto L11;
         */
        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v0, types: [h.a.f1.j<T>] */
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
        void g() {
            h.a.y0.f.a aVar = (h.a.y0.f.a) this.G;
            h.a.i0<? super V> i0Var = this.F;
            h.a.f1.j<T> jVar = this.b0;
            int iA = 1;
            while (true) {
                boolean z = this.d0;
                boolean z2 = this.I;
                Object objPoll = aVar.poll();
                if (z2 && (objPoll == null || objPoll == e0)) {
                    break;
                }
                if (objPoll == null) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (objPoll == e0) {
                    jVar.onComplete();
                    if (z) {
                        this.O.dispose();
                    } else {
                        jVar = (h.a.f1.j<T>) h.a.f1.j.i(this.N);
                        this.b0 = jVar;
                        i0Var.onNext(jVar);
                    }
                } else {
                    jVar.onNext(h.a.y0.j.q.getValue(objPoll));
                }
            }
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.I = true;
            if (b()) {
                g();
            }
            f();
            this.F.onComplete();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.J = th;
            this.I = true;
            if (b()) {
                g();
            }
            f();
            this.F.onError(th);
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (this.d0) {
                return;
            }
            if (e()) {
                this.b0.onNext(t);
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer((U) h.a.y0.j.q.next(t));
                if (!b()) {
                    return;
                }
            }
            g();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.O, cVar)) {
                this.O = cVar;
                this.b0 = h.a.f1.j.i(this.N);
                h.a.i0<? super V> i0Var = this.F;
                i0Var.onSubscribe(this);
                i0Var.onNext(this.b0);
                if (this.H) {
                    return;
                }
                h.a.j0 j0Var = this.M;
                long j2 = this.K;
                h.a.y0.a.d.replace(this.c0, j0Var.a(this, j2, j2, this.L));
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            if (this.H) {
                this.d0 = true;
                f();
            }
            this.G.offer((U) e0);
            if (b()) {
                g();
            }
        }
    }

    /* JADX INFO: compiled from: ObservableWindowTimed.java */
    static final class c<T> extends h.a.y0.d.w<T, Object, h.a.b0<T>> implements h.a.u0.c, Runnable {
        final long K;
        final long L;
        final TimeUnit M;
        final j0.c N;
        final int O;
        final List<h.a.f1.j<T>> b0;
        h.a.u0.c c0;
        volatile boolean d0;

        /* JADX INFO: compiled from: ObservableWindowTimed.java */
        final class a implements Runnable {
            private final h.a.f1.j<T> a;

            a(h.a.f1.j<T> jVar) {
                this.a = jVar;
            }

            @Override // java.lang.Runnable
            public void run() {
                c.this.a(this.a);
            }
        }

        /* JADX INFO: compiled from: ObservableWindowTimed.java */
        static final class b<T> {
            final h.a.f1.j<T> a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final boolean f11287b;

            b(h.a.f1.j<T> jVar, boolean z) {
                this.a = jVar;
                this.f11287b = z;
            }
        }

        c(h.a.i0<? super h.a.b0<T>> i0Var, long j2, long j3, TimeUnit timeUnit, j0.c cVar, int i2) {
            super(i0Var, new h.a.y0.f.a());
            this.K = j2;
            this.L = j3;
            this.M = timeUnit;
            this.N = cVar;
            this.O = i2;
            this.b0 = new LinkedList();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void a(h.a.f1.j<T> jVar) {
            this.G.offer((U) new b(jVar, false));
            if (b()) {
                g();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.H = true;
        }

        void f() {
            this.N.dispose();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference incomplete: some casts might be missing */
        void g() {
            h.a.y0.f.a aVar = (h.a.y0.f.a) this.G;
            h.a.i0<? super V> i0Var = this.F;
            List<h.a.f1.j<T>> list = this.b0;
            int iA = 1;
            while (!this.d0) {
                boolean z = this.I;
                Object objPoll = aVar.poll();
                boolean z2 = objPoll == null;
                boolean z3 = objPoll instanceof b;
                if (z && (z2 || z3)) {
                    aVar.clear();
                    Throwable th = this.J;
                    if (th != null) {
                        Iterator<h.a.f1.j<T>> it = list.iterator();
                        while (it.hasNext()) {
                            it.next().onError(th);
                        }
                    } else {
                        Iterator<h.a.f1.j<T>> it2 = list.iterator();
                        while (it2.hasNext()) {
                            it2.next().onComplete();
                        }
                    }
                    f();
                    list.clear();
                    return;
                }
                if (z2) {
                    iA = a(-iA);
                    if (iA == 0) {
                        return;
                    }
                } else if (z3) {
                    b bVar = (b) objPoll;
                    if (!bVar.f11287b) {
                        list.remove(bVar.a);
                        bVar.a.onComplete();
                        if (list.isEmpty() && this.H) {
                            this.d0 = true;
                        }
                    } else if (!this.H) {
                        h.a.f1.j<T> jVarI = h.a.f1.j.i(this.O);
                        list.add(jVarI);
                        i0Var.onNext(jVarI);
                        this.N.a(new a(jVarI), this.K, this.M);
                    }
                } else {
                    Iterator<h.a.f1.j<T>> it3 = list.iterator();
                    while (it3.hasNext()) {
                        it3.next().onNext(objPoll);
                    }
                }
            }
            this.c0.dispose();
            f();
            aVar.clear();
            list.clear();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.H;
        }

        @Override // h.a.i0
        public void onComplete() {
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onComplete();
            f();
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.J = th;
            this.I = true;
            if (b()) {
                g();
            }
            this.F.onError(th);
            f();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onNext(T t) {
            if (e()) {
                Iterator<h.a.f1.j<T>> it = this.b0.iterator();
                while (it.hasNext()) {
                    it.next().onNext(t);
                }
                if (a(-1) == 0) {
                    return;
                }
            } else {
                this.G.offer((U) t);
                if (!b()) {
                    return;
                }
            }
            g();
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            if (h.a.y0.a.d.validate(this.c0, cVar)) {
                this.c0 = cVar;
                this.F.onSubscribe(this);
                if (this.H) {
                    return;
                }
                h.a.f1.j<T> jVarI = h.a.f1.j.i(this.O);
                this.b0.add(jVarI);
                this.F.onNext(jVarI);
                this.N.a(new a(jVarI), this.K, this.M);
                j0.c cVar2 = this.N;
                long j2 = this.L;
                cVar2.a(this, j2, j2, this.M);
            }
        }

        /* JADX WARN: Type inference incomplete: some casts might be missing */
        @Override // java.lang.Runnable
        public void run() {
            Object bVar = new b(h.a.f1.j.i(this.O), true);
            if (!this.H) {
                this.G.offer((U) bVar);
            }
            if (b()) {
                g();
            }
        }
    }

    public c4(h.a.g0<T> g0Var, long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var, long j4, int i2, boolean z) {
        super(g0Var);
        this.f11278b = j2;
        this.f11279c = j3;
        this.f11280d = timeUnit;
        this.f11281e = j0Var;
        this.f11282f = j4;
        this.f11283g = i2;
        this.f11284h = z;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super h.a.b0<T>> i0Var) {
        h.a.a1.m mVar = new h.a.a1.m(i0Var);
        long j2 = this.f11278b;
        long j3 = this.f11279c;
        if (j2 != j3) {
            this.a.subscribe(new c(mVar, j2, j3, this.f11280d, this.f11281e.a(), this.f11283g));
            return;
        }
        long j4 = this.f11282f;
        if (j4 == i.q2.t.m0.f12222b) {
            this.a.subscribe(new b(mVar, j2, this.f11280d, this.f11281e, this.f11283g));
        } else {
            this.a.subscribe(new a(mVar, j2, this.f11280d, this.f11281e, this.f11283g, j4, this.f11284h));
        }
    }
}
