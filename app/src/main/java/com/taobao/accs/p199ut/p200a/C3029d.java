package com.taobao.accs.p199ut.p200a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.ut.a.d */
/* loaded from: classes2.dex */
public class C3029d {

    /* renamed from: a */
    public String f9654a;

    /* renamed from: b */
    public String f9655b;

    /* renamed from: c */
    public String f9656c;

    /* renamed from: d */
    public String f9657d;

    /* renamed from: e */
    public String f9658e;

    /* renamed from: f */
    public String f9659f;

    /* renamed from: g */
    public String f9660g;

    /* renamed from: i */
    public String f9662i;

    /* renamed from: j */
    private final String f9663j = "receiveMessage";

    /* renamed from: h */
    public boolean f9661h = false;

    /* renamed from: k */
    private boolean f9664k = false;

    /* renamed from: a */
    public void m9173a() {
        String str;
        String str2;
        if (this.f9664k) {
            return;
        }
        this.f9664k = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.f9654a;
            try {
                str2 = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                str2 = null;
            }
            try {
                hashMap.put("device_id", this.f9654a);
                hashMap.put("data_id", this.f9655b);
                hashMap.put("receive_date", this.f9656c);
                hashMap.put("to_bz_date", this.f9657d);
                hashMap.put("service_id", this.f9658e);
                hashMap.put("data_length", this.f9659f);
                hashMap.put("msg_type", this.f9660g);
                hashMap.put("repeat", this.f9661h ? "y" : "n");
                hashMap.put(SocializeConstants.TENCENT_UID, this.f9662i);
                UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, str2, hashMap);
            } catch (Throwable th2) {
                th = th2;
                ALog.m9180d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + AbstractC1191a.f2568g + th.toString(), new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            str2 = null;
        }
    }
}
