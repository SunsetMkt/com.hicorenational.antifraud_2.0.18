package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import java.io.File;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.huawei.hms.hatool.c0 */
/* loaded from: classes.dex */
public class C2401c0 {
    /* renamed from: a */
    public static boolean m7057a(Context context) {
        return System.currentTimeMillis() - C2403d.m7068a(context, "Privacy_MY", "flashKeyTime", -1L) > C2084a.f6125g;
    }

    /* renamed from: a */
    public static boolean m7058a(Context context, String str) {
        if (context == null) {
            return true;
        }
        if (Build.VERSION.SDK_INT < 23) {
            if (context.getPackageManager().checkPermission(str, context.getPackageName()) == 0) {
                return false;
            }
            C2452v.m7390f("hmsSdk", "not have read phone permission!");
            return true;
        }
        if (context.checkSelfPermission(str) == 0) {
            return false;
        }
        C2452v.m7390f("hmsSdk", "not have read phone permission!");
        return true;
    }

    @SuppressLint({"DefaultLocale"})
    /* renamed from: a */
    public static boolean m7059a(Context context, String str, int i2) {
        String str2 = C2403d.m7075c(context, str) + ".xml";
        File file = new File(context.getFilesDir(), "../shared_prefs/" + str2);
        if (!file.exists()) {
            String str3 = context.getPackageName() + AbstractC1191a.f2606s1 + str2;
            file = new File(context.getFilesDir(), "../../shared_prefs/" + str3);
        }
        long length = file.length();
        if (length <= i2) {
            return false;
        }
        C2452v.m7385c("hmsSdk", String.format("reach local file limited size - file len: %d limitedSize: %d", Long.valueOf(length), Integer.valueOf(i2)));
        return true;
    }

    /* renamed from: a */
    public static boolean m7060a(String str, long j2, long j3) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            return j2 - Long.parseLong(str) > j3;
        } catch (NumberFormatException unused) {
            C2452v.m7390f("hmsSdk", "isTimeExpired(): Data type conversion error : number format !");
            return true;
        }
    }
}
