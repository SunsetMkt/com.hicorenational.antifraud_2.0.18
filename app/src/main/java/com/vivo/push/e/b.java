package com.vivo.push.e;

import android.content.Context;
import com.vivo.push.util.ContextDelegate;

/* JADX INFO: compiled from: PushSecurityManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile b f8500c;
    private a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f8501b;

    private b() {
    }

    public static synchronized b a() {
        if (f8500c == null) {
            f8500c = new b();
        }
        return f8500c;
    }

    public final synchronized a a(Context context) {
        if (this.a != null) {
            return this.a;
        }
        if (context == null) {
            return null;
        }
        if (this.a == null) {
            this.f8501b = ContextDelegate.getContext(context.getApplicationContext());
            this.a = new c(this.f8501b);
        }
        return this.a;
    }
}
