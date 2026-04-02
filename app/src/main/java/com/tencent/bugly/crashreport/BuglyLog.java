package com.tencent.bugly.crashreport;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.b;
import com.tencent.bugly.proguard.ap;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public class BuglyLog {
    public static void d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = d.c.a.b.a.a.f10075h;
        }
        boolean z = b.f5995c;
        ap.a("D", str, str2);
    }

    public static void e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = d.c.a.b.a.a.f10075h;
        }
        boolean z = b.f5995c;
        ap.a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    public static void i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = d.c.a.b.a.a.f10075h;
        }
        boolean z = b.f5995c;
        ap.a("I", str, str2);
    }

    public static void setCache(int i2) {
        ap.a(i2);
    }

    public static void v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = d.c.a.b.a.a.f10075h;
        }
        boolean z = b.f5995c;
        ap.a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    public static void w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = d.c.a.b.a.a.f10075h;
        }
        boolean z = b.f5995c;
        ap.a(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    public static void e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        boolean z = b.f5995c;
        ap.a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
