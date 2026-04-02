package com.vivo.push.util;

import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.database.Cursor;
import android.os.Build;
import android.text.TextUtils;
import bean.SurveyH5Bean;
import com.umeng.socialize.net.dplus.CommonNetImpl;
import i.f1;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

/* JADX INFO: compiled from: PushPackageUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class aa {
    private static Boolean a;

    /* JADX INFO: renamed from: b */
    private static String f8645b;

    public static com.vivo.push.model.b a(Context context, o oVar) {
        com.vivo.push.model.b bVarF;
        Context applicationContext = ContextDelegate.getContext(context).getApplicationContext();
        com.vivo.push.model.b bVarC = c(applicationContext);
        if (bVarC != null) {
            u.d("PushPackageUtils", "get system push info :".concat(String.valueOf(bVarC)));
            return bVarC;
        }
        List<String> listA = oVar.a(applicationContext);
        com.vivo.push.model.b bVarF2 = f(applicationContext, applicationContext.getPackageName());
        if (listA == null || listA.size() <= 0) {
            if (bVarF2 != null && bVarF2.d()) {
                bVarC = bVarF2;
            }
            u.a("PushPackageUtils", "findAllPushPackages error: find no package!");
        } else {
            com.vivo.push.model.b bVar = null;
            String strA = af.b(applicationContext).a("com.vivo.push.cur_pkg", null);
            if (TextUtils.isEmpty(strA) || !a(applicationContext, strA, "com.vivo.pushservice.action.METHOD") || (bVarC = f(applicationContext, strA)) == null || !bVarC.d()) {
                bVarC = null;
            }
            if (bVarF2 == null || !bVarF2.d()) {
                bVarF2 = null;
            }
            if (bVarC == null) {
                bVarC = null;
            }
            if (bVarF2 != null && (bVarC == null || (!bVarF2.c() ? bVarC.c() || bVarF2.b() > bVarC.b() : bVarC.c() && bVarF2.b() > bVarC.b()))) {
                bVarC = bVarF2;
            }
            HashMap map = new HashMap();
            if (bVarC == null) {
                bVarC = null;
            } else if (bVarC.c()) {
                bVar = bVarC;
                bVarC = null;
            }
            int size = listA.size();
            for (int i2 = 0; i2 < size; i2++) {
                String str = listA.get(i2);
                if (!TextUtils.isEmpty(str) && (bVarF = f(applicationContext, str)) != null) {
                    map.put(str, bVarF);
                    if (bVarF.d()) {
                        if (bVarF.c()) {
                            if (bVar == null || bVarF.b() > bVar.b()) {
                                bVar = bVarF;
                            }
                        } else if (bVarC == null || bVarF.b() > bVarC.b()) {
                            bVarC = bVarF;
                        }
                    }
                }
            }
            if (bVarC == null) {
                u.d("PushPackageUtils", "findSuitablePushPackage, all push app in balck list.");
                bVarC = bVar;
            }
        }
        if (bVarC == null) {
            u.b(applicationContext, "\u67e5\u627e\u6700\u4f18\u5305\u4e3a\u7a7a!");
            u.d("PushPackageUtils", "finSuitablePushPackage is null");
        } else if (bVarC.c()) {
            u.a(applicationContext, "\u67e5\u627e\u6700\u4f18\u5305\u4e3a:" + bVarC.a() + "(" + bVarC.b() + ", Black)");
            u.d("PushPackageUtils", "finSuitablePushPackage" + bVarC.a() + "(" + bVarC.b() + ", Black)");
        } else {
            u.a(applicationContext, "\u67e5\u627e\u6700\u4f18\u5305\u4e3a:" + bVarC.a() + "(" + bVarC.b() + ")");
            u.d("PushPackageUtils", "finSuitablePushPackage" + bVarC.a() + "(" + bVarC.b() + ")");
        }
        return bVarC;
    }

    public static boolean b(Context context) {
        ProviderInfo providerInfoResolveContentProvider;
        Boolean bool = a;
        if (bool != null) {
            return bool.booleanValue();
        }
        String str = null;
        if (context != null && !TextUtils.isEmpty("com.vivo.push.sdk.service.SystemPushConfig") && (providerInfoResolveContentProvider = context.getPackageManager().resolveContentProvider("com.vivo.push.sdk.service.SystemPushConfig", 128)) != null) {
            str = providerInfoResolveContentProvider.packageName;
        }
        Boolean boolValueOf = Boolean.valueOf("BCC35D4D3606F154F0402AB7634E8490C0B244C2675C3C6238986987024F0C02".equals(g(context, str)));
        a = boolValueOf;
        return boolValueOf.booleanValue();
    }

    private static com.vivo.push.model.b c(Context context) {
        String strA = a(context);
        ApplicationInfo applicationInfo = null;
        if (TextUtils.isEmpty(strA)) {
            return null;
        }
        com.vivo.push.model.b bVar = new com.vivo.push.model.b(strA);
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(strA, 128);
            if (packageInfo != null) {
                bVar.a(packageInfo.versionCode);
                bVar.a(packageInfo.versionName);
                applicationInfo = packageInfo.applicationInfo;
            }
            if (applicationInfo != null) {
                bVar.a(ag.a(context, strA));
            }
            bVar.a(a(context, bVar.b()));
            bVar.b(a(context, strA));
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
                byte[] bArrDigest = MessageDigest.getInstance("SHA256").digest(signatureArr[0].toByteArray());
                StringBuffer stringBuffer = new StringBuffer();
                for (byte b2 : bArrDigest) {
                    String upperCase = Integer.toHexString(b2 & f1.f12066c).toUpperCase(Locale.US);
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

    /* JADX WARN: Removed duplicated region for block: B:237:0x011f A[Catch: Exception -> 0x00fa, TRY_ENTER, TryCatch #11 {Exception -> 0x00fa, blocks: (B:218:0x00f6, B:222:0x00fe, B:224:0x0102, B:237:0x011f, B:239:0x0124, B:241:0x0128), top: B:268:0x0014 }] */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0139 A[Catch: Exception -> 0x0135, TryCatch #4 {Exception -> 0x0135, blocks: (B:246:0x0131, B:250:0x0139, B:252:0x013d), top: B:263:0x0131 }] */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0131 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String a(Context context) {
        Throwable th;
        Cursor cursorQuery;
        ContentProviderClient contentProviderClientAcquireUnstableContentProviderClient;
        Exception e2;
        String string;
        Cursor cursorQuery2;
        if (!TextUtils.isEmpty(f8645b)) {
            return f8645b;
        }
        Cursor cursor = null;
        try {
            try {
                if (Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient = context.getContentResolver().acquireUnstableContentProviderClient(com.vivo.push.x.a);
                    if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        try {
                            try {
                                u.a("PushPackageUtils", "client is null");
                                cursorQuery2 = contentProviderClientAcquireUnstableContentProviderClient.query(com.vivo.push.x.a, null, null, null, null);
                            } catch (Throwable th2) {
                                th = th2;
                                cursorQuery = cursor;
                                if (cursorQuery != null) {
                                }
                                if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                                    contentProviderClientAcquireUnstableContentProviderClient.close();
                                }
                                throw th;
                            }
                        } catch (Exception e3) {
                            e2 = e3;
                            string = null;
                        }
                    } else {
                        cursorQuery2 = null;
                    }
                } else {
                    contentProviderClientAcquireUnstableContentProviderClient = null;
                    cursorQuery2 = null;
                }
                if (cursorQuery2 == null) {
                    try {
                        cursorQuery = context.getContentResolver().query(com.vivo.push.x.a, null, null, null, null);
                    } catch (Exception e4) {
                        e2 = e4;
                        Cursor cursor2 = cursorQuery2;
                        string = null;
                        cursor = cursor2;
                    } catch (Throwable th3) {
                        th = th3;
                        cursorQuery = cursorQuery2;
                        if (cursorQuery != null) {
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                        }
                        throw th;
                    }
                } else {
                    cursorQuery = cursorQuery2;
                }
            } catch (Exception e5) {
                e2 = e5;
                contentProviderClientAcquireUnstableContentProviderClient = null;
                string = null;
            } catch (Throwable th4) {
                th = th4;
                cursorQuery = null;
                contentProviderClientAcquireUnstableContentProviderClient = null;
            }
        } catch (Exception e6) {
            u.a("PushPackageUtils", "close", e6);
        }
        try {
            if (cursorQuery == null) {
                try {
                    u.a("PushPackageUtils", "cursor is null");
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e7) {
                            u.a("PushPackageUtils", "close", e7);
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return null;
                } catch (Exception e8) {
                    e2 = e8;
                    string = null;
                }
            } else {
                string = null;
                boolean z = false;
                while (cursorQuery.moveToNext()) {
                    try {
                        if ("pushPkgName".equals(cursorQuery.getString(cursorQuery.getColumnIndex(CommonNetImpl.NAME)))) {
                            string = cursorQuery.getString(cursorQuery.getColumnIndex(SurveyH5Bean.VALUE));
                        } else if ("pushEnable".equals(cursorQuery.getString(cursorQuery.getColumnIndex(CommonNetImpl.NAME)))) {
                            z = Boolean.parseBoolean(cursorQuery.getString(cursorQuery.getColumnIndex(SurveyH5Bean.VALUE)));
                        }
                    } catch (Exception e9) {
                        e2 = e9;
                        cursor = cursorQuery;
                        u.a("PushPackageUtils", "getSystemPush", e2);
                        if (cursor != null) {
                        }
                        if (contentProviderClientAcquireUnstableContentProviderClient != null) {
                            contentProviderClientAcquireUnstableContentProviderClient.close();
                        }
                    }
                }
                f8645b = string;
                if (TextUtils.isEmpty(string)) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e10) {
                            u.a("PushPackageUtils", "close", e10);
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return null;
                }
                if (!z) {
                    if (cursorQuery != null) {
                        try {
                            cursorQuery.close();
                        } catch (Exception e11) {
                            u.a("PushPackageUtils", "close", e11);
                        }
                    }
                    if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                        contentProviderClientAcquireUnstableContentProviderClient.close();
                    }
                    return null;
                }
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                    contentProviderClientAcquireUnstableContentProviderClient.close();
                }
                return string;
            }
            cursor = cursorQuery;
            return string;
        } catch (Throwable th5) {
            th = th5;
            if (cursorQuery != null) {
                try {
                    cursorQuery.close();
                } catch (Exception e12) {
                    u.a("PushPackageUtils", "close", e12);
                    throw th;
                }
            }
            if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
                contentProviderClientAcquireUnstableContentProviderClient.close();
            }
            throw th;
        }
        u.a("PushPackageUtils", "getSystemPush", e2);
        if (cursor != null) {
            cursor.close();
        }
        if (contentProviderClientAcquireUnstableContentProviderClient != null && Build.VERSION.SDK_INT >= 24) {
            contentProviderClientAcquireUnstableContentProviderClient.close();
        }
    }

    public static boolean a(Context context, String str) {
        ServiceInfo serviceInfo;
        if (!TextUtils.isEmpty(str) && context != null) {
            Intent intent = new Intent("com.vivo.pushservice.action.PUSH_SERVICE");
            intent.setPackage(str);
            PackageManager packageManager = context.getPackageManager();
            List<ResolveInfo> listQueryIntentServices = packageManager.queryIntentServices(intent, 576);
            if (listQueryIntentServices != null && listQueryIntentServices.size() > 0) {
                int size = listQueryIntentServices.size();
                boolean z = false;
                for (int i2 = 0; i2 < size; i2++) {
                    ResolveInfo resolveInfo = listQueryIntentServices.get(i2);
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
        com.vivo.push.cache.d dVarA = com.vivo.push.cache.b.a().a(context);
        if (dVarA != null) {
            return dVarA.isInBlackList(j2);
        }
        return false;
    }

    private static boolean a(Context context, String str, String str2) {
        List<ResolveInfo> listQueryBroadcastReceivers;
        Intent intent = new Intent(str2);
        intent.setPackage(str);
        try {
            listQueryBroadcastReceivers = context.getPackageManager().queryBroadcastReceivers(intent, 576);
        } catch (Exception unused) {
            listQueryBroadcastReceivers = null;
        }
        return listQueryBroadcastReceivers != null && listQueryBroadcastReceivers.size() > 0;
    }
}
