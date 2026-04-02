package com.vivo.push.b;

/* JADX INFO: compiled from: OnLogReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class n extends s {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8457b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f8458c;

    public n() {
        super(7);
        this.f8457b = 0;
        this.f8458c = false;
    }

    public final void a(int i2) {
        this.f8457b = i2;
    }

    public final void b(String str) {
        this.a = str;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.a);
        dVar.a("log_level", this.f8457b);
        dVar.a("is_server_log", this.f8458c);
    }

    public final String d() {
        return this.a;
    }

    public final int e() {
        return this.f8457b;
    }

    public final boolean f() {
        return this.f8458c;
    }

    public final void g() {
        this.f8458c = false;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnLogCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("content");
        this.f8457b = dVar.b("log_level", 0);
        this.f8458c = dVar.e("is_server_log");
    }
}
