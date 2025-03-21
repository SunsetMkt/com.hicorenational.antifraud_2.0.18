package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnDelTagsReceiveTask.java */
/* renamed from: com.vivo.push.f.m */
/* loaded from: classes2.dex */
final class RunnableC3903m implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f14031a;

    /* renamed from: b */
    final /* synthetic */ List f14032b;

    /* renamed from: c */
    final /* synthetic */ List f14033c;

    /* renamed from: d */
    final /* synthetic */ String f14034d;

    /* renamed from: e */
    final /* synthetic */ C3902l f14035e;

    RunnableC3903m(C3902l c3902l, int i2, List list, List list2, String str) {
        this.f14035e = c3902l;
        this.f14031a = i2;
        this.f14032b = list;
        this.f14033c = list2;
        this.f14034d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3902l c3902l = this.f14035e;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3902l).f14009b;
        context = ((AbstractRunnableC3971s) c3902l).f14186a;
        pushMessageCallback.onDelTags(context, this.f14031a, this.f14032b, this.f14033c, this.f14034d);
    }
}
