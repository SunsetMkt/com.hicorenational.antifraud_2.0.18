package com.vivo.push.b;

/* JADX INFO: compiled from: PushModeCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class w extends com.vivo.push.v {
    private int a;

    public w() {
        super(2011);
        this.a = 0;
    }

    @Override // com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        dVar.a("com.bbk.push.ikey.MODE_TYPE", this.a);
    }

    @Override // com.vivo.push.v
    public final boolean c() {
        return true;
    }

    public final int d() {
        return this.a;
    }

    @Override // com.vivo.push.v
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        this.a = dVar.b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
