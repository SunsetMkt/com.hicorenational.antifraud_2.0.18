package p251g.p252a.p268y0.p282h;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4529q;
import p251g.p252a.p268y0.p283i.EnumC5160j;
import p251g.p252a.p268y0.p284j.EnumC5177q;
import p324i.p338d.InterfaceC5823d;

/* compiled from: BlockingSubscriber.java */
/* renamed from: g.a.y0.h.f */
/* loaded from: classes2.dex */
public final class C5135f<T> extends AtomicReference<InterfaceC5823d> implements InterfaceC4529q<T>, InterfaceC5823d {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public C5135f(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        if (EnumC5160j.cancel(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    public boolean isCancelled() {
        return get() == EnumC5160j.CANCELLED;
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onComplete() {
        this.queue.offer(EnumC5177q.complete());
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onError(Throwable th) {
        this.queue.offer(EnumC5177q.error(th));
    }

    @Override // p324i.p338d.InterfaceC5822c
    public void onNext(T t) {
        this.queue.offer(EnumC5177q.next(t));
    }

    @Override // p251g.p252a.InterfaceC4529q
    public void onSubscribe(InterfaceC5823d interfaceC5823d) {
        if (EnumC5160j.setOnce(this, interfaceC5823d)) {
            this.queue.offer(EnumC5177q.subscription(this));
        }
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        get().request(j2);
    }
}
