package i.z2;

import java.util.SortedSet;
import java.util.TreeSet;

/* JADX INFO: compiled from: _StringsJvm.kt */
/* JADX INFO: loaded from: classes2.dex */
class d0 extends c0 {
    @i.m2.f
    private static final char c(@j.c.a.d CharSequence charSequence, int i2) {
        return charSequence.charAt(i2);
    }

    @j.c.a.d
    public static final SortedSet<Character> d(@j.c.a.d CharSequence charSequence) {
        i.q2.t.i0.f(charSequence, "$this$toSortedSet");
        return (SortedSet) e0.a(charSequence, new TreeSet());
    }
}
