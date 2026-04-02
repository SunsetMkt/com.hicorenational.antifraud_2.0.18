package d.b.c.a0.e;

import java.util.Arrays;

/* JADX INFO: compiled from: DefaultPlacement.java */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private final CharSequence a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f9469b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f9470c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final byte[] f9471d;

    public e(CharSequence charSequence, int i2, int i3) {
        this.a = charSequence;
        this.f9470c = i2;
        this.f9469b = i3;
        this.f9471d = new byte[i2 * i3];
        Arrays.fill(this.f9471d, (byte) -1);
    }

    final byte[] a() {
        return this.f9471d;
    }

    final int b() {
        return this.f9470c;
    }

    final int c() {
        return this.f9469b;
    }

    public final void d() {
        int i2;
        int i3;
        int i4 = 4;
        int i5 = 0;
        int i6 = 0;
        while (true) {
            if (i4 == this.f9469b && i5 == 0) {
                a(i6);
                i6++;
            }
            if (i4 == this.f9469b - 2 && i5 == 0 && this.f9470c % 4 != 0) {
                b(i6);
                i6++;
            }
            if (i4 == this.f9469b - 2 && i5 == 0 && this.f9470c % 8 == 4) {
                c(i6);
                i6++;
            }
            if (i4 == this.f9469b + 4 && i5 == 2 && this.f9470c % 8 == 0) {
                d(i6);
                i6++;
            }
            do {
                if (i4 < this.f9469b && i5 >= 0 && !b(i5, i4)) {
                    a(i4, i5, i6);
                    i6++;
                }
                i4 -= 2;
                i5 += 2;
                if (i4 < 0) {
                    break;
                }
            } while (i5 < this.f9470c);
            int i7 = i4 + 1;
            int i8 = i5 + 3;
            do {
                if (i7 >= 0 && i8 < this.f9470c && !b(i8, i7)) {
                    a(i7, i8, i6);
                    i6++;
                }
                i7 += 2;
                i8 -= 2;
                if (i7 >= this.f9469b) {
                    break;
                }
            } while (i8 >= 0);
            i4 = i7 + 3;
            i5 = i8 + 1;
            i2 = this.f9469b;
            if (i4 >= i2 && i5 >= (i3 = this.f9470c)) {
                break;
            }
        }
        if (b(i3 - 1, i2 - 1)) {
            return;
        }
        a(this.f9470c - 1, this.f9469b - 1, true);
        a(this.f9470c - 2, this.f9469b - 2, true);
    }

    private void c(int i2) {
        a(this.f9469b - 3, 0, i2, 1);
        a(this.f9469b - 2, 0, i2, 2);
        a(this.f9469b - 1, 0, i2, 3);
        a(0, this.f9470c - 2, i2, 4);
        a(0, this.f9470c - 1, i2, 5);
        a(1, this.f9470c - 1, i2, 6);
        a(2, this.f9470c - 1, i2, 7);
        a(3, this.f9470c - 1, i2, 8);
    }

    public final boolean a(int i2, int i3) {
        return this.f9471d[(i3 * this.f9470c) + i2] == 1;
    }

    final boolean b(int i2, int i3) {
        return this.f9471d[(i3 * this.f9470c) + i2] >= 0;
    }

    private void b(int i2) {
        a(this.f9469b - 3, 0, i2, 1);
        a(this.f9469b - 2, 0, i2, 2);
        a(this.f9469b - 1, 0, i2, 3);
        a(0, this.f9470c - 4, i2, 4);
        a(0, this.f9470c - 3, i2, 5);
        a(0, this.f9470c - 2, i2, 6);
        a(0, this.f9470c - 1, i2, 7);
        a(1, this.f9470c - 1, i2, 8);
    }

    final void a(int i2, int i3, boolean z) {
        this.f9471d[(i3 * this.f9470c) + i2] = z ? (byte) 1 : (byte) 0;
    }

    private void a(int i2, int i3, int i4, int i5) {
        if (i2 < 0) {
            int i6 = this.f9469b;
            i2 += i6;
            i3 += 4 - ((i6 + 4) % 8);
        }
        if (i3 < 0) {
            int i7 = this.f9470c;
            i3 += i7;
            i2 += 4 - ((i7 + 4) % 8);
        }
        a(i3, i2, (this.a.charAt(i4) & (1 << (8 - i5))) != 0);
    }

    private void a(int i2, int i3, int i4) {
        int i5 = i2 - 2;
        int i6 = i3 - 2;
        a(i5, i6, i4, 1);
        int i7 = i3 - 1;
        a(i5, i7, i4, 2);
        int i8 = i2 - 1;
        a(i8, i6, i4, 3);
        a(i8, i7, i4, 4);
        a(i8, i3, i4, 5);
        a(i2, i6, i4, 6);
        a(i2, i7, i4, 7);
        a(i2, i3, i4, 8);
    }

    private void a(int i2) {
        a(this.f9469b - 1, 0, i2, 1);
        a(this.f9469b - 1, 1, i2, 2);
        a(this.f9469b - 1, 2, i2, 3);
        a(0, this.f9470c - 2, i2, 4);
        a(0, this.f9470c - 1, i2, 5);
        a(1, this.f9470c - 1, i2, 6);
        a(2, this.f9470c - 1, i2, 7);
        a(3, this.f9470c - 1, i2, 8);
    }

    private void d(int i2) {
        a(this.f9469b - 1, 0, i2, 1);
        a(this.f9469b - 1, this.f9470c - 1, i2, 2);
        a(0, this.f9470c - 3, i2, 3);
        a(0, this.f9470c - 2, i2, 4);
        a(0, this.f9470c - 1, i2, 5);
        a(1, this.f9470c - 3, i2, 6);
        a(1, this.f9470c - 2, i2, 7);
        a(1, this.f9470c - 1, i2, 8);
    }
}
