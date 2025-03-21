package com.xiaomi.push;

import com.umeng.analytics.pro.C3393cw;
import java.io.InputStream;
import java.util.Vector;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;
import p286h.C5230f1;
import p286h.p309q2.p311t.C5558n;

/* renamed from: com.xiaomi.push.b */
/* loaded from: classes2.dex */
public final class C4098b {

    /* renamed from: a */
    private int f14593a;

    /* renamed from: a */
    private final InputStream f14594a;

    /* renamed from: a */
    private final byte[] f14595a;

    /* renamed from: b */
    private int f14596b;

    /* renamed from: c */
    private int f14597c;

    /* renamed from: d */
    private int f14598d;

    /* renamed from: e */
    private int f14599e;

    /* renamed from: f */
    private int f14600f;

    /* renamed from: g */
    private int f14601g;

    /* renamed from: h */
    private int f14602h;

    /* renamed from: i */
    private int f14603i;

    private C4098b(byte[] bArr, int i2, int i3) {
        this.f14600f = Integer.MAX_VALUE;
        this.f14602h = 64;
        this.f14603i = AbstractC1191a.f2487B1;
        this.f14595a = bArr;
        this.f14593a = i3 + i2;
        this.f14597c = i2;
        this.f14594a = null;
    }

    /* renamed from: a */
    public static C4098b m13848a(InputStream inputStream) {
        return new C4098b(inputStream);
    }

    /* renamed from: b */
    public long m13865b() {
        return m13869c();
    }

    /* renamed from: c */
    public int m13868c() {
        return m13871d();
    }

    /* renamed from: d */
    public int m13871d() {
        int i2;
        byte m13852a = m13852a();
        if (m13852a >= 0) {
            return m13852a;
        }
        int i3 = m13852a & C5558n.f20402b;
        byte m13852a2 = m13852a();
        if (m13852a2 >= 0) {
            i2 = m13852a2 << 7;
        } else {
            i3 |= (m13852a2 & C5558n.f20402b) << 7;
            byte m13852a3 = m13852a();
            if (m13852a3 >= 0) {
                i2 = m13852a3 << C3393cw.f11872l;
            } else {
                i3 |= (m13852a3 & C5558n.f20402b) << 14;
                byte m13852a4 = m13852a();
                if (m13852a4 < 0) {
                    int i4 = i3 | ((m13852a4 & C5558n.f20402b) << 21);
                    byte m13852a5 = m13852a();
                    int i5 = i4 | (m13852a5 << 28);
                    if (m13852a5 >= 0) {
                        return i5;
                    }
                    for (int i6 = 0; i6 < 5; i6++) {
                        if (m13852a() >= 0) {
                            return i5;
                        }
                    }
                    throw C4152d.m14248c();
                }
                i2 = m13852a4 << 21;
            }
        }
        return i3 | i2;
    }

    /* renamed from: e */
    public int m13873e() {
        return (m13852a() & C5230f1.f20085c) | ((m13852a() & C5230f1.f20085c) << 8) | ((m13852a() & C5230f1.f20085c) << 16) | ((m13852a() & C5230f1.f20085c) << 24);
    }

    /* renamed from: a */
    public static C4098b m13849a(byte[] bArr, int i2, int i3) {
        return new C4098b(bArr, i2, i3);
    }

    /* renamed from: b */
    public int m13864b() {
        return m13871d();
    }

    /* renamed from: c */
    public long m13869c() {
        long j2 = 0;
        for (int i2 = 0; i2 < 64; i2 += 7) {
            j2 |= (r3 & C5558n.f20402b) << i2;
            if ((m13852a() & C5558n.f20401a) == 0) {
                return j2;
            }
        }
        throw C4152d.m14248c();
    }

    /* renamed from: b */
    private void m13851b() {
        this.f14593a += this.f14596b;
        int i2 = this.f14599e;
        int i3 = this.f14593a;
        int i4 = i2 + i3;
        int i5 = this.f14600f;
        if (i4 > i5) {
            this.f14596b = i4 - i5;
            this.f14593a = i3 - this.f14596b;
        } else {
            this.f14596b = 0;
        }
    }

    /* renamed from: a */
    public int m13853a() {
        if (m13867b()) {
            this.f14598d = 0;
            return 0;
        }
        this.f14598d = m13871d();
        int i2 = this.f14598d;
        if (i2 != 0) {
            return i2;
        }
        throw C4152d.m14249d();
    }

