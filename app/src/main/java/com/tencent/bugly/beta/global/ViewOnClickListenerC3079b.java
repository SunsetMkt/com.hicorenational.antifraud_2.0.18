package com.tencent.bugly.beta.global;

import android.app.Activity;
import android.os.Process;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.p205ui.AbstractC3090a;
import com.tencent.bugly.beta.p205ui.C3094e;
import com.tencent.bugly.beta.p205ui.C3097h;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3191p;
import com.tencent.bugly.proguard.C3198w;
import com.tencent.bugly.proguard.C3200y;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.global.b */
/* loaded from: classes2.dex */
public class ViewOnClickListenerC3079b implements View.OnClickListener {

    /* renamed from: a */
    final int f9861a;

    /* renamed from: b */
    final Object[] f9862b;

    public ViewOnClickListenerC3079b(int i2, Object... objArr) {
        this.f9861a = i2;
        this.f9862b = objArr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        try {
            switch (this.f9861a) {
                case 1:
                    if (((ViewGroup) this.f9862b[1]).getChildCount() <= 0) {
                        ((Activity) this.f9862b[0]).finish();
                        C3151an.m9915a("BetaAct closed by empty view", new Object[0]);
                        break;
                    }
                    break;
                case 2:
                    ((AbstractC3090a) this.f9862b[0]).mo9351a();
                    break;
                case 3:
                    if (this.f9862b[1] != null) {
                        ((DownloadTask) this.f9862b[1]).download();
                    }
                    ((AbstractC3090a) this.f9862b[0]).mo9351a();
                    break;
                case 4:
                    C3097h c3097h = (C3097h) this.f9862b[0];
                    DownloadTask downloadTask = c3097h.f9979q;
                    C3200y c3200y = c3097h.f9978p;
                    BetaReceiver.addTask(downloadTask);
                    if (c3097h.f9980r != null) {
                        c3097h.f9980r.run();
                    }
                    if (downloadTask.getStatus() == 1 && C3078a.m9331a(C3082e.f9867G.f9919u, downloadTask.getSaveFile(), c3200y.f10837f.f10796a)) {
                        C3191p.f10775a.m10131a(new C3198w("install", System.currentTimeMillis(), (byte) 0, 0L, c3200y.f10836e, c3200y.f10844m, c3200y.f10847p, null));
                    } else {
                        downloadTask.download();
                    }
                    if (c3200y.f10838g != 2) {
                        c3097h.mo9351a();
                        break;
                    }
                    break;
                case 5:
                    C3097h c3097h2 = (C3097h) this.f9862b[0];
                    DownloadTask downloadTask2 = c3097h2.f9979q;
                    BetaReceiver.netListeners.remove(downloadTask2.getDownloadUrl());
                    downloadTask2.stop();
                    c3097h2.m9363a(downloadTask2);
                    break;
                case 6:
                    C3097h c3097h3 = (C3097h) this.f9862b[0];
                    if (c3097h3.f9981s != null) {
                        c3097h3.f9981s.run();
                    }
                    c3097h3.mo9351a();
                    break;
                case 7:
                    Process.killProcess(Process.myPid());
                    System.exit(0);
                    break;
                case 8:
                    ((C3094e) this.f9862b[0]).mo9351a();
                    break;
                case 9:
                    Beta.installApk(Beta.getStrategyTask().getSaveFile());
                    Beta.saveInstallEvent(true);
                    break;
            }
        } catch (Exception e2) {
            if (C3151an.m9919b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }
}
