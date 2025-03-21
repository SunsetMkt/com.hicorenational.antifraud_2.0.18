package com.tencent.bugly.beta.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.bugly.beta.global.e;
import com.tencent.bugly.beta.ui.f;
import com.tencent.bugly.beta.ui.g;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import util.r1;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaReceiver extends BroadcastReceiver {
    public static ConcurrentHashMap<String, c> netListeners = new ConcurrentHashMap<>(3);
    public static int netStatus = 0;
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    public static synchronized void addTask(DownloadTask downloadTask) {
        synchronized (BetaReceiver.class) {
            netStatus = com.tencent.bugly.beta.global.a.a(e.G.u);
            f fVar = new f();
            fVar.n = downloadTask;
            netListeners.put(downloadTask.getDownloadUrl(), new c(2, downloadTask, false, fVar));
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(final Context context, final Intent intent) {
        am.a().a(new Runnable() { // from class: com.tencent.bugly.beta.download.BetaReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (intent.getAction().equals(BetaReceiver.CONNECTIVITY_CHANGE)) {
                        int i2 = BetaReceiver.netStatus;
                        BetaReceiver.netStatus = com.tencent.bugly.beta.global.a.a(context);
                        Iterator<c> it = BetaReceiver.netListeners.values().iterator();
                        while (it.hasNext()) {
                            it.next().a(i2, BetaReceiver.netStatus);
                        }
                        return;
                    }
                    if (intent.getAction().equals(com.tencent.bugly.beta.ui.c.f8829a.f8831c)) {
                        int intExtra = intent.getIntExtra(SocialConstants.TYPE_REQUEST, -1);
                        if (intExtra != 1) {
                            if (intExtra != 2) {
                                return;
                            }
                            g.a(com.tencent.bugly.beta.ui.c.f8829a.f8833e, true, true, 0L);
                            return;
                        }
                        DownloadTask downloadTask = com.tencent.bugly.beta.ui.c.f8829a.f8830b;
                        if (downloadTask == null) {
                            return;
                        }
                        int status = downloadTask.getStatus();
                        if (status != 0) {
                            if (status == 1) {
                                com.tencent.bugly.beta.global.a.a(e.G.u, downloadTask.getSaveFile(), downloadTask.getMD5());
                            } else if (status == 2) {
                                BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                                downloadTask.stop();
                            } else if (status != 3 && status != 4 && status != 5) {
                            }
                            if (com.tencent.bugly.beta.upgrade.c.f8860a.f8864e == null || h.v == null) {
                            }
                            h.v.a(downloadTask);
                            return;
                        }
                        File saveFile = downloadTask.getSaveFile();
                        if (saveFile != null && saveFile.exists() && saveFile.getName().endsWith(r1.f20958d)) {
                            String a2 = aq.a(saveFile, "MD5");
                            if (TextUtils.isEmpty(downloadTask.getMD5()) || !TextUtils.equals(downloadTask.getMD5().toUpperCase(), a2)) {
                                BetaReceiver.addTask(downloadTask);
                                downloadTask.download();
                            } else {
                                com.tencent.bugly.beta.global.a.a(e.G.u, downloadTask.getSaveFile(), downloadTask.getMD5());
                            }
                        } else {
                            BetaReceiver.addTask(downloadTask);
                            downloadTask.download();
                        }
                        if (com.tencent.bugly.beta.upgrade.c.f8860a.f8864e == null) {
                        }
                    }
                } catch (Exception e2) {
                    if (an.b(e2)) {
                        return;
                    }
                    e2.printStackTrace();
                }
            }
        });
    }
}
