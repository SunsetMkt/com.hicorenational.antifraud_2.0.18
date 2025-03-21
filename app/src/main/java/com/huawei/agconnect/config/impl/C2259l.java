package com.huawei.agconnect.config.impl;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* renamed from: com.huawei.agconnect.config.impl.l */
/* loaded from: classes.dex */
public class C2259l {
    /* renamed from: a */
    private static String m6443a(Context context, String str, String str2) {
        int identifier;
        if (TextUtils.isEmpty(str2) || (identifier = context.getResources().getIdentifier(str2, "string", str)) == 0) {
            return null;
        }
        try {
            return context.getResources().getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }

    /* renamed from: a */
    public static String m6444a(Context context, String str, String str2, String str3) {
        try {
            return m6443a(context, str, str2 + Hex.encodeHexString(m6445a(str3.getBytes("utf-8"))));
        } catch (UnsupportedEncodingException | NoSuchAlgorithmException e2) {
            String str4 = "getResources exception:" + e2.getMessage();
            return null;
        }
    }

    /* renamed from: a */
    public static byte[] m6445a(byte[] bArr) throws NoSuchAlgorithmException {
        return MessageDigest.getInstance("SHA-256").digest(bArr);
    }
}
