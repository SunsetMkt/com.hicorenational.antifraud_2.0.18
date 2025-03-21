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
import org.greenrobot.eventbus.p387r.InterfaceC6067d;

/* compiled from: EventBus.java */
/* renamed from: org.greenrobot.eventbus.c */
/* loaded from: classes2.dex */
public class C6049c {

    /* renamed from: s */
    public static String f21526s = "EventBus";

    /* renamed from: t */
    static volatile C6049c f21527t;

    /* renamed from: u */
    private static final C6050d f21528u = new C6050d();

    /* renamed from: v */
    private static final Map<Class<?>, List<Class<?>>> f21529v = new HashMap();

    /* renamed from: a */
    private final Map<Class<?>, CopyOnWriteArrayList<C6063q>> f21530a;

    /* renamed from: b */
    private final Map<Object, List<Class<?>>> f21531b;

    /* renamed from: c */
    private final Map<Class<?>, Object> f21532c;

    /* renamed from: d */
    private final ThreadLocal<d> f21533d;

    /* renamed from: e */
    private final InterfaceC6054h f21534e;

    /* renamed from: f */
    private final InterfaceC6058l f21535f;

    /* renamed from: g */
    private final RunnableC6048b f21536g;

    /* renamed from: h */
    private final RunnableC6047a f21537h;

    /* renamed from: i */
    private final C6062p f21538i;

    /* renamed from: j */
    private final ExecutorService f21539j;

    /* renamed from: k */
    private final boolean f21540k;

    /* renamed from: l */
    private final boolean f21541l;

    /* renamed from: m */
    private final boolean f21542m;

    /* renamed from: n */
    private final boolean f21543n;

    /* renamed from: o */
    private final boolean f21544o;

    /* renamed from: p */
    private final boolean f21545p;

    /* renamed from: q */
    private final int f21546q;

    /* renamed from: r */
    private final InterfaceC6053g f21547r;

    /* compiled from: EventBus.java */
    /* renamed from: org.greenrobot.eventbus.c$a */
    class a extends ThreadLocal<d> {
        a() {
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public d initialValue() {
            return new d();
        }
    }

