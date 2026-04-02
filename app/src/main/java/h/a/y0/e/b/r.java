package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowableCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T> extends h.a.y0.e.b.a<T, T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final a<T> f10924c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicBoolean f10925d;

    /* JADX INFO: compiled from: FlowableCache.java */
    static final class a<T> extends h.a.y0.j.n implements h.a.q<T> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final b[] f10926k = new b[0];

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final b[] f10927l = new b[0];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.l<T> f10928f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference<j.d.d> f10929g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference<b<T>[]> f10930h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f10931i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f10932j;

        a(h.a.l<T> lVar, int i2) {
            super(i2);
            this.f10929g = new AtomicReference<>();
            this.f10928f = lVar;
            this.f10930h = new AtomicReference<>(f10926k);
        }

        public void a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f10930h.get();
                if (bVarArr == f10927l) {
                    return;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f10930h.compareAndSet(bVarArr, bVarArr2));
        }

        public void b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f10930h.get();
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
                    bVarArr2 = f10926k;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f10930h.compareAndSet(bVarArr, bVarArr2));
        }

        public void c() {
            this.f10928f.a((h.a.q) this);
            this.f10931i = true;
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10932j) {
                return;
            }
            this.f10932j = true;
            a(h.a.y0.j.q.complete());
            h.a.y0.i.j.cancel(this.f10929g);
            for (b<T> bVar : this.f10930h.getAndSet(f10927l)) {
                bVar.replay();
            }
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10932j) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10932j = true;
            a(h.a.y0.j.q.error(th));
            h.a.y0.i.j.cancel(this.f10929g);
            for (b<T> bVar : this.f10930h.getAndSet(f10927l)) {
                bVar.replay();
            }
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10932j) {
                return;
            }
            a(h.a.y0.j.q.next(t));
            for (b<T> bVar : this.f10930h.get()) {
                bVar.replay();
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this.f10929g, dVar)) {
                dVar.request(i.q2.t.m0.f12222b);
            }
        }
    }

    /* JADX INFO: compiled from: FlowableCache.java */
    static final class b<T> extends AtomicInteger implements j.d.d {
        private static final long a = -1;
        private static final long serialVersionUID = -2557562030197141021L;
        final j.d.c<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final AtomicLong requested = new AtomicLong();
        final a<T> state;

        b(j.d.c<? super T> cVar, a<T> aVar) {
            this.child = cVar;
            this.state = aVar;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.requested.getAndSet(-1L) != -1) {
                this.state.b(this);
            }
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super T> cVar = this.child;
            AtomicLong atomicLong = this.requested;
            int i2 = 1;
            int iAddAndGet = 1;
            while (true) {
                long j2 = atomicLong.get();
                if (j2 < 0) {
                    return;
                }
                int iB = this.state.b();
                if (iB != 0) {
                    Object[] objArrA = this.currentBuffer;
                    if (objArrA == null) {
                        objArrA = this.state.a();
                        this.currentBuffer = objArrA;
                    }
                    int length = objArrA.length - i2;
                    int i3 = this.index;
                    int i4 = this.currentIndexInBuffer;
                    int i5 = 0;
                    while (i3 < iB && j2 > 0) {
                        if (atomicLong.get() == -1) {
                            return;
                        }
                        if (i4 == length) {
                            objArrA = (Object[]) objArrA[length];
                            i4 = 0;
                        }
                        if (h.a.y0.j.q.accept(objArrA[i4], cVar)) {
                            return;
                        }
                        i4++;
                        i3++;
                        j2--;
                        i5++;
                    }
                    if (atomicLong.get() == -1) {
                        return;
                    }
                    if (j2 == 0) {
                        Object obj = objArrA[i4];
                        if (h.a.y0.j.q.isComplete(obj)) {
                            cVar.onComplete();
                            return;
                        } else if (h.a.y0.j.q.isError(obj)) {
                            cVar.onError(h.a.y0.j.q.getError(obj));
                            return;
                        }
                    }
                    if (i5 != 0) {
                        h.a.y0.j.d.d(atomicLong, i5);
                    }
                    this.index = i3;
                    this.currentIndexInBuffer = i4;
                    this.currentBuffer = objArrA;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                } else {
                    i2 = 1;
                }
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            long j3;
            if (h.a.y0.i.j.validate(j2)) {
                do {
                    j3 = this.requested.get();
                    if (j3 == -1) {
                        return;
                    }
                } while (!this.requested.compareAndSet(j3, h.a.y0.j.d.a(j3, j2)));
                replay();
            }
        }
    }

    public r(h.a.l<T> lVar, int i2) {
        super(lVar);
        this.f10924c = new a<>(lVar, i2);
        this.f10925d = new AtomicBoolean();
    }

    int T() {
        return this.f10924c.b();
    }

    boolean U() {
        return this.f10924c.f10930h.get().length != 0;
    }

    boolean V() {
        return this.f10924c.f10931i;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        b<T> bVar = new b<>(cVar, this.f10924c);
        this.f10924c.a((b) bVar);
        cVar.onSubscribe(bVar);
        if (this.f10925d.get() || !this.f10925d.compareAndSet(false, true)) {
            return;
        }
        this.f10924c.c();
    }
}
