package com.umeng.message.proguard;

import android.app.Application;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.cw;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.message.MessageSharedPrefs;
import com.umeng.message.MsgConstant;
import com.umeng.message.common.UPLog;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
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

/* loaded from: classes2.dex */
final class m implements Runnable {
    m() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (f.f11348a) {
            MessageSharedPrefs messageSharedPrefs = MessageSharedPrefs.getInstance(x.a());
            if (messageSharedPrefs.f11129c == null) {
                try {
                    if (f.b(messageSharedPrefs.f11127a)) {
                        messageSharedPrefs.f11128b.a(com.umeng.socialize.a.a.f11538d, messageSharedPrefs.m() + 1);
                    }
                } finally {
                    messageSharedPrefs.f11129c = Boolean.TRUE;
                }
            }
            if (messageSharedPrefs.m() >= messageSharedPrefs.f11128b.b(com.umeng.socialize.a.a.f11540f, 0) && messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e)) {
                try {
                    final Application a2 = x.a();
                    final String appkey = UMUtils.getAppkey(a2);
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put(bh.al, UMUtils.getZid(a2));
                    try {
                        jSONObject.put("imei", DeviceConfig.getImeiNew(a2));
                        jSONObject.put("oaid", DeviceConfig.getOaid(a2));
                    } catch (Throwable unused) {
                    }
                    try {
                        jSONObject.put("idfa", DeviceConfig.getIdfa(a2));
                    } catch (Throwable unused2) {
                    }
                    jSONObject.put("umid", d.k(a2));
                    jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(a2));
                    jSONObject.put("sdk_v", MsgConstant.SDK_VERSION);
                    jSONObject.put("os_v", Build.VERSION.RELEASE);
                    jSONObject.put("lvl", Build.VERSION.SDK_INT);
                    String[] networkAccessMode = UMUtils.getNetworkAccessMode(a2);
                    if (TextUtils.isEmpty(networkAccessMode[0])) {
                        networkAccessMode[0] = "Unknown";
                    }
                    jSONObject.put("net", networkAccessMode[0]);
                    jSONObject.put("brand", d.f());
                    long b2 = messageSharedPrefs.f11128b.b("smart_ts", 0L);
                    if (b2 > 0) {
                        jSONObject.put("last", b2);
                    }
                    JSONObject jSONObject2 = null;
                    try {
                        jSONObject2 = g.a(jSONObject, "https://ccs.umeng.com/aa", appkey, false);
                    } catch (Exception unused3) {
                    }
                    if (jSONObject2 == null) {
                        messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e, 7200L);
                        return;
                    }
                    JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                    if (optJSONObject == null) {
                        messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e, 7200L);
                        return;
                    }
                    JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                    if (optJSONObject2 == null) {
                        optJSONObject2 = new JSONObject();
                    }
                    int optInt = optJSONObject2.optInt("launch", 5);
                    messageSharedPrefs.f11128b.a(com.umeng.socialize.a.a.f11540f, optInt);
                    if (messageSharedPrefs.m() < optInt) {
                        return;
                    }
                    messageSharedPrefs.a(com.umeng.socialize.a.a.f11539e, optJSONObject.optLong(RemoteMessageConst.TTL, 86400L));
                    final long optLong = optJSONObject.optLong("id", -1L);
                    if (optLong <= 0) {
                        return;
                    }
                    final int max = Math.max(optJSONObject2.optInt(com.umeng.ccg.a.s, 300), 100);
                    final int optInt2 = optJSONObject2.optInt("action", 1);
                    int optInt3 = optJSONObject2.optInt("delay");
                    if (optInt2 == 1 || optInt2 == 2) {
                        b.a(new Runnable() { // from class: com.umeng.message.proguard.m.1
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
                                    byte[] bArr = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, cw.f10302l, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, cw.f10301k, 3, 21, 21, 12, 40, cw.f10302l, 29};
                                    byte[] copyOfRange = Arrays.copyOfRange(bArr, 179, 187);
                                    byte[] copyOf = Arrays.copyOf(bArr, 179);
                                    ay.a(copyOf, copyOfRange);
                                    bc.b(copyOf, byteArrayOutputStream);
                                    JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream.toString());
                                    Object a3 = ba.a(jSONObject3.optString(bh.aI), jSONObject3.optString(bh.aA), null, a2, null);
                                    if (1 == optInt2) {
                                        Object a4 = ba.a(jSONObject3.optString("m"), jSONObject3.optString("q"), new Class[]{ba.a(jSONObject3.optString(bh.aF)), Integer.TYPE}, a3, new Object[]{ba.a(jSONObject3.optString(bh.aF), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                        if (a4 instanceof List) {
                                            Field a5 = ba.a(jSONObject3.optString("r"), jSONObject3.optString(bh.aE));
                                            Field a6 = ba.a(jSONObject3.optString("t"), jSONObject3.optString("n"));
                                            Iterator it = ((List) a4).iterator();
                                            while (it.hasNext()) {
                                                Object a7 = ba.a(a6, ba.a(a5, it.next()));
                                                if (a7 != null) {
                                                    treeSet.add((String) a7);
                                                }
                                            }
                                        }
                                    } else {
                                        Object a8 = ba.a(jSONObject3.optString("m"), jSONObject3.optString(bh.aK), new Class[]{Integer.TYPE}, a3, new Object[]{0});
                                        if (a8 instanceof List) {
                                            Field a9 = ba.a(jSONObject3.optString("v"), jSONObject3.optString("n"));
                                            Iterator it2 = ((List) a8).iterator();
                                            while (it2.hasNext()) {
                                                Object a10 = ba.a(a9, it2.next());
                                                if (a10 != null) {
                                                    treeSet.add((String) a10);
                                                }
                                            }
                                        }
                                    }
                                    if (treeSet.isEmpty()) {
                                        return;
                                    }
                                    if (a3 == null) {
                                        return;
                                    }
                                    ArrayList arrayList = new ArrayList();
                                    JSONArray jSONArray = new JSONArray();
                                    Iterator it3 = treeSet.iterator();
                                    int i2 = 0;
                                    while (it3.hasNext()) {
                                        Object a11 = f.a(a3, (String) it3.next());
                                        if (a11 != null) {
                                            l lVar = new l(a3, a11);
                                            JSONObject jSONObject4 = new JSONObject();
                                            jSONObject4.put("a", lVar.f11373b);
                                            jSONObject4.put(bh.aA, lVar.f11372a);
                                            jSONObject4.put("v", lVar.f11374c);
                                            jSONObject4.put("t", lVar.f11377f);
                                            jSONObject4.put(bh.aF, lVar.f11375d);
                                            jSONObject4.put(bh.aK, lVar.f11376e);
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
                                    jSONObject5.put(bh.al, UMUtils.getZid(a2));
                                    jSONObject5.put("appkey", appkey);
                                    jSONObject5.put("umid", d.k(a2));
                                    jSONObject5.put("v", "2.0");
                                    jSONObject5.put("sdk_v", MsgConstant.SDK_VERSION);
                                    jSONObject5.put("os_v", Build.VERSION.RELEASE);
                                    jSONObject5.put("brand", d.f());
                                    jSONObject5.put(Constants.KEY_MODEL, d.d());
                                    jSONObject5.put("smart_id", optLong);
                                    jSONObject5.put("src", "push");
                                    jSONObject5.put("imei", DeviceConfig.getImeiNew(a2));
                                    try {
                                        jSONObject5.put("oaid", DeviceConfig.getOaid(a2));
                                    } catch (Throwable unused4) {
                                    }
                                    try {
                                        jSONObject5.put("idfa", DeviceConfig.getIdfa(a2));
                                    } catch (Throwable unused5) {
                                    }
                                    jSONObject5.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, d.e(a2));
                                    jSONObject5.put("pkg", a2.getPackageName());
                                    jSONObject5.put("app_v", UMUtils.getAppVersionName(a2));
                                    jSONObject5.put("board", d.e());
                                    try {
                                        Locale locale = UMUtils.getLocale(a2);
                                        if (locale != null) {
                                            jSONObject5.put("os_lang", locale.getLanguage());
                                        }
                                    } catch (Throwable unused6) {
                                    }
                                    jSONObject5.put("c_ts", System.currentTimeMillis());
                                    jSONObject5.put("total", i2);
                                    try {
                                        jSONObject5.put("os_i", Build.VERSION.SDK_INT);
                                        jSONObject5.put("os_t", a2.getApplicationInfo().targetSdkVersion);
                                        jSONObject5.put("grant", f.f(a2) ? 1 : 0);
                                    } catch (Throwable unused7) {
                                    }
                                    Iterator it4 = arrayList.iterator();
                                    int i3 = 0;
                                    while (it4.hasNext()) {
                                        JSONArray jSONArray2 = (JSONArray) it4.next();
                                        i3++;
                                        jSONObject5.put(com.umeng.ccg.a.s, i3);
                                        jSONObject5.put("data", jSONArray2);
                                        try {
                                            g.b(jSONObject5, com.umeng.socialize.a.a.f11536b, appkey);
                                        } catch (Exception e2) {
                                            throw e2;
                                        }
                                    }
                                } catch (Throwable th2) {
                                    th = th2;
                                    try {
                                        UPLog.e("App", th.getMessage());
                                    } finally {
                                        f.a(byteArrayOutputStream);
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
