package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import com.umeng.analytics.AnalyticsConfig;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;

/* compiled from: SessionIdGenerateServiceImpl.java */
/* renamed from: com.umeng.analytics.pro.x */
/* loaded from: classes2.dex */
class C3423x implements InterfaceC3422w {

    /* renamed from: a */
    private long f12271a = AnalyticsConfig.kContinueSessionMillis;

    C3423x() {
    }

    @Override // com.umeng.analytics.pro.InterfaceC3422w
    /* renamed from: a */
    public void mo11415a(long j2) {
        this.f12271a = j2;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3422w
    /* renamed from: a */
    public long mo11413a() {
        return this.f12271a;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3422w
    /* renamed from: a */
    public String mo11414a(Context context) {
        String appkey = UMUtils.getAppkey(context);
        long currentTimeMillis = System.currentTimeMillis();
        if (appkey != null) {
            return UMUtils.MD5(currentTimeMillis + appkey + "02:00:00:00:00:00");
        }
        throw new RuntimeException("Appkey is null or empty, Please check!");
    }

    @Override // com.umeng.analytics.pro.InterfaceC3422w
    /* renamed from: a */
    public boolean mo11417a(long j2, long j3) {
        long currentTimeMillis = System.currentTimeMillis();
        return (j2 == 0 || currentTimeMillis - j2 >= this.f12271a) && j3 > 0 && currentTimeMillis - j3 > this.f12271a;
    }

    @Override // com.umeng.analytics.pro.InterfaceC3422w
    /* renamed from: a */
    public void mo11416a(Context context, String str) {
        long currentTimeMillis = System.currentTimeMillis();
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString("session_id", str);
            edit.putLong(C3420u.f12252b, 0L);
            edit.putLong(C3420u.f12255e, currentTimeMillis);
            edit.putLong(C3420u.f12256f, 0L);
            edit.commit();
        } catch (Exception unused) {
        }
    }
}
