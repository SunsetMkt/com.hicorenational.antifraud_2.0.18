package com.tencent.open.utils;

import android.content.Context;
import java.io.File;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.g */
/* loaded from: classes2.dex */
public final class C3289g {

    /* renamed from: a */
    private static Context f11304a;

    /* renamed from: a */
    public static final Context m10603a() {
        Context context = f11304a;
        if (context == null) {
            return null;
        }
        return context;
    }

    /* renamed from: b */
    public static final String m10606b() {
        return m10603a() == null ? "" : m10603a().getPackageName();
    }

    /* renamed from: c */
    public static final File m10607c() {
        if (m10603a() == null) {
            return null;
        }
        return m10603a().getFilesDir();
    }

    /* renamed from: d */
    public static final File m10608d() {
        Context m10603a = m10603a();
        if (m10603a != null) {
            return m10603a.getCacheDir();
        }
        return null;
    }

    /* renamed from: e */
    public static final File m10609e() {
        return m10604a((String) null);
    }

    /* renamed from: a */
    public static final void m10605a(Context context) {
        f11304a = context;
    }

    /* renamed from: a */
    public static final File m10604a(String str) {
        return C3295m.m10707h(m10603a(), str);
    }
}
