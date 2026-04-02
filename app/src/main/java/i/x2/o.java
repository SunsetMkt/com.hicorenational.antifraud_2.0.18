package i.x2;

import i.t0;
import i.y1;
import java.util.Collection;
import java.util.Iterator;

/* JADX INFO: compiled from: SequenceBuilder.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.k2.j
@t0(version = "1.3")
public abstract class o<T> {
    @j.c.a.e
    public final Object a(@j.c.a.d Iterable<? extends T> iterable, @j.c.a.d i.k2.d<? super y1> dVar) {
        Object objA;
        return (!((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) && (objA = a((Iterator) iterable.iterator(), dVar)) == i.k2.m.d.b()) ? objA : y1.a;
    }

    @j.c.a.e
    public abstract Object a(T t, @j.c.a.d i.k2.d<? super y1> dVar);

    @j.c.a.e
    public abstract Object a(@j.c.a.d Iterator<? extends T> it, @j.c.a.d i.k2.d<? super y1> dVar);

    @j.c.a.e
    public final Object a(@j.c.a.d m<? extends T> mVar, @j.c.a.d i.k2.d<? super y1> dVar) {
        Object objA = a((Iterator) mVar.iterator(), dVar);
        return objA == i.k2.m.d.b() ? objA : y1.a;
    }
}
