package com.umeng.analytics;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.common.C3443b;

/* compiled from: InternalConfig.java */
/* renamed from: com.umeng.analytics.c */
/* loaded from: classes2.dex */
public class C3311c {

    /* renamed from: a */
    private static String[] f11401a = new String[2];

    /* renamed from: a */
    public static void m10791a(Context context, String str, String str2) {
        String[] strArr = f11401a;
        strArr[0] = str;
        strArr[1] = str2;
        if (context != null) {
            C3443b.m11503a(context).m11510a(str, str2);
        }
    }

    /* renamed from: b */
    public static void m10793b(Context context) {
        String[] strArr = f11401a;
        strArr[0] = null;
        strArr[1] = null;
        if (context != null) {
            C3443b.m11503a(context).m11512b();
        }
    }

    /* renamed from: a */
    public static String[] m10792a(Context context) {
        String[] m11511a;
        if (!TextUtils.isEmpty(f11401a[0]) && !TextUtils.isEmpty(f11401a[1])) {
            return f11401a;
        }
        if (context == null || (m11511a = C3443b.m11503a(context).m11511a()) == null) {
            return null;
        }
        String[] strArr = f11401a;
        strArr[0] = m11511a[0];
        strArr[1] = m11511a[1];
        return strArr;
    }
}
