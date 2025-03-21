package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4287i;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* renamed from: com.xiaomi.mipush.sdk.b */
/* loaded from: classes2.dex */
public class C4048b {

    /* renamed from: a */
    private static volatile C4048b f14375a;

    /* renamed from: a */
    private Context f14376a;

    /* renamed from: a */
    private a f14377a;

    /* renamed from: a */
    String f14378a;

    /* renamed from: a */
    private Map<String, a> f14379a;

    private C4048b(Context context) {
        this.f14376a = context;
        m13477c();
    }

    /* renamed from: a */
    public static C4048b m13476a(Context context) {
        if (f14375a == null) {
            synchronized (C4048b.class) {
                if (f14375a == null) {
                    f14375a = new C4048b(context);
                }
            }
        }
        return f14375a;
    }

    /* renamed from: c */
    private void m13477c() {
        this.f14377a = new a(this.f14376a);
        this.f14379a = new HashMap();
        SharedPreferences m13475a = m13475a(this.f14376a);
        this.f14377a.f14382a = m13475a.getString("appId", null);
        this.f14377a.f14384b = m13475a.getString("appToken", null);
        this.f14377a.f14386c = m13475a.getString("regId", null);
        this.f14377a.f14387d = m13475a.getString("regSec", null);
        this.f14377a.f14389f = m13475a.getString("devId", null);
        if (!TextUtils.isEmpty(this.f14377a.f14389f) && C4287i.m15640a(this.f14377a.f14389f)) {
            this.f14377a.f14389f = C4287i.m15654h(this.f14376a);
            m13475a.edit().putString("devId", this.f14377a.f14389f).commit();
        }
        this.f14377a.f14388e = m13475a.getString("vName", null);
        this.f14377a.f14383a = m13475a.getBoolean("valid", true);
        this.f14377a.f14385b = m13475a.getBoolean("paused", false);
        this.f14377a.f14380a = m13475a.getInt("envType", 1);
        this.f14377a.f14390g = m13475a.getString("regResource", null);
        this.f14377a.f14391h = m13475a.getString("appRegion", null);
    }

    /* renamed from: b */
    public boolean m13494b() {
        if (this.f14377a.m13511a()) {
            return true;
        }
        AbstractC4022b.m13347a("Don't send message before initialization succeeded!");
        return false;
    }

    /* renamed from: d */
    public String m13497d() {
        return this.f14377a.f14387d;
    }

    /* renamed from: e */
    public String m13499e() {
        return this.f14377a.f14390g;
    }

    /* renamed from: f */
    public String m13501f() {
        return this.f14377a.f14391h;
    }

    /* renamed from: d */
    public boolean m13498d() {
        return (TextUtils.isEmpty(this.f14377a.f14382a) || TextUtils.isEmpty(this.f14377a.f14384b) || TextUtils.isEmpty(this.f14377a.f14386c) || TextUtils.isEmpty(this.f14377a.f14387d)) ? false : true;
    }

    /* renamed from: e */
    public boolean m13500e() {
        return this.f14377a.f14385b;
    }

    /* renamed from: f */
    public boolean m13502f() {
        return !this.f14377a.f14383a;
    }

    /* renamed from: b */
    public String m13490b() {
        return this.f14377a.f14384b;
    }

    /* renamed from: b */
    public void m13493b(String str, String str2, String str3) {
        this.f14377a.m13514b(str, str2, str3);
    }

