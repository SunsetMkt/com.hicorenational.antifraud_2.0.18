package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: AndroidIdTracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.b */
/* loaded from: classes2.dex */
public class C3502b extends AbstractC3501a {

    /* renamed from: a */
    private static final String f12778a = "android_id";

    /* renamed from: b */
    private Context f12779b;

    public C3502b(Context context) {
        super("android_id");
        this.f12779b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    /* renamed from: f */
    public String mo11855f() {
        return DeviceConfig.getAndroidId(this.f12779b);
    }
}
