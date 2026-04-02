package com.vivo.push.f;

import java.util.List;

/* JADX INFO: compiled from: OnDelTagsReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class m implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f8522b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f8523c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f8524d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f8525e;

    m(l lVar, int i2, List list, List list2, String str) {
        this.f8525e = lVar;
        this.a = i2;
        this.f8522b = list;
        this.f8523c = list2;
        this.f8524d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f8525e;
        ((aa) lVar).f8506b.onDelTags(((com.vivo.push.s) lVar).a, this.a, this.f8522b, this.f8523c, this.f8524d);
    }
}
