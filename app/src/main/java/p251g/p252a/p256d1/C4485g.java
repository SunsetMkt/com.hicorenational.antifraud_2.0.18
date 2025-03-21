package p251g.p252a.p256d1;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.AbstractC4519l;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4544d;
import p251g.p252a.p263t0.InterfaceC4545e;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p270b.C4601b;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p283i.AbstractC5153c;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5164d;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: UnicastProcessor.java */
/* renamed from: g.a.d1.g */
/* loaded from: classes2.dex */
public final class C4485g<T> extends AbstractC4481c<T> {

    /* renamed from: b */
    final C5111c<T> f17307b;

    /* renamed from: c */
    final AtomicReference<Runnable> f17308c;

    /* renamed from: d */
    final boolean f17309d;

    /* renamed from: e */
    volatile boolean f17310e;

    /* renamed from: f */
    Throwable f17311f;

    /* renamed from: g */
    final AtomicReference<InterfaceC5822c<? super T>> f17312g;

    /* renamed from: h */
    volatile boolean f17313h;

    /* renamed from: i */
    final AtomicBoolean f17314i;

    /* renamed from: j */
    final AbstractC5153c<T> f17315j;

    /* renamed from: k */
    final AtomicLong f17316k;

    /* renamed from: l */
    boolean f17317l;

    /* compiled from: UnicastProcessor.java */
    /* renamed from: g.a.d1.g$a */
    final class a extends AbstractC5153c<T> {
        private static final long serialVersionUID = -4896760517184205454L;

