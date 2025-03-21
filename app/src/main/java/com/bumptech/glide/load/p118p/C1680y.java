package com.bumptech.glide.load.p118p;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* compiled from: ResourceRecycler.java */
/* renamed from: com.bumptech.glide.load.p.y */
/* loaded from: classes.dex */
class C1680y {

    /* renamed from: a */
    private boolean f4653a;

    /* renamed from: b */
    private final Handler f4654b = new Handler(Looper.getMainLooper(), new a());

    /* compiled from: ResourceRecycler.java */
    /* renamed from: com.bumptech.glide.load.p.y$a */
    private static final class a implements Handler.Callback {

        /* renamed from: a */
        static final int f4655a = 1;

        a() {
        }

        @Override // android.os.Handler.Callback
        public boolean handleMessage(Message message) {
            if (message.what != 1) {
                return false;
            }
            ((InterfaceC1677v) message.obj).recycle();
            return true;
        }
    }

    C1680y() {
    }

    /* renamed from: a */
    synchronized void m4210a(InterfaceC1677v<?> interfaceC1677v, boolean z) {
        if (!this.f4653a && !z) {
            this.f4653a = true;
            interfaceC1677v.recycle();
            this.f4653a = false;
        }
        this.f4654b.obtainMessage(1, interfaceC1677v).sendToTarget();
    }
}
