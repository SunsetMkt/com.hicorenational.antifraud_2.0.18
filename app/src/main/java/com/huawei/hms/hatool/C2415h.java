package com.huawei.hms.hatool;

/* renamed from: com.huawei.hms.hatool.h */
/* loaded from: classes.dex */
public class C2415h {

    /* renamed from: a */
    private byte[] f7523a;

    /* renamed from: b */
    private int f7524b = 0;

    public C2415h(int i2) {
        this.f7523a = null;
        this.f7523a = new byte[i2];
    }

    /* renamed from: a */
    public void m7150a(byte[] bArr, int i2) {
        if (i2 <= 0) {
            return;
        }
        byte[] bArr2 = this.f7523a;
        int length = bArr2.length;
        int i3 = this.f7524b;
        if (length - i3 >= i2) {
            System.arraycopy(bArr, 0, bArr2, i3, i2);
        } else {
            byte[] bArr3 = new byte[(bArr2.length + i2) << 1];
            System.arraycopy(bArr2, 0, bArr3, 0, i3);
            System.arraycopy(bArr, 0, bArr3, this.f7524b, i2);
            this.f7523a = bArr3;
        }
        this.f7524b += i2;
    }

    /* renamed from: a */
    public byte[] m7151a() {
        int i2 = this.f7524b;
        if (i2 <= 0) {
            return new byte[0];
        }
        byte[] bArr = new byte[i2];
        System.arraycopy(this.f7523a, 0, bArr, 0, i2);
        return bArr;
    }

    /* renamed from: b */
    public int m7152b() {
        return this.f7524b;
    }
}
