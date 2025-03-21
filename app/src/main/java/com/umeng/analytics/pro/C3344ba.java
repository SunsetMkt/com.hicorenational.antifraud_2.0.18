package com.umeng.analytics.pro;

import android.content.Context;
import p324i.p339e.p343b.p347b.p348a.p349a.C5827b;

/* compiled from: MeizuDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.ba */
/* loaded from: classes2.dex */
class C3344ba implements InterfaceC3337au {
    C3344ba() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        if (context == null) {
            return null;
        }
        boolean m24458a = C5827b.m24458a();
        C3350bg.m10898a("getOAID", "isSupported", Boolean.valueOf(m24458a));
        if (m24458a) {
            return C5827b.m24459b(context);
        }
        return null;
    }
}
