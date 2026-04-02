package com.taobao.accs.net;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes2.dex */
class y implements Runnable {
    final /* synthetic */ String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f5844b;

    y(v vVar, String str) {
        this.f5844b = vVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str = this.a;
        if (str != null && str.equals(this.f5844b.O) && this.f5844b.t == 2) {
            this.f5844b.K = false;
            this.f5844b.M = true;
            this.f5844b.o();
            this.f5844b.I.setCloseReason("conn timeout");
        }
    }
}