    /* renamed from: b */
    public void m13492b(String str) {
        this.f14379a.remove(str);
        m13475a(this.f14376a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* renamed from: a */
    public boolean m13487a() {
        Context context = this.f14376a;
        return !TextUtils.equals(C4233g.m14931a(context, context.getPackageName()), this.f14377a.f14388e);
    }

    /* renamed from: b */
    public void m13491b() {
        this.f14377a.m13513b();
    }

    /* renamed from: com.xiaomi.mipush.sdk.b$a */
    public static class a {

        /* renamed from: a */
        private Context f14381a;

        /* renamed from: a */
        public String f14382a;

        /* renamed from: b */
        public String f14384b;

        /* renamed from: c */
        public String f14386c;

        /* renamed from: d */
        public String f14387d;

        /* renamed from: e */
        public String f14388e;

        /* renamed from: f */
        public String f14389f;

        /* renamed from: g */
        public String f14390g;

        /* renamed from: h */
        public String f14391h;

        /* renamed from: a */
        public boolean f14383a = true;

        /* renamed from: b */
        public boolean f14385b = false;

        /* renamed from: a */
        public int f14380a = 1;

        public a(Context context) {
            this.f14381a = context;
        }

        /* renamed from: a */
        public void m13509a(String str, String str2, String str3) {
            this.f14382a = str;
            this.f14384b = str2;
            this.f14390g = str3;
            SharedPreferences.Editor edit = C4048b.m13475a(this.f14381a).edit();
            edit.putString("appId", this.f14382a);
            edit.putString("appToken", str2);
            edit.putString("regResource", str3);
            edit.commit();
        }

        /* renamed from: b */
        public void m13514b(String str, String str2, String str3) {
            this.f14386c = str;
            this.f14387d = str2;
            this.f14389f = C4287i.m15654h(this.f14381a);
            this.f14388e = m13504a();
            this.f14383a = true;
            this.f14391h = str3;
            SharedPreferences.Editor edit = C4048b.m13475a(this.f14381a).edit();
            edit.putString("regId", str);
            edit.putString("regSec", str2);
            edit.putString("devId", this.f14389f);
            edit.putString("vName", m13504a());
            edit.putBoolean("valid", true);
            edit.putString("appRegion", str3);
            edit.commit();
        }

        /* renamed from: c */
        public void m13515c(String str, String str2, String str3) {
            this.f14382a = str;
            this.f14384b = str2;
            this.f14390g = str3;
        }

        /* renamed from: a */
        public void m13508a(String str, String str2) {
            this.f14386c = str;
            this.f14387d = str2;
            this.f14389f = C4287i.m15654h(this.f14381a);
            this.f14388e = m13504a();
            this.f14383a = true;
        }

        /* renamed from: a */
        public boolean m13512a(String str, String str2) {
            boolean equals = TextUtils.equals(this.f14382a, str);
            boolean equals2 = TextUtils.equals(this.f14384b, str2);
            boolean z = !TextUtils.isEmpty(this.f14386c);
            boolean z2 = !TextUtils.isEmpty(this.f14387d);
            boolean z3 = TextUtils.isEmpty(C4287i.m15643b(this.f14381a)) || TextUtils.equals(this.f14389f, C4287i.m15654h(this.f14381a)) || TextUtils.equals(this.f14389f, C4287i.m15653g(this.f14381a));
            boolean z4 = equals && equals2 && z && z2 && z3;
            if (!z4) {
                AbstractC4022b.m13363e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(equals), Boolean.valueOf(equals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        /* renamed from: b */
        public void m13513b() {
            this.f14383a = false;
            C4048b.m13475a(this.f14381a).edit().putBoolean("valid", this.f14383a).commit();
        }

        /* renamed from: a */
        public boolean m13511a() {
            return m13512a(this.f14382a, this.f14384b);
        }

        /* renamed from: a */
        private String m13504a() {
            Context context = this.f14381a;
            return C4233g.m14931a(context, context.getPackageName());
        }

        /* renamed from: a */
        public void m13506a() {
            C4048b.m13475a(this.f14381a).edit().clear().commit();
            this.f14382a = null;
            this.f14384b = null;
            this.f14386c = null;
            this.f14387d = null;
            this.f14389f = null;
            this.f14388e = null;
            this.f14383a = false;
            this.f14385b = false;
            this.f14391h = null;
            this.f14380a = 1;
        }

        /* renamed from: a */
        public void m13510a(boolean z) {
            this.f14385b = z;
        }

        /* renamed from: a */
        public void m13507a(int i2) {
            this.f14380a = i2;
        }

        /* renamed from: a */
        public static a m13503a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f14382a = jSONObject.getString("appId");
                aVar.f14384b = jSONObject.getString("appToken");
                aVar.f14386c = jSONObject.getString("regId");
                aVar.f14387d = jSONObject.getString("regSec");
                aVar.f14389f = jSONObject.getString("devId");
                aVar.f14388e = jSONObject.getString("vName");
                aVar.f14383a = jSONObject.getBoolean("valid");
                aVar.f14385b = jSONObject.getBoolean("paused");
                aVar.f14380a = jSONObject.getInt("envType");
                aVar.f14390g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                AbstractC4022b.m13351a(th);
                return null;
            }
        }

        /* renamed from: a */
        public static String m13505a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f14382a);
                jSONObject.put("appToken", aVar.f14384b);
                jSONObject.put("regId", aVar.f14386c);
                jSONObject.put("regSec", aVar.f14387d);
                jSONObject.put("devId", aVar.f14389f);
                jSONObject.put("vName", aVar.f14388e);
                jSONObject.put("valid", aVar.f14383a);
                jSONObject.put("paused", aVar.f14385b);
                jSONObject.put("envType", aVar.f14380a);
                jSONObject.put("regResource", aVar.f14390g);
                return jSONObject.toString();
            } catch (Throwable th) {
                AbstractC4022b.m13351a(th);
                return null;
            }
        }
    }

