package com.hihonor.push.sdk;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import java.nio.charset.StandardCharsets;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import javax.crypto.Cipher;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/* renamed from: com.hihonor.push.sdk.d */
/* loaded from: classes.dex */
public class C2193d {

    /* renamed from: a */
    public static volatile C2207h1 f6758a;

    /* renamed from: b */
    public static final C2193d f6759b = new C2193d();

    /* renamed from: a */
    public final void m6379a(Context context) {
        if (f6758a == null) {
            f6758a = new C2207h1(context, "push");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00c2 A[Catch: all -> 0x00da, TryCatch #0 {, blocks: (B:3:0x0001, B:5:0x0010, B:9:0x001b, B:11:0x0023, B:15:0x002d, B:17:0x0035, B:18:0x003e, B:20:0x0046, B:21:0x004f, B:24:0x005d, B:28:0x0062, B:30:0x007f, B:32:0x0085, B:33:0x00ba, B:36:0x00c2, B:39:0x00a5, B:43:0x00d1), top: B:2:0x0001, inners: #1 }] */
    /* renamed from: b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public synchronized java.lang.String m6381b(android.content.Context r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            r7.m6379a(r8)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r8 = ""
            com.hihonor.push.sdk.h1 r0 = com.hihonor.push.sdk.C2193d.f6758a     // Catch: java.lang.Throwable -> Lda
            java.lang.String r1 = "key_push_token"
            android.content.SharedPreferences r0 = r0.f6789a     // Catch: java.lang.Throwable -> Lda
            r2 = 1
            r3 = 0
            if (r0 == 0) goto L18
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> Lda
            if (r0 == 0) goto L18
            r0 = 1
            goto L19
        L18:
            r0 = 0
        L19:
            if (r0 == 0) goto Ld8
            com.hihonor.push.sdk.h1 r0 = com.hihonor.push.sdk.C2193d.f6758a     // Catch: java.lang.Throwable -> Lda
            java.lang.String r1 = "key_aes_gcm"
            android.content.SharedPreferences r0 = r0.f6789a     // Catch: java.lang.Throwable -> Lda
            if (r0 == 0) goto L2a
            boolean r0 = r0.contains(r1)     // Catch: java.lang.Throwable -> Lda
            if (r0 == 0) goto L2a
            goto L2b
        L2a:
            r2 = 0
        L2b:
            if (r2 == 0) goto Ld1
            com.hihonor.push.sdk.h1 r0 = com.hihonor.push.sdk.C2193d.f6758a     // Catch: java.lang.Throwable -> Lda
            java.lang.String r1 = "key_push_token"
            android.content.SharedPreferences r0 = r0.f6789a     // Catch: java.lang.Throwable -> Lda
            if (r0 == 0) goto L3c
            java.lang.String r2 = ""
            java.lang.String r0 = r0.getString(r1, r2)     // Catch: java.lang.Throwable -> Lda
            goto L3e
        L3c:
            java.lang.String r0 = ""
        L3e:
            com.hihonor.push.sdk.h1 r1 = com.hihonor.push.sdk.C2193d.f6758a     // Catch: java.lang.Throwable -> Lda
            java.lang.String r2 = "key_aes_gcm"
            android.content.SharedPreferences r1 = r1.f6789a     // Catch: java.lang.Throwable -> Lda
            if (r1 == 0) goto L4d
            java.lang.String r4 = ""
            java.lang.String r1 = r1.getString(r2, r4)     // Catch: java.lang.Throwable -> Lda
            goto L4f
        L4d:
            java.lang.String r1 = ""
        L4f:
            byte[] r1 = android.util.Base64.decode(r1, r3)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r2 = ""
            boolean r4 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Throwable -> Lda
            if (r4 != 0) goto Lb9
            if (r1 == 0) goto Lb9
            int r4 = r1.length     // Catch: java.lang.Throwable -> Lda
            r5 = 16
            if (r4 < r5) goto Lb9
            javax.crypto.spec.SecretKeySpec r4 = new javax.crypto.spec.SecretKeySpec     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            java.lang.String r5 = "AES"
            r4.<init>(r1, r5)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            java.lang.String r1 = "AES/GCM/NoPadding"
            javax.crypto.Cipher r1 = javax.crypto.Cipher.getInstance(r1)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            r5 = 24
            java.lang.String r3 = r0.substring(r3, r5)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            java.lang.String r0 = r0.substring(r5)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            boolean r5 = android.text.TextUtils.isEmpty(r3)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            if (r5 != 0) goto Lb9
            boolean r5 = android.text.TextUtils.isEmpty(r0)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            if (r5 != 0) goto Lb9
            javax.crypto.spec.GCMParameterSpec r5 = new javax.crypto.spec.GCMParameterSpec     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            r6 = 128(0x80, float:1.8E-43)
            byte[] r3 = com.hihonor.push.sdk.C2186b.m6368a(r3)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            r5.<init>(r6, r3)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            r3 = 2
            r1.init(r3, r4, r5)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            byte[] r0 = com.hihonor.push.sdk.C2186b.m6368a(r0)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            byte[] r0 = r1.doFinal(r0)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            java.lang.String r1 = new java.lang.String     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            r1.<init>(r0, r3)     // Catch: java.lang.Exception -> La4 java.lang.Throwable -> Lda
            goto Lba
        La4:
            r0 = move-exception
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Throwable -> Lda
            r1.<init>()     // Catch: java.lang.Throwable -> Lda
            java.lang.String r3 = "GCM decrypt data exception: "
            r1.append(r3)     // Catch: java.lang.Throwable -> Lda
            java.lang.String r0 = r0.getMessage()     // Catch: java.lang.Throwable -> Lda
            r1.append(r0)     // Catch: java.lang.Throwable -> Lda
            r1.toString()     // Catch: java.lang.Throwable -> Lda
        Lb9:
            r1 = r2
        Lba:
            boolean r0 = android.text.TextUtils.isEmpty(r1)     // Catch: java.lang.Throwable -> Lda
            if (r0 != 0) goto Lc2
            r8 = r1
            goto Ld8
        Lc2:
            com.hihonor.push.sdk.h1 r0 = com.hihonor.push.sdk.C2193d.f6758a     // Catch: java.lang.Throwable -> Lda
            java.lang.String r1 = "key_aes_gcm"
            r0.m6388a(r1)     // Catch: java.lang.Throwable -> Lda
            com.hihonor.push.sdk.h1 r0 = com.hihonor.push.sdk.C2193d.f6758a     // Catch: java.lang.Throwable -> Lda
            java.lang.String r1 = "key_push_token"
            r0.m6388a(r1)     // Catch: java.lang.Throwable -> Lda
            goto Ld8
        Ld1:
            com.hihonor.push.sdk.h1 r0 = com.hihonor.push.sdk.C2193d.f6758a     // Catch: java.lang.Throwable -> Lda
            java.lang.String r1 = "key_push_token"
            r0.m6388a(r1)     // Catch: java.lang.Throwable -> Lda
        Ld8:
            monitor-exit(r7)
            return r8
        Lda:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hihonor.push.sdk.C2193d.m6381b(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    public synchronized void m6380a(Context context, String str) {
        byte[] bArr;
        byte[] bArr2;
        m6379a(context);
        if (TextUtils.isEmpty(str)) {
            f6758a.m6388a("key_push_token");
        } else {
            String m6364a = C2186b.m6364a(context, context.getPackageName());
            byte[] m6368a = C2186b.m6368a("EA23F5B8C7577CDC744ABD1C6D7E143D5123F8F282BF4E7853C1EC86BD2EDD22");
            byte[] m6368a2 = C2186b.m6368a(m6364a);
            try {
                bArr = new byte[32];
                new SecureRandom().nextBytes(bArr);
            } catch (Exception unused) {
                bArr = new byte[0];
            }
            String encodeToString = Base64.encodeToString(C2186b.m6370a(C2186b.m6369a(C2186b.m6370a(C2186b.m6369a(m6368a, -4), m6368a2), 6), bArr), 0);
            boolean m6389a = f6758a.m6389a("key_aes_gcm", encodeToString);
            byte[] decode = Base64.decode(encodeToString, 0);
            String str2 = "";
            if (!TextUtils.isEmpty(str) && decode != null && decode.length >= 16) {
                try {
                    try {
                        bArr2 = new byte[12];
                        new SecureRandom().nextBytes(bArr2);
                    } catch (Exception unused2) {
                        bArr2 = new byte[0];
                    }
                    byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
                    SecretKeySpec secretKeySpec = new SecretKeySpec(decode, "AES");
                    Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
                    cipher.init(1, secretKeySpec, new GCMParameterSpec(128, bArr2));
                    byte[] doFinal = cipher.doFinal(bytes);
                    if (doFinal != null && doFinal.length != 0) {
                        str2 = C2186b.m6365a(bArr2) + C2186b.m6365a(doFinal);
                    }
                } catch (GeneralSecurityException e2) {
                    String str3 = "GCM encrypt data error" + e2.getMessage();
                }
            }
            if (m6389a && !TextUtils.isEmpty(str2)) {
                f6758a.m6389a("key_push_token", str2);
            }
        }
    }
}
