package com.huawei.secure.android.common.util;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import p286h.C5230f1;

/* loaded from: classes.dex */
public final class HexUtil {

    /* renamed from: a */
    private static final String f8263a = "";

    /* renamed from: b */
    private static final String f8264b = "HexUtil";

    private HexUtil() {
    }

    public static String byteArray2HexStr(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (byte b2 : bArr) {
            String hexString = Integer.toHexString(b2 & C5230f1.f20085c);
            if (hexString.length() == 1) {
                sb.append('0');
            }
            sb.append(hexString);
        }
        return sb.toString();
    }

    public static byte[] hexStr2ByteArray(String str) {
        if (TextUtils.isEmpty(str)) {
            return new byte[0];
        }
        String upperCase = str.toUpperCase(Locale.ENGLISH);
        byte[] bArr = new byte[upperCase.length() / 2];
        try {
            byte[] bytes = upperCase.getBytes("UTF-8");
            for (int i2 = 0; i2 < bArr.length; i2++) {
                StringBuilder sb = new StringBuilder();
                sb.append("0x");
                int i3 = i2 * 2;
                sb.append(new String(new byte[]{bytes[i3]}, "UTF-8"));
                bArr[i2] = (byte) (((byte) (Byte.decode(sb.toString()).byteValue() << 4)) ^ Byte.decode("0x" + new String(new byte[]{bytes[i3 + 1]}, "UTF-8")).byteValue());
            }
        } catch (UnsupportedEncodingException e2) {
            e = e2;
            String str2 = "hex string 2 byte UnsupportedEncodingException or NumberFormatException : " + e.getMessage();
        } catch (NumberFormatException e3) {
            e = e3;
            String str22 = "hex string 2 byte UnsupportedEncodingException or NumberFormatException : " + e.getMessage();
        } catch (Exception e4) {
            String str3 = "byte array 2 hex string exception : " + e4.getMessage();
        }
        return bArr;
    }

    public static String byteArray2HexStr(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return byteArray2HexStr(str.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e2) {
            String str2 = "byte array 2 hex string UnsupportedEncodingException : " + e2.getMessage();
            return "";
        } catch (Exception e3) {
            String str3 = "byte array 2 hex string exception : " + e3.getMessage();
            return "";
        }
    }
}
