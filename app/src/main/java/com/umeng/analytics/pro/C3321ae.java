package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* compiled from: IntervalPeriodCondition.java */
/* renamed from: com.umeng.analytics.pro.ae */
/* loaded from: classes2.dex */
public class C3321ae implements InterfaceC3317aa {

    /* renamed from: a */
    private String f11425a;

    /* renamed from: b */
    private long f11426b;

    public C3321ae(String str, long j2) {
        this.f11425a = "";
        this.f11426b = 0L;
        this.f11425a = str;
        this.f11426b = j2;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: a */
    public boolean mo10809a() {
        try {
            String str = C3333aq.f11471b + this.f11425a;
            SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
            if (m10859a == null) {
                return false;
            }
            long currentTimeMillis = System.currentTimeMillis() - m10859a.getLong(str, 0L);
            if (currentTimeMillis > this.f11426b * 1000) {
                return true;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + currentTimeMillis + "; config: " + (this.f11426b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
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
