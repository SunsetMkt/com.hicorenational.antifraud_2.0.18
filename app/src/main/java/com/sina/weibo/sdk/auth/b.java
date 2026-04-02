package com.sina.weibo.sdk.auth;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class b {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Map<String, WbAuthListener> f5688e;

    static class a {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private static final b f5689f = new b(0);
    }

    /* synthetic */ b(byte b2) {
        this();
    }

    public static synchronized b b() {
        return a.f5689f;
    }

    public final synchronized void a(String str, WbAuthListener wbAuthListener) {
        if (!TextUtils.isEmpty(str) && wbAuthListener != null) {
            this.f5688e.put(str, wbAuthListener);
        }
    }

    private b() {
        this.f5688e = new HashMap();
    }

    public final synchronized void b(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.f5688e.remove(str);
    }

    public final synchronized WbAuthListener a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return this.f5688e.get(str);
    }
}
