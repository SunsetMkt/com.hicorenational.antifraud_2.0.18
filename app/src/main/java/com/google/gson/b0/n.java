package com.google.gson.b0;

import com.google.gson.v;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: ReflectionAccessFilterHelper.java */
/* loaded from: classes.dex */
public class n {

    /* compiled from: ReflectionAccessFilterHelper.java */
    private static abstract class b {

        /* renamed from: a, reason: collision with root package name */
        public static final b f5540a;

        /* compiled from: ReflectionAccessFilterHelper.java */
        class a extends b {

            /* renamed from: b, reason: collision with root package name */
            final /* synthetic */ Method f5541b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f5541b = method;
            }

            @Override // com.google.gson.b0.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f5541b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e2) {
                    throw new RuntimeException("Failed invoking canAccess", e2);
                }
            }
        }

        /* compiled from: ReflectionAccessFilterHelper.java */
        /* renamed from: com.google.gson.b0.n$b$b, reason: collision with other inner class name */
        class C0085b extends b {
            C0085b() {
                super();
            }

            @Override // com.google.gson.b0.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
        static {
            /*
                boolean r0 = com.google.gson.b0.f.c()
                if (r0 == 0) goto L1c
                java.lang.Class<java.lang.reflect.AccessibleObject> r0 = java.lang.reflect.AccessibleObject.class
                java.lang.String r1 = "canAccess"
                r2 = 1
                java.lang.Class[] r2 = new java.lang.Class[r2]     // Catch: java.lang.NoSuchMethodException -> L1c
                r3 = 0
                java.lang.Class<java.lang.Object> r4 = java.lang.Object.class
                r2[r3] = r4     // Catch: java.lang.NoSuchMethodException -> L1c
                java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch: java.lang.NoSuchMethodException -> L1c
                com.google.gson.b0.n$b$a r1 = new com.google.gson.b0.n$b$a     // Catch: java.lang.NoSuchMethodException -> L1c
                r1.<init>(r0)     // Catch: java.lang.NoSuchMethodException -> L1c
                goto L1d
            L1c:
                r1 = 0
            L1d:
                if (r1 != 0) goto L24
                com.google.gson.b0.n$b$b r1 = new com.google.gson.b0.n$b$b
                r1.<init>()
            L24:
                com.google.gson.b0.n.b.f5540a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.b0.n.b.<clinit>():void");
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);
    }

    private n() {
    }

    public static boolean a(Class<?> cls) {
        return a(cls.getName());
    }

    private static boolean b(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }

    public static boolean c(Class<?> cls) {
        return b(cls.getName());
    }

    private static boolean a(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || b(str);
    }

    public static boolean b(Class<?> cls) {
        String name = cls.getName();
        return a(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    public static v.e a(List<v> list, Class<?> cls) {
        Iterator<v> it = list.iterator();
        while (it.hasNext()) {
            v.e a2 = it.next().a(cls);
            if (a2 != v.e.INDECISIVE) {
                return a2;
            }
        }
        return v.e.ALLOW;
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.f5540a.a(accessibleObject, obj);
    }
}
