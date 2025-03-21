package com.xiaomi.push.service;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4287i;
import com.xiaomi.push.C4409x;
import com.xiaomi.push.EnumC4304n;

/* renamed from: com.xiaomi.push.service.q */
/* loaded from: classes2.dex */
public class C4394q {

    /* renamed from: a */
    private static C4393p f16760a;

    /* renamed from: a */
    private static a f16761a;

    /* renamed from: com.xiaomi.push.service.q$a */
    public interface a {
        /* renamed from: a */
        void mo15815a();
    }

    /* renamed from: a */
    public static synchronized C4393p m16204a(Context context) {
        synchronized (C4394q.class) {
            if (f16760a != null) {
                return f16760a;
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
            if (!TextUtils.isEmpty(string7) && C4287i.m15640a(string7)) {
                string7 = C4287i.m15653g(context);
                sharedPreferences.edit().putString("device_id", string7).commit();
            }
            if (TextUtils.isEmpty(string) || TextUtils.isEmpty(string2) || TextUtils.isEmpty(string3)) {
                return null;
            }
            String m15653g = C4287i.m15653g(context);
            if (!"com.xiaomi.xmsf".equals(context.getPackageName()) && !TextUtils.isEmpty(m15653g) && !TextUtils.isEmpty(string7) && !string7.equals(m15653g)) {
                AbstractC4022b.m13347a("read_phone_state permission changes.");
            }
            f16760a = new C4393p(string, string2, string3, string4, string5, string6, i2);
            return f16760a;
        }
    }

    /* JADX WARN: Can't wrap try/catch for region: R(27:3|4|(2:8|(24:10|11|(1:13)(1:118)|14|(1:16)(1:117)|17|(1:19)(1:116)|20|21|22|23|(1:25)(1:112)|26|(6:28|(1:30)|31|(1:35)|36|(1:38))|39|(1:41)|42|(6:45|46|47|49|50|43)|54|55|(3:60|61|(2:63|64)(9:(1:67)|68|69|(2:73|(4:75|76|77|(7:79|(1:81)|82|83|84|85|86)(6:88|89|(1:93)|94|95|96)))|106|(2:91|93)|94|95|96))|111|61|(0)(0)))|119|11|(0)(0)|14|(0)(0)|17|(0)(0)|20|21|22|23|(0)(0)|26|(0)|39|(0)|42|(1:43)|54|55|(4:57|60|61|(0)(0))|111|61|(0)(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:114:0x0086, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:115:0x0087, code lost:
    
        com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13351a(r0);
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
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static synchronized com.xiaomi.push.service.C4393p m16205a(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20) {
        /*
            Method dump skipped, instructions count: 817
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.service.C4394q.m16205a(android.content.Context, java.lang.String, java.lang.String, java.lang.String):com.xiaomi.push.service.p");
    }

    /* renamed from: a */
    private static String m16207a(Context context, boolean z) {
        String m16048a = C4375b.m16045a(context).m16048a();
        String str = z ? "/pass/v2/register/encrypt" : "/pass/v2/register";
        if (C4409x.m16367b()) {
            return "http://10.38.162.35:9085" + str;
        }
        if (!EnumC4304n.China.name().equals(m16048a)) {
            return null;
        }
        return "https://cn.register.xmpush.xiaomi.com" + str;
    }

    /* renamed from: a */
    private static boolean m16213a(Context context) {
        return context.getPackageName().equals("com.xiaomi.xmsf");
    }

    /* renamed from: a */
    private static void m16210a(Context context, int i2) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putInt("enc_req_fail_count", i2);
        edit.commit();
    }

    /* renamed from: a */
    private static int m16203a(Context context) {
        return context.getSharedPreferences("mipush_account", 0).getInt("enc_req_fail_count", 0);
    }

    /* renamed from: a */
    public static void m16211a(Context context, C4393p c4393p) {
        SharedPreferences.Editor edit = context.getSharedPreferences("mipush_account", 0).edit();
        edit.putString("uuid", c4393p.f16754a);
        edit.putString("security", c4393p.f16756c);
        edit.putString("token", c4393p.f16755b);
        edit.putString("app_id", c4393p.f16757d);
        edit.putString("package_name", c4393p.f16759f);
        edit.putString("app_token", c4393p.f16758e);
        edit.putString("device_id", C4287i.m15653g(context));
        edit.putInt("env_type", c4393p.f16753a);
        edit.commit();
        m16208a();
    }

    /* renamed from: a */
    public static void m16209a(Context context) {
        context.getSharedPreferences("mipush_account", 0).edit().clear().commit();
        f16760a = null;
        m16208a();
    }

    /* renamed from: a */
    public static void m16212a(a aVar) {
        f16761a = aVar;
    }

    /* renamed from: a */
    public static void m16208a() {
        a aVar = f16761a;
        if (aVar != null) {
            aVar.mo15815a();
        }
    }

    /* renamed from: a */
    public static String m16206a(Context context) {
        C4393p m16204a = m16204a(context);
        if (m16204a != null && !TextUtils.isEmpty(m16204a.f16754a)) {
            String[] split = m16204a.f16754a.split("@");
            if (split.length > 0) {
                return split[0];
            }
        }
        return null;
    }
}
