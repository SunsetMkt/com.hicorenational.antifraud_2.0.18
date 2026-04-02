package com.huawei.secure.android.common.encrypt.utils;

import android.annotation.SuppressLint;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class RootKeyUtil {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f5114b = "RootKeyUtil";
    private byte[] a = null;

    private RootKeyUtil() {
    }

    private void a(String str, String str2, String str3, String str4) {
        a(str, str2, str3, HexUtil.hexStr2ByteArray(str4));
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, String str4) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, str4);
        return rootKeyUtil;
    }

    public byte[] getRootKey() {
        return (byte[]) this.a.clone();
    }

    public String getRootKeyHex() {
        return HexUtil.byteArray2HexStr(this.a);
    }

    @SuppressLint({"NewApi"})
    private void a(String str, String str2, String str3, byte[] bArr) {
        if (Build.VERSION.SDK_INT < 26) {
            b.c(f5114b, "initRootKey: sha1");
            this.a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, false);
        } else {
            b.c(f5114b, "initRootKey: sha256");
            this.a = BaseKeyUtil.exportRootKey(str, str2, str3, bArr, true);
        }
    }

    public static RootKeyUtil newInstance(String str, String str2, String str3, byte[] bArr) {
        RootKeyUtil rootKeyUtil = new RootKeyUtil();
        rootKeyUtil.a(str, str2, str3, bArr);
        return rootKeyUtil;
    }
}
