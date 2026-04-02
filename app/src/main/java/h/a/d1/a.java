package h.a.d1;

import i.q2.t.m0;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AsyncProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> extends c<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final C0171a[] f10265e = new C0171a[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final C0171a[] f10266f = new C0171a[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<C0171a<T>[]> f10267b = new AtomicReference<>(f10265e);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Throwable f10268c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    T f10269d;

    /* JADX INFO: renamed from: h.a.d1.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncProcessor.java */
    static final class C0171a<T> extends h.a.y0.i.f<T> {
        private static final long serialVersionUID = 5629876084736248016L;
        final a<T> parent;

        C0171a(j.d.c<? super T> cVar, a<T> aVar) {
            super(cVar);
            this.parent = aVar;
        }

        @Override // h.a.y0.i.f, j.d.d
        public void cancel() {
            if (super.tryCancel()) {
                this.parent.b((C0171a) this);
            }
        }

        void onComplete() {
            if (isCancelled()) {
                return;
            }
            this.actual.onComplete();
        }

        void onError(Throwable th) {
            if (isCancelled()) {
                h.a.c1.a.b(th);
            } else {
                this.actual.onError(th);
            }
        }
    }

    a() {
    }

    @h.a.t0.f
    @h.a.t0.d
    public static <T> a<T> c0() {
        return new a<>();
    }

    @Override // h.a.d1.c
    public Throwable T() {
        if (this.f10267b.get() == f10266f) {
            return this.f10268c;
        }
        return null;
    }

    @Override // h.a.d1.c
    public boolean U() {
        return this.f10267b.get() == f10266f && this.f10268c == null;
    }

    @Override // h.a.d1.c
    public boolean V() {
        return this.f10267b.get().length != 0;
    }

    @Override // h.a.d1.c
    public boolean W() {
        return this.f10267b.get() == f10266f && this.f10268c != null;
    }

    public T Y() {
        if (this.f10267b.get() == f10266f) {
            return this.f10269d;
        }
        return null;
    }

    public Object[] Z() {
        T tY = Y();
        return tY != null ? new Object[]{tY} : new Object[0];
    }

    boolean a(C0171a<T> c0171a) {
        C0171a<T>[] c0171aArr;
        C0171a<T>[] c0171aArr2;
        do {
            c0171aArr = this.f10267b.get();
            if (c0171aArr == f10266f) {
                return false;
            }
            int length = c0171aArr.length;
            c0171aArr2 = new C0171a[length + 1];
            System.arraycopy(c0171aArr, 0, c0171aArr2, 0, length);
            c0171aArr2[length] = c0171a;
        } while (!this.f10267b.compareAndSet(c0171aArr, c0171aArr2));
        return true;
    }

    public boolean a0() {
        return this.f10267b.get() == f10266f && this.f10269d != null;
    }

    void b(C0171a<T> c0171a) {
        C0171a<T>[] c0171aArr;
        C0171a<T>[] c0171aArr2;
        do {
            c0171aArr = this.f10267b.get();
            int length = c0171aArr.length;
            if (length == 0) {
                return;
            }
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (c0171aArr[i3] == c0171a) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                c0171aArr2 = f10265e;
            } else {
                C0171a<T>[] c0171aArr3 = new C0171a[length - 1];
                System.arraycopy(c0171aArr, 0, c0171aArr3, 0, i2);
                System.arraycopy(c0171aArr, i2 + 1, c0171aArr3, i2, (length - i2) - 1);
                c0171aArr2 = c0171aArr3;
            }
        } while (!this.f10267b.compareAndSet(c0171aArr, c0171aArr2));
    }

    void b0() {
        this.f10269d = null;
        NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
        this.f10268c = nullPointerException;
        for (C0171a<T> c0171a : this.f10267b.getAndSet(f10266f)) {
            c0171a.onError(nullPointerException);
        }
    }

    public T[] c(T[] tArr) {
        T tY = Y();
        if (tY == null) {
            if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }
        if (tArr.length == 0) {
            tArr = (T[]) Arrays.copyOf(tArr, 1);
        }
        tArr[0] = tY;
        if (tArr.length != 1) {
            tArr[1] = null;
        }
        return tArr;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        C0171a<T> c0171a = new C0171a<>(cVar, this);
        cVar.onSubscribe(c0171a);
        if (a((C0171a) c0171a)) {
            if (c0171a.isCancelled()) {
                b((C0171a) c0171a);
                return;
            }
            return;
        }
        Throwable th = this.f10268c;
        if (th != null) {
            cVar.onError(th);
            return;
        }
        T t = this.f10269d;
        if (t != null) {
            c0171a.complete(t);
        } else {
            c0171a.onComplete();
        }
    }

    @Override // j.d.c
    public void onComplete() {
        C0171a<T>[] c0171aArr = this.f10267b.get();
        C0171a<T>[] c0171aArr2 = f10266f;
        if (c0171aArr == c0171aArr2) {
            return;
        }
        T t = this.f10269d;
        C0171a<T>[] andSet = this.f10267b.getAndSet(c0171aArr2);
        int i2 = 0;
        if (t == null) {
            int length = andSet.length;
            while (i2 < length) {
                andSet[i2].onComplete();
                i2++;
            }
            return;
        }
        int length2 = andSet.length;
        while (i2 < length2) {
            andSet[i2].complete(t);
            i2++;
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        C0171a<T>[] c0171aArr = this.f10267b.get();
        C0171a<T>[] c0171aArr2 = f10266f;
        if (c0171aArr == c0171aArr2) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10269d = null;
        this.f10268c = th;
        for (C0171a<T> c0171a : this.f10267b.getAndSet(c0171aArr2)) {
            c0171a.onError(th);
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (this.f10267b.get() == f10266f) {
            return;
        }
        if (t == null) {
            b0();
        } else {
            this.f10269d = t;
        }
    }

    @Override // j.d.c, h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (this.f10267b.get() == f10266f) {
            dVar.cancel();
        } else {
            dVar.request(m0.f12222b);
        }
    }
}
