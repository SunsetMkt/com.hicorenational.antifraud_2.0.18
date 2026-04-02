package com.tencent.open.b;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.connect.common.Constants;
import com.tencent.open.log.SLog;
import com.tencent.open.utils.HttpUtils;
import com.tencent.open.utils.i;
import com.tencent.open.utils.l;
import com.tencent.open.utils.m;
import com.umeng.analytics.pro.bh;
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

/* JADX INFO: compiled from: ProGuard */
/* JADX INFO: loaded from: classes2.dex */
public class h {
    protected static h a;

    /* JADX INFO: renamed from: e */
    protected HandlerThread f6831e;

    /* JADX INFO: renamed from: f */
    protected Handler f6832f;

    /* JADX INFO: renamed from: b */
    protected Random f6828b = new SecureRandom();

    /* JADX INFO: renamed from: d */
    protected List<Serializable> f6830d = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: c */
    protected List<Serializable> f6829c = Collections.synchronizedList(new ArrayList());

    /* JADX INFO: renamed from: g */
    protected Executor f6833g = l.b();

    /* JADX INFO: renamed from: h */
    protected Executor f6834h = l.b();

    /* JADX INFO: renamed from: com.tencent.open.b.h$1 */
    /* JADX INFO: compiled from: ProGuard */
    class AnonymousClass1 extends Handler {
        AnonymousClass1(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            int i2 = message.what;
            if (i2 == 1000) {
                h.this.b();
            } else if (i2 == 1001) {
                h.this.d();
            }
            super.handleMessage(message);
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.b.h$2 */
    /* JADX INFO: compiled from: ProGuard */
    class AnonymousClass2 implements Runnable {
        final /* synthetic */ Bundle a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ boolean f6835b;

        AnonymousClass2(Bundle bundle, boolean z) {
            bundle = bundle;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Bundle bundle = new Bundle();
                bundle.putString("uin", Constants.DEFAULT_UIN);
                bundle.putString("platform", "1");
                bundle.putString("os_ver", Build.VERSION.RELEASE);
                bundle.putString("position", "");
                bundle.putString("network", a.a(com.tencent.open.utils.g.a()));
                bundle.putString(bh.N, d.a());
                bundle.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                bundle.putString("apn", a.b(com.tencent.open.utils.g.a()));
                bundle.putString(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
                bundle.putString(bh.M, TimeZone.getDefault().getID());
                bundle.putString("sdk_ver", Constants.SDK_VERSION);
                bundle.putString("qz_ver", m.d(com.tencent.open.utils.g.a(), Constants.PACKAGE_QZONE));
                bundle.putString(Constants.PARAM_QQ_VER, m.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                bundle.putString("qua", m.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                bundle.putString("packagename", com.tencent.open.utils.g.b());
                bundle.putString(Constants.PARAM_APP_VER, m.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                if (bundle != null) {
                    bundle.putAll(bundle);
                }
                h.this.f6830d.add(new c(bundle));
                int size = h.this.f6830d.size();
                int iA = i.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                if (iA == 0) {
                    iA = 10000;
                }
                if (!h.this.a("report_via", size) && !z) {
                    if (h.this.f6832f.hasMessages(1001)) {
                        return;
                    }
                    Message messageObtain = Message.obtain();
                    messageObtain.what = 1001;
                    h.this.f6832f.sendMessageDelayed(messageObtain, iA);
                    return;
                }
                h.this.d();
                h.this.f6832f.removeMessages(1001);
            } catch (Exception e2) {
                SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.b.h$3 */
    /* JADX INFO: compiled from: ProGuard */
    class AnonymousClass3 implements Runnable {
        AnonymousClass3() {
        }

        @Override // java.lang.Runnable
        public void run() throws JSONException {
            int i2;
            long jB;
            long jC;
            long j2;
            long j3;
            long j4;
            boolean z;
            com.tencent.open.a.g gVarB;
            JSONObject jSONObjectD;
            int i3;
            try {
                Map<String, String> mapC = h.this.c();
                if (mapC == null) {
                    return;
                }
                SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, params: " + mapC.toString());
                int iA = f.a();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                int i4 = 0;
                int errorCodeFromException = 0;
                do {
                    int i5 = i4 + 1;
                    try {
                        try {
                            gVarB = com.tencent.open.a.f.a().b("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", mapC);
                            SLog.i("openSDK_LOG.ReportManager", "-->reportVia: statusCode " + gVarB.d());
                            jSONObjectD = m.d(gVarB.a());
                            jC = (long) gVarB.c();
                            i2 = i5;
                            jB = gVarB.b();
                        } catch (SocketTimeoutException unused) {
                            i2 = i5;
                        } catch (IOException e2) {
                            e = e2;
                            i2 = i5;
                        } catch (JSONException unused2) {
                            i2 = i5;
                        }
                        try {
                            try {
                            } catch (SocketTimeoutException unused3) {
                                jElapsedRealtime = SystemClock.elapsedRealtime();
                                jB = 0;
                                jC = 0;
                                i4 = i2;
                                errorCodeFromException = -8;
                            } catch (IOException e3) {
                                e = e3;
                                errorCodeFromException = HttpUtils.getErrorCodeFromException(e);
                                jB = 0;
                                jC = 0;
                            }
                            if (gVarB.d() != 200) {
                                errorCodeFromException = gVarB.d();
                                break;
                            }
                            try {
                                i3 = jSONObjectD.getInt("ret");
                            } catch (JSONException unused4) {
                                i3 = -4;
                            }
                            if (i3 == 0 || jB != 0) {
                                j4 = jElapsedRealtime;
                                j2 = jB;
                                j3 = jC;
                                z = true;
                                break;
                            }
                            i4 = i2;
                        } catch (JSONException unused5) {
                            jB = 0;
                            jC = 0;
                            i4 = i2;
                            errorCodeFromException = -4;
                        }
                    } catch (Exception unused6) {
                        i4 = iA;
                        jB = 0;
                        jC = 0;
                        errorCodeFromException = -6;
                    }
                } while (i4 < iA);
                j4 = jElapsedRealtime;
                j2 = jB;
                j3 = jC;
                z = false;
                h.this.a("mapp_apptrace_sdk", j4, j3, j2, errorCodeFromException, null, false);
                if (z) {
                    g.a("report_via");
                } else {
                    g.a("report_via", h.this.f6830d);
                }
                h.this.f6830d.clear();
                SLog.i("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z + " resultCode: " + errorCodeFromException);
            } catch (Exception e4) {
                SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e4);
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.open.b.h$4 */
    /* JADX INFO: compiled from: ProGuard */
    class AnonymousClass4 implements Runnable {
        final /* synthetic */ String a;

        /* JADX INFO: renamed from: b */
        final /* synthetic */ Map f6837b;

        AnonymousClass4(String str, Map map) {
            str = str;
            map = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int i2 = 0;
            try {
                int iA = f.a();
                if (iA == 0) {
                    iA = 3;
                }
                SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + iA);
                do {
                    i2++;
                    try {
                        SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.f.a().a(str, map).d());
                    } catch (SocketTimeoutException e2) {
                        SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e2);
                    } catch (Exception e3) {
                        SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e3);
                    }
                } while (i2 < iA);
            } catch (Exception e4) {
                SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e4);
            }
        }
    }

    private h() {
        this.f6831e = null;
        if (this.f6831e == null) {
            this.f6831e = new HandlerThread("opensdk.report.handlerthread", 10);
            this.f6831e.start();
        }
        if (!this.f6831e.isAlive() || this.f6831e.getLooper() == null) {
            return;
        }
        this.f6832f = new Handler(this.f6831e.getLooper()) { // from class: com.tencent.open.b.h.1
            AnonymousClass1(Looper looper) {
                super(looper);
            }

            @Override // android.os.Handler
            public void handleMessage(Message message) {
                int i2 = message.what;
                if (i2 == 1000) {
                    h.this.b();
                } else if (i2 == 1001) {
                    h.this.d();
                }
                super.handleMessage(message);
            }
        };
    }

    public static synchronized h a() {
        if (a == null) {
            a = new h();
        }
        return a;
    }

    protected void b() {
    }

    protected Map<String, String> c() {
        List<Serializable> listB = g.b("report_via");
        if (listB != null) {
            this.f6830d.addAll(listB);
        }
        SLog.d("openSDK_LOG.ReportManager", "-->prepareViaData, mViaList size: " + this.f6830d.size());
        if (this.f6830d.size() == 0) {
            return null;
        }
        JSONArray jSONArray = new JSONArray();
        for (Serializable serializable : this.f6830d) {
            JSONObject jSONObject = new JSONObject();
            c cVar = (c) serializable;
            for (String str : cVar.a.keySet()) {
                try {
                    String str2 = cVar.a.get(str);
                    if (str2 == null) {
                        str2 = "";
                    }
                    jSONObject.put(str, str2);
                } catch (JSONException e2) {
                    SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e2);
                }
            }
            jSONArray.put(jSONObject);
        }
        SLog.v("openSDK_LOG.ReportManager", "-->prepareViaData, JSONArray array: " + jSONArray.toString());
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("data", jSONArray);
            HashMap map = new HashMap();
            map.put("data", jSONObject2.toString());
            return map;
        } catch (JSONException e3) {
            SLog.e("openSDK_LOG.ReportManager", "-->prepareViaData, put bundle to json array exception", e3);
            return null;
        }
    }

    protected void d() {
        if (m.b(com.tencent.open.utils.g.a())) {
            this.f6833g.execute(new Runnable() { // from class: com.tencent.open.b.h.3
                AnonymousClass3() {
                }

                @Override // java.lang.Runnable
                public void run() throws JSONException {
                    int i2;
                    long jB;
                    long jC;
                    long j2;
                    long j3;
                    long j4;
                    boolean z;
                    com.tencent.open.a.g gVarB;
                    JSONObject jSONObjectD;
                    int i3;
                    try {
                        Map<String, String> mapC = h.this.c();
                        if (mapC == null) {
                            return;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->doReportVia, params: " + mapC.toString());
                        int iA = f.a();
                        long jElapsedRealtime = SystemClock.elapsedRealtime();
                        int i4 = 0;
                        int errorCodeFromException = 0;
                        do {
                            int i5 = i4 + 1;
                            try {
                                try {
                                    gVarB = com.tencent.open.a.f.a().b("https://appsupport.qq.com/cgi-bin/appstage/mstats_batch_report", mapC);
                                    SLog.i("openSDK_LOG.ReportManager", "-->reportVia: statusCode " + gVarB.d());
                                    jSONObjectD = m.d(gVarB.a());
                                    jC = (long) gVarB.c();
                                    i2 = i5;
                                    jB = gVarB.b();
                                } catch (SocketTimeoutException unused) {
                                    i2 = i5;
                                } catch (IOException e2) {
                                    e = e2;
                                    i2 = i5;
                                } catch (JSONException unused2) {
                                    i2 = i5;
                                }
                                try {
                                    try {
                                    } catch (SocketTimeoutException unused3) {
                                        jElapsedRealtime = SystemClock.elapsedRealtime();
                                        jB = 0;
                                        jC = 0;
                                        i4 = i2;
                                        errorCodeFromException = -8;
                                    } catch (IOException e3) {
                                        e = e3;
                                        errorCodeFromException = HttpUtils.getErrorCodeFromException(e);
                                        jB = 0;
                                        jC = 0;
                                    }
                                    if (gVarB.d() != 200) {
                                        errorCodeFromException = gVarB.d();
                                        break;
                                    }
                                    try {
                                        i3 = jSONObjectD.getInt("ret");
                                    } catch (JSONException unused4) {
                                        i3 = -4;
                                    }
                                    if (i3 == 0 || jB != 0) {
                                        j4 = jElapsedRealtime;
                                        j2 = jB;
                                        j3 = jC;
                                        z = true;
                                        break;
                                    }
                                    i4 = i2;
                                } catch (JSONException unused5) {
                                    jB = 0;
                                    jC = 0;
                                    i4 = i2;
                                    errorCodeFromException = -4;
                                }
                            } catch (Exception unused6) {
                                i4 = iA;
                                jB = 0;
                                jC = 0;
                                errorCodeFromException = -6;
                            }
                        } while (i4 < iA);
                        j4 = jElapsedRealtime;
                        j2 = jB;
                        j3 = jC;
                        z = false;
                        h.this.a("mapp_apptrace_sdk", j4, j3, j2, errorCodeFromException, null, false);
                        if (z) {
                            g.a("report_via");
                        } else {
                            g.a("report_via", h.this.f6830d);
                        }
                        h.this.f6830d.clear();
                        SLog.i("openSDK_LOG.ReportManager", "-->doReportVia, uploadSuccess: " + z + " resultCode: " + errorCodeFromException);
                    } catch (Exception e4) {
                        SLog.e("openSDK_LOG.ReportManager", "-->doReportVia, exception in serial executor.", e4);
                    }
                }
            });
        }
    }

    public void a(Bundle bundle, String str, boolean z) {
        if (bundle == null) {
            return;
        }
        SLog.v("openSDK_LOG.ReportManager", "-->reportVia, bundle: " + bundle.toString());
        if (a("report_via", str) || z) {
            this.f6833g.execute(new Runnable() { // from class: com.tencent.open.b.h.2
                final /* synthetic */ Bundle a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ boolean f6835b;

                AnonymousClass2(Bundle bundle2, boolean z2) {
                    bundle = bundle2;
                    z = z2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Bundle bundle2 = new Bundle();
                        bundle2.putString("uin", Constants.DEFAULT_UIN);
                        bundle2.putString("platform", "1");
                        bundle2.putString("os_ver", Build.VERSION.RELEASE);
                        bundle2.putString("position", "");
                        bundle2.putString("network", a.a(com.tencent.open.utils.g.a()));
                        bundle2.putString(bh.N, d.a());
                        bundle2.putString("resolution", d.a(com.tencent.open.utils.g.a()));
                        bundle2.putString("apn", a.b(com.tencent.open.utils.g.a()));
                        bundle2.putString(Constants.PARAM_MODEL_NAME, com.tencent.open.utils.f.a().c(com.tencent.open.utils.g.a()));
                        bundle2.putString(bh.M, TimeZone.getDefault().getID());
                        bundle2.putString("sdk_ver", Constants.SDK_VERSION);
                        bundle2.putString("qz_ver", m.d(com.tencent.open.utils.g.a(), Constants.PACKAGE_QZONE));
                        bundle2.putString(Constants.PARAM_QQ_VER, m.c(com.tencent.open.utils.g.a(), "com.tencent.mobileqq"));
                        bundle2.putString("qua", m.e(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        bundle2.putString("packagename", com.tencent.open.utils.g.b());
                        bundle2.putString(Constants.PARAM_APP_VER, m.d(com.tencent.open.utils.g.a(), com.tencent.open.utils.g.b()));
                        if (bundle != null) {
                            bundle2.putAll(bundle);
                        }
                        h.this.f6830d.add(new c(bundle2));
                        int size = h.this.f6830d.size();
                        int iA = i.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportTimeInterval");
                        if (iA == 0) {
                            iA = 10000;
                        }
                        if (!h.this.a("report_via", size) && !z) {
                            if (h.this.f6832f.hasMessages(1001)) {
                                return;
                            }
                            Message messageObtain = Message.obtain();
                            messageObtain.what = 1001;
                            h.this.f6832f.sendMessageDelayed(messageObtain, iA);
                            return;
                        }
                        h.this.d();
                        h.this.f6832f.removeMessages(1001);
                    } catch (Exception e2) {
                        SLog.e("openSDK_LOG.ReportManager", "--> reporVia, exception in sub thread.", e2);
                    }
                }
            });
        }
    }

    public void a(String str, long j2, long j3, long j4, int i2) {
        a(str, j2, j3, j4, i2, "", false);
    }

    public void a(String str, long j2, long j3, long j4, int i2, String str2, boolean z) {
        SLog.v("openSDK_LOG.ReportManager", "-->reportCgi, command: " + str + " | startTime: " + j2 + " | reqSize:" + j3 + " | rspSize: " + j4 + " | responseCode: " + i2 + " | detail: " + str2);
    }

    /* JADX WARN: Removed duplicated region for block: B:38:0x0057 A[PHI: r6
  0x0057: PHI (r6v5 int) = (r6v2 int), (r6v8 int) binds: [B:31:0x003f, B:37:0x0055] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(String str, String str2) {
        int iA;
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, report: " + str + " | ext: " + str2);
        boolean z = false;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.equals("report_cgi")) {
            try {
                iA = a(Integer.parseInt(str2));
                if (this.f6828b.nextInt(100) < iA) {
                    z = true;
                }
            } catch (Exception unused) {
                return false;
            }
        } else if (str.equals("report_via")) {
            iA = f.a(str2);
            if (this.f6828b.nextInt(100) < iA) {
            }
        } else {
            iA = 100;
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableFrequency, result: " + z + " | frequency: " + iA);
        return z;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x001b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected boolean a(String str, int i2) {
        int iA;
        if (str.equals("report_cgi")) {
            iA = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportMaxcount");
            if (iA == 0) {
                iA = 5;
            }
        } else if (str.equals("report_via")) {
            iA = i.a(com.tencent.open.utils.g.a(), (String) null).a("Agent_ReportBatchCount");
            if (iA == 0) {
            }
        } else {
            iA = 0;
        }
        SLog.d("openSDK_LOG.ReportManager", "-->availableCount, report: " + str + " | dataSize: " + i2 + " | maxcount: " + iA);
        return i2 >= iA;
    }

    protected int a(int i2) {
        if (i2 == 0) {
            int iA = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencySuccess");
            if (iA == 0) {
                return 10;
            }
            return iA;
        }
        int iA2 = i.a(com.tencent.open.utils.g.a(), (String) null).a("Common_CGIReportFrequencyFailed");
        if (iA2 == 0) {
            return 100;
        }
        return iA2;
    }

    public void a(String str, Map<String, String> map) {
        if (m.b(com.tencent.open.utils.g.a())) {
            l.b(new Runnable() { // from class: com.tencent.open.b.h.4
                final /* synthetic */ String a;

                /* JADX INFO: renamed from: b */
                final /* synthetic */ Map f6837b;

                AnonymousClass4(String str2, Map map2) {
                    str = str2;
                    map = map2;
                }

                @Override // java.lang.Runnable
                public void run() {
                    int i2 = 0;
                    try {
                        int iA = f.a();
                        if (iA == 0) {
                            iA = 3;
                        }
                        SLog.d("openSDK_LOG.ReportManager", "-->httpRequest, retryCount: " + iA);
                        do {
                            i2++;
                            try {
                                SLog.i("openSDK_LOG.ReportManager", "-->httpRequest, statusCode: " + com.tencent.open.a.f.a().a(str, map).d());
                            } catch (SocketTimeoutException e2) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest SocketTimeoutException:", e2);
                            } catch (Exception e3) {
                                SLog.e("openSDK_LOG.ReportManager", "-->ReportCenter httpRequest Exception:", e3);
                            }
                        } while (i2 < iA);
                    } catch (Exception e4) {
                        SLog.e("openSDK_LOG.ReportManager", "-->httpRequest, exception in serial executor:", e4);
                    }
                }
            });
        }
    }
}
