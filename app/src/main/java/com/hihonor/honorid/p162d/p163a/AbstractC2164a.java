package com.hihonor.honorid.p162d.p163a;

import com.umeng.analytics.pro.C3393cw;
import java.util.Locale;
import p286h.C5230f1;
import p286h.p309q2.p311t.C5558n;

/* compiled from: Hex.java */
/* renamed from: com.hihonor.honorid.d.a.a */
/* loaded from: classes.dex */
public abstract class AbstractC2164a {

    /* renamed from: a */
    public static final String f6715a = "248CCA91412";

    /* renamed from: b */
    public static final String f6716b = "71D3BA3BC921CD6F";

    /* renamed from: c */
    public static final String f6717c = "fbhp";

    /* renamed from: d */
    public static final byte[] f6718d = {-115, -65, 76, 20, 59, -33, 65, -114, -25, -81, 33, 17, -71, -83, -80, -30, -120, 110, -47, -35, -81, 3, 28, 33, C5558n.f20402b, 93, 0, 58, 90, 116, 81, -86, 100, -60, -6, -65, 48, 109, 117, -73, 100, 114, -33, 48, 0, 119, -96, 70, -126, -44, 105, -14, 9, C3393cw.f11873m, 38, -93, 72, 87, -91, -68, 1, 116, 87, -76, 116, 99, 65, 34, -108, 91, 88, -46, -28, 4, 57, 115, -2, -46, 44, 48, -5, 107, C3393cw.f11872l, 99, 5, 62, 27, -41, 47, 50, 21, 90, -6, 33, 35, 85, 56, 57, 53, 73, 42, -37, 56, -41, C5558n.f20402b, 24, -21, -72, 38, -31, 36, -21, -113, -32, 97, -55, 116, -74, 93, 124, 81, 99, C3393cw.f11873m, 31, 125, -106, 62, -7, 75, -48, 85, 12, 11, 52, -53, C3393cw.f11872l, -62, 18, 37, -17, 51, 32, -5, 87, -60, -19, -78, -15, -3, -56, 89, -74, -10, 126, 8, 79, 72, -53, 40, -11};

    /* renamed from: a */
    public static String m6300a(byte[] bArr, int i2) {
        StringBuffer stringBuffer = new StringBuffer();
        if (bArr == null) {
            return null;
        }
        if (i2 <= 0 || i2 > bArr.length) {
            i2 = bArr.length;
        }
        for (int i3 = 0; i3 < i2; i3++) {
            String hexString = Integer.toHexString(bArr[i3] & C5230f1.f20085c);
            if (hexString.length() == 1) {
                hexString = "0" + hexString;
            }
            stringBuffer.append(hexString.toUpperCase(Locale.ENGLISH));
        }
        return stringBuffer.toString();
    }

    /* renamed from: a */
    public static byte[] m6301a(String str) {
        if (str == null) {
            return new byte[0];
        }
        int length = str.length();
        if (length % 2 != 0) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = upperCase.charAt(i2);
            if (('0' > charAt || charAt > '9') && ('A' > charAt || charAt > 'F')) {
                return new byte[0];
            }
        }
        int i3 = length / 2;
        byte[] bArr = new byte[i3];
        byte[] bArr2 = new byte[2];
        int i4 = 0;
        for (int i5 = 0; i5 < i3; i5++) {
            int i6 = i4 + 1;
            bArr2[0] = (byte) upperCase.charAt(i4);
            i4 = i6 + 1;
            bArr2[1] = (byte) upperCase.charAt(i6);
            for (int i7 = 0; i7 < 2; i7++) {
                if (65 <= bArr2[i7] && bArr2[i7] <= 70) {
                    bArr2[i7] = (byte) (bArr2[i7] - 55);
                } else {
                    bArr2[i7] = (byte) (bArr2[i7] - 48);
                }
            }
            bArr[i5] = (byte) ((bArr2[0] << 4) | bArr2[1]);
        }
        return bArr;
    }

    /* renamed from: a */
    public static String m6299a(byte[] bArr) {
        return m6300a(bArr, 0);
    }
}
