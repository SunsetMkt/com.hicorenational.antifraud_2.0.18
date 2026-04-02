package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import org.json.JSONException;

/* JADX INFO: compiled from: CFToCoreDS.java */
/* JADX INFO: loaded from: classes2.dex */
public final class c implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<c> a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8619b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8620c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private long f8621d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8622e;

    public c(int i2, int i3) {
        this.f8619b = com.vivo.push.restructure.a.a().b().getPackageName();
        this.f8620c = i2;
        this.f8621d = 341L;
        this.f8622e = i3;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f8619b);
        aVar.a(this.f8620c);
        aVar.a(this.f8621d);
        aVar.a(this.f8622e);
    }

    protected c(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f8619b = aVar.c();
            this.f8620c = aVar.a();
            this.f8621d = aVar.b();
            this.f8622e = aVar.a();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
    }
}
