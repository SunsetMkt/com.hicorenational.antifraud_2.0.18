package com.taobao.accs.net;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
class y implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f8567a;

    /* renamed from: b, reason: collision with root package name */
    final /* synthetic */ v f8568b;

    y(v vVar, String str) {
        this.f8568b = vVar;
        this.f8567a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        String str;
        String str2 = this.f8567a;
        if (str2 != null) {
            str = this.f8568b.O;
            if (str2.equals(str) && this.f8568b.t == 2) {
                this.f8568b.K = false;
                this.f8568b.M = true;
                this.f8568b.o();
                this.f8568b.I.setCloseReason("conn timeout");
            }
        }
    }
}
