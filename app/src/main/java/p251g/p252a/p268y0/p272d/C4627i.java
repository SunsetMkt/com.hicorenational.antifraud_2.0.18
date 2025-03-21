package p251g.p252a.p268y0.p272d;

import java.util.Queue;
import java.util.concurrent.atomic.AtomicReference;
import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p264u0.InterfaceC4552c;
import p251g.p252a.p268y0.p269a.EnumC4592d;
import p251g.p252a.p268y0.p284j.EnumC5177q;

/* compiled from: BlockingObserver.java */
/* renamed from: g.a.y0.d.i */
/* loaded from: classes2.dex */
public final class C4627i<T> extends AtomicReference<InterfaceC4552c> implements InterfaceC4514i0<T>, InterfaceC4552c {
    public static final Object TERMINATED = new Object();
    private static final long serialVersionUID = -4875965440900746268L;
    final Queue<Object> queue;

    public C4627i(Queue<Object> queue) {
        this.queue = queue;
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public void dispose() {
        if (EnumC4592d.dispose(this)) {
            this.queue.offer(TERMINATED);
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public boolean isDisposed() {
        return get() == EnumC4592d.DISPOSED;
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onComplete() {
        this.queue.offer(EnumC5177q.complete());
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onError(Throwable th) {
        this.queue.offer(EnumC5177q.error(th));
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onNext(T t) {
        this.queue.offer(EnumC5177q.next(t));
    }

    @Override // p251g.p252a.InterfaceC4514i0
    public void onSubscribe(InterfaceC4552c interfaceC4552c) {
        EnumC4592d.setOnce(this, interfaceC4552c);
    }
}
