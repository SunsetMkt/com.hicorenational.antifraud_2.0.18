package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.p232b.C3846r;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnPublishReceiveTask.java */
/* renamed from: com.vivo.push.f.z */
/* loaded from: classes2.dex */
final class RunnableC3916z implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3846r f14049a;

    /* renamed from: b */
    final /* synthetic */ C3915y f14050b;

    RunnableC3916z(C3915y c3915y, C3846r c3846r) {
        this.f14050b = c3915y;
        this.f14049a = c3846r;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3915y c3915y = this.f14050b;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3915y).f14009b;
        context = ((AbstractRunnableC3971s) c3915y).f14186a;
        pushMessageCallback.onPublish(context, this.f14049a.m12877i(), this.f14049a.m12876h());
    }
}
