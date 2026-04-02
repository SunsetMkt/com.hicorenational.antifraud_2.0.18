package i.g2;

import java.util.List;

/* JADX INFO: compiled from: ReversedViews.kt */
/* JADX INFO: loaded from: classes2.dex */
class i1<T> extends d<T> {
    private final List<T> a;

    /* JADX WARN: Multi-variable type inference failed */
    public i1(@j.c.a.d List<? extends T> list) {
        i.q2.t.i0.f(list, "delegate");
        this.a = list;
    }

    @Override // i.g2.d, java.util.List
    public T get(int i2) {
        return this.a.get(e0.c((List<?>) this, i2));
    }

    @Override // i.g2.d, i.g2.a
    public int getSize() {
        return this.a.size();
    }
}
