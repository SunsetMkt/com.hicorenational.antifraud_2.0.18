package com.huawei.hms.base.p172ui;

import android.text.TextUtils;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public class LogUtil {

    /* renamed from: a */
    private static final Pattern f7190a = Pattern.compile("[0-9]*[a-z|A-Z]*[一-龥]*");

    /* renamed from: a */
    private static String m6682a(String str, boolean z) {
        StringBuilder sb = new StringBuilder(512);
        if (!TextUtils.isEmpty(str)) {
            if (z) {
                sb.append(m6681a(str));
            } else {
                sb.append(str);
            }
        }
        return sb.toString();
    }

    /* renamed from: e */
    public static void m6684e(String str, String str2, boolean z) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m6682a(str2, z);
    }

    /* renamed from: e */
    public static void m6683e(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        m6682a(str2, false);
    }

    /* renamed from: a */
    private static String m6681a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int length = str.length();
        int i2 = 1;
        if (1 == length) {
            return String.valueOf('*');
        }
        StringBuilder sb = new StringBuilder(length);
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (f7190a.matcher(String.valueOf(charAt)).matches()) {
                if (i2 % 2 == 0) {
                    charAt = '*';
                }
                i2++;
            }
            sb.append(charAt);
        }
        return sb.toString();
    }
}
