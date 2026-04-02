package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class e extends i.g2.m0 {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final float[] f12204b;

    public e(@j.c.a.d float[] fArr) {
        i0.f(fArr, "array");
        this.f12204b = fArr;
    }

    @Override // i.g2.m0
    public float b() {
        try {
            float[] fArr = this.f12204b;
            int i2 = this.a;
            this.a = i2 + 1;
            return fArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12204b.length;
    }
}
