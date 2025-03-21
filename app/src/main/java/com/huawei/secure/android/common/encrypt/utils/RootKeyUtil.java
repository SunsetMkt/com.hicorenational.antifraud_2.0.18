package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import android.os.Build;

/* loaded from: classes.dex */
public class RootKeyUtil {

    /* renamed from: b */
    private static final String f8107b = "RootKeyUtil";

    /* renamed from: a */
    private byte[] f8108a = null;

    private RootKeyUtil() {
    }

    /* renamed from: a */
    private void m7881a(String str, String str2, String str3, String str4) {
        m7882a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.m7881a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public byte[] getRootKey() {
        return (byte[]) this.f8108a.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.f8108a);
    }

    @SuppressLint({"NewApi"})
    /* renamed from: a */
    private void m7882a(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            C2551b.m7899c(f8107b, "initRootKey: sha1");
            this.f8108a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, false);
        } else {
            C2551b.m7899c(f8107b, "initRootKey: sha256");
            this.f8108a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
        }
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.m7882a(str, str2, str3, bArr);
        return rootKeyUtil;
    }
}
