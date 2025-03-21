package com.tencent.bugly.crashreport;

import androidx.exifinterface.media.ExifInterface;
import com.tencent.bugly.C3072b;
import com.tencent.bugly.proguard.C3153ap;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: BUGLY */
/* loaded from: classes2.dex */
public class BuglyLog {
    /* renamed from: d */
    public static void m9465d(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = AbstractC1191a.f2571h;
        }
        boolean z = C3072b.f9834c;
        C3153ap.m9931a("D", str, str2);
    }

    /* renamed from: e */
    public static void m9466e(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = AbstractC1191a.f2571h;
        }
        boolean z = C3072b.f9834c;
        C3153ap.m9931a(ExifInterface.LONGITUDE_EAST, str, str2);
    }

    /* renamed from: i */
    public static void m9468i(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = AbstractC1191a.f2571h;
        }
        boolean z = C3072b.f9834c;
        C3153ap.m9931a("I", str, str2);
    }

    public static void setCache(int i2) {
        C3153ap.m9929a(i2);
    }

    /* renamed from: v */
    public static void m9469v(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = AbstractC1191a.f2571h;
        }
        boolean z = C3072b.f9834c;
        C3153ap.m9931a(ExifInterface.GPS_MEASUREMENT_INTERRUPTED, str, str2);
    }

    /* renamed from: w */
    public static void m9470w(String str, String str2) {
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = AbstractC1191a.f2571h;
        }
        boolean z = C3072b.f9834c;
        C3153ap.m9931a(ExifInterface.LONGITUDE_WEST, str, str2);
    }

    /* renamed from: e */
    public static void m9467e(String str, String str2, Throwable th) {
        if (str == null) {
            str = "";
        }
        boolean z = C3072b.f9834c;
        C3153ap.m9932a(ExifInterface.LONGITUDE_EAST, str, th);
    }
}
