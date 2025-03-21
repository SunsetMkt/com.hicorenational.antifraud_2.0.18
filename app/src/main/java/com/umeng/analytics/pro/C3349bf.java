package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import p324i.p339e.p343b.p350c.p351a.C5833b;

/* compiled from: XiaomiDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.bf */
/* loaded from: classes2.dex */
class C3349bf implements InterfaceC3337au {
    C3349bf() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        String str = null;
        try {
            if (C5833b.m24480a()) {
                str = C5833b.m24481b(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return str;
    }
}
