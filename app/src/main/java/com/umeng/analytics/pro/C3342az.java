package com.umeng.analytics.pro;

import android.content.Context;
import p324i.p339e.p343b.p354e.p356b.C5841b;

/* compiled from: LenovoDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.az */
/* loaded from: classes2.dex */
public class C3342az implements InterfaceC3337au {

    /* renamed from: a */
    private static final int f11533a = 1;

    /* renamed from: b */
    private C5841b f11534b;

    /* renamed from: c */
    private boolean f11535c = false;

    /* renamed from: d */
    private boolean f11536d = false;

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f11535c) {
            this.f11534b = new C5841b();
            this.f11536d = this.f11534b.m24576a(context, (C5841b.b<String>) null) == 1;
            this.f11535c = true;
        }
        C3350bg.m10898a("getOAID", "isSupported", Boolean.valueOf(this.f11536d));
        if (this.f11536d && this.f11534b.m24580c()) {
            return this.f11534b.m24577a();
        }
        return null;
    }
}
