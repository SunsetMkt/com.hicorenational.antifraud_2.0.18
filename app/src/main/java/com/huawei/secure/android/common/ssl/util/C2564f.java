package com.huawei.secure.android.common.ssl.util;

import android.content.Context;
import android.content.pm.PackageManager;

/* renamed from: com.huawei.secure.android.common.ssl.util.f */
/* loaded from: classes.dex */
public class C2564f {

    /* renamed from: a */
    private static final String f8247a = "f";

    /* renamed from: a */
    public static String m7990a(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return "";
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            C2563e.m7986b(f8247a, "getVersion NameNotFoundException : " + e2.getMessage());
            return "";
        } catch (Exception e3) {
            C2563e.m7986b(f8247a, "getVersion: " + e3.getMessage());
            return "";
        } catch (Throwable unused) {
            C2563e.m7986b(f8247a, "throwable");
            return "";
        }
    }

    /* renamed from: b */
    public static int m7991b(String str) {
        Context contextUtil = ContextUtil.getInstance();
        if (contextUtil == null) {
            return 0;
        }
        try {
            return contextUtil.getPackageManager().getPackageInfo(str, 0).versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            C2563e.m7986b(f8247a, "getVersion NameNotFoundException");
            return 0;
        } catch (Exception e2) {
            C2563e.m7986b(f8247a, "getVersion: " + e2.getMessage());
            return 0;
        }
    }
}
