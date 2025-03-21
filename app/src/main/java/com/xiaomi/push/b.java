package com.xiaomi.push;

import h.f1;
import java.io.InputStream;
import java.util.Vector;

/* loaded from: classes2.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    private int f12473a;

    /* renamed from: a, reason: collision with other field name */
    private final InputStream f206a;

    /* renamed from: a, reason: collision with other field name */
    private final byte[] f207a;

    /* renamed from: b, reason: collision with root package name */
    private int f12474b;

    /* renamed from: c, reason: collision with root package name */
    private int f12475c;

    /* renamed from: d, reason: collision with root package name */
    private int f12476d;

    /* renamed from: e, reason: collision with root package name */
    private int f12477e;

    /* renamed from: f, reason: collision with root package name */
    private int f12478f;

    /* renamed from: g, reason: collision with root package name */
    private int f12479g;

    /* renamed from: h, reason: collision with root package name */
    private int f12480h;

    /* renamed from: i, reason: collision with root package name */
    private int f12481i;

    private b(byte[] bArr, int i2, int i3) {
        this.f12478f = Integer.MAX_VALUE;
        this.f12480h = 64;
        this.f12481i = c.c.a.b.a.a.B1;
        this.f207a = bArr;
        this.f12473a = i3 + i2;
        this.f12475c = i2;
        this.f206a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m172b() {
        return m174c();
    }

    public int c() {
        return d();
    }

    public int d() {
        int i2;
        byte a2 = a();
        if (a2 >= 0) {
            return a2;
        }
        int i3 = a2 & h.q2.t.n.f16414b;
        byte a3 = a();
        if (a3 >= 0) {
            i2 = a3 << 7;
        } else {
            i3 |= (a3 & h.q2.t.n.f16414b) << 7;
            byte a4 = a();
            if (a4 >= 0) {
                i2 = a4 << com.umeng.analytics.pro.cw.f10302l;
            } else {
                i3 |= (a4 & h.q2.t.n.f16414b) << 14;
                byte a5 = a();
                if (a5 < 0) {
                    int i4 = i3 | ((a5 & h.q2.t.n.f16414b) << 21);
                    byte a6 = a();
                    int i5 = i4 | (a6 << 28);
                    if (a6 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (a() >= 0) {
                            return i5;
                        }
                    }
                    throw d.c();
                }
                i2 = a5 << 21;
            }
        }
        return i3 | i2;
    }

    public int e() {
        return (a() & f1.f16099c) | ((a() & f1.f16099c) << 8) | ((a() & f1.f16099c) << 16) | ((a() & f1.f16099c) << 24);
    }

    public static b a(byte[] bArr, int i2, int i3) {
        return new b(bArr, i2, i3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public int m171b() {
        return d();
    }

    /* renamed from: c, reason: collision with other method in class */
    public long m174c() {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & h.q2.t.n.f16414b) << i2;
            if ((a() & h.q2.t.n.f16413a) == 0) {
                return j2;
            }
        }
        throw d.c();
    }

    private void b() {
        this.f12473a += this.f12474b;
        int i2 = this.f12477e;
        int i3 = this.f12473a;
        int i4 = i2 + i3;
        int i5 = this.f12478f;
        if (i4 > i5) {
            this.f12474b = i4 - i5;
            this.f12473a = i3 - this.f12474b;
        } else {
            this.f12474b = 0;
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public int m162a() {
        if (m173b()) {
            this.f12476d = 0;
            return 0;
        }
        this.f12476d = d();
        int i2 = this.f12476d;
        if (i2 != 0) {
            return i2;
        }
        throw d.d();
    }

    public void c(int i2) {
        if (i2 >= 0) {
            int i3 = this.f12477e;
            int i4 = this.f12475c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f12478f;
            if (i5 <= i6) {
                int i7 = this.f12473a;
                if (i2 <= i7 - i4) {
                    this.f12475c = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.f12477e = i3 + i7;
                this.f12475c = 0;
                this.f12473a = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.f206a;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
                    if (skip > 0) {
                        i8 += skip;
                        this.f12477e += skip;
                    } else {
                        throw d.a();
                    }
                }
                return;
            }
            c((i6 - i3) - i4);
            throw d.a();
        }
        throw d.b();
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m167a(int i2) {
        if (this.f12476d != i2) {
            throw d.e();
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public long m175d() {
        return ((a() & 255) << 8) | (a() & 255) | ((a() & 255) << 16) | ((a() & 255) << 24) | ((a() & 255) << 32) | ((a() & 255) << 40) | ((a() & 255) << 48) | ((a() & 255) << 56);
    }

    private b(InputStream inputStream) {
        this.f12478f = Integer.MAX_VALUE;
        this.f12480h = 64;
        this.f12481i = c.c.a.b.a.a.B1;
        this.f207a = new byte[4096];
        this.f12473a = 0;
        this.f12475c = 0;
        this.f206a = inputStream;
    }

    public void b(int i2) {
        this.f12478f = i2;
        b();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m169a(int i2) {
        int a2 = f.a(i2);
        if (a2 == 0) {
            m171b();
            return true;
        }
        if (a2 == 1) {
            m175d();
            return true;
        }
        if (a2 == 2) {
            c(d());
            return true;
        }
        if (a2 == 3) {
            m166a();
            m167a(f.a(f.b(i2), 4));
            return true;
        }
        if (a2 == 4) {
            return false;
        }
        if (a2 == 5) {
            e();
            return true;
        }
        throw d.f();
    }

    /* renamed from: b, reason: collision with other method in class */
    public boolean m173b() {
        return this.f12475c == this.f12473a && !a(false);
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m166a() {
        int m162a;
        do {
            m162a = m162a();
            if (m162a == 0) {
                return;
            }
        } while (m169a(m162a));
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m163a() {
        return m174c();
    }

    /* renamed from: a, reason: collision with other method in class */
    public boolean m168a() {
        return d() != 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    public String m165a() {
        int d2 = d();
        int i2 = this.f12473a;
        int i3 = this.f12475c;
        if (d2 <= i2 - i3 && d2 > 0) {
            String str = new String(this.f207a, i3, d2, "UTF-8");
            this.f12475c += d2;
            return str;
        }
        return new String(m170a(d2), "UTF-8");
    }

    public void a(e eVar) {
        int d2 = d();
        if (this.f12479g < this.f12480h) {
            int a2 = a(d2);
            this.f12479g++;
            eVar.a(this);
            m167a(0);
            this.f12479g--;
            b(a2);
            return;
        }
        throw d.g();
    }

    /* renamed from: a, reason: collision with other method in class */
    public a m164a() {
        int d2 = d();
        int i2 = this.f12473a;
        int i3 = this.f12475c;
        if (d2 <= i2 - i3 && d2 > 0) {
            a a2 = a.a(this.f207a, i3, d2);
            this.f12475c += d2;
            return a2;
        }
        return a.a(m170a(d2));
    }

    public int a(int i2) {
        if (i2 >= 0) {
            int i3 = i2 + this.f12477e + this.f12475c;
            int i4 = this.f12478f;
            if (i3 <= i4) {
                this.f12478f = i3;
                b();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    private boolean a(boolean z) {
        int i2 = this.f12475c;
        int i3 = this.f12473a;
        if (i2 >= i3) {
            int i4 = this.f12477e;
            if (i4 + i3 == this.f12478f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.f12477e = i4 + i3;
            this.f12475c = 0;
            InputStream inputStream = this.f206a;
            this.f12473a = inputStream == null ? -1 : inputStream.read(this.f207a);
            int i5 = this.f12473a;
            if (i5 == 0 || i5 < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f12473a + "\nThe InputStream implementation is buggy.");
            }
            if (i5 == -1) {
                this.f12473a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            }
            b();
            int i6 = this.f12477e + this.f12473a + this.f12474b;
            if (i6 > this.f12481i || i6 < 0) {
                throw d.h();
            }
            return true;
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public byte a() {
        if (this.f12475c == this.f12473a) {
            a(true);
        }
        byte[] bArr = this.f207a;
        int i2 = this.f12475c;
        this.f12475c = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a, reason: collision with other method in class */
    public byte[] m170a(int i2) {
        if (i2 >= 0) {
            int i3 = this.f12477e;
            int i4 = this.f12475c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f12478f;
            if (i5 <= i6) {
                int i7 = this.f12473a;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f207a, i4, bArr, 0, i2);
                    this.f12475c += i2;
                    return bArr;
                }
                if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.f207a, i4, bArr2, 0, i8);
                    this.f12475c = this.f12473a;
                    a(true);
                    while (true) {
                        int i9 = i2 - i8;
                        int i10 = this.f12473a;
                        if (i9 > i10) {
                            System.arraycopy(this.f207a, 0, bArr2, i8, i10);
                            int i11 = this.f12473a;
                            i8 += i11;
                            this.f12475c = i11;
                            a(true);
                        } else {
                            System.arraycopy(this.f207a, 0, bArr2, i8, i9);
                            this.f12475c = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.f12477e = i3 + i7;
                    this.f12475c = 0;
                    this.f12473a = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    Vector vector = new Vector();
                    while (i13 > 0) {
                        byte[] bArr3 = new byte[Math.min(i13, 4096)];
                        int i14 = 0;
                        while (i14 < bArr3.length) {
                            InputStream inputStream = this.f206a;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, bArr3.length - i14);
                            if (read == -1) {
                                throw d.a();
                            }
                            this.f12477e += read;
                            i14 += read;
                        }
                        i13 -= bArr3.length;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.f207a, i4, bArr4, 0, i12);
                    for (int i15 = 0; i15 < vector.size(); i15++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i15);
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                c((i6 - i3) - i4);
                throw d.a();
            }
        } else {
            throw d.b();
        }
    }
}
