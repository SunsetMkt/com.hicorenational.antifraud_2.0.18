package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* JADX INFO: loaded from: classes.dex */
public class k {
    private final AesDecrypt a;

    public k(Context context, String str) {
        this.a = (TextUtils.isEmpty(a(context, str)) || Build.VERSION.SDK_INT < 26) ? new g(context, str) : new h(context, str);
    }

    private String a(Context context, String str) {
        String strA = l.a(context, str, "agc_plugin_", "crypto");
        if (strA == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(strA), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
            String str2 = "UnsupportedEncodingException" + e2.getMessage();
            return null;
        }
    }

    public String a(String str, String str2) {
        return this.a.decrypt(str, str2);
    }
}
