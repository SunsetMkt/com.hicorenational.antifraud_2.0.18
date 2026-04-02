package i.x2;

import i.q2.t.i0;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class c<T, K> implements m<T> {
    private final m<T> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final i.q2.s.l<T, K> f12344b;

    /* JADX WARN: Multi-variable type inference failed */
    public c(@j.c.a.d m<? extends T> mVar, @j.c.a.d i.q2.s.l<? super T, ? extends K> lVar) {
        i0.f(mVar, "source");
        i0.f(lVar, "keySelector");
        this.a = mVar;
        this.f12344b = lVar;
    }

    @Override // i.x2.m
    @j.c.a.d
    public Iterator<T> iterator() {
        return new b(this.a.iterator(), this.f12344b);
    }
}
