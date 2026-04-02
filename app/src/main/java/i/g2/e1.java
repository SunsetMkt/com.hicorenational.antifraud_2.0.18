package i.g2;

import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: SlidingWindow.kt */
/* JADX INFO: loaded from: classes2.dex */
public final class e1<E> extends d<E> implements RandomAccess {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f12079b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final List<E> f12080c;

    /* JADX WARN: Multi-variable type inference failed */
    public e1(@j.c.a.d List<? extends E> list) {
        i.q2.t.i0.f(list, "list");
        this.f12080c = list;
    }

    public final void a(int i2, int i3) {
        d.Companion.b(i2, i3, this.f12080c.size());
        this.a = i2;
        this.f12079b = i3 - i2;
    }

    @Override // i.g2.d, java.util.List
    public E get(int i2) {
        d.Companion.a(i2, this.f12079b);
        return this.f12080c.get(this.a + i2);
    }

    @Override // i.g2.d, i.g2.a
    public int getSize() {
        return this.f12079b;
    }
}