    /* renamed from: c */
    public void m13870c(int i2) {
        if (i2 >= 0) {
            int i3 = this.f14599e;
            int i4 = this.f14597c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f14600f;
            if (i5 <= i6) {
                int i7 = this.f14593a;
                if (i2 <= i7 - i4) {
                    this.f14597c = i4 + i2;
                    return;
                }
                int i8 = i7 - i4;
                this.f14599e = i3 + i7;
                this.f14597c = 0;
                this.f14593a = 0;
                while (i8 < i2) {
                    InputStream inputStream = this.f14594a;
                    int skip = inputStream == null ? -1 : (int) inputStream.skip(i2 - i8);
                    if (skip > 0) {
                        i8 += skip;
                        this.f14599e += skip;
                    } else {
                        throw C4152d.m14246a();
                    }
                }
                return;
            }
            m13870c((i6 - i3) - i4);
            throw C4152d.m14246a();
        }
        throw C4152d.m14247b();
    }

    /* renamed from: a */
    public void m13859a(int i2) {
        if (this.f14598d != i2) {
            throw C4152d.m14250e();
        }
    }

    /* renamed from: d */
    public long m13872d() {
        return ((m13852a() & 255) << 8) | (m13852a() & 255) | ((m13852a() & 255) << 16) | ((m13852a() & 255) << 24) | ((m13852a() & 255) << 32) | ((m13852a() & 255) << 40) | ((m13852a() & 255) << 48) | ((m13852a() & 255) << 56);
    }

    private C4098b(InputStream inputStream) {
        this.f14600f = Integer.MAX_VALUE;
        this.f14602h = 64;
        this.f14603i = AbstractC1191a.f2487B1;
        this.f14595a = new byte[4096];
        this.f14593a = 0;
        this.f14597c = 0;
        this.f14594a = inputStream;
    }

    /* renamed from: b */
    public void m13866b(int i2) {
        this.f14600f = i2;
        m13851b();
    }

    /* renamed from: a */
    public boolean m13862a(int i2) {
        int m14754a = C4206f.m14754a(i2);
        if (m14754a == 0) {
            m13864b();
            return true;
        }
        if (m14754a == 1) {
            m13872d();
            return true;
        }
        if (m14754a == 2) {
            m13870c(m13871d());
            return true;
        }
        if (m14754a == 3) {
            m13858a();
            m13859a(C4206f.m14755a(C4206f.m14756b(i2), 4));
            return true;
        }
        if (m14754a == 4) {
            return false;
        }
        if (m14754a == 5) {
            m13873e();
            return true;
        }
        throw C4152d.m14251f();
    }

    /* renamed from: b */
    public boolean m13867b() {
        return this.f14597c == this.f14593a && !m13850a(false);
    }

    /* renamed from: a */
    public void m13858a() {
        int m13853a;
        do {
            m13853a = m13853a();
            if (m13853a == 0) {
                return;
            }
        } while (m13862a(m13853a));
    }

    /* renamed from: a */
    public long m13855a() {
        return m13869c();
    }

    /* renamed from: a */
    public boolean m13861a() {
        return m13871d() != 0;
    }

    /* renamed from: a */
    public String m13857a() {
        int m13871d = m13871d();
        int i2 = this.f14593a;
        int i3 = this.f14597c;
        if (m13871d <= i2 - i3 && m13871d > 0) {
            String str = new String(this.f14595a, i3, m13871d, "UTF-8");
            this.f14597c += m13871d;
            return str;
        }
        return new String(m13863a(m13871d), "UTF-8");
    }

    /* renamed from: a */
    public void m13860a(AbstractC4179e abstractC4179e) {
        int m13871d = m13871d();
        if (this.f14601g < this.f14602h) {
            int m13854a = m13854a(m13871d);
            this.f14601g++;
            abstractC4179e.mo14316a(this);
            m13859a(0);
            this.f14601g--;
            m13866b(m13854a);
            return;
        }
        throw C4152d.m14252g();
    }

    /* renamed from: a */
    public C4071a m13856a() {
        int m13871d = m13871d();
        int i2 = this.f14593a;
        int i3 = this.f14597c;
        if (m13871d <= i2 - i3 && m13871d > 0) {
            C4071a m13688a = C4071a.m13688a(this.f14595a, i3, m13871d);
            this.f14597c += m13871d;
            return m13688a;
        }
        return C4071a.m13687a(m13863a(m13871d));
    }

