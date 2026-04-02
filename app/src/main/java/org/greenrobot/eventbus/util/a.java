package org.greenrobot.eventbus.util;

import java.lang.reflect.Constructor;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.logging.Level;

/* JADX INFO: compiled from: AsyncExecutor.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    private final Executor a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Constructor<?> f12981b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final org.greenrobot.eventbus.c f12982c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final Object f12983d;

    /* JADX INFO: renamed from: org.greenrobot.eventbus.util.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AsyncExecutor.java */
    class RunnableC0279a implements Runnable {
        final /* synthetic */ c a;

        RunnableC0279a(c cVar) {
            this.a = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.a.run();
            } catch (Exception e2) {
                try {
                    Object objNewInstance = a.this.f12981b.newInstance(e2);
                    if (objNewInstance instanceof e) {
                        ((e) objNewInstance).a(a.this.f12983d);
                    }
                    a.this.f12982c.c(objNewInstance);
                } catch (Exception e3) {
                    a.this.f12982c.b().a(Level.SEVERE, "Original exception:", e2);
                    throw new RuntimeException("Could not create failure event", e3);
                }
            }
        }
    }

    /* JADX INFO: compiled from: AsyncExecutor.java */
    public static class b {
        private Executor a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Class<?> f12985b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private org.greenrobot.eventbus.c f12986c;

        /* synthetic */ b(RunnableC0279a runnableC0279a) {
            this();
        }

        public b a(Executor executor) {
            this.a = executor;
            return this;
        }

        private b() {
        }

        public b a(Class<?> cls) {
            this.f12985b = cls;
            return this;
        }

        public b a(org.greenrobot.eventbus.c cVar) {
            this.f12986c = cVar;
            return this;
        }

        public a a() {
            return a((Object) null);
        }

        public a a(Object obj) {
            if (this.f12986c == null) {
                this.f12986c = org.greenrobot.eventbus.c.f();
            }
            if (this.a == null) {
                this.a = Executors.newCachedThreadPool();
            }
            if (this.f12985b == null) {
                this.f12985b = f.class;
            }
            return new a(this.a, this.f12986c, this.f12985b, obj, null);
        }
    }

    /* JADX INFO: compiled from: AsyncExecutor.java */
    public interface c {
        void run() throws Exception;
    }

    /* synthetic */ a(Executor executor, org.greenrobot.eventbus.c cVar, Class cls, Object obj, RunnableC0279a runnableC0279a) {
        this(executor, cVar, cls, obj);
    }

    private a(Executor executor, org.greenrobot.eventbus.c cVar, Class<?> cls, Object obj) {
        this.a = executor;
        this.f12982c = cVar;
        this.f12983d = obj;
        try {
            this.f12981b = cls.getConstructor(Throwable.class);
        } catch (NoSuchMethodException e2) {
            throw new RuntimeException("Failure event class must have a constructor with one parameter of type Throwable", e2);
        }
    }

    public static b a() {
        return new b(null);
    }

    public static a b() {
        return new b(null).a();
    }

    public void a(c cVar) {
        this.a.execute(new RunnableC0279a(cVar));
    }
}
