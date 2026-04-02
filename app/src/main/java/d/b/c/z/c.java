package d.b.c.z;

import i.f1;

/* JADX INFO: compiled from: BitSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class c {
    private final byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9997b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9998c;

    public c(byte[] bArr) {
        this.a = bArr;
    }

    public int a(int i2) {
        int i3;
        if (i2 < 1 || i2 > 32 || i2 > a()) {
            throw new IllegalArgumentException(String.valueOf(i2));
        }
        int i4 = this.f9998c;
        if (i4 > 0) {
            int i5 = 8 - i4;
            int i6 = i2 < i5 ? i2 : i5;
            int i7 = i5 - i6;
            byte[] bArr = this.a;
            int i8 = this.f9997b;
            i3 = (((255 >> (8 - i6)) << i7) & bArr[i8]) >> i7;
            i2 -= i6;
            this.f9998c += i6;
            if (this.f9998c == 8) {
                this.f9998c = 0;
                this.f9997b = i8 + 1;
            }
        } else {
            i3 = 0;
        }
        if (i2 <= 0) {
            return i3;
        }
        while (i2 >= 8) {
            byte[] bArr2 = this.a;
            int i9 = this.f9997b;
            i3 = (i3 << 8) | (bArr2[i9] & f1.f12066c);
            this.f9997b = i9 + 1;
            i2 -= 8;
        }
        if (i2 <= 0) {
            return i3;
        }
        int i10 = 8 - i2;
        int i11 = (i3 << i2) | ((((255 >> i10) << i10) & this.a[this.f9997b]) >> i10);
        this.f9998c += i2;
        return i11;
    }

    public int b() {
        return this.f9998c;
    }

    public int c() {
        return this.f9997b;
    }

    public int a() {
        return ((this.a.length - this.f9997b) * 8) - this.f9998c;
    }
}
