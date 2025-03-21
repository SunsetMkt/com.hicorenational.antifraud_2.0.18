package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.p232b.C3841m;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnListTagReceiveTask.java */
/* renamed from: com.vivo.push.f.q */
/* loaded from: classes2.dex */
final class RunnableC3907q implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3841m f14041a;

    /* renamed from: b */
    final /* synthetic */ C3906p f14042b;

    RunnableC3907q(C3906p c3906p, C3841m c3841m) {
        this.f14042b = c3906p;
        this.f14041a = c3841m;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3906p c3906p = this.f14042b;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3906p).f14009b;
        context = ((AbstractRunnableC3971s) c3906p).f14186a;
        pushMessageCallback.onListTags(context, this.f14041a.m12877i(), this.f14041a.m12852d(), this.f14041a.m12876h());
    }
}
