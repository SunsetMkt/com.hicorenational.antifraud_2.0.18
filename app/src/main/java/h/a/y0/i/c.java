package h.a.y0.i;

import h.a.y0.c.l;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: BasicIntQueueSubscription.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class c<T> extends AtomicInteger implements l<T> {
    private static final long serialVersionUID = -6671519529404341862L;

    @Override // h.a.y0.c.o
    public final boolean offer(T t) {
        throw new UnsupportedOperationException("Should not be called!");
    }

    @Override // h.a.y0.c.o
    public final boolean offer(T t, T t2) {
        throw new UnsupportedOperationException("Should not be called!");
    }
}
