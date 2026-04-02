package com.umeng.analytics.pro;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.commonsdk.config.FieldManager;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: SessionIdManager.java */
/* JADX INFO: loaded from: classes2.dex */
public class y {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile y f7399c;
    private w a = new x();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f7400b;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private List<a> f7401d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f7402e;

    /* JADX INFO: compiled from: SessionIdManager.java */
    public interface a {
        void a(String str, long j2, long j3, long j4);

        void a(String str, String str2, long j2, long j3, long j4);
    }

    private y() {
    }

    public static y a() {
        if (f7399c == null) {
            synchronized (y.class) {
                if (f7399c == null) {
                    f7399c = new y();
                }
            }
        }
        return f7399c;
    }

    private String f(Context context) {
        try {
            SharedPreferences.Editor editorEdit = PreferenceWrapper.getDefault(context).edit();
            editorEdit.putString(u.f7384d, d(context));
            editorEdit.commit();
        } catch (Exception unused) {
        }
        long jH = h(context);
        long jI = i(context);
        String str = this.f7400b;
        long jA = u.a(context);
        long j2 = jA * com.heytap.mcssdk.constant.a.r;
        UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** \u8bfb\u53d6 foreground count \u503c\u5b8c\u6210\uff0ccount\u6b21\u6570\uff1a" + jA);
        if (!FieldManager.allow(com.umeng.commonsdk.utils.d.E)) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** foreground count druation\u4e91\u63a7\u53c2\u6570\u5173\u95ed\u3002");
        } else if (UMWorkDispatch.eventHasExist()) {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** \u8bfb\u53d6 foreground count druation\u503c\u5b8c\u6210\uff0c\u7ec8\u6b62checker timer.");
            UMWorkDispatch.removeEvent();
        } else {
            UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>>*** \u8bfb\u53d6 foreground count druation\u503c\u5b8c\u6210\uff0c\u65e0\u672a\u5904\u7406check timer\u4e8b\u4ef6\u3002");
        }
        a(jI, jH, j2, str, false);
        this.f7400b = this.a.a(context);
        a(jI, jH, j2, str, true);
        this.a.a(context, this.f7400b);
        return this.f7400b;
    }

    private boolean g(Context context) {
        return !TextUtils.isEmpty(this.f7400b) && i.a(context).a(this.f7400b) > 0;
    }

    private long h(Context context) {
        return a(context, u.f7386f);
    }

    private long i(Context context) {
        return a(context, u.a);
    }

    private boolean j(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        try {
            SharedPreferences sharedPreferences = PreferenceWrapper.getDefault(appContext);
            long j2 = sharedPreferences.getLong(u.f7385e, 0L);
            long j3 = sharedPreferences.getLong(u.f7386f, 0L);
            if (FieldManager.allow(com.umeng.commonsdk.utils.d.E) && j2 > 0 && j3 == 0) {
                long jA = u.a(appContext);
                if (jA > 0) {
                    long j4 = jA * com.heytap.mcssdk.constant.a.r;
                    UMRTLog.e(UMRTLog.RTLOG_TAG, "--->>> last session end time stamp = 0, reconstruct it by foreground count value.");
                    j3 = j2 + j4;
                }
            }
            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> interval of last session is: " + (j3 - j2));
            return this.a.a(j2, j3);
        } catch (Exception unused) {
            return false;
        }
    }

    public long b() {
        return this.a.a();
    }

    public String c(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        try {
            this.f7400b = f(appContext);
        } catch (Exception unused) {
        }
        return this.f7400b;
    }

    public String d(Context context) {
        if (TextUtils.isEmpty(this.f7400b)) {
            try {
                this.f7400b = PreferenceWrapper.getDefault(context).getString("session_id", null);
            } catch (Exception unused) {
            }
        }
        return this.f7400b;
    }

    public boolean e(Context context) {
        if (TextUtils.isEmpty(this.f7400b)) {
            this.f7400b = d(context);
        }
        return TextUtils.isEmpty(this.f7400b) || j(context) || g(context);
    }

    public synchronized String b(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        this.f7400b = d(appContext);
        if (e(appContext)) {
            try {
                this.f7400b = f(appContext);
            } catch (Exception unused) {
            }
        }
        return this.f7400b;
    }

    public void a(long j2) {
        this.a.a(j2);
    }

    public String a(Context context) {
        Context appContext = UMGlobalContext.getAppContext(context);
        if (appContext == null) {
            return "";
        }
        String string = "";
        try {
            synchronized (y.class) {
                string = PreferenceWrapper.getDefault(appContext).getString(u.f7384d, "");
            }
        } catch (Exception unused) {
        }
        return string;
    }

    public void b(a aVar) {
        List<a> list;
        if (aVar == null || (list = this.f7401d) == null || list.size() == 0) {
            return;
        }
        this.f7401d.remove(aVar);
    }

    public String a(Context context, long j2) {
        if (TextUtils.isEmpty(this.f7402e)) {
            String str = "SUB" + j2;
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(String.format("%0" + (32 - str.length()) + "d", 0));
            this.f7402e = sb.toString();
        }
        return this.f7402e;
    }

    private long a(Context context, String str) {
        long j2;
        try {
            j2 = PreferenceWrapper.getDefault(context).getLong(str, 0L);
        } catch (Exception unused) {
            j2 = 0;
        }
        return j2 <= 0 ? System.currentTimeMillis() : j2;
    }

    private void a(long j2, long j3, long j4, String str, boolean z) {
        List<a> list = this.f7401d;
        if (list != null) {
            for (a aVar : list) {
                if (z) {
                    try {
                        aVar.a(str, this.f7400b, j2, j3, j4);
                    } catch (Exception unused) {
                    }
                } else {
                    aVar.a(this.f7400b, j2, j3, j4);
                }
            }
        }
    }

    public void a(a aVar) {
        if (aVar == null) {
            return;
        }
        if (this.f7401d == null) {
            this.f7401d = new ArrayList();
        }
        if (this.f7401d.contains(aVar)) {
            return;
        }
        this.f7401d.add(aVar);
    }
}
