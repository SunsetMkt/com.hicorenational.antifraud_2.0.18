package com.umeng.ccg;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3318ab;
import com.umeng.analytics.pro.C3319ac;
import com.umeng.analytics.pro.C3320ad;
import com.umeng.analytics.pro.C3321ae;
import com.umeng.analytics.pro.C3322af;
import com.umeng.analytics.pro.C3324ah;
import com.umeng.analytics.pro.C3326aj;
import com.umeng.analytics.pro.C3332ap;
import com.umeng.analytics.pro.C3333aq;
import com.umeng.analytics.pro.C3335as;
import com.umeng.analytics.pro.C3336at;
import com.umeng.analytics.pro.C3425z;
import com.umeng.analytics.pro.InterfaceC3317aa;
import com.umeng.ccg.C3440c;
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
/* renamed from: com.umeng.ccg.d */
/* loaded from: classes2.dex */
public class C3441d implements C3440c.a {

    /* renamed from: a */
    private static final String f12374a = "iucc";

    /* renamed from: b */
    private static final String f12375b = C3336at.m10865b().m10868b(C3336at.f11484C);

    /* renamed from: c */
    private static JSONObject f12376c = null;

    /* renamed from: d */
    private static final String[] f12377d = {C3438a.f12333f, C3438a.f12334g, C3438a.f12335h};

    /* renamed from: e */
    private static ArrayList<InterfaceC3317aa> f12378e = null;

    /* renamed from: f */
    private static ArrayList<InterfaceC3317aa> f12379f = null;

    /* renamed from: g */
    private static ArrayList<InterfaceC3317aa> f12380g = null;

    /* renamed from: j */
    private static c f12381j = new c();

    /* renamed from: h */
    private volatile String f12382h = "";

    /* renamed from: i */
    private Map<String, a> f12383i = new HashMap();

    /* compiled from: Monitor.java */
    /* renamed from: com.umeng.ccg.d$a */
    public class a {

        /* renamed from: b */
        private JSONArray f12386b;

        /* renamed from: c */
        private String f12387c;

        public a(JSONArray jSONArray, String str) {
            this.f12386b = jSONArray;
            this.f12387c = str;
        }

        /* renamed from: a */
        public JSONArray m11493a() {
            return this.f12386b;
        }

        /* renamed from: b */
        public String m11494b() {
            return this.f12387c;
        }
    }

    /* compiled from: Monitor.java */
    /* renamed from: com.umeng.ccg.d$b */
    private static class b {

        /* renamed from: a */
        private static final C3441d f12388a = new C3441d();

        private b() {
        }
    }

    /* compiled from: Monitor.java */
    /* renamed from: com.umeng.ccg.d$c */
    public static class c extends BroadcastReceiver {
        /* renamed from: a */
        public long m11496a(ArrayList<InterfaceC3317aa> arrayList) {
            if (arrayList != null && arrayList.size() > 0) {
                for (int i2 = 0; i2 < arrayList.size(); i2++) {
                    InterfaceC3317aa interfaceC3317aa = arrayList.get(i2);
                    if (interfaceC3317aa instanceof C3319ac) {
                        return ((C3319ac) interfaceC3317aa).mo10811c();
                    }
                }
            }
            return 0L;
        }

