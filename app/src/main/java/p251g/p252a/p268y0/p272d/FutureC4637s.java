package p251g.p252a.p268y0.p272d;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4524n0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.C5165e;

/* compiled from: FutureSingleObserver.java */
/* renamed from: g.a.y0.d.s */
/* loaded from: classes2.dex */
public final class FutureC4637s<T> extends CountDownLatch implements InterfaceC4524n0<T>, Future<T>, InterfaceC4552c {

    /* renamed from: a */
    T f17588a;

    /* renamed from: b */
    Throwable f17589b;

    /* renamed from: c */
    final AtomicReference<InterfaceC4552c> f17590c;

    public FutureC4637s() {
        super(1);
        this.f17590c = new AtomicReference<>();
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        InterfaceC4552c interfaceC4552c;
        EnumC4592d enumC4592d;
        do {
            interfaceC4552c = this.f17590c.get();
            if (interfaceC4552c == this || interfaceC4552c == (enumC4592d = EnumC4592d.DISPOSED)) {
                return false;
            }
        } while (!this.f17590c.compareAndSet(interfaceC4552c, enumC4592d));
        if (interfaceC4552c != null) {
            interfaceC4552c.dispose();
        }
        countDown();
        return true;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
    }

    @Override // java.util.concurrent.Future
    public T get() throws InterruptedException, ExecutionException {
        if (getCount() != 0) {
            C5165e.m18612a();
            await();
        }
        if (isCancelled()) {
            throw new CancellationException();
        }
        Throwable th = this.f17589b;
        if (th == null) {
            return this.f17588a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return EnumC4592d.isDisposed(this.f17590c.get());
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return isDone();
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onError(Throwable th) {
        InterfaceC4552c interfaceC4552c;
        do {
            interfaceC4552c = this.f17590c.get();
            if (interfaceC4552c == EnumC4592d.DISPOSED) {
                C4476a.m17152b(th);
                return;
            }
            this.f17589b = th;
        } while (!this.f17590c.compareAndSet(interfaceC4552c, this));
        countDown();
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.setOnce(this.f17590c, interfaceC4552c);
    }

    @Override // p251g.p252a.InterfaceC4524n0
    public void onSuccess(T t) {
        InterfaceC4552c interfaceC4552c = this.f17590c.get();
        if (interfaceC4552c == EnumC4592d.DISPOSED) {
            return;
        }
        this.f17588a = t;
        this.f17590c.compareAndSet(interfaceC4552c, this);
        countDown();
    }

    @Override // java.util.concurrent.Future
    public T get(long j2, TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        if (getCount() != 0) {
            C5165e.m18612a();
            if (!await(j2, timeUnit)) {
                throw new TimeoutException();
            }
        }
        if (!isCancelled()) {
            Throwable th = this.f17589b;
            if (th == null) {
                return this.f17588a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
