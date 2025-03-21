package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.Map;

/* renamed from: com.xiaomi.push.an */
/* loaded from: classes2.dex */
public class C4085an implements InterfaceC4080ai {

    /* renamed from: a */
    private static volatile C4085an f14540a;

    /* renamed from: a */
    private int f14541a = C4084am.f14539a;

    /* renamed from: a */
    private long f14542a;

    /* renamed from: a */
    private Context f14543a;

    /* renamed from: a */
    private InterfaceC4080ai f14544a;

    /* renamed from: a */
    private String f14545a;

    private C4085an(Context context) {
        this.f14543a = context.getApplicationContext();
        this.f14544a = C4084am.m13754a(context);
        AbstractC4022b.m13347a("create id manager is: " + this.f14541a);
    }

    /* renamed from: a */
    public static C4085an m13755a(Context context) {
        if (f14540a == null) {
            synchronized (C4085an.class) {
                if (f14540a == null) {
                    f14540a = new C4085an(context.getApplicationContext());
                }
            }
        }
        return f14540a;
    }

    /* renamed from: a */
    private String m13756a(String str) {
        return str == null ? "" : str;
    }

    /* renamed from: a */
    public void m13757a() {
    }

    /* renamed from: b */
    public String m13759b() {
        return null;
    }

    /* renamed from: c */
    public String m13760c() {
        return null;
    }

    /* renamed from: d */
    public String m13761d() {
        return null;
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public boolean mo13737a() {
        return this.f14544a.mo13737a();
    }

    @Override // com.xiaomi.push.InterfaceC4080ai
    /* renamed from: a */
    public String mo13736a() {
        if (C4300j.m15681a(this.f14543a)) {
            return m13756a(this.f14544a.mo13736a());
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.f14542a) > 86400000) {
            this.f14542a = currentTimeMillis;
            String m13756a = m13756a(this.f14544a.mo13736a());
            this.f14545a = m13756a;
            return m13756a;
        }
        return m13756a(this.f14545a);
    }

    /* renamed from: a */
    public void m13758a(Map<String, String> map) {
        if (map == null) {
            return;
        }
        String m13759b = m13759b();
        if (!TextUtils.isEmpty(m13759b)) {
            map.put("udid", m13759b);
        }
        String mo13736a = mo13736a();
        if (!TextUtils.isEmpty(mo13736a)) {
            map.put("oaid", mo13736a);
        }
        String m13760c = m13760c();
        if (!TextUtils.isEmpty(m13760c)) {
            map.put("vaid", m13760c);
        }
        String m13761d = m13761d();
        if (!TextUtils.isEmpty(m13761d)) {
            map.put("aaid", m13761d);
        }
        map.put("oaid_type", String.valueOf(this.f14541a));
    }
}
