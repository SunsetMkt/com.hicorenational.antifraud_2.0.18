package p251g.p252a.p268y0.p284j;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import p251g.p252a.p267x0.InterfaceC4584o;

/* compiled from: SorterFunction.java */
/* renamed from: g.a.y0.j.w */
/* loaded from: classes2.dex */
public final class C5183w<T> implements InterfaceC4584o<List<T>, List<T>> {

    /* renamed from: a */
    final Comparator<? super T> f20052a;

    public C5183w(Comparator<? super T> comparator) {
        this.f20052a = comparator;
    }

    @Override // p251g.p252a.p267x0.InterfaceC4584o
    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public List<T> apply(List<T> list) throws Exception {
        Collections.sort(list, this.f20052a);
        return list;
    }
}
