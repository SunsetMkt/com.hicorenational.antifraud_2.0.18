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
import com.tencent.bugly.AbstractC3071a;
import com.tencent.bugly.BuglyStrategy;
import com.tencent.bugly.beta.download.DownloadListener;
import com.tencent.bugly.beta.download.DownloadTask;
import com.tencent.bugly.beta.global.C3078a;
import com.tencent.bugly.beta.global.C3082e;
import com.tencent.bugly.beta.global.C3083f;
import com.tencent.bugly.beta.global.ResBean;
import com.tencent.bugly.beta.global.RunnableC3081d;
import com.tencent.bugly.beta.interfaces.BetaPatchListener;
import com.tencent.bugly.beta.p205ui.C3097h;
import com.tencent.bugly.beta.p205ui.UILifecycleListener;
import com.tencent.bugly.beta.tinker.TinkerApplicationLike;
import com.tencent.bugly.beta.tinker.TinkerManager;
import com.tencent.bugly.beta.upgrade.BetaGrayStrategy;
import com.tencent.bugly.beta.upgrade.C3100c;
import com.tencent.bugly.beta.upgrade.UpgradeListener;
import com.tencent.bugly.beta.upgrade.UpgradeStateListener;
import com.tencent.bugly.beta.utils.C3105e;
import com.tencent.bugly.crashreport.common.info.C3113a;
import com.tencent.bugly.proguard.C3140ac;
import com.tencent.bugly.proguard.C3150am;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.tencent.bugly.proguard.C3191p;
import com.tencent.bugly.proguard.C3192q;
import com.tencent.bugly.proguard.C3193r;
import com.tencent.bugly.proguard.C3194s;
import com.tencent.bugly.proguard.C3196u;
import com.tencent.bugly.proguard.C3197v;
import com.tencent.bugly.proguard.C3198w;
import com.tencent.bugly.proguard.C3200y;
import com.umeng.analytics.pro.C3355bl;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class Beta extends AbstractC3071a {
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

    /* renamed from: a */
    private static DownloadTask f9837a = null;

    /* renamed from: a */
    private static void m9314a(boolean z, boolean z2, int i2) {
        try {
            if (z) {
                C3100c.f10000a.m9382a(z, z2, i2);
                if (upgradeStateListener != null) {
                    C3105e.m9461a(new RunnableC3081d(18, upgradeStateListener, 2, Boolean.valueOf(z)));
                } else {
                    C3105e.m9461a(new RunnableC3081d(5, strToastCheckingUpgrade));
                }
            } else if (i2 == 0 || i2 == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) C3078a.m9326a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy != null && betaGrayStrategy.f9988a != null && System.currentTimeMillis() - betaGrayStrategy.f9992e <= C3082e.f9867G.f9901c) {
                    C3100c.f10000a.m9383a(z, z2, 0, null, "");
                }
                C3100c.f10000a.m9382a(z, z2, i2);
            } else if (i2 != 3) {
            } else {
                C3192q.f10776a.m10141a(z, z2, 3);
            }
        } catch (Exception e2) {
            if (C3151an.m9919b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() {
        if (new File(C3082e.f9867G.f9877J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(C3082e.f9867G.f9877J.getAbsolutePath(), true);
        } else {
            C3151an.m9920c(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:8:0x0023, code lost:
    
        if (((java.lang.Boolean) r1[2]).booleanValue() == com.tencent.bugly.beta.upgrade.C3100c.f10000a.f10006g) goto L11;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void cancelDownload() {
        /*
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.C3100c.f10000a
            com.tencent.bugly.beta.global.d r1 = r0.f10009j
            r2 = 2
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L25
            java.lang.Object[] r1 = r1.f9866b
            r5 = r1[r4]
            com.tencent.bugly.beta.download.DownloadTask r6 = r0.f10002c
            if (r5 != r6) goto L25
            r5 = r1[r3]
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r0 = r0.f10001b
            if (r5 != r0) goto L25
            r0 = r1[r2]
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            com.tencent.bugly.beta.upgrade.c r1 = com.tencent.bugly.beta.upgrade.C3100c.f10000a
            boolean r1 = r1.f10006g
            if (r0 == r1) goto L43
        L25:
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.C3100c.f10000a
            com.tencent.bugly.beta.global.d r1 = new com.tencent.bugly.beta.global.d
            r5 = 14
            r6 = 3
            java.lang.Object[] r6 = new java.lang.Object[r6]
            com.tencent.bugly.beta.download.DownloadTask r7 = r0.f10002c
            r6[r4] = r7
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r4 = r0.f10001b
            r6[r3] = r4
            boolean r3 = r0.f10006g
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            r6[r2] = r3
            r1.<init>(r5, r6)
            r0.f10009j = r1
        L43:
            com.tencent.bugly.beta.upgrade.c r0 = com.tencent.bugly.beta.upgrade.C3100c.f10000a
            com.tencent.bugly.beta.global.d r0 = r0.f10009j
            r0.run()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.cancelDownload():void");
    }

    public static void checkAppUpgrade() {
        m9314a(true, false, 1);
    }

    public static void checkHotFix() {
        m9314a(false, false, 3);
    }

    public static void checkUpgrade() {
        checkUpgrade(true, false);
    }

    public static void cleanTinkerPatch(boolean z) {
        C3078a.m9330a("IS_PATCH_ROLL_BACK", false);
        TinkerManager.getInstance().cleanPatch(z);
    }

    public static void downloadPatch() {
        C3192q c3192q = C3192q.f10776a;
        c3192q.f10777b = c3192q.m10139a((C3200y) null);
        try {
            if (C3192q.f10776a.f10777b != null) {
                C3192q.f10776a.m10140a(0, C3192q.f10776a.f10777b.f9988a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            C3100c.f10000a.f10001b = (BetaGrayStrategy) C3078a.m9326a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (C3100c.f10000a.f10001b != null) {
                return new UpgradeInfo(C3100c.f10000a.f10001b.f9988a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            C3192q.f10776a.f10777b = (BetaGrayStrategy) C3078a.m9326a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (C3192q.f10776a.f10777b != null) {
                return new UpgradeInfo(C3192q.f10776a.f10777b.f9988a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static Beta getInstance() {
        Beta beta = instance;
        beta.f9831id = 1002;
        beta.version = "1.4.5";
        beta.versionKey = "G10";
        return beta;
    }

    public static DownloadTask getStrategyTask() {
        if (f9837a == null) {
            C3100c.f10000a.f10001b = (BetaGrayStrategy) C3078a.m9326a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (C3100c.f10000a.f10001b != null) {
                f9837a = C3082e.f9867G.f9916r.mo9315a(C3100c.f10000a.f10001b.f9988a.f10837f.f10797b, C3082e.f9867G.f9920v.getAbsolutePath(), null, C3100c.f10000a.f10001b.f9988a.f10837f.f10796a);
                f9837a.setDownloadType(1);
                C3100c.f10000a.f10002c = f9837a;
            }
        }
        return C3100c.f10000a.f10002c;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0044, code lost:
    
        return new com.tencent.bugly.beta.UpgradeInfo(r1.f9988a);
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
            android.os.Parcelable r1 = com.tencent.bugly.beta.global.C3078a.m9326a(r1, r2)     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r1 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r1     // Catch: java.lang.Exception -> L45
            java.lang.String r2 = "app.upgrade.strategy.bch"
            android.os.Parcelable$Creator<com.tencent.bugly.beta.upgrade.BetaGrayStrategy> r3 = com.tencent.bugly.beta.upgrade.BetaGrayStrategy.CREATOR     // Catch: java.lang.Exception -> L45
            android.os.Parcelable r2 = com.tencent.bugly.beta.global.C3078a.m9326a(r2, r3)     // Catch: java.lang.Exception -> L45
            com.tencent.bugly.beta.upgrade.BetaGrayStrategy r2 = (com.tencent.bugly.beta.upgrade.BetaGrayStrategy) r2     // Catch: java.lang.Exception -> L45
            if (r1 == 0) goto L2a
            com.tencent.bugly.proguard.y r3 = r1.f9988a     // Catch: java.lang.Exception -> L45
            if (r3 == 0) goto L2a
            if (r2 == 0) goto L2a
            com.tencent.bugly.proguard.y r3 = r2.f9988a     // Catch: java.lang.Exception -> L45
            if (r3 == 0) goto L2a
            long r3 = r1.f9992e     // Catch: java.lang.Exception -> L45
            long r5 = r2.f9992e     // Catch: java.lang.Exception -> L45
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 <= 0) goto L3a
            goto L3b
        L2a:
            if (r1 == 0) goto L3a
            com.tencent.bugly.proguard.y r3 = r1.f9988a     // Catch: java.lang.Exception -> L45
            if (r3 != 0) goto L31
            goto L3a
        L31:
            if (r2 == 0) goto L3b
            com.tencent.bugly.proguard.y r2 = r2.f9988a     // Catch: java.lang.Exception -> L45
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
            com.tencent.bugly.proguard.y r1 = r1.f9988a     // Catch: java.lang.Exception -> L45
            r2.<init>(r1)     // Catch: java.lang.Exception -> L45
            return r2
        L45:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.bugly.beta.Beta.getUpgradeInfo():com.tencent.bugly.beta.UpgradeInfo");
    }

    public static synchronized C3200y getUpgradeStrategy() {
        synchronized (Beta.class) {
            C3100c.f10000a.f10001b = (BetaGrayStrategy) C3078a.m9326a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            try {
                if (C3100c.f10000a.f10001b != null) {
                    return (C3200y) C3100c.f10000a.f10001b.f9988a.clone();
                }
            } catch (Exception unused) {
            }
            return null;
        }
    }

    public static synchronized void init(Context context, boolean z) {
        synchronized (Beta.class) {
            C3151an.m9915a("Beta init start....", new Object[0]);
            C3140ac m9797a = C3140ac.m9797a();
            int i2 = instance.f9831id;
            int i3 = C3082e.f9868a + 1;
            C3082e.f9868a = i3;
            m9797a.m9808a(i2, i3);
            if (TextUtils.isEmpty(initProcessName)) {
                initProcessName = context.getPackageName();
            }
            C3151an.m9915a("Beta will init at: %s", initProcessName);
            String str = C3113a.m9532b().f10197e;
            C3151an.m9915a("current process: %s", str);
            if (TextUtils.equals(initProcessName, str)) {
                C3082e c3082e = C3082e.f9867G;
                if (!TextUtils.isEmpty(c3082e.f9922x)) {
                    C3151an.m9922d("Beta has been initialized [apkMD5 : %s]", c3082e.f9922x);
                    return;
                }
                C3151an.m9915a("current upgrade sdk version:1.4.5", new Object[0]);
                c3082e.f9874F = z;
                if (upgradeCheckPeriod < 0) {
                    C3151an.m9922d("upgradeCheckPeriod cannot be negative", new Object[0]);
                } else {
                    c3082e.f9901c = upgradeCheckPeriod;
                    C3151an.m9915a("setted upgradeCheckPeriod: %d", Long.valueOf(upgradeCheckPeriod));
                }
                if (initDelay < 0) {
                    C3151an.m9922d("initDelay cannot be negative", new Object[0]);
                } else {
                    c3082e.f9900b = initDelay;
                    C3151an.m9915a("setted initDelay: %d", Long.valueOf(initDelay));
                }
                if (smallIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(smallIconId) != null) {
                            c3082e.f9906h = smallIconId;
                            C3151an.m9915a("setted smallIconId: %d", Integer.valueOf(smallIconId));
                        }
                    } catch (Exception e2) {
                        C3151an.m9923e("smallIconId is not available:\n %s", e2.toString());
                    }
                }
                if (largeIconId != 0) {
                    try {
                        if (context.getResources().getDrawable(largeIconId) != null) {
                            c3082e.f9907i = largeIconId;
                            C3151an.m9915a("setted largeIconId: %d", Integer.valueOf(largeIconId));
                        }
                    } catch (Exception e3) {
                        C3151an.m9923e("largeIconId is not available:\n %s", e3.toString());
                    }
                }
                if (defaultBannerId != 0) {
                    try {
                        if (context.getResources().getDrawable(defaultBannerId) != null) {
                            c3082e.f9908j = defaultBannerId;
                            C3151an.m9915a("setted defaultBannerId: %d", Integer.valueOf(defaultBannerId));
                        }
                    } catch (Exception e4) {
                        C3151an.m9923e("defaultBannerId is not available:\n %s", e4.toString());
                    }
                }
                if (upgradeDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout = context.getResources().getLayout(upgradeDialogLayoutId);
                        if (layout != null) {
                            c3082e.f9909k = upgradeDialogLayoutId;
                            C3151an.m9915a("setted upgradeDialogLayoutId: %d", Integer.valueOf(upgradeDialogLayoutId));
                            layout.close();
                        }
                    } catch (Exception e5) {
                        C3151an.m9923e("upgradeDialogLayoutId is not available:\n %s", e5.toString());
                    }
                }
                if (tipsDialogLayoutId != 0) {
                    try {
                        XmlResourceParser layout2 = context.getResources().getLayout(tipsDialogLayoutId);
                        if (layout2 != null) {
                            c3082e.f9910l = tipsDialogLayoutId;
                            C3151an.m9915a("setted tipsDialogLayoutId: %d", Integer.valueOf(tipsDialogLayoutId));
                            layout2.close();
                        }
                    } catch (Exception e6) {
                        C3151an.m9923e("tipsDialogLayoutId is not available:\n %s", e6.toString());
                    }
                }
                if (upgradeDialogLifecycleListener != null) {
                    try {
                        c3082e.f9911m = upgradeDialogLifecycleListener;
                        C3151an.m9915a("setted upgradeDialogLifecycleListener:%s" + upgradeDialogLifecycleListener, new Object[0]);
                    } catch (Exception e7) {
                        C3151an.m9923e("upgradeDialogLifecycleListener is not available:\n %", e7.toString());
                    }
                }
                if (canShowUpgradeActs != null && !canShowUpgradeActs.isEmpty()) {
                    for (Class<? extends Activity> cls : canShowUpgradeActs) {
                        if (cls != null) {
                            c3082e.f9913o.add(cls);
                        }
                    }
                    C3151an.m9915a("setted canShowUpgradeActs: %s", c3082e.f9913o);
                }
                if (canNotShowUpgradeActs != null && !canNotShowUpgradeActs.isEmpty()) {
                    for (Class<? extends Activity> cls2 : canNotShowUpgradeActs) {
                        if (cls2 != null) {
                            c3082e.f9914p.add(cls2);
                        }
                    }
                    C3151an.m9915a("setted canNotShowUpgradeActs: %s", c3082e.f9914p);
                }
                c3082e.f9902d = autoCheckUpgrade;
                c3082e.f9903e = autoCheckAppUpgrade;
                c3082e.f9904f = autoCheckHotfix;
                Object[] objArr = new Object[1];
                objArr[0] = c3082e.f9902d ? "is opened" : "is closed";
                C3151an.m9915a("autoCheckUpgrade %s", objArr);
                Object[] objArr2 = new Object[1];
                objArr2[0] = c3082e.f9903e ? "is opened" : "is closed";
                C3151an.m9915a("autoCheckAppUpgrade %s", objArr2);
                Object[] objArr3 = new Object[1];
                objArr3[0] = c3082e.f9904f ? "is opened" : "is closed";
                C3151an.m9915a("autoCheckHotfix %s", objArr3);
                c3082e.f9899af = autoInstallApk;
                Object[] objArr4 = new Object[1];
                objArr4[0] = c3082e.f9899af ? "is opened" : "is closed";
                C3151an.m9915a("autoInstallApk %s", objArr4);
                c3082e.f9889V = autoDownloadOn4g;
                Object[] objArr5 = new Object[1];
                objArr5[0] = c3082e.f9889V ? "is opened" : "is closed";
                C3151an.m9915a("autoDownloadOn4g %s", objArr5);
                c3082e.f9905g = showInterruptedStrategy;
                Object[] objArr6 = new Object[1];
                objArr6[0] = c3082e.f9905g ? "is opened" : "is closed";
                C3151an.m9915a("showInterruptedStrategy %s", objArr6);
                Object[] objArr7 = new Object[1];
                objArr7[0] = upgradeListener != null ? "is opened" : "is closed";
                C3151an.m9915a("isDIY %s", objArr7);
                if (storageDir != null) {
                    if (storageDir.exists() || storageDir.mkdirs()) {
                        c3082e.f9912n = storageDir;
                        C3151an.m9915a("setted storageDir: %s", storageDir.getAbsolutePath());
                    } else {
                        C3151an.m9915a("storageDir is not exists: %s", storageDir.getAbsolutePath());
                    }
                }
                if (c3082e.f9916r == null) {
                    c3082e.f9916r = C3194s.f10788a;
                }
                if (TextUtils.isEmpty(c3082e.f9921w)) {
                    c3082e.f9921w = C3113a.m9532b().m9571f();
                }
                c3082e.f9887T = enableNotification;
                C3151an.m9915a("enableNotification %s", enableNotification + "");
                c3082e.f9888U = autoDownloadOnWifi;
                C3151an.m9915a("autoDownloadOnWifi %s", autoDownloadOnWifi + "");
                c3082e.f9890W = canShowApkInfo;
                C3151an.m9915a("canShowApkInfo %s", canShowApkInfo + "");
                c3082e.f9891X = canAutoPatch;
                C3151an.m9915a("canAutoPatch %s", canAutoPatch + "");
                c3082e.f9892Y = betaPatchListener;
                c3082e.f9924z = appVersionName;
                c3082e.f9923y = appVersionCode;
                c3082e.f9893Z = canNotifyUserRestart;
                C3151an.m9915a("canNotifyUserRestart %s", canNotifyUserRestart + "");
                c3082e.f9894aa = canAutoDownloadPatch;
                C3151an.m9915a("canAutoDownloadPatch %s", canAutoDownloadPatch + "");
                c3082e.f9895ab = enableHotfix;
                C3151an.m9915a("enableHotfix %s", enableHotfix + "");
                if (soBlackList != null && !soBlackList.isEmpty()) {
                    for (String str2 : soBlackList) {
                        if (str2 != null) {
                            c3082e.f9896ac.add(str2);
                        }
                    }
                    C3151an.m9915a("setted soBlackList: %s", c3082e.f9896ac);
                }
                if (appChannel != null) {
                    c3082e.f9885R = appChannel;
                    C3151an.m9915a("Beta channel %s", appChannel);
                }
                c3082e.m9339a(context);
                ResBean.f9856a = (ResBean) C3078a.m9326a("rb.bch", ResBean.CREATOR);
                if (ResBean.f9856a == null) {
                    ResBean.f9856a = new ResBean();
                }
                C3100c.f10000a.f10004e = upgradeListener;
                C3100c.f10000a.f10005f = upgradeStateListener;
                C3100c.f10000a.f10003d = downloadListener;
                if (getStrategyTask() != null && downloadListener != null) {
                    getStrategyTask().addListener(C3100c.f10000a.f10003d);
                }
                if (enableHotfix) {
                    C3151an.m9915a("enableHotfix %s", "1");
                    C3154aq.m9986b("D4", "1");
                    C3193r.m10142a(context);
                }
                Resources resources = context.getResources();
                DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                Configuration configuration = resources.getConfiguration();
                configuration.locale = Locale.getDefault();
                if (configuration.locale.equals(Locale.US) || configuration.locale.equals(Locale.ENGLISH)) {
                    strToastYourAreTheLatestVersion = context.getResources().getString(C3073R.string.strToastYourAreTheLatestVersion);
                    strToastCheckUpgradeError = context.getResources().getString(C3073R.string.strToastCheckUpgradeError);
                    strToastCheckingUpgrade = context.getResources().getString(C3073R.string.strToastCheckingUpgrade);
                    strNotificationDownloading = context.getResources().getString(C3073R.string.strNotificationDownloading);
                    strNotificationClickToView = context.getResources().getString(C3073R.string.strNotificationClickToView);
                    strNotificationClickToInstall = context.getResources().getString(C3073R.string.strNotificationClickToInstall);
                    strNotificationClickToContinue = context.getResources().getString(C3073R.string.strNotificationClickToContinue);
                    strNotificationClickToRetry = context.getResources().getString(C3073R.string.strNotificationClickToRetry);
                    strNotificationDownloadSucc = context.getResources().getString(C3073R.string.strNotificationDownloadSucc);
                    strNotificationDownloadError = context.getResources().getString(C3073R.string.strNotificationDownloadError);
                    strNotificationHaveNewVersion = context.getResources().getString(C3073R.string.strNotificationHaveNewVersion);
                    strNetworkTipsMessage = context.getResources().getString(C3073R.string.strNetworkTipsMessage);
                    strNetworkTipsTitle = context.getResources().getString(C3073R.string.strNetworkTipsTitle);
                    strNetworkTipsConfirmBtn = context.getResources().getString(C3073R.string.strNetworkTipsConfirmBtn);
                    strNetworkTipsCancelBtn = context.getResources().getString(C3073R.string.strNetworkTipsCancelBtn);
                    strUpgradeDialogVersionLabel = context.getResources().getString(C3073R.string.strUpgradeDialogVersionLabel);
                    strUpgradeDialogFileSizeLabel = context.getResources().getString(C3073R.string.strUpgradeDialogFileSizeLabel);
                    strUpgradeDialogUpdateTimeLabel = context.getResources().getString(C3073R.string.strUpgradeDialogUpdateTimeLabel);
                    strUpgradeDialogFeatureLabel = context.getResources().getString(C3073R.string.strUpgradeDialogFeatureLabel);
                    strUpgradeDialogUpgradeBtn = context.getResources().getString(C3073R.string.strUpgradeDialogUpgradeBtn);
                    strUpgradeDialogInstallBtn = context.getResources().getString(C3073R.string.strUpgradeDialogInstallBtn);
                    strUpgradeDialogRetryBtn = context.getResources().getString(C3073R.string.strUpgradeDialogRetryBtn);
                    strUpgradeDialogContinueBtn = context.getResources().getString(C3073R.string.strUpgradeDialogContinueBtn);
                    strUpgradeDialogCancelBtn = context.getResources().getString(C3073R.string.strUpgradeDialogCancelBtn);
                }
                resources.updateConfiguration(configuration, displayMetrics);
                C3150am.m9906a().m9909a(new RunnableC3081d(1, new Object[0]), c3082e.f9900b);
                C3140ac m9797a2 = C3140ac.m9797a();
                int i4 = instance.f9831id;
                int i5 = C3082e.f9868a - 1;
                C3082e.f9868a = i5;
                m9797a2.m9808a(i4, i5);
                C3151an.m9915a("Beta init finished...", new Object[0]);
            }
        }
    }

    public static synchronized void installApk(File file) {
        synchronized (Beta.class) {
            try {
                C3200y upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && C3078a.m9331a(C3082e.f9867G.f9919u, file, upgradeStrategy.f10837f.f10796a)) {
                    C3191p.f10775a.m10131a(new C3198w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f10836e, upgradeStrategy.f10844m, upgradeStrategy.f10847p, null));
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
        C3082e c3082e = C3082e.f9867G;
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    if (!C3078a.m9338b("LoadSoFileResult", true)) {
                        System.loadLibrary(str);
                        C3078a.m9330a("IS_PATCH_ROLL_BACK", true);
                        cleanTinkerPatch(true);
                        return;
                    }
                    C3078a.m9330a("LoadSoFileResult", false);
                    String m9337b = C3078a.m9337b(str, "");
                    boolean m9338b = C3078a.m9338b("PatchResult", false);
                    if (TextUtils.isEmpty(m9337b) || !m9338b) {
                        z = false;
                    } else {
                        z = TinkerManager.loadLibraryFromTinker(c3082e.f9919u, "lib/" + m9337b, str);
                    }
                    if (!z) {
                        System.loadLibrary(str);
                    }
                    C3078a.m9330a("LoadSoFileResult", true);
                    return;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
                C3078a.m9330a("LoadSoFileResult", false);
                return;
            }
        }
        C3151an.m9923e("libName is invalid", new Object[0]);
    }

    public static void loadLibraryFromTinker(Context context, String str, String str2) {
        TinkerManager.loadLibraryFromTinker(context, str, str2);
    }

    public static synchronized void onUpgradeReceived(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, int i6, long j4, String str7, boolean z, boolean z2, int i7, String str8, long j5) {
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i5));
            C3100c.f10000a.m9383a(z, z2, i7, new C3200y(str, str2, j2, 0, new C3197v(C3082e.f9867G.f9921w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "", ""), new C3196u(str5, str4, "", j3, ""), (byte) i2, i6, j4, null, "", hashMap, str7, 1, j5, 1), str8 == null ? "" : str8);
        }
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        C3082e c3082e = C3082e.f9867G;
        c3082e.f9917s = downloadListener2;
        if (c3082e.f9917s == null || (downloadTask = C3100c.f10000a.f10002c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z) {
        synchronized (Beta.class) {
            try {
                C3200y upgradeStrategy = getUpgradeStrategy();
                if (upgradeStrategy != null && z) {
                    C3078a.m9329a("installApkMd5", upgradeStrategy.f10837f.f10796a);
                    C3191p.f10775a.m10131a(new C3198w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f10836e, upgradeStrategy.f10844m, upgradeStrategy.f10847p, null));
                    C3151an.m9915a("安装事件保存成功", new Object[0]);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        C3200y c3200y;
        synchronized (Beta.class) {
            HashMap hashMap = new HashMap();
            hashMap.put("IMG_title", str6);
            hashMap.put("VAL_style", String.valueOf(i5));
            C3200y c3200y2 = new C3200y(str, str2, j2, 0, new C3197v(C3082e.f9867G.f9921w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "1.4.5", ""), new C3196u(str5, str4, "", j3, ""), (byte) i2, 0, 0L, null, "", hashMap, null, 1, System.currentTimeMillis(), 1);
            if (f9837a != null && !f9837a.getDownloadUrl().equals(str4)) {
                f9837a.delete(true);
                f9837a = null;
            }
            if (f9837a == null) {
                c3200y = c3200y2;
                f9837a = C3082e.f9867G.f9916r.mo9315a(c3200y.f10837f.f10797b, C3082e.f9867G.f9920v.getAbsolutePath(), null, c3200y.f10837f.f10796a);
                f9837a.setDownloadType(1);
            } else {
                c3200y = c3200y2;
            }
            f9837a.addListener(downloadListener2);
            C3097h.f9972v.m9364a(c3200y, f9837a);
            C3097h.f9972v.f9980r = runnable;
            C3097h.f9972v.f9981s = runnable2;
            C3083f.f9925a.m9341a(C3082e.f9867G.f9916r, c3200y.f10843l);
            if (z) {
                C3083f c3083f = C3083f.f9925a;
                Object[] objArr = new Object[2];
                objArr[0] = C3097h.f9972v;
                objArr[1] = Boolean.valueOf(c3200y.f10838g == 2);
                c3083f.m9343a(new RunnableC3081d(2, objArr), PathInterpolatorCompat.MAX_NUM_POINTS);
            } else {
                C3083f c3083f2 = C3083f.f9925a;
                Object[] objArr2 = new Object[2];
                objArr2[0] = C3097h.f9972v;
                objArr2[1] = Boolean.valueOf(c3200y.f10838g == 2);
                c3083f2.m9342a(new RunnableC3081d(2, objArr2));
            }
        }
    }

    public static DownloadTask startDownload() {
        C3100c c3100c = C3100c.f10000a;
        RunnableC3081d runnableC3081d = c3100c.f10008i;
        if (runnableC3081d == null || runnableC3081d.f9866b[0] != c3100c.f10002c) {
            C3100c c3100c2 = C3100c.f10000a;
            c3100c2.f10008i = new RunnableC3081d(13, c3100c2.f10002c, c3100c2.f10001b);
        }
        C3100c.f10000a.f10008i.run();
        return C3100c.f10000a.f10002c;
    }

    public static void unInit() {
        if (C3078a.m9338b("IS_PATCH_ROLL_BACK", false)) {
            C3078a.m9330a("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = C3100c.f10000a.f10002c;
        if (downloadTask != null) {
            downloadTask.removeListener(C3082e.f9867G.f9917s);
        }
        C3082e.f9867G.f9917s = null;
    }

    @Override // com.tencent.bugly.AbstractC3071a
    public String[] getTables() {
        return new String[]{"dl_1002", "ge_1002", "st_1002"};
    }

    @Override // com.tencent.bugly.AbstractC3071a
    public void onDbDowngrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
    }

    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // com.tencent.bugly.AbstractC3071a
    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        int i4;
        String str;
        String str2;
        Cursor cursor;
        String str3 = " , ";
        String str4 = C3355bl.f11732d;
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
                    sb.append(AbstractC1191a.f2568g);
                    sb.append("integer");
                    sb.append(str3);
                    sb.append(C3355bl.f11733e);
                    sb.append(AbstractC1191a.f2568g);
                    sb.append("text");
                    sb.append(str3);
                    sb.append("_tm");
                    sb.append(AbstractC1191a.f2568g);
                    sb.append("int");
                    sb.append(str3);
                    sb.append("_dt");
                    sb.append(AbstractC1191a.f2568g);
                    sb.append("blob");
                    sb.append(",primary key(");
                    sb.append(str4);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(C3355bl.f11733e);
                    sb.append(" )) ");
                    C3151an.m9921c("create %s", sb.toString());
                    sQLiteDatabase.execSQL(sb.toString());
                } catch (Throwable th) {
                    if (!C3151an.m9919b(th)) {
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
                        contentValues.put(C3355bl.f11733e, cursor.getString(cursor.getColumnIndex(C3355bl.f11733e)));
                        contentValues.put("_dt", cursor.getBlob(cursor.getColumnIndex("_dt")));
                        sQLiteDatabase.replace("st_1002", null, contentValues);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            if (!C3151an.m9919b(th)) {
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
        m9314a(z, z2, 1);
    }

    public static void checkUpgrade(boolean z, boolean z2) {
        m9314a(z, z2, 0);
    }

    public static void installTinker(Object obj) {
        enableHotfix = true;
        TinkerManager.setPatchRestartOnScreenOff(setPatchRestartOnScreenOff);
        C3151an.m9915a("setPatchRestartOnScreenOff %s", setPatchRestartOnScreenOff + "");
        TinkerManager.installTinker(obj);
    }

    public static void installTinker(Object obj, Object obj2, Object obj3, Object obj4, TinkerManager.TinkerPatchResultListener tinkerPatchResultListener, Object obj5) {
        enableHotfix = true;
        TinkerManager.installTinker(obj, obj2, obj3, obj4, tinkerPatchResultListener, obj5);
    }

    @Override // com.tencent.bugly.AbstractC3071a
    public synchronized void init(Context context, boolean z, BuglyStrategy buglyStrategy) {
        C3113a.m9532b().m9566c("G10", "1.4.5");
        if (autoInit) {
            init(context, z);
        }
    }
}
