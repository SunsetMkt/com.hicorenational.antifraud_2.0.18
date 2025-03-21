package com.tencent.bugly.beta.download;

import android.os.Build;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.C3083f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.p205ui.C3097h;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C3099b;
import com.tencent.bugly.beta.upgrade.C3100c;
import com.tencent.bugly.beta.utils.C3105e;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3191p;
import com.tencent.bugly.proguard.C3192q;
import com.tencent.bugly.proguard.C3198w;
import java.io.File;
import java.util.Iterator;
import java.util.Map;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.beta.download.a */
/* loaded from: classes2.dex */
public class C3075a implements DownloadListener {

    /* renamed from: a */
    final int f9852a;

    /* renamed from: b */
    final Object[] f9853b;

    public C3075a(int i2, Object... objArr) {
        this.f9852a = i2;
        this.f9853b = objArr;
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onCompleted(DownloadTask downloadTask) {
        try {
            int i2 = this.f9852a;
            if (i2 == 1) {
                synchronized (this.f9853b[0]) {
                    Map map = (Map) this.f9853b[1];
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
                    C3151an.m9921c(i3 + " has completed", new Object[0]);
                    if (i3 < map.size()) {
                        return;
                    }
                    for (String str : map.keySet()) {
                        if (((DownloadTask) map.get(str)).getSaveFile() != null && ((DownloadTask) map.get(str)).getSaveFile().exists()) {
                            ResBean.f9856a.m9319a(str, ((DownloadTask) map.get(str)).getSaveFile().getAbsolutePath());
                        }
                    }
                    C3078a.m9335a("rb.bch", ResBean.f9856a);
                    C3083f c3083f = (C3083f) this.f9853b[0];
                    c3083f.m9340a();
                    c3083f.m9344b();
                    return;
                }
            }
            if (i2 == 2) {
                ((C3097h) this.f9853b[0]).m9363a(downloadTask);
                return;
            }
            if (i2 == 3) {
                C3100c c3100c = (C3100c) this.f9853b[0];
                BetaGrayStrategy betaGrayStrategy = c3100c.f10001b;
                if (betaGrayStrategy != null && betaGrayStrategy.f9988a != null) {
                    if (c3100c.f10005f != null) {
                        C3105e.m9461a(new RunnableC3081d(18, c3100c.f10005f, 3, Boolean.valueOf(c3100c.f10006g)));
                    }
                    C3151an.m9915a("apk download completed", new Object[0]);
                    C3198w c3198w = new C3198w("download", System.currentTimeMillis(), (byte) 0, downloadTask.getCostTime(), betaGrayStrategy.f9988a.f10836e, betaGrayStrategy.f9988a.f10844m, betaGrayStrategy.f9988a.f10847p, null);
                    if (C3191p.f10775a.m10131a(c3198w)) {
                        C3099b.f9999a.m9373a(c3198w, true);
                    }
                    if (C3082e.f9867G.f9899af) {
                        File saveFile = downloadTask.getSaveFile();
                        Integer num = (Integer) this.f9853b[1];
                        if (C3078a.m9331a(C3082e.f9867G.f9919u, saveFile, betaGrayStrategy.f9988a.f10837f.f10796a)) {
                            this.f9853b[1] = 0;
                            C3191p.f10775a.m10131a(new C3198w("install", System.currentTimeMillis(), (byte) 0, 0L, betaGrayStrategy.f9988a.f10836e, betaGrayStrategy.f9988a.f10844m, betaGrayStrategy.f9988a.f10847p, null));
                            return;
                        }
                        if (num.intValue() >= 2) {
                            this.f9853b[1] = 0;
                            onFailed(downloadTask, 2080, "file md5 verify fail");
                            downloadTask.delete(true);
                            return;
                        } else {
                            if (Build.VERSION.SDK_INT >= 24) {
                                this.f9853b[1] = 0;
                                onFailed(downloadTask, 2080, "安装失败，请检查您的App是否兼容7.0设备");
                                downloadTask.delete(true);
                                return;
                            }
                            this.f9853b[1] = Integer.valueOf(num.intValue() + 1);
                            downloadTask.delete(true);
                            c3100c.f10002c = C3082e.f9867G.f9916r.mo9315a(betaGrayStrategy.f9988a.f10837f.f10797b, C3082e.f9867G.f9920v.getAbsolutePath(), null, betaGrayStrategy.f9988a.f10837f.f10797b);
                            c3100c.f10002c.setDownloadType(1);
                            C3097h.f9972v.m9364a(betaGrayStrategy.f9988a, c3100c.f10002c);
                            c3100c.f10002c.addListener(this);
                            BetaReceiver.addTask(c3100c.f10002c);
                            c3100c.f10002c.download();
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
            C3192q c3192q = (C3192q) this.f9853b[0];
            Integer num2 = (Integer) this.f9853b[1];
            BetaGrayStrategy betaGrayStrategy2 = c3192q.f10777b;
            if (betaGrayStrategy2 != null && betaGrayStrategy2.f9988a != null) {
                C3151an.m9915a("patch download success !!!", new Object[0]);
                File saveFile2 = downloadTask.getSaveFile();
                if (!C3078a.m9333a(saveFile2, betaGrayStrategy2.f9988a.f10837f.f10796a, "SHA")) {
                    if (num2.intValue() >= 2) {
                        this.f9853b[1] = 0;
                        onFailed(downloadTask, 2080, "file sha1 verify fail");
                        downloadTask.delete(true);
                        TinkerManager.getInstance().onDownloadFailure("retry download patch too many times.");
                        return;
                    }
                    this.f9853b[1] = Integer.valueOf(num2.intValue() + 1);
                    downloadTask.delete(true);
                    c3192q.f10778c = C3082e.f9867G.f9916r.mo9315a(betaGrayStrategy2.f9988a.f10837f.f10797b, C3082e.f9867G.f9920v.getAbsolutePath(), null, betaGrayStrategy2.f9988a.f10837f.f10797b);
                    c3192q.f10778c.setDownloadType(3);
                    c3192q.f10778c.setNeededNotify(false);
                    c3192q.f10778c.addListener(this);
                    BetaReceiver.addTask(c3192q.f10778c);
                    c3192q.f10778c.download();
                    return;
                }
                this.f9853b[1] = 0;
                if (!C3078a.m9332a(saveFile2, C3082e.f9867G.f9877J)) {
                    C3151an.m9915a("copy file failed", new Object[0]);
                    TinkerManager.getInstance().onDownloadFailure("copy file failure.");
                    return;
                }
                C3151an.m9921c("copy " + saveFile2.getAbsolutePath() + " to " + C3082e.f9867G.f9877J.getAbsolutePath() + " success!", new Object[0]);
                if (c3192q.f10778c != null) {
                    C3151an.m9921c("delete temp file", new Object[0]);
                    c3192q.f10778c.delete(true);
                }
                C3078a.m9330a("UPLOAD_PATCH_RESULT", false);
                TinkerManager.getInstance().onDownloadSuccess(C3082e.f9867G.f9877J.getAbsolutePath(), C3082e.f9867G.f9891X);
            }
        } catch (Exception e2) {
            if (C3151an.m9919b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onFailed(DownloadTask downloadTask, int i2, String str) {
        try {
            int i3 = this.f9852a;
            if (i3 == 1) {
                synchronized (this.f9853b[0]) {
                    C3083f c3083f = (C3083f) this.f9853b[0];
                    c3083f.m9340a();
                    c3083f.m9344b();
                }
                return;
            }
            if (i3 == 2) {
                ((C3097h) this.f9853b[0]).m9363a(downloadTask);
                return;
            }
            if (i3 == 3) {
                C3100c c3100c = (C3100c) this.f9853b[0];
                if (downloadTask != null) {
                    C3191p.f10775a.m10131a(new C3198w("download", System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), c3100c.f10001b.f9988a.f10836e, c3100c.f10001b.f9988a.f10844m, c3100c.f10001b.f9988a.f10847p, null));
                }
                C3151an.m9923e("upgrade failed：(%d)%s", Integer.valueOf(i2), str);
                return;
            }
            if (i3 != 4) {
                return;
            }
            C3192q c3192q = (C3192q) this.f9853b[0];
            if (downloadTask != null) {
                C3191p.f10775a.m10131a(new C3198w("download", System.currentTimeMillis(), (byte) 1, downloadTask.getCostTime(), c3192q.f10777b.f9988a.f10836e, c3192q.f10777b.f9988a.f10844m, c3192q.f10777b.f9988a.f10847p, null));
            }
            C3151an.m9923e("hotfix download failed：(%d)%s", Integer.valueOf(i2), str);
            TinkerManager.getInstance().onDownloadFailure(str);
        } catch (Exception e2) {
            if (C3151an.m9919b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    @Override // com.tencent.bugly.beta.download.DownloadListener
    public void onReceive(DownloadTask downloadTask) {
        if (this.f9852a != 2) {
            return;
        }
        ((C3097h) this.f9853b[0]).m9363a(downloadTask);
    }
}
