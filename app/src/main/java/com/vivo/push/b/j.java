package com.vivo.push.b;

/* JADX INFO: compiled from: OnChangePushStatusReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j extends s {
    private int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8455b;

    public j() {
        super(12);
        this.a = -1;
        this.f8455b = -1;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        dVar.a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f8455b);
    }

    public final int d() {
        return this.a;
    }

    public final int e() {
        return this.f8455b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.a);
        this.f8455b = dVar.b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f8455b);
    }
}
