package com.tencent.open.p212b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.p211a.C3255f;
import com.tencent.open.p211a.InterfaceC3256g;
import com.tencent.open.utils.C3288f;
import com.tencent.open.utils.C3289g;
import com.tencent.open.utils.C3291i;
import com.tencent.open.utils.C3294l;
import com.tencent.open.utils.C3295m;
import com.tencent.open.utils.HttpUtils;
import com.umeng.analytics.pro.C3351bh;
import java.io.IOException;
import java.io.Serializable;
import java.net.SocketTimeoutException;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.TimeZone;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: ProGuard */
/* renamed from: com.tencent.open.b.h */
/* loaded from: classes2.dex */
public class C3266h {

    /* renamed from: a */
    protected static C3266h f11184a;

    /* renamed from: e */
    protected HandlerThread f11188e;

    /* renamed from: f */
    protected Handler f11189f;

    /* renamed from: b */
    protected Random f11185b = new SecureRandom();

    /* renamed from: d */
    protected List<Serializable> f11187d = Collections.synchronizedList(new ArrayList());

    /* renamed from: c */
    protected List<Serializable> f11186c = Collections.synchronizedList(new ArrayList());

    /* renamed from: g */
    protected Executor f11190g = C3294l.m10655b();

    /* renamed from: h */
    protected Executor f11191h = C3294l.m10655b();

