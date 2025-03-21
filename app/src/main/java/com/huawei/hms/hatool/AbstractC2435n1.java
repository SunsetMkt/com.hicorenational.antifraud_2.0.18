package com.huawei.hms.hatool;

import android.util.Pair;
import com.xiaomi.mipush.sdk.Constants;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

/* renamed from: com.huawei.hms.hatool.n1 */
/* loaded from: classes.dex */
public abstract class AbstractC2435n1 {
    /* renamed from: a */
    public static long m7250a(String str, long j2) {
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(str, Locale.getDefault());
            return simpleDateFormat.parse(simpleDateFormat.format(Long.valueOf(j2))).getTime();
        } catch (ParseException unused) {
            C2452v.m7390f("hmsSdk/stringUtil", "getMillisOfDate(): Time conversion Exception !");
            return 0L;
        }
    }

    /* renamed from: a */
    public static Pair<String, String> m7251a(String str) {
        String str2;
        String str3;
        if ("_default_config_tag".equals(str)) {
            return new Pair<>(str, "");
        }
        String[] split = str.split(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
        if (split.length > 2) {
            str3 = split[split.length - 1];
            str2 = str.substring(0, (str.length() - str3.length()) - 1);
        } else {
            str2 = split[0];
            str3 = split[1];
        }
        return new Pair<>(str2, str3);
    }

    /* renamed from: a */
    public static String m7252a(int i2) {
        return i2 != 0 ? i2 != 1 ? i2 != 2 ? i2 != 3 ? "alltype" : "diffprivacy" : "preins" : "maint" : "oper";
    }

    /* renamed from: a */
    public static String m7253a(String str, String str2) {
        if ("_default_config_tag".equals(str)) {
            return str;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2;
    }

    /* renamed from: a */
    public static String m7254a(String str, String str2, String str3) {
        if ("_default_config_tag".equals(str)) {
            return "_default_config_tag#" + str3;
        }
        return str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + str2 + "#" + str3;
    }

    /* renamed from: a */
    public static Set<String> m7255a(Set<String> set) {
        if (set == null || set.size() == 0) {
            return new HashSet();
        }
        HashSet hashSet = new HashSet();
        for (String str : set) {
            if ("_default_config_tag".equals(str)) {
                hashSet.add("_default_config_tag");
            } else {
                String str2 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "oper";
                String str3 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "maint";
                String str4 = str + Constants.ACCEPT_TIME_SEPARATOR_SERVER + "diffprivacy";
                hashSet.add(str2);
                hashSet.add(str3);
                hashSet.add(str4);
            }
        }
        return hashSet;
    }
}
