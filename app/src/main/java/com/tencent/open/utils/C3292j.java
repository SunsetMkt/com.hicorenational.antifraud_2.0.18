package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.j */
/* loaded from: classes2.dex */
public class C3292j {

    /* renamed from: a */
    private static C3292j f11316a;

    /* renamed from: b */
    private volatile WeakReference<SharedPreferences> f11317b = null;

    /* renamed from: a */
    public static synchronized C3292j m10626a() {
        C3292j c3292j;
        synchronized (C3292j.class) {
            if (f11316a == null) {
                f11316a = new C3292j();
            }
            c3292j = f11316a;
        }
        return c3292j;
    }

    /* renamed from: a */
    public String m10627a(Context context, String str) {
        if (this.f11317b == null || this.f11317b.get() == null) {
            this.f11317b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.m10500e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f11317b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                SLog.m10506v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            SLog.m10506v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e2) {
            SLog.m10500e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e2.getMessage());
            return str;
        }
    }
}
