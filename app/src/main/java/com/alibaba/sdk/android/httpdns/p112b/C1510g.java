package com.alibaba.sdk.android.httpdns.p112b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

/* renamed from: com.alibaba.sdk.android.httpdns.b.g */
/* loaded from: classes.dex */
public class C1510g {

    /* renamed from: i */
    public long f3863i;

    /* renamed from: id */
    public long f3864id;

    /* renamed from: o */
    public String f3865o;

    /* renamed from: p */
    public String f3866p;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[IpRecord] ");
        sb.append("id:");
        sb.append(this.f3864id);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("host_id:");
        sb.append(this.f3863i);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ip:");
        sb.append(this.f3865o);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ttl:");
        sb.append(this.f3866p);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        return sb.toString();
    }
}
