package com.hihonor.honorid;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: ApplicationContext.java */
/* JADX INFO: loaded from: classes.dex */
public final class a {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static a f4099c;
    private Map<String, List<String>> a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference<Context> f4100b;

    private a() {
        new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
        this.f4100b = null;
    }

    public static synchronized a c() {
        if (f4099c == null) {
            f4099c = new a();
        }
        return f4099c;
    }

    public void a(Context context) {
        this.f4100b = new WeakReference<>(context);
    }

    public List<String> b() {
        return this.a.get("packageNamesNotUseApk");
    }

    public Context a() {
        WeakReference<Context> weakReference = this.f4100b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f4100b.get();
    }

    public void a(List<String> list) {
        this.a.put("packageNamesNotUseApk", list);
    }
}
