package com.vivo.push.p232b;

import com.vivo.push.C3862d;

/* compiled from: OnVerifyReceiveCommand.java */
/* renamed from: com.vivo.push.b.v */
/* loaded from: classes2.dex */
public abstract class AbstractC3850v extends C3847s {

    /* renamed from: a */
    private String f13954a;

    /* renamed from: b */
    private long f13955b;

    public AbstractC3850v(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12917a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT", this.f13954a);
        c3862d.m12915a("notify_id", this.f13955b);
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13954a = c3862d.m12913a("OnVerifyCallBackCommand.EXTRA_SECURITY_CONTENT");
        this.f13955b = c3862d.m12922b("notify_id", -1L);
    }

    /* renamed from: f */
    public final long m12882f() {
        return this.f13955b;
    }

    /* renamed from: g */
    public final String m12883g() {
        return this.f13954a;
    }
}
