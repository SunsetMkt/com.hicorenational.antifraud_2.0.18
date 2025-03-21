package com.heytap.msp.push.encrypt;

import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5756a;
import p324i.p325a.p326a.p327a.InterfaceC5757b;
import p324i.p325a.p326a.p327a.p328k.C5777l;

/* renamed from: com.heytap.msp.push.encrypt.b */
/* loaded from: classes.dex */
public abstract class AbstractC2111b implements InterfaceC5756a, InterfaceC5757b {

    /* renamed from: a */
    private static final int f6281a = 2;

    /* renamed from: b */
    public static final int f6282b = 76;

    /* renamed from: c */
    public static final int f6283c = 64;

    /* renamed from: d */
    protected static final int f6284d = 255;

    /* renamed from: e */
    protected static final byte f6285e = 61;

    /* renamed from: m */
    private static final int f6286m = 8192;

    /* renamed from: f */
    protected final byte f6287f = f6285e;

    /* renamed from: g */
    protected final int f6288g;

    /* renamed from: h */
    protected byte[] f6289h;

    /* renamed from: i */
    protected int f6290i;

    /* renamed from: j */
    protected boolean f6291j;

    /* renamed from: k */
    protected int f6292k;

    /* renamed from: l */
    protected int f6293l;

    /* renamed from: n */
    private final int f6294n;

    /* renamed from: o */
    private final int f6295o;

    /* renamed from: p */
    private final int f6296p;

    /* renamed from: q */
    private int f6297q;

    protected AbstractC2111b(int i2, int i3, int i4, int i5) {
        this.f6294n = i2;
        this.f6295o = i3;
        this.f6288g = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f6296p = i5;
    }

    /* renamed from: a */
    private void m5936a() {
        byte[] bArr = this.f6289h;
        if (bArr == null) {
            this.f6289h = new byte[m5945d()];
            this.f6290i = 0;
            this.f6297q = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f6289h = bArr2;
        }
    }

    /* renamed from: c */
    protected static boolean m5937c(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    /* renamed from: e */
    private void m5938e() {
        this.f6289h = null;
        this.f6290i = 0;
        this.f6297q = 0;
        this.f6292k = 0;
        this.f6293l = 0;
        this.f6291j = false;
    }

    /* renamed from: a */
    protected void m5939a(int i2) {
        byte[] bArr = this.f6289h;
        if (bArr == null || bArr.length < this.f6290i + i2) {
            m5936a();
        }
    }

    /* renamed from: a */
    abstract void mo5932a(byte[] bArr, int i2, int i3);

    /* renamed from: b */
    abstract void mo5934b(byte[] bArr, int i2, int i3);

    /* renamed from: b */
    boolean m5940b() {
        return this.f6289h != null;
    }

    /* renamed from: b */
    protected abstract boolean mo5935b(byte b2);

    /* renamed from: b */
    public boolean m5941b(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!mo5935b(bArr[i2]) && (!z || (bArr[i2] != 61 && !m5937c(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: c */
    int m5942c() {
        if (this.f6289h != null) {
            return this.f6290i - this.f6297q;
        }
        return 0;
    }

    /* renamed from: c */
    int m5943c(byte[] bArr, int i2, int i3) {
        if (this.f6289h == null) {
            return this.f6291j ? -1 : 0;
        }
        int min = Math.min(m5942c(), i3);
        System.arraycopy(this.f6289h, this.f6297q, bArr, i2, min);
        this.f6297q += min;
        if (this.f6297q >= this.f6290i) {
            this.f6289h = null;
        }
        return min;
    }

    /* renamed from: c */
    public byte[] m5944c(String str) {
        return decode(C5777l.m24218f(str));
    }

    /* renamed from: d */
    protected int m5945d() {
        return 8192;
    }

    /* renamed from: d */
    public boolean m5946d(String str) {
        return m5941b(C5777l.m24218f(str), true);
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return m5944c((String) obj);
        }
        throw new C5760e("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5756a
    public byte[] decode(byte[] bArr) {
        m5938e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo5934b(bArr, 0, bArr.length);
        mo5934b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f6290i];
        m5943c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5761f
    public Object encode(Object obj) {
        if (obj instanceof byte[]) {
            return encode((byte[]) obj);
        }
        throw new C5762g("Parameter supplied to Base-N encode is not a byte[]");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5757b
    public byte[] encode(byte[] bArr) {
        m5938e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo5932a(bArr, 0, bArr.length);
        mo5932a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f6290i - this.f6297q];
        m5943c(bArr2, 0, bArr2.length);
        return bArr2;
    }

    /* renamed from: j */
    public String m5947j(byte[] bArr) {
        return C5777l.m24217f(encode(bArr));
    }

    /* renamed from: k */
    public String m5948k(byte[] bArr) {
        return C5777l.m24217f(encode(bArr));
    }

    /* renamed from: l */
    protected boolean m5949l(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || mo5935b(b2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: m */
    public long m5950m(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f6294n;
        long j2 = (((length + i2) - 1) / i2) * this.f6295o;
        int i3 = this.f6288g;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.f6296p) : j2;
    }
}
