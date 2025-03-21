package com.huawei.hms.aaid.encrypt;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.AbstractC2474l;
import com.huawei.secure.android.common.encrypt.aes.AesCbc;

/* loaded from: classes.dex */
public class PushEncrypter {
    public static String decrypter(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : AesCbc.decrypt(str, AbstractC2474l.m7490b(context));
    }

    public static String encrypter(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : AesCbc.encrypt(str, AbstractC2474l.m7490b(context));
    }

    public static String encrypterOld(Context context, String str) {
        return TextUtils.isEmpty(str) ? "" : AesCbc.encrypt(str, AbstractC2474l.m7486a(context));
    }
}
