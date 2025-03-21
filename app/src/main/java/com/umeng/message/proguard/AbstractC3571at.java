package com.umeng.message.proguard;

/* renamed from: com.umeng.message.proguard.at */
/* loaded from: classes2.dex */
abstract class AbstractC3571at {

    /* renamed from: b */
    protected byte[] f13234b;

    /* renamed from: c */
    protected int f13235c;

    /* renamed from: d */
    protected boolean f13236d;

    /* renamed from: e */
    protected int f13237e;

    /* renamed from: f */
    protected int f13238f;

    /* renamed from: i */
    private int f13241i;

    /* renamed from: a */
    protected final byte f13233a = 61;

    /* renamed from: g */
    private final int f13239g = 3;

    /* renamed from: h */
    private final int f13240h = 4;

    protected AbstractC3571at() {
    }

    /* renamed from: a */
    protected final void m12305a(int i2) {
        byte[] bArr = this.f13234b;
        if (bArr == null || bArr.length < this.f13235c + i2) {
            byte[] bArr2 = this.f13234b;
            if (bArr2 == null) {
                this.f13234b = new byte[8192];
                this.f13235c = 0;
                this.f13241i = 0;
            } else {
                byte[] bArr3 = new byte[bArr2.length * 2];
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                this.f13234b = bArr3;
            }
        }
    }

    /* renamed from: a */
    abstract void mo12297a(byte[] bArr, int i2, int i3);

    /* renamed from: b */
    abstract void mo12298b(byte[] bArr, int i2, int i3);

    /* renamed from: b */
    public byte[] mo12299b(String str) {
        return mo12302e(str.getBytes());
    }

    /* renamed from: c */
    public long mo12300c(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f13239g;
        return (((length + i2) - 1) / i2) * this.f13240h;
    }

    /* renamed from: d */
    public byte[] mo12301d(byte[] bArr) {
        m12304a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo12297a(bArr, 0, bArr.length);
        mo12297a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f13235c - this.f13241i];
        m12303a(bArr2, bArr2.length);
        return bArr2;
    }

    /* renamed from: e */
    public byte[] mo12302e(byte[] bArr) {
        m12304a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo12298b(bArr, 0, bArr.length);
        mo12298b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f13235c];
        m12303a(bArr2, bArr2.length);
        return bArr2;
    }

    /* renamed from: a */
    private int m12303a(byte[] bArr, int i2) {
        byte[] bArr2 = this.f13234b;
        if (bArr2 == null) {
            return this.f13236d ? -1 : 0;
        }
        int min = Math.min(bArr2 != null ? this.f13235c - this.f13241i : 0, i2);
        System.arraycopy(this.f13234b, this.f13241i, bArr, 0, min);
        this.f13241i += min;
        if (this.f13241i >= this.f13235c) {
            this.f13234b = null;
        }
        return min;
    }

    /* renamed from: a */
    private void m12304a() {
        this.f13234b = null;
        this.f13235c = 0;
        this.f13241i = 0;
        this.f13237e = 0;
        this.f13238f = 0;
        this.f13236d = false;
    }
}
