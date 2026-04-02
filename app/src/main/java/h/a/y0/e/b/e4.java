package h.a.y0.e.b;

import h.a.y0.e.b.f4;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableTimeout.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e4<T, U, V> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<U> f10644c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super T, ? extends j.d.b<V>> f10645d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final j.d.b<? extends T> f10646e;

    /* JADX INFO: compiled from: FlowableTimeout.java */
    static final class a extends AtomicReference<j.d.d> implements h.a.q<Object>, h.a.u0.c {
        private static final long serialVersionUID = 8708641127342403073L;
        final long idx;
        final c parent;

        a(long j2, c cVar) {
            this.idx = j2;
            this.parent = cVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.i.j.cancel(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.i.j.isCancelled(get());
        }

        @Override // j.d.c
        public void onComplete() {
            Object obj = get();
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (obj != jVar) {
                lazySet(jVar);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            Object obj = get();
            h.a.y0.i.j jVar = h.a.y0.i.j.CANCELLED;
            if (obj == jVar) {
                h.a.c1.a.b(th);
            } else {
                lazySet(jVar);
                this.parent.onTimeoutError(this.idx, th);
            }
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            j.d.d dVar = (j.d.d) get();
            if (dVar != h.a.y0.i.j.CANCELLED) {
                dVar.cancel();
                lazySet(h.a.y0.i.j.CANCELLED);
                this.parent.onTimeout(this.idx);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableTimeout.java */
    static final class b<T> extends h.a.y0.i.i implements h.a.q<T>, c {
        private static final long serialVersionUID = 3764492702657003550L;
        final j.d.c<? super T> actual;
        long consumed;
        j.d.b<? extends T> fallback;
        final h.a.x0.o<? super T, ? extends j.d.b<?>> itemTimeoutIndicator;
        final h.a.y0.a.k task = new h.a.y0.a.k();
        final AtomicReference<j.d.d> upstream = new AtomicReference<>();
        final AtomicLong index = new AtomicLong();

        b(j.d.c<? super T> cVar, h.a.x0.o<? super T, ? extends j.d.b<?>> oVar, j.d.b<? extends T> bVar) {
            this.actual = cVar;
            this.itemTimeoutIndicator = oVar;
            this.fallback = bVar;
        }

        @Override // h.a.y0.i.i, j.d.d
        public void cancel() {
            super.cancel();
            this.task.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.index.getAndSet(i.q2.t.m0.f12222b) != i.q2.t.m0.f12222b) {
                this.task.dispose();
                this.actual.onComplete();
                this.task.dispose();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.index.getAndSet(i.q2.t.m0.f12222b) == i.q2.t.m0.f12222b) {
                h.a.c1.a.b(th);
                return;
            }
            this.task.dispose();
            this.actual.onError(th);
            this.task.dispose();
        }

        @Override // j.d.c
        public void onNext(T t) {
            long j2 = this.index.get();
            if (j2 != i.q2.t.m0.f12222b) {
                long j3 = j2 + 1;
                if (this.index.compareAndSet(j2, j3)) {
                    h.a.u0.c cVar = this.task.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.consumed++;
                    this.actual.onNext(t);
                    try {
                        j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.task.replace(aVar)) {
                            bVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.upstream.get().cancel();
                        this.index.getAndSet(i.q2.t.m0.f12222b);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this.upstream, dVar)) {
                setSubscription(dVar);
            }
        }

        @Override // h.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (this.index.compareAndSet(j2, i.q2.t.m0.f12222b)) {
                h.a.y0.i.j.cancel(this.upstream);
                j.d.b<? extends T> bVar = this.fallback;
                this.fallback = null;
                long j3 = this.consumed;
                if (j3 != 0) {
                    produced(j3);
                }
                bVar.subscribe(new f4.a(this.actual, this));
            }
        }

        @Override // h.a.y0.e.b.e4.c
        public void onTimeoutError(long j2, Throwable th) {
            if (!this.index.compareAndSet(j2, i.q2.t.m0.f12222b)) {
                h.a.c1.a.b(th);
            } else {
                h.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(th);
            }
        }

        void startFirstTimeout(j.d.b<?> bVar) {
            if (bVar != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    bVar.subscribe(aVar);
                }
            }
        }
    }

    /* JADX INFO: compiled from: FlowableTimeout.java */
    interface c extends f4.d {
        void onTimeoutError(long j2, Throwable th);
    }

    /* JADX INFO: compiled from: FlowableTimeout.java */
    static final class d<T> extends AtomicLong implements h.a.q<T>, j.d.d, c {
        private static final long serialVersionUID = 3764492702657003550L;
        final j.d.c<? super T> actual;
        final h.a.x0.o<? super T, ? extends j.d.b<?>> itemTimeoutIndicator;
        final h.a.y0.a.k task = new h.a.y0.a.k();
        final AtomicReference<j.d.d> upstream = new AtomicReference<>();
        final AtomicLong requested = new AtomicLong();

        d(j.d.c<? super T> cVar, h.a.x0.o<? super T, ? extends j.d.b<?>> oVar) {
            this.actual = cVar;
            this.itemTimeoutIndicator = oVar;
        }

        @Override // j.d.d
        public void cancel() {
            h.a.y0.i.j.cancel(this.upstream);
            this.task.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            if (getAndSet(i.q2.t.m0.f12222b) != i.q2.t.m0.f12222b) {
                this.task.dispose();
                this.actual.onComplete();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (getAndSet(i.q2.t.m0.f12222b) == i.q2.t.m0.f12222b) {
                h.a.c1.a.b(th);
            } else {
                this.task.dispose();
                this.actual.onError(th);
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            long j2 = get();
            if (j2 != i.q2.t.m0.f12222b) {
                long j3 = 1 + j2;
                if (compareAndSet(j2, j3)) {
                    h.a.u0.c cVar = this.task.get();
                    if (cVar != null) {
                        cVar.dispose();
                    }
                    this.actual.onNext(t);
                    try {
                        j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.itemTimeoutIndicator.apply(t), "The itemTimeoutIndicator returned a null Publisher.");
                        a aVar = new a(j3, this);
                        if (this.task.replace(aVar)) {
                            bVar.subscribe(aVar);
                        }
                    } catch (Throwable th) {
                        h.a.v0.b.b(th);
                        this.upstream.get().cancel();
                        getAndSet(i.q2.t.m0.f12222b);
                        this.actual.onError(th);
                    }
                }
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            h.a.y0.i.j.deferredSetOnce(this.upstream, this.requested, dVar);
        }

        @Override // h.a.y0.e.b.f4.d
        public void onTimeout(long j2) {
            if (compareAndSet(j2, i.q2.t.m0.f12222b)) {
                h.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(new TimeoutException());
            }
        }

        @Override // h.a.y0.e.b.e4.c
        public void onTimeoutError(long j2, Throwable th) {
            if (!compareAndSet(j2, i.q2.t.m0.f12222b)) {
                h.a.c1.a.b(th);
            } else {
                h.a.y0.i.j.cancel(this.upstream);
                this.actual.onError(th);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            h.a.y0.i.j.deferredRequest(this.upstream, this.requested, j2);
        }

        void startFirstTimeout(j.d.b<?> bVar) {
            if (bVar != null) {
                a aVar = new a(0L, this);
                if (this.task.replace(aVar)) {
                    bVar.subscribe(aVar);
                }
            }
        }
    }

    public e4(h.a.l<T> lVar, j.d.b<U> bVar, h.a.x0.o<? super T, ? extends j.d.b<V>> oVar, j.d.b<? extends T> bVar2) {
        super(lVar);
        this.f10644c = bVar;
        this.f10645d = oVar;
        this.f10646e = bVar2;
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
    protected void d(j.d.c<? super T> cVar) {
        j.d.b<? extends T> bVar = this.f10646e;
        if (bVar == null) {
            d dVar = new d(cVar, this.f10645d);
            cVar.onSubscribe(dVar);
            dVar.startFirstTimeout(this.f10644c);
            this.f10561b.a((h.a.q) dVar);
            return;
        }
        b bVar2 = new b(cVar, this.f10645d, bVar);
        cVar.onSubscribe(bVar2);
        bVar2.startFirstTimeout(this.f10644c);
        this.f10561b.a((h.a.q) bVar2);
    }
}
