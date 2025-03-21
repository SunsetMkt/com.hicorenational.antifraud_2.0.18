package p031c.p035b.p043c.p062f0.p065e;

import java.lang.reflect.Array;

/* compiled from: ByteMatrix.java */
/* renamed from: c.b.c.f0.e.b */
/* loaded from: classes.dex */
public final class C1091b {

    /* renamed from: a */
    private final byte[][] f2173a;

    /* renamed from: b */
    private final int f2174b;

    /* renamed from: c */
    private final int f2175c;

    public C1091b(int i2, int i3) {
        this.f2173a = (byte[][]) Array.newInstance((Class<?>) byte.class, i3, i2);
        this.f2174b = i2;
        this.f2175c = i3;
    }

    /* renamed from: a */
    public byte m1826a(int i2, int i3) {
        return this.f2173a[i3][i2];
    }

    /* renamed from: b */
    public int m1832b() {
        return this.f2175c;
    }

    /* renamed from: c */
    public int m1833c() {
        return this.f2174b;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder((this.f2174b * 2 * this.f2175c) + 2);
        for (int i2 = 0; i2 < this.f2175c; i2++) {
            for (int i3 = 0; i3 < this.f2174b; i3++) {
                byte b2 = this.f2173a[i2][i3];
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

    /* renamed from: a */
    public byte[][] m1831a() {
        return this.f2173a;
    }

    /* renamed from: a */
    public void m1828a(int i2, int i3, byte b2) {
        this.f2173a[i3][i2] = b2;
    }

    /* renamed from: a */
    public void m1829a(int i2, int i3, int i4) {
        this.f2173a[i3][i2] = (byte) i4;
    }

    /* renamed from: a */
    public void m1830a(int i2, int i3, boolean z) {
        this.f2173a[i3][i2] = z ? (byte) 1 : (byte) 0;
    }

    /* renamed from: a */
    public void m1827a(byte b2) {
        for (int i2 = 0; i2 < this.f2175c; i2++) {
            for (int i3 = 0; i3 < this.f2174b; i3++) {
                this.f2173a[i2][i3] = b2;
            }
        }
    }
}
