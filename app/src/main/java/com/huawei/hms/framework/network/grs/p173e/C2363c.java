package com.huawei.hms.framework.network.grs.p173e;

import android.content.Context;
import android.content.pm.PackageManager;
import com.huawei.hms.framework.common.ContextHolder;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.PLSharedPreferences;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.huawei.hms.framework.network.grs.e.c */
/* loaded from: classes.dex */
public class C2363c {

    /* renamed from: b */
    private static final String f7359b = "c";

    /* renamed from: c */
    private static final Map<String, PLSharedPreferences> f7360c = new ConcurrentHashMap(16);

    /* renamed from: a */
    private final PLSharedPreferences f7361a;

    public C2363c(Context context, String str) {
        String packageName = context.getPackageName();
        Logger.m6795d(f7359b, "get pkgname from context is{%s}", packageName);
        if (f7360c.containsKey(str + packageName)) {
            this.f7361a = f7360c.get(str + packageName);
        } else {
            this.f7361a = new PLSharedPreferences(context, str + packageName);
            f7360c.put(str + packageName, this.f7361a);
        }
        m6856a(context);
    }

    /* renamed from: a */
    private void m6856a(Context context) {
        Logger.m6799i(f7359b, "ContextHolder.getAppContext() from GRS is:" + ContextHolder.getAppContext());
        if (ContextHolder.getAppContext() != null) {
            context = ContextHolder.getAppContext();
        }
        try {
            String l2 = Long.toString(context.getPackageManager().getPackageInfo(context.getPackageName(), 16384).versionCode);
            String m6857a = m6857a("version", "");
            if (l2.equals(m6857a)) {
                return;
            }
            Logger.m6800i(f7359b, "app version changed! old version{%s} and new version{%s}", m6857a, l2);
            m6860b();
            m6861b("version", l2);
        } catch (PackageManager.NameNotFoundException unused) {
            Logger.m6803w(f7359b, "get app version failed and catch NameNotFoundException");
        }
    }

    /* renamed from: a */
    public String m6857a(String str, String str2) {
        String string;
        PLSharedPreferences pLSharedPreferences = this.f7361a;
        if (pLSharedPreferences == null) {
            return str2;
        }
        synchronized (pLSharedPreferences) {
            string = this.f7361a.getString(str, str2);
        }
        return string;
    }

    /* renamed from: a */
    public Map<String, ?> m6858a() {
        Map<String, ?> all;
        PLSharedPreferences pLSharedPreferences = this.f7361a;
        if (pLSharedPreferences == null) {
            return new HashMap();
        }
        synchronized (pLSharedPreferences) {
            all = this.f7361a.getAll();
        }
        return all;
    }

    /* renamed from: a */
    public void m6859a(String str) {
        PLSharedPreferences pLSharedPreferences = this.f7361a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f7361a.remove(str);
        }
    }

    /* renamed from: b */
    public void m6860b() {
        PLSharedPreferences pLSharedPreferences = this.f7361a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f7361a.clear();
        }
    }

    /* renamed from: b */
    public void m6861b(String str, String str2) {
        PLSharedPreferences pLSharedPreferences = this.f7361a;
        if (pLSharedPreferences == null) {
            return;
        }
        synchronized (pLSharedPreferences) {
            this.f7361a.putString(str, str2);
        }
    }
}
