package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import p324i.p339e.p343b.p344a.p345a.p346a.C5825a;

/* compiled from: OppoDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.bc */
/* loaded from: classes2.dex */
public class C3346bc implements InterfaceC3337au {

    /* renamed from: a */
    private boolean f11544a = false;

    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        try {
            if (!this.f11544a) {
                C5825a.m24445a(context);
                this.f11544a = true;
            }
            if (C5825a.m24446a()) {
                return C5825a.m24448c(context);
            }
            UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            return null;
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
            return null;
        }
    }
}
