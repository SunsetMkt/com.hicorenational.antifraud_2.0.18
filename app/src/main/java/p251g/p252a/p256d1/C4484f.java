package p251g.p252a.p256d1;

import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p284j.C5161a;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SerializedProcessor.java */
/* renamed from: g.a.d1.f */
/* loaded from: classes2.dex */
final class C4484f<T> extends AbstractC4481c<T> {

    /* renamed from: b */
    final AbstractC4481c<T> f17303b;

    /* renamed from: c */
    boolean f17304c;

    /* renamed from: d */
    C5161a<Object> f17305d;

    /* renamed from: e */
    volatile boolean f17306e;

    C4484f(AbstractC4481c<T> abstractC4481c) {
        this.f17303b = abstractC4481c;
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: T */
    public Throwable mo17205T() {
        return this.f17303b.mo17205T();
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: U */
    public boolean mo17206U() {
        return this.f17303b.mo17206U();
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: V */
    public boolean mo17207V() {
        return this.f17303b.mo17207V();
    }

    @Override // p251g.p252a.p256d1.AbstractC4481c
    /* renamed from: W */
    public boolean mo17208W() {
        return this.f17303b.mo17208W();
    }

    /* renamed from: Y */
    void m17255Y() {
        C5161a<Object> c5161a;
        while (true) {
            synchronized (this) {
                c5161a = this.f17305d;
                if (c5161a == null) {
                    this.f17304c = false;
                    return;
                }
                this.f17305d = null;
            }
            c5161a.m18604a((InterfaceC5822c) this.f17303b);
        }
    }

    @Override // p251g.p252a.AbstractC4519l
    /* renamed from: d */
    protected void mo17216d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17303b.subscribe(interfaceC5822c);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f17306e) {
            return;
        }
        synchronized (this) {
            if (this.f17306e) {
                return;
            }
            this.f17306e = true;
            if (!this.f17304c) {
                this.f17304c = true;
                this.f17303b.onComplete();
                return;
            }
            C5161a<Object> c5161a = this.f17305d;
            if (c5161a == null) {
                c5161a = new C5161a<>(4);
                this.f17305d = c5161a;
            }
            c5161a.m18601a((C5161a<Object>) EnumC5177q.complete());
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        boolean z;
        if (this.f17306e) {
            C4476a.m17152b(th);
            return;
        }
        synchronized (this) {
            if (this.f17306e) {
                z = true;
            } else {
                this.f17306e = true;
                if (this.f17304c) {
                    C5161a<Object> c5161a = this.f17305d;
                    if (c5161a == null) {
                        c5161a = new C5161a<>(4);
                        this.f17305d = c5161a;
                    }
                    c5161a.m18605b(EnumC5177q.error(th));
                    return;
                }
                z = false;
                this.f17304c = true;
            }
            if (z) {
                C4476a.m17152b(th);
            } else {
                this.f17303b.onError(th);
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f17306e) {
            return;
        }
        synchronized (this) {
            if (this.f17306e) {
                return;
            }
            if (!this.f17304c) {
                this.f17304c = true;
                this.f17303b.onNext(t);
                m17255Y();
            } else {
                C5161a<Object> c5161a = this.f17305d;
                if (c5161a == null) {
                    c5161a = new C5161a<>(4);
                    this.f17305d = c5161a;
                }
                c5161a.m18601a((C5161a<Object>) EnumC5177q.next(t));
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5822c, p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        boolean z = true;
        if (!this.f17306e) {
            synchronized (this) {
                if (!this.f17306e) {
                    if (this.f17304c) {
                        C5161a<Object> c5161a = this.f17305d;
                        if (c5161a == null) {
                            c5161a = new C5161a<>(4);
                            this.f17305d = c5161a;
                        }
                        c5161a.m18601a((C5161a<Object>) EnumC5177q.subscription(interfaceC5823d));
                        return;
                    }
                    this.f17304c = true;
                    z = false;
                }
            }
        }
        if (z) {
            interfaceC5823d.cancel();
        } else {
            this.f17303b.onSubscribe(interfaceC5823d);
            m17255Y();
        }
    }
}
