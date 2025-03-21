package p251g.p252a.p260s0.p262e;

import android.os.Handler;
import android.os.Message;
import java.util.concurrent.TimeUnit;
import p251g.p252a.AbstractC4516j0;
import p251g.p252a.p255c1.C4476a;
import p251g.p252a.p264u0.C4553d;
import p251g.p252a.p264u0.InterfaceC4552c;

/* compiled from: HandlerScheduler.java */
/* renamed from: g.a.s0.e.b */
/* loaded from: classes2.dex */
final class C4539b extends AbstractC4516j0 {

    /* renamed from: b */
    private final Handler f17453b;

    /* compiled from: HandlerScheduler.java */
    /* renamed from: g.a.s0.e.b$a */
    private static final class a extends AbstractC4516j0.c {

        /* renamed from: a */
        private final Handler f17454a;

        /* renamed from: b */
        private volatile boolean f17455b;

        a(Handler handler) {
            this.f17454a = handler;
        }

        @Override // p251g.p252a.AbstractC4516j0.c
        /* renamed from: a */
        public InterfaceC4552c mo17283a(Runnable runnable, long j2, TimeUnit timeUnit) {
            if (runnable == null) {
                throw new NullPointerException("run == null");
            }
            if (timeUnit == null) {
                throw new NullPointerException("unit == null");
            }
            if (this.f17455b) {
                return C4553d.m18183a();
            }
            b bVar = new b(this.f17454a, C4476a.m17139a(runnable));
            Message obtain = Message.obtain(this.f17454a, bVar);
            obtain.obj = this;
            this.f17454a.sendMessageDelayed(obtain, Math.max(0L, timeUnit.toMillis(j2)));
            if (!this.f17455b) {
                return bVar;
            }
            this.f17454a.removeCallbacks(bVar);
            return C4553d.m18183a();
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17455b = true;
            this.f17454a.removeCallbacksAndMessages(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17455b;
        }
    }

    /* compiled from: HandlerScheduler.java */
    /* renamed from: g.a.s0.e.b$b */
    private static final class b implements Runnable, InterfaceC4552c {

        /* renamed from: a */
        private final Handler f17456a;

        /* renamed from: b */
        private final Runnable f17457b;

        /* renamed from: c */
        private volatile boolean f17458c;

        b(Handler handler, Runnable runnable) {
            this.f17456a = handler;
            this.f17457b = runnable;
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public void dispose() {
            this.f17458c = true;
            this.f17456a.removeCallbacks(this);
        }

        @Override // p251g.p252a.p264u0.InterfaceC4552c
        public boolean isDisposed() {
            return this.f17458c;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f17457b.run();
            } catch (Throwable th) {
                IllegalStateException illegalStateException = new IllegalStateException("Fatal Exception thrown on Scheduler.", th);
                C4476a.m17152b(illegalStateException);
                Thread currentThread = Thread.currentThread();
                currentThread.getUncaughtExceptionHandler().uncaughtException(currentThread, illegalStateException);
            }
        }
    }

    C4539b(Handler handler) {
        this.f17453b = handler;
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: a */
    public InterfaceC4552c mo17409a(Runnable runnable, long j2, TimeUnit timeUnit) {
        if (runnable == null) {
            throw new NullPointerException("run == null");
        }
        if (timeUnit == null) {
            throw new NullPointerException("unit == null");
        }
        b bVar = new b(this.f17453b, C4476a.m17139a(runnable));
        this.f17453b.postDelayed(bVar, Math.max(0L, timeUnit.toMillis(j2)));
        return bVar;
    }

    @Override // p251g.p252a.AbstractC4516j0
    /* renamed from: a */
    public AbstractC4516j0.c mo17277a() {
        return new a(this.f17453b);
    }
}
