package h.a.y0.e.d;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableInterval.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n1 extends h.a.b0<Long> {
    final h.a.j0 a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final long f11513b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f11514c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final TimeUnit f11515d;

    /* JADX INFO: compiled from: ObservableInterval.java */
    static final class a extends AtomicReference<h.a.u0.c> implements h.a.u0.c, Runnable {
        private static final long serialVersionUID = 346773832286157679L;
        final h.a.i0<? super Long> actual;
        long count;

        a(h.a.i0<? super Long> i0Var) {
            this.actual = i0Var;
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
            if (get() != h.a.y0.a.d.DISPOSED) {
                h.a.i0<? super Long> i0Var = this.actual;
                long j2 = this.count;
                this.count = 1 + j2;
                i0Var.onNext(Long.valueOf(j2));
            }
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public n1(long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.f11513b = j2;
        this.f11514c = j3;
        this.f11515d = timeUnit;
        this.a = j0Var;
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
        a aVar = new a(i0Var);
        i0Var.onSubscribe(aVar);
        h.a.j0 j0Var = this.a;
        if (!(j0Var instanceof h.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f11513b, this.f11514c, this.f11515d));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f11513b, this.f11514c, this.f11515d);
    }
}
