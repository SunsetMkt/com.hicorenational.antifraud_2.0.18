package com.vivo.push.f;

import java.util.List;

/* JADX INFO: compiled from: OnSetTagsReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class ac implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f8508b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f8509c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f8510d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ab f8511e;

    ac(ab abVar, int i2, List list, List list2, String str) {
        this.f8511e = abVar;
        this.a = i2;
        this.f8508b = list;
        this.f8509c = list2;
        this.f8510d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ab abVar = this.f8511e;
        ((aa) abVar).f8506b.onSetTags(((com.vivo.push.s) abVar).a, this.a, this.f8508b, this.f8509c, this.f8510d);
    }
}
