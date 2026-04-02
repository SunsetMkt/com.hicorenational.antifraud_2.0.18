package org.greenrobot.eventbus;

import i.z2.h0;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: SubscriberMethodFinder.java */
/* JADX INFO: loaded from: classes2.dex */
class p {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f12942d = 64;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f12943e = 4096;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f12944f = 5192;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f12946h = 4;
    private List<org.greenrobot.eventbus.r.d> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f12948b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final boolean f12949c;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final Map<Class<?>, List<o>> f12945g = new ConcurrentHashMap();

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final a[] f12947i = new a[4];

    p(List<org.greenrobot.eventbus.r.d> list, boolean z, boolean z2) {
        this.a = list;
        this.f12948b = z;
        this.f12949c = z2;
    }

    private List<o> b(Class<?> cls) {
        a aVarB = b();
        aVarB.a(cls);
        while (aVarB.f12954f != null) {
            aVarB.f12956h = c(aVarB);
            org.greenrobot.eventbus.r.c cVar = aVarB.f12956h;
            if (cVar != null) {
                for (o oVar : cVar.a()) {
                    if (aVarB.a(oVar.a, oVar.f12938c)) {
                        aVarB.a.add(oVar);
                    }
                }
            } else {
                a(aVarB);
            }
            aVarB.a();
        }
        return b(aVarB);
    }

    private org.greenrobot.eventbus.r.c c(a aVar) {
        org.greenrobot.eventbus.r.c cVar = aVar.f12956h;
        if (cVar != null && cVar.b() != null) {
            org.greenrobot.eventbus.r.c cVarB = aVar.f12956h.b();
            if (aVar.f12954f == cVarB.d()) {
                return cVarB;
            }
        }
        List<org.greenrobot.eventbus.r.d> list = this.a;
        if (list == null) {
            return null;
        }
        Iterator<org.greenrobot.eventbus.r.d> it = list.iterator();
        while (it.hasNext()) {
            org.greenrobot.eventbus.r.c cVarA = it.next().a(aVar.f12954f);
            if (cVarA != null) {
                return cVarA;
            }
        }
        return null;
    }

    List<o> a(Class<?> cls) {
        List<o> list = f12945g.get(cls);
        if (list != null) {
            return list;
        }
        List<o> listC = this.f12949c ? c(cls) : b(cls);
        if (!listC.isEmpty()) {
            f12945g.put(cls, listC);
            return listC;
        }
        throw new e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* JADX INFO: compiled from: SubscriberMethodFinder.java */
    static class a {
        final List<o> a = new ArrayList();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Map<Class, Object> f12950b = new HashMap();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map<String, Class> f12951c = new HashMap();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final StringBuilder f12952d = new StringBuilder(128);

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        Class<?> f12953e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Class<?> f12954f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        boolean f12955g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        org.greenrobot.eventbus.r.c f12956h;

        a() {
        }

        void a(Class<?> cls) {
            this.f12954f = cls;
            this.f12953e = cls;
            this.f12955g = false;
            this.f12956h = null;
        }

        void b() {
            this.a.clear();
            this.f12950b.clear();
            this.f12951c.clear();
            this.f12952d.setLength(0);
            this.f12953e = null;
            this.f12954f = null;
            this.f12955g = false;
            this.f12956h = null;
        }

        boolean a(Method method, Class<?> cls) {
            Object objPut = this.f12950b.put(cls, method);
            if (objPut == null) {
                return true;
            }
            if (objPut instanceof Method) {
                if (b((Method) objPut, cls)) {
                    this.f12950b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return b(method, cls);
        }

        private boolean b(Method method, Class<?> cls) {
            this.f12952d.setLength(0);
            this.f12952d.append(method.getName());
            StringBuilder sb = this.f12952d;
            sb.append(h0.f12425e);
            sb.append(cls.getName());
            String string = this.f12952d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class clsPut = this.f12951c.put(string, declaringClass);
            if (clsPut == null || clsPut.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f12951c.put(string, clsPut);
            return false;
        }

        void a() {
            if (this.f12955g) {
                this.f12954f = null;
                return;
            }
            this.f12954f = this.f12954f.getSuperclass();
            String name = this.f12954f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f12954f = null;
            }
        }
    }

    private List<o> c(Class<?> cls) {
        a aVarB = b();
        aVarB.a(cls);
        while (aVarB.f12954f != null) {
            a(aVarB);
            aVarB.a();
        }
        return b(aVarB);
    }

    private void a(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f12954f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f12954f.getMethods();
            aVar.f12955g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & f12944f) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    m mVar = (m) method.getAnnotation(m.class);
                    if (mVar != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.a(method, cls)) {
                            aVar.a.add(new o(method, cls, mVar.threadMode(), mVar.priority(), mVar.sticky()));
                        }
                    }
                } else if (this.f12948b && method.isAnnotationPresent(m.class)) {
                    throw new e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f12948b && method.isAnnotationPresent(m.class)) {
                throw new e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    private List<o> b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.a);
        aVar.b();
        synchronized (f12947i) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                if (f12947i[i2] == null) {
                    f12947i[i2] = aVar;
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    private a b() {
        synchronized (f12947i) {
            for (int i2 = 0; i2 < 4; i2++) {
                a aVar = f12947i[i2];
                if (aVar != null) {
                    f12947i[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    static void a() {
        f12945g.clear();
    }
}
