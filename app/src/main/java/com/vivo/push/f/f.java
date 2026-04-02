package com.vivo.push.f;

import android.app.ActivityManager;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: NotifyOpenClientClickTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class f implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Map f8517b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ e f8518c;

    f(e eVar, Context context, Map map) {
        this.f8518c = eVar;
        this.a = context;
        this.f8517b = map;
    }

    @Override // java.lang.Runnable
    public final void run() {
        String packageName = this.a.getPackageName();
        try {
            List<ActivityManager.RunningTaskInfo> runningTasks = ((ActivityManager) this.a.getSystemService("activity")).getRunningTasks(100);
            if (runningTasks != null) {
                Iterator<ActivityManager.RunningTaskInfo> it = runningTasks.iterator();
                while (it.hasNext()) {
                    ComponentName componentName = it.next().topActivity;
                    if (componentName.getPackageName().equals(packageName)) {
                        com.vivo.push.util.u.d("NotifyOpenClientTask", "topClassName=" + componentName.getClassName());
                        Intent intent = new Intent();
                        intent.setComponent(componentName);
                        intent.setFlags(335544320);
                        e.b(intent, this.f8517b);
                        this.a.startActivity(intent);
                        return;
                    }
                }
            }
        } catch (Exception e2) {
            com.vivo.push.util.u.a("NotifyOpenClientTask", "start recentIntent is error", e2);
        }
        Intent launchIntentForPackage = this.a.getPackageManager().getLaunchIntentForPackage(this.a.getPackageName());
        if (launchIntentForPackage == null) {
            com.vivo.push.util.u.a("NotifyOpenClientTask", "LaunchIntent is null");
            return;
        }
        launchIntentForPackage.setFlags(CommonNetImpl.FLAG_AUTH);
        e.b(launchIntentForPackage, this.f8517b);
        this.a.startActivity(launchIntentForPackage);
    }
}
