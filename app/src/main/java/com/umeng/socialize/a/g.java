package com.umeng.socialize.a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import com.umeng.analytics.pro.cw;
import com.umeng.commonsdk.statistics.common.DeviceConfig;
import com.umeng.commonsdk.utils.UMUtils;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import com.umeng.socialize.utils.ContextUtil;
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

/* compiled from: UMAppScanTask.java */
/* loaded from: classes2.dex */
final class g implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    private static final int f11562a = 1;

    /* renamed from: b, reason: collision with root package name */
    private static final int f11563b = 2;

    /* renamed from: c, reason: collision with root package name */
    private static final String f11564c = "AZX";

    g() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (UMShareAPI.getSmartEnableFlag()) {
            e a2 = e.a(ContextUtil.getContext());
            a2.e();
            int c2 = a2.c();
            long d2 = a2.d();
            if (d2 < c2) {
                if (a.f11537c) {
                    m.a(f11564c, "launch times skipped. times:", Long.valueOf(d2), " config:", Integer.valueOf(c2));
                    return;
                }
                return;
            }
            if (!a2.b()) {
                if (a.f11537c) {
                    m.a(f11564c, "interval skipped.");
                    return;
                }
                return;
            }
            try {
                final Context context = ContextUtil.getContext();
                final String appkey = UMUtils.getAppkey(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(bh.al, UMUtils.getZid(context));
                try {
                    jSONObject.put("imei", DeviceConfig.getImeiNew(context));
                    jSONObject.put("oaid", DeviceConfig.getOaid(context));
                } catch (Throwable unused) {
                }
                try {
                    jSONObject.put("idfa", DeviceConfig.getIdfa(context));
                } catch (Throwable unused2) {
                }
                jSONObject.put("umid", UMUtils.getUMId(context));
                jSONObject.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                jSONObject.put("sdk_v", "7.3.2");
                jSONObject.put("os_v", Build.VERSION.RELEASE);
                jSONObject.put("lvl", Build.VERSION.SDK_INT);
                String[] networkAccessMode = UMUtils.getNetworkAccessMode(context);
                if (TextUtils.isEmpty(networkAccessMode[0])) {
                    networkAccessMode[0] = "Unknown";
                }
                jSONObject.put("net", networkAccessMode[0]);
                jSONObject.put("brand", c.a());
                long a3 = a2.a();
                if (a3 > 0) {
                    jSONObject.put("last", a3);
                }
                JSONObject jSONObject2 = null;
                try {
                    jSONObject2 = d.a(jSONObject, a.f11535a, appkey, a.f11537c);
                } catch (Exception e2) {
                    if (a.f11537c) {
                        m.d(f11564c, "request failed. ", e2.getMessage());
                    }
                }
                if (jSONObject2 == null) {
                    if (a.f11537c) {
                        m.a(f11564c, "response == null");
                    }
                    a2.a(7200L);
                    return;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                if (optJSONObject == null) {
                    if (a.f11537c) {
                        m.a(f11564c, "data empty skipped.");
                    }
                    a2.a(7200L);
                    return;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                int optInt = optJSONObject2.optInt("launch", 5);
                a2.a(optInt);
                if (a2.d() < optInt) {
                    if (a.f11537c) {
                        m.a(f11564c, "launch times skipped. config:", Integer.valueOf(optInt));
                        return;
                    }
                    return;
                }
                a2.a(optJSONObject.optLong(RemoteMessageConst.TTL, 86400L));
                final long optLong = optJSONObject.optLong("id", -1L);
                if (optLong <= 0) {
                    if (a.f11537c) {
                        m.a(f11564c, "id skipped, id:", Long.valueOf(optLong));
                        return;
                    }
                    return;
                }
                final int max = Math.max(optJSONObject2.optInt(com.umeng.ccg.a.s, 300), 100);
                final int optInt2 = optJSONObject2.optInt("action", 1);
                int optInt3 = optJSONObject2.optInt("delay");
                if (optInt2 == 1 || optInt2 == 2) {
                    j.a(new Runnable() { // from class: com.umeng.socialize.a.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ByteArrayOutputStream byteArrayOutputStream;
                            TreeSet treeSet;
                            Object a4;
                            try {
                                treeSet = new TreeSet();
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = null;
                            }
                            try {
                                byte[] bArr = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, cw.f10302l, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, cw.f10301k, 3, 21, 21, 12, 40, cw.f10302l, 29};
                                byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr.length - 8, bArr.length);
                                byte[] copyOf = Arrays.copyOf(bArr, bArr.length - 8);
                                i.a(copyOf, copyOfRange);
                                l.b(copyOf, byteArrayOutputStream);
                                JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream.toString());
                                if (a.f11537c) {
                                    m.a(g.f11564c, jSONObject3.toString());
                                }
                                a4 = k.a(jSONObject3.optString(bh.aI), jSONObject3.optString(bh.aA), null, context, null);
                                if (1 == optInt2) {
                                    Object a5 = k.a(jSONObject3.optString("m"), jSONObject3.optString("q"), new Class[]{k.a(jSONObject3.optString(bh.aF)), Integer.TYPE}, a4, new Object[]{k.a(jSONObject3.optString(bh.aF), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                    if (a5 instanceof List) {
                                        Field a6 = k.a(jSONObject3.optString("r"), jSONObject3.optString(bh.aE));
                                        Field a7 = k.a(jSONObject3.optString("t"), jSONObject3.optString("n"));
                                        Iterator it = ((List) a5).iterator();
                                        while (it.hasNext()) {
                                            Object a8 = k.a(a7, k.a(a6, it.next()));
                                            if (a8 != null) {
                                                treeSet.add((String) a8);
                                            }
                                        }
                                        if (a.f11537c) {
                                            m.a(g.f11564c, "size:" + treeSet.size());
                                        }
                                    }
                                } else {
                                    Object a9 = k.a(jSONObject3.optString("m"), jSONObject3.optString(bh.aK), new Class[]{Integer.TYPE}, a4, new Object[]{0});
                                    if (a9 instanceof List) {
                                        Field a10 = k.a(jSONObject3.optString("v"), jSONObject3.optString("n"));
                                        Iterator it2 = ((List) a9).iterator();
                                        while (it2.hasNext()) {
                                            Object a11 = k.a(a10, it2.next());
                                            if (a11 != null) {
                                                treeSet.add((String) a11);
                                            }
                                        }
                                        if (a.f11537c) {
                                            m.a(g.f11564c, "size:" + treeSet.size());
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    m.d(g.f11564c, th.getMessage());
                                } finally {
                                    c.a(byteArrayOutputStream);
                                }
                            }
                            if (treeSet.isEmpty()) {
                                if (a.f11537c) {
                                    m.a(g.f11564c, "app list empty!");
                                }
                                return;
                            }
                            if (a4 == null) {
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it3 = treeSet.iterator();
                            int i2 = 0;
                            while (it3.hasNext()) {
                                Object a12 = c.a(a4, (String) it3.next(), 0);
                                if (a12 != null) {
                                    f fVar = new f(a4, a12);
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("a", fVar.f11557b);
                                    jSONObject4.put(bh.aA, fVar.f11556a);
                                    jSONObject4.put("v", fVar.f11558c);
                                    jSONObject4.put("t", fVar.f11561f);
                                    jSONObject4.put(bh.aF, fVar.f11559d);
                                    jSONObject4.put(bh.aK, fVar.f11560e);
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
                            if (a.f11537c) {
                                m.a(g.f11564c, "total:", Integer.valueOf(i2));
                                Iterator it4 = arrayList.iterator();
                                while (it4.hasNext()) {
                                    JSONArray jSONArray2 = (JSONArray) it4.next();
                                    m.c(g.f11564c, "--- start ---");
                                    m.b(g.f11564c, "--- size:", Integer.valueOf(jSONArray2.length()));
                                    m.b(g.f11564c, jSONArray2);
                                    m.c(g.f11564c, "--- end ---");
                                }
                            }
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put(bh.al, UMUtils.getZid(context));
                            jSONObject5.put("appkey", appkey);
                            jSONObject5.put("umid", UMUtils.getUMId(context));
                            jSONObject5.put("v", "2.0");
                            jSONObject5.put("sdk_v", "7.3.2");
                            jSONObject5.put("os_v", Build.VERSION.RELEASE);
                            jSONObject5.put("brand", c.a());
                            jSONObject5.put(Constants.KEY_MODEL, c.b());
                            jSONObject5.put("smart_id", optLong);
                            jSONObject5.put("src", "share");
                            jSONObject5.put("imei", DeviceConfig.getImeiNew(context));
                            try {
                                jSONObject5.put("oaid", DeviceConfig.getOaid(context));
                            } catch (Throwable unused3) {
                            }
                            try {
                                jSONObject5.put("idfa", DeviceConfig.getIdfa(context));
                            } catch (Throwable unused4) {
                            }
                            jSONObject5.put(SocializeProtocolConstants.PROTOCOL_KEY_ANDROID_ID, DeviceConfig.getAndroidId(context));
                            jSONObject5.put("pkg", context.getPackageName());
                            jSONObject5.put("app_v", UMUtils.getAppVersionName(context));
                            jSONObject5.put("board", c.c());
                            try {
                                Locale locale = UMUtils.getLocale(context);
                                if (locale != null) {
                                    jSONObject5.put("os_lang", locale.getLanguage());
                                }
                            } catch (Throwable unused5) {
                            }
                            jSONObject5.put("c_ts", System.currentTimeMillis());
                            jSONObject5.put("total", i2);
                            try {
                                jSONObject5.put("os_i", Build.VERSION.SDK_INT);
                                jSONObject5.put("os_t", context.getApplicationInfo().targetSdkVersion);
                                jSONObject5.put("grant", c.b(context) ? 1 : 0);
                            } catch (Throwable unused6) {
                            }
                            Iterator it5 = arrayList.iterator();
                            int i3 = 0;
                            while (it5.hasNext()) {
                                JSONArray jSONArray3 = (JSONArray) it5.next();
                                i3++;
                                jSONObject5.put(com.umeng.ccg.a.s, i3);
                                jSONObject5.put("data", jSONArray3);
                                try {
                                    d.a(jSONObject5, a.f11536b, appkey);
                                } catch (Exception e3) {
                                    if (a.f11537c) {
                                        m.d(g.f11564c, "upload error:", e3.getMessage());
                                    }
                                    throw e3;
                                }
                            }
                        }
                    }, optInt3, TimeUnit.SECONDS);
                } else if (a.f11537c) {
                    m.a(f11564c, "action skipped. ", Integer.valueOf(optInt2));
                }
            } catch (Throwable th) {
                if (a.f11537c) {
                    m.d(f11564c, th.getMessage());
                }
            }
        }
    }
}
