package com.vivo.push;

import android.text.TextUtils;

/* JADX INFO: compiled from: SubscribeImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class z implements k {
    private y a = new y();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private y f8702b = new y();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.vivo.push.c.a f8703c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile String f8704d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private com.vivo.push.restructure.b.a f8705e;

    public z(com.vivo.push.c.a aVar, com.vivo.push.restructure.b.a aVar2) {
        this.f8703c = aVar;
        this.f8705e = aVar2;
    }

    private void d(String str) {
        this.f8704d = str;
        this.f8705e.c(this.f8704d);
    }

    @Override // com.vivo.push.k
    public final String b() throws Throwable {
        if (!TextUtils.isEmpty(this.f8704d)) {
            return this.f8704d;
        }
        String strD = d();
        if (TextUtils.isEmpty(strD)) {
            strD = this.f8705e.f();
            t.c(new aa(this, strD));
        }
        this.f8704d = strD;
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(strD)));
        return strD;
    }

    @Override // com.vivo.push.k
    public final void c(String str) {
        d(str);
    }

    private int c() throws Throwable {
        if (!this.f8703c.d()) {
            return 8013;
        }
        if (this.f8702b.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe \u4e24\u79d2\u5185\u91cd\u590d\u8c03\u7528  ");
            return 1002;
        }
        int i2 = 1;
        try {
            String strA = new e(1, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe parameter = ".concat(String.valueOf(strA)));
            String strA2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), strA);
            com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe isSubscribe = ".concat(String.valueOf(strA2)));
            if (!TextUtils.isEmpty(strA2)) {
                i2 = 1 ^ (Boolean.parseBoolean(g.a.a(strA2).b()) ? 1 : 0);
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("SubscribeImpl", "isAppSubscribe", e2);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "isAppSubscribe code = ".concat(String.valueOf(i2)));
        return i2;
    }

    @Override // com.vivo.push.k
    public final void a(IPushActionListener iPushActionListener, String str, String str2) {
        if (this.f8703c.c() || iPushActionListener == null) {
            m.a().b(iPushActionListener, str, str2);
        } else {
            iPushActionListener.onStateChanged(8012);
        }
    }

    private String d() throws Throwable {
        String strB = "";
        if (!this.f8703c.d()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk \u7cfb\u7edf\u4e0d\u652f\u6301\u67e5\u8be2regid  ");
            return "";
        }
        if (this.a.a()) {
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk \u4e24\u79d2\u5185\u91cd\u590d\u8c03\u7528  ");
            return "";
        }
        try {
            String strA = new e(2, com.vivo.push.restructure.a.a().b().getPackageName(), "", "", com.vivo.push.restructure.a.a().e().f()).a();
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk parameter = ".concat(String.valueOf(strA)));
            String strA2 = com.vivo.push.c.a.a(com.vivo.push.restructure.a.a().b(), strA);
            com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk isSubscribe = ".concat(String.valueOf(strA2)));
            if (!TextUtils.isEmpty(strA2)) {
                strB = g.a.a(strA2).b();
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("SubscribeImpl", "getRegidByCoreSdk", e2);
        }
        com.vivo.push.util.u.d("SubscribeImpl", "getRegidByCoreSdk code = ".concat(String.valueOf(strB)));
        return strB;
    }

    @Override // com.vivo.push.k
    public final int a() {
        return c();
    }

    @Override // com.vivo.push.k
    public final void a(String str, String str2, String str3) {
        d(str);
        this.f8705e.a(str2);
        this.f8705e.b(str3);
    }

    @Override // com.vivo.push.k
    public final void a(String str) {
        d(str);
        this.f8705e.d();
        this.f8705e.b();
    }

    @Override // com.vivo.push.k
    public final void b(String str) {
        d(str);
        m.a().e();
        this.f8705e.h();
        this.f8705e.d();
        this.f8705e.b();
    }
}
