package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import com.umeng.socialize.common.SocializeConstants;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class d {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5866b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5867c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5868d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5869e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5870f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public String f5871g;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f5873i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final String f5874j = "receiveMessage";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f5872h = false;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f5875k = false;

    public void a() {
        String str;
        String strValueOf;
        if (this.f5875k) {
            return;
        }
        this.f5875k = true;
        HashMap map = new HashMap();
        try {
            str = this.a;
            try {
                strValueOf = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
            try {
                map.put("device_id", this.a);
                map.put("data_id", this.f5866b);
                map.put("receive_date", this.f5867c);
                map.put("to_bz_date", this.f5868d);
                map.put("service_id", this.f5869e);
                map.put("data_length", this.f5870f);
                map.put("msg_type", this.f5871g);
                map.put("repeat", this.f5872h ? "y" : "n");
                map.put(SocializeConstants.TENCENT_UID, this.f5873i);
                UTMini.getInstance().commitEvent(66001, "receiveMessage", str, (Object) null, strValueOf, map);
            } catch (Throwable th2) {
                th = th2;
                ALog.d("ReceiveMessage", UTMini.getCommitInfo(66001, str, (String) null, strValueOf, map) + d.c.a.b.a.a.f10074g + th.toString(), new Object[0]);
            }
        } catch (Throwable th3) {
            th = th3;
            str = null;
            strValueOf = null;
        }
    }
}
