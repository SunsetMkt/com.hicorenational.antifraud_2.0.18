package com.vivo.push.restructure.b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.ag;

/* JADX INFO: compiled from: PushRelyImpl.java */
/* JADX INFO: loaded from: classes2.dex */
final class e implements Runnable {
    final /* synthetic */ Context a;

    /* JADX INFO: renamed from: b */
    final /* synthetic */ PushConfig f8608b;

    /* JADX INFO: renamed from: c */
    final /* synthetic */ d f8609c;

    e(d dVar, Context context, PushConfig pushConfig) {
        this.f8609c = dVar;
        this.a = context;
        this.f8608b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.a;
        ag.a(context, context.getPackageName(), this.f8608b.isAgreePrivacyStatement());
    }
}
