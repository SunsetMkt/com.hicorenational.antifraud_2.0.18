package p251g.p252a.p268y0.p283i;

import java.util.concurrent.atomic.AtomicInteger;
import p251g.p252a.p263t0.InterfaceC4547g;
import p251g.p252a.p268y0.p271c.InterfaceC4613l;
import p324i.p338d.InterfaceC5822c;

/* compiled from: ScalarSubscription.java */
/* renamed from: g.a.y0.i.h */
/* loaded from: classes2.dex */
public final class C5158h<T> extends AtomicInteger implements InterfaceC4613l<T> {
    static final int CANCELLED = 2;
    static final int NO_REQUEST = 0;
    static final int REQUESTED = 1;
    private static final long serialVersionUID = -3830916580126663321L;
    final InterfaceC5822c<? super T> subscriber;
    final T value;

    public C5158h(InterfaceC5822c<? super T> interfaceC5822c, T t) {
        this.subscriber = interfaceC5822c;
        this.value = t;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void cancel() {
        lazySet(2);
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public void clear() {
        lazySet(1);
    }

    public boolean isCancelled() {
        return get() == 2;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean isEmpty() {
        return get() != 0;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    @InterfaceC4547g
    public T poll() {
        if (get() != 0) {
            return null;
        }
        lazySet(1);
        return this.value;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public void request(long j2) {
        if (EnumC5160j.validate(j2) && compareAndSet(0, 1)) {
            InterfaceC5822c<? super T> interfaceC5822c = this.subscriber;
            interfaceC5822c.onNext(this.value);
            if (get() != 2) {
                interfaceC5822c.onComplete();
            }
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
    public int requestFusion(int i2) {
        return i2 & 1;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
