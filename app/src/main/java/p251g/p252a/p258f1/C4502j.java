package p251g.p252a.p258f1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4469b0;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4593e;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p271c.InterfaceC4616o;
import p251g.p252a.p268y0.p272d.AbstractC4619b;
import p251g.p252a.p268y0.p280f.C5111c;

/* compiled from: UnicastSubject.java */
/* renamed from: g.a.f1.j */
/* loaded from: classes2.dex */
public final class C4502j<T> extends AbstractC4501i<T> {

    /* renamed from: a */
    final C5111c<T> f17395a;

    /* renamed from: b */
    final AtomicReference<InterfaceC4514i0<? super T>> f17396b;

    /* renamed from: c */
    final AtomicReference<Runnable> f17397c;

    /* renamed from: d */
    final boolean f17398d;

    /* renamed from: e */
    volatile boolean f17399e;

    /* renamed from: f */
    volatile boolean f17400f;

    /* renamed from: g */
    Throwable f17401g;

    /* renamed from: h */
    final AtomicBoolean f17402h;

    /* renamed from: i */
    final AbstractC4619b<T> f17403i;

    /* renamed from: j */
    boolean f17404j;

    /* compiled from: UnicastSubject.java */
    /* renamed from: g.a.f1.j$a */
    final class a extends AbstractC4619b<T> {
        private static final long serialVersionUID = 7926949470189395511L;

        a() {
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            C4502j.this.f17395a.clear();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            if (C4502j.this.f17399e) {
                return;
            }
            C4502j c4502j = C4502j.this;
            c4502j.f17399e = true;
            c4502j.m17370T();
            C4502j.this.f17396b.lazySet(null);
            if (C4502j.this.f17403i.getAndIncrement() == 0) {
                C4502j.this.f17396b.lazySet(null);
                C4502j.this.f17395a.clear();
            }
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return C4502j.this.f17399e;
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return C4502j.this.f17395a.isEmpty();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() throws Exception {
            return C4502j.this.f17395a.poll();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            C4502j.this.f17404j = true;
            return 2;
        }
    }

    C4502j(int i2, boolean z) {
        this.f17395a = new C5111c<>(C4601b.m18279a(i2, "capacityHint"));
        this.f17397c = new AtomicReference<>();
        this.f17398d = z;
        this.f17396b = new AtomicReference<>();
        this.f17402h = new AtomicBoolean();
        this.f17403i = new a();
    }

    @InterfaceC4544d
    /* renamed from: V */
    public static <T> C4502j<T> m17365V() {
        return new C4502j<>(AbstractC4469b0.m16521L(), true);
    }

    @InterfaceC4544d
    /* renamed from: a */
    public static <T> C4502j<T> m17366a(int i2, Runnable runnable) {
        return new C4502j<>(i2, runnable, true);
    }

    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: b */
    public static <T> C4502j<T> m17368b(boolean z) {
        return new C4502j<>(AbstractC4469b0.m16521L(), z);
    }

