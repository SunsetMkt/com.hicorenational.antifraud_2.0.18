package com.xiaomi.push;

/* renamed from: com.xiaomi.push.a */
/* loaded from: classes2.dex */
public final class C4071a {

    /* renamed from: a */
    public static final C4071a f14473a = new C4071a(new byte[0]);

    /* renamed from: a */
    private volatile int f14474a = 0;

    /* renamed from: a */
    private final byte[] f14475a;

    private C4071a(byte[] bArr) {
        this.f14475a = bArr;
    }

    /* renamed from: a */
    public int m13689a() {
        return this.f14475a.length;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof C4071a)) {
            return false;
        }
        byte[] bArr = this.f14475a;
        int length = bArr.length;
        byte[] bArr2 = ((C4071a) obj).f14475a;
        if (length != bArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < length; i2++) {
            if (bArr[i2] != bArr2[i2]) {
                return false;
            }
        }
        return true;
    }

    public int hashCode() {
        int i2 = this.f14474a;
        if (i2 == 0) {
            byte[] bArr = this.f14475a;
            int length = bArr.length;
            for (byte b2 : bArr) {
                length = (length * 31) + b2;
            }
            i2 = length == 0 ? 1 : length;
            this.f14474a = i2;
        }
        return i2;
    }

    /* renamed from: a */
    public static C4071a m13688a(byte[] bArr, int i2, int i3) {
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i2, bArr2, 0, i3);
        return new C4071a(bArr2);
    }

    /* renamed from: a */
    public static C4071a m13687a(byte[] bArr) {
        return m13688a(bArr, 0, bArr.length);
    }

    /* renamed from: a */
    public byte[] m13690a() {
        byte[] bArr = this.f14475a;
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, 0, bArr2, 0, length);
        return bArr2;
    }
}
