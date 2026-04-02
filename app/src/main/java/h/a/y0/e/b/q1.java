package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableInterval.java */
/* JADX INFO: loaded from: classes2.dex */
public final class q1 extends h.a.l<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f10908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f10910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final TimeUnit f10911e;

    /* JADX INFO: compiled from: FlowableInterval.java */
    static final class a extends AtomicLong implements j.d.d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final j.d.c<? super Long> actual;
        long count;
        final AtomicReference<h.a.u0.c> resource = new AtomicReference<>();

        a(j.d.c<? super Long> cVar) {
            this.actual = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.a.d.dispose(this.resource);
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this, j2);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.resource.get() != h.a.y0.a.d.DISPOSED) {
                if (get() != 0) {
                    j.d.c<? super Long> cVar = this.actual;
                    long j2 = this.count;
                    this.count = j2 + 1;
                    cVar.onNext(Long.valueOf(j2));
                    h.a.y0.j.d.c(this, 1L);
                    return;
                }
                this.actual.onError(new h.a.v0.c("Can't deliver value " + this.count + " due to lack of requests"));
                h.a.y0.a.d.dispose(this.resource);
            }
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.resource, cVar);
        }
    }

    public q1(long j2, long j3, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.f10909c = j2;
        this.f10910d = j3;
        this.f10911e = timeUnit;
        this.f10908b = j0Var;
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
    @Override // h.a.l
    public void d(j.d.c<? super Long> cVar) {
        a aVar = new a(cVar);
        cVar.onSubscribe(aVar);
        h.a.j0 j0Var = this.f10908b;
        if (!(j0Var instanceof h.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f10909c, this.f10910d, this.f10911e));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f10909c, this.f10910d, this.f10911e);
    }
}
