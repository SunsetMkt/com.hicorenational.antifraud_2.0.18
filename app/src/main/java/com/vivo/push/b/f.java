package com.vivo.push.b;

/* JADX INFO: compiled from: DefaultCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class f extends com.vivo.push.v {
    private int a;

    public f() {
        super(0);
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        if (dVar != null) {
            dVar.a("APP_CLIENT_SWITCH_FLAG", this.a);
        }
    }

    public final void d() {
        this.a = 3;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "DefaultCommand";
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        if (dVar != null) {
            this.a = dVar.b("APP_CLIENT_SWITCH_FLAG", 0);
        }
    }
}
