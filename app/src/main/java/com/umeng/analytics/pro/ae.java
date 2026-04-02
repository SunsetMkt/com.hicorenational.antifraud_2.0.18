package com.umeng.analytics.pro;

import android.content.SharedPreferences;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.service.UMGlobalContext;

/* JADX INFO: compiled from: IntervalPeriodCondition.java */
/* JADX INFO: loaded from: classes2.dex */
public class ae implements aa {
    private String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long f6983b;

    public ae(String str, long j2) {
        this.a = "";
        this.f6983b = 0L;
        this.a = str;
        this.f6983b = j2;
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean a() {
        try {
            String str = aq.f7007b + this.a;
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA == null) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis() - sharedPreferencesA.getLong(str, 0L);
            if (jCurrentTimeMillis > this.f6983b * 1000) {
                return true;
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "internal period skipped. elapse: " + jCurrentTimeMillis + "; config: " + (this.f6983b * 1000));
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    @Override // com.umeng.analytics.pro.aa
    public boolean b() {
        return !a();
    }

    @Override // com.umeng.analytics.pro.aa
    public long c() {
        return 0L;
    }
}
