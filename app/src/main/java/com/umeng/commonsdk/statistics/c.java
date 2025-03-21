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

/* compiled from: NetWorkManager.java */
/* loaded from: classes2.dex */
public class c {

    /* renamed from: b, reason: collision with root package name */
    private static final int f10881b = 1;

    /* renamed from: c, reason: collision with root package name */
    private static final int f10882c = 2;

    /* renamed from: d, reason: collision with root package name */
    private static final int f10883d = 3;
    private static final String o = "thtstart";
    private static final String p = "gkvc";
    private static final String q = "ekvc";

    /* renamed from: a, reason: collision with root package name */
    String f10884a;

    /* renamed from: f, reason: collision with root package name */
    private com.umeng.commonsdk.statistics.internal.c f10886f;

    /* renamed from: g, reason: collision with root package name */
    private ImprintHandler f10887g;

    /* renamed from: h, reason: collision with root package name */
    private e f10888h;

    /* renamed from: i, reason: collision with root package name */
    private ImprintHandler.a f10889i;

    /* renamed from: k, reason: collision with root package name */
    private Defcon f10891k;

    /* renamed from: l, reason: collision with root package name */
    private long f10892l;

    /* renamed from: m, reason: collision with root package name */
    private int f10893m;
    private int n;
    private Context r;

    /* renamed from: e, reason: collision with root package name */
    private final int f10885e = 1;

    /* renamed from: j, reason: collision with root package name */
    private ABTest f10890j = null;

    public c(Context context) {
        this.f10888h = null;
        this.f10889i = null;
        this.f10891k = null;
        this.f10892l = 0L;
        this.f10893m = 0;
        this.n = 0;
        this.f10884a = null;
        this.r = context;
        this.f10889i = ImprintHandler.getImprintService(this.r).c();
        this.f10891k = Defcon.getService(this.r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.r);
        this.f10892l = sharedPreferences.getLong(o, 0L);
        this.f10893m = sharedPreferences.getInt(p, 0);
        this.n = sharedPreferences.getInt(q, 0);
        this.f10884a = UMEnvelopeBuild.imprintProperty(this.r, "track_list", null);
        this.f10887g = ImprintHandler.getImprintService(this.r);
        this.f10887g.a(new d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.d
            public void onImprintChanged(ImprintHandler.a aVar) {
                c.this.f10891k.onImprintChanged(aVar);
                c cVar = c.this;
                cVar.f10884a = UMEnvelopeBuild.imprintProperty(cVar.r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.r)) {
            this.f10888h = e.a(this.r);
        }
        this.f10886f = new com.umeng.commonsdk.statistics.internal.c(this.r);
        this.f10886f.a(StatTracer.getInstance(this.r));
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
            com.umeng.commonsdk.statistics.internal.a a2 = com.umeng.commonsdk.statistics.internal.a.a(this.r);
            a2.e(name);
            boolean a3 = a2.a(name);
            boolean b2 = a2.b(name);
            boolean c2 = a2.c(name);
            boolean d2 = a2.d(name);
            String d3 = com.umeng.commonsdk.stateless.d.d(name);
            byte[] a4 = this.f10886f.a(byteArray, a3, c2, !TextUtils.isEmpty(d3) ? com.umeng.commonsdk.stateless.d.c(d3) : d2 ? UMServerURL.SILENT_HEART_BEAT : c2 ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int a5 = a4 == null ? 1 : a(a4);
            if (UMConfigure.isDebugLog()) {
                if (d2 && a5 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (c2 && a5 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (b2 && a5 == 2) {
                    MLog.d("本次启动数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (a3 && a5 == 2) {
                    MLog.d("普通统计数据: 发送成功!");
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (a5 == 2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (a5 != 1) {
                if (a5 == 2) {
                    if (this.f10888h != null) {
                        this.f10888h.e();
                    }
                    StatTracer.getInstance(this.r).saveSate();
                    if (d2) {
                        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.r, "iss", "");
                        if (!TextUtils.isEmpty(imprintProperty)) {
                            if ("1".equalsIgnoreCase(imprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                                com.umeng.commonsdk.utils.c.a(this.r, System.currentTimeMillis());
                            } else if ("0".equalsIgnoreCase(imprintProperty)) {
                                UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                                com.umeng.commonsdk.utils.c.a(this.r, 0L);
                                com.umeng.commonsdk.utils.c.d(this.r);
                            }
                        }
                    }
                } else if (a5 == 3) {
                    StatTracer.getInstance(this.r).saveSate();
                    if (c2) {
                        FieldManager.a().a(this.r);
                        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                        UMWorkDispatch.sendEvent(this.r, com.umeng.commonsdk.internal.a.s, com.umeng.commonsdk.internal.b.a(this.r).a(), null);
                        return true;
                    }
                }
            }
            return a5 == 2;
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
                this.f10887g.b(response.getImprint());
                this.f10887g.d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
