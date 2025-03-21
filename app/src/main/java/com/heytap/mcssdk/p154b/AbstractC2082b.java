package com.heytap.mcssdk.p154b;

import p324i.p325a.p326a.p327a.C5760e;
import p324i.p325a.p326a.p327a.C5762g;
import p324i.p325a.p326a.p327a.InterfaceC5756a;
import p324i.p325a.p326a.p327a.InterfaceC5757b;
import p324i.p325a.p326a.p327a.p328k.C5777l;

/* renamed from: com.heytap.mcssdk.b.b */
/* loaded from: classes.dex */
public abstract class AbstractC2082b implements InterfaceC5756a, InterfaceC5757b {

    /* renamed from: l */
    public static final int f6095l = 76;

    /* renamed from: m */
    public static final int f6096m = 64;

    /* renamed from: n */
    private static final int f6097n = 2;

    /* renamed from: o */
    private static final int f6098o = 8192;

    /* renamed from: p */
    protected static final int f6099p = 255;

    /* renamed from: q */
    protected static final byte f6100q = 61;

    /* renamed from: a */
    protected final byte f6101a = f6100q;

    /* renamed from: b */
    private final int f6102b;

    /* renamed from: c */
    private final int f6103c;

    /* renamed from: d */
    protected final int f6104d;

    /* renamed from: e */
    private final int f6105e;

    /* renamed from: f */
    protected byte[] f6106f;

    /* renamed from: g */
    protected int f6107g;

    /* renamed from: h */
    private int f6108h;

    /* renamed from: i */
    protected boolean f6109i;

    /* renamed from: j */
    protected int f6110j;

    /* renamed from: k */
    protected int f6111k;

    protected AbstractC2082b(int i2, int i3, int i4, int i5) {
        this.f6102b = i2;
        this.f6103c = i3;
        this.f6104d = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f6105e = i5;
    }

    /* renamed from: b */
    protected static boolean m5773b(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    /* renamed from: d */
    private void m5774d() {
        byte[] bArr = this.f6106f;
        if (bArr == null) {
            this.f6106f = new byte[m5784c()];
            this.f6107g = 0;
            this.f6108h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f6106f = bArr2;
        }
    }

    /* renamed from: e */
    private void m5775e() {
        this.f6106f = null;
        this.f6107g = 0;
        this.f6108h = 0;
        this.f6110j = 0;
        this.f6111k = 0;
        this.f6109i = false;
    }

    /* renamed from: a */
    public String m5776a(byte[] bArr) {
        return C5777l.m24217f(encode(bArr));
    }

    /* renamed from: a */
    protected void m5777a(int i2) {
        byte[] bArr = this.f6106f;
        if (bArr == null || bArr.length < this.f6107g + i2) {
            m5774d();
        }
    }

    /* renamed from: a */
    abstract void mo5769a(byte[] bArr, int i2, int i3);

    /* renamed from: a */
    boolean m5778a() {
        return this.f6106f != null;
    }

    /* renamed from: a */
    protected abstract boolean mo5770a(byte b2);

    /* renamed from: a */
    public boolean m5779a(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!mo5770a(bArr[i2]) && (!z || (bArr[i2] != 61 && !m5773b(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public byte[] m5780a(String str) {
        return decode(C5777l.m24218f(str));
    }

    /* renamed from: b */
    int m5781b() {
        if (this.f6106f != null) {
            return this.f6107g - this.f6108h;
        }
        return 0;
    }

    /* renamed from: b */
    public String m5782b(byte[] bArr) {
        return C5777l.m24217f(encode(bArr));
    }

    /* renamed from: b */
    abstract void mo5771b(byte[] bArr, int i2, int i3);

    /* renamed from: b */
    public boolean m5783b(String str) {
        return m5779a(C5777l.m24218f(str), true);
    }

    /* renamed from: c */
    protected int m5784c() {
        return 8192;
    }

    /* renamed from: c */
    int m5785c(byte[] bArr, int i2, int i3) {
        if (this.f6106f == null) {
            return this.f6109i ? -1 : 0;
        }
        int min = Math.min(m5781b(), i3);
        System.arraycopy(this.f6106f, this.f6108h, bArr, i2, min);
        this.f6108h += min;
        if (this.f6108h >= this.f6107g) {
            this.f6106f = null;
        }
        return min;
    }

    /* renamed from: c */
    protected boolean m5786c(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || mo5770a(b2)) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: d */
    public long m5787d(byte[] bArr) {
        int length = bArr.length;
        int i2 = this.f6102b;
        long j2 = (((length + i2) - 1) / i2) * this.f6103c;
        int i3 = this.f6104d;
        return i3 > 0 ? j2 + ((((i3 + j2) - 1) / i3) * this.f6105e) : j2;
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5759d
    public Object decode(Object obj) {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return m5780a((String) obj);
        }
        throw new C5760e("Parameter supplied to Base-N decode is not a byte[] or a String");
    }

    @Override // p324i.p325a.p326a.p327a.InterfaceC5756a
    public byte[] decode(byte[] bArr) {
        m5775e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo5771b(bArr, 0, bArr.length);
        mo5771b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f6107g];
        m5785c(bArr2, 0, bArr2.length);
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
        m5775e();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        mo5769a(bArr, 0, bArr.length);
        mo5769a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f6107g - this.f6108h];
        m5785c(bArr2, 0, bArr2.length);
        return bArr2;
    }
}
