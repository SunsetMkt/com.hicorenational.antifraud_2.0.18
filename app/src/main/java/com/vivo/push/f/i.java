package com.vivo.push.f;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnBindAppReceiveTask.java */
/* loaded from: classes2.dex */
final class i implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f12053a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f12054b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f12055c;

    i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.f12055c = hVar;
        this.f12053a = str;
        this.f12054b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f12053a)) {
            h hVar = this.f12055c;
            PushMessageCallback pushMessageCallback = ((aa) hVar).f12034b;
            context2 = ((com.vivo.push.s) hVar).f12207a;
            pushMessageCallback.onReceiveRegId(context2, this.f12053a);
        }
        h hVar2 = this.f12055c;
        PushMessageCallback pushMessageCallback2 = ((aa) hVar2).f12034b;
        context = ((com.vivo.push.s) hVar2).f12207a;
        pushMessageCallback2.onBind(context, this.f12054b.i(), this.f12054b.d());
    }
}
