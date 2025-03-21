package com.huawei.hms.hatool;

import android.os.Build;
import android.text.TextUtils;
import com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* renamed from: com.huawei.hms.hatool.o0 */
/* loaded from: classes.dex */
public class C2437o0 {

    /* renamed from: c */
    private static C2437o0 f7588c;

    /* renamed from: a */
    private String f7589a;

    /* renamed from: b */
    private String f7590b;

    /* JADX WARN: Code restructure failed: missing block: B:9:0x003b, code lost:
    
        if (m7272f() != false) goto L12;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private java.lang.String m7266a(java.lang.String r3) {
        /*
            r2 = this;
            boolean r0 = r2.m7272f()
            if (r0 == 0) goto Ld
            java.lang.String r0 = "analytics_keystore"
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.keystore.aes.AesGcmKS.decrypt(r0, r3)
            goto Lf
        Ld:
            java.lang.String r0 = ""
        Lf:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L4f
            java.lang.String r0 = "hmsSdk"
            java.lang.String r1 = "deCrypt work key first"
            com.huawei.hms.hatool.C2452v.m7385c(r0, r1)
            java.lang.String r0 = r2.m7271e()
            java.lang.String r0 = com.huawei.hms.hatool.C2433n.m7245a(r3, r0)
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            if (r3 == 0) goto L41
            r3 = 16
            java.lang.String r0 = com.huawei.secure.android.common.encrypt.utils.EncryptUtil.generateSecureRandomStr(r3)
            java.lang.String r3 = r2.m7267b(r0)
            r2.m7269c(r3)
            boolean r3 = r2.m7272f()
            if (r3 == 0) goto L4f
        L3d:
            com.huawei.hms.hatool.C2456x.m7409c()
            goto L4f
        L41:
            boolean r3 = r2.m7272f()
            if (r3 == 0) goto L4f
            java.lang.String r3 = r2.m7267b(r0)
            r2.m7269c(r3)
            goto L3d
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.hatool.C2437o0.m7266a(java.lang.String):java.lang.String");
    }

    /* renamed from: b */
    private String m7267b(String str) {
        return m7272f() ? AesGcmKS.encrypt("analytics_keystore", str) : C2433n.m7247b(str, m7271e());
    }

    /* renamed from: c */
    private String m7268c() {
        String m7069a = C2403d.m7069a(AbstractC2443q0.m7311i(), "Privacy_MY", "PrivacyData", "");
        if (!TextUtils.isEmpty(m7069a)) {
            return m7266a(m7069a);
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        m7269c(m7267b(generateSecureRandomStr));
        return generateSecureRandomStr;
    }

    /* renamed from: c */
    private boolean m7269c(String str) {
        C2452v.m7385c("hmsSdk", "refresh sp aes key");
        if (TextUtils.isEmpty(str)) {
            C2452v.m7385c("hmsSdk", "refreshLocalKey(): encrypted key is empty");
            return false;
        }
        C2403d.m7074b(AbstractC2443q0.m7311i(), "Privacy_MY", "PrivacyData", str);
        C2403d.m7073b(AbstractC2443q0.m7311i(), "Privacy_MY", "flashKeyTime", System.currentTimeMillis());
        return true;
    }

    /* renamed from: d */
    public static C2437o0 m7270d() {
        if (f7588c == null) {
            m7273g();
        }
        return f7588c;
    }

    /* renamed from: e */
    private String m7271e() {
        if (TextUtils.isEmpty(this.f7590b)) {
            this.f7590b = new C2456x().m7411a();
        }
        return this.f7590b;
    }

    /* renamed from: f */
    private boolean m7272f() {
        return Build.VERSION.SDK_INT >= 23;
    }

    /* renamed from: g */
    private static synchronized void m7273g() {
        synchronized (C2437o0.class) {
            if (f7588c == null) {
                f7588c = new C2437o0();
            }
        }
    }

    /* renamed from: a */
    public String m7274a() {
        if (TextUtils.isEmpty(this.f7589a)) {
            this.f7589a = m7268c();
        }
        return this.f7589a;
    }

    /* renamed from: b */
    public void m7275b() {
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        if (m7269c(m7267b(generateSecureRandomStr))) {
            this.f7589a = generateSecureRandomStr;
        }
    }
}
