package d.b.c.e0.g;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: BarcodeMatrix.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {
    private final b[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9745b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9746c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f9747d;

    a(int i2, int i3) {
        this.a = new b[i2];
        int length = this.a.length;
        for (int i4 = 0; i4 < length; i4++) {
            this.a[i4] = new b(((i3 + 4) * 17) + 1);
        }
        this.f9747d = i3 * 17;
        this.f9746c = i2;
        this.f9745b = -1;
    }

    void a(int i2, int i3, byte b2) {
        this.a[i3].a(i2, b2);
    }

    public byte[][] b() {
        return a(1, 1);
    }

    void c() {
        this.f9745b++;
    }

    b a() {
        return this.a[this.f9745b];
    }

    public byte[][] a(int i2, int i3) {
        byte[][] bArr = (byte[][]) Array.newInstance((Class<?>) byte.class, this.f9746c * i3, this.f9747d * i2);
        int i4 = this.f9746c * i3;
        for (int i5 = 0; i5 < i4; i5++) {
            bArr[(i4 - i5) - 1] = this.a[i5 / i3].a(i2);
        }
        return bArr;
    }
}
