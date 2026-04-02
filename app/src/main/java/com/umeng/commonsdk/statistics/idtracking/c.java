package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* JADX INFO: compiled from: IDFATracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class c extends a {
    private static final String a = "idfa";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Context f7710b;

    public c(Context context) {
        super(a);
        this.f7710b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.a
    public String f() {
        return DeviceConfig.getIdfa(this.f7710b);
    }
}
