package com.heytap.mcssdk.p160k;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.mcssdk.C2080a;

/* renamed from: com.heytap.mcssdk.k.h */
/* loaded from: classes.dex */
public class C2108h {

    /* renamed from: d */
    private static final String f6258d = "shared_msg_sdk";

    /* renamed from: e */
    private static final String f6259e = "hasDefaultChannelCreated";

    /* renamed from: f */
    private static final String f6260f = "decryptTag";

    /* renamed from: a */
    private Context f6261a;

    /* renamed from: b */
    private SharedPreferences f6262b;

    /* renamed from: c */
    private Object f6263c;

    /* renamed from: com.heytap.mcssdk.k.h$b */
    private static class b {

        /* renamed from: a */
        static C2108h f6264a = new C2108h();

        private b() {
        }
    }

    private C2108h() {
        this.f6263c = new Object();
        Context m5742k = C2080a.m5698w().m5742k();
        if (m5742k != null) {
            this.f6261a = m5906a(m5742k);
        }
        Context context = this.f6261a;
        if (context != null) {
            this.f6262b = context.getSharedPreferences(f6258d, 0);
        }
    }

    /* renamed from: a */
    private Context m5906a(Context context) {
        boolean m5869a = C2104d.m5869a();
        C2107g.m5884b("fbeVersion is " + m5869a);
        return (!m5869a || Build.VERSION.SDK_INT < 24) ? context.getApplicationContext() : context.createDeviceProtectedStorageContext();
    }

    /* renamed from: c */
    public static C2108h m5907c() {
        return b.f6264a;
    }

    /* renamed from: d */
    private SharedPreferences m5908d() {
        SharedPreferences sharedPreferences = this.f6262b;
        if (sharedPreferences != null) {
            return sharedPreferences;
        }
        synchronized (this.f6263c) {
            if (this.f6262b != null || this.f6261a == null) {
                return this.f6262b;
            }
            this.f6262b = this.f6261a.getSharedPreferences(f6258d, 0);
            return this.f6262b;
        }
    }

    /* renamed from: a */
    public void m5909a(String str) {
        SharedPreferences m5908d = m5908d();
        if (m5908d != null) {
            m5908d.edit().putString(f6260f, str).commit();
        }
    }

    /* renamed from: a */
    public void m5910a(boolean z) {
        SharedPreferences m5908d = m5908d();
        if (m5908d != null) {
            m5908d.edit().putBoolean(f6259e, z).commit();
        }
    }

    /* renamed from: a */
    public boolean m5911a() {
        SharedPreferences m5908d = m5908d();
        if (m5908d != null) {
            return m5908d.getBoolean(f6259e, false);
        }
        return false;
    }

    /* renamed from: b */
    public String m5912b() {
        SharedPreferences m5908d = m5908d();
        return m5908d != null ? m5908d.getString(f6260f, "DES") : "DES";
    }
}
