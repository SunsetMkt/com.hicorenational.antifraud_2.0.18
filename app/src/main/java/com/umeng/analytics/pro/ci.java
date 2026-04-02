package com.umeng.analytics.pro;

import i.f1;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: TBinaryProtocol.java */
/* JADX INFO: loaded from: classes2.dex */
public class ci extends cp {
    protected static final int a = -65536;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected static final int f7138b = -2147418112;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final cu f7139h = new cu();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected boolean f7140c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f7141d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f7142e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected boolean f7143f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private byte[] f7144i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private byte[] f7145j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private byte[] f7146k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private byte[] f7147l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private byte[] f7148m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private byte[] f7149n;
    private byte[] o;
    private byte[] p;

    /* JADX INFO: compiled from: TBinaryProtocol.java */
    public static class a implements cr {
        protected boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        protected boolean f7150b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        protected int f7151c;

        public a() {
            this(false, true);
        }

        @Override // com.umeng.analytics.pro.cr
        public cp a(dd ddVar) {
            ci ciVar = new ci(ddVar, this.a, this.f7150b);
            int i2 = this.f7151c;
            if (i2 != 0) {
                ciVar.c(i2);
            }
            return ciVar;
        }

        public a(boolean z, boolean z2) {
            this(z, z2, 0);
        }

        public a(boolean z, boolean z2, int i2) {
            this.a = false;
            this.f7150b = true;
            this.a = z;
            this.f7150b = z2;
            this.f7151c = i2;
        }
    }

    public ci(dd ddVar) {
        this(ddVar, false, true);
    }

