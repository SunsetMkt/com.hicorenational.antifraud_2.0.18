package com.taobao.accs.p199ut.p200a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.ut.a.b */
/* loaded from: classes2.dex */
public class C3027b {

    /* renamed from: a */
    public String f9636a;

    /* renamed from: b */
    public String f9637b;

    /* renamed from: c */
    public boolean f9638c;

    /* renamed from: d */
    public String f9639d;

    /* renamed from: e */
    public String f9640e;

    /* renamed from: f */
    private final String f9641f = "BindUser";

    /* renamed from: g */
    private boolean f9642g = false;

    /* renamed from: b */
    private void m9168b(String str) {
        String str2;
        String str3;
        if (this.f9642g) {
            return;
        }
        this.f9642g = true;
        HashMap hashMap = new HashMap();
        try {
            str2 = this.f9636a;
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
            hashMap.put("device_id", this.f9636a);
            hashMap.put("bind_date", this.f9637b);
            hashMap.put("ret", this.f9638c ? "y" : "n");
            hashMap.put("fail_reasons", this.f9639d);
            hashMap.put(SocializeConstants.TENCENT_UID, this.f9640e);
            if (ALog.isPrintLog(ALog.Level.D)) {
                ALog.m9180d("accs.BindUserStatistic", UTMini.getCommitInfo(66001, str2, (String) null, str3, hashMap), new Object[0]);
            }
            UTMini.getInstance().commitEvent(66001, str, str2, (Object) null, str3, hashMap);
        } catch (Throwable th3) {
            th = th3;
            ALog.m9180d("accs.BindUserStatistic", UTMini.getCommitInfo(66001, str2, (String) null, str3, hashMap) + AbstractC1191a.f2568g + th.toString(), new Object[0]);
        }
    }

    /* renamed from: a */
    public void m9171a(String str) {
        this.f9639d = str;
    }

    /* renamed from: a */
    public void m9170a(int i2) {
        if (i2 == -4) {
            m9171a("msg too large");
            return;
        }
        if (i2 == -3) {
            m9171a("service not available");
            return;
        }
        if (i2 == -2) {
            m9171a("param error");
            return;
        }
        if (i2 == -1) {
            m9171a("network fail");
        } else if (i2 != 200) {
            if (i2 != 300) {
                m9171a(String.valueOf(i2));
            } else {
                m9171a("app not bind");
            }
        }
    }

    /* renamed from: a */
    public void m9169a() {
        m9168b("BindUser");
    }
}
