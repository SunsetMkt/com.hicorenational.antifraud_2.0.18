package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.utils.f */
/* loaded from: classes2.dex */
public class C3288f {

    /* renamed from: a */
    private String f11301a;

    /* renamed from: b */
    private String f11302b;

    /* compiled from: ProGuard */
    /* renamed from: com.tencent.open.utils.f$a */
    private static class a {

        /* renamed from: a */
        private static C3288f f11303a = new C3288f();
    }

    /* renamed from: a */
    public static C3288f m10596a() {
        return a.f11303a;
    }

    /* renamed from: b */
    public String m10600b(Context context) {
        return this.f11301a;
    }

    /* renamed from: c */
    public String m10601c(Context context) {
        return this.f11302b;
    }

    private C3288f() {
        this.f11301a = "";
        this.f11302b = "";
    }

    /* renamed from: a */
    public void m10597a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 4);
        String str = this.f11302b;
        if (str == null || str.trim().isEmpty()) {
            this.f11302b = sharedPreferences.getString("build_model", "");
            SLog.m10502i("openSDK_LOG.DeviceInfoUtils", "init, model = " + this.f11302b);
        }
        String str2 = this.f11301a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.f11301a = sharedPreferences.getString("build_device", "");
            SLog.m10502i("openSDK_LOG.DeviceInfoUtils", "init, device = " + this.f11301a);
        }
    }

    /* renamed from: b */
    public String m10599b() {
        return this.f11302b;
    }

    /* renamed from: a */
    public void m10598a(Context context, String str) {
        SLog.m10502i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, model = " + str);
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.f11302b;
            if (str2 != null && str2.equals(str)) {
                SLog.m10502i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, needn't update sp.");
                return;
            }
            this.f11302b = str;
            if (context != null) {
                context.getSharedPreferences("device_info_file", 4).edit().putString("build_model", this.f11302b).commit();
                SLog.m10502i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, update sp.");
                return;
            }
            return;
        }
        this.f11302b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 4).edit().remove("build_model").commit();
        }
    }
}
