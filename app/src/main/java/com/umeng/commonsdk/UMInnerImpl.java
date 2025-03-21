package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMModuleRegister;
import com.umeng.commonsdk.internal.C3474d;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.internal.utils.C3477c;
import com.umeng.commonsdk.internal.utils.C3485k;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.utils.C3531d;

/* loaded from: classes2.dex */
public class UMInnerImpl {
    private static boolean isInternal = false;

    public static synchronized void initAndSendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.2
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                                        return;
                                    }
                                    try {
                                        if (FieldManager.allow(C3531d.f12994ao) && !C3477c.m11646a(context).m11648a()) {
                                            C3477c.m11646a(context).m11649b();
                                        }
                                    } catch (Throwable th) {
                                        ULog.m11777e(UMModuleRegister.INNER, "e is " + th);
                                    }
                                    try {
                                        C3485k.m11671b(context);
                                    } catch (Throwable th2) {
                                        ULog.m11777e(UMModuleRegister.INNER, "e is " + th2);
                                    }
                                } catch (Throwable th3) {
                                    UMCrashManager.reportCrash(context, th3);
                                }
                            }
                        }).start();
                        isInternal = true;
                        sendInternal(context);
                    }
                } finally {
                }
            }
        }
    }

    private static synchronized void sendInternal(final Context context) {
        synchronized (UMInnerImpl.class) {
            if (context != null) {
                try {
                    new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMInnerImpl.1
                        @Override // java.lang.Runnable
                        public void run() {
                            try {
                                String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                String packageName = context.getPackageName();
                                if (!TextUtils.isEmpty(currentProcessName) && !TextUtils.isEmpty(packageName) && currentProcessName.equals(packageName)) {
                                    try {
                                        C3474d.m11615b(context);
                                    } catch (Throwable th) {
                                        ULog.m11777e(UMModuleRegister.INNER, "e is " + th);
                                    }
                                }
                            } catch (Throwable th2) {
                                UMCrashManager.reportCrash(context, th2);
                            }
                        }
                    }).start();
                    isInternal = true;
                } finally {
                }
            }
        }
    }
}
