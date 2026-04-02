package i.q2.t;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: ArrayIterators.kt */
/* JADX INFO: loaded from: classes2.dex */
final class b extends i.g2.u {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final byte[] f12201b;

    public b(@j.c.a.d byte[] bArr) {
        i0.f(bArr, "array");
        this.f12201b = bArr;
    }

    @Override // i.g2.u
    public byte b() {
        try {
            byte[] bArr = this.f12201b;
            int i2 = this.a;
            this.a = i2 + 1;
            return bArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.a < this.f12201b.length;
    }
}
