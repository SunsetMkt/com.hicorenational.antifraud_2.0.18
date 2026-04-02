package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: IDMD5Tracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class d extends a {
    private static final String a = "idmd5";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7711b;

    public d(Context context) {
        super("idmd5");
        this.f7711b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getDeviceIdUmengMD5(this.f7711b);
    }
}
