package com.umeng.socialize.p215a;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3393cw;
import com.umeng.ccg.C3438a;
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
/* renamed from: com.umeng.socialize.a.g */
/* loaded from: classes2.dex */
final class RunnableC3621g implements Runnable {

    /* renamed from: a */
    private static final int f13495a = 1;

    /* renamed from: b */
    private static final int f13496b = 2;

    /* renamed from: c */
    private static final String f13497c = "AZX";

    RunnableC3621g() {
    }

    @Override // java.lang.Runnable
    public void run() {
        if (UMShareAPI.getSmartEnableFlag()) {
            C3619e m12511a = C3619e.m12511a(ContextUtil.getContext());
            m12511a.m12521e();
            int m12519c = m12511a.m12519c();
            long m12520d = m12511a.m12520d();
            if (m12520d < m12519c) {
                if (C3615a.f13470c) {
                    C3627m.m12562a(f13497c, "launch times skipped. times:", Long.valueOf(m12520d), " config:", Integer.valueOf(m12519c));
                    return;
                }
                return;
            }
            if (!m12511a.m12518b()) {
                if (C3615a.f13470c) {
                    C3627m.m12562a(f13497c, "interval skipped.");
                    return;
                }
                return;
            }
            try {
                final Context context = ContextUtil.getContext();
                final String appkey = UMUtils.getAppkey(context);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(C3351bh.f11613al, UMUtils.getZid(context));
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
                jSONObject.put("brand", C3617c.m12502a());
                long m12515a = m12511a.m12515a();
                if (m12515a > 0) {
                    jSONObject.put("last", m12515a);
                }
                JSONObject jSONObject2 = null;
                try {
                    jSONObject2 = C3618d.m12509a(jSONObject, C3615a.f13468a, appkey, C3615a.f13470c);
                } catch (Exception e2) {
                    if (C3615a.f13470c) {
                        C3627m.m12568d(f13497c, "request failed. ", e2.getMessage());
                    }
                }
                if (jSONObject2 == null) {
                    if (C3615a.f13470c) {
                        C3627m.m12562a(f13497c, "response == null");
                    }
                    m12511a.m12517a(7200L);
                    return;
                }
                JSONObject optJSONObject = jSONObject2.optJSONObject("data");
                if (optJSONObject == null) {
                    if (C3615a.f13470c) {
                        C3627m.m12562a(f13497c, "data empty skipped.");
                    }
                    m12511a.m12517a(7200L);
                    return;
                }
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("aa");
                if (optJSONObject2 == null) {
                    optJSONObject2 = new JSONObject();
                }
                int optInt = optJSONObject2.optInt("launch", 5);
                m12511a.m12516a(optInt);
                if (m12511a.m12520d() < optInt) {
                    if (C3615a.f13470c) {
                        C3627m.m12562a(f13497c, "launch times skipped. config:", Integer.valueOf(optInt));
                        return;
                    }
                    return;
                }
                m12511a.m12517a(optJSONObject.optLong(RemoteMessageConst.TTL, 86400L));
                final long optLong = optJSONObject.optLong("id", -1L);
                if (optLong <= 0) {
                    if (C3615a.f13470c) {
                        C3627m.m12562a(f13497c, "id skipped, id:", Long.valueOf(optLong));
                        return;
                    }
                    return;
                }
                final int max = Math.max(optJSONObject2.optInt(C3438a.f12346s, 300), 100);
                final int optInt2 = optJSONObject2.optInt("action", 1);
                int optInt3 = optJSONObject2.optInt("delay");
                if (optInt2 == 1 || optInt2 == 2) {
                    C3624j.m12543a(new Runnable() { // from class: com.umeng.socialize.a.g.1
                        @Override // java.lang.Runnable
                        public void run() {
                            ByteArrayOutputStream byteArrayOutputStream;
                            TreeSet treeSet;
                            Object m12550a;
                            try {
                                treeSet = new TreeSet();
                                byteArrayOutputStream = new ByteArrayOutputStream();
                            } catch (Throwable th) {
                                th = th;
                                byteArrayOutputStream = null;
                            }
                            try {
                                byte[] bArr = {18, -119, 31, 22, 8, 45, 8, 26, 5, 10, 98, 78, -51, 47, -125, 34, 17, 108, -112, -104, 95, 34, 120, 61, -52, -77, 8, 107, -4, 56, 82, -49, -119, -18, -111, -20, 110, -108, -32, -28, 88, -5, 69, -26, 120, -36, 5, -77, -46, 29, 24, -115, -118, -9, -108, -86, -17, 34, 115, -123, 93, 53, 118, 64, 48, -101, -83, -59, -99, 36, 69, -104, 51, -126, 8, -18, 79, -115, -16, 84, -49, 72, 66, 49, 93, -22, -127, -47, -59, -86, C3393cw.f11872l, -12, -100, -12, 53, 85, 37, -75, -30, 31, 44, -83, 99, -108, -92, -127, -32, 87, -61, -83, -90, 123, -98, -32, -60, 77, 113, -60, 101, 81, 57, -72, -86, 28, -74, 88, 35, -118, -22, -74, -29, -103, -86, -25, 19, -78, 62, 28, -100, -68, 1, 35, -68, 58, -100, 29, 5, -10, -95, 20, 98, 124, -40, 99, -100, 8, -126, -10, 79, -31, -42, -114, 12, 27, -102, 114, -107, -35, 82, 21, 97, -9, 39, -20, 123, -37, -68, -78, -89, C3393cw.f11871k, 3, 21, 21, 12, 40, C3393cw.f11872l, 29};
                                byte[] copyOfRange = Arrays.copyOfRange(bArr, bArr.length - 8, bArr.length);
                                byte[] copyOf = Arrays.copyOf(bArr, bArr.length - 8);
                                C3623i.m12539a(copyOf, copyOfRange);
                                C3626l.m12557b(copyOf, byteArrayOutputStream);
                                JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream.toString());
                                if (C3615a.f13470c) {
                                    C3627m.m12562a(RunnableC3621g.f13497c, jSONObject3.toString());
                                }
                                m12550a = C3625k.m12550a(jSONObject3.optString(C3351bh.f11584aI), jSONObject3.optString(C3351bh.f11576aA), null, context, null);
                                if (1 == optInt2) {
                                    Object m12550a2 = C3625k.m12550a(jSONObject3.optString("m"), jSONObject3.optString("q"), new Class[]{C3625k.m12548a(jSONObject3.optString(C3351bh.f11581aF)), Integer.TYPE}, m12550a, new Object[]{C3625k.m12551a(jSONObject3.optString(C3351bh.f11581aF), (Class<?>[]) new Class[]{String.class}, new Object[]{jSONObject3.optString("a")}), 0});
                                    if (m12550a2 instanceof List) {
                                        Field m12554a = C3625k.m12554a(jSONObject3.optString("r"), jSONObject3.optString(C3351bh.f11580aE));
                                        Field m12554a2 = C3625k.m12554a(jSONObject3.optString("t"), jSONObject3.optString("n"));
                                        Iterator it = ((List) m12550a2).iterator();
                                        while (it.hasNext()) {
                                            Object m12552a = C3625k.m12552a(m12554a2, C3625k.m12552a(m12554a, it.next()));
                                            if (m12552a != null) {
                                                treeSet.add((String) m12552a);
                                            }
                                        }
                                        if (C3615a.f13470c) {
                                            C3627m.m12562a(RunnableC3621g.f13497c, "size:" + treeSet.size());
                                        }
                                    }
                                } else {
                                    Object m12550a3 = C3625k.m12550a(jSONObject3.optString("m"), jSONObject3.optString(C3351bh.f11586aK), new Class[]{Integer.TYPE}, m12550a, new Object[]{0});
                                    if (m12550a3 instanceof List) {
                                        Field m12554a3 = C3625k.m12554a(jSONObject3.optString("v"), jSONObject3.optString("n"));
                                        Iterator it2 = ((List) m12550a3).iterator();
                                        while (it2.hasNext()) {
                                            Object m12552a2 = C3625k.m12552a(m12554a3, it2.next());
                                            if (m12552a2 != null) {
                                                treeSet.add((String) m12552a2);
                                            }
                                        }
                                        if (C3615a.f13470c) {
                                            C3627m.m12562a(RunnableC3621g.f13497c, "size:" + treeSet.size());
                                        }
                                    }
                                }
                            } catch (Throwable th2) {
                                th = th2;
                                try {
                                    C3627m.m12568d(RunnableC3621g.f13497c, th.getMessage());
                                } finally {
                                    C3617c.m12503a(byteArrayOutputStream);
                                }
                            }
                            if (treeSet.isEmpty()) {
                                if (C3615a.f13470c) {
                                    C3627m.m12562a(RunnableC3621g.f13497c, "app list empty!");
                                }
                                return;
                            }
                            if (m12550a == null) {
                                return;
                            }
                            ArrayList arrayList = new ArrayList();
                            JSONArray jSONArray = new JSONArray();
                            Iterator it3 = treeSet.iterator();
                            int i2 = 0;
                            while (it3.hasNext()) {
                                Object m12501a = C3617c.m12501a(m12550a, (String) it3.next(), 0);
                                if (m12501a != null) {
                                    C3620f c3620f = new C3620f(m12550a, m12501a);
                                    JSONObject jSONObject4 = new JSONObject();
                                    jSONObject4.put("a", c3620f.f13490b);
                                    jSONObject4.put(C3351bh.f11576aA, c3620f.f13489a);
                                    jSONObject4.put("v", c3620f.f13491c);
                                    jSONObject4.put("t", c3620f.f13494f);
                                    jSONObject4.put(C3351bh.f11581aF, c3620f.f13492d);
                                    jSONObject4.put(C3351bh.f11586aK, c3620f.f13493e);
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
                            if (C3615a.f13470c) {
                                C3627m.m12562a(RunnableC3621g.f13497c, "total:", Integer.valueOf(i2));
                                Iterator it4 = arrayList.iterator();
                                while (it4.hasNext()) {
                                    JSONArray jSONArray2 = (JSONArray) it4.next();
                                    C3627m.m12567c(RunnableC3621g.f13497c, "--- start ---");
                                    C3627m.m12566b(RunnableC3621g.f13497c, "--- size:", Integer.valueOf(jSONArray2.length()));
                                    C3627m.m12566b(RunnableC3621g.f13497c, jSONArray2);
                                    C3627m.m12567c(RunnableC3621g.f13497c, "--- end ---");
                                }
                            }
                            if (arrayList.isEmpty()) {
                                return;
                            }
                            JSONObject jSONObject5 = new JSONObject();
                            jSONObject5.put(C3351bh.f11613al, UMUtils.getZid(context));
                            jSONObject5.put("appkey", appkey);
                            jSONObject5.put("umid", UMUtils.getUMId(context));
                            jSONObject5.put("v", "2.0");
                            jSONObject5.put("sdk_v", "7.3.2");
                            jSONObject5.put("os_v", Build.VERSION.RELEASE);
                            jSONObject5.put("brand", C3617c.m12502a());
                            jSONObject5.put(Constants.KEY_MODEL, C3617c.m12505b());
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
                            jSONObject5.put("board", C3617c.m12507c());
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
                                jSONObject5.put("grant", C3617c.m12506b(context) ? 1 : 0);
                            } catch (Throwable unused6) {
                            }
                            Iterator it5 = arrayList.iterator();
                            int i3 = 0;
                            while (it5.hasNext()) {
                                JSONArray jSONArray3 = (JSONArray) it5.next();
                                i3++;
                                jSONObject5.put(C3438a.f12346s, i3);
                                jSONObject5.put("data", jSONArray3);
                                try {
                                    C3618d.m12510a(jSONObject5, C3615a.f13469b, appkey);
                                } catch (Exception e3) {
                                    if (C3615a.f13470c) {
                                        C3627m.m12568d(RunnableC3621g.f13497c, "upload error:", e3.getMessage());
                                    }
                                    throw e3;
                                }
                            }
                        }
                    }, optInt3, TimeUnit.SECONDS);
                } else if (C3615a.f13470c) {
                    C3627m.m12562a(f13497c, "action skipped. ", Integer.valueOf(optInt2));
                }
            } catch (Throwable th) {
                if (C3615a.f13470c) {
                    C3627m.m12568d(f13497c, th.getMessage());
                }
            }
        }
    }
}
