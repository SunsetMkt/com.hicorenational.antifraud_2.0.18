package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class e {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5876b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f5877c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5878d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f5879e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f5880f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final String f5881g = "sendAck";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private boolean f5882h = false;

    public void a() {
        String str;
        String strValueOf;
        if (this.f5882h) {
            return;
        }
        this.f5882h = true;
        HashMap map = new HashMap();
        try {
            str = this.a;
            try {
                strValueOf = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str = null;
            strValueOf = null;
        }
        try {
            map.put("device_id", this.a);
            map.put("session_id", this.f5876b);
            map.put("data_id", this.f5877c);
            map.put("ack_date", this.f5878d);
            map.put("service_id", this.f5879e);
            map.put("fail_reasons", this.f5880f);
            UTMini.getInstance().commitEvent(66001, "sendAck", str, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("accs.SendAckStatistic", UTMini.getCommitInfo(66001, str, (String) null, strValueOf, map) + d.c.a.b.a.a.f10074g + th.toString(), new Object[0]);
        }
    }
}
