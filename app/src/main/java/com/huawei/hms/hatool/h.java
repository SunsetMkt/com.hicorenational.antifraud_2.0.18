package com.huawei.hms.hatool;

/* JADX INFO: loaded from: classes.dex */
public class h {
    private byte[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f4740b = 0;

    public h(int i2) {
        this.a = null;
        this.a = new byte[i2];
    }

    public void a(byte[] bArr, int i2) {
        if (i2 <= 0) {
            return;
        }
        byte[] bArr2 = this.a;
        int length = bArr2.length;
        int i3 = this.f4740b;
        if (length - i3 >= i2) {
            System.arraycopy(bArr, 0, bArr2, i3, i2);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i2) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i3);
            System.arraycopy(bArr, 0, bArr3, this.f4740b, i2);
            this.a = bArr3;
        }
        this.f4740b += i2;
    }

    public byte[] a() {
        int i2 = this.f4740b;
        if (i2 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.a, 0, bArr, 0, i2);
        return bArr;
    }

    public int b() {
        return this.f4740b;
    }
}
