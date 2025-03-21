package com.umeng.analytics.filter;

import android.text.TextUtils;
import com.umeng.analytics.AnalyticsConfig;

/* compiled from: EventBlackList.java */
/* renamed from: com.umeng.analytics.filter.a */
/* loaded from: classes2.dex */
public class C3312a extends EventList {

    /* renamed from: a */
    private C3315d f11402a;

    /* renamed from: b */
    private Object f11403b;

    public C3312a(String str, String str2) {
        super(str, str2);
        this.f11403b = new Object();
    }

    @Override // com.umeng.analytics.filter.EventList
    protected void eventListChange() {
        if (TextUtils.isEmpty(this.mEventList)) {
            return;
        }
        synchronized (this.f11403b) {
            this.f11402a = null;
            this.f11402a = new C3315d(false, this.mEventList);
        }
    }

    @Override // com.umeng.analytics.filter.EventList
    public boolean matchHit(String str) {
        boolean m10796a;
        if (TextUtils.isEmpty(this.mEventList)) {
            return false;
        }
        synchronized (this.f11403b) {
            if (this.f11402a == null) {
                this.f11402a = new C3315d(false, this.mEventList);
            }
            m10796a = this.f11402a.m10796a(str);
        }
        return m10796a;
    }

    @Override // com.umeng.analytics.filter.EventList
    public void setMD5ClearFlag(boolean z) {
        AnalyticsConfig.CLEAR_EKV_BL = z;
    }
}
