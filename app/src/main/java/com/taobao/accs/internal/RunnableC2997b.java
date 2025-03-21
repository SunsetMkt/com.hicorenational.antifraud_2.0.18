package com.taobao.accs.internal;

import com.taobao.accs.InterfaceC2977c;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.internal.b */
/* loaded from: classes2.dex */
class RunnableC2997b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC2977c f9512a;

    /* renamed from: b */
    final /* synthetic */ ACCSManagerImpl f9513b;

    RunnableC2997b(ACCSManagerImpl aCCSManagerImpl, InterfaceC2977c interfaceC2977c) {
        this.f9513b = aCCSManagerImpl;
        this.f9512a = interfaceC2977c;
    }

    @Override // java.lang.Runnable
    public void run() {
        InterfaceC2977c interfaceC2977c = this.f9512a;
        if (interfaceC2977c != null) {
            interfaceC2977c.mo8961a(true, false);
        }
    }
}