    /* compiled from: EventBus.java */
    /* renamed from: org.greenrobot.eventbus.c$b */
    static /* synthetic */ class b {

        /* renamed from: a */
        static final /* synthetic */ int[] f21549a = new int[ThreadMode.values().length];

        static {
            try {
                f21549a[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f21549a[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f21549a[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f21549a[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f21549a[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    /* compiled from: EventBus.java */
    /* renamed from: org.greenrobot.eventbus.c$c */
    interface c {
        /* renamed from: a */
        void m25004a(List<C6060n> list);
    }

    /* compiled from: EventBus.java */
    /* renamed from: org.greenrobot.eventbus.c$d */
    static final class d {

        /* renamed from: a */
        final List<Object> f21550a = new ArrayList();

        /* renamed from: b */
        boolean f21551b;

        /* renamed from: c */
        boolean f21552c;

        /* renamed from: d */
        C6063q f21553d;

        /* renamed from: e */
        Object f21554e;

        /* renamed from: f */
        boolean f21555f;

        d() {
        }
    }

    public C6049c() {
        this(f21528u);
    }

    /* renamed from: a */
    private void m24978a(Object obj, C6061o c6061o) {
        Class<?> cls = c6061o.f21592c;
        C6063q c6063q = new C6063q(obj, c6061o);
        CopyOnWriteArrayList<C6063q> copyOnWriteArrayList = this.f21530a.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f21530a.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(c6063q)) {
            throw new C6051e("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i2 = 0; i2 <= size; i2++) {
            if (i2 == size || c6061o.f21593d > copyOnWriteArrayList.get(i2).f21614b.f21593d) {
                copyOnWriteArrayList.add(i2, c6063q);
                break;
            }
        }
        List<Class<?>> list = this.f21531b.get(obj);
        if (list == null) {
            list = new ArrayList<>();
            this.f21531b.put(obj, list);
        }
        list.add(cls);
        if (c6061o.f21594e) {
            if (!this.f21545p) {
                m24983b(c6063q, this.f21532c.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f21532c.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    m24983b(c6063q, entry.getValue());
                }
            }
        }
    }

    /* renamed from: b */
    private void m24983b(C6063q c6063q, Object obj) {
        if (obj != null) {
            m24981a(c6063q, obj, m24988g());
        }
    }

    /* renamed from: d */
    public static C6050d m24985d() {
        return new C6050d();
    }

    /* renamed from: e */
    public static void m24986e() {
        C6062p.m25034a();
        f21529v.clear();
    }

    /* renamed from: f */
    public static C6049c m24987f() {
        if (f21527t == null) {
            synchronized (C6049c.class) {
                if (f21527t == null) {
                    f21527t = new C6049c();
                }
            }
        }
        return f21527t;
    }

    /* renamed from: g */
    private boolean m24988g() {
        InterfaceC6054h interfaceC6054h = this.f21534e;
        if (interfaceC6054h != null) {
            return interfaceC6054h.mo25027a();
        }
        return true;
    }

    /* renamed from: c */
    public void m24999c(Object obj) {
        d dVar = this.f21533d.get();
        List<Object> list = dVar.f21550a;
        list.add(obj);
        if (dVar.f21551b) {
            return;
        }
        dVar.f21552c = m24988g();
        dVar.f21551b = true;
        if (dVar.f21555f) {
            throw new C6051e("Internal error. Abort state was not reset");
        }
        while (true) {
            try {
                if (list.isEmpty()) {
                    return;
                } else {
                    m24977a(list.remove(0), dVar);
                }
            } finally {
                dVar.f21551b = false;
                dVar.f21552c = false;
            }
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f21546q + ", eventInheritance=" + this.f21545p + "]";
    }

    C6049c(C6050d c6050d) {
        this.f21533d = new a();
        this.f21547r = c6050d.m25014c();
        this.f21530a = new HashMap();
        this.f21531b = new HashMap();
        this.f21532c = new ConcurrentHashMap();
        this.f21534e = c6050d.m25016d();
        InterfaceC6054h interfaceC6054h = this.f21534e;
        this.f21535f = interfaceC6054h != null ? interfaceC6054h.mo25026a(this) : null;
        this.f21536g = new RunnableC6048b(this);
        this.f21537h = new RunnableC6047a(this);
        List<InterfaceC6067d> list = c6050d.f21567k;
        this.f21546q = list != null ? list.size() : 0;
        this.f21538i = new C6062p(c6050d.f21567k, c6050d.f21564h, c6050d.f21563g);
        this.f21541l = c6050d.f21557a;
        this.f21542m = c6050d.f21558b;
        this.f21543n = c6050d.f21559c;
        this.f21544o = c6050d.f21560d;
        this.f21540k = c6050d.f21561e;
        this.f21545p = c6050d.f21562f;
        this.f21539j = c6050d.f21565i;
    }

    /* renamed from: b */
    public synchronized boolean m24996b(Object obj) {
        return this.f21531b.containsKey(obj);
    }

    /* renamed from: d */
    public void m25000d(Object obj) {
        synchronized (this.f21532c) {
            this.f21532c.put(obj.getClass(), obj);
        }
        m24999c(obj);
    }

    /* renamed from: g */
    public synchronized void m25003g(Object obj) {
        List<Class<?>> list = this.f21531b.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                m24976a(obj, it.next());
            }
            this.f21531b.remove(obj);
        } else {
            this.f21547r.mo25022a(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* renamed from: b */
    public boolean m24995b(Class<?> cls) {
        CopyOnWriteArrayList<C6063q> copyOnWriteArrayList;
        List<Class<?>> m24984d = m24984d(cls);
        if (m24984d != null) {
            int size = m24984d.size();
            for (int i2 = 0; i2 < size; i2++) {
                Class<?> cls2 = m24984d.get(i2);
                synchronized (this) {
                    copyOnWriteArrayList = this.f21530a.get(cls2);
                }
                if (copyOnWriteArrayList != null && !copyOnWriteArrayList.isEmpty()) {
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: e */
    public void m25001e(Object obj) {
        List<C6061o> m25041a = this.f21538i.m25041a(obj.getClass());
        synchronized (this) {
            Iterator<C6061o> it = m25041a.iterator();
            while (it.hasNext()) {
                m24978a(obj, it.next());
            }
        }
    }

    /* renamed from: d */
    private static List<Class<?>> m24984d(Class<?> cls) {
        List<Class<?>> list;
        synchronized (f21529v) {
            list = f21529v.get(cls);
            if (list == null) {
                list = new ArrayList<>();
                for (Class<?> cls2 = cls; cls2 != null; cls2 = cls2.getSuperclass()) {
                    list.add(cls2);
                    m24979a(list, cls2.getInterfaces());
                }
                f21529v.put(cls, list);
            }
        }
        return list;
    }

    /* renamed from: f */
    public boolean m25002f(Object obj) {
        synchronized (this.f21532c) {
            Class<?> cls = obj.getClass();
            if (!obj.equals(this.f21532c.get(cls))) {
                return false;
            }
            this.f21532c.remove(cls);
            return true;
        }
    }

    /* renamed from: b */
    public InterfaceC6053g m24994b() {
        return this.f21547r;
    }

    /* renamed from: c */
    public <T> T m24997c(Class<T> cls) {
        T cast;
        synchronized (this.f21532c) {
            cast = cls.cast(this.f21532c.remove(cls));
        }
        return cast;
    }

    /* renamed from: c */
    public void m24998c() {
        synchronized (this.f21532c) {
            this.f21532c.clear();
        }
    }

    /* renamed from: a */
    private void m24976a(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<C6063q> copyOnWriteArrayList = this.f21530a.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i2 = 0;
            while (i2 < size) {
                C6063q c6063q = copyOnWriteArrayList.get(i2);
                if (c6063q.f21613a == obj) {
                    c6063q.f21615c = false;
                    copyOnWriteArrayList.remove(i2);
                    i2--;
                    size--;
                }
                i2++;
            }
        }
    }

    /* renamed from: a */
    public void m24991a(Object obj) {
        d dVar = this.f21533d.get();
        if (!dVar.f21551b) {
            throw new C6051e("This method may only be called from inside event handling methods on the posting thread");
        }
        if (obj != null) {
            if (dVar.f21554e == obj) {
                if (dVar.f21553d.f21614b.f21591b == ThreadMode.POSTING) {
                    dVar.f21555f = true;
                    return;
                }
                throw new C6051e(" event handlers may only abort the incoming event");
            }
            throw new C6051e("Only the currently handled event may be aborted");
        }
        throw new C6051e("Event may not be null");
    }

    /* renamed from: a */
    public <T> T m24989a(Class<T> cls) {
        T cast;
        synchronized (this.f21532c) {
            cast = cls.cast(this.f21532c.get(cls));
        }
        return cast;
    }

    /* renamed from: a */
    private void m24977a(Object obj, d dVar) throws Error {
        boolean m24982a;
        Class<?> cls = obj.getClass();
        if (this.f21545p) {
            List<Class<?>> m24984d = m24984d(cls);
            int size = m24984d.size();
            m24982a = false;
            for (int i2 = 0; i2 < size; i2++) {
                m24982a |= m24982a(obj, dVar, m24984d.get(i2));
            }
        } else {
            m24982a = m24982a(obj, dVar, cls);
        }
        if (m24982a) {
            return;
        }
        if (this.f21542m) {
            this.f21547r.mo25022a(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.f21544o || cls == C6055i.class || cls == C6060n.class) {
            return;
        }
        m24999c(new C6055i(this, obj));
    }

    /* renamed from: a */
    private boolean m24982a(Object obj, d dVar, Class<?> cls) {
        CopyOnWriteArrayList<C6063q> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f21530a.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        Iterator<C6063q> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            C6063q next = it.next();
            dVar.f21554e = obj;
            dVar.f21553d = next;
            try {
                m24981a(next, obj, dVar.f21552c);
                if (dVar.f21555f) {
                    return true;
                }
            } finally {
                dVar.f21554e = null;
                dVar.f21553d = null;
                dVar.f21555f = false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private void m24981a(C6063q c6063q, Object obj, boolean z) {
        int i2 = b.f21549a[c6063q.f21614b.f21591b.ordinal()];
        if (i2 == 1) {
            m24993a(c6063q, obj);
            return;
        }
        if (i2 == 2) {
            if (z) {
                m24993a(c6063q, obj);
                return;
            } else {
                this.f21535f.mo24975a(c6063q, obj);
                return;
            }
        }
        if (i2 == 3) {
            InterfaceC6058l interfaceC6058l = this.f21535f;
            if (interfaceC6058l != null) {
                interfaceC6058l.mo24975a(c6063q, obj);
                return;
            } else {
                m24993a(c6063q, obj);
                return;
            }
        }
        if (i2 == 4) {
            if (z) {
                this.f21536g.mo24975a(c6063q, obj);
                return;
            } else {
                m24993a(c6063q, obj);
                return;
            }
        }
        if (i2 == 5) {
            this.f21537h.mo24975a(c6063q, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + c6063q.f21614b.f21591b);
    }

    /* renamed from: a */
    static void m24979a(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                m24979a(list, cls.getInterfaces());
            }
        }
    }

    /* renamed from: a */
    void m24992a(C6056j c6056j) {
        Object obj = c6056j.f21581a;
        C6063q c6063q = c6056j.f21582b;
        C6056j.m25029a(c6056j);
        if (c6063q.f21615c) {
            m24993a(c6063q, obj);
        }
    }

    /* renamed from: a */
    void m24993a(C6063q c6063q, Object obj) {
        try {
            c6063q.f21614b.f21590a.invoke(c6063q.f21613a, obj);
        } catch (IllegalAccessException e2) {
            throw new IllegalStateException("Unexpected exception", e2);
        } catch (InvocationTargetException e3) {
            m24980a(c6063q, obj, e3.getCause());
        }
    }

    /* renamed from: a */
    private void m24980a(C6063q c6063q, Object obj, Throwable th) {
        if (obj instanceof C6060n) {
            if (this.f21541l) {
                this.f21547r.mo25023a(Level.SEVERE, "SubscriberExceptionEvent subscriber " + c6063q.f21613a.getClass() + " threw an exception", th);
                C6060n c6060n = (C6060n) obj;
                this.f21547r.mo25023a(Level.SEVERE, "Initial event " + c6060n.f21588c + " caused exception in " + c6060n.f21589d, c6060n.f21587b);
                return;
            }
            return;
        }
        if (!this.f21540k) {
            if (this.f21541l) {
                this.f21547r.mo25023a(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + c6063q.f21613a.getClass(), th);
            }
            if (this.f21543n) {
                m24999c(new C6060n(this, th, obj, c6063q.f21613a));
                return;
            }
            return;
        }
        throw new C6051e("Invoking subscriber failed", th);
    }

    /* renamed from: a */
    ExecutorService m24990a() {
        return this.f21539j;
    }
}
