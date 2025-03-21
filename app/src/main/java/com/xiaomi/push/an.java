package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.util.Map;

/* loaded from: classes2.dex */
public class an implements ai {

    /* renamed from: a, reason: collision with root package name */
    private static volatile an f12444a;

    /* renamed from: a, reason: collision with other field name */
    private int f182a = am.f12443a;

    /* renamed from: a, reason: collision with other field name */
    private long f183a;

    /* renamed from: a, reason: collision with other field name */
    private Context f184a;

    /* renamed from: a, reason: collision with other field name */
    private ai f185a;

    /* renamed from: a, reason: collision with other field name */
    private String f186a;

    private an(Context context) {
        this.f184a = context.getApplicationContext();
        this.f185a = am.a(context);
        com.xiaomi.channel.commonutils.logger.b.m50a("create id manager is: " + this.f182a);
    }

    public static an a(Context context) {
        if (f12444a == null) {
            synchronized (an.class) {
                if (f12444a == null) {
                    f12444a = new an(context.getApplicationContext());
                }
            }
        }
        return f12444a;
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
    /* renamed from: a */
    public boolean mo137a() {
        return this.f185a.mo137a();
    }

    @Override // com.xiaomi.push.ai
    /* renamed from: a */
    public String mo136a() {
        if (j.m627a(this.f184a)) {
            return a(this.f185a.mo136a());
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f183a) > 86400000) {
            this.f183a = currentTimeMillis;
            String a2 = a(this.f185a.mo136a());
            this.f186a = a2;
            return a2;
        }
        return a(this.f186a);
    }

    public void a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String b2 = b();
        if (!TextUtils.isEmpty(b2)) {
            map.put("udid", b2);
        }
        String mo136a = mo136a();
        if (!TextUtils.isEmpty(mo136a)) {
            map.put("oaid", mo136a);
        }
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            map.put("vaid", c2);
        }
        String d2 = d();
        if (!TextUtils.isEmpty(d2)) {
            map.put("aaid", d2);
        }
        map.put("oaid_type", String.valueOf(this.f182a));
    }
}
