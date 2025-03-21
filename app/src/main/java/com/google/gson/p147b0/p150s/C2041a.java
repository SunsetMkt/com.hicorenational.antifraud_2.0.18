package com.google.gson.p147b0.p150s;

import com.google.gson.C2064l;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: ReflectionHelper.java */
/* renamed from: com.google.gson.b0.s.a */
/* loaded from: classes.dex */
public class C2041a {

    /* renamed from: a */
    private static final b f5880a;

    /* compiled from: ReflectionHelper.java */
    /* renamed from: com.google.gson.b0.s.a$b */
    private static abstract class b {
        private b() {
        }

        /* renamed from: a */
        abstract <T> Constructor<T> mo5540a(Class<T> cls);

        /* renamed from: a */
        public abstract Method mo5541a(Class<?> cls, Field field);

        /* renamed from: b */
        abstract String[] mo5542b(Class<?> cls);

        /* renamed from: c */
        abstract boolean mo5543c(Class<?> cls);
    }

    /* compiled from: ReflectionHelper.java */
    /* renamed from: com.google.gson.b0.s.a$c */
    private static class c extends b {
        private c() {
            super();
        }

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: a */
        <T> Constructor<T> mo5540a(Class<T> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: b */
        String[] mo5542b(Class<?> cls) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: c */
        boolean mo5543c(Class<?> cls) {
            return false;
        }

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: a */
        public Method mo5541a(Class<?> cls, Field field) {
            throw new UnsupportedOperationException("Records are not supported on this JVM, this method should not be called");
        }
    }

    /* compiled from: ReflectionHelper.java */
    /* renamed from: com.google.gson.b0.s.a$d */
    private static class d extends b {

        /* renamed from: a */
        private final Method f5881a;

        /* renamed from: b */
        private final Method f5882b;

        /* renamed from: c */
        private final Method f5883c;

        /* renamed from: d */
        private final Method f5884d;

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: a */
        public <T> Constructor<T> mo5540a(Class<T> cls) {
            try {
                Object[] objArr = (Object[]) this.f5882b.invoke(cls, new Object[0]);
                Class<?>[] clsArr = new Class[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    clsArr[i2] = (Class) this.f5884d.invoke(objArr[i2], new Object[0]);
                }
                return cls.getDeclaredConstructor(clsArr);
            } catch (ReflectiveOperationException e2) {
                throw C2041a.m5536b(e2);
            }
        }

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: b */
        String[] mo5542b(Class<?> cls) {
            try {
                Object[] objArr = (Object[]) this.f5882b.invoke(cls, new Object[0]);
                String[] strArr = new String[objArr.length];
                for (int i2 = 0; i2 < objArr.length; i2++) {
                    strArr[i2] = (String) this.f5883c.invoke(objArr[i2], new Object[0]);
                }
                return strArr;
            } catch (ReflectiveOperationException e2) {
                throw C2041a.m5536b(e2);
            }
        }

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: c */
        boolean mo5543c(Class<?> cls) {
            try {
                return ((Boolean) this.f5881a.invoke(cls, new Object[0])).booleanValue();
            } catch (ReflectiveOperationException e2) {
                throw C2041a.m5536b(e2);
            }
        }

        private d() throws NoSuchMethodException {
            super();
            this.f5881a = Class.class.getMethod("isRecord", new Class[0]);
            this.f5882b = Class.class.getMethod("getRecordComponents", new Class[0]);
            Class<?> componentType = this.f5882b.getReturnType().getComponentType();
            this.f5883c = componentType.getMethod("getName", new Class[0]);
            this.f5884d = componentType.getMethod("getType", new Class[0]);
        }

        @Override // com.google.gson.p147b0.p150s.C2041a.b
        /* renamed from: a */
        public Method mo5541a(Class<?> cls, Field field) {
            try {
                return cls.getMethod(field.getName(), new Class[0]);
            } catch (ReflectiveOperationException e2) {
                throw C2041a.m5536b(e2);
            }
        }
    }

    static {
        b cVar;
        try {
            cVar = new d();
        } catch (NoSuchMethodException unused) {
            cVar = new c();
        }
        f5880a = cVar;
    }

