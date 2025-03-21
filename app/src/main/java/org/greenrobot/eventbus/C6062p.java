package org.greenrobot.eventbus;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.greenrobot.eventbus.p387r.InterfaceC6066c;
import org.greenrobot.eventbus.p387r.InterfaceC6067d;
import p286h.p323z2.C5736h0;

/* compiled from: SubscriberMethodFinder.java */
/* renamed from: org.greenrobot.eventbus.p */
/* loaded from: classes2.dex */
class C6062p {

    /* renamed from: d */
    private static final int f21596d = 64;

    /* renamed from: e */
    private static final int f21597e = 4096;

    /* renamed from: f */
    private static final int f21598f = 5192;

    /* renamed from: h */
    private static final int f21600h = 4;

    /* renamed from: a */
    private List<InterfaceC6067d> f21602a;

    /* renamed from: b */
    private final boolean f21603b;

    /* renamed from: c */
    private final boolean f21604c;

    /* renamed from: g */
    private static final Map<Class<?>, List<C6061o>> f21599g = new ConcurrentHashMap();

    /* renamed from: i */
    private static final a[] f21601i = new a[4];

    C6062p(List<InterfaceC6067d> list, boolean z, boolean z2) {
        this.f21602a = list;
        this.f21603b = z;
        this.f21604c = z2;
    }

    /* renamed from: b */
    private List<C6061o> m25036b(Class<?> cls) {
        a m25038b = m25038b();
        m25038b.m25044a(cls);
        while (m25038b.f21610f != null) {
            m25038b.f21612h = m25040c(m25038b);
            InterfaceC6066c interfaceC6066c = m25038b.f21612h;
            if (interfaceC6066c != null) {
                for (C6061o c6061o : interfaceC6066c.mo25053a()) {
                    if (m25038b.m25045a(c6061o.f21590a, c6061o.f21592c)) {
                        m25038b.f21605a.add(c6061o);
                    }
                }
            } else {
                m25035a(m25038b);
            }
            m25038b.m25043a();
        }
        return m25037b(m25038b);
    }

    /* renamed from: c */
    private InterfaceC6066c m25040c(a aVar) {
        InterfaceC6066c interfaceC6066c = aVar.f21612h;
        if (interfaceC6066c != null && interfaceC6066c.mo25050b() != null) {
            InterfaceC6066c mo25050b = aVar.f21612h.mo25050b();
            if (aVar.f21610f == mo25050b.mo25052d()) {
                return mo25050b;
            }
        }
        List<InterfaceC6067d> list = this.f21602a;
        if (list == null) {
            return null;
        }
        Iterator<InterfaceC6067d> it = list.iterator();
        while (it.hasNext()) {
            InterfaceC6066c m25054a = it.next().m25054a(aVar.f21610f);
            if (m25054a != null) {
                return m25054a;
            }
        }
        return null;
    }

    /* renamed from: a */
    List<C6061o> m25041a(Class<?> cls) {
        List<C6061o> list = f21599g.get(cls);
        if (list != null) {
            return list;
        }
        List<C6061o> m25039c = this.f21604c ? m25039c(cls) : m25036b(cls);
        if (!m25039c.isEmpty()) {
            f21599g.put(cls, m25039c);
            return m25039c;
        }
        throw new C6051e("Subscriber " + cls + " and its super classes have no public methods with the @Subscribe annotation");
    }

    /* compiled from: SubscriberMethodFinder.java */
    /* renamed from: org.greenrobot.eventbus.p$a */
    static class a {

        /* renamed from: a */
        final List<C6061o> f21605a = new ArrayList();

        /* renamed from: b */
        final Map<Class, Object> f21606b = new HashMap();

        /* renamed from: c */
        final Map<String, Class> f21607c = new HashMap();

        /* renamed from: d */
        final StringBuilder f21608d = new StringBuilder(128);

        /* renamed from: e */
        Class<?> f21609e;

        /* renamed from: f */
        Class<?> f21610f;

        /* renamed from: g */
        boolean f21611g;

        /* renamed from: h */
        InterfaceC6066c f21612h;

        a() {
        }

        /* renamed from: a */
        void m25044a(Class<?> cls) {
            this.f21610f = cls;
            this.f21609e = cls;
            this.f21611g = false;
            this.f21612h = null;
        }

