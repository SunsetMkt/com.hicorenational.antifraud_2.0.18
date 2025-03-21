package com.vivo.push.restructure.request.p243a;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b;
import com.vivo.push.util.C4010u;
import org.json.JSONException;

/* compiled from: CFToClientDS.java */
/* renamed from: com.vivo.push.restructure.request.a.a */
/* loaded from: classes2.dex */
public final class C3959a implements InterfaceC3961b {

    /* renamed from: a */
    public static final InterfaceC3961b.a<C3959a> f14160a = new C3963b();

    /* renamed from: b */
    private String f14161b;

    /* renamed from: c */
    private int f14162c;

    /* renamed from: d */
    private int f14163d;

    /* renamed from: e */
    private long f14164e;

    /* renamed from: f */
    private int f14165f;

    /* renamed from: g */
    private int f14166g;

    protected C3959a(C3960a c3960a) {
        try {
            this.f14161b = c3960a.m13149c();
            this.f14162c = c3960a.m13142a();
            this.f14164e = c3960a.m13148b();
            this.f14165f = c3960a.m13142a();
            this.f14163d = c3960a.m13142a();
            this.f14166g = c3960a.m13142a();
        } catch (JSONException e2) {
            C4010u.m13294a("CFToClientDS", e2);
        }
    }

    /* renamed from: a */
    public final int m13139a() {
        return this.f14162c;
    }

    /* renamed from: b */
    public final int m13140b() {
        return this.f14165f;
    }

    /* renamed from: c */
    public final int m13141c() {
        return this.f14166g;
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b
    /* renamed from: a */
    public final void mo12930a(C3960a c3960a) {
        c3960a.m13146a(this.f14161b);
        c3960a.m13143a(this.f14162c);
        c3960a.m13144a(this.f14164e);
        c3960a.m13143a(this.f14165f);
        c3960a.m13143a(this.f14163d);
        c3960a.m13143a(this.f14166g);
    }
}
