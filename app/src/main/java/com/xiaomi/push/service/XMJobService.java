package com.xiaomi.push.service;

import android.annotation.TargetApi;
import android.app.Service;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.Build;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4094aw;
import com.xiaomi.push.C4178dz;
import com.xiaomi.push.C4300j;

/* loaded from: classes2.dex */
public class XMJobService extends Service {

    /* renamed from: a */
    static Service f16413a;

    /* renamed from: a */
    private IBinder f16414a = null;

    @TargetApi(21)
    /* renamed from: com.xiaomi.push.service.XMJobService$a */
    static class JobServiceC4313a extends JobService {

        /* renamed from: a */
        Binder f16415a;

        /* renamed from: a */
        private Handler f16416a;

        /* renamed from: com.xiaomi.push.service.XMJobService$a$a */
        private static class a extends Handler {

            /* renamed from: a */
            JobService f16417a;

            a(JobService jobService) {
                super(jobService.getMainLooper());
                this.f16417a = jobService;
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                if (message.what != 1) {
                    return;
                }
                JobParameters jobParameters = (JobParameters) message.obj;
                AbstractC4022b.m13347a("Job finished " + jobParameters.getJobId());
                this.f16417a.jobFinished(jobParameters, false);
                if (jobParameters.getJobId() == 1) {
                    C4178dz.m14581a(false);
                }
            }
        }

        JobServiceC4313a(Service service2) {
            this.f16415a = null;
            this.f16415a = (Binder) C4094aw.m13822a((Object) this, "onBind", new Intent());
            C4094aw.m13822a((Object) this, "attachBaseContext", service2);
        }

        @Override // android.app.job.JobService
        public boolean onStartJob(JobParameters jobParameters) {
            AbstractC4022b.m13347a("Job started " + jobParameters.getJobId());
            Intent intent = new Intent(this, (Class<?>) XMPushService.class);
            intent.setAction("com.xiaomi.push.timer");
            intent.setPackage(getPackageName());
            startService(intent);
            if (this.f16416a == null) {
                this.f16416a = new a(this);
            }
            Handler handler = this.f16416a;
            handler.sendMessage(Message.obtain(handler, 1, jobParameters));
            return true;
        }

        @Override // android.app.job.JobService
        public boolean onStopJob(JobParameters jobParameters) {
            AbstractC4022b.m13347a("Job stop " + jobParameters.getJobId());
            return false;
        }
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        IBinder iBinder = this.f16414a;
        return iBinder != null ? iBinder : new Binder();
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        if (Build.VERSION.SDK_INT >= 21) {
            this.f16414a = new JobServiceC4313a(this).f16415a;
        }
        f16413a = this;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        f16413a = null;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i2, int i3) {
        int onStartCommand = super.onStartCommand(intent, i2, i3);
        if (C4300j.m15681a((Context) this)) {
            return onStartCommand;
        }
        return 2;
    }
}
