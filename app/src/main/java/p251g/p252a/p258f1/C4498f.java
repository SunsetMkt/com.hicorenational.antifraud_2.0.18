package p251g.p252a.p258f1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p286h.p309q2.p311t.C5556m0;

/* compiled from: ReplaySubject.java */
/* renamed from: g.a.f1.f */
/* loaded from: classes2.dex */
public final class C4498f<T> extends AbstractC4501i<T> {

    /* renamed from: d */
    static final c[] f17379d = new c[0];

    /* renamed from: e */
    static final c[] f17380e = new c[0];

    /* renamed from: f */
    private static final Object[] f17381f = new Object[0];

    /* renamed from: a */
    final b<T> f17382a;

    /* renamed from: b */
    final AtomicReference<c<T>[]> f17383b = new AtomicReference<>(f17379d);

    /* renamed from: c */
    boolean f17384c;

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$a */
    static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        a(T t) {
            this.value = t;
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$b */
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

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$c */
    static final class c<T> extends AtomicInteger implements InterfaceC4552c {
        private static final long serialVersionUID = 466549804534799122L;
        final InterfaceC4514i0<? super T> actual;
        volatile boolean cancelled;
        Object index;
        final C4498f<T> state;

        c(InterfaceC4514i0<? super T> interfaceC4514i0, C4498f<T> c4498f) {
            this.actual = interfaceC4514i0;
            this.state = c4498f;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.m17350b((c) this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$d */
    static final class d<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -8056260896137901749L;
        volatile boolean done;
        volatile f<Object> head;
        final long maxAge;
        final int maxSize;
        final AbstractC4516j0 scheduler;
        int size;
        f<Object> tail;
        final TimeUnit unit;

        d(int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.maxSize = C4601b.m18279a(i2, "maxSize");
            this.maxAge = C4601b.m18282a(j2, "maxAge");
            this.unit = (TimeUnit) C4601b.m18284a(timeUnit, "unit is null");
            this.scheduler = (AbstractC4516j0) C4601b.m18284a(abstractC4516j0, "scheduler is null");
            f<Object> fVar = new f<>(null, 0L);
            this.tail = fVar;
            this.head = fVar;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public void add(T t) {
            f<Object> fVar = new f<>(t, this.scheduler.mo17276a(this.unit));
            f<Object> fVar2 = this.tail;
            this.tail = fVar;
            this.size++;
            fVar2.set(fVar);
            trim();
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public void addFinal(Object obj) {
            f<Object> fVar = new f<>(obj, C5556m0.f20396b);
            f<Object> fVar2 = this.tail;
            this.tail = fVar;
            this.size++;
            fVar2.lazySet(fVar);
            trimFinal();
            this.done = true;
        }

        f<Object> getHead() {
            f<Object> fVar;
            f<Object> fVar2 = this.head;
            long mo17276a = this.scheduler.mo17276a(this.unit) - this.maxAge;
            f<T> fVar3 = fVar2.get();
            while (true) {
                f<T> fVar4 = fVar3;
                fVar = fVar2;
                fVar2 = fVar4;
                if (fVar2 == null || fVar2.time > mo17276a) {
                    break;
                }
                fVar3 = fVar2.get();
            }
            return fVar;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public T getValue() {
            T t;
            f<Object> fVar = this.head;
            f<Object> fVar2 = null;
            while (true) {
                f<T> fVar3 = fVar.get();
                if (fVar3 == null) {
                    break;
                }
                fVar2 = fVar;
                fVar = fVar3;
            }
            if (fVar.time >= this.scheduler.mo17276a(this.unit) - this.maxAge && (t = (T) fVar.value) != null) {
                return (EnumC5177q.isComplete(t) || EnumC5177q.isError(t)) ? (T) fVar2.value : t;
            }
            return null;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public T[] getValues(T[] tArr) {
            f<T> head = getHead();
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

        @Override // p251g.p252a.p258f1.C4498f.b
        public void replay(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            InterfaceC4514i0<? super T> interfaceC4514i0 = cVar.actual;
            f<Object> fVar = (f) cVar.index;
            if (fVar == null) {
                fVar = getHead();
            }
            int i2 = 1;
            while (!cVar.cancelled) {
                while (!cVar.cancelled) {
                    f<T> fVar2 = fVar.get();
                    if (fVar2 != null) {
                        T t = fVar2.value;
                        if (this.done && fVar2.get() == null) {
                            if (EnumC5177q.isComplete(t)) {
                                interfaceC4514i0.onComplete();
                            } else {
                                interfaceC4514i0.onError(EnumC5177q.getError(t));
                            }
                            cVar.index = null;
                            cVar.cancelled = true;
                            return;
                        }
                        interfaceC4514i0.onNext(t);
                        fVar = fVar2;
                    } else if (fVar.get() == null) {
                        cVar.index = fVar;
                        i2 = cVar.addAndGet(-i2);
                        if (i2 == 0) {
                            return;
                        }
                    }
                }
                cVar.index = null;
                return;
            }
            cVar.index = null;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public int size() {
            return size(getHead());
        }

        void trim() {
            int i2 = this.size;
            if (i2 > this.maxSize) {
                this.size = i2 - 1;
                this.head = this.head.get();
            }
            long mo17276a = this.scheduler.mo17276a(this.unit) - this.maxAge;
            f<Object> fVar = this.head;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    this.head = fVar;
                    return;
                } else {
                    if (fVar2.time > mo17276a) {
                        this.head = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        void trimFinal() {
            long mo17276a = this.scheduler.mo17276a(this.unit) - this.maxAge;
            f<Object> fVar = this.head;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2.get() == null) {
                    this.head = fVar;
                    return;
                } else {
                    if (fVar2.time > mo17276a) {
                        this.head = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        int size(f<Object> fVar) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    Object obj = fVar.value;
                    return (EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) ? i2 - 1 : i2;
                }
                i2++;
                fVar = fVar2;
            }
            return i2;
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$e */
    static final class e<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = 1107649250281456395L;
        volatile boolean done;
        volatile a<Object> head;
        final int maxSize;
        int size;
        a<Object> tail;

        e(int i2) {
            this.maxSize = C4601b.m18279a(i2, "maxSize");
            a<Object> aVar = new a<>(null);
            this.tail = aVar;
            this.head = aVar;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public void add(T t) {
            a<Object> aVar = new a<>(t);
            a<Object> aVar2 = this.tail;
            this.tail = aVar;
            this.size++;
            aVar2.set(aVar);
            trim();
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public void addFinal(Object obj) {
            a<Object> aVar = new a<>(obj);
            a<Object> aVar2 = this.tail;
            this.tail = aVar;
            this.size++;
            aVar2.lazySet(aVar);
            this.done = true;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
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
            return (EnumC5177q.isComplete(t) || EnumC5177q.isError(t)) ? (T) aVar2.value : t;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
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

        @Override // p251g.p252a.p258f1.C4498f.b
        public void replay(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            InterfaceC4514i0<? super T> interfaceC4514i0 = cVar.actual;
            a<Object> aVar = (a) cVar.index;
            if (aVar == null) {
                aVar = this.head;
            }
            int i2 = 1;
            while (!cVar.cancelled) {
                a<T> aVar2 = aVar.get();
                if (aVar2 != null) {
                    T t = aVar2.value;
                    if (this.done && aVar2.get() == null) {
                        if (EnumC5177q.isComplete(t)) {
                            interfaceC4514i0.onComplete();
                        } else {
                            interfaceC4514i0.onError(EnumC5177q.getError(t));
                        }
                        cVar.index = null;
                        cVar.cancelled = true;
                        return;
                    }
                    interfaceC4514i0.onNext(t);
                    aVar = aVar2;
                } else if (aVar.get() != null) {
                    continue;
                } else {
                    cVar.index = aVar;
                    i2 = cVar.addAndGet(-i2);
                    if (i2 == 0) {
                        return;
                    }
                }
            }
            cVar.index = null;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public int size() {
            a<Object> aVar = this.head;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    Object obj = aVar.value;
                    return (EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) ? i2 - 1 : i2;
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

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$f */
    static final class f<T> extends AtomicReference<f<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        f(T t, long j2) {
            this.value = t;
            this.time = j2;
        }
    }

    /* compiled from: ReplaySubject.java */
    /* renamed from: g.a.f1.f$g */
    static final class g<T> extends AtomicReference<Object> implements b<T> {
        private static final long serialVersionUID = -733876083048047795L;
        final List<Object> buffer;
        volatile boolean done;
        volatile int size;

        g(int i2) {
            this.buffer = new ArrayList(C4601b.m18279a(i2, "capacityHint"));
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public void add(T t) {
            this.buffer.add(t);
            this.size++;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public void addFinal(Object obj) {
            this.buffer.add(obj);
            this.size++;
            this.done = true;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public T getValue() {
            int i2 = this.size;
            if (i2 == 0) {
                return null;
            }
            List<Object> list = this.buffer;
            T t = (T) list.get(i2 - 1);
            if (!EnumC5177q.isComplete(t) && !EnumC5177q.isError(t)) {
                return t;
            }
            if (i2 == 1) {
                return null;
            }
            return (T) list.get(i2 - 2);
        }

        @Override // p251g.p252a.p258f1.C4498f.b
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
            if ((EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) && i2 - 1 == 0) {
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

        @Override // p251g.p252a.p258f1.C4498f.b
        public void replay(c<T> cVar) {
            int i2;
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            List<Object> list = this.buffer;
            InterfaceC4514i0<? super T> interfaceC4514i0 = cVar.actual;
            Integer num = (Integer) cVar.index;
            int i3 = 0;
            if (num != null) {
                i3 = num.intValue();
            } else {
                cVar.index = 0;
            }
            int i4 = 1;
            while (!cVar.cancelled) {
                int i5 = this.size;
                while (i5 != i3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    Object obj = list.get(i3);
                    if (this.done && (i2 = i3 + 1) == i5 && i2 == (i5 = this.size)) {
                        if (EnumC5177q.isComplete(obj)) {
                            interfaceC4514i0.onComplete();
                        } else {
                            interfaceC4514i0.onError(EnumC5177q.getError(obj));
                        }
                        cVar.index = null;
                        cVar.cancelled = true;
                        return;
                    }
                    interfaceC4514i0.onNext(obj);
                    i3++;
                }
                if (i3 == this.size) {
                    cVar.index = Integer.valueOf(i3);
                    i4 = cVar.addAndGet(-i4);
                    if (i4 == 0) {
                        return;
                    }
                }
            }
            cVar.index = null;
        }

        @Override // p251g.p252a.p258f1.C4498f.b
        public int size() {
            int i2 = this.size;
            if (i2 == 0) {
                return 0;
            }
            int i3 = i2 - 1;
            Object obj = this.buffer.get(i3);
            return (EnumC5177q.isComplete(obj) || EnumC5177q.isError(obj)) ? i3 : i2;
        }
    }

    C4498f(b<T> bVar) {
        this.f17382a = bVar;
    }

    @InterfaceC4544d
    /* renamed from: Y */
    public static <T> C4498f<T> m17338Y() {
        return new C4498f<>(new g(16));
    }

    /* renamed from: Z */
    static <T> C4498f<T> m17339Z() {
        return new C4498f<>(new e(Integer.MAX_VALUE));
    }

    @InterfaceC4544d
    /* renamed from: b */
    public static <T> C4498f<T> m17340b(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
        return new C4498f<>(new d(i2, j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    /* renamed from: i */
    public static <T> C4498f<T> m17341i(int i2) {
        return new C4498f<>(new g(i2));
    }

    @InterfaceC4544d
    /* renamed from: j */
    public static <T> C4498f<T> m17342j(int i2) {
        return new C4498f<>(new e(i2));
    }

    @InterfaceC4544d
    /* renamed from: r */
    public static <T> C4498f<T> m17343r(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return new C4498f<>(new d(Integer.MAX_VALUE, j2, timeUnit, abstractC4516j0));
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: O */
    public Throwable mo17291O() {
        Object obj = this.f17382a.get();
        if (EnumC5177q.isError(obj)) {
            return EnumC5177q.getError(obj);
        }
        return null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: P */
    public boolean mo17292P() {
        return EnumC5177q.isComplete(this.f17382a.get());
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: Q */
    public boolean mo17293Q() {
        return this.f17383b.get().length != 0;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: R */
    public boolean mo17294R() {
        return EnumC5177q.isError(this.f17382a.get());
    }

    /* renamed from: T */
    public T m17344T() {
        return this.f17382a.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: U */
    public Object[] m17345U() {
        Object[] m17351c = m17351c(f17381f);
        return m17351c == f17381f ? new Object[0] : m17351c;
    }

    /* renamed from: V */
    public boolean m17346V() {
        return this.f17382a.size() != 0;
    }

    /* renamed from: W */
    int m17347W() {
        return this.f17383b.get().length;
    }

    /* renamed from: X */
    int m17348X() {
        return this.f17382a.size();
    }

    /* renamed from: a */
    boolean m17349a(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f17383b.get();
            if (cVarArr == f17380e) {
                return false;
            }
            int length = cVarArr.length;
            cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
        } while (!this.f17383b.compareAndSet(cVarArr, cVarArr2));
        return true;
    }

    /* renamed from: c */
    public T[] m17351c(T[] tArr) {
        return this.f17382a.getValues(tArr);
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        c<T> cVar = new c<>(interfaceC4514i0, this);
        interfaceC4514i0.onSubscribe(cVar);
        if (cVar.cancelled) {
            return;
        }
        if (m17349a((c) cVar) && cVar.cancelled) {
            m17350b((c) cVar);
        } else {
            this.f17382a.replay(cVar);
        }
    }

    /* renamed from: m */
    c<T>[] m17352m(Object obj) {
        return this.f17382a.compareAndSet(null, obj) ? this.f17383b.getAndSet(f17380e) : f17380e;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17384c) {
            return;
        }
        this.f17384c = true;
        Object complete = EnumC5177q.complete();
        b<T> bVar = this.f17382a;
        bVar.addFinal(complete);
        for (c<T> cVar : m17352m(complete)) {
            bVar.replay(cVar);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.f17384c) {
            C4476a.m17152b(th);
            return;
        }
        this.f17384c = true;
        Object error = EnumC5177q.error(th);
        b<T> bVar = this.f17382a;
        bVar.addFinal(error);
        for (c<T> cVar : m17352m(error)) {
            bVar.replay(cVar);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f17384c) {
            return;
        }
        b<T> bVar = this.f17382a;
        bVar.add(t);
        for (c<T> cVar : this.f17383b.get()) {
            bVar.replay(cVar);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (this.f17384c) {
            interfaceC4552c.dispose();
        }
    }

    /* renamed from: b */
    void m17350b(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f17383b.get();
            if (cVarArr == f17380e || cVarArr == f17379d) {
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
                cVarArr2 = f17379d;
            } else {
                c<T>[] cVarArr3 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                cVarArr2 = cVarArr3;
            }
        } while (!this.f17383b.compareAndSet(cVarArr, cVarArr2));
    }
}
