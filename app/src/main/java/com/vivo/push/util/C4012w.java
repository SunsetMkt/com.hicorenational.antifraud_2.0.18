package com.vivo.push.util;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* compiled from: MultiUserManager.java */
/* renamed from: com.vivo.push.util.w */
/* loaded from: classes2.dex */
public final class C4012w {

    /* renamed from: a */
    private static int f14281a = -1;

    /* renamed from: a */
    public static int m13314a() {
        if (Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        int i2 = f14281a;
        if (i2 != -1) {
            return i2;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            f14281a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            C4010u.m13309d("MultiUserManager", "getMyUserId = " + f14281a);
            return f14281a;
        } catch (Exception e2) {
            C4010u.m13292a("MultiUserManager", "getMyUserId error " + e2.getMessage());
            return 0;
        }
    }
}
