package p251g.p252a.p268y0.p272d;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import p251g.p252a.InterfaceC4491f;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.InterfaceC4559v;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: BlockingMultiObserver.java */
/* renamed from: g.a.y0.d.h */
/* loaded from: classes2.dex */
public final class C4626h<T> extends CountDownLatch implements InterfaceC4524n0<T>, InterfaceC4491f, InterfaceC4559v<T> {

    /* renamed from: a */
    T f17574a;

    /* renamed from: b */
    Throwable f17575b;

    /* renamed from: c */
    InterfaceC4552c f17576c;

    /* renamed from: d */
    volatile boolean f17577d;

    public C4626h() {
        super(1);
    }

    /* renamed from: a */
    public T m18294a() {
        if (getCount() != 0) {
            try {
                C5165e.m18612a();
                await();
            } catch (InterruptedException e2) {
                m18299c();
                throw C5171k.m18626c(e2);
            }
        }
        Throwable th = this.f17575b;
        if (th == null) {
            return this.f17574a;
        }
        throw C5171k.m18626c(th);
    }

    /* renamed from: b */
    public Throwable m18297b() {
        if (getCount() != 0) {
            try {
                C5165e.m18612a();
                await();
            } catch (InterruptedException e2) {
                m18299c();
                return e2;
            }
        }
        return this.f17575b;
    }

    /* renamed from: c */
    void m18299c() {
        this.f17577d = true;
        InterfaceC4552c interfaceC4552c = this.f17576c;
        if (interfaceC4552c != null) {
            interfaceC4552c.dispose();
        }
    }

    @Override // p251g.p252a.InterfaceC4491f
    public void onComplete() {
        countDown();
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onError(Throwable th) {
        this.f17575b = th;
        countDown();
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        this.f17576c = interfaceC4552c;
        if (this.f17577d) {
            interfaceC4552c.dispose();
        }
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        this.f17574a = t;
        countDown();
    }

    /* renamed from: b */
    public Throwable m18298b(long j2, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                C5165e.m18612a();
                if (!await(j2, timeUnit)) {
                    m18299c();
                    throw C5171k.m18626c(new TimeoutException());
                }
            } catch (InterruptedException e2) {
                m18299c();
                throw C5171k.m18626c(e2);
            }
        }
        return this.f17575b;
    }

    /* renamed from: a */
    public T m18295a(T t) {
        if (getCount() != 0) {
            try {
                C5165e.m18612a();
                await();
            } catch (InterruptedException e2) {
                m18299c();
                throw C5171k.m18626c(e2);
            }
        }
        Throwable th = this.f17575b;
        if (th == null) {
            T t2 = this.f17574a;
            return t2 != null ? t2 : t;
        }
        throw C5171k.m18626c(th);
    }

    /* renamed from: a */
    public boolean m18296a(long j2, TimeUnit timeUnit) {
        if (getCount() != 0) {
            try {
                C5165e.m18612a();
                if (!await(j2, timeUnit)) {
                    m18299c();
                    return false;
                }
            } catch (InterruptedException e2) {
                m18299c();
                throw C5171k.m18626c(e2);
            }
        }
        Throwable th = this.f17575b;
        if (th == null) {
            return true;
        }
        throw C5171k.m18626c(th);
    }
}
