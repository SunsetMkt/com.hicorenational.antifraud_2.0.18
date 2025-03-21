package com.tencent.bugly.beta;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import androidx.vectordrawable.graphics.drawable.PathInterpolatorCompat;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.a;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.d;
import com.tencent.bugly.beta.global.f;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.ui.UILifecycleListener;
import com.tencent.bugly.beta.ui.h;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.upgrade.c;
import com.tencent.bugly.beta.utils.e;
import com.tencent.bugly.proguard.ac;
import com.tencent.bugly.proguard.am;
import com.tencent.bugly.proguard.an;
import com.tencent.bugly.proguard.aq;
import com.tencent.bugly.proguard.p;
import com.tencent.bugly.proguard.q;
import com.tencent.bugly.proguard.r;
import com.tencent.bugly.proguard.s;
import com.tencent.bugly.proguard.u;
import com.tencent.bugly.proguard.v;
import com.tencent.bugly.proguard.w;
import com.tencent.bugly.proguard.y;
import com.umeng.analytics.pro.bl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class Beta extends a {
    public static final String TAG_CANCEL_BUTTON = "beta_cancel_button";
    public static final String TAG_CONFIRM_BUTTON = "beta_confirm_button";
    public static final String TAG_IMG_BANNER = "beta_upgrade_banner";
    public static final String TAG_TIP_MESSAGE = "beta_tip_message";
    public static final String TAG_TITLE = "beta_title";
    public static final String TAG_UPGRADE_FEATURE = "beta_upgrade_feature";
    public static final String TAG_UPGRADE_INFO = "beta_upgrade_info";
    public static boolean autoCheckAppUpgrade = false;
    public static boolean autoCheckHotfix = false;
    public static boolean autoCheckUpgrade = true;
    public static boolean autoInit = true;
    public static BetaPatchListener betaPatchListener = null;
    public static int defaultBannerId = 0;
    public static DownloadListener downloadListener = null;
    public static long initDelay = 3000;
    public static String initProcessName = null;
    public static int largeIconId = 0;
    public static boolean showInterruptedStrategy = true;
    public static int smallIconId = 0;
    public static File storageDir = null;
    public static String strNetworkTipsCancelBtn = "取消";
    public static String strNetworkTipsConfirmBtn = "继续下载";
    public static String strNetworkTipsMessage = "你已切换到移动网络，是否继续当前下载？";
    public static String strNetworkTipsTitle = "网络提示";
    public static String strNotificationClickToContinue = "继续下载";
    public static String strNotificationClickToInstall = "点击安装";
    public static String strNotificationClickToRetry = "点击重试";
    public static String strNotificationClickToView = "点击查看";
    public static String strNotificationDownloadError = "下载失败";
    public static String strNotificationDownloadSucc = "下载完成";
    public static String strNotificationDownloading = "正在下载";
    public static String strNotificationHaveNewVersion = "有新版本";
    public static String strToastCheckUpgradeError = "检查新版本失败，请稍后重试";
    public static String strToastCheckingUpgrade = "正在检查，请稍候...";
    public static String strToastYourAreTheLatestVersion = "你已经是最新版了";
    public static String strUpgradeDialogCancelBtn = "下次再说";
    public static String strUpgradeDialogContinueBtn = "继续";
    public static String strUpgradeDialogFeatureLabel = "更新说明";
    public static String strUpgradeDialogFileSizeLabel = "包大小";
    public static String strUpgradeDialogInstallBtn = "安装";
    public static String strUpgradeDialogRetryBtn = "重试";
    public static String strUpgradeDialogUpdateTimeLabel = "更新时间";
    public static String strUpgradeDialogUpgradeBtn = "立即更新";
    public static String strUpgradeDialogVersionLabel = "版本";
    public static int tipsDialogLayoutId;
    public static long upgradeCheckPeriod;
    public static int upgradeDialogLayoutId;
    public static UILifecycleListener<UpgradeInfo> upgradeDialogLifecycleListener;
    public static UpgradeListener upgradeListener;
    public static UpgradeStateListener upgradeStateListener;
    public static List<Class<? extends Activity>> canShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static List<Class<? extends Activity>> canNotShowUpgradeActs = Collections.synchronizedList(new ArrayList());
    public static boolean enableHotfix = false;
    public static boolean enableNotification = true;
    public static boolean autoDownloadOnWifi = false;
    public static boolean canShowApkInfo = true;
    public static boolean canAutoDownloadPatch = true;
    public static boolean canAutoPatch = true;
    public static String appVersionName = null;
    public static int appVersionCode = Integer.MIN_VALUE;
    public static String appChannel = null;
    public static boolean canNotifyUserRestart = false;
    public static List<String> soBlackList = Collections.synchronizedList(new ArrayList());
    public static boolean dialogFullScreen = false;
    public static boolean autoInstallApk = true;
    public static boolean autoDownloadOn4g = false;
    public static boolean setPatchRestartOnScreenOff = true;
    public static Beta instance = new Beta();

    /* renamed from: a, reason: collision with root package name */
    private static DownloadTask f8762a = null;

    private static void a(boolean z, boolean z2, int i2) {
        try {
            if (z) {
                c.f8860a.a(z, z2, i2);
                if (upgradeStateListener != null) {
                    e.a(new d(18, upgradeStateListener, 2, Boolean.valueOf(z)));
                } else {
                    e.a(new d(5, strToastCheckingUpgrade));
                }
            } else if (i2 == 0 || i2 == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy != null && betaGrayStrategy.f8848a != null && System.currentTimeMillis() - betaGrayStrategy.f8852e <= com.tencent.bugly.beta.global.e.G.f8793c) {
                    c.f8860a.a(z, z2, 0, null, "");
                }
                c.f8860a.a(z, z2, i2);
            } else if (i2 != 3) {
            } else {
                q.f9424a.a(z, z2, 3);
            }
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() {
        if (new File(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath(), true);
        } else {
            an.c(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (((java.lang.Boolean) r1[2]).booleanValue() == com.tencent.bugly.beta.upgrade.c.f8860a.f8866g) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cancelDownload() {
        /*
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.c.f8860a
            com.tencent.bugly.beta.global.d r1 = r0.f8869j
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L25
            java.lang.Object[] r1 = r1.f8790b
            r5 = r1[r4]
            com.tencent.bugly.beta.download.DownloadTask r6 = r0.f8862c
            if (r5 != r6) goto L25
            r5 = r1[r3]
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r0 = r0.f8861b
            if (r5 != r0) goto L25
            r0 = r1[r2]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.tencent.bugly.beta.upgrade.c r1 = com.tencent.bugly.beta.upgrade.c.f8860a
            boolean r1 = r1.f8866g
            if (r0 == r1) goto L43
        L25:
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.c.f8860a
            com.tencent.bugly.beta.global.d r1 = new com.tencent.bugly.beta.global.d
            r5 = 14
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.tencent.bugly.beta.download.DownloadTask r7 = r0.f8862c
            r6[r4] = r7
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = r0.f8861b
            r6[r3] = r4
            boolean r3 = r0.f8866g
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r6[r2] = r3
            r1.<init>(r5, r6)
            r0.f8869j = r1
        L43:
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.c.f8860a
            com.tencent.bugly.beta.global.d r0 = r0.f8869j
            r0.run()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.cancelDownload():void");
    }

    public static void checkAppUpgrade() {
        a(true, false, 1);
    }

    public static void checkHotFix() {
        a(false, false, 3);
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void cleanTinkerPatch(boolean z) {
        com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z);
    }

    public static void downloadPatch() {
        q qVar = q.f9424a;
        qVar.f9425b = qVar.a((y) null);
        try {
            if (q.f9424a.f9425b != null) {
                q.f9424a.a(0, q.f9424a.f9425b.f8848a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            c.f8860a.f8861b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (c.f8860a.f8861b != null) {
                return new UpgradeInfo(c.f8860a.f8861b.f8848a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            q.f9424a.f9425b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (q.f9424a.f9425b != null) {
                return new UpgradeInfo(q.f9424a.f9425b.f8848a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.id = 1002;
        beta.version = "1.4.5";
        beta.versionKey = "G10";
        return beta;
    }

    public static DownloadTask getStrategyTask() {
        if (f8762a == null) {
            c.f8860a.f8861b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (c.f8860a.f8861b != null) {
                f8762a = com.tencent.bugly.beta.global.e.G.r.a(c.f8860a.f8861b.f8848a.f9480f.f9445b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, c.f8860a.f8861b.f8848a.f9480f.f9444a);
                f8762a.setDownloadType(1);
                c.f8860a.f8862c = f8762a;
            }
        }
        return c.f8860a.f8862c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        return new com.tencent.bugly.beta.UpgradeInfo(r1.f8848a);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.tencent.bugly.beta.UpgradeInfo getUpgradeInfo() {
        /*
            r0 = 0
            java.lang.String r1 = "hotfix.strategy.bch"
            android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r2 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch: java.lang.Exception -> L45
            android.os.Parcelable r1 = com.tencent.bugly.beta.global.a.a(r1, r2)     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r1 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r1     // Catch: java.lang.Exception -> L45
            java.lang.String r2 = "app.upgrade.strategy.bch"
            android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r3 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch: java.lang.Exception -> L45
            android.os.Parcelable r2 = com.tencent.bugly.beta.global.a.a(r2, r3)     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2     // Catch: java.lang.Exception -> L45
            if (r1 == 0) goto L2a
            com.tencent.bugly.proguard.y r3 = r1.f8848a     // Catch: java.lang.Exception -> L45
            if (r3 == 0) goto L2a
            if (r2 == 0) goto L2a
            com.tencent.bugly.proguard.y r3 = r2.f8848a     // Catch: java.lang.Exception -> L45
            if (r3 == 0) goto L2a
            long r3 = r1.f8852e     // Catch: java.lang.Exception -> L45
            long r5 = r2.f8852e     // Catch: java.lang.Exception -> L45
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L3a
            goto L3b
        L2a:
            if (r1 == 0) goto L3a
            com.tencent.bugly.proguard.y r3 = r1.f8848a     // Catch: java.lang.Exception -> L45
            if (r3 != 0) goto L31
            goto L3a
        L31:
            if (r2 == 0) goto L3b
            com.tencent.bugly.proguard.y r2 = r2.f8848a     // Catch: java.lang.Exception -> L45
            if (r2 != 0) goto L38
            goto L3b
        L38:
            r1 = r0
            goto L3b
        L3a:
            r1 = r2
        L3b:
            if (r1 == 0) goto L45
            com.tencent.bugly.beta.UpgradeInfo r2 = new com.tencent.bugly.beta.UpgradeInfo     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.proguard.y r1 = r1.f8848a     // Catch: java.lang.Exception -> L45
            r2.<init>(r1)     // Catch: java.lang.Exception -> L45
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeInfo():com.tencent.bugly.beta.UpgradeInfo");
    }

    public static synchronized y getUpgradeStrategy() {
        synchronized (Beta.class) {
            c.f8860a.f8861b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            try {
                if (c.f8860a.f8861b != null) {
                    return (y) c.f8860a.f8861b.f8848a.clone();
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public static synchronized void init(Context context, boolean z) {
        synchronized (Beta.class) {
            an.a("Beta init start....", new Object[0]);
            ac a2 = ac.a();
            int i2 = instance.id;
            int i3 = com.tencent.bugly.beta.global.e.f8791a + 1;
            com.tencent.bugly.beta.global.e.f8791a = i3;
            a2.a(i2, i3);
            if (TextUtils.isEmpty(initProcessName)) {
                initProcessName = context.getPackageName();
            }
            an.a("Beta will init at: %s", initProcessName);
            String str = com.tencent.bugly.crashreport.common.info.a.b().f8978e;
            an.a("current process: %s", str);
            if (TextUtils.equals(initProcessName, str)) {
                com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
                if (!TextUtils.isEmpty(eVar.x)) {
                    an.d("Beta has been initialized [apkMD5 : %s]", eVar.x);
                    return;
                }
                an.a("current upgrade sdk version:1.4.5", new Object[0]);
                eVar.F = z;
                if (upgradeCheckPeriod < 0) {
                    an.d("upgradeCheckPeriod cannot be negative", new Object[0]);
                } else {
                    eVar.f8793c = upgradeCheckPeriod;
                    an.a("setted upgradeCheckPeriod: %d", Long.valueOf(upgradeCheckPeriod));
                }
                if (initDelay < 0) {
                    an.d("initDelay cannot be negative", new Object[0]);
                } else {
                    eVar.f8792b = initDelay;
                    an.a("setted initDelay: %d", Long.valueOf(initDelay));
                }
                if (smallIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(smallIconId) != null) {
                            eVar.f8798h = smallIconId;
                            an.a("setted smallIconId: %d", Integer.valueOf(smallIconId));
                        }
                    } catch (Exception e2) {
                        an.e("smallIconId is not available:\n %s", e2.toString());
                    }
                }
                if (largeIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(largeIconId) != null) {
                            eVar.f8799i = largeIconId;
                            an.a("setted largeIconId: %d", Integer.valueOf(largeIconId));
                        }
                    } catch (Exception e3) {
                        an.e("largeIconId is not available:\n %s", e3.toString());
                    }
                }
                if (defaultBannerId != 0) {
                    try {
                        if (context.getResources().getDrawable(defaultBannerId) != null) {
                            eVar.f8800j = defaultBannerId;
                            an.a("setted defaultBannerId: %d", Integer.valueOf(defaultBannerId));
                        }
                    } catch (Exception e4) {
                        an.e("defaultBannerId is not available:\n %s", e4.toString());
                    }
                }
                if (upgradeDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout = context.getResources().getLayout(upgradeDialogLayoutId);
                        if (layout != null) {
                            eVar.f8801k = upgradeDialogLayoutId;
                            an.a("setted upgradeDialogLayoutId: %d", Integer.valueOf(upgradeDialogLayoutId));
                            layout.close();
                        }
                    } catch (Exception e5) {
                        an.e("upgradeDialogLayoutId is not available:\n %s", e5.toString());
                    }
                }
                if (tipsDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout2 = context.getResources().getLayout(tipsDialogLayoutId);
                        if (layout2 != null) {
                            eVar.f8802l = tipsDialogLayoutId;
                            an.a("setted tipsDialogLayoutId: %d", Integer.valueOf(tipsDialogLayoutId));
                            layout2.close();
                        }
                    } catch (Exception e6) {
                        an.e("tipsDialogLayoutId is not available:\n %s", e6.toString());
                    }
                }
                if (upgradeDialogLifecycleListener != null) {
                    try {
                        eVar.f8803m = upgradeDialogLifecycleListener;
                        an.a("setted upgradeDialogLifecycleListener:%s" + upgradeDialogLifecycleListener, new Object[0]);
                    } catch (Exception e7) {
                        an.e("upgradeDialogLifecycleListener is not available:\n %", e7.toString());
                    }
                }
                if (canShowUpgradeActs != null && !canShowUpgradeActs.isEmpty()) {
                    for (Class<? extends Activity> cls : canShowUpgradeActs) {
                        if (cls != null) {
                            eVar.o.add(cls);
                        }
                    }
                    an.a("setted canShowUpgradeActs: %s", eVar.o);
                }
                if (canNotShowUpgradeActs != null && !canNotShowUpgradeActs.isEmpty()) {
                    for (Class<? extends Activity> cls2 : canNotShowUpgradeActs) {
                        if (cls2 != null) {
                            eVar.p.add(cls2);
                        }
                    }
                    an.a("setted canNotShowUpgradeActs: %s", eVar.p);
                }
                eVar.f8794d = autoCheckUpgrade;
                eVar.f8795e = autoCheckAppUpgrade;
                eVar.f8796f = autoCheckHotfix;
                Object[] objArr = new Object[1];
                objArr[0] = eVar.f8794d ? "is opened" : "is closed";
                an.a("autoCheckUpgrade %s", objArr);
                Object[] objArr2 = new Object[1];
                objArr2[0] = eVar.f8795e ? "is opened" : "is closed";
                an.a("autoCheckAppUpgrade %s", objArr2);
                Object[] objArr3 = new Object[1];
                objArr3[0] = eVar.f8796f ? "is opened" : "is closed";
                an.a("autoCheckHotfix %s", objArr3);
                eVar.af = autoInstallApk;
                Object[] objArr4 = new Object[1];
                objArr4[0] = eVar.af ? "is opened" : "is closed";
                an.a("autoInstallApk %s", objArr4);
                eVar.V = autoDownloadOn4g;
                Object[] objArr5 = new Object[1];
                objArr5[0] = eVar.V ? "is opened" : "is closed";
                an.a("autoDownloadOn4g %s", objArr5);
                eVar.f8797g = showInterruptedStrategy;
                Object[] objArr6 = new Object[1];
                objArr6[0] = eVar.f8797g ? "is opened" : "is closed";
                an.a("showInterruptedStrategy %s", objArr6);
                Object[] objArr7 = new Object[1];
                objArr7[0] = upgradeListener != null ? "is opened" : "is closed";
                an.a("isDIY %s", objArr7);
                if (storageDir != null) {
                    if (storageDir.exists() || storageDir.mkdirs()) {
                        eVar.n = storageDir;
                        an.a("setted storageDir: %s", storageDir.getAbsolutePath());
                    } else {
                        an.a("storageDir is not exists: %s", storageDir.getAbsolutePath());
                    }
                }
                if (eVar.r == null) {
                    eVar.r = s.f9436a;
                }
                if (TextUtils.isEmpty(eVar.w)) {
                    eVar.w = com.tencent.bugly.crashreport.common.info.a.b().f();
                }
                eVar.T = enableNotification;
                an.a("enableNotification %s", enableNotification + "");
                eVar.U = autoDownloadOnWifi;
                an.a("autoDownloadOnWifi %s", autoDownloadOnWifi + "");
                eVar.W = canShowApkInfo;
                an.a("canShowApkInfo %s", canShowApkInfo + "");
                eVar.X = canAutoPatch;
                an.a("canAutoPatch %s", canAutoPatch + "");
                eVar.Y = betaPatchListener;
                eVar.z = appVersionName;
                eVar.y = appVersionCode;
                eVar.Z = canNotifyUserRestart;
                an.a("canNotifyUserRestart %s", canNotifyUserRestart + "");
                eVar.aa = canAutoDownloadPatch;
                an.a("canAutoDownloadPatch %s", canAutoDownloadPatch + "");
                eVar.ab = enableHotfix;
                an.a("enableHotfix %s", enableHotfix + "");
                if (soBlackList != null && !soBlackList.isEmpty()) {
                    for (String str2 : soBlackList) {
                        if (str2 != null) {
                            eVar.ac.add(str2);
                        }
                    }
                    an.a("setted soBlackList: %s", eVar.ac);
                }
                if (appChannel != null) {
                    eVar.R = appChannel;
                    an.a("Beta channel %s", appChannel);
                }
                eVar.a(context);
                ResBean.f8780a = (ResBean) com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.CREATOR);
                if (ResBean.f8780a == null) {
                    ResBean.f8780a = new ResBean();
                }
                c.f8860a.f8864e = upgradeListener;
                c.f8860a.f8865f = upgradeStateListener;
                c.f8860a.f8863d = downloadListener;
                if (getStrategyTask() != null && downloadListener != null) {
                    getStrategyTask().addListener(c.f8860a.f8863d);
                }
                if (enableHotfix) {
                    an.a("enableHotfix %s", "1");
                    aq.b("D4", "1");
                    r.a(context);
                }
                Resources resources = context.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = resources.getConfiguration();
                configuration.locale = Locale.getDefault();
                if (configuration.locale.equals(Locale.US) || configuration.locale.equals(Locale.ENGLISH)) {
                    strToastYourAreTheLatestVersion = context.getResources().getString(R.string.strToastYourAreTheLatestVersion);
                    strToastCheckUpgradeError = context.getResources().getString(R.string.strToastCheckUpgradeError);
                    strToastCheckingUpgrade = context.getResources().getString(R.string.strToastCheckingUpgrade);
                    strNotificationDownloading = context.getResources().getString(R.string.strNotificationDownloading);
                    strNotificationClickToView = context.getResources().getString(R.string.strNotificationClickToView);
                    strNotificationClickToInstall = context.getResources().getString(R.string.strNotificationClickToInstall);
                    strNotificationClickToContinue = context.getResources().getString(R.string.strNotificationClickToContinue);
                    strNotificationClickToRetry = context.getResources().getString(R.string.strNotificationClickToRetry);
                    strNotificationDownloadSucc = context.getResources().getString(R.string.strNotificationDownloadSucc);
                    strNotificationDownloadError = context.getResources().getString(R.string.strNotificationDownloadError);
                    strNotificationHaveNewVersion = context.getResources().getString(R.string.strNotificationHaveNewVersion);
                    strNetworkTipsMessage = context.getResources().getString(R.string.strNetworkTipsMessage);
                    strNetworkTipsTitle = context.getResources().getString(R.string.strNetworkTipsTitle);
                    strNetworkTipsConfirmBtn = context.getResources().getString(R.string.strNetworkTipsConfirmBtn);
                    strNetworkTipsCancelBtn = context.getResources().getString(R.string.strNetworkTipsCancelBtn);
                    strUpgradeDialogVersionLabel = context.getResources().getString(R.string.strUpgradeDialogVersionLabel);
                    strUpgradeDialogFileSizeLabel = context.getResources().getString(R.string.strUpgradeDialogFileSizeLabel);
                    strUpgradeDialogUpdateTimeLabel = context.getResources().getString(R.string.strUpgradeDialogUpdateTimeLabel);
                    strUpgradeDialogFeatureLabel = context.getResources().getString(R.string.strUpgradeDialogFeatureLabel);
                    strUpgradeDialogUpgradeBtn = context.getResources().getString(R.string.strUpgradeDialogUpgradeBtn);
                    strUpgradeDialogInstallBtn = context.getResources().getString(R.string.strUpgradeDialogInstallBtn);
                    strUpgradeDialogRetryBtn = context.getResources().getString(R.string.strUpgradeDialogRetryBtn);
                    strUpgradeDialogContinueBtn = context.getResources().getString(R.string.strUpgradeDialogContinueBtn);
                    strUpgradeDialogCancelBtn = context.getResources().getString(R.string.strUpgradeDialogCancelBtn);
                }
                resources.updateConfiguration(configuration, displayMetrics);
                am.a().a(new d(1, new Object[0]), eVar.f8792b);
                ac a3 = ac.a();
                int i4 = instance.id;
                int i5 = com.tencent.bugly.beta.global.e.f8791a - 1;
                com.tencent.bugly.beta.global.e.f8791a = i5;
                a3.a(i4, i5);
                an.a("Beta init finished...", new Object[0]);
            }
        }
    }

    public static synchronized void installApk(File file) {
        synchronized (Beta.class) {
            try {
                y upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.G.u, file, upgradeStrategy.f9480f.f9444a)) {
                    p.f9423a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f9479e, upgradeStrategy.f9487m, upgradeStrategy.p, null));
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static void installTinker() {
        enableHotfix = true;
        installTinker(TinkerApplicationLike.getTinkerPatchApplicationLike());
    }

    public static void loadArmLibrary(Context context, String str) {
        TinkerManager.loadArmLibrary(context, str);
    }

    public static void loadArmV7Library(Context context, String str) {
        TinkerManager.loadArmV7Library(context, str);
    }

    public static void loadLibrary(String str) {
        boolean z;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (!com.tencent.bugly.beta.global.a.b("LoadSoFileResult", true)) {
                        System.loadLibrary(str);
                        com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", true);
                        cleanTinkerPatch(true);
                        return;
                    }
                    com.tencent.bugly.beta.global.a.a("LoadSoFileResult", false);
                    String b2 = com.tencent.bugly.beta.global.a.b(str, "");
                    boolean b3 = com.tencent.bugly.beta.global.a.b("PatchResult", false);
                    if (TextUtils.isEmpty(b2) || !b3) {
                        z = false;
                    } else {
                        z = TinkerManager.loadLibraryFromTinker(eVar.u, "lib/" + b2, str);
                    }
                    if (!z) {
                        System.loadLibrary(str);
                    }
                    com.tencent.bugly.beta.global.a.a("LoadSoFileResult", true);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                com.tencent.bugly.beta.global.a.a("LoadSoFileResult", false);
                return;
            }
        }
        an.e("libName is invalid", new Object[0]);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static synchronized void onUpgradeReceived(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, int i6, long j4, String str7, boolean z, boolean z2, int i7, String str8, long j5) {
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i5));
            c.f8860a.a(z, z2, i7, new y(str, str2, j2, 0, new v(com.tencent.bugly.beta.global.e.G.w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "", ""), new u(str5, str4, "", j3, ""), (byte) i2, i6, j4, null, "", hashMap, str7, 1, j5, 1), str8 == null ? "" : str8);
        }
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        eVar.s = downloadListener2;
        if (eVar.s == null || (downloadTask = c.f8860a.f8862c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z) {
        synchronized (Beta.class) {
            try {
                y upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && z) {
                    com.tencent.bugly.beta.global.a.a("installApkMd5", upgradeStrategy.f9480f.f9444a);
                    p.f9423a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f9479e, upgradeStrategy.f9487m, upgradeStrategy.p, null));
                    an.a("安装事件保存成功", new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        y yVar;
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i5));
            y yVar2 = new y(str, str2, j2, 0, new v(com.tencent.bugly.beta.global.e.G.w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "1.4.5", ""), new u(str5, str4, "", j3, ""), (byte) i2, 0, 0L, null, "", hashMap, null, 1, System.currentTimeMillis(), 1);
            if (f8762a != null && !f8762a.getDownloadUrl().equals(str4)) {
                f8762a.delete(true);
                f8762a = null;
            }
            if (f8762a == null) {
                yVar = yVar2;
                f8762a = com.tencent.bugly.beta.global.e.G.r.a(yVar.f9480f.f9445b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, yVar.f9480f.f9444a);
                f8762a.setDownloadType(1);
            } else {
                yVar = yVar2;
            }
            f8762a.addListener(downloadListener2);
            h.v.a(yVar, f8762a);
            h.v.r = runnable;
            h.v.s = runnable2;
            f.f8804a.a(com.tencent.bugly.beta.global.e.G.r, yVar.f9486l);
            if (z) {
                f fVar = f.f8804a;
                Object[] objArr = new Object[2];
                objArr[0] = h.v;
                objArr[1] = Boolean.valueOf(yVar.f9481g == 2);
                fVar.a(new d(2, objArr), PathInterpolatorCompat.MAX_NUM_POINTS);
            } else {
                f fVar2 = f.f8804a;
                Object[] objArr2 = new Object[2];
                objArr2[0] = h.v;
                objArr2[1] = Boolean.valueOf(yVar.f9481g == 2);
                fVar2.a(new d(2, objArr2));
            }
        }
    }

    public static DownloadTask startDownload() {
        c cVar = c.f8860a;
        d dVar = cVar.f8868i;
        if (dVar == null || dVar.f8790b[0] != cVar.f8862c) {
            c cVar2 = c.f8860a;
            cVar2.f8868i = new d(13, cVar2.f8862c, cVar2.f8861b);
        }
        c.f8860a.f8868i.run();
        return c.f8860a.f8862c;
    }

    public static void unInit() {
        if (com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false)) {
            com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = c.f8860a.f8862c;
        if (downloadTask != null) {
            downloadTask.removeListener(com.tencent.bugly.beta.global.e.G.s);
        }
        com.tencent.bugly.beta.global.e.G.s = null;
    }

    @Override // com.tencent.bugly.a
    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    @Override // com.tencent.bugly.a
    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // com.tencent.bugly.a
    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        int i4;
        String str;
        String str2;
        Cursor cursor;
        String str3 = " , ";
        String str4 = bl.f10170d;
        int i5 = i2;
        int i6 = i3;
        while (i5 < i6) {
            if (i5 != 10) {
                i4 = i5;
                str = str3;
                str2 = str4;
            } else {
                try {
                    StringBuilder sb = new StringBuilder();
                    sb.setLength(0);
                    sb.append(" CREATE TABLE  IF NOT EXISTS ");
                    sb.append("st_1002");
                    sb.append(" ( ");
                    sb.append(str4);
                    sb.append(c.c.a.b.a.a.f3100g);
                    sb.append("integer");
                    sb.append(str3);
                    sb.append(bl.f10171e);
                    sb.append(c.c.a.b.a.a.f3100g);
                    sb.append("text");
                    sb.append(str3);
                    sb.append("_tm");
                    sb.append(c.c.a.b.a.a.f3100g);
                    sb.append("int");
                    sb.append(str3);
                    sb.append("_dt");
                    sb.append(c.c.a.b.a.a.f3100g);
                    sb.append("blob");
                    sb.append(",primary key(");
                    sb.append(str4);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(bl.f10171e);
                    sb.append(" )) ");
                    an.c("create %s", sb.toString());
                    sQLiteDatabase.execSQL(sb.toString());
                } catch (Throwable th) {
                    if (!an.b(th)) {
                        th.printStackTrace();
                    }
                }
                i4 = i5;
                str = str3;
                str2 = str4;
                try {
                    cursor = sQLiteDatabase.query("t_pf", null, "_id = 1002", null, null, null, null);
                } catch (Throwable th2) {
                    th = th2;
                    cursor = null;
                }
                if (cursor == null) {
                    if (cursor != null) {
                        return;
                    } else {
                        return;
                    }
                }
                while (cursor.moveToNext()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        if (cursor.getLong(cursor.getColumnIndex(str2)) > 0) {
                            contentValues.put(str2, Long.valueOf(cursor.getLong(cursor.getColumnIndex(str2))));
                        }
                        contentValues.put("_tm", Long.valueOf(cursor.getLong(cursor.getColumnIndex("_tm"))));
                        contentValues.put(bl.f10171e, cursor.getString(cursor.getColumnIndex(bl.f10171e)));
                        contentValues.put("_dt", cursor.getBlob(cursor.getColumnIndex("_dt")));
                        sQLiteDatabase.replace("st_1002", null, contentValues);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            if (!an.b(th)) {
                                th.printStackTrace();
                            }
                            if (cursor == null) {
                                i5 = i4 + 1;
                                i6 = i3;
                                str4 = str2;
                                str3 = str;
                            }
                            cursor.close();
                            i5 = i4 + 1;
                            i6 = i3;
                            str4 = str2;
                            str3 = str;
                        } finally {
                            if (cursor != null) {
                                cursor.close();
                            }
                        }
                    }
                }
                if (cursor == null) {
                }
                cursor.close();
            }
            i5 = i4 + 1;
            i6 = i3;
            str4 = str2;
            str3 = str;
        }
    }

    public static void checkAppUpgrade(boolean z, boolean z2) {
        a(z, z2, 1);
    }

    public static void checkUpgrade(boolean z, boolean z2) {
        a(z, z2, 0);
    }

    public static void installTinker(Object obj) {
        enableHotfix = true;
        TinkerManager.setPatchRestartOnScreenOff(setPatchRestartOnScreenOff);
        an.a("setPatchRestartOnScreenOff %s", setPatchRestartOnScreenOff + "");
        TinkerManager.installTinker(obj);
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerManager.TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        enableHotfix = true;
        TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
    }

    @Override // com.tencent.bugly.a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        com.tencent.bugly.crashreport.common.info.a.b().c("G10", "1.4.5");
        if (autoInit) {
            init(context, z);
        }
    }
}
