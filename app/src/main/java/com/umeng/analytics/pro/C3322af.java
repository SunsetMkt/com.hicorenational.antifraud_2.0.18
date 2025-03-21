package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* compiled from: LaunchTimesCondition.java */
/* renamed from: com.umeng.analytics.pro.af */
/* loaded from: classes2.dex */
public class C3322af implements InterfaceC3317aa {

    /* renamed from: a */
    private int f11427a;

    public C3322af(int i2) {
        this.f11427a = 0;
        this.f11427a = i2;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: a */
    public boolean mo10809a() {
        long j2 = 0;
        try {
            SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
            if (m10859a != null) {
                j2 = m10859a.getLong(C3333aq.f11470a, 0L);
                if (j2 >= this.f11427a) {
                    return true;
                }
            }
        } catch (Throwable unused) {
        }
        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "launch times skipped. times: " + j2 + " ; config: " + this.f11427a);
        return false;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: b */
    public boolean mo10810b() {
        return !mo10809a();
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: c */
    public long mo10811c() {
        return 0L;
    }
}
