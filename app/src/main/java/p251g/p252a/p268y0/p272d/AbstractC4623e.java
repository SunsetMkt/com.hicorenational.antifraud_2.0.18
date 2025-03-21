package p251g.p252a.p268y0.p272d;

import java.util.concurrent.CountDownLatch;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p284j.C5165e;
import p251g.p252a.p268y0.p284j.C5171k;

/* compiled from: BlockingBaseObserver.java */
/* renamed from: g.a.y0.d.e */
/* loaded from: classes2.dex */
public abstract class AbstractC4623e<T> extends CountDownLatch implements InterfaceC4514i0<T>, InterfaceC4552c {

    /* renamed from: a */
    T f17570a;

    /* renamed from: b */
    Throwable f17571b;

    /* renamed from: c */
    InterfaceC4552c f17572c;

    /* renamed from: d */
    volatile boolean f17573d;

    public AbstractC4623e() {
        super(1);
    }

    /* renamed from: a */
    public final T m18293a() {
        if (getCount() != 0) {
            try {
                C5165e.m18612a();
                await();
            } catch (InterruptedException e2) {
                dispose();
                throw C5171k.m18626c(e2);
            }
        }
        Throwable th = this.f17571b;
        if (th == null) {
            return this.f17570a;
        }
        throw C5171k.m18626c(th);
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final void dispose() {
        this.f17573d = true;
        InterfaceC4552c interfaceC4552c = this.f17572c;
        if (interfaceC4552c != null) {
            interfaceC4552c.dispose();
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return this.f17573d;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onComplete() {
        countDown();
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public final void onSubscribe(InterfaceC4552c interfaceC4552c) {
        this.f17572c = interfaceC4552c;
        if (this.f17573d) {
            interfaceC4552c.dispose();
        }
    }
}
