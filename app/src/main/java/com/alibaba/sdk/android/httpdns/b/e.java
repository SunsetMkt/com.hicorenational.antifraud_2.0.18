package com.alibaba.sdk.android.httpdns.b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class e {
    public String a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ArrayList<g> f7a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f2547b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public ArrayList<g> f8b;
    public String host;
    public long id;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public String f2548m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public String f2549n;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[HostRecord] ");
        sb.append("id:");
        sb.append(this.id);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("host:");
        sb.append(this.host);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("sp:");
        sb.append(this.f2548m);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("time:");
        sb.append(this.f2549n);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ips:");
        ArrayList<g> arrayList = this.f7a;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<g> it = this.f7a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ipsv6:");
        ArrayList<g> arrayList2 = this.f8b;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<g> it2 = this.f8b.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
            }
        }
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("extra:");
        sb.append(this.a);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("cacheKey:");
        sb.append(this.f2547b);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        return sb.toString();
    }
}
