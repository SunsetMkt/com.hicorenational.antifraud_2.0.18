package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;

/* loaded from: classes2.dex */
public class q {

    /* renamed from: a, reason: collision with root package name */
    private static p f13451a;

    /* renamed from: a, reason: collision with other field name */
    private static a f1068a;

    public interface a {
        void a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static synchronized p m741a(Context context) {
        synchronized (q.class) {
            if (f13451a != null) {
                return f13451a;
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
            String g2 = com.xiaomi.push.i.g(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(g2) && !TextUtils.isEmpty(string7) && !string7.equals(g2)) {
                com.xiaomi.channel.commonutils.logger.b.m50a("read_phone_state permission changes.");
            }
            f13451a = new p(string, string2, string3, string4, string5, string6, i2);
            return f13451a;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|(2:8|(24:10|11|(1:13)(1:118)|14|(1:16)(1:117)|17|(1:19)(1:116)|20|21|22|23|(1:25)(1:112)|26|(6:28|(1:30)|31|(1:35)|36|(1:38))|39|(1:41)|42|(6:45|46|47|49|50|43)|54|55|(3:60|61|(2:63|64)(9:(1:67)|68|69|(2:73|(4:75|76|77|(7:79|(1:81)|82|83|84|85|86)(6:88|89|(1:93)|94|95|96)))|106|(2:91|93)|94|95|96))|111|61|(0)(0)))|119|11|(0)(0)|14|(0)(0)|17|(0)(0)|20|21|22|23|(0)(0)|26|(0)|39|(0)|42|(1:43)|54|55|(4:57|60|61|(0)(0))|111|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0086, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0087, code lost:
    
        com.xiaomi.channel.commonutils.logger.b.a(r0);
        r0 = null;
     */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0063  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:13:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x005f  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x008f A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:11:0x0046, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:22:0x007b, B:25:0x008f, B:26:0x0098, B:28:0x00c2, B:30:0x00ce, B:31:0x00e1, B:33:0x00eb, B:35:0x00f1, B:36:0x0105, B:38:0x010b, B:39:0x0110, B:41:0x0133, B:42:0x013c, B:43:0x0173, B:45:0x0179, B:47:0x0180, B:52:0x018f, B:55:0x01c0, B:57:0x01e0, B:60:0x01e7, B:61:0x01fe, B:69:0x020d, B:71:0x022b, B:73:0x0231, B:101:0x02e8, B:91:0x0319, B:93:0x031f, B:94:0x0327, B:99:0x0300, B:110:0x0214, B:115:0x0087), top: B:3:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00c2 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:11:0x0046, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:22:0x007b, B:25:0x008f, B:26:0x0098, B:28:0x00c2, B:30:0x00ce, B:31:0x00e1, B:33:0x00eb, B:35:0x00f1, B:36:0x0105, B:38:0x010b, B:39:0x0110, B:41:0x0133, B:42:0x013c, B:43:0x0173, B:45:0x0179, B:47:0x0180, B:52:0x018f, B:55:0x01c0, B:57:0x01e0, B:60:0x01e7, B:61:0x01fe, B:69:0x020d, B:71:0x022b, B:73:0x0231, B:101:0x02e8, B:91:0x0319, B:93:0x031f, B:94:0x0327, B:99:0x0300, B:110:0x0214, B:115:0x0087), top: B:3:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0133 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:11:0x0046, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:22:0x007b, B:25:0x008f, B:26:0x0098, B:28:0x00c2, B:30:0x00ce, B:31:0x00e1, B:33:0x00eb, B:35:0x00f1, B:36:0x0105, B:38:0x010b, B:39:0x0110, B:41:0x0133, B:42:0x013c, B:43:0x0173, B:45:0x0179, B:47:0x0180, B:52:0x018f, B:55:0x01c0, B:57:0x01e0, B:60:0x01e7, B:61:0x01fe, B:69:0x020d, B:71:0x022b, B:73:0x0231, B:101:0x02e8, B:91:0x0319, B:93:0x031f, B:94:0x0327, B:99:0x0300, B:110:0x0214, B:115:0x0087), top: B:3:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:45:0x0179 A[Catch: all -> 0x032e, TRY_LEAVE, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:11:0x0046, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:22:0x007b, B:25:0x008f, B:26:0x0098, B:28:0x00c2, B:30:0x00ce, B:31:0x00e1, B:33:0x00eb, B:35:0x00f1, B:36:0x0105, B:38:0x010b, B:39:0x0110, B:41:0x0133, B:42:0x013c, B:43:0x0173, B:45:0x0179, B:47:0x0180, B:52:0x018f, B:55:0x01c0, B:57:0x01e0, B:60:0x01e7, B:61:0x01fe, B:69:0x020d, B:71:0x022b, B:73:0x0231, B:101:0x02e8, B:91:0x0319, B:93:0x031f, B:94:0x0327, B:99:0x0300, B:110:0x0214, B:115:0x0087), top: B:3:0x0005, inners: #3, #4, #6 }] */
    /* JADX WARN: Removed duplicated region for block: B:63:0x0208 A[DONT_GENERATE] */
    /* JADX WARN: Removed duplicated region for block: B:66:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0319 A[Catch: all -> 0x032e, TryCatch #7 {, blocks: (B:4:0x0005, B:6:0x001a, B:8:0x0024, B:10:0x003a, B:11:0x0046, B:14:0x0059, B:17:0x0065, B:20:0x0071, B:22:0x007b, B:25:0x008f, B:26:0x0098, B:28:0x00c2, B:30:0x00ce, B:31:0x00e1, B:33:0x00eb, B:35:0x00f1, B:36:0x0105, B:38:0x010b, B:39:0x0110, B:41:0x0133, B:42:0x013c, B:43:0x0173, B:45:0x0179, B:47:0x0180, B:52:0x018f, B:55:0x01c0, B:57:0x01e0, B:60:0x01e7, B:61:0x01fe, B:69:0x020d, B:71:0x022b, B:73:0x0231, B:101:0x02e8, B:91:0x0319, B:93:0x031f, B:94:0x0327, B:99:0x0300, B:110:0x0214, B:115:0x0087), top: B:3:0x0005, inners: #3, #4, #6 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.xiaomi.push.service.p a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.q.a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.p");
    }

    private static String a(Context context, boolean z) {
        String a2 = b.a(context).a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (com.xiaomi.push.x.b()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (!com.xiaomi.push.n.China.name().equals(a2)) {
            return null;
        }
        return "https://cn.register.xmpush.xiaomi.com" + str;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static boolean m744a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    private static void a(Context context, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i2);
        edit.commit();
    }

    private static int a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    public static void a(Context context, p pVar) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", pVar.f1067a);
        edit.putString("security", pVar.f13447c);
        edit.putString("token", pVar.f13446b);
        edit.putString("app_id", pVar.f13448d);
        edit.putString("package_name", pVar.f13450f);
        edit.putString("app_token", pVar.f13449e);
        edit.putString("device_id", com.xiaomi.push.i.g(context));
        edit.putInt("env_type", pVar.f13445a);
        edit.commit();
        a();
    }

    /* renamed from: a, reason: collision with other method in class */
    public static void m743a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f13451a = null;
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

    /* renamed from: a, reason: collision with other method in class */
    public static String m742a(Context context) {
        p m741a = m741a(context);
        if (m741a != null && !TextUtils.isEmpty(m741a.f1067a)) {
            String[] split = m741a.f1067a.split("@");
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }
}
