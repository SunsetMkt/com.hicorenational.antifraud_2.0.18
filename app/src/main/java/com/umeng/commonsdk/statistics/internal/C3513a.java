package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: HeaderHelper.java */
/* renamed from: com.umeng.commonsdk.statistics.internal.a */
/* loaded from: classes2.dex */
public class C3513a {

    /* renamed from: a */
    private static Context f12809a;

    /* renamed from: b */
    private String f12810b;

    /* renamed from: c */
    private String f12811c;

    /* compiled from: HeaderHelper.java */
    /* renamed from: com.umeng.commonsdk.statistics.internal.a$a */
    private static class a {

        /* renamed from: a */
        private static final C3513a f12812a = new C3513a();

        private a() {
        }
    }

    /* renamed from: a */
    public static C3513a m11877a(Context context) {
        if (f12809a == null && context != null) {
            f12809a = context.getApplicationContext();
        }
        return a.f12812a;
    }

    /* renamed from: f */
    private void m11878f(String str) {
        try {
            this.f12810b = str.replaceAll("&=", AbstractC1191a.f2568g).replaceAll("&&", AbstractC1191a.f2568g).replaceAll("==", "/") + "/Android" + AbstractC1191a.f2568g + HelperUtils.getUmengMD5(UMUtils.getAppkey(f12809a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f12809a, th);
        }
    }

    /* renamed from: g */
    private void m11879g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] split = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(C3351bh.f11595aT);
            for (String str3 : split) {
                if (!TextUtils.isEmpty(str3)) {
                    String substring = str3.substring(0, 2);
                    if (substring.endsWith(ContainerUtils.KEY_VALUE_DELIMITER)) {
                        substring = substring.replace(ContainerUtils.KEY_VALUE_DELIMITER, "");
                    }
                    sb.append(substring);
                }
            }
            this.f12811c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(f12809a, th);
        }
    }

    /* renamed from: b */
    public boolean m11883b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    /* renamed from: c */
    public boolean m11884c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(C3351bh.f11582aG);
    }

    /* renamed from: d */
    public boolean m11885d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(C3351bh.f11585aJ);
    }

    /* renamed from: e */
    public void m11886e(String str) {
        String substring = str.substring(0, str.indexOf(95));
        m11879g(substring);
        m11878f(substring);
    }

    private C3513a() {
        this.f12810b = null;
        this.f12811c = null;
    }

    /* renamed from: b */
    public String m11882b() {
        return this.f12810b;
    }

    /* renamed from: a */
    public boolean m11881a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("a");
    }

    /* renamed from: a */
    public String m11880a() {
        return this.f12811c;
    }
}
