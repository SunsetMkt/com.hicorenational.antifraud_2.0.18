package com.umeng.p221ut.p222a.p225c;

import android.content.Context;
import com.umeng.commonsdk.framework.UMFrUtils;

/* renamed from: com.umeng.ut.a.c.c */
/* loaded from: classes2.dex */
public class C3808c {
    /* renamed from: b */
    public static boolean m12776b(Context context) {
        if (context == null) {
            return true;
        }
        try {
            return UMFrUtils.isOnline(context);
        } catch (Throwable th) {
            C3810e.m12783a("", th, new Object[0]);
            return true;
        }
    }
}
