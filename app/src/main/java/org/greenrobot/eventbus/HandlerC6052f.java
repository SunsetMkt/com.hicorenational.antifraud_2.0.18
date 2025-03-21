package org.greenrobot.eventbus;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;

/* compiled from: HandlerPoster.java */
/* renamed from: org.greenrobot.eventbus.f */
/* loaded from: classes2.dex */
public class HandlerC6052f extends Handler implements InterfaceC6058l {

    /* renamed from: a */
    private final C6057k f21570a;

    /* renamed from: b */
    private final int f21571b;

    /* renamed from: c */
    private final C6049c f21572c;

    /* renamed from: d */
    private boolean f21573d;

    protected HandlerC6052f(C6049c c6049c, Looper looper, int i2) {
        super(looper);
        this.f21572c = c6049c;
        this.f21571b = i2;
        this.f21570a = new C6057k();
    }

    @Override // org.greenrobot.eventbus.InterfaceC6058l
    /* renamed from: a */
    public void mo24975a(C6063q c6063q, Object obj) {
        C6056j m25028a = C6056j.m25028a(c6063q, obj);
        synchronized (this) {
            this.f21570a.m25032a(m25028a);
            if (!this.f21573d) {
                this.f21573d = true;
                if (!sendMessage(obtainMessage())) {
                    throw new C6051e("Could not send handler message");
                }
            }
        }
    }

    @Override // android.os.Handler
    public void handleMessage(Message message) {
        try {
            long uptimeMillis = SystemClock.uptimeMillis();
            do {
                C6056j m25030a = this.f21570a.m25030a();
                if (m25030a == null) {
                    synchronized (this) {
                        m25030a = this.f21570a.m25030a();
                        if (m25030a == null) {
                            this.f21573d = false;
                            return;
                        }
                    }
                }
                this.f21572c.m24992a(m25030a);
            } while (SystemClock.uptimeMillis() - uptimeMillis < this.f21571b);
            if (!sendMessage(obtainMessage())) {
                throw new C6051e("Could not send handler message");
            }
            this.f21573d = true;
        } finally {
            this.f21573d = false;
        }
    }
}
