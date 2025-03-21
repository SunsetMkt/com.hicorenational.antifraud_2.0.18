package p251g.p252a.p258f1;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p284j.C5161a;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: SerializedSubject.java */
/* renamed from: g.a.f1.g */
/* loaded from: classes2.dex */
final class C4499g<T> extends AbstractC4501i<T> implements C5161a.a<Object> {

    /* renamed from: a */
    final AbstractC4501i<T> f17385a;

    /* renamed from: b */
    boolean f17386b;

    /* renamed from: c */
    C5161a<Object> f17387c;

    /* renamed from: d */
    volatile boolean f17388d;

    C4499g(AbstractC4501i<T> abstractC4501i) {
        this.f17385a = abstractC4501i;
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: O */
    public Throwable mo17291O() {
        return this.f17385a.mo17291O();
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: P */
    public boolean mo17292P() {
        return this.f17385a.mo17292P();
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: Q */
    public boolean mo17293Q() {
        return this.f17385a.mo17293Q();
    }

    @Override // p251g.p252a.p258f1.AbstractC4501i
    /* renamed from: R */
    public boolean mo17294R() {
        return this.f17385a.mo17294R();
    }

    /* renamed from: T */
    void m17353T() {
        C5161a<Object> c5161a;
        while (true) {
            synchronized (this) {
                c5161a = this.f17387c;
                if (c5161a == null) {
                    this.f17386b = false;
                    return;
                }
                this.f17387c = null;
            }
            c5161a.m18600a((C5161a.a<? super Object>) this);
        }
    }

    @Override // p251g.p252a.AbstractC4469b0
    /* renamed from: d */
    protected void mo16855d(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.f17385a.subscribe(interfaceC4514i0);
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        if (this.f17388d) {
            return;
        }
        synchronized (this) {
            if (this.f17388d) {
                return;
            }
            this.f17388d = true;
            if (!this.f17386b) {
                this.f17386b = true;
                this.f17385a.onComplete();
                return;
            }
            C5161a<Object> c5161a = this.f17387c;
            if (c5161a == null) {
                c5161a = new C5161a<>(4);
                this.f17387c = c5161a;
            }
            c5161a.m18601a((C5161a<Object>) EnumC5177q.complete());
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        boolean z;
        if (this.f17388d) {
            C4476a.m17152b(th);
            return;
        }
        synchronized (this) {
            if (this.f17388d) {
                z = true;
            } else {
                this.f17388d = true;
                if (this.f17386b) {
                    C5161a<Object> c5161a = this.f17387c;
                    if (c5161a == null) {
                        c5161a = new C5161a<>(4);
                        this.f17387c = c5161a;
                    }
                    c5161a.m18605b(EnumC5177q.error(th));
                    return;
                }
                z = false;
                this.f17386b = true;
            }
            if (z) {
                C4476a.m17152b(th);
            } else {
                this.f17385a.onError(th);
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        if (this.f17388d) {
            return;
        }
        synchronized (this) {
            if (this.f17388d) {
                return;
            }
            if (!this.f17386b) {
                this.f17386b = true;
                this.f17385a.onNext(t);
                m17353T();
            } else {
                C5161a<Object> c5161a = this.f17387c;
                if (c5161a == null) {
                    c5161a = new C5161a<>(4);
                    this.f17387c = c5161a;
                }
                c5161a.m18601a((C5161a<Object>) EnumC5177q.next(t));
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        boolean z = true;
        if (!this.f17388d) {
            synchronized (this) {
                if (!this.f17388d) {
                    if (this.f17386b) {
                        C5161a<Object> c5161a = this.f17387c;
                        if (c5161a == null) {
                            c5161a = new C5161a<>(4);
                            this.f17387c = c5161a;
                        }
                        c5161a.m18601a((C5161a<Object>) EnumC5177q.disposable(interfaceC4552c));
                        return;
                    }
                    this.f17386b = true;
                    z = false;
                }
            }
        }
        if (z) {
            interfaceC4552c.dispose();
        } else {
            this.f17385a.onSubscribe(interfaceC4552c);
            m17353T();
        }
    }

    @Override // p251g.p252a.p268y0.p284j.C5161a.a, p251g.p252a.p267x0.InterfaceC4587r
    public boolean test(Object obj) {
        return EnumC5177q.acceptFull(obj, this.f17385a);
    }
}
