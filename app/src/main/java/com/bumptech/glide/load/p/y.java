package com.bumptech.glide.load.p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: compiled from: ResourceRecycler.java */
/* JADX INFO: loaded from: classes.dex */
class y {
    private boolean a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Handler f3046b = new Handler(Looper.getMainLooper(), new a());

    /* JADX INFO: compiled from: ResourceRecycler.java */
    private static final class a implements Handler.Callback {
        static final int a = 1;

        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((v) message.obj).recycle();
            return true;
        }
    }

    y() {
    }

    synchronized void a(v<?> vVar, boolean z) {
        if (this.a || z) {
            this.f3046b.obtainMessage(1, vVar).sendToTarget();
        } else {
            this.a = true;
            vVar.recycle();
            this.a = false;
        }
    }
}
