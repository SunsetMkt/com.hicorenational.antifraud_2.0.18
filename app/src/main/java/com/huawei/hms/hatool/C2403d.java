package com.huawei.hms.hatool;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

@SuppressLint({"ApplySharedPref"})
/* renamed from: com.huawei.hms.hatool.d */
/* loaded from: classes.dex */
public class C2403d {
    /* renamed from: a */
    public static long m7068a(Context context, String str, String str2, long j2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2452v.m7390f("hmsSdk", "context is null or spName empty or spkey is empty");
            return j2;
        }
        SharedPreferences m7072b = m7072b(context, str);
        return m7072b != null ? m7072b.getLong(str2, j2) : j2;
    }

    /* renamed from: a */
    public static String m7069a(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2452v.m7390f("hmsSdk", "context is null or spName empty or spkey is empty");
            return str3;
        }
        SharedPreferences m7072b = m7072b(context, str);
        return m7072b != null ? m7072b.getString(str2, str3) : str3;
    }

    /* renamed from: a */
    public static Map<String, ?> m7070a(Context context, String str) {
        return m7072b(context, str).getAll();
    }

    /* renamed from: a */
    public static void m7071a(Context context, String str, String... strArr) {
        String str2;
        if (context == null || TextUtils.isEmpty(str)) {
            str2 = "clearData(): parameter error.context,spname";
        } else {
            if (strArr != null) {
                SharedPreferences m7072b = m7072b(context, str);
                if (m7072b != null) {
                    SharedPreferences.Editor edit = m7072b.edit();
                    if (strArr.length == 0) {
                        edit.clear();
                        edit.commit();
                        return;
                    }
                    for (String str3 : strArr) {
                        if (m7072b.contains(str3)) {
                            edit.remove(str3);
                            edit.commit();
                        }
                    }
                    return;
                }
                return;
            }
            str2 = "clearData(): No data need to be deleted,keys is null";
        }
        C2452v.m7390f("hmsSdk", str2);
    }

    /* renamed from: b */
    private static SharedPreferences m7072b(Context context, String str) {
        return context.getSharedPreferences(m7075c(context, str), 0);
    }

    /* renamed from: b */
    public static void m7073b(Context context, String str, String str2, long j2) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2452v.m7390f("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences m7072b = m7072b(context, str);
        if (m7072b != null) {
            SharedPreferences.Editor edit = m7072b.edit();
            edit.putLong(str2, j2);
            edit.commit();
        }
    }

    /* renamed from: b */
    public static void m7074b(Context context, String str, String str2, String str3) {
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            C2452v.m7389e("hmsSdk", "context is null or spName empty or spkey is empty");
            return;
        }
        SharedPreferences m7072b = m7072b(context, str);
        if (m7072b != null) {
            SharedPreferences.Editor edit = m7072b.edit();
            edit.putString(str2, str3);
            edit.commit();
        }
    }

    /* renamed from: c */
    public static String m7075c(Context context, String str) {
        String packageName = context.getPackageName();
        String m7032n = AbstractC2396a1.m7032n("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(m7032n)) {
            return "hms_" + str + AbstractC1191a.f2606s1 + packageName;
        }
        return "hms_" + str + AbstractC1191a.f2606s1 + packageName + AbstractC1191a.f2606s1 + m7032n;
    }
}
