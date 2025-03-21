package com.taobao.accs.internal;

import android.annotation.TargetApi;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Intent;
import com.taobao.accs.common.Constants;
import com.taobao.accs.p197a.C2961a;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.C3042j;

/* compiled from: Taobao */
@TargetApi(21)
/* loaded from: classes2.dex */
public class AccsJobService extends JobService {
    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        return 2;
    }

    @Override // android.app.job.JobService
    public boolean onStartJob(JobParameters jobParameters) {
        ALog.m9180d("AccsJobService", "onStartJob", new Object[0]);
        try {
            String packageName = getPackageName();
            Intent intent = new Intent();
            intent.setPackage(packageName);
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            intent.setClassName(packageName, C3042j.channelService);
            C2961a.m8908a(getApplicationContext(), intent);
        } catch (Throwable th) {
            ALog.m9181e("AccsJobService", "onStartJob", th, new Object[0]);
        }
        return false;
    }

    @Override // android.app.job.JobService
    public boolean onStopJob(JobParameters jobParameters) {
        try {
            Intent intent = new Intent();
            intent.setPackage(getPackageName());
            intent.setAction(Constants.ACTION_COMMAND);
            intent.putExtra("command", 201);
            intent.setClassName(getPackageName(), C3042j.channelService);
            C2961a.m8908a(getApplicationContext(), intent);
        } catch (Throwable th) {
            ALog.m9181e("AccsJobService", "onStopJob", th, new Object[0]);
        }
        return false;
    }
}