        a() {
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void cancel() {
            if (C4485g.this.f17313h) {
                return;
            }
            C4485g c4485g = C4485g.this;
            c4485g.f17313h = true;
            c4485g.m17261Y();
            C4485g c4485g2 = C4485g.this;
            if (c4485g2.f17317l || c4485g2.f17315j.getAndIncrement() != 0) {
                return;
            }
            C4485g.this.f17307b.clear();
            C4485g.this.f17312g.lazySet(null);
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public void clear() {
            C4485g.this.f17307b.clear();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        public boolean isEmpty() {
            return C4485g.this.f17307b.isEmpty();
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
        @InterfaceC4547g
        public T poll() {
            return C4485g.this.f17307b.poll();
        }

        @Override // p324i.p338d.InterfaceC5823d
        public void request(long j2) {
            if (EnumC5160j.validate(j2)) {
                C5164d.m18607a(C4485g.this.f17316k, j2);
                C4485g.this.m17262Z();
            }
        }

        @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
        public int requestFusion(int i2) {
            if ((i2 & 2) == 0) {
                return 0;
            }
            C4485g.this.f17317l = true;
            return 2;
        }
    }

    C4485g(int i2) {
        this(i2, null, true);
    }

    @InterfaceC4544d
    /* renamed from: a */
    public static <T> C4485g<T> m17256a(int i2, Runnable runnable) {
        C4601b.m18284a(runnable, "onTerminate");
        return new C4485g<>(i2, runnable);
    }

    @InterfaceC4544d
    /* renamed from: a0 */
    public static <T> C4485g<T> m17258a0() {
        return new C4485g<>(AbstractC4519l.m17539Q());
    }

    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: b */
    public static <T> C4485g<T> m17259b(boolean z) {
        return new C4485g<>(AbstractC4519l.m17539Q(), null, z);
    }

    @InterfaceC4544d
    /* renamed from: m */
    public static <T> C4485g<T> m17260m(int i2) {
        return new C4485g<>(i2);
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: T */
    public Throwable mo17205T() {
        if (this.f17310e) {
            return this.f17311f;
        }
        return null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: U */
    public boolean mo17206U() {
        return this.f17310e && this.f17311f == null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: V */
    public boolean mo17207V() {
        return this.f17312g.get() != null;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: W */
    public boolean mo17208W() {
        return this.f17310e && this.f17311f != null;
    }

    /* renamed from: Y */
    void m17261Y() {
        Runnable runnable = this.f17308c.get();
        if (runnable == null || !this.f17308c.compareAndSet(runnable, null)) {
            return;
        }
        runnable.run();
    }

    /* renamed from: Z */
    void m17262Z() {
        if (this.f17315j.getAndIncrement() != 0) {
            return;
        }
        int i2 = 1;
        InterfaceC5822c<? super T> interfaceC5822c = this.f17312g.get();
        while (interfaceC5822c == null) {
            i2 = this.f17315j.addAndGet(-i2);
            if (i2 == 0) {
                return;
            } else {
                interfaceC5822c = this.f17312g.get();
            }
        }
        if (this.f17317l) {
            m17264f((InterfaceC5822c) interfaceC5822c);
        } else {
            m17265g((InterfaceC5822c) interfaceC5822c);
        }
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        if (this.f17314i.get() || !this.f17314i.compareAndSet(false, true)) {
            EnumC5157g.error(new IllegalStateException("This processor allows only a single Subscriber"), interfaceC5822c);
            return;
        }
        interfaceC5822c.onSubscribe(this.f17315j);
        this.f17312g.set(interfaceC5822c);
        if (this.f17313h) {
            this.f17312g.lazySet(null);
        } else {
            m17262Z();
        }
    }

    /* renamed from: f */
    void m17264f(InterfaceC5822c<? super T> interfaceC5822c) {
        C5111c<T> c5111c = this.f17307b;
        int i2 = 1;
        boolean z = !this.f17309d;
        while (!this.f17313h) {
            boolean z2 = this.f17310e;
            if (z && z2 && this.f17311f != null) {
                c5111c.clear();
                this.f17312g.lazySet(null);
                interfaceC5822c.onError(this.f17311f);
                return;
            }
            interfaceC5822c.onNext(null);
            if (z2) {
                this.f17312g.lazySet(null);
                Throwable th = this.f17311f;
                if (th != null) {
                    interfaceC5822c.onError(th);
                    return;
                } else {
                    interfaceC5822c.onComplete();
                    return;
                }
            }
            i2 = this.f17315j.addAndGet(-i2);
            if (i2 == 0) {
                return;
            }
        }
        c5111c.clear();
        this.f17312g.lazySet(null);
    }

    /* renamed from: g */
    void m17265g(InterfaceC5822c<? super T> interfaceC5822c) {
        long j2;
        C5111c<T> c5111c = this.f17307b;
        boolean z = !this.f17309d;
        int i2 = 1;
        do {
            long j3 = this.f17316k.get();
            long j4 = 0;
            while (true) {
                if (j3 == j4) {
                    j2 = j4;
                    break;
                }
                boolean z2 = this.f17310e;
                T poll = c5111c.poll();
                boolean z3 = poll == null;
                j2 = j4;
                if (m17263a(z, z2, z3, interfaceC5822c, c5111c)) {
                    return;
                }
                if (z3) {
                    break;
                }
                interfaceC5822c.onNext(poll);
                j4 = 1 + j2;
            }
            if (j3 == j4 && m17263a(z, this.f17310e, c5111c.isEmpty(), interfaceC5822c, c5111c)) {
                return;
            }
            if (j2 != 0 && j3 != C5556m0.f20396b) {
                this.f17316k.addAndGet(-j2);
            }
            i2 = this.f17315j.addAndGet(-i2);
        } while (i2 != 0);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f17310e || this.f17313h) {
            return;
        }
        this.f17310e = true;
        m17261Y();
        m17262Z();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (this.f17310e || this.f17313h) {
            C4476a.m17152b(th);
            return;
        }
        if (th == null) {
            th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
        }
        this.f17311f = th;
        this.f17310e = true;
        m17261Y();
        m17262Z();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f17310e || this.f17313h) {
            return;
        }
        if (t == null) {
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
        } else {
            this.f17307b.offer(t);
            m17262Z();
        }
    }

    @Override // p324i.p338d.InterfaceC5822c, p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (this.f17310e || this.f17313h) {
            interfaceC5823d.cancel();
        } else {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }

    C4485g(int i2, Runnable runnable) {
        this(i2, runnable, true);
    }

    C4485g(int i2, Runnable runnable, boolean z) {
        this.f17307b = new C5111c<>(C4601b.m18279a(i2, "capacityHint"));
        this.f17308c = new AtomicReference<>(runnable);
        this.f17309d = z;
        this.f17312g = new AtomicReference<>();
        this.f17314i = new AtomicBoolean();
        this.f17315j = new a();
        this.f17316k = new AtomicLong();
    }

    @InterfaceC4545e
    @InterfaceC4544d
    /* renamed from: a */
    public static <T> C4485g<T> m17257a(int i2, Runnable runnable, boolean z) {
        C4601b.m18284a(runnable, "onTerminate");
        return new C4485g<>(i2, runnable, z);
    }

    /* renamed from: a */
    boolean m17263a(boolean z, boolean z2, boolean z3, InterfaceC5822c<? super T> interfaceC5822c, C5111c<T> c5111c) {
        if (this.f17313h) {
            c5111c.clear();
            this.f17312g.lazySet(null);
            return true;
        }
        if (!z2) {
            return false;
        }
        if (z && this.f17311f != null) {
            c5111c.clear();
            this.f17312g.lazySet(null);
            interfaceC5822c.onError(this.f17311f);
            return true;
        }
        if (!z3) {
            return false;
        }
        Throwable th = this.f17311f;
        this.f17312g.lazySet(null);
        if (th != null) {
            interfaceC5822c.onError(th);
        } else {
            interfaceC5822c.onComplete();
        }
        return true;
    }
}
