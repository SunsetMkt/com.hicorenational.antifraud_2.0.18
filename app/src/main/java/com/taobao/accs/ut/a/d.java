package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public class d {

    /* renamed from: a, reason: collision with root package name */
    public String f8593a;

    /* renamed from: b, reason: collision with root package name */
    public String f8594b;

    /* renamed from: c, reason: collision with root package name */
    public String f8595c;

    /* renamed from: d, reason: collision with root package name */
    public String f8596d;

    /* renamed from: e, reason: collision with root package name */
    public String f8597e;

    /* renamed from: f, reason: collision with root package name */
    public String f8598f;

    /* renamed from: g, reason: collision with root package name */
    public String f8599g;

    /* renamed from: i, reason: collision with root package name */
    public String f8601i;

    /* renamed from: j, reason: collision with root package name */
    private final String f8602j = "receiveMessage";

    /* renamed from: h, reason: collision with root package name */
    public boolean f8600h = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f8603k = false;

    public void a() {
        String str;
        String str2;
        if (this.f8603k) {
            return;
        }
        this.f8603k = true;
        HashMap hashMap = new HashMap();
        try {
            str = this.f8593a;
            try {
                str2 = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                str2 = null;
            }
            try {
                hashMap.put("device_id", this.f8593a);
                hashMap.put("data_id", this.f8594b);
                hashMap.put("receive_date", this.f8595c);
                hashMap.put("to_bz_date", this.f8596d);
                hashMap.put("service_id", this.f8597e);
                hashMap.put("data_length", this.f8598f);
                hashMap.put("msg_type", this.f8599g);
                hashMap.put("repeat", this.f8600h ? "y" : "n");
                hashMap.put(SocializeConstants.TENCENT_UID, this.f8601i);
                UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, str2, hashMap);
            } catch (Throwable th2) {
                th = th2;
                ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, str2, hashMap) + c.c.a.b.a.a.f3100g + th.toString(), new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            str2 = null;
        }
    }
}
