package i.x2;

import i.q2.t.i0;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: SequencesJVM.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class a<T> implements m<T> {
    private final AtomicReference<m<T>> a;

    public a(@j.c.a.d m<? extends T> mVar) {
        i0.f(mVar, "sequence");
        this.a = new AtomicReference<>(mVar);
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<T> iterator() {
        m<T> andSet = this.a.getAndSet(null);
        if (andSet != null) {
            return andSet.iterator();
        }
        throw new IllegalStateException("This sequence can be consumed only once.");
    }
}
