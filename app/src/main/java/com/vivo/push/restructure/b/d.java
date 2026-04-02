package com.vivo.push.restructure.b;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.vivo.push.PushConfig;
import com.vivo.push.util.aa;
import com.vivo.push.util.g;
import com.vivo.push.util.u;
import com.vivo.push.util.z;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: PushRelyImpl.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d implements a {
    private static Map<String, c> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8605b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private z f8606c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile PushConfig f8607d;

    public d(z zVar) {
        this.f8606c = zVar;
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a(Context context, String str) {
        if (!TextUtils.isEmpty(this.f8605b)) {
            return this.f8605b;
        }
        if (context == null || TextUtils.isEmpty(str)) {
            u.a("PushRelyImpl", "getReceiverClassName() params error, context = " + context + ", action = " + str);
            return "";
        }
        String packageName = context.getPackageName();
        this.f8605b = a(context, packageName, str);
        if (TextUtils.isEmpty(this.f8605b)) {
            u.d("PushRelyImpl", " reflectReceiver error: receiver for: " + str + " not found, package: " + packageName);
        }
        return this.f8605b;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b() {
        a("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String c() {
        c cVar = a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String strB = cVar.b();
            if (!TextUtils.isEmpty(strB)) {
                return strB;
            }
        }
        String strC = this.f8606c.c();
        if (!TextUtils.isEmpty(strC)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.b(strC);
            a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return strC;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d() {
        b("");
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e() {
        this.f8606c.a();
        a.clear();
    }

    @Override // com.vivo.push.restructure.b.a
    public final String f() {
        return this.f8606c.b("APP_TOKEN", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final String g() {
        return this.f8606c.b("APP_TAGS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void h() {
        this.f8606c.a("APP_TAGS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String i() {
        return this.f8606c.b("APP_ALIAS", (String) null);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void j() {
        this.f8606c.a("APP_ALIAS");
    }

    @Override // com.vivo.push.restructure.b.a
    public final String k() {
        com.vivo.push.model.b bVarA = aa.a(com.vivo.push.restructure.a.a().b(), com.vivo.push.restructure.a.a().f());
        if (bVarA == null || bVarA.c()) {
            return null;
        }
        return bVarA.a();
    }

    @Override // com.vivo.push.restructure.b.a
    public final PushConfig l() {
        if (this.f8607d != null) {
            return this.f8607d;
        }
        int iB = this.f8606c.b("PUSH_CLIENT_CONFIG", 1) & 1;
        return new PushConfig.Builder().agreePrivacyStatement(iB != 0).openMultiUserMode(iB != 0).build();
    }

    @Override // com.vivo.push.restructure.b.a
    public final void b(String str) {
        this.f8606c.a("APP_APIKEY", str);
        c cVar = a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.b(str);
        a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void d(String str) {
        this.f8606c.a("APP_TAGS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void e(String str) {
        this.f8606c.a("APP_ALIAS", str);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void c(String str) {
        this.f8606c.a("APP_TOKEN", str);
    }

    private static String a(Context context, String str, String str2) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return null;
        }
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (listQueryBroadcastReceivers = packageManager.queryBroadcastReceivers(intent, 64)) == null || listQueryBroadcastReceivers.size() <= 0) {
                return null;
            }
            return listQueryBroadcastReceivers.get(0).activityInfo.name;
        } catch (Exception e2) {
            u.a("PushRelyImpl", "error  " + e2.getMessage());
            return null;
        }
    }

    @Override // com.vivo.push.restructure.b.a
    public final String a() {
        c cVar = a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar != null) {
            String strA = cVar.a();
            if (!TextUtils.isEmpty(strA)) {
                return strA;
            }
        }
        String strB = this.f8606c.b();
        if (!TextUtils.isEmpty(strB)) {
            if (cVar == null) {
                cVar = new c();
            }
            cVar.a(strB);
            a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
        }
        return strB;
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(String str) {
        this.f8606c.a("APP_APPID", str);
        c cVar = a.get(com.vivo.push.restructure.a.a().b().getPackageName());
        if (cVar == null) {
            cVar = new c();
        }
        cVar.a(str);
        a.put(com.vivo.push.restructure.a.a().b().getPackageName(), cVar);
    }

    @Override // com.vivo.push.restructure.b.a
    public final void a(PushConfig pushConfig) {
        int i2;
        if (pushConfig == null) {
            return;
        }
        this.f8607d = null;
        Context contextB = com.vivo.push.restructure.a.a().b();
        if (pushConfig == null) {
            i2 = 1;
        } else {
            i2 = (pushConfig.isAgreePrivacyStatement() ? 1 : 0) | (pushConfig.isOpenMultiUser() ? 1 : 0);
        }
        this.f8606c.a("PUSH_CLIENT_CONFIG", i2);
        g.a().execute(new e(this, contextB, pushConfig));
        this.f8607d = pushConfig;
    }
}
