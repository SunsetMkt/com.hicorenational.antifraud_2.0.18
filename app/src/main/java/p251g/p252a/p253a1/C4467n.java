package p251g.p252a.p253a1;

import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p267x0.InterfaceC4576g;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p271c.InterfaceC4611j;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: TestObserver.java */
/* renamed from: g.a.a1.n */
/* loaded from: classes2.dex */
public class C4467n<T> extends AbstractC4454a<T, C4467n<T>> implements InterfaceC4514i0<T>, InterfaceC4552c, InterfaceC4559v<T>, InterfaceC4524n0<T>, InterfaceC4491f {

    /* renamed from: k */
    private final InterfaceC4514i0<? super T> f17226k;

    /* renamed from: l */
    private final AtomicReference<InterfaceC4552c> f17227l;

    /* renamed from: m */
    private InterfaceC4611j<T> f17228m;

    /* compiled from: TestObserver.java */
    /* renamed from: g.a.a1.n$a */
    enum a implements InterfaceC4514i0<Object> {
        INSTANCE;

        @Override // p251g.p252a.InterfaceC4514i0
        public void onComplete() {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onError(Throwable th) {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onNext(Object obj) {
        }

        @Override // p251g.p252a.InterfaceC4514i0
        public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        }
    }

    public C4467n() {
        this(a.INSTANCE);
    }

    /* renamed from: B */
    public static <T> C4467n<T> m16511B() {
        return new C4467n<>();
    }

    /* renamed from: a */
    public static <T> C4467n<T> m16512a(InterfaceC4514i0<? super T> interfaceC4514i0) {
        return new C4467n<>(interfaceC4514i0);
    }

    /* renamed from: e */
    static String m16513e(int i2) {
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
    public final boolean m16514A() {
        return isDisposed();
    }

    /* renamed from: c */
    final C4467n<T> m16516c(int i2) {
        int i3 = this.f17199h;
        if (i3 == i2) {
            return this;
        }
        if (this.f17228m == null) {
            throw m16469b("Upstream is not fuseable");
        }
        throw new AssertionError("Fusion mode different. Expected: " + m16513e(i2) + ", actual: " + m16513e(i3));
    }

    public final void cancel() {
        dispose();
    }

    /* renamed from: d */
    final C4467n<T> m16517d(int i2) {
        this.f17198g = i2;
        return this;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        EnumC4592d.dispose(this.f17227l);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return EnumC4592d.isDisposed(this.f17227l.get());
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (!this.f17197f) {
            this.f17197f = true;
            if (this.f17227l.get() == null) {
                this.f17194c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17196e = Thread.currentThread();
            this.f17195d++;
            this.f17226k.onComplete();
        } finally {
            this.f17192a.countDown();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        if (!this.f17197f) {
            this.f17197f = true;
            if (this.f17227l.get() == null) {
                this.f17194c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        try {
            this.f17196e = Thread.currentThread();
            if (th == null) {
                this.f17194c.add(new NullPointerException("onError received a null Throwable"));
            } else {
                this.f17194c.add(th);
            }
            this.f17226k.onError(th);
        } finally {
            this.f17192a.countDown();
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (!this.f17197f) {
            this.f17197f = true;
            if (this.f17227l.get() == null) {
                this.f17194c.add(new IllegalStateException("onSubscribe not called in proper order"));
            }
        }
        this.f17196e = Thread.currentThread();
        if (this.f17199h != 2) {
            this.f17193b.add(t);
            if (t == null) {
                this.f17194c.add(new NullPointerException("onNext received a null value"));
            }
            this.f17226k.onNext(t);
            return;
        }
        while (true) {
            try {
                T poll = this.f17228m.poll();
                if (poll == null) {
                    return;
                } else {
                    this.f17193b.add(poll);
                }
            } catch (Throwable th) {
                this.f17194c.add(th);
                this.f17228m.dispose();
                return;
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        this.f17196e = Thread.currentThread();
        if (interfaceC4552c == null) {
            this.f17194c.add(new NullPointerException("onSubscribe received a null Subscription"));
            return;
        }
        if (!this.f17227l.compareAndSet(null, interfaceC4552c)) {
            interfaceC4552c.dispose();
            if (this.f17227l.get() != EnumC4592d.DISPOSED) {
                this.f17194c.add(new IllegalStateException("onSubscribe received multiple subscriptions: " + interfaceC4552c));
                return;
            }
            return;
        }
        int i2 = this.f17198g;
        if (i2 != 0 && (interfaceC4552c instanceof InterfaceC4611j)) {
            this.f17228m = (InterfaceC4611j) interfaceC4552c;
            int requestFusion = this.f17228m.requestFusion(i2);
            this.f17199h = requestFusion;
            if (requestFusion == 1) {
                this.f17197f = true;
                this.f17196e = Thread.currentThread();
                while (true) {
                    try {
                        T poll = this.f17228m.poll();
                        if (poll == null) {
                            this.f17195d++;
                            this.f17227l.lazySet(EnumC4592d.DISPOSED);
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
        this.f17226k.onSubscribe(interfaceC4552c);
    }

    @Override // p251g.p252a.InterfaceC4559v, p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        onNext(t);
        onComplete();
    }

    /* renamed from: x */
    final C4467n<T> m16518x() {
        if (this.f17228m != null) {
            return this;
        }
        throw new AssertionError("Upstream is not fuseable.");
    }

    /* renamed from: y */
    final C4467n<T> m16519y() {
        if (this.f17228m == null) {
            return this;
        }
        throw new AssertionError("Upstream is fuseable.");
    }

    /* renamed from: z */
    public final boolean m16520z() {
        return this.f17227l.get() != null;
    }

    public C4467n(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f17227l = new AtomicReference<>();
        this.f17226k = interfaceC4514i0;
    }

    /* renamed from: a */
    public final C4467n<T> m16515a(InterfaceC4576g<? super C4467n<T>> interfaceC4576g) {
        try {
            interfaceC4576g.accept(this);
            return this;
        } catch (Throwable th) {
            throw C5171k.m18626c(th);
        }
    }

    @Override // p251g.p252a.p253a1.AbstractC4454a
    /* renamed from: g */
    public final C4467n<T> mo16477g() {
        if (this.f17227l.get() != null) {
            throw m16469b("Subscribed!");
        }
        if (this.f17194c.isEmpty()) {
            return this;
        }
        throw m16469b("Not subscribed but errors found");
    }

    @Override // p251g.p252a.p253a1.AbstractC4454a
    /* renamed from: i */
    public final C4467n<T> mo16479i() {
        if (this.f17227l.get() != null) {
            return this;
        }
        throw m16469b("Not subscribed!");
    }
}
