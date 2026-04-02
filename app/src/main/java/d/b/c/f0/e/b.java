package d.b.c.f0.e;

import java.lang.reflect.Array;

/* JADX INFO: compiled from: ByteMatrix.java */
/* JADX INFO: loaded from: classes.dex */
public final class b {
    private final byte[][] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9819b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9820c;

    public b(int i2, int i3) {
        this.a = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, i2);
        this.f9819b = i2;
        this.f9820c = i3;
    }

    public byte a(int i2, int i3) {
        return this.a[i3][i2];
    }

    public int b() {
        return this.f9820c;
    }

    public int c() {
        return this.f9819b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f9819b * 2 * this.f9820c) + 2);
        for (int i2 = 0; i2 < this.f9820c; i2++) {
            for (int i3 = 0; i3 < this.f9819b; i3++) {
                byte b2 = this.a[i2][i3];
                if (b2 == 0) {
                    sb.append(" 0");
                } else if (b2 != 1) {
                    sb.append("  ");
                } else {
                    sb.append(" 1");
                }
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public byte[][] a() {
        return this.a;
    }

    public void a(int i2, int i3, byte b2) {
        this.a[i3][i2] = b2;
    }

    public void a(int i2, int i3, int i4) {
        this.a[i3][i2] = (byte) i4;
    }

    public void a(int i2, int i3, boolean z) {
        this.a[i3][i2] = z ? (byte) 1 : (byte) 0;
    }

    public void a(byte b2) {
        for (int i2 = 0; i2 < this.f9820c; i2++) {
            for (int i3 = 0; i3 < this.f9819b; i3++) {
                this.a[i2][i3] = b2;
            }
        }
    }
}
