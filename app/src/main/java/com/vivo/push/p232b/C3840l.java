package com.vivo.push.p232b;

import com.vivo.push.C3862d;

/* compiled from: OnDispatcherReceiveCommand.java */
/* renamed from: com.vivo.push.b.l */
/* loaded from: classes2.dex */
public final class C3840l extends C3847s {

    /* renamed from: a */
    private int f13929a;

    /* renamed from: b */
    private int f13930b;

    public C3840l() {
        super(2016);
        this.f13929a = -1;
        this.f13930b = -1;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12914a("key_dispatch_environment", this.f13929a);
        c3862d.m12914a("key_dispatch_area", this.f13930b);
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13929a = c3862d.m12921b("key_dispatch_environment", 1);
        this.f13930b = c3862d.m12921b("key_dispatch_area", 1);
    }

    /* renamed from: e */
    public final int m12851e() {
        return this.f13930b;
    }

    /* renamed from: d */
    public final int m12850d() {
        return this.f13929a;
    }
}
