package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: loaded from: classes2.dex */
public abstract class ah {
    final long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f7964b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final long f7966d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f7967e;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f7965c = false;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Handler f7968f = new Handler(Looper.getMainLooper()) { // from class: com.umeng.message.proguard.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            synchronized (ah.this) {
                if (message.what == 1) {
                    if (ah.this.f7965c) {
                        return;
                    }
                    long jElapsedRealtime = ah.this.f7964b - SystemClock.elapsedRealtime();
                    if (jElapsedRealtime <= 0) {
                        ah.this.e();
                    } else if (jElapsedRealtime < ah.this.a) {
                        ah.this.a(jElapsedRealtime);
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime);
                    } else {
                        long jElapsedRealtime2 = SystemClock.elapsedRealtime();
                        ah.this.a(jElapsedRealtime);
                        long jElapsedRealtime3 = (jElapsedRealtime2 + ah.this.a) - SystemClock.elapsedRealtime();
                        while (jElapsedRealtime3 < 0) {
                            jElapsedRealtime3 += ah.this.a;
                        }
                        sendMessageDelayed(obtainMessage(1), jElapsedRealtime3);
                    }
                }
            }
        }
    };

    public ah(long j2, long j3) {
        this.f7966d = j2;
        this.a = j3;
    }

    public final synchronized void a() {
        this.f7965c = true;
        this.f7968f.removeMessages(1);
    }

    public abstract void a(long j2);

    public final synchronized ah b() {
        this.f7965c = false;
        if (this.f7966d <= 0) {
            e();
            return this;
        }
        this.f7964b = SystemClock.elapsedRealtime() + this.f7966d;
        this.f7968f.sendMessage(this.f7968f.obtainMessage(1));
        return this;
    }

    public final synchronized ah c() {
        this.f7965c = false;
        this.f7967e = this.f7964b - SystemClock.elapsedRealtime();
        if (this.f7967e <= 0) {
            return this;
        }
        this.f7968f.removeMessages(1);
        this.f7968f.sendMessageAtFrontOfQueue(this.f7968f.obtainMessage(2));
        return this;
    }

    public final synchronized ah d() {
        this.f7965c = false;
        if (this.f7967e <= 0) {
            return this;
        }
        this.f7968f.removeMessages(2);
        this.f7964b = this.f7967e + SystemClock.elapsedRealtime();
        this.f7968f.sendMessageAtFrontOfQueue(this.f7968f.obtainMessage(1));
        return this;
    }

    public abstract void e();
}
