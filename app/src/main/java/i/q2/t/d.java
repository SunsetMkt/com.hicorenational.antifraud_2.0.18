package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class d extends i.g2.h0 {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final double[] f12203b;

    public d(@j.c.a.d double[] dArr) {
        i0.f(dArr, "array");
        this.f12203b = dArr;
    }

    @Override // i.g2.h0
    public double b() {
        try {
            double[] dArr = this.f12203b;
            int i2 = this.a;
            this.a = i2 + 1;
            return dArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12203b.length;
    }
}
