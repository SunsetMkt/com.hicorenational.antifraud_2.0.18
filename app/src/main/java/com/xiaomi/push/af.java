package com.xiaomi.push;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import i.q2.t.m0;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public class af {
    private int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private Handler f156a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private a f157a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile b f158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private volatile boolean f159a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f8734b;

    public static abstract class b {
        public void a() {
        }

        public abstract void b();

        /* JADX INFO: renamed from: c */
        public void mo263c() {
        }
    }

    public af() {
        this(false);
    }

    private class a extends Thread {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private final LinkedBlockingQueue<b> f161a;

        public a() {
            super("PackageProcessor");
            this.f161a = new LinkedBlockingQueue<>();
        }

        public void a(b bVar) {
            try {
                this.f161a.add(bVar);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            long j2 = af.this.a > 0 ? af.this.a : m0.f12222b;
            while (!af.this.f159a) {
                try {
                    b bVarPoll = this.f161a.poll(j2, TimeUnit.SECONDS);
                    af.this.f158a = bVarPoll;
                    if (bVarPoll != null) {
                        a(0, bVarPoll);
                        bVarPoll.b();
                        a(1, bVarPoll);
                    } else if (af.this.a > 0) {
                        af.this.a();
                    }
                } catch (InterruptedException e2) {
                    com.xiaomi.channel.commonutils.logger.b.a(e2);
                }
            }
        }

        private void a(int i2, b bVar) {
            try {
                af.this.f156a.sendMessage(af.this.f156a.obtainMessage(i2, bVar));
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
            }
        }
    }

    public af(boolean z) {
        this(z, 0);
    }

    public af(boolean z, int i2) {
        this.f156a = null;
        this.f159a = false;
        this.a = 0;
        this.f156a = new Handler(Looper.getMainLooper()) { // from class: com.xiaomi.push.af.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                b bVar = (b) message.obj;
                int i3 = message.what;
                if (i3 == 0) {
                    bVar.a();
                } else if (i3 == 1) {
                    bVar.mo263c();
                }
                super.handleMessage(message);
            }
        };
        this.f8734b = z;
        this.a = i2;
    }

    public synchronized void a(b bVar) {
        if (this.f157a == null) {
            this.f157a = new a();
            this.f157a.setDaemon(this.f8734b);
            this.f159a = false;
            this.f157a.start();
        }
        this.f157a.a(bVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void a() {
        this.f157a = null;
        this.f159a = true;
    }

    public void a(final b bVar, long j2) {
        this.f156a.postDelayed(new Runnable() { // from class: com.xiaomi.push.af.2
            @Override // java.lang.Runnable
            public void run() {
                af.this.a(bVar);
            }
        }, j2);
    }
}
