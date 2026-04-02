package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.aa;
import com.umeng.analytics.pro.ab;
import com.umeng.analytics.pro.ac;
import com.umeng.analytics.pro.ad;
import com.umeng.analytics.pro.ae;
import com.umeng.analytics.pro.af;
import com.umeng.analytics.pro.ah;
import com.umeng.analytics.pro.aj;
import com.umeng.analytics.pro.al;
import com.umeng.analytics.pro.an;
import com.umeng.analytics.pro.ao;
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.ar;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.z;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
import com.umeng.commonsdk.framework.UMEnvelopeBuild;
import com.umeng.commonsdk.service.UMGlobalContext;
import com.umeng.commonsdk.statistics.common.HelperUtils;
import com.umeng.commonsdk.statistics.idtracking.ImprintHandler;
import com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: Monitor.java */
/* JADX INFO: loaded from: classes2.dex */
public class d implements c.a {
    private static final String a = "iucc";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final String f7469b = at.b().b(at.C);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static JSONObject f7470c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final String[] f7471d = {com.umeng.ccg.a.f7442f, com.umeng.ccg.a.f7443g, com.umeng.ccg.a.f7444h};

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static ArrayList<aa> f7472e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static ArrayList<aa> f7473f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static ArrayList<aa> f7474g = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static c f7475j = new c();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private volatile String f7476h = "";

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private Map<String, a> f7477i = new HashMap();

    /* JADX INFO: compiled from: Monitor.java */
    public class a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private JSONArray f7478b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private String f7479c;

        public a(JSONArray jSONArray, String str) {
            this.f7478b = jSONArray;
            this.f7479c = str;
        }

        public JSONArray a() {
            return this.f7478b;
        }

