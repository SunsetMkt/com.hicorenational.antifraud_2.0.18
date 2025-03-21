package g.a.y0.e.b;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowableGroupJoin.java */
/* loaded from: classes2.dex */
public final class l1<TLeft, TRight, TLeftEnd, TRightEnd, R> extends g.a.y0.e.b.a<TLeft, R> {

    /* renamed from: c, reason: collision with root package name */
    final i.d.b<? extends TRight> f14346c;

    /* renamed from: d, reason: collision with root package name */
    final g.a.x0.o<? super TLeft, ? extends i.d.b<TLeftEnd>> f14347d;

    /* renamed from: e, reason: collision with root package name */
    final g.a.x0.o<? super TRight, ? extends i.d.b<TRightEnd>> f14348e;

    /* renamed from: f, reason: collision with root package name */
    final g.a.x0.c<? super TLeft, ? super g.a.l<TRight>, ? extends R> f14349f;

    /* compiled from: FlowableGroupJoin.java */
    static final class a<TLeft, TRight, TLeftEnd, TRightEnd, R> extends AtomicInteger implements i.d.d, b {
        private static final long serialVersionUID = -6071216598687999801L;
        final i.d.c<? super R> actual;
        volatile boolean cancelled;
        final g.a.x0.o<? super TLeft, ? extends i.d.b<TLeftEnd>> leftEnd;
        int leftIndex;
        final g.a.x0.c<? super TLeft, ? super g.a.l<TRight>, ? extends R> resultSelector;
        final g.a.x0.o<? super TRight, ? extends i.d.b<TRightEnd>> rightEnd;
        int rightIndex;
        static final Integer LEFT_VALUE = 1;
        static final Integer RIGHT_VALUE = 2;
        static final Integer LEFT_CLOSE = 3;
        static final Integer RIGHT_CLOSE = 4;
        final AtomicLong requested = new AtomicLong();
        final g.a.u0.b disposables = new g.a.u0.b();
        final g.a.y0.f.c<Object> queue = new g.a.y0.f.c<>(g.a.l.Q());
        final Map<Integer, g.a.d1.g<TRight>> lefts = new LinkedHashMap();
        final Map<Integer, TRight> rights = new LinkedHashMap();
        final AtomicReference<Throwable> error = new AtomicReference<>();
        final AtomicInteger active = new AtomicInteger(2);

        a(i.d.c<? super R> cVar, g.a.x0.o<? super TLeft, ? extends i.d.b<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends i.d.b<TRightEnd>> oVar2, g.a.x0.c<? super TLeft, ? super g.a.l<TRight>, ? extends R> cVar2) {
            this.actual = cVar;
            this.leftEnd = oVar;
            this.rightEnd = oVar2;
            this.resultSelector = cVar2;
        }

        @Override // i.d.d
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
            g.a.y0.f.c<Object> cVar = this.queue;
            i.d.c<? super R> cVar2 = this.actual;
            int i2 = 1;
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
                    Iterator<g.a.d1.g<TRight>> it = this.lefts.values().iterator();
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
                    i2 = addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                } else {
                    Object poll = cVar.poll();
                    if (num == LEFT_VALUE) {
                        g.a.d1.g a0 = g.a.d1.g.a0();
                        int i3 = this.leftIndex;
                        this.leftIndex = i3 + 1;
                        this.lefts.put(Integer.valueOf(i3), a0);
                        try {
                            i.d.b bVar = (i.d.b) g.a.y0.b.b.a(this.leftEnd.apply(poll), "The leftEnd returned a null Publisher");
                            c cVar3 = new c(this, true, i3);
                            this.disposables.b(cVar3);
                            bVar.subscribe(cVar3);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(cVar2);
                                return;
                            }
                            try {
                                a.a.a aVar = (Object) g.a.y0.b.b.a(this.resultSelector.apply(poll, a0), "The resultSelector returned a null value");
                                if (this.requested.get() == 0) {
                                    fail(new g.a.v0.c("Could not emit value due to lack of requests"), cVar2, cVar);
                                    return;
                                }
                                cVar2.onNext(aVar);
                                g.a.y0.j.d.c(this.requested, 1L);
                                Iterator<TRight> it2 = this.rights.values().iterator();
                                while (it2.hasNext()) {
                                    a0.onNext(it2.next());
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
                        int i4 = this.rightIndex;
                        this.rightIndex = i4 + 1;
                        this.rights.put(Integer.valueOf(i4), poll);
                        try {
                            i.d.b bVar2 = (i.d.b) g.a.y0.b.b.a(this.rightEnd.apply(poll), "The rightEnd returned a null Publisher");
                            c cVar4 = new c(this, false, i4);
                            this.disposables.b(cVar4);
                            bVar2.subscribe(cVar4);
                            if (this.error.get() != null) {
                                cVar.clear();
                                cancelAll();
                                errorAll(cVar2);
                                return;
                            } else {
                                Iterator<g.a.d1.g<TRight>> it3 = this.lefts.values().iterator();
                                while (it3.hasNext()) {
                                    it3.next().onNext(poll);
                                }
                            }
                        } catch (Throwable th3) {
                            fail(th3, cVar2, cVar);
                            return;
                        }
                    } else if (num == LEFT_CLOSE) {
                        c cVar5 = (c) poll;
                        g.a.d1.g<TRight> remove = this.lefts.remove(Integer.valueOf(cVar5.index));
                        this.disposables.a(cVar5);
                        if (remove != null) {
                            remove.onComplete();
                        }
                    } else if (num == RIGHT_CLOSE) {
                        c cVar6 = (c) poll;
                        this.rights.remove(Integer.valueOf(cVar6.index));
                        this.disposables.a(cVar6);
                    }
                }
            }
            cVar.clear();
        }

