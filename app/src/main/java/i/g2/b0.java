package i.g2;

import java.util.Iterator;

/* JADX INFO: compiled from: Iterators.kt */
/* JADX INFO: loaded from: classes2.dex */
class b0 extends a0 {
    /* JADX WARN: Multi-variable type inference failed */
    @i.m2.f
    private static final <T> Iterator<T> a(@j.c.a.d Iterator<? extends T> it) {
        i.q2.t.i0.f(it, "$this$iterator");
        return it;
    }

    public static final <T> void a(@j.c.a.d Iterator<? extends T> it, @j.c.a.d i.q2.s.l<? super T, i.y1> lVar) {
        i.q2.t.i0.f(it, "$this$forEach");
        i.q2.t.i0.f(lVar, "operation");
        while (it.hasNext()) {
            lVar.invoke(it.next());
        }
    }

    @j.c.a.d
    public static final <T> Iterator<r0<T>> b(@j.c.a.d Iterator<? extends T> it) {
        i.q2.t.i0.f(it, "$this$withIndex");
        return new t0(it);
    }
}
