package com.xiaomi.push.service;

import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.mipush.sdk.Constants;

/* JADX INFO: loaded from: classes2.dex */
public class ar {
    private static int a = 8;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f9386d = -666;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f1010a = new byte[256];

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f9385c = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9384b = 0;

    public static int a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    private void a(int i2, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i3 = 0; i3 < 256; i3++) {
            this.f1010a[i3] = (byte) i3;
        }
        this.f9385c = 0;
        this.f9384b = 0;
        while (true) {
            int i4 = this.f9384b;
            if (i4 >= i2) {
                break;
            }
            this.f9385c = ((this.f9385c + a(this.f1010a[i4])) + a(bArr[this.f9384b % length])) % 256;
            a(this.f1010a, this.f9384b, this.f9385c);
            this.f9384b++;
        }
        if (i2 != 256) {
            this.f9386d = ((this.f9385c + a(this.f1010a[i2])) + a(bArr[i2 % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i5 = i2 - 1;
            sb.append(i5);
            sb.append(Constants.COLON_SEPARATOR);
            for (int i6 = 0; i6 <= i2; i6++) {
                sb.append(d.c.a.b.a.a.f10074g);
                sb.append(a(this.f1010a[i6]));
            }
            sb.append("   j_");
            sb.append(i5);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.f9385c);
            sb.append("   j_");
            sb.append(i2);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.f9386d);
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i5);
            sb.append("]=");
            sb.append(a(this.f1010a[this.f9385c]));
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i2);
            sb.append("]=");
            sb.append(a(this.f1010a[this.f9386d]));
            if (this.f1010a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            com.xiaomi.channel.commonutils.logger.b.m48a(sb.toString());
        }
    }

    private void a(byte[] bArr) {
        a(256, bArr, false);
    }

    private void a() {
        this.f9385c = 0;
        this.f9384b = 0;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    byte m700a() {
        this.f9384b = (this.f9384b + 1) % 256;
        this.f9385c = (this.f9385c + a(this.f1010a[this.f9384b])) % 256;
        a(this.f1010a, this.f9384b, this.f9385c);
        byte[] bArr = this.f1010a;
        return bArr[(a(bArr[this.f9384b]) + a(this.f1010a[this.f9385c])) % 256];
    }

    private static void a(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2];
        bArr[i2] = bArr[i3];
        bArr[i3] = b2;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        ar arVar = new ar();
        arVar.a(bArr);
        arVar.a();
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr3[i2] = (byte) (bArr2[i2] ^ arVar.m700a());
        }
        return bArr3;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, boolean z, int i2, int i3) {
        byte[] bArr3;
        int i4;
        if (i2 >= 0 && i2 <= bArr2.length && i2 + i3 <= bArr2.length) {
            if (z) {
                bArr3 = bArr2;
                i4 = i2;
            } else {
                bArr3 = new byte[i3];
                i4 = 0;
            }
            ar arVar = new ar();
            arVar.a(bArr);
            arVar.a();
            for (int i5 = 0; i5 < i3; i5++) {
                bArr3[i4 + i5] = (byte) (bArr2[i2 + i5] ^ arVar.m700a());
            }
            return bArr3;
        }
        throw new IllegalArgumentException("start = " + i2 + " len = " + i3);
    }

    public static byte[] a(byte[] bArr, String str) {
        return a(bArr, com.xiaomi.push.ay.m159a(str));
    }

    public static byte[] a(String str, String str2) {
        byte[] bArrM159a = com.xiaomi.push.ay.m159a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[bArrM159a.length + 1 + bytes.length];
        for (int i2 = 0; i2 < bArrM159a.length; i2++) {
            bArr[i2] = bArrM159a[i2];
        }
        bArr[bArrM159a.length] = 95;
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[bArrM159a.length + 1 + i3] = bytes[i3];
        }
        return bArr;
    }
}
