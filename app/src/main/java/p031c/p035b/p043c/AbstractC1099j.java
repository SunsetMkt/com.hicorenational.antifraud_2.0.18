package p031c.p035b.p043c;

import p286h.C5230f1;

/* compiled from: LuminanceSource.java */
/* renamed from: c.b.c.j */
/* loaded from: classes.dex */
public abstract class AbstractC1099j {

    /* renamed from: a */
    private final int f2199a;

    /* renamed from: b */
    private final int f2200b;

    protected AbstractC1099j(int i2, int i3) {
        this.f2199a = i2;
        this.f2200b = i3;
    }

    /* renamed from: a */
    public final int m1901a() {
        return this.f2200b;
    }

    /* renamed from: a */
    public abstract byte[] mo1894a(int i2, byte[] bArr);

    /* renamed from: b */
    public abstract byte[] mo1895b();

    /* renamed from: c */
    public final int m1902c() {
        return this.f2199a;
    }

    /* renamed from: d */
    public AbstractC1099j mo1896d() {
        return new C1098i(this);
    }

    /* renamed from: e */
    public boolean mo1897e() {
        return false;
    }

    /* renamed from: f */
    public boolean mo1898f() {
        return false;
    }

    /* renamed from: g */
    public AbstractC1099j mo1899g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    /* renamed from: h */
    public AbstractC1099j mo1900h() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i2 = this.f2199a;
        StringBuilder sb = new StringBuilder(this.f2200b * (i2 + 1));
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < this.f2200b; i3++) {
            bArr = mo1894a(i3, bArr);
            for (int i4 = 0; i4 < this.f2199a; i4++) {
                int i5 = bArr[i4] & C5230f1.f20085c;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    /* renamed from: a */
    public AbstractC1099j mo1893a(int i2, int i3, int i4, int i5) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }
}
