package h.g2;

import java.util.List;

/* loaded from: classes2.dex */
public final class w extends g0 {
    private w() {
    }

    public static /* bridge */ /* synthetic */ <T> T C(@i.c.a.d Iterable<? extends T> iterable) {
        return (T) g0.C(iterable);
    }

    public static /* bridge */ /* synthetic */ Appendable a(Iterable iterable, Appendable appendable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i2, CharSequence charSequence4, h.q2.s.l lVar, int i3, Object obj) {
        Appendable a2;
        a2 = g0.a(iterable, appendable, (r14 & 2) != 0 ? ", " : charSequence, (r14 & 4) != 0 ? "" : charSequence2, (r14 & 8) == 0 ? charSequence3 : "", (r14 & 16) != 0 ? -1 : i2, (r14 & 32) != 0 ? "..." : charSequence4, (r14 & 64) != 0 ? null : lVar);
        return a2;
    }

    public static /* bridge */ /* synthetic */ <T> T r(@i.c.a.d List<? extends T> list) {
        return (T) g0.r((List) list);
    }

    @i.c.a.e
    public static /* bridge */ /* synthetic */ <T extends Comparable<? super T>> T y(@i.c.a.d Iterable<? extends T> iterable) {
        return (T) g0.y(iterable);
    }
}
