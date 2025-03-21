package com.hihonor.honorid;

import android.content.Context;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: ApplicationContext.java */
/* renamed from: com.hihonor.honorid.a */
/* loaded from: classes.dex */
public final class C2151a {

    /* renamed from: c */
    private static C2151a f6488c;

    /* renamed from: a */
    private Map<String, List<String>> f6489a = new HashMap();

    /* renamed from: b */
    private WeakReference<Context> f6490b;

    private C2151a() {
        new HashMap();
        new HashMap();
        new HashMap();
        new HashMap();
        this.f6490b = null;
    }

    /* renamed from: c */
    public static synchronized C2151a m6093c() {
        C2151a c2151a;
        synchronized (C2151a.class) {
            if (f6488c == null) {
                f6488c = new C2151a();
            }
            c2151a = f6488c;
        }
        return c2151a;
    }

    /* renamed from: a */
    public void m6095a(Context context) {
        this.f6490b = new WeakReference<>(context);
    }

    /* renamed from: b */
    public List<String> m6097b() {
        return this.f6489a.get("packageNamesNotUseApk");
    }

    /* renamed from: a */
    public Context m6094a() {
        WeakReference<Context> weakReference = this.f6490b;
        if (weakReference == null || weakReference.get() == null) {
            return null;
        }
        return this.f6490b.get();
    }

    /* renamed from: a */
    public void m6096a(List<String> list) {
        this.f6489a.put("packageNamesNotUseApk", list);
    }
}
