package com.google.gson.b0;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: UnsafeAllocator.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class p {
    public static final p a = a();

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class a extends p {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Method f3675b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ Object f3676c;

        a(Method method, Object obj) {
            this.f3675b = method;
            this.f3676c = obj;
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) throws Exception {
            p.c(cls);
            return (T) this.f3675b.invoke(this.f3676c, cls);
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class b extends p {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Method f3677b;

        /* JADX INFO: renamed from: c */
        final /* synthetic */ int f3678c;

        b(Method method, int i2) {
            this.f3677b = method;
            this.f3678c = i2;
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) throws Exception {
            p.c(cls);
            return (T) this.f3677b.invoke(null, cls, Integer.valueOf(this.f3678c));
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class c extends p {

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Method f3679b;

        c(Method method) {
            this.f3679b = method;
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) throws Exception {
            p.c(cls);
            return (T) this.f3679b.invoke(null, cls, Object.class);
        }
    }

    /* JADX INFO: compiled from: UnsafeAllocator.java */
    class d extends p {
        d() {
        }

        @Override // com.google.gson.b0.p
        public <T> T a(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    private static p a() {
        try {
            Class<?> cls = Class.forName("sun.misc.Unsafe");
            Field declaredField = cls.getDeclaredField("theUnsafe");
            declaredField.setAccessible(true);
            return new a(cls.getMethod("allocateInstance", Class.class), declaredField.get(null));
        } catch (Exception unused) {
            try {
                try {
                    Method declaredMethod = ObjectStreamClass.class.getDeclaredMethod("getConstructorId", Class.class);
                    declaredMethod.setAccessible(true);
                    int iIntValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, iIntValue);
                } catch (Exception unused2) {
                    Method declaredMethod3 = ObjectInputStream.class.getDeclaredMethod("newInstance", Class.class, Class.class);
                    declaredMethod3.setAccessible(true);
                    return new c(declaredMethod3);
                }
            } catch (Exception unused3) {
                return new d();
            }
        }
    }

    public static void c(Class<?> cls) {
        String strA = com.google.gson.b0.c.a(cls);
        if (strA == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + strA);
    }

    public abstract <T> T a(Class<T> cls) throws Exception;
}
