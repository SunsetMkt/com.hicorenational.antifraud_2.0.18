package com.vivo.push.cache;

import android.content.Context;
import com.vivo.push.util.C4010u;
import java.lang.reflect.Method;

/* compiled from: ConfigManagerFactory.java */
/* renamed from: com.vivo.push.cache.b */
/* loaded from: classes2.dex */
public final class C3858b {

    /* renamed from: a */
    private static volatile C3858b f13965a;

    /* renamed from: b */
    private InterfaceC3860d f13966b;

    private C3858b() {
    }

    /* renamed from: a */
    public static synchronized C3858b m12901a() {
        C3858b c3858b;
        synchronized (C3858b.class) {
            if (f13965a == null) {
                f13965a = new C3858b();
            }
            c3858b = f13965a;
        }
        return c3858b;
    }

    /* renamed from: a */
    public final InterfaceC3860d m12902a(Context context) {
        InterfaceC3860d interfaceC3860d = this.f13966b;
        if (interfaceC3860d != null) {
            return interfaceC3860d;
        }
        try {
            Method method = Class.forName("com.vivo.push.cache.ClientConfigManagerImpl").getMethod("getInstance", Context.class);
            C4010u.m13309d("ConfigManagerFactory", "createConfig success is ".concat("com.vivo.push.cache.ClientConfigManagerImpl"));
            this.f13966b = (InterfaceC3860d) method.invoke(null, context);
            return this.f13966b;
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13302b("ConfigManagerFactory", "createConfig error", e2);
            return null;
        }
    }
}
