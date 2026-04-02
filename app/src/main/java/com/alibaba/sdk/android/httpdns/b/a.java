package com.alibaba.sdk.android.httpdns.b;

import android.content.Context;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
class a implements f {
    private final d a;

    a(Context context) {
        this.a = new d(context);
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public List<e> a() {
        return this.a.b();
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public void a(e eVar) {
        this.a.m10a(eVar);
    }

    @Override // com.alibaba.sdk.android.httpdns.b.f
    public void b(e eVar) {
        this.a.b(eVar.f2548m, eVar.host);
    }
}
