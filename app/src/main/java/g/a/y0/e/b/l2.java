package g.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* compiled from: FlowablePublish.java */
/* loaded from: classes2.dex */
public final class l2<T> extends g.a.w0.a<T> implements g.a.y0.c.h<T> {

    /* renamed from: f, reason: collision with root package name */
    static final long f14350f = Long.MIN_VALUE;

    /* renamed from: b, reason: collision with root package name */
    final g.a.l<T> f14351b;

    /* renamed from: c, reason: collision with root package name */
    final AtomicReference<c<T>> f14352c;

    /* renamed from: d, reason: collision with root package name */
    final int f14353d;

    /* renamed from: e, reason: collision with root package name */
    final i.d.b<T> f14354e;

    /* compiled from: FlowablePublish.java */
    static final class a<T> implements i.d.b<T> {

        /* renamed from: a, reason: collision with root package name */
        private final AtomicReference<c<T>> f14355a;

        /* renamed from: b, reason: collision with root package name */
        private final int f14356b;

        a(AtomicReference<c<T>> atomicReference, int i2) {
            this.f14355a = atomicReference;
            this.f14356b = i2;
        }

        @Override // i.d.b
        public void subscribe(i.d.c<? super T> cVar) {
            c<T> cVar2;
            b<T> bVar = new b<>(cVar);
            cVar.onSubscribe(bVar);
            while (true) {
                cVar2 = this.f14355a.get();
                if (cVar2 == null || cVar2.isDisposed()) {
                    c<T> cVar3 = new c<>(this.f14355a, this.f14356b);
                    if (this.f14355a.compareAndSet(cVar2, cVar3)) {
                        cVar2 = cVar3;
                    } else {
                        continue;
                    }
                }
                if (cVar2.add(bVar)) {
                    break;
                }
            }
            if (bVar.get() == Long.MIN_VALUE) {
                cVar2.remove(bVar);
            } else {
                bVar.parent = cVar2;
            }
            cVar2.dispatch();
        }
    }

    /* compiled from: FlowablePublish.java */
    static final class b<T> extends AtomicLong implements i.d.d {
        private static final long serialVersionUID = -4453897557930727610L;
        final i.d.c<? super T> child;
        volatile c<T> parent;

        b(i.d.c<? super T> cVar) {
            this.child = cVar;
        }

        @Override // i.d.d
        public void cancel() {
            c<T> cVar;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (cVar = this.parent) == null) {
                return;
            }
            cVar.remove(this);
            cVar.dispatch();
        }

        public long produced(long j2) {
            return g.a.y0.j.d.d(this, j2);
        }

