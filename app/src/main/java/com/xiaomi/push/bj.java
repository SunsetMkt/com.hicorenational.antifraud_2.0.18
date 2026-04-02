package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* JADX INFO: loaded from: classes2.dex */
public class bj extends ae.a {
    private Context a;

    public bj(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m57a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ae.a
    /* JADX INFO: renamed from: a */
    public String mo181a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.clientreport.manager.a.a(this.a).c();
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.d("fail to send perf data. " + e2);
        }
    }
}
