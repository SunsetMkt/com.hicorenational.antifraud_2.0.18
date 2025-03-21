package com.taobao.accs.p199ut.p200a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.ut.a.a */
/* loaded from: classes2.dex */
public class C3026a {

    /* renamed from: a */
    public String f9630a;

    /* renamed from: b */
    public String f9631b;

    /* renamed from: c */
    public boolean f9632c;

    /* renamed from: d */
    public String f9633d;

    /* renamed from: e */
    private final String f9634e = "BindApp";

    /* renamed from: f */
    private boolean f9635f = false;

    /* renamed from: b */
    private void m9164b(String str) {
        String str2;
        String str3;
        if (this.f9635f) {
            return;
        }
        this.f9635f = true;
        HashMap hashMap = new HashMap();
        try {
            str2 = this.f9630a;
            try {
                str3 = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                str3 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
            str3 = null;
        }
        try {
            hashMap.put("device_id", this.f9630a);
            hashMap.put("bind_date", this.f9631b);
            hashMap.put("ret", this.f9632c ? "y" : "n");
            hashMap.put("fail_reasons", this.f9633d);
            hashMap.put("push_token", "");
            UTMini.getInstance().commitEvent(66001, str, str2, (Object) null, str3, hashMap);
        } catch (Throwable th3) {
            th = th3;
            ALog.m9180d("BindAppStatistic", UTMini.getCommitInfo(66001, str2, (String) null, str3, hashMap) + AbstractC1191a.f2568g + th.toString(), new Object[0]);
        }
    }

    /* renamed from: a */
    public void m9167a(String str) {
        this.f9633d = str;
    }

    /* renamed from: a */
    public void m9166a(int i2) {
        if (i2 == -4) {
            m9167a("msg too large");
            return;
        }
        if (i2 == -3) {
            m9167a("service not available");
            return;
        }
        if (i2 == -2) {
            m9167a("param error");
            return;
        }
        if (i2 == -1) {
            m9167a("network fail");
        } else if (i2 != 200) {
            if (i2 != 300) {
                m9167a(String.valueOf(i2));
            } else {
                m9167a("app not bind");
            }
        }
    }

    /* renamed from: a */
    public void m9165a() {
        m9164b("BindApp");
    }
}
