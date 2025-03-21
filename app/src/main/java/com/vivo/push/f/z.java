package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnPublishReceiveTask.java */
/* loaded from: classes2.dex */
final class z implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.r f12074a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ y f12075b;

    z(y yVar, com.vivo.push.b.r rVar) {
        this.f12075b = yVar;
        this.f12074a = rVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        y yVar = this.f12075b;
        PushMessageCallback pushMessageCallback = ((aa) yVar).f12034b;
        context = ((com.vivo.push.s) yVar).f12207a;
        pushMessageCallback.onPublish(context, this.f12074a.i(), this.f12074a.h());
    }
}
