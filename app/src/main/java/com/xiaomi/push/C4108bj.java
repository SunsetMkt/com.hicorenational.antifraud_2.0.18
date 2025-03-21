package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.manager.C4025a;
import com.xiaomi.push.C4076ae;

/* renamed from: com.xiaomi.push.bj */
/* loaded from: classes2.dex */
public class C4108bj extends C4076ae.a {

    /* renamed from: a */
    private Context f14632a;

    public C4108bj(Context context) {
        this.f14632a = context;
    }

    /* renamed from: a */
    private boolean m13914a() {
        return C4025a.m13366a(this.f14632a).m13381a().isPerfUploadSwitchOpen();
    }

    @Override // com.xiaomi.push.C4076ae.a
    /* renamed from: a */
    public String mo13391a() {
        return "100887";
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (m13914a()) {
                C4025a.m13366a(this.f14632a).m13390c();
                AbstractC4022b.m13359c(this.f14632a.getPackageName() + " perf begin upload");
            }
        } catch (Exception e2) {
            AbstractC4022b.m13361d("fail to send perf data. " + e2);
        }
    }
}
