package com.xiaomi.push;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.xiaomi.clientreport.data.C4024a;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;

/* renamed from: com.xiaomi.push.dt */
/* loaded from: classes2.dex */
public class C4172dt {

    /* renamed from: a */
    private static volatile C4172dt f15036a;

    /* renamed from: a */
    private Context f15037a;

    private C4172dt(Context context) {
        this.f15037a = context;
    }

    /* renamed from: a */
    public static C4172dt m14529a(Context context) {
        if (f15036a == null) {
            synchronized (C4172dt.class) {
                if (f15036a == null) {
                    f15036a = new C4172dt(context);
                }
            }
        }
        return f15036a;
    }

    /* renamed from: b */
    public void m14537b(String str, String str2, String str3, String str4) {
        m14534a(str, str2, str3, 5001, System.currentTimeMillis(), str4);
    }

    /* renamed from: c */
    public void m14538c(String str, String str2, String str3, String str4) {
        m14534a(str, str2, str3, 4002, System.currentTimeMillis(), str4);
    }

    /* renamed from: a */
    public void m14534a(String str, String str2, String str3, int i2, long j2, String str4) {
        if (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return;
        }
        EventClientReport m14516a = C4171ds.m14516a(this.f15037a, str2, str3, i2, j2, str4);
        m14516a.setAppPackageName(str);
        m14516a.setSdkVersion(BuildConfig.VERSION_NAME);
        m14530a(m14516a);
    }

    /* renamed from: a */
    public void m14535a(String str, String str2, String str3, int i2, String str4) {
        m14534a(str, str2, str3, i2, System.currentTimeMillis(), str4);
    }

    /* renamed from: a */
    public void m14532a(String str, Intent intent, int i2, String str2) {
        if (intent == null) {
            return;
        }
        m14534a(str, C4171ds.m14522a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), i2, System.currentTimeMillis(), str2);
    }

    /* renamed from: a */
    public void m14536a(String str, String str2, String str3, String str4) {
        m14534a(str, str2, str3, 5002, System.currentTimeMillis(), str4);
    }

    /* renamed from: a */
    public void m14533a(String str, Intent intent, String str2) {
        if (intent == null) {
            return;
        }
        m14534a(str, C4171ds.m14522a(intent.getIntExtra("eventMessageType", -1)), intent.getStringExtra("messageId"), 5001, System.currentTimeMillis(), str2);
    }

    /* renamed from: a */
    public void m14531a(String str, int i2, long j2, long j3) {
        if (i2 < 0 || j3 < 0 || j2 <= 0) {
            return;
        }
        PerfClientReport m14519a = C4171ds.m14519a(this.f15037a, i2, j2, j3);
        m14519a.setAppPackageName(str);
        m14519a.setSdkVersion(BuildConfig.VERSION_NAME);
        m14530a(m14519a);
    }

    /* renamed from: a */
    private void m14530a(C4024a c4024a) {
        if (c4024a instanceof PerfClientReport) {
            ClientReportClient.reportPerf(this.f15037a, (PerfClientReport) c4024a);
        } else if (c4024a instanceof EventClientReport) {
            ClientReportClient.reportEvent(this.f15037a, (EventClientReport) c4024a);
        }
    }
}
