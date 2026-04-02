package com.tencent.bugly.beta.global;

import android.content.ComponentName;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.tencent.bugly.beta.Beta;
import com.tencent.bugly.beta.UpgradeInfo;
import com.tencent.bugly.beta.download.BetaReceiver;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.ui.BetaActivity;
import com.tencent.bugly.beta.ui.g;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.x;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class d implements Runnable {
    int a;

    /* JADX INFO: renamed from: b */
    public final Object[] f6017b;

    public d(int i2, Object... objArr) {
        this.a = i2;
        this.f6017b = objArr;
    }

    /* JADX WARN: Removed duplicated region for block: B:549:0x0679  */
    /* JADX WARN: Removed duplicated region for block: B:610:? A[RETURN, SYNTHETIC] */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void run() {
        ArrayList arrayList;
        try {
            UpgradeInfo upgradeInfo = null;
            switch (this.a) {
                case 1:
                    try {
                        an.a("Beta async init start...", new Object[0]);
                        e eVar = e.G;
                        synchronized (e.G) {
                            try {
                                eVar.x = aq.a(new File(eVar.B.applicationInfo.publicSourceDir), "MD5");
                            } catch (Exception unused) {
                                eVar.x = null;
                            }
                            if (TextUtils.isEmpty(eVar.x)) {
                                eVar.x = d.c.a.b.a.a.f10075h;
                                an.e("\u65e0\u6cd5\u83b7\u53d6md5\u503c", new Object[0]);
                            }
                            if (eVar.E) {
                                a.a(eVar.v);
                            }
                            BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                            if (betaGrayStrategy != null && betaGrayStrategy.a != null) {
                                if (TextUtils.equals(betaGrayStrategy.a.f6598e.f6580i.toUpperCase(), eVar.x)) {
                                    if (a.a("app.upgrade.strategy.bch")) {
                                        String strB = a.b("installApkMd5", (String) null);
                                        if (TextUtils.isEmpty(strB) || !TextUtils.equals(strB, eVar.x)) {
                                            an.a("activated from the other way", new Object[0]);
                                        } else {
                                            p.a.a(new w("active", System.currentTimeMillis(), (byte) 0, 0L, null, betaGrayStrategy.a.f6606m, betaGrayStrategy.a.p, null));
                                        }
                                        eVar.C.edit().remove("installApkMd5").apply();
                                        DownloadTask downloadTaskA = eVar.r.a(betaGrayStrategy.a.f6599f.f6568b, eVar.v.getAbsolutePath(), null, null);
                                        downloadTaskA.setDownloadType(1);
                                        downloadTaskA.delete(true);
                                        a.a(eVar.v);
                                        f.a.a();
                                        an.a("upgrade success", new Object[0]);
                                    } else {
                                        an.d("delete strategy failed", new Object[0]);
                                    }
                                }
                                an.a("[this md5:%s] [strategy md5:%s]", eVar.x, betaGrayStrategy.a.f6598e.f6580i);
                            }
                            e.G.notifyAll();
                            break;
                        }
                        eVar.u.registerReceiver(new BetaReceiver(), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
                        if (eVar.f6020d) {
                            Beta.checkUpgrade(false, false);
                        } else {
                            if (eVar.f6022f) {
                                Beta.checkHotFix();
                            }
                            if (eVar.f6021e) {
                                Beta.checkAppUpgrade(false, false);
                            }
                        }
                        if (e.G.H.a.f6490b && (arrayList = (ArrayList) p.a.a()) != null && !arrayList.isEmpty()) {
                            com.tencent.bugly.beta.upgrade.b.a.a(new x(arrayList), true);
                        }
                        an.a("Beta async init end...", new Object[0]);
                        return;
                    } catch (Exception e2) {
                        if (an.b(e2)) {
                            return;
                        }
                        e2.printStackTrace();
                        return;
                    }
                case 2:
                    g.a((com.tencent.bugly.beta.ui.b) this.f6017b[0], ((Boolean) this.f6017b[1]).booleanValue());
                    return;
                case 3:
                    BetaGrayStrategy betaGrayStrategy2 = (BetaGrayStrategy) this.f6017b[0];
                    DownloadTask downloadTask = (DownloadTask) this.f6017b[1];
                    if (!betaGrayStrategy2.f6072d) {
                        betaGrayStrategy2.f6072d = true;
                        betaGrayStrategy2.f6071c = System.currentTimeMillis();
                        if (betaGrayStrategy2.a != null && betaGrayStrategy2.a.p == 1) {
                            a.a("app.upgrade.strategy.bch", betaGrayStrategy2);
                        }
                    }
                    if (downloadTask.getStatus() != 2) {
                        if (downloadTask.getStatus() == 1) {
                            p.a.a(new w("pop", System.currentTimeMillis(), (byte) 4, 0L, betaGrayStrategy2.a.f6598e, betaGrayStrategy2.a.f6606m, betaGrayStrategy2.a.p, null));
                            return;
                        } else {
                            p.a.a(new w("pop", System.currentTimeMillis(), (byte) 3, 0L, betaGrayStrategy2.a.f6598e, betaGrayStrategy2.a.f6606m, betaGrayStrategy2.a.p, null));
                            return;
                        }
                    }
                    return;
                case 4:
                    BetaGrayStrategy betaGrayStrategy3 = (BetaGrayStrategy) this.f6017b[0];
                    DownloadTask downloadTask2 = (DownloadTask) this.f6017b[1];
                    boolean zBooleanValue = ((Boolean) this.f6017b[2]).booleanValue();
                    if (downloadTask2.getStatus() != 2) {
                        betaGrayStrategy3.f6072d = false;
                        betaGrayStrategy3.f6071c = System.currentTimeMillis();
                        if (!zBooleanValue && betaGrayStrategy3.a.f6600g != 2) {
                            betaGrayStrategy3.f6070b++;
                        }
                        if (betaGrayStrategy3.a != null && betaGrayStrategy3.a.p == 1) {
                            a.a("app.upgrade.strategy.bch", betaGrayStrategy3);
                        }
                        p.a.a(new w("pop", System.currentTimeMillis(), (byte) 2, 0L, betaGrayStrategy3.a.f6598e, betaGrayStrategy3.a.f6606m, betaGrayStrategy3.a.p, null));
                        return;
                    }
                    return;
                case 5:
                    com.tencent.bugly.beta.utils.f.a(e.G.u, (String) this.f6017b[0]);
                    return;
                case 6:
                    synchronized (this) {
                        if (!((Boolean) this.f6017b[0]).booleanValue()) {
                            this.f6017b[0] = true;
                            ((Runnable) this.f6017b[1]).run();
                        }
                        break;
                    }
                    return;
                case 7:
                    ((h) this.f6017b[0]).c();
                    return;
                case 8:
                    List<DownloadListener> list = (List) this.f6017b[0];
                    if (list != null) {
                        for (DownloadListener downloadListener : list) {
                            if (downloadListener != null) {
                                downloadListener.onCompleted((DownloadTask) this.f6017b[1]);
                            }
                        }
                        return;
                    }
                    return;
                case 9:
                    List<DownloadListener> list2 = (List) this.f6017b[0];
                    if (list2 != null) {
                        for (DownloadListener downloadListener2 : list2) {
                            if (downloadListener2 != null) {
                                downloadListener2.onReceive((DownloadTask) this.f6017b[1]);
                            }
                        }
                    }
                    DownloadTask downloadTask3 = (DownloadTask) this.f6017b[1];
                    if (e.G.Y == null || downloadTask3.getDownloadType() != 3) {
                        return;
                    }
                    e.G.Y.onDownloadReceived(downloadTask3.getSavedLength(), downloadTask3.getTotalLength());
                    return;
                case 10:
                    List<DownloadListener> list3 = (List) this.f6017b[0];
                    if (list3 != null) {
                        for (DownloadListener downloadListener3 : list3) {
                            if (downloadListener3 != null) {
                                downloadListener3.onFailed((DownloadTask) this.f6017b[1], ((Integer) this.f6017b[2]).intValue(), (String) this.f6017b[3]);
                            }
                        }
                        return;
                    }
                    return;
                case 11:
                    g.a((com.tencent.bugly.beta.ui.b) this.f6017b[0], ((Boolean) this.f6017b[1]).booleanValue(), ((Boolean) this.f6017b[2]).booleanValue(), ((Long) this.f6017b[3]).longValue());
                    an.a("BetaAct TYPE_actCanShow checking : " + this.f6017b[0].hashCode(), new Object[0]);
                    return;
                case 12:
                    boolean zBooleanValue2 = ((Boolean) this.f6017b[0]).booleanValue();
                    com.tencent.bugly.beta.upgrade.a aVar = (com.tencent.bugly.beta.upgrade.a) this.f6017b[1];
                    synchronized (this.f6017b[1]) {
                        if (!zBooleanValue2) {
                            if (!aVar.f6077d) {
                                this.f6017b[0] = true;
                                aVar.a(aVar.f6075b, null, 0L, 0L, false, "request is not finished");
                                aVar.f6076c[1] = true;
                                aVar.f6077d = false;
                                an.a("request is not finished", new Object[0]);
                            }
                            break;
                        } else {
                            break;
                        }
                    }
                    return;
                case 13:
                    DownloadTask downloadTask4 = (DownloadTask) this.f6017b[0];
                    BetaGrayStrategy betaGrayStrategy4 = (BetaGrayStrategy) this.f6017b[1];
                    if (downloadTask4 != null && betaGrayStrategy4 != null) {
                        int status = downloadTask4.getStatus();
                        if (status != 0 && status != 1) {
                            if (status == 2) {
                                downloadTask4.stop();
                                return;
                            } else if (status != 3 && status != 4 && status != 5) {
                                return;
                            }
                        }
                        if (!betaGrayStrategy4.f6072d) {
                            betaGrayStrategy4.f6072d = true;
                            betaGrayStrategy4.f6071c = System.currentTimeMillis();
                            if (betaGrayStrategy4.a != null && betaGrayStrategy4.a.p == 1) {
                                a.a("app.upgrade.strategy.bch", betaGrayStrategy4);
                            }
                        }
                        if (downloadTask4.getStatus() != 2) {
                            if (downloadTask4.getStatus() == 1) {
                                p.a.a(new w("pop", System.currentTimeMillis(), (byte) 4, 0L, betaGrayStrategy4.a.f6598e, betaGrayStrategy4.a.f6606m, betaGrayStrategy4.a.p, null));
                            } else {
                                p.a.a(new w("pop", System.currentTimeMillis(), (byte) 3, 0L, betaGrayStrategy4.a.f6598e, betaGrayStrategy4.a.f6606m, betaGrayStrategy4.a.p, null));
                            }
                        }
                        if (downloadTask4.getStatus() == 1 && a.a(e.G.u, downloadTask4.getSaveFile(), betaGrayStrategy4.a.f6599f.a)) {
                            p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, betaGrayStrategy4.a.f6598e, betaGrayStrategy4.a.f6606m, betaGrayStrategy4.a.p, null));
                            return;
                        } else {
                            downloadTask4.download();
                            return;
                        }
                    }
                    an.a("strategyTask or betaStrategy is null", new Object[0]);
                    return;
                case 14:
                    DownloadTask downloadTask5 = (DownloadTask) this.f6017b[0];
                    BetaGrayStrategy betaGrayStrategy5 = (BetaGrayStrategy) this.f6017b[1];
                    boolean zBooleanValue3 = ((Boolean) this.f6017b[2]).booleanValue();
                    if (downloadTask5 != null && betaGrayStrategy5 != null) {
                        if (downloadTask5.getStatus() != 2) {
                            betaGrayStrategy5.f6072d = false;
                            betaGrayStrategy5.f6071c = System.currentTimeMillis();
                            if (!zBooleanValue3 && betaGrayStrategy5.a.f6600g != 2) {
                                betaGrayStrategy5.f6070b++;
                            }
                            if (betaGrayStrategy5.a != null && betaGrayStrategy5.a.p == 1) {
                                a.a("app.upgrade.strategy.bch", betaGrayStrategy5);
                            }
                            p.a.a(new w("pop", System.currentTimeMillis(), (byte) 2, 0L, betaGrayStrategy5.a.f6598e, betaGrayStrategy5.a.f6606m, betaGrayStrategy5.a.p, null));
                            return;
                        }
                        return;
                    }
                    an.a("strategyTask or betaStrategy is null", new Object[0]);
                    return;
                case 15:
                    if (!((com.tencent.bugly.beta.ui.b) this.f6017b[0]).b() && !TextUtils.equals(g.a(), BetaActivity.class.getCanonicalName())) {
                        g.a((com.tencent.bugly.beta.ui.b) this.f6017b[0], ((Boolean) this.f6017b[1]).booleanValue(), ((Boolean) this.f6017b[2]).booleanValue(), ((Long) this.f6017b[3]).longValue());
                        return;
                    }
                    com.tencent.bugly.beta.utils.e.a(this, 3000L);
                    return;
                case 16:
                    UpgradeListener upgradeListener = (UpgradeListener) this.f6017b[0];
                    int iIntValue = ((Integer) this.f6017b[1]).intValue();
                    BetaGrayStrategy betaGrayStrategy6 = (BetaGrayStrategy) this.f6017b[2];
                    boolean zBooleanValue4 = ((Boolean) this.f6017b[3]).booleanValue();
                    boolean zBooleanValue5 = ((Boolean) this.f6017b[4]).booleanValue();
                    if (betaGrayStrategy6 != null) {
                        upgradeInfo = new UpgradeInfo(betaGrayStrategy6.a);
                    }
                    upgradeListener.onUpgrade(iIntValue, upgradeInfo, zBooleanValue4, zBooleanValue5);
                    return;
                case 17:
                    try {
                        PackageManager packageManager = e.G.u.getPackageManager();
                        if (packageManager != null) {
                            ComponentName componentName = new ComponentName(e.G.u, BetaActivity.class.getName());
                            if (packageManager.getComponentEnabledSetting(componentName) == 2) {
                                packageManager.setComponentEnabledSetting(componentName, 1, 1);
                            }
                        }
                        ((Map) this.f6017b[0]).put((Integer) this.f6017b[1], (com.tencent.bugly.beta.ui.b) this.f6017b[2]);
                        Intent intent = new Intent(e.G.u, (Class<?>) BetaActivity.class);
                        intent.putExtra("frag", (Integer) this.f6017b[1]);
                        intent.setFlags(CommonNetImpl.FLAG_AUTH);
                        e.G.u.startActivity(intent);
                        return;
                    } catch (Exception e3) {
                        an.e("\u65e0\u6cd5\u6b63\u5e38\u5f39\u7a97\uff0c\u8bf7\u5728AndroidManifest.xml\u4e2d\u6dfb\u52a0BetaActivity\u58f0\u660e\uff1a\n<activity\n    android:name=\"com.tencent.bugly.beta.ui.BetaActivity\"\n    android:theme=\"@android:style/Theme.Translucent\" />", new Object[0]);
                        if (an.b(e3)) {
                            return;
                        }
                        e3.printStackTrace();
                        return;
                    }
                case 18:
                    UpgradeStateListener upgradeStateListener = (UpgradeStateListener) this.f6017b[0];
                    int iIntValue2 = ((Integer) this.f6017b[1]).intValue();
                    boolean zBooleanValue6 = ((Boolean) this.f6017b[2]).booleanValue();
                    if (iIntValue2 == -1) {
                        upgradeStateListener.onUpgradeFailed(zBooleanValue6);
                        return;
                    }
                    if (iIntValue2 == 0) {
                        upgradeStateListener.onUpgradeSuccess(zBooleanValue6);
                        return;
                    }
                    if (iIntValue2 == 1) {
                        upgradeStateListener.onUpgradeNoVersion(zBooleanValue6);
                        return;
                    } else if (iIntValue2 == 2) {
                        upgradeStateListener.onUpgrading(zBooleanValue6);
                        return;
                    } else {
                        if (iIntValue2 != 3) {
                            return;
                        }
                        upgradeStateListener.onDownloadCompleted(zBooleanValue6);
                        return;
                    }
                default:
                    return;
            }
        } catch (Exception e4) {
            if (an.b(e4)) {
            }
        }
        if (an.b(e4)) {
            e4.printStackTrace();
        }
    }
}
