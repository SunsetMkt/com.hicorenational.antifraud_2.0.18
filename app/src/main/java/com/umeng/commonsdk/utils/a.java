package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: CountDownTimer.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class a {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f7832e = 1;
    private final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final long f7833b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f7834c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private HandlerThread f7836f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f7837g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7835d = false;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Handler.Callback f7838h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (a.this) {
                if (a.this.f7835d) {
                    return true;
                }
                long jElapsedRealtime = a.this.f7834c - SystemClock.elapsedRealtime();
                if (jElapsedRealtime <= 0) {
                    a.this.c();
                    if (a.this.f7836f != null) {
                        a.this.f7836f.quit();
                    }
                } else if (jElapsedRealtime < a.this.f7833b) {
                    a.this.f7837g.sendMessageDelayed(a.this.f7837g.obtainMessage(1), jElapsedRealtime);
                } else {
                    long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                    a.this.a(jElapsedRealtime);
                    long jElapsedRealtime3 = (jElapsedRealtime2 + a.this.f7833b) - SystemClock.elapsedRealtime();
                    while (jElapsedRealtime3 < 0) {
                        jElapsedRealtime3 += a.this.f7833b;
                    }
                    a.this.f7837g.sendMessageDelayed(a.this.f7837g.obtainMessage(1), jElapsedRealtime3);
                }
                return false;
            }
        }
    };

    public a(long j2, long j3) {
        this.a = j2;
        this.f7833b = j3;
        if (d()) {
            this.f7837g = new Handler(this.f7838h);
            return;
        }
        this.f7836f = new HandlerThread("CountDownTimerThread");
        this.f7836f.start();
        this.f7837g = new Handler(this.f7836f.getLooper(), this.f7838h);
    }

    public abstract void a(long j2);

    public abstract void c();

    private boolean d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    public final synchronized void a() {
        this.f7835d = true;
        this.f7837g.removeMessages(1);
    }

    public final synchronized a b() {
        this.f7835d = false;
        if (this.a <= 0) {
            c();
            return this;
        }
        this.f7834c = SystemClock.elapsedRealtime() + this.a;
        this.f7837g.sendMessage(this.f7837g.obtainMessage(1));
        return this;
    }
}
