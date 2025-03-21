package com.umeng.commonsdk.statistics.idtracking;

import android.annotation.TargetApi;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: SerialTracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.i */
/* loaded from: classes2.dex */
public class C3509i extends AbstractC3501a {

    /* renamed from: a */
    private static final String f12805a = "serial";

    public C3509i() {
        super(f12805a);
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    @TargetApi(9)
    /* renamed from: f */
    public String mo11855f() {
        return DeviceConfig.getSerial();
    }
}
