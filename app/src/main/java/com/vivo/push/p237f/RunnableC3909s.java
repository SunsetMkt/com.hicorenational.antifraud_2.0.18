package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.p232b.C3842n;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnLogReceiveTask.java */
/* renamed from: com.vivo.push.f.s */
/* loaded from: classes2.dex */
final class RunnableC3909s implements Runnable {

    /* renamed from: a */
    final /* synthetic */ C3842n f14043a;

    /* renamed from: b */
    final /* synthetic */ C3908r f14044b;

    RunnableC3909s(C3908r c3908r, C3842n c3842n) {
        this.f14044b = c3908r;
        this.f14043a = c3842n;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3908r c3908r = this.f14044b;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3908r).f14009b;
        context = ((AbstractRunnableC3971s) c3908r).f14186a;
        pushMessageCallback.onLog(context, this.f14043a.m12855d(), this.f14043a.m12856e(), this.f14043a.m12857f());
    }
}
