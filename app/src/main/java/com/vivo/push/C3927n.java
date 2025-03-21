package com.vivo.push;

import com.vivo.push.C3924m;
import com.vivo.push.restructure.C3932a;
import com.vivo.push.util.C4010u;

/* compiled from: PushClientManager.java */
/* renamed from: com.vivo.push.n */
/* loaded from: classes2.dex */
final class C3927n implements IPushActionListener {

    /* renamed from: a */
    final /* synthetic */ C3924m.a f14099a;

    /* renamed from: b */
    final /* synthetic */ String f14100b;

    /* renamed from: c */
    final /* synthetic */ String f14101c;

    /* renamed from: d */
    final /* synthetic */ C3924m f14102d;

    C3927n(C3924m c3924m, C3924m.a aVar, String str, String str2) {
        this.f14102d = c3924m;
        this.f14099a = aVar;
        this.f14100b = str;
        this.f14101c = str2;
    }

    @Override // com.vivo.push.IPushActionListener
    public final void onStateChanged(int i2) {
        if (i2 != 0) {
            C3932a.m13069a().m13077h().mo13009a("");
            return;
        }
        Object[] m13057b = this.f14099a.m13057b();
        if (m13057b == null || m13057b.length == 0) {
            C4010u.m13292a("PushClientManager", "bind app result is null");
        } else {
            C3932a.m13069a().m13077h().mo13010a((String) this.f14099a.m13057b()[0], this.f14100b, this.f14101c);
        }
    }
}
