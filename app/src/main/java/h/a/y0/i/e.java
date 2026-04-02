package h.a.y0.i;

import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: BooleanSubscription.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e extends AtomicBoolean implements j.d.d {
    private static final long serialVersionUID = -8127758972444290902L;

    @Override // j.d.d
    public void cancel() {
        lazySet(true);
    }

    public boolean isCancelled() {
        return get();
    }

    @Override // j.d.d
    public void request(long j2) {
        j.validate(j2);
    }

    @Override // java.util.concurrent.atomic.AtomicBoolean
    public String toString() {
        return "BooleanSubscription(cancelled=" + get() + ")";
    }
}
