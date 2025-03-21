package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: HourOnCondition.java */
/* renamed from: com.umeng.analytics.pro.ad */
/* loaded from: classes2.dex */
public class C3320ad implements InterfaceC3317aa {

    /* renamed from: a */
    private Set<Integer> f11424a;

    public C3320ad(Set<Integer> set) {
        this.f11424a = null;
        this.f11424a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: a */
    public boolean mo10809a() {
        try {
            int i2 = Calendar.getInstance().get(11);
            if (this.f11424a != null && this.f11424a.contains(Integer.valueOf(i2))) {
                return true;
            }
            String str = "";
            Iterator<Integer> it = this.f11424a.iterator();
            while (it.hasNext()) {
                str = str + it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "HourOn skipped. hour of day: " + i2 + "; config: " + str);
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
