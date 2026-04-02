package com.taobao.accs.net;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class f extends g {

    /* JADX INFO: renamed from: c */
    private JobScheduler f5815c;

    f(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.g
    @SuppressLint({"NewApi"})
    protected void a(int i2) {
        if (this.f5815c == null) {
            this.f5815c = (JobScheduler) this.a.getSystemService("jobscheduler");
        }
        this.f5815c.cancel(com.umeng.analytics.pro.i.f7287b);
        long j2 = i2 * 1000;
        this.f5815c.schedule(new JobInfo.Builder(com.umeng.analytics.pro.i.f7287b, new ComponentName(this.a.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j2).setOverrideDeadline(j2).setRequiredNetworkType(1).build());
    }
}
