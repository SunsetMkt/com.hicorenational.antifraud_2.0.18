package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.u;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: ConfigManagerFactory.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {
    private static volatile b a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f8476b;

    private b() {
    }

    public static synchronized b a() {
        if (a == null) {
            a = new b();
        }
        return a;
    }

    public final d a(Context context) {
        d dVar = this.f8476b;
        if (dVar != null) {
            return dVar;
        }
        try {
            Method method = Class.forName("com.vivo.push.cache.ClientConfigManagerImpl").getMethod("getInstance", Context.class);
            u.d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            this.f8476b = (d) method.invoke(null, context);
            return this.f8476b;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
