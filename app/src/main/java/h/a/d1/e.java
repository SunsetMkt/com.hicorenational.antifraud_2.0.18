package h.a.d1;

import h.a.j0;
import h.a.y0.i.j;
import i.q2.t.m0;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: ReplayProcessor.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e<T> extends h.a.d1.c<T> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final Object[] f10284e = new Object[0];

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    static final c[] f10285f = new c[0];

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    static final c[] f10286g = new c[0];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final b<T> f10287b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f10288c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final AtomicReference<c<T>[]> f10289d = new AtomicReference<>(f10285f);

    /* JADX INFO: compiled from: ReplayProcessor.java */
    static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        a(T t) {
            this.value = t;
        }
    }

    /* JADX INFO: compiled from: ReplayProcessor.java */
    interface b<T> {
        void a(c<T> cVar);

        void complete();

        void error(Throwable th);

        Throwable g();

        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t);

        int size();
    }

    /* JADX INFO: compiled from: ReplayProcessor.java */
    static final class c<T> extends AtomicInteger implements j.d.d {
        private static final long serialVersionUID = 466549804534799122L;
        final j.d.c<? super T> actual;
        volatile boolean cancelled;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final e<T> state;

        c(j.d.c<? super T> cVar, e<T> eVar) {
            this.actual = cVar;
            this.state = eVar;
        }

        @Override // j.d.d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.b((c) this);
        }

        @Override // j.d.d
        public void request(long j2) {
            if (j.validate(j2)) {
                h.a.y0.j.d.a(this.requested, j2);
                this.state.f10287b.a(this);
            }
        }
    }

    /* JADX INFO: compiled from: ReplayProcessor.java */
    static final class f<T> extends AtomicReference<f<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        f(T t, long j2) {
            this.value = t;
            this.time = j2;
        }
    }

    /* JADX INFO: compiled from: ReplayProcessor.java */
    static final class g<T> implements b<T> {
        final List<T> a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Throwable f10303b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile boolean f10304c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile int f10305d;

        g(int i2) {
            this.a = new ArrayList(h.a.y0.b.b.a(i2, "capacityHint"));
        }

        @Override // h.a.d1.e.b
        public void a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.a;
            j.d.c<? super T> cVar2 = cVar.actual;
            Integer num = (Integer) cVar.index;
            int iIntValue = 0;
            if (num != null) {
                iIntValue = num.intValue();
            } else {
                cVar.index = 0;
            }
            long j2 = cVar.emitted;
            int iAddAndGet = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f10304c;
                    int i2 = this.f10305d;
                    if (z && iIntValue == i2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f10303b;
                        if (th == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th);
                            return;
                        }
                    }
                    if (iIntValue == i2) {
                        break;
                    }
                    cVar2.onNext(list.get(iIntValue));
                    iIntValue++;
                    j2++;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z2 = this.f10304c;
                    int i3 = this.f10305d;
                    if (z2 && iIntValue == i3) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f10303b;
                        if (th2 == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = Integer.valueOf(iIntValue);
                cVar.emitted = j2;
                iAddAndGet = cVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        @Override // h.a.d1.e.b
        public void complete() {
            this.f10304c = true;
        }

        @Override // h.a.d1.e.b
        public void error(Throwable th) {
            this.f10303b = th;
            this.f10304c = true;
        }

        @Override // h.a.d1.e.b
        public Throwable g() {
            return this.f10303b;
        }

        @Override // h.a.d1.e.b
        public T getValue() {
            int i2 = this.f10305d;
            if (i2 == 0) {
                return null;
            }
            return this.a.get(i2 - 1);
        }

        @Override // h.a.d1.e.b
        public T[] getValues(T[] tArr) {
            int i2 = this.f10305d;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.a;
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

        @Override // h.a.d1.e.b
        public boolean isDone() {
            return this.f10304c;
        }

        @Override // h.a.d1.e.b
        public void next(T t) {
            this.a.add(t);
            this.f10305d++;
        }

        @Override // h.a.d1.e.b
        public int size() {
            return this.f10305d;
        }
    }

    e(b<T> bVar) {
        this.f10287b = bVar;
    }

    @h.a.t0.d
    public static <T> e<T> b(long j2, TimeUnit timeUnit, j0 j0Var, int i2) {
        return new e<>(new d(i2, j2, timeUnit, j0Var));
    }

    @h.a.t0.d
    public static <T> e<T> d0() {
        return new e<>(new g(16));
    }

    static <T> e<T> e0() {
        return new e<>(new C0172e(Integer.MAX_VALUE));
    }

    @h.a.t0.d
    public static <T> e<T> m(int i2) {
        return new e<>(new g(i2));
    }

    @h.a.t0.d
    public static <T> e<T> n(int i2) {
        return new e<>(new C0172e(i2));
    }

    @h.a.t0.d
    public static <T> e<T> r(long j2, TimeUnit timeUnit, j0 j0Var) {
        return new e<>(new d(Integer.MAX_VALUE, j2, timeUnit, j0Var));
    }

    @Override // h.a.d1.c
    public Throwable T() {
        b<T> bVar = this.f10287b;
        if (bVar.isDone()) {
            return bVar.g();
        }
        return null;
    }

    @Override // h.a.d1.c
    public boolean U() {
        b<T> bVar = this.f10287b;
        return bVar.isDone() && bVar.g() == null;
    }

    @Override // h.a.d1.c
    public boolean V() {
        return this.f10289d.get().length != 0;
    }

    @Override // h.a.d1.c
    public boolean W() {
        b<T> bVar = this.f10287b;
        return bVar.isDone() && bVar.g() != null;
    }

    public T Y() {
        return this.f10287b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Object[] Z() {
        Object[] objArrC = c(f10284e);
        return objArrC == f10284e ? new Object[0] : objArrC;
    }

    boolean a(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f10289d.get();
            if (cVarArr == f10286g) {
                return false;
            }
            int length = cVarArr.length;
            cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
        } while (!this.f10289d.compareAndSet(cVarArr, cVarArr2));
        return true;
    }

    public boolean a0() {
        return this.f10287b.size() != 0;
    }

    int b0() {
        return this.f10287b.size();
    }

    public T[] c(T[] tArr) {
        return this.f10287b.getValues(tArr);
    }

    int c0() {
        return this.f10289d.get().length;
    }

    @Override // h.a.l
    protected void d(j.d.c<? super T> cVar) {
        c<T> cVar2 = new c<>(cVar, this);
        cVar.onSubscribe(cVar2);
        if (a((c) cVar2) && cVar2.cancelled) {
            b((c) cVar2);
        } else {
            this.f10287b.a(cVar2);
        }
    }

    @Override // j.d.c
    public void onComplete() {
        if (this.f10288c) {
            return;
        }
        this.f10288c = true;
        b<T> bVar = this.f10287b;
        bVar.complete();
        for (c<T> cVar : this.f10289d.getAndSet(f10286g)) {
            bVar.a(cVar);
        }
    }

    @Override // j.d.c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.f10288c) {
            h.a.c1.a.b(th);
            return;
        }
        this.f10288c = true;
        b<T> bVar = this.f10287b;
        bVar.error(th);
        for (c<T> cVar : this.f10289d.getAndSet(f10286g)) {
            bVar.a(cVar);
        }
    }

    @Override // j.d.c
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f10288c) {
            return;
        }
        b<T> bVar = this.f10287b;
        bVar.next(t);
        for (c<T> cVar : this.f10289d.get()) {
            bVar.a(cVar);
        }
    }

    @Override // j.d.c, h.a.q
    public void onSubscribe(j.d.d dVar) {
        if (this.f10288c) {
            dVar.cancel();
        } else {
            dVar.request(m0.f12222b);
        }
    }

    void b(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f10289d.get();
            if (cVarArr == f10286g || cVarArr == f10285f) {
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
                cVarArr2 = f10285f;
            } else {
                c<T>[] cVarArr3 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                cVarArr2 = cVarArr3;
            }
        } while (!this.f10289d.compareAndSet(cVarArr, cVarArr2));
    }

    /* JADX INFO: renamed from: h.a.d1.e$e, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ReplayProcessor.java */
    static final class C0172e<T> implements b<T> {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f10298b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile a<T> f10299c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        a<T> f10300d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Throwable f10301e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile boolean f10302f;

        C0172e(int i2) {
            this.a = h.a.y0.b.b.a(i2, "maxSize");
            a<T> aVar = new a<>(null);
            this.f10300d = aVar;
            this.f10299c = aVar;
        }

        void a() {
            int i2 = this.f10298b;
            if (i2 > this.a) {
                this.f10298b = i2 - 1;
                this.f10299c = this.f10299c.get();
            }
        }

        @Override // h.a.d1.e.b
        public void complete() {
            this.f10302f = true;
        }

        @Override // h.a.d1.e.b
        public void error(Throwable th) {
            this.f10301e = th;
            this.f10302f = true;
        }

        @Override // h.a.d1.e.b
        public Throwable g() {
            return this.f10301e;
        }

        @Override // h.a.d1.e.b
        public T getValue() {
            a<T> aVar = this.f10299c;
            while (true) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    return aVar.value;
                }
                aVar = aVar2;
            }
        }

        @Override // h.a.d1.e.b
        public T[] getValues(T[] tArr) {
            a<T> aVar = this.f10299c;
            a<T> aVar2 = aVar;
            int i2 = 0;
            while (true) {
                aVar2 = aVar2.get();
                if (aVar2 == null) {
                    break;
                }
                i2++;
            }
            if (tArr.length < i2) {
                tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), i2));
            }
            for (int i3 = 0; i3 < i2; i3++) {
                aVar = aVar.get();
                tArr[i3] = aVar.value;
            }
            if (tArr.length > i2) {
                tArr[i2] = null;
            }
            return tArr;
        }

        @Override // h.a.d1.e.b
        public boolean isDone() {
            return this.f10302f;
        }

        @Override // h.a.d1.e.b
        public void next(T t) {
            a<T> aVar = new a<>(t);
            a<T> aVar2 = this.f10300d;
            this.f10300d = aVar;
            this.f10298b++;
            aVar2.set(aVar);
            a();
        }

        @Override // h.a.d1.e.b
        public int size() {
            a<T> aVar = this.f10299c;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (aVar = aVar.get()) != null) {
                i2++;
            }
            return i2;
        }

        @Override // h.a.d1.e.b
        public void a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super T> cVar2 = cVar.actual;
            a<T> aVar = (a) cVar.index;
            if (aVar == null) {
                aVar = this.f10299c;
            }
            long j2 = cVar.emitted;
            int iAddAndGet = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f10302f;
                    a<T> aVar2 = aVar.get();
                    boolean z2 = aVar2 == null;
                    if (z && z2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f10301e;
                        if (th == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar2.onNext(aVar2.value);
                    j2++;
                    aVar = aVar2;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    if (this.f10302f && aVar.get() == null) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f10301e;
                        if (th2 == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = aVar;
                cVar.emitted = j2;
                iAddAndGet = cVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }
    }

    /* JADX INFO: compiled from: ReplayProcessor.java */
    static final class d<T> implements b<T> {
        final int a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final long f10290b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final TimeUnit f10291c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final j0 f10292d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        int f10293e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile f<T> f10294f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        f<T> f10295g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        Throwable f10296h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile boolean f10297i;

        d(int i2, long j2, TimeUnit timeUnit, j0 j0Var) {
            this.a = h.a.y0.b.b.a(i2, "maxSize");
            this.f10290b = h.a.y0.b.b.a(j2, "maxAge");
            this.f10291c = (TimeUnit) h.a.y0.b.b.a(timeUnit, "unit is null");
            this.f10292d = (j0) h.a.y0.b.b.a(j0Var, "scheduler is null");
            f<T> fVar = new f<>(null, 0L);
            this.f10295g = fVar;
            this.f10294f = fVar;
        }

        f<T> a() {
            f<T> fVar;
            f<T> fVar2 = this.f10294f;
            long jA = this.f10292d.a(this.f10291c) - this.f10290b;
            f<T> fVar3 = fVar2.get();
            while (true) {
                f<T> fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 == null || fVar2.time > jA) {
                    break;
                }
                fVar3 = fVar2.get();
            }
            return fVar;
        }

        void b() {
            int i2 = this.f10293e;
            if (i2 > this.a) {
                this.f10293e = i2 - 1;
                this.f10294f = this.f10294f.get();
            }
            long jA = this.f10292d.a(this.f10291c) - this.f10290b;
            f<T> fVar = this.f10294f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    this.f10294f = fVar;
                    return;
                } else {
                    if (fVar2.time > jA) {
                        this.f10294f = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        void c() {
            long jA = this.f10292d.a(this.f10291c) - this.f10290b;
            f<T> fVar = this.f10294f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    this.f10294f = fVar;
                    return;
                } else {
                    if (fVar2.time > jA) {
                        this.f10294f = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        @Override // h.a.d1.e.b
        public void complete() {
            c();
            this.f10297i = true;
        }

        @Override // h.a.d1.e.b
        public void error(Throwable th) {
            c();
            this.f10296h = th;
            this.f10297i = true;
        }

        @Override // h.a.d1.e.b
        public Throwable g() {
            return this.f10296h;
        }

        @Override // h.a.d1.e.b
        public T getValue() {
            f<T> fVar = this.f10294f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    break;
                }
                fVar = fVar2;
            }
            if (fVar.time < this.f10292d.a(this.f10291c) - this.f10290b) {
                return null;
            }
            return fVar.value;
        }

        @Override // h.a.d1.e.b
        public T[] getValues(T[] tArr) {
            f<T> fVarA = a();
            int iA = a(fVarA);
            if (iA != 0) {
                if (tArr.length < iA) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), iA));
                }
                for (int i2 = 0; i2 != iA; i2++) {
                    fVarA = fVarA.get();
                    tArr[i2] = fVarA.value;
                }
                if (tArr.length > iA) {
                    tArr[iA] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // h.a.d1.e.b
        public boolean isDone() {
            return this.f10297i;
        }

        @Override // h.a.d1.e.b
        public void next(T t) {
            f<T> fVar = new f<>(t, this.f10292d.a(this.f10291c));
            f<T> fVar2 = this.f10295g;
            this.f10295g = fVar;
            this.f10293e++;
            fVar2.set(fVar);
            b();
        }

        @Override // h.a.d1.e.b
        public int size() {
            return a(a());
        }

        @Override // h.a.d1.e.b
        public void a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            j.d.c<? super T> cVar2 = cVar.actual;
            f<T> fVarA = (f) cVar.index;
            if (fVarA == null) {
                fVarA = a();
            }
            long j2 = cVar.emitted;
            int iAddAndGet = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f10297i;
                    f<T> fVar = fVarA.get();
                    boolean z2 = fVar == null;
                    if (z && z2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f10296h;
                        if (th == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    cVar2.onNext(fVar.value);
                    j2++;
                    fVarA = fVar;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    if (this.f10297i && fVarA.get() == null) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f10296h;
                        if (th2 == null) {
                            cVar2.onComplete();
                            return;
                        } else {
                            cVar2.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = fVarA;
                cVar.emitted = j2;
                iAddAndGet = cVar.addAndGet(-iAddAndGet);
            } while (iAddAndGet != 0);
        }

        int a(f<T> fVar) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (fVar = fVar.get()) != null) {
                i2++;
            }
            return i2;
        }
    }
}
