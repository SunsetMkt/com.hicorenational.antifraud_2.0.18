package com.vivo.push.restructure.p241b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.PushConfig;
import com.vivo.push.model.C3926b;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C3984aa;
import com.vivo.push.util.C3996g;
import com.vivo.push.util.C4010u;
import com.vivo.push.util.C4015z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: PushRelyImpl.java */
/* renamed from: com.vivo.push.restructure.b.d */
/* loaded from: classes2.dex */
public final class C3953d implements InterfaceC3950a {

    /* renamed from: a */
    private static Map<String, C3952c> f14150a = new ConcurrentHashMap();

    /* renamed from: b */
    private String f14151b;

    /* renamed from: c */
    private C4015z f14152c;

    /* renamed from: d */
    private volatile PushConfig f14153d;

    public C3953d(C4015z c4015z) {
        this.f14152c = c4015z;
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: a */
    public final String mo13113a(Context context, String str) {
        if (!TextUtils.isEmpty(this.f14151b)) {
            return this.f14151b;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            C4010u.m13292a("PushRelyImpl", "getReceiverClassName() params error, context = " + context + ", action = " + str);
            return "";
        }
        String packageName = context.getPackageName();
        this.f14151b = m13135a(context, packageName, str);
        if (TextUtils.isEmpty(this.f14151b)) {
            C4010u.m13309d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
        }
        return this.f14151b;
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: b */
    public final void mo13116b() {
        mo13115a("");
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: c */
    public final String mo13118c() {
        C3952c c3952c = f14150a.get(C3932a.m13069a().m13071b().getPackageName());
        if (c3952c != null) {
            String m13133b = c3952c.m13133b();
            if (!TextUtils.isEmpty(m13133b)) {
                return m13133b;
            }
        }
        String m13319c = this.f14152c.m13319c();
        if (!TextUtils.isEmpty(m13319c)) {
            if (c3952c == null) {
                c3952c = new C3952c();
            }
            c3952c.m13134b(m13319c);
            f14150a.put(C3932a.m13069a().m13071b().getPackageName(), c3952c);
        }
        return m13319c;
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: d */
    public final void mo13120d() {
        mo13117b("");
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: e */
    public final void mo13122e() {
        this.f14152c.m13238a();
        f14150a.clear();
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: f */
    public final String mo13124f() {
        return this.f14152c.m13246b("APP_TOKEN", (String) null);
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: g */
    public final String mo13125g() {
        return this.f14152c.m13246b("APP_TAGS", (String) null);
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: h */
    public final void mo13126h() {
        this.f14152c.m13240a("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: i */
    public final String mo13127i() {
        return this.f14152c.m13246b("APP_ALIAS", (String) null);
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: j */
    public final void mo13128j() {
        this.f14152c.m13240a("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: k */
    public final String mo13129k() {
        C3926b m13179a = C3984aa.m13179a(C3932a.m13069a().m13071b(), C3932a.m13069a().m13075f());
        if (m13179a == null || m13179a.m13067c()) {
            return null;
        }
        return m13179a.m13060a();
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: l */
    public final PushConfig mo13130l() {
        if (this.f14153d != null) {
            return this.f14153d;
        }
        int m13244b = this.f14152c.m13244b("PUSH_CLIENT_CONFIG", 1) & 1;
        return new PushConfig.Builder().agreePrivacyStatement(m13244b != 0).openMultiUserMode(m13244b != 0).build();
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: b */
    public final void mo13117b(String str) {
        this.f14152c.m13243a("APP_APIKEY", str);
        C3952c c3952c = f14150a.get(C3932a.m13069a().m13071b().getPackageName());
        if (c3952c == null) {
            c3952c = new C3952c();
        }
        c3952c.m13134b(str);
        f14150a.put(C3932a.m13069a().m13071b().getPackageName(), c3952c);
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: d */
    public final void mo13121d(String str) {
        this.f14152c.m13243a("APP_TAGS", str);
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: e */
    public final void mo13123e(String str) {
        this.f14152c.m13243a("APP_ALIAS", str);
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: c */
    public final void mo13119c(String str) {
        this.f14152c.m13243a("APP_TOKEN", str);
    }

    /* renamed from: a */
    private static String m13135a(Context context, String str, String str2) {
        List<ResolveInfo> queryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (queryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || queryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return queryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            C4010u.m13292a("PushRelyImpl", "error  " + e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: a */
    public final String mo13112a() {
        C3952c c3952c = f14150a.get(C3932a.m13069a().m13071b().getPackageName());
        if (c3952c != null) {
            String m13131a = c3952c.m13131a();
            if (!TextUtils.isEmpty(m13131a)) {
                return m13131a;
            }
        }
        String m13318b = this.f14152c.m13318b();
        if (!TextUtils.isEmpty(m13318b)) {
            if (c3952c == null) {
                c3952c = new C3952c();
            }
            c3952c.m13132a(m13318b);
            f14150a.put(C3932a.m13069a().m13071b().getPackageName(), c3952c);
        }
        return m13318b;
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: a */
    public final void mo13115a(String str) {
        this.f14152c.m13243a("APP_APPID", str);
        C3952c c3952c = f14150a.get(C3932a.m13069a().m13071b().getPackageName());
        if (c3952c == null) {
            c3952c = new C3952c();
        }
        c3952c.m13132a(str);
        f14150a.put(C3932a.m13069a().m13071b().getPackageName(), c3952c);
    }

    @Override // com.vivo.push.restructure.p241b.InterfaceC3950a
    /* renamed from: a */
    public final void mo13114a(PushConfig pushConfig) {
        int i2;
        if (pushConfig == null) {
            return;
        }
        this.f14153d = null;
        Context m13071b = C3932a.m13069a().m13071b();
        if (pushConfig == null) {
            i2 = 1;
        } else {
            i2 = (pushConfig.isAgreePrivacyStatement() ? 1 : 0) | (pushConfig.isOpenMultiUser() ? 1 : 0);
        }
        this.f14152c.m13241a("PUSH_CLIENT_CONFIG", i2);
        C3996g.m13250a().execute(new RunnableC3954e(this, m13071b, pushConfig));
        this.f14153d = pushConfig;
    }
}
