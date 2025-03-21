package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import com.huawei.secure.android.common.encrypt.hash.PBKDF2;

/* loaded from: classes.dex */
public class BaseKeyUtil {

    /* renamed from: a */
    private static final String f8095a = "BaseKeyUtil";

    /* renamed from: b */
    private static final int f8096b = 16;

    /* renamed from: c */
    private static final int f8097c = 16;

    /* renamed from: d */
    private static final int f8098d = 10000;

    /* renamed from: e */
    private static final int f8099e = 32;

    /* renamed from: f */
    private static final int f8100f = 1;

    /* renamed from: a */
    private static int m7875a(int i2, int i3, int i4) {
        if (i3 < i2) {
            i2 = i3;
        }
        return i4 < i2 ? i4 : i2;
    }

    /* renamed from: a */
    private static boolean m7876a(int i2) {
        return i2 >= 16;
    }

    /* renamed from: a */
    private static boolean m7877a(int i2, byte[] bArr) {
        return m7876a(i2) & m7878a(bArr);
    }

    public static String exportHexRootKey(String str, String str2, String str3, byte[] bArr, int i2, boolean z) {
        return HexUtil.byteArray2HexStr(exportRootKey(str, str2, str3, bArr, i2, z));
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 16, z);
    }

    public static byte[] exportRootKey32(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 32, z);
    }

    public static byte[] exportRootKey32Iteration1(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 1, 32, z);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKeyIteration1(String str, String str2, String str3, byte[] bArr, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 1, 16, z);
    }

    @SuppressLint({"NewApi"})
    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i2, boolean z) {
        return exportRootKey(str, str2, str3, bArr, 10000, i2, z);
    }

    /* renamed from: a */
    private static boolean m7878a(byte[] bArr) {
        return bArr.length >= 16;
    }

    public static byte[] exportRootKey(String str, String str2, String str3, byte[] bArr, int i2, int i3, boolean z) {
        byte[] hexStr2ByteArray = HexUtil.hexStr2ByteArray(str);
        byte[] hexStr2ByteArray2 = HexUtil.hexStr2ByteArray(str2);
        byte[] hexStr2ByteArray3 = HexUtil.hexStr2ByteArray(str3);
        int m7875a = m7875a(hexStr2ByteArray.length, hexStr2ByteArray2.length, hexStr2ByteArray3.length);
        if (m7877a(m7875a, bArr)) {
            char[] cArr = new char[m7875a];
            for (int i4 = 0; i4 < m7875a; i4++) {
                cArr[i4] = (char) ((hexStr2ByteArray[i4] ^ hexStr2ByteArray2[i4]) ^ hexStr2ByteArray3[i4]);
            }
            if (!z) {
                C2551b.m7899c(f8095a, "exportRootKey: sha1");
                return PBKDF2.pbkdf2(cArr, bArr, i2, i3 * 8);
            }
            C2551b.m7899c(f8095a, "exportRootKey: sha256");
            return PBKDF2.pbkdf2SHA256(cArr, bArr, i2, i3 * 8);
        }
        throw new IllegalArgumentException("key length must be more than 128bit.");
    }

    public static byte[] exportRootKey(String str, String str2, String str3, String str4, int i2, boolean z) {
        return exportRootKey(str, str2, str3, HexUtil.hexStr2ByteArray(str4), i2, z);
    }
}
