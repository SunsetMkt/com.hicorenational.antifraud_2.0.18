package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3393cw;
import com.umeng.ccg.C3438a;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.p215a.C3615a;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.TreeSet;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.umeng.message.proguard.m */
/* loaded from: classes2.dex */
final class RunnableC3593m implements Runnable {
    RunnableC3593m() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (C3586f.f13276a) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(C3604x.m12460a());
            if (messageSharedPrefs.f13044c == null) {
                try {
                    if (C3586f.m12390b(messageSharedPrefs.f13042a)) {
                        messageSharedPrefs.f13043b.m12284a(C3615a.f13471d, messageSharedPrefs.m12133m() + 1);
                    }
                } finally {
                    messageSharedPrefs.f13044c = Boolean.TRUE;
                }
            }
            if (messageSharedPrefs.m12133m() >= messageSharedPrefs.f13043b.m12288b(C3615a.f13473f, 0) && messageSharedPrefs.m12119a(C3615a.f13472e)) {
                try {
                    final Application m12460a = C3604x.m12460a();
                    final String appkey = UMUtils.getAppkey(m12460a);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(C3351bh.f11613al, UMUtils.getZid(m12460a));
                    try {
                        jSONObject.put("imei", DeviceConfig.getImeiNew(m12460a));
                        jSONObject.put("oaid", DeviceConfig.getOaid(m12460a));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject.put("idfa", DeviceConfig.getIdfa(m12460a));
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("umid", C3584d.m12367k(m12460a));
                    jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, C3584d.m12355e(m12460a));
                    jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                    jSONObject.put("os_v", Build.VERSION.RELEASE);
                    jSONObject.put("lvl", Build.VERSION.SDK_INT);
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(m12460a);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject.put("net", networkAccessMode[0]);
                    jSONObject.put("brand", C3584d.m12356f());
                    long m12289b = messageSharedPrefs.f13043b.m12289b("smart_ts", 0L);
                    if (m12289b > 0) {
                        jSONObject.put("last", m12289b);
                    }
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = C3587g.m12400a(jSONObject, "https://ccs.umeng.com/aa", appkey, false);
                    } catch (Exception unused3) {
                    }
                    if (jSONObject2 == null) {
                        messageSharedPrefs.m12114a(C3615a.f13472e, 7200L);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                    if (optJSONObject == null) {
                        messageSharedPrefs.m12114a(C3615a.f13472e, 7200L);
                        return;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                    }
                    int optInt = optJSONObject2.optInt("launch", 5);
                    messageSharedPrefs.f13043b.m12283a(C3615a.f13473f, optInt);
                    if (messageSharedPrefs.m12133m() < optInt) {
                        return;
                    }
                    messageSharedPrefs.m12114a(C3615a.f13472e, optJSONObject.optLong(RemoteMessageConst.TTL, 86400L));
                    final long optLong = optJSONObject.optLong("id", -1L);
                    if (optLong <= 0) {
                        return;
                    }
                    final int max = Math.max(optJSONObject2.optInt(C3438a.f12346s, 300), 100);
                    final int optInt2 = optJSONObject2.optInt("action", 1);
                    int optInt3 = optJSONObject2.optInt("delay");
                    if (optInt2 == 1 || optInt2 == 2) {
                        C3578b.m12321a(new Runnable() { // from class: com.umeng.message.proguard.m.1
                            @Override // java.lang.Runnable
                            public final void run() {
                                ByteArrayOutputStream byteArrayOutputStream;
                                TreeSet treeSet;
                                try {
                                    treeSet = new TreeSet();
                                    byteArrayOutputStream = new ByteArrayOutputStream();
                                } catch (Throwable th) {
                                    th = th;
                                    byteArrayOutputStream = null;
                                }
                                try {
                                    byte[] bArr = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, C3393cw.f11872l, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, C3393cw.f11871k, 3, 21, 21, 12, 40, C3393cw.f11872l, 29};
                                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 179, 187);
                                    byte[] copyOf = Arrays.copyOf(bArr, 179);
                                    C3576ay.m12318a(copyOf, copyOfRange);
                                    C3581bc.m12339b(copyOf, byteArrayOutputStream);
                                    JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream.toString());
                                    Object m12330a = C3579ba.m12330a(jSONObject3.optString(C3351bh.f11584aI), jSONObject3.optString(C3351bh.f11576aA), null, m12460a, null);
                                    if (1 == optInt2) {
                                        Object m12330a2 = C3579ba.m12330a(jSONObject3.optString("m"), jSONObject3.optString("q"), new Class[]{C3579ba.m12329a(jSONObject3.optString(C3351bh.f11581aF)), Integer.TYPE}, m12330a, new Object[]{C3579ba.m12331a(jSONObject3.optString(C3351bh.f11581aF), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                        if (m12330a2 instanceof List) {
                                            Field m12334a = C3579ba.m12334a(jSONObject3.optString("r"), jSONObject3.optString(C3351bh.f11580aE));
                                            Field m12334a2 = C3579ba.m12334a(jSONObject3.optString("t"), jSONObject3.optString("n"));
                                            Iterator it = ((List) m12330a2).iterator();
                                            while (it.hasNext()) {
                                                Object m12332a = C3579ba.m12332a(m12334a2, C3579ba.m12332a(m12334a, it.next()));
                                                if (m12332a != null) {
                                                    treeSet.add((String) m12332a);
                                                }
                                            }
                                        }
                                    } else {
                                        Object m12330a3 = C3579ba.m12330a(jSONObject3.optString("m"), jSONObject3.optString(C3351bh.f11586aK), new Class[]{Integer.TYPE}, m12330a, new Object[]{0});
                                        if (m12330a3 instanceof List) {
                                            Field m12334a3 = C3579ba.m12334a(jSONObject3.optString("v"), jSONObject3.optString("n"));
                                            Iterator it2 = ((List) m12330a3).iterator();
                                            while (it2.hasNext()) {
                                                Object m12332a2 = C3579ba.m12332a(m12334a3, it2.next());
                                                if (m12332a2 != null) {
                                                    treeSet.add((String) m12332a2);
                                                }
                                            }
                                        }
                                    }
                                    if (treeSet.isEmpty()) {
                                        return;
                                    }
                                    if (m12330a == null) {
                                        return;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it3 = treeSet.iterator();
                                    int i2 = 0;
                                    while (it3.hasNext()) {
                                        Object m12380a = C3586f.m12380a(m12330a, (String) it3.next());
                                        if (m12380a != null) {
                                            C3592l c3592l = new C3592l(m12330a, m12380a);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("a", c3592l.f13301b);
                                            jSONObject4.put(C3351bh.f11576aA, c3592l.f13300a);
                                            jSONObject4.put("v", c3592l.f13302c);
                                            jSONObject4.put("t", c3592l.f13305f);
                                            jSONObject4.put(C3351bh.f11581aF, c3592l.f13303d);
                                            jSONObject4.put(C3351bh.f11586aK, c3592l.f13304e);
                                            jSONArray.put(jSONObject4);
                                            i2++;
                                            if (jSONArray.length() == max) {
                                                arrayList.add(jSONArray);
                                                jSONArray = new JSONArray();
                                            }
                                        }
                                    }
                                    if (jSONArray.length() > 0) {
                                        arrayList.add(jSONArray);
                                    }
                                    if (arrayList.isEmpty()) {
                                        return;
                                    }
                                    JSONObject jSONObject5 = new JSONObject();
                                    jSONObject5.put(C3351bh.f11613al, UMUtils.getZid(m12460a));
                                    jSONObject5.put("appkey", appkey);
                                    jSONObject5.put("umid", C3584d.m12367k(m12460a));
                                    jSONObject5.put("v", "2.0");
                                    jSONObject5.put("sdk_v", MsgConstant.SDK_VERSION);
                                    jSONObject5.put("os_v", Build.VERSION.RELEASE);
                                    jSONObject5.put("brand", C3584d.m12356f());
                                    jSONObject5.put(Constants.KEY_MODEL, C3584d.m12352d());
                                    jSONObject5.put("smart_id", optLong);
                                    jSONObject5.put("src", "push");
                                    jSONObject5.put("imei", DeviceConfig.getImeiNew(m12460a));
                                    try {
                                        jSONObject5.put("oaid", DeviceConfig.getOaid(m12460a));
                                    } catch (Throwable unused4) {
                                    }
                                    try {
                                        jSONObject5.put("idfa", DeviceConfig.getIdfa(m12460a));
                                    } catch (Throwable unused5) {
                                    }
                                    jSONObject5.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, C3584d.m12355e(m12460a));
                                    jSONObject5.put("pkg", m12460a.getPackageName());
                                    jSONObject5.put("app_v", UMUtils.getAppVersionName(m12460a));
                                    jSONObject5.put("board", C3584d.m12354e());
                                    try {
                                        Locale locale = UMUtils.getLocale(m12460a);
                                        if (locale != null) {
                                            jSONObject5.put("os_lang", locale.getLanguage());
                                        }
                                    } catch (Throwable unused6) {
                                    }
                                    jSONObject5.put("c_ts", System.currentTimeMillis());
                                    jSONObject5.put("total", i2);
                                    try {
                                        jSONObject5.put("os_i", Build.VERSION.SDK_INT);
                                        jSONObject5.put("os_t", m12460a.getApplicationInfo().targetSdkVersion);
                                        jSONObject5.put("grant", C3586f.m12395f(m12460a) ? 1 : 0);
                                    } catch (Throwable unused7) {
                                    }
                                    Iterator it4 = arrayList.iterator();
                                    int i3 = 0;
                                    while (it4.hasNext()) {
                                        JSONArray jSONArray2 = (JSONArray) it4.next();
                                        i3++;
                                        jSONObject5.put(C3438a.f12346s, i3);
                                        jSONObject5.put("data", jSONArray2);
                                        try {
                                            C3587g.m12401b(jSONObject5, C3615a.f13469b, appkey);
                                        } catch (Exception e2) {
                                            throw e2;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        UPLog.m12144e("App", th.getMessage());
                                    } finally {
                                        C3586f.m12386a(byteArrayOutputStream);
                                    }
                                }
                            }
                        }, optInt3, TimeUnit.SECONDS);
                    }
                } catch (Throwable unused4) {
                }
            }
        }
    }
}