        public String b() {
            return this.f7479c;
        }
    }

    /* JADX INFO: compiled from: Monitor.java */
    private static class b {
        private static final d a = new d();

        private b() {
        }
    }

    /* JADX INFO: compiled from: Monitor.java */
    public static class c extends BroadcastReceiver {
        public long a(ArrayList<aa> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    aa aaVar = arrayList.get(i2);
                    if (aaVar instanceof ac) {
                        return ((ac) aaVar).c();
                    }
                }
            }
            return 0L;
        }

        public boolean b(ArrayList<aa> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).b()) {
                    return false;
                }
            }
            return true;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            try {
                String action = intent.getAction();
                if (TextUtils.isEmpty(action)) {
                    return;
                }
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (b(d.f7472e)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f7472e) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.f7473f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f7473f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.f7474g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.f7474g) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(f7475j, intentFilter);
    }

    private String e(Context context) {
        try {
            SharedPreferences sharedPreferencesA = aq.a(context);
            return sharedPreferencesA != null ? sharedPreferencesA.getString(aq.f7010e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void f() {
        try {
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                sharedPreferencesA.edit().putString(aq.f7011f, new JSONObject(ap.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean g() {
        try {
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                return !TextUtils.isEmpty(sharedPreferencesA.getString(aq.f7012g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private long b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    private void c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences sharedPreferencesA = aq.a(context);
            if (sharedPreferencesA != null) {
                return Long.valueOf(sharedPreferencesA.getLong(aq.f7009d, 0L));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null && (jSONObject instanceof JSONObject) && jSONObject.has(com.umeng.ccg.a.a)) {
            try {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.a);
                z zVarA = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f7438b) ? a(com.umeng.ccg.a.f7438b, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f7438b)) : null;
                z zVarA2 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f7439c) ? a(com.umeng.ccg.a.f7439c, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f7439c)) : null;
                z zVarA3 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f7440d) ? a(com.umeng.ccg.a.f7440d, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f7440d)) : null;
                z zVarA4 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f7441e) ? a(com.umeng.ccg.a.f7441e, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f7441e)) : null;
                z zVarA5 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f7442f) ? a(com.umeng.ccg.a.f7442f, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f7442f)) : null;
                z zVarA6 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f7443g) ? a(com.umeng.ccg.a.f7443g, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f7443g)) : null;
                z zVarA7 = jSONObjectOptJSONObject.has(com.umeng.ccg.a.f7444h) ? a(com.umeng.ccg.a.f7444h, jSONObjectOptJSONObject.optJSONObject(com.umeng.ccg.a.f7444h)) : null;
                ArrayList arrayList = new ArrayList();
                if (zVarA != null) {
                    arrayList.add(zVarA);
                }
                if (zVarA2 != null) {
                    arrayList.add(zVarA2);
                }
                if (zVarA3 != null) {
                    arrayList.add(zVarA3);
                }
                if (zVarA4 != null) {
                    arrayList.add(zVarA4);
                }
                if (zVarA5 != null) {
                    arrayList.add(zVarA5);
                }
                if (zVarA6 != null) {
                    arrayList.add(zVarA6);
                }
                if (zVarA7 != null) {
                    arrayList.add(zVarA7);
                }
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean e() {
        SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
        if (sharedPreferencesA != null) {
            String string = sharedPreferencesA.getString(aq.f7011f, "");
            if (TextUtils.isEmpty(string)) {
                f();
                return false;
            }
            try {
                if (!ap.a().keySet().equals(ap.a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    public static d a() {
        return b.a;
    }

    private JSONObject b(Context context) {
        FileInputStream fileInputStreamOpenFileInput;
        try {
            if (!new File(context.getFilesDir(), f7469b).exists()) {
                return null;
            }
            try {
                fileInputStreamOpenFileInput = context.openFileInput(f7469b);
                try {
                    JSONObject jSONObject = new JSONObject(new String(as.a(HelperUtils.readStreamToByteArray(fileInputStreamOpenFileInput), UMConfigure.sAppkey.getBytes())));
                    try {
                        ap.a(fileInputStreamOpenFileInput);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                } catch (Throwable unused2) {
                    ap.a(fileInputStreamOpenFileInput);
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStreamOpenFileInput = null;
            }
        } catch (Throwable unused4) {
            return null;
        }
    }

    public void a(Context context) {
        com.umeng.ccg.c.a(context, 105, a(), null);
    }

    private boolean a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has(com.umeng.ccg.a.a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(Context context, JSONObject jSONObject, String str) {
        try {
            long jB = b(jSONObject);
            byte[] bArrA = as.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (bArrA != null && bArrA.length > 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f7469b));
                try {
                    fileOutputStream.write(bArrA);
                    fileOutputStream.flush();
                    ap.a(fileOutputStream);
                    a(context, str, jB);
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
                } catch (Throwable th) {
                    ap.a(fileOutputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    private void b(String str) {
        String str2 = aq.f7007b + str;
        SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
        if (sharedPreferencesA != null) {
            sharedPreferencesA.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, aa aaVar) {
        if (com.umeng.ccg.a.f7442f.equalsIgnoreCase(str)) {
            if (f7472e == null) {
                f7472e = new ArrayList<>();
            }
            f7472e.add(aaVar);
        }
        if (com.umeng.ccg.a.f7443g.equalsIgnoreCase(str)) {
            if (f7473f == null) {
                f7473f = new ArrayList<>();
            }
            f7473f.add(aaVar);
        }
        if (com.umeng.ccg.a.f7444h.equalsIgnoreCase(str)) {
            if (f7474g == null) {
                f7474g = new ArrayList<>();
            }
            f7474g.add(aaVar);
        }
    }

    private z a(String str, JSONObject jSONObject) {
        JSONArray jSONArrayOptJSONArray;
        String str2;
        String str3;
        z zVar;
        JSONArray jSONArrayOptJSONArray2;
        if (jSONObject != null && (jSONObject instanceof JSONObject)) {
            try {
                if (jSONObject.has(com.umeng.ccg.a.f7445i) && (jSONArrayOptJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.f7445i)) != null && jSONArrayOptJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) jSONArrayOptJSONArray.get(0);
                    boolean zHas = jSONObject2.has(com.umeng.ccg.a.f7446j);
                    boolean zHas2 = jSONObject2.has(com.umeng.ccg.a.f7449m);
                    boolean zHas3 = jSONObject2.has(com.umeng.ccg.a.f7450n);
                    if (!zHas || !zHas2 || !zHas3) {
                        return null;
                    }
                    try {
                        int iOptInt = jSONObject2.optInt(com.umeng.ccg.a.f7446j);
                        long jOptLong = jSONObject2.optLong(com.umeng.ccg.a.f7449m);
                        long jOptLong2 = jSONObject2.optLong(com.umeng.ccg.a.f7450n);
                        String strOptString = jSONObject2.optString(com.umeng.ccg.a.o);
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has(com.umeng.ccg.a.f7447k)) {
                            JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.f7447k);
                            str2 = "action";
                            HashSet hashSet = new HashSet();
                            if (jSONArrayOptJSONArray3 != null) {
                                str3 = com.umeng.ccg.a.r;
                                int i2 = 0;
                                for (int length = jSONArrayOptJSONArray3.length(); i2 < length; length = length) {
                                    hashSet.add(Integer.valueOf(jSONArrayOptJSONArray3.getInt(i2)));
                                    i2++;
                                }
                            } else {
                                str3 = com.umeng.ccg.a.r;
                            }
                            if (hashSet.size() > 0) {
                                aj ajVar = new aj(hashSet);
                                if (Arrays.asList(f7471d).contains(str)) {
                                    a(str, ajVar);
                                } else {
                                    arrayList.add(ajVar);
                                }
                            }
                        } else {
                            str2 = "action";
                            str3 = com.umeng.ccg.a.r;
                        }
                        if (jSONObject2.has(com.umeng.ccg.a.f7448l)) {
                            String strOptString2 = jSONObject2.optString(com.umeng.ccg.a.f7448l);
                            if (!TextUtils.isEmpty(strOptString2)) {
                                ah ahVar = new ah(strOptString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i3 = 1; i3 <= 24; i3++) {
                                    if (ahVar.a(i3)) {
                                        hashSet2.add(Integer.valueOf(i3));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    ad adVar = new ad(hashSet2);
                                    if (Arrays.asList(f7471d).contains(str)) {
                                        a(str, adVar);
                                    } else {
                                        arrayList.add(adVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new af(iOptInt));
                        ae aeVar = new ae(str, jOptLong);
                        if (Arrays.asList(f7471d).contains(str)) {
                            a(str, aeVar);
                        } else {
                            arrayList.add(aeVar);
                        }
                        ac acVar = new ac(jOptLong2);
                        if (Arrays.asList(f7471d).contains(str)) {
                            a(str, acVar);
                            arrayList.add(acVar);
                        } else {
                            arrayList.add(acVar);
                        }
                        if (com.umeng.ccg.a.f7441e.equals(str)) {
                            zVar = new ab(str, arrayList);
                        } else {
                            zVar = new z(str, arrayList);
                        }
                        try {
                            zVar.a(strOptString);
                            String str4 = "";
                            String str5 = str3;
                            if (jSONObject.has(str5) && (jSONArrayOptJSONArray2 = jSONObject.optJSONArray(str5)) != null && (jSONArrayOptJSONArray2 instanceof JSONArray)) {
                                if (this.f7477i != null && !this.f7477i.containsKey(str)) {
                                    this.f7477i.put(str, new a(new JSONArray(jSONArrayOptJSONArray2.toString()), strOptString));
                                }
                                int length2 = jSONArrayOptJSONArray2.length();
                                String str6 = "";
                                for (int i4 = 0; i4 < jSONArrayOptJSONArray2.length(); i4++) {
                                    str6 = str6 + jSONArrayOptJSONArray2.getString(i4);
                                    if (i4 < length2 - 1) {
                                        str6 = str6 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                    }
                                }
                                str4 = str6;
                            }
                            zVar.b(str4);
                            if (com.umeng.ccg.a.f7441e.equals(str) && (zVar instanceof ab)) {
                                String str7 = str2;
                                if (jSONObject2.has(str7)) {
                                    ((ab) zVar).d(jSONObject2.optString(str7));
                                }
                                if (jSONObject2.has(com.umeng.ccg.a.s)) {
                                    ((ab) zVar).c(jSONObject2.optString(com.umeng.ccg.a.s));
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        return zVar;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    private void a(Context context, String str, long j2) {
        SharedPreferences sharedPreferencesA;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length != 4 || (sharedPreferencesA = aq.a(context)) == null) {
                return;
            }
            long j3 = Long.parseLong(strArrSplit[0]);
            String str2 = strArrSplit[1];
            SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
            editorEdit.putLong(aq.f7008c, j2);
            editorEdit.putLong(aq.f7009d, j3);
            editorEdit.putString(aq.f7010e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + j3 + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] strArrSplit = str.split("@");
            if (strArrSplit.length != 4) {
                return;
            }
            long j2 = Long.parseLong(strArrSplit[0]);
            String str2 = strArrSplit[1];
            if (!TextUtils.isEmpty(this.f7476h)) {
                String[] strArrSplit2 = this.f7476h.split("@");
                if (strArrSplit2.length == 2) {
                    long j3 = Long.parseLong(strArrSplit2[0]);
                    String str3 = strArrSplit2[1];
                    if (j3 == j2 && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "\u91cd\u590d\u7684iucc S1 and S2, \u5ffd\u7565\u672c\u6b21\u66f4\u65b0\uff0c\u4e0d\u53d1\u8d77fetch\u3002");
                        return;
                    }
                }
            }
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                if (sharedPreferencesA.getLong(aq.f7008c, 0L) != j2) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f7476h = String.valueOf(j2) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f7476h = String.valueOf(j2) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z) {
        try {
            SharedPreferences sharedPreferencesA = aq.a(UMGlobalContext.getAppContext());
            if (sharedPreferencesA != null) {
                SharedPreferences.Editor editorEdit = sharedPreferencesA.edit();
                if (z) {
                    editorEdit.putString(aq.f7012g, "1").commit();
                } else {
                    editorEdit.putString(aq.f7012g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v10, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v14, types: [org.json.JSONObject] */
    /* JADX WARN: Type inference failed for: r4v38 */
    /* JADX WARN: Type inference failed for: r4v39 */
    /* JADX WARN: Type inference failed for: r4v40 */
    /* JADX WARN: Type inference failed for: r4v5 */
    /* JADX WARN: Type inference failed for: r4v6, types: [int] */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v9, types: [org.json.JSONObject] */
    @Override // com.umeng.ccg.c.a
    public void a(Object obj, int i2) {
        Integer numValueOf;
        ArrayList arrayList;
        int size;
        a aVar;
        a aVar2;
        a aVar3;
        JSONObject jSONObjectB = null;
        boolean z = true;
        int i3 = 0;
        try {
            switch (i2) {
                case 101:
                    if (obj != null && (obj instanceof String)) {
                        String str = (String) obj;
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_NEW_CONFIG msg. source iucc is: " + str);
                        JSONObject jSONObjectA = al.a(UMGlobalContext.getAppContext(), str);
                        if (jSONObjectA != null) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "[imprint] send request. body: " + jSONObjectA.toString());
                            ar.a(new ao(ao.a, jSONObjectA, str), 0L, TimeUnit.SECONDS);
                        }
                        if (g()) {
                            c(UMGlobalContext.getAppContext());
                            String strImprintProperty = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), a, "");
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + strImprintProperty);
                            a(strImprintProperty);
                        }
                        break;
                    }
                    break;
                case 102:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_RESPONSE msg.");
                    this.f7476h = "";
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject = (JSONObject) obj;
                        if (a(jSONObject.optJSONObject("config"))) {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 103, a(), jSONObject);
                        } else {
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                        }
                    } else {
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 104, a(), null);
                    }
                    break;
                case 103:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_SUCCESS msg.");
                    Context appContext = UMGlobalContext.getAppContext();
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject2 = (JSONObject) obj;
                        JSONObject jSONObjectOptJSONObject = jSONObject2.optJSONObject("config");
                        String strOptString = jSONObject2.optString("sourceIucc");
                        if (jSONObjectOptJSONObject != null) {
                            if (g()) {
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> \u6210\u529f\u62c9\u53d6\u4e91\u914d\u53c2\u6570\u540e\uff0c\u68c0\u6d4b\u5230should fetch\u6807\u5fd7\uff0c\u6e05\u9664\u6b64\u6807\u5fd7\u3002\u66f4\u65b0SDK\u7c7b\u578b\u96c6\u7f13\u5b58\u503c");
                                f();
                                a(false);
                            }
                            a(appContext, jSONObjectOptJSONObject, strOptString);
                        }
                        break;
                    }
                    break;
                case 104:
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv FETCH_FAILED msg.");
                    break;
                case 105:
                    String[] collectItemList = CcgAgent.getCollectItemList();
                    int length = collectItemList.length;
                    ?? jSONObject3 = 0;
                    while (jSONObject3 < length) {
                        String str2 = collectItemList[jSONObject3];
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "[forbid_sdk] \u91c7\u96c6\u9879: " + str2 + "; \u503c: " + CcgAgent.getForbidSdkArray(str2).toString());
                        jSONObject3++;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "[workEvent]: recv LOAD_CONFIG msg.");
                    Integer num = 0;
                    try {
                        try {
                            jSONObjectB = b(UMGlobalContext.getAppContext());
                            if (jSONObjectB != null && (jSONObjectB instanceof JSONObject) && a(jSONObjectB)) {
                                numValueOf = Integer.valueOf(num.intValue() | 1);
                            } else {
                                numValueOf = Integer.valueOf(num.intValue() | 0);
                            }
                            jSONObject3 = new JSONObject();
                            jSONObject3.put("result", numValueOf);
                        } catch (Throwable unused) {
                            jSONObject3 = new JSONObject();
                            jSONObject3.put("result", num);
                            if (0 != 0) {
                                jSONObject3 = jSONObject3;
                                if (jSONObjectB instanceof JSONObject) {
                                }
                            }
                        }
                        if (jSONObjectB != null) {
                            jSONObject3 = jSONObject3;
                            if (jSONObjectB instanceof JSONObject) {
                                jSONObject3.put("config", jSONObjectB);
                            }
                        }
                        break;
                    } catch (Throwable unused2) {
                    }
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 106, a(), jSONObject3);
                    break;
                case 106:
                    if (obj != null && (obj instanceof JSONObject)) {
                        JSONObject jSONObject4 = (JSONObject) obj;
                        if (jSONObject4 != null && jSONObject4.has("result")) {
                            if ((jSONObject4.optInt("result") & 1) != 0 && jSONObject4.has("config")) {
                                f7470c = jSONObject4.optJSONObject("config");
                                if (f7470c != null) {
                                    CcgAgent.notifyConfigReady(f7470c);
                                    i3 = 1;
                                }
                            }
                            if (i3 == 0) {
                                CcgAgent.notifyConfigReady(null);
                            }
                        }
                        if (e()) {
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "--->>> \u68c0\u6d4b\u5230\u96c6\u6210\u7684SDK\u7c7b\u578b\u96c6\u5408\u53d1\u751f\u53d8\u5316\uff0c\u53d1\u8d77\u4e91\u914d\u53c2\u6570\u62c9\u53d6\u8bf7\u6c42(\u8bbe\u7f6e\u672c\u5730should fetch\u6807\u5fd7).");
                            String strImprintProperty2 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), a, "");
                            a(true);
                            com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), strImprintProperty2);
                        } else {
                            c(UMGlobalContext.getAppContext());
                            String strImprintProperty3 = UMEnvelopeBuild.imprintProperty(UMGlobalContext.getAppContext(), a, "");
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "manual check iucc value: " + strImprintProperty3);
                            a(strImprintProperty3);
                        }
                        break;
                    }
                    break;
                case 107:
                    if (obj != null) {
                        try {
                            if (obj instanceof String) {
                                String str3 = (String) obj;
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "[IMPRINT_IUCC_CHANGED] iucc : " + str3);
                                a(str3);
                            }
                        } catch (Throwable th) {
                            UMRTLog.e(UMRTLog.RTLOG_TAG, "[imprint] process error " + th.getMessage());
                            return;
                        }
                    }
                    break;
                default:
                    switch (i2) {
                        case 201:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv PARSE_CONFIG msg.");
                            if (obj != null && (obj instanceof JSONObject)) {
                                c((JSONObject) obj);
                                break;
                            }
                            break;
                        case 202:
                            UMRTLog.i(UMRTLog.RTLOG_TAG, "recv COLLECTION_JUDGMENT msg.");
                            if (obj != null && (obj instanceof ArrayList) && (size = (arrayList = (ArrayList) obj).size()) > 0) {
                                while (i3 < size) {
                                    z zVar = (z) arrayList.get(i3);
                                    JSONObject jSONObjectA2 = zVar.a(zVar.a(), null);
                                    if (jSONObjectA2 != null) {
                                        long jOptLong = !Arrays.asList(f7471d).contains(zVar.a()) ? jSONObjectA2.optLong("delay") * 1000 : 0L;
                                        jSONObjectA2.remove("delay");
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "send START_COLLECT msg, delayTs = " + jOptLong);
                                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 203, a(), jSONObjectA2, jOptLong);
                                    }
                                    i3++;
                                }
                                break;
                            }
                            break;
                        case 203:
                            if (obj != null && (obj instanceof JSONObject)) {
                                JSONObject jSONObject5 = (JSONObject) obj;
                                String strOptString2 = jSONObject5.optString("actionName");
                                UMRTLog.i(UMRTLog.RTLOG_TAG, "recv START_COLLECT msg. name is : " + strOptString2);
                                if (com.umeng.ccg.b.a(strOptString2)) {
                                    String string = jSONObject5.toString();
                                    if (Arrays.asList(f7471d).contains(strOptString2)) {
                                        if (com.umeng.ccg.a.f7442f.equalsIgnoreCase(strOptString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_ON");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_ON");
                                        }
                                        if (com.umeng.ccg.a.f7443g.equalsIgnoreCase(strOptString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_SCREEN_OFF");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.SCREEN_OFF");
                                        }
                                        if (com.umeng.ccg.a.f7444h.equalsIgnoreCase(strOptString2)) {
                                            UMRTLog.i(UMRTLog.RTLOG_TAG, "register Intent.ACTION_USER_PRESENT");
                                            a(UMGlobalContext.getAppContext(), "android.intent.action.USER_PRESENT");
                                        }
                                    } else {
                                        b(strOptString2);
                                        if (CcgAgent.hasRegistedActionInfo()) {
                                            if (CcgAgent.getActionInfo("anti") == null) {
                                                z = false;
                                            }
                                            String strOptString3 = jSONObject5.optString(com.umeng.ccg.a.p);
                                            if (TextUtils.isEmpty(strOptString3)) {
                                                UMRTLog.i(UMRTLog.RTLOG_TAG, "\u5ffd\u7565 \u672c\u6b21\u91c7\u96c6\u9879[" + strOptString2 + "]\u91c7\u96c6\u8bf7\u6c42.");
                                            } else {
                                                ActionInfo actionInfo = CcgAgent.getActionInfo(strOptString3);
                                                if (actionInfo != null) {
                                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "\u8c03\u7528[" + strOptString3 + "] onCommand\u63a5\u53e3\u65b9\u6cd5, \u53c2\u6570: " + jSONObject5.toString());
                                                    actionInfo.onCommand(UMGlobalContext.getAppContext(), strOptString2, jSONObject5);
                                                }
                                            }
                                            if (!z) {
                                                ap.a(UMGlobalContext.getAppContext(), string);
                                            }
                                        } else {
                                            ap.a(UMGlobalContext.getAppContext(), string);
                                        }
                                    }
                                } else {
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "Local switch of [" + strOptString2 + "] is off, ignore this command.");
                                }
                                break;
                            }
                            break;
                        default:
                            switch (i2) {
                                case 301:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_ON msg.");
                                    b(com.umeng.ccg.a.f7442f);
                                    if (this.f7477i.containsKey(com.umeng.ccg.a.f7442f) && (aVar = this.f7477i.get(com.umeng.ccg.a.f7442f)) != null) {
                                        JSONObject jSONObjectA3 = al.a(UMGlobalContext.getAppContext(), 1, aVar.a(), aVar.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_on event param: " + jSONObjectA3.toString());
                                        ar.a(new an(an.a, jSONObjectA3), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 302:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_OFF msg.");
                                    b(com.umeng.ccg.a.f7443g);
                                    if (this.f7477i.containsKey(com.umeng.ccg.a.f7443g) && (aVar2 = this.f7477i.get(com.umeng.ccg.a.f7443g)) != null) {
                                        JSONObject jSONObjectA4 = al.a(UMGlobalContext.getAppContext(), 3, aVar2.a(), aVar2.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_off event param: " + jSONObjectA4.toString());
                                        ar.a(new an(an.a, jSONObjectA4), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                                case 303:
                                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv REPORT_SCREEN_UNLOCK msg.");
                                    b(com.umeng.ccg.a.f7444h);
                                    if (this.f7477i.containsKey(com.umeng.ccg.a.f7444h) && (aVar3 = this.f7477i.get(com.umeng.ccg.a.f7444h)) != null) {
                                        JSONObject jSONObjectA5 = al.a(UMGlobalContext.getAppContext(), 2, aVar3.a(), aVar3.b());
                                        UMRTLog.i(UMRTLog.RTLOG_TAG, "screen_unlock event param: " + jSONObjectA5.toString());
                                        ar.a(new an(an.a, jSONObjectA5), 0L, TimeUnit.SECONDS);
                                        break;
                                    }
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } catch (Throwable unused3) {
        }
    }
}
