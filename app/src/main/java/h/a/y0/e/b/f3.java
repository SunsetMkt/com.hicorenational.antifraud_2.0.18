package h.a.y0.e.b;

import java.util.concurrent.Callable;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: compiled from: FlowableScanSeed.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f3<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.c<R, ? super T, R> f10655c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Callable<R> f10656d;

    /* JADX INFO: compiled from: FlowableScanSeed.java */
    static final class a<T, R> extends AtomicInteger implements h.a.q<T>, j.d.d {
        private static final long serialVersionUID = -1776795561228106469L;
        final h.a.x0.c<R, ? super T, R> accumulator;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;
        int consumed;
        volatile boolean done;
        Throwable error;
        final int limit;
        final int prefetch;
        final h.a.y0.c.n<R> queue;
        final AtomicLong requested;
        j.d.d s;
        R value;

        a(j.d.c<? super R> cVar, h.a.x0.c<R, ? super T, R> cVar2, R r, int i2) {
            this.actual = cVar;
            this.accumulator = cVar2;
            this.value = r;
            this.prefetch = i2;
            this.limit = i2 - (i2 >> 2);
            this.queue = new h.a.y0.f.b(i2);
            this.queue.offer(r);
            this.requested = new AtomicLong();
        }

        @Override // j.d.d
        public void cancel() {
            this.cancelled = true;
            this.s.cancel();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            Throwable th;
            if (getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super R> cVar = this.actual;
            h.a.y0.c.n<R> nVar = this.queue;
            int i2 = this.limit;
            int i3 = this.consumed;
            int iAddAndGet = 1;
            do {
                long j2 = this.requested.get();
                long j3 = 0;
                while (j3 != j2) {
                    if (this.cancelled) {
                        nVar.clear();
                        return;
                    }
                    boolean z = this.done;
                    if (z && (th = this.error) != null) {
                        nVar.clear();
                        cVar.onError(th);
                        return;
                    }
                    R rPoll = nVar.poll();
                    boolean z2 = rPoll == null;
                    if (z && z2) {
                        cVar.onComplete();
                        return;
                    }
                    if (z2) {
                        break;
                    }
                    cVar.onNext(rPoll);
                    j3++;
                    i3++;
                    if (i3 == i2) {
                        this.s.request(i2);
                        i3 = 0;
                    }
                }
                if (j3 == j2 && this.done) {
                    Throwable th2 = this.error;
                    if (th2 != null) {
                        nVar.clear();
                        cVar.onError(th2);
                        return;
                    } else if (nVar.isEmpty()) {
                        cVar.onComplete();
                        return;
                    }
                }
                if (j3 != 0) {
                    h.a.y0.j.d.c(this.requested, j3);
                }
                this.consumed = i3;
                iAddAndGet = addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.done) {
                return;
            }
            this.done = true;
            drain();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.done) {
                h.a.c1.a.b(th);
                return;
            }
            this.error = th;
            this.done = true;
            drain();
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
        @Override // j.d.c
        public void onNext(T t) {
            if (this.done) {
                return;
            }
            try {
                R r = (R) h.a.y0.b.b.a(this.accumulator.apply(this.value, t), "The accumulator returned a null value");
                this.value = r;
                this.queue.offer(r);
                drain();
            } catch (Throwable th) {
                h.a.v0.b.b(th);
                this.s.cancel();
                onError(th);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.s, dVar)) {
                this.s = dVar;
                this.actual.onSubscribe(this);
                dVar.request(this.prefetch - 1);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                drain();
            }
        }
    }

    public f3(h.a.l<T> lVar, Callable<R> callable, h.a.x0.c<R, ? super T, R> cVar) {
        super(lVar);
        this.f10655c = cVar;
        this.f10656d = callable;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        try {
            this.f10561b.a((h.a.q) new a(cVar, this.f10655c, h.a.y0.b.b.a(this.f10656d.call(), "The seed supplied is null"), h.a.l.Q()));
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }
}
