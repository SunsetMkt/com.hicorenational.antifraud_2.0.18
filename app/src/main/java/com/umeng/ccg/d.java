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
import com.umeng.analytics.pro.ap;
import com.umeng.analytics.pro.aq;
import com.umeng.analytics.pro.as;
import com.umeng.analytics.pro.at;
import com.umeng.analytics.pro.z;
import com.umeng.ccg.c;
import com.umeng.commonsdk.UMConfigure;
import com.umeng.commonsdk.debug.UMRTLog;
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
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: Monitor.java */
/* loaded from: classes2.dex */
public class d implements c.a {

    /* renamed from: a, reason: collision with root package name */
    private static final String f10623a = "iucc";

    /* renamed from: b, reason: collision with root package name */
    private static final String f10624b = at.b().b(at.C);

    /* renamed from: c, reason: collision with root package name */
    private static JSONObject f10625c = null;

    /* renamed from: d, reason: collision with root package name */
    private static final String[] f10626d = {com.umeng.ccg.a.f10596f, com.umeng.ccg.a.f10597g, com.umeng.ccg.a.f10598h};

    /* renamed from: e, reason: collision with root package name */
    private static ArrayList<aa> f10627e = null;

    /* renamed from: f, reason: collision with root package name */
    private static ArrayList<aa> f10628f = null;

    /* renamed from: g, reason: collision with root package name */
    private static ArrayList<aa> f10629g = null;

    /* renamed from: j, reason: collision with root package name */
    private static c f10630j = new c();

    /* renamed from: h, reason: collision with root package name */
    private volatile String f10631h = "";

    /* renamed from: i, reason: collision with root package name */
    private Map<String, a> f10632i = new HashMap();

    /* compiled from: Monitor.java */
    public class a {

        /* renamed from: b, reason: collision with root package name */
        private JSONArray f10635b;

        /* renamed from: c, reason: collision with root package name */
        private String f10636c;

        public a(JSONArray jSONArray, String str) {
            this.f10635b = jSONArray;
            this.f10636c = str;
        }

        public JSONArray a() {
            return this.f10635b;
        }

        public String b() {
            return this.f10636c;
        }
    }

    /* compiled from: Monitor.java */
    private static class b {

        /* renamed from: a, reason: collision with root package name */
        private static final d f10637a = new d();

        private b() {
        }
    }

    /* compiled from: Monitor.java */
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
                    if (b(d.f10627e)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 301, d.a(), null, a(d.f10627e) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (b(d.f10628f)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 302, d.a(), null, a(d.f10628f) * 1000);
                    } else {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!b(d.f10629g)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 303, d.a(), null, a(d.f10629g) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(f10630j, intentFilter);
    }

