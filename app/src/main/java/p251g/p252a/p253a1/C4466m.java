package p251g.p252a.p253a1;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4546f;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.C5161a;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: SerializedObserver.java */
/* renamed from: g.a.a1.m */
/* loaded from: classes2.dex */
public final class C4466m<T> implements InterfaceC4514i0<T>, InterfaceC4552c {

    /* renamed from: g */
    static final int f17219g = 4;

    /* renamed from: a */
    final InterfaceC4514i0<? super T> f17220a;

    /* renamed from: b */
    final boolean f17221b;

    /* renamed from: c */
    InterfaceC4552c f17222c;

    /* renamed from: d */
    boolean f17223d;

    /* renamed from: e */
    C5161a<Object> f17224e;

    /* renamed from: f */
    volatile boolean f17225f;

    public C4466m(@InterfaceC4546f InterfaceC4514i0<? super T> interfaceC4514i0) {
        this(interfaceC4514i0, false);
    }

    /* renamed from: a */
    void m16510a() {
        C5161a<Object> c5161a;
        do {
            synchronized (this) {
                c5161a = this.f17224e;
                if (c5161a == null) {
                    this.f17223d = false;
                    return;
                }
                this.f17224e = null;
            }
        } while (!c5161a.m18603a((InterfaceC4514i0) this.f17220a));
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        this.f17222c.dispose();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return this.f17222c.isDisposed();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17225f) {
            return;
        }
        synchronized (this) {
            if (this.f17225f) {
                return;
            }
            if (!this.f17223d) {
                this.f17225f = true;
                this.f17223d = true;
                this.f17220a.onComplete();
            } else {
                C5161a<Object> c5161a = this.f17224e;
                if (c5161a == null) {
                    c5161a = new C5161a<>(4);
                    this.f17224e = c5161a;
                }
                c5161a.m18601a((C5161a<Object>) EnumC5177q.complete());
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(@InterfaceC4546f Throwable th) {
        if (this.f17225f) {
            C4476a.m17152b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f17225f) {
                if (this.f17223d) {
                    this.f17225f = true;
                    C5161a<Object> c5161a = this.f17224e;
                    if (c5161a == null) {
                        c5161a = new C5161a<>(4);
                        this.f17224e = c5161a;
                    }
                    Object error = EnumC5177q.error(th);
                    if (this.f17221b) {
                        c5161a.m18601a((C5161a<Object>) error);
                    } else {
                        c5161a.m18605b(error);
                    }
                    return;
                }
                this.f17225f = true;
                this.f17223d = true;
                z = false;
            }
            if (z) {
                C4476a.m17152b(th);
            } else {
                this.f17220a.onError(th);
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(@InterfaceC4546f T t) {
        if (this.f17225f) {
            return;
        }
        if (t == null) {
            this.f17222c.dispose();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f17225f) {
                return;
            }
            if (!this.f17223d) {
                this.f17223d = true;
                this.f17220a.onNext(t);
                m16510a();
            } else {
                C5161a<Object> c5161a = this.f17224e;
                if (c5161a == null) {
                    c5161a = new C5161a<>(4);
                    this.f17224e = c5161a;
                }
                c5161a.m18601a((C5161a<Object>) EnumC5177q.next(t));
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(@InterfaceC4546f InterfaceC4552c interfaceC4552c) {
        if (EnumC4592d.validate(this.f17222c, interfaceC4552c)) {
            this.f17222c = interfaceC4552c;
            this.f17220a.onSubscribe(this);
        }
    }

    public C4466m(@InterfaceC4546f InterfaceC4514i0<? super T> interfaceC4514i0, boolean z) {
        this.f17220a = interfaceC4514i0;
        this.f17221b = z;
    }
}
