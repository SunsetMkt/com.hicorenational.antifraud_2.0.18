package com.umeng.commonsdk.statistics.idtracking;

import android.content.Context;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.AnalyticsConstants;
import com.umeng.commonsdk.statistics.common.DeviceConfig;

/* compiled from: MacTracker.java */
/* renamed from: com.umeng.commonsdk.statistics.idtracking.g */
/* loaded from: classes2.dex */
public class C3507g extends AbstractC3501a {

    /* renamed from: a */
    private static final String f12798a = "mac";

    /* renamed from: b */
    private Context f12799b;

    public C3507g(Context context) {
        super("mac");
        this.f12799b = context;
    }

    @Override // com.umeng.commonsdk.statistics.idtracking.AbstractC3501a
    /* renamed from: f */
    public String mo11855f() {
        try {
            return DeviceConfig.getMac(this.f12799b);
        } catch (Exception e2) {
            if (AnalyticsConstants.UM_DEBUG) {
                e2.printStackTrace();
            }
            UMCrashManager.reportCrash(this.f12799b, e2);
            return null;
        }
    }
}
