package p251g.p252a.p268y0.p272d;

import p251g.p252a.InterfaceC4514i0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p263t0.InterfaceC4547g;

/* compiled from: DeferredScalarDisposable.java */
/* renamed from: g.a.y0.d.l */
/* loaded from: classes2.dex */
public class C4630l<T> extends AbstractC4619b<T> {
    static final int DISPOSED = 4;
    static final int FUSED_CONSUMED = 32;
    static final int FUSED_EMPTY = 8;
    static final int FUSED_READY = 16;
    static final int TERMINATED = 2;
    private static final long serialVersionUID = -5502432239815349361L;
    protected final InterfaceC4514i0<? super T> actual;
    protected T value;

    public C4630l(InterfaceC4514i0<? super T> interfaceC4514i0) {
        this.actual = interfaceC4514i0;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final void clear() {
        lazySet(32);
        this.value = null;
    }

    public final void complete(T t) {
        int i2 = get();
        if ((i2 & 54) != 0) {
            return;
        }
        if (i2 == 8) {
            this.value = t;
            lazySet(16);
        } else {
            lazySet(2);
        }
        InterfaceC4514i0<? super T> interfaceC4514i0 = this.actual;
        interfaceC4514i0.onNext(t);
        if (get() != 4) {
            interfaceC4514i0.onComplete();
        }
    }

    public void dispose() {
        set(4);
        this.value = null;
    }

    public final void error(Throwable th) {
        if ((get() & 54) != 0) {
            C4476a.m17152b(th);
        } else {
            lazySet(2);
            this.actual.onError(th);
        }
    }

    @Override // p251g.p252a.p264u0.InterfaceC4552c
    public final boolean isDisposed() {
        return get() == 4;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    public final boolean isEmpty() {
        return get() != 16;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4616o
    @InterfaceC4547g
    public final T poll() throws Exception {
        if (get() != 16) {
            return null;
        }
        T t = this.value;
        this.value = null;
        lazySet(32);
        return t;
    }

    @Override // p251g.p252a.p268y0.p271c.InterfaceC4612k
    public final int requestFusion(int i2) {
        if ((i2 & 2) == 0) {
            return 0;
        }
        lazySet(8);
        return 2;
    }

    public final boolean tryDispose() {
        return getAndSet(4) != 4;
    }

    public final void complete() {
        if ((get() & 54) != 0) {
            return;
        }
        lazySet(2);
        this.actual.onComplete();
    }
}
