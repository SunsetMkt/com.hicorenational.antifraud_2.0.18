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
import util.x1;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class BetaReceiver extends BroadcastReceiver {
    public static ConcurrentHashMap<String, c> netListeners = new ConcurrentHashMap<>(3);
    public static int netStatus = 0;
    public static String CONNECTIVITY_CHANGE = "android.net.conn.CONNECTIVITY_CHANGE";

    /* JADX INFO: renamed from: com.tencent.bugly.beta.download.BetaReceiver$1 */
    /* JADX INFO: compiled from: BUGLY */
    class AnonymousClass1 implements Runnable {
        final /* synthetic */ Intent a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Context f5998b;

        AnonymousClass1(Intent intent, Context context) {
            intent = intent;
            context = context;
        }

        /* JADX WARN: Removed duplicated region for block: B:96:0x0099 A[Catch: Exception -> 0x00fc, TryCatch #0 {Exception -> 0x00fc, blocks: (B:67:0x0000, B:69:0x000e, B:70:0x0022, B:72:0x0028, B:73:0x0034, B:75:0x0044, B:79:0x0055, B:80:0x0060, B:83:0x0067, B:109:0x00ec, B:111:0x00f2, B:113:0x00f6, B:94:0x007c, B:95:0x0089, B:96:0x0099, B:98:0x009f, B:100:0x00a5, B:102:0x00b1, B:104:0x00c1, B:106:0x00cf, B:107:0x00df, B:108:0x00e6), top: B:120:0x0000 }] */
        @Override // java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() throws Throwable {
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
                if (intent.getAction().equals(com.tencent.bugly.beta.ui.c.a.f6052c)) {
                    int intExtra = intent.getIntExtra(SocialConstants.TYPE_REQUEST, -1);
                    if (intExtra != 1) {
                        if (intExtra != 2) {
                            return;
                        }
                        g.a(com.tencent.bugly.beta.ui.c.a.f6054e, true, true, 0L);
                        return;
                    }
                    DownloadTask downloadTask = com.tencent.bugly.beta.ui.c.a.f6051b;
                    if (downloadTask == null) {
                        return;
                    }
                    int status = downloadTask.getStatus();
                    if (status == 0) {
                        File saveFile = downloadTask.getSaveFile();
                        if (saveFile != null && saveFile.exists() && saveFile.getName().endsWith(x1.f15111d)) {
                            String strA = aq.a(saveFile, "MD5");
                            if (TextUtils.isEmpty(downloadTask.getMD5()) || !TextUtils.equals(downloadTask.getMD5().toUpperCase(), strA)) {
                                BetaReceiver.addTask(downloadTask);
                                downloadTask.download();
                            } else {
                                com.tencent.bugly.beta.global.a.a(e.G.u, downloadTask.getSaveFile(), downloadTask.getMD5());
                            }
                        } else {
                            BetaReceiver.addTask(downloadTask);
                            downloadTask.download();
                        }
                    } else if (status == 1) {
                        com.tencent.bugly.beta.global.a.a(e.G.u, downloadTask.getSaveFile(), downloadTask.getMD5());
                    } else if (status == 2) {
                        BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                        downloadTask.stop();
                    } else if (status == 3 || status == 4 || status == 5) {
                    }
                    if (com.tencent.bugly.beta.upgrade.c.a.f6081e != null || h.v == null) {
                        return;
                    }
                    h.v.a(downloadTask);
                }
            } catch (Exception e2) {
                if (an.b(e2)) {
                    return;
                }
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void addTask(DownloadTask downloadTask) {
        netStatus = com.tencent.bugly.beta.global.a.a(e.G.u);
        f fVar = new f();
        fVar.f6065n = downloadTask;
        netListeners.put(downloadTask.getDownloadUrl(), new c(2, downloadTask, false, fVar));
    }

    @Override // android.content.BroadcastReceiver
    public synchronized void onReceive(Context context, Intent intent) {
        am.a().a(new Runnable() { // from class: com.tencent.bugly.beta.download.BetaReceiver.1
            final /* synthetic */ Intent a;

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Context f5998b;

            AnonymousClass1(Intent intent2, Context context2) {
                intent = intent2;
                context = context2;
            }

            /* JADX WARN: Removed duplicated region for block: B:96:0x0099 A[Catch: Exception -> 0x00fc, TryCatch #0 {Exception -> 0x00fc, blocks: (B:67:0x0000, B:69:0x000e, B:70:0x0022, B:72:0x0028, B:73:0x0034, B:75:0x0044, B:79:0x0055, B:80:0x0060, B:83:0x0067, B:109:0x00ec, B:111:0x00f2, B:113:0x00f6, B:94:0x007c, B:95:0x0089, B:96:0x0099, B:98:0x009f, B:100:0x00a5, B:102:0x00b1, B:104:0x00c1, B:106:0x00cf, B:107:0x00df, B:108:0x00e6), top: B:120:0x0000 }] */
            @Override // java.lang.Runnable
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public void run() throws Throwable {
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
                    if (intent.getAction().equals(com.tencent.bugly.beta.ui.c.a.f6052c)) {
                        int intExtra = intent.getIntExtra(SocialConstants.TYPE_REQUEST, -1);
                        if (intExtra != 1) {
                            if (intExtra != 2) {
                                return;
                            }
                            g.a(com.tencent.bugly.beta.ui.c.a.f6054e, true, true, 0L);
                            return;
                        }
                        DownloadTask downloadTask = com.tencent.bugly.beta.ui.c.a.f6051b;
                        if (downloadTask == null) {
                            return;
                        }
                        int status = downloadTask.getStatus();
                        if (status == 0) {
                            File saveFile = downloadTask.getSaveFile();
                            if (saveFile != null && saveFile.exists() && saveFile.getName().endsWith(x1.f15111d)) {
                                String strA = aq.a(saveFile, "MD5");
                                if (TextUtils.isEmpty(downloadTask.getMD5()) || !TextUtils.equals(downloadTask.getMD5().toUpperCase(), strA)) {
                                    BetaReceiver.addTask(downloadTask);
                                    downloadTask.download();
                                } else {
                                    com.tencent.bugly.beta.global.a.a(e.G.u, downloadTask.getSaveFile(), downloadTask.getMD5());
                                }
                            } else {
                                BetaReceiver.addTask(downloadTask);
                                downloadTask.download();
                            }
                        } else if (status == 1) {
                            com.tencent.bugly.beta.global.a.a(e.G.u, downloadTask.getSaveFile(), downloadTask.getMD5());
                        } else if (status == 2) {
                            BetaReceiver.netListeners.remove(downloadTask.getDownloadUrl());
                            downloadTask.stop();
                        } else if (status == 3 || status == 4 || status == 5) {
                        }
                        if (com.tencent.bugly.beta.upgrade.c.a.f6081e != null || h.v == null) {
                            return;
                        }
                        h.v.a(downloadTask);
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
