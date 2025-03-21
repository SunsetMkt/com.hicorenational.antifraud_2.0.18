package com.bumptech.glide.load.p118p.p121c0;

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

/* compiled from: GlideExecutor.java */
/* renamed from: com.bumptech.glide.load.p.c0.a */
/* loaded from: classes.dex */
public final class ExecutorServiceC1653a implements ExecutorService {

    /* renamed from: b */
    private static final String f4400b = "source";

    /* renamed from: c */
    private static final String f4401c = "disk-cache";

    /* renamed from: d */
    private static final int f4402d = 1;

    /* renamed from: e */
    private static final String f4403e = "GlideExecutor";

    /* renamed from: f */
    private static final String f4404f = "source-unlimited";

    /* renamed from: g */
    private static final String f4405g = "animation";

    /* renamed from: h */
    private static final long f4406h = TimeUnit.SECONDS.toMillis(10);

    /* renamed from: i */
    private static final int f4407i = 4;

    /* renamed from: j */
    private static volatile int f4408j;

    /* renamed from: a */
    private final ExecutorService f4409a;

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.p.c0.a$a */
    public static final class a {

        /* renamed from: g */
        public static final long f4410g = 0;

        /* renamed from: a */
        private final boolean f4411a;

        /* renamed from: b */
        private int f4412b;

        /* renamed from: c */
        private int f4413c;

        /* renamed from: d */
        @NonNull
        private c f4414d = c.f4426d;

        /* renamed from: e */
        private String f4415e;

        /* renamed from: f */
        private long f4416f;

        a(boolean z) {
            this.f4411a = z;
        }

        /* renamed from: a */
        public a m4041a(long j2) {
            this.f4416f = j2;
            return this;
        }

        /* renamed from: a */
        public a m4040a(@IntRange(from = 1) int i2) {
            this.f4412b = i2;
            this.f4413c = i2;
            return this;
        }

        /* renamed from: a */
        public a m4042a(@NonNull c cVar) {
            this.f4414d = cVar;
            return this;
        }

        /* renamed from: a */
        public a m4043a(String str) {
            this.f4415e = str;
            return this;
        }

        /* renamed from: a */
        public ExecutorServiceC1653a m4044a() {
            if (!TextUtils.isEmpty(this.f4415e)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.f4412b, this.f4413c, this.f4416f, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new b(this.f4415e, this.f4414d, this.f4411a));
                if (this.f4416f != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new ExecutorServiceC1653a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f4415e);
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.p.c0.a$b */
    private static final class b implements ThreadFactory {

        /* renamed from: e */
        private static final int f4417e = 9;

        /* renamed from: a */
        private final String f4418a;

        /* renamed from: b */
        final c f4419b;

        /* renamed from: c */
        final boolean f4420c;

        /* renamed from: d */
        private int f4421d;

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.p.c0.a$b$a */
        class a extends Thread {
            a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                if (b.this.f4420c) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    super.run();
                } catch (Throwable th) {
                    b.this.f4419b.mo4045a(th);
                }
            }
        }

        b(String str, c cVar, boolean z) {
            this.f4418a = str;
            this.f4419b = cVar;
            this.f4420c = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public synchronized Thread newThread(@NonNull Runnable runnable) {
            a aVar;
            aVar = new a(runnable, "glide-" + this.f4418a + "-thread-" + this.f4421d);
            this.f4421d = this.f4421d + 1;
            return aVar;
        }
    }

    /* compiled from: GlideExecutor.java */
    /* renamed from: com.bumptech.glide.load.p.c0.a$c */
    public interface c {

        /* renamed from: a */
        public static final c f4423a = new a();

        /* renamed from: b */
        public static final c f4424b = new b();

        /* renamed from: c */
        public static final c f4425c = new C7359c();

        /* renamed from: d */
        public static final c f4426d = f4424b;

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.p.c0.a$c$a */
        class a implements c {
            a() {
            }

            @Override // com.bumptech.glide.load.p118p.p121c0.ExecutorServiceC1653a.c
            /* renamed from: a */
            public void mo4045a(Throwable th) {
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.p.c0.a$c$b */
        class b implements c {
            b() {
            }

            @Override // com.bumptech.glide.load.p118p.p121c0.ExecutorServiceC1653a.c
            /* renamed from: a */
            public void mo4045a(Throwable th) {
                if (th != null) {
                    Log.isLoggable(ExecutorServiceC1653a.f4403e, 6);
                }
            }
        }

        /* compiled from: GlideExecutor.java */
        /* renamed from: com.bumptech.glide.load.p.c0.a$c$c, reason: collision with other inner class name */
        class C7359c implements c {
            C7359c() {
            }

            @Override // com.bumptech.glide.load.p118p.p121c0.ExecutorServiceC1653a.c
            /* renamed from: a */
            public void mo4045a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        /* renamed from: a */
        void mo4045a(Throwable th);
    }

    @VisibleForTesting
    ExecutorServiceC1653a(ExecutorService executorService) {
        this.f4409a = executorService;
    }

    @Deprecated
    /* renamed from: a */
    public static ExecutorServiceC1653a m4030a(c cVar) {
        return m4035d().m4042a(cVar).m4044a();
    }

    @Deprecated
    /* renamed from: b */
    public static ExecutorServiceC1653a m4033b(c cVar) {
        return m4037f().m4042a(cVar).m4044a();
    }

    /* renamed from: c */
    public static ExecutorServiceC1653a m4034c() {
        return m4031b().m4044a();
    }

    /* renamed from: d */
    public static a m4035d() {
        return new a(true).m4040a(1).m4043a(f4401c);
    }

    /* renamed from: e */
    public static ExecutorServiceC1653a m4036e() {
        return m4035d().m4044a();
    }

    /* renamed from: f */
    public static a m4037f() {
        return new a(false).m4040a(m4027a()).m4043a("source");
    }

    /* renamed from: g */
    public static ExecutorServiceC1653a m4038g() {
        return m4037f().m4044a();
    }

    /* renamed from: h */
    public static ExecutorServiceC1653a m4039h() {
        return new ExecutorServiceC1653a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, f4406h, TimeUnit.MILLISECONDS, new SynchronousQueue(), new b(f4404f, c.f4426d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f4409a.awaitTermination(j2, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f4409a.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f4409a.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException, ExecutionException {
        return (T) this.f4409a.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f4409a.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f4409a.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f4409a.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f4409a.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f4409a.submit(runnable);
    }

    public String toString() {
        return this.f4409a.toString();
    }

    @Deprecated
    /* renamed from: a */
    public static ExecutorServiceC1653a m4029a(int i2, String str, c cVar) {
        return m4035d().m4040a(i2).m4043a(str).m4042a(cVar).m4044a();
    }

    @Deprecated
    /* renamed from: b */
    public static ExecutorServiceC1653a m4032b(int i2, String str, c cVar) {
        return m4037f().m4040a(i2).m4043a(str).m4042a(cVar).m4044a();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f4409a.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException, ExecutionException, TimeoutException {
        return (T) this.f4409a.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f4409a.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f4409a.submit(callable);
    }

    @Deprecated
    /* renamed from: a */
    public static ExecutorServiceC1653a m4028a(int i2, c cVar) {
        return m4031b().m4040a(i2).m4042a(cVar).m4044a();
    }

    /* renamed from: b */
    public static a m4031b() {
        return new a(true).m4040a(m4027a() >= 4 ? 2 : 1).m4043a(f4405g);
    }

    /* renamed from: a */
    public static int m4027a() {
        if (f4408j == 0) {
            f4408j = Math.min(4, C1654b.m4046a());
        }
        return f4408j;
    }
}
