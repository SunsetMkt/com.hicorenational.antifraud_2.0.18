package p251g.p252a.p253a1;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p269a.EnumC4593e;

/* compiled from: SafeObserver.java */
/* renamed from: g.a.a1.l */
/* loaded from: classes2.dex */
public final class C4465l<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

    /* renamed from: a */
    final InterfaceC4514i0<? super T> f17216a;

    /* renamed from: b */
    InterfaceC4552c f17217b;

    /* renamed from: c */
    boolean f17218c;

    public C4465l(@InterfaceC4546f InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f17216a = interfaceC4514i0;
    }

    /* renamed from: a */
    void m16508a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17216a.onSubscribe(EnumC4593e.INSTANCE);
            try {
                this.f17216a.onError(nullPointerException);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(new C4560a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(nullPointerException, th2));
        }
    }

    /* renamed from: b */
    void m16509b() {
        this.f17218c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17216a.onSubscribe(EnumC4593e.INSTANCE);
            try {
                this.f17216a.onError(nullPointerException);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(new C4560a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(nullPointerException, th2));
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        this.f17217b.dispose();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f17217b.isDisposed();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17218c) {
            return;
        }
        this.f17218c = true;
        if (this.f17217b == null) {
            m16508a();
            return;
        }
        try {
            this.f17216a.onComplete();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(@InterfaceC4546f Throwable th) {
        if (this.f17218c) {
            C4476a.m17152b(th);
            return;
        }
        this.f17218c = true;
        if (this.f17217b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f17216a.onError(th);
                return;
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                C4476a.m17152b(new C4560a(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17216a.onSubscribe(EnumC4593e.INSTANCE);
            try {
                this.f17216a.onError(new C4560a(th, nullPointerException));
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                C4476a.m17152b(new C4560a(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            C4561b.m18199b(th4);
            C4476a.m17152b(new C4560a(th, nullPointerException, th4));
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(@InterfaceC4546f T t) {
        if (this.f17218c) {
            return;
        }
        if (this.f17217b == null) {
            m16509b();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f17217b.dispose();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                C4561b.m18199b(th);
                onError(new C4560a(nullPointerException, th));
                return;
            }
        }
        try {
            this.f17216a.onNext(t);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            try {
                this.f17217b.dispose();
                onError(th2);
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                onError(new C4560a(th2, th3));
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.validate(this.f17217b, interfaceC4552c)) {
            this.f17217b = interfaceC4552c;
            try {
                this.f17216a.onSubscribe(this);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17218c = true;
                try {
                    interfaceC4552c.dispose();
                    C4476a.m17152b(th);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    C4476a.m17152b(new C4560a(th, th2));
                }
            }
        }
    }
}
