package com.taobao.accs.net;

/* compiled from: Taobao */
/* renamed from: com.taobao.accs.net.y */
/* loaded from: classes2.dex */
class RunnableC3025y implements Runnable {

    /* renamed from: a */
    final /* synthetic */ String f9628a;

    /* renamed from: b */
    final /* synthetic */ C3022v f9629b;

    RunnableC3025y(C3022v c3022v, String str) {
        this.f9629b = c3022v;
        this.f9628a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2 = this.f9628a;
        if (str2 != null) {
            str = this.f9629b.f9607O;
            if (str2.equals(str) && this.f9629b.f9613t == 2) {
                this.f9629b.f9603K = false;
                this.f9629b.f9605M = true;
                this.f9629b.m9160o();
                this.f9629b.f9601I.setCloseReason("conn timeout");
            }
        }
    }
}
