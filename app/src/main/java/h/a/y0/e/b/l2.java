package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowablePublish.java */
/* JADX INFO: loaded from: classes2.dex */
public final class l2<T> extends h.a.w0.a<T> implements h.a.y0.c.h<T> {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final long f10762f = Long.MIN_VALUE;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final h.a.l<T> f10763b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicReference<c<T>> f10764c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10765d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final j.d.b<T> f10766e;

    /* JADX INFO: compiled from: FlowablePublish.java */
    static final class a<T> implements j.d.b<T> {
        private final AtomicReference<c<T>> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f10767b;

        a(AtomicReference<c<T>> atomicReference, int i2) {
            this.a = atomicReference;
            this.f10767b = i2;
        }

        @Override // j.d.b
        public void subscribe(j.d.c<? super T> cVar) {
            c<T> cVar2;
            b<T> bVar = new b<>(cVar);
            cVar.onSubscribe(bVar);
            while (true) {
                cVar2 = this.a.get();
                if (cVar2 == null || cVar2.isDisposed()) {
                    c<T> cVar3 = new c<>(this.a, this.f10767b);
                    if (this.a.compareAndSet(cVar2, cVar3)) {
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

    /* JADX INFO: compiled from: FlowablePublish.java */
    static final class b<T> extends AtomicLong implements j.d.d {
        private static final long serialVersionUID = -4453897557930727610L;
        final j.d.c<? super T> child;
        volatile c<T> parent;

        b(j.d.c<? super T> cVar) {
            this.child = cVar;
        }

        @Override // j.d.d
        public void cancel() {
            c<T> cVar;
            if (get() == Long.MIN_VALUE || getAndSet(Long.MIN_VALUE) == Long.MIN_VALUE || (cVar = this.parent) == null) {
                return;
            }
            cVar.remove(this);
            cVar.dispatch();
        }

        public long produced(long j2) {
            return h.a.y0.j.d.d(this, j2);
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.b(this, j2);
                c<T> cVar = this.parent;
                if (cVar != null) {
                    cVar.dispatch();
                }
            }
        }
    }

    /* JADX INFO: compiled from: FlowablePublish.java */
    static final class c<T> extends AtomicInteger implements h.a.q<T>, h.a.u0.c {
        static final b[] EMPTY = new b[0];
        static final b[] TERMINATED = new b[0];
        private static final long serialVersionUID = -202316842419149694L;
        final int bufferSize;
        final AtomicReference<c<T>> current;
        volatile h.a.y0.c.o<T> queue;
        int sourceMode;
        volatile Object terminalEvent;
        final AtomicReference<j.d.d> s = new AtomicReference<>();
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
                if (!h.a.y0.j.q.isComplete(obj)) {
                    Throwable error = h.a.y0.j.q.getError(obj);
                    this.current.compareAndSet(this, null);
                    b[] andSet = this.subscribers.getAndSet(TERMINATED);
                    if (andSet.length != 0) {
                        int length = andSet.length;
                        while (i2 < length) {
                            andSet[i2].child.onError(error);
                            i2++;
                        }
                    } else {
                        h.a.c1.a.b(error);
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

        void dispatch() {
            int i2;
            long j2;
            long j3;
            T tPoll;
            T tPoll2;
            if (getAndIncrement() != 0) {
                return;
            }
            int i3 = 1;
            int iAddAndGet = 1;
            while (true) {
                Object obj = this.terminalEvent;
                h.a.y0.c.o<T> oVar = this.queue;
                boolean z = oVar == null || oVar.isEmpty();
                if (checkTerminated(obj, z)) {
                    return;
                }
                if (z) {
                    i2 = iAddAndGet;
                } else {
                    b[] bVarArr = this.subscribers.get();
                    int length = bVarArr.length;
                    int length2 = bVarArr.length;
                    long jMin = Long.MAX_VALUE;
                    int i4 = 0;
                    int i5 = 0;
                    while (true) {
                        j2 = 0;
                        if (i4 >= length2) {
                            break;
                        }
                        boolean z2 = z;
                        long j4 = bVarArr[i4].get();
                        if (j4 >= 0) {
                            jMin = Math.min(jMin, j4);
                        } else if (j4 == Long.MIN_VALUE) {
                            i5++;
                        }
                        i4++;
                        z = z2;
                    }
                    boolean z3 = z;
                    if (length == i5) {
                        Object objError = this.terminalEvent;
                        try {
                            tPoll2 = oVar.poll();
                        } catch (Throwable th) {
                            h.a.v0.b.b(th);
                            this.s.get().cancel();
                            objError = h.a.y0.j.q.error(th);
                            this.terminalEvent = objError;
                            tPoll2 = null;
                        }
                        if (checkTerminated(objError, tPoll2 == null)) {
                            return;
                        }
                        if (this.sourceMode != i3) {
                            this.s.get().request(1L);
                        }
                        i2 = iAddAndGet;
                    } else {
                        i2 = iAddAndGet;
                        int i6 = 0;
                        while (true) {
                            j3 = i6;
                            if (j3 >= jMin) {
                                break;
                            }
                            Object objError2 = this.terminalEvent;
                            try {
                                tPoll = oVar.poll();
                            } catch (Throwable th2) {
                                h.a.v0.b.b(th2);
                                this.s.get().cancel();
                                objError2 = h.a.y0.j.q.error(th2);
                                this.terminalEvent = objError2;
                                tPoll = null;
                            }
                            boolean z4 = tPoll == null;
                            if (checkTerminated(objError2, z4)) {
                                return;
                            }
                            if (z4) {
                                z3 = z4;
                                break;
                            }
                            Object value = h.a.y0.j.q.getValue(tPoll);
                            int length3 = bVarArr.length;
                            int i7 = 0;
                            while (i7 < length3) {
                                b bVar = bVarArr[i7];
                                if (bVar.get() > j2) {
                                    bVar.child.onNext(value);
                                    bVar.produced(1L);
                                }
                                i7++;
                                j2 = 0;
                            }
                            i6++;
                            z3 = z4;
                            j2 = 0;
                        }
                        if (i6 > 0 && this.sourceMode != 1) {
                            this.s.get().request(j3);
                        }
                        if (jMin == 0 || z3) {
                        }
                        i3 = 1;
                    }
                    iAddAndGet = i2;
                    i3 = 1;
                }
                iAddAndGet = addAndGet(-i2);
                if (iAddAndGet == 0) {
                    return;
                } else {
                    i3 = 1;
                }
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            b[] bVarArr = this.subscribers.get();
            b[] bVarArr2 = TERMINATED;
            if (bVarArr == bVarArr2 || this.subscribers.getAndSet(bVarArr2) == TERMINATED) {
                return;
            }
            this.current.compareAndSet(this, null);
            h.a.y0.i.j.cancel(this.s);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.subscribers.get() == TERMINATED;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.terminalEvent == null) {
                this.terminalEvent = h.a.y0.j.q.complete();
                dispatch();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.terminalEvent != null) {
                h.a.c1.a.b(th);
            } else {
                this.terminalEvent = h.a.y0.j.q.error(th);
                dispatch();
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.sourceMode != 0 || this.queue.offer(t)) {
                dispatch();
            } else {
                onError(new h.a.v0.c("Prefetch queue is full?!"));
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this.s, dVar)) {
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        this.terminalEvent = h.a.y0.j.q.complete();
                        dispatch();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.sourceMode = iRequestFusion;
                        this.queue = lVar;
                        dVar.request(this.bufferSize);
                        return;
                    }
                }
                this.queue = new h.a.y0.f.b(this.bufferSize);
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

    private l2(j.d.b<T> bVar, h.a.l<T> lVar, AtomicReference<c<T>> atomicReference, int i2) {
        this.f10766e = bVar;
        this.f10763b = lVar;
        this.f10764c = atomicReference;
        this.f10765d = i2;
    }

    public static <T> h.a.w0.a<T> a(h.a.l<T> lVar, int i2) {
        AtomicReference atomicReference = new AtomicReference();
        return h.a.c1.a.a((h.a.w0.a) new l2(new a(atomicReference, i2), lVar, atomicReference, i2));
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        this.f10766e.subscribe(cVar);
    }

    @Override // h.a.w0.a
    public void l(h.a.x0.g<? super h.a.u0.c> gVar) {
        c<T> cVar;
        while (true) {
            cVar = this.f10764c.get();
            if (cVar != null && !cVar.isDisposed()) {
                break;
            }
            c<T> cVar2 = new c<>(this.f10764c, this.f10765d);
            if (this.f10764c.compareAndSet(cVar, cVar2)) {
                cVar = cVar2;
                break;
            }
        }
        boolean z = !cVar.shouldConnect.get() && cVar.shouldConnect.compareAndSet(false, true);
        try {
            gVar.accept(cVar);
            if (z) {
                this.f10763b.a((h.a.q) cVar);
            }
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            throw h.a.y0.j.k.c(th);
        }
    }

    @Override // h.a.y0.c.h
    public j.d.b<T> source() {
        return this.f10763b;
    }
}
