package com.google.gson.b0;

import com.google.gson.v;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: ReflectionAccessFilterHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: compiled from: ReflectionAccessFilterHelper.java */
    private static abstract class b {
        public static final b a;

        /* JADX INFO: compiled from: ReflectionAccessFilterHelper.java */
        class a extends b {

            /* JADX INFO: renamed from: b */
            final /* synthetic */ Method f3672b;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            a(Method method) {
                super();
                this.f3672b = method;
            }

            @Override // com.google.gson.b0.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                try {
                    return ((Boolean) this.f3672b.invoke(accessibleObject, obj)).booleanValue();
                } catch (Exception e2) {
                    throw new RuntimeException("Failed invoking canAccess", e2);
                }
            }
        }

        /* JADX INFO: renamed from: com.google.gson.b0.n$b$b */
        /* JADX INFO: compiled from: ReflectionAccessFilterHelper.java */
        class C0073b extends b {
            C0073b() {
                super();
            }

            @Override // com.google.gson.b0.n.b
            public boolean a(AccessibleObject accessibleObject, Object obj) {
                return true;
            }
        }

        static {
            b aVar;
            if (f.c()) {
                try {
                    aVar = new a(AccessibleObject.class.getDeclaredMethod("canAccess", Object.class));
                } catch (NoSuchMethodException unused) {
                    aVar = null;
                }
            } else {
                aVar = null;
            }
            if (aVar == null) {
                aVar = new C0073b();
            }
            a = aVar;
        }

        private b() {
        }

        public abstract boolean a(AccessibleObject accessibleObject, Object obj);

        /* synthetic */ b(a aVar) {
            this();
        }
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
            v.e eVarA = it.next().a(cls);
            if (eVarA != v.e.INDECISIVE) {
                return eVarA;
            }
        }
        return v.e.ALLOW;
    }

    public static boolean a(AccessibleObject accessibleObject, Object obj) {
        return b.a.a(accessibleObject, obj);
    }
}
