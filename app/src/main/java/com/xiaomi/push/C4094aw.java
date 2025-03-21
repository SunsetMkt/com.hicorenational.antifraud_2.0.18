package com.xiaomi.push;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.xiaomi.push.aw */
/* loaded from: classes2.dex */
public class C4094aw {

    /* renamed from: a */
    private static final Map<Class<?>, Class<?>> f14582a = new HashMap();

    /* renamed from: com.xiaomi.push.aw$a */
    public static class a<T> {

        /* renamed from: a */
        public final Class<? extends T> f14583a;

        /* renamed from: a */
        public final T f14584a;
    }

    static {
        f14582a.put(Boolean.class, Boolean.TYPE);
        f14582a.put(Byte.class, Byte.TYPE);
        f14582a.put(Character.class, Character.TYPE);
        f14582a.put(Short.class, Short.TYPE);
        f14582a.put(Integer.class, Integer.TYPE);
        f14582a.put(Float.class, Float.TYPE);
        f14582a.put(Long.class, Long.TYPE);
        f14582a.put(Double.class, Double.TYPE);
        Map<Class<?>, Class<?>> map = f14582a;
        Class<?> cls = Boolean.TYPE;
        map.put(cls, cls);
        Map<Class<?>, Class<?>> map2 = f14582a;
        Class<?> cls2 = Byte.TYPE;
        map2.put(cls2, cls2);
        Map<Class<?>, Class<?>> map3 = f14582a;
        Class<?> cls3 = Character.TYPE;
        map3.put(cls3, cls3);
        Map<Class<?>, Class<?>> map4 = f14582a;
        Class<?> cls4 = Short.TYPE;
        map4.put(cls4, cls4);
        Map<Class<?>, Class<?>> map5 = f14582a;
        Class<?> cls5 = Integer.TYPE;
        map5.put(cls5, cls5);
        Map<Class<?>, Class<?>> map6 = f14582a;
        Class<?> cls6 = Float.TYPE;
        map6.put(cls6, cls6);
        Map<Class<?>, Class<?>> map7 = f14582a;
        Class<?> cls7 = Long.TYPE;
        map7.put(cls7, cls7);
        Map<Class<?>, Class<?>> map8 = f14582a;
        Class<?> cls8 = Double.TYPE;
        map8.put(cls8, cls8);
    }

    /* renamed from: a */
    public static <T> T m13821a(Object obj, String str) {
        try {
            return (T) m13818a((Class<? extends Object>) obj.getClass(), obj, str);
        } catch (Exception e2) {
            String str2 = "Meet exception when call getField '" + str + "' in " + obj + ", " + e2;
            return null;
        }
    }

    /* renamed from: b */
    public static void m13832b(Object obj, String str, Object obj2) {
        Class<?> cls = obj.getClass();
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        field.set(obj, obj2);
    }

