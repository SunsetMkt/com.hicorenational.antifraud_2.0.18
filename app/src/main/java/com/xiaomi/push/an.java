package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public class an implements ai {
    private static volatile an a;

    /* JADX INFO: renamed from: a */
    private int f182a = am.a;

    /* JADX INFO: renamed from: a */
    private long f183a;

    /* JADX INFO: renamed from: a */
    private Context f184a;

    /* JADX INFO: renamed from: a */
    private ai f185a;

    /* JADX INFO: renamed from: a */
    private String f186a;

    private an(Context context) {
        this.f184a = context.getApplicationContext();
        this.f185a = am.a(context);
        com.xiaomi.channel.commonutils.logger.b.m48a("create id manager is: " + this.f182a);
    }

    public static an a(Context context) {
        if (a == null) {
            synchronized (an.class) {
                if (a == null) {
                    a = new an(context.getApplicationContext());
                }
            }
        }
        return a;
    }

    private String a(String str) {
        return str == null ? "" : str;
    }

    public void a() {
    }

    public String b() {
        return null;
    }

    public String c() {
        return null;
    }

    public String d() {
        return null;
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public boolean mo135a() {
        return this.f185a.mo135a();
    }

    @Override // com.xiaomi.push.ai
    /* JADX INFO: renamed from: a */
    public String mo134a() {
        if (j.m625a(this.f184a)) {
            return a(this.f185a.mo134a());
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (Math.abs(jCurrentTimeMillis - this.f183a) > 86400000) {
            this.f183a = jCurrentTimeMillis;
            String strA = a(this.f185a.mo134a());
            this.f186a = strA;
            return strA;
        }
        return a(this.f186a);
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String strB = b();
        if (!TextUtils.isEmpty(strB)) {
            map.put("udid", strB);
        }
        String strMo134a = mo134a();
        if (!TextUtils.isEmpty(strMo134a)) {
            map.put("oaid", strMo134a);
        }
        String strC = c();
        if (!TextUtils.isEmpty(strC)) {
            map.put("vaid", strC);
        }
        String strD = d();
        if (!TextUtils.isEmpty(strD)) {
            map.put("aaid", strD);
        }
        map.put("oaid_type", String.valueOf(this.f182a));
    }
}
