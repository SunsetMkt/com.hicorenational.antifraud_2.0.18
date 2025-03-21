package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* loaded from: classes2.dex */
public class ba {
    public static Method a(String str, String str2, Class<?>... clsArr) {
        Class<?> a2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a2 = a(str)) == null) {
            return null;
        }
        try {
            return a2.getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            UPLog.e("", "getMethod failed, cls:", str, "method:", str2, "msg:", th.getMessage());
            return null;
        }
    }

    public static Object a(Method method, Object obj, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            UPLog.e("", "invoke failed:", th.getMessage());
            return null;
        }
    }

    public static Object a(String str, String str2, Class<?>[] clsArr, Object obj, Object[] objArr) {
        Method a2 = a(str, str2, clsArr);
        if (a2 != null) {
            return a(a2, obj, objArr);
        }
        return null;
    }

    public static Field a(String str, String str2) {
        Class<?> a2;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (a2 = a(str)) == null) {
            return null;
        }
        try {
            return a2.getField(str2);
        } catch (Throwable th) {
            UPLog.e("", "getFiled failed, cls:", str, "filed:", str2, "msg:", th.getMessage());
            return null;
        }
    }

    public static Object a(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (Throwable th) {
            UPLog.e("", "getFiledValue failed:", th.getMessage());
            return null;
        }
    }

    public static Object a(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> a2 = a(str);
        if (a2 == null) {
            return null;
        }
        try {
            return a2.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            UPLog.e("", "newInstance failed, cls:", str, "msg:", th.getMessage());
            return null;
        }
    }

    public static Class<?> a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = ba.class.getClassLoader();
        }
        try {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return Class.forName(str, true, ba.class.getClassLoader());
        }
    }
}
