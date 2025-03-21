package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnLogReceiveTask.java */
/* loaded from: classes2.dex */
final class s implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.n f12068a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ r f12069b;

    s(r rVar, com.vivo.push.b.n nVar) {
        this.f12069b = rVar;
        this.f12068a = nVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        r rVar = this.f12069b;
        PushMessageCallback pushMessageCallback = ((aa) rVar).f12034b;
        context = ((com.vivo.push.s) rVar).f12207a;
        pushMessageCallback.onLog(context, this.f12068a.d(), this.f12068a.e(), this.f12068a.f());
    }
}
