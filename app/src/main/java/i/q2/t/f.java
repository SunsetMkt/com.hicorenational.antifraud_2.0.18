package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class f extends i.g2.u0 {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int[] f12205b;

    public f(@j.c.a.d int[] iArr) {
        i0.f(iArr, "array");
        this.f12205b = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12205b.length;
    }

    @Override // i.g2.u0
    public int nextInt() {
        try {
            int[] iArr = this.f12205b;
            int i2 = this.a;
            this.a = i2 + 1;
            return iArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
