package p251g.p252a.p259g1;

import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p265v0.C4560a;
import p251g.p252a.p265v0.C4561b;
import p251g.p252a.p268y0.p283i.EnumC5157g;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: SafeSubscriber.java */
/* renamed from: g.a.g1.d */
/* loaded from: classes2.dex */
public final class C4508d<T> implements InterfaceC4529q<T>, InterfaceC5823d {

    /* renamed from: a */
    final InterfaceC5822c<? super T> f17410a;

    /* renamed from: b */
    InterfaceC5823d f17411b;

    /* renamed from: c */
    boolean f17412c;

    public C4508d(InterfaceC5822c<? super T> interfaceC5822c) {
        this.f17410a = interfaceC5822c;
    }

    /* renamed from: a */
    void m17386a() {
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17410a.onSubscribe(EnumC5157g.INSTANCE);
            try {
                this.f17410a.onError(nullPointerException);
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
    void m17387b() {
        this.f17412c = true;
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17410a.onSubscribe(EnumC5157g.INSTANCE);
            try {
                this.f17410a.onError(nullPointerException);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                C4476a.m17152b(new C4560a(nullPointerException, th));
            }
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            C4476a.m17152b(new C4560a(nullPointerException, th2));
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        try {
            this.f17411b.cancel();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        if (this.f17412c) {
            return;
        }
        this.f17412c = true;
        if (this.f17411b == null) {
            m17386a();
            return;
        }
        try {
            this.f17410a.onComplete();
        } catch (Throwable th) {
            C4561b.m18199b(th);
            C4476a.m17152b(th);
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        if (this.f17412c) {
            C4476a.m17152b(th);
            return;
        }
        this.f17412c = true;
        if (this.f17411b != null) {
            if (th == null) {
                th = new NullPointerException("onError called with null. Null values are generally not allowed in 2.x operators and sources.");
            }
            try {
                this.f17410a.onError(th);
                return;
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                C4476a.m17152b(new C4560a(th, th2));
                return;
            }
        }
        NullPointerException nullPointerException = new NullPointerException("Subscription not set!");
        try {
            this.f17410a.onSubscribe(EnumC5157g.INSTANCE);
            try {
                this.f17410a.onError(new C4560a(th, nullPointerException));
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                C4476a.m17152b(new C4560a(th, nullPointerException, th3));
            }
        } catch (Throwable th4) {
            C4561b.m18199b(th4);
            C4476a.m17152b(new C4560a(th, nullPointerException, th4));
        }
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f17412c) {
            return;
        }
        if (this.f17411b == null) {
            m17387b();
            return;
        }
        if (t == null) {
            NullPointerException nullPointerException = new NullPointerException("onNext called with null. Null values are generally not allowed in 2.x operators and sources.");
            try {
                this.f17411b.cancel();
                onError(nullPointerException);
                return;
            } catch (Throwable th) {
                C4561b.m18199b(th);
                onError(new C4560a(nullPointerException, th));
                return;
            }
        }
        try {
            this.f17410a.onNext(t);
        } catch (Throwable th2) {
            C4561b.m18199b(th2);
            try {
                this.f17411b.cancel();
                onError(th2);
            } catch (Throwable th3) {
                C4561b.m18199b(th3);
                onError(new C4560a(th2, th3));
            }
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.validate(this.f17411b, interfaceC5823d)) {
            this.f17411b = interfaceC5823d;
            try {
                this.f17410a.onSubscribe(this);
            } catch (Throwable th) {
                C4561b.m18199b(th);
                this.f17412c = true;
                try {
                    interfaceC5823d.cancel();
                    C4476a.m17152b(th);
                } catch (Throwable th2) {
                    C4561b.m18199b(th2);
                    C4476a.m17152b(new C4560a(th, th2));
                }
            }
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        try {
            this.f17411b.request(j2);
        } catch (Throwable th) {
            C4561b.m18199b(th);
            try {
                this.f17411b.cancel();
                C4476a.m17152b(th);
            } catch (Throwable th2) {
                C4561b.m18199b(th2);
                C4476a.m17152b(new C4560a(th, th2));
            }
        }
    }
}
