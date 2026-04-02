package h.a.y0.e.d;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableIntervalRange.java */
/* JADX INFO: loaded from: classes2.dex */
public final class o1 extends h.a.b0<Long> {
    final h.a.j0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f11536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f11537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final TimeUnit f11538f;

    /* JADX INFO: compiled from: ObservableIntervalRange.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.u0.c, Runnable {
        private static final long serialVersionUID = 1891866368734007884L;
        final h.a.i0<? super Long> actual;
        long count;
        final long end;

        a(h.a.i0<? super Long> i0Var, long j2, long j3) {
            this.actual = i0Var;
            this.count = j2;
            this.end = j3;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return get() == h.a.y0.a.d.DISPOSED;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (isDisposed()) {
                return;
            }
            long j2 = this.count;
            this.actual.onNext(Long.valueOf(j2));
            if (j2 != this.end) {
                this.count = j2 + 1;
            } else {
                h.a.y0.a.d.dispose(this);
                this.actual.onComplete();
            }
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public o1(long j2, long j3, long j4, long j5, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.f11536d = j4;
        this.f11537e = j5;
        this.f11538f = timeUnit;
        this.a = j0Var;
        this.f11534b = j2;
        this.f11535c = j3;
    }

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
    @Override // h.a.b0
    public void d(h.a.i0<? super Long> i0Var) {
        a aVar = new a(i0Var, this.f11534b, this.f11535c);
        i0Var.onSubscribe(aVar);
        h.a.j0 j0Var = this.a;
        if (!(j0Var instanceof h.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f11536d, this.f11537e, this.f11538f));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f11536d, this.f11537e, this.f11538f);
    }
}
