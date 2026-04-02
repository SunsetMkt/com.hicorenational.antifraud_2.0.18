package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.text.TextUtils;
import com.taobao.accs.common.Constants;
import com.xiaomi.push.BuildConfig;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes2.dex */
public class q {
    private static p a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static a f1068a;

    public interface a {
        void a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static synchronized p m739a(Context context) {
        if (a != null) {
            return a;
        }
        SharedPreferences sharedPreferences = context.getSharedPreferences("mipush_account", 0);
        String string = sharedPreferences.getString("uuid", null);
        String string2 = sharedPreferences.getString("token", null);
        String string3 = sharedPreferences.getString("security", null);
        String string4 = sharedPreferences.getString("app_id", null);
        String string5 = sharedPreferences.getString("app_token", null);
        String string6 = sharedPreferences.getString("package_name", null);
        String string7 = sharedPreferences.getString("device_id", null);
        int i2 = sharedPreferences.getInt("env_type", 1);
        if (!TextUtils.isEmpty(string7) && com.xiaomi.push.i.a(string7)) {
            string7 = com.xiaomi.push.i.g(context);
            sharedPreferences.edit().putString("device_id", string7).commit();
        }
        if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
            return null;
        }
        String strG = com.xiaomi.push.i.g(context);
        if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(strG) && !TextUtils.isEmpty(string7) && !string7.equals(strG)) {
            com.xiaomi.channel.commonutils.logger.b.m48a("read_phone_state permission changes.");
        }
        a = new p(string, string2, string3, string4, string5, string6, i2);
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x0315  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0045  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:22:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:23:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x008f A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0133 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0179 A[Catch: all -> 0x032e, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:12:0x0046, B:16:0x0059, B:20:0x0065, B:24:0x0071, B:25:0x007b, B:31:0x008f, B:33:0x0098, B:35:0x00c2, B:37:0x00ce, B:38:0x00e1, B:40:0x00eb, B:42:0x00f1, B:43:0x0105, B:45:0x010b, B:46:0x0110, B:48:0x0133, B:49:0x013c, B:50:0x0173, B:52:0x0179, B:53:0x0180, B:56:0x018f, B:57:0x01c0, B:59:0x01e0, B:62:0x01e7, B:64:0x01fe, B:70:0x020d, B:76:0x022b, B:78:0x0231, B:99:0x02e8, B:105:0x0319, B:107:0x031f, B:108:0x0327, B:102:0x0300, B:74:0x0214, B:28:0x0087), top: B:120:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x0208 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:68:0x020a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static synchronized p a(Context context, String str, String str2, String str3) {
        String strSubstring;
        String str4;
        PackageInfo packageInfo;
        int iA;
        boolean z;
        String strA;
        com.xiaomi.push.as asVarA;
        boolean z2;
        JSONObject jSONObject;
        TreeMap treeMap = new TreeMap();
        treeMap.put("devid", com.xiaomi.push.i.a(context, false));
        if (a != null && !TextUtils.isEmpty(a.f1067a)) {
            treeMap.put("uuid", a.f1067a);
            int iLastIndexOf = a.f1067a.lastIndexOf("/");
            if (iLastIndexOf != -1) {
                strSubstring = a.f1067a.substring(iLastIndexOf + 1);
            }
            com.xiaomi.push.an.a(context).a(treeMap);
            if (!m742a(context)) {
            }
            if (!m742a(context)) {
            }
            if (!m742a(context)) {
            }
            treeMap.put("appid", str);
            treeMap.put("apptoken", str);
            packageInfo = context.getPackageManager().getPackageInfo(str4, 16384);
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));
            treeMap.put("packagename", str4);
            treeMap.put(Constants.KEY_MODEL, com.xiaomi.push.k.a());
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.j.m630d()) {
            }
            treeMap.put("os", Build.VERSION.RELEASE + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            iA = com.xiaomi.push.i.a();
            if (iA >= 0) {
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.i.m612a());
            treeMap.put("rom", com.xiaomi.push.i.m617b());
            JSONObject jSONObject2 = new JSONObject();
            while (r9.hasNext()) {
            }
            String strA2 = av.a(jSONObject2.toString());
            TreeMap treeMap2 = new TreeMap();
            treeMap2.put("requestData", strA2);
            treeMap2.put("keyPairVer", "1");
            if (a(context) < 2) {
                z = false;
                strA = a(context, z);
                if (!TextUtils.isEmpty(strA)) {
                }
            }
        } else {
            strSubstring = null;
            com.xiaomi.push.an.a(context).a(treeMap);
            String str5 = !m742a(context) ? "1000271" : str2;
            String str6 = !m742a(context) ? "420100086271" : str3;
            str4 = !m742a(context) ? "com.xiaomi.xmsf" : str;
            treeMap.put("appid", str5);
            treeMap.put("apptoken", str6);
            try {
                packageInfo = context.getPackageManager().getPackageInfo(str4, 16384);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.a(e2);
                packageInfo = null;
            }
            treeMap.put("appversion", packageInfo == null ? String.valueOf(packageInfo.versionCode) : "0");
            treeMap.put("sdkversion", Integer.toString(BuildConfig.VERSION_CODE));
            treeMap.put("packagename", str4);
            treeMap.put(Constants.KEY_MODEL, com.xiaomi.push.k.a());
            treeMap.put("board", Build.BOARD);
            if (!com.xiaomi.push.j.m630d()) {
                String strC = com.xiaomi.push.i.c(context);
                String str7 = TextUtils.isEmpty(strC) ? "" : "" + com.xiaomi.push.bb.a(strC);
                String strE = com.xiaomi.push.i.e(context);
                if (!TextUtils.isEmpty(str7) && !TextUtils.isEmpty(strE)) {
                    str7 = str7 + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SP + strE;
                }
                if (!TextUtils.isEmpty(str7)) {
                    treeMap.put(com.xiaomi.mipush.sdk.Constants.EXTRA_KEY_IMEI_MD5, str7);
                }
            }
            treeMap.put("os", Build.VERSION.RELEASE + com.xiaomi.mipush.sdk.Constants.ACCEPT_TIME_SEPARATOR_SERVER + Build.VERSION.INCREMENTAL);
            iA = com.xiaomi.push.i.a();
            if (iA >= 0) {
                treeMap.put("space_id", Integer.toString(iA));
            }
            treeMap.put("brand", Build.BRAND + "");
            treeMap.put("ram", com.xiaomi.push.i.m612a());
            treeMap.put("rom", com.xiaomi.push.i.m617b());
            JSONObject jSONObject22 = new JSONObject();
            for (Map.Entry entry : treeMap.entrySet()) {
                try {
                    jSONObject22.put((String) entry.getKey(), entry.getValue());
                } catch (JSONException e3) {
                    com.xiaomi.channel.commonutils.logger.b.d("failed to add data in json format: k=" + ((String) entry.getKey()) + ",v=" + ((String) entry.getValue()) + ". " + e3);
                }
            }
            String strA22 = av.a(jSONObject22.toString());
            TreeMap treeMap22 = new TreeMap();
            treeMap22.put("requestData", strA22);
            treeMap22.put("keyPairVer", "1");
            if (a(context) < 2 || TextUtils.isEmpty(strA22)) {
                z = false;
            } else {
                com.xiaomi.channel.commonutils.logger.b.m48a("r.data = " + strA22);
                z = true;
            }
            strA = a(context, z);
            if (!TextUtils.isEmpty(strA)) {
                return null;
            }
            if (z) {
                treeMap = treeMap22;
            }
            try {
                asVarA = com.xiaomi.push.au.a(context, strA, treeMap);
            } catch (IOException e4) {
                com.xiaomi.channel.commonutils.logger.b.d("device registration request failed. " + e4);
                asVarA = null;
            }
            if (asVarA != null && asVarA.a == 200) {
                String strA3 = asVarA.a();
                if (!TextUtils.isEmpty(strA3)) {
                    try {
                        jSONObject = new JSONObject(strA3);
                    } catch (JSONException e5) {
                        e = e5;
                        z2 = z;
                    } catch (Throwable th) {
                        th = th;
                        z2 = z;
                    }
                    try {
                        if (jSONObject.getInt("code") == 0) {
                            JSONObject jSONObject3 = jSONObject.getJSONObject("data");
                            String string = jSONObject3.getString("ssecurity");
                            String string2 = jSONObject3.getString("token");
                            String string3 = jSONObject3.getString("userId");
                            if (TextUtils.isEmpty(strSubstring)) {
                                strSubstring = "an" + com.xiaomi.push.bb.a(6);
                            }
                            p pVar = new p(string3 + "@xiaomi.com/" + strSubstring, string2, string, str5, str6, str4, com.xiaomi.push.x.a());
                            a(context, pVar);
                            a = pVar;
                            a(context, 0);
                            com.xiaomi.channel.commonutils.logger.b.m48a("device registration is successful. " + string3);
                            return pVar;
                        }
                        z2 = z;
                        t.a(context, jSONObject.getInt("code"), jSONObject.optString("description"));
                        com.xiaomi.channel.commonutils.logger.b.m48a("device registration resp: " + strA3);
                    } catch (JSONException e6) {
                        e = e6;
                        com.xiaomi.channel.commonutils.logger.b.d("failed to parse respone json data. " + e);
                    } catch (Throwable th2) {
                        th = th2;
                        com.xiaomi.channel.commonutils.logger.b.d("unknow throwable. " + th);
                    }
                    com.xiaomi.channel.commonutils.logger.b.d("failed to parse respone json data. " + e);
                }
                if (z2) {
                    a(context, a(context) + 1);
                }
                com.xiaomi.channel.commonutils.logger.b.m48a("fail to register push account. meet error.");
                return null;
            }
            z2 = z;
            if (z2 && com.xiaomi.push.au.b(context)) {
                a(context, a(context) + 1);
            }
            com.xiaomi.channel.commonutils.logger.b.m48a("fail to register push account. meet error.");
            return null;
        }
    }

    private static String a(Context context, boolean z) {
        String strA = b.a(context).a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.x.b()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (!com.xiaomi.push.n.China.name().equals(strA)) {
            return null;
        }
        return "https://cn.register.xmpush.xiaomi.com" + str;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m742a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static void a(Context context, int i2) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putInt("enc_req_fail_count", i2);
        editorEdit.commit();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static void a(Context context, p pVar) {
        SharedPreferences.Editor editorEdit = context.getSharedPreferences("mipush_account", 0).edit();
        editorEdit.putString("uuid", pVar.f1067a);
        editorEdit.putString("security", pVar.f9412c);
        editorEdit.putString("token", pVar.f9411b);
        editorEdit.putString("app_id", pVar.f9413d);
        editorEdit.putString("package_name", pVar.f9415f);
        editorEdit.putString("app_token", pVar.f9414e);
        editorEdit.putString("device_id", com.xiaomi.push.i.g(context));
        editorEdit.putInt("env_type", pVar.a);
        editorEdit.commit();
        a();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m741a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        a = null;
        a();
    }

    public static void a(a aVar) {
        f1068a = aVar;
    }

    public static void a() {
        a aVar = f1068a;
        if (aVar != null) {
            aVar.a();
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static String m740a(Context context) {
        p pVarM739a = m739a(context);
        if (pVarM739a != null && !TextUtils.isEmpty(pVarM739a.f1067a)) {
            String[] strArrSplit = pVarM739a.f1067a.split("@");
            if (strArrSplit.length > 0) {
                return strArrSplit[0];
            }
        }
        return null;
    }
}
