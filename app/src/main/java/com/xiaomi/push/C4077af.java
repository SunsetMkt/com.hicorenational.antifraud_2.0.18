package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import p286h.p309q2.p311t.C5556m0;

/* renamed from: com.xiaomi.push.af */
/* loaded from: classes2.dex */
public class C4077af {

    /* renamed from: a */
    private int f14488a;

    /* renamed from: a */
    private Handler f14489a;

    /* renamed from: a */
    private a f14490a;

    /* renamed from: a */
    private volatile b f14491a;

    /* renamed from: a */
    private volatile boolean f14492a;

    /* renamed from: b */
    private final boolean f14493b;

    /* renamed from: com.xiaomi.push.af$b */
    public static abstract class b {
        /* renamed from: a */
        public void m13723a() {
        }

        /* renamed from: b */
        public abstract void mo13724b();

        /* renamed from: c */
        public void mo13725c() {
        }
    }

    public C4077af() {
        this(false);
    }

    /* renamed from: com.xiaomi.push.af$a */
    private class a extends Thread {

        /* renamed from: a */
        private final LinkedBlockingQueue<b> f14498a;

        public a() {
            super("PackageProcessor");
            this.f14498a = new LinkedBlockingQueue<>();
        }

        /* renamed from: a */
        public void m13722a(b bVar) {
            try {
                this.f14498a.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j2 = C4077af.this.f14488a > 0 ? C4077af.this.f14488a : C5556m0.f20396b;
            while (!C4077af.this.f14492a) {
                try {
                    b poll = this.f14498a.poll(j2, TimeUnit.SECONDS);
                    C4077af.this.f14491a = poll;
                    if (poll != null) {
                        m13721a(0, poll);
                        poll.mo13724b();
                        m13721a(1, poll);
                    } else if (C4077af.this.f14488a > 0) {
                        C4077af.this.m13716a();
                    }
                } catch (InterruptedException e2) {
                    AbstractC4022b.m13351a(e2);
                }
            }
        }

        /* renamed from: a */
        private void m13721a(int i2, b bVar) {
            try {
                C4077af.this.f14489a.sendMessage(C4077af.this.f14489a.obtainMessage(i2, bVar));
            } catch (Exception e2) {
                AbstractC4022b.m13351a(e2);
            }
        }
    }

    public C4077af(boolean z) {
        this(z, 0);
    }

    public C4077af(boolean z, int i2) {
        this.f14489a = null;
        this.f14492a = false;
        this.f14488a = 0;
        this.f14489a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.push.af.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                int i3 = message.what;
                if (i3 == 0) {
                    bVar.m13723a();
                } else if (i3 == 1) {
                    bVar.mo13725c();
                }
                super.handleMessage(message);
            }
        };
        this.f14493b = z;
        this.f14488a = i2;
    }

    /* renamed from: a */
    public synchronized void m13719a(b bVar) {
        if (this.f14490a == null) {
            this.f14490a = new a();
            this.f14490a.setDaemon(this.f14493b);
            this.f14492a = false;
            this.f14490a.start();
        }
        this.f14490a.m13722a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m13716a() {
        this.f14490a = null;
        this.f14492a = true;
    }

    /* renamed from: a */
    public void m13720a(final b bVar, long j2) {
        this.f14489a.postDelayed(new Runnable() { // from class: com.xiaomi.push.af.2
            @Override // java.lang.Runnable
            public void run() {
                C4077af.this.m13719a(bVar);
            }
        }, j2);
    }
}
