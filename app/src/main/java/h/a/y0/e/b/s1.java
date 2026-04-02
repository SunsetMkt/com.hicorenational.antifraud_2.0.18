package h.a.y0.e.b;

import h.a.y0.e.b.l1;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableJoin.java */
/* JADX INFO: loaded from: classes2.dex */
public final class s1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends h.a.y0.e.b.a<TLeft, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final j.d.b<? extends TRight> f10964c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> f10965d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> f10966e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final h.a.x0.c<? super TLeft, ? super TRight, ? extends R> f10967f;

    /* JADX INFO: compiled from: FlowableJoin.java */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements j.d.d, l1.b {
        private static final long serialVersionUID = -6071216598687999801L;
        final j.d.c<? super R> actual;
        volatile boolean cancelled;
        final h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> leftEnd;
        int leftIndex;
        final h.a.x0.c<? super TLeft, ? super TRight, ? extends R> resultSelector;
        final h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final h.a.u0.b disposables = new h.a.u0.b();
        final h.a.y0.f.c<Object> queue = new h.a.y0.f.c<>(h.a.l.Q());
        final Map<Integer, TLeft> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(j.d.c<? super R> cVar, h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> oVar2, h.a.x0.c<? super TLeft, ? super TRight, ? extends R> cVar2) {
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
            boolean z = true;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                if (this.error.get() != null) {
                    cVar.clear();
                    cancelAll();
                    errorAll(cVar2);
                    return;
                }
                boolean z2 = this.active.get() == 0;
                Integer num = (Integer) cVar.poll();
                boolean z3 = num == null;
                if (z2 && z3) {
                    this.lefts.clear();
                    this.rights.clear();
                    this.disposables.dispose();
                    cVar2.onComplete();
                    return;
                }
                if (z3) {
                    iAddAndGet = addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                } else {
                    Object objPoll = cVar.poll();
                    if (num == LEFT_VALUE) {
                        int i2 = this.leftIndex;
                        this.leftIndex = i2 + 1;
                        this.lefts.put(Integer.valueOf(i2), (TLeft) objPoll);
                        try {
                            j.d.b bVar = (j.d.b) h.a.y0.b.b.a(this.leftEnd.apply(objPoll), "The leftEnd returned a null Publisher");
                            l1.c cVar3 = new l1.c(this, z, i2);
                            this.disposables.b(cVar3);
                            bVar.subscribe(cVar3);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(cVar2);
                                return;
                            }
                            long j2 = this.requested.get();
                            Iterator<TRight> it = this.rights.values().iterator();
                            long j3 = 0;
                            while (it.hasNext()) {
                                try {
                                    defpackage.a aVar = (Object) h.a.y0.b.b.a(this.resultSelector.apply(objPoll, it.next()), "The resultSelector returned a null value");
                                    if (j3 == j2) {
                                        h.a.y0.j.k.a(this.error, new h.a.v0.c("Could not emit value due to lack of requests"));
                                        cVar.clear();
                                        cancelAll();
                                        errorAll(cVar2);
                                        return;
                                    }
                                    cVar2.onNext(aVar);
                                    j3++;
                                } catch (Throwable th) {
                                    fail(th, cVar2, cVar);
                                    return;
                                }
                            }
                            if (j3 != 0) {
                                h.a.y0.j.d.c(this.requested, j3);
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
                            l1.c cVar4 = new l1.c(this, false, i3);
                            this.disposables.b(cVar4);
                            bVar2.subscribe(cVar4);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(cVar2);
                                return;
                            }
                            long j4 = this.requested.get();
                            Iterator<TLeft> it2 = this.lefts.values().iterator();
                            long j5 = 0;
                            while (it2.hasNext()) {
                                try {
                                    defpackage.a aVar2 = (Object) h.a.y0.b.b.a(this.resultSelector.apply(it2.next(), objPoll), "The resultSelector returned a null value");
                                    if (j5 == j4) {
                                        h.a.y0.j.k.a(this.error, new h.a.v0.c("Could not emit value due to lack of requests"));
                                        cVar.clear();
                                        cancelAll();
                                        errorAll(cVar2);
                                        return;
                                    }
                                    cVar2.onNext(aVar2);
                                    j5++;
                                } catch (Throwable th3) {
                                    fail(th3, cVar2, cVar);
                                    return;
                                }
                            }
                            if (j5 != 0) {
                                h.a.y0.j.d.c(this.requested, j5);
                            }
                        } catch (Throwable th4) {
                            fail(th4, cVar2, cVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        l1.c cVar5 = (l1.c) objPoll;
                        this.lefts.remove(Integer.valueOf(cVar5.index));
                        this.disposables.a(cVar5);
                    } else if (num == RIGHT_CLOSE) {
                        l1.c cVar6 = (l1.c) objPoll;
                        this.rights.remove(Integer.valueOf(cVar6.index));
                        this.disposables.a(cVar6);
                    }
                    z = true;
                }
            }
            cVar.clear();
        }

        void errorAll(j.d.c<?> cVar) {
            Throwable thA = h.a.y0.j.k.a(this.error);
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
        public void innerClose(boolean z, l1.c cVar) {
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
        public void innerComplete(l1.d dVar) {
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

    public s1(h.a.l<TLeft> lVar, j.d.b<? extends TRight> bVar, h.a.x0.o<? super TLeft, ? extends j.d.b<TLeftEnd>> oVar, h.a.x0.o<? super TRight, ? extends j.d.b<TRightEnd>> oVar2, h.a.x0.c<? super TLeft, ? super TRight, ? extends R> cVar) {
        super(lVar);
        this.f10964c = bVar;
        this.f10965d = oVar;
        this.f10966e = oVar2;
        this.f10967f = cVar;
    }

    /* JADX WARN: Type inference incomplete: some casts might be missing */
    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        a aVar = new a(cVar, this.f10965d, this.f10966e, this.f10967f);
        cVar.onSubscribe(aVar);
        l1.d dVar = new l1.d(aVar, true);
        aVar.disposables.b(dVar);
        l1.d dVar2 = new l1.d(aVar, false);
        aVar.disposables.b(dVar2);
        this.f10561b.a((h.a.q) dVar);
        this.f10964c.subscribe(dVar2);
    }
}
