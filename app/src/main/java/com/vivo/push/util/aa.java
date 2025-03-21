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
import h.f1;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* compiled from: PushPackageUtils.java */
/* loaded from: classes2.dex */
public final class aa {

    /* renamed from: a, reason: collision with root package name */
    private static Boolean f12235a;

    /* renamed from: b, reason: collision with root package name */
    private static String f12236b;

    public static com.vivo.push.model.b a(Context context, o oVar) {
        com.vivo.push.model.b f2;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b c2 = c(applicationContext);
        if (c2 != null) {
            u.d("PushPackageUtils", "get system push info :".concat(String.valueOf(c2)));
            return c2;
        }
        List<String> a2 = oVar.a(applicationContext);
        com.vivo.push.model.b f3 = f(applicationContext, applicationContext.getPackageName());
        if (a2 == null || a2.size() <= 0) {
            if (f3 != null && f3.d()) {
                c2 = f3;
            }
            u.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            com.vivo.push.model.b bVar = null;
            String a3 = af.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(a3) || !a(applicationContext, a3, "com.vivo.pushservice.action.METHOD") || (c2 = f(applicationContext, a3)) == null || !c2.d()) {
                c2 = null;
            }
            if (f3 == null || !f3.d()) {
                f3 = null;
            }
            if (c2 == null) {
                c2 = null;
            }
            if (f3 != null && (c2 == null || (!f3.c() ? c2.c() || f3.b() > c2.b() : c2.c() && f3.b() > c2.b()))) {
                c2 = f3;
            }
            HashMap hashMap = new HashMap();
            if (c2 == null) {
                c2 = null;
            } else if (c2.c()) {
                bVar = c2;
                c2 = null;
            }
            int size = a2.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = a2.get(i2);
                if (!TextUtils.isEmpty(str) && (f2 = f(applicationContext, str)) != null) {
                    hashMap.put(str, f2);
                    if (f2.d()) {
                        if (f2.c()) {
                            if (bVar == null || f2.b() > bVar.b()) {
                                bVar = f2;
                            }
                        } else if (c2 == null || f2.b() > c2.b()) {
                            c2 = f2;
                        }
                    }
                }
            }
            if (c2 == null) {
                u.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                c2 = bVar;
            }
        }
        if (c2 == null) {
            u.b(applicationContext, "查找最优包为空!");
            u.d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (c2.c()) {
            u.a(applicationContext, "查找最优包为:" + c2.a() + "(" + c2.b() + ", Black)");
            u.d("PushPackageUtils", "finSuitablePushPackage" + c2.a() + "(" + c2.b() + ", Black)");
        } else {
            u.a(applicationContext, "查找最优包为:" + c2.a() + "(" + c2.b() + ")");
            u.d("PushPackageUtils", "finSuitablePushPackage" + c2.a() + "(" + c2.b() + ")");
        }
        return c2;
    }

    public static boolean b(Context context) {
        ProviderInfo resolveContentProvider;
        Boolean bool = f12235a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (resolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = resolveContentProvider.packageName;
        }
        Boolean valueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        f12235a = valueOf;
        return valueOf.booleanValue();
    }

    private static com.vivo.push.model.b c(Context context) {
        String a2 = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(a2)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(a2);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(a2, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(ag.a(context, a2));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, a2));
            return bVar;
        } catch (Exception e2) {
            e2.printStackTrace();
            u.b("PushPackageUtils", "PackageManager NameNotFoundException is null", e2);
            return null;
        }
    }

    public static boolean d(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.RECEIVE");
    }

    public static boolean e(Context context, String str) {
        return a(context, str, "com.vivo.pushservice.action.METHOD");
    }

    private static com.vivo.push.model.b f(Context context, String str) {
        ApplicationInfo applicationInfo;
        if (!TextUtils.isEmpty(str)) {
            if (a(context, str, "com.vivo.pushservice.action.METHOD") || a(context, str, "com.vivo.pushservice.action.RECEIVE")) {
                com.vivo.push.model.b bVar = new com.vivo.push.model.b(str);
                try {
                    PackageInfo packageInfo = context.getPackageManager().getPackageInfo(str, 128);
                    if (packageInfo != null) {
                        bVar.a(packageInfo.versionCode);
                        bVar.a(packageInfo.versionName);
                        applicationInfo = packageInfo.applicationInfo;
                    } else {
                        applicationInfo = null;
                    }
                    if (applicationInfo != null) {
                        bVar.a(ag.a(context, str));
                    }
                    bVar.b(a(context, str));
                    bVar.a(a(context, bVar.b()));
                    return bVar;
                } catch (Exception e2) {
                    u.a("PushPackageUtils", "getPushPackageInfo exception: ", e2);
                }
            }
        }
        return null;
    }

    private static String g(Context context, String str) {
        if (!TextUtils.isEmpty(str) && context != null) {
            try {
                Signature[] signatureArr = context.getPackageManager().getPackageInfo(str, 64).signatures;
                byte[] digest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : digest) {
                    String upperCase = Integer.toHexString(b2 & f1.f16099c).toUpperCase(Locale.US);
                    if (upperCase.length() == 1) {
                        stringBuffer.append("0");
                    }
                    stringBuffer.append(upperCase);
                }
                return stringBuffer.toString();
            } catch (Exception e2) {
                u.a("PushPackageUtils", " getSignatureSHA exception ".concat(String.valueOf(e2)));
            }
        }
        return null;
    }

    public static int b(Context context, String str) {
        int i2 = a(context, str, "com.vivo.pushservice.action.RECEIVE") ? 0 : -1;
        if (a(context, str, "com.vivo.pushclient.action.RECEIVE")) {
            return 1;
        }
        return i2;
    }

    public static boolean c(Context context, String str) {
        return a(context, str, "com.vivo.pushclient.action.RECEIVE");
    }

    /* JADX WARN: Removed duplicated region for block: B:85:0x0139 A[Catch: Exception -> 0x0135, TryCatch #4 {Exception -> 0x0135, blocks: (B:94:0x0131, B:85:0x0139, B:87:0x013d), top: B:93:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static java.lang.String a(android.content.Context r14) {
        /*
            Method dump skipped, instructions count: 325
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.vivo.push.util.aa.a(android.content.Context):java.lang.String");
    }

    public static boolean a(Context context, String str) {
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
            u.a("PushPackageUtils", "isEnablePush error: can not find push service.");
        }
        return false;
    }

    private static boolean a(Context context, long j2) {
        com.vivo.push.cache.d a2 = com.vivo.push.cache.b.a().a(context);
        if (a2 != null) {
            return a2.isInBlackList(j2);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
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
