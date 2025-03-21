package com.vivo.push.util;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.text.TextUtils;
import com.vivo.push.cache.C3858b;
import com.vivo.push.cache.InterfaceC3860d;
import com.vivo.push.model.C3926b;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import p286h.C5230f1;

/* compiled from: PushPackageUtils.java */
/* renamed from: com.vivo.push.util.aa */
/* loaded from: classes2.dex */
public final class C3984aa {

    /* renamed from: a */
    private static Boolean f14214a;

    /* renamed from: b */
    private static String f14215b;

    /* renamed from: a */
    public static C3926b m13179a(Context context, InterfaceC4004o interfaceC4004o) {
        C3926b m13190f;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        C3926b m13186c = m13186c(applicationContext);
        if (m13186c != null) {
            C4010u.m13309d("PushPackageUtils", "get system push info :".concat(String.valueOf(m13186c)));
            return m13186c;
        }
        List<String> mo13136a = interfaceC4004o.mo13136a(applicationContext);
        C3926b m13190f2 = m13190f(applicationContext, applicationContext.getPackageName());
        if (mo13136a == null || mo13136a.size() <= 0) {
            if (m13190f2 != null && m13190f2.m13068d()) {
                m13186c = m13190f2;
            }
            C4010u.m13292a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            C3926b c3926b = null;
            String mo13195a = C3989af.m13204b(applicationContext).mo13195a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(mo13195a) || !m13183a(applicationContext, mo13195a, "com.vivo.pushservice.action.METHOD") || (m13186c = m13190f(applicationContext, mo13195a)) == null || !m13186c.m13068d()) {
                m13186c = null;
            }
            if (m13190f2 == null || !m13190f2.m13068d()) {
                m13190f2 = null;
            }
            if (m13186c == null) {
                m13186c = null;
            }
            if (m13190f2 != null && (m13186c == null || (!m13190f2.m13067c() ? m13186c.m13067c() || m13190f2.m13065b() > m13186c.m13065b() : m13186c.m13067c() && m13190f2.m13065b() > m13186c.m13065b()))) {
                m13186c = m13190f2;
            }
            HashMap hashMap = new HashMap();
            if (m13186c == null) {
                m13186c = null;
            } else if (m13186c.m13067c()) {
                c3926b = m13186c;
                m13186c = null;
            }
            int size = mo13136a.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = mo13136a.get(i2);
                if (!TextUtils.isEmpty(str) && (m13190f = m13190f(applicationContext, str)) != null) {
                    hashMap.put(str, m13190f);
                    if (m13190f.m13068d()) {
                        if (m13190f.m13067c()) {
                            if (c3926b == null || m13190f.m13065b() > c3926b.m13065b()) {
                                c3926b = m13190f;
                            }
                        } else if (m13186c == null || m13190f.m13065b() > m13186c.m13065b()) {
                            m13186c = m13190f;
                        }
                    }
                }
            }
            if (m13186c == null) {
                C4010u.m13309d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                m13186c = c3926b;
            }
        }
        if (m13186c == null) {
            C4010u.m13303b(applicationContext, "查找最优包为空!");
            C4010u.m13309d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (m13186c.m13067c()) {
            C4010u.m13297a(applicationContext, "查找最优包为:" + m13186c.m13060a() + "(" + m13186c.m13065b() + ", Black)");
            C4010u.m13309d("PushPackageUtils", "finSuitablePushPackage" + m13186c.m13060a() + "(" + m13186c.m13065b() + ", Black)");
        } else {
            C4010u.m13297a(applicationContext, "查找最优包为:" + m13186c.m13060a() + "(" + m13186c.m13065b() + ")");
            C4010u.m13309d("PushPackageUtils", "finSuitablePushPackage" + m13186c.m13060a() + "(" + m13186c.m13065b() + ")");
        }
        return m13186c;
    }

    /* renamed from: b */
    public static boolean m13185b(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f14214a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(m13191g(context, str)));
        f14214a = valueOf;
        return valueOf.booleanValue();
    }

    /* renamed from: c */
    private static C3926b m13186c(Context context) {
        String m13180a = m13180a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(m13180a)) {
            return null;
        }
        C3926b c3926b = new C3926b(m13180a);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(m13180a, 128);
            if (packageInfo != null) {
                c3926b.m13061a(packageInfo.versionCode);
                c3926b.m13063a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                c3926b.m13062a(C3990ag.m13207a(context, m13180a));
            }
            c3926b.m13064a(m13181a(context, c3926b.m13065b()));
            c3926b.m13066b(m13182a(context, m13180a));
            return c3926b;
        } catch (Exception e2) {
            e2.printStackTrace();
            C4010u.m13302b("PushPackageUtils", "PackageManager NameNotFoundException is null", e2);
            return null;
        }
    }

    /* renamed from: d */
    public static boolean m13188d(Context context, String str) {
        return m13183a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    /* renamed from: e */
    public static boolean m13189e(Context context, String str) {
        return m13183a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    /* renamed from: f */
    private static C3926b m13190f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (m13183a(context, str, "com.vivo.pushservice.action.METHOD") || m13183a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                C3926b c3926b = new C3926b(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        c3926b.m13061a(packageInfo.versionCode);
                        c3926b.m13063a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        c3926b.m13062a(C3990ag.m13207a(context, str));
                    }
                    c3926b.m13066b(m13182a(context, str));
                    c3926b.m13064a(m13181a(context, c3926b.m13065b()));
                    return c3926b;
                } catch (Exception e2) {
                    C4010u.m13293a("PushPackageUtils", "getPushPackageInfo exception: ", e2);
                }
            }
        }
        return null;
    }

    /* renamed from: g */
    private static String m13191g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & C5230f1.f20085c).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e2) {
                C4010u.m13292a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e2)));
            }
        }
        return null;
    }

    /* renamed from: b */
    public static int m13184b(Context context, String str) {
        int i2 = m13183a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (m13183a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i2;
    }

    /* renamed from: c */
    public static boolean m13187c(Context context, String str) {
        return m13183a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0139 A[Catch: Exception -> 0x0135, TryCatch #4 {Exception -> 0x0135, blocks: (B:94:0x0131, B:85:0x0139, B:87:0x013d), top: B:93:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String m13180a(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.C3984aa.m13180a(android.content.Context):java.lang.String");
    }

    /* renamed from: a */
    public static boolean m13182a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (queryIntentServices != null && queryIntentServices.size() > 0) {
                int size = queryIntentServices.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    ResolveInfo resolveInfo = queryIntentServices.get(i2);
                    if (resolveInfo != null && (serviceInfo = resolveInfo.serviceInfo) != null) {
                        String str2 = serviceInfo.name;
                        boolean z2 = resolveInfo.serviceInfo.exported;
                        if ("com.vivo.push.sdk.service.PushService".equals(str2) && z2) {
                            boolean z3 = resolveInfo.serviceInfo.enabled;
                            int componentEnabledSetting = packageManager.getComponentEnabledSetting(new ComponentName(str, "com.vivo.push.sdk.service.PushService"));
                            boolean z4 = true;
                            if (componentEnabledSetting != 1 && (componentEnabledSetting != 0 || !z3)) {
                                z4 = false;
                            }
                            z = z4;
                        }
                    }
                }
                return z;
            }
            C4010u.m13292a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m13181a(Context context, long j2) {
        InterfaceC3860d m12902a = C3858b.m12901a().m12902a(context);
        if (m12902a != null) {
            return m12902a.isInBlackList(j2);
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m13183a(Context context, String str, String str2) {
        List<ResolveInfo> list;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            list = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            list = null;
        }
        return list != null && list.size() > 0;
    }
}
