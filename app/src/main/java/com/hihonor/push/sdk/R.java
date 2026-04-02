package com.hihonor.push.sdk;

import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class r implements k0<List<HonorPushDataMsg>> {
    public final /* synthetic */ HonorPushCallback a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ s f4272b;

    public r(s sVar, HonorPushCallback honorPushCallback) {
        this.f4272b = sVar;
        this.a = honorPushCallback;
    }

    @Override // com.hihonor.push.sdk.k0
    public void a(a1<List<HonorPushDataMsg>> a1Var) {
        if (!a1Var.e()) {
            s.a(this.f4272b, this.a, -1, a1Var.b().toString());
            return;
        }
        s sVar = this.f4272b;
        HonorPushCallback honorPushCallback = this.a;
        List<HonorPushDataMsg> listC = a1Var.c();
        sVar.getClass();
        b1.a(new t(sVar, honorPushCallback, listC));
    }
}
