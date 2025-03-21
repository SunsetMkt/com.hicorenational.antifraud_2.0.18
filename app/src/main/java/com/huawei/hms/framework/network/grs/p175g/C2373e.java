package com.huawei.hms.framework.network.grs.p175g;

import android.content.Context;
import anet.channel.strategy.dispatch.DispatchConstants;
import com.huawei.hms.framework.common.ExceptionCode;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.common.StringUtils;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.framework.common.hianalytics.HianalyticsHelper;
import com.huawei.hms.framework.common.hianalytics.LinkedHashMapPack;
import com.huawei.hms.framework.network.grs.p175g.p177j.C2378a;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.huawei.hms.framework.network.grs.g.e */
/* loaded from: classes.dex */
public class C2373e {

    /* renamed from: com.huawei.hms.framework.network.grs.g.e$a */
    class a implements Runnable {

        /* renamed from: a */
        final /* synthetic */ long f7410a;

        /* renamed from: b */
        final /* synthetic */ ArrayList f7411b;

        /* renamed from: c */
        final /* synthetic */ JSONArray f7412c;

        a(long j2, ArrayList arrayList, JSONArray jSONArray) {
            this.f7410a = j2;
            this.f7411b = arrayList;
            this.f7412c = jSONArray;
        }

        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            C2378a c2378a = new C2378a();
            c2378a.put("total_time", this.f7410a);
            Iterator it = this.f7411b.iterator();
            while (it.hasNext()) {
                C2372d c2372d = (C2372d) it.next();
                if (c2372d.m6942o() || c2372d.m6940m()) {
                    c2378a.put(C2373e.m6945b(c2372d));
                    it.remove();
                    z = true;
                    break;
                }
            }
            z = false;
            if (!z && this.f7411b.size() > 0) {
                ArrayList arrayList = this.f7411b;
                C2372d c2372d2 = (C2372d) arrayList.get(arrayList.size() - 1);
                c2378a.put(C2373e.m6945b(c2372d2));
                this.f7411b.remove(c2372d2);
            }
            if (this.f7411b.size() > 0) {
                Iterator it2 = this.f7411b.iterator();
                while (it2.hasNext()) {
                    this.f7412c.put(new JSONObject(C2373e.m6945b((C2372d) it2.next())));
                }
            }
            if (this.f7412c.length() > 0) {
                c2378a.put("failed_info", this.f7412c.toString());
            }
            Logger.m6795d("HaReportHelper", "grssdk report data to aiops is: %s", new JSONObject(c2378a.get()));
            HianalyticsHelper.getInstance().onEvent(c2378a.get(), "grs_request");
        }
    }

    /* renamed from: a */
    public static void m6944a(ArrayList<C2372d> arrayList, long j2, JSONArray jSONArray, Context context) {
        if (context == null || arrayList == null || arrayList.size() <= 0 || !HianalyticsHelper.getInstance().isEnableReport(context)) {
            return;
        }
        HianalyticsHelper.getInstance().getReportExecutor().submit(new a(j2, arrayList, jSONArray));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public static LinkedHashMap<String, String> m6945b(C2372d c2372d) {
        LinkedHashMapPack linkedHashMapPack = new LinkedHashMapPack();
        Exception m6931d = c2372d.m6931d();
        if (m6931d != null) {
            linkedHashMapPack.put("error_code", ExceptionCode.getErrorCodeFromException(m6931d));
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, m6931d.getClass().getSimpleName());
            linkedHashMapPack.put("message", StringUtils.anonymizeMessage(m6931d.getMessage()));
        } else {
            linkedHashMapPack.put("error_code", c2372d.m6927b());
            linkedHashMapPack.put(CrashHianalyticsData.EXCEPTION_NAME, c2372d.m6930c());
        }
        try {
            linkedHashMapPack.put(DispatchConstants.DOMAIN, new URL(c2372d.m6939l()).getHost());
        } catch (MalformedURLException e2) {
            Logger.m6804w("HaReportHelper", "report host MalformedURLException", e2);
        }
        linkedHashMapPack.put("req_start_time", c2372d.m6935h());
        linkedHashMapPack.put("req_end_time", c2372d.m6934g());
        linkedHashMapPack.put("req_total_time", c2372d.m6936i());
        return linkedHashMapPack.getAll();
    }
}
