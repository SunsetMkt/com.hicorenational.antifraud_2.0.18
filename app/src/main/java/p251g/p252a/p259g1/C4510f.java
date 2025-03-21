package p251g.p252a.p259g1;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p253a1.AbstractC4454a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5171k;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: TestSubscriber.java */
/* renamed from: g.a.g1.f */
/* loaded from: classes2.dex */
public class C4510f<T> extends AbstractC4454a<T, C4510f<T>> implements InterfaceC4529q<T>, InterfaceC5823d, InterfaceC4552c {

    /* renamed from: k */
    private final InterfaceC5822c<? super T> f17420k;

    /* renamed from: l */
    private volatile boolean f17421l;

    /* renamed from: m */
    private final AtomicReference<InterfaceC5823d> f17422m;

    /* renamed from: n */
    private final AtomicLong f17423n;

    /* renamed from: o */
    private InterfaceC4613l<T> f17424o;

    /* compiled from: TestSubscriber.java */
    /* renamed from: g.a.g1.f$a */
    enum a implements InterfaceC4529q<Object> {
        INSTANCE;

        @Override // p324i.p338d.InterfaceC5822c
        public void onComplete() {
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onError(Throwable th) {
        }

        @Override // p324i.p338d.InterfaceC5822c
        public void onNext(Object obj) {
        }

        @Override // p251g.p252a.InterfaceC4529q
        public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        }
    }

    public C4510f() {
        this(a.INSTANCE, C5556m0.f20396b);
    }

    /* renamed from: C */
    public static <T> C4510f<T> m17389C() {
        return new C4510f<>();
    }

    /* renamed from: a */
    public static <T> C4510f<T> m17390a(InterfaceC5822c<? super T> interfaceC5822c) {
        return new C4510f<>(interfaceC5822c);
    }

    /* renamed from: b */
    public static <T> C4510f<T> m17391b(long j2) {
        return new C4510f<>(j2);
    }

    /* renamed from: e */
    static String m17392e(int i2) {
        if (i2 == 0) {
            return "NONE";
        }
        if (i2 == 1) {
            return "SYNC";
        }
        if (i2 == 2) {
            return "ASYNC";
        }
        return "Unknown(" + i2 + ")";
    }

    /* renamed from: A */
    public final boolean m17393A() {
        return this.f17421l;
    }

    /* renamed from: B */
    protected void m17394B() {
    }

    /* renamed from: c */
    final C4510f<T> m17397c(int i2) {
        int i3 = this.f17199h;
        if (i3 == i2) {
            return this;
        }
        if (this.f17424o == null) {
            throw m16469b("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + m17392e(i2) + ", actual: " + m17392e(i3));
    }

    @Override // p324i.p338d.InterfaceC5823d
    public final void cancel() {
        if (this.f17421l) {
            return;
        }
        this.f17421l = true;
        EnumC5160j.cancel(this.f17422m);
    }

    /* renamed from: d */
    final C4510f<T> m17398d(int i2) {
        this.f17198g = i2;
        return this;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        cancel();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return this.f17421l;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (!this.f17197f) {
            this.f17197f = true;
            if (this.f17422m.get() == null) {
                this.f17194c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17196e = Thread.currentThread();
            this.f17195d++;
            this.f17420k.onComplete();
        } finally {
            this.f17192a.countDown();
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (!this.f17197f) {
            this.f17197f = true;
            if (this.f17422m.get() == null) {
                this.f17194c.add(new NullPointerException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17196e = Thread.currentThread();
            this.f17194c.add(th);
            if (th == null) {
                this.f17194c.add(new IllegalStateException("onError received a null Throwable"));
            }
            this.f17420k.onError(th);
        } finally {
            this.f17192a.countDown();
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (!this.f17197f) {
            this.f17197f = true;
            if (this.f17422m.get() == null) {
                this.f17194c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f17196e = Thread.currentThread();
        if (this.f17199h != 2) {
            this.f17193b.add(t);
            if (t == null) {
                this.f17194c.add(new NullPointerException("onNext received a null value"));
            }
            this.f17420k.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.f17424o.poll();
                if (poll == null) {
                    return;
                } else {
                    this.f17193b.add(poll);
                }
            } catch (Throwable th) {
                this.f17194c.add(th);
                this.f17424o.cancel();
                return;
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        this.f17196e = Thread.currentThread();
        if (interfaceC5823d == null) {
            this.f17194c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f17422m.compareAndSet(null, interfaceC5823d)) {
            interfaceC5823d.cancel();
            if (this.f17422m.get() != EnumC5160j.CANCELLED) {
                this.f17194c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + interfaceC5823d));
                return;
            }
            return;
        }
        int i2 = this.f17198g;
        if (i2 != 0 && (interfaceC5823d instanceof InterfaceC4613l)) {
            this.f17424o = (InterfaceC4613l) interfaceC5823d;
            int requestFusion = this.f17424o.requestFusion(i2);
            this.f17199h = requestFusion;
            if (requestFusion == 1) {
                this.f17197f = true;
                this.f17196e = Thread.currentThread();
                while (true) {
                    try {
                        T poll = this.f17424o.poll();
                        if (poll == null) {
                            this.f17195d++;
                            return;
                        }
                        this.f17193b.add(poll);
                    } catch (Throwable th) {
                        this.f17194c.add(th);
                        return;
                    }
                }
            }
        }
        this.f17420k.onSubscribe(interfaceC5823d);
        long andSet = this.f17423n.getAndSet(0L);
        if (andSet != 0) {
            interfaceC5823d.request(andSet);
        }
        m17394B();
    }

    @Override // p324i.p338d.InterfaceC5823d
    public final void request(long j2) {
        EnumC5160j.deferredRequest(this.f17422m, this.f17423n, j2);
    }

    /* renamed from: x */
    final C4510f<T> m17399x() {
        if (this.f17424o != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    /* renamed from: y */
    final C4510f<T> m17400y() {
        if (this.f17424o == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    /* renamed from: z */
    public final boolean m17401z() {
        return this.f17422m.get() != null;
    }

    public C4510f(long j2) {
        this(a.INSTANCE, j2);
    }

    /* renamed from: a */
    public final C4510f<T> m17396a(InterfaceC4576g<? super C4510f<T>> interfaceC4576g) {
        try {
            interfaceC4576g.accept(this);
            return this;
        } catch (Throwable th) {
            throw C5171k.m18626c(th);
        }
    }

    @Override // p251g.p252a.p253a1.AbstractC4454a
    /* renamed from: g */
    public final C4510f<T> mo16477g() {
        if (this.f17422m.get() != null) {
            throw m16469b("Subscribed!");
        }
        if (this.f17194c.isEmpty()) {
            return this;
        }
        throw m16469b("Not subscribed but errors found");
    }

    @Override // p251g.p252a.p253a1.AbstractC4454a
    /* renamed from: i */
    public final C4510f<T> mo16479i() {
        if (this.f17422m.get() != null) {
            return this;
        }
        throw m16469b("Not subscribed!");
    }

    public C4510f(InterfaceC5822c<? super T> interfaceC5822c) {
        this(interfaceC5822c, C5556m0.f20396b);
    }

    public C4510f(InterfaceC5822c<? super T> interfaceC5822c, long j2) {
        if (j2 >= 0) {
            this.f17420k = interfaceC5822c;
            this.f17422m = new AtomicReference<>();
            this.f17423n = new AtomicLong(j2);
            return;
        }
        throw new IllegalArgumentException("Negative initial request not allowed");
    }

    /* renamed from: a */
    public final C4510f<T> m17395a(long j2) {
        request(j2);
        return this;
    }
}
