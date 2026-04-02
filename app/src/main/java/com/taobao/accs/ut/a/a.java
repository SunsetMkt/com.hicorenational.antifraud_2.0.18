package com.taobao.accs.ut.a;

import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.UTMini;
import java.util.HashMap;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f5845b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f5846c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f5847d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final String f5848e = "BindApp";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f5849f = false;

    private void b(String str) {
        String str2;
        String strValueOf;
        if (this.f5849f) {
            return;
        }
        this.f5849f = true;
        HashMap map = new HashMap();
        try {
            str2 = this.a;
            try {
                strValueOf = String.valueOf(221);
            } catch (Throwable th) {
                th = th;
                strValueOf = null;
            }
        } catch (Throwable th2) {
            th = th2;
            str2 = null;
            strValueOf = null;
        }
        try {
            map.put("device_id", this.a);
            map.put("bind_date", this.f5845b);
            map.put("ret", this.f5846c ? "y" : "n");
            map.put("fail_reasons", this.f5847d);
            map.put("push_token", "");
            UTMini.getInstance().commitEvent(66001, str, str2, (Object) null, strValueOf, map);
        } catch (Throwable th3) {
            th = th3;
            ALog.d("BindAppStatistic", UTMini.getCommitInfo(66001, str2, (String) null, strValueOf, map) + d.c.a.b.a.a.f10074g + th.toString(), new Object[0]);
        }
    }

    public void a(String str) {
        this.f5847d = str;
    }

    public void a(int i2) {
        if (i2 == -4) {
            a("msg too large");
            return;
        }
        if (i2 == -3) {
            a("service not available");
            return;
        }
        if (i2 == -2) {
            a("param error");
            return;
        }
        if (i2 == -1) {
            a("network fail");
        } else if (i2 != 200) {
            if (i2 != 300) {
                a(String.valueOf(i2));
            } else {
                a("app not bind");
            }
        }
    }

    public void a() {
        b("BindApp");
    }
}