    @InterfaceC4544d
    /* renamed from: i */
    public static <T> C4502j<T> m17369i(int i2) {
        return new C4502j<>(i2, true);
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: O */
    public Throwable mo17291O() {
        if (this.f17400f) {
            return this.f17401g;
        }
        return null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: P */
    public boolean mo17292P() {
        return this.f17400f && this.f17401g == null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: Q */
    public boolean mo17293Q() {
        return this.f17396b.get() != null;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: R */
    public boolean mo17294R() {
        return this.f17400f && this.f17401g != null;
    }

    /* renamed from: T */
    void m17370T() {
        Runnable runnable = this.f17397c.get();
        if (runnable == null || !this.f17397c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    /* renamed from: U */
    void m17371U() {
        if (this.f17403i.getAndIncrement() != 0) {
            return;
        }
        InterfaceC4514i0<? super T> interfaceC4514i0 = this.f17396b.get();
        int i2 = 1;
        while (interfaceC4514i0 == null) {
            i2 = this.f17403i.addAndGet(-i2);
            if (i2 == 0) {
                return;
            } else {
                interfaceC4514i0 = this.f17396b.get();
            }
        }
        if (this.f17404j) {
            m17373f((InterfaceC4514i0) interfaceC4514i0);
        } else {
            m17374g((InterfaceC4514i0) interfaceC4514i0);
        }
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        if (this.f17402h.get() || !this.f17402h.compareAndSet(false, true)) {
            EnumC4593e.error(new IllegalStateException("Only a single observer allowed."), interfaceC4514i0);
            return;
        }
        interfaceC4514i0.onSubscribe(this.f17403i);
        this.f17396b.lazySet(interfaceC4514i0);
        if (this.f17399e) {
            this.f17396b.lazySet(null);
        } else {
            m17371U();
        }
    }

    /* renamed from: f */
    void m17373f(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C5111c<T> c5111c = this.f17395a;
        int i2 = 1;
        boolean z = !this.f17398d;
        while (!this.f17399e) {
            boolean z2 = this.f17400f;
            if (z && z2 && m17372a((InterfaceC4616o) c5111c, (InterfaceC4514i0) interfaceC4514i0)) {
                return;
            }
            interfaceC4514i0.onNext(null);
            if (z2) {
                m17375h((InterfaceC4514i0) interfaceC4514i0);
                return;
            } else {
                i2 = this.f17403i.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            }
        }
        this.f17396b.lazySet(null);
        c5111c.clear();
    }

    /* renamed from: g */
    void m17374g(InterfaceC4514i0<? super T> interfaceC4514i0) {
        C5111c<T> c5111c = this.f17395a;
        boolean z = !this.f17398d;
        boolean z2 = true;
        int i2 = 1;
        while (!this.f17399e) {
            boolean z3 = this.f17400f;
            T poll = this.f17395a.poll();
            boolean z4 = poll == null;
            if (z3) {
                if (z && z2) {
                    if (m17372a((InterfaceC4616o) c5111c, (InterfaceC4514i0) interfaceC4514i0)) {
                        return;
                    } else {
                        z2 = false;
                    }
                }
                if (z4) {
                    m17375h((InterfaceC4514i0) interfaceC4514i0);
                    return;
                }
            }
            if (z4) {
                i2 = this.f17403i.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                interfaceC4514i0.onNext(poll);
            }
        }
        this.f17396b.lazySet(null);
        c5111c.clear();
    }

    /* renamed from: h */
    void m17375h(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f17396b.lazySet(null);
        Throwable th = this.f17401g;
        if (th != null) {
            interfaceC4514i0.onError(th);
        } else {
            interfaceC4514i0.onComplete();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17400f || this.f17399e) {
            return;
        }
        this.f17400f = true;
        m17370T();
        m17371U();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (this.f17400f || this.f17399e) {
            C4476a.m17152b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f17401g = th;
        this.f17400f = true;
        m17370T();
        m17371U();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (this.f17400f || this.f17399e) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.f17395a.offer(t);
            m17371U();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        if (this.f17400f || this.f17399e) {
            interfaceC4552c.dispose();
        }
    }

    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public static <T> C4502j<T> m17367a(int i2, Runnable runnable, boolean z) {
        return new C4502j<>(i2, runnable, z);
    }

    /* renamed from: a */
    boolean m17372a(InterfaceC4616o<T> interfaceC4616o, InterfaceC4514i0<? super T> interfaceC4514i0) {
        Throwable th = this.f17401g;
        if (th == null) {
            return false;
        }
        this.f17396b.lazySet(null);
        interfaceC4616o.clear();
        interfaceC4514i0.onError(th);
        return true;
    }

    C4502j(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    C4502j(int i2, Runnable runnable, boolean z) {
        this.f17395a = new C5111c<>(C4601b.m18279a(i2, "capacityHint"));
        this.f17397c = new AtomicReference<>(C4601b.m18284a(runnable, "onTerminate"));
        this.f17398d = z;
        this.f17396b = new AtomicReference<>();
        this.f17402h = new AtomicBoolean();
        this.f17403i = new a();
    }
}