    private C2041a() {
    }

    /* renamed from: b */
    public static String m5537b(Constructor<?> constructor) {
        try {
            constructor.setAccessible(true);
            return null;
        } catch (Exception e2) {
            return "Failed making constructor '" + m5530a(constructor) + "' accessible; either increase its visibility or write a custom InstanceCreator or TypeAdapter for its declaring type: " + e2.getMessage();
        }
    }

    /* renamed from: c */
    public static boolean m5539c(Class<?> cls) {
        return f5880a.mo5543c(cls);
    }

    /* renamed from: a */
    public static void m5534a(AccessibleObject accessibleObject) throws C2064l {
        try {
            accessibleObject.setAccessible(true);
        } catch (Exception e2) {
            throw new C2064l("Failed making " + m5529a(accessibleObject, false) + " accessible; either increase its visibility or write a custom TypeAdapter for its declaring type.", e2);
        }
    }

    /* renamed from: b */
    public static String[] m5538b(Class<?> cls) {
        return f5880a.mo5542b(cls);
    }

    /* renamed from: a */
    public static String m5529a(AccessibleObject accessibleObject, boolean z) {
        String str;
        if (accessibleObject instanceof Field) {
            str = "field '" + m5531a((Field) accessibleObject) + "'";
        } else if (accessibleObject instanceof Method) {
            Method method = (Method) accessibleObject;
            StringBuilder sb = new StringBuilder(method.getName());
            m5535a(method, sb);
            str = "method '" + method.getDeclaringClass().getName() + "#" + sb.toString() + "'";
        } else if (accessibleObject instanceof Constructor) {
            str = "constructor '" + m5530a((Constructor<?>) accessibleObject) + "'";
        } else {
            str = "<unknown AccessibleObject> " + accessibleObject.toString();
        }
        if (!z || !Character.isLowerCase(str.charAt(0))) {
            return str;
        }
        return Character.toUpperCase(str.charAt(0)) + str.substring(1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static RuntimeException m5536b(ReflectiveOperationException reflectiveOperationException) {
        throw new RuntimeException("Unexpected ReflectiveOperationException occurred (Gson 2.10.1). To support Java records, reflection is utilized to read out information about records. All these invocations happens after it is established that records exist in the JVM. This exception is unexpected behavior.", reflectiveOperationException);
    }

    /* renamed from: a */
    public static String m5531a(Field field) {
        return field.getDeclaringClass().getName() + "#" + field.getName();
    }

    /* renamed from: a */
    public static String m5530a(Constructor<?> constructor) {
        StringBuilder sb = new StringBuilder(constructor.getDeclaringClass().getName());
        m5535a(constructor, sb);
        return sb.toString();
    }

    /* renamed from: a */
    private static void m5535a(AccessibleObject accessibleObject, StringBuilder sb) {
        Class<?>[] parameterTypes;
        sb.append('(');
        if (accessibleObject instanceof Method) {
            parameterTypes = ((Method) accessibleObject).getParameterTypes();
        } else {
            parameterTypes = ((Constructor) accessibleObject).getParameterTypes();
        }
        for (int i2 = 0; i2 < parameterTypes.length; i2++) {
            if (i2 > 0) {
                sb.append(", ");
            }
            sb.append(parameterTypes[i2].getSimpleName());
        }
        sb.append(')');
    }

    /* renamed from: a */
    public static Method m5533a(Class<?> cls, Field field) {
        return f5880a.mo5541a(cls, field);
    }

    /* renamed from: a */
    public static <T> Constructor<T> m5532a(Class<T> cls) {
        return f5880a.mo5540a(cls);
    }

    /* renamed from: a */
    public static RuntimeException m5527a(IllegalAccessException illegalAccessException) {
        throw new RuntimeException("Unexpected IllegalAccessException occurred (Gson 2.10.1). Certain ReflectionAccessFilter features require Java >= 9 to work correctly. If you are not using ReflectionAccessFilter, report this to the Gson maintainers.", illegalAccessException);
    }
}
