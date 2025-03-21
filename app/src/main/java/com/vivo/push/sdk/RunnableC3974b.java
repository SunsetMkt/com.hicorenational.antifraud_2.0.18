package com.vivo.push.sdk;

import android.content.Context;
import com.vivo.push.AbstractC3827ab;
import com.vivo.push.C3924m;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.p239a.InterfaceC3933a;
import com.vivo.push.util.C4010u;

/* compiled from: CommandWorker.java */
/* renamed from: com.vivo.push.sdk.b */
/* loaded from: classes2.dex */
final class RunnableC3974b implements Runnable {

    /* renamed from: a */
    final /* synthetic */ InterfaceC3933a f14196a;

    /* renamed from: b */
    final /* synthetic */ C3973a f14197b;

    RunnableC3974b(C3973a c3973a, InterfaceC3933a interfaceC3933a) {
        this.f14197b = c3973a;
        this.f14196a = interfaceC3933a;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C4010u.m13309d("CommandWorker", " handleMessage type: ".concat(String.valueOf(this.f14196a.mo13087j())));
        C3924m m13016a = C3924m.m13016a();
        context = ((AbstractC3827ab) this.f14197b).f13900a;
        m13016a.m13030a(context);
        C3932a.m13069a().m13073d().m13100a(this.f14196a);
    }
}
