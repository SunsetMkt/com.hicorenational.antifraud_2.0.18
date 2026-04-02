package com.vivo.push.b;

/* JADX INFO: compiled from: AppCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends c {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8441b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8442c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f8443d;

    public b(boolean z, String str) {
        super(z ? 2006 : 2007, str);
        this.f8442c = 1;
        this.f8443d = false;
    }

    public final void a(int i2) {
        this.f8442c = i2;
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("sdk_clients", this.a);
        dVar.a("sdk_version", 341L);
        dVar.a("PUSH_REGID", this.f8441b);
        if (b() == 2007) {
            dVar.a("PUSH_UNBIND_SOURCE_CODE", this.f8442c);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.a("sdk_clients");
        this.f8441b = dVar.a("PUSH_REGID");
        if (b() == 2007) {
            this.f8442c = dVar.b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.b.c, com.vivo.push.v
    public final String toString() {
        return "AppCommand:" + b();
    }
}
