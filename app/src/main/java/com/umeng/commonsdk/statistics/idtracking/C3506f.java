package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: ImeiTracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.f */
/* loaded from: classes2.dex */
public class C3506f extends AbstractC3501a {

    /* renamed from: a */
    private static final String f12796a = "imei";

    /* renamed from: b */
    private Context f12797b;

    public C3506f(Context context) {
        super("imei");
        this.f12797b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    /* renamed from: f */
    public String mo11855f() {
        return DeviceConfig.getImeiNew(this.f12797b);
    }
}
