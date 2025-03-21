package com.vivo.push.p237f;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.util.C4010u;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* compiled from: NotifyOpenClientClickTask.java */
/* renamed from: com.vivo.push.f.f */
/* loaded from: classes2.dex */
final class RunnableC3896f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f14023a;

    /* renamed from: b */
    final /* synthetic */ Map f14024b;

    /* renamed from: c */
    final /* synthetic */ C3895e f14025c;

    RunnableC3896f(C3895e c3895e, Context context, Map map) {
        this.f14025c = c3895e;
        this.f14023a = context;
        this.f14024b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.f14023a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.f14023a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        C4010u.m13309d("NotifyOpenClientTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        C3895e.m12967b(intent, this.f14024b);
                        this.f14023a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            C4010u.m13293a("NotifyOpenClientTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.f14023a.getPackageManager().getLaunchIntentForPackage(this.f14023a.getPackageName());
        if (launchIntentForPackage == null) {
            C4010u.m13292a("NotifyOpenClientTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(CommonNetImpl.FLAG_AUTH);
        C3895e.m12967b(launchIntentForPackage, this.f14024b);
        this.f14023a.startActivity(launchIntentForPackage);
    }
}