        /* renamed from: b */
        void m25046b() {
            this.f21605a.clear();
            this.f21606b.clear();
            this.f21607c.clear();
            this.f21608d.setLength(0);
            this.f21609e = null;
            this.f21610f = null;
            this.f21611g = false;
            this.f21612h = null;
        }

        /* renamed from: a */
        boolean m25045a(Method method, Class<?> cls) {
            Object put = this.f21606b.put(cls, method);
            if (put == null) {
                return true;
            }
            if (put instanceof Method) {
                if (m25042b((Method) put, cls)) {
                    this.f21606b.put(cls, this);
                } else {
                    throw new IllegalStateException();
                }
            }
            return m25042b(method, cls);
        }

        /* renamed from: b */
        private boolean m25042b(Method method, Class<?> cls) {
            this.f21608d.setLength(0);
            this.f21608d.append(method.getName());
            StringBuilder sb = this.f21608d;
            sb.append(C5736h0.f20716e);
            sb.append(cls.getName());
            String sb2 = this.f21608d.toString();
            Class<?> declaringClass = method.getDeclaringClass();
            Class put = this.f21607c.put(sb2, declaringClass);
            if (put == null || put.isAssignableFrom(declaringClass)) {
                return true;
            }
            this.f21607c.put(sb2, put);
            return false;
        }

        /* renamed from: a */
        void m25043a() {
            if (this.f21611g) {
                this.f21610f = null;
                return;
            }
            this.f21610f = this.f21610f.getSuperclass();
            String name = this.f21610f.getName();
            if (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("android.")) {
                this.f21610f = null;
            }
        }
    }

    /* renamed from: c */
    private List<C6061o> m25039c(Class<?> cls) {
        a m25038b = m25038b();
        m25038b.m25044a(cls);
        while (m25038b.f21610f != null) {
            m25035a(m25038b);
            m25038b.m25043a();
        }
        return m25037b(m25038b);
    }

    /* renamed from: a */
    private void m25035a(a aVar) {
        Method[] methods;
        try {
            methods = aVar.f21610f.getDeclaredMethods();
        } catch (Throwable unused) {
            methods = aVar.f21610f.getMethods();
            aVar.f21611g = true;
        }
        for (Method method : methods) {
            int modifiers = method.getModifiers();
            if ((modifiers & 1) != 0 && (modifiers & f21598f) == 0) {
                Class<?>[] parameterTypes = method.getParameterTypes();
                if (parameterTypes.length == 1) {
                    InterfaceC6059m interfaceC6059m = (InterfaceC6059m) method.getAnnotation(InterfaceC6059m.class);
                    if (interfaceC6059m != null) {
                        Class<?> cls = parameterTypes[0];
                        if (aVar.m25045a(method, cls)) {
                            aVar.f21605a.add(new C6061o(method, cls, interfaceC6059m.threadMode(), interfaceC6059m.priority(), interfaceC6059m.sticky()));
                        }
                    }
                } else if (this.f21603b && method.isAnnotationPresent(InterfaceC6059m.class)) {
                    throw new C6051e("@Subscribe method " + (method.getDeclaringClass().getName() + "." + method.getName()) + "must have exactly 1 parameter but has " + parameterTypes.length);
                }
            } else if (this.f21603b && method.isAnnotationPresent(InterfaceC6059m.class)) {
                throw new C6051e((method.getDeclaringClass().getName() + "." + method.getName()) + " is a illegal @Subscribe method: must be public, non-static, and non-abstract");
            }
        }
    }

    /* renamed from: b */
    private List<C6061o> m25037b(a aVar) {
        ArrayList arrayList = new ArrayList(aVar.f21605a);
        aVar.m25046b();
        synchronized (f21601i) {
            int i2 = 0;
            while (true) {
                if (i2 >= 4) {
                    break;
                }
                if (f21601i[i2] == null) {
                    f21601i[i2] = aVar;
                    break;
                }
                i2++;
            }
        }
        return arrayList;
    }

    /* renamed from: b */
    private a m25038b() {
        synchronized (f21601i) {
            for (int i2 = 0; i2 < 4; i2++) {
                a aVar = f21601i[i2];
                if (aVar != null) {
                    f21601i[i2] = null;
                    return aVar;
                }
            }
            return new a();
        }
    }

    /* renamed from: a */
    static void m25034a() {
        f21599g.clear();
    }
}
