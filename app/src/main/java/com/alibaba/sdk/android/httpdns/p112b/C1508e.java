package com.alibaba.sdk.android.httpdns.p112b;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.alibaba.sdk.android.httpdns.b.e */
/* loaded from: classes.dex */
public class C1508e {

    /* renamed from: a */
    public String f3856a;

    /* renamed from: a */
    public ArrayList<C1510g> f3857a;

    /* renamed from: b */
    public String f3858b;

    /* renamed from: b */
    public ArrayList<C1510g> f3859b;
    public String host;

    /* renamed from: id */
    public long f3860id;

    /* renamed from: m */
    public String f3861m;

    /* renamed from: n */
    public String f3862n;

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("[HostRecord] ");
        sb.append("id:");
        sb.append(this.f3860id);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("host:");
        sb.append(this.host);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("sp:");
        sb.append(this.f3861m);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("time:");
        sb.append(this.f3862n);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ips:");
        ArrayList<C1510g> arrayList = this.f3857a;
        if (arrayList != null && arrayList.size() > 0) {
            Iterator<C1510g> it = this.f3857a.iterator();
            while (it.hasNext()) {
                sb.append(it.next());
            }
        }
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("ipsv6:");
        ArrayList<C1510g> arrayList2 = this.f3859b;
        if (arrayList2 != null && arrayList2.size() > 0) {
            Iterator<C1510g> it2 = this.f3859b.iterator();
            while (it2.hasNext()) {
                sb.append(it2.next());
            }
        }
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("extra:");
        sb.append(this.f3856a);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb.append("cacheKey:");
        sb.append(this.f3858b);
        sb.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        return sb.toString();
    }
}
