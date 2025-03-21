package com.vivo.push;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryResultDS.java */
/* renamed from: com.vivo.push.g */
/* loaded from: classes2.dex */
public final class C3917g implements InterfaceC3962c {

    /* renamed from: a */
    public static InterfaceC3962c.a<C3917g> f14051a = new C3919h();

    /* renamed from: b */
    private int f14052b;

    /* renamed from: c */
    private String f14053c;

    protected C3917g(C3960a c3960a) throws JSONException {
        this.f14052b = c3960a.m13142a();
        this.f14053c = c3960a.m13149c();
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c
    /* renamed from: a */
    public final String mo12933a() {
        C3960a c3960a = new C3960a();
        c3960a.m13143a(this.f14052b);
        c3960a.m13146a(this.f14053c);
        return c3960a.m13150d();
    }

    /* renamed from: b */
    public final String m12990b() {
        return this.f14053c;
    }
}
