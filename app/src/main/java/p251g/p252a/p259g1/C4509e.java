package p251g.p252a.p259g1;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5161a;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SerializedSubscriber.java */
/* renamed from: g.a.g1.e */
/* loaded from: classes2.dex */
public final class C4509e<T> implements InterfaceC4529q<T>, InterfaceC5823d {

    /* renamed from: g */
    static final int f17413g = 4;

    /* renamed from: a */
    final InterfaceC5822c<? super T> f17414a;

    /* renamed from: b */
    final boolean f17415b;

    /* renamed from: c */
    InterfaceC5823d f17416c;

    /* renamed from: d */
    boolean f17417d;

    /* renamed from: e */
    C5161a<Object> f17418e;

    /* renamed from: f */
    volatile boolean f17419f;

    public C4509e(InterfaceC5822c<? super T> interfaceC5822c) {
        this(interfaceC5822c, false);
    }

    /* renamed from: a */
    void m17388a() {
        C5161a<Object> c5161a;
        do {
            synchronized (this) {
                c5161a = this.f17418e;
                if (c5161a == null) {
                    this.f17417d = false;
                    return;
                }
                this.f17418e = null;
            }
        } while (!c5161a.m18604a((InterfaceC5822c) this.f17414a));
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        this.f17416c.cancel();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f17419f) {
            return;
        }
        synchronized (this) {
            if (this.f17419f) {
                return;
            }
            if (!this.f17417d) {
                this.f17419f = true;
                this.f17417d = true;
                this.f17414a.onComplete();
            } else {
                C5161a<Object> c5161a = this.f17418e;
                if (c5161a == null) {
                    c5161a = new C5161a<>(4);
                    this.f17418e = c5161a;
                }
                c5161a.m18601a((C5161a<Object>) EnumC5177q.complete());
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (this.f17419f) {
            C4476a.m17152b(th);
            return;
        }
        synchronized (this) {
            boolean z = true;
            if (!this.f17419f) {
                if (this.f17417d) {
                    this.f17419f = true;
                    C5161a<Object> c5161a = this.f17418e;
                    if (c5161a == null) {
                        c5161a = new C5161a<>(4);
                        this.f17418e = c5161a;
                    }
                    Object error = EnumC5177q.error(th);
                    if (this.f17415b) {
                        c5161a.m18601a((C5161a<Object>) error);
                    } else {
                        c5161a.m18605b(error);
                    }
                    return;
                }
                this.f17419f = true;
                this.f17417d = true;
                z = false;
            }
            if (z) {
                C4476a.m17152b(th);
            } else {
                this.f17414a.onError(th);
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f17419f) {
            return;
        }
        if (t == null) {
            this.f17416c.cancel();
            onError(new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources."));
            return;
        }
        synchronized (this) {
            if (this.f17419f) {
                return;
            }
            if (!this.f17417d) {
                this.f17417d = true;
                this.f17414a.onNext(t);
                m17388a();
            } else {
                C5161a<Object> c5161a = this.f17418e;
                if (c5161a == null) {
                    c5161a = new C5161a<>(4);
                    this.f17418e = c5161a;
                }
                c5161a.m18601a((C5161a<Object>) EnumC5177q.next(t));
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.validate(this.f17416c, interfaceC5823d)) {
            this.f17416c = interfaceC5823d;
            this.f17414a.onSubscribe(this);
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        this.f17416c.request(j2);
    }

    public C4509e(InterfaceC5822c<? super T> interfaceC5822c, boolean z) {
        this.f17414a = interfaceC5822c;
        this.f17415b = z;
    }
}
