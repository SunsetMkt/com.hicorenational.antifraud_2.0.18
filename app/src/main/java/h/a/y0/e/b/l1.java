package h.a.y0.e.b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableGroupJoin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends h.a.y0.e.b.a<TLeft, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<? extends TRight> f10758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> f10759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> f10760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.x0.c<? super TLeft, ? super h.a.l<TRight>, ? extends R> f10761f;

    /* JADX INFO: compiled from: FlowableGroupJoin.java */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements j.d.d, b {
        private static final long serialVersionUID = -6071216598687999801L;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;
        final h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> leftEnd;
        int leftIndex;
        final h.a.x0.c<? super TLeft, ? super h.a.l<TRight>, ? extends R> resultSelector;
        final h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final h.a.u0.b disposables = new h.a.u0.b();
        final h.a.y0.f.c<Object> queue = new h.a.y0.f.c<>(h.a.l.Q());
        final Map<Integer, h.a.d1.g<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(j.d.c<? super R> cVar, h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> oVar2, h.a.x0.c<? super TLeft, ? super h.a.l<TRight>, ? extends R> cVar2) {
            this.actual = cVar;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar2;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            cancelAll();
            if (getAndIncrement() == 0) {
                this.queue.clear();
            }
        }

        void cancelAll() {
            this.disposables.dispose();
        }

        void drain() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.y0.f.c<Object> cVar = this.queue;
            j.d.c<? super R> cVar2 = this.actual;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    cVar.clear();
                    cancelAll();
                    errorAll(cVar2);
                    return;
                }
                boolean z = this.active.get() == 0;
                Integer num = (Integer) cVar.poll();
                boolean z2 = num == null;
                if (z && z2) {
                    Iterator<h.a.d1.g<TRight>> it = this.lefts.values().iterator();
                    while (it.hasNext()) {
                        it.next().onComplete();
                    }
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    cVar2.onComplete();
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
                        h.a.d1.g gVarA0 = h.a.d1.g.a0();
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), (h.a.d1.g<TRight>) gVarA0);
                        try {
                            j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.leftEnd.apply(objPoll), "The leftEnd returned a null Publisher");
                            c cVar3 = new c(this, true, i2);
                            this.disposables.b(cVar3);
                            bVar.subscribe(cVar3);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(cVar2);
                                return;
                            }
                            try {
                                defpackage.a aVar = (Object) h.a.y0.b.b.a(this.resultSelector.apply(objPoll, gVarA0), "The resultSelector returned a null value");
                                if (this.requested.get() == 0) {
                                    fail(new h.a.v0.c("Could not emit value due to lack of requests"), cVar2, cVar);
                                    return;
                                }
                                cVar2.onNext(aVar);
                                h.a.y0.j.d.c(this.requested, 1L);
                                Iterator<TRight> it2 = this.rights.values().iterator();
                                while (it2.hasNext()) {
                                    gVarA0.onNext(it2.next());
                                }
                            } catch (Throwable th) {
                                fail(th, cVar2, cVar);
                                return;
                            }
                        } catch (Throwable th2) {
                            fail(th2, cVar2, cVar);
                            return;
                        }
                    } else if (num == RIGHT_VALUE) {
                        int i3 = this.rightIndex;
                        this.rightIndex = i3 + 1;
                        this.rights.put(Integer.valueOf(i3), (TRight) objPoll);
                        try {
                            j.d.b bVar2 = (j.d.b) h.a.y0.b.b.a(this.rightEnd.apply(objPoll), "The rightEnd returned a null Publisher");
                            c cVar4 = new c(this, false, i3);
                            this.disposables.b(cVar4);
                            bVar2.subscribe(cVar4);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(cVar2);
                                return;
                            } else {
                                Iterator<h.a.d1.g<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(objPoll);
                                }
                            }
                        } catch (Throwable th3) {
                            fail(th3, cVar2, cVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        c cVar5 = (c) objPoll;
                        h.a.d1.g<TRight> gVarRemove = this.lefts.remove(Integer.valueOf(cVar5.index));
                        this.disposables.a(cVar5);
                        if (gVarRemove != null) {
                            gVarRemove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        c cVar6 = (c) objPoll;
                        this.rights.remove(Integer.valueOf(cVar6.index));
                        this.disposables.a(cVar6);
                    }
                }
            }
            cVar.clear();
        }

        void errorAll(j.d.c<?> cVar) {
            Throwable thA = h.a.y0.j.k.a(this.error);
            Iterator<h.a.d1.g<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(thA);
            }
            this.lefts.clear();
            this.rights.clear();
            cVar.onError(thA);
        }

        void fail(Throwable th, j.d.c<?> cVar, h.a.y0.c.o<?> oVar) {
            h.a.v0.b.b(th);
            h.a.y0.j.k.a(this.error, th);
            oVar.clear();
            cancelAll();
            errorAll(cVar);
        }

        @Override // h.a.y0.e.b.l1.b
        public void innerClose(boolean z, c cVar) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            drain();
        }

        @Override // h.a.y0.e.b.l1.b
        public void innerCloseError(Throwable th) {
            if (h.a.y0.j.k.a(this.error, th)) {
                drain();
            } else {
                h.a.c1.a.b(th);
            }
        }

        @Override // h.a.y0.e.b.l1.b
        public void innerComplete(d dVar) {
            this.disposables.c(dVar);
            this.active.decrementAndGet();
            drain();
        }

        @Override // h.a.y0.e.b.l1.b
        public void innerError(Throwable th) {
            if (!h.a.y0.j.k.a(this.error, th)) {
                h.a.c1.a.b(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // h.a.y0.e.b.l1.b
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableGroupJoin.java */
    interface b {
        void innerClose(boolean z, c cVar);

        void innerCloseError(Throwable th);

        void innerComplete(d dVar);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* JADX INFO: compiled from: FlowableGroupJoin.java */
    static final class c extends AtomicReference<j.d.d> implements h.a.q<Object>, h.a.u0.c {
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
            h.a.y0.i.j.cancel(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.i.j.isCancelled(get());
        }

        @Override // j.d.c
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            if (h.a.y0.i.j.cancel(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableGroupJoin.java */
    static final class d extends AtomicReference<j.d.d> implements h.a.q<Object>, h.a.u0.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        d(b bVar, boolean z) {
            this.parent = bVar;
            this.isLeft = z;
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
            this.parent.innerComplete(this);
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // j.d.c
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    public l1(h.a.l<TLeft> lVar, j.d.b<? extends TRight> bVar, h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> oVar2, h.a.x0.c<? super TLeft, ? super h.a.l<TRight>, ? extends R> cVar) {
        super(lVar);
        this.f10758c = bVar;
        this.f10759d = oVar;
        this.f10760e = oVar2;
        this.f10761f = cVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        a aVar = new a(cVar, this.f10759d, this.f10760e, this.f10761f);
        cVar.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.b(dVar2);
        this.f10561b.a((h.a.q) dVar);
        this.f10758c.subscribe(dVar2);
    }
}
