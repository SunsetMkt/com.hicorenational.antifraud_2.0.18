package com.umeng.commonsdk.statistics;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3363bt;
import com.umeng.analytics.pro.C3379ci;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMFrUtils;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.internal.C3470a;
import com.umeng.commonsdk.internal.C3471b;
import com.umeng.commonsdk.internal.crash.UMCrashManager;
import com.umeng.commonsdk.stateless.C3492d;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.idtracking.C3505e;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.C3513a;
import com.umeng.commonsdk.statistics.internal.C3515c;
import com.umeng.commonsdk.statistics.internal.InterfaceC3516d;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.statistics.internal.StatTracer;
import com.umeng.commonsdk.statistics.noise.ABTest;
import com.umeng.commonsdk.statistics.noise.Defcon;
import com.umeng.commonsdk.statistics.proto.Response;
import com.umeng.commonsdk.utils.C3530c;
import java.io.File;

/* compiled from: NetWorkManager.java */
/* renamed from: com.umeng.commonsdk.statistics.c */
/* loaded from: classes2.dex */
public class C3495c {

    /* renamed from: b */
    private static final int f12727b = 1;

    /* renamed from: c */
    private static final int f12728c = 2;

    /* renamed from: d */
    private static final int f12729d = 3;

    /* renamed from: o */
    private static final String f12730o = "thtstart";

    /* renamed from: p */
    private static final String f12731p = "gkvc";

    /* renamed from: q */
    private static final String f12732q = "ekvc";

    /* renamed from: a */
    String f12733a;

    /* renamed from: f */
    private C3515c f12735f;

    /* renamed from: g */
    private ImprintHandler f12736g;

    /* renamed from: h */
    private C3505e f12737h;

    /* renamed from: i */
    private ImprintHandler.C3500a f12738i;

    /* renamed from: k */
    private Defcon f12740k;

    /* renamed from: l */
    private long f12741l;

    /* renamed from: m */
    private int f12742m;

    /* renamed from: n */
    private int f12743n;

    /* renamed from: r */
    private Context f12744r;

    /* renamed from: e */
    private final int f12734e = 1;

    /* renamed from: j */
    private ABTest f12739j = null;

    public C3495c(Context context) {
        this.f12737h = null;
        this.f12738i = null;
        this.f12740k = null;
        this.f12741l = 0L;
        this.f12742m = 0;
        this.f12743n = 0;
        this.f12733a = null;
        this.f12744r = context;
        this.f12738i = ImprintHandler.getImprintService(this.f12744r).m11839c();
        this.f12740k = Defcon.getService(this.f12744r);
        SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(this.f12744r);
        this.f12741l = sharedPreferences.getLong(f12730o, 0L);
        this.f12742m = sharedPreferences.getInt(f12731p, 0);
        this.f12743n = sharedPreferences.getInt(f12732q, 0);
        this.f12733a = UMEnvelopeBuild.imprintProperty(this.f12744r, "track_list", null);
        this.f12736g = ImprintHandler.getImprintService(this.f12744r);
        this.f12736g.m11833a(new InterfaceC3516d() { // from class: com.umeng.commonsdk.statistics.c.1
            @Override // com.umeng.commonsdk.statistics.internal.InterfaceC3516d
            public void onImprintChanged(ImprintHandler.C3500a c3500a) {
                C3495c.this.f12740k.onImprintChanged(c3500a);
                C3495c c3495c = C3495c.this;
                c3495c.f12733a = UMEnvelopeBuild.imprintProperty(c3495c.f12744r, "track_list", null);
            }
        });
        if (!UMConfigure.needSendZcfgEnv(this.f12744r)) {
            this.f12737h = C3505e.m11856a(this.f12744r);
        }
        this.f12735f = new C3515c(this.f12744r);
        this.f12735f.m11893a(StatTracer.getInstance(this.f12744r));
    }

    /* renamed from: a */
    public boolean m11737a(File file) {
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
            C3513a m11877a = C3513a.m11877a(this.f12744r);
            m11877a.m11886e(name);
            boolean m11881a = m11877a.m11881a(name);
            boolean m11883b = m11877a.m11883b(name);
            boolean m11884c = m11877a.m11884c(name);
            boolean m11885d = m11877a.m11885d(name);
            String m11714d = C3492d.m11714d(name);
            byte[] m11895a = this.f12735f.m11895a(byteArray, m11881a, m11884c, !TextUtils.isEmpty(m11714d) ? C3492d.m11712c(m11714d) : m11885d ? UMServerURL.SILENT_HEART_BEAT : m11884c ? UMServerURL.ZCFG_PATH : UMServerURL.PATH_ANALYTICS);
            int m11734a = m11895a == null ? 1 : m11734a(m11895a);
            if (UMConfigure.isDebugLog()) {
                if (m11885d && m11734a == 2) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "heart beat req: succeed.");
                } else if (m11884c && m11734a == 2) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "Zero req: succeed.");
                } else if (m11883b && m11734a == 2) {
                    MLog.m11738d("本次启动数据: 发送成功!");
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "Send instant data: succeed.");
                } else if (m11881a && m11734a == 2) {
                    MLog.m11738d("普通统计数据: 发送成功!");
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "Send analytics data: succeed.");
                } else if (m11734a == 2) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "Inner req: succeed.");
                }
            }
            if (m11734a != 1) {
                if (m11734a == 2) {
                    if (this.f12737h != null) {
                        this.f12737h.m11867e();
                    }
                    StatTracer.getInstance(this.f12744r).saveSate();
                    if (m11885d) {
                        String imprintProperty = UMEnvelopeBuild.imprintProperty(this.f12744r, "iss", "");
                        if (!TextUtils.isEmpty(imprintProperty)) {
                            if ("1".equalsIgnoreCase(imprintProperty)) {
                                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 更新静默心跳最后一次成功请求时间.");
                                C3530c.m12098a(this.f12744r, System.currentTimeMillis());
                            } else if ("0".equalsIgnoreCase(imprintProperty)) {
                                UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 静默模式 -> 正常模式。重置 last req time");
                                C3530c.m12098a(this.f12744r, 0L);
                                C3530c.m12103d(this.f12744r);
                            }
                        }
                    }
                } else if (m11734a == 3) {
                    StatTracer.getInstance(this.f12744r).saveSate();
                    if (m11884c) {
                        FieldManager.m11529a().m11531a(this.f12744r);
                        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> 零号报文应答内容报错!!! ，特殊处理!，继续正常流程。");
                        UMWorkDispatch.sendEvent(this.f12744r, C3470a.f12605s, C3471b.m11589a(this.f12744r).m11590a(), null);
                        return true;
                    }
                }
            }
            return m11734a == 2;
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f12744r, th);
            return false;
        }
    }

    /* renamed from: a */
    private int m11734a(byte[] bArr) {
        Response response = new Response();
        try {
            new C3363bt(new C3379ci.a()).m11061a(response, bArr);
            if (response.resp_code == 1) {
                this.f12736g.m11838b(response.getImprint());
                this.f12736g.m11840d();
            }
        } catch (Throwable th) {
            UMCrashManager.reportCrash(this.f12744r, th);
        }
        return response.resp_code == 1 ? 2 : 3;
    }
}
