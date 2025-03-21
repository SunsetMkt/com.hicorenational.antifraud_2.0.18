package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.heytap.mcssdk.constant.C2084a;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.C3531d;
import java.util.ArrayList;
import java.util.List;

/* compiled from: SessionIdManager.java */
/* renamed from: com.umeng.analytics.pro.y */
/* loaded from: classes2.dex */
public class C3424y {

    /* renamed from: c */
    private static volatile C3424y f12272c;

    /* renamed from: a */
    private InterfaceC3422w f12273a = new C3423x();

    /* renamed from: b */
    private String f12274b;

    /* renamed from: d */
    private List<a> f12275d;

    /* renamed from: e */
    private String f12276e;

    /* compiled from: SessionIdManager.java */
    /* renamed from: com.umeng.analytics.pro.y$a */
    public interface a {
        /* renamed from: a */
        void mo11399a(String str, long j2, long j3, long j4);

        /* renamed from: a */
        void mo11400a(String str, String str2, long j2, long j3, long j4);
    }

    private C3424y() {
    }

    /* renamed from: a */
    public static C3424y m11419a() {
        if (f12272c == null) {
            synchronized (C3424y.class) {
                if (f12272c == null) {
                    f12272c = new C3424y();
                }
            }
        }
        return f12272c;
    }

    /* renamed from: f */
    private String m11421f(Context context) {
        try {
            SharedPreferences.Editor edit = PreferenceWrapper.getDefault(context).edit();
            edit.putString(C3420u.f12254d, m11434d(context));
            edit.commit();
        } catch (Exception unused) {
        }
        long m11423h = m11423h(context);
        long m11424i = m11424i(context);
        String str = this.f12274b;
        long m11388a = C3420u.m11388a(context);
        long j2 = m11388a * C2084a.f6136r;
        UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count 值完成，count次数：" + m11388a);
        if (!FieldManager.allow(C3531d.f12957E)) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation云控参数关闭。");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，终止checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>>*** 读取 foreground count druation值完成，无未处理check timer事件。");
        }
        m11420a(m11424i, m11423h, j2, str, false);
        this.f12274b = this.f12273a.mo11414a(context);
        m11420a(m11424i, m11423h, j2, str, true);
        this.f12273a.mo11416a(context, this.f12274b);
        return this.f12274b;
    }

    /* renamed from: g */
    private boolean m11422g(Context context) {
        return !TextUtils.isEmpty(this.f12274b) && C3408i.m11232a(context).m11244a(this.f12274b) > 0;
    }

    /* renamed from: h */
    private long m11423h(Context context) {
        return m11418a(context, C3420u.f12256f);
    }

    /* renamed from: i */
    private long m11424i(Context context) {
        return m11418a(context, C3420u.f12251a);
    }

    /* renamed from: j */
    private boolean m11425j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j2 = sharedPreferences.getLong(C3420u.f12255e, 0L);
            long j3 = sharedPreferences.getLong(C3420u.f12256f, 0L);
            if (FieldManager.allow(C3531d.f12957E) && j2 > 0 && j3 == 0) {
                long m11388a = C3420u.m11388a(appContext);
                if (m11388a > 0) {
                    long j4 = m11388a * C2084a.f6136r;
                    UMRTLog.m11555e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j3 = j2 + j4;
                }
            }
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j3 - j2));
            return this.f12273a.mo11417a(j2, j3);
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: b */
    public long m11430b() {
        return this.f12273a.mo11413a();
    }

    /* renamed from: c */
    public String m11433c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f12274b = m11421f(appContext);
        } catch (Exception unused) {
        }
        return this.f12274b;
    }

    /* renamed from: d */
    public String m11434d(Context context) {
        if (TextUtils.isEmpty(this.f12274b)) {
            try {
                this.f12274b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f12274b;
    }

    /* renamed from: e */
    public boolean m11435e(Context context) {
        if (TextUtils.isEmpty(this.f12274b)) {
            this.f12274b = m11434d(context);
        }
        return TextUtils.isEmpty(this.f12274b) || m11425j(context) || m11422g(context);
    }

    /* renamed from: b */
    public synchronized String m11431b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f12274b = m11434d(appContext);
        if (m11435e(appContext)) {
            try {
                this.f12274b = m11421f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f12274b;
    }

    /* renamed from: a */
    public void m11428a(long j2) {
        this.f12273a.mo11415a(j2);
    }

    /* renamed from: a */
    public String m11426a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String str = "";
        try {
            synchronized (C3424y.class) {
                str = PreferenceWrapper.getDefault(appContext).getString(C3420u.f12254d, "");
            }
        } catch (Exception unused) {
        }
        return str;
    }

    /* renamed from: b */
    public void m11432b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f12275d) == null || list.size() == 0) {
            return;
        }
        this.f12275d.remove(aVar);
    }

    /* renamed from: a */
    public String m11427a(Context context, long j2) {
        if (TextUtils.isEmpty(this.f12276e)) {
            String str = "SUB" + j2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f12276e = sb.toString();
        }
        return this.f12276e;
    }

    /* renamed from: a */
    private long m11418a(Context context, String str) {
        long j2;
        try {
            j2 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j2 = 0;
        }
        return j2 <= 0 ? System.currentTimeMillis() : j2;
    }

    /* renamed from: a */
    private void m11420a(long j2, long j3, long j4, String str, boolean z) {
        List<a> list = this.f12275d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.mo11400a(str, this.f12274b, j2, j3, j4);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.mo11399a(this.f12274b, j2, j3, j4);
                }
            }
        }
    }

    /* renamed from: a */
    public void m11429a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f12275d == null) {
            this.f12275d = new ArrayList();
        }
        if (this.f12275d.contains(aVar)) {
            return;
        }
        this.f12275d.add(aVar);
    }
}
