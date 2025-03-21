package com.vivo.push.f;

import android.content.Context;
import com.vivo.push.sdk.PushMessageCallback;
import java.util.List;

/* compiled from: OnSetTagsReceiveTask.java */
/* loaded from: classes2.dex */
final class ad implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ int f12041a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f12042b;

    /* renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f12043c;

    /* renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f12044d;

    /* renamed from: e, reason: collision with root package name */
    final /* synthetic */ ab f12045e;

    ad(ab abVar, int i2, List list, List list2, String str) {
        this.f12045e = abVar;
        this.f12041a = i2;
        this.f12042b = list;
        this.f12043c = list2;
        this.f12044d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Context context;
        ab abVar = this.f12045e;
        PushMessageCallback pushMessageCallback = ((aa) abVar).f12034b;
        context = ((com.vivo.push.s) abVar).f12207a;
        pushMessageCallback.onSetAlias(context, this.f12041a, this.f12042b, this.f12043c, this.f12044d);
    }
}
