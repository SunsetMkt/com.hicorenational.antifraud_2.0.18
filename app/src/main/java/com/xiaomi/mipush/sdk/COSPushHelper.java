package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;

/* loaded from: classes2.dex */
public class COSPushHelper {

    /* renamed from: a */
    private static long f14339a = 0;

    /* renamed from: a */
    private static volatile boolean f14340a = false;

    public static void convertMessage(Intent intent) {
        C4052f.m13540a(intent);
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j2 = f14339a;
            if (j2 <= 0 || j2 + 300000 <= elapsedRealtime) {
                f14339a = elapsedRealtime;
                registerCOSAssemblePush(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f14340a;
    }

    public static boolean hasNetwork(Context context) {
        return C4052f.m13542a(context);
    }

    public static void onNotificationMessageCome(Context context, String str) {
    }

    public static void onPassThoughMessageCome(Context context, String str) {
    }

    public static void registerCOSAssemblePush(Context context) {
        AbstractPushManager m13522a = C4051e.m13518a(context).m13522a(EnumC4050d.ASSEMBLE_PUSH_COS);
        if (m13522a != null) {
            AbstractC4022b.m13347a("ASSEMBLE_PUSH :  register cos when network change!");
            m13522a.register();
        }
    }

    public static synchronized void setNeedRegister(boolean z) {
        synchronized (COSPushHelper.class) {
            f14340a = z;
        }
    }

    public static void uploadToken(Context context, String str) {
        C4052f.m13538a(context, EnumC4050d.ASSEMBLE_PUSH_COS, str);
    }
}
