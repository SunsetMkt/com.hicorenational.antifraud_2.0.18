package com.vivo.push.restructure.p239a.p240a;

import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.vivo.push.util.C3996g;
import com.vivo.push.util.C4010u;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: AbstractMessageNodeMonitor.java */
/* renamed from: com.vivo.push.restructure.a.a.a */
/* loaded from: classes2.dex */
abstract class AbstractC3934a<T> {

    /* renamed from: a */
    protected T f14120a;

    /* renamed from: b */
    private String f14121b;

    /* renamed from: e */
    private InterfaceC3942i f14124e;

    /* renamed from: g */
    private AbstractC3934a f14126g;

    /* renamed from: c */
    private long f14122c = -1;

    /* renamed from: d */
    private int f14123d = -1;

    /* renamed from: f */
    private boolean f14125f = false;

    public AbstractC3934a(String str, T t, InterfaceC3942i interfaceC3942i) {
        this.f14121b = str;
        this.f14120a = t;
        this.f14124e = interfaceC3942i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m13091d() {
        long currentTimeMillis = System.currentTimeMillis();
        this.f14123d = mo13092a((AbstractC3934a<T>) this.f14120a);
        this.f14122c = System.currentTimeMillis() - currentTimeMillis;
        int i2 = this.f14123d;
        if (i2 != 0) {
            InterfaceC3942i interfaceC3942i = this.f14124e;
            if (interfaceC3942i != null) {
                interfaceC3942i.mo13103a(this, this.f14120a, i2);
                return;
            }
            return;
        }
        AbstractC3934a abstractC3934a = this.f14126g;
        if (abstractC3934a != null) {
            abstractC3934a.m13093a();
            return;
        }
        InterfaceC3942i interfaceC3942i2 = this.f14124e;
        if (interfaceC3942i2 != null) {
            interfaceC3942i2.mo13104a((InterfaceC3942i) this.f14120a);
        }
    }

    /* renamed from: a */
    protected abstract int mo13092a(T t);

    /* renamed from: a */
    public final void m13095a(AbstractC3934a abstractC3934a) {
        if (this != abstractC3934a) {
            this.f14126g = abstractC3934a;
        }
    }

    /* renamed from: c */
    public final JSONArray m13097c() {
        JSONArray jSONArray = new JSONArray();
        for (AbstractC3934a<T> abstractC3934a = this; abstractC3934a != null; abstractC3934a = abstractC3934a.f14126g) {
            try {
                jSONArray.put(abstractC3934a.mo13096b());
            } catch (Exception e2) {
                C4010u.m13294a("AbstractMessageNodeMoni", e2);
            }
        }
        return jSONArray;
    }

    /* renamed from: a */
    public final void m13094a(long j2) {
        this.f14122c = j2;
    }

    /* renamed from: b */
    public synchronized String mo13096b() {
        JSONObject jSONObject;
        jSONObject = new JSONObject();
        try {
            jSONObject.put(CommonNetImpl.NAME, this.f14121b);
            jSONObject.put("code", this.f14123d);
            jSONObject.put("cost", this.f14122c);
        } catch (Exception e2) {
            C4010u.m13294a("AbstractMessageNodeMoni", e2);
        }
        return jSONObject.toString();
    }

    /* renamed from: a */
    public final void m13093a() {
        if (this.f14125f) {
            C3996g.m13250a().execute(new RunnableC3935b(this));
        } else {
            m13091d();
        }
    }
}
