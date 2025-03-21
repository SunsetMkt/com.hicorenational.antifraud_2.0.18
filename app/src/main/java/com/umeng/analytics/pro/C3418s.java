package com.umeng.analytics.pro;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.CoreProtocol;
import com.umeng.analytics.pro.C3414o;
import com.umeng.commonsdk.debug.UMLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.framework.UMWorkDispatch;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.common.MLog;
import com.umeng.commonsdk.statistics.common.ULog;
import com.umeng.commonsdk.statistics.internal.PreferenceWrapper;
import com.umeng.commonsdk.utils.UMUtils;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* compiled from: EventTracker.java */
/* renamed from: com.umeng.analytics.pro.s */
/* loaded from: classes2.dex */
public class C3418s {

    /* renamed from: a */
    private static final String f12242a = "fs_lc_tl_uapp";

    /* renamed from: f */
    private static final String f12243f = "-1";

    /* renamed from: g */
    private static Context f12244g;

    /* renamed from: b */
    private final int f12245b;

    /* renamed from: c */
    private final int f12246c;

    /* renamed from: d */
    private final int f12247d;

    /* renamed from: e */
    private final int f12248e;

    /* renamed from: h */
    private JSONObject f12249h;

    /* compiled from: EventTracker.java */
    /* renamed from: com.umeng.analytics.pro.s$a */
    private static class a {

        /* renamed from: a */
        private static final C3418s f12250a = new C3418s();

        private a() {
        }
    }

    /* renamed from: a */
    public static C3418s m11372a(Context context) {
        if (f12244g == null && context != null) {
            f12244g = context.getApplicationContext();
        }
        return a.f12250a;
    }

    /* renamed from: b */
    private void m11378b(Context context) {
        try {
            String string = PreferenceWrapper.getDefault(context).getString(f12242a, null);
            if (!TextUtils.isEmpty(string)) {
                this.f12249h = new JSONObject(string);
            }
            m11374a();
        } catch (Exception unused) {
        }
    }

