package com.heytap.mcssdk.b;

import j.a.a.a.e;
import j.a.a.a.g;
import j.a.a.a.k.l;

/* JADX INFO: loaded from: classes.dex */
public abstract class b implements j.a.a.a.a, j.a.a.a.b {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f3847l = 76;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f3848m = 64;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f3849n = 2;
    private static final int o = 8192;
    protected static final int p = 255;
    protected static final byte q = 61;
    protected final byte a = q;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f3850b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f3851c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected final int f3852d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f3853e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected byte[] f3854f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    protected int f3855g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private int f3856h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    protected boolean f3857i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    protected int f3858j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    protected int f3859k;

    protected b(int i2, int i3, int i4, int i5) {
        this.f3850b = i2;
        this.f3851c = i3;
        this.f3852d = (i4 <= 0 || i5 <= 0) ? 0 : (i4 / i3) * i3;
        this.f3853e = i5;
    }

    protected static boolean b(byte b2) {
        return b2 == 9 || b2 == 10 || b2 == 13 || b2 == 32;
    }

    private void d() {
        byte[] bArr = this.f3854f;
        if (bArr == null) {
            this.f3854f = new byte[c()];
            this.f3855g = 0;
            this.f3856h = 0;
        } else {
            byte[] bArr2 = new byte[bArr.length * 2];
            System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
            this.f3854f = bArr2;
        }
    }

    private void e() {
        this.f3854f = null;
        this.f3855g = 0;
        this.f3856h = 0;
        this.f3858j = 0;
        this.f3859k = 0;
        this.f3857i = false;
    }

    public String a(byte[] bArr) {
        return l.f(encode(bArr));
    }

    protected void a(int i2) {
        byte[] bArr = this.f3854f;
        if (bArr == null || bArr.length < this.f3855g + i2) {
            d();
        }
    }

    abstract void a(byte[] bArr, int i2, int i3);

    boolean a() {
        return this.f3854f != null;
    }

    protected abstract boolean a(byte b2);

    public boolean a(byte[] bArr, boolean z) {
        for (int i2 = 0; i2 < bArr.length; i2++) {
            if (!a(bArr[i2]) && (!z || (bArr[i2] != 61 && !b(bArr[i2])))) {
                return false;
            }
        }
        return true;
    }

    public byte[] a(String str) {
        return decode(l.f(str));
    }

    int b() {
        if (this.f3854f != null) {
            return this.f3855g - this.f3856h;
        }
        return 0;
    }

    public String b(byte[] bArr) {
        return l.f(encode(bArr));
    }

    abstract void b(byte[] bArr, int i2, int i3);

    public boolean b(String str) {
        return a(l.f(str), true);
    }

    protected int c() {
        return 8192;
    }

    int c(byte[] bArr, int i2, int i3) {
        if (this.f3854f == null) {
            return this.f3857i ? -1 : 0;
        }
        int iMin = Math.min(b(), i3);
        System.arraycopy(this.f3854f, this.f3856h, bArr, i2, iMin);
        this.f3856h += iMin;
        if (this.f3856h >= this.f3855g) {
            this.f3854f = null;
        }
        return iMin;
    }

    protected boolean c(byte[] bArr) {
        if (bArr == null) {
            return false;
        }
        for (byte b2 : bArr) {
            if (61 == b2 || a(b2)) {
                return true;
            }
        }
        return false;
    }

    public long d(byte[] bArr) {
        int length = bArr.length;
        long j2 = ((long) (((length + r0) - 1) / this.f3850b)) * ((long) this.f3851c);
        int i2 = this.f3852d;
        return i2 > 0 ? j2 + ((((((long) i2) + j2) - 1) / ((long) i2)) * ((long) this.f3853e)) : j2;
    }

    @Override // j.a.a.a.d
    public Object decode(Object obj) throws e {
        if (obj instanceof byte[]) {
            return decode((byte[]) obj);
        }
        if (obj instanceof String) {
            return a((String) obj);
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
        byte[] bArr2 = new byte[this.f3855g];
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
        byte[] bArr2 = new byte[this.f3855g - this.f3856h];
        c(bArr2, 0, bArr2.length);
        return bArr2;
    }
}