        /* renamed from: b */
        public boolean m11497b(ArrayList<InterfaceC3317aa> arrayList) {
            if (arrayList == null || arrayList.size() <= 0) {
                return false;
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                if (arrayList.get(i2).mo10810b()) {
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
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_ON");
                    if (m11497b(C3441d.f12378e)) {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "report screen_on event.");
                        C3440c.m11466a(UMGlobalContext.getAppContext(), 301, C3441d.m11471a(), null, m11496a(C3441d.f12378e) * 1000);
                    } else {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "don't report screen_on event.");
                    }
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_SCREEN_OFF");
                    if (m11497b(C3441d.f12379f)) {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "report screen_off event.");
                        C3440c.m11466a(UMGlobalContext.getAppContext(), 302, C3441d.m11471a(), null, m11496a(C3441d.f12379f) * 1000);
                    } else {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "don't report screen_off event.");
                    }
                }
                if (action.equals("android.intent.action.USER_PRESENT")) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "recv intent : ACTION_USER_PRESENT");
                    if (!m11497b(C3441d.f12380g)) {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "don't report screen_unlock event.");
                        return;
                    }
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "report screen_unlock event.");
                    C3440c.m11466a(UMGlobalContext.getAppContext(), 303, C3441d.m11471a(), null, m11496a(C3441d.f12380g) * 1000);
                }
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: a */
    public static void m11472a(Context context, String str) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(str);
        context.registerReceiver(f12381j, intentFilter);
    }

    /* renamed from: e */
    private String m11488e(Context context) {
        try {
            SharedPreferences m10859a = C3333aq.m10859a(context);
            return m10859a != null ? m10859a.getString(C3333aq.f11474e, "") : "";
        } catch (Throwable unused) {
            return "";
        }
    }

    /* renamed from: f */
    private void m11490f() {
        try {
            SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
            if (m10859a != null) {
                m10859a.edit().putString(C3333aq.f11475f, new JSONObject(C3332ap.m10855a()).toString()).commit();
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: g */
    private boolean m11491g() {
        try {
            SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
            if (m10859a != null) {
                return !TextUtils.isEmpty(m10859a.getString(C3333aq.f11476g, ""));
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: b */
    private long m11479b(JSONObject jSONObject) {
        if (jSONObject != null && jSONObject.has("ts")) {
            try {
                return jSONObject.optLong("ts");
            } catch (Throwable unused) {
            }
        }
        return 0L;
    }

    /* renamed from: c */
    private void m11484c(Context context) {
        ImprintHandler.getImprintService(context).registImprintCallback(f12374a, new UMImprintChangeCallback() { // from class: com.umeng.ccg.d.1
            @Override // com.umeng.commonsdk.statistics.internal.UMImprintChangeCallback
            public void onImprintValueChanged(String str, String str2) {
                C3440c.m11465a(UMGlobalContext.getAppContext(), 107, C3441d.m11471a(), str2);
            }
        });
    }

    /* renamed from: d */
    private Long m11486d(Context context) {
        try {
            SharedPreferences m10859a = C3333aq.m10859a(context);
            if (m10859a != null) {
                return Long.valueOf(m10859a.getLong(C3333aq.f11473d, 0L));
            }
            return 0L;
        } catch (Throwable unused) {
            return 0L;
        }
    }

    /* renamed from: c */
    private void m11485c(JSONObject jSONObject) {
        if (jSONObject != null && (jSONObject instanceof JSONObject) && jSONObject.has(C3438a.f12328a)) {
            try {
                JSONObject optJSONObject = jSONObject.optJSONObject(C3438a.f12328a);
                C3425z m11470a = optJSONObject.has(C3438a.f12329b) ? m11470a(C3438a.f12329b, optJSONObject.optJSONObject(C3438a.f12329b)) : null;
                C3425z m11470a2 = optJSONObject.has(C3438a.f12330c) ? m11470a(C3438a.f12330c, optJSONObject.optJSONObject(C3438a.f12330c)) : null;
                C3425z m11470a3 = optJSONObject.has(C3438a.f12331d) ? m11470a(C3438a.f12331d, optJSONObject.optJSONObject(C3438a.f12331d)) : null;
                C3425z m11470a4 = optJSONObject.has(C3438a.f12332e) ? m11470a(C3438a.f12332e, optJSONObject.optJSONObject(C3438a.f12332e)) : null;
                C3425z m11470a5 = optJSONObject.has(C3438a.f12333f) ? m11470a(C3438a.f12333f, optJSONObject.optJSONObject(C3438a.f12333f)) : null;
                C3425z m11470a6 = optJSONObject.has(C3438a.f12334g) ? m11470a(C3438a.f12334g, optJSONObject.optJSONObject(C3438a.f12334g)) : null;
                C3425z m11470a7 = optJSONObject.has(C3438a.f12335h) ? m11470a(C3438a.f12335h, optJSONObject.optJSONObject(C3438a.f12335h)) : null;
                ArrayList arrayList = new ArrayList();
                if (m11470a != null) {
                    arrayList.add(m11470a);
                }
                if (m11470a2 != null) {
                    arrayList.add(m11470a2);
                }
                if (m11470a3 != null) {
                    arrayList.add(m11470a3);
                }
                if (m11470a4 != null) {
                    arrayList.add(m11470a4);
                }
                if (m11470a5 != null) {
                    arrayList.add(m11470a5);
                }
                if (m11470a6 != null) {
                    arrayList.add(m11470a6);
                }
                if (m11470a7 != null) {
                    arrayList.add(m11470a7);
                }
                C3440c.m11465a(UMGlobalContext.getAppContext(), 202, m11471a(), arrayList);
            } catch (Throwable unused) {
            }
        }
    }

    /* renamed from: e */
    private boolean m11489e() {
        SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
        if (m10859a != null) {
            String string = m10859a.getString(C3333aq.f11475f, "");
            if (TextUtils.isEmpty(string)) {
                m11490f();
                return false;
            }
            try {
                if (!C3332ap.m10855a().keySet().equals(C3332ap.m10856a(new JSONObject(string)).keySet())) {
                    return true;
                }
            } catch (Throwable unused) {
            }
        }
        return false;
    }

    /* renamed from: a */
    public static C3441d m11471a() {
        return b.f12388a;
    }

    /* renamed from: b */
    private JSONObject m11481b(Context context) {
        FileInputStream fileInputStream;
        try {
            if (!new File(context.getFilesDir(), f12375b).exists()) {
                return null;
            }
            try {
                fileInputStream = context.openFileInput(f12375b);
                try {
                    JSONObject jSONObject = new JSONObject(new String(C3335as.m10863a(HelperUtils.readStreamToByteArray(fileInputStream), UMConfigure.sAppkey.getBytes())));
                    try {
                        C3332ap.m10858a(fileInputStream);
                    } catch (Throwable unused) {
                    }
                    return jSONObject;
                } catch (Throwable unused2) {
                    C3332ap.m10858a(fileInputStream);
                    return null;
                }
            } catch (Throwable unused3) {
                fileInputStream = null;
            }
        } catch (Throwable unused4) {
            return null;
        }
    }

    /* renamed from: a */
    public void m11492a(Context context) {
        C3440c.m11465a(context, 105, m11471a(), null);
    }

    /* renamed from: a */
    private boolean m11478a(JSONObject jSONObject) {
        if (jSONObject == null || !jSONObject.has("code")) {
            return false;
        }
        try {
            if (200 == Integer.valueOf(jSONObject.optInt("code")).intValue() && jSONObject.has(C3438a.f12328a)) {
                return jSONObject.has("ts");
            }
            return false;
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private void m11474a(Context context, JSONObject jSONObject, String str) {
        try {
            long m11479b = m11479b(jSONObject);
            byte[] m10863a = C3335as.m10863a(jSONObject.toString().getBytes(), UMConfigure.sAppkey.getBytes());
            if (m10863a != null && m10863a.length > 1) {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(context.getFilesDir(), f12375b));
                try {
                    fileOutputStream.write(m10863a);
                    fileOutputStream.flush();
                    C3332ap.m10858a(fileOutputStream);
                    m11473a(context, str, m11479b);
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "saveConfigFile success.");
                } catch (Throwable th) {
                    C3332ap.m10858a(fileOutputStream);
                    throw th;
                }
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: b */
    private void m11482b(String str) {
        String str2 = C3333aq.f11471b + str;
        SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
        if (m10859a != null) {
            m10859a.edit().putLong(str2, System.currentTimeMillis()).commit();
        }
    }

    /* renamed from: a */
    private void m11476a(String str, InterfaceC3317aa interfaceC3317aa) {
        if (C3438a.f12333f.equalsIgnoreCase(str)) {
            if (f12378e == null) {
                f12378e = new ArrayList<>();
            }
            f12378e.add(interfaceC3317aa);
        }
        if (C3438a.f12334g.equalsIgnoreCase(str)) {
            if (f12379f == null) {
                f12379f = new ArrayList<>();
            }
            f12379f.add(interfaceC3317aa);
        }
        if (C3438a.f12335h.equalsIgnoreCase(str)) {
            if (f12380g == null) {
                f12380g = new ArrayList<>();
            }
            f12380g.add(interfaceC3317aa);
        }
    }

    /* renamed from: a */
    private C3425z m11470a(String str, JSONObject jSONObject) {
        JSONArray optJSONArray;
        String str2;
        String str3;
        C3425z c3425z;
        JSONArray optJSONArray2;
        if (jSONObject != null && (jSONObject instanceof JSONObject)) {
            try {
                if (jSONObject.has(C3438a.f12336i) && (optJSONArray = jSONObject.optJSONArray(C3438a.f12336i)) != null && optJSONArray.length() > 0) {
                    JSONObject jSONObject2 = (JSONObject) optJSONArray.get(0);
                    boolean has = jSONObject2.has(C3438a.f12337j);
                    boolean has2 = jSONObject2.has(C3438a.f12340m);
                    boolean has3 = jSONObject2.has(C3438a.f12341n);
                    if (!has || !has2 || !has3) {
                        return null;
                    }
                    try {
                        int optInt = jSONObject2.optInt(C3438a.f12337j);
                        long optLong = jSONObject2.optLong(C3438a.f12340m);
                        long optLong2 = jSONObject2.optLong(C3438a.f12341n);
                        String optString = jSONObject2.optString(C3438a.f12342o);
                        ArrayList arrayList = new ArrayList();
                        if (jSONObject2.has(C3438a.f12338k)) {
                            JSONArray optJSONArray3 = jSONObject2.optJSONArray(C3438a.f12338k);
                            str2 = "action";
                            HashSet hashSet = new HashSet();
                            if (optJSONArray3 != null) {
                                str3 = C3438a.f12345r;
                                int i2 = 0;
                                for (int length = optJSONArray3.length(); i2 < length; length = length) {
                                    hashSet.add(Integer.valueOf(optJSONArray3.getInt(i2)));
                                    i2++;
                                }
                            } else {
                                str3 = C3438a.f12345r;
                            }
                            if (hashSet.size() > 0) {
                                C3326aj c3326aj = new C3326aj(hashSet);
                                if (Arrays.asList(f12377d).contains(str)) {
                                    m11476a(str, c3326aj);
                                } else {
                                    arrayList.add(c3326aj);
                                }
                            }
                        } else {
                            str2 = "action";
                            str3 = C3438a.f12345r;
                        }
                        if (jSONObject2.has(C3438a.f12339l)) {
                            String optString2 = jSONObject2.optString(C3438a.f12339l);
                            if (!TextUtils.isEmpty(optString2)) {
                                C3324ah c3324ah = new C3324ah(optString2);
                                HashSet hashSet2 = new HashSet();
                                for (int i3 = 1; i3 <= 24; i3++) {
                                    if (c3324ah.m10818a(i3)) {
                                        hashSet2.add(Integer.valueOf(i3));
                                    }
                                }
                                if (hashSet2.size() > 0) {
                                    C3320ad c3320ad = new C3320ad(hashSet2);
                                    if (Arrays.asList(f12377d).contains(str)) {
                                        m11476a(str, c3320ad);
                                    } else {
                                        arrayList.add(c3320ad);
                                    }
                                }
                            }
                        }
                        arrayList.add(new C3322af(optInt));
                        C3321ae c3321ae = new C3321ae(str, optLong);
                        if (Arrays.asList(f12377d).contains(str)) {
                            m11476a(str, c3321ae);
                        } else {
                            arrayList.add(c3321ae);
                        }
                        C3319ac c3319ac = new C3319ac(optLong2);
                        if (Arrays.asList(f12377d).contains(str)) {
                            m11476a(str, c3319ac);
                            arrayList.add(c3319ac);
                        } else {
                            arrayList.add(c3319ac);
                        }
                        if (C3438a.f12332e.equals(str)) {
                            c3425z = new C3318ab(str, arrayList);
                        } else {
                            c3425z = new C3425z(str, arrayList);
                        }
                        try {
                            c3425z.m11438a(optString);
                            String str4 = "";
                            String str5 = str3;
                            if (jSONObject.has(str5) && (optJSONArray2 = jSONObject.optJSONArray(str5)) != null && (optJSONArray2 instanceof JSONArray)) {
                                if (this.f12383i != null && !this.f12383i.containsKey(str)) {
                                    this.f12383i.put(str, new a(new JSONArray(optJSONArray2.toString()), optString));
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
                            c3425z.m11440b(str4);
                            if (C3438a.f12332e.equals(str) && (c3425z instanceof C3318ab)) {
                                String str7 = str2;
                                if (jSONObject2.has(str7)) {
                                    ((C3318ab) c3425z).m10815d(jSONObject2.optString(str7));
                                }
                                if (jSONObject2.has(C3438a.f12346s)) {
                                    ((C3318ab) c3425z).m10813c(jSONObject2.optString(C3438a.f12346s));
                                }
                            }
                        } catch (Throwable unused) {
                        }
                        return c3425z;
                    } catch (Throwable unused2) {
                        return null;
                    }
                }
            } catch (Throwable unused3) {
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m11473a(Context context, String str, long j2) {
        SharedPreferences m10859a;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            String[] split = str.split("@");
            if (split.length != 4 || (m10859a = C3333aq.m10859a(context)) == null) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            SharedPreferences.Editor edit = m10859a.edit();
            edit.putLong(C3333aq.f11472c, j2);
            edit.putLong(C3333aq.f11473d, parseLong);
            edit.putString(C3333aq.f11474e, str2).commit();
            UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "updateTsS1S2 : ts = " + j2 + "; s1 = " + parseLong + "; s2 = " + str2);
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m11475a(String str) {
        try {
            String[] split = str.split("@");
            if (split.length != 4) {
                return;
            }
            long parseLong = Long.parseLong(split[0]);
            String str2 = split[1];
            if (!TextUtils.isEmpty(this.f12382h)) {
                String[] split2 = this.f12382h.split("@");
                if (split2.length == 2) {
                    long parseLong2 = Long.parseLong(split2[0]);
                    String str3 = split2[1];
                    if (parseLong2 == parseLong && str3.equalsIgnoreCase(str2)) {
                        UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "重复的iucc S1 and S2, 忽略本次更新，不发起fetch。");
                        return;
                    }
                }
            }
            SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
            if (m10859a != null) {
                if (m10859a.getLong(C3333aq.f11472c, 0L) != parseLong) {
                    UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "local config ts != iuccS1, send FETCH_NEW_CONFIG msg.");
                    this.f12382h = String.valueOf(parseLong) + "@" + str2;
                    C3440c.m11465a(UMGlobalContext.getAppContext(), 101, m11471a(), str);
                    return;
                }
                m11486d(UMGlobalContext.getAppContext());
                if (m11488e(UMGlobalContext.getAppContext()).equalsIgnoreCase(str2)) {
                    return;
                }
                UMRTLog.m11556i(UMRTLog.RTLOG_TAG, "local S2 != iuccS2, send FETCH_NEW_CONFIG msg.");
                this.f12382h = String.valueOf(parseLong) + "@" + str2;
                C3440c.m11465a(UMGlobalContext.getAppContext(), 101, m11471a(), str);
            }
        } catch (Throwable unused) {
        }
    }

    /* renamed from: a */
    private void m11477a(boolean z) {
        try {
            SharedPreferences m10859a = C3333aq.m10859a(UMGlobalContext.getAppContext());
            if (m10859a != null) {
                SharedPreferences.Editor edit = m10859a.edit();
                if (z) {
                    edit.putString(C3333aq.f11476g, "1").commit();
                } else {
                    edit.putString(C3333aq.f11476g, "").commit();
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
    @Override // com.umeng.ccg.C3440c.a
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo11469a(java.lang.Object r19, int r20) {
        /*
            Method dump skipped, instructions count: 1290
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.umeng.ccg.C3441d.mo11469a(java.lang.Object, int):void");
    }
}
