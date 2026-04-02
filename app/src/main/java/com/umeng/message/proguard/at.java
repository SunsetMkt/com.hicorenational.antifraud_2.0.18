package com.umeng.message.proguard;

/* JADX INFO: loaded from: classes2.dex */
abstract class at {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected byte[] f8005b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected int f8006c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected boolean f8007d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected int f8008e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    protected int f8009f;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f8012i;
    protected final byte a = 61;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f8010g = 3;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f8011h = 4;

    protected at() {
    }

    protected final void a(int i2) {
        byte[] bArr = this.f8005b;
        if (bArr == null || bArr.length < this.f8006c + i2) {
            byte[] bArr2 = this.f8005b;
            if (bArr2 == null) {
                this.f8005b = new byte[8192];
                this.f8006c = 0;
                this.f8012i = 0;
            } else {
                byte[] bArr3 = new byte[bArr2.length * 2];
                System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length);
                this.f8005b = bArr3;
            }
        }
    }

    abstract void a(byte[] bArr, int i2, int i3);

    abstract void b(byte[] bArr, int i2, int i3);

    public byte[] b(String str) {
        return e(str.getBytes());
    }

    public long c(byte[] bArr) {
        int length = bArr.length;
        return ((long) (((length + r0) - 1) / this.f8010g)) * ((long) this.f8011h);
    }

    public byte[] d(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        a(bArr, 0, bArr.length);
        a(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f8006c - this.f8012i];
        a(bArr2, bArr2.length);
        return bArr2;
    }

    public byte[] e(byte[] bArr) {
        a();
        if (bArr == null || bArr.length == 0) {
            return bArr;
        }
        b(bArr, 0, bArr.length);
        b(bArr, 0, -1);
        byte[] bArr2 = new byte[this.f8006c];
        a(bArr2, bArr2.length);
        return bArr2;
    }

    private int a(byte[] bArr, int i2) {
        byte[] bArr2 = this.f8005b;
        if (bArr2 == null) {
            return this.f8007d ? -1 : 0;
        }
        int iMin = Math.min(bArr2 != null ? this.f8006c - this.f8012i : 0, i2);
        System.arraycopy(this.f8005b, this.f8012i, bArr, 0, iMin);
        this.f8012i += iMin;
        if (this.f8012i >= this.f8006c) {
            this.f8005b = null;
        }
        return iMin;
    }

    private void a() {
        this.f8005b = null;
        this.f8006c = 0;
        this.f8012i = 0;
        this.f8008e = 0;
        this.f8009f = 0;
        this.f8007d = false;
    }
}
