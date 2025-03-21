package com.vivo.push.restructure.p241b;

import android.content.Context;
import com.vivo.push.PushConfig;
import com.vivo.push.util.C3990ag;

/* compiled from: PushRelyImpl.java */
/* renamed from: com.vivo.push.restructure.b.e */
/* loaded from: classes2.dex */
final class RunnableC3954e implements Runnable {

    /* renamed from: a */
    final /* synthetic */ Context f14154a;

    /* renamed from: b */
    final /* synthetic */ PushConfig f14155b;

    /* renamed from: c */
    final /* synthetic */ C3953d f14156c;

    RunnableC3954e(C3953d c3953d, Context context, PushConfig pushConfig) {
        this.f14156c = c3953d;
        this.f14154a = context;
        this.f14155b = pushConfig;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context = this.f14154a;
        C3990ag.m13216a(context, context.getPackageName(), this.f14155b.isAgreePrivacyStatement());
    }
}
