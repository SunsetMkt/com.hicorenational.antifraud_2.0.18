package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import org.greenrobot.eventbus.C6049c;

/* compiled from: AsyncExecutor.java */
/* renamed from: org.greenrobot.eventbus.util.a */
/* loaded from: classes2.dex */
public class C6069a {

    /* renamed from: a */
    private final Executor f21644a;

    /* renamed from: b */
    private final Constructor<?> f21645b;

    /* renamed from: c */
    private final C6049c f21646c;

    /* renamed from: d */
    private final Object f21647d;

    /* compiled from: AsyncExecutor.java */
    /* renamed from: org.greenrobot.eventbus.util.a$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ c f21648a;

        a(c cVar) {
            this.f21648a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f21648a.run();
            } catch (Exception e2) {
                try {
                    Object newInstance = C6069a.this.f21645b.newInstance(e2);
                    if (newInstance instanceof InterfaceC6073e) {
                        ((InterfaceC6073e) newInstance).mo25096a(C6069a.this.f21647d);
                    }
                    C6069a.this.f21646c.m24999c(newInstance);
                } catch (Exception e3) {
                    C6069a.this.f21646c.m24994b().mo25023a(Level.SEVERE, "Original exception:", e2);
                    throw new RuntimeException("Could not create failure event", e3);
                }
            }
        }
    }

    /* compiled from: AsyncExecutor.java */
    /* renamed from: org.greenrobot.eventbus.util.a$b */
    public static class b {

        /* renamed from: a */
        private Executor f21650a;

        /* renamed from: b */
        private Class<?> f21651b;

        /* renamed from: c */
        private C6049c f21652c;

        /* synthetic */ b(a aVar) {
            this();
        }

        /* renamed from: a */
        public b m25076a(Executor executor) {
            this.f21650a = executor;
            return this;
        }

        private b() {
        }

        /* renamed from: a */
        public b m25075a(Class<?> cls) {
            this.f21651b = cls;
            return this;
        }

        /* renamed from: a */
        public b m25077a(C6049c c6049c) {
            this.f21652c = c6049c;
            return this;
        }

        /* renamed from: a */
        public C6069a m25078a() {
            return m25079a((Object) null);
        }

        /* renamed from: a */
        public C6069a m25079a(Object obj) {
            if (this.f21652c == null) {
                this.f21652c = C6049c.m24987f();
            }
            if (this.f21650a == null) {
                this.f21650a = Executors.newCachedThreadPool();
            }
            if (this.f21651b == null) {
                this.f21651b = C6074f.class;
            }
            return new C6069a(this.f21650a, this.f21652c, this.f21651b, obj, null);
        }
    }

    /* compiled from: AsyncExecutor.java */
    /* renamed from: org.greenrobot.eventbus.util.a$c */
    public interface c {
        void run() throws Exception;
    }

    /* synthetic */ C6069a(Executor executor, C6049c c6049c, Class cls, Object obj, a aVar) {
        this(executor, c6049c, cls, obj);
    }

    private C6069a(Executor executor, C6049c c6049c, Class<?> cls, Object obj) {
        this.f21644a = executor;
        this.f21646c = c6049c;
        this.f21647d = obj;
        try {
            this.f21645b = cls.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e2);
        }
    }

    /* renamed from: a */
    public static b m25070a() {
        return new b(null);
    }

    /* renamed from: b */
    public static C6069a m25072b() {
        return new b(null).m25078a();
    }

    /* renamed from: a */
    public void m25074a(c cVar) {
        this.f21644a.execute(new a(cVar));
    }
}
