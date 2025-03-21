package com.vivo.push.p237f;

import android.content.Context;
import android.text.TextUtils;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.p232b.C3837i;
import com.vivo.push.sdk.PushMessageCallback;

/* compiled from: OnBindAppReceiveTask.java */
/* renamed from: com.vivo.push.f.i */
/* loaded from: classes2.dex */
final class RunnableC3899i implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f14028a;

    /* renamed from: b */
    final /* synthetic */ C3837i f14029b;

    /* renamed from: c */
    final /* synthetic */ C3898h f14030c;

    RunnableC3899i(C3898h c3898h, String str, C3837i c3837i) {
        this.f14030c = c3898h;
        this.f14028a = str;
        this.f14029b = c3837i;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        Context context2;
        if (!TextUtils.isEmpty(this.f14028a)) {
            C3898h c3898h = this.f14030c;
            PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3898h).f14009b;
            context2 = ((AbstractRunnableC3971s) c3898h).f14186a;
            pushMessageCallback.onReceiveRegId(context2, this.f14028a);
        }
        C3898h c3898h2 = this.f14030c;
        PushMessageCallback pushMessageCallback2 = ((AbstractC3882aa) c3898h2).f14009b;
        context = ((AbstractRunnableC3971s) c3898h2).f14186a;
        pushMessageCallback2.onBind(context, this.f14029b.m12877i(), this.f14029b.m12846d());
    }
}
