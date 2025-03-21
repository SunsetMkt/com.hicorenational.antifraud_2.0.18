package org.greenrobot.eventbus;

import android.os.Looper;

/* compiled from: MainThreadSupport.java */
/* renamed from: org.greenrobot.eventbus.h */
/* loaded from: classes2.dex */
public interface InterfaceC6054h {

    /* compiled from: MainThreadSupport.java */
    /* renamed from: org.greenrobot.eventbus.h$a */
    public static class a implements InterfaceC6054h {

        /* renamed from: a */
        private final Looper f21577a;

        public a(Looper looper) {
            this.f21577a = looper;
        }

        @Override // org.greenrobot.eventbus.InterfaceC6054h
        /* renamed from: a */
        public boolean mo25027a() {
            return this.f21577a == Looper.myLooper();
        }

        @Override // org.greenrobot.eventbus.InterfaceC6054h
        /* renamed from: a */
        public InterfaceC6058l mo25026a(C6049c c6049c) {
            return new HandlerC6052f(c6049c, this.f21577a, 10);
        }
    }

    /* renamed from: a */
    InterfaceC6058l mo25026a(C6049c c6049c);

    /* renamed from: a */
    boolean mo25027a();
}
