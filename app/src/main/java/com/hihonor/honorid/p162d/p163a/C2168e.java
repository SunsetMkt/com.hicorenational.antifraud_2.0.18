package com.hihonor.honorid.p162d.p163a;

import android.text.TextUtils;
import com.hihonor.honorid.p165f.C2171a;
import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import p358k.p359a.p360a.p361a.p363j.C5863e;

/* compiled from: SHA256.java */
/* renamed from: com.hihonor.honorid.d.a.e */
/* loaded from: classes.dex */
public class C2168e {

    /* renamed from: a */
    private static final String[] f6721a = {"SHA-256", "SHA-384", "SHA-512"};

    /* renamed from: a */
    public static String m6311a(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C5863e.m24694d("SHA256", "content or algorithm is null.", true);
            return "";
        }
        if (!m6312a(str2)) {
            C5863e.m24694d("SHA256", "algorithm is not safe or legal", true);
            return "";
        }
        try {
            MessageDigest messageDigest = MessageDigest.getInstance(str2);
            messageDigest.update(str.getBytes("UTF-8"));
            return C2171a.m6318a(messageDigest.digest());
        } catch (UnsupportedEncodingException unused) {
            C5863e.m24694d("SHA256", "Error in generate SHA UnsupportedEncodingException", true);
            return "";
        } catch (NoSuchAlgorithmException unused2) {
            C5863e.m24694d("SHA256", "Error in generate SHA NoSuchAlgorithmException", true);
            return "";
        }
    }

    /* renamed from: b */
    public static String m6313b(String str) {
        return m6314c(str);
    }

    /* renamed from: c */
    public static String m6314c(String str) {
        return m6311a(str, "SHA-256");
    }

    /* renamed from: a */
    private static boolean m6312a(String str) {
        for (String str2 : f6721a) {
            if (str2.equals(str)) {
                return true;
            }
        }
        return false;
    }
}
