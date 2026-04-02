package com.tencent.bugly.beta.download;

import android.os.Build;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.w;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class a implements DownloadListener {
    final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final Object[] f6009b;

    public a(int i2, Object... objArr) {
        this.a = i2;
        this.f6009b = objArr;
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onCompleted(DownloadTask downloadTask) throws Throwable {
        try {
            int i2 = this.a;
            if (i2 == 1) {
                synchronized (this.f6009b[0]) {
                    Map map = (Map) this.f6009b[1];
                    if (map.size() == 0) {
                        return;
                    }
                    Iterator it = map.values().iterator();
                    int i3 = 0;
                    while (it.hasNext()) {
                        if (((DownloadTask) it.next()).getStatus() == 1) {
                            i3++;
                        }
                    }
                    an.c(i3 + " has completed", new Object[0]);
                    if (i3 < map.size()) {
                        return;
                    }
                    for (String str : map.keySet()) {
                        if (((DownloadTask) map.get(str)).getSaveFile() != null && ((DownloadTask) map.get(str)).getSaveFile().exists()) {
                            ResBean.a.a(str, ((DownloadTask) map.get(str)).getSaveFile().getAbsolutePath());
                        }
                    }
                    com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.a);
                    f fVar = (f) this.f6009b[0];
                    fVar.a();
                    fVar.b();
                    return;
                }
            }
            if (i2 == 2) {
                ((h) this.f6009b[0]).a(downloadTask);
                return;
            }
            if (i2 == 3) {
                com.tencent.bugly.beta.upgrade.c cVar = (com.tencent.bugly.beta.upgrade.c) this.f6009b[0];
                BetaGrayStrategy betaGrayStrategy = cVar.f6078b;
                if (betaGrayStrategy != null && betaGrayStrategy.a != null) {
                    if (cVar.f6082f != null) {
                        e.a(new d(18, cVar.f6082f, 3, Boolean.valueOf(cVar.f6083g)));
                    }
                    an.a("apk download completed", new Object[0]);
                    w wVar = new w("download", System.currentTimeMillis(), (byte) 0, downloadTask.getCostTime(), betaGrayStrategy.a.f6598e, betaGrayStrategy.a.f6606m, betaGrayStrategy.a.p, null);
                    if (p.a.a(wVar)) {
                        com.tencent.bugly.beta.upgrade.b.a.a(wVar, true);
                    }
                    if (com.tencent.bugly.beta.global.e.G.af) {
                        File saveFile = downloadTask.getSaveFile();
                        Integer num = (Integer) this.f6009b[1];
                        if (com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.G.u, saveFile, betaGrayStrategy.a.f6599f.a)) {
                            this.f6009b[1] = 0;
                            p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, betaGrayStrategy.a.f6598e, betaGrayStrategy.a.f6606m, betaGrayStrategy.a.p, null));
                            return;
                        }
                        if (num.intValue() >= 2) {
                            this.f6009b[1] = 0;
                            onFailed(downloadTask, 2080, "file md5 verify fail");
                            downloadTask.delete(true);
                            return;
                        } else {
                            if (Build.VERSION.SDK_INT >= 24) {
                                this.f6009b[1] = 0;
                                onFailed(downloadTask, 2080, "\u5b89\u88c5\u5931\u8d25\uff0c\u8bf7\u68c0\u67e5\u60a8\u7684App\u662f\u5426\u517c\u5bb97.0\u8bbe\u5907");
                                downloadTask.delete(true);
                                return;
                            }
                            this.f6009b[1] = Integer.valueOf(num.intValue() + 1);
                            downloadTask.delete(true);
                            cVar.f6079c = com.tencent.bugly.beta.global.e.G.r.a(betaGrayStrategy.a.f6599f.f6568b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, betaGrayStrategy.a.f6599f.f6568b);
                            cVar.f6079c.setDownloadType(1);
                            h.v.a(betaGrayStrategy.a, cVar.f6079c);
                            cVar.f6079c.addListener(this);
                            BetaReceiver.addTask(cVar.f6079c);
                            cVar.f6079c.download();
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            if (i2 != 4) {
                return;
            }
            q qVar = (q) this.f6009b[0];
            Integer num2 = (Integer) this.f6009b[1];
            BetaGrayStrategy betaGrayStrategy2 = qVar.f6553b;
            if (betaGrayStrategy2 != null && betaGrayStrategy2.a != null) {
                an.a("patch download success !!!", new Object[0]);
                File saveFile2 = downloadTask.getSaveFile();
                if (!com.tencent.bugly.beta.global.a.a(saveFile2, betaGrayStrategy2.a.f6599f.a, "SHA")) {
                    if (num2.intValue() >= 2) {
                        this.f6009b[1] = 0;
                        onFailed(downloadTask, 2080, "file sha1 verify fail");
                        downloadTask.delete(true);
                        TinkerManager.getInstance().onDownloadFailure("retry download patch too many times.");
                        return;
                    }
                    this.f6009b[1] = Integer.valueOf(num2.intValue() + 1);
                    downloadTask.delete(true);
                    qVar.f6554c = com.tencent.bugly.beta.global.e.G.r.a(betaGrayStrategy2.a.f6599f.f6568b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, betaGrayStrategy2.a.f6599f.f6568b);
                    qVar.f6554c.setDownloadType(3);
                    qVar.f6554c.setNeededNotify(false);
                    qVar.f6554c.addListener(this);
                    BetaReceiver.addTask(qVar.f6554c);
                    qVar.f6554c.download();
                    return;
                }
                this.f6009b[1] = 0;
                if (!com.tencent.bugly.beta.global.a.a(saveFile2, com.tencent.bugly.beta.global.e.G.J)) {
                    an.a("copy file failed", new Object[0]);
                    TinkerManager.getInstance().onDownloadFailure("copy file failure.");
                    return;
                }
                an.c("copy " + saveFile2.getAbsolutePath() + " to " + com.tencent.bugly.beta.global.e.G.J.getAbsolutePath() + " success!", new Object[0]);
                if (qVar.f6554c != null) {
                    an.c("delete temp file", new Object[0]);
                    qVar.f6554c.delete(true);
                }
                com.tencent.bugly.beta.global.a.a("UPLOAD_PATCH_RESULT", false);
                TinkerManager.getInstance().onDownloadSuccess(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath(), com.tencent.bugly.beta.global.e.G.X);
            }
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onFailed(DownloadTask downloadTask, int i2, String str) {
        try {
            int i3 = this.a;
            if (i3 == 1) {
                synchronized (this.f6009b[0]) {
                    f fVar = (f) this.f6009b[0];
                    fVar.a();
                    fVar.b();
                }
                return;
            }
            if (i3 == 2) {
                ((h) this.f6009b[0]).a(downloadTask);
                return;
            }
            if (i3 == 3) {
                com.tencent.bugly.beta.upgrade.c cVar = (com.tencent.bugly.beta.upgrade.c) this.f6009b[0];
                if (downloadTask != null) {
                    p.a.a(new w("download", System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), cVar.f6078b.a.f6598e, cVar.f6078b.a.f6606m, cVar.f6078b.a.p, null));
                }
                an.e("upgrade failed\uff1a(%d)%s", Integer.valueOf(i2), str);
                return;
            }
            if (i3 != 4) {
                return;
            }
            q qVar = (q) this.f6009b[0];
            if (downloadTask != null) {
                p.a.a(new w("download", System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), qVar.f6553b.a.f6598e, qVar.f6553b.a.f6606m, qVar.f6553b.a.p, null));
            }
            an.e("hotfix download failed\uff1a(%d)%s", Integer.valueOf(i2), str);
            TinkerManager.getInstance().onDownloadFailure(str);
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onReceive(DownloadTask downloadTask) {
        if (this.a != 2) {
            return;
        }
        ((h) this.f6009b[0]).a(downloadTask);
    }
}
