package com.tencent.bugly.beta.download;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.p205ui.C3092c;
import com.tencent.bugly.beta.p205ui.C3095f;
import com.tencent.bugly.beta.p205ui.C3096g;
import com.tencent.bugly.beta.p205ui.C3097h;
import com.tencent.bugly.beta.upgrade.C3100c;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.open.SocialConstants;
import java.io.File;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import util.C7316r1;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BetaReceiver extends BroadcastReceiver {
    public static ConcurrentHashMap<String, C3077c> netListeners = new ConcurrentHashMap<>(3);
    public static int netStatus = 0;
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    public static synchronized void addTask(DownloadTask downloadTask) {
        synchronized (BetaReceiver.class) {
            netStatus = C3078a.m9321a(C3082e.f9867G.f9919u);
            C3095f c3095f = new C3095f();
            c3095f.f9966n = downloadTask;
            netListeners.put(downloadTask.getDownloadUrl(), new C3077c(2, downloadTask, false, c3095f));
        }
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(final Context context, final Intent intent) {
        C3150am.m9906a().m9908a(new Runnable() { // from class: com.tencent.bugly.beta.download.BetaReceiver.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    if (intent.getAction().equals(BetaReceiver.CONNECTIVITY_CHANGE)) {
                        int i2 = BetaReceiver.netStatus;
                        BetaReceiver.netStatus = C3078a.m9321a(context);
                        Iterator<C3077c> it = BetaReceiver.netListeners.values().iterator();
                        while (it.hasNext()) {
                            it.next().m9316a(i2, BetaReceiver.netStatus);
                        }
                        return;
                    }
                    if (intent.getAction().equals(C3092c.f9950a.f9952c)) {
                        int intExtra = intent.getIntExtra(SocialConstants.TYPE_REQUEST, -1);
                        if (intExtra != 1) {
                            if (intExtra != 2) {
                                return;
                            }
                            C3096g.m9361a(C3092c.f9950a.f9954e, true, true, 0L);
                            return;
                        }
                        DownloadTask downloadTask = C3092c.f9950a.f9951b;
                        if (downloadTask == null) {
                            return;
                        }
                        int status = downloadTask.getStatus();
                        if (status != 0) {
                            if (status == 1) {
                                C3078a.m9331a(C3082e.f9867G.f9919u, downloadTask.getSaveFile(), downloadTask.getMD5());
                            } else if (status == 2) {
                                BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                                downloadTask.stop();
                            } else if (status != 3 && status != 4 && status != 5) {
                            }
                            if (C3100c.f10000a.f10004e == null || C3097h.f9972v == null) {
                            }
                            C3097h.f9972v.m9363a(downloadTask);
                            return;
                        }
                        File saveFile = downloadTask.getSaveFile();
                        if (saveFile != null && saveFile.exists() && saveFile.getName().endsWith(C7316r1.f25586d)) {
                            String m9956a = C3154aq.m9956a(saveFile, "MD5");
                            if (TextUtils.isEmpty(downloadTask.getMD5()) || !TextUtils.equals(downloadTask.getMD5().toUpperCase(), m9956a)) {
                                BetaReceiver.addTask(downloadTask);
                                downloadTask.download();
                            } else {
                                C3078a.m9331a(C3082e.f9867G.f9919u, downloadTask.getSaveFile(), downloadTask.getMD5());
                            }
                        } else {
                            BetaReceiver.addTask(downloadTask);
                            downloadTask.download();
                        }
                        if (C3100c.f10000a.f10004e == null) {
                        }
                    }
                } catch (Exception e2) {
                    if (C3151an.m9919b(e2)) {
                        return;
                    }
                    e2.printStackTrace();
                }
            }
        });
    }
}
