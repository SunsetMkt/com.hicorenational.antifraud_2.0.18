package com.xiaomi.clientreport.manager;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.clientreport.data.C4024a;
import com.xiaomi.clientreport.data.Config;
import com.xiaomi.clientreport.data.EventClientReport;
import com.xiaomi.clientreport.data.PerfClientReport;
import com.xiaomi.clientreport.processor.IEventProcessor;
import com.xiaomi.clientreport.processor.IPerfProcessor;
import com.xiaomi.push.C4076ae;
import com.xiaomi.push.C4100bb;
import com.xiaomi.push.C4107bi;
import com.xiaomi.push.C4108bj;
import com.xiaomi.push.C4110bl;
import com.xiaomi.push.C4111bm;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.RunnableC4109bk;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.xiaomi.clientreport.manager.a */
/* loaded from: classes2.dex */
public class C4025a {

    /* renamed from: a */
    private static final int f14311a;

    /* renamed from: a */
    private static volatile C4025a f14312a;

    /* renamed from: a */
    private Context f14313a;

    /* renamed from: a */
    private Config f14314a;

    /* renamed from: a */
    private IEventProcessor f14315a;

    /* renamed from: a */
    private IPerfProcessor f14316a;

    /* renamed from: a */
    private String f14317a;

    /* renamed from: a */
    private ExecutorService f14319a = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    private HashMap<String, HashMap<String, C4024a>> f14318a = new HashMap<>();

    /* renamed from: b */
    private HashMap<String, ArrayList<C4024a>> f14320b = new HashMap<>();

    static {
        f14311a = C4300j.m15680a() ? 30 : 10;
    }

    private C4025a(Context context) {
        this.f14313a = context;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public void m13377d() {
        try {
            this.f14315a.mo13403b();
        } catch (Exception e2) {
            AbstractC4022b.m13361d("we: " + e2.getMessage());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public void m13378e() {
        try {
            this.f14316a.mo13403b();
        } catch (Exception e2) {
            AbstractC4022b.m13361d("wp: " + e2.getMessage());
        }
    }

    /* renamed from: f */
    private void m13379f() {
        if (m13366a(this.f14313a).m13381a().isEventUploadSwitchOpen()) {
            final C4107bi c4107bi = new C4107bi(this.f14313a);
            int eventUploadFrequency = (int) m13366a(this.f14313a).m13381a().getEventUploadFrequency();
            int i2 = eventUploadFrequency >= 1800 ? eventUploadFrequency : 1800;
            if (System.currentTimeMillis() - C4111bm.m13926a(this.f14313a).m13927a("sp_client_report_status", "event_last_upload_time", 0L) > i2 * 1000) {
                C4076ae.m13698a(this.f14313a).m13704a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.5
                    @Override // java.lang.Runnable
                    public void run() {
                        c4107bi.run();
                    }
                }, 10);
            }
            synchronized (C4025a.class) {
                if (!C4076ae.m13698a(this.f14313a).m13706a((C4076ae.a) c4107bi, i2)) {
                    C4076ae.m13698a(this.f14313a).m13709a("100886");
                    C4076ae.m13698a(this.f14313a).m13706a((C4076ae.a) c4107bi, i2);
                }
            }
        }
    }

    /* renamed from: g */
    private void m13380g() {
        if (m13366a(this.f14313a).m13381a().isPerfUploadSwitchOpen()) {
            final C4108bj c4108bj = new C4108bj(this.f14313a);
            int perfUploadFrequency = (int) m13366a(this.f14313a).m13381a().getPerfUploadFrequency();
            int i2 = perfUploadFrequency >= 1800 ? perfUploadFrequency : 1800;
            if (System.currentTimeMillis() - C4111bm.m13926a(this.f14313a).m13927a("sp_client_report_status", "perf_last_upload_time", 0L) > i2 * 1000) {
                C4076ae.m13698a(this.f14313a).m13704a(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.6
                    @Override // java.lang.Runnable
                    public void run() {
                        c4108bj.run();
                    }
                }, 15);
            }
            synchronized (C4025a.class) {
                if (!C4076ae.m13698a(this.f14313a).m13706a((C4076ae.a) c4108bj, i2)) {
                    C4076ae.m13698a(this.f14313a).m13709a("100887");
                    C4076ae.m13698a(this.f14313a).m13706a((C4076ae.a) c4108bj, i2);
                }
            }
        }
    }

