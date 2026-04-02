package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* JADX INFO: compiled from: HandlerPoster.java */
/* JADX INFO: loaded from: classes2.dex */
public class f extends Handler implements l {
    private final k a;

    /* JADX INFO: renamed from: b */
    private final int f12925b;

    /* JADX INFO: renamed from: c */
    private final c f12926c;

    /* JADX INFO: renamed from: d */
    private boolean f12927d;

    protected f(c cVar, Looper looper, int i2) {
        super(looper);
        this.f12926c = cVar;
        this.f12925b = i2;
        this.a = new k();
    }

    @Override // org.greenrobot.eventbus.l
    public void a(q qVar, Object obj) {
        j jVarA = j.a(qVar, obj);
        synchronized (this) {
            this.a.a(jVarA);
            if (!this.f12927d) {
                this.f12927d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long jUptimeMillis = SystemClock.uptimeMillis();
            do {
                j jVarA = this.a.a();
                if (jVarA == null) {
                    synchronized (this) {
                        jVarA = this.a.a();
                        if (jVarA == null) {
                            this.f12927d = false;
                            return;
                        }
                    }
                }
                this.f12926c.a(jVarA);
            } while (SystemClock.uptimeMillis() - jUptimeMillis < this.f12925b);
            if (!sendMessage(obtainMessage())) {
                throw new e("Could not send handler message");
            }
            this.f12927d = true;
        } finally {
            this.f12927d = false;
        }
    }
}
