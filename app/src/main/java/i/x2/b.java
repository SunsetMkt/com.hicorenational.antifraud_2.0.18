package i.x2;

import i.q2.t.i0;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: compiled from: Sequences.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b<T, K> extends i.g2.c<T> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final HashSet<K> f12341c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Iterator<T> f12342d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final i.q2.s.l<T, K> f12343e;

    /* JADX WARN: Multi-variable type inference failed */
    public b(@j.c.a.d Iterator<? extends T> it, @j.c.a.d i.q2.s.l<? super T, ? extends K> lVar) {
        i0.f(it, "source");
        i0.f(lVar, "keySelector");
        this.f12342d = it;
        this.f12343e = lVar;
        this.f12341c = new HashSet<>();
    }

    @Override // i.g2.c
    protected void b() {
        while (this.f12342d.hasNext()) {
            T next = this.f12342d.next();
            if (this.f12341c.add(this.f12343e.invoke(next))) {
                b(next);
                return;
            }
        }
        c();
    }
}
