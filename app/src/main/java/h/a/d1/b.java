package h.a.d1;

import h.a.y0.i.j;
import h.a.y0.j.a;
import h.a.y0.j.k;
import h.a.y0.j.q;
import i.q2.t.m0;
import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: BehaviorProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b<T> extends c<T> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    static final Object[] f10270i = new Object[0];

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    static final a[] f10271j = new a[0];

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final a[] f10272k = new a[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<a<T>[]> f10273b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final ReadWriteLock f10274c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Lock f10275d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final Lock f10276e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final AtomicReference<Object> f10277f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final AtomicReference<Throwable> f10278g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    long f10279h;

    /* JADX INFO: compiled from: BehaviorProcessor.java */
    static final class a<T> extends AtomicLong implements j.d.d, a.InterfaceC0233a<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        h.a.y0.j.a<Object> queue;
        final b<T> state;

        a(j.d.c<? super T> cVar, b<T> bVar) {
            this.actual = cVar;
            this.state = bVar;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b((a) this);
        }

        void emitFirst() {
            if (this.cancelled) {
                return;
            }
            synchronized (this) {
                if (this.cancelled) {
                    return;
                }
                if (this.next) {
                    return;
                }
                b<T> bVar = this.state;
                Lock lock = bVar.f10275d;
                lock.lock();
                this.index = bVar.f10279h;
                Object obj = bVar.f10277f.get();
                lock.unlock();
                this.emitting = obj != null;
                this.next = true;
                if (obj == null || test(obj)) {
                    return;
                }
                emitLoop();
            }
        }

        void emitLoop() {
            h.a.y0.j.a<Object> aVar;
            while (!this.cancelled) {
                synchronized (this) {
                    aVar = this.queue;
                    if (aVar == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                aVar.a((a.InterfaceC0233a<? super Object>) this);
            }
        }

        void emitNext(Object obj, long j2) {
            if (this.cancelled) {
                return;
            }
            if (!this.fastPath) {
                synchronized (this) {
                    if (this.cancelled) {
                        return;
                    }
                    if (this.index == j2) {
                        return;
                    }
                    if (this.emitting) {
                        h.a.y0.j.a<Object> aVar = this.queue;
                        if (aVar == null) {
                            aVar = new h.a.y0.j.a<>(4);
                            this.queue = aVar;
                        }
                        aVar.a(obj);
                        return;
                    }
                    this.next = true;
                    this.fastPath = true;
                }
            }
            test(obj);
        }

        public boolean isFull() {
            return get() == 0;
        }

        @Override // j.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                h.a.y0.j.d.a(this, j2);
            }
        }

        @Override // h.a.y0.j.a.InterfaceC0233a, h.a.x0.r
        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (q.isComplete(obj)) {
                this.actual.onComplete();
                return true;
            }
            if (q.isError(obj)) {
                this.actual.onError(q.getError(obj));
                return true;
            }
            long j2 = get();
            if (j2 == 0) {
                cancel();
                this.actual.onError(new h.a.v0.c("Could not deliver value due to lack of requests"));
                return true;
            }
            this.actual.onNext((Object) q.getValue(obj));
            if (j2 == m0.f12222b) {
                return false;
            }
            decrementAndGet();
            return false;
        }
    }

    b() {
        this.f10277f = new AtomicReference<>();
        this.f10274c = new ReentrantReadWriteLock();
        this.f10275d = this.f10274c.readLock();
        this.f10276e = this.f10274c.writeLock();
        this.f10273b = new AtomicReference<>(f10271j);
        this.f10278g = new AtomicReference<>();
    }

    @h.a.t0.d
    public static <T> b<T> c0() {
        return new b<>();
    }

    @h.a.t0.d
    public static <T> b<T> p(T t) {
        h.a.y0.b.b.a((Object) t, "defaultValue is null");
        return new b<>(t);
    }

    @Override // h.a.d1.c
    public Throwable T() {
        Object obj = this.f10277f.get();
        if (q.isError(obj)) {
            return q.getError(obj);
        }
        return null;
    }

    @Override // h.a.d1.c
    public boolean U() {
        return q.isComplete(this.f10277f.get());
    }

    @Override // h.a.d1.c
    public boolean V() {
        return this.f10273b.get().length != 0;
    }

    @Override // h.a.d1.c
    public boolean W() {
        return q.isError(this.f10277f.get());
    }

    public T Y() {
        Object obj = this.f10277f.get();
        if (q.isComplete(obj) || q.isError(obj)) {
            return null;
        }
        return (T) q.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] Z() {
        Object[] objArrC = c(f10270i);
        return objArrC == f10270i ? new Object[0] : objArrC;
    }

    boolean a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f10273b.get();
            if (aVarArr == f10272k) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f10273b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    public boolean a0() {
        Object obj = this.f10277f.get();
        return (obj == null || q.isComplete(obj) || q.isError(obj)) ? false : true;
    }

    void b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f10273b.get();
            if (aVarArr == f10272k || aVarArr == f10271j) {
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
                aVarArr2 = f10271j;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f10273b.compareAndSet(aVarArr, aVarArr2));
    }

    int b0() {
        return this.f10273b.get().length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public T[] c(T[] tArr) {
        Object obj = this.f10277f.get();
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

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        a<T> aVar = new a<>(cVar, this);
        cVar.onSubscribe(aVar);
        if (a((a) aVar)) {
            if (aVar.cancelled) {
                b((a) aVar);
                return;
            } else {
                aVar.emitFirst();
                return;
            }
        }
        Throwable th = this.f10278g.get();
        if (th == k.a) {
            cVar.onComplete();
        } else {
            cVar.onError(th);
        }
    }

    @h.a.t0.e
    public boolean m(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        a<T>[] aVarArr = this.f10273b.get();
        for (a<T> aVar : aVarArr) {
            if (aVar.isFull()) {
                return false;
            }
        }
        Object next = q.next(t);
        n(next);
        for (a<T> aVar2 : aVarArr) {
            aVar2.emitNext(next, this.f10279h);
        }
        return true;
    }

    void n(Object obj) {
        Lock lock = this.f10276e;
        lock.lock();
        this.f10279h++;
        this.f10277f.lazySet(obj);
        lock.unlock();
    }

    a<T>[] o(Object obj) {
        a<T>[] andSet = this.f10273b.get();
        a<T>[] aVarArr = f10272k;
        if (andSet != aVarArr && (andSet = this.f10273b.getAndSet(aVarArr)) != f10272k) {
            n(obj);
        }
        return andSet;
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f10278g.compareAndSet(null, k.a)) {
            Object objComplete = q.complete();
            for (a<T> aVar : o(objComplete)) {
                aVar.emitNext(objComplete, this.f10279h);
            }
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (!this.f10278g.compareAndSet(null, th)) {
            h.a.c1.a.b(th);
            return;
        }
        Object objError = q.error(th);
        for (a<T> aVar : o(objError)) {
            aVar.emitNext(objError, this.f10279h);
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f10278g.get() != null) {
            return;
        }
        Object next = q.next(t);
        n(next);
        for (a<T> aVar : this.f10273b.get()) {
            aVar.emitNext(next, this.f10279h);
        }
    }

    @Override // j.d.c, h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (this.f10278g.get() != null) {
            dVar.cancel();
        } else {
            dVar.request(m0.f12222b);
        }
    }

    b(T t) {
        this();
        this.f10277f.lazySet(h.a.y0.b.b.a((Object) t, "defaultValue is null"));
    }
}
