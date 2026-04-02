package h.a.y0.e.d;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ObservableCache.java */
/* JADX INFO: loaded from: classes2.dex */
public final class r<T> extends h.a.y0.e.d.a<T, T> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final a<T> f11588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final AtomicBoolean f11589c;

    /* JADX INFO: compiled from: ObservableCache.java */
    static final class a<T> extends h.a.y0.j.n implements h.a.i0<T> {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        static final b[] f11590k = new b[0];

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        static final b[] f11591l = new b[0];

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final h.a.b0<? extends T> f11592f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final h.a.y0.a.k f11593g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final AtomicReference<b<T>[]> f11594h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f11595i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        boolean f11596j;

        a(h.a.b0<? extends T> b0Var, int i2) {
            super(i2);
            this.f11592f = b0Var;
            this.f11594h = new AtomicReference<>(f11590k);
            this.f11593g = new h.a.y0.a.k();
        }

        public boolean a(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f11594h.get();
                if (bVarArr == f11591l) {
                    return false;
                }
                int length = bVarArr.length;
                bVarArr2 = new b[length + 1];
                System.arraycopy(bVarArr, 0, bVarArr2, 0, length);
                bVarArr2[length] = bVar;
            } while (!this.f11594h.compareAndSet(bVarArr, bVarArr2));
            return true;
        }

        public void b(b<T> bVar) {
            b<T>[] bVarArr;
            b<T>[] bVarArr2;
            do {
                bVarArr = this.f11594h.get();
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
                    bVarArr2 = f11590k;
                } else {
                    b<T>[] bVarArr3 = new b[length - 1];
                    System.arraycopy(bVarArr, 0, bVarArr3, 0, i2);
                    System.arraycopy(bVarArr, i2 + 1, bVarArr3, i2, (length - i2) - 1);
                    bVarArr2 = bVarArr3;
                }
            } while (!this.f11594h.compareAndSet(bVarArr, bVarArr2));
        }

        public void c() {
            this.f11592f.subscribe(this);
            this.f11595i = true;
        }

        @Override // h.a.i0
        public void onComplete() {
            if (this.f11596j) {
                return;
            }
            this.f11596j = true;
            a(h.a.y0.j.q.complete());
            this.f11593g.dispose();
            for (b<T> bVar : this.f11594h.getAndSet(f11591l)) {
                bVar.replay();
            }
        }

        @Override // h.a.i0
        public void onError(Throwable th) {
            if (this.f11596j) {
                return;
            }
            this.f11596j = true;
            a(h.a.y0.j.q.error(th));
            this.f11593g.dispose();
            for (b<T> bVar : this.f11594h.getAndSet(f11591l)) {
                bVar.replay();
            }
        }

        @Override // h.a.i0
        public void onNext(T t) {
            if (this.f11596j) {
                return;
            }
            a(h.a.y0.j.q.next(t));
            for (b<T> bVar : this.f11594h.get()) {
                bVar.replay();
            }
        }

        @Override // h.a.i0
        public void onSubscribe(h.a.u0.c cVar) {
            this.f11593g.update(cVar);
        }
    }

    /* JADX INFO: compiled from: ObservableCache.java */
    static final class b<T> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = 7058506693698832024L;
        volatile boolean cancelled;
        final h.a.i0<? super T> child;
        Object[] currentBuffer;
        int currentIndexInBuffer;
        int index;
        final a<T> state;

        b(h.a.i0<? super T> i0Var, a<T> aVar) {
            this.child = i0Var;
            this.state = aVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }

        public void replay() {
            if (getAndIncrement() != 0) {
                return;
            }
            h.a.i0<? super T> i0Var = this.child;
            int iAddAndGet = 1;
            while (!this.cancelled) {
                int iB = this.state.b();
                if (iB != 0) {
                    Object[] objArrA = this.currentBuffer;
                    if (objArrA == null) {
                        objArrA = this.state.a();
                        this.currentBuffer = objArrA;
                    }
                    int length = objArrA.length - 1;
                    int i2 = this.index;
                    int i3 = this.currentIndexInBuffer;
                    while (i2 < iB) {
                        if (this.cancelled) {
                            return;
                        }
                        if (i3 == length) {
                            objArrA = (Object[]) objArrA[length];
                            i3 = 0;
                        }
                        if (h.a.y0.j.q.accept(objArrA[i3], i0Var)) {
                            return;
                        }
                        i3++;
                        i2++;
                    }
                    if (this.cancelled) {
                        return;
                    }
                    this.index = i2;
                    this.currentIndexInBuffer = i3;
                    this.currentBuffer = objArrA;
                }
                iAddAndGet = addAndGet(-iAddAndGet);
                if (iAddAndGet == 0) {
                    return;
                }
            }
        }
    }

    private r(h.a.b0<T> b0Var, a<T> aVar) {
        super(b0Var);
        this.f11588b = aVar;
        this.f11589c = new AtomicBoolean();
    }

    public static <T> h.a.b0<T> a(h.a.b0<T> b0Var) {
        return a((h.a.b0) b0Var, 16);
    }

    int O() {
        return this.f11588b.b();
    }

    boolean P() {
        return this.f11588b.f11594h.get().length != 0;
    }

    boolean Q() {
        return this.f11588b.f11595i;
    }

    @Override // h.a.b0
    protected void d(h.a.i0<? super T> i0Var) {
        b<T> bVar = new b<>(i0Var, this.f11588b);
        i0Var.onSubscribe(bVar);
        this.f11588b.a((b) bVar);
        if (!this.f11589c.get() && this.f11589c.compareAndSet(false, true)) {
            this.f11588b.c();
        }
        bVar.replay();
    }

    public static <T> h.a.b0<T> a(h.a.b0<T> b0Var, int i2) {
        h.a.y0.b.b.a(i2, "capacityHint");
        return h.a.c1.a.a(new r(b0Var, new a(b0Var, i2)));
    }
}
