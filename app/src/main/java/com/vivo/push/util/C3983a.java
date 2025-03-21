package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESParseManager.java */
/* renamed from: com.vivo.push.util.a */
/* loaded from: classes2.dex */
public class C3983a {

    /* renamed from: c */
    private static volatile C3983a f14211c;

    /* renamed from: a */
    private byte[] f14212a;

    /* renamed from: b */
    private byte[] f14213b;

    private C3983a(Context context) {
        C3987ad.m13198b().m13200a(ContextDelegate.getContext(context));
        C3987ad m13198b = C3987ad.m13198b();
        this.f14212a = m13198b.m13201c();
        this.f14213b = m13198b.m13202d();
    }

    /* renamed from: a */
    public static C3983a m13174a(Context context) {
        if (f14211c == null) {
            synchronized (C3983a.class) {
                if (f14211c == null) {
                    f14211c = new C3983a(context.getApplicationContext());
                }
            }
        }
        return f14211c;
    }

    /* renamed from: b */
    public final String m13178b(String str) throws Exception {
        return new String(C3999j.m13260a(C3999j.m13259a(m13175a()), C3999j.m13259a(m13176b()), Base64.decode(str, 2)), "utf-8");
    }

    /* renamed from: b */
    private byte[] m13176b() {
        byte[] bArr = this.f14213b;
        return (bArr == null || bArr.length <= 0) ? C3987ad.m13198b().m13202d() : bArr;
    }

    /* renamed from: a */
    public final String m13177a(String str) throws Exception {
        String m13259a = C3999j.m13259a(m13175a());
        String m13259a2 = C3999j.m13259a(m13176b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(m13259a2.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(m13259a.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    /* renamed from: a */
    private byte[] m13175a() {
        byte[] bArr = this.f14212a;
        return (bArr == null || bArr.length <= 0) ? C3987ad.m13198b().m13201c() : bArr;
    }
}
