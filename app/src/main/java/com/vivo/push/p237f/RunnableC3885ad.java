package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* renamed from: com.vivo.push.f.ad */
/* loaded from: classes2.dex */
final class RunnableC3885ad implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f14016a;

    /* renamed from: b */
    final /* synthetic */ List f14017b;

    /* renamed from: c */
    final /* synthetic */ List f14018c;

    /* renamed from: d */
    final /* synthetic */ String f14019d;

    /* renamed from: e */
    final /* synthetic */ C3883ab f14020e;

    RunnableC3885ad(C3883ab c3883ab, int i2, List list, List list2, String str) {
        this.f14020e = c3883ab;
        this.f14016a = i2;
        this.f14017b = list;
        this.f14018c = list2;
        this.f14019d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3883ab c3883ab = this.f14020e;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3883ab).f14009b;
        context = ((AbstractRunnableC3971s) c3883ab).f14186a;
        pushMessageCallback.onSetAlias(context, this.f14016a, this.f14017b, this.f14018c, this.f14019d);
    }
}
