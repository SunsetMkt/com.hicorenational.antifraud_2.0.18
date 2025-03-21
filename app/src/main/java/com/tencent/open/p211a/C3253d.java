package com.tencent.open.p211a;

import java.io.IOException;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.a.d */
/* loaded from: classes2.dex */
class C3253d implements InterfaceC3256g {

    /* renamed from: a */
    private Response f11147a;

    /* renamed from: b */
    private String f11148b = null;

    /* renamed from: c */
    private int f11149c;

    /* renamed from: d */
    private int f11150d;

    /* renamed from: e */
    private int f11151e;

    C3253d(Response response, int i2) {
        this.f11147a = response;
        this.f11150d = i2;
        this.f11149c = response.code();
        ResponseBody body = this.f11147a.body();
        if (body != null) {
            this.f11151e = (int) body.contentLength();
        } else {
            this.f11151e = 0;
        }
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: a */
    public String mo10410a() throws IOException {
        if (this.f11148b == null) {
            ResponseBody body = this.f11147a.body();
            if (body != null) {
                this.f11148b = body.string();
            }
            if (this.f11148b == null) {
                this.f11148b = "";
            }
        }
        return this.f11148b;
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: b */
    public int mo10411b() {
        return this.f11151e;
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: c */
    public int mo10412c() {
        return this.f11150d;
    }

    @Override // com.tencent.open.p211a.InterfaceC3256g
    /* renamed from: d */
    public int mo10413d() {
        return this.f11149c;
    }

    public String toString() {
        return C3253d.class.getSimpleName() + '@' + hashCode() + this.f11148b + this.f11149c + this.f11150d + this.f11151e;
    }
}
