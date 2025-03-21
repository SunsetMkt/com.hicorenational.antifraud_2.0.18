package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.Map;

/* loaded from: classes2.dex */
public class FTOSPushHelper {

    /* renamed from: a */
    private static long f14341a = 0;

    /* renamed from: a */
    private static volatile boolean f14342a = false;

    /* renamed from: a */
    private static void m13427a(Context context) {
        AbstractPushManager m13522a = C4051e.m13518a(context).m13522a(EnumC4050d.ASSEMBLE_PUSH_FTOS);
        if (m13522a != null) {
            AbstractC4022b.m13347a("ASSEMBLE_PUSH :  register fun touch os when network change!");
            m13522a.register();
        }
    }

    public static void doInNetworkChange(Context context) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (getNeedRegister()) {
            long j2 = f14341a;
            if (j2 <= 0 || j2 + 300000 <= elapsedRealtime) {
                f14341a = elapsedRealtime;
                m13427a(context);
            }
        }
    }

    public static boolean getNeedRegister() {
        return f14342a;
    }

    public static boolean hasNetwork(Context context) {
        return C4052f.m13542a(context);
    }

    public static void notifyFTOSNotificationClicked(Context context, Map<String, String> map) {
        PushMessageReceiver m13531a;
        if (map == null || !map.containsKey("pushMsg")) {
            return;
        }
        String str = map.get("pushMsg");
        if (TextUtils.isEmpty(str) || (m13531a = C4052f.m13531a(context)) == null) {
            return;
        }
        MiPushMessage m13530a = C4052f.m13530a(str);
        if (m13530a.getExtra().containsKey("notify_effect")) {
            return;
        }
        m13531a.onNotificationMessageClicked(context, m13530a);
    }

    public static void setNeedRegister(boolean z) {
        f14342a = z;
    }

    public static void uploadToken(Context context, String str) {
        C4052f.m13538a(context, EnumC4050d.ASSEMBLE_PUSH_FTOS, str);
    }
}
