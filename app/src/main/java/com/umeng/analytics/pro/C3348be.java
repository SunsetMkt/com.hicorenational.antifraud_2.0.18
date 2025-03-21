package com.umeng.analytics.pro;

import android.content.Context;
import com.umeng.commonsdk.debug.UMLog;
import p324i.p339e.p343b.p352d.p353a.C5838e;

/* compiled from: VivoDeviceIdSupplier.java */
/* renamed from: com.umeng.analytics.pro.be */
/* loaded from: classes2.dex */
public class C3348be implements InterfaceC3337au {
    @Override // com.umeng.analytics.pro.InterfaceC3337au
    /* renamed from: a */
    public String mo10870a(Context context) {
        String str = null;
        try {
            if (C5838e.m24550a(context)) {
                str = C5838e.m24552b(context);
            } else {
                UMLog.mutlInfo(2, "当前设备不支持获取OAID");
            }
        } catch (Exception unused) {
            UMLog.mutlInfo(2, "未检测到您集成OAID SDK包");
        }
        return str;
    }
}
