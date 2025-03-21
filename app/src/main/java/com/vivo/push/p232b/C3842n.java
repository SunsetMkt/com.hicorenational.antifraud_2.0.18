package com.vivo.push.p232b;

import com.vivo.push.C3862d;

/* compiled from: OnLogReceiveCommand.java */
/* renamed from: com.vivo.push.b.n */
/* loaded from: classes2.dex */
public final class C3842n extends C3847s {

    /* renamed from: a */
    private String f13932a;

    /* renamed from: b */
    private int f13933b;

    /* renamed from: c */
    private boolean f13934c;

    public C3842n() {
        super(7);
        this.f13933b = 0;
        this.f13934c = false;
    }

    /* renamed from: a */
    public final void m12853a(int i2) {
        this.f13933b = i2;
    }

    /* renamed from: b */
    public final void m12854b(String str) {
        this.f13932a = str;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12917a("content", this.f13932a);
        c3862d.m12914a("log_level", this.f13933b);
        c3862d.m12919a("is_server_log", this.f13934c);
    }

    /* renamed from: d */
    public final String m12855d() {
        return this.f13932a;
    }

    /* renamed from: e */
    public final int m12856e() {
        return this.f13933b;
    }

    /* renamed from: f */
    public final boolean m12857f() {
        return this.f13934c;
    }

    /* renamed from: g */
    public final void m12858g() {
        this.f13934c = false;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnLogCommand";
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13932a = c3862d.m12913a("content");
        this.f13933b = c3862d.m12921b("log_level", 0);
        this.f13934c = c3862d.m12927e("is_server_log");
    }
}
