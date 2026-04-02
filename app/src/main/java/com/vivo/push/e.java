package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* JADX INFO: compiled from: ClientSdkQueryParemeterDS.java */
/* JADX INFO: loaded from: classes2.dex */
public final class e implements com.vivo.push.restructure.request.a.a.c {
    public static c.a<e> a = new f();

    /* JADX INFO: renamed from: b */
    private int f8495b;

    /* JADX INFO: renamed from: c */
    private String f8496c;

    /* JADX INFO: renamed from: d */
    private String f8497d;

    /* JADX INFO: renamed from: e */
    private String f8498e;

    /* JADX INFO: renamed from: f */
    private String f8499f;

    public e(int i2, String str, String str2, String str3, String str4) {
        this.f8495b = i2;
        this.f8496c = str;
        this.f8497d = str2;
        this.f8498e = str3;
        this.f8499f = str4;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f8495b);
        aVar.a(this.f8496c);
        aVar.a(this.f8497d);
        aVar.a(this.f8498e);
        aVar.a(this.f8499f);
        return aVar.d();
    }

    protected e(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f8495b = aVar.a();
        this.f8496c = aVar.c();
        this.f8497d = aVar.c();
        this.f8498e = aVar.c();
        this.f8499f = aVar.c();
    }
}
