package p251g.p252a.p268y0.p282h;

import java.util.NoSuchElementException;
import java.util.concurrent.CancellationException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5165e;
import p286h.p309q2.p311t.C5556m0;
import p324i.p338d.InterfaceC5823d;

/* compiled from: FutureSubscriber.java */
/* renamed from: g.a.y0.h.i */
/* loaded from: classes2.dex */
public final class FutureC5138i<T> extends CountDownLatch implements InterfaceC4529q<T>, Future<T>, InterfaceC5823d {

    /* renamed from: a */
    T f19963a;

    /* renamed from: b */
    Throwable f19964b;

    /* renamed from: c */
    final AtomicReference<InterfaceC5823d> f19965c;

    public FutureC5138i() {
        super(1);
        this.f19965c = new AtomicReference<>();
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
    }

    @Override // java.util.concurrent.Future
    public boolean cancel(boolean z) {
        InterfaceC5823d interfaceC5823d;
        EnumC5160j enumC5160j;
        do {
            interfaceC5823d = this.f19965c.get();
            if (interfaceC5823d == this || interfaceC5823d == (enumC5160j = EnumC5160j.CANCELLED)) {
                return false;
            }
        } while (!this.f19965c.compareAndSet(interfaceC5823d, enumC5160j));
        if (interfaceC5823d != null) {
            interfaceC5823d.cancel();
        }
        countDown();
        return true;
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
        Throwable th = this.f19964b;
        if (th == null) {
            return this.f19963a;
        }
        throw new ExecutionException(th);
    }

    @Override // java.util.concurrent.Future
    public boolean isCancelled() {
        return EnumC5160j.isCancelled(this.f19965c.get());
    }

    @Override // java.util.concurrent.Future
    public boolean isDone() {
        return getCount() == 0;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        InterfaceC5823d interfaceC5823d;
        if (this.f19963a == null) {
            onError(new NoSuchElementException("The source is empty"));
            return;
        }
        do {
            interfaceC5823d = this.f19965c.get();
            if (interfaceC5823d == this || interfaceC5823d == EnumC5160j.CANCELLED) {
                return;
            }
        } while (!this.f19965c.compareAndSet(interfaceC5823d, this));
        countDown();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        InterfaceC5823d interfaceC5823d;
        do {
            interfaceC5823d = this.f19965c.get();
            if (interfaceC5823d == this || interfaceC5823d == EnumC5160j.CANCELLED) {
                C4476a.m17152b(th);
                return;
            }
            this.f19964b = th;
        } while (!this.f19965c.compareAndSet(interfaceC5823d, this));
        countDown();
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        if (this.f19963a == null) {
            this.f19963a = t;
        } else {
            this.f19965c.get().cancel();
            onError(new IndexOutOfBoundsException("More than one element received"));
        }
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.setOnce(this.f19965c, interfaceC5823d)) {
            interfaceC5823d.request(C5556m0.f20396b);
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
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
            Throwable th = this.f19964b;
            if (th == null) {
                return this.f19963a;
            }
            throw new ExecutionException(th);
        }
        throw new CancellationException();
    }
}
