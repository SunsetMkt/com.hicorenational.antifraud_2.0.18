package p375l;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import p375l.InterfaceC5874c;

/* compiled from: Platform.java */
/* renamed from: l.k */
/* loaded from: classes2.dex */
class C5882k {

    /* renamed from: a */
    private static final C5882k f21251a = m24769b();

    /* compiled from: Platform.java */
    /* renamed from: l.k$a */
    static class a extends C5882k {

        /* compiled from: Platform.java */
        /* renamed from: l.k$a$a, reason: collision with other inner class name */
        static class ExecutorC7437a implements Executor {

            /* renamed from: a */
            private final Handler f21252a = new Handler(Looper.getMainLooper());

            ExecutorC7437a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.f21252a.post(runnable);
            }
        }

        a() {
        }

        @Override // p375l.C5882k
        /* renamed from: a */
        public Executor mo24772a() {
            return new ExecutorC7437a();
        }

        @Override // p375l.C5882k
        /* renamed from: a */
        InterfaceC5874c.a mo24773a(@Nullable Executor executor) {
            if (executor != null) {
                return new C5878g(executor);
            }
            throw new AssertionError();
        }
    }

    /* compiled from: Platform.java */
    @IgnoreJRERequirement
    /* renamed from: l.k$b */
    static class b extends C5882k {
        b() {
        }

        @Override // p375l.C5882k
        /* renamed from: a */
        boolean mo24774a(Method method) {
            return method.isDefault();
        }

        @Override // p375l.C5882k
        /* renamed from: a */
        Object mo24771a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    C5882k() {
    }

    /* renamed from: b */
    private static C5882k m24769b() {
        try {
            Class.forName("android.os.Build");
            if (Build.VERSION.SDK_INT != 0) {
                return new a();
            }
        } catch (ClassNotFoundException unused) {
        }
        try {
            Class.forName("java.util.Optional");
            return new b();
        } catch (ClassNotFoundException unused2) {
            return new C5882k();
        }
    }

    /* renamed from: c */
    static C5882k m24770c() {
        return f21251a;
    }

    @Nullable
    /* renamed from: a */
    Executor mo24772a() {
        return null;
    }

    /* renamed from: a */
    InterfaceC5874c.a mo24773a(@Nullable Executor executor) {
        return executor != null ? new C5878g(executor) : C5877f.f21197a;
    }

    /* renamed from: a */
    boolean mo24774a(Method method) {
        return false;
    }

    @Nullable
    /* renamed from: a */
    Object mo24771a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
