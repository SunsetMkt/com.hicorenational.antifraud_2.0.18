package p251g.p252a.p268y0.p282h;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.C5163c;
import p251g.p252a.p268y0.p284j.C5172l;
import p324i.p338d.InterfaceC5822c;
import p324i.p338d.InterfaceC5823d;

/* compiled from: StrictSubscriber.java */
/* renamed from: g.a.y0.h.t */
/* loaded from: classes2.dex */
public class C5149t<T> extends AtomicInteger implements InterfaceC4529q<T>, InterfaceC5823d {
    private static final long serialVersionUID = -4945028590049415624L;
    final InterfaceC5822c<? super T> actual;
    volatile boolean done;
    final C5163c error = new C5163c();
    final AtomicLong requested = new AtomicLong();

    /* renamed from: s */
    final AtomicReference<InterfaceC5823d> f20019s = new AtomicReference<>();
    final AtomicBoolean once = new AtomicBoolean();

    public C5149t(InterfaceC5822c<? super T> interfaceC5822c) {
        this.actual = interfaceC5822c;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        if (this.done) {
            return;
        }
        EnumC5160j.cancel(this.f20019s);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        this.done = true;
        C5172l.m18632a(this.actual, this, this.error);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        this.done = true;
        C5172l.m18631a((InterfaceC5822c<?>) this.actual, th, (AtomicInteger) this, this.error);
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        C5172l.m18630a(this.actual, t, this, this.error);
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (this.once.compareAndSet(false, true)) {
            this.actual.onSubscribe(this);
            EnumC5160j.deferredSetOnce(this.f20019s, this.requested, interfaceC5823d);
        } else {
            interfaceC5823d.cancel();
            cancel();
            onError(new IllegalStateException("§2.12 violated: onSubscribe must be called at most once"));
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        if (j2 > 0) {
            EnumC5160j.deferredRequest(this.f20019s, this.requested, j2);
            return;
        }
        cancel();
        onError(new IllegalArgumentException("§3.9 violated: positive request amount required but it was " + j2));
    }
}
