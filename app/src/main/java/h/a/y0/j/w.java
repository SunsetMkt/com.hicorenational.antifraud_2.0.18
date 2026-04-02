package h.a.y0.j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/* JADX INFO: compiled from: SorterFunction.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w<T> implements h.a.x0.o<List<T>, List<T>> {
    final Comparator<? super T> a;

    public w(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    @Override // h.a.x0.o
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.a);
        return list;
    }
}
