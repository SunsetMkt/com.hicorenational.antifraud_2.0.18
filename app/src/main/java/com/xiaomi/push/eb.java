package com.xiaomi.push;

import android.annotation.TargetApi;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.os.SystemClock;
import com.xiaomi.push.dz;
import com.xiaomi.push.service.XMJobService;

/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
public class eb implements dz.a {
    JobScheduler a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    Context f421a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private boolean f422a = false;

    eb(Context context) {
        this.f421a = context;
        this.a = (JobScheduler) context.getSystemService("jobscheduler");
    }

    void a(long j2) {
        JobInfo.Builder builder = new JobInfo.Builder(1, new ComponentName(this.f421a.getPackageName(), XMJobService.class.getName()));
        builder.setMinimumLatency(j2);
        builder.setOverrideDeadline(j2);
        builder.setRequiredNetworkType(1);
        com.xiaomi.channel.commonutils.logger.b.c("schedule Job = " + builder.build().getId() + " in " + j2);
        this.a.schedule(builder.build());
    }

    @Override // com.xiaomi.push.dz.a
    public void a(boolean z) {
        if (z || this.f422a) {
            long jB = fg.b();
            if (z) {
                a();
                jB -= SystemClock.elapsedRealtime() % jB;
            }
            this.f422a = true;
            a(jB);
        }
    }

    @Override // com.xiaomi.push.dz.a
    public void a() {
        this.f422a = false;
        this.a.cancel(1);
    }

    @Override // com.xiaomi.push.dz.a
    /* JADX INFO: renamed from: a */
    public boolean mo370a() {
        return this.f422a;
    }
}
