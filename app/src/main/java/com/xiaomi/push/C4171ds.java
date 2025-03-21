package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.manager.ClientReportClient;
import com.xiaomi.push.service.C4356ah;
import com.xiaomi.push.service.C4374az;
import com.xiaomi.push.service.C4376ba;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import p388ui.activity.BaseProgressUploadActivity;

/* renamed from: com.xiaomi.push.ds */
/* loaded from: classes2.dex */
public class C4171ds {

    /* renamed from: a */
    private static a f15034a;

    /* renamed from: a */
    private static Map<String, EnumC4249gp> f15035a;

    /* renamed from: com.xiaomi.push.ds$a */
    public interface a {
        void uploader(Context context, C4243gj c4243gj);
    }

    /* renamed from: a */
    public static int m14513a(int i2) {
        if (i2 > 0) {
            return i2 + 1000;
        }
        return -1;
    }

    /* renamed from: a */
    public static String m14522a(int i2) {
        return i2 == 1000 ? "E100000" : i2 == 3000 ? "E100002" : i2 == 2000 ? "E100001" : i2 == 6000 ? "E100003" : "";
    }

    /* renamed from: a */
    public static void m14527a(a aVar) {
        f15034a = aVar;
    }

    /* renamed from: a */
    private static void m14525a(Context context, C4243gj c4243gj) {
        if (m14528a(context.getApplicationContext())) {
            C4376ba.m16052a(context.getApplicationContext(), c4243gj);
            return;
        }
        a aVar = f15034a;
        if (aVar != null) {
            aVar.uploader(context, c4243gj);
        }
    }

    /* renamed from: a */
    public static EventClientReport m14517a(String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = str;
        return eventClientReport;
    }

    /* renamed from: a */
    public static PerfClientReport m14518a() {
        PerfClientReport perfClientReport = new PerfClientReport();
        perfClientReport.production = 1000;
        perfClientReport.reportType = 1000;
        perfClientReport.clientInterfaceId = "P100000";
        return perfClientReport;
    }

    /* renamed from: a */
    public static EventClientReport m14516a(Context context, String str, String str2, int i2, long j2, String str3) {
        EventClientReport m14517a = m14517a(str);
        m14517a.eventId = str2;
        m14517a.eventType = i2;
        m14517a.eventTime = j2;
        m14517a.eventContent = str3;
        return m14517a;
    }

    /* renamed from: a */
    public static PerfClientReport m14519a(Context context, int i2, long j2, long j3) {
        PerfClientReport m14518a = m14518a();
        m14518a.code = i2;
        m14518a.perfCounts = j2;
        m14518a.perfLatencies = j3;
        return m14518a;
    }

    /* renamed from: a */
    public static boolean m14528a(Context context) {
        return (context == null || TextUtils.isEmpty(context.getPackageName()) || !"com.xiaomi.xmsf".equals(context.getPackageName())) ? false : true;
    }

    /* renamed from: a */
    public static void m14526a(Context context, List<String> list) {
        if (list == null) {
            return;
        }
        try {
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                C4243gj m14520a = m14520a(context, it.next());
                if (!C4374az.m16043a(m14520a, false)) {
                    m14525a(context, m14520a);
                }
            }
        } catch (Throwable th) {
            AbstractC4022b.m13361d(th.getMessage());
        }
    }

    /* renamed from: a */
    public static C4243gj m14520a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C4243gj c4243gj = new C4243gj();
        c4243gj.m15000d("category_client_report_data");
        c4243gj.m14981a("push_sdk_channel");
        c4243gj.m14980a(1L);
        c4243gj.m14992b(str);
        c4243gj.m14983a(true);
        c4243gj.m14991b(System.currentTimeMillis());
        c4243gj.m15008g(context.getPackageName());
        c4243gj.m15003e("com.xiaomi.xmsf");
        c4243gj.m15006f(C4374az.m16040a());
        c4243gj.m14996c("quality_support");
        return c4243gj;
    }

    /* renamed from: a */
    public static void m14524a(Context context, Config config) {
        ClientReportClient.init(context, config, new C4169dq(context), new C4170dr(context));
    }

    /* renamed from: a */
    public static void m14523a(Context context) {
        ClientReportClient.updateConfig(context, m14515a(context));
    }

    /* renamed from: a */
    public static Config m14515a(Context context) {
        boolean m15935a = C4356ah.m15923a(context).m15935a(EnumC4244gk.PerfUploadSwitch.m15014a(), false);
        boolean m15935a2 = C4356ah.m15923a(context).m15935a(EnumC4244gk.EventUploadNewSwitch.m15014a(), false);
        return Config.getBuilder().setEventUploadSwitchOpen(m15935a2).setEventUploadFrequency(C4356ah.m15923a(context).m15927a(EnumC4244gk.EventUploadFrequency.m15014a(), RemoteMessageConst.DEFAULT_TTL)).setPerfUploadSwitchOpen(m15935a).setPerfUploadFrequency(C4356ah.m15923a(context).m15927a(EnumC4244gk.PerfUploadFrequency.m15014a(), RemoteMessageConst.DEFAULT_TTL)).build(context);
    }

    /* renamed from: a */
    public static int m14514a(Enum r1) {
        if (r1 != null) {
            if (r1 instanceof EnumC4239gf) {
                return r1.ordinal() + 1001;
            }
            if (r1 instanceof EnumC4249gp) {
                return r1.ordinal() + BaseProgressUploadActivity.REQUESTION_CODE_RECORD_AUDIO_1;
            }
            if (r1 instanceof EnumC4183ed) {
                return r1.ordinal() + 3001;
            }
        }
        return -1;
    }

    /* renamed from: a */
    public static EnumC4249gp m14521a(String str) {
        if (f15035a == null) {
            synchronized (EnumC4249gp.class) {
                if (f15035a == null) {
                    f15035a = new HashMap();
                    for (EnumC4249gp enumC4249gp : EnumC4249gp.values()) {
                        f15035a.put(enumC4249gp.f15769a.toLowerCase(), enumC4249gp);
                    }
                }
            }
        }
        EnumC4249gp enumC4249gp2 = f15035a.get(str.toLowerCase());
        return enumC4249gp2 != null ? enumC4249gp2 : EnumC4249gp.Invalid;
    }
}
