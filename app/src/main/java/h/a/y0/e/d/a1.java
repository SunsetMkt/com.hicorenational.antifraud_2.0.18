package h.a.y0.e.d;

/* JADX INFO: compiled from: ObservableFromArray.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a1<T> extends h.a.b0<T> {
    final T[] a;

    /* JADX INFO: compiled from: ObservableFromArray.java */
    static final class a<T> extends h.a.y0.d.c<T> {
        final h.a.i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final T[] f11213b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f11214c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f11215d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        volatile boolean f11216e;

        a(h.a.i0<? super T> i0Var, T[] tArr) {
            this.a = i0Var;
            this.f11213b = tArr;
        }

        void a() {
            T[] tArr = this.f11213b;
            int length = tArr.length;
            for (int i2 = 0; i2 < length && !isDisposed(); i2++) {
                T t = tArr[i2];
                if (t == null) {
                    this.a.onError(new NullPointerException("The " + i2 + "th element is null"));
                    return;
                }
                this.a.onNext(t);
            }
            if (isDisposed()) {
                return;
            }
            this.a.onComplete();
        }

        @Override // h.a.y0.c.o
        public void clear() {
            this.f11214c = this.f11213b.length;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f11216e = true;
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f11216e;
        }

        @Override // h.a.y0.c.o
        public boolean isEmpty() {
            return this.f11214c == this.f11213b.length;
        }

        @Override // h.a.y0.c.o
        @h.a.t0.g
        public T poll() {
            int i2 = this.f11214c;
            T[] tArr = this.f11213b;
            if (i2 == tArr.length) {
                return null;
            }
            this.f11214c = i2 + 1;
            return (T) h.a.y0.b.b.a((Object) tArr[i2], "The array element is null");
        }

        @Override // h.a.y0.c.k
        public int requestFusion(int i2) {
            if ((i2 & 1) == 0) {
                return 0;
            }
            this.f11215d = true;
            return 1;
        }
    }

    public a1(T[] tArr) {
        this.a = tArr;
    }

    @Override // h.a.b0
    public void d(h.a.i0<? super T> i0Var) {
        a aVar = new a(i0Var, this.a);
        i0Var.onSubscribe(aVar);
        if (aVar.f11215d) {
            return;
        }
        aVar.a();
    }
}
