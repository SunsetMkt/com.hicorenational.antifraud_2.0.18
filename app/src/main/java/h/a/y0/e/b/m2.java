package h.a.y0.e.b;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: FlowablePublishMulticast.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m2<T, R> extends h.a.y0.e.b.a<T, R> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final h.a.x0.o<? super h.a.l<T>, ? extends j.d.b<? extends R>> f10789c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f10790d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final boolean f10791e;

    /* JADX INFO: compiled from: FlowablePublishMulticast.java */
    static final class b<T> extends AtomicLong implements j.d.d {
        private static final long serialVersionUID = 8664815189257569791L;
        final j.d.c<? super T> actual;
        final a<T> parent;

        b(j.d.c<? super T> cVar, a<T> aVar) {
            this.actual = cVar;
            this.parent = aVar;
        }

        @Override // j.d.d
        public void cancel() {
            if (getAndSet(Long.MIN_VALUE) != Long.MIN_VALUE) {
                this.parent.b((b) this);
                this.parent.U();
            }
        }

        public boolean isCancelled() {
            return get() == Long.MIN_VALUE;
        }

        @Override // j.d.d
        public void request(long j2) {
            if (h.a.y0.i.j.validate(j2)) {
                h.a.y0.j.d.b(this, j2);
                this.parent.U();
            }
        }
    }

    /* JADX INFO: compiled from: FlowablePublishMulticast.java */
    static final class c<R> implements h.a.q<R>, j.d.d {
        final j.d.c<? super R> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final a<?> f10805b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        j.d.d f10806c;

        c(j.d.c<? super R> cVar, a<?> aVar) {
            this.a = cVar;
            this.f10805b = aVar;
        }

        @Override // j.d.d
        public void cancel() {
            this.f10806c.cancel();
            this.f10805b.dispose();
        }

        @Override // j.d.c
        public void onComplete() {
            this.a.onComplete();
            this.f10805b.dispose();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            this.a.onError(th);
            this.f10805b.dispose();
        }

        @Override // j.d.c
        public void onNext(R r) {
            this.a.onNext(r);
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.validate(this.f10806c, dVar)) {
                this.f10806c = dVar;
                this.a.onSubscribe(this);
            }
        }

        @Override // j.d.d
        public void request(long j2) {
            this.f10806c.request(j2);
        }
    }

    public m2(h.a.l<T> lVar, h.a.x0.o<? super h.a.l<T>, ? extends j.d.b<? extends R>> oVar, int i2, boolean z) {
        super(lVar);
        this.f10789c = oVar;
        this.f10790d = i2;
        this.f10791e = z;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super R> cVar) {
        a aVar = new a(this.f10790d, this.f10791e);
        try {
            ((j.d.b) h.a.y0.b.b.a(this.f10789c.apply(aVar), "selector returned a null Publisher")).subscribe(new c(cVar, aVar));
            this.f10561b.a((h.a.q) aVar);
        } catch (Throwable th) {
            h.a.v0.b.b(th);
            h.a.y0.i.g.error(th, cVar);
        }
    }

    /* JADX INFO: compiled from: FlowablePublishMulticast.java */
    static final class a<T> extends h.a.l<T> implements h.a.q<T>, h.a.u0.c {

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        static final b[] f10792m = new b[0];

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        static final b[] f10793n = new b[0];

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final int f10796d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final int f10797e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final boolean f10798f;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile h.a.y0.c.o<T> f10800h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        int f10801i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        volatile boolean f10802j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        Throwable f10803k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        int f10804l;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final AtomicInteger f10794b = new AtomicInteger();

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicReference<j.d.d> f10799g = new AtomicReference<>();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final AtomicReference<b<T>[]> f10795c = new AtomicReference<>(f10792m);

        a(int i2, boolean z) {
            this.f10796d = i2;
            this.f10797e = i2 - (i2 >> 2);
            this.f10798f = z;
        }

        void T() {
            for (b<T> bVar : this.f10795c.getAndSet(f10793n)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.actual.onComplete();
                }
            }
        }

        void U() {
            Throwable th;
            Throwable th2;
            if (this.f10794b.getAndIncrement() != 0) {
                return;
            }
            h.a.y0.c.o<T> oVar = this.f10800h;
            int i2 = this.f10804l;
            int i3 = this.f10797e;
            boolean z = this.f10801i != 1;
            int i4 = i2;
            int iAddAndGet = 1;
            while (true) {
                b<T>[] bVarArr = this.f10795c.get();
                int length = bVarArr.length;
                if (oVar != null && length != 0) {
                    long j2 = Long.MAX_VALUE;
                    for (b<T> bVar : bVarArr) {
                        long j3 = bVar.get();
                        if (j3 != Long.MIN_VALUE && j2 > j3) {
                            j2 = j3;
                        }
                    }
                    long j4 = 0;
                    while (j4 != j2) {
                        if (isDisposed()) {
                            oVar.clear();
                            return;
                        }
                        boolean z2 = this.f10802j;
                        if (z2 && !this.f10798f && (th2 = this.f10803k) != null) {
                            b(th2);
                            return;
                        }
                        try {
                            T tPoll = oVar.poll();
                            boolean z3 = tPoll == null;
                            if (z2 && z3) {
                                Throwable th3 = this.f10803k;
                                if (th3 != null) {
                                    b(th3);
                                    return;
                                } else {
                                    T();
                                    return;
                                }
                            }
                            if (z3) {
                                break;
                            }
                            int length2 = bVarArr.length;
                            int i5 = 0;
                            while (i5 < length2) {
                                int i6 = length2;
                                b<T> bVar2 = bVarArr[i5];
                                if (bVar2.get() != Long.MIN_VALUE) {
                                    bVar2.actual.onNext(tPoll);
                                }
                                i5++;
                                length2 = i6;
                            }
                            j4++;
                            if (z) {
                                int i7 = i4 + 1;
                                if (i7 == i3) {
                                    this.f10799g.get().request(i3);
                                    i4 = 0;
                                } else {
                                    i4 = i7;
                                }
                            }
                        } catch (Throwable th4) {
                            h.a.v0.b.b(th4);
                            h.a.y0.i.j.cancel(this.f10799g);
                            b(th4);
                            return;
                        }
                    }
                    if (j4 == j2) {
                        if (isDisposed()) {
                            oVar.clear();
                            return;
                        }
                        boolean z4 = this.f10802j;
                        if (z4 && !this.f10798f && (th = this.f10803k) != null) {
                            b(th);
                            return;
                        }
                        if (z4 && oVar.isEmpty()) {
                            Throwable th5 = this.f10803k;
                            if (th5 != null) {
                                b(th5);
                                return;
                            } else {
                                T();
                                return;
                            }
                        }
                    }
                    for (b<T> bVar3 : bVarArr) {
                        h.a.y0.j.d.c(bVar3, j4);
                    }
                }
                this.f10804l = i4;
                iAddAndGet = this.f10794b.addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
                if (oVar == null) {
                    oVar = this.f10800h;
                }
            }
        }

        boolean a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f10795c.get();
                if (bVarArr == f10793n) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f10795c.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        void b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f10795c.get();
                if (bVarArr == f10793n || bVarArr == f10792m) {
                    return;
                }
                int length = bVarArr.length;
                int i2 = -1;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    }
                    if (bVarArr[i3] == bVar) {
                        i2 = i3;
                        break;
                    }
                    i3++;
                }
                if (i2 < 0) {
                    return;
                }
                if (length == 1) {
                    bVarArr2 = f10792m;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f10795c.compareAndSet(bVarArr, bVarArr2));
        }

        @Override // h.a.l
        protected void d(j.d.c<? super T> cVar) {
            b<T> bVar = new b<>(cVar, this);
            cVar.onSubscribe(bVar);
            if (a((b) bVar)) {
                if (bVar.isCancelled()) {
                    b((b) bVar);
                    return;
                } else {
                    U();
                    return;
                }
            }
            Throwable th = this.f10803k;
            if (th != null) {
                cVar.onError(th);
            } else {
                cVar.onComplete();
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            h.a.y0.c.o<T> oVar;
            h.a.y0.i.j.cancel(this.f10799g);
            if (this.f10794b.getAndIncrement() != 0 || (oVar = this.f10800h) == null) {
                return;
            }
            oVar.clear();
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return h.a.y0.i.j.isCancelled(this.f10799g.get());
        }

        @Override // j.d.c
        public void onComplete() {
            if (this.f10802j) {
                return;
            }
            this.f10802j = true;
            U();
        }

        @Override // j.d.c
        public void onError(Throwable th) {
            if (this.f10802j) {
                h.a.c1.a.b(th);
                return;
            }
            this.f10803k = th;
            this.f10802j = true;
            U();
        }

        @Override // j.d.c
        public void onNext(T t) {
            if (this.f10802j) {
                return;
            }
            if (this.f10801i != 0 || this.f10800h.offer(t)) {
                U();
            } else {
                this.f10799g.get().cancel();
                onError(new h.a.v0.c());
            }
        }

        @Override // h.a.q
        public void onSubscribe(j.d.d dVar) {
            if (h.a.y0.i.j.setOnce(this.f10799g, dVar)) {
                if (dVar instanceof h.a.y0.c.l) {
                    h.a.y0.c.l lVar = (h.a.y0.c.l) dVar;
                    int iRequestFusion = lVar.requestFusion(3);
                    if (iRequestFusion == 1) {
                        this.f10801i = iRequestFusion;
                        this.f10800h = lVar;
                        this.f10802j = true;
                        U();
                        return;
                    }
                    if (iRequestFusion == 2) {
                        this.f10801i = iRequestFusion;
                        this.f10800h = lVar;
                        h.a.y0.j.v.a(dVar, this.f10796d);
                        return;
                    }
                }
                this.f10800h = h.a.y0.j.v.a(this.f10796d);
                h.a.y0.j.v.a(dVar, this.f10796d);
            }
        }

        void b(Throwable th) {
            for (b<T> bVar : this.f10795c.getAndSet(f10793n)) {
                if (bVar.get() != Long.MIN_VALUE) {
                    bVar.actual.onError(th);
                }
            }
        }
    }
}
