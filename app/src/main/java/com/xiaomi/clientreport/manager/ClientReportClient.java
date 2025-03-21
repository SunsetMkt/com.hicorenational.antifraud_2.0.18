package com.xiaomi.clientreport.manager;

import android.content.Context;
import android.os.Process;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.C4026a;
import com.xiaomi.clientreport.processor.C4027b;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C4233g;

/* loaded from: classes2.dex */
public class ClientReportClient {
    public static void init(Context context) {
        init(context, Config.defaultConfig(context), new C4026a(context), new C4027b(context));
    }

    public static void reportEvent(Context context, EventClientReport eventClientReport) {
        if (eventClientReport != null) {
            C4025a.m13366a(context).m13385a(eventClientReport);
        }
    }

    public static void reportPerf(Context context, PerfClientReport perfClientReport) {
        if (perfClientReport != null) {
            C4025a.m13366a(context).m13386a(perfClientReport);
        }
    }

    public static void updateConfig(Context context, Config config) {
        if (config == null) {
            return;
        }
        C4025a.m13366a(context).m13388a(config.isEventUploadSwitchOpen(), config.isPerfUploadSwitchOpen(), config.getEventUploadFrequency(), config.getPerfUploadFrequency());
    }

    public static void init(Context context, Config config) {
        init(context, config, new C4026a(context), new C4027b(context));
    }

    public static void init(Context context, Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        AbstractC4022b.m13359c("init in  pid :" + Process.myPid() + " threadId: " + Thread.currentThread().getId());
        C4025a.m13366a(context).m13384a(config, iEventProcessor, iPerfProcessor);
        if (C4233g.m14934a(context)) {
            AbstractC4022b.m13359c("init in process\u3000start scheduleJob");
            C4025a.m13366a(context).m13383a();
        }
    }
}
