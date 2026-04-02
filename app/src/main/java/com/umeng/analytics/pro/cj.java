package com.umeng.analytics.pro;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TCompactProtocol.java */
/* JADX INFO: loaded from: classes2.dex */
public class cj extends cp {

    /* JADX INFO: renamed from: d */
    private static final cu f7152d = new cu("");

    /* JADX INFO: renamed from: e */
    private static final ck f7153e = new ck("", (byte) 0, 0);

    /* JADX INFO: renamed from: f */
    private static final byte[] f7154f = new byte[16];

    /* JADX INFO: renamed from: h */
    private static final byte f7155h = -126;

    /* JADX INFO: renamed from: i */
    private static final byte f7156i = 1;

    /* JADX INFO: renamed from: j */
    private static final byte f7157j = 31;

    /* JADX INFO: renamed from: k */
    private static final byte f7158k = -32;

    /* JADX INFO: renamed from: l */
    private static final int f7159l = 5;
    byte[] a;

    /* JADX INFO: renamed from: b */
    byte[] f7160b;

    /* JADX INFO: renamed from: c */
    byte[] f7161c;

    /* JADX INFO: renamed from: m */
    private bo f7162m;

    /* JADX INFO: renamed from: n */
    private short f7163n;
    private ck o;
    private Boolean p;
    private final long q;
    private byte[] r;

    /* JADX INFO: compiled from: TCompactProtocol.java */
    private static class b {
        public static final byte a = 1;

        /* JADX INFO: renamed from: b */
        public static final byte f7164b = 2;

        /* JADX INFO: renamed from: c */
        public static final byte f7165c = 3;

        /* JADX INFO: renamed from: d */
        public static final byte f7166d = 4;

        /* JADX INFO: renamed from: e */
        public static final byte f7167e = 5;

        /* JADX INFO: renamed from: f */
        public static final byte f7168f = 6;

        /* JADX INFO: renamed from: g */
        public static final byte f7169g = 7;

        /* JADX INFO: renamed from: h */
        public static final byte f7170h = 8;

        /* JADX INFO: renamed from: i */
        public static final byte f7171i = 9;

        /* JADX INFO: renamed from: j */
        public static final byte f7172j = 10;

        /* JADX INFO: renamed from: k */
        public static final byte f7173k = 11;

        /* JADX INFO: renamed from: l */
        public static final byte f7174l = 12;

        private b() {
        }
    }

    static {
        byte[] bArr = f7154f;
        bArr[0] = 0;
        bArr[2] = 1;
        bArr[3] = 3;
        bArr[6] = 4;
        bArr[8] = 5;
        bArr[10] = 6;
        bArr[4] = 7;
        bArr[11] = 8;
        bArr[15] = 9;
        bArr[14] = 10;
        bArr[13] = 11;
        bArr[12] = 12;
    }

    public cj(dd ddVar, long j2) {
        super(ddVar);
        this.f7162m = new bo(15);
        this.f7163n = (short) 0;
        this.o = null;
        this.p = null;
        this.a = new byte[5];
        this.f7160b = new byte[10];
        this.r = new byte[1];
        this.f7161c = new byte[1];
        this.q = j2;
    }

