package com.vivo.push.p232b;

import com.vivo.push.C3862d;

/* compiled from: OnChangePushStatusReceiveCommand.java */
/* renamed from: com.vivo.push.b.j */
/* loaded from: classes2.dex */
public final class C3838j extends C3847s {

    /* renamed from: a */
    private int f13927a;

    /* renamed from: b */
    private int f13928b;

    public C3838j() {
        super(12);
        this.f13927a = -1;
        this.f13928b = -1;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12914a("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f13927a);
        c3862d.m12914a("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f13928b);
    }

    /* renamed from: d */
    public final int m12848d() {
        return this.f13927a;
    }

    /* renamed from: e */
    public final int m12849e() {
        return this.f13928b;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnChangePushStatusCommand";
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13927a = c3862d.m12921b("OnChangePushStatus.EXTRA_REQ_SERVICE_STATUS", this.f13927a);
        this.f13928b = c3862d.m12921b("OnChangePushStatus.EXTRA_REQ_RECEIVER_STATUS", this.f13928b);
    }
}
