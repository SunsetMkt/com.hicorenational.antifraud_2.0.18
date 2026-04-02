package com.umeng.socialize.tracker;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.socialize.tracker.utils.HttpRequestListener;
import com.umeng.socialize.tracker.utils.b;
import com.umeng.socialize.tracker.utils.c;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: TrackerManagerImpl.java */
/* JADX INFO: loaded from: classes2.dex */
class b {
    private static final String a = "TrackerManagerImpl";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f8376b = 3000;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String f8377c = "_$";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f8378d = 16;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f8379e = 64;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final String f8380f = "\u81ea\u5b9a\u4e49\u5c5e\u6027\u540d\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc716\u4e2a\u5b57\u7b26\u3002";

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final String f8381g = "\u81ea\u5b9a\u4e49\u5c5e\u6027\u503c\u957f\u5ea6\u4e0d\u80fd\u8d85\u8fc764\u4e2a\u5b57\u7b26\u3002";

    /* JADX INFO: compiled from: TrackerManagerImpl.java */
    private static class a {
        private static final b a = new b();

        private a() {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String d(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return "\u9519\u8bef\u8be6\u60c5 [" + (jSONObject.has("code") ? jSONObject.optInt("code") : 0) + "]: " + (jSONObject.has("msg") ? jSONObject.optString("msg") : "");
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static String e(String str) {
        JSONObject jSONObjectOptJSONObject;
        try {
            JSONObject jSONObject = new JSONObject(str);
            if (jSONObject.has("data") && (jSONObjectOptJSONObject = jSONObject.optJSONObject("data")) != null && jSONObjectOptJSONObject.has(com.umeng.socialize.tracker.a.f8374l)) {
                return jSONObjectOptJSONObject.optString(com.umeng.socialize.tracker.a.f8374l);
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean f(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            return (jSONObject.has("code") ? jSONObject.getInt("code") : 0) == 200;
        } catch (Throwable unused) {
            return false;
        }
    }

    private b() {
    }

    public static b a() {
        return a.a;
    }

    public void a(Context context, String str, String str2, String str3, String str4, Map<String, String> map, final int i2, final TrackerResultHandler trackerResultHandler) {
        HashMap map2 = new HashMap();
        if (map != null && !map.isEmpty()) {
            for (String str5 : map.keySet()) {
                String str6 = map.get(str5);
                if (!TextUtils.isEmpty(str5) && str5.length() <= 16) {
                    if (TextUtils.isEmpty(str6)) {
                        String str7 = "\u81ea\u5b9a\u4e49\u5c5e\u6027[" + str5 + "]\u503c\u4e3anull\u6216\u8005\u7a7a\u5b57\u7b26\u4e32\u3002";
                    } else if (str6.length() <= 64) {
                        map2.put(str5, str6);
                    }
                }
            }
        }
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        try {
            for (String str8 : map2.keySet()) {
                if (!TextUtils.isEmpty(str8)) {
                    jSONObject3.put(str8, map2.get(str8));
                }
            }
            jSONObject2.put(com.umeng.socialize.tracker.a.f8366d, str);
            jSONObject2.put(com.umeng.socialize.tracker.a.f8367e, str2);
            if (!TextUtils.isEmpty(str4)) {
                jSONObject2.put(com.umeng.socialize.tracker.a.f8369g, str4);
            }
            if (!TextUtils.isEmpty(str3)) {
                jSONObject2.put(com.umeng.socialize.tracker.a.f8368f, str3);
            } else {
                jSONObject2.put(com.umeng.socialize.tracker.a.f8368f, (Object) null);
            }
            jSONObject.put(com.umeng.socialize.tracker.a.f8365c, jSONObject2);
            jSONObject.put(com.umeng.socialize.tracker.a.f8370h, jSONObject3);
            final String string = jSONObject.toString();
            context.getApplicationContext();
            c.a(new Runnable() { // from class: com.umeng.socialize.tracker.b.1
                @Override // java.lang.Runnable
                public void run() {
                    String str9 = string;
                    HashMap map3 = new HashMap();
                    map3.put("Content-Type", "application/json");
                    com.umeng.socialize.tracker.utils.b bVar = new com.umeng.socialize.tracker.utils.b(com.umeng.socialize.tracker.a.a, b.a.POST, map3, new HttpRequestListener() { // from class: com.umeng.socialize.tracker.b.1.1
                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a() {
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a(String str10) {
                            if (TextUtils.isEmpty(str10)) {
                                trackerResultHandler.codeGenerateFailed(new Throwable(com.umeng.socialize.tracker.utils.a.EmptyResponse.a()));
                                return;
                            }
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> utc:onRequestSuccess: " + str10);
                            if (b.f(str10)) {
                                String strE = b.e(str10);
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> utc:success:rootTrackCode: " + strE);
                                trackerResultHandler.codeGenerateSuccess(strE);
                                return;
                            }
                            String strD = b.d(str10);
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> utc:failed:error: " + strD);
                            trackerResultHandler.codeGenerateFailed(new Throwable(strD));
                        }

                        @Override // com.umeng.socialize.tracker.utils.HttpRequestListener
                        public void a(Throwable th) {
                            trackerResultHandler.codeGenerateFailed(th);
                        }
                    });
                    int i3 = i2;
                    bVar.a((i3 <= 0 || i3 > 10) ? 3000 : i3 * 1000, str9);
                }
            });
        } catch (Throwable unused) {
            trackerResultHandler.codeGenerateFailed(new Throwable(com.umeng.socialize.tracker.utils.a.ErrorMakeRequestBody.a()));
        }
    }
}