    /* renamed from: c */
    private void m11381c(Context context) {
        try {
            if (this.f12249h != null) {
                PreferenceWrapper.getDefault(f12244g).edit().putString(f12242a, this.f12249h.toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private C3418s() {
        this.f12245b = 128;
        this.f12246c = 256;
        this.f12247d = 1024;
        this.f12248e = 10;
        this.f12249h = null;
        try {
            if (this.f12249h == null) {
                m11378b(f12244g);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: c */
    private boolean m11382c(String str) {
        if (str == null) {
            return true;
        }
        try {
            return str.trim().getBytes().length <= 1024;
        } catch (Exception unused) {
            return false;
        }
    }

    /* renamed from: a */
    public void m11383a(String str, String str2, long j2, int i2, String str3) {
        String m11427a;
        try {
            if (m11377a(str) && m11379b(str2)) {
                if (Arrays.asList(C3397d.f11908aG).contains(str)) {
                    MLog.m11744e("key is " + str + ", please check key, illegal");
                    UMLog.m11549aq(C3409j.f12124m, 0, "\\|");
                    return;
                }
                long currentTimeMillis = System.currentTimeMillis();
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", currentTimeMillis);
                if (j2 > 0) {
                    jSONObject.put(C3397d.f11897W, j2);
                }
                jSONObject.put("__t", C3408i.f12048a);
                if (!TextUtils.isEmpty(str2)) {
                    jSONObject.put(str, str2);
                }
                if (UMUtils.isMainProgress(f12244g)) {
                    m11427a = C3424y.m11419a().m11434d(UMGlobalContext.getAppContext(f12244g));
                } else {
                    m11427a = C3424y.m11419a().m11427a(UMGlobalContext.getAppContext(f12244g), currentTimeMillis);
                }
                if (TextUtils.isEmpty(m11427a)) {
                    m11427a = f12243f;
                }
                jSONObject.put("__i", m11427a);
                if (!TextUtils.isEmpty(str3)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str3);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(C3397d.f11930au, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f12244g).getProcessName(f12244g));
                m11374a();
                if (this.f12249h != null && this.f12249h.has(str) && !((Boolean) this.f12249h.get(str)).booleanValue()) {
                    jSONObject.put(C3397d.f11899Y, 1);
                    this.f12249h.put(str, true);
                    m11381c(f12244g);
                }
                UMWorkDispatch.sendEvent(f12244g, 4097, CoreProtocol.getInstance(f12244g), jSONObject);
                return;
            }
            UMLog.m11549aq(C3409j.f12123l, 0, "\\|");
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: b */
    private boolean m11379b(String str) {
        if (str == null) {
            return true;
        }
        try {
            if (str.trim().getBytes().length <= 256) {
                return true;
            }
        } catch (Exception unused) {
        }
        MLog.m11744e("value is " + str + ", please check value, illegal");
        return false;
    }

    /* renamed from: b */
    private boolean m11380b(Map<String, Object> map) {
        if (map != null) {
            try {
                if (!map.isEmpty()) {
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        if (!m11377a(entry.getKey())) {
                            UMLog.m11549aq(C3409j.f12119h, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() == null) {
                            UMLog.m11549aq(C3409j.f12120i, 0, "\\|");
                            return false;
                        }
                        if (entry.getValue() instanceof String) {
                            if (C3397d.f11906aE.equals(entry.getKey())) {
                                if (!m11382c(entry.getValue().toString())) {
                                    UMLog.m11549aq(C3409j.f12083P, 0, "\\|");
                                    return false;
                                }
                            } else if ("_$!url".equals(entry.getKey())) {
                                if (!m11382c(entry.getValue().toString())) {
                                    UMLog.m11549aq("url参数长度超过限制。|参数url长度不能超过1024字符。", 0, "\\|");
                                    return false;
                                }
                            } else if (!m11379b(entry.getValue().toString())) {
                                UMLog.m11549aq(C3409j.f12121j, 0, "\\|");
                                return false;
                            }
                        }
                    }
                    return true;
                }
            } catch (Exception unused) {
                return true;
            }
        }
        UMLog.m11549aq(C3409j.f12118g, 0, "\\|");
        return false;
    }

    /* renamed from: a */
    public void m11384a(String str, Map<String, Object> map, long j2, String str2, boolean z) {
        String m11427a;
        try {
            if (!m11377a(str)) {
                UMLog.m11549aq(C3409j.f12117f, 0, "\\|");
                return;
            }
            if (m11380b(map)) {
                if (map.size() > 100) {
                    MLog.m11744e("map size is " + map.size() + ", please check");
                    return;
                }
                if (Arrays.asList(C3397d.f11908aG).contains(str)) {
                    MLog.m11744e("key is " + str + ", please check key, illegal");
                    UMLog.m11549aq(C3409j.f12113b, 0, "\\|");
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                if (j2 > 0) {
                    jSONObject.put(C3397d.f11897W, j2);
                }
                jSONObject.put("__t", C3408i.f12048a);
                ULog.m11780i("befort ekv map, event is " + jSONObject.toString());
                for (Map.Entry<String, Object> entry : map.entrySet()) {
                    if (!Arrays.asList(C3397d.f11908aG).contains(entry.getKey())) {
                        Object value = entry.getValue();
                        if (!(value instanceof String) && !(value instanceof Integer) && !(value instanceof Long) && !(value instanceof Short) && !(value instanceof Float) && !(value instanceof Double)) {
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    if (iArr.length > 10) {
                                        MLog.m11744e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray = new JSONArray();
                                    for (int i2 : iArr) {
                                        jSONArray.put(i2);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    if (dArr.length > 10) {
                                        MLog.m11744e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray2 = new JSONArray();
                                    for (double d2 : dArr) {
                                        jSONArray2.put(d2);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    if (jArr.length > 10) {
                                        MLog.m11744e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray3 = new JSONArray();
                                    for (long j3 : jArr) {
                                        jSONArray3.put(j3);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    if (fArr.length > 10) {
                                        MLog.m11744e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray4 = new JSONArray();
                                    for (float f2 : fArr) {
                                        jSONArray4.put(f2);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    if (sArr.length > 10) {
                                        MLog.m11744e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray5 = new JSONArray();
                                    for (short s : sArr) {
                                        jSONArray5.put((int) s);
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray5);
                                } else if (value instanceof String[]) {
                                    String[] strArr = (String[]) value;
                                    if (strArr.length > 10) {
                                        MLog.m11744e("please check key or value, size overlength!");
                                        return;
                                    }
                                    JSONArray jSONArray6 = new JSONArray();
                                    for (int i3 = 0; i3 < strArr.length; i3++) {
                                        if (strArr[i3] == null) {
                                            MLog.m11744e("please check array, null item!");
                                            return;
                                        } else {
                                            if (!m11379b(strArr[i3])) {
                                                return;
                                            }
                                            jSONArray6.put(strArr[i3]);
                                        }
                                    }
                                    jSONObject.put(entry.getKey(), jSONArray6);
                                } else {
                                    MLog.m11744e("please check key or value, illegal type!");
                                    return;
                                }
                            } else {
                                MLog.m11744e("please check key or value, illegal type!");
                                return;
                            }
                        }
                        jSONObject.put(entry.getKey(), value);
                    } else {
                        UMLog.m11549aq(C3409j.f12116e, 0, "\\|");
                        return;
                    }
                }
                if (UMUtils.isMainProgress(f12244g)) {
                    m11427a = C3424y.m11419a().m11434d(UMGlobalContext.getAppContext(f12244g));
                } else {
                    m11427a = C3424y.m11419a().m11427a(UMGlobalContext.getAppContext(f12244g), jSONObject.getLong("ts"));
                }
                if (TextUtils.isEmpty(m11427a)) {
                    m11427a = f12243f;
                }
                jSONObject.put("__i", m11427a);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(C3397d.f11930au, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f12244g).getProcessName(f12244g));
                m11374a();
                if (this.f12249h != null && this.f12249h.has(str) && !((Boolean) this.f12249h.get(str)).booleanValue()) {
                    jSONObject.put(C3397d.f11899Y, 1);
                    this.f12249h.put(str, true);
                    m11381c(f12244g);
                }
                ULog.m11780i("----->>>>>ekv event json is " + jSONObject.toString());
                if (!z) {
                    UMWorkDispatch.sendEvent(f12244g, 4097, CoreProtocol.getInstance(f12244g), jSONObject);
                } else {
                    UMWorkDispatch.sendEvent(f12244g, C3414o.a.f12210n, CoreProtocol.getInstance(f12244g), jSONObject);
                }
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    public void m11385a(String str, Map<String, Object> map, String str2) {
        try {
            if (m11377a(str)) {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("id", str);
                jSONObject.put("ts", System.currentTimeMillis());
                jSONObject.put(C3397d.f11897W, 0);
                jSONObject.put("__t", C3408i.f12049b);
                ULog.m11780i("befort gkv map, event is " + jSONObject.toString());
                Iterator<Map.Entry<String, Object>> it = map.entrySet().iterator();
                for (int i2 = 0; i2 < 10 && it.hasNext(); i2++) {
                    Map.Entry<String, Object> next = it.next();
                    if (!C3397d.f11899Y.equals(next.getKey()) && !C3397d.f11897W.equals(next.getKey()) && !"id".equals(next.getKey()) && !"ts".equals(next.getKey())) {
                        Object value = next.getValue();
                        if ((value instanceof String) || (value instanceof Integer) || (value instanceof Long)) {
                            jSONObject.put(next.getKey(), value);
                        }
                    }
                }
                String m11434d = C3424y.m11419a().m11434d(UMGlobalContext.getAppContext(f12244g));
                if (TextUtils.isEmpty(m11434d)) {
                    m11434d = f12243f;
                }
                jSONObject.put("__i", m11434d);
                if (!TextUtils.isEmpty(str2)) {
                    try {
                        JSONObject jSONObject2 = new JSONObject(str2);
                        if (jSONObject2.length() > 0) {
                            jSONObject.put(C3397d.f11930au, jSONObject2);
                        }
                    } catch (JSONException unused) {
                    }
                }
                jSONObject.put("ds", 0);
                jSONObject.put("pn", UMGlobalContext.getInstance(f12244g).getProcessName(f12244g));
                ULog.m11780i("----->>>>>gkv event json is " + jSONObject.toString());
                UMWorkDispatch.sendEvent(f12244g, 4098, CoreProtocol.getInstance(f12244g), jSONObject);
            }
        } catch (Throwable unused2) {
        }
    }

    /* renamed from: a */
    private void m11374a() {
        try {
            String imprintProperty = UMEnvelopeBuild.imprintProperty(f12244g, "track_list", "");
            if (TextUtils.isEmpty(imprintProperty)) {
                return;
            }
            String[] split = imprintProperty.split("!");
            JSONObject jSONObject = new JSONObject();
            int i2 = 0;
            if (this.f12249h != null) {
                for (String str : split) {
                    String subStr = HelperUtils.subStr(str, 128);
                    if (this.f12249h.has(subStr)) {
                        jSONObject.put(subStr, this.f12249h.get(subStr));
                    }
                }
            }
            this.f12249h = new JSONObject();
            if (split.length >= 10) {
                while (i2 < 10) {
                    m11375a(split[i2], jSONObject);
                    i2++;
                }
            } else {
                while (i2 < split.length) {
                    m11375a(split[i2], jSONObject);
                    i2++;
                }
            }
            m11381c(f12244g);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    private void m11375a(String str, JSONObject jSONObject) throws JSONException {
        String subStr = HelperUtils.subStr(str, 128);
        if (jSONObject.has(subStr)) {
            m11376a(subStr, ((Boolean) jSONObject.get(subStr)).booleanValue());
        } else {
            m11376a(subStr, false);
        }
    }

    /* renamed from: a */
    private void m11376a(String str, boolean z) {
        try {
            if (C3397d.f11899Y.equals(str) || C3397d.f11897W.equals(str) || "id".equals(str) || "ts".equals(str) || this.f12249h.has(str)) {
                return;
            }
            this.f12249h.put(str, z);
        } catch (Exception unused) {
        }
    }

    /* renamed from: a */
    public void m11386a(List<String> list) {
        if (list != null) {
            try {
                if (list.size() > 0) {
                    m11374a();
                    if (this.f12249h == null) {
                        this.f12249h = new JSONObject();
                        int size = list.size();
                        for (int i2 = 0; i2 < size; i2++) {
                            if (this.f12249h == null) {
                                this.f12249h = new JSONObject();
                            } else if (this.f12249h.length() >= 5) {
                                break;
                            }
                            String str = list.get(i2);
                            if (!TextUtils.isEmpty(str)) {
                                m11376a(HelperUtils.subStr(str, 128), false);
                            }
                        }
                        m11381c(f12244g);
                        return;
                    }
                    if (this.f12249h.length() >= 5) {
                        MLog.m11738d("already setFistLaunchEvent, igone.");
                        return;
                    }
                    for (int i3 = 0; i3 < list.size(); i3++) {
                        if (this.f12249h.length() >= 5) {
                            MLog.m11738d(" add setFistLaunchEvent over.");
                            return;
                        }
                        m11376a(HelperUtils.subStr(list.get(i3), 128), false);
                    }
                    m11381c(f12244g);
                    return;
                }
            } catch (Exception unused) {
                return;
            }
        }
        UMLog.m11549aq(C3409j.f12105ak, 0, "\\|");
    }

    /* renamed from: a */
    private JSONObject m11373a(Map<String, Object> map) {
        JSONObject jSONObject = new JSONObject();
        try {
            for (Map.Entry<String, Object> entry : map.entrySet()) {
                try {
                    String key = entry.getKey();
                    if (key != null) {
                        String subStr = HelperUtils.subStr(key, 128);
                        Object value = entry.getValue();
                        if (value != null) {
                            int i2 = 0;
                            if (value.getClass().isArray()) {
                                if (value instanceof int[]) {
                                    int[] iArr = (int[]) value;
                                    JSONArray jSONArray = new JSONArray();
                                    while (i2 < iArr.length) {
                                        jSONArray.put(iArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(subStr, jSONArray);
                                } else if (value instanceof double[]) {
                                    double[] dArr = (double[]) value;
                                    JSONArray jSONArray2 = new JSONArray();
                                    while (i2 < dArr.length) {
                                        jSONArray2.put(dArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(subStr, jSONArray2);
                                } else if (value instanceof long[]) {
                                    long[] jArr = (long[]) value;
                                    JSONArray jSONArray3 = new JSONArray();
                                    while (i2 < jArr.length) {
                                        jSONArray3.put(jArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(subStr, jSONArray3);
                                } else if (value instanceof float[]) {
                                    float[] fArr = (float[]) value;
                                    JSONArray jSONArray4 = new JSONArray();
                                    while (i2 < fArr.length) {
                                        jSONArray4.put(fArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(subStr, jSONArray4);
                                } else if (value instanceof short[]) {
                                    short[] sArr = (short[]) value;
                                    JSONArray jSONArray5 = new JSONArray();
                                    while (i2 < sArr.length) {
                                        jSONArray5.put((int) sArr[i2]);
                                        i2++;
                                    }
                                    jSONObject.put(subStr, jSONArray5);
                                }
                            } else if (value instanceof List) {
                                List list = (List) value;
                                JSONArray jSONArray6 = new JSONArray();
                                while (i2 < list.size()) {
                                    Object obj = list.get(i2);
                                    if ((obj instanceof String) || (obj instanceof Long) || (obj instanceof Integer) || (obj instanceof Float) || (obj instanceof Double) || (obj instanceof Short)) {
                                        jSONArray6.put(list.get(i2));
                                    }
                                    i2++;
                                }
                                if (jSONArray6.length() > 0) {
                                    jSONObject.put(subStr, jSONArray6);
                                }
                            } else if (value instanceof String) {
                                jSONObject.put(subStr, HelperUtils.subStr(value.toString(), 256));
                            } else {
                                if (!(value instanceof Long) && !(value instanceof Integer) && !(value instanceof Float) && !(value instanceof Double) && !(value instanceof Short)) {
                                    MLog.m11744e("The param has not support type. please check !");
                                }
                                jSONObject.put(subStr, value);
                            }
                        }
                    }
                } catch (Exception e2) {
                    MLog.m11748e(e2);
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }

    /* renamed from: a */
    private boolean m11377a(String str) {
        if (str != null) {
            try {
                int length = str.trim().getBytes().length;
                if (length > 0 && length <= 128) {
                    return true;
                }
            } catch (Exception unused) {
            }
        }
        MLog.m11744e("key is " + str + ", please check key, illegal");
        return false;
    }
}
