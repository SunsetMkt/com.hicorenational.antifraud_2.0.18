package org.greenrobot.eventbus;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    public static String s = "EventBus";
    static volatile c t;
    private static final org.greenrobot.eventbus.d u = new org.greenrobot.eventbus.d();
    private static final Map<Class<?>, List<Class<?>>> v = new HashMap();
    private final Map<Class<?>, CopyOnWriteArrayList<q>> a;

    /* JADX INFO: renamed from: b */
    private final Map<Object, List<Class<?>>> f12894b;

    /* JADX INFO: renamed from: c */
    private final Map<Class<?>, Object> f12895c;

    /* JADX INFO: renamed from: d */
    private final ThreadLocal<d> f12896d;

    /* JADX INFO: renamed from: e */
    private final h f12897e;

    /* JADX INFO: renamed from: f */
    private final l f12898f;

    /* JADX INFO: renamed from: g */
    private final org.greenrobot.eventbus.b f12899g;

    /* JADX INFO: renamed from: h */
    private final org.greenrobot.eventbus.a f12900h;

    /* JADX INFO: renamed from: i */
    private final p f12901i;

    /* JADX INFO: renamed from: j */
    private final ExecutorService f12902j;

    /* JADX INFO: renamed from: k */
    private final boolean f12903k;

    /* JADX INFO: renamed from: l */
    private final boolean f12904l;

    /* JADX INFO: renamed from: m */
    private final boolean f12905m;

    /* JADX INFO: renamed from: n */
    private final boolean f12906n;
    private final boolean o;
    private final boolean p;
    private final int q;
    private final g r;

    /* JADX INFO: compiled from: EventBus.java */
    class a extends ThreadLocal<d> {
        a() {
        }

        @Override // java.lang.ThreadLocal
        public d initialValue() {
            return new d();
        }
    }

    /* JADX INFO: compiled from: EventBus.java */
    static /* synthetic */ class b {
        static final /* synthetic */ int[] a = new int[ThreadMode.values().length];

        static {
            try {
                a[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* JADX INFO: renamed from: org.greenrobot.eventbus.c$c */
    /* JADX INFO: compiled from: EventBus.java */
    interface InterfaceC0278c {
        void a(List<n> list);
    }

    /* JADX INFO: compiled from: EventBus.java */
    static final class d {
        final List<Object> a = new ArrayList();

        /* JADX INFO: renamed from: b */
        boolean f12907b;

        /* JADX INFO: renamed from: c */
        boolean f12908c;

        /* JADX INFO: renamed from: d */
        q f12909d;

        /* JADX INFO: renamed from: e */
        Object f12910e;

        /* JADX INFO: renamed from: f */
        boolean f12911f;

        d() {
        }
    }

    public c() {
        this(u);
    }

    private void a(Object obj, o oVar) {
        Class<?> cls = oVar.f12938c;
        q qVar = new q(obj, oVar);
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(qVar)) {
            throw new e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || oVar.f12939d > copyOnWriteArrayList.get(i2).f12957b.f12939d) {
                copyOnWriteArrayList.add(i2, qVar);
                break;
            }
        }
        List<Class<?>> arrayList = this.f12894b.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f12894b.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (oVar.f12940e) {
            if (!this.p) {
                b(qVar, this.f12895c.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f12895c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    b(qVar, entry.getValue());
                }
            }
        }
    }

    private void b(q qVar, Object obj) {
        if (obj != null) {
            a(qVar, obj, g());
        }
    }

    public static org.greenrobot.eventbus.d d() {
        return new org.greenrobot.eventbus.d();
    }

    public static void e() {
        p.a();
        v.clear();
    }

    public static c f() {
        if (t == null) {
            synchronized (c.class) {
                if (t == null) {
                    t = new c();
                }
            }
        }
        return t;
    }

    private boolean g() {
        h hVar = this.f12897e;
        if (hVar != null) {
            return hVar.a();
        }
        return true;
    }

    public void c(Object obj) {
        d dVar = this.f12896d.get();
        List<Object> list = dVar.a;
        list.add(obj);
        if (dVar.f12907b) {
            return;
        }
        dVar.f12908c = g();
        dVar.f12907b = true;
        if (dVar.f12911f) {
            throw new e("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    a(list.remove(0), dVar);
                }
            } finally {
                dVar.f12907b = false;
                dVar.f12908c = false;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.q + ", eventInheritance=" + this.p + "]";
    }

    c(org.greenrobot.eventbus.d dVar) {
        this.f12896d = new a();
        this.r = dVar.c();
        this.a = new HashMap();
        this.f12894b = new HashMap();
        this.f12895c = new ConcurrentHashMap();
        this.f12897e = dVar.d();
        h hVar = this.f12897e;
        this.f12898f = hVar != null ? hVar.a(this) : null;
        this.f12899g = new org.greenrobot.eventbus.b(this);
        this.f12900h = new org.greenrobot.eventbus.a(this);
        List<org.greenrobot.eventbus.r.d> list = dVar.f12922k;
        this.q = list != null ? list.size() : 0;
        this.f12901i = new p(dVar.f12922k, dVar.f12919h, dVar.f12918g);
        this.f12904l = dVar.a;
        this.f12905m = dVar.f12913b;
        this.f12906n = dVar.f12914c;
        this.o = dVar.f12915d;
        this.f12903k = dVar.f12916e;
        this.p = dVar.f12917f;
        this.f12902j = dVar.f12920i;
    }

    public synchronized boolean b(Object obj) {
        return this.f12894b.containsKey(obj);
    }

    public void d(Object obj) {
        synchronized (this.f12895c) {
            this.f12895c.put(obj.getClass(), obj);
        }
        c(obj);
    }

    public synchronized void g(Object obj) {
        List<Class<?>> list = this.f12894b.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
            this.f12894b.remove(obj);
        } else {
            this.r.a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    public boolean b(Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        List<Class<?>> listD = d(cls);
        if (listD != null) {
            int size = listD.size();
            for (int i2 = 0; i2 < size; i2++) {
                Class<?> cls2 = listD.get(i2);
                synchronized (this) {
                    copyOnWriteArrayList = this.a.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    public void e(Object obj) {
        List<o> listA = this.f12901i.a(obj.getClass());
        synchronized (this) {
            Iterator<o> it = listA.iterator();
            while (it.hasNext()) {
                a(obj, it.next());
            }
        }
    }

    private static List<Class<?>> d(Class<?> cls) {
        List<Class<?>> arrayList;
        synchronized (v) {
            arrayList = v.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    a(arrayList, superclass.getInterfaces());
                }
                v.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    public boolean f(Object obj) {
        synchronized (this.f12895c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f12895c.get(cls))) {
                return false;
            }
            this.f12895c.remove(cls);
            return true;
        }
    }

    public g b() {
        return this.r;
    }

    public <T> T c(Class<T> cls) {
        T tCast;
        synchronized (this.f12895c) {
            tCast = cls.cast(this.f12895c.remove(cls));
        }
        return tCast;
    }

    public void c() {
        synchronized (this.f12895c) {
            this.f12895c.clear();
        }
    }

    private void a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList = this.a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                q qVar = copyOnWriteArrayList.get(i2);
                if (qVar.a == obj) {
                    qVar.f12958c = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    public void a(Object obj) {
        d dVar = this.f12896d.get();
        if (!dVar.f12907b) {
            throw new e("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj != null) {
            if (dVar.f12910e == obj) {
                if (dVar.f12909d.f12957b.f12937b == ThreadMode.POSTING) {
                    dVar.f12911f = true;
                    return;
                }
                throw new e(" event handlers may only abort the incoming event");
            }
            throw new e("Only the currently handled event may be aborted");
        }
        throw new e("Event may not be null");
    }

    public <T> T a(Class<T> cls) {
        T tCast;
        synchronized (this.f12895c) {
            tCast = cls.cast(this.f12895c.get(cls));
        }
        return tCast;
    }

    private void a(Object obj, d dVar) throws Error {
        boolean zA;
        Class<?> cls = obj.getClass();
        if (this.p) {
            List<Class<?>> listD = d(cls);
            int size = listD.size();
            zA = false;
            for (int i2 = 0; i2 < size; i2++) {
                zA |= a(obj, dVar, listD.get(i2));
            }
        } else {
            zA = a(obj, dVar, cls);
        }
        if (zA) {
            return;
        }
        if (this.f12905m) {
            this.r.a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.o || cls == i.class || cls == n.class) {
            return;
        }
        c(new i(this, obj));
    }

    private boolean a(Object obj, d dVar, Class<?> cls) {
        CopyOnWriteArrayList<q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (q qVar : copyOnWriteArrayList) {
            dVar.f12910e = obj;
            dVar.f12909d = qVar;
            try {
                a(qVar, obj, dVar.f12908c);
                if (dVar.f12911f) {
                    return true;
                }
            } finally {
                dVar.f12910e = null;
                dVar.f12909d = null;
                dVar.f12911f = false;
            }
        }
        return true;
    }

    private void a(q qVar, Object obj, boolean z) {
        int i2 = b.a[qVar.f12957b.f12937b.ordinal()];
        if (i2 == 1) {
            a(qVar, obj);
            return;
        }
        if (i2 == 2) {
            if (z) {
                a(qVar, obj);
                return;
            } else {
                this.f12898f.a(qVar, obj);
                return;
            }
        }
        if (i2 == 3) {
            l lVar = this.f12898f;
            if (lVar != null) {
                lVar.a(qVar, obj);
                return;
            } else {
                a(qVar, obj);
                return;
            }
        }
        if (i2 == 4) {
            if (z) {
                this.f12899g.a(qVar, obj);
                return;
            } else {
                a(qVar, obj);
                return;
            }
        }
        if (i2 == 5) {
            this.f12900h.a(qVar, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + qVar.f12957b.f12937b);
    }

    static void a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                a(list, cls.getInterfaces());
            }
        }
    }

    void a(j jVar) {
        Object obj = jVar.a;
        q qVar = jVar.f12931b;
        j.a(jVar);
        if (qVar.f12958c) {
            a(qVar, obj);
        }
    }

    void a(q qVar, Object obj) {
        try {
            qVar.f12957b.a.invoke(qVar.a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            a(qVar, obj, e3.getCause());
        }
    }

    private void a(q qVar, Object obj, Throwable th) {
        if (obj instanceof n) {
            if (this.f12904l) {
                this.r.a(Level.SEVERE, "SubscriberExceptionEvent subscriber " + qVar.a.getClass() + " threw an exception", th);
                n nVar = (n) obj;
                this.r.a(Level.SEVERE, "Initial event " + nVar.f12935c + " caused exception in " + nVar.f12936d, nVar.f12934b);
                return;
            }
            return;
        }
        if (!this.f12903k) {
            if (this.f12904l) {
                this.r.a(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + qVar.a.getClass(), th);
            }
            if (this.f12906n) {
                c(new n(this, th, obj, qVar.a));
                return;
            }
            return;
        }
        throw new e("Invoking subscriber failed", th);
    }

    ExecutorService a() {
        return this.f12902j;
    }
}
