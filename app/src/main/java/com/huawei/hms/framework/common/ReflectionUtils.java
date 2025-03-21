package com.huawei.hms.framework.common;

import android.text.TextUtils;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.security.AccessController;
import java.security.PrivilegedAction;

/* loaded from: classes.dex */
public class ReflectionUtils {
    private static final String TAG = "ReflectionUtils";

    public static boolean checkCompatible(String str) {
        try {
            tryLoadClass(str);
            return true;
        } catch (Exception unused) {
            Logger.m6803w(TAG, str + "ClassNotFoundException");
            return false;
        }
    }

    private static Class<?> getClass(String str) {
        if (str == null) {
            return null;
        }
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException unused) {
            return null;
        }
    }

    public static Field getField(Object obj, String str) {
        if (obj != null && !TextUtils.isEmpty(str)) {
            try {
                final Field declaredField = obj.getClass().getDeclaredField(str);
                AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.2
                    @Override // java.security.PrivilegedAction
                    public Object run() {
                        declaredField.setAccessible(true);
                        return null;
                    }
                });
                return declaredField;
            } catch (IllegalArgumentException e2) {
                Logger.m6797e(TAG, "Exception in getField :: IllegalArgumentException:", e2);
            } catch (NoSuchFieldException e3) {
                Logger.m6797e(TAG, "Exception in getField :: NoSuchFieldException:", e3);
            } catch (SecurityException e4) {
                Logger.m6797e(TAG, "not security int method getField,SecurityException:", e4);
            }
        }
        return null;
    }

    public static Object getFieldObj(Object obj, String str) {
        if (obj == null || TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            final Field declaredField = obj.getClass().getDeclaredField(str);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.1
                @Override // java.security.PrivilegedAction
                public Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(obj);
        } catch (IllegalAccessException e2) {
            Logger.m6797e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e2);
            return null;
        } catch (IllegalArgumentException e3) {
            Logger.m6797e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e3);
            return null;
        } catch (NoSuchFieldException e4) {
            Logger.m6797e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e4);
            return null;
        } catch (SecurityException e5) {
            Logger.m6797e(TAG, "not security int method getFieldObj,SecurityException:", e5);
            return null;
        }
    }

    public static Method getMethod(Class<?> cls, String str, Class<?>... clsArr) {
        if (cls == null || str == null) {
            Logger.m6803w(TAG, "targetClass is  null pr name is null:");
            return null;
        }
        try {
            return cls.getDeclaredMethod(str, clsArr);
        } catch (NoSuchMethodException e2) {
            Logger.m6797e(TAG, "NoSuchMethodException:", e2);
            return null;
        } catch (SecurityException e3) {
            Logger.m6797e(TAG, "SecurityException:", e3);
            return null;
        }
    }

    public static Object getStaticFieldObj(String str, String str2) {
        Class<?> cls;
        if (str == null || (cls = getClass(str)) == null || TextUtils.isEmpty(str2)) {
            return null;
        }
        try {
            final Field declaredField = cls.getDeclaredField(str2);
            AccessController.doPrivileged(new PrivilegedAction() { // from class: com.huawei.hms.framework.common.ReflectionUtils.3
                @Override // java.security.PrivilegedAction
                public Object run() {
                    declaredField.setAccessible(true);
                    return null;
                }
            });
            return declaredField.get(cls);
        } catch (IllegalAccessException e2) {
            Logger.m6797e(TAG, "Exception in getFieldObj :: IllegalAccessException:", e2);
            return null;
        } catch (IllegalArgumentException e3) {
            Logger.m6797e(TAG, "Exception in getFieldObj :: IllegalArgumentException:", e3);
            return null;
        } catch (NoSuchFieldException e4) {
            Logger.m6797e(TAG, "Exception in getFieldObj :: NoSuchFieldException:", e4);
            return null;
        } catch (SecurityException e5) {
            Logger.m6797e(TAG, "not security int method getStaticFieldObj,SecurityException:", e5);
            return null;
        }
    }

    private static Object invoke(Object obj, Method method, Object... objArr) throws UnsupportedOperationException {
        if (method == null) {
            return null;
        }
        try {
            return method.invoke(obj, objArr);
        } catch (RuntimeException e2) {
            Logger.m6797e(TAG, "RuntimeException in invoke:", e2);
            return null;
        } catch (Exception e3) {
            Logger.m6797e(TAG, "Exception in invoke:", e3);
            return null;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Object... objArr) {
        Class[] clsArr;
        if (str == null) {
            return null;
        }
        if (objArr != null) {
            int length = objArr.length;
            clsArr = new Class[length];
            for (int i2 = 0; i2 < length; i2++) {
                setClassType(clsArr, objArr[i2], i2);
            }
        } else {
            clsArr = null;
        }
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }

    private static void setClassType(Class<?>[] clsArr, Object obj, int i2) {
        if (obj instanceof Integer) {
            clsArr[i2] = Integer.TYPE;
            return;
        }
        if (obj instanceof Long) {
            clsArr[i2] = Long.TYPE;
            return;
        }
        if (obj instanceof Double) {
            clsArr[i2] = Double.TYPE;
            return;
        }
        if (obj instanceof Float) {
            clsArr[i2] = Float.TYPE;
            return;
        }
        if (obj instanceof Boolean) {
            clsArr[i2] = Boolean.TYPE;
            return;
        }
        if (obj instanceof Character) {
            clsArr[i2] = Character.TYPE;
            return;
        }
        if (obj instanceof Byte) {
            clsArr[i2] = Byte.TYPE;
            return;
        }
        if (obj instanceof Void) {
            clsArr[i2] = Void.TYPE;
        } else if (obj instanceof Short) {
            clsArr[i2] = Short.TYPE;
        } else {
            clsArr[i2] = obj.getClass();
        }
    }

    private static void tryLoadClass(String str) throws ClassNotFoundException {
        ClassLoader classLoader = ReflectionUtils.class.getClassLoader();
        if (classLoader == null) {
            throw new ClassNotFoundException("not found classloader");
        }
        classLoader.loadClass(str);
    }

    public static boolean checkCompatible(String str, String str2, Class<?>... clsArr) {
        try {
            if (str != null && str2 != null) {
                Class.forName(str).getDeclaredMethod(str2, clsArr);
                Logger.m6801v(TAG, "has method : " + str2);
                return true;
            }
            Logger.m6803w(TAG, "targetClass is  null or name is null:");
            return false;
        } catch (RuntimeException unused) {
            Logger.m6803w(TAG, str + " RuntimeException");
            return false;
        } catch (Exception unused2) {
            Logger.m6803w(TAG, str2 + " NoSuchMethodException");
            return false;
        }
    }

    public static Object invokeStaticMethod(String str, String str2, Class<?>[] clsArr, Object... objArr) {
        Method method = getMethod(getClass(str), str2, clsArr);
        if (method == null) {
            return null;
        }
        return invoke(null, method, objArr);
    }
}
