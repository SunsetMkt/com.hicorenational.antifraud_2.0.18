package m;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.invoke.MethodHandles;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import m.c;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;

/* JADX INFO: compiled from: Platform.java */
/* JADX INFO: loaded from: classes2.dex */
class k {
    private static final k a = b();

    /* JADX INFO: compiled from: Platform.java */
    static class a extends k {

        /* JADX INFO: renamed from: m.k$a$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: Platform.java */
        static class ExecutorC0273a implements Executor {
            private final Handler a = new Handler(Looper.getMainLooper());

            ExecutorC0273a() {
            }

            @Override // java.util.concurrent.Executor
            public void execute(Runnable runnable) {
                this.a.post(runnable);
            }
        }

        a() {
        }

        @Override // m.k
        public Executor a() {
            return new ExecutorC0273a();
        }

        @Override // m.k
        c.a a(@Nullable Executor executor) {
            if (executor != null) {
                return new g(executor);
            }
            throw new AssertionError();
        }
    }

    /* JADX INFO: compiled from: Platform.java */
    @IgnoreJRERequirement
    static class b extends k {
        b() {
        }

        @Override // m.k
        boolean a(Method method) {
            return method.isDefault();
        }

        @Override // m.k
        Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
            Constructor declaredConstructor = MethodHandles.Lookup.class.getDeclaredConstructor(Class.class, Integer.TYPE);
            declaredConstructor.setAccessible(true);
            return ((MethodHandles.Lookup) declaredConstructor.newInstance(cls, -1)).unreflectSpecial(method, cls).bindTo(obj).invokeWithArguments(objArr);
        }
    }

    k() {
    }

    private static k b() {
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
            return new k();
        }
    }

    static k c() {
        return a;
    }

    @Nullable
    Executor a() {
        return null;
    }

    c.a a(@Nullable Executor executor) {
        return executor != null ? new g(executor) : f.a;
    }

    boolean a(Method method) {
        return false;
    }

    @Nullable
    Object a(Method method, Class<?> cls, Object obj, @Nullable Object... objArr) throws Throwable {
        throw new UnsupportedOperationException();
    }
}
