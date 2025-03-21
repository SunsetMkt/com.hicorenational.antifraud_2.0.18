package com.google.gson.p147b0;

import com.google.gson.InterfaceC2074v;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* compiled from: ReflectionAccessFilterHelper.java */
/* renamed from: com.google.gson.b0.n */
/* loaded from: classes.dex */
public class C2021n {

    /* compiled from: ReflectionAccessFilterHelper.java */
    /* renamed from: com.google.gson.b0.n$b */
    private static abstract class b {

        /* renamed from: a */
        public static final b f5707a;

        /* compiled from: ReflectionAccessFilterHelper.java */
        /* renamed from: com.google.gson.b0.n$b$a */
        class a extends b {

            /* renamed from: b */
            final /* synthetic */ Method f5708b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f5708b = method;
            }

            @Override // com.google.gson.p147b0.C2021n.b
            /* renamed from: a */
            public boolean mo5389a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f5708b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e2) {
                    throw new RuntimeException("Failed invoking canAccess", e2);
                }
            }
        }

        /* compiled from: ReflectionAccessFilterHelper.java */
        /* renamed from: com.google.gson.b0.n$b$b, reason: collision with other inner class name */
        class C7364b extends b {
            C7364b() {
                super();
            }

            @Override // com.google.gson.p147b0.C2021n.b
            /* renamed from: a */
            public boolean mo5389a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:5:0x001f  */
        static {
            /*
                boolean r0 = com.google.gson.p147b0.C2013f.m5361c()
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
                com.google.gson.p147b0.C2021n.b.f5707a = r1
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.gson.p147b0.C2021n.b.<clinit>():void");
        }

        private b() {
        }

        /* renamed from: a */
        public abstract boolean mo5389a(AccessibleObject accessibleObject, Object obj);
    }

    private C2021n() {
    }

    /* renamed from: a */
    public static boolean m5383a(Class<?> cls) {
        return m5384a(cls.getName());
    }

    /* renamed from: b */
    private static boolean m5387b(String str) {
        return str.startsWith("java.") || str.startsWith("javax.");
    }

    /* renamed from: c */
    public static boolean m5388c(Class<?> cls) {
        return m5387b(cls.getName());
    }

    /* renamed from: a */
    private static boolean m5384a(String str) {
        return str.startsWith("android.") || str.startsWith("androidx.") || m5387b(str);
    }

    /* renamed from: b */
    public static boolean m5386b(Class<?> cls) {
        String name = cls.getName();
        return m5384a(name) || name.startsWith("kotlin.") || name.startsWith("kotlinx.") || name.startsWith("scala.");
    }

    /* renamed from: a */
    public static InterfaceC2074v.e m5382a(List<InterfaceC2074v> list, Class<?> cls) {
        Iterator<InterfaceC2074v> it = list.iterator();
        while (it.hasNext()) {
            InterfaceC2074v.e mo5683a = it.next().mo5683a(cls);
            if (mo5683a != InterfaceC2074v.e.INDECISIVE) {
                return mo5683a;
            }
        }
        return InterfaceC2074v.e.ALLOW;
    }

    /* renamed from: a */
    public static boolean m5385a(AccessibleObject accessibleObject, Object obj) {
        return b.f5707a.mo5389a(accessibleObject, obj);
    }
}
