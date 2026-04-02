package com.vivo.push.b;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: OnTagsReceiveCommand.java */
/* JADX INFO: loaded from: classes2.dex */
public final class t extends s {
    private ArrayList<String> a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ArrayList<String> f8470b;

    public t(int i2) {
        super(i2);
        this.a = null;
        this.f8470b = null;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void c(com.vivo.push.d dVar) {
        super.c(dVar);
        dVar.a("content", this.a);
        dVar.a("error_msg", this.f8470b);
    }

    public final ArrayList<String> d() {
        return this.a;
    }

    public final List<String> e() {
        return this.f8470b;
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    public final String toString() {
        return "OnSetTagsCommand";
    }

    @Override // com.vivo.push.b.s, com.vivo.push.v
    protected final void d(com.vivo.push.d dVar) {
        super.d(dVar);
        this.a = dVar.c("content");
        this.f8470b = dVar.c("error_msg");
    }
}
