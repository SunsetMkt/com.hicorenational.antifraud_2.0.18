package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.agconnect.config.AesDecrypt;
import java.io.UnsupportedEncodingException;

/* renamed from: com.huawei.agconnect.config.impl.k */
/* loaded from: classes.dex */
public class C2258k {

    /* renamed from: a */
    private final AesDecrypt f6910a;

    public C2258k(Context context, String str) {
        this.f6910a = (TextUtils.isEmpty(m6441a(context, str)) || Build.VERSION.SDK_INT < 26) ? new C2254g(context, str) : new C2255h(context, str);
    }

    /* renamed from: a */
    private String m6441a(Context context, String str) {
        String m6444a = C2259l.m6444a(context, str, "agc_plugin_", "crypto");
        if (m6444a == null) {
            return null;
        }
        try {
            return new String(Hex.decodeHexString(m6444a), "utf-8");
        } catch (UnsupportedEncodingException | IllegalArgumentException e2) {
            String str2 = "UnsupportedEncodingException" + e2.getMessage();
            return null;
        }
    }

    /* renamed from: a */
    public String m6442a(String str, String str2) {
        return this.f6910a.decrypt(str, str2);
    }
}
