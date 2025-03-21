package p251g.p252a.p268y0.p283i;

import p251g.p252a.p263t0.InterfaceC4547g;
import p324i.p338d.InterfaceC5822c;

/* compiled from: DeferredScalarSubscription.java */
/* renamed from: g.a.y0.i.f */
/* loaded from: classes2.dex */
public class C5156f<T> extends AbstractC5153c<T> {
    static final int CANCELLED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int HAS_REQUEST_HAS_VALUE = 3;
    static final int HAS_REQUEST_NO_VALUE = 2;
    static final int NO_REQUEST_HAS_VALUE = 1;
    static final int NO_REQUEST_NO_VALUE = 0;
    private static final long serialVersionUID = -2151279923272604993L;
    protected final InterfaceC5822c<? super T> actual;
    protected T value;

    public C5156f(InterfaceC5822c<? super T> interfaceC5822c) {
        this.actual = interfaceC5822c;
    }

    public void cancel() {
        set(4);
        this.value = null;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i2 = get();
        while (i2 != 8) {
            if ((i2 & (-3)) != 0) {
                return;
            }
            if (i2 == 2) {
                lazySet(3);
                InterfaceC5822c<? super T> interfaceC5822c = this.actual;
                interfaceC5822c.onNext(t);
                if (get() != 4) {
                    interfaceC5822c.onComplete();
                    return;
                }
                return;
            }
            this.value = t;
            if (compareAndSet(0, 1)) {
                return;
            }
            i2 = get();
            if (i2 == 4) {
                this.value = null;
                return;
            }
        }
        this.value = t;
        lazySet(16);
        InterfaceC5822c<? super T> interfaceC5822c2 = this.actual;
        interfaceC5822c2.onNext(t);
        if (get() != 4) {
            interfaceC5822c2.onComplete();
        }
    }

    public final boolean isCancelled() {
        return get() == 4;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    @InterfaceC4547g
    public final T poll() {
        if (get() != 16) {
            return null;
        }
        lazySet(32);
        T t = this.value;
        this.value = null;
        return t;
    }

    @Override // p324i.p338d.InterfaceC5823d
    public final void request(long j2) {
        T t;
        if (EnumC5160j.validate(j2)) {
            do {
                int i2 = get();
                if ((i2 & (-2)) != 0) {
                    return;
                }
                if (i2 == 1) {
                    if (!compareAndSet(1, 3) || (t = this.value) == null) {
                        return;
                    }
                    this.value = null;
                    InterfaceC5822c<? super T> interfaceC5822c = this.actual;
                    interfaceC5822c.onNext(t);
                    if (get() != 4) {
                        interfaceC5822c.onComplete();
                        return;
                    }
                    return;
                }
            } while (!compareAndSet(0, 2));
        }
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
    public final int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryCancel() {
        return getAndSet(4) != 4;
    }
}
