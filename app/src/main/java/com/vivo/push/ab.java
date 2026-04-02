package com.vivo.push;

import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: Worker.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class ab {
    protected Context a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected Handler f8438b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final Object f8439c = new Object();

    /* JADX INFO: compiled from: Worker.java */
    class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public final void handleMessage(Message message) {
            ab.this.b(message);
        }
    }

    public ab() {
        HandlerThread handlerThread = new HandlerThread(getClass().getSimpleName(), 1);
        handlerThread.start();
        this.f8438b = new a(handlerThread.getLooper());
    }

    public final void a(Context context) {
        this.a = context;
    }

    public abstract void b(Message message);

    public final void a(Message message) {
        synchronized (this.f8439c) {
            if (this.f8438b == null) {
                String str = "Dead worker dropping a message: " + message.what;
                com.vivo.push.util.u.e(getClass().getSimpleName(), str + " (Thread " + Thread.currentThread().getId() + ")");
            } else {
                this.f8438b.sendMessage(message);
            }
        }
    }
}
