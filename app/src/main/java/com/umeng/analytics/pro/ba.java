package com.umeng.analytics.pro;

import android.content.Context;

/* JADX INFO: compiled from: MeizuDeviceIdSupplier.java */
/* JADX INFO: loaded from: classes2.dex */
class ba implements au {
    ba() {
    }

    @Override // com.umeng.analytics.pro.au
    public String a(Context context) {
        if (context == null) {
            return null;
        }
        boolean zA = j.e.b.b.a.a.b.a();
        bg.a("getOAID", "isSupported", Boolean.valueOf(zA));
        if (zA) {
            return j.e.b.b.a.a.b.b(context);
        }
        return null;
    }
}