        @Override // i.d.d
        public void request(long j2) {
            if (g.a.y0.i.j.validate(j2)) {
                g.a.y0.j.d.b(this, j2);
                c<T> cVar = this.parent;
                if (cVar != null) {
                    cVar.dispatch();
                }
            }
        }
    }

    /* compiled from: FlowablePublish.java */
    static final class c<T> extends AtomicInteger implements g.a.q<T>, g.a.u0.c {
        static final b[] EMPTY = new b[0];
        static final b[] TERMINATED = new b[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<c<T>> current;
        volatile g.a.y0.c.o<T> queue;
        int sourceMode;
        volatile Object terminalEvent;
        final AtomicReference<i.d.d> s = new AtomicReference<>();
        final AtomicReference<b[]> subscribers = new AtomicReference<>(EMPTY);
        final AtomicBoolean shouldConnect = new AtomicBoolean();

        c(AtomicReference<c<T>> atomicReference, int i2) {
            this.current = atomicReference;
            this.bufferSize = i2;
        }

        boolean add(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.subscribers.get();
                if (bVarArr == TERMINATED) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.subscribers.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        boolean checkTerminated(Object obj, boolean z) {
            int i2 = 0;
            if (obj != null) {
                if (!g.a.y0.j.q.isComplete(obj)) {
                    Throwable error = g.a.y0.j.q.getError(obj);
                    this.current.compareAndSet(this, null);
                    b[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].child.onError(error);
                            i2++;
                        }
                    } else {
                        g.a.c1.a.b(error);
                    }
                    return true;
                }
                if (z) {
                    this.current.compareAndSet(this, null);
                    b[] andSet2 = this.subscribers.getAndSet(TERMINATED);
                    int length2 = andSet2.length;
                    while (i2 < length2) {
                        andSet2[i2].child.onComplete();
                        i2++;
                    }
                    return true;
                }
            }
            return false;
        }

        /* JADX WARN: Code restructure failed: missing block: B:79:0x0115, code lost:
        
            if (r16 == false) goto L75;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        void dispatch() {
            /*
                Method dump skipped, instructions count: 294
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: g.a.y0.e.b.l2.c.dispatch():void");
        }

        @Override // g.a.u0.c
        public void dispose() {
            b[] bVarArr = this.subscribers.get();
            b[] bVarArr2 = TERMINATED;
            if (bVarArr == bVarArr2 || this.subscribers.getAndSet(bVarArr2) == TERMINATED) {
                return;
            }
            this.current.compareAndSet(this, null);
            g.a.y0.i.j.cancel(this.s);
        }

        @Override // g.a.u0.c
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // i.d.c
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = g.a.y0.j.q.complete();
                dispatch();
            }
        }

        @Override // i.d.c
        public void onError(Throwable th) {
            if (this.terminalEvent != null) {
                g.a.c1.a.b(th);
            } else {
                this.terminalEvent = g.a.y0.j.q.error(th);
                dispatch();
            }
        }

        @Override // i.d.c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new g.a.v0.c("Prefetch queue is full?!"));
            }
        }

        @Override // g.a.q
        public void onSubscribe(i.d.d dVar) {
            if (g.a.y0.i.j.setOnce(this.s, dVar)) {
                if (dVar instanceof g.a.y0.c.l) {
                    g.a.y0.c.l lVar = (g.a.y0.c.l) dVar;
                    int requestFusion = lVar.requestFusion(3);
                    if (requestFusion == 1) {
                        this.sourceMode = requestFusion;
                        this.queue = lVar;
                        this.terminalEvent = g.a.y0.j.q.complete();
                        dispatch();
                        return;
                    }
                    if (requestFusion == 2) {
                        this.sourceMode = requestFusion;
                        this.queue = lVar;
                        dVar.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new g.a.y0.f.b(this.bufferSize);
                dVar.request(this.bufferSize);
            }
        }

        void remove(b<T> bVar) {
            b[] bVarArr;
            b[] bVarArr2;
            do {
                bVarArr = this.subscribers.get();
                int length = bVarArr.length;
                if (length == 0) {
                    return;
                }
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3].equals(bVar)) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = EMPTY;
                } else {
                    b[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.subscribers.compareAndSet(bVarArr, bVarArr2));
        }
    }

    private l2(i.d.b<T> bVar, g.a.l<T> lVar, AtomicReference<c<T>> atomicReference, int i2) {
        this.f14354e = bVar;
        this.f14351b = lVar;
        this.f14352c = atomicReference;
        this.f14353d = i2;
    }

    public static <T> g.a.w0.a<T> a(g.a.l<T> lVar, int i2) {
        AtomicReference atomicReference = new AtomicReference();
        return g.a.c1.a.a((g.a.w0.a) new l2(new a(atomicReference, i2), lVar, atomicReference, i2));
    }

    @Override // g.a.l
    protected void d(i.d.c<? super T> cVar) {
        this.f14354e.subscribe(cVar);
    }

    @Override // g.a.w0.a
    public void l(g.a.x0.g<? super g.a.u0.c> gVar) {
        c<T> cVar;
        while (true) {
            cVar = this.f14352c.get();
            if (cVar != null && !cVar.isDisposed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f14352c, this.f14353d);
            if (this.f14352c.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = !cVar.shouldConnect.get() && cVar.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(cVar);
            if (z) {
                this.f14351b.a((g.a.q) cVar);
            }
        } catch (Throwable th) {
            g.a.v0.b.b(th);
            throw g.a.y0.j.k.c(th);
        }
    }

    @Override // g.a.y0.c.h
    public i.d.b<T> source() {
        return this.f14351b;
    }
}
