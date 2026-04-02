package com.vivo.push;

import com.vivo.push.m;

/* JADX INFO: compiled from: PushClientManager.java */
/* JADX INFO: loaded from: classes2.dex */
final class n implements IPushActionListener {
    final /* synthetic */ m.a a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f8570b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f8571c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ m f8572d;

    n(m mVar, m.a aVar, String str, String str2) {
        this.f8572d = mVar;
        this.a = aVar;
        this.f8570b = str;
        this.f8571c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        if (i2 != 0) {
            com.vivo.push.restructure.a.a().h().a("");
            return;
        }
        Object[] objArrB = this.a.b();
        if (objArrB == null || objArrB.length == 0) {
            com.vivo.push.util.u.a("PushClientManager", "bind app result is null");
        } else {
            com.vivo.push.restructure.a.a().h().a((String) this.a.b()[0], this.f8570b, this.f8571c);
        }
    }
}
