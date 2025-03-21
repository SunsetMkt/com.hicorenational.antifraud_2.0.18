package p251g.p252a.p258f1;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.C5161a;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: BehaviorSubject.java */
/* renamed from: g.a.f1.b */
/* loaded from: classes2.dex */
public final class C4494b<T> extends AbstractC4501i<T> {

    /* renamed from: h */
    private static final Object[] f17346h = new Object[0];

    /* renamed from: i */
    static final a[] f17347i = new a[0];

    /* renamed from: j */
    static final a[] f17348j = new a[0];

    /* renamed from: a */
    final AtomicReference<Object> f17349a;

    /* renamed from: b */
    final AtomicReference<a<T>[]> f17350b;

    /* renamed from: c */
    final ReadWriteLock f17351c;

    /* renamed from: d */
    final Lock f17352d;

    /* renamed from: e */
    final Lock f17353e;

    /* renamed from: f */
    final AtomicReference<Throwable> f17354f;

    /* renamed from: g */
    long f17355g;

    C4494b() {
        this.f17351c = new ReentrantReadWriteLock();
        this.f17352d = this.f17351c.readLock();
        this.f17353e = this.f17351c.writeLock();
        this.f17350b = new AtomicReference<>(f17347i);
        this.f17349a = new AtomicReference<>();
        this.f17354f = new AtomicReference<>();
    }

    @InterfaceC4544d
    /* renamed from: X */
    public static <T> C4494b<T> m17302X() {
        return new C4494b<>();
    }

