package com.vivo.push.util;

import android.os.Build;
import android.os.UserHandle;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: MultiUserManager.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w {
    private static int a = -1;

    public static int a() {
        if (Build.VERSION.SDK_INT < 17) {
            return 0;
        }
        int i2 = a;
        if (i2 != -1) {
            return i2;
        }
        try {
            Method declaredMethod = UserHandle.class.getDeclaredMethod("myUserId", new Class[0]);
            declaredMethod.setAccessible(true);
            a = ((Integer) declaredMethod.invoke(null, null)).intValue();
            u.d("MultiUserManager", "getMyUserId = " + a);
            return a;
        } catch (Exception e2) {
            u.a("MultiUserManager", "getMyUserId error " + e2.getMessage());
            return 0;
        }
    }
}
