package h.a.y0.j;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: AtomicThrowable.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c extends AtomicReference<Throwable> {
    private static final long serialVersionUID = 3949248817947090603L;

    public boolean addThrowable(Throwable th) {
        return k.a(this, th);
    }

    public boolean isTerminated() {
        return get() == k.a;
    }

    public Throwable terminate() {
        return k.a(this);
    }
}
