package com.umeng.analytics.pro;

/* JADX INFO: compiled from: TMemoryInputTransport.java */
/* JADX INFO: loaded from: classes2.dex */
public final class dc extends dd {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7221b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f7222c;

    public dc() {
    }

    public void a(byte[] bArr) {
        c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.dd
    public boolean a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.dd
    public void b() throws de {
    }

    @Override // com.umeng.analytics.pro.dd
    public void b(byte[] bArr, int i2, int i3) throws de {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.dd
    public void c() {
    }

    public void c(byte[] bArr, int i2, int i3) {
        this.a = bArr;
        this.f7221b = i2;
        this.f7222c = i2 + i3;
    }

    public void e() {
        this.a = null;
    }

    @Override // com.umeng.analytics.pro.dd
    public byte[] f() {
        return this.a;
    }

    @Override // com.umeng.analytics.pro.dd
    public int g() {
        return this.f7221b;
    }

    @Override // com.umeng.analytics.pro.dd
    public int h() {
        return this.f7222c - this.f7221b;
    }

    public dc(byte[] bArr) {
        a(bArr);
    }

    @Override // com.umeng.analytics.pro.dd
    public int a(byte[] bArr, int i2, int i3) throws de {
        int iH = h();
        if (i3 > iH) {
            i3 = iH;
        }
        if (i3 > 0) {
            System.arraycopy(this.a, this.f7221b, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    public dc(byte[] bArr, int i2, int i3) {
        c(bArr, i2, i3);
    }

    @Override // com.umeng.analytics.pro.dd
    public void a(int i2) {
        this.f7221b += i2;
    }
}
