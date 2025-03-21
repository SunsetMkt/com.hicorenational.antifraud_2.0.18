package com.umeng.socialize.p215a;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: UMReflectUtils.java */
/* renamed from: com.umeng.socialize.a.k */
/* loaded from: classes2.dex */
public class C3625k {
    /* renamed from: a */
    public static Method m12555a(String str, String str2, Class<?>... clsArr) {
        Class<?> m12548a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m12548a = m12548a(str)) == null) {
            return null;
        }
        try {
            return m12548a.getDeclaredMethod(str2, clsArr);
        } catch (Throwable th) {
            C3627m.m12568d("", "getMethod failed, cls:", str, " method:", str2, " msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12553a(Method method, Object obj, Object[] objArr) {
        if (method == null) {
            return null;
        }
        try {
            if (!method.isAccessible()) {
                method.setAccessible(true);
            }
            return method.invoke(obj, objArr);
        } catch (Throwable th) {
            C3627m.m12568d("", "invoke failed:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12550a(String str, String str2, Class<?>[] clsArr, Object obj, Object[] objArr) {
        Method m12555a = m12555a(str, str2, clsArr);
        if (m12555a != null) {
            return m12553a(m12555a, obj, objArr);
        }
        return null;
    }

    /* renamed from: a */
    public static Field m12554a(String str, String str2) {
        Class<?> m12548a;
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || (m12548a = m12548a(str)) == null) {
            return null;
        }
        try {
            return m12548a.getField(str2);
        } catch (Throwable th) {
            C3627m.m12568d("", "getFiled failed, cls:", str, " filed:", str2, " msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12549a(String str, String str2, Object obj) {
        return m12552a(m12554a(str, str2), obj);
    }

    /* renamed from: a */
    public static Object m12552a(Field field, Object obj) {
        if (field == null) {
            return null;
        }
        try {
            if (!field.isAccessible()) {
                field.setAccessible(true);
            }
            return field.get(obj);
        } catch (Throwable th) {
            C3627m.m12568d("", "getFiledValue failed:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Object m12551a(String str, Class<?>[] clsArr, Object[] objArr) {
        Class<?> m12548a = m12548a(str);
        if (m12548a == null) {
            return null;
        }
        try {
            return m12548a.getConstructor(clsArr).newInstance(objArr);
        } catch (Throwable th) {
            C3627m.m12568d("", "newInstance failed, cls:", str, " msg:", th.getMessage());
            return null;
        }
    }

    /* renamed from: a */
    public static Class<?> m12548a(String str) {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = C3625k.class.getClassLoader();
        }
        try {
            try {
                return Class.forName(str, true, contextClassLoader);
            } catch (Throwable unused) {
                return null;
            }
        } catch (Throwable unused2) {
            return Class.forName(str, true, C3625k.class.getClassLoader());
        }
    }
}