    private String e(Context context) {
        try {
            SharedPreferences a2 = aq.a(context);
            return a2 != null ? a2.getString(aq.f10059e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    private void f() {
        try {
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                a2.edit().putString(aq.f10060f, new JSONObject(ap.a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    private boolean g() {
        try {
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                return !TextUtils.isEmpty(a2.getString(aq.f10061g, ""));
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
        ImprintHandler.getImprintService(context).registImprintCallback(f10623a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 107, d.a(), str2);
            }
        });
    }

    private Long d(Context context) {
        try {
            SharedPreferences a2 = aq.a(context);
            if (a2 != null) {
                return Long.valueOf(a2.getLong(aq.f10058d, 0L));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject != null && (jSONObject instanceof JSONObject) && jSONObject.has(com.umeng.ccg.a.f10591a)) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(com.umeng.ccg.a.f10591a);
                z a2 = optJSONObject.has(com.umeng.ccg.a.f10592b) ? a(com.umeng.ccg.a.f10592b, optJSONObject.optJSONObject(com.umeng.ccg.a.f10592b)) : null;
                z a3 = optJSONObject.has(com.umeng.ccg.a.f10593c) ? a(com.umeng.ccg.a.f10593c, optJSONObject.optJSONObject(com.umeng.ccg.a.f10593c)) : null;
                z a4 = optJSONObject.has(com.umeng.ccg.a.f10594d) ? a(com.umeng.ccg.a.f10594d, optJSONObject.optJSONObject(com.umeng.ccg.a.f10594d)) : null;
                z a5 = optJSONObject.has(com.umeng.ccg.a.f10595e) ? a(com.umeng.ccg.a.f10595e, optJSONObject.optJSONObject(com.umeng.ccg.a.f10595e)) : null;
                z a6 = optJSONObject.has(com.umeng.ccg.a.f10596f) ? a(com.umeng.ccg.a.f10596f, optJSONObject.optJSONObject(com.umeng.ccg.a.f10596f)) : null;
                z a7 = optJSONObject.has(com.umeng.ccg.a.f10597g) ? a(com.umeng.ccg.a.f10597g, optJSONObject.optJSONObject(com.umeng.ccg.a.f10597g)) : null;
                z a8 = optJSONObject.has(com.umeng.ccg.a.f10598h) ? a(com.umeng.ccg.a.f10598h, optJSONObject.optJSONObject(com.umeng.ccg.a.f10598h)) : null;
                ArrayList arrayList = new ArrayList();
                if (a2 != null) {
                    arrayList.add(a2);
                }
                if (a3 != null) {
                    arrayList.add(a3);
                }
                if (a4 != null) {
                    arrayList.add(a4);
                }
                if (a5 != null) {
                    arrayList.add(a5);
                }
                if (a6 != null) {
                    arrayList.add(a6);
                }
                if (a7 != null) {
                    arrayList.add(a7);
                }
                if (a8 != null) {
                    arrayList.add(a8);
                }
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 202, a(), arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    private boolean e() {
        SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
        if (a2 != null) {
            String string = a2.getString(aq.f10060f, "");
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
        return b.f10637a;
    }

    private JSONObject b(Context context) {
        FileInputStream fileInputStream;
        try {
            if (!new File(context.getFilesDir(), f10624b).exists()) {
                return null;
            }
            try {
                fileInputStream = context.openFileInput(f10624b);
                try {
                    JSONObject jSONObject = new JSONObject(new String(as.a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
                    try {
                        ap.a(fileInputStream);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                } catch (Throwable unused2) {
                    ap.a(fileInputStream);
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
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
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has(com.umeng.ccg.a.f10591a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    private void a(Context context, JSONObject jSONObject, String str) {
        try {
            long b2 = b(jSONObject);
            byte[] a2 = as.a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (a2 != null && a2.length > 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f10624b));
                try {
                    fileOutputStream.write(a2);
                    fileOutputStream.flush();
                    ap.a(fileOutputStream);
                    a(context, str, b2);
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
        String str2 = aq.f10056b + str;
        SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
        if (a2 != null) {
            a2.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    private void a(String str, aa aaVar) {
        if (com.umeng.ccg.a.f10596f.equalsIgnoreCase(str)) {
            if (f10627e == null) {
                f10627e = new ArrayList<>();
            }
            f10627e.add(aaVar);
        }
        if (com.umeng.ccg.a.f10597g.equalsIgnoreCase(str)) {
            if (f10628f == null) {
                f10628f = new ArrayList<>();
            }
            f10628f.add(aaVar);
        }
        if (com.umeng.ccg.a.f10598h.equalsIgnoreCase(str)) {
            if (f10629g == null) {
                f10629g = new ArrayList<>();
            }
            f10629g.add(aaVar);
        }
    }

    private z a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        String str2;
        String str3;
        z zVar;
        JSONArray optJSONArray2;
        if (jSONObject != null && (jSONObject instanceof JSONObject)) {
            try {
                if (jSONObject.has(com.umeng.ccg.a.f10599i) && (optJSONArray = jSONObject.optJSONArray(com.umeng.ccg.a.f10599i)) != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject2.has(com.umeng.ccg.a.f10600j);
                    boolean has2 = jSONObject2.has(com.umeng.ccg.a.f10603m);
                    boolean has3 = jSONObject2.has(com.umeng.ccg.a.n);
                    if (!has || !has2 || !has3) {
                        return null;
                    }
                    try {
                        int optInt = jSONObject2.optInt(com.umeng.ccg.a.f10600j);
                        long optLong = jSONObject2.optLong(com.umeng.ccg.a.f10603m);
                        long optLong2 = jSONObject2.optLong(com.umeng.ccg.a.n);
                        String optString = jSONObject2.optString(com.umeng.ccg.a.o);
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has(com.umeng.ccg.a.f10601k)) {
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray(com.umeng.ccg.a.f10601k);
                            str2 = "action";
                            HashSet hashSet = new HashSet();
                            if (optJSONArray3 != null) {
                                str3 = com.umeng.ccg.a.r;
                                int i2 = 0;
                                for (int length = optJSONArray3.length(); i2 < length; length = length) {
                                    hashSet.add(Integer.valueOf(optJSONArray3.getInt(i2)));
                                    i2++;
                                }
                            } else {
                                str3 = com.umeng.ccg.a.r;
                            }
                            if (hashSet.size() > 0) {
                                aj ajVar = new aj(hashSet);
                                if (Arrays.asList(f10626d).contains(str)) {
                                    a(str, ajVar);
                                } else {
                                    arrayList.add(ajVar);
                                }
                            }
                        } else {
                            str2 = "action";
                            str3 = com.umeng.ccg.a.r;
                        }
                        if (jSONObject2.has(com.umeng.ccg.a.f10602l)) {
                            String optString2 = jSONObject2.optString(com.umeng.ccg.a.f10602l);
                            if (!TextUtils.isEmpty(optString2)) {
                                ah ahVar = new ah(optString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i3 = 1; i3 <= 24; i3++) {
                                    if (ahVar.a(i3)) {
                                        hashSet2.add(Integer.valueOf(i3));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    ad adVar = new ad(hashSet2);
                                    if (Arrays.asList(f10626d).contains(str)) {
                                        a(str, adVar);
                                    } else {
                                        arrayList.add(adVar);
                                    }
                                }
                            }
                        }
                        arrayList.add(new af(optInt));
                        ae aeVar = new ae(str, optLong);
                        if (Arrays.asList(f10626d).contains(str)) {
                            a(str, aeVar);
                        } else {
                            arrayList.add(aeVar);
                        }
                        ac acVar = new ac(optLong2);
                        if (Arrays.asList(f10626d).contains(str)) {
                            a(str, acVar);
                            arrayList.add(acVar);
                        } else {
                            arrayList.add(acVar);
                        }
                        if (com.umeng.ccg.a.f10595e.equals(str)) {
                            zVar = new ab(str, arrayList);
                        } else {
                            zVar = new z(str, arrayList);
                        }
                        try {
                            zVar.a(optString);
                            String str4 = "";
                            String str5 = str3;
                            if (jSONObject.has(str5) && (optJSONArray2 = jSONObject.optJSONArray(str5)) != null && (optJSONArray2 instanceof JSONArray)) {
                                if (this.f10632i != null && !this.f10632i.containsKey(str)) {
                                    this.f10632i.put(str, new a(new JSONArray(optJSONArray2.toString()), optString));
                                }
                                int length2 = optJSONArray2.length();
                                String str6 = "";
                                for (int i4 = 0; i4 < optJSONArray2.length(); i4++) {
                                    str6 = str6 + optJSONArray2.getString(i4);
                                    if (i4 < length2 - 1) {
                                        str6 = str6 + Constants.ACCEPT_TIME_SEPARATOR_SP;
                                    }
                                }
                                str4 = str6;
                            }
                            zVar.b(str4);
                            if (com.umeng.ccg.a.f10595e.equals(str) && (zVar instanceof ab)) {
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
        SharedPreferences a2;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (a2 = aq.a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = a2.edit();
            edit.putLong(aq.f10057c, j2);
            edit.putLong(aq.f10058d, parseLong);
            edit.putString(aq.f10059e, str2).commit();
            UMRTLog.i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    private void a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.f10631h)) {
                String[] split2 = this.f10631h.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                if (a2.getLong(aq.f10057c, 0L) != parseLong) {
                    UMRTLog.i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f10631h = String.valueOf(parseLong) + "@" + str2;
                    com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
                    return;
                }
                d(UMGlobalContext.getAppContext());
                if (e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f10631h = String.valueOf(parseLong) + "@" + str2;
                com.umeng.ccg.c.a(UMGlobalContext.getAppContext(), 101, a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    private void a(boolean z) {
        try {
            SharedPreferences a2 = aq.a(UMGlobalContext.getAppContext());
            if (a2 != null) {
                SharedPreferences.Editor edit = a2.edit();
                if (z) {
                    edit.putString(aq.f10061g, "1").commit();
                } else {
                    edit.putString(aq.f10061g, "").commit();
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:161:0x03ce, code lost:
    
        if ((r7 instanceof org.json.JSONObject) != false) goto L135;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x03df, code lost:
    
        r4.put("config", r7);
     */
    /* JADX WARN: Code restructure failed: missing block: B:172:0x03dd, code lost:
    
        if ((r7 instanceof org.json.JSONObject) != false) goto L135;
     */
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
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(java.lang.Object r19, int r20) {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.d.a(java.lang.Object, int):void");
    }
}
