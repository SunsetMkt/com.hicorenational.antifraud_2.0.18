package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.bt;
import com.umeng.analytics.pro.ci;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.idtracking.e;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.internal.d;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import java.io.File;

/* JADX INFO: compiled from: NetWorkManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f7674b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7675c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f7676d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";
    String a;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f7678f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ImprintHandler f7679g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private e f7680h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private ImprintHandler.a f7681i;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Defcon f7683k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private long f7684l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f7685m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private int f7686n;
    private Context r;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final int f7677e = 1;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private ABTest f7682j = null;

    public c(Context context) {
        this.f7680h = null;
        this.f7681i = null;
        this.f7683k = null;
        this.f7684l = 0L;
        this.f7685m = 0;
        this.f7686n = 0;
        this.a = null;
        this.r = context;
        this.f7681i = ImprintHandler.getImprintService(this.r).c();
        this.f7683k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.f7684l = sharedPreferences.getLong(o, 0L);
        this.f7685m = sharedPreferences.getInt(p, 0);
        this.f7686n = sharedPreferences.getInt(q, 0);
        this.a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        this.f7679g = ImprintHandler.getImprintService(this.r);
        this.f7679g.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f7683k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.f7680h = e.a(this.r);
        }
        this.f7678f = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f7678f.a(StatTracer.getInstance(this.r));
    }

    public boolean a(File file) {
        if (file == null) {
            return false;
        }
        try {
            byte[] byteArray = UMFrUtils.toByteArray(file.getPath());
            if (byteArray == null) {
                return false;
            }
            String name = file.getName();
            if (TextUtils.isEmpty(name)) {
                return false;
            }
            com.umeng.commonsdk.statistics.internal.a aVarA = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            aVarA.e(name);
            boolean zA = aVarA.a(name);
            boolean zB = aVarA.b(name);
            boolean zC = aVarA.c(name);
            boolean zD = aVarA.d(name);
            String strD = com.umeng.commonsdk.stateless.d.d(name);
            byte[] bArrA = this.f7678f.a(byteArray, zA, zC, !TextUtils.isEmpty(strD) ? com.umeng.commonsdk.stateless.d.c(strD) : zD ? UMServerURL.SILENT_HEART_BEAT : zC ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int iA = bArrA == null ? 1 : a(bArrA);
            if (UMConfigure.isDebugLog()) {
                if (zD && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (zC && iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (zB && iA == 2) {
                    MLog.d("\u672c\u6b21\u542f\u52a8\u6570\u636e: \u53d1\u9001\u6210\u529f!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (zA && iA == 2) {
                    MLog.d("\u666e\u901a\u7edf\u8ba1\u6570\u636e: \u53d1\u9001\u6210\u529f!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (iA == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (iA != 1) {
                if (iA == 2) {
                    if (this.f7680h != null) {
                        this.f7680h.e();
                    }
                    StatTracer.getInstance(this.r).saveSate();
                    if (zD) {
                        String strImprintProperty = UMEnvelopeBuild.imprintProperty(this.r, "iss", "");
                        if (!TextUtils.isEmpty(strImprintProperty)) {
                            if ("1".equalsIgnoreCase(strImprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u66f4\u65b0\u9759\u9ed8\u5fc3\u8df3\u6700\u540e\u4e00\u6b21\u6210\u529f\u8bf7\u6c42\u65f6\u95f4.");
                                com.umeng.commonsdk.utils.c.a(this.r, System.currentTimeMillis());
                            } else if ("0".equalsIgnoreCase(strImprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u9759\u9ed8\u6a21\u5f0f -> \u6b63\u5e38\u6a21\u5f0f\u3002\u91cd\u7f6e last req time");
                                com.umeng.commonsdk.utils.c.a(this.r, 0L);
                                com.umeng.commonsdk.utils.c.d(this.r);
                            }
                        }
                    }
                } else if (iA == 3) {
                    StatTracer.getInstance(this.r).saveSate();
                    if (zC) {
                        FieldManager.a().a(this.r);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> \u96f6\u53f7\u62a5\u6587\u5e94\u7b54\u5185\u5bb9\u62a5\u9519!!! \uff0c\u7279\u6b8a\u5904\u7406!\uff0c\u7ee7\u7eed\u6b63\u5e38\u6d41\u7a0b\u3002");
                        UMWorkDispatch.sendEvent(this.r, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(this.r).a(), null);
                        return true;
                    }
                }
            }
            return iA == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
            return false;
        }
    }

    private int a(byte[] bArr) {
        Response response = new Response();
        try {
            new bt(new ci.a()).a(response, bArr);
            if (response.resp_code == 1) {
                this.f7679g.b(response.getImprint());
                this.f7679g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
