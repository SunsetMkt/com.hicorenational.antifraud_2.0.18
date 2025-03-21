package com.umeng.message.proguard;

import android.text.TextUtils;
import com.umeng.message.common.UPLog;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* renamed from: com.umeng.message.proguard.ba */
/* loaded from: classes2.dex */
public class C3579ba {
    /* renamed from: a */
    public static Method m12335a(String str, String str2, Class<?>... clsArr) {
        Class<?> m12329a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m12329a = m12329a(str)) == null) {
            return null;
        }
        try {
            return m12329a.getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            UPLog.m12144e("", "getMethod failed, cls:", str, "method:", str2, "msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12333a(Method method, Object obj, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            UPLog.m12144e("", "invoke failed:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12330a(String str, String str2, Class<?>[] clsArr, Object obj, Object[] objArr) {
        Method m12335a = m12335a(str, str2, clsArr);
        if (m12335a != null) {
            return m12333a(m12335a, obj, objArr);
        }
        return null;
    }

    /* renamed from: a */
    public static Field m12334a(String str, String str2) {
        Class<?> m12329a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m12329a = m12329a(str)) == null) {
            return null;
        }
        try {
            return m12329a.getField(str2);
        } catch (Throwable th) {
            UPLog.m12144e("", "getFiled failed, cls:", str, "filed:", str2, "msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12332a(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (Throwable th) {
            UPLog.m12144e("", "getFiledValue failed:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12331a(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> m12329a = m12329a(str);
        if (m12329a == null) {
            return null;
        }
        try {
            return m12329a.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            UPLog.m12144e("", "newInstance failed, cls:", str, "msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m12329a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = C3579ba.class.getClassLoader();
        }
        try {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return Class.forName(str, true, C3579ba.class.getClassLoader());
        }
    }
}
