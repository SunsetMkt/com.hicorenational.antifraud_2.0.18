package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: IDMD5Tracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.d */
/* loaded from: classes2.dex */
public class C3504d extends AbstractC3501a {

    /* renamed from: a */
    private static final String f12782a = "idmd5";

    /* renamed from: b */
    private Context f12783b;

    public C3504d(Context context) {
        super("idmd5");
        this.f12783b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    /* renamed from: f */
    public String mo11855f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f12783b);
    }
}
