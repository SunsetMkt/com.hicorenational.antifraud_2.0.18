package p251g.p252a.p256d1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: ReplayProcessor.java */
/* renamed from: g.a.d1.e */
/* loaded from: classes2.dex */
public final class C4483e<T> extends AbstractC4481c<T> {

    /* renamed from: e */
    private static final Object[] f17278e = new Object[0];

    /* renamed from: f */
    static final c[] f17279f = new c[0];

    /* renamed from: g */
    static final c[] f17280g = new c[0];

    /* renamed from: b */
    final b<T> f17281b;

    /* renamed from: c */
    boolean f17282c;

    /* renamed from: d */
    final AtomicReference<c<T>[]> f17283d = new AtomicReference<>(f17279f);

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$a */
    static final class a<T> extends AtomicReference<a<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final T value;

        a(T t) {
            this.value = t;
        }
    }

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$b */
    interface b<T> {
        /* renamed from: a */
        void mo17248a(c<T> cVar);

        void complete();

        void error(Throwable th);

        /* renamed from: g */
        Throwable mo17249g();

        T getValue();

        T[] getValues(T[] tArr);

        boolean isDone();

        void next(T t);

        int size();
    }

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$c */
    static final class c<T> extends AtomicInteger implements InterfaceC5823d {
        private static final long serialVersionUID = 466549804534799122L;
        final InterfaceC5822c<? super T> actual;
        volatile boolean cancelled;
        long emitted;
        Object index;
        final AtomicLong requested = new AtomicLong();
        final C4483e<T> state;

        c(InterfaceC5822c<? super T> interfaceC5822c, C4483e<T> c4483e) {
            this.actual = interfaceC5822c;
            this.state = c4483e;
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (this.cancelled) {
                return;
            }
            this.cancelled = true;
            this.state.m17244b((c) this);
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(this.requested, j2);
                this.state.f17281b.mo17248a(this);
            }
        }
    }

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$f */
    static final class f<T> extends AtomicReference<f<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        final long time;
        final T value;

        f(T t, long j2) {
            this.value = t;
            this.time = j2;
        }
    }

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$g */
    static final class g<T> implements b<T> {

        /* renamed from: a */
        final List<T> f17299a;

        /* renamed from: b */
        Throwable f17300b;

        /* renamed from: c */
        volatile boolean f17301c;

        /* renamed from: d */
        volatile int f17302d;

        g(int i2) {
            this.f17299a = new ArrayList(C4601b.m18279a(i2, "capacityHint"));
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        /* renamed from: a */
        public void mo17248a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            List<T> list = this.f17299a;
            InterfaceC5822c<? super T> interfaceC5822c = cVar.actual;
            Integer num = (Integer) cVar.index;
            int i2 = 0;
            if (num != null) {
                i2 = num.intValue();
            } else {
                cVar.index = 0;
            }
            long j2 = cVar.emitted;
            int i3 = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f17301c;
                    int i4 = this.f17302d;
                    if (z && i2 == i4) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f17300b;
                        if (th == null) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            interfaceC5822c.onError(th);
                            return;
                        }
                    }
                    if (i2 == i4) {
                        break;
                    }
                    interfaceC5822c.onNext(list.get(i2));
                    i2++;
                    j2++;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z2 = this.f17301c;
                    int i5 = this.f17302d;
                    if (z2 && i2 == i5) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f17300b;
                        if (th2 == null) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            interfaceC5822c.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = Integer.valueOf(i2);
                cVar.emitted = j2;
                i3 = cVar.addAndGet(-i3);
            } while (i3 != 0);
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void complete() {
            this.f17301c = true;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void error(Throwable th) {
            this.f17300b = th;
            this.f17301c = true;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        /* renamed from: g */
        public Throwable mo17249g() {
            return this.f17300b;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public T getValue() {
            int i2 = this.f17302d;
            if (i2 == 0) {
                return null;
            }
            return this.f17299a.get(i2 - 1);
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public T[] getValues(T[] tArr) {
            int i2 = this.f17302d;
            if (i2 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List<T> list = this.f17299a;
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

        @Override // p251g.p252a.p256d1.C4483e.b
        public boolean isDone() {
            return this.f17301c;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void next(T t) {
            this.f17299a.add(t);
            this.f17302d++;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public int size() {
            return this.f17302d;
        }
    }

    C4483e(b<T> bVar) {
        this.f17281b = bVar;
    }

    @InterfaceC4544d
    /* renamed from: b */
    public static <T> C4483e<T> m17234b(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0, int i2) {
        return new C4483e<>(new d(i2, j2, timeUnit, abstractC4516j0));
    }

    @InterfaceC4544d
    /* renamed from: d0 */
    public static <T> C4483e<T> m17235d0() {
        return new C4483e<>(new g(16));
    }

    /* renamed from: e0 */
    static <T> C4483e<T> m17236e0() {
        return new C4483e<>(new e(Integer.MAX_VALUE));
    }

    @InterfaceC4544d
    /* renamed from: m */
    public static <T> C4483e<T> m17237m(int i2) {
        return new C4483e<>(new g(i2));
    }

    @InterfaceC4544d
    /* renamed from: n */
    public static <T> C4483e<T> m17238n(int i2) {
        return new C4483e<>(new e(i2));
    }

    @InterfaceC4544d
    /* renamed from: r */
    public static <T> C4483e<T> m17239r(long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
        return new C4483e<>(new d(Integer.MAX_VALUE, j2, timeUnit, abstractC4516j0));
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: T */
    public Throwable mo17205T() {
        b<T> bVar = this.f17281b;
        if (bVar.isDone()) {
            return bVar.mo17249g();
        }
        return null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: U */
    public boolean mo17206U() {
        b<T> bVar = this.f17281b;
        return bVar.isDone() && bVar.mo17249g() == null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: V */
    public boolean mo17207V() {
        return this.f17283d.get().length != 0;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: W */
    public boolean mo17208W() {
        b<T> bVar = this.f17281b;
        return bVar.isDone() && bVar.mo17249g() != null;
    }

    /* renamed from: Y */
    public T m17240Y() {
        return this.f17281b.getValue();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: Z */
    public Object[] m17241Z() {
        Object[] m17246c = m17246c(f17278e);
        return m17246c == f17278e ? new Object[0] : m17246c;
    }

    /* renamed from: a */
    boolean m17242a(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f17283d.get();
            if (cVarArr == f17280g) {
                return false;
            }
            int length = cVarArr.length;
            cVarArr2 = new c[length + 1];
            System.arraycopy(cVarArr, 0, cVarArr2, 0, length);
            cVarArr2[length] = cVar;
        } while (!this.f17283d.compareAndSet(cVarArr, cVarArr2));
        return true;
    }

    /* renamed from: a0 */
    public boolean m17243a0() {
        return this.f17281b.size() != 0;
    }

    /* renamed from: b0 */
    int m17245b0() {
        return this.f17281b.size();
    }

    /* renamed from: c */
    public T[] m17246c(T[] tArr) {
        return this.f17281b.getValues(tArr);
    }

    /* renamed from: c0 */
    int m17247c0() {
        return this.f17283d.get().length;
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        c<T> cVar = new c<>(interfaceC5822c, this);
        interfaceC5822c.onSubscribe(cVar);
        if (m17242a((c) cVar) && cVar.cancelled) {
            m17244b((c) cVar);
        } else {
            this.f17281b.mo17248a(cVar);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f17282c) {
            return;
        }
        this.f17282c = true;
        b<T> bVar = this.f17281b;
        bVar.complete();
        for (c<T> cVar : this.f17283d.getAndSet(f17280g)) {
            bVar.mo17248a(cVar);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        if (this.f17282c) {
            C4476a.m17152b(th);
            return;
        }
        this.f17282c = true;
        b<T> bVar = this.f17281b;
        bVar.error(th);
        for (c<T> cVar : this.f17283d.getAndSet(f17280g)) {
            bVar.mo17248a(cVar);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        if (this.f17282c) {
            return;
        }
        b<T> bVar = this.f17281b;
        bVar.next(t);
        for (c<T> cVar : this.f17283d.get()) {
            bVar.mo17248a(cVar);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c, p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (this.f17282c) {
            interfaceC5823d.cancel();
        } else {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }

    /* renamed from: b */
    void m17244b(c<T> cVar) {
        c<T>[] cVarArr;
        c<T>[] cVarArr2;
        do {
            cVarArr = this.f17283d.get();
            if (cVarArr == f17280g || cVarArr == f17279f) {
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
                cVarArr2 = f17279f;
            } else {
                c<T>[] cVarArr3 = new c[length - 1];
                System.arraycopy(cVarArr, 0, cVarArr3, 0, i2);
                System.arraycopy(cVarArr, i2 + 1, cVarArr3, i2, (length - i2) - 1);
                cVarArr2 = cVarArr3;
            }
        } while (!this.f17283d.compareAndSet(cVarArr, cVarArr2));
    }

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$e */
    static final class e<T> implements b<T> {

        /* renamed from: a */
        final int f17293a;

        /* renamed from: b */
        int f17294b;

        /* renamed from: c */
        volatile a<T> f17295c;

        /* renamed from: d */
        a<T> f17296d;

        /* renamed from: e */
        Throwable f17297e;

        /* renamed from: f */
        volatile boolean f17298f;

        e(int i2) {
            this.f17293a = C4601b.m18279a(i2, "maxSize");
            a<T> aVar = new a<>(null);
            this.f17296d = aVar;
            this.f17295c = aVar;
        }

        /* renamed from: a */
        void m17254a() {
            int i2 = this.f17294b;
            if (i2 > this.f17293a) {
                this.f17294b = i2 - 1;
                this.f17295c = this.f17295c.get();
            }
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void complete() {
            this.f17298f = true;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void error(Throwable th) {
            this.f17297e = th;
            this.f17298f = true;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        /* renamed from: g */
        public Throwable mo17249g() {
            return this.f17297e;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public T getValue() {
            a<T> aVar = this.f17295c;
            while (true) {
                a<T> aVar2 = aVar.get();
                if (aVar2 == null) {
                    return aVar.value;
                }
                aVar = aVar2;
            }
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public T[] getValues(T[] tArr) {
            a<T> aVar = this.f17295c;
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

        @Override // p251g.p252a.p256d1.C4483e.b
        public boolean isDone() {
            return this.f17298f;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void next(T t) {
            a<T> aVar = new a<>(t);
            a<T> aVar2 = this.f17296d;
            this.f17296d = aVar;
            this.f17294b++;
            aVar2.set(aVar);
            m17254a();
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public int size() {
            a<T> aVar = this.f17295c;
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (aVar = aVar.get()) != null) {
                i2++;
            }
            return i2;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        /* renamed from: a */
        public void mo17248a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = cVar.actual;
            a<T> aVar = (a) cVar.index;
            if (aVar == null) {
                aVar = this.f17295c;
            }
            long j2 = cVar.emitted;
            int i2 = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f17298f;
                    a<T> aVar2 = aVar.get();
                    boolean z2 = aVar2 == null;
                    if (z && z2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f17297e;
                        if (th == null) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            interfaceC5822c.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(aVar2.value);
                    j2++;
                    aVar = aVar2;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    if (this.f17298f && aVar.get() == null) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f17297e;
                        if (th2 == null) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            interfaceC5822c.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = aVar;
                cVar.emitted = j2;
                i2 = cVar.addAndGet(-i2);
            } while (i2 != 0);
        }
    }

    /* compiled from: ReplayProcessor.java */
    /* renamed from: g.a.d1.e$d */
    static final class d<T> implements b<T> {

        /* renamed from: a */
        final int f17284a;

        /* renamed from: b */
        final long f17285b;

        /* renamed from: c */
        final TimeUnit f17286c;

        /* renamed from: d */
        final AbstractC4516j0 f17287d;

        /* renamed from: e */
        int f17288e;

        /* renamed from: f */
        volatile f<T> f17289f;

        /* renamed from: g */
        f<T> f17290g;

        /* renamed from: h */
        Throwable f17291h;

        /* renamed from: i */
        volatile boolean f17292i;

        d(int i2, long j2, TimeUnit timeUnit, AbstractC4516j0 abstractC4516j0) {
            this.f17284a = C4601b.m18279a(i2, "maxSize");
            this.f17285b = C4601b.m18282a(j2, "maxAge");
            this.f17286c = (TimeUnit) C4601b.m18284a(timeUnit, "unit is null");
            this.f17287d = (AbstractC4516j0) C4601b.m18284a(abstractC4516j0, "scheduler is null");
            f<T> fVar = new f<>(null, 0L);
            this.f17290g = fVar;
            this.f17289f = fVar;
        }

        /* renamed from: a */
        f<T> m17251a() {
            f<T> fVar;
            f<T> fVar2 = this.f17289f;
            long mo17276a = this.f17287d.mo17276a(this.f17286c) - this.f17285b;
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

        /* renamed from: b */
        void m17252b() {
            int i2 = this.f17288e;
            if (i2 > this.f17284a) {
                this.f17288e = i2 - 1;
                this.f17289f = this.f17289f.get();
            }
            long mo17276a = this.f17287d.mo17276a(this.f17286c) - this.f17285b;
            f<T> fVar = this.f17289f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    this.f17289f = fVar;
                    return;
                } else {
                    if (fVar2.time > mo17276a) {
                        this.f17289f = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        /* renamed from: c */
        void m17253c() {
            long mo17276a = this.f17287d.mo17276a(this.f17286c) - this.f17285b;
            f<T> fVar = this.f17289f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    this.f17289f = fVar;
                    return;
                } else {
                    if (fVar2.time > mo17276a) {
                        this.f17289f = fVar;
                        return;
                    }
                    fVar = fVar2;
                }
            }
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void complete() {
            m17253c();
            this.f17292i = true;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void error(Throwable th) {
            m17253c();
            this.f17291h = th;
            this.f17292i = true;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        /* renamed from: g */
        public Throwable mo17249g() {
            return this.f17291h;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public T getValue() {
            f<T> fVar = this.f17289f;
            while (true) {
                f<T> fVar2 = fVar.get();
                if (fVar2 == null) {
                    break;
                }
                fVar = fVar2;
            }
            if (fVar.time < this.f17287d.mo17276a(this.f17286c) - this.f17285b) {
                return null;
            }
            return fVar.value;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public T[] getValues(T[] tArr) {
            f<T> m17251a = m17251a();
            int m17250a = m17250a(m17251a);
            if (m17250a != 0) {
                if (tArr.length < m17250a) {
                    tArr = (T[]) ((Object[]) Array.newInstance(tArr.getClass().getComponentType(), m17250a));
                }
                for (int i2 = 0; i2 != m17250a; i2++) {
                    m17251a = m17251a.get();
                    tArr[i2] = m17251a.value;
                }
                if (tArr.length > m17250a) {
                    tArr[m17250a] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public boolean isDone() {
            return this.f17292i;
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public void next(T t) {
            f<T> fVar = new f<>(t, this.f17287d.mo17276a(this.f17286c));
            f<T> fVar2 = this.f17290g;
            this.f17290g = fVar;
            this.f17288e++;
            fVar2.set(fVar);
            m17252b();
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        public int size() {
            return m17250a(m17251a());
        }

        @Override // p251g.p252a.p256d1.C4483e.b
        /* renamed from: a */
        public void mo17248a(c<T> cVar) {
            if (cVar.getAndIncrement() != 0) {
                return;
            }
            InterfaceC5822c<? super T> interfaceC5822c = cVar.actual;
            f<T> fVar = (f) cVar.index;
            if (fVar == null) {
                fVar = m17251a();
            }
            long j2 = cVar.emitted;
            int i2 = 1;
            do {
                long j3 = cVar.requested.get();
                while (j2 != j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    boolean z = this.f17292i;
                    f<T> fVar2 = fVar.get();
                    boolean z2 = fVar2 == null;
                    if (z && z2) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th = this.f17291h;
                        if (th == null) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            interfaceC5822c.onError(th);
                            return;
                        }
                    }
                    if (z2) {
                        break;
                    }
                    interfaceC5822c.onNext(fVar2.value);
                    j2++;
                    fVar = fVar2;
                }
                if (j2 == j3) {
                    if (cVar.cancelled) {
                        cVar.index = null;
                        return;
                    }
                    if (this.f17292i && fVar.get() == null) {
                        cVar.index = null;
                        cVar.cancelled = true;
                        Throwable th2 = this.f17291h;
                        if (th2 == null) {
                            interfaceC5822c.onComplete();
                            return;
                        } else {
                            interfaceC5822c.onError(th2);
                            return;
                        }
                    }
                }
                cVar.index = fVar;
                cVar.emitted = j2;
                i2 = cVar.addAndGet(-i2);
            } while (i2 != 0);
        }

        /* renamed from: a */
        int m17250a(f<T> fVar) {
            int i2 = 0;
            while (i2 != Integer.MAX_VALUE && (fVar = fVar.get()) != null) {
                i2++;
            }
            return i2;
        }
    }
}
