package com.vivo.push.p232b;

import com.vivo.push.C3862d;

/* compiled from: AppCommand.java */
/* renamed from: com.vivo.push.b.b */
/* loaded from: classes2.dex */
public final class C3830b extends C3831c {

    /* renamed from: a */
    private String f13907a;

    /* renamed from: b */
    private String f13908b;

    /* renamed from: c */
    private int f13909c;

    /* renamed from: d */
    private boolean f13910d;

    public C3830b(boolean z, String str) {
        super(z ? 2006 : 2007, str);
        this.f13909c = 1;
        this.f13910d = false;
    }

    /* renamed from: a */
    public final void m12835a(int i2) {
        this.f13909c = i2;
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    public final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12917a("sdk_clients", this.f13907a);
        c3862d.m12915a("sdk_version", 341L);
        c3862d.m12917a("PUSH_REGID", this.f13908b);
        if (m13325b() == 2007) {
            c3862d.m12914a("PUSH_UNBIND_SOURCE_CODE", this.f13909c);
        }
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    public final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13907a = c3862d.m12913a("sdk_clients");
        this.f13908b = c3862d.m12913a("PUSH_REGID");
        if (m13325b() == 2007) {
            this.f13909c = c3862d.m12921b("PUSH_UNBIND_SOURCE_CODE", 1);
        }
    }

    @Override // com.vivo.push.p232b.C3831c, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "AppCommand:" + m13325b();
    }
}
