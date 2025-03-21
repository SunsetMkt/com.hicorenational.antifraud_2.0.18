package com.xiaomi.push.service;

import android.os.SystemClock;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.concurrent.RejectedExecutionException;

/* renamed from: com.xiaomi.push.service.n */
/* loaded from: classes2.dex */
public class C4391n {

    /* renamed from: a */
    private static long f16725a;

    /* renamed from: b */
    private static long f16726b;

    /* renamed from: c */
    private static long f16727c;

    /* renamed from: a */
    private final a f16728a;

    /* renamed from: a */
    private final c f16729a;

    /* renamed from: com.xiaomi.push.service.n$a */
    private static final class a {

        /* renamed from: a */
        private final c f16730a;

        a(c cVar) {
            this.f16730a = cVar;
        }

        protected void finalize() {
            try {
                synchronized (this.f16730a) {
                    this.f16730a.f16737c = true;
                    this.f16730a.notify();
                }
            } finally {
                super.finalize();
            }
        }
    }

    /* renamed from: com.xiaomi.push.service.n$b */
    public static abstract class b implements Runnable {

        /* renamed from: a */
        protected int f16731a;

        public b(int i2) {
            this.f16731a = i2;
        }
    }

    /* renamed from: com.xiaomi.push.service.n$c */
    private static final class c extends Thread {

        /* renamed from: b */
        private boolean f16736b;

        /* renamed from: c */
        private boolean f16737c;

        /* renamed from: a */
        private volatile long f16732a = 0;

        /* renamed from: a */
        private volatile boolean f16734a = false;

        /* renamed from: b */
        private long f16735b = 50;

        /* renamed from: a */
        private a f16733a = new a();

        /* renamed from: com.xiaomi.push.service.n$c$a */
        private static final class a {

            /* renamed from: a */
            private int f16738a;

            /* renamed from: a */
            private d[] f16739a;

            /* renamed from: b */
            private int f16740b;

            /* renamed from: c */
            private int f16741c;

            private a() {
                this.f16738a = 256;
                this.f16739a = new d[this.f16738a];
                this.f16740b = 0;
                this.f16741c = 0;
            }

