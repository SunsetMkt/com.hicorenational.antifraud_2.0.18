package com.vivo.push;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* JADX INFO: compiled from: ClientSdkQueryResultDS.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g implements com.vivo.push.restructure.request.a.a.c {
    public static c.a<g> a = new h();

    /* JADX INFO: renamed from: b */
    private int f8535b;

    /* JADX INFO: renamed from: c */
    private String f8536c;

    protected g(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f8535b = aVar.a();
        this.f8536c = aVar.c();
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f8535b);
        aVar.a(this.f8536c);
        return aVar.d();
    }

    public final String b() {
        return this.f8536c;
    }
}
