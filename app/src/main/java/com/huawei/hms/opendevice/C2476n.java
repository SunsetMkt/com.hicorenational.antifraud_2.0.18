package com.huawei.hms.opendevice;

import android.text.TextUtils;

/* compiled from: StringUtils.java */
/* renamed from: com.huawei.hms.opendevice.n */
/* loaded from: classes.dex */
public class C2476n {
    /* renamed from: a */
    public static boolean m7504a(String... strArr) {
        for (String str : strArr) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
        }
        return true;
    }
}
