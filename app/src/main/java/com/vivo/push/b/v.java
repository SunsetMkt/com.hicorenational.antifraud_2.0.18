package com.vivo.push.b;

/* JADX INFO: compiled from: OnVerifyReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public abstract class v extends s {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f8472b;

    public v(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.a);
        dVar.a("notify_id", this.f8472b);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f8472b = dVar.b("notify_id", -1L);
    }

    public final long f() {
        return this.f8472b;
    }

    public final String g() {
        return this.a;
    }
}
