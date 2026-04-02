package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class c extends i.g2.v {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final char[] f12202b;

    public c(@j.c.a.d char[] cArr) {
        i0.f(cArr, "array");
        this.f12202b = cArr;
    }

    @Override // i.g2.v
    public char b() {
        try {
            char[] cArr = this.f12202b;
            int i2 = this.a;
            this.a = i2 + 1;
            return cArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12202b.length;
    }
}
