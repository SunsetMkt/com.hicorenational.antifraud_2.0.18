package com.google.gson.p147b0;

import java.io.ObjectInputStream;
import java.io.ObjectStreamClass;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/* compiled from: UnsafeAllocator.java */
/* renamed from: com.google.gson.b0.p */
/* loaded from: classes.dex */
public abstract class AbstractC2023p {

    /* renamed from: a */
    public static final AbstractC2023p f5713a = m5394a();

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: com.google.gson.b0.p$a */
    class a extends AbstractC2023p {

        /* renamed from: b */
        final /* synthetic */ Method f5714b;

        /* renamed from: c */
        final /* synthetic */ Object f5715c;

        a(Method method, Object obj) {
            this.f5714b = method;
            this.f5715c = obj;
        }

        @Override // com.google.gson.p147b0.AbstractC2023p
        /* renamed from: a */
        public <T> T mo5397a(Class<T> cls) throws Exception {
            AbstractC2023p.m5396c(cls);
            return (T) this.f5714b.invoke(this.f5715c, cls);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: com.google.gson.b0.p$b */
    class b extends AbstractC2023p {

        /* renamed from: b */
        final /* synthetic */ Method f5716b;

        /* renamed from: c */
        final /* synthetic */ int f5717c;

        b(Method method, int i2) {
            this.f5716b = method;
            this.f5717c = i2;
        }

        @Override // com.google.gson.p147b0.AbstractC2023p
        /* renamed from: a */
        public <T> T mo5397a(Class<T> cls) throws Exception {
            AbstractC2023p.m5396c(cls);
            return (T) this.f5716b.invoke(null, cls, Integer.valueOf(this.f5717c));
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: com.google.gson.b0.p$c */
    class c extends AbstractC2023p {

        /* renamed from: b */
        final /* synthetic */ Method f5718b;

        c(Method method) {
            this.f5718b = method;
        }

        @Override // com.google.gson.p147b0.AbstractC2023p
        /* renamed from: a */
        public <T> T mo5397a(Class<T> cls) throws Exception {
            AbstractC2023p.m5396c(cls);
            return (T) this.f5718b.invoke(null, cls, Object.class);
        }
    }

    /* compiled from: UnsafeAllocator.java */
    /* renamed from: com.google.gson.b0.p$d */
    class d extends AbstractC2023p {
        d() {
        }

        @Override // com.google.gson.p147b0.AbstractC2023p
        /* renamed from: a */
        public <T> T mo5397a(Class<T> cls) {
            throw new UnsupportedOperationException("Cannot allocate " + cls + ". Usage of JDK sun.misc.Unsafe is enabled, but it could not be used. Make sure your runtime is configured correctly.");
        }
    }

    /* renamed from: a */
    private static AbstractC2023p m5394a() {
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
                    int intValue = ((Integer) declaredMethod.invoke(null, Object.class)).intValue();
                    Method declaredMethod2 = ObjectStreamClass.class.getDeclaredMethod("newInstance", Class.class, Integer.TYPE);
                    declaredMethod2.setAccessible(true);
                    return new b(declaredMethod2, intValue);
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

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static void m5396c(Class<?> cls) {
        String m5335a = C2010c.m5335a(cls);
        if (m5335a == null) {
            return;
        }
        throw new AssertionError("UnsafeAllocator is used for non-instantiable type: " + m5335a);
    }

    /* renamed from: a */
    public abstract <T> T mo5397a(Class<T> cls) throws Exception;
}
