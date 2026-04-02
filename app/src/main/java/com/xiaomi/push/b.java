package com.xiaomi.push;

import i.f1;
import java.io.InputStream;
import java.util.Vector;

/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private int a;

    /* JADX INFO: renamed from: a */
    private final InputStream f206a;

    /* JADX INFO: renamed from: a */
    private final byte[] f207a;

    /* JADX INFO: renamed from: b */
    private int f8759b;

    /* JADX INFO: renamed from: c */
    private int f8760c;

    /* JADX INFO: renamed from: d */
    private int f8761d;

    /* JADX INFO: renamed from: e */
    private int f8762e;

    /* JADX INFO: renamed from: f */
    private int f8763f;

    /* JADX INFO: renamed from: g */
    private int f8764g;

    /* JADX INFO: renamed from: h */
    private int f8765h;

    /* JADX INFO: renamed from: i */
    private int f8766i;

    private b(byte[] bArr, int i2, int i3) {
        this.f8763f = Integer.MAX_VALUE;
        this.f8765h = 64;
        this.f8766i = d.c.a.b.a.a.B1;
        this.f207a = bArr;
        this.a = i3 + i2;
        this.f8760c = i2;
        this.f206a = null;
    }

    public static b a(InputStream inputStream) {
        return new b(inputStream);
    }

    /* JADX INFO: renamed from: b */
    public long m170b() {
        return m172c();
    }

    public int c() {
        return d();
    }

    public int d() throws d {
        int i2;
        byte bA = a();
        if (bA >= 0) {
            return bA;
        }
        int i3 = bA & i.q2.t.n.f12226b;
        byte bA2 = a();
        if (bA2 >= 0) {
            i2 = bA2 << 7;
        } else {
            i3 |= (bA2 & i.q2.t.n.f12226b) << 7;
            byte bA3 = a();
            if (bA3 >= 0) {
                i2 = bA3 << com.umeng.analytics.pro.cw.f7204l;
            } else {
                i3 |= (bA3 & i.q2.t.n.f12226b) << 14;
                byte bA4 = a();
                if (bA4 < 0) {
                    int i4 = i3 | ((bA4 & i.q2.t.n.f12226b) << 21);
                    byte bA5 = a();
                    int i5 = i4 | (bA5 << 28);
                    if (bA5 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (a() >= 0) {
                            return i5;
                        }
                    }
                    throw d.c();
                }
                i2 = bA4 << 21;
            }
        }
        return i3 | i2;
    }

    public int e() throws d {
        return (a() & f1.f12066c) | ((a() & f1.f12066c) << 8) | ((a() & f1.f12066c) << 16) | ((a() & f1.f12066c) << 24);
    }

    public static b a(byte[] bArr, int i2, int i3) {
        return new b(bArr, i2, i3);
    }

    /* JADX INFO: renamed from: b */
    public int m169b() {
        return d();
    }

    /* JADX INFO: renamed from: c */
    public long m172c() throws d {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            byte bA = a();
            j2 |= ((long) (bA & i.q2.t.n.f12226b)) << i2;
            if ((bA & i.q2.t.n.a) == 0) {
                return j2;
            }
        }
        throw d.c();
    }

    private void b() {
        this.a += this.f8759b;
        int i2 = this.f8762e;
        int i3 = this.a;
        int i4 = i2 + i3;
        int i5 = this.f8763f;
        if (i4 > i5) {
            this.f8759b = i4 - i5;
            this.a = i3 - this.f8759b;
        } else {
            this.f8759b = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public int m160a() throws d {
        if (m171b()) {
            this.f8761d = 0;
            return 0;
        }
        this.f8761d = d();
        int i2 = this.f8761d;
        if (i2 != 0) {
            return i2;
        }
        throw d.d();
    }

    public void c(int i2) throws d {
        if (i2 >= 0) {
            int i3 = this.f8762e;
            int i4 = this.f8760c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f8763f;
            if (i5 <= i6) {
                int i7 = this.a;
                if (i2 <= i7 - i4) {
                    this.f8760c = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.f8762e = i3 + i7;
                this.f8760c = 0;
                this.a = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.f206a;
                    int iSkip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
                    if (iSkip > 0) {
                        i8 += iSkip;
                        this.f8762e += iSkip;
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

    /* JADX INFO: renamed from: a */
    public void m165a(int i2) throws d {
        if (this.f8761d != i2) {
            throw d.e();
        }
    }

    /* JADX INFO: renamed from: d */
    public long m173d() throws d {
        byte bA = a();
        return ((((long) a()) & 255) << 8) | (((long) bA) & 255) | ((((long) a()) & 255) << 16) | ((((long) a()) & 255) << 24) | ((((long) a()) & 255) << 32) | ((((long) a()) & 255) << 40) | ((((long) a()) & 255) << 48) | ((((long) a()) & 255) << 56);
    }

    private b(InputStream inputStream) {
        this.f8763f = Integer.MAX_VALUE;
        this.f8765h = 64;
        this.f8766i = d.c.a.b.a.a.B1;
        this.f207a = new byte[4096];
        this.a = 0;
        this.f8760c = 0;
        this.f206a = inputStream;
    }

    public void b(int i2) {
        this.f8763f = i2;
        b();
    }

    /* JADX INFO: renamed from: a */
    public boolean m167a(int i2) throws d {
        int iA = f.a(i2);
        if (iA == 0) {
            m169b();
            return true;
        }
        if (iA == 1) {
            m173d();
            return true;
        }
        if (iA == 2) {
            c(d());
            return true;
        }
        if (iA == 3) {
            m164a();
            m165a(f.a(f.b(i2), 4));
            return true;
        }
        if (iA == 4) {
            return false;
        }
        if (iA == 5) {
            e();
            return true;
        }
        throw d.f();
    }

    /* JADX INFO: renamed from: b */
    public boolean m171b() {
        return this.f8760c == this.a && !a(false);
    }

    /* JADX INFO: renamed from: a */
    public void m164a() throws d {
        int iM160a;
        do {
            iM160a = m160a();
            if (iM160a == 0) {
                return;
            }
        } while (m167a(iM160a));
    }

    /* JADX INFO: renamed from: a */
    public long m161a() {
        return m172c();
    }

    /* JADX INFO: renamed from: a */
    public boolean m166a() {
        return d() != 0;
    }

    /* JADX INFO: renamed from: a */
    public String m163a() throws d {
        int iD = d();
        int i2 = this.a;
        int i3 = this.f8760c;
        if (iD <= i2 - i3 && iD > 0) {
            String str = new String(this.f207a, i3, iD, "UTF-8");
            this.f8760c += iD;
            return str;
        }
        return new String(m168a(iD), "UTF-8");
    }

    public void a(e eVar) throws d {
        int iD = d();
        if (this.f8764g < this.f8765h) {
            int iA = a(iD);
            this.f8764g++;
            eVar.a(this);
            m165a(0);
            this.f8764g--;
            b(iA);
            return;
        }
        throw d.g();
    }

    /* JADX INFO: renamed from: a */
    public a m162a() throws d {
        int iD = d();
        int i2 = this.a;
        int i3 = this.f8760c;
        if (iD <= i2 - i3 && iD > 0) {
            a aVarA = a.a(this.f207a, i3, iD);
            this.f8760c += iD;
            return aVarA;
        }
        return a.a(m168a(iD));
    }

    public int a(int i2) throws d {
        if (i2 >= 0) {
            int i3 = i2 + this.f8762e + this.f8760c;
            int i4 = this.f8763f;
            if (i3 <= i4) {
                this.f8763f = i3;
                b();
                return i4;
            }
            throw d.a();
        }
        throw d.b();
    }

    private boolean a(boolean z) throws d {
        int i2 = this.f8760c;
        int i3 = this.a;
        if (i2 >= i3) {
            int i4 = this.f8762e;
            if (i4 + i3 == this.f8763f) {
                if (z) {
                    throw d.a();
                }
                return false;
            }
            this.f8762e = i4 + i3;
            this.f8760c = 0;
            InputStream inputStream = this.f206a;
            this.a = inputStream == null ? -1 : inputStream.read(this.f207a);
            int i5 = this.a;
            if (i5 == 0 || i5 < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.a + "\nThe InputStream implementation is buggy.");
            }
            if (i5 == -1) {
                this.a = 0;
                if (z) {
                    throw d.a();
                }
                return false;
            }
            b();
            int i6 = this.f8762e + this.a + this.f8759b;
            if (i6 > this.f8766i || i6 < 0) {
                throw d.h();
            }
            return true;
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    public byte a() throws d {
        if (this.f8760c == this.a) {
            a(true);
        }
        byte[] bArr = this.f207a;
        int i2 = this.f8760c;
        this.f8760c = i2 + 1;
        return bArr[i2];
    }

    /* JADX INFO: renamed from: a */
    public byte[] m168a(int i2) throws d {
        if (i2 >= 0) {
            int i3 = this.f8762e;
            int i4 = this.f8760c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f8763f;
            if (i5 <= i6) {
                int i7 = this.a;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f207a, i4, bArr, 0, i2);
                    this.f8760c += i2;
                    return bArr;
                }
                if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.f207a, i4, bArr2, 0, i8);
                    this.f8760c = this.a;
                    a(true);
                    while (true) {
                        int i9 = i2 - i8;
                        int i10 = this.a;
                        if (i9 > i10) {
                            System.arraycopy(this.f207a, 0, bArr2, i8, i10);
                            int i11 = this.a;
                            i8 += i11;
                            this.f8760c = i11;
                            a(true);
                        } else {
                            System.arraycopy(this.f207a, 0, bArr2, i8, i9);
                            this.f8760c = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.f8762e = i3 + i7;
                    this.f8760c = 0;
                    this.a = 0;
                    int length = i7 - i4;
                    int length2 = i2 - length;
                    Vector vector = new Vector();
                    while (length2 > 0) {
                        byte[] bArr3 = new byte[Math.min(length2, 4096)];
                        int i12 = 0;
                        while (i12 < bArr3.length) {
                            InputStream inputStream = this.f206a;
                            int i13 = inputStream == null ? -1 : inputStream.read(bArr3, i12, bArr3.length - i12);
                            if (i13 == -1) {
                                throw d.a();
                            }
                            this.f8762e += i13;
                            i12 += i13;
                        }
                        length2 -= bArr3.length;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.f207a, i4, bArr4, 0, length);
                    for (int i14 = 0; i14 < vector.size(); i14++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i14);
                        System.arraycopy(bArr5, 0, bArr4, length, bArr5.length);
                        length += bArr5.length;
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
