package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.manager.C4025a;
import com.xiaomi.push.C4076ae;

/* renamed from: com.xiaomi.push.bi */
/* loaded from: classes2.dex */
public class C4107bi extends C4076ae.a {

    /* renamed from: a */
    private Context f14631a;

    public C4107bi(Context context) {
        this.f14631a = context;
    }

    /* renamed from: a */
    private boolean m13913a() {
        return C4025a.m13366a(this.f14631a).m13381a().isEventUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.C4076ae.a
    /* renamed from: a */
    public String mo13391a() {
        return "100886";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (m13913a()) {
                AbstractC4022b.m13359c(this.f14631a.getPackageName() + " begin upload event");
                C4025a.m13366a(this.f14631a).m13389b();
            }
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
        }
    }
}
