package com.vivo.push.restructure.p239a.p240a;

import com.vivo.push.PushClient;
import com.vivo.push.restructure.C3932a;

/* compiled from: DispatchNode.java */
/* renamed from: com.vivo.push.restructure.a.a.f */
/* loaded from: classes2.dex */
final class RunnableC3939f implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f14131a;

    /* renamed from: b */
    final /* synthetic */ String f14132b;

    /* renamed from: c */
    final /* synthetic */ C3938e f14133c;

    RunnableC3939f(C3938e c3938e, int i2, String str) {
        this.f14133c = c3938e;
        this.f14131a = i2;
        this.f14132b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i2 = this.f14131a;
        if (i2 == 3) {
            PushClient.getInstance(C3932a.m13069a().m13071b()).unBindAlias(this.f14132b, null);
        } else if (i2 == 4) {
            PushClient.getInstance(C3932a.m13069a().m13071b()).delTopic(this.f14132b, null);
        }
    }
}
