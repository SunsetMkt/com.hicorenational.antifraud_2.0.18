package com.vivo.push;

import com.vivo.push.restructure.request.p243a.p244a.C3960a;
import com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c;
import org.json.JSONException;

/* compiled from: ClientSdkQueryParemeterDS.java */
/* renamed from: com.vivo.push.e */
/* loaded from: classes2.dex */
public final class C3876e implements InterfaceC3962c {

    /* renamed from: a */
    public static InterfaceC3962c.a<C3876e> f13995a = new C3880f();

    /* renamed from: b */
    private int f13996b;

    /* renamed from: c */
    private String f13997c;

    /* renamed from: d */
    private String f13998d;

    /* renamed from: e */
    private String f13999e;

    /* renamed from: f */
    private String f14000f;

    public C3876e(int i2, String str, String str2, String str3, String str4) {
        this.f13996b = i2;
        this.f13997c = str;
        this.f13998d = str2;
        this.f13999e = str3;
        this.f14000f = str4;
    }

    @Override // com.vivo.push.restructure.request.p243a.p244a.InterfaceC3962c
    /* renamed from: a */
    public final String mo12933a() {
        C3960a c3960a = new C3960a();
        c3960a.m13143a(this.f13996b);
        c3960a.m13146a(this.f13997c);
        c3960a.m13146a(this.f13998d);
        c3960a.m13146a(this.f13999e);
        c3960a.m13146a(this.f14000f);
        return c3960a.m13150d();
    }

    protected C3876e(C3960a c3960a) throws JSONException {
        this.f13996b = c3960a.m13142a();
        this.f13997c = c3960a.m13149c();
        this.f13998d = c3960a.m13149c();
        this.f13999e = c3960a.m13149c();
        this.f14000f = c3960a.m13149c();
    }
}
