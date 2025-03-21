package com.taobao.accs.net;

import android.annotation.SuppressLint;
import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import com.taobao.accs.internal.AccsJobService;
import com.umeng.analytics.pro.C3408i;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.f */
/* loaded from: classes2.dex */
class C3006f extends AbstractC3007g {

    /* renamed from: c */
    private JobScheduler f9546c;

    C3006f(Context context) {
        super(context);
    }

    @Override // com.taobao.accs.net.AbstractC3007g
    @SuppressLint({"NewApi"})
    /* renamed from: a */
    protected void mo9111a(int i2) {
        if (this.f9546c == null) {
            this.f9546c = (JobScheduler) this.f9549a.getSystemService("jobscheduler");
        }
        this.f9546c.cancel(C3408i.f12049b);
        long j2 = i2 * 1000;
        this.f9546c.schedule(new JobInfo.Builder(C3408i.f12049b, new ComponentName(this.f9549a.getPackageName(), AccsJobService.class.getName())).setMinimumLatency(j2).setOverrideDeadline(j2).setRequiredNetworkType(1).build());
    }
}
