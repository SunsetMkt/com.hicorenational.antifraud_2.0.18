package com.umeng.message.proguard;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* renamed from: com.umeng.message.proguard.ah */
/* loaded from: classes2.dex */
public abstract class AbstractC3559ah {

    /* renamed from: a */
    final long f13174a;

    /* renamed from: b */
    long f13175b;

    /* renamed from: d */
    private final long f13177d;

    /* renamed from: e */
    private long f13178e;

    /* renamed from: c */
    boolean f13176c = false;

    /* renamed from: f */
    private final Handler f13179f = new Handler(Looper.getMainLooper()) { // from class: com.umeng.message.proguard.ah.1
        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            synchronized (AbstractC3559ah.this) {
                if (message.what == 1) {
                    if (AbstractC3559ah.this.f13176c) {
                        return;
                    }
                    long elapsedRealtime = AbstractC3559ah.this.f13175b - SystemClock.elapsedRealtime();
                    if (elapsedRealtime <= 0) {
                        AbstractC3559ah.this.mo12215e();
                    } else if (elapsedRealtime < AbstractC3559ah.this.f13174a) {
                        AbstractC3559ah.this.mo12214a(elapsedRealtime);
                        sendMessageDelayed(obtainMessage(1), elapsedRealtime);
                    } else {
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        AbstractC3559ah.this.mo12214a(elapsedRealtime);
                        long elapsedRealtime3 = (elapsedRealtime2 + AbstractC3559ah.this.f13174a) - SystemClock.elapsedRealtime();
                        while (elapsedRealtime3 < 0) {
                            elapsedRealtime3 += AbstractC3559ah.this.f13174a;
                        }
                        sendMessageDelayed(obtainMessage(1), elapsedRealtime3);
                    }
                }
            }
        }
    };

    public AbstractC3559ah(long j2, long j3) {
        this.f13177d = j2;
        this.f13174a = j3;
    }

    /* renamed from: a */
    public final synchronized void m12238a() {
        this.f13176c = true;
        this.f13179f.removeMessages(1);
    }

    /* renamed from: a */
    public abstract void mo12214a(long j2);

    /* renamed from: b */
    public final synchronized AbstractC3559ah m12239b() {
        this.f13176c = false;
        if (this.f13177d <= 0) {
            mo12215e();
            return this;
        }
        this.f13175b = SystemClock.elapsedRealtime() + this.f13177d;
        this.f13179f.sendMessage(this.f13179f.obtainMessage(1));
        return this;
    }

    /* renamed from: c */
    public final synchronized AbstractC3559ah m12240c() {
        this.f13176c = false;
        this.f13178e = this.f13175b - SystemClock.elapsedRealtime();
        if (this.f13178e <= 0) {
            return this;
        }
        this.f13179f.removeMessages(1);
        this.f13179f.sendMessageAtFrontOfQueue(this.f13179f.obtainMessage(2));
        return this;
    }

    /* renamed from: d */
    public final synchronized AbstractC3559ah m12241d() {
        this.f13176c = false;
        if (this.f13178e <= 0) {
            return this;
        }
        this.f13179f.removeMessages(2);
        this.f13175b = this.f13178e + SystemClock.elapsedRealtime();
        this.f13179f.sendMessageAtFrontOfQueue(this.f13179f.obtainMessage(1));
        return this;
    }

    /* renamed from: e */
    public abstract void mo12215e();
}
