package h.a.y0.e.d;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableGroupJoin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends h.a.y0.e.d.a<TLeft, R> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.g0<? extends TRight> f11412b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super TLeft, ? extends h.a.g0<TLeftEnd>> f11413c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super TRight, ? extends h.a.g0<TRightEnd>> f11414d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.c<? super TLeft, ? super h.a.b0<TRight>, ? extends R> f11415e;

    /* JADX INFO: compiled from: ObservableGroupJoin.java */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements h.a.u0.c, b {
        private static final long serialVersionUID = -6071216598687999801L;
        final h.a.i0<? super R> actual;
        volatile boolean cancelled;
        final h.a.x0.o<? super TLeft, ? extends h.a.g0<TLeftEnd>> leftEnd;
        int leftIndex;
        final h.a.x0.c<? super TLeft, ? super h.a.b0<TRight>, ? extends R> resultSelector;
        final h.a.x0.o<? super TRight, ? extends h.a.g0<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final h.a.u0.b disposables = new h.a.u0.b();
        final h.a.y0.f.c<Object> queue = new h.a.y0.f.c<>(h.a.b0.L());
        final Map<Integer, h.a.f1.j<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(h.a.i0<? super R> i0Var, h.a.x0.o<? super TLeft, ? extends h.a.g0<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends h.a.g0<TRightEnd>> oVar2, h.a.x0.c<? super TLeft, ? super h.a.b0<TRight>, ? extends R> cVar) {
            this.actual = i0Var;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar;
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.y0.f.c<?> cVar = this.queue;
            h.a.i0<? super R> i0Var = this.actual;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    cVar.clear();
                    cancelAll();
                    errorAll(i0Var);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) cVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<h.a.f1.j<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    i0Var.onComplete();
                    return;
                }
                if (z2) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = cVar.poll();
                    if (num == LEFT_VALUE) {
                        h.a.f1.j jVarV = h.a.f1.j.V();
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), (h.a.f1.j<TRight>) jVarV);
                        try {
                            h.a.g0 g0Var = (h.a.g0) h.a.y0.b.b.a(this.leftEnd.apply(objPoll), "The leftEnd returned a null ObservableSource");
                            c cVar2 = new c(this, true, i2);
                            this.disposables.b(cVar2);
                            g0Var.subscribe(cVar2);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(i0Var);
                                return;
                            } else {
                                try {
                                    i0Var.onNext((Object) h.a.y0.b.b.a(this.resultSelector.apply(objPoll, jVarV), "The resultSelector returned a null value"));
                                    Iterator<TRight> it2 = this.rights.values().iterator();
                                    while (it2.hasNext()) {
                                        jVarV.onNext(it2.next());
                                    }
                                } catch (Throwable th) {
                                    fail(th, i0Var, cVar);
                                    return;
                                }
                            }
                        } catch (Throwable th2) {
                            fail(th2, i0Var, cVar);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), (TRight) objPoll);
                        try {
                            h.a.g0 g0Var2 = (h.a.g0) h.a.y0.b.b.a(this.rightEnd.apply(objPoll), "The rightEnd returned a null ObservableSource");
                            c cVar3 = new c(this, false, i3);
                            this.disposables.b(cVar3);
                            g0Var2.subscribe(cVar3);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(i0Var);
                                return;
                            } else {
                                Iterator<h.a.f1.j<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            fail(th3, i0Var, cVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        c cVar4 = (c) objPoll;
                        h.a.f1.j<TRight> jVarRemove = this.lefts.remove(Integer.valueOf(cVar4.index));
                        this.disposables.a(cVar4);
                        if (jVarRemove != null) {
                            jVarRemove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        c cVar5 = (c) objPoll;
                        this.rights.remove(Integer.valueOf(cVar5.index));
                        this.disposables.a(cVar5);
                    }
                }
            }
            cVar.clear();
        }

        void errorAll(h.a.i0<?> i0Var) {
            Throwable thA = h.a.y0.j.k.a(this.error);
            Iterator<h.a.f1.j<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(thA);
            }
            this.lefts.clear();
            this.rights.clear();
            i0Var.onError(thA);
        }

        void fail(Throwable th, h.a.i0<?> i0Var, h.a.y0.f.c<?> cVar) {
            h.a.v0.b.b(th);
            h.a.y0.j.k.a(this.error, th);
            cVar.clear();
            cancelAll();
            errorAll(i0Var);
        }

        @Override // h.a.y0.e.d.i1.b
        public void innerClose(boolean z, c cVar) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            drain();
        }

        @Override // h.a.y0.e.d.i1.b
        public void innerCloseError(Throwable th) {
            if (h.a.y0.j.k.a(this.error, th)) {
                drain();
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.y0.e.d.i1.b
        public void innerComplete(d dVar) {
            this.disposables.c(dVar);
            this.active.decrementAndGet();
            drain();
        }

        @Override // h.a.y0.e.d.i1.b
        public void innerError(Throwable th) {
            if (!h.a.y0.j.k.a(this.error, th)) {
                h.a.c1.a.b(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // h.a.y0.e.d.i1.b
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX INFO: compiled from: ObservableGroupJoin.java */
    interface b {
        void innerClose(boolean z, c cVar);

        void innerCloseError(Throwable th);

        void innerComplete(d dVar);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* JADX INFO: compiled from: ObservableGroupJoin.java */
    static final class c extends AtomicReference<h.a.u0.c> implements h.a.i0<Object>, h.a.u0.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final b parent;

        c(b bVar, boolean z, int i2) {
            this.parent = bVar;
            this.isLeft = z;
            this.index = i2;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.i0
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
            if (h.a.y0.a.d.dispose(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableGroupJoin.java */
    static final class d extends AtomicReference<h.a.u0.c> implements h.a.i0<Object>, h.a.u0.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        d(b bVar, boolean z) {
            this.parent = bVar;
            this.isLeft = z;
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.a.d.dispose(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.a.d.isDisposed(get());
        }

        @Override // h.a.i0
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // h.a.i0
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            h.a.y0.a.d.setOnce(this, cVar);
        }
    }

    public i1(h.a.g0<TLeft> g0Var, h.a.g0<? extends TRight> g0Var2, h.a.x0.o<? super TLeft, ? extends h.a.g0<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends h.a.g0<TRightEnd>> oVar2, h.a.x0.c<? super TLeft, ? super h.a.b0<TRight>, ? extends R> cVar) {
        super(g0Var);
        this.f11412b = g0Var2;
        this.f11413c = oVar;
        this.f11414d = oVar2;
        this.f11415e = cVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // h.a.b0
    protected void d(h.a.i0<? super R> i0Var) {
        a aVar = new a(i0Var, this.f11413c, this.f11414d, this.f11415e);
        i0Var.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.b(dVar2);
        this.a.subscribe(dVar);
        this.f11412b.subscribe(dVar2);
    }
}