            /* renamed from: c */
            private void m16181c() {
                int i2 = this.f16740b - 1;
                int i3 = (i2 - 1) / 2;
                while (true) {
                    d[] dVarArr = this.f16739a;
                    if (dVarArr[i2].f16743a >= dVarArr[i3].f16743a) {
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

            /* renamed from: b */
            public void m16191b(int i2) {
                int i3;
                if (i2 < 0 || i2 >= (i3 = this.f16740b)) {
                    return;
                }
                d[] dVarArr = this.f16739a;
                int i4 = i3 - 1;
                this.f16740b = i4;
                dVarArr[i2] = dVarArr[i4];
                dVarArr[this.f16740b] = null;
                m16182c(i2);
            }

            /* renamed from: a */
            public d m16183a() {
                return this.f16739a[0];
            }

            /* renamed from: a */
            public boolean m16188a() {
                return this.f16740b == 0;
            }

            /* renamed from: a */
            public void m16187a(d dVar) {
                d[] dVarArr = this.f16739a;
                int length = dVarArr.length;
                int i2 = this.f16740b;
                if (length == i2) {
                    d[] dVarArr2 = new d[i2 * 2];
                    System.arraycopy(dVarArr, 0, dVarArr2, 0, i2);
                    this.f16739a = dVarArr2;
                }
                d[] dVarArr3 = this.f16739a;
                int i3 = this.f16740b;
                this.f16740b = i3 + 1;
                dVarArr3[i3] = dVar;
                m16181c();
            }

            /* renamed from: b */
            public void m16190b() {
                int i2 = 0;
                while (i2 < this.f16740b) {
                    if (this.f16739a[i2].f16746a) {
                        this.f16741c++;
                        m16191b(i2);
                        i2--;
                    }
                    i2++;
                }
            }

            /* renamed from: c */
            private void m16182c(int i2) {
                int i3 = (i2 * 2) + 1;
                while (true) {
                    int i4 = this.f16740b;
                    if (i3 >= i4 || i4 <= 0) {
                        return;
                    }
                    int i5 = i3 + 1;
                    if (i5 < i4) {
                        d[] dVarArr = this.f16739a;
                        if (dVarArr[i5].f16743a < dVarArr[i3].f16743a) {
                            i3 = i5;
                        }
                    }
                    d[] dVarArr2 = this.f16739a;
                    if (dVarArr2[i2].f16743a < dVarArr2[i3].f16743a) {
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

            /* renamed from: a */
            public boolean m16189a(int i2) {
                for (int i3 = 0; i3 < this.f16740b; i3++) {
                    if (this.f16739a[i3].f16742a == i2) {
                        return true;
                    }
                }
                return false;
            }

            /* renamed from: a */
            public void m16185a(int i2) {
                for (int i3 = 0; i3 < this.f16740b; i3++) {
                    d[] dVarArr = this.f16739a;
                    if (dVarArr[i3].f16742a == i2) {
                        dVarArr[i3].m16193a();
                    }
                }
                m16190b();
            }

            /* renamed from: a */
            public void m16186a(int i2, b bVar) {
                for (int i3 = 0; i3 < this.f16740b; i3++) {
                    d[] dVarArr = this.f16739a;
                    if (dVarArr[i3].f16744a == bVar) {
                        dVarArr[i3].m16193a();
                    }
                }
                m16190b();
            }

            /* renamed from: a */
            public void m16184a() {
                this.f16739a = new d[this.f16738a];
                this.f16740b = 0;
            }

            /* JADX INFO: Access modifiers changed from: private */
            /* renamed from: a */
            public int m16180a(d dVar) {
                int i2 = 0;
                while (true) {
                    d[] dVarArr = this.f16739a;
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

        /* JADX WARN: Code restructure failed: missing block: B:33:0x0099, code lost:
        
            r10.f16732a = android.os.SystemClock.uptimeMillis();
            r10.f16734a = true;
            r2.f16744a.run();
            r10.f16734a = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:37:0x00aa, code lost:
        
            r1 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00ab, code lost:
        
            monitor-enter(r10);
         */
        /* JADX WARN: Code restructure failed: missing block: B:40:0x00ac, code lost:
        
            r10.f16736b = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:42:0x00af, code lost:
        
            throw r1;
         */
        @Override // java.lang.Thread, java.lang.Runnable
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                Method dump skipped, instructions count: 188
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4391n.c.run():void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: a */
        public void m16174a(d dVar) {
            this.f16733a.m16187a(dVar);
            notify();
        }

        /* renamed from: a */
        public synchronized void m16177a() {
            this.f16736b = true;
            this.f16733a.m16184a();
            notify();
        }

        /* renamed from: a */
        public boolean m16178a() {
            return this.f16734a && SystemClock.uptimeMillis() - this.f16732a > 600000;
        }
    }

    static {
        f16725a = SystemClock.elapsedRealtime() > 0 ? SystemClock.elapsedRealtime() : 0L;
        f16726b = f16725a;
    }

    public C4391n(String str, boolean z) {
        if (str == null) {
            throw new NullPointerException("name == null");
        }
        this.f16729a = new c(str, z);
        this.f16728a = new a(this.f16729a);
    }

    /* renamed from: a */
    static synchronized long m16161a() {
        long j2;
        synchronized (C4391n.class) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (elapsedRealtime > f16726b) {
                f16725a += elapsedRealtime - f16726b;
            }
            f16726b = elapsedRealtime;
            j2 = f16725a;
        }
        return j2;
    }

    /* renamed from: b */
    private static synchronized long m16162b() {
        long j2;
        synchronized (C4391n.class) {
            j2 = f16727c;
            f16727c = 1 + j2;
        }
        return j2;
    }

    /* renamed from: b */
    public void m16171b() {
        synchronized (this.f16729a) {
            this.f16729a.f16733a.m16184a();
        }
    }

    /* renamed from: com.xiaomi.push.service.n$d */
    static class d {

        /* renamed from: a */
        int f16742a;

        /* renamed from: a */
        long f16743a;

        /* renamed from: a */
        b f16744a;

        /* renamed from: a */
        final Object f16745a = new Object();

        /* renamed from: a */
        boolean f16746a;

        /* renamed from: b */
        private long f16747b;

        d() {
        }

        /* renamed from: a */
        void m16192a(long j2) {
            synchronized (this.f16745a) {
                this.f16747b = j2;
            }
        }

        /* renamed from: a */
        public boolean m16193a() {
            boolean z;
            synchronized (this.f16745a) {
                z = !this.f16746a && this.f16743a > 0;
                this.f16746a = true;
            }
            return z;
        }
    }

    public C4391n(String str) {
        this(str, false);
    }

    /* renamed from: b */
    private void m16163b(b bVar, long j2) {
        synchronized (this.f16729a) {
            if (!this.f16729a.f16736b) {
                long m16161a = j2 + m16161a();
                if (m16161a >= 0) {
                    d dVar = new d();
                    dVar.f16742a = bVar.f16731a;
                    dVar.f16744a = bVar;
                    dVar.f16743a = m16161a;
                    this.f16729a.m16174a(dVar);
                } else {
                    throw new IllegalArgumentException("Illegal delay to start the TimerTask: " + m16161a);
                }
            } else {
                throw new IllegalStateException("Timer was canceled");
            }
        }
    }

    public C4391n(boolean z) {
        this("Timer-" + m16162b(), z);
    }

    /* renamed from: a */
    public void m16164a() {
        AbstractC4022b.m13347a("quit. finalizer:" + this.f16728a);
        this.f16729a.m16177a();
    }

    public C4391n() {
        this(false);
    }

    /* renamed from: a */
    public boolean m16170a(int i2) {
        boolean m16189a;
        synchronized (this.f16729a) {
            m16189a = this.f16729a.f16733a.m16189a(i2);
        }
        return m16189a;
    }

    /* renamed from: a */
    public void m16165a(int i2) {
        synchronized (this.f16729a) {
            this.f16729a.f16733a.m16185a(i2);
        }
    }

    /* renamed from: a */
    public void m16166a(int i2, b bVar) {
        synchronized (this.f16729a) {
            this.f16729a.f16733a.m16186a(i2, bVar);
        }
    }

    /* renamed from: a */
    public boolean m16169a() {
        return this.f16729a.m16178a();
    }

    /* renamed from: a */
    public void m16167a(b bVar) {
        if (AbstractC4022b.m13334a() < 1 && Thread.currentThread() != this.f16729a) {
            AbstractC4022b.m13361d("run job outside job job thread");
            throw new RejectedExecutionException("Run job outside job thread");
        }
        bVar.run();
    }

    /* renamed from: a */
    public void m16168a(b bVar, long j2) {
        if (j2 >= 0) {
            m16163b(bVar, j2);
            return;
        }
        throw new IllegalArgumentException("delay < 0: " + j2);
    }
}
