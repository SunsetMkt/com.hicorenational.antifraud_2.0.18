package com.xiaomi.push.service;

import android.os.SystemClock;
import java.util.concurrent.RejectedExecutionException;

/* JADX INFO: loaded from: classes2.dex */
public class n {
    private static long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static long f9403b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static long f9404c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final a f1055a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final c f1056a;

    private static final class a {
        private final c a;

        a(c cVar) {
            this.a = cVar;
        }

        protected void finalize() throws Throwable {
            try {
                synchronized (this.a) {
                    this.a.f9406c = true;
                    this.a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    public static abstract class b implements Runnable {
        protected int a;

        public b(int i2) {
            this.a = i2;
        }
    }

    private static final class c extends Thread {

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        private boolean f1059b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private boolean f9406c;
        private volatile long a = 0;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private volatile boolean f1058a = false;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f9405b = 50;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private a f1057a = new a();

        private static final class a {
            private int a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            private d[] f1060a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f9407b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private int f9408c;

            private a() {
                this.a = 256;
                this.f1060a = new d[this.a];
                this.f9407b = 0;
                this.f9408c = 0;
            }

            private void c() {
                int i2 = this.f9407b - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f1060a;
                    if (dVarArr[i2].f1061a >= dVarArr[i3].f1061a) {
                        return;
                    }
                    d dVar = dVarArr[i2];
                    dVarArr[i2] = dVarArr[i3];
                    dVarArr[i3] = dVar;
                    int i4 = i3;
                    i3 = (i3 - 1) / 2;
                    i2 = i4;
                }
            }

            public void b(int i2) {
                int i3;
                if (i2 < 0 || i2 >= (i3 = this.f9407b)) {
                    return;
                }
                d[] dVarArr = this.f1060a;
                int i4 = i3 - 1;
                this.f9407b = i4;
                dVarArr[i2] = dVarArr[i4];
                dVarArr[this.f9407b] = null;
                c(i2);
            }

            public d a() {
                return this.f1060a[0];
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m736a() {
                return this.f9407b == 0;
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m735a(d dVar) {
                d[] dVarArr = this.f1060a;
                int length = dVarArr.length;
                int i2 = this.f9407b;
                if (length == i2) {
                    d[] dVarArr2 = new d[i2 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                    this.f1060a = dVarArr2;
                }
                d[] dVarArr3 = this.f1060a;
                int i3 = this.f9407b;
                this.f9407b = i3 + 1;
                dVarArr3[i3] = dVar;
                c();
            }

            public void b() {
                int i2 = 0;
                while (i2 < this.f9407b) {
                    if (this.f1060a[i2].f1064a) {
                        this.f9408c++;
                        b(i2);
                        i2--;
                    }
                    i2++;
                }
            }

            private void c(int i2) {
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f9407b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f1060a;
                        if (dVarArr[i5].f1061a < dVarArr[i3].f1061a) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f1060a;
                    if (dVarArr2[i2].f1061a < dVarArr2[i3].f1061a) {
                        return;
                    }
                    d dVar = dVarArr2[i2];
                    dVarArr2[i2] = dVarArr2[i3];
                    dVarArr2[i3] = dVar;
                    int i6 = i3;
                    i3 = (i3 * 2) + 1;
                    i2 = i6;
                }
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public boolean m737a(int i2) {
                for (int i3 = 0; i3 < this.f9407b; i3++) {
                    if (this.f1060a[i3].a == i2) {
                        return true;
                    }
                }
                return false;
            }

            public void a(int i2) {
                for (int i3 = 0; i3 < this.f9407b; i3++) {
                    d[] dVarArr = this.f1060a;
                    if (dVarArr[i3].a == i2) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            public void a(int i2, b bVar) {
                for (int i3 = 0; i3 < this.f9407b; i3++) {
                    d[] dVarArr = this.f1060a;
                    if (dVarArr[i3].f1062a == bVar) {
                        dVarArr[i3].a();
                    }
                }
                b();
            }

            /* JADX INFO: renamed from: a, reason: collision with other method in class */
            public void m734a() {
                this.f1060a = new d[this.a];
                this.f9407b = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public int a(d dVar) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.f1060a;
                    if (i2 >= dVarArr.length) {
                        return -1;
                    }
                    if (dVarArr[i2] == dVar) {
                        return i2;
                    }
                    i2++;
                }
            }
        }

        c(String str, boolean z) {
            setName(str);
            setDaemon(z);
            start();
        }

        /* JADX WARN: Code restructure failed: missing block: B:53:0x0099, code lost:
        
            r10.a = android.os.SystemClock.uptimeMillis();
            r10.f1058a = true;
            r2.f1062a.run();
            r10.f1058a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:55:0x00aa, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:56:0x00ab, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:57:0x00ac, code lost:
        
            r10.f1059b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:59:0x00af, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public void run() {
            while (true) {
                synchronized (this) {
                    if (this.f1059b) {
                        return;
                    }
                    if (!this.f1057a.m736a()) {
                        long jA = n.a();
                        d dVarA = this.f1057a.a();
                        synchronized (dVarA.f1063a) {
                            if (dVarA.f1064a) {
                                this.f1057a.b(0);
                            } else {
                                long j2 = dVarA.f1061a - jA;
                                if (j2 > 0) {
                                    if (j2 > this.f9405b) {
                                        j2 = this.f9405b;
                                    }
                                    this.f9405b += 50;
                                    if (this.f9405b > 500) {
                                        this.f9405b = 500L;
                                    }
                                    try {
                                        wait(j2);
                                    } catch (InterruptedException unused) {
                                    }
                                } else {
                                    this.f9405b = 50L;
                                    synchronized (dVarA.f1063a) {
                                        int iA = this.f1057a.a().f1061a != dVarA.f1061a ? this.f1057a.a(dVarA) : 0;
                                        if (dVarA.f1064a) {
                                            this.f1057a.b(this.f1057a.a(dVarA));
                                        } else {
                                            dVarA.a(dVarA.f1061a);
                                            this.f1057a.b(iA);
                                            dVarA.f1061a = 0L;
                                        }
                                    }
                                }
                            }
                        }
                    } else if (this.f9406c) {
                        return;
                    } else {
                        try {
                            wait();
                        } catch (InterruptedException unused2) {
                        }
                    }
                }
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(d dVar) {
            this.f1057a.m735a(dVar);
            notify();
        }

        public synchronized void a() {
            this.f1059b = true;
            this.f1057a.m734a();
            notify();
        }

        /* JADX INFO: renamed from: a, reason: collision with other method in class */
        public boolean m733a() {
            return this.f1058a && SystemClock.uptimeMillis() - this.a > 600000;
        }
    }

    static {
        a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f9403b = a;
    }

    public n(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f1056a = new c(str, z);
        this.f1055a = new a(this.f1056a);
    }

    static synchronized long a() {
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        if (jElapsedRealtime > f9403b) {
            a += jElapsedRealtime - f9403b;
        }
        f9403b = jElapsedRealtime;
        return a;
    }

    private static synchronized long b() {
        long j2;
        j2 = f9404c;
        f9404c = 1 + j2;
        return j2;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public void m731b() {
        synchronized (this.f1056a) {
            this.f1056a.f1057a.m734a();
        }
    }

    static class d {
        int a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        long f1061a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        b f1062a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final Object f1063a = new Object();

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        boolean f1064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private long f9409b;

        d() {
        }

        void a(long j2) {
            synchronized (this.f1063a) {
                this.f9409b = j2;
            }
        }

        public boolean a() {
            boolean z;
            synchronized (this.f1063a) {
                z = !this.f1064a && this.f1061a > 0;
                this.f1064a = true;
            }
            return z;
        }
    }

    public n(String str) {
        this(str, false);
    }

    private void b(b bVar, long j2) {
        synchronized (this.f1056a) {
            if (!this.f1056a.f1059b) {
                long jA = j2 + a();
                if (jA >= 0) {
                    d dVar = new d();
                    dVar.a = bVar.a;
                    dVar.f1062a = bVar;
                    dVar.f1061a = jA;
                    this.f1056a.a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + jA);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public n(boolean z) {
        this("Timer-" + b(), z);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public void m728a() {
        com.xiaomi.channel.commonutils.logger.b.m48a("quit. finalizer:" + this.f1055a);
        this.f1056a.a();
    }

    public n() {
        this(false);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m730a(int i2) {
        boolean zM737a;
        synchronized (this.f1056a) {
            zM737a = this.f1056a.f1057a.m737a(i2);
        }
        return zM737a;
    }

    public void a(int i2) {
        synchronized (this.f1056a) {
            this.f1056a.f1057a.a(i2);
        }
    }

    public void a(int i2, b bVar) {
        synchronized (this.f1056a) {
            this.f1056a.f1057a.a(i2, bVar);
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m729a() {
        return this.f1056a.m733a();
    }

    public void a(b bVar) {
        if (com.xiaomi.channel.commonutils.logger.b.a() < 1 && Thread.currentThread() != this.f1056a) {
            com.xiaomi.channel.commonutils.logger.b.d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    public void a(b bVar, long j2) {
        if (j2 >= 0) {
            b(bVar, j2);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j2);
    }
}
