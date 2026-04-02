package h.a.s0.e;

import android.os.Handler;
import android.os.Message;
import h.a.j0;
import h.a.u0.c;
import h.a.u0.d;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: HandlerScheduler.java */
/* JADX INFO: loaded from: classes2.dex */
final class b extends j0 {

    /* JADX INFO: renamed from: b */
    private final Handler f10419b;

    /* JADX INFO: compiled from: HandlerScheduler.java */
    private static final class a extends j0.c {
        private final Handler a;

        /* JADX INFO: renamed from: b */
        private volatile boolean f10420b;

        a(Handler handler) {
            this.a = handler;
        }

        @Override // h.a.j0.c
        public c a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f10420b) {
                return d.a();
            }
            RunnableC0179b runnableC0179b = new RunnableC0179b(this.a, h.a.c1.a.a(runnable));
            Message messageObtain = Message.obtain(this.a, runnableC0179b);
            messageObtain.obj = this;
            this.a.sendMessageDelayed(messageObtain, Math.max(0L, timeUnit.toMillis(j2)));
            if (!this.f10420b) {
                return runnableC0179b;
            }
            this.a.removeCallbacks(runnableC0179b);
            return d.a();
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10420b = true;
            this.a.removeCallbacksAndMessages(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10420b;
        }
    }

    /* JADX INFO: renamed from: h.a.s0.e.b$b */
    /* JADX INFO: compiled from: HandlerScheduler.java */
    private static final class RunnableC0179b implements Runnable, c {
        private final Handler a;

        /* JADX INFO: renamed from: b */
        private final Runnable f10421b;

        /* JADX INFO: renamed from: c */
        private volatile boolean f10422c;

        RunnableC0179b(Handler handler, Runnable runnable) {
            this.a = handler;
            this.f10421b = runnable;
        }

        @Override // h.a.u0.c
        public void dispose() {
            this.f10422c = true;
            this.a.removeCallbacks(this);
        }

        @Override // h.a.u0.c
        public boolean isDisposed() {
            return this.f10422c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f10421b.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                h.a.c1.a.b(illegalStateException);
                Thread threadCurrentThread = Thread.currentThread();
                threadCurrentThread.getUncaughtExceptionHandler().uncaughtException(threadCurrentThread, illegalStateException);
            }
        }
    }

    b(Handler handler) {
        this.f10419b = handler;
    }

    @Override // h.a.j0
    public c a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        RunnableC0179b runnableC0179b = new RunnableC0179b(this.f10419b, h.a.c1.a.a(runnable));
        this.f10419b.postDelayed(runnableC0179b, Math.max(0L, timeUnit.toMillis(j2)));
        return runnableC0179b;
    }

    @Override // h.a.j0
    public j0.c a() {
        return new a(this.f10419b);
    }
}
