package com.vivo.push.b;

import com.tencent.connect.common.Constants;

/* JADX INFO: compiled from: OnAppReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class i extends s {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private String f8453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f8454d;

    public i(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("app_id", this.a);
        dVar.a(Constants.PARAM_CLIENT_ID, this.f8452b);
        dVar.a("client_token", this.f8453c);
        dVar.a("client_token_validity_period", this.f8454d);
    }

    public final String d() {
        return this.a;
    }

    public final String e() {
        return this.f8453c;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("app_id");
        this.f8452b = dVar.a(Constants.PARAM_CLIENT_ID);
        this.f8453c = dVar.a("client_token");
        this.f8454d = dVar.a("client_token_validity_period");
    }
}
