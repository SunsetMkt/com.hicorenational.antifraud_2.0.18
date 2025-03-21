package com.taobao.accs.p197a;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.taobao.accs.utl.ALog;
import com.taobao.accs.utl.BaseMonitor;
import com.taobao.accs.utl.C3043k;
import com.taobao.accs.utl.C3054v;
import com.taobao.accs.utl.UtilityImpl;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.a.a */
/* loaded from: classes.dex */
public class C2961a {
    public static final String TAG = "a";

    /* renamed from: a */
    public static void m8908a(Context context, Intent intent) {
        String className;
        String packageName;
        if (context == null || intent == null) {
            ALog.m9182e(TAG, "dispatchIntent context or intent is null", new Object[0]);
            return;
        }
        Context applicationContext = context.getApplicationContext();
        try {
            if (intent.getComponent() == null) {
                className = intent.toString();
                packageName = "";
            } else {
                className = intent.getComponent().getClassName();
                packageName = intent.getComponent().getPackageName();
            }
            if (C3054v.m9284a(applicationContext)) {
                ALog.m9183i(TAG, "dispatchIntent bind service start", CommonCode.Resolution.HAS_RESOLUTION_FROM_APK, intent.toString());
                if (applicationContext.bindService(intent, new ServiceConnectionC2962b(intent, applicationContext, context, 0), 1) || !context.getPackageName().equals(packageName)) {
                    return;
                }
                C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_BIND, intent.toString(), UtilityImpl.m9194a(-2), "dispatchIntent bindService return false");
                return;
            }
            ALog.m9183i(TAG, "dispatchIntent start service ", new Object[0]);
            applicationContext.startService(intent);
            if (context.getPackageName().equals(packageName)) {
                C3043k.m9249a("accs", BaseMonitor.ALARM_POINT_BIND, className);
            }
        } catch (Throwable th) {
            ALog.m9181e(TAG, "dispatchIntent method call with exception ", th, new Object[0]);
            if (context.getPackageName().equals(null)) {
                C3043k.m9251a("accs", BaseMonitor.ALARM_POINT_BIND, intent.toString(), UtilityImpl.m9194a(-1), "dispatchIntent method call with exception");
            }
        }
    }
}
