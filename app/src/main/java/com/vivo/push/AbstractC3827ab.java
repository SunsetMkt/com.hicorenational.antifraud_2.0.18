package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.vivo.push.util.C4010u;

/* compiled from: Worker.java */
/* renamed from: com.vivo.push.ab */
/* loaded from: classes2.dex */
public abstract class AbstractC3827ab {

    /* renamed from: a */
    protected Context f13900a;

    /* renamed from: b */
    protected Handler f13901b;

    /* renamed from: c */
    private final Object f13902c = new Object();

    /* compiled from: Worker.java */
    /* renamed from: com.vivo.push.ab$a */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            AbstractC3827ab.this.mo12832b(message);
        }
    }

    public AbstractC3827ab() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f13901b = new a(handlerThread.getLooper());
    }

    /* renamed from: a */
    public final void m12830a(Context context) {
        this.f13900a = context;
    }

    /* renamed from: b */
    public abstract void mo12832b(Message message);

    /* renamed from: a */
    public final void m12831a(Message message) {
        synchronized (this.f13902c) {
            if (this.f13901b == null) {
                String str = "Dead worker dropping a message: " + message.what;
                C4010u.m13310e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                this.f13901b.sendMessage(message);
            }
        }
    }
}
