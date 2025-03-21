package com.vivo.push.p237f;

import android.content.Context;
import com.vivo.push.AbstractRunnableC3971s;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* renamed from: com.vivo.push.f.ac */
/* loaded from: classes2.dex */
final class RunnableC3884ac implements Runnable {

    /* renamed from: a */
    final /* synthetic */ int f14011a;

    /* renamed from: b */
    final /* synthetic */ List f14012b;

    /* renamed from: c */
    final /* synthetic */ List f14013c;

    /* renamed from: d */
    final /* synthetic */ String f14014d;

    /* renamed from: e */
    final /* synthetic */ C3883ab f14015e;

    RunnableC3884ac(C3883ab c3883ab, int i2, List list, List list2, String str) {
        this.f14015e = c3883ab;
        this.f14011a = i2;
        this.f14012b = list;
        this.f14013c = list2;
        this.f14014d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        C3883ab c3883ab = this.f14015e;
        PushMessageCallback pushMessageCallback = ((AbstractC3882aa) c3883ab).f14009b;
        context = ((AbstractRunnableC3971s) c3883ab).f14186a;
        pushMessageCallback.onSetTags(context, this.f14011a, this.f14012b, this.f14013c, this.f14014d);
    }
}
