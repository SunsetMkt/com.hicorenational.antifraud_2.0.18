package com.vivo.push.b;

import java.util.ArrayList;

/* JADX INFO: compiled from: OnListTagReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class m extends s {
    private ArrayList<String> a;

    public m() {
        super(8);
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("tags_list", this.a);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnListTagCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("tags_list");
    }
}
