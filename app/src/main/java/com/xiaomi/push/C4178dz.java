package com.xiaomi.push;

import android.content.Context;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.service.XMJobService;

/* renamed from: com.xiaomi.push.dz */
/* loaded from: classes2.dex */
public final class C4178dz {

    /* renamed from: a */
    private static a f15062a;

    /* renamed from: a */
    private static final String f15063a = XMJobService.class.getCanonicalName();

    /* renamed from: a */
    private static int f15061a = 0;

    /* renamed from: com.xiaomi.push.dz$a */
    interface a {
        /* renamed from: a */
        void mo14583a();

        /* renamed from: a */
        void mo14584a(boolean z);

        /* renamed from: a */
        boolean mo14585a();
    }

    /* JADX WARN: Code restructure failed: missing block: B:30:0x005e, code lost:
    
        if (com.xiaomi.push.C4178dz.f15063a.equals(com.xiaomi.push.C4309r.m15716a(r9, r6.name).getSuperclass().getCanonicalName()) != false) goto L15;
     */
    /* renamed from: a */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m14579a(android.content.Context r9) {
        /*
            java.lang.String r0 = "android.permission.BIND_JOB_SERVICE"
            android.content.Context r9 = r9.getApplicationContext()
            java.lang.String r1 = r9.getPackageName()
            java.lang.String r2 = "com.xiaomi.xmsf"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L1b
            com.xiaomi.push.ea r0 = new com.xiaomi.push.ea
            r0.<init>(r9)
            com.xiaomi.push.C4178dz.f15062a = r0
            goto Ld4
        L1b:
            android.content.pm.PackageManager r1 = r9.getPackageManager()
            r2 = 0
            java.lang.String r3 = r9.getPackageName()     // Catch: java.lang.Exception -> L80
            r4 = 4
            android.content.pm.PackageInfo r1 = r1.getPackageInfo(r3, r4)     // Catch: java.lang.Exception -> L80
            android.content.pm.ServiceInfo[] r3 = r1.services     // Catch: java.lang.Exception -> L80
            r4 = 1
            if (r3 == 0) goto L7e
            android.content.pm.ServiceInfo[] r1 = r1.services     // Catch: java.lang.Exception -> L80
            int r3 = r1.length     // Catch: java.lang.Exception -> L80
            r5 = 0
        L32:
            if (r2 >= r3) goto L9a
            r6 = r1[r2]     // Catch: java.lang.Exception -> L7c
            java.lang.String r7 = r6.permission     // Catch: java.lang.Exception -> L7c
            boolean r7 = r0.equals(r7)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L65
            java.lang.String r7 = com.xiaomi.push.C4178dz.f15063a     // Catch: java.lang.Exception -> L7c
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L7c
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L4a
        L48:
            r5 = 1
            goto L62
        L4a:
            java.lang.String r7 = r6.name     // Catch: java.lang.Exception -> L61
            java.lang.Class r7 = com.xiaomi.push.C4309r.m15716a(r9, r7)     // Catch: java.lang.Exception -> L61
            java.lang.String r8 = com.xiaomi.push.C4178dz.f15063a     // Catch: java.lang.Exception -> L61
            java.lang.Class r7 = r7.getSuperclass()     // Catch: java.lang.Exception -> L61
            java.lang.String r7 = r7.getCanonicalName()     // Catch: java.lang.Exception -> L61
            boolean r7 = r8.equals(r7)     // Catch: java.lang.Exception -> L61
            if (r7 == 0) goto L62
            goto L48
        L61:
        L62:
            if (r5 != r4) goto L65
            goto L9a
        L65:
            java.lang.String r7 = com.xiaomi.push.C4178dz.f15063a     // Catch: java.lang.Exception -> L7c
            java.lang.String r8 = r6.name     // Catch: java.lang.Exception -> L7c
            boolean r7 = r7.equals(r8)     // Catch: java.lang.Exception -> L7c
            if (r7 == 0) goto L79
            java.lang.String r6 = r6.permission     // Catch: java.lang.Exception -> L7c
            boolean r6 = r0.equals(r6)     // Catch: java.lang.Exception -> L7c
            if (r6 == 0) goto L79
            r5 = 1
            goto L9a
        L79:
            int r2 = r2 + 1
            goto L32
        L7c:
            r1 = move-exception
            goto L82
        L7e:
            r5 = 0
            goto L9a
        L80:
            r1 = move-exception
            r5 = 0
        L82:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "check service err : "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            com.xiaomi.channel.commonutils.logger.AbstractC4022b.m13347a(r1)
        L9a:
            if (r5 != 0) goto Lc9
            boolean r1 = com.xiaomi.push.C4309r.m15720a(r9)
            if (r1 != 0) goto La3
            goto Lc9
        La3:
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Should export service: "
            r1.append(r2)
            java.lang.String r2 = com.xiaomi.push.C4178dz.f15063a
            r1.append(r2)
            java.lang.String r2 = " with permission "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = " in AndroidManifest.xml file"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r9.<init>(r0)
            throw r9
        Lc9:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 21
            com.xiaomi.push.ea r0 = new com.xiaomi.push.ea
            r0.<init>(r9)
            com.xiaomi.push.C4178dz.f15062a = r0
        Ld4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.C4178dz.m14579a(android.content.Context):void");
    }

    /* renamed from: a */
    public static synchronized void m14580a(Context context, int i2) {
        synchronized (C4178dz.class) {
            int i3 = f15061a;
            if (!"com.xiaomi.xmsf".equals(context.getPackageName())) {
                if (i2 == 2) {
                    f15061a = 2;
                } else {
                    f15061a = 0;
                }
            }
            if (i3 != f15061a && f15061a == 2) {
                m14578a();
                f15062a = new C4182ec(context);
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m14581a(boolean z) {
        synchronized (C4178dz.class) {
            if (f15062a == null) {
                AbstractC4022b.m13347a("timer is not initialized");
                return;
            }
            AbstractC4022b.m13347a("[Alarm] register alarm. (" + z + ")");
            f15062a.mo14584a(z);
        }
    }

    /* renamed from: a */
    public static synchronized void m14578a() {
        synchronized (C4178dz.class) {
            if (f15062a == null) {
                return;
            }
            AbstractC4022b.m13347a("[Alarm] stop alarm.");
            f15062a.mo14583a();
        }
    }

    /* renamed from: a */
    public static synchronized boolean m14582a() {
        synchronized (C4178dz.class) {
            if (f15062a == null) {
                return false;
            }
            return f15062a.mo14585a();
        }
    }
}
