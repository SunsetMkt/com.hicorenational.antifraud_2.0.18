package com.vivo.push.b;

/* JADX INFO: compiled from: OnReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public class s extends com.vivo.push.v {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8469b;

    public s(int i2) {
        super(i2);
        this.a = null;
        this.f8469b = 0;
    }

    @Override // com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        dVar.a("req_id", this.a);
        dVar.a("status_msg_code", this.f8469b);
    }

    @Override // com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        this.a = dVar.a("req_id");
        this.f8469b = dVar.b("status_msg_code", this.f8469b);
    }

    public final String h() {
        return this.a;
    }

    public final int i() {
        return this.f8469b;
    }

    @Override // com.vivo.push.v
    public String toString() {
        return "OnReceiveCommand";
    }
}
