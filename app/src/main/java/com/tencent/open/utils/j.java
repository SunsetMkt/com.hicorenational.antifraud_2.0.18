package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;
import java.lang.ref.WeakReference;
import java.net.URL;

/* compiled from: ProGuard */
/* loaded from: classes2.dex */
public class j {

    /* renamed from: a, reason: collision with root package name */
    private static j f9931a;

    /* renamed from: b, reason: collision with root package name */
    private volatile WeakReference<SharedPreferences> f9932b = null;

    public static synchronized j a() {
        j jVar;
        synchronized (j.class) {
            if (f9931a == null) {
                f9931a = new j();
            }
            jVar = f9931a;
        }
        return jVar;
    }

    public String a(Context context, String str) {
        if (this.f9932b == null || this.f9932b.get() == null) {
            this.f9932b = new WeakReference<>(context.getSharedPreferences("ServerPrefs", 0));
        }
        try {
            String host = new URL(str).getHost();
            if (host == null) {
                SLog.e("openSDK_LOG.ServerSetting", "Get host error. url=" + str);
                return str;
            }
            String string = this.f9932b.get().getString(host, null);
            if (string != null && !host.equals(string)) {
                String replace = str.replace(host, string);
                SLog.v("openSDK_LOG.ServerSetting", "return environment url : " + replace);
                return replace;
            }
            SLog.v("openSDK_LOG.ServerSetting", "host=" + host + ", envHost=" + string);
            return str;
        } catch (Exception e2) {
            SLog.e("openSDK_LOG.ServerSetting", "getEnvUrl url=" + str + "error.: " + e2.getMessage());
            return str;
        }
    }
}
