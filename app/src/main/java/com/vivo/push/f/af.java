package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnUnBindAppReceiveTask.java */
/* loaded from: classes2.dex */
final class af implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f12046a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ ae f12047b;

    af(ae aeVar, com.vivo.push.b.i iVar) {
        this.f12047b = aeVar;
        this.f12046a = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ae aeVar = this.f12047b;
        PushMessageCallback pushMessageCallback = ((aa) aeVar).f12034b;
        context = ((com.vivo.push.s) aeVar).f12207a;
        pushMessageCallback.onUnBind(context, this.f12046a.i(), this.f12046a.d());
    }
}
