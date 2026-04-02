package com.umeng.commonsdk.statistics.internal;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import com.umeng.analytics.pro.bh;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.utils.UMUtils;

/* JADX INFO: compiled from: HeaderHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private static Context a;

    /* JADX INFO: renamed from: b */
    private String f7729b;

    /* JADX INFO: renamed from: c */
    private String f7730c;

    /* JADX INFO: renamed from: com.umeng.commonsdk.statistics.internal.a$a */
    /* JADX INFO: compiled from: HeaderHelper.java */
    private static class C0132a {
        private static final a a = new a();

        private C0132a() {
        }
    }

    /* synthetic */ a(AnonymousClass1 anonymousClass1) {
        this();
    }

    public static a a(Context context) {
        if (a == null && context != null) {
            a = context.getApplicationContext();
        }
        return C0132a.a;
    }

    private void f(String str) {
        try {
            this.f7729b = str.replaceAll("&=", d.c.a.b.a.a.f10074g).replaceAll("&&", d.c.a.b.a.a.f10074g).replaceAll("==", "/") + "/Android" + d.c.a.b.a.a.f10074g + HelperUtils.getUmengMD5(UMUtils.getAppkey(a));
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    private void g(String str) {
        try {
            String str2 = str.split("&&")[0];
            if (TextUtils.isEmpty(str2)) {
                return;
            }
            String[] strArrSplit = str2.split("&=");
            StringBuilder sb = new StringBuilder();
            sb.append(bh.aT);
            for (String str3 : strArrSplit) {
                if (!TextUtils.isEmpty(str3)) {
                    String strSubstring = str3.substring(0, 2);
                    if (strSubstring.endsWith(ContainerUtils.KEY_VALUE_DELIMITER)) {
                        strSubstring = strSubstring.replace(ContainerUtils.KEY_VALUE_DELIMITER, "");
                    }
                    sb.append(strSubstring);
                }
            }
            this.f7730c = sb.toString();
        } catch (Throwable th) {
            UMCrashManager.reportCrash(a, th);
        }
    }

    public boolean b(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("t");
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bh.aG);
    }

    public boolean d(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bh.aJ);
    }

    public void e(String str) {
        String strSubstring = str.substring(0, str.indexOf(95));
        g(strSubstring);
        f(strSubstring);
    }

    private a() {
        this.f7729b = null;
        this.f7730c = null;
    }

    public String b() {
        return this.f7729b;
    }

    public boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith(bh.ay);
    }

    public String a() {
        return this.f7730c;
    }
}