    private C3266h() {
        this.f11188e = null;
        if (this.f11188e == null) {
            this.f11188e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f11188e.start();
        }
        if (!this.f11188e.isAlive() || this.f11188e.getLooper() == null) {
            return;
        }
        this.f11189f = new Handler(this.f11188e.getLooper()) { // from class: com.tencent.open.b.h.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    C3266h.this.m10476b();
                } else if (i2 == 1001) {
                    C3266h.this.m10478d();
                }
                super.handleMessage(message);
            }
        };
    }

    /* renamed from: a */
    public static synchronized C3266h m10468a() {
        C3266h c3266h;
        synchronized (C3266h.class) {
            if (f11184a == null) {
                f11184a = new C3266h();
            }
            c3266h = f11184a;
        }
        return c3266h;
    }

    /* renamed from: b */
    protected void m10476b() {
    }

    /* renamed from: c */
    protected Map<String, String> m10477c() {
        List<Serializable> m10467b = C3265g.m10467b("report_via");
        if (m10467b != null) {
            this.f11187d.addAll(m10467b);
        }
        SLog.m10498d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f11187d.size());
        if (this.f11187d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f11187d) {
            JSONObject jSONObject = new JSONObject();
            C3261c c3261c = (C3261c) serializable;
            for (String str : c3261c.f11180a.keySet()) {
                try {
                    String str2 = c3261c.f11180a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    SLog.m10501e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.m10506v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap hashMap = new HashMap();
            hashMap.put("data", jSONObject2.toString());
            return hashMap;
        } catch (JSONException e3) {
            SLog.m10501e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
            return null;
        }
    }

    /* renamed from: d */
    protected void m10478d() {
        if (C3295m.m10688b(C3289g.m10603a())) {
            this.f11190g.execute(new Runnable() { // from class: com.tencent.open.b.h.3
                @Override // java.lang.Runnable
                public void run() {
                    int i2;
                    long j2;
                    long j3;
                    long j4;
                    long j5;
                    long j6;
                    boolean z;
                    InterfaceC3256g m10424b;
                    JSONObject m10696d;
                    int i3;
                    try {
                        Map<String, String> m10477c = C3266h.this.m10477c();
                        if (m10477c == null) {
                            return;
                        }
                        SLog.m10498d("openSDK_LOG.ReportManager", "-->doReportVia, params: " + m10477c.toString());
                        int m10462a = C3264f.m10462a();
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        int i4 = 0;
                        int i5 = 0;
                        do {
                            int i6 = i4 + 1;
                            try {
                                try {
                                    m10424b = C3255f.m10416a().m10424b("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", m10477c);
                                    SLog.m10502i("openSDK_LOG.ReportManager", "-->reportVia: statusCode " + m10424b.mo10413d());
                                    m10696d = C3295m.m10696d(m10424b.mo10410a());
                                    j3 = (long) m10424b.mo10412c();
                                    i2 = i6;
                                    j2 = m10424b.mo10411b();
                                } catch (SocketTimeoutException unused) {
                                    i2 = i6;
                                } catch (IOException e2) {
                                    e = e2;
                                    i2 = i6;
                                } catch (JSONException unused2) {
                                    i2 = i6;
                                }
                            } catch (Exception unused3) {
                                i4 = m10462a;
                                j2 = 0;
                                j3 = 0;
                                i5 = -6;
                            }
                            try {
                                try {
                                } catch (SocketTimeoutException unused4) {
                                    elapsedRealtime = SystemClock.elapsedRealtime();
                                    j2 = 0;
                                    j3 = 0;
                                    i4 = i2;
                                    i5 = -8;
                                } catch (IOException e3) {
                                    e = e3;
                                    i5 = HttpUtils.getErrorCodeFromException(e);
                                    j2 = 0;
                                    j3 = 0;
                                    i4 = i2;
                                }
                                if (m10424b.mo10413d() != 200) {
                                    i5 = m10424b.mo10413d();
                                    break;
                                }
                                try {
                                    i3 = m10696d.getInt("ret");
                                } catch (JSONException unused5) {
                                    i3 = -4;
                                }
                                if (i3 == 0 || j2 != 0) {
                                    j6 = elapsedRealtime;
                                    j4 = j2;
                                    j5 = j3;
                                    z = true;
                                    break;
                                }
                                i4 = i2;
                            } catch (JSONException unused6) {
                                j2 = 0;
                                j3 = 0;
                                i4 = i2;
                                i5 = -4;
                            }
                        } while (i4 < m10462a);
                        j6 = elapsedRealtime;
                        j4 = j2;
                        j5 = j3;
                        z = false;
                        C3266h.this.m10472a("mapp_apptrace_sdk", j6, j5, j4, i5, null, false);
                        if (z) {
                            C3265g.m10465a("report_via");
                        } else {
                            C3265g.m10466a("report_via", C3266h.this.f11187d);
                        }
                        C3266h.this.f11187d.clear();
                        SLog.m10502i("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z + " resultCode: " + i5);
                    } catch (Exception e4) {
                        SLog.m10501e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e4);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m10470a(final Bundle bundle, String str, final boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.m10506v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (m10475a("report_via", str) || z) {
            this.f11190g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", C3259a.m10432a(C3289g.m10603a()));
                        bundle2.putString(C3351bh.f11562N, C3262d.m10455a());
                        bundle2.putString("resolution", C3262d.m10456a(C3289g.m10603a()));
                        bundle2.putString("apn", C3259a.m10433b(C3289g.m10603a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, C3288f.m10596a().m10601c(C3289g.m10603a()));
                        bundle2.putString(C3351bh.f11561M, TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", C3295m.m10695d(C3289g.m10603a(), Constants.PACKAGE_QZONE));
                        bundle2.putString(Constants.PARAM_QQ_VER, C3295m.m10691c(C3289g.m10603a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", C3295m.m10698e(C3289g.m10603a(), C3289g.m10606b()));
                        bundle2.putString("packagename", C3289g.m10606b());
                        bundle2.putString(Constants.PARAM_APP_VER, C3295m.m10695d(C3289g.m10603a(), C3289g.m10606b()));
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                        }
                        C3266h.this.f11187d.add(new C3261c(bundle2));
                        int size = C3266h.this.f11187d.size();
                        int m10624a = C3291i.m10615a(C3289g.m10603a(), (String) null).m10624a("Agent_ReportTimeInterval");
                        if (m10624a == 0) {
                            m10624a = 10000;
                        }
                        if (!C3266h.this.m10474a("report_via", size) && !z) {
                            if (C3266h.this.f11189f.hasMessages(1001)) {
                                return;
                            }
                            Message obtain = Message.obtain();
                            obtain.what = 1001;
                            C3266h.this.f11189f.sendMessageDelayed(obtain, m10624a);
                            return;
                        }
                        C3266h.this.m10478d();
                        C3266h.this.f11189f.removeMessages(1001);
                    } catch (Exception e2) {
                        SLog.m10501e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    /* renamed from: a */
    public void m10471a(String str, long j2, long j3, long j4, int i2) {
        m10472a(str, j2, j3, j4, i2, "", false);
    }

    /* renamed from: a */
    public void m10472a(String str, long j2, long j3, long j4, int i2, String str2, boolean z) {
        SLog.m10506v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j2 + " | reqSize:" + j3 + " | rspSize: " + j4 + " | responseCode: " + i2 + " | detail: " + str2);
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0055, code lost:
    
        if (r5.f11185b.nextInt(100) < r6) goto L16;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0057, code lost:
    
        r2 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x003f, code lost:
    
        if (r5.f11185b.nextInt(100) < r6) goto L16;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean m10475a(java.lang.String r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "-->availableFrequency, report: "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = " | ext: "
            r0.append(r1)
            r0.append(r7)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.m10498d(r1, r0)
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r2 = 0
            if (r0 == 0) goto L26
            return r2
        L26:
            java.lang.String r0 = "report_cgi"
            boolean r0 = r6.equals(r0)
            r3 = 1
            r4 = 100
            if (r0 == 0) goto L43
            int r6 = java.lang.Integer.parseInt(r7)     // Catch: java.lang.Exception -> L42
            int r6 = r5.m10469a(r6)
            java.util.Random r7 = r5.f11185b
            int r7 = r7.nextInt(r4)
            if (r7 >= r6) goto L5b
            goto L57
        L42:
            return r2
        L43:
            java.lang.String r0 = "report_via"
            boolean r6 = r6.equals(r0)
            if (r6 == 0) goto L59
            int r6 = com.tencent.open.p212b.C3264f.m10463a(r7)
            java.util.Random r7 = r5.f11185b
            int r7 = r7.nextInt(r4)
            if (r7 >= r6) goto L5b
        L57:
            r2 = 1
            goto L5b
        L59:
            r6 = 100
        L5b:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r0 = "-->availableFrequency, result: "
            r7.append(r0)
            r7.append(r2)
            java.lang.String r0 = " | frequency: "
            r7.append(r0)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            com.tencent.open.log.SLog.m10498d(r1, r6)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.p212b.C3266h.m10475a(java.lang.String, java.lang.String):boolean");
    }

    /* JADX WARN: Code restructure failed: missing block: B:14:0x0033, code lost:
    
        if (r0 == 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:4:0x0019, code lost:
    
        if (r0 == 0) goto L6;
     */
    /* JADX WARN: Code restructure failed: missing block: B:5:0x001b, code lost:
    
        r0 = 5;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected boolean m10474a(java.lang.String r5, int r6) {
        /*
            r4 = this;
            java.lang.String r0 = "report_cgi"
            boolean r0 = r5.equals(r0)
            r1 = 5
            r2 = 0
            r3 = 0
            if (r0 == 0) goto L1d
            android.content.Context r0 = com.tencent.open.utils.C3289g.m10603a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.C3291i.m10615a(r0, r2)
            java.lang.String r2 = "Common_CGIReportMaxcount"
            int r0 = r0.m10624a(r2)
            if (r0 != 0) goto L37
        L1b:
            r0 = 5
            goto L37
        L1d:
            java.lang.String r0 = "report_via"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L36
            android.content.Context r0 = com.tencent.open.utils.C3289g.m10603a()
            com.tencent.open.utils.i r0 = com.tencent.open.utils.C3291i.m10615a(r0, r2)
            java.lang.String r2 = "Agent_ReportBatchCount"
            int r0 = r0.m10624a(r2)
            if (r0 != 0) goto L37
            goto L1b
        L36:
            r0 = 0
        L37:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "-->availableCount, report: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = " | dataSize: "
            r1.append(r5)
            r1.append(r6)
            java.lang.String r5 = " | maxcount: "
            r1.append(r5)
            r1.append(r0)
            java.lang.String r5 = r1.toString()
            java.lang.String r1 = "openSDK_LOG.ReportManager"
            com.tencent.open.log.SLog.m10498d(r1, r5)
            if (r6 < r0) goto L61
            r5 = 1
            return r5
        L61:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.open.p212b.C3266h.m10474a(java.lang.String, int):boolean");
    }

    /* renamed from: a */
    protected int m10469a(int i2) {
        if (i2 == 0) {
            int m10624a = C3291i.m10615a(C3289g.m10603a(), (String) null).m10624a("Common_CGIReportFrequencySuccess");
            if (m10624a == 0) {
                return 10;
            }
            return m10624a;
        }
        int m10624a2 = C3291i.m10615a(C3289g.m10603a(), (String) null).m10624a("Common_CGIReportFrequencyFailed");
        if (m10624a2 == 0) {
            return 100;
        }
        return m10624a2;
    }

    /* renamed from: a */
    public void m10473a(final String str, final Map<String, String> map) {
        if (C3295m.m10688b(C3289g.m10603a())) {
            C3294l.m10656b(new Runnable() { // from class: com.tencent.open.b.h.4
                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    try {
                        int m10462a = C3264f.m10462a();
                        if (m10462a == 0) {
                            m10462a = 3;
                        }
                        SLog.m10498d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + m10462a);
                        do {
                            i2++;
                            try {
                                SLog.m10502i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + C3255f.m10416a().m10420a(str, map).mo10413d());
                            } catch (SocketTimeoutException e2) {
                                SLog.m10501e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e2);
                            } catch (Exception e3) {
                                SLog.m10501e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e3);
                            }
                        } while (i2 < m10462a);
                    } catch (Exception e4) {
                        SLog.m10501e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e4);
                    }
                }
            });
        }
    }
}
