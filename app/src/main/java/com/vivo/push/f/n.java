package com.vivo.push.f;

import java.util.List;

/* JADX INFO: compiled from: OnDelTagsReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class n implements Runnable {
    final /* synthetic */ int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f8526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f8527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ String f8528d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    final /* synthetic */ l f8529e;

    n(l lVar, int i2, List list, List list2, String str) {
        this.f8529e = lVar;
        this.a = i2;
        this.f8526b = list;
        this.f8527c = list2;
        this.f8528d = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        l lVar = this.f8529e;
        ((aa) lVar).f8506b.onDelAlias(((com.vivo.push.s) lVar).a, this.a, this.f8526b, this.f8527c, this.f8528d);
    }
}
