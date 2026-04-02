package com.vivo.push.b;

/* JADX INFO: compiled from: StopServiceCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class y extends com.vivo.push.v {
    private String a;

    public y(String str) {
        super(2008);
        this.a = str;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("package_name", this.a);
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.a("package_name");
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "StopServiceCommand";
    }

    public y() {
        super(2008);
    }
}
