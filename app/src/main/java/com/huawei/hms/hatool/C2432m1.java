package com.huawei.hms.hatool;

import com.heytap.mcssdk.constant.C2084a;
import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* renamed from: com.huawei.hms.hatool.m1 */
/* loaded from: classes.dex */
public class C2432m1 {

    /* renamed from: b */
    private static C2432m1 f7579b = new C2432m1();

    /* renamed from: a */
    private a f7580a = new a();

    /* renamed from: com.huawei.hms.hatool.m1$a */
    class a {

        /* renamed from: a */
        String f7581a;

        /* renamed from: b */
        String f7582b;

        /* renamed from: c */
        long f7583c = 0;

        a() {
        }

        /* renamed from: a */
        void m7241a(long j2) {
            C2432m1.this.f7580a.f7583c = j2;
        }

        /* renamed from: a */
        void m7242a(String str) {
            C2432m1.this.f7580a.f7582b = str;
        }

        /* renamed from: b */
        void m7243b(String str) {
            C2432m1.this.f7580a.f7581a = str;
        }
    }

    /* renamed from: d */
    public static C2432m1 m7236d() {
        return f7579b;
    }

    /* renamed from: a */
    public String m7237a() {
        return this.f7580a.f7582b;
    }

    /* renamed from: a */
    public void m7238a(String str, String str2) {
        long m7239b = m7239b();
        String m7400c = C2455w0.m7400c(str, str2);
        if (m7400c == null || m7400c.isEmpty()) {
            C2452v.m7389e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (m7239b == 0) {
            m7239b = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - m7239b <= C2084a.f6125g) {
            return;
        }
        String generateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String m7153a = C2416h0.m7153a(m7400c, generateSecureRandomStr);
        this.f7580a.m7241a(m7239b);
        this.f7580a.m7243b(generateSecureRandomStr);
        this.f7580a.m7242a(m7153a);
    }

    /* renamed from: b */
    public long m7239b() {
        return this.f7580a.f7583c;
    }

    /* renamed from: c */
    public String m7240c() {
        return this.f7580a.f7581a;
    }
}