    private int E() throws bw {
        int i2 = 0;
        if (this.f7185g.h() >= 5) {
            byte[] bArrF = this.f7185g.f();
            int iG = this.f7185g.g();
            int i3 = 0;
            int i4 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                i3 |= (b2 & i.q2.t.n.f12226b) << i4;
                if ((b2 & i.q2.t.n.a) != 128) {
                    this.f7185g.a(i2 + 1);
                    return i3;
                }
                i4 += 7;
                i2++;
            }
        } else {
            int i5 = 0;
            while (true) {
                byte bU = u();
                i2 |= (bU & i.q2.t.n.f12226b) << i5;
                if ((bU & i.q2.t.n.a) != 128) {
                    return i2;
                }
                i5 += 7;
            }
        }
    }

    private long F() throws bw {
        int i2 = 0;
        long j2 = 0;
        if (this.f7185g.h() >= 10) {
            byte[] bArrF = this.f7185g.f();
            int iG = this.f7185g.g();
            int i3 = 0;
            while (true) {
                byte b2 = bArrF[iG + i2];
                j2 |= ((long) (b2 & i.q2.t.n.f12226b)) << i3;
                if ((b2 & i.q2.t.n.a) != 128) {
                    break;
                }
                i3 += 7;
                i2++;
            }
            this.f7185g.a(i2 + 1);
        } else {
            while (true) {
                byte bU = u();
                j2 |= ((long) (bU & i.q2.t.n.f12226b)) << i2;
                if ((bU & i.q2.t.n.a) != 128) {
                    break;
                }
                i2 += 7;
            }
        }
        return j2;
    }

    private int c(int i2) {
        return (i2 >> 31) ^ (i2 << 1);
    }

    private long c(long j2) {
        return (j2 >> 63) ^ (j2 << 1);
    }

    private boolean c(byte b2) {
        int i2 = b2 & cw.f7205m;
        return i2 == 1 || i2 == 2;
    }

    private long d(long j2) {
        return (-(j2 & 1)) ^ (j2 >>> 1);
    }

    private byte[] e(int i2) throws bw {
        if (i2 == 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        this.f7185g.d(bArr, 0, i2);
        return bArr;
    }

    private void f(int i2) throws cq {
        if (i2 < 0) {
            throw new cq("Negative length: " + i2);
        }
        long j2 = this.q;
        if (j2 == -1 || i2 <= j2) {
            return;
        }
        throw new cq("Length exceeded max allowed: " + i2);
    }

    private int g(int i2) {
        return (-(i2 & 1)) ^ (i2 >>> 1);
    }

    @Override // com.umeng.analytics.pro.cp
    public ByteBuffer A() throws bw {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return ByteBuffer.wrap(new byte[0]);
        }
        byte[] bArr = new byte[iE];
        this.f7185g.d(bArr, 0, iE);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void B() {
        this.f7162m.c();
        this.f7163n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cp
    public void a() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cn cnVar) throws bw {
        b(f7155h);
        d(((cnVar.f7180b << 5) & (-32)) | 1);
        b(cnVar.f7181c);
        a(cnVar.a);
    }

    @Override // com.umeng.analytics.pro.cp
    public void b() throws bw {
        this.f7163n = this.f7162m.a();
    }

    @Override // com.umeng.analytics.pro.cp
    public void c() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void d() throws bw {
        b((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cp
    public void e() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void f() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public void g() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cn h() throws bw {
        byte bU = u();
        if (bU != -126) {
            throw new cq("Expected protocol id " + Integer.toHexString(-126) + " but got " + Integer.toHexString(bU));
        }
        byte bU2 = u();
        byte b2 = (byte) (bU2 & f7157j);
        if (b2 == 1) {
            return new cn(z(), (byte) ((bU2 >> 5) & 3), E());
        }
        throw new cq("Expected version 1 but got " + ((int) b2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void i() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cu j() throws bw {
        this.f7162m.a(this.f7163n);
        this.f7163n = (short) 0;
        return f7152d;
    }

    @Override // com.umeng.analytics.pro.cp
    public void k() throws bw {
        this.f7163n = this.f7162m.a();
    }

    @Override // com.umeng.analytics.pro.cp
    public ck l() throws bw {
        byte bU = u();
        if (bU == 0) {
            return f7153e;
        }
        short s = (short) ((bU & 240) >> 4);
        short sV = s == 0 ? v() : (short) (this.f7163n + s);
        byte b2 = (byte) (bU & cw.f7205m);
        ck ckVar = new ck("", d(b2), sV);
        if (c(bU)) {
            this.p = b2 == 1 ? Boolean.TRUE : Boolean.FALSE;
        }
        this.f7163n = ckVar.f7176c;
        return ckVar;
    }

    @Override // com.umeng.analytics.pro.cp
    public void m() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cm n() throws bw {
        int iE = E();
        byte bU = iE == 0 ? (byte) 0 : u();
        return new cm(d((byte) (bU >> 4)), d((byte) (bU & cw.f7205m)), iE);
    }

    @Override // com.umeng.analytics.pro.cp
    public void o() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public cl p() throws bw {
        byte bU = u();
        int iE = (bU >> 4) & 15;
        if (iE == 15) {
            iE = E();
        }
        return new cl(d(bU), iE);
    }

    @Override // com.umeng.analytics.pro.cp
    public void q() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public ct r() throws bw {
        return new ct(p());
    }

    @Override // com.umeng.analytics.pro.cp
    public void s() throws bw {
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean t() throws bw {
        Boolean bool = this.p;
        if (bool == null) {
            return u() == 1;
        }
        boolean zBooleanValue = bool.booleanValue();
        this.p = null;
        return zBooleanValue;
    }

    @Override // com.umeng.analytics.pro.cp
    public byte u() throws bw {
        if (this.f7185g.h() <= 0) {
            this.f7185g.d(this.f7161c, 0, 1);
            return this.f7161c[0];
        }
        byte b2 = this.f7185g.f()[this.f7185g.g()];
        this.f7185g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.cp
    public short v() throws bw {
        return (short) g(E());
    }

    @Override // com.umeng.analytics.pro.cp
    public int w() throws bw {
        return g(E());
    }

    @Override // com.umeng.analytics.pro.cp
    public long x() throws bw {
        return d(F());
    }

    @Override // com.umeng.analytics.pro.cp
    public double y() throws bw {
        byte[] bArr = new byte[8];
        this.f7185g.d(bArr, 0, 8);
        return Double.longBitsToDouble(a(bArr));
    }

    @Override // com.umeng.analytics.pro.cp
    public String z() throws bw {
        int iE = E();
        f(iE);
        if (iE == 0) {
            return "";
        }
        try {
            if (this.f7185g.h() < iE) {
                return new String(e(iE), "UTF-8");
            }
            String str = new String(this.f7185g.f(), this.f7185g.g(), iE, "UTF-8");
            this.f7185g.a(iE);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bw("UTF-8 not supported!");
        }
    }

    /* JADX INFO: compiled from: TCompactProtocol.java */
    public static class a implements cr {
        private final long a;

        public a() {
            this.a = -1L;
        }

        @Override // com.umeng.analytics.pro.cr
        public cp a(dd ddVar) {
            return new cj(ddVar, this.a);
        }

        public a(int i2) {
            this.a = i2;
        }
    }

    private void b(int i2) throws bw {
        int i3 = 0;
        while ((i2 & (-128)) != 0) {
            this.a[i3] = (byte) ((i2 & 127) | 128);
            i2 >>>= 7;
            i3++;
        }
        byte[] bArr = this.a;
        bArr[i3] = (byte) i2;
        this.f7185g.b(bArr, 0, i3 + 1);
    }

    private void d(int i2) throws bw {
        b((byte) i2);
    }

    private byte d(byte b2) throws cq {
        byte b3 = (byte) (b2 & cw.f7205m);
        switch (b3) {
            case 0:
                return (byte) 0;
            case 1:
            case 2:
                return (byte) 2;
            case 3:
                return (byte) 3;
            case 4:
                return (byte) 6;
            case 5:
                return (byte) 8;
            case 6:
                return (byte) 10;
            case 7:
                return (byte) 4;
            case 8:
                return (byte) 11;
            case 9:
                return cw.f7205m;
            case 10:
                return cw.f7204l;
            case 11:
                return cw.f7203k;
            case 12:
                return (byte) 12;
            default:
                throw new cq("don't know what type: " + ((int) b3));
        }
    }

    private byte e(byte b2) {
        return f7154f[b2];
    }

    private void b(long j2) throws bw {
        int i2 = 0;
        while (((-128) & j2) != 0) {
            this.f7160b[i2] = (byte) ((127 & j2) | 128);
            j2 >>>= 7;
            i2++;
        }
        byte[] bArr = this.f7160b;
        bArr[i2] = (byte) j2;
        this.f7185g.b(bArr, 0, i2 + 1);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cu cuVar) throws bw {
        this.f7162m.a(this.f7163n);
        this.f7163n = (short) 0;
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ck ckVar) throws bw {
        if (ckVar.f7175b == 2) {
            this.o = ckVar;
        } else {
            a(ckVar, (byte) -1);
        }
    }

    private void b(byte b2) throws bw {
        byte[] bArr = this.r;
        bArr[0] = b2;
        this.f7185g.b(bArr);
    }

    private void a(ck ckVar, byte b2) throws bw {
        if (b2 == -1) {
            b2 = e(ckVar.f7175b);
        }
        short s = ckVar.f7176c;
        short s2 = this.f7163n;
        if (s > s2 && s - s2 <= 15) {
            d(b2 | ((s - s2) << 4));
        } else {
            b(b2);
            a(ckVar.f7176c);
        }
        this.f7163n = ckVar.f7176c;
    }

    public cj(dd ddVar) {
        this(ddVar, -1L);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cm cmVar) throws bw {
        int i2 = cmVar.f7179c;
        if (i2 == 0) {
            d(0);
            return;
        }
        b(i2);
        d(e(cmVar.f7178b) | (e(cmVar.a) << 4));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cl clVar) throws bw {
        a(clVar.a, clVar.f7177b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ct ctVar) throws bw {
        a(ctVar.a, ctVar.f7193b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(boolean z) throws bw {
        ck ckVar = this.o;
        if (ckVar != null) {
            a(ckVar, z ? (byte) 1 : (byte) 2);
            this.o = null;
        } else {
            b(z ? (byte) 1 : (byte) 2);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(byte b2) throws bw {
        b(b2);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(short s) throws bw {
        b(c((int) s));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(int i2) throws bw {
        b(c(i2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(long j2) throws bw {
        b(c(j2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(double d2) throws bw {
        byte[] bArr = {0, 0, 0, 0, 0, 0, 0, 0};
        a(Double.doubleToLongBits(d2), bArr, 0);
        this.f7185g.b(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(String str) throws bw {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bw("UTF-8 not supported!");
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ByteBuffer byteBuffer) throws bw {
        a(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), byteBuffer.limit() - byteBuffer.position());
    }

    private void a(byte[] bArr, int i2, int i3) throws bw {
        b(i3);
        this.f7185g.b(bArr, i2, i3);
    }

    protected void a(byte b2, int i2) throws bw {
        if (i2 <= 14) {
            d(e(b2) | (i2 << 4));
        } else {
            d(e(b2) | 240);
            b(i2);
        }
    }

    private void a(long j2, byte[] bArr, int i2) {
        bArr[i2 + 0] = (byte) (j2 & 255);
        bArr[i2 + 1] = (byte) ((j2 >> 8) & 255);
        bArr[i2 + 2] = (byte) ((j2 >> 16) & 255);
        bArr[i2 + 3] = (byte) ((j2 >> 24) & 255);
        bArr[i2 + 4] = (byte) ((j2 >> 32) & 255);
        bArr[i2 + 5] = (byte) ((j2 >> 40) & 255);
        bArr[i2 + 6] = (byte) ((j2 >> 48) & 255);
        bArr[i2 + 7] = (byte) ((j2 >> 56) & 255);
    }

    private long a(byte[] bArr) {
        return ((((long) bArr[7]) & 255) << 56) | ((((long) bArr[6]) & 255) << 48) | ((((long) bArr[5]) & 255) << 40) | ((((long) bArr[4]) & 255) << 32) | ((((long) bArr[3]) & 255) << 24) | ((((long) bArr[2]) & 255) << 16) | ((((long) bArr[1]) & 255) << 8) | (255 & ((long) bArr[0]));
    }
}
