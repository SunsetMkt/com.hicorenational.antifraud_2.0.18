package h.a.y0.d;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BasicIntQueueDisposable.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class b<T> extends AtomicInteger implements h.a.y0.c.j<T> {
    private static final long serialVersionUID = -1001730202384742097L;

    @Override // h.a.y0.c.o
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called");
    }

    @Override // h.a.y0.c.o
    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called");
    }
}
