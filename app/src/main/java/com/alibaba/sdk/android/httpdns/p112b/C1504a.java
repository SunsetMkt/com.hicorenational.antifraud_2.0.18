package com.alibaba.sdk.android.httpdns.p112b;

import android.content.Context;
import java.util.List;

/* renamed from: com.alibaba.sdk.android.httpdns.b.a */
/* loaded from: classes.dex */
class C1504a implements InterfaceC1509f {

    /* renamed from: a */
    private final C1507d f3849a;

    C1504a(Context context) {
        this.f3849a = new C1507d(context);
    }

    @Override // com.alibaba.sdk.android.httpdns.p112b.InterfaceC1509f
    /* renamed from: a */
    public List<C1508e> mo3430a() {
        return this.f3849a.m3460b();
    }

    @Override // com.alibaba.sdk.android.httpdns.p112b.InterfaceC1509f
    /* renamed from: a */
    public void mo3431a(C1508e c1508e) {
        this.f3849a.m3458a(c1508e);
    }

    @Override // com.alibaba.sdk.android.httpdns.p112b.InterfaceC1509f
    /* renamed from: b */
    public void mo3432b(C1508e c1508e) {
        this.f3849a.m3461b(c1508e.f3861m, c1508e.host);
    }
}
