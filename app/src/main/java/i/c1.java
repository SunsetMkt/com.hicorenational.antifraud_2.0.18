package i;

import java.util.List;

/* JADX INFO: compiled from: Tuples.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.q2.e(name = "TuplesKt")
public final class c1 {
    @j.c.a.d
    public static final <A, B> i0<A, B> a(A a, B b2) {
        return new i0<>(a, b2);
    }

    @j.c.a.d
    public static final <T> List<T> a(@j.c.a.d i0<? extends T, ? extends T> i0Var) {
        i.q2.t.i0.f(i0Var, "$this$toList");
        return i.g2.y.c(i0Var.getFirst(), i0Var.getSecond());
    }

    @j.c.a.d
    public static final <T> List<T> a(@j.c.a.d b1<? extends T, ? extends T, ? extends T> b1Var) {
        i.q2.t.i0.f(b1Var, "$this$toList");
        return i.g2.y.c(b1Var.getFirst(), b1Var.getSecond(), b1Var.getThird());
    }
}
