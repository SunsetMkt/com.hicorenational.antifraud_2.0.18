package com.vivo.push.restructure.a.a;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.util.u;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: AbstractMessageNodeMonitor.java */
/* JADX INFO: loaded from: classes2.dex */
abstract class a<T> {
    protected T a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f8584b;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private i f8587e;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private a f8589g;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private long f8585c = -1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f8586d = -1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f8588f = false;

    public a(String str, T t, i iVar) {
        this.f8584b = str;
        this.a = t;
        this.f8587e = iVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f8586d = a(this.a);
        this.f8585c = System.currentTimeMillis() - jCurrentTimeMillis;
        int i2 = this.f8586d;
        if (i2 != 0) {
            i iVar = this.f8587e;
            if (iVar != null) {
                iVar.a(this, this.a, i2);
                return;
            }
            return;
        }
        a aVar = this.f8589g;
        if (aVar != null) {
            aVar.a();
            return;
        }
        i iVar2 = this.f8587e;
        if (iVar2 != null) {
            iVar2.a(this.a);
        }
    }

    protected abstract int a(T t);

    public final void a(a aVar) {
        if (this != aVar) {
            this.f8589g = aVar;
        }
    }

    public final JSONArray c() {
        JSONArray jSONArray = new JSONArray();
        for (a<T> aVar = this; aVar != null; aVar = aVar.f8589g) {
            try {
                jSONArray.put(aVar.b());
            } catch (Exception e2) {
                u.a("AbstractMessageNodeMoni", e2);
            }
        }
        return jSONArray;
    }

    public final void a(long j2) {
        this.f8585c = j2;
    }

    public synchronized String b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.NAME, this.f8584b);
            jSONObject.put("code", this.f8586d);
            jSONObject.put("cost", this.f8585c);
        } catch (Exception e2) {
            u.a("AbstractMessageNodeMoni", e2);
        }
        return jSONObject.toString();
    }

    public final void a() {
        if (this.f8588f) {
            com.vivo.push.util.g.a().execute(new b(this));
        } else {
            d();
        }
    }
}
