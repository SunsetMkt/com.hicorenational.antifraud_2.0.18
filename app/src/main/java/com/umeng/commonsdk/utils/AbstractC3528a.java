package com.umeng.commonsdk.utils;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: CountDownTimer.java */
/* renamed from: com.umeng.commonsdk.utils.a */
/* loaded from: classes2.dex */
public abstract class AbstractC3528a {

    /* renamed from: e */
    private static final int f12930e = 1;

    /* renamed from: a */
    private final long f12931a;

    /* renamed from: b */
    private final long f12932b;

    /* renamed from: c */
    private long f12933c;

    /* renamed from: f */
    private HandlerThread f12935f;

    /* renamed from: g */
    private Handler f12936g;

    /* renamed from: d */
    private boolean f12934d = false;

    /* renamed from: h */
    private Handler.Callback f12937h = new Handler.Callback() { // from class: com.umeng.commonsdk.utils.a.1
        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            synchronized (AbstractC3528a.this) {
                if (AbstractC3528a.this.f12934d) {
                    return true;
                }
                long elapsedRealtime = AbstractC3528a.this.f12933c - SystemClock.elapsedRealtime();
                if (elapsedRealtime <= 0) {
                    AbstractC3528a.this.m12092c();
                    if (AbstractC3528a.this.f12935f != null) {
                        AbstractC3528a.this.f12935f.quit();
                    }
                } else if (elapsedRealtime < AbstractC3528a.this.f12932b) {
                    AbstractC3528a.this.f12936g.sendMessageDelayed(AbstractC3528a.this.f12936g.obtainMessage(1), elapsedRealtime);
                } else {
                    long elapsedRealtime2 = SystemClock.elapsedRealtime();
                    AbstractC3528a.this.m12090a(elapsedRealtime);
                    long elapsedRealtime3 = (elapsedRealtime2 + AbstractC3528a.this.f12932b) - SystemClock.elapsedRealtime();
                    while (elapsedRealtime3 < 0) {
                        elapsedRealtime3 += AbstractC3528a.this.f12932b;
                    }
                    AbstractC3528a.this.f12936g.sendMessageDelayed(AbstractC3528a.this.f12936g.obtainMessage(1), elapsedRealtime3);
                }
                return false;
            }
        }
    };

    public AbstractC3528a(long j2, long j3) {
        this.f12931a = j2;
        this.f12932b = j3;
        if (m12087d()) {
            this.f12936g = new Handler(this.f12937h);
            return;
        }
        this.f12935f = new HandlerThread("CountDownTimerThread");
        this.f12935f.start();
        this.f12936g = new Handler(this.f12935f.getLooper(), this.f12937h);
    }

    /* renamed from: a */
    public abstract void m12090a(long j2);

    /* renamed from: c */
    public abstract void m12092c();

    /* renamed from: d */
    private boolean m12087d() {
        return Looper.getMainLooper().getThread().equals(Thread.currentThread());
    }

    /* renamed from: a */
    public final synchronized void m12089a() {
        this.f12934d = true;
        this.f12936g.removeMessages(1);
    }

    /* renamed from: b */
    public final synchronized AbstractC3528a m12091b() {
        this.f12934d = false;
        if (this.f12931a <= 0) {
            m12092c();
            return this;
        }
        this.f12933c = SystemClock.elapsedRealtime() + this.f12931a;
        this.f12936g.sendMessage(this.f12936g.obtainMessage(1));
        return this;
    }
}
