package com.vivo.push.d;

import com.vivo.push.restructure.request.a.a.c;
import org.json.JSONException;

/* JADX INFO: compiled from: ProfileInfoDS.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b implements com.vivo.push.restructure.request.a.a.c {
    public static c.a<b> a = new c();

    /* JADX INFO: renamed from: b */
    private String f8486b;

    public b(String str) {
        this.f8486b = str;
    }

    @Override // com.vivo.push.restructure.request.a.a.c
    public final String a() {
        com.vivo.push.restructure.request.a.a.a aVar = new com.vivo.push.restructure.request.a.a.a();
        aVar.a(this.f8486b);
        return aVar.d();
    }

    public final String b() {
        return this.f8486b;
    }

    protected b(com.vivo.push.restructure.request.a.a.a aVar) throws JSONException {
        this.f8486b = aVar.c();
    }
}
