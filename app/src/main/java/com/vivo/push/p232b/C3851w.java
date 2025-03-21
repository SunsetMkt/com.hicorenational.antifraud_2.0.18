package com.vivo.push.p232b;

import com.vivo.push.AbstractC4016v;
import com.vivo.push.C3862d;

/* compiled from: PushModeCommand.java */
/* renamed from: com.vivo.push.b.w */
/* loaded from: classes2.dex */
public final class C3851w extends AbstractC4016v {

    /* renamed from: a */
    private int f13956a;

    public C3851w() {
        super(2011);
        this.f13956a = 0;
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        c3862d.m12914a("com.bbk.push.ikey.MODE_TYPE", this.f13956a);
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: c */
    public final boolean mo12884c() {
        return true;
    }

    /* renamed from: d */
    public final int m12885d() {
        return this.f13956a;
    }

    @Override // com.vivo.push.AbstractC4016v
    public final String toString() {
        return "PushModeCommand";
    }

    @Override // com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        this.f13956a = c3862d.m12921b("com.bbk.push.ikey.MODE_TYPE", 0);
    }
}
