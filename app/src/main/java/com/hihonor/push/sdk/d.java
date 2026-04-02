package com.hihonor.push.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* JADX INFO: loaded from: classes.dex */
public class d {
    public static volatile h1 a;

    /* JADX INFO: renamed from: b */
    public static final d f4240b = new d();

    public final void a(Context context) {
        if (a == null) {
            a = new h1(context, "push");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x00c2 A[Catch: all -> 0x00da, TryCatch #0 {, blocks: (B:56:0x0001, B:58:0x0010, B:63:0x001b, B:65:0x0023, B:70:0x002d, B:72:0x0035, B:74:0x003e, B:76:0x0046, B:78:0x004f, B:81:0x005d, B:84:0x0062, B:86:0x007f, B:88:0x0085, B:93:0x00ba, B:96:0x00c2, B:91:0x00a5, B:97:0x00d1), top: B:103:0x0001, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized String b(Context context) {
        String str;
        String str2;
        a(context);
        str = "";
        SharedPreferences sharedPreferences = a.a;
        boolean z = true;
        if (sharedPreferences != null && sharedPreferences.contains("key_push_token")) {
            SharedPreferences sharedPreferences2 = a.a;
            if (sharedPreferences2 == null || !sharedPreferences2.contains("key_aes_gcm")) {
                z = false;
            }
            if (z) {
                SharedPreferences sharedPreferences3 = a.a;
                String string = sharedPreferences3 != null ? sharedPreferences3.getString("key_push_token", "") : "";
                SharedPreferences sharedPreferences4 = a.a;
                byte[] bArrDecode = Base64.decode(sharedPreferences4 != null ? sharedPreferences4.getString("key_aes_gcm", "") : "", 0);
                if (TextUtils.isEmpty(string) || bArrDecode == null || bArrDecode.length < 16) {
                    str2 = "";
                    if (TextUtils.isEmpty(str2)) {
                        str = str2;
                    } else {
                        a.a("key_aes_gcm");
                        a.a("key_push_token");
                    }
                } else {
                    try {
                        SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecode, "AES");
                        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                        String strSubstring = string.substring(0, 24);
                        String strSubstring2 = string.substring(24);
                        if (!TextUtils.isEmpty(strSubstring) && !TextUtils.isEmpty(strSubstring2)) {
                            cipher.init(2, secretKeySpec, new GCMParameterSpec(128, b.a(strSubstring)));
                            str2 = new String(cipher.doFinal(b.a(strSubstring2)), StandardCharsets.UTF_8);
                        }
                    } catch (Exception e2) {
                        String str3 = "GCM decrypt data exception: " + e2.getMessage();
                    }
                    if (TextUtils.isEmpty(str2)) {
                    }
                }
            } else {
                a.a("key_push_token");
            }
        }
        return str;
    }

    public synchronized void a(Context context, String str) {
        byte[] bArr;
        byte[] bArr2;
        a(context);
        if (TextUtils.isEmpty(str)) {
            a.a("key_push_token");
        } else {
            String strA = b.a(context, context.getPackageName());
            byte[] bArrA = b.a("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");
            byte[] bArrA2 = b.a(strA);
            try {
                bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
            } catch (Exception unused) {
                bArr = new byte[0];
            }
            String strEncodeToString = Base64.encodeToString(b.a(b.a(b.a(b.a(bArrA, -4), bArrA2), 6), bArr), 0);
            boolean zA = a.a("key_aes_gcm", strEncodeToString);
            byte[] bArrDecode = Base64.decode(strEncodeToString, 0);
            String str2 = "";
            if (!TextUtils.isEmpty(str) && bArrDecode != null && bArrDecode.length >= 16) {
                try {
                    try {
                        bArr2 = new byte[12];
                        new SecureRandom().nextBytes(bArr2);
                    } catch (Exception unused2) {
                        bArr2 = new byte[0];
                    }
                    byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(bArrDecode, "AES");
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr2));
                    byte[] bArrDoFinal = cipher.doFinal(bytes);
                    if (bArrDoFinal != null && bArrDoFinal.length != 0) {
                        str2 = b.a(bArr2) + b.a(bArrDoFinal);
                    }
                } catch (GeneralSecurityException e2) {
                    String str3 = "GCM encrypt data error" + e2.getMessage();
                }
            }
            if (zA && !TextUtils.isEmpty(str2)) {
                a.a("key_push_token", str2);
            }
        }
    }
}
