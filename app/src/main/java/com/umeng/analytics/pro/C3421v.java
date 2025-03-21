package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C3408i;
import com.umeng.analytics.vshelper.InterfaceC3436a;
import com.umeng.analytics.vshelper.PageNameMonitor;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: ViewPageTracker.java */
/* renamed from: com.umeng.analytics.pro.v */
/* loaded from: classes2.dex */
public class C3421v {

    /* renamed from: c */
    private static final int f12265c = 5;

    /* renamed from: d */
    private static JSONArray f12266d = new JSONArray();

    /* renamed from: e */
    private static Object f12267e = new Object();

    /* renamed from: f */
    private final Map<String, Long> f12270f = new HashMap();

    /* renamed from: a */
    Stack<String> f12268a = new Stack<>();

    /* renamed from: b */
    InterfaceC3436a f12269b = PageNameMonitor.getInstance();

    /* renamed from: a */
    public static void m11409a(Context context) {
        String jSONArray;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f12267e) {
                    jSONArray = f12266d.toString();
                    f12266d = new JSONArray();
                }
                if (jSONArray.length() > 0) {
                    jSONObject.put("__a", new JSONArray(jSONArray));
                    if (jSONObject.length() > 0) {
                        C3408i.m11232a(context).m11251a(C3420u.m11389a().m11405c(), jSONObject, C3408i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    protected int mo11267a() {
        return 2;
    }

    /* renamed from: b */
    public void m11412b(String str) {
        Long l2;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f12270f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.f12268a.size() == 0) {
                UMLog.m11551aq(C3409j.f12074G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f12270f) {
            l2 = this.f12270f.get(str);
            this.f12270f.remove(str);
        }
        if (l2 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f12268a.size() > 0 && str.equals(this.f12268a.peek())) {
            this.f12268a.pop();
        }
        long currentTimeMillis = System.currentTimeMillis() - l2.longValue();
        synchronized (f12267e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3397d.f11956v, str);
                jSONObject.put("duration", currentTimeMillis);
                jSONObject.put(C3397d.f11958x, l2);
                jSONObject.put("type", mo11267a());
                f12266d.put(jSONObject);
                if (f12266d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.f12268a.size() == 0) {
            return;
        }
        UMLog.m11551aq(C3409j.f12072E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    /* renamed from: a */
    public void m11410a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.f12268a.size() != 0) {
            UMLog.m11551aq(C3409j.f12073F, 0, "\\|", new String[]{"@"}, new String[]{this.f12268a.peek()}, null, null);
        }
        this.f12269b.customPageBegin(str);
        synchronized (this.f12270f) {
            this.f12270f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.f12268a.push(str);
            }
        }
    }

    /* renamed from: b */
    public void m11411b() {
        String str;
        synchronized (this.f12270f) {
            str = null;
            long j2 = 0;
            for (Map.Entry<String, Long> entry : this.f12270f.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long longValue = entry.getValue().longValue();
                    str = entry.getKey();
                    j2 = longValue;
                }
            }
        }
        if (str != null) {
            m11412b(str);
        }
    }
}
