package h.a.f1;

import h.a.i0;
import h.a.y0.j.a;
import h.a.y0.j.k;
import h.a.y0.j.q;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: BehaviorSubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends i<T> {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final Object[] f10339h = new Object[0];

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final a[] f10340i = new a[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final a[] f10341j = new a[0];
    final AtomicReference<Object> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f10342b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ReadWriteLock f10343c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Lock f10344d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Lock f10345e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicReference<Throwable> f10346f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    long f10347g;

    b() {
        this.f10343c = new ReentrantReadWriteLock();
        this.f10344d = this.f10343c.readLock();
        this.f10345e = this.f10343c.writeLock();
        this.f10342b = new AtomicReference<>(f10340i);
        this.a = new AtomicReference<>();
        this.f10346f = new AtomicReference<>();
    }

    @h.a.t0.d
    public static <T> b<T> X() {
        return new b<>();
    }

    @h.a.t0.d
    public static <T> b<T> o(T t) {
        return new b<>(t);
    }

    @Override // h.a.f1.i
    public Throwable O() {
        Object obj = this.a.get();
        if (q.isError(obj)) {
            return q.getError(obj);
        }
        return null;
    }

    @Override // h.a.f1.i
    public boolean P() {
        return q.isComplete(this.a.get());
    }

    @Override // h.a.f1.i
    public boolean Q() {
        return this.f10342b.get().length != 0;
    }

    @Override // h.a.f1.i
    public boolean R() {
        return q.isError(this.a.get());
    }

    public T T() {
        Object obj = this.a.get();
        if (q.isComplete(obj) || q.isError(obj)) {
            return null;
        }
        return (T) q.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] U() {
        Object[] objArrC = c(f10339h);
        return objArrC == f10339h ? new Object[0] : objArrC;
    }

    public boolean V() {
        Object obj = this.a.get();
        return (obj == null || q.isComplete(obj) || q.isError(obj)) ? false : true;
    }

    int W() {
        return this.f10342b.get().length;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f10342b.get();
            if (aVarArr == f10341j) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f10342b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f10342b.get();
            if (aVarArr == f10341j || aVarArr == f10340i) {
                return;
            }
            int length = aVarArr.length;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (aVarArr[i3] == aVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                aVarArr2 = f10340i;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f10342b.compareAndSet(aVarArr, aVarArr2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] c(T[] tArr) {
        Object obj = this.a.get();
        if (obj == null || q.isComplete(obj) || q.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        Object value = q.getValue(obj);
        if (tArr.length == 0) {
            T[] tArr2 = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), 1));
            tArr2[0] = value;
            return tArr2;
        }
        tArr[0] = value;
        if (tArr.length == 1) {
            return tArr;
        }
        tArr[1] = 0;
        return tArr;
    }

    @Override // h.a.b0
    protected void d(i0<? super T> i0Var) {
        a<T> aVar = new a<>(i0Var, this);
        i0Var.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.f10353g) {
                b((a) aVar);
                return;
            } else {
                aVar.a();
                return;
            }
        }
        Throwable th = this.f10346f.get();
        if (th == k.a) {
            i0Var.onComplete();
        } else {
            i0Var.onError(th);
        }
    }

    void m(Object obj) {
        this.f10345e.lock();
        try {
            this.f10347g++;
            this.a.lazySet(obj);
        } finally {
            this.f10345e.unlock();
        }
    }

    a<T>[] n(Object obj) {
        a<T>[] andSet = this.f10342b.get();
        a<T>[] aVarArr = f10341j;
        if (andSet != aVarArr && (andSet = this.f10342b.getAndSet(aVarArr)) != f10341j) {
            m(obj);
        }
        return andSet;
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10346f.compareAndSet(null, k.a)) {
            Object objComplete = q.complete();
            for (a<T> aVar : n(objComplete)) {
                aVar.a(objComplete, this.f10347g);
            }
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (!this.f10346f.compareAndSet(null, th)) {
            h.a.c1.a.b(th);
            return;
        }
        Object objError = q.error(th);
        for (a<T> aVar : n(objError)) {
            aVar.a(objError, this.f10347g);
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f10346f.get() != null) {
            return;
        }
        Object next = q.next(t);
        m(next);
        for (a<T> aVar : this.f10342b.get()) {
            aVar.a(next, this.f10347g);
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (this.f10346f.get() != null) {
            cVar.dispose();
        }
    }

    b(T t) {
        this();
        this.a.lazySet(h.a.y0.b.b.a((Object) t, "defaultValue is null"));
    }

    /* JADX INFO: compiled from: BehaviorSubject.java */
    static final class a<T> implements h.a.u0.c, a.InterfaceC0233a<Object> {
        final i0<? super T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final b<T> f10348b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        boolean f10349c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f10350d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        h.a.y0.j.a<Object> f10351e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f10352f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile boolean f10353g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        long f10354h;

        a(i0<? super T> i0Var, b<T> bVar) {
            this.a = i0Var;
            this.f10348b = bVar;
        }

        void a() {
            if (this.f10353g) {
                return;
            }
            synchronized (this) {
                if (this.f10353g) {
                    return;
                }
                if (this.f10349c) {
                    return;
                }
                b<T> bVar = this.f10348b;
                Lock lock = bVar.f10344d;
                lock.lock();
                this.f10354h = bVar.f10347g;
                Object obj = bVar.a.get();
                lock.unlock();
                this.f10350d = obj != null;
                this.f10349c = true;
                if (obj == null || test(obj)) {
                    return;
                }
                b();
            }
        }

        void b() {
            h.a.y0.j.a<Object> aVar;
            while (!this.f10353g) {
                synchronized (this) {
                    aVar = this.f10351e;
                    if (aVar == null) {
                        this.f10350d = false;
                        return;
                    }
                    this.f10351e = null;
                }
                aVar.a((a.InterfaceC0233a<? super Object>) this);
            }
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.f10353g) {
                return;
            }
            this.f10353g = true;
            this.f10348b.b((a) this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10353g;
        }

        @Override // h.a.y0.j.a.InterfaceC0233a, h.a.x0.r
        public boolean test(Object obj) {
            return this.f10353g || q.accept(obj, this.a);
        }

        void a(Object obj, long j2) {
            if (this.f10353g) {
                return;
            }
            if (!this.f10352f) {
                synchronized (this) {
                    if (this.f10353g) {
                        return;
                    }
                    if (this.f10354h == j2) {
                        return;
                    }
                    if (this.f10350d) {
                        h.a.y0.j.a<Object> aVar = this.f10351e;
                        if (aVar == null) {
                            aVar = new h.a.y0.j.a<>(4);
                            this.f10351e = aVar;
                        }
                        aVar.a(obj);
                        return;
                    }
                    this.f10349c = true;
                    this.f10352f = true;
                }
            }
            test(obj);
        }
    }
}
