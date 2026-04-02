package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class j extends i.g2.v0 {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long[] f12214b;

    public j(@j.c.a.d long[] jArr) {
        i0.f(jArr, "array");
        this.f12214b = jArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12214b.length;
    }

    @Override // i.g2.v0
    public long nextLong() {
        try {
            long[] jArr = this.f12214b;
            int i2 = this.a;
            this.a = i2 + 1;
            return jArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
