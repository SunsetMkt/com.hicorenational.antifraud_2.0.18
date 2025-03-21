package com.vivo.push.util;

import android.content.Context;
import android.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* compiled from: AESParseManager.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: c, reason: collision with root package name */
    private static volatile a f12232c;

    /* renamed from: a, reason: collision with root package name */
    private byte[] f12233a;

    /* renamed from: b, reason: collision with root package name */
    private byte[] f12234b;

    private a(Context context) {
        ad.b().a(ContextDelegate.getContext(context));
        ad b2 = ad.b();
        this.f12233a = b2.c();
        this.f12234b = b2.d();
    }

    public static a a(Context context) {
        if (f12232c == null) {
            synchronized (a.class) {
                if (f12232c == null) {
                    f12232c = new a(context.getApplicationContext());
                }
            }
        }
        return f12232c;
    }

    public final String b(String str) throws Exception {
        return new String(j.a(j.a(a()), j.a(b()), Base64.decode(str, 2)), "utf-8");
    }

    private byte[] b() {
        byte[] bArr = this.f12234b;
        return (bArr == null || bArr.length <= 0) ? ad.b().d() : bArr;
    }

    public final String a(String str) throws Exception {
        String a2 = j.a(a());
        String a3 = j.a(b());
        byte[] bytes = str.getBytes("utf-8");
        SecretKeySpec secretKeySpec = new SecretKeySpec(a3.getBytes("utf-8"), "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(1, secretKeySpec, new IvParameterSpec(a2.getBytes("utf-8")));
        return Base64.encodeToString(cipher.doFinal(bytes), 2);
    }

    private byte[] a() {
        byte[] bArr = this.f12233a;
        return (bArr == null || bArr.length <= 0) ? ad.b().c() : bArr;
    }
}
