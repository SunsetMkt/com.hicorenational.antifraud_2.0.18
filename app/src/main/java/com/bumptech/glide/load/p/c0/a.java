package com.bumptech.glide.load.p.c0;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: GlideExecutor.java */
/* JADX INFO: loaded from: classes.dex */
public final class a implements ExecutorService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f2868b = "source";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f2869c = "disk-cache";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f2870d = 1;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final String f2871e = "GlideExecutor";

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f2872f = "source-unlimited";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f2873g = "animation";

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final long f2874h = TimeUnit.SECONDS.toMillis(10);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f2875i = 4;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static volatile int f2876j;
    private final ExecutorService a;

    /* JADX INFO: renamed from: com.bumptech.glide.load.p.c0.a$a, reason: collision with other inner class name */
    /* JADX INFO: compiled from: GlideExecutor.java */
    public static final class C0047a {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public static final long f2877g = 0;
        private final boolean a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f2878b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f2879c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        @NonNull
        private c f2880d = c.f2889d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private String f2881e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private long f2882f;

        C0047a(boolean z) {
            this.a = z;
        }

        public C0047a a(long j2) {
            this.f2882f = j2;
            return this;
        }

        public C0047a a(@IntRange(from = 1) int i2) {
            this.f2878b = i2;
            this.f2879c = i2;
            return this;
        }

        public C0047a a(@NonNull c cVar) {
            this.f2880d = cVar;
            return this;
        }

        public C0047a a(String str) {
            this.f2881e = str;
            return this;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f2881e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f2878b, this.f2879c, this.f2882f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f2881e, this.f2880d, this.a));
                if (this.f2882f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f2881e);
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    private static final class b implements ThreadFactory {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private static final int f2883e = 9;
        private final String a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final c f2884b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final boolean f2885c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f2886d;

        /* JADX INFO: renamed from: com.bumptech.glide.load.p.c0.a$b$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0048a extends Thread {
            C0048a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f2885c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.f2884b.a(th);
                }
            }
        }

        b(String str, c cVar, boolean z) {
            this.a = str;
            this.f2884b = cVar;
            this.f2885c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            C0048a c0048a;
            c0048a = new C0048a(runnable, "glide-" + this.a + "-thread-" + this.f2886d);
            this.f2886d = this.f2886d + 1;
            return c0048a;
        }
    }

    /* JADX INFO: compiled from: GlideExecutor.java */
    public interface c {
        public static final c a = new C0049a();

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f2887b = new b();

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f2888c = new C0050c();

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final c f2889d = f2887b;

        /* JADX INFO: renamed from: com.bumptech.glide.load.p.c0.a$c$a, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0049a implements c {
            C0049a() {
            }

            @Override // com.bumptech.glide.load.p.c0.a.c
            public void a(Throwable th) {
            }
        }

        /* JADX INFO: compiled from: GlideExecutor.java */
        class b implements c {
            b() {
            }

            @Override // com.bumptech.glide.load.p.c0.a.c
            public void a(Throwable th) {
                if (th != null) {
                    Log.isLoggable(a.f2871e, 6);
                }
            }
        }

        /* JADX INFO: renamed from: com.bumptech.glide.load.p.c0.a$c$c, reason: collision with other inner class name */
        /* JADX INFO: compiled from: GlideExecutor.java */
        class C0050c implements c {
            C0050c() {
            }

            @Override // com.bumptech.glide.load.p.c0.a.c
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    a(ExecutorService executorService) {
        this.a = executorService;
    }

    @Deprecated
    public static a a(c cVar) {
        return d().a(cVar).a();
    }

    @Deprecated
    public static a b(c cVar) {
        return f().a(cVar).a();
    }

    public static a c() {
        return b().a();
    }

    public static C0047a d() {
        return new C0047a(true).a(1).a(f2869c);
    }

    public static a e() {
        return d().a();
    }

    public static C0047a f() {
        return new C0047a(false).a(a()).a("source");
    }

    public static a g() {
        return f().a();
    }

    public static a h() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f2874h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b(f2872f, c.f2889d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.a.submit(runnable);
    }

    public String toString() {
        return this.a.toString();
    }

    @Deprecated
    public static a a(int i2, String str, c cVar) {
        return d().a(i2).a(str).a(cVar).a();
    }

    @Deprecated
    public static a b(int i2, String str, c cVar) {
        return f().a(i2).a(str).a(cVar).a();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.a.submit(callable);
    }

    @Deprecated
    public static a a(int i2, c cVar) {
        return b().a(i2).a(cVar).a();
    }

    public static C0047a b() {
        return new C0047a(true).a(a() >= 4 ? 2 : 1).a(f2873g);
    }

    public static int a() {
        if (f2876j == 0) {
            f2876j = Math.min(4, com.bumptech.glide.load.p.c0.b.a());
        }
        return f2876j;
    }
}
