package com.heytap.msp.push.encrypt;

import j.a.a.a.e;
import j.a.a.a.g;
import j.a.a.a.k.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements j.a.a.a.a, j.a.a.a.b {
    private static final int a = 2;

    /* JADX INFO: renamed from: b */
    public static final int f3966b = 76;

    /* JADX INFO: renamed from: c */
    public static final int f3967c = 64;

    /* JADX INFO: renamed from: d */
    protected static final int f3968d = 255;

    /* JADX INFO: renamed from: e */
    protected static final byte f3969e = 61;

    /* JADX INFO: renamed from: m */
    private static final int f3970m = 8192;

    /* JADX INFO: renamed from: f */
    protected final byte f3971f = f3969e;

    /* JADX INFO: renamed from: g */
    protected final int f3972g;

    /* JADX INFO: renamed from: h */
    protected byte[] f3973h;

    /* JADX INFO: renamed from: i */
    protected int f3974i;

    /* JADX INFO: renamed from: j */
    protected boolean f3975j;

    /* JADX INFO: renamed from: k */
    protected int f3976k;

    /* JADX INFO: renamed from: l */
    protected int f3977l;

    /* JADX INFO: renamed from: n */
    private final int f3978n;
    private final int o;
    private final int p;
    private int q;

    protected b(int i2, int i3, int i4, int i5) {
        this.f3978n = i2;
        this.o = i3;
        this.f3972g = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.p = i5;
    }

    private void a() {
        byte[] bArr = this.f3973h;
        if (bArr == null) {
            this.f3973h = new byte[d()];
            this.f3974i = 0;
            this.q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f3973h = bArr2;
        }
    }

    protected static boolean c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void e() {
        this.f3973h = null;
        this.f3974i = 0;
        this.q = 0;
        this.f3976k = 0;
        this.f3977l = 0;
        this.f3975j = false;
    }

    protected void a(int i2) {
        byte[] bArr = this.f3973h;
        if (bArr == null || bArr.length < this.f3974i + i2) {
            a();
        }
    }

    abstract void a(byte[] bArr, int i2, int i3);

    abstract void b(byte[] bArr, int i2, int i3);

    boolean b() {
        return this.f3973h != null;
    }

    protected abstract boolean b(byte b2);

    public boolean b(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!b(bArr[i2]) && (!z || (bArr[i2] != 61 && !c(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    int c() {
        if (this.f3973h != null) {
            return this.f3974i - this.q;
        }
        return 0;
    }

    int c(byte[] bArr, int i2, int i3) {
        if (this.f3973h == null) {
            return this.f3975j ? -1 : 0;
        }
        int iMin = Math.min(c(), i3);
        System.arraycopy(this.f3973h, this.q, bArr, i2, iMin);
        this.q += iMin;
        if (this.q >= this.f3974i) {
            this.f3973h = null;
        }
        return iMin;
    }

    public byte[] c(String str) {
        return decode(l.f(str));
    }

    protected int d() {
        return 8192;
    }

    public boolean d(String str) {
        return b(l.f(str), true);
    }

    @Override // j.a.a.a.d
    public Object decode(Object obj) throws e {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return c((String) obj);
        }
        throw new e("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // j.a.a.a.a
    public byte[] decode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f3974i];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    @Override // j.a.a.a.f
    public Object encode(Object obj) throws g {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new g("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // j.a.a.a.b
    public byte[] encode(byte[] bArr) {
        e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f3974i - this.q];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    public String j(byte[] bArr) {
        return l.f(encode(bArr));
    }

    public String k(byte[] bArr) {
        return l.f(encode(bArr));
    }

    protected boolean l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || b(b2)) {
                return true;
            }
        }
        return false;
    }

    public long m(byte[] bArr) {
        int length = bArr.length;
        long j2 = ((long) (((length + r0) - 1) / this.f3978n)) * ((long) this.o);
        int i2 = this.f3972g;
        return i2 > 0 ? j2 + ((((((long) i2) + j2) - 1) / ((long) i2)) * ((long) this.p)) : j2;
    }
}
