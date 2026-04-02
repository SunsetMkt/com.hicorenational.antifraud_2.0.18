package h.a.y0.e.b;

import h.a.j0;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableIntervalRange.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r1 extends h.a.l<Long> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.j0 f10938b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final long f10939c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final long f10940d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final long f10941e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final long f10942f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final TimeUnit f10943g;

    /* JADX INFO: compiled from: FlowableIntervalRange.java */
    static final class a extends AtomicLong implements j.d.d, Runnable {
        private static final long serialVersionUID = -2809475196591179431L;
        final j.d.c<? super Long> actual;
        long count;
        final long end;
        final AtomicReference<h.a.u0.c> resource = new AtomicReference<>();

        a(j.d.c<? super Long> cVar, long j2, long j3) {
            this.actual = cVar;
            this.count = j2;
            this.end = j3;
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
                long j2 = get();
                if (j2 == 0) {
                    this.actual.onError(new h.a.v0.c("Can't deliver value " + this.count + " due to lack of requests"));
                    h.a.y0.a.d.dispose(this.resource);
                    return;
                }
                long j3 = this.count;
                this.actual.onNext(Long.valueOf(j3));
                if (j3 == this.end) {
                    if (this.resource.get() != h.a.y0.a.d.DISPOSED) {
                        this.actual.onComplete();
                    }
                    h.a.y0.a.d.dispose(this.resource);
                } else {
                    this.count = j3 + 1;
                    if (j2 != i.q2.t.m0.f12222b) {
                        decrementAndGet();
                    }
                }
            }
        }

        public void setResource(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this.resource, cVar);
        }
    }

    public r1(long j2, long j3, long j4, long j5, TimeUnit timeUnit, h.a.j0 j0Var) {
        this.f10941e = j4;
        this.f10942f = j5;
        this.f10943g = timeUnit;
        this.f10938b = j0Var;
        this.f10939c = j2;
        this.f10940d = j3;
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
        a aVar = new a(cVar, this.f10939c, this.f10940d);
        cVar.onSubscribe(aVar);
        h.a.j0 j0Var = this.f10938b;
        if (!(j0Var instanceof h.a.y0.g.r)) {
            aVar.setResource(j0Var.a(aVar, this.f10941e, this.f10942f, this.f10943g));
            return;
        }
        j0.c cVarA = j0Var.a();
        aVar.setResource(cVarA);
        cVarA.a(aVar, this.f10941e, this.f10942f, this.f10943g);
    }
}
