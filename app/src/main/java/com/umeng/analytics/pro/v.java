package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.i;
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

/* JADX INFO: compiled from: ViewPageTracker.java */
/* JADX INFO: loaded from: classes2.dex */
public class v {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f7394c = 5;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static JSONArray f7395d = new JSONArray();

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Object f7396e = new Object();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final Map<String, Long> f7398f = new HashMap();
    Stack<String> a = new Stack<>();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    com.umeng.analytics.vshelper.a f7397b = PageNameMonitor.getInstance();

    public static void a(Context context) {
        String string;
        if (context != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                synchronized (f7396e) {
                    string = f7395d.toString();
                    f7395d = new JSONArray();
                }
                if (string.length() > 0) {
                    jSONObject.put("__a", new JSONArray(string));
                    if (jSONObject.length() > 0) {
                        i.a(context).a(u.a().c(), jSONObject, i.a.PAGE);
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    protected int a() {
        return 2;
    }

    public void b(String str) {
        Long l2;
        Context appContext;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (!this.f7398f.containsKey(str)) {
            if (UMConfigure.isDebugLog() && this.a.size() == 0) {
                UMLog.aq(j.G, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
                return;
            }
            return;
        }
        synchronized (this.f7398f) {
            l2 = this.f7398f.get(str);
            this.f7398f.remove(str);
        }
        if (l2 == null) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() > 0 && str.equals(this.a.peek())) {
            this.a.pop();
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - l2.longValue();
        synchronized (f7396e) {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(d.v, str);
                jSONObject.put("duration", jCurrentTimeMillis);
                jSONObject.put(d.x, l2);
                jSONObject.put("type", a());
                f7395d.put(jSONObject);
                if (f7395d.length() >= 5 && (appContext = UMGlobalContext.getAppContext(null)) != null) {
                    UMWorkDispatch.sendEvent(appContext, 4099, CoreProtocol.getInstance(appContext), null);
                }
            } catch (Throwable unused) {
            }
        }
        if (!UMConfigure.isDebugLog() || this.a.size() == 0) {
            return;
        }
        UMLog.aq(j.E, 0, "\\|", new String[]{"@"}, new String[]{str}, null, null);
    }

    public void a(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        if (UMConfigure.isDebugLog() && this.a.size() != 0) {
            UMLog.aq(j.F, 0, "\\|", new String[]{"@"}, new String[]{this.a.peek()}, null, null);
        }
        this.f7397b.customPageBegin(str);
        synchronized (this.f7398f) {
            this.f7398f.put(str, Long.valueOf(System.currentTimeMillis()));
            if (UMConfigure.isDebugLog()) {
                this.a.push(str);
            }
        }
    }

    public void b() {
        String key;
        synchronized (this.f7398f) {
            key = null;
            long j2 = 0;
            for (Map.Entry<String, Long> entry : this.f7398f.entrySet()) {
                if (entry.getValue().longValue() > j2) {
                    long jLongValue = entry.getValue().longValue();
                    key = entry.getKey();
                    j2 = jLongValue;
                }
            }
        }
        if (key != null) {
            b(key);
        }
    }
}
