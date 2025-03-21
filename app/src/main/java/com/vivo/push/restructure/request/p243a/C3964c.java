package com.vivo.push.restructure.request.p243a;

import com.vivo.push.restructure.C3932a;
import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b;
import org.json.JSONException;

/* compiled from: CFToCoreDS.java */
/* renamed from: com.vivo.push.restructure.request.a.c */
/* loaded from: classes2.dex */
public final class C3964c implements InterfaceC3961b {

    /* renamed from: a */
    public static final InterfaceC3961b.a<C3964c> f14170a = new C3965d();

    /* renamed from: b */
    private String f14171b;

    /* renamed from: c */
    private int f14172c;

    /* renamed from: d */
    private long f14173d;

    /* renamed from: e */
    private int f14174e;

    public C3964c(int i2, int i3) {
        this.f14171b = C3932a.m13069a().m13071b().getPackageName();
        this.f14172c = i2;
        this.f14173d = 341L;
        this.f14174e = i3;
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3961b
    /* renamed from: a */
    public final void mo12930a(C3960a c3960a) {
        c3960a.m13146a(this.f14171b);
        c3960a.m13143a(this.f14172c);
        c3960a.m13144a(this.f14173d);
        c3960a.m13143a(this.f14174e);
    }

    protected C3964c(C3960a c3960a) {
        try {
            this.f14171b = c3960a.m13149c();
            this.f14172c = c3960a.m13142a();
            this.f14173d = c3960a.m13148b();
            this.f14174e = c3960a.m13142a();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