        void errorAll(i.d.c<?> cVar) {
            Throwable a2 = g.a.y0.j.k.a(this.error);
            Iterator<g.a.d1.g<TRight>> it = this.lefts.values().iterator();
            while (it.hasNext()) {
                it.next().onError(a2);
            }
            this.lefts.clear();
            this.rights.clear();
            cVar.onError(a2);
        }

        void fail(Throwable th, i.d.c<?> cVar, g.a.y0.c.o<?> oVar) {
            g.a.v0.b.b(th);
            g.a.y0.j.k.a(this.error, th);
            oVar.clear();
            cancelAll();
            errorAll(cVar);
        }

        @Override // g.a.y0.e.b.l1.b
        public void innerClose(boolean z, c cVar) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_CLOSE : RIGHT_CLOSE, cVar);
            }
            drain();
        }

        @Override // g.a.y0.e.b.l1.b
        public void innerCloseError(Throwable th) {
            if (g.a.y0.j.k.a(this.error, th)) {
                drain();
            } else {
                g.a.c1.a.b(th);
            }
        }

        @Override // g.a.y0.e.b.l1.b
        public void innerComplete(d dVar) {
            this.disposables.c(dVar);
            this.active.decrementAndGet();
            drain();
        }

        @Override // g.a.y0.e.b.l1.b
        public void innerError(Throwable th) {
            if (!g.a.y0.j.k.a(this.error, th)) {
                g.a.c1.a.b(th);
            } else {
                this.active.decrementAndGet();
                drain();
            }
        }

        @Override // g.a.y0.e.b.l1.b
        public void innerValue(boolean z, Object obj) {
            synchronized (this) {
                this.queue.offer(z ? LEFT_VALUE : RIGHT_VALUE, obj);
            }
            drain();
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.a(this.requested, j2);
            }
        }
    }

    /* compiled from: FlowableGroupJoin.java */
    interface b {
        void innerClose(boolean z, c cVar);

        void innerCloseError(Throwable th);

        void innerComplete(d dVar);

        void innerError(Throwable th);

        void innerValue(boolean z, Object obj);
    }

    /* compiled from: FlowableGroupJoin.java */
    static final class c extends AtomicReference<i.d.d> implements g.a.q<Object>, g.a.u0.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final int index;
        final boolean isLeft;
        final b parent;

        c(b bVar, boolean z, int i2) {
            this.parent = bVar;
            this.isLeft = z;
            this.index = i2;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.i.j.isCancelled(get());
        }

        @Override // i.d.c
        public void onComplete() {
            this.parent.innerClose(this.isLeft, this);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.innerCloseError(th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            if (g.a.y0.i.j.cancel(this)) {
                this.parent.innerClose(this.isLeft, this);
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    /* compiled from: FlowableGroupJoin.java */
    static final class d extends AtomicReference<i.d.d> implements g.a.q<Object>, g.a.u0.c {
        private static final long serialVersionUID = 1883890389173668373L;
        final boolean isLeft;
        final b parent;

        d(b bVar, boolean z) {
            this.parent = bVar;
            this.isLeft = z;
        }

        @Override // g.a.u0.c
        public void dispose() {
            g.a.y0.i.j.cancel(this);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return g.a.y0.i.j.isCancelled(get());
        }

        @Override // i.d.c
        public void onComplete() {
            this.parent.innerComplete(this);
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            this.parent.innerError(th);
        }

        @Override // i.d.c
        public void onNext(Object obj) {
            this.parent.innerValue(this.isLeft, obj);
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this, dVar)) {
                dVar.request(h.q2.t.m0.f16408b);
            }
        }
    }

    public l1(g.a.l<TLeft> lVar, i.d.b<? extends TRight> bVar, g.a.x0.o<? super TLeft, ? extends i.d.b<TLeftEnd>> oVar, g.a.x0.o<? super TRight, ? extends i.d.b<TRightEnd>> oVar2, g.a.x0.c<? super TLeft, ? super g.a.l<TRight>, ? extends R> cVar) {
        super(lVar);
        this.f14346c = bVar;
        this.f14347d = oVar;
        this.f14348e = oVar2;
        this.f14349f = cVar;
    }

    @Override // g.a.l
    protected void d(i.d.c<? super R> cVar) {
        a aVar = new a(cVar, this.f14347d, this.f14348e, this.f14349f);
        cVar.onSubscribe(aVar);
        d dVar = new d(aVar, true);
        aVar.disposables.b(dVar);
        d dVar2 = new d(aVar, false);
        aVar.disposables.b(dVar2);
        this.f14110b.a((g.a.q) dVar);
        this.f14346c.subscribe(dVar2);
    }
}
