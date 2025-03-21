package com.taobao.accs.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.C3351bh;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.client.b */
/* loaded from: classes.dex */
public class C2979b {

    /* renamed from: a */
    private Context f9409a;

    /* renamed from: d */
    private long f9412d;

    /* renamed from: f */
    private String f9414f;

    /* renamed from: b */
    private ConcurrentMap<String, Integer> f9410b = new ConcurrentHashMap();

    /* renamed from: c */
    private ConcurrentMap<String, Set<String>> f9411c = new ConcurrentHashMap();

    /* renamed from: e */
    private String f9413e = "ClientManager_";

    public C2979b(Context context, String str) {
        this.f9414f = "ACCS_BIND";
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f9413e += str;
        this.f9409a = context.getApplicationContext();
        this.f9414f = "ACCS_BIND" + str;
        m8980a();
    }

    /* renamed from: a */
    public void m8982a(String str) {
        Integer num = this.f9410b.get(str);
        if (num == null || num.intValue() != 2) {
            this.f9410b.put(str, 2);
            m8981a(this.f9409a, this.f9414f, this.f9412d, this.f9410b);
        }
    }

    /* renamed from: b */
    public void m8984b(String str) {
        Integer num = this.f9410b.get(str);
        if (num == null || num.intValue() != 4) {
            this.f9410b.put(str, 4);
            m8981a(this.f9409a, this.f9414f, this.f9412d, this.f9410b);
        }
    }

    /* renamed from: c */
    public boolean m8986c(String str) {
        if (this.f9410b.isEmpty()) {
            m8980a();
        }
        Integer num = this.f9410b.get(str);
        ALog.m9183i(this.f9413e, "isAppBinded", "appStatus", num, "mBindStatus", this.f9410b);
        return num != null && num.intValue() == 2;
    }

    /* renamed from: d */
    public boolean m8987d(String str) {
        Integer num = this.f9410b.get(str);
        return num != null && num.intValue() == 4;
    }

    /* renamed from: e */
    public void m8988e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f9411c.remove(str);
        } catch (Exception e2) {
            ALog.m9182e(this.f9413e, this.f9413e + e2.toString(), new Object[0]);
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    public void m8983a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                Set<String> set = this.f9411c.get(str);
                if (set == null) {
                    set = new HashSet<>();
                }
                set.add(str2);
                this.f9411c.put(str, set);
            }
        } catch (Exception e2) {
            ALog.m9182e(this.f9413e, this.f9413e + e2.toString(), new Object[0]);
            e2.printStackTrace();
        }
    }

    /* renamed from: b */
    public boolean m8985b(String str, String str2) {
        Set<String> set;
        try {
            if (!TextUtils.isEmpty(str) && (set = this.f9411c.get(str)) != null) {
                if (set.contains(str2)) {
                    return true;
                }
            }
        } catch (Exception e2) {
            ALog.m9182e(this.f9413e, this.f9413e + e2.toString(), new Object[0]);
            e2.printStackTrace();
        }
        return false;
    }

    /* renamed from: a */
    private void m8980a() {
        try {
            String string = this.f9409a.getSharedPreferences(this.f9414f, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.m9186w(this.f9413e, "restoreClients break as packages null", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f9412d = jSONArray.getLong(0);
            if (System.currentTimeMillis() < this.f9412d + 86400000) {
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    this.f9410b.put(jSONObject.getString(C3351bh.f11576aA), Integer.valueOf(jSONObject.getInt(C3351bh.f11580aE)));
                }
                ALog.m9183i(this.f9413e, "restoreClients success", "mBindStatus", this.f9410b);
                return;
            }
            ALog.m9183i(this.f9413e, "restoreClients expired", "lastFlushTime", Long.valueOf(this.f9412d));
            this.f9412d = 0L;
        } catch (Exception e2) {
            ALog.m9185w(this.f9413e, "restoreClients", e2, new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m8981a(Context context, String str, long j2, Map<String, Integer> map) {
        try {
            String[] strArr = (String[]) map.keySet().toArray(new String[0]);
            JSONArray jSONArray = new JSONArray();
            if (j2 > 0 && j2 < System.currentTimeMillis()) {
                jSONArray.put(j2);
            } else {
                jSONArray.put(System.currentTimeMillis() - (Math.random() * 8.64E7d));
            }
            for (String str2 : strArr) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3351bh.f11576aA, str2);
                jSONObject.put(C3351bh.f11580aE, map.get(str2).intValue());
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor edit = context.getSharedPreferences(str, 0).edit();
            edit.putString("bind_status", jSONArray.toString());
            edit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
