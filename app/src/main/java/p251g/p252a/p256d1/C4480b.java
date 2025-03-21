package p251g.p252a.p256d1;

import java.lang.reflect.Array;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p265v0.C4562c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5161a;
import p251g.p252a.p268y0.p284j.C5164d;
import p251g.p252a.p268y0.p284j.C5171k;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: BehaviorProcessor.java */
/* renamed from: g.a.d1.b */
/* loaded from: classes2.dex */
public final class C4480b<T> extends AbstractC4481c<T> {

    /* renamed from: i */
    static final Object[] f17264i = new Object[0];

    /* renamed from: j */
    static final a[] f17265j = new a[0];

    /* renamed from: k */
    static final a[] f17266k = new a[0];

    /* renamed from: b */
    final AtomicReference<a<T>[]> f17267b;

    /* renamed from: c */
    final ReadWriteLock f17268c;

    /* renamed from: d */
    final Lock f17269d;

    /* renamed from: e */
    final Lock f17270e;

    /* renamed from: f */
    final AtomicReference<Object> f17271f;

    /* renamed from: g */
    final AtomicReference<Throwable> f17272g;

    /* renamed from: h */
    long f17273h;

    /* compiled from: BehaviorProcessor.java */
    /* renamed from: g.a.d1.b$a */
    static final class a<T> extends AtomicLong implements InterfaceC5823d, C5161a.a<Object> {
        private static final long serialVersionUID = 3293175281126227086L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        boolean emitting;
        boolean fastPath;
        long index;
        boolean next;
        C5161a<Object> queue;
        final C4480b<T> state;

        a(InterfaceC5822c<? super T> interfaceC5822c, C4480b<T> c4480b) {
            this.actual = interfaceC5822c;
            this.state = c4480b;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.m17223b((a) this);
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
                C4480b<T> c4480b = this.state;
                Lock lock = c4480b.f17269d;
                lock.lock();
                this.index = c4480b.f17273h;
                Object obj = c4480b.f17271f.get();
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
            C5161a<Object> c5161a;
            while (!this.cancelled) {
                synchronized (this) {
                    c5161a = this.queue;
                    if (c5161a == null) {
                        this.emitting = false;
                        return;
                    }
                    this.queue = null;
                }
                c5161a.m18600a((C5161a.a<? super Object>) this);
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
                        C5161a<Object> c5161a = this.queue;
                        if (c5161a == null) {
                            c5161a = new C5161a<>(4);
                            this.queue = c5161a;
                        }
                        c5161a.m18601a((C5161a<Object>) obj);
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

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this, j2);
            }
        }

