package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventWhiteList.java */
/* renamed from: com.umeng.analytics.filter.b */
/* loaded from: classes2.dex */
public class C3313b extends EventList {

    /* renamed from: a */
    private C3315d f11404a;

    /* renamed from: b */
    private Object f11405b;

    public C3313b(String str, String str2) {
        super(str, str2);
        this.f11405b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f11405b) {
            this.f11404a = null;
            this.f11404a = new C3315d(true, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean m10796a;
        if (TextUtils.isEmpty(this.mEventList)) {
            return true;
        }
        synchronized (this.f11405b) {
            if (this.f11404a == null) {
                this.f11404a = new C3315d(true, this.mEventList);
            }
            m10796a = this.f11404a.m10796a(str);
        }
        return m10796a;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_WL = z;
    }
}
