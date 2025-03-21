package com.vivo.push.p234d;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c;
import org.json.JSONException;

/* compiled from: ProfileInfoDS.java */
/* renamed from: com.vivo.push.d.b */
/* loaded from: classes2.dex */
public final class C3867b implements InterfaceC3962c {

    /* renamed from: a */
    public static InterfaceC3962c.a<C3867b> f13979a = new C3868c();

    /* renamed from: b */
    private String f13980b;

    public C3867b(String str) {
        this.f13980b = str;
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c
    /* renamed from: a */
    public final String mo12933a() {
        C3960a c3960a = new C3960a();
        c3960a.m13146a(this.f13980b);
        return c3960a.m13150d();
    }

    /* renamed from: b */
    public final String m12934b() {
        return this.f13980b;
    }

    protected C3867b(C3960a c3960a) throws JSONException {
        this.f13980b = c3960a.m13149c();
    }
}
