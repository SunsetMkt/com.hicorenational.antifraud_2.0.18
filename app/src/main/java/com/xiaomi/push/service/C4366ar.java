package com.xiaomi.push.service;

import com.huawei.hms.framework.common.ContainerUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.mipush.sdk.Constants;
import com.xiaomi.push.C4096ay;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.service.ar */
/* loaded from: classes2.dex */
public class C4366ar {

    /* renamed from: a */
    private static int f16632a = 8;

    /* renamed from: d */
    private int f16636d = -666;

    /* renamed from: a */
    private byte[] f16633a = new byte[256];

    /* renamed from: c */
    private int f16635c = 0;

    /* renamed from: b */
    private int f16634b = 0;

    /* renamed from: a */
    public static int m15989a(byte b2) {
        return b2 >= 0 ? b2 : b2 + 256;
    }

    /* renamed from: a */
    private void m15991a(int i2, byte[] bArr, boolean z) {
        int length = bArr.length;
        for (int i3 = 0; i3 < 256; i3++) {
            this.f16633a[i3] = (byte) i3;
        }
        this.f16635c = 0;
        this.f16634b = 0;
        while (true) {
            int i4 = this.f16634b;
            if (i4 >= i2) {
                break;
            }
            this.f16635c = ((this.f16635c + m15989a(this.f16633a[i4])) + m15989a(bArr[this.f16634b % length])) % 256;
            m15993a(this.f16633a, this.f16634b, this.f16635c);
            this.f16634b++;
        }
        if (i2 != 256) {
            this.f16636d = ((this.f16635c + m15989a(this.f16633a[i2])) + m15989a(bArr[i2 % length])) % 256;
        }
        if (z) {
            StringBuilder sb = new StringBuilder();
            sb.append("S_");
            int i5 = i2 - 1;
            sb.append(i5);
            sb.append(Constants.COLON_SEPARATOR);
            for (int i6 = 0; i6 <= i2; i6++) {
                sb.append(AbstractC1191a.f2568g);
                sb.append(m15989a(this.f16633a[i6]));
            }
            sb.append("   j_");
            sb.append(i5);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.f16635c);
            sb.append("   j_");
            sb.append(i2);
            sb.append(ContainerUtils.KEY_VALUE_DELIMITER);
            sb.append(this.f16636d);
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i5);
            sb.append("]=");
            sb.append(m15989a(this.f16633a[this.f16635c]));
            sb.append("   S_");
            sb.append(i5);
            sb.append("[j_");
            sb.append(i2);
            sb.append("]=");
            sb.append(m15989a(this.f16633a[this.f16636d]));
            if (this.f16633a[1] != 0) {
                sb.append("   S[1]!=0");
            }
            AbstractC4022b.m13347a(sb.toString());
        }
    }

    /* renamed from: a */
    private void m15992a(byte[] bArr) {
        m15991a(256, bArr, false);
    }

    /* renamed from: a */
    private void m15990a() {
        this.f16635c = 0;
        this.f16634b = 0;
    }

    /* renamed from: a */
    byte m15998a() {
        this.f16634b = (this.f16634b + 1) % 256;
        this.f16635c = (this.f16635c + m15989a(this.f16633a[this.f16634b])) % 256;
        m15993a(this.f16633a, this.f16634b, this.f16635c);
        byte[] bArr = this.f16633a;
        return bArr[(m15989a(bArr[this.f16634b]) + m15989a(this.f16633a[this.f16635c])) % 256];
    }

    /* renamed from: a */
    private static void m15993a(byte[] bArr, int i2, int i3) {
        byte b2 = bArr[i2];
        bArr[i2] = bArr[i3];
        bArr[i3] = b2;
    }

    /* renamed from: a */
    public static byte[] m15996a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[bArr2.length];
        C4366ar c4366ar = new C4366ar();
        c4366ar.m15992a(bArr);
        c4366ar.m15990a();
        for (int i2 = 0; i2 < bArr2.length; i2++) {
            bArr3[i2] = (byte) (bArr2[i2] ^ c4366ar.m15998a());
        }
        return bArr3;
    }

    /* renamed from: a */
    public static byte[] m15997a(byte[] bArr, byte[] bArr2, boolean z, int i2, int i3) {
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
            C4366ar c4366ar = new C4366ar();
            c4366ar.m15992a(bArr);
            c4366ar.m15990a();
            for (int i5 = 0; i5 < i3; i5++) {
                bArr3[i4 + i5] = (byte) (bArr2[i2 + i5] ^ c4366ar.m15998a());
            }
            return bArr3;
        }
        throw new IllegalArgumentException("start = " + i2 + " len = " + i3);
    }

    /* renamed from: a */
    public static byte[] m15995a(byte[] bArr, String str) {
        return m15996a(bArr, C4096ay.m13840a(str));
    }

    /* renamed from: a */
    public static byte[] m15994a(String str, String str2) {
        byte[] m13840a = C4096ay.m13840a(str);
        byte[] bytes = str2.getBytes();
        byte[] bArr = new byte[m13840a.length + 1 + bytes.length];
        for (int i2 = 0; i2 < m13840a.length; i2++) {
            bArr[i2] = m13840a[i2];
        }
        bArr[m13840a.length] = 95;
        for (int i3 = 0; i3 < bytes.length; i3++) {
            bArr[m13840a.length + 1 + i3] = bytes[i3];
        }
        return bArr;
    }
}
