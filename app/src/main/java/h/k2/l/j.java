package h.k2.l;

import h.t0;
import h.y1;
import java.util.Collection;
import java.util.Iterator;

/* compiled from: SequenceBuilder.kt */
@h
@t0(version = "1.1")
/* loaded from: classes2.dex */
public abstract class j<T> {
    @i.c.a.e
    public final Object a(@i.c.a.d Iterable<? extends T> iterable, @i.c.a.d c<? super y1> cVar) {
        Object b2;
        if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
            return y1.f16671a;
        }
        Object a2 = a((Iterator) iterable.iterator(), cVar);
        b2 = h.k2.l.n.b.b();
        return a2 == b2 ? a2 : y1.f16671a;
    }

    @i.c.a.e
    public abstract Object a(T t, @i.c.a.d c<? super y1> cVar);

    @i.c.a.e
    public abstract Object a(@i.c.a.d Iterator<? extends T> it, @i.c.a.d c<? super y1> cVar);

    @i.c.a.e
    public final Object a(@i.c.a.d h.x2.m<? extends T> mVar, @i.c.a.d c<? super y1> cVar) {
        Object b2;
        Object a2 = a((Iterator) mVar.iterator(), cVar);
        b2 = h.k2.l.n.b.b();
        return a2 == b2 ? a2 : y1.f16671a;
    }
}