    /* renamed from: c */
    public void m13390c() {
        if (m13381a().isPerfUploadSwitchOpen()) {
            RunnableC4109bk runnableC4109bk = new RunnableC4109bk();
            runnableC4109bk.m13916a(this.f14316a);
            runnableC4109bk.m13915a(this.f14313a);
            this.f14319a.execute(runnableC4109bk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13374b(EventClientReport eventClientReport) {
        IEventProcessor iEventProcessor = this.f14315a;
        if (iEventProcessor != null) {
            iEventProcessor.mo13400a(eventClientReport);
            if (m13364a() >= 10) {
                m13377d();
                C4076ae.m13698a(this.f14313a).m13709a("100888");
            } else {
                m13371a(new C4076ae.a() { // from class: com.xiaomi.clientreport.manager.a.3
                    @Override // com.xiaomi.push.C4076ae.a
                    /* renamed from: a */
                    public String mo13391a() {
                        return "100888";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (C4025a.this.m13364a() > 0) {
                            C4025a.this.f14319a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.3.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C4025a.this.m13377d();
                                }
                            });
                        }
                    }
                }, f14311a);
            }
        }
    }

    /* renamed from: a */
    public static C4025a m13366a(Context context) {
        if (f14312a == null) {
            synchronized (C4025a.class) {
                if (f14312a == null) {
                    f14312a = new C4025a(context);
                }
            }
        }
        return f14312a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public void m13375b(PerfClientReport perfClientReport) {
        IPerfProcessor iPerfProcessor = this.f14316a;
        if (iPerfProcessor != null) {
            iPerfProcessor.mo13400a(perfClientReport);
            if (m13372b() >= 10) {
                m13378e();
                C4076ae.m13698a(this.f14313a).m13709a("100889");
            } else {
                m13371a(new C4076ae.a() { // from class: com.xiaomi.clientreport.manager.a.4
                    @Override // com.xiaomi.push.C4076ae.a
                    /* renamed from: a */
                    public String mo13391a() {
                        return "100889";
                    }

                    @Override // java.lang.Runnable
                    public void run() {
                        if (C4025a.this.m13372b() > 0) {
                            C4025a.this.f14319a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.4.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    C4025a.this.m13378e();
                                }
                            });
                        }
                    }
                }, f14311a);
            }
        }
    }

    /* renamed from: a */
    public synchronized Config m13381a() {
        if (this.f14314a == null) {
            this.f14314a = Config.defaultConfig(this.f14313a);
        }
        return this.f14314a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: b */
    public int m13372b() {
        HashMap<String, HashMap<String, C4024a>> hashMap = this.f14318a;
        int i2 = 0;
        if (hashMap != null) {
            Iterator<String> it = hashMap.keySet().iterator();
            while (it.hasNext()) {
                HashMap<String, C4024a> hashMap2 = this.f14318a.get(it.next());
                if (hashMap2 != null) {
                    Iterator<String> it2 = hashMap2.keySet().iterator();
                    while (it2.hasNext()) {
                        C4024a c4024a = hashMap2.get(it2.next());
                        if (c4024a instanceof PerfClientReport) {
                            i2 = (int) (i2 + ((PerfClientReport) c4024a).perfCounts);
                        }
                    }
                }
            }
        }
        return i2;
    }

    /* renamed from: a */
    public void m13383a() {
        m13366a(this.f14313a).m13379f();
        m13366a(this.f14313a).m13380g();
    }

    /* renamed from: a */
    public void m13387a(String str) {
        this.f14317a = str;
    }

    /* renamed from: a */
    public void m13384a(Config config, IEventProcessor iEventProcessor, IPerfProcessor iPerfProcessor) {
        this.f14314a = config;
        this.f14315a = iEventProcessor;
        this.f14316a = iPerfProcessor;
        this.f14315a.setEventMap(this.f14320b);
        this.f14316a.setPerfMap(this.f14318a);
    }

    /* renamed from: a */
    public void m13388a(boolean z, boolean z2, long j2, long j3) {
        Config config = this.f14314a;
        if (config != null) {
            if (z == config.isEventUploadSwitchOpen() && z2 == this.f14314a.isPerfUploadSwitchOpen() && j2 == this.f14314a.getEventUploadFrequency() && j3 == this.f14314a.getPerfUploadFrequency()) {
                return;
            }
            long eventUploadFrequency = this.f14314a.getEventUploadFrequency();
            long perfUploadFrequency = this.f14314a.getPerfUploadFrequency();
            Config build = Config.getBuilder().setAESKey(C4110bl.m13918a(this.f14313a)).setEventEncrypted(this.f14314a.isEventEncrypted()).setEventUploadSwitchOpen(z).setEventUploadFrequency(j2).setPerfUploadSwitchOpen(z2).setPerfUploadFrequency(j3).build(this.f14313a);
            this.f14314a = build;
            if (!this.f14314a.isEventUploadSwitchOpen()) {
                C4076ae.m13698a(this.f14313a).m13709a("100886");
            } else if (eventUploadFrequency != build.getEventUploadFrequency()) {
                AbstractC4022b.m13359c(this.f14313a.getPackageName() + "reset event job " + build.getEventUploadFrequency());
                m13379f();
            }
            if (!this.f14314a.isPerfUploadSwitchOpen()) {
                C4076ae.m13698a(this.f14313a).m13709a("100887");
                return;
            }
            if (perfUploadFrequency != build.getPerfUploadFrequency()) {
                AbstractC4022b.m13359c(this.f14313a.getPackageName() + " reset perf job " + build.getPerfUploadFrequency());
                m13380g();
            }
        }
    }

    /* renamed from: b */
    public void m13389b() {
        if (m13381a().isEventUploadSwitchOpen()) {
            RunnableC4109bk runnableC4109bk = new RunnableC4109bk();
            runnableC4109bk.m13915a(this.f14313a);
            runnableC4109bk.m13916a(this.f14315a);
            this.f14319a.execute(runnableC4109bk);
        }
    }

    /* renamed from: a */
    private void m13371a(C4076ae.a aVar, int i2) {
        C4076ae.m13698a(this.f14313a).m13710b(aVar, i2);
    }

    /* renamed from: a */
    public void m13385a(final EventClientReport eventClientReport) {
        if (m13381a().isEventUploadSwitchOpen()) {
            this.f14319a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.1
                @Override // java.lang.Runnable
                public void run() {
                    C4025a.this.m13374b(eventClientReport);
                }
            });
        }
    }

    /* renamed from: a */
    public void m13386a(final PerfClientReport perfClientReport) {
        if (m13381a().isPerfUploadSwitchOpen()) {
            this.f14319a.execute(new Runnable() { // from class: com.xiaomi.clientreport.manager.a.2
                @Override // java.lang.Runnable
                public void run() {
                    C4025a.this.m13375b(perfClientReport);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: a */
    public int m13364a() {
        HashMap<String, ArrayList<C4024a>> hashMap = this.f14320b;
        if (hashMap == null) {
            return 0;
        }
        Iterator<String> it = hashMap.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            ArrayList<C4024a> arrayList = this.f14320b.get(it.next());
            i2 += arrayList != null ? arrayList.size() : 0;
        }
        return i2;
    }

    /* renamed from: a */
    public EventClientReport m13382a(int i2, String str) {
        EventClientReport eventClientReport = new EventClientReport();
        eventClientReport.eventContent = str;
        eventClientReport.eventTime = System.currentTimeMillis();
        eventClientReport.eventType = i2;
        eventClientReport.eventId = C4100bb.m13878a(6);
        eventClientReport.production = 1000;
        eventClientReport.reportType = 1001;
        eventClientReport.clientInterfaceId = "E100004";
        eventClientReport.setAppPackageName(this.f14313a.getPackageName());
        eventClientReport.setSdkVersion(this.f14317a);
        return eventClientReport;
    }
}
