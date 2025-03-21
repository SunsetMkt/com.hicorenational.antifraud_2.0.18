package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* renamed from: com.vivo.push.f.n */
/* loaded from: classes2.dex */
final class RunnableC3904n implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f14036a;

    /* renamed from: b */
    final /* synthetic */ List f14037b;

    /* renamed from: c */
    final /* synthetic */ List f14038c;

    /* renamed from: d */
    final /* synthetic */ String f14039d;

    /* renamed from: e */
    final /* synthetic */ C3902l f14040e;

    RunnableC3904n(C3902l c3902l, int i2, List list, List list2, String str) {
        this.f14040e = c3902l;
        this.f14036a = i2;
        this.f14037b = list;
        this.f14038c = list2;
        this.f14039d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3902l c3902l = this.f14040e;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3902l).f14009b;
        context = ((AbstractRunnableC3971s) c3902l).f14186a;
        pushMessageCallback.onDelAlias(context, this.f14036a, this.f14037b, this.f14038c, this.f14039d);
    }
}