    @Override // com.umeng.analytics.pro.cp
    public ByteBuffer A() throws bw {
        int iW = w();
        d(iW);
        if (this.f7185g.h() >= iW) {
            ByteBuffer byteBufferWrap = ByteBuffer.wrap(this.f7185g.f(), this.f7185g.g(), iW);
            this.f7185g.a(iW);
            return byteBufferWrap;
        }
        byte[] bArr = new byte[iW];
        this.f7185g.d(bArr, 0, iW);
        return ByteBuffer.wrap(bArr);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cn cnVar) throws bw {
        if (this.f7141d) {
            a(f7138b | cnVar.f7180b);
            a(cnVar.a);
            a(cnVar.f7181c);
        } else {
            a(cnVar.a);
            a(cnVar.f7180b);
            a(cnVar.f7181c);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cu cuVar) {
    }

    public String b(int i2) throws bw {
        try {
            d(i2);
            byte[] bArr = new byte[i2];
            this.f7185g.d(bArr, 0, i2);
            return new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void b() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void c() {
    }

    public void c(int i2) {
        this.f7142e = i2;
        this.f7143f = true;
    }

    @Override // com.umeng.analytics.pro.cp
    public void d() throws bw {
        a((byte) 0);
    }

    @Override // com.umeng.analytics.pro.cp
    public void e() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void f() {
    }

    @Override // com.umeng.analytics.pro.cp
    public void g() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cn h() throws bw {
        int iW = w();
        if (iW < 0) {
            if (((-65536) & iW) == f7138b) {
                return new cn(z(), (byte) (iW & 255), w());
            }
            throw new cq(4, "Bad version in readMessageBegin");
        }
        if (this.f7140c) {
            throw new cq(4, "Missing version in readMessageBegin, old client?");
        }
        return new cn(b(iW), u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void i() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cu j() {
        return f7139h;
    }

    @Override // com.umeng.analytics.pro.cp
    public void k() {
    }

    @Override // com.umeng.analytics.pro.cp
    public ck l() throws bw {
        byte bU = u();
        return new ck("", bU, bU == 0 ? (short) 0 : v());
    }

    @Override // com.umeng.analytics.pro.cp
    public void m() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cm n() throws bw {
        return new cm(u(), u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void o() {
    }

    @Override // com.umeng.analytics.pro.cp
    public cl p() throws bw {
        return new cl(u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void q() {
    }

    @Override // com.umeng.analytics.pro.cp
    public ct r() throws bw {
        return new ct(u(), w());
    }

    @Override // com.umeng.analytics.pro.cp
    public void s() {
    }

    @Override // com.umeng.analytics.pro.cp
    public boolean t() throws bw {
        return u() == 1;
    }

    @Override // com.umeng.analytics.pro.cp
    public byte u() throws bw {
        if (this.f7185g.h() < 1) {
            a(this.f7148m, 0, 1);
            return this.f7148m[0];
        }
        byte b2 = this.f7185g.f()[this.f7185g.g()];
        this.f7185g.a(1);
        return b2;
    }

    @Override // com.umeng.analytics.pro.cp
    public short v() throws bw {
        byte[] bArrF = this.f7149n;
        int iG = 0;
        if (this.f7185g.h() >= 2) {
            bArrF = this.f7185g.f();
            iG = this.f7185g.g();
            this.f7185g.a(2);
        } else {
            a(this.f7149n, 0, 2);
        }
        return (short) ((bArrF[iG + 1] & f1.f12066c) | ((bArrF[iG] & f1.f12066c) << 8));
    }

    @Override // com.umeng.analytics.pro.cp
    public int w() throws bw {
        byte[] bArrF = this.o;
        int iG = 0;
        if (this.f7185g.h() >= 4) {
            bArrF = this.f7185g.f();
            iG = this.f7185g.g();
            this.f7185g.a(4);
        } else {
            a(this.o, 0, 4);
        }
        return (bArrF[iG + 3] & f1.f12066c) | ((bArrF[iG] & f1.f12066c) << 24) | ((bArrF[iG + 1] & f1.f12066c) << 16) | ((bArrF[iG + 2] & f1.f12066c) << 8);
    }

    @Override // com.umeng.analytics.pro.cp
    public long x() throws bw {
        byte[] bArrF = this.p;
        int iG = 0;
        if (this.f7185g.h() >= 8) {
            bArrF = this.f7185g.f();
            iG = this.f7185g.g();
            this.f7185g.a(8);
        } else {
            a(this.p, 0, 8);
        }
        return ((long) (bArrF[iG + 7] & f1.f12066c)) | (((long) (bArrF[iG] & f1.f12066c)) << 56) | (((long) (bArrF[iG + 1] & f1.f12066c)) << 48) | (((long) (bArrF[iG + 2] & f1.f12066c)) << 40) | (((long) (bArrF[iG + 3] & f1.f12066c)) << 32) | (((long) (bArrF[iG + 4] & f1.f12066c)) << 24) | (((long) (bArrF[iG + 5] & f1.f12066c)) << 16) | (((long) (bArrF[iG + 6] & f1.f12066c)) << 8);
    }

    @Override // com.umeng.analytics.pro.cp
    public double y() throws bw {
        return Double.longBitsToDouble(x());
    }

    @Override // com.umeng.analytics.pro.cp
    public String z() throws bw {
        int iW = w();
        if (this.f7185g.h() < iW) {
            return b(iW);
        }
        try {
            String str = new String(this.f7185g.f(), this.f7185g.g(), iW, "UTF-8");
            this.f7185g.a(iW);
            return str;
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    public ci(dd ddVar, boolean z, boolean z2) {
        super(ddVar);
        this.f7140c = false;
        this.f7141d = true;
        this.f7143f = false;
        this.f7144i = new byte[1];
        this.f7145j = new byte[2];
        this.f7146k = new byte[4];
        this.f7147l = new byte[8];
        this.f7148m = new byte[1];
        this.f7149n = new byte[2];
        this.o = new byte[4];
        this.p = new byte[8];
        this.f7140c = z;
        this.f7141d = z2;
    }

    protected void d(int i2) throws bw {
        if (i2 < 0) {
            throw new cq("Negative length: " + i2);
        }
        if (this.f7143f) {
            this.f7142e -= i2;
            if (this.f7142e >= 0) {
                return;
            }
            throw new cq("Message length exceeded: " + i2);
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ck ckVar) throws bw {
        a(ckVar.f7175b);
        a(ckVar.f7176c);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cm cmVar) throws bw {
        a(cmVar.a);
        a(cmVar.f7178b);
        a(cmVar.f7179c);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(cl clVar) throws bw {
        a(clVar.a);
        a(clVar.f7177b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ct ctVar) throws bw {
        a(ctVar.a);
        a(ctVar.f7193b);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(boolean z) throws bw {
        a(z ? (byte) 1 : (byte) 0);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(byte b2) throws bw {
        byte[] bArr = this.f7144i;
        bArr[0] = b2;
        this.f7185g.b(bArr, 0, 1);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(short s) throws bw {
        byte[] bArr = this.f7145j;
        bArr[0] = (byte) ((s >> 8) & 255);
        bArr[1] = (byte) (s & 255);
        this.f7185g.b(bArr, 0, 2);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(int i2) throws bw {
        byte[] bArr = this.f7146k;
        bArr[0] = (byte) ((i2 >> 24) & 255);
        bArr[1] = (byte) ((i2 >> 16) & 255);
        bArr[2] = (byte) ((i2 >> 8) & 255);
        bArr[3] = (byte) (i2 & 255);
        this.f7185g.b(bArr, 0, 4);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(long j2) throws bw {
        byte[] bArr = this.f7147l;
        bArr[0] = (byte) ((j2 >> 56) & 255);
        bArr[1] = (byte) ((j2 >> 48) & 255);
        bArr[2] = (byte) ((j2 >> 40) & 255);
        bArr[3] = (byte) ((j2 >> 32) & 255);
        bArr[4] = (byte) ((j2 >> 24) & 255);
        bArr[5] = (byte) ((j2 >> 16) & 255);
        bArr[6] = (byte) ((j2 >> 8) & 255);
        bArr[7] = (byte) (j2 & 255);
        this.f7185g.b(bArr, 0, 8);
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(double d2) throws bw {
        a(Double.doubleToLongBits(d2));
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(String str) throws bw {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            a(bytes.length);
            this.f7185g.b(bytes, 0, bytes.length);
        } catch (UnsupportedEncodingException unused) {
            throw new bw("JVM DOES NOT SUPPORT UTF-8");
        }
    }

    @Override // com.umeng.analytics.pro.cp
    public void a(ByteBuffer byteBuffer) throws bw {
        int iLimit = byteBuffer.limit() - byteBuffer.position();
        a(iLimit);
        this.f7185g.b(byteBuffer.array(), byteBuffer.position() + byteBuffer.arrayOffset(), iLimit);
    }

    private int a(byte[] bArr, int i2, int i3) throws bw {
        d(i3);
        return this.f7185g.d(bArr, i2, i3);
    }
}