    /* renamed from: a */
    public void m13483a(String str) {
        SharedPreferences.Editor edit = m13475a(this.f14376a).edit();
        edit.putString("vName", str);
        edit.commit();
        this.f14377a.f14388e = str;
    }

    /* renamed from: a */
    public String m13480a() {
        return this.f14377a.f14382a;
    }

    /* renamed from: a */
    public boolean m13488a(String str, String str2) {
        return this.f14377a.m13512a(str, str2);
    }

    /* renamed from: a */
    public void m13485a(String str, String str2, String str3) {
        this.f14377a.m13509a(str, str2, str3);
    }

    /* renamed from: a */
    public void m13481a() {
        this.f14377a.m13506a();
    }

    /* renamed from: a */
    public a m13479a(String str) {
        if (this.f14379a.containsKey(str)) {
            return this.f14379a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences m13475a = m13475a(this.f14376a);
        if (!m13475a.contains(str2)) {
            return null;
        }
        a m13503a = a.m13503a(this.f14376a, m13475a.getString(str2, ""));
        this.f14379a.put(str2, m13503a);
        return m13503a;
    }

    /* renamed from: c */
    public String m13495c() {
        return this.f14377a.f14386c;
    }

    /* renamed from: c */
    public boolean m13496c() {
        return this.f14377a.m13511a();
    }

    /* renamed from: a */
    public void m13484a(String str, a aVar) {
        this.f14379a.put(str, aVar);
        m13475a(this.f14376a).edit().putString("hybrid_app_info_" + str, a.m13505a(aVar)).commit();
    }

    /* renamed from: a */
    public boolean m13489a(String str, String str2, String str3) {
        a m13479a = m13479a(str3);
        return m13479a != null && TextUtils.equals(str, m13479a.f14382a) && TextUtils.equals(str2, m13479a.f14384b);
    }

    /* renamed from: a */
    public static SharedPreferences m13475a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    /* renamed from: a */
    public int m13478a() {
        return this.f14377a.f14380a;
    }

    /* renamed from: a */
    public void m13486a(boolean z) {
        this.f14377a.m13510a(z);
        m13475a(this.f14376a).edit().putBoolean("paused", z).commit();
    }

    /* renamed from: a */
    public void m13482a(int i2) {
        this.f14377a.m13507a(i2);
        m13475a(this.f14376a).edit().putInt("envType", i2).commit();
    }
}
