package i.h2;

import com.umeng.analytics.pro.bh;
import i.q2.t.i0;
import java.util.Comparator;

/* JADX INFO: compiled from: Comparisons.kt */
/* JADX INFO: loaded from: classes2.dex */
final class e implements Comparator<Comparable<? super Object>> {
    public static final e a = new e();

    private e() {
    }

    @Override // java.util.Comparator
    /* JADX INFO: renamed from: a */
    public int compare(@j.c.a.d Comparable<Object> comparable, @j.c.a.d Comparable<Object> comparable2) {
        i0.f(comparable, bh.ay);
        i0.f(comparable2, "b");
        return comparable.compareTo(comparable2);
    }

    @Override // java.util.Comparator
    @j.c.a.d
    public final Comparator<Comparable<? super Object>> reversed() {
        return f.a;
    }
}
