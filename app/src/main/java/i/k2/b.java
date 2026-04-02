package i.k2;

import i.k2.g;
import i.k2.g.b;
import i.q2.s.l;
import i.q2.t.i0;
import i.t0;

/* JADX INFO: compiled from: CoroutineContextImpl.kt */
/* JADX INFO: loaded from: classes2.dex */
@i.j
@t0(version = "1.3")
public abstract class b<B extends g.b, E extends B> implements g.c<E> {
    private final g.c<?> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final l<g.b, E> f12119b;

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v1, types: [i.k2.g$c<?>] */
    /* JADX WARN: Type inference failed for: r2v5 */
    /* JADX WARN: Type inference failed for: r2v6 */
    /* JADX WARN: Type inference failed for: r3v0, types: [i.q2.s.l<? super i.k2.g$b, ? extends E extends B>, i.q2.s.l<i.k2.g$b, E extends B>, java.lang.Object] */
    public b(@j.c.a.d g.c<B> cVar, @j.c.a.d l<? super g.b, ? extends E> lVar) {
        i0.f(cVar, "baseKey");
        i0.f(lVar, "safeCast");
        this.f12119b = lVar;
        this.a = cVar instanceof b ? (g.c<B>) ((b) cVar).a : cVar;
    }

    /* JADX WARN: Incorrect return type in method signature: (Li/k2/g$b;)TE; */
    @j.c.a.e
    public final g.b a(@j.c.a.d g.b bVar) {
        i0.f(bVar, "element");
        return (g.b) this.f12119b.invoke(bVar);
    }

    public final boolean a(@j.c.a.d g.c<?> cVar) {
        i0.f(cVar, "key");
        return cVar == this || this.a == cVar;
    }
}
