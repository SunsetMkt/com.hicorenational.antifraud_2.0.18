package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.sina.weibo.sdk.auth.b */
/* loaded from: classes.dex */
public final class C2922b {

    /* renamed from: e */
    private Map<String, WbAuthListener> f9299e;

    /* renamed from: com.sina.weibo.sdk.auth.b$a */
    static class a {

        /* renamed from: f */
        private static final C2922b f9300f = new C2922b(0);
    }

    /* synthetic */ C2922b(byte b2) {
        this();
    }

    /* renamed from: b */
    public static synchronized C2922b m8817b() {
        C2922b c2922b;
        synchronized (C2922b.class) {
            c2922b = a.f9300f;
        }
        return c2922b;
    }

    /* renamed from: a */
    public final synchronized void m8819a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.f9299e.put(str, wbAuthListener);
        }
    }

    private C2922b() {
        this.f9299e = new HashMap();
    }

    /* renamed from: b */
    public final synchronized void m8820b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f9299e.remove(str);
    }

    /* renamed from: a */
    public final synchronized WbAuthListener m8818a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f9299e.get(str);
    }
}
