package com.vivo.push.restructure.request.a;

import com.vivo.push.restructure.request.a.a.b;
import com.vivo.push.util.u;
import org.json.JSONException;

/* JADX INFO: compiled from: CFToClientDS.java */
/* JADX INFO: loaded from: classes2.dex */
public final class a implements com.vivo.push.restructure.request.a.a.b {
    public static final b.a<a> a = new b();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8611b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f8612c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8613d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private long f8614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private int f8616g;

    protected a(com.vivo.push.restructure.request.a.a.a aVar) {
        try {
            this.f8611b = aVar.c();
            this.f8612c = aVar.a();
            this.f8614e = aVar.b();
            this.f8615f = aVar.a();
            this.f8613d = aVar.a();
            this.f8616g = aVar.a();
        } catch (JSONException e2) {
            u.a("CFToClientDS", e2);
        }
    }

    public final int a() {
        return this.f8612c;
    }

    public final int b() {
        return this.f8615f;
    }

    public final int c() {
        return this.f8616g;
    }

    @Override // com.vivo.push.restructure.request.a.a.b
    public final void a(com.vivo.push.restructure.request.a.a.a aVar) {
        aVar.a(this.f8611b);
        aVar.a(this.f8612c);
        aVar.a(this.f8614e);
        aVar.a(this.f8615f);
        aVar.a(this.f8613d);
        aVar.a(this.f8616g);
    }
}
