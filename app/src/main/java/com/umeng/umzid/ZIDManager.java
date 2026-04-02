package com.umeng.umzid;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import com.umeng.analytics.pro.bh;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import com.umeng.socialize.net.utils.SocializeProtocolConstants;
import i.f1;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.util.Calendar;
import java.util.Locale;
import java.util.UUID;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class ZIDManager {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static ZIDManager f8412d;
    public boolean a = false;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f8413b = false;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public boolean f8414c;

    public class a implements Runnable {
        public final /* synthetic */ Context a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ IZIDCompletionCallback f8415b;

        public a(Context context, IZIDCompletionCallback iZIDCompletionCallback) {
            this.a = context;
            this.f8415b = iZIDCompletionCallback;
        }

        @Override // java.lang.Runnable
        public void run() {
            String strA = ZIDManager.a(ZIDManager.this, this.a);
            if (TextUtils.isEmpty(strA)) {
                IZIDCompletionCallback iZIDCompletionCallback = this.f8415b;
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1002", "\u83b7\u53d6zid\u5931\u8d25");
                    return;
                }
                return;
            }
            IZIDCompletionCallback iZIDCompletionCallback2 = this.f8415b;
            if (iZIDCompletionCallback2 != null) {
                iZIDCompletionCallback2.onSuccess(strA);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ Context a;

        public b(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.this.b(this.a);
        }
    }

    public class c implements Runnable {
        public final /* synthetic */ Context a;

        public c(Context context) {
            this.a = context;
        }

        @Override // java.lang.Runnable
        public void run() {
            ZIDManager.a(ZIDManager.this, this.a);
        }
    }

    public static /* synthetic */ String a(ZIDManager zIDManager, Context context) {
        Throwable th;
        JSONObject jSONObject;
        String strOptString = null;
        if (!zIDManager.a) {
            zIDManager.a = true;
            JSONObject jSONObject2 = new JSONObject();
            try {
                String id = Spy.getID();
                jSONObject2.put(bh.aG, id);
                String strE = d.e(context);
                jSONObject2.put(bh.A, strE);
                String strF = d.f(context);
                jSONObject2.put("o", strF);
                try {
                    jSONObject = new JSONObject();
                } catch (Throwable th2) {
                    th = th2;
                    jSONObject = null;
                }
                try {
                    jSONObject.put("vpn_pxy", d.i(context));
                    jSONObject.put("wifi_pxy", d.j(context));
                    jSONObject.put("double", d.g(context));
                } catch (Throwable th3) {
                    th = th3;
                    th.printStackTrace();
                }
                if (jSONObject != null) {
                    jSONObject2.put("anti", jSONObject);
                }
                zIDManager.a(context, jSONObject2);
                String strB = d.b(context);
                if (strB.length() <= 0) {
                    strB = "https://utoken.umeng.com";
                }
                String strA = com.umeng.umzid.a.a(strB + "/anti/postZdata", jSONObject2.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject3 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, strE);
                        d.b(context, strF);
                        strOptString = jSONObject3.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            d.e(context, strOptString);
                        }
                        String strOptString2 = jSONObject3.optString("uabc");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            d.d(context, strOptString2);
                        }
                        String strOptString3 = jSONObject3.optString("resetToken");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            d.c(context, strOptString3);
                        }
                    }
                }
                zIDManager.a(context);
            } finally {
                try {
                } finally {
                }
            }
        }
        return strOptString;
    }

    public static void configureDomain(Context context, String str) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        String strB = d.b(str);
        if (context == null || strB == null || TextUtils.isEmpty(strB) || (sharedPreferencesA = com.umeng.umzid.a.a(context)) == null || (editorEdit = sharedPreferencesA.edit()) == null) {
            return;
        }
        editorEdit.putString("inputDomain", strB).commit();
    }

    public static synchronized ZIDManager getInstance() {
        if (f8412d == null) {
            f8412d = new ZIDManager();
        }
        return f8412d;
    }

    public static String getSDKVersion() {
        return "1.8.0";
    }

    public final void a(Context context) {
        Method declaredMethod;
        Object objInvoke;
        Method declaredMethod2;
        try {
            Class<?> cls = Class.forName("com.uyumao.sdk.UYMManager");
            if (cls == null || (declaredMethod = cls.getDeclaredMethod("getInstance", new Class[0])) == null || (objInvoke = declaredMethod.invoke(cls, new Object[0])) == null || (declaredMethod2 = cls.getDeclaredMethod("init", Context.class)) == null) {
                return;
            }
            declaredMethod2.setAccessible(true);
            declaredMethod2.invoke(objInvoke, context);
        } catch (Exception unused) {
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0045  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final String b(Context context) {
        String string;
        String string2;
        Throwable th;
        JSONObject jSONObject;
        SharedPreferences sharedPreferencesA;
        SharedPreferences sharedPreferencesA2;
        SharedPreferences sharedPreferencesA3;
        try {
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        boolean z = new JSONObject(d.c(context)).optLong("ets") <= System.currentTimeMillis();
        String strOptString = null;
        if (!z || this.f8413b) {
            return null;
        }
        this.f8413b = true;
        JSONObject jSONObject2 = new JSONObject();
        String string3 = "";
        if (context != null) {
            try {
                SharedPreferences sharedPreferencesA4 = com.umeng.umzid.a.a(context);
                String string4 = sharedPreferencesA4 != null ? sharedPreferencesA4.getString("zdata", null) : "";
                String id = Spy.getID();
                jSONObject2.put(bh.aG, id);
                jSONObject2.put("o_z", string4);
                if (context == null || (sharedPreferencesA3 = com.umeng.umzid.a.a(context)) == null) {
                    string = "";
                } else {
                    string = sharedPreferencesA3.getString("oaid", "");
                    if (d.c(string)) {
                        string = d.a(string);
                    }
                }
                String strF = d.f(context);
                jSONObject2.put("o_o", string);
                jSONObject2.put("o", strF);
                if (context == null || (sharedPreferencesA2 = com.umeng.umzid.a.a(context)) == null) {
                    string2 = "";
                } else {
                    string2 = sharedPreferencesA2.getString(SocializeProtocolConstants.PROTOCOL_KEY_MAC, "");
                    if (d.c(string2)) {
                        string2 = d.a(string2);
                    }
                }
                String strE = d.e(context);
                jSONObject2.put(bh.A, strE);
                jSONObject2.put("o_mc", string2);
                a(context, jSONObject2);
                jSONObject2.put("aaid", d.d(context));
                jSONObject2.put("uabc", d.c(context));
                if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
                    string3 = sharedPreferencesA.getString("resetToken", "");
                }
                if (!TextUtils.isEmpty(string3)) {
                    jSONObject2.put("rt", string3);
                }
                try {
                    jSONObject = new JSONObject();
                    try {
                        jSONObject.put("vpn_pxy", d.i(context));
                        jSONObject.put("wifi_pxy", d.j(context));
                        jSONObject.put("double", d.g(context));
                    } catch (Throwable th2) {
                        th = th2;
                        th.printStackTrace();
                    }
                } catch (Throwable th3) {
                    th = th3;
                    jSONObject = null;
                }
                if (jSONObject != null) {
                    jSONObject2.put("anti", jSONObject);
                }
                String strB = d.b(context);
                if (strB.length() <= 0) {
                    strB = "https://utoken.umeng.com";
                }
                String strA = com.umeng.umzid.a.a(strB + "/anti/updateZdata", jSONObject2.toString());
                if (!TextUtils.isEmpty(strA)) {
                    JSONObject jSONObject3 = new JSONObject(strA);
                    if (Boolean.valueOf(jSONObject3.optBoolean("suc")).booleanValue()) {
                        d.f(context, id);
                        d.a(context, strE);
                        d.b(context, strF);
                        strOptString = jSONObject3.optString("aaid");
                        if (!TextUtils.isEmpty(strOptString)) {
                            d.e(context, strOptString);
                        }
                        String strOptString2 = jSONObject3.optString("uabc");
                        if (!TextUtils.isEmpty(strOptString2)) {
                            d.d(context, strOptString2);
                        }
                        String strOptString3 = jSONObject3.optString("resetToken");
                        if (!TextUtils.isEmpty(strOptString3)) {
                            d.c(context, strOptString3);
                        }
                    }
                }
                a(context);
            } catch (Throwable unused) {
            }
        }
        this.f8413b = false;
        return strOptString;
    }

    public synchronized String getZID(Context context) {
        if (context == null) {
            return "";
        }
        Context applicationContext = context.getApplicationContext();
        String strD = d.d(applicationContext);
        if (!TextUtils.isEmpty(strD)) {
            return strD;
        }
        com.umeng.umzid.c.a(new c(applicationContext));
        return "";
    }

    public synchronized void init(Context context, String str, IZIDCompletionCallback iZIDCompletionCallback) {
        SharedPreferences sharedPreferencesA;
        SharedPreferences.Editor editorEdit;
        this.f8414c = d.h(context);
        if (this.f8414c) {
            if (context == null) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1001", "\u4f20\u5165\u53c2\u6570Context\u4e3anull");
                }
                return;
            }
            if (TextUtils.isEmpty(str)) {
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onFailure("1003", "\u4f20\u5165\u53c2\u6570appkey\u4e3a\u7a7a");
                }
                return;
            }
            Context applicationContext = context.getApplicationContext();
            if (applicationContext != null && str != null && !TextUtils.isEmpty(str) && (sharedPreferencesA = com.umeng.umzid.a.a(applicationContext)) != null && (editorEdit = sharedPreferencesA.edit()) != null) {
                editorEdit.putString("appkey", str).commit();
            }
            String strD = d.d(applicationContext);
            if (strD == null || TextUtils.isEmpty(strD)) {
                com.umeng.umzid.c.a(new a(applicationContext, iZIDCompletionCallback));
            } else {
                com.umeng.umzid.c.a(new b(applicationContext));
                if (iZIDCompletionCallback != null) {
                    iZIDCompletionCallback.onSuccess(strD);
                }
            }
            SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
            if (TextUtils.isEmpty(sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "")) {
                String string = "";
                SharedPreferences sharedPreferencesA3 = com.umeng.umzid.a.a(context);
                try {
                    string = UUID.randomUUID().toString();
                } catch (Throwable unused) {
                }
                if (sharedPreferencesA3 != null) {
                    sharedPreferencesA3.edit().putString("uuid", string).commit();
                }
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x01b4  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final JSONObject a(Context context, JSONObject jSONObject) throws JSONException {
        Locale locale;
        int rawOffset;
        Object obj;
        String string;
        Object obj2;
        Object string2;
        Object country;
        Object obj3;
        Class<?> cls;
        Method declaredMethod;
        SharedPreferences sharedPreferencesA;
        Class<?> cls2;
        Method declaredMethod2;
        jSONObject.putOpt("z_v", Spy.getVersion());
        jSONObject.putOpt("a_id", d.a(context));
        jSONObject.putOpt("os_v", Build.VERSION.RELEASE);
        Object string3 = null;
        if (context == null) {
            rawOffset = 8;
        } else {
            try {
                Configuration configuration = new Configuration();
                configuration.setToDefaults();
                Settings.System.getConfiguration(context.getContentResolver(), configuration);
                locale = configuration.locale;
            } catch (Throwable unused) {
                locale = null;
            }
            if (locale == null) {
                try {
                    locale = Locale.getDefault();
                } catch (Throwable unused2) {
                }
            }
            Calendar calendar = Calendar.getInstance(locale);
            if (calendar != null) {
                rawOffset = calendar.getTimeZone().getRawOffset() / 3600000;
            }
        }
        jSONObject.putOpt("tz", Integer.valueOf(rawOffset));
        jSONObject.putOpt("m", Build.MODEL);
        try {
            cls2 = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (Throwable unused3) {
        }
        if (cls2 == null || (declaredMethod2 = cls2.getDeclaredMethod("getImeiNew", Context.class)) == null) {
            obj = "";
        } else {
            declaredMethod2.setAccessible(true);
            Object objInvoke = declaredMethod2.invoke(cls2, context);
            if (objInvoke != null && (objInvoke instanceof String)) {
                obj = (String) objInvoke;
            }
        }
        jSONObject.putOpt("im", obj);
        try {
            Method declaredMethod3 = Build.class.getDeclaredMethod("getString", String.class);
            declaredMethod3.setAccessible(true);
            string = declaredMethod3.invoke(null, "net.hostname").toString();
            if (string != null) {
                try {
                    if (!string.equalsIgnoreCase("")) {
                        try {
                            MessageDigest messageDigest = MessageDigest.getInstance("MD5");
                            messageDigest.update(string.getBytes());
                            byte[] bArrDigest = messageDigest.digest();
                            StringBuffer stringBuffer = new StringBuffer();
                            for (byte b2 : bArrDigest) {
                                stringBuffer.append(Integer.toHexString(b2 & f1.f12066c));
                            }
                            string = stringBuffer.toString();
                        } catch (Throwable unused4) {
                            string = "";
                        }
                    }
                } catch (Exception unused5) {
                }
            }
        } catch (Exception unused6) {
            string = null;
        }
        jSONObject.putOpt("hn", string);
        jSONObject.putOpt("s_v", "1.8.0");
        jSONObject.putOpt("pkg", context == null ? null : context.getPackageName());
        jSONObject.putOpt(CommonNetImpl.SHARETYPE, "Android");
        SharedPreferences sharedPreferencesA2 = com.umeng.umzid.a.a(context);
        jSONObject.putOpt("uid", sharedPreferencesA2 != null ? sharedPreferencesA2.getString("uuid", "") : "");
        jSONObject.putOpt("s_id", "umeng");
        try {
            obj2 = context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e2) {
            e2.printStackTrace();
            obj2 = null;
        }
        jSONObject.putOpt("a_v", obj2);
        try {
            string2 = context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (Exception e3) {
            e3.printStackTrace();
            string2 = null;
        }
        jSONObject.putOpt("a_n", string2);
        try {
            country = context.getResources().getConfiguration().locale.getCountry();
        } catch (Exception e4) {
            e4.printStackTrace();
            country = null;
        }
        jSONObject.putOpt(bh.aI, country);
        if (context != null && (sharedPreferencesA = com.umeng.umzid.a.a(context)) != null) {
            string3 = sharedPreferencesA.getString("appkey", null);
        }
        jSONObject.putOpt(SocializeProtocolConstants.PROTOCOL_KEY_AK, string3);
        try {
            cls = Class.forName("com.umeng.commonsdk.statistics.common.DeviceConfig");
        } catch (Throwable unused7) {
        }
        if (cls == null || (declaredMethod = cls.getDeclaredMethod("getIdfa", Context.class)) == null) {
            obj3 = "";
        } else {
            declaredMethod.setAccessible(true);
            Object objInvoke2 = declaredMethod.invoke(cls, context);
            if (objInvoke2 != null && (objInvoke2 instanceof String)) {
                obj3 = (String) objInvoke2;
            }
        }
        jSONObject.putOpt("gd", obj3);
        return jSONObject;
    }
}
