package d.b.c;

import i.f1;

/* JADX INFO: compiled from: LuminanceSource.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class j {
    private final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9837b;

    protected j(int i2, int i3) {
        this.a = i2;
        this.f9837b = i3;
    }

    public final int a() {
        return this.f9837b;
    }

    public abstract byte[] a(int i2, byte[] bArr);

    public abstract byte[] b();

    public final int c() {
        return this.a;
    }

    public j d() {
        return new i(this);
    }

    public boolean e() {
        return false;
    }

    public boolean f() {
        return false;
    }

    public j g() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public j h() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i2 = this.a;
        StringBuilder sb = new StringBuilder(this.f9837b * (i2 + 1));
        byte[] bArrA = new byte[i2];
        for (int i3 = 0; i3 < this.f9837b; i3++) {
            bArrA = a(i3, bArrA);
            for (int i4 = 0; i4 < this.a; i4++) {
                int i5 = bArrA[i4] & f1.f12066c;
                sb.append(i5 < 64 ? '#' : i5 < 128 ? '+' : i5 < 192 ? '.' : ' ');
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public j a(int i2, int i3, int i4, int i5) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }
}
