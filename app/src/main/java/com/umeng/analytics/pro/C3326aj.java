package com.umeng.analytics.pro;

import com.umeng.commonsdk.debug.UMRTLog;
import com.xiaomi.mipush.sdk.Constants;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* compiled from: WeekOnCondition.java */
/* renamed from: com.umeng.analytics.pro.aj */
/* loaded from: classes2.dex */
public class C3326aj implements InterfaceC3317aa {

    /* renamed from: a */
    private Set<Integer> f11435a;

    public C3326aj(Set<Integer> set) {
        this.f11435a = null;
        this.f11435a = new HashSet(set);
    }

    @Override // com.umeng.analytics.pro.InterfaceC3317aa
    /* renamed from: a */
    public boolean mo10809a() {
        try {
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(System.currentTimeMillis());
            int i2 = calendar.get(7) - 1;
            if (i2 == 0) {
                i2 = 7;
            }
            if (this.f11435a != null && this.f11435a.contains(Integer.valueOf(i2))) {
                return true;
            }
            String str = "";
            Iterator<Integer> it = this.f11435a.iterator();
            while (it.hasNext()) {
                str = str + it.next() + Constants.ACCEPT_TIME_SEPARATOR_SP;
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "WeekOn skipped. day of week: " + i2 + "; config: " + str);
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
