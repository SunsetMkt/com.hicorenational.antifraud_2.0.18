package i.k2.l;

import i.t0;
import i.y1;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@t0(version = "1.1")
@h
public abstract class j<T> {
    @j.c.a.e
    public final Object a(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d c<? super y1> cVar) {
        Object objA;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (objA = a((Iterator) iterable.iterator(), cVar)) == i.k2.l.n.b.b()) ? objA : y1.a;
    }

    @j.c.a.e
    public abstract Object a(T t, @j.c.a.d c<? super y1> cVar);

    @j.c.a.e
    public abstract Object a(@j.c.a.d Iterator<? extends T> it, @j.c.a.d c<? super y1> cVar);

    @j.c.a.e
    public final Object a(@j.c.a.d i.x2.m<? extends T> mVar, @j.c.a.d c<? super y1> cVar) {
        Object objA = a((Iterator) mVar.iterator(), cVar);
        return objA == i.k2.l.n.b.b() ? objA : y1.a;
    }
}
