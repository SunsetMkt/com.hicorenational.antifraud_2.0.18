package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class a extends i.g2.t {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean[] f12199b;

    public a(@j.c.a.d boolean[] zArr) {
        i0.f(zArr, "array");
        this.f12199b = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12199b.length;
    }

    @Override // i.g2.t
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f12199b;
            int i2 = this.a;
            this.a = i2 + 1;
            return zArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
