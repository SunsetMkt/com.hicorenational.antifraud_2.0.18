package com.vivo.push.f;

import android.text.TextUtils;

/* JADX INFO: compiled from: OnBindAppReceiveTask.java */
/* JADX INFO: loaded from: classes2.dex */
final class i implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ com.vivo.push.b.i f8520b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ h f8521c;

    i(h hVar, String str, com.vivo.push.b.i iVar) {
        this.f8521c = hVar;
        this.a = str;
        this.f8520b = iVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (!TextUtils.isEmpty(this.a)) {
            h hVar = this.f8521c;
            ((aa) hVar).f8506b.onReceiveRegId(((com.vivo.push.s) hVar).a, this.a);
        }
        h hVar2 = this.f8521c;
        ((aa) hVar2).f8506b.onBind(((com.vivo.push.s) hVar2).a, this.f8520b.i(), this.f8520b.d());
    }
}
