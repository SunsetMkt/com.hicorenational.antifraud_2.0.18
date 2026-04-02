package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class k extends i.g2.o1 {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final short[] f12219b;

    public k(@j.c.a.d short[] sArr) {
        i0.f(sArr, "array");
        this.f12219b = sArr;
    }

    @Override // i.g2.o1
    public short b() {
        try {
            short[] sArr = this.f12219b;
            int i2 = this.a;
            this.a = i2 + 1;
            return sArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12219b.length;
    }
}
