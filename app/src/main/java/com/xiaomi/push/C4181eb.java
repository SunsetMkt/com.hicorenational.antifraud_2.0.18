package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4178dz;
import com.xiaomi.push.service.XMJobService;

@TargetApi(21)
/* renamed from: com.xiaomi.push.eb */
/* loaded from: classes2.dex */
public class C4181eb implements C4178dz.a {

    /* renamed from: a */
    JobScheduler f15067a;

    /* renamed from: a */
    Context f15068a;

    /* renamed from: a */
    private boolean f15069a = false;

    C4181eb(Context context) {
        this.f15068a = context;
        this.f15067a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    /* renamed from: a */
    void m14593a(long j2) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f15068a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j2);
        builder.setOverrideDeadline(j2);
        builder.setRequiredNetworkType(1);
        AbstractC4022b.m13359c("schedule Job = " + builder.build().getId() + " in " + j2);
        this.f15067a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.C4178dz.a
    /* renamed from: a */
    public void mo14584a(boolean z) {
        if (z || this.f15069a) {
            long m14801b = C4213fg.m14801b();
            if (z) {
                mo14583a();
                m14801b -= SystemClock.elapsedRealtime() % m14801b;
            }
            this.f15069a = true;
            m14593a(m14801b);
        }
    }

    @Override // com.xiaomi.push.C4178dz.a
    /* renamed from: a */
    public void mo14583a() {
        this.f15069a = false;
        this.f15067a.cancel(1);
    }

    @Override // com.xiaomi.push.C4178dz.a
    /* renamed from: a */
    public boolean mo14585a() {
        return this.f15069a;
    }
}
