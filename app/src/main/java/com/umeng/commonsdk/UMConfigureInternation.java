package com.umeng.commonsdk;

import android.content.Context;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMLogDataProtocol;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;

/* loaded from: classes2.dex */
public class UMConfigureInternation {
    private static boolean isInternal = false;

    public static void doSelfCheck(Context context) {
        try {
            String currentProcessName = UMFrUtils.getCurrentProcessName(context);
            String packageName = context.getPackageName();
            if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName)) {
                return;
            }
            UMWorkDispatch.sendEvent(context, C3470a.f12577C, C3471b.m11589a(context).m11590a(), null);
        } catch (Throwable unused) {
        }
    }

    public static synchronized void sendInternal(final Context context) {
        synchronized (UMConfigureInternation.class) {
            if (context != null) {
                try {
                    if (!isInternal) {
                        new Thread(new Runnable() { // from class: com.umeng.commonsdk.UMConfigureInternation.1
                            @Override // java.lang.Runnable
                            public void run() {
                                try {
                                    String currentProcessName = UMFrUtils.getCurrentProcessName(context);
                                    String packageName = context.getPackageName();
                                    if (TextUtils.isEmpty(currentProcessName) || TextUtils.isEmpty(packageName) || !currentProcessName.equals(packageName) || !UMEnvelopeBuild.isReadyBuild(context, UMLogDataProtocol.UMBusinessType.U_INTERNAL)) {
                                        return;
                                    }
                                    UMWorkDispatch.sendEvent(context, C3470a.f12600n, C3471b.m11589a(context).m11590a(), null, C2084a.f6136r);
                                } catch (Throwable unused) {
                                }
                            }
                        }).start();
                        isInternal = true;
                    }
                } finally {
                }
            }
        }
    }
}