        @Override // p251g.p252a.p268y0.p284j.C5161a.a, p251g.p252a.p267x0.InterfaceC4587r
        public boolean test(Object obj) {
            if (this.cancelled) {
                return true;
            }
            if (EnumC5177q.isComplete(obj)) {
                this.actual.onComplete();
                return true;
            }
            if (EnumC5177q.isError(obj)) {
                this.actual.onError(EnumC5177q.getError(obj));
                return true;
            }
            long j2 = get();
            if (j2 == 0) {
                cancel();
                this.actual.onError(new C4562c("Could not deliver value due to lack of requests"));
                return true;
            }
            this.actual.onNext((Object) EnumC5177q.getValue(obj));
            if (j2 == C5556m0.f20396b) {
                return false;
            }
            decrementAndGet();
            return false;
        }
    }

    C4480b() {
        this.f17271f = new AtomicReference<>();
        this.f17268c = new ReentrantReadWriteLock();
        this.f17269d = this.f17268c.readLock();
        this.f17270e = this.f17268c.writeLock();
        this.f17267b = new AtomicReference<>(f17265j);
        this.f17272g = new AtomicReference<>();
    }

    @InterfaceC4544d
    /* renamed from: c0 */
    public static <T> C4480b<T> m17217c0() {
        return new C4480b<>();
    }

    @InterfaceC4544d
    /* renamed from: p */
    public static <T> C4480b<T> m17218p(T t) {
        C4601b.m18284a((Object) t, "defaultValue is null");
        return new C4480b<>(t);
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: T */
    public Throwable mo17205T() {
        Object obj = this.f17271f.get();
        if (EnumC5177q.isError(obj)) {
            return EnumC5177q.getError(obj);
        }
        return null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: U */
    public boolean mo17206U() {
        return EnumC5177q.isComplete(this.f17271f.get());
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: V */
    public boolean mo17207V() {
        return this.f17267b.get().length != 0;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: W */
    public boolean mo17208W() {
        return EnumC5177q.isError(this.f17271f.get());
    }

    /* renamed from: Y */
    public T m17219Y() {
        Object obj = this.f17271f.get();
        if (EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) {
            return null;
        }
        return (T) EnumC5177q.getValue(obj);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Z */
    public Object[] m17220Z() {
        Object[] m17225c = m17225c(f17264i);
        return m17225c == f17264i ? new Object[0] : m17225c;
    }

    /* renamed from: a */
    boolean m17221a(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17267b.get();
            if (aVarArr == f17266k) {
                return false;
            }
            int length = aVarArr.length;
            aVarArr2 = new a[length + 1];
            System.arraycopy(aVarArr, 0, aVarArr2, 0, length);
            aVarArr2[length] = aVar;
        } while (!this.f17267b.compareAndSet(aVarArr, aVarArr2));
        return true;
    }

    /* renamed from: a0 */
    public boolean m17222a0() {
        Object obj = this.f17271f.get();
        return (obj == null || EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) ? false : true;
    }

    /* renamed from: b */
    void m17223b(a<T> aVar) {
        a<T>[] aVarArr;
        a<T>[] aVarArr2;
        do {
            aVarArr = this.f17267b.get();
            if (aVarArr == f17266k || aVarArr == f17265j) {
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
                aVarArr2 = f17265j;
            } else {
                a<T>[] aVarArr3 = new a[length - 1];
                System.arraycopy(aVarArr, 0, aVarArr3, 0, i2);
                System.arraycopy(aVarArr, i2 + 1, aVarArr3, i2, (length - i2) - 1);
                aVarArr2 = aVarArr3;
            }
        } while (!this.f17267b.compareAndSet(aVarArr, aVarArr2));
    }

    /* renamed from: b0 */
    int m17224b0() {
        return this.f17267b.get().length;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: c */
    public T[] m17225c(T[] tArr) {
        Object obj = this.f17271f.get();
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

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        a<T> aVar = new a<>(interfaceC5822c, this);
        interfaceC5822c.onSubscribe(aVar);
        if (m17221a((a) aVar)) {
            if (aVar.cancelled) {
                m17223b((a) aVar);
                return;
            } else {
                aVar.emitFirst();
                return;
            }
        }
        Throwable th = this.f17272g.get();
        if (th == C5171k.f20031a) {
            interfaceC5822c.onComplete();
        } else {
            interfaceC5822c.onError(th);
        }
    }

    @InterfaceC4545e
    /* renamed from: m */
    public boolean m17226m(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return true;
        }
        a<T>[] aVarArr = this.f17267b.get();
        for (a<T> aVar : aVarArr) {
            if (aVar.isFull()) {
                return false;
            }
        }
        Object next = EnumC5177q.next(t);
        m17227n(next);
        for (a<T> aVar2 : aVarArr) {
            aVar2.emitNext(next, this.f17273h);
        }
        return true;
    }

    /* renamed from: n */
    void m17227n(Object obj) {
        Lock lock = this.f17270e;
        lock.lock();
        this.f17273h++;
        this.f17271f.lazySet(obj);
        lock.unlock();
    }

    /* renamed from: o */
    a<T>[] m17228o(Object obj) {
        a<T>[] aVarArr = this.f17267b.get();
        a<T>[] aVarArr2 = f17266k;
        if (aVarArr != aVarArr2 && (aVarArr = this.f17267b.getAndSet(aVarArr2)) != f17266k) {
            m17227n(obj);
        }
        return aVarArr;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f17272g.compareAndSet(null, C5171k.f20031a)) {
            Object complete = EnumC5177q.complete();
            for (a<T> aVar : m17228o(complete)) {
                aVar.emitNext(complete, this.f17273h);
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (!this.f17272g.compareAndSet(null, th)) {
            C4476a.m17152b(th);
            return;
        }
        Object error = EnumC5177q.error(th);
        for (a<T> aVar : m17228o(error)) {
            aVar.emitNext(error, this.f17273h);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f17272g.get() != null) {
            return;
        }
        Object next = EnumC5177q.next(t);
        m17227n(next);
        for (a<T> aVar : this.f17267b.get()) {
            aVar.emitNext(next, this.f17273h);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c, p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (this.f17272g.get() != null) {
            interfaceC5823d.cancel();
        } else {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }

    C4480b(T t) {
        this();
        this.f17271f.lazySet(C4601b.m18284a((Object) t, "defaultValue is null"));
    }
}
