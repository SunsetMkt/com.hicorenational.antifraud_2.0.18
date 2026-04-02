package com.vivo.push.b;

/* JADX INFO: compiled from: OnUndoMsgReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class u extends v {
    private long a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f8471b;

    public u() {
        super(20);
        this.a = -1L;
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("undo_msg_v1", this.a);
        dVar.a("undo_msg_type_v1", this.f8471b);
    }

    public final long d() {
        return this.a;
    }

    public final String e() {
        long j2 = this.a;
        if (j2 != -1) {
            return String.valueOf(j2);
        }
        return null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnUndoMsgCommand";
    }

    @Override // com.vivo.push.b.v, com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.b("undo_msg_v1", this.a);
        this.f8471b = dVar.b("undo_msg_type_v1", 0);
    }
}
