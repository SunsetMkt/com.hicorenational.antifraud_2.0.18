package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.clientreport.processor.InterfaceC4028c;

/* renamed from: com.xiaomi.push.bk */
/* loaded from: classes2.dex */
public class RunnableC4109bk implements Runnable {

    /* renamed from: a */
    private Context f14633a;

    /* renamed from: a */
    private InterfaceC4028c f14634a;

    /* renamed from: a */
    public void m13916a(InterfaceC4028c interfaceC4028c) {
        this.f14634a = interfaceC4028c;
    }

    @Override // java.lang.Runnable
    public void run() {
        try {
            if (this.f14634a != null) {
                this.f14634a.mo13398a();
            }
            AbstractC4022b.m13359c("begin read and send perf / event");
            if (this.f14634a instanceof IEventProcessor) {
                C4111bm.m13926a(this.f14633a).m13929a("sp_client_report_status", "event_last_upload_time", System.currentTimeMillis());
            } else if (this.f14634a instanceof IPerfProcessor) {
                C4111bm.m13926a(this.f14633a).m13929a("sp_client_report_status", "perf_last_upload_time", System.currentTimeMillis());
            }
        } catch (Exception e2) {
            AbstractC4022b.m13351a(e2);
        }
    }

    /* renamed from: a */
    public void m13915a(Context context) {
        this.f14633a = context;
    }
}
