package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.push.ae;

/* JADX INFO: loaded from: classes2.dex */
public class bi extends ae.a {
    private Context a;

    public bi(Context context) {
        this.a = context;
    }

    private boolean a() {
        return com.xiaomi.clientreport.manager.a.a(this.a).m57a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.ae.a
    /* JADX INFO: renamed from: a */
    public String mo181a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (a()) {
                com.xiaomi.channel.commonutils.logger.b.c(this.a.getPackageName() + " begin upload event");
                com.xiaomi.clientreport.manager.a.a(this.a).m59b();
            }
        } catch (Exception e2) {
            com.xiaomi.channel.commonutils.logger.b.a(e2);
        }
    }
}
