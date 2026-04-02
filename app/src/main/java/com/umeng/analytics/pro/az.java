package com.umeng.analytics.pro;

import android.content.Context;
import j.e.b.e.b.b;

/* JADX INFO: compiled from: LenovoDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
public class az implements au {
    private static final int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private j.e.b.e.b.b f7041b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f7042c = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f7043d = false;

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        if (!this.f7042c) {
            this.f7041b = new j.e.b.e.b.b();
            this.f7043d = this.f7041b.a(context, (b.InterfaceC0263b<String>) null) == 1;
            this.f7042c = true;
        }
        bg.a("getOAID", "isSupported", Boolean.valueOf(this.f7043d));
        if (this.f7043d && this.f7041b.c()) {
            return this.f7041b.a();
        }
        return null;
    }
}
