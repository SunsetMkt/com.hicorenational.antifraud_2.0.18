package com.vivo.push.f;

import java.util.List;

/* JADX INFO: compiled from: OnSetTagsReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class ad implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f8512b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f8513c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f8514d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ ab f8515e;

    ad(ab abVar, int i2, List list, List list2, String str) {
        this.f8515e = abVar;
        this.a = i2;
        this.f8512b = list;
        this.f8513c = list2;
        this.f8514d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ab abVar = this.f8515e;
        ((aa) abVar).f8506b.onSetAlias(((com.vivo.push.s) abVar).a, this.a, this.f8512b, this.f8513c, this.f8514d);
    }
}
