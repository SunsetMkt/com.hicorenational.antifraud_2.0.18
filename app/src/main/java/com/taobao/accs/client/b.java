package com.taobao.accs.client;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.taobao.accs.utl.ALog;
import com.umeng.analytics.pro.bh;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    private Context a;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f5739d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f5741f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ConcurrentMap<String, Integer> f5737b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ConcurrentMap<String, Set<String>> f5738c = new ConcurrentHashMap();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f5740e = "ClientManager_";

    public b(Context context, String str) {
        this.f5741f = "ACCS_BIND";
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f5740e += str;
        this.a = context.getApplicationContext();
        this.f5741f = "ACCS_BIND" + str;
        a();
    }

    public void a(String str) {
        Integer num = this.f5737b.get(str);
        if (num == null || num.intValue() != 2) {
            this.f5737b.put(str, 2);
            a(this.a, this.f5741f, this.f5739d, this.f5737b);
        }
    }

    public void b(String str) {
        Integer num = this.f5737b.get(str);
        if (num == null || num.intValue() != 4) {
            this.f5737b.put(str, 4);
            a(this.a, this.f5741f, this.f5739d, this.f5737b);
        }
    }

    public boolean c(String str) {
        if (this.f5737b.isEmpty()) {
            a();
        }
        Integer num = this.f5737b.get(str);
        ALog.i(this.f5740e, "isAppBinded", "appStatus", num, "mBindStatus", this.f5737b);
        return num != null && num.intValue() == 2;
    }

    public boolean d(String str) {
        Integer num = this.f5737b.get(str);
        return num != null && num.intValue() == 4;
    }

    public void e(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.f5738c.remove(str);
        } catch (Exception e2) {
            ALog.e(this.f5740e, this.f5740e + e2.toString(), new Object[0]);
            e2.printStackTrace();
        }
    }

    public void a(String str, String str2) {
        try {
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
                Set<String> hashSet = this.f5738c.get(str);
                if (hashSet == null) {
                    hashSet = new HashSet<>();
                }
                hashSet.add(str2);
                this.f5738c.put(str, hashSet);
            }
        } catch (Exception e2) {
            ALog.e(this.f5740e, this.f5740e + e2.toString(), new Object[0]);
            e2.printStackTrace();
        }
    }

    public boolean b(String str, String str2) {
        Set<String> set;
        try {
            if (!TextUtils.isEmpty(str) && (set = this.f5738c.get(str)) != null) {
                if (set.contains(str2)) {
                    return true;
                }
            }
        } catch (Exception e2) {
            ALog.e(this.f5740e, this.f5740e + e2.toString(), new Object[0]);
            e2.printStackTrace();
        }
        return false;
    }

    private void a() {
        try {
            String string = this.a.getSharedPreferences(this.f5741f, 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w(this.f5740e, "restoreClients break as packages null", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f5739d = jSONArray.getLong(0);
            if (System.currentTimeMillis() < this.f5739d + 86400000) {
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    this.f5737b.put(jSONObject.getString(bh.aA), Integer.valueOf(jSONObject.getInt(bh.aE)));
                }
                ALog.i(this.f5740e, "restoreClients success", "mBindStatus", this.f5737b);
                return;
            }
            ALog.i(this.f5740e, "restoreClients expired", "lastFlushTime", Long.valueOf(this.f5739d));
            this.f5739d = 0L;
        } catch (Exception e2) {
            ALog.w(this.f5740e, "restoreClients", e2, new Object[0]);
        }
    }

    public static void a(Context context, String str, long j2, Map<String, Integer> map) {
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
                jSONObject.put(bh.aA, str2);
                jSONObject.put(bh.aE, map.get(str2).intValue());
                jSONArray.put(jSONObject);
            }
            SharedPreferences.Editor editorEdit = context.getSharedPreferences(str, 0).edit();
            editorEdit.putString("bind_status", jSONArray.toString());
            editorEdit.apply();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
