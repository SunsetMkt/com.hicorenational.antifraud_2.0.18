package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: IDFATracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.c */
/* loaded from: classes2.dex */
public class C3503c extends AbstractC3501a {

    /* renamed from: a */
    private static final String f12780a = "idfa";

    /* renamed from: b */
    private Context f12781b;

    public C3503c(Context context) {
        super(f12780a);
        this.f12781b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    /* renamed from: f */
    public String mo11855f() {
        return DeviceConfig.getIdfa(this.f12781b);
    }
}
