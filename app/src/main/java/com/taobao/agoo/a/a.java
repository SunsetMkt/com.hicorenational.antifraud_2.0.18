package com.taobao.agoo.a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.bh;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";
    private ConcurrentMap<String, Integer> a = new ConcurrentHashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f5949b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f5950c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Context f5951d;

    public a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f5951d = context.getApplicationContext();
    }

    public void a(String str) {
        Integer num = this.a.get(str);
        if (num == null || num.intValue() != 2) {
            this.a.put(str, 2);
            com.taobao.accs.client.b.a(this.f5951d, "AGOO_BIND", this.f5950c, this.a);
        }
    }

    public boolean b(String str) {
        if (this.a.isEmpty()) {
            b();
        }
        Integer num = this.a.get(str);
        ALog.i("AgooBindCache", "isAgooRegistered", Constants.KEY_PACKAGE_NAME, str, "appStatus", num, "agooBindStatus", this.a);
        return (UtilityImpl.a(Config.PREFERENCES, this.f5951d) || num == null || num.intValue() != 2) ? false : true;
    }

    public void c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5949b = str;
    }

    public boolean d(String str) {
        String str2 = this.f5949b;
        return str2 != null && str2.equals(str);
    }

    public void a() {
        this.f5949b = null;
    }

    private void b() {
        try {
            String string = this.f5951d.getSharedPreferences("AGOO_BIND", 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f5950c = jSONArray.getLong(0);
            if (System.currentTimeMillis() < this.f5950c + 86400000) {
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    this.a.put(jSONObject.getString(bh.aA), Integer.valueOf(jSONObject.getInt(bh.aE)));
                }
                ALog.i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.a);
                return;
            }
            ALog.i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(this.f5950c));
            this.f5950c = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
