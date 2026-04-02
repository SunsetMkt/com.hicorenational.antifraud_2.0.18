package org.greenrobot.eventbus;

import android.os.Looper;

/* JADX INFO: compiled from: MainThreadSupport.java */
/* JADX INFO: loaded from: classes2.dex */
public interface h {

    /* JADX INFO: compiled from: MainThreadSupport.java */
    public static class a implements h {
        private final Looper a;

        public a(Looper looper) {
            this.a = looper;
        }

        @Override // org.greenrobot.eventbus.h
        public boolean a() {
            return this.a == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.h
        public l a(c cVar) {
            return new f(cVar, this.a, 10);
        }
    }

    l a(c cVar);

    boolean a();
}
