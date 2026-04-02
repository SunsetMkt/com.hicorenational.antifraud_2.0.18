package com.tencent.open.utils;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.open.log.SLog;

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class f {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f6913b;

    /* JADX INFO: compiled from: ProGuard */
    private static class a {
        private static f a = new f();
    }

    public static f a() {
        return a.a;
    }

    public String b(Context context) {
        return this.a;
    }

    public String c(Context context) {
        return this.f6913b;
    }

    private f() {
        this.a = "";
        this.f6913b = "";
    }

    public void a(Context context) {
        if (context == null) {
            return;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("device_info_file", 4);
        String str = this.f6913b;
        if (str == null || str.trim().isEmpty()) {
            this.f6913b = sharedPreferences.getString("build_model", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, model = " + this.f6913b);
        }
        String str2 = this.a;
        if (str2 == null || str2.trim().isEmpty()) {
            this.a = sharedPreferences.getString("build_device", "");
            SLog.i("openSDK_LOG.DeviceInfoUtils", "init, device = " + this.a);
        }
    }

    public String b() {
        return this.f6913b;
    }

    public void a(Context context, String str) {
        SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, model = " + str);
        if (str != null && !str.trim().isEmpty()) {
            String str2 = this.f6913b;
            if (str2 != null && str2.equals(str)) {
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, needn't update sp.");
                return;
            }
            this.f6913b = str;
            if (context != null) {
                context.getSharedPreferences("device_info_file", 4).edit().putString("build_model", this.f6913b).commit();
                SLog.i("openSDK_LOG.DeviceInfoUtils", "setBuildModel, update sp.");
                return;
            }
            return;
        }
        this.f6913b = "";
        if (context != null) {
            context.getSharedPreferences("device_info_file", 4).edit().remove("build_model").commit();
        }
    }
}
