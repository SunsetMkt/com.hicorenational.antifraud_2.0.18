package p251g.p252a.p268y0.p269a;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p280f.C5111c;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: ObserverFullArbiter.java */
/* renamed from: g.a.y0.a.j */
/* loaded from: classes2.dex */
public final class C4598j<T> extends C4595g implements InterfaceC4552c {

    /* renamed from: F */
    final InterfaceC4514i0<? super T> f17508F;

    /* renamed from: G */
    final C5111c<Object> f17509G;

    /* renamed from: H */
    volatile InterfaceC4552c f17510H = EnumC4593e.INSTANCE;

    /* renamed from: I */
    InterfaceC4552c f17511I;

    /* renamed from: J */
    volatile boolean f17512J;

    public C4598j(InterfaceC4514i0<? super T> interfaceC4514i0, InterfaceC4552c interfaceC4552c, int i2) {
        this.f17508F = interfaceC4514i0;
        this.f17511I = interfaceC4552c;
        this.f17509G = new C5111c<>(i2);
    }

    /* renamed from: a */
    void m18223a() {
        InterfaceC4552c interfaceC4552c = this.f17511I;
        this.f17511I = null;
        if (interfaceC4552c != null) {
            interfaceC4552c.dispose();
        }
    }

    /* renamed from: b */
    public boolean m18228b(InterfaceC4552c interfaceC4552c) {
        if (this.f17512J) {
            return false;
        }
        this.f17509G.offer(this.f17510H, EnumC5177q.disposable(interfaceC4552c));
        m18227b();
        return true;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        if (this.f17512J) {
            return;
        }
        this.f17512J = true;
        m18223a();
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        InterfaceC4552c interfaceC4552c = this.f17511I;
        return interfaceC4552c != null ? interfaceC4552c.isDisposed() : this.f17512J;
    }

    /* renamed from: a */
    public boolean m18226a(T t, InterfaceC4552c interfaceC4552c) {
        if (this.f17512J) {
            return false;
        }
        this.f17509G.offer(interfaceC4552c, EnumC5177q.next(t));
        m18227b();
        return true;
    }

    /* renamed from: b */
    void m18227b() {
        if (this.f17505p.getAndIncrement() != 0) {
            return;
        }
        C5111c<Object> c5111c = this.f17509G;
        InterfaceC4514i0<? super T> interfaceC4514i0 = this.f17508F;
        int i2 = 1;
        while (true) {
            Object poll = c5111c.poll();
            if (poll == null) {
                i2 = this.f17505p.addAndGet(-i2);
                if (i2 == 0) {
                    return;
                }
            } else {
                Object poll2 = c5111c.poll();
                if (poll == this.f17510H) {
                    if (EnumC5177q.isDisposable(poll2)) {
                        InterfaceC4552c disposable = EnumC5177q.getDisposable(poll2);
                        this.f17510H.dispose();
                        if (!this.f17512J) {
                            this.f17510H = disposable;
                        } else {
                            disposable.dispose();
                        }
                    } else if (EnumC5177q.isError(poll2)) {
                        c5111c.clear();
                        m18223a();
                        Throwable error = EnumC5177q.getError(poll2);
                        if (!this.f17512J) {
                            this.f17512J = true;
                            interfaceC4514i0.onError(error);
                        } else {
                            C4476a.m17152b(error);
                        }
                    } else if (EnumC5177q.isComplete(poll2)) {
                        c5111c.clear();
                        m18223a();
                        if (!this.f17512J) {
                            this.f17512J = true;
                            interfaceC4514i0.onComplete();
                        }
                    } else {
                        interfaceC4514i0.onNext((Object) EnumC5177q.getValue(poll2));
                    }
                }
            }
        }
    }

    /* renamed from: a */
    public void m18225a(Throwable th, InterfaceC4552c interfaceC4552c) {
        if (this.f17512J) {
            C4476a.m17152b(th);
        } else {
            this.f17509G.offer(interfaceC4552c, EnumC5177q.error(th));
            m18227b();
        }
    }

    /* renamed from: a */
    public void m18224a(InterfaceC4552c interfaceC4552c) {
        this.f17509G.offer(interfaceC4552c, EnumC5177q.complete());
        m18227b();
    }
}
