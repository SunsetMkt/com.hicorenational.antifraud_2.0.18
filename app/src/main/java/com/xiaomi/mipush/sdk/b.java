package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class b {
    private static volatile b a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Context f106a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f107a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    String f108a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Map<String, a> f109a;

    private b(Context context) {
        this.f106a = context;
        c();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static b m73a(Context context) {
        if (a == null) {
            synchronized (b.class) {
                if (a == null) {
                    a = new b(context);
                }
            }
        }
        return a;
    }

    private void c() {
        this.f107a = new a(this.f106a);
        this.f109a = new HashMap();
        SharedPreferences sharedPreferencesA = a(this.f106a);
        this.f107a.f111a = sharedPreferencesA.getString("appId", null);
        this.f107a.f8710b = sharedPreferencesA.getString("appToken", null);
        this.f107a.f8711c = sharedPreferencesA.getString("regId", null);
        this.f107a.f8712d = sharedPreferencesA.getString("regSec", null);
        this.f107a.f8714f = sharedPreferencesA.getString("devId", null);
        if (!TextUtils.isEmpty(this.f107a.f8714f) && com.xiaomi.push.i.a(this.f107a.f8714f)) {
            this.f107a.f8714f = com.xiaomi.push.i.h(this.f106a);
            sharedPreferencesA.edit().putString("devId", this.f107a.f8714f).commit();
        }
        this.f107a.f8713e = sharedPreferencesA.getString("vName", null);
        this.f107a.f112a = sharedPreferencesA.getBoolean("valid", true);
        this.f107a.f113b = sharedPreferencesA.getBoolean("paused", false);
        this.f107a.a = sharedPreferencesA.getInt("envType", 1);
        this.f107a.f8715g = sharedPreferencesA.getString("regResource", null);
        this.f107a.f8716h = sharedPreferencesA.getString("appRegion", null);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public boolean m80b() {
        if (this.f107a.m87a()) {
            return true;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("Don't send message before initialization succeeded!");
        return false;
    }

    public String d() {
        return this.f107a.f8712d;
    }

    public String e() {
        return this.f107a.f8715g;
    }

    public String f() {
        return this.f107a.f8716h;
    }

    /* JADX INFO: renamed from: d, reason: collision with other method in class */
    public boolean m83d() {
        return (TextUtils.isEmpty(this.f107a.f111a) || TextUtils.isEmpty(this.f107a.f8710b) || TextUtils.isEmpty(this.f107a.f8711c) || TextUtils.isEmpty(this.f107a.f8712d)) ? false : true;
    }

    /* JADX INFO: renamed from: e, reason: collision with other method in class */
    public boolean m84e() {
        return this.f107a.f113b;
    }

    /* JADX INFO: renamed from: f, reason: collision with other method in class */
    public boolean m85f() {
        return !this.f107a.f112a;
    }

    public String b() {
        return this.f107a.f8710b;
    }

    public void b(String str, String str2, String str3) {
        this.f107a.b(str, str2, str3);
    }

    public void b(String str) {
        this.f109a.remove(str);
        a(this.f106a).edit().remove("hybrid_app_info_" + str).commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m77a() {
        Context context = this.f106a;
        return !TextUtils.equals(com.xiaomi.push.g.m449a(context, context.getPackageName()), this.f107a.f8713e);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m79b() {
        this.f107a.b();
    }

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private Context f110a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f111a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public String f8710b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public String f8711c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public String f8712d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public String f8713e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public String f8714f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public String f8715g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public String f8716h;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f112a = true;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public boolean f113b = false;
        public int a = 1;

        public a(Context context) {
            this.f110a = context;
        }

        public void a(String str, String str2, String str3) {
            this.f111a = str;
            this.f8710b = str2;
            this.f8715g = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f110a).edit();
            editorEdit.putString("appId", this.f111a);
            editorEdit.putString("appToken", str2);
            editorEdit.putString("regResource", str3);
            editorEdit.commit();
        }

        public void b(String str, String str2, String str3) {
            this.f8711c = str;
            this.f8712d = str2;
            this.f8714f = com.xiaomi.push.i.h(this.f110a);
            this.f8713e = a();
            this.f112a = true;
            this.f8716h = str3;
            SharedPreferences.Editor editorEdit = b.a(this.f110a).edit();
            editorEdit.putString("regId", str);
            editorEdit.putString("regSec", str2);
            editorEdit.putString("devId", this.f8714f);
            editorEdit.putString("vName", a());
            editorEdit.putBoolean("valid", true);
            editorEdit.putString("appRegion", str3);
            editorEdit.commit();
        }

        public void c(String str, String str2, String str3) {
            this.f111a = str;
            this.f8710b = str2;
            this.f8715g = str3;
        }

        public void a(String str, String str2) {
            this.f8711c = str;
            this.f8712d = str2;
            this.f8714f = com.xiaomi.push.i.h(this.f110a);
            this.f8713e = a();
            this.f112a = true;
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m88a(String str, String str2) {
            boolean zEquals = TextUtils.equals(this.f111a, str);
            boolean zEquals2 = TextUtils.equals(this.f8710b, str2);
            boolean z = !TextUtils.isEmpty(this.f8711c);
            boolean z2 = !TextUtils.isEmpty(this.f8712d);
            boolean z3 = TextUtils.isEmpty(com.xiaomi.push.i.b(this.f110a)) || TextUtils.equals(this.f8714f, com.xiaomi.push.i.h(this.f110a)) || TextUtils.equals(this.f8714f, com.xiaomi.push.i.g(this.f110a));
            boolean z4 = zEquals && zEquals2 && z && z2 && z3;
            if (!z4) {
                com.xiaomi.channel.commonutils.logger.b.e(String.format("register invalid, aid=%s;atn=%s;rid=%s;rse=%s;did=%s", Boolean.valueOf(zEquals), Boolean.valueOf(zEquals2), Boolean.valueOf(z), Boolean.valueOf(z2), Boolean.valueOf(z3)));
            }
            return z4;
        }

        public void b() {
            this.f112a = false;
            b.a(this.f110a).edit().putBoolean("valid", this.f112a).commit();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m87a() {
            return m88a(this.f111a, this.f8710b);
        }

        private String a() {
            Context context = this.f110a;
            return com.xiaomi.push.g.m449a(context, context.getPackageName());
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public void m86a() {
            b.a(this.f110a).edit().clear().commit();
            this.f111a = null;
            this.f8710b = null;
            this.f8711c = null;
            this.f8712d = null;
            this.f8714f = null;
            this.f8713e = null;
            this.f112a = false;
            this.f113b = false;
            this.f8716h = null;
            this.a = 1;
        }

        public void a(boolean z) {
            this.f113b = z;
        }

        public void a(int i2) {
            this.a = i2;
        }

        public static a a(Context context, String str) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = new a(context);
                aVar.f111a = jSONObject.getString("appId");
                aVar.f8710b = jSONObject.getString("appToken");
                aVar.f8711c = jSONObject.getString("regId");
                aVar.f8712d = jSONObject.getString("regSec");
                aVar.f8714f = jSONObject.getString("devId");
                aVar.f8713e = jSONObject.getString("vName");
                aVar.f112a = jSONObject.getBoolean("valid");
                aVar.f113b = jSONObject.getBoolean("paused");
                aVar.a = jSONObject.getInt("envType");
                aVar.f8715g = jSONObject.getString("regResource");
                return aVar;
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }

        public static String a(a aVar) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("appId", aVar.f111a);
                jSONObject.put("appToken", aVar.f8710b);
                jSONObject.put("regId", aVar.f8711c);
                jSONObject.put("regSec", aVar.f8712d);
                jSONObject.put("devId", aVar.f8714f);
                jSONObject.put("vName", aVar.f8713e);
                jSONObject.put("valid", aVar.f112a);
                jSONObject.put("paused", aVar.f113b);
                jSONObject.put("envType", aVar.a);
                jSONObject.put("regResource", aVar.f8715g);
                return jSONObject.toString();
            } catch (Throwable th) {
                com.xiaomi.channel.commonutils.logger.b.a(th);
                return null;
            }
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m76a(String str) {
        SharedPreferences.Editor editorEdit = a(this.f106a).edit();
        editorEdit.putString("vName", str);
        editorEdit.commit();
        this.f107a.f8713e = str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m74a() {
        return this.f107a.f111a;
    }

    public boolean a(String str, String str2) {
        return this.f107a.m88a(str, str2);
    }

    public void a(String str, String str2, String str3) {
        this.f107a.a(str, str2, str3);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m75a() {
        this.f107a.m86a();
    }

    public a a(String str) {
        if (this.f109a.containsKey(str)) {
            return this.f109a.get(str);
        }
        String str2 = "hybrid_app_info_" + str;
        SharedPreferences sharedPreferencesA = a(this.f106a);
        if (!sharedPreferencesA.contains(str2)) {
            return null;
        }
        a aVarA = a.a(this.f106a, sharedPreferencesA.getString(str2, ""));
        this.f109a.put(str2, aVarA);
        return aVarA;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public String m81c() {
        return this.f107a.f8711c;
    }

    /* JADX INFO: renamed from: c, reason: collision with other method in class */
    public boolean m82c() {
        return this.f107a.m87a();
    }

    public void a(String str, a aVar) {
        this.f109a.put(str, aVar);
        a(this.f106a).edit().putString("hybrid_app_info_" + str, a.a(aVar)).commit();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m78a(String str, String str2, String str3) {
        a aVarA = a(str3);
        return aVarA != null && TextUtils.equals(str, aVarA.f111a) && TextUtils.equals(str2, aVarA.f8710b);
    }

    public static SharedPreferences a(Context context) {
        return context.getSharedPreferences("mipush", 0);
    }

    public int a() {
        return this.f107a.a;
    }

    public void a(boolean z) {
        this.f107a.a(z);
        a(this.f106a).edit().putBoolean("paused", z).commit();
    }

    public void a(int i2) {
        this.f107a.a(i2);
        a(this.f106a).edit().putInt("envType", i2).commit();
    }
}