    /* renamed from: a */
    public static <T> T m13819a(Class<? extends Object> cls, String str) {
        try {
            return (T) m13818a(cls, (Object) null, str);
        } catch (Exception e2) {
            StringBuilder sb = new StringBuilder();
            sb.append("Meet exception when call getStaticField '");
            sb.append(str);
            sb.append("' in ");
            sb.append(cls != null ? cls.getSimpleName() : "");
            sb.append(", ");
            sb.append(e2);
            sb.toString();
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m13823a(String str, String str2) {
        try {
            return (T) m13818a((Class<? extends Object>) C4309r.m15716a(null, str), (Object) null, str2);
        } catch (Exception e2) {
            String str3 = "Meet exception when call getStaticField '" + str2 + "' in " + str + ", " + e2;
            return null;
        }
    }

    /* renamed from: b */
    public static <T> T m13831b(Object obj, String str, Object... objArr) {
        return (T) m13825a(obj.getClass(), str, m13829a(objArr)).invoke(obj, m13830a(objArr));
    }

    /* renamed from: a */
    public static <T> T m13818a(Class<? extends Object> cls, Object obj, String str) {
        Field field = null;
        while (field == null) {
            try {
                field = cls.getDeclaredField(str);
                field.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                cls = cls.getSuperclass();
            }
            if (cls == null) {
                throw new NoSuchFieldException();
            }
        }
        field.setAccessible(true);
        return (T) field.get(obj);
    }

    /* renamed from: a */
    public static void m13827a(Object obj, String str, Object obj2) {
        try {
            m13832b(obj, str, obj2);
        } catch (Exception e2) {
            String str2 = "Meet exception when call setField '" + str + "' in " + obj + ", " + e2;
        }
    }

    /* renamed from: a */
    public static <T> T m13822a(Object obj, String str, Object... objArr) {
        try {
            return (T) m13831b(obj, str, objArr);
        } catch (Exception e2) {
            String str2 = "Meet exception when call Method '" + str + "' in " + obj + ", " + e2;
            return null;
        }
    }

    /* renamed from: a */
    public static <T> T m13824a(String str, String str2, Object... objArr) {
        try {
            return (T) m13820a(C4309r.m15716a(null, str), str2, objArr);
        } catch (Exception e2) {
            String str3 = "Meet exception when call Method '" + str2 + "' in " + str + ", " + e2;
            return null;
        }
    }

    /* renamed from: a */
    private static Method m13825a(Class<?> cls, String str, Class<?>... clsArr) {
        Method m13826a = m13826a(cls.getDeclaredMethods(), str, clsArr);
        if (m13826a == null) {
            if (cls.getSuperclass() != null) {
                return m13825a((Class<?>) cls.getSuperclass(), str, clsArr);
            }
            throw new NoSuchMethodException();
        }
        m13826a.setAccessible(true);
        return m13826a;
    }

    /* renamed from: a */
    private static Method m13826a(Method[] methodArr, String str, Class<?>[] clsArr) {
        if (str != null) {
            for (Method method : methodArr) {
                if (method.getName().equals(str) && m13828a(method.getParameterTypes(), clsArr)) {
                    return method;
                }
            }
            return null;
        }
        throw new NullPointerException("Method name must not be null.");
    }

    /* renamed from: a */
    private static boolean m13828a(Class<?>[] clsArr, Class<?>[] clsArr2) {
        if (clsArr == null) {
            return clsArr2 == null || clsArr2.length == 0;
        }
        if (clsArr2 == null) {
            return clsArr.length == 0;
        }
        if (clsArr.length != clsArr2.length) {
            return false;
        }
        for (int i2 = 0; i2 < clsArr.length; i2++) {
            if (clsArr2[i2] != null && !clsArr[i2].isAssignableFrom(clsArr2[i2]) && (!f14582a.containsKey(clsArr[i2]) || !f14582a.get(clsArr[i2]).equals(f14582a.get(clsArr2[i2])))) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    public static <T> T m13820a(Class<?> cls, String str, Object... objArr) {
        return (T) m13825a(cls, str, m13829a(objArr)).invoke(null, m13830a(objArr));
    }

    /* renamed from: a */
    private static Class<?>[] m13829a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Class<?>[] clsArr = new Class[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof a)) {
                clsArr[i2] = ((a) obj).f14583a;
            } else {
                clsArr[i2] = obj == null ? null : obj.getClass();
            }
        }
        return clsArr;
    }

    /* renamed from: a */
    private static Object[] m13830a(Object... objArr) {
        if (objArr == null || objArr.length <= 0) {
            return null;
        }
        Object[] objArr2 = new Object[objArr.length];
        for (int i2 = 0; i2 < objArr.length; i2++) {
            Object obj = objArr[i2];
            if (obj != null && (obj instanceof a)) {
                objArr2[i2] = ((a) obj).f14584a;
            } else {
                objArr2[i2] = obj;
            }
        }
        return objArr2;
    }
}
