package com.taobao.accs.p199ut.p200a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.ut.a.e */
/* loaded from: classes2.dex */
public class C3030e {

    /* renamed from: a */
    public String f9665a;

    /* renamed from: b */
    public String f9666b;

    /* renamed from: c */
    public String f9667c;

    /* renamed from: d */
    public String f9668d;

    /* renamed from: e */
    public String f9669e;

    /* renamed from: f */
    public String f9670f;

    /* renamed from: g */
    private final String f9671g = "sendAck";

    /* renamed from: h */
    private boolean f9672h = false;

    /* renamed from: a */
    public void m9174a() {
        String str;
        String str2;
        if (this.f9672h) {
            return;
        }
        this.f9672h = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.f9665a;
            try {
                str2 = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                str2 = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            str2 = null;
        }
        try {
            hashMap.put("device_id", this.f9665a);
            hashMap.put("session_id", this.f9666b);
            hashMap.put("data_id", this.f9667c);
            hashMap.put("ack_date", this.f9668d);
            hashMap.put("service_id", this.f9669e);
            hashMap.put("fail_reasons", this.f9670f);
            UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, str2, hashMap);
        } catch (Throwable th3) {
            th = th3;
            ALog.m9180d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + AbstractC1191a.f2568g + th.toString(), new Object[0]);
        }
    }
}
