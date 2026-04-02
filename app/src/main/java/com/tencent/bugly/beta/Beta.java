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

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
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
    public static String strNetworkTipsCancelBtn = "\u53d6\u6d88";
    public static String strNetworkTipsConfirmBtn = "\u7ee7\u7eed\u4e0b\u8f7d";
    public static String strNetworkTipsMessage = "\u4f60\u5df2\u5207\u6362\u5230\u79fb\u52a8\u7f51\u7edc\uff0c\u662f\u5426\u7ee7\u7eed\u5f53\u524d\u4e0b\u8f7d\uff1f";
    public static String strNetworkTipsTitle = "\u7f51\u7edc\u63d0\u793a";
    public static String strNotificationClickToContinue = "\u7ee7\u7eed\u4e0b\u8f7d";
    public static String strNotificationClickToInstall = "\u70b9\u51fb\u5b89\u88c5";
    public static String strNotificationClickToRetry = "\u70b9\u51fb\u91cd\u8bd5";
    public static String strNotificationClickToView = "\u70b9\u51fb\u67e5\u770b";
    public static String strNotificationDownloadError = "\u4e0b\u8f7d\u5931\u8d25";
    public static String strNotificationDownloadSucc = "\u4e0b\u8f7d\u5b8c\u6210";
    public static String strNotificationDownloading = "\u6b63\u5728\u4e0b\u8f7d";
    public static String strNotificationHaveNewVersion = "\u6709\u65b0\u7248\u672c";
    public static String strToastCheckUpgradeError = "\u68c0\u67e5\u65b0\u7248\u672c\u5931\u8d25\uff0c\u8bf7\u7a0d\u540e\u91cd\u8bd5";
    public static String strToastCheckingUpgrade = "\u6b63\u5728\u68c0\u67e5\uff0c\u8bf7\u7a0d\u5019...";
    public static String strToastYourAreTheLatestVersion = "\u4f60\u5df2\u7ecf\u662f\u6700\u65b0\u7248\u4e86";
    public static String strUpgradeDialogCancelBtn = "\u4e0b\u6b21\u518d\u8bf4";
    public static String strUpgradeDialogContinueBtn = "\u7ee7\u7eed";
    public static String strUpgradeDialogFeatureLabel = "\u66f4\u65b0\u8bf4\u660e";
    public static String strUpgradeDialogFileSizeLabel = "\u5305\u5927\u5c0f";
    public static String strUpgradeDialogInstallBtn = "\u5b89\u88c5";
    public static String strUpgradeDialogRetryBtn = "\u91cd\u8bd5";
    public static String strUpgradeDialogUpdateTimeLabel = "\u66f4\u65b0\u65f6\u95f4";
    public static String strUpgradeDialogUpgradeBtn = "\u7acb\u5373\u66f4\u65b0";
    public static String strUpgradeDialogVersionLabel = "\u7248\u672c";
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
    private static DownloadTask a = null;

    private static void a(boolean z, boolean z2, int i2) {
        try {
            if (z) {
                c.a.a(z, z2, i2);
                if (upgradeStateListener != null) {
                    e.a(new d(18, upgradeStateListener, 2, Boolean.valueOf(z)));
                } else {
                    e.a(new d(5, strToastCheckingUpgrade));
                }
            } else if (i2 == 0 || i2 == 1) {
                BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
                if (betaGrayStrategy == null || betaGrayStrategy.a == null || System.currentTimeMillis() - betaGrayStrategy.f6073e > com.tencent.bugly.beta.global.e.G.f6019c) {
                    c.a.a(z, z2, i2);
                } else {
                    c.a.a(z, z2, 0, null, "");
                }
            } else if (i2 != 3) {
            } else {
                q.a.a(z, z2, 3);
            }
        } catch (Exception e2) {
            if (an.b(e2)) {
                return;
            }
            e2.printStackTrace();
        }
    }

    public static void applyDownloadedPatch() throws Throwable {
        if (new File(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath()).exists()) {
            TinkerManager.getInstance().applyPatch(com.tencent.bugly.beta.global.e.G.J.getAbsolutePath(), true);
        } else {
            an.c(Beta.class, "[applyDownloadedPatch] patch file not exist", new Object[0]);
        }
    }

    public static void applyTinkerPatch(Context context, String str) {
        TinkerManager.getInstance().applyPatch(context, str);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0025  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void cancelDownload() {
        c cVar = c.a;
        d dVar = cVar.f6086j;
        if (dVar != null) {
            Object[] objArr = dVar.f6017b;
            if (objArr[0] != cVar.f6079c || objArr[1] != cVar.f6078b || ((Boolean) objArr[2]).booleanValue() != c.a.f6083g) {
                c cVar2 = c.a;
                cVar2.f6086j = new d(14, cVar2.f6079c, cVar2.f6078b, Boolean.valueOf(cVar2.f6083g));
            }
        }
        c.a.f6086j.run();
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
        q qVar = q.a;
        qVar.f6553b = qVar.a((y) null);
        try {
            if (q.a.f6553b != null) {
                q.a.a(0, q.a.f6553b.a, true);
            }
        } catch (Exception unused) {
        }
    }

    public static UpgradeInfo getAppUpgradeInfo() {
        try {
            c.a.f6078b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (c.a.f6078b != null) {
                return new UpgradeInfo(c.a.f6078b.a);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public static UpgradeInfo getHotfixUpgradeInfo() {
        try {
            q.a.f6553b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            if (q.a.f6553b != null) {
                return new UpgradeInfo(q.a.f6553b.a);
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
        if (a == null) {
            c.a.f6078b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (c.a.f6078b != null) {
                a = com.tencent.bugly.beta.global.e.G.r.a(c.a.f6078b.a.f6599f.f6568b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, c.a.f6078b.a.f6599f.a);
                a.setDownloadType(1);
                c.a.f6079c = a;
            }
        }
        return c.a.f6079c;
    }

    /* JADX WARN: Removed duplicated region for block: B:52:0x003a  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x003d A[Catch: Exception -> 0x0045, TRY_LEAVE, TryCatch #0 {Exception -> 0x0045, blocks: (B:33:0x0001, B:35:0x0017, B:38:0x001d, B:40:0x0021, B:54:0x003d, B:44:0x002c, B:48:0x0033), top: B:58:0x0001 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static UpgradeInfo getUpgradeInfo() {
        try {
            BetaGrayStrategy betaGrayStrategy = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("hotfix.strategy.bch", BetaGrayStrategy.CREATOR);
            BetaGrayStrategy betaGrayStrategy2 = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
            if (betaGrayStrategy == null || betaGrayStrategy.a == null || betaGrayStrategy2 == null || betaGrayStrategy2.a == null) {
                if (betaGrayStrategy == null || betaGrayStrategy.a == null) {
                    betaGrayStrategy = betaGrayStrategy2;
                } else if (betaGrayStrategy2 != null && betaGrayStrategy2.a != null) {
                    betaGrayStrategy = null;
                }
                if (betaGrayStrategy != null) {
                    return new UpgradeInfo(betaGrayStrategy.a);
                }
            } else {
                if (betaGrayStrategy.f6073e > betaGrayStrategy2.f6073e) {
                }
                if (betaGrayStrategy != null) {
                }
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static synchronized y getUpgradeStrategy() {
        c.a.f6078b = (BetaGrayStrategy) com.tencent.bugly.beta.global.a.a("app.upgrade.strategy.bch", BetaGrayStrategy.CREATOR);
        try {
            if (c.a.f6078b != null) {
                return (y) c.a.f6078b.a.clone();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:230:0x00e4 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0116 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0148 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:254:0x017d A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:262:0x01b2 A[Catch: all -> 0x0626, TRY_LEAVE, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:275:0x01f9 A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:286:0x022a A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x025a  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0269  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x026c  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x027b  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0291  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:309:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:320:0x02dd A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:328:0x0314 A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:331:0x0320 A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:339:0x042e A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:345:0x044b A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:348:0x046d A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:356:0x049f A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:361:0x04da A[Catch: all -> 0x0626, TryCatch #2 {, blocks: (B:202:0x0003, B:204:0x0024, B:205:0x002a, B:209:0x004e, B:211:0x0058, B:214:0x0065, B:216:0x0076, B:218:0x0091, B:220:0x0097, B:222:0x00b2, B:224:0x00b6, B:226:0x00c2, B:230:0x00e4, B:232:0x00e8, B:234:0x00f4, B:238:0x0116, B:240:0x011a, B:242:0x0126, B:246:0x0148, B:248:0x014c, B:250:0x0158, B:254:0x017d, B:256:0x0181, B:258:0x018d, B:262:0x01b2, B:264:0x01b6, B:268:0x01e1, B:270:0x01e5, B:272:0x01ed, B:273:0x01f3, B:275:0x01f9, B:277:0x0201, B:278:0x0207, B:279:0x0212, B:281:0x0216, B:283:0x021e, B:284:0x0224, B:286:0x022a, B:288:0x0232, B:289:0x0238, B:290:0x0243, B:294:0x025c, B:298:0x026e, B:302:0x0280, B:306:0x0296, B:310:0x02ac, B:314:0x02c2, B:318:0x02d4, B:320:0x02dd, B:322:0x02e5, B:324:0x02ed, B:325:0x02fd, B:326:0x0310, B:328:0x0314, B:329:0x0318, B:331:0x0320, B:332:0x032a, B:334:0x041a, B:336:0x0422, B:337:0x0428, B:339:0x042e, B:341:0x0436, B:342:0x043c, B:343:0x0447, B:345:0x044b, B:346:0x045a, B:348:0x046d, B:349:0x0474, B:351:0x048c, B:353:0x0490, B:354:0x049b, B:356:0x049f, B:357:0x04b4, B:359:0x04d0, B:362:0x05fa, B:361:0x04da, B:267:0x01d4, B:261:0x01a5, B:253:0x0170, B:245:0x013b, B:237:0x0109, B:229:0x00d7, B:221:0x009f, B:217:0x007e), top: B:372:0x0003, inners: #0, #1, #3, #4, #5, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:368:0x014c A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:370:0x011a A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:373:0x00e8 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:377:0x0181 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:379:0x01b6 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized void init(Context context, boolean z) {
        XmlResourceParser layout;
        XmlResourceParser layout2;
        Configuration configuration;
        an.a("Beta init start....", new Object[0]);
        ac acVarA = ac.a();
        int i2 = instance.id;
        int i3 = com.tencent.bugly.beta.global.e.a + 1;
        com.tencent.bugly.beta.global.e.a = i3;
        acVarA.a(i2, i3);
        if (TextUtils.isEmpty(initProcessName)) {
            initProcessName = context.getPackageName();
        }
        an.a("Beta will init at: %s", initProcessName);
        String str = com.tencent.bugly.crashreport.common.info.a.b().f6176e;
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
                eVar.f6019c = upgradeCheckPeriod;
                an.a("setted upgradeCheckPeriod: %d", Long.valueOf(upgradeCheckPeriod));
            }
            if (initDelay < 0) {
                an.d("initDelay cannot be negative", new Object[0]);
            } else {
                eVar.f6018b = initDelay;
                an.a("setted initDelay: %d", Long.valueOf(initDelay));
            }
            if (smallIconId != 0) {
                try {
                } catch (Exception e2) {
                    an.e("smallIconId is not available:\n %s", e2.toString());
                }
                if (context.getResources().getDrawable(smallIconId) != null) {
                    eVar.f6024h = smallIconId;
                    an.a("setted smallIconId: %d", Integer.valueOf(smallIconId));
                    if (largeIconId == 0) {
                        try {
                        } catch (Exception e3) {
                            an.e("largeIconId is not available:\n %s", e3.toString());
                        }
                        if (context.getResources().getDrawable(largeIconId) != null) {
                            eVar.f6025i = largeIconId;
                            an.a("setted largeIconId: %d", Integer.valueOf(largeIconId));
                            if (defaultBannerId == 0) {
                                try {
                                } catch (Exception e4) {
                                    an.e("defaultBannerId is not available:\n %s", e4.toString());
                                }
                                if (context.getResources().getDrawable(defaultBannerId) != null) {
                                    eVar.f6026j = defaultBannerId;
                                    an.a("setted defaultBannerId: %d", Integer.valueOf(defaultBannerId));
                                    if (upgradeDialogLayoutId == 0) {
                                        try {
                                            layout = context.getResources().getLayout(upgradeDialogLayoutId);
                                        } catch (Exception e5) {
                                            an.e("upgradeDialogLayoutId is not available:\n %s", e5.toString());
                                        }
                                        if (layout != null) {
                                            eVar.f6027k = upgradeDialogLayoutId;
                                            an.a("setted upgradeDialogLayoutId: %d", Integer.valueOf(upgradeDialogLayoutId));
                                            layout.close();
                                            if (tipsDialogLayoutId == 0) {
                                                try {
                                                    layout2 = context.getResources().getLayout(tipsDialogLayoutId);
                                                } catch (Exception e6) {
                                                    an.e("tipsDialogLayoutId is not available:\n %s", e6.toString());
                                                }
                                                if (layout2 == null) {
                                                    if (upgradeDialogLifecycleListener != null) {
                                                    }
                                                    if (canShowUpgradeActs != null) {
                                                        while (r11.hasNext()) {
                                                        }
                                                        an.a("setted canShowUpgradeActs: %s", eVar.o);
                                                    }
                                                    if (canNotShowUpgradeActs != null) {
                                                        while (r11.hasNext()) {
                                                        }
                                                        an.a("setted canNotShowUpgradeActs: %s", eVar.p);
                                                    }
                                                    eVar.f6020d = autoCheckUpgrade;
                                                    eVar.f6021e = autoCheckAppUpgrade;
                                                    eVar.f6022f = autoCheckHotfix;
                                                    Object[] objArr = new Object[1];
                                                    objArr[0] = !eVar.f6020d ? "is opened" : "is closed";
                                                    an.a("autoCheckUpgrade %s", objArr);
                                                    Object[] objArr2 = new Object[1];
                                                    objArr2[0] = !eVar.f6021e ? "is opened" : "is closed";
                                                    an.a("autoCheckAppUpgrade %s", objArr2);
                                                    Object[] objArr3 = new Object[1];
                                                    objArr3[0] = !eVar.f6022f ? "is opened" : "is closed";
                                                    an.a("autoCheckHotfix %s", objArr3);
                                                    eVar.af = autoInstallApk;
                                                    Object[] objArr4 = new Object[1];
                                                    objArr4[0] = !eVar.af ? "is opened" : "is closed";
                                                    an.a("autoInstallApk %s", objArr4);
                                                    eVar.V = autoDownloadOn4g;
                                                    Object[] objArr5 = new Object[1];
                                                    objArr5[0] = !eVar.V ? "is opened" : "is closed";
                                                    an.a("autoDownloadOn4g %s", objArr5);
                                                    eVar.f6023g = showInterruptedStrategy;
                                                    Object[] objArr6 = new Object[1];
                                                    objArr6[0] = !eVar.f6023g ? "is opened" : "is closed";
                                                    an.a("showInterruptedStrategy %s", objArr6);
                                                    Object[] objArr7 = new Object[1];
                                                    objArr7[0] = upgradeListener == null ? "is opened" : "is closed";
                                                    an.a("isDIY %s", objArr7);
                                                    if (storageDir != null) {
                                                    }
                                                    if (eVar.r == null) {
                                                    }
                                                    if (TextUtils.isEmpty(eVar.w)) {
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
                                                    if (soBlackList != null) {
                                                        while (r11.hasNext()) {
                                                        }
                                                        an.a("setted soBlackList: %s", eVar.ac);
                                                    }
                                                    if (appChannel != null) {
                                                    }
                                                    eVar.a(context);
                                                    ResBean.a = (ResBean) com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.CREATOR);
                                                    if (ResBean.a == null) {
                                                    }
                                                    c.a.f6081e = upgradeListener;
                                                    c.a.f6082f = upgradeStateListener;
                                                    c.a.f6080d = downloadListener;
                                                    if (getStrategyTask() != null) {
                                                        getStrategyTask().addListener(c.a.f6080d);
                                                    }
                                                    if (enableHotfix) {
                                                    }
                                                    Resources resources = context.getResources();
                                                    DisplayMetrics displayMetrics = resources.getDisplayMetrics();
                                                    configuration = resources.getConfiguration();
                                                    configuration.locale = Locale.getDefault();
                                                    if (!configuration.locale.equals(Locale.US)) {
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
                                                    am.a().a(new d(1, new Object[0]), eVar.f6018b);
                                                    ac acVarA2 = ac.a();
                                                    int i4 = instance.id;
                                                    int i5 = com.tencent.bugly.beta.global.e.a - 1;
                                                    com.tencent.bugly.beta.global.e.a = i5;
                                                    acVarA2.a(i4, i5);
                                                    an.a("Beta init finished...", new Object[0]);
                                                    return;
                                                }
                                                eVar.f6028l = tipsDialogLayoutId;
                                                an.a("setted tipsDialogLayoutId: %d", Integer.valueOf(tipsDialogLayoutId));
                                                layout2.close();
                                                if (upgradeDialogLifecycleListener != null) {
                                                    try {
                                                        eVar.f6029m = upgradeDialogLifecycleListener;
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
                                                eVar.f6020d = autoCheckUpgrade;
                                                eVar.f6021e = autoCheckAppUpgrade;
                                                eVar.f6022f = autoCheckHotfix;
                                                Object[] objArr8 = new Object[1];
                                                objArr8[0] = !eVar.f6020d ? "is opened" : "is closed";
                                                an.a("autoCheckUpgrade %s", objArr8);
                                                Object[] objArr22 = new Object[1];
                                                objArr22[0] = !eVar.f6021e ? "is opened" : "is closed";
                                                an.a("autoCheckAppUpgrade %s", objArr22);
                                                Object[] objArr32 = new Object[1];
                                                objArr32[0] = !eVar.f6022f ? "is opened" : "is closed";
                                                an.a("autoCheckHotfix %s", objArr32);
                                                eVar.af = autoInstallApk;
                                                Object[] objArr42 = new Object[1];
                                                objArr42[0] = !eVar.af ? "is opened" : "is closed";
                                                an.a("autoInstallApk %s", objArr42);
                                                eVar.V = autoDownloadOn4g;
                                                Object[] objArr52 = new Object[1];
                                                objArr52[0] = !eVar.V ? "is opened" : "is closed";
                                                an.a("autoDownloadOn4g %s", objArr52);
                                                eVar.f6023g = showInterruptedStrategy;
                                                Object[] objArr62 = new Object[1];
                                                objArr62[0] = !eVar.f6023g ? "is opened" : "is closed";
                                                an.a("showInterruptedStrategy %s", objArr62);
                                                Object[] objArr72 = new Object[1];
                                                objArr72[0] = upgradeListener == null ? "is opened" : "is closed";
                                                an.a("isDIY %s", objArr72);
                                                if (storageDir != null) {
                                                    if (storageDir.exists() || storageDir.mkdirs()) {
                                                        eVar.f6030n = storageDir;
                                                        an.a("setted storageDir: %s", storageDir.getAbsolutePath());
                                                    } else {
                                                        an.a("storageDir is not exists: %s", storageDir.getAbsolutePath());
                                                    }
                                                }
                                                if (eVar.r == null) {
                                                    eVar.r = s.a;
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
                                                ResBean.a = (ResBean) com.tencent.bugly.beta.global.a.a("rb.bch", ResBean.CREATOR);
                                                if (ResBean.a == null) {
                                                    ResBean.a = new ResBean();
                                                }
                                                c.a.f6081e = upgradeListener;
                                                c.a.f6082f = upgradeStateListener;
                                                c.a.f6080d = downloadListener;
                                                if (getStrategyTask() != null && downloadListener != null) {
                                                    getStrategyTask().addListener(c.a.f6080d);
                                                }
                                                if (enableHotfix) {
                                                    an.a("enableHotfix %s", "1");
                                                    aq.b("D4", "1");
                                                    r.a(context);
                                                }
                                                Resources resources2 = context.getResources();
                                                DisplayMetrics displayMetrics2 = resources2.getDisplayMetrics();
                                                configuration = resources2.getConfiguration();
                                                configuration.locale = Locale.getDefault();
                                                if (!configuration.locale.equals(Locale.US) || configuration.locale.equals(Locale.ENGLISH)) {
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
                                                resources2.updateConfiguration(configuration, displayMetrics2);
                                                am.a().a(new d(1, new Object[0]), eVar.f6018b);
                                                ac acVarA22 = ac.a();
                                                int i42 = instance.id;
                                                int i52 = com.tencent.bugly.beta.global.e.a - 1;
                                                com.tencent.bugly.beta.global.e.a = i52;
                                                acVarA22.a(i42, i52);
                                                an.a("Beta init finished...", new Object[0]);
                                                return;
                                            }
                                        } else if (tipsDialogLayoutId == 0) {
                                        }
                                    }
                                } else if (upgradeDialogLayoutId == 0) {
                                }
                            }
                        } else if (defaultBannerId == 0) {
                        }
                    }
                } else if (largeIconId == 0) {
                }
            }
        }
    }

    public static synchronized void installApk(File file) {
        y upgradeStrategy;
        try {
            upgradeStrategy = getUpgradeStrategy();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (upgradeStrategy != null && com.tencent.bugly.beta.global.a.a(com.tencent.bugly.beta.global.e.G.u, file, upgradeStrategy.f6599f.a)) {
            p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f6598e, upgradeStrategy.f6606m, upgradeStrategy.p, null));
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
        boolean zLoadLibraryFromTinker;
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
                    String strB = com.tencent.bugly.beta.global.a.b(str, "");
                    boolean zB = com.tencent.bugly.beta.global.a.b("PatchResult", false);
                    if (TextUtils.isEmpty(strB) || !zB) {
                        zLoadLibraryFromTinker = false;
                    } else {
                        zLoadLibraryFromTinker = TinkerManager.loadLibraryFromTinker(eVar.u, "lib/" + strB, str);
                    }
                    if (!zLoadLibraryFromTinker) {
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
        HashMap map = new HashMap();
        map.put("IMG_title", str6);
        map.put("VAL_style", String.valueOf(i5));
        c.a.a(z, z2, i7, new y(str, str2, j2, 0, new v(com.tencent.bugly.beta.global.e.G.w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "", ""), new u(str5, str4, "", j3, ""), (byte) i2, i6, j4, null, "", map, str7, 1, j5, 1), str8 == null ? "" : str8);
    }

    public static void registerDownloadListener(DownloadListener downloadListener2) {
        DownloadTask downloadTask;
        com.tencent.bugly.beta.global.e eVar = com.tencent.bugly.beta.global.e.G;
        eVar.s = downloadListener2;
        if (eVar.s == null || (downloadTask = c.a.f6079c) == null) {
            return;
        }
        downloadTask.addListener(downloadListener2);
    }

    public static synchronized void saveInstallEvent(boolean z) {
        try {
            y upgradeStrategy = getUpgradeStrategy();
            if (upgradeStrategy != null && z) {
                com.tencent.bugly.beta.global.a.a("installApkMd5", upgradeStrategy.f6599f.a);
                p.a.a(new w("install", System.currentTimeMillis(), (byte) 0, 0L, upgradeStrategy.f6598e, upgradeStrategy.f6606m, upgradeStrategy.p, null));
                an.a("\u5b89\u88c5\u4e8b\u4ef6\u4fdd\u5b58\u6210\u529f", new Object[0]);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public static synchronized void showUpgradeDialog(String str, int i2, String str2, long j2, int i3, int i4, String str3, String str4, long j3, String str5, String str6, int i5, DownloadListener downloadListener2, Runnable runnable, Runnable runnable2, boolean z) {
        y yVar;
        HashMap map = new HashMap();
        map.put("IMG_title", str6);
        map.put("VAL_style", String.valueOf(i5));
        y yVar2 = new y(str, str2, j2, 0, new v(com.tencent.bugly.beta.global.e.G.w, (byte) 1, i4, str3, i3, "", 1L, "", str5, "1.4.5", ""), new u(str5, str4, "", j3, ""), (byte) i2, 0, 0L, null, "", map, null, 1, System.currentTimeMillis(), 1);
        if (a != null && !a.getDownloadUrl().equals(str4)) {
            a.delete(true);
            a = null;
        }
        if (a == null) {
            yVar = yVar2;
            a = com.tencent.bugly.beta.global.e.G.r.a(yVar.f6599f.f6568b, com.tencent.bugly.beta.global.e.G.v.getAbsolutePath(), null, yVar.f6599f.a);
            a.setDownloadType(1);
        } else {
            yVar = yVar2;
        }
        a.addListener(downloadListener2);
        h.v.a(yVar, a);
        h.v.r = runnable;
        h.v.s = runnable2;
        f.a.a(com.tencent.bugly.beta.global.e.G.r, yVar.f6605l);
        if (z) {
            f fVar = f.a;
            Object[] objArr = new Object[2];
            objArr[0] = h.v;
            objArr[1] = Boolean.valueOf(yVar.f6600g == 2);
            fVar.a(new d(2, objArr), PathInterpolatorCompat.MAX_NUM_POINTS);
        } else {
            f fVar2 = f.a;
            Object[] objArr2 = new Object[2];
            objArr2[0] = h.v;
            objArr2[1] = Boolean.valueOf(yVar.f6600g == 2);
            fVar2.a(new d(2, objArr2));
        }
    }

    public static DownloadTask startDownload() {
        c cVar = c.a;
        d dVar = cVar.f6085i;
        if (dVar == null || dVar.f6017b[0] != cVar.f6079c) {
            c cVar2 = c.a;
            cVar2.f6085i = new d(13, cVar2.f6079c, cVar2.f6078b);
        }
        c.a.f6085i.run();
        return c.a.f6079c;
    }

    public static void unInit() {
        if (com.tencent.bugly.beta.global.a.b("IS_PATCH_ROLL_BACK", false)) {
            com.tencent.bugly.beta.global.a.a("IS_PATCH_ROLL_BACK", false);
            TinkerManager.getInstance().cleanPatch(true);
        }
    }

    public static void unregisterDownloadListener() {
        DownloadTask downloadTask = c.a.f6079c;
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

    /* JADX WARN: Removed duplicated region for block: B:105:0x0135 A[PHI: r5
  0x0135: PHI (r5v4 android.database.Cursor) = (r5v3 android.database.Cursor), (r5v5 android.database.Cursor) binds: [B:104:0x0133, B:93:0x011a] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Unreachable blocks removed: 2, instructions: 5 */
    @Override // com.tencent.bugly.a
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public void onDbUpgrade(SQLiteDatabase sQLiteDatabase, int i2, int i3) {
        int i4;
        String str;
        String str2;
        Cursor cursorQuery;
        String str3 = " , ";
        String str4 = bl.f7101d;
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
                    sb.append(d.c.a.b.a.a.f10074g);
                    sb.append("integer");
                    sb.append(str3);
                    sb.append(bl.f7102e);
                    sb.append(d.c.a.b.a.a.f10074g);
                    sb.append("text");
                    sb.append(str3);
                    sb.append("_tm");
                    sb.append(d.c.a.b.a.a.f10074g);
                    sb.append("int");
                    sb.append(str3);
                    sb.append("_dt");
                    sb.append(d.c.a.b.a.a.f10074g);
                    sb.append("blob");
                    sb.append(",primary key(");
                    sb.append(str4);
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    sb.append(bl.f7102e);
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
                    cursorQuery = sQLiteDatabase.query("t_pf", null, "_id = 1002", null, null, null, null);
                } catch (Throwable th2) {
                    th = th2;
                    cursorQuery = null;
                }
                if (cursorQuery == null) {
                    if (cursorQuery != null) {
                        return;
                    } else {
                        return;
                    }
                }
                while (cursorQuery.moveToNext()) {
                    try {
                        ContentValues contentValues = new ContentValues();
                        if (cursorQuery.getLong(cursorQuery.getColumnIndex(str2)) > 0) {
                            contentValues.put(str2, Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex(str2))));
                        }
                        contentValues.put("_tm", Long.valueOf(cursorQuery.getLong(cursorQuery.getColumnIndex("_tm"))));
                        contentValues.put(bl.f7102e, cursorQuery.getString(cursorQuery.getColumnIndex(bl.f7102e)));
                        contentValues.put("_dt", cursorQuery.getBlob(cursorQuery.getColumnIndex("_dt")));
                        sQLiteDatabase.replace("st_1002", null, contentValues);
                    } catch (Throwable th3) {
                        th = th3;
                        try {
                            if (!an.b(th)) {
                                th.printStackTrace();
                            }
                            if (cursorQuery != null) {
                            }
                        } finally {
                            if (cursorQuery != null) {
                                cursorQuery.close();
                            }
                        }
                    }
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
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
