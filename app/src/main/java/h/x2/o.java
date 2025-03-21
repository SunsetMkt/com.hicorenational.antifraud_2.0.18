package h.x2;

import h.t0;
import h.y1;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: SequenceBuilder.kt */
@t0(version = "1.3")
@h.k2.j
/* loaded from: classes2.dex */
public abstract class o<T> {
    @i.c.a.e
    public final Object a(@i.c.a.d Iterable<? extends T> iterable, @i.c.a.d h.k2.d<? super y1> dVar) {
        Object b2;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return y1.f16671a;
        }
        Object a2 = a((Iterator) iterable.iterator(), dVar);
        b2 = h.k2.m.d.b();
        return a2 == b2 ? a2 : y1.f16671a;
    }

    @i.c.a.e
    public abstract Object a(T t, @i.c.a.d h.k2.d<? super y1> dVar);

    @i.c.a.e
    public abstract Object a(@i.c.a.d Iterator<? extends T> it, @i.c.a.d h.k2.d<? super y1> dVar);

    @i.c.a.e
    public final Object a(@i.c.a.d m<? extends T> mVar, @i.c.a.d h.k2.d<? super y1> dVar) {
        Object b2;
        Object a2 = a((Iterator) mVar.iterator(), dVar);
        b2 = h.k2.m.d.b();
        return a2 == b2 ? a2 : y1.f16671a;
    }
}
