package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.p232b.C3837i;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnUnBindAppReceiveTask.java */
/* renamed from: com.vivo.push.f.af */
/* loaded from: classes2.dex */
final class RunnableC3887af implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3837i f14021a;

    /* renamed from: b */
    final /* synthetic */ C3886ae f14022b;

    RunnableC3887af(C3886ae c3886ae, C3837i c3837i) {
        this.f14022b = c3886ae;
        this.f14021a = c3837i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3886ae c3886ae = this.f14022b;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3886ae).f14009b;
        context = ((AbstractRunnableC3971s) c3886ae).f14186a;
        pushMessageCallback.onUnBind(context, this.f14021a.m12877i(), this.f14021a.m12846d());
    }
}
