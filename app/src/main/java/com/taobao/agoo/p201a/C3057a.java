package com.taobao.agoo.p201a;

import android.content.Context;
import android.text.TextUtils;
import com.taobao.accs.client.C2979b;
import com.taobao.accs.common.Constants;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UtilityImpl;
import com.umeng.analytics.pro.C3351bh;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import org.android.agoo.common.Config;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Taobao */
/* renamed from: com.taobao.agoo.a.a */
/* loaded from: classes2.dex */
public class C3057a {
    public static final String SP_AGOO_BIND_FILE_NAME = "AGOO_BIND";

    /* renamed from: a */
    private ConcurrentMap<String, Integer> f9771a = new ConcurrentHashMap();

    /* renamed from: b */
    private String f9772b;

    /* renamed from: c */
    private long f9773c;

    /* renamed from: d */
    private Context f9774d;

    public C3057a(Context context) {
        if (context == null) {
            throw new RuntimeException("Context is null!!");
        }
        this.f9774d = context.getApplicationContext();
    }

    /* renamed from: a */
    public void m9293a(String str) {
        Integer num = this.f9771a.get(str);
        if (num == null || num.intValue() != 2) {
            this.f9771a.put(str, 2);
            C2979b.m8981a(this.f9774d, "AGOO_BIND", this.f9773c, this.f9771a);
        }
    }

    /* renamed from: b */
    public boolean m9294b(String str) {
        if (this.f9771a.isEmpty()) {
            m9291b();
        }
        Integer num = this.f9771a.get(str);
        ALog.m9183i("AgooBindCache", "isAgooRegistered", Constants.KEY_PACKAGE_NAME, str, "appStatus", num, "agooBindStatus", this.f9771a);
        return (UtilityImpl.m9206a(Config.PREFERENCES, this.f9774d) || num == null || num.intValue() != 2) ? false : true;
    }

    /* renamed from: c */
    public void m9295c(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f9772b = str;
    }

    /* renamed from: d */
    public boolean m9296d(String str) {
        String str2 = this.f9772b;
        return str2 != null && str2.equals(str);
    }

    /* renamed from: a */
    public void m9292a() {
        this.f9772b = null;
    }

    /* renamed from: b */
    private void m9291b() {
        try {
            String string = this.f9774d.getSharedPreferences("AGOO_BIND", 0).getString("bind_status", null);
            if (TextUtils.isEmpty(string)) {
                ALog.m9186w("AgooBindCache", "restoreAgooClients packs null return", new Object[0]);
                return;
            }
            JSONArray jSONArray = new JSONArray(string);
            this.f9773c = jSONArray.getLong(0);
            if (System.currentTimeMillis() < this.f9773c + 86400000) {
                for (int i2 = 1; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    this.f9771a.put(jSONObject.getString(C3351bh.f11576aA), Integer.valueOf(jSONObject.getInt(C3351bh.f11580aE)));
                }
                ALog.m9183i("AgooBindCache", "restoreAgooClients", "mAgooBindStatus", this.f9771a);
                return;
            }
            ALog.m9183i("AgooBindCache", "restoreAgooClients expired", "agooLastFlushTime", Long.valueOf(this.f9773c));
            this.f9773c = 0L;
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
