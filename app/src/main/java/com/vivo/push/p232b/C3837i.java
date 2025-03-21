package com.vivo.push.p232b;

import com.tencent.connect.common.Constants;
import com.vivo.push.C3862d;

/* compiled from: OnAppReceiveCommand.java */
/* renamed from: com.vivo.push.b.i */
/* loaded from: classes2.dex */
public final class C3837i extends C3847s {

    /* renamed from: a */
    private String f13923a;

    /* renamed from: b */
    private String f13924b;

    /* renamed from: c */
    private String f13925c;

    /* renamed from: d */
    private String f13926d;

    public C3837i(int i2) {
        super(i2);
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: c */
    protected final void mo12833c(C3862d c3862d) {
        super.mo12833c(c3862d);
        c3862d.m12917a("app_id", this.f13923a);
        c3862d.m12917a(Constants.PARAM_CLIENT_ID, this.f13924b);
        c3862d.m12917a("client_token", this.f13925c);
        c3862d.m12917a("client_token_validity_period", this.f13926d);
    }

    /* renamed from: d */
    public final String m12846d() {
        return this.f13923a;
    }

    /* renamed from: e */
    public final String m12847e() {
        return this.f13925c;
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    public final String toString() {
        return "OnBindCommand";
    }

    @Override // com.vivo.push.p232b.C3847s, com.vivo.push.AbstractC4016v
    /* renamed from: d */
    protected final void mo12834d(C3862d c3862d) {
        super.mo12834d(c3862d);
        this.f13923a = c3862d.m12913a("app_id");
        this.f13924b = c3862d.m12913a(Constants.PARAM_CLIENT_ID);
        this.f13925c = c3862d.m12913a("client_token");
        this.f13926d = c3862d.m12913a("client_token_validity_period");
    }
}
