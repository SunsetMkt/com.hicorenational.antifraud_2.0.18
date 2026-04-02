package com.xiaomi.push;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.ServiceInfo;
import android.os.Build;
import com.xiaomi.push.service.XMJobService;

/* JADX INFO: loaded from: classes2.dex */
public final class dz {

    /* JADX INFO: renamed from: a */
    private static a f417a;

    /* JADX INFO: renamed from: a */
    private static final String f418a = XMJobService.class.getCanonicalName();
    private static int a = 0;

    interface a {
        void a();

        void a(boolean z);

        /* JADX INFO: renamed from: a */
        boolean mo370a();
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x009a A[EDGE_INSN: B:103:0x009a->B:88:0x009a BREAK  A[LOOP:0: B:64:0x0032->B:81:0x0079], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0065 A[Catch: Exception -> 0x007c, PHI: r5
  0x0065: PHI (r5v6 boolean) = (r5v5 boolean), (r5v8 boolean) binds: [B:66:0x003c, B:74:0x0062] A[DONT_GENERATE, DONT_INLINE], TRY_ENTER, TryCatch #1 {Exception -> 0x007c, blocks: (B:65:0x0034, B:67:0x003e, B:76:0x0065, B:78:0x006f), top: B:98:0x0034 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static void a(Context context) {
        boolean z;
        Context applicationContext = context.getApplicationContext();
        if ("com.xiaomi.xmsf".equals(applicationContext.getPackageName())) {
            f417a = new ea(applicationContext);
            return;
        }
        int i2 = 0;
        try {
            PackageInfo packageInfo = applicationContext.getPackageManager().getPackageInfo(applicationContext.getPackageName(), 4);
            if (packageInfo.services != null) {
                ServiceInfo[] serviceInfoArr = packageInfo.services;
                int length = serviceInfoArr.length;
                z = false;
                while (true) {
                    if (i2 >= length) {
                        break;
                    }
                    try {
                        ServiceInfo serviceInfo = serviceInfoArr[i2];
                        if (!"android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                            if (f418a.equals(serviceInfo.name) && "android.permission.BIND_JOB_SERVICE".equals(serviceInfo.permission)) {
                                z = true;
                                break;
                            }
                            i2++;
                        } else if (f418a.equals(serviceInfo.name)) {
                            z = true;
                            if (!z) {
                                break;
                            }
                        } else {
                            try {
                                if (f418a.equals(r.a(applicationContext, serviceInfo.name).getSuperclass().getCanonicalName())) {
                                }
                            } catch (Exception unused) {
                            }
                            if (!z) {
                            }
                        }
                    } catch (Exception e2) {
                        e = e2;
                        com.xiaomi.channel.commonutils.logger.b.m48a("check service err : " + e.getMessage());
                    }
                }
            } else {
                z = false;
            }
        } catch (Exception e3) {
            e = e3;
            z = false;
        }
        if (z || !r.m637a(applicationContext)) {
            int i3 = Build.VERSION.SDK_INT;
            f417a = new ea(applicationContext);
            return;
        }
        throw new RuntimeException("Should export service: " + f418a + " with permission android.permission.BIND_JOB_SERVICE in AndroidManifest.xml file");
    }

    public static synchronized void a(Context context, int i2) {
        int i3 = a;
        if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
            if (i2 == 2) {
                a = 2;
            } else {
                a = 0;
            }
        }
        if (i3 != a && a == 2) {
            a();
            f417a = new ec(context);
        }
    }

    public static synchronized void a(boolean z) {
        if (f417a == null) {
            com.xiaomi.channel.commonutils.logger.b.m48a("timer is not initialized");
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] register alarm. (" + z + ")");
        f417a.a(z);
    }

    public static synchronized void a() {
        if (f417a == null) {
            return;
        }
        com.xiaomi.channel.commonutils.logger.b.m48a("[Alarm] stop alarm.");
        f417a.a();
    }

    /* JADX INFO: renamed from: a */
    public static synchronized boolean m369a() {
        if (f417a == null) {
            return false;
        }
        return f417a.mo370a();
    }
}