    @InterfaceC4544d
    /* renamed from: o */
    public static <T> C4494b<T> m17303o(T t) {
        return new C4494b<>(t);
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: O */
    public Throwable mo17291O() {
        Object obj = this.f17349a.get();
        if (EnumC5177q.isError(obj)) {
            return EnumC5177q.getError(obj);
        }
        return null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: P */
    public boolean mo17292P() {
        return EnumC5177q.isComplete(this.f17349a.get());
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: Q */
    public boolean mo17293Q() {
        return this.f17350b.get().length != 0;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: R */
    public boolean mo17294R() {
        return EnumC5177q.isError(this.f17349a.get());
    }

    /* renamed from: T */
    public T m17304T() {
        Object obj = this.f17349a.get();
        if (EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) {
            return null;
        }
        return (T) EnumC5177q.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: U */
    public Object[] m17305U() {
        Object[] m17310c = m17310c(f17346h);
        return m17310c == f17346h ? new Object[0] : m17310c;
    }

    /* renamed from: V */
    public boolean m17306V() {
        Object obj = this.f17349a.get();
        return (obj == null || EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) ? false : true;
    }

    /* renamed from: W */
    int m17307W() {
        return this.f17350b.get().length;
    }

    /* renamed from: a */
    boolean m17308a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17350b.get();
            if (aVarArr == f17348j) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17350b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* renamed from: b */
    void m17309b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17350b.get();
            if (aVarArr == f17348j || aVarArr == f17347i) {
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
                aVarArr2 = f17347i;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17350b.compareAndSet(aVarArr, aVarArr2));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public T[] m17310c(T[] tArr) {
        Object obj = this.f17349a.get();
        if (obj == null || EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) {
            if (tArr.length != 0) {
                tArr[0] = 0;
            }
            return tArr;
        }
        Object value = EnumC5177q.getValue(obj);
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

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        a<T> aVar = new a<>(interfaceC4514i0, this);
        interfaceC4514i0.onSubscribe(aVar);
        if (m17308a((a) aVar)) {
            if (aVar.f17362g) {
                m17309b((a) aVar);
                return;
            } else {
                aVar.m17313a();
                return;
            }
        }
        Throwable th = this.f17354f.get();
        if (th == C5171k.f20031a) {
            interfaceC4514i0.onComplete();
        } else {
            interfaceC4514i0.onError(th);
        }
    }

    /* renamed from: m */
    void m17311m(Object obj) {
        this.f17353e.lock();
        try {
            this.f17355g++;
            this.f17349a.lazySet(obj);
        } finally {
            this.f17353e.unlock();
        }
    }

    /* renamed from: n */
    a<T>[] m17312n(Object obj) {
        a<T>[] aVarArr = this.f17350b.get();
        a<T>[] aVarArr2 = f17348j;
        if (aVarArr != aVarArr2 && (aVarArr = this.f17350b.getAndSet(aVarArr2)) != f17348j) {
            m17311m(obj);
        }
        return aVarArr;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17354f.compareAndSet(null, C5171k.f20031a)) {
            Object complete = EnumC5177q.complete();
            for (a<T> aVar : m17312n(complete)) {
                aVar.m17314a(complete, this.f17355g);
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (!this.f17354f.compareAndSet(null, th)) {
            C4476a.m17152b(th);
            return;
        }
        Object error = EnumC5177q.error(th);
        for (a<T> aVar : m17312n(error)) {
            aVar.m17314a(error, this.f17355g);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f17354f.get() != null) {
            return;
        }
        Object next = EnumC5177q.next(t);
        m17311m(next);
        for (a<T> aVar : this.f17350b.get()) {
            aVar.m17314a(next, this.f17355g);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (this.f17354f.get() != null) {
            interfaceC4552c.dispose();
        }
    }

    C4494b(T t) {
        this();
        this.f17349a.lazySet(C4601b.m18284a((Object) t, "defaultValue is null"));
    }

    /* compiled from: BehaviorSubject.java */
    /* renamed from: g.a.f1.b$a */
    static final class a<T> implements InterfaceC4552c, C5161a.a<Object> {

        /* renamed from: a */
        final InterfaceC4514i0<? super T> f17356a;

        /* renamed from: b */
        final C4494b<T> f17357b;

        /* renamed from: c */
        boolean f17358c;

        /* renamed from: d */
        boolean f17359d;

        /* renamed from: e */
        C5161a<Object> f17360e;

        /* renamed from: f */
        boolean f17361f;

        /* renamed from: g */
        volatile boolean f17362g;

        /* renamed from: h */
        long f17363h;

        a(InterfaceC4514i0<? super T> interfaceC4514i0, C4494b<T> c4494b) {
            this.f17356a = interfaceC4514i0;
            this.f17357b = c4494b;
        }

        /* renamed from: a */
        void m17313a() {
            if (this.f17362g) {
                return;
            }
            synchronized (this) {
                if (this.f17362g) {
                    return;
                }
                if (this.f17358c) {
                    return;
                }
                C4494b<T> c4494b = this.f17357b;
                Lock lock = c4494b.f17352d;
                lock.lock();
                this.f17363h = c4494b.f17355g;
                Object obj = c4494b.f17349a.get();
                lock.unlock();
                this.f17359d = obj != null;
                this.f17358c = true;
                if (obj == null || test(obj)) {
                    return;
                }
                m17315b();
            }
        }

        /* renamed from: b */
        void m17315b() {
            C5161a<Object> c5161a;
            while (!this.f17362g) {
                synchronized (this) {
                    c5161a = this.f17360e;
                    if (c5161a == null) {
                        this.f17359d = false;
                        return;
                    }
                    this.f17360e = null;
                }
                c5161a.m18600a((C5161a.a<? super Object>) this);
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.f17362g) {
                return;
            }
            this.f17362g = true;
            this.f17357b.m17309b((a) this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17362g;
        }

        @Override // p251g.p252a.p268y0.p284j.C5161a.a, p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(Object obj) {
            return this.f17362g || EnumC5177q.accept(obj, this.f17356a);
        }

        /* renamed from: a */
        void m17314a(Object obj, long j2) {
            if (this.f17362g) {
                return;
            }
            if (!this.f17361f) {
                synchronized (this) {
                    if (this.f17362g) {
                        return;
                    }
                    if (this.f17363h == j2) {
                        return;
                    }
                    if (this.f17359d) {
                        C5161a<Object> c5161a = this.f17360e;
                        if (c5161a == null) {
                            c5161a = new C5161a<>(4);
                            this.f17360e = c5161a;
                        }
                        c5161a.m18601a((C5161a<Object>) obj);
                        return;
                    }
                    this.f17358c = true;
                    this.f17361f = true;
                }
            }
            test(obj);
        }
    }
}
