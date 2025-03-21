package com.vivo.push.p236e;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* compiled from: PushSecurityManager.java */
/* renamed from: com.vivo.push.e.b */
/* loaded from: classes2.dex */
public final class C3878b {

    /* renamed from: c */
    private static volatile C3878b f14001c;

    /* renamed from: a */
    private InterfaceC3877a f14002a;

    /* renamed from: b */
    private Context f14003b;

    private C3878b() {
    }

    /* renamed from: a */
    public static synchronized C3878b m12943a() {
        C3878b c3878b;
        synchronized (C3878b.class) {
            if (f14001c == null) {
                f14001c = new C3878b();
            }
            c3878b = f14001c;
        }
        return c3878b;
    }

    /* renamed from: a */
    public final synchronized InterfaceC3877a m12944a(Context context) {
        if (this.f14002a != null) {
            return this.f14002a;
        }
        if (context == null) {
            return null;
        }
        if (this.f14002a == null) {
            this.f14003b = ContextDelegate.getContext(context.getApplicationContext());
            this.f14002a = new C3879c(this.f14003b);
        }
        return this.f14002a;
    }
}
