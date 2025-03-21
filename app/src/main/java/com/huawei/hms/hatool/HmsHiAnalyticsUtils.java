package com.huawei.hms.hatool;

import android.content.Context;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public class HmsHiAnalyticsUtils {
    public static void enableLog() {
        C2400c.m7055a();
    }

    public static boolean getInitFlag() {
        return AbstractC2394a.m7016b();
    }

    public static void init(Context context, boolean z, boolean z2, boolean z3, String str, String str2) {
        new C2397b(context).m7036a(z).m7039c(z2).m7038b(z3).m7034a(0, str).m7034a(1, str).m7035a(str2).m7037a();
    }

    public static void onEvent(Context context, String str, String str2) {
        AbstractC2394a.m7014a(context, str, str2);
    }

    public static void onReport() {
        AbstractC2394a.m7017c();
    }

    public static void onStreamEvent(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        AbstractC2394a.m7015b(i2, str, linkedHashMap);
    }

    public static void onEvent(int i2, String str, LinkedHashMap<String, String> linkedHashMap) {
        AbstractC2394a.m7013a(i2, str, linkedHashMap);
    }
}
