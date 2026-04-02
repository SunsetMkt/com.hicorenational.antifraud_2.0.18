package h.a.y0.j;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: MergerBiFunction.java */
/* JADX INFO: loaded from: classes2.dex */
public final class p<T> implements h.a.x0.c<List<T>, List<T>, List<T>> {
    final Comparator<? super T> a;

    public p(Comparator<? super T> comparator) {
        this.a = comparator;
    }

    /* JADX WARN: Code restructure failed: missing block: B:36:0x0037, code lost:
    
        r3 = null;
     */
    @Override // h.a.x0.c
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public List<T> apply(List<T> list, List<T> list2) throws Exception {
        T next;
        int size = list.size() + list2.size();
        if (size == 0) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList(size);
        Iterator<T> it = list.iterator();
        Iterator<T> it2 = list2.iterator();
        T next2 = it.hasNext() ? it.next() : null;
        if (it2.hasNext()) {
            next = it2.next();
            while (next2 != null && next != null) {
                if (this.a.compare(next2, next) < 0) {
                    arrayList.add(next2);
                    next2 = it.hasNext() ? it.next() : null;
                } else {
                    arrayList.add(next);
                    if (it2.hasNext()) {
                        next = it2.next();
                    }
                }
            }
            if (next2 != null) {
                arrayList.add(next2);
                while (it.hasNext()) {
                    arrayList.add(it.next());
                }
            } else if (next != null) {
                arrayList.add(next);
                while (it2.hasNext()) {
                    arrayList.add(it2.next());
                }
            }
            return arrayList;
        }
        next = null;
    }
}
