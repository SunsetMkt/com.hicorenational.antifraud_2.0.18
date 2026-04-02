package com.huawei.hms.hatool;

import com.huawei.secure.android.common.encrypt.utils.EncryptUtil;

/* JADX INFO: loaded from: classes.dex */
public class m1 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static m1 f4782b = new m1();
    private a a = new a();

    class a {
        String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        String f4783b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f4784c = 0;

        a() {
        }

        void a(long j2) {
            m1.this.a.f4784c = j2;
        }

        void a(String str) {
            m1.this.a.f4783b = str;
        }

        void b(String str) {
            m1.this.a.a = str;
        }
    }

    public static m1 d() {
        return f4782b;
    }

    public String a() {
        return this.a.f4783b;
    }

    public void a(String str, String str2) {
        long jB = b();
        String strC = w0.c(str, str2);
        if (strC == null || strC.isEmpty()) {
            v.e("WorkKeyHandler", "get rsa pubkey config error");
            return;
        }
        if (jB == 0) {
            jB = System.currentTimeMillis();
        } else if (System.currentTimeMillis() - jB <= com.heytap.mcssdk.constant.a.f3871g) {
            return;
        }
        String strGenerateSecureRandomStr = EncryptUtil.generateSecureRandomStr(16);
        String strA = h0.a(strC, strGenerateSecureRandomStr);
        this.a.a(jB);
        this.a.b(strGenerateSecureRandomStr);
        this.a.a(strA);
    }

    public long b() {
        return this.a.f4784c;
    }

    public String c() {
        return this.a.a;
    }
}
