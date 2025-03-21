package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5307v0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.j */
/* loaded from: classes2.dex */
final class C5546j extends AbstractC5307v0 {

    /* renamed from: a */
    private int f20382a;

    /* renamed from: b */
    private final long[] f20383b;

    public C5546j(@InterfaceC5816d long[] jArr) {
        C5544i0.m22546f(jArr, "array");
        this.f20383b = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20382a < this.f20383b.length;
    }

    @Override // p286h.p289g2.AbstractC5307v0
    public long nextLong() {
        try {
            long[] jArr = this.f20383b;
            int i2 = this.f20382a;
            this.f20382a = i2 + 1;
            return jArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20382a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
