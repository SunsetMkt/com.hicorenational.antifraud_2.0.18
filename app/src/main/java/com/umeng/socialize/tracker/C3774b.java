package com.umeng.socialize.tracker;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.socialize.tracker.utils.C3776b;
import com.umeng.socialize.tracker.utils.C3777c;
import com.umeng.socialize.tracker.utils.EnumC3775a;
import com.umeng.socialize.tracker.utils.HttpRequestListener;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* compiled from: TrackerManagerImpl.java */
/* renamed from: com.umeng.socialize.tracker.b */
/* loaded from: classes2.dex */
class C3774b {

    /* renamed from: a */
    private static final String f13780a = "TrackerManagerImpl";

    /* renamed from: b */
    private static final int f13781b = 3000;

    /* renamed from: c */
    private static final String f13782c = "_$";

    /* renamed from: d */
    private static final int f13783d = 16;

    /* renamed from: e */
    private static final int f13784e = 64;

    /* renamed from: f */
    private static final String f13785f = "自定义属性名长度不能超过16个字符。";

    /* renamed from: g */
    private static final String f13786g = "自定义属性值长度不能超过64个字符。";

    /* compiled from: TrackerManagerImpl.java */
    /* renamed from: com.umeng.socialize.tracker.b$a */
    private static class a {

        /* renamed from: a */
        private static final C3774b f13792a = new C3774b();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: d */
    public static String m12703d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return "错误详情 [" + (jSONObject.has("code") ? jSONObject.optInt("code") : 0) + "]: " + (jSONObject.has("msg") ? jSONObject.optString("msg") : "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: e */
    public static String m12704e(String str) {
        JSONObject optJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (optJSONObject = jSONObject.optJSONObject("data")) != null && optJSONObject.has(C3773a.f13778l)) {
                return optJSONObject.optString(C3773a.f13778l);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: f */
    public static boolean m12705f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("code") ? jSONObject.getInt("code") : 0) == 200;
        } catch (Throwable unused) {
            return false;
        }
    }

    private C3774b() {
    }

    /* renamed from: a */
    public static C3774b m12699a() {
        return a.f13792a;
    }

    /* renamed from: a */
    public void m12706a(Context context, String str, String str2, String str3, String str4, Map<String, String> map, final int i2, final TrackerResultHandler trackerResultHandler) {
        HashMap hashMap = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (String str5 : map.keySet()) {
                String str6 = map.get(str5);
                if (!TextUtils.isEmpty(str5) && str5.length() <= 16) {
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = "自定义属性[" + str5 + "]值为null或者空字符串。";
                    } else if (str6.length() <= 64) {
                        hashMap.put(str5, str6);
                    }
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            for (String str8 : hashMap.keySet()) {
                if (!TextUtils.isEmpty(str8)) {
                    jSONObject3.put(str8, hashMap.get(str8));
                }
            }
            jSONObject2.put(C3773a.f13770d, str);
            jSONObject2.put(C3773a.f13771e, str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put(C3773a.f13773g, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put(C3773a.f13772f, str3);
            } else {
                jSONObject2.put(C3773a.f13772f, (Object) null);
            }
            jSONObject.put(C3773a.f13769c, jSONObject2);
            jSONObject.put(C3773a.f13774h, jSONObject3);
            final String jSONObject4 = jSONObject.toString();
            context.getApplicationContext();
            C3777c.m12714a(new Runnable() { // from class: com.umeng.socialize.tracker.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str9 = jSONObject4;
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("Content-Type", "application/json");
                    C3776b c3776b = new C3776b(C3773a.f13767a, C3776b.a.POST, hashMap2, new HttpRequestListener() { // from class: com.umeng.socialize.tracker.b.1.1
                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        /* renamed from: a */
                        public void mo12707a() {
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        /* renamed from: a */
                        public void mo12708a(String str10) {
                            if (TextUtils.isEmpty(str10)) {
                                trackerResultHandler.codeGenerateFailed(new Throwable(EnumC3775a.EmptyResponse.m12712a()));
                                return;
                            }
                            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> utc:onRequestSuccess: " + str10);
                            if (C3774b.m12705f(str10)) {
                                String m12704e = C3774b.m12704e(str10);
                                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> utc:success:rootTrackCode: " + m12704e);
                                trackerResultHandler.codeGenerateSuccess(m12704e);
                                return;
                            }
                            String m12703d = C3774b.m12703d(str10);
                            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "--->>> utc:failed:error: " + m12703d);
                            trackerResultHandler.codeGenerateFailed(new Throwable(m12703d));
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        /* renamed from: a */
                        public void mo12709a(Throwable th) {
                            trackerResultHandler.codeGenerateFailed(th);
                        }
                    });
                    int i3 = i2;
                    c3776b.m12713a((i3 <= 0 || i3 > 10) ? 3000 : i3 * 1000, str9);
                }
            });
        } catch (Throwable unused) {
            trackerResultHandler.codeGenerateFailed(new Throwable(EnumC3775a.ErrorMakeRequestBody.m12712a()));
        }
    }
}