    /* renamed from: a */
    public int m13854a(int i2) {
        if (i2 >= 0) {
            int i3 = i2 + this.f14599e + this.f14597c;
            int i4 = this.f14600f;
            if (i3 <= i4) {
                this.f14600f = i3;
                m13851b();
                return i4;
            }
            throw C4152d.m14246a();
        }
        throw C4152d.m14247b();
    }

    /* renamed from: a */
    private boolean m13850a(boolean z) {
        int i2 = this.f14597c;
        int i3 = this.f14593a;
        if (i2 >= i3) {
            int i4 = this.f14599e;
            if (i4 + i3 == this.f14600f) {
                if (z) {
                    throw C4152d.m14246a();
                }
                return false;
            }
            this.f14599e = i4 + i3;
            this.f14597c = 0;
            InputStream inputStream = this.f14594a;
            this.f14593a = inputStream == null ? -1 : inputStream.read(this.f14595a);
            int i5 = this.f14593a;
            if (i5 == 0 || i5 < -1) {
                throw new IllegalStateException("InputStream#read(byte[]) returned invalid result: " + this.f14593a + "\nThe InputStream implementation is buggy.");
            }
            if (i5 == -1) {
                this.f14593a = 0;
                if (z) {
                    throw C4152d.m14246a();
                }
                return false;
            }
            m13851b();
            int i6 = this.f14599e + this.f14593a + this.f14596b;
            if (i6 > this.f14603i || i6 < 0) {
                throw C4152d.m14253h();
            }
            return true;
        }
        throw new IllegalStateException("refillBuffer() called when buffer wasn't empty.");
    }

    /* renamed from: a */
    public byte m13852a() {
        if (this.f14597c == this.f14593a) {
            m13850a(true);
        }
        byte[] bArr = this.f14595a;
        int i2 = this.f14597c;
        this.f14597c = i2 + 1;
        return bArr[i2];
    }

    /* renamed from: a */
    public byte[] m13863a(int i2) {
        if (i2 >= 0) {
            int i3 = this.f14599e;
            int i4 = this.f14597c;
            int i5 = i3 + i4 + i2;
            int i6 = this.f14600f;
            if (i5 <= i6) {
                int i7 = this.f14593a;
                if (i2 <= i7 - i4) {
                    byte[] bArr = new byte[i2];
                    System.arraycopy(this.f14595a, i4, bArr, 0, i2);
                    this.f14597c += i2;
                    return bArr;
                }
                if (i2 < 4096) {
                    byte[] bArr2 = new byte[i2];
                    int i8 = i7 - i4;
                    System.arraycopy(this.f14595a, i4, bArr2, 0, i8);
                    this.f14597c = this.f14593a;
                    m13850a(true);
                    while (true) {
                        int i9 = i2 - i8;
                        int i10 = this.f14593a;
                        if (i9 > i10) {
                            System.arraycopy(this.f14595a, 0, bArr2, i8, i10);
                            int i11 = this.f14593a;
                            i8 += i11;
                            this.f14597c = i11;
                            m13850a(true);
                        } else {
                            System.arraycopy(this.f14595a, 0, bArr2, i8, i9);
                            this.f14597c = i9;
                            return bArr2;
                        }
                    }
                } else {
                    this.f14599e = i3 + i7;
                    this.f14597c = 0;
                    this.f14593a = 0;
                    int i12 = i7 - i4;
                    int i13 = i2 - i12;
                    Vector vector = new Vector();
                    while (i13 > 0) {
                        byte[] bArr3 = new byte[Math.min(i13, 4096)];
                        int i14 = 0;
                        while (i14 < bArr3.length) {
                            InputStream inputStream = this.f14594a;
                            int read = inputStream == null ? -1 : inputStream.read(bArr3, i14, bArr3.length - i14);
                            if (read == -1) {
                                throw C4152d.m14246a();
                            }
                            this.f14599e += read;
                            i14 += read;
                        }
                        i13 -= bArr3.length;
                        vector.addElement(bArr3);
                    }
                    byte[] bArr4 = new byte[i2];
                    System.arraycopy(this.f14595a, i4, bArr4, 0, i12);
                    for (int i15 = 0; i15 < vector.size(); i15++) {
                        byte[] bArr5 = (byte[]) vector.elementAt(i15);
                        System.arraycopy(bArr5, 0, bArr4, i12, bArr5.length);
                        i12 += bArr5.length;
                    }
                    return bArr4;
                }
            } else {
                m13870c((i6 - i3) - i4);
                throw C4152d.m14246a();
            }
        } else {
            throw C4152d.m14247b();
        }
    }
}
