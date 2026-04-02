package h.a.f1;

import h.a.i0;
import h.a.j0;
import h.a.y0.j.q;
import i.q2.t.m0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ReplaySubject.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f<T> extends i<T> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final c[] f10367d = new c[0];

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    static final c[] f10368e = new c[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final Object[] f10369f = new Object[0];
    final b<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final AtomicReference<c<T>[]> f10370b = new AtomicReference<>(f10367d);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f10371c;

    /* JADX INFO: compiled from: ReplaySubject.java */
    static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        a(T t) {
            this.value = t;
        }
    }

    /* JADX INFO: compiled from: ReplaySubject.java */
    interface b<T> {
        void add(T t);

        void addFinal(Object obj);

        boolean compareAndSet(Object obj, Object obj2);

        Object get();

        T getValue();

        T[] getValues(T[] tArr);

        void replay(c<T> cVar);

        int size();
    }

    /* JADX INFO: compiled from: ReplaySubject.java */
    static final class c<T> extends AtomicInteger implements h.a.u0.c {
        private static final long serialVersionUID = 466549804534799122L;
        final i0<? super T> actual;
        volatile boolean cancelled;
        Object index;
        final f<T> state;

        c(i0<? super T> i0Var, f<T> fVar) {
            this.actual = i0Var;
            this.state = fVar;
        }

        @Override // h.a.u0.c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b((c) this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* JADX INFO: compiled from: ReplaySubject.java */
    static final class d<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile C0177f<Object> head;
        final long maxAge;
        final int maxSize;
        final j0 scheduler;
        int size;
        C0177f<Object> tail;
        final TimeUnit unit;

        d(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
            this.maxSize = h.a.y0.b.b.a(i2, "maxSize");
            this.maxAge = h.a.y0.b.b.a(j2, "maxAge");
            this.unit = (TimeUnit) h.a.y0.b.b.a(timeUnit, "unit is null");
            this.scheduler = (j0) h.a.y0.b.b.a(j0Var, "scheduler is null");
            C0177f<Object> c0177f = new C0177f<>(null, 0L);
            this.tail = c0177f;
            this.head = c0177f;
        }

        @Override // h.a.f1.f.b
        public void add(T t) {
            C0177f<Object> c0177f = new C0177f<>(t, this.scheduler.a(this.unit));
            C0177f<Object> c0177f2 = this.tail;
            this.tail = c0177f;
            this.size++;
            c0177f2.set(c0177f);
            trim();
        }

        @Override // h.a.f1.f.b
        public void addFinal(Object obj) {
            C0177f<Object> c0177f = new C0177f<>(obj, m0.f12222b);
            C0177f<Object> c0177f2 = this.tail;
            this.tail = c0177f;
            this.size++;
            c0177f2.lazySet(c0177f);
            trimFinal();
            this.done = true;
        }

        C0177f<Object> getHead() {
            C0177f<Object> c0177f;
            C0177f<Object> c0177f2 = this.head;
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            C0177f<T> c0177f3 = c0177f2.get();
            while (true) {
                C0177f<T> c0177f4 = c0177f3;
                c0177f = c0177f2;
                c0177f2 = c0177f4;
                if (c0177f2 == null || c0177f2.time > jA) {
                    break;
                }
                c0177f3 = c0177f2.get();
            }
            return c0177f;
        }

        @Override // h.a.f1.f.b
        public T getValue() {
            T t;
            C0177f<Object> c0177f = this.head;
            C0177f<Object> c0177f2 = null;
            while (true) {
                C0177f<T> c0177f3 = c0177f.get();
                if (c0177f3 == null) {
                    break;
                }
                c0177f2 = c0177f;
                c0177f = c0177f3;
            }
            if (c0177f.time >= this.scheduler.a(this.unit) - this.maxAge && (t = (T) c0177f.value) != null) {
                return (q.isComplete(t) || q.isError(t)) ? (T) c0177f2.value : t;
            }
            return null;
        }

        @Override // h.a.f1.f.b
        public T[] getValues(T[] tArr) {
            C0177f<T> head = getHead();
            int size = size(head);
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i2 = 0; i2 != size; i2++) {
                    head = head.get();
                    tArr[i2] = head.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // h.a.f1.f.b
        public void replay(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            i0<? super T> i0Var = cVar.actual;
            C0177f<Object> head = (C0177f) cVar.index;
            if (head == null) {
                head = getHead();
            }
            int iAddAndGet = 1;
            while (!cVar.cancelled) {
                while (!cVar.cancelled) {
                    C0177f<T> c0177f = head.get();
                    if (c0177f != null) {
                        T t = c0177f.value;
                        if (this.done && c0177f.get() == null) {
                            if (q.isComplete(t)) {
                                i0Var.onComplete();
                            } else {
                                i0Var.onError(q.getError(t));
                            }
                            cVar.index = null;
                            cVar.cancelled = true;
                            return;
                        }
                        i0Var.onNext(t);
                        head = c0177f;
                    } else if (head.get() == null) {
                        cVar.index = head;
                        iAddAndGet = cVar.addAndGet(-iAddAndGet);
                        if (iAddAndGet == 0) {
                            return;
                        }
                    }
                }
                cVar.index = null;
                return;
            }
            cVar.index = null;
        }

        @Override // h.a.f1.f.b
        public int size() {
            return size(getHead());
        }

        void trim() {
            int i2 = this.size;
            if (i2 > this.maxSize) {
                this.size = i2 - 1;
                this.head = this.head.get();
            }
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            C0177f<Object> c0177f = this.head;
            while (true) {
                C0177f<T> c0177f2 = c0177f.get();
                if (c0177f2 == null) {
                    this.head = c0177f;
                    return;
                } else {
                    if (c0177f2.time > jA) {
                        this.head = c0177f;
                        return;
                    }
                    c0177f = c0177f2;
                }
            }
        }

        void trimFinal() {
            long jA = this.scheduler.a(this.unit) - this.maxAge;
            C0177f<Object> c0177f = this.head;
            while (true) {
                C0177f<T> c0177f2 = c0177f.get();
                if (c0177f2.get() == null) {
                    this.head = c0177f;
                    return;
                } else {
                    if (c0177f2.time > jA) {
                        this.head = c0177f;
                        return;
                    }
                    c0177f = c0177f2;
                }
            }
        }

        int size(C0177f<Object> c0177f) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                C0177f<T> c0177f2 = c0177f.get();
                if (c0177f2 == null) {
                    Object obj = c0177f.value;
                    return (q.isComplete(obj) || q.isError(obj)) ? i2 - 1 : i2;
                }
                i2++;
                c0177f = c0177f2;
            }
            return i2;
        }
    }

    /* JADX INFO: compiled from: ReplaySubject.java */
    static final class e<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile a<Object> head;
        final int maxSize;
        int size;
        a<Object> tail;

        e(int i2) {
            this.maxSize = h.a.y0.b.b.a(i2, "maxSize");
            a<Object> aVar = new a<>(null);
            this.tail = aVar;
            this.head = aVar;
        }

        @Override // h.a.f1.f.b
        public void add(T t) {
            a<Object> aVar = new a<>(t);
            a<Object> aVar2 = this.tail;
            this.tail = aVar;
            this.size++;
            aVar2.set(aVar);
            trim();
        }

        @Override // h.a.f1.f.b
        public void addFinal(Object obj) {
            a<Object> aVar = new a<>(obj);
            a<Object> aVar2 = this.tail;
            this.tail = aVar;
            this.size++;
            aVar2.lazySet(aVar);
            this.done = true;
        }

        @Override // h.a.f1.f.b
        public T getValue() {
            a<Object> aVar = this.head;
            a<Object> aVar2 = null;
            while (true) {
                a<T> aVar3 = aVar.get();
                if (aVar3 == null) {
                    break;
                }
                aVar2 = aVar;
                aVar = aVar3;
            }
            T t = (T) aVar.value;
            if (t == null) {
                return null;
            }
            return (q.isComplete(t) || q.isError(t)) ? (T) aVar2.value : t;
        }

        @Override // h.a.f1.f.b
        public T[] getValues(T[] tArr) {
            a<T> aVar = this.head;
            int size = size();
            if (size != 0) {
                if (tArr.length < size) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), size));
                }
                for (int i2 = 0; i2 != size; i2++) {
                    aVar = aVar.get();
                    tArr[i2] = aVar.value;
                }
                if (tArr.length > size) {
                    tArr[size] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // h.a.f1.f.b
        public void replay(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            i0<? super T> i0Var = cVar.actual;
            a<Object> aVar = (a) cVar.index;
            if (aVar == null) {
                aVar = this.head;
            }
            int iAddAndGet = 1;
            while (!cVar.cancelled) {
                a<T> aVar2 = aVar.get();
                if (aVar2 != null) {
                    T t = aVar2.value;
                    if (this.done && aVar2.get() == null) {
                        if (q.isComplete(t)) {
                            i0Var.onComplete();
                        } else {
                            i0Var.onError(q.getError(t));
                        }
                        cVar.index = null;
                        cVar.cancelled = true;
                        return;
                    }
                    i0Var.onNext(t);
                    aVar = aVar2;
                } else if (aVar.get() != null) {
                    continue;
                } else {
                    cVar.index = aVar;
                    iAddAndGet = cVar.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar.index = null;
        }

        @Override // h.a.f1.f.b
        public int size() {
            a<Object> aVar = this.head;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    Object obj = aVar.value;
                    return (q.isComplete(obj) || q.isError(obj)) ? i2 - 1 : i2;
                }
                i2++;
                aVar = aVar2;
            }
            return i2;
        }

        void trim() {
            int i2 = this.size;
            if (i2 > this.maxSize) {
                this.size = i2 - 1;
                this.head = this.head.get();
            }
        }
    }

    /* JADX INFO: renamed from: h.a.f1.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReplaySubject.java */
    static final class C0177f<T> extends AtomicReference<C0177f<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        C0177f(T t, long j2) {
            this.value = t;
            this.time = j2;
        }
    }

    /* JADX INFO: compiled from: ReplaySubject.java */
    static final class g<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        g(int i2) {
            this.buffer = new ArrayList(h.a.y0.b.b.a(i2, "capacityHint"));
        }

        @Override // h.a.f1.f.b
        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // h.a.f1.f.b
        public void addFinal(Object obj) {
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }

        @Override // h.a.f1.f.b
        public T getValue() {
            int i2 = this.size;
            if (i2 == 0) {
                return null;
            }
            List<Object> list = this.buffer;
            T t = (T) list.get(i2 - 1);
            if (!q.isComplete(t) && !q.isError(t)) {
                return t;
            }
            if (i2 == 1) {
                return null;
            }
            return (T) list.get(i2 - 2);
        }

        @Override // h.a.f1.f.b
        public T[] getValues(T[] tArr) {
            int i2 = this.size;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<Object> list = this.buffer;
            Object obj = list.get(i2 - 1);
            if ((q.isComplete(obj) || q.isError(obj)) && i2 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i2) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
            }
            for (int i3 = 0; i3 < i2; i3++) {
                tArr[i3] = list.get(i3);
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        @Override // h.a.f1.f.b
        public void replay(c<T> cVar) {
            int i2;
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            List<Object> list = this.buffer;
            i0<? super T> i0Var = cVar.actual;
            Integer num = (Integer) cVar.index;
            int iIntValue = 0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                cVar.index = 0;
            }
            int iAddAndGet = 1;
            while (!cVar.cancelled) {
                int i3 = this.size;
                while (i3 != iIntValue) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    Object obj = list.get(iIntValue);
                    if (this.done && (i2 = iIntValue + 1) == i3 && i2 == (i3 = this.size)) {
                        if (q.isComplete(obj)) {
                            i0Var.onComplete();
                        } else {
                            i0Var.onError(q.getError(obj));
                        }
                        cVar.index = null;
                        cVar.cancelled = true;
                        return;
                    }
                    i0Var.onNext(obj);
                    iIntValue++;
                }
                if (iIntValue == this.size) {
                    cVar.index = Integer.valueOf(iIntValue);
                    iAddAndGet = cVar.addAndGet(-iAddAndGet);
                    if (iAddAndGet == 0) {
                        return;
                    }
                }
            }
            cVar.index = null;
        }

        @Override // h.a.f1.f.b
        public int size() {
            int i2 = this.size;
            if (i2 == 0) {
                return 0;
            }
            int i3 = i2 - 1;
            Object obj = this.buffer.get(i3);
            return (q.isComplete(obj) || q.isError(obj)) ? i3 : i2;
        }
    }

    f(b<T> bVar) {
        this.a = bVar;
    }

    @h.a.t0.d
    public static <T> f<T> Y() {
        return new f<>(new g(16));
    }

    static <T> f<T> Z() {
        return new f<>(new e(Integer.MAX_VALUE));
    }

    @h.a.t0.d
    public static <T> f<T> b(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return new f<>(new d(i2, j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    public static <T> f<T> i(int i2) {
        return new f<>(new g(i2));
    }

    @h.a.t0.d
    public static <T> f<T> j(int i2) {
        return new f<>(new e(i2));
    }

    @h.a.t0.d
    public static <T> f<T> r(long j2, TimeUnit timeUnit, j0 j0Var) {
        return new f<>(new d(Integer.MAX_VALUE, j2, timeUnit, j0Var));
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
        return this.f10370b.get().length != 0;
    }

    @Override // h.a.f1.i
    public boolean R() {
        return q.isError(this.a.get());
    }

    public T T() {
        return this.a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] U() {
        Object[] objArrC = c(f10369f);
        return objArrC == f10369f ? new Object[0] : objArrC;
    }

    public boolean V() {
        return this.a.size() != 0;
    }

    int W() {
        return this.f10370b.get().length;
    }

    int X() {
        return this.a.size();
    }

    boolean a(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f10370b.get();
            if (cVarArr == f10368e) {
                return false;
            }
            int length = cVarArr.length;
            cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
        } while (!this.f10370b.compareAndSet(cVarArr, cVarArr2));
        return true;
    }

    public T[] c(T[] tArr) {
        return this.a.getValues(tArr);
    }

    @Override // h.a.b0
    protected void d(i0<? super T> i0Var) {
        c<T> cVar = new c<>(i0Var, this);
        i0Var.onSubscribe(cVar);
        if (cVar.cancelled) {
            return;
        }
        if (a((c) cVar) && cVar.cancelled) {
            b((c) cVar);
        } else {
            this.a.replay(cVar);
        }
    }

    c<T>[] m(Object obj) {
        return this.a.compareAndSet(null, obj) ? this.f10370b.getAndSet(f10368e) : f10368e;
    }

    @Override // h.a.i0
    public void onComplete() {
        if (this.f10371c) {
            return;
        }
        this.f10371c = true;
        Object objComplete = q.complete();
        b<T> bVar = this.a;
        bVar.addFinal(objComplete);
        for (c<T> cVar : m(objComplete)) {
            bVar.replay(cVar);
        }
    }

    @Override // h.a.i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.f10371c) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10371c = true;
        Object objError = q.error(th);
        b<T> bVar = this.a;
        bVar.addFinal(objError);
        for (c<T> cVar : m(objError)) {
            bVar.replay(cVar);
        }
    }

    @Override // h.a.i0
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f10371c) {
            return;
        }
        b<T> bVar = this.a;
        bVar.add(t);
        for (c<T> cVar : this.f10370b.get()) {
            bVar.replay(cVar);
        }
    }

    @Override // h.a.i0
    public void onSubscribe(h.a.u0.c cVar) {
        if (this.f10371c) {
            cVar.dispose();
        }
    }

    void b(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f10370b.get();
            if (cVarArr == f10368e || cVarArr == f10367d) {
                return;
            }
            int length = cVarArr.length;
            int i2 = -1;
            int i3 = 0;
            while (true) {
                if (i3 >= length) {
                    break;
                }
                if (cVarArr[i3] == cVar) {
                    i2 = i3;
                    break;
                }
                i3++;
            }
            if (i2 < 0) {
                return;
            }
            if (length == 1) {
                cVarArr2 = f10367d;
            } else {
                c<T>[] cVarArr3 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                cVarArr2 = cVarArr3;
            }
        } while (!this.f10370b.compareAndSet(cVarArr, cVarArr2));
    }
}
