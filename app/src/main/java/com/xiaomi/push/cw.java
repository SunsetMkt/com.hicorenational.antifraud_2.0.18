package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;

/* JADX INFO: loaded from: classes2.dex */
public class cw {
    private static int a = 0;

    /* JADX INFO: renamed from: a */
    private static boolean f290a = true;

    /* JADX INFO: renamed from: com.xiaomi.push.cw$1 */
    static class AnonymousClass1 implements Runnable {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Context f291a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ boolean f292a;

        AnonymousClass1(Context context, long j2, boolean z) {
            context = context;
            j = j2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cw.i(context, j, z);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onSendMsg exception: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.cw$2 */
    static class AnonymousClass2 implements Runnable {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Context f293a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ boolean f294a;

        AnonymousClass2(Context context, long j2, boolean z) {
            context = context;
            j = j2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cw.j(context, j, z);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onReceiveMsg exception: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.cw$3 */
    static class AnonymousClass3 implements Runnable {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Context f295a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ boolean f296a;

        AnonymousClass3(Context context, long j2, boolean z) {
            context = context;
            j = j2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cw.k(context, j, z);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onPing exception: " + e2.getMessage());
            }
        }
    }

    /* JADX INFO: renamed from: com.xiaomi.push.cw$4 */
    static class AnonymousClass4 implements Runnable {
        final /* synthetic */ long a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ Context f297a;

        /* JADX INFO: renamed from: a */
        final /* synthetic */ boolean f298a;

        AnonymousClass4(Context context, long j2, boolean z) {
            context = context;
            j = j2;
            z = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                cw.l(context, j, z);
            } catch (Exception e2) {
                com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onPong exception: " + e2.getMessage());
            }
        }
    }

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    /* JADX INFO: renamed from: a */
    private static SharedPreferences m256a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    public static void b(Context context, long j2, boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.2
            final /* synthetic */ long a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Context f293a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ boolean f294a;

            AnonymousClass2(Context context2, long j22, boolean z2) {
                context = context2;
                j = j22;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.j(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onReceiveMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void c(Context context, long j2, boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.3
            final /* synthetic */ long a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Context f295a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ boolean f296a;

            AnonymousClass3(Context context2, long j22, boolean z2) {
                context = context2;
                j = j22;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.k(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onPing exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void d(Context context, long j2, boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.4
            final /* synthetic */ long a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Context f297a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ boolean f298a;

            AnonymousClass4(Context context2, long j22, boolean z2) {
                context = context2;
                j = j22;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.l(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onPong exception: " + e2.getMessage());
                }
            }
        });
    }

    public static synchronized void i(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordSendMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM256a = m256a(context);
        long j3 = sharedPreferencesM256a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM256a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM256a.getInt("on_up_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("on_up_count", i2).apply();
        } else {
            i2 = sharedPreferencesM256a.getInt("off_up_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("off_up_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordSendMsg complete");
    }

    public static synchronized void j(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordReceiveMsg start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM256a = m256a(context);
        long j3 = sharedPreferencesM256a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM256a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM256a.getInt("on_down_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("on_down_count", i2).apply();
        } else {
            i2 = sharedPreferencesM256a.getInt("off_down_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("off_down_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordReceiveMsg complete");
    }

    public static synchronized void k(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordPing start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM256a = m256a(context);
        long j3 = sharedPreferencesM256a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM256a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM256a.getInt("on_ping_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("on_ping_count", i2).apply();
        } else {
            i2 = sharedPreferencesM256a.getInt("off_ping_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("off_ping_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordPing complete");
    }

    public static synchronized void l(Context context, long j2, boolean z) {
        int i2;
        ct.a("recordPong start");
        int iA = a(z);
        SharedPreferences sharedPreferencesM256a = m256a(context);
        long j3 = sharedPreferencesM256a.getLong(com.umeng.analytics.pro.d.p, 0L);
        if (j3 <= 0) {
            a(context, sharedPreferencesM256a, j2, iA);
        }
        if (iA == 1) {
            i2 = sharedPreferencesM256a.getInt("on_pong_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("on_pong_count", i2).apply();
        } else {
            i2 = sharedPreferencesM256a.getInt("off_pong_count", 0) + 1;
            sharedPreferencesM256a.edit().putInt("off_pong_count", i2).apply();
        }
        a(context, j3, j2, i2, iA);
        ct.a("recordPong complete");
    }

    public static void a(Context context, long j2, boolean z) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cw.1
            final /* synthetic */ long a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ Context f291a;

            /* JADX INFO: renamed from: a */
            final /* synthetic */ boolean f292a;

            AnonymousClass1(Context context2, long j22, boolean z2) {
                context = context2;
                j = j22;
                z = z2;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    cw.i(context, j, z);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m48a("PowerStatsSP onSendMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    private static void b(Context context, long j2, int i2) {
        ct.a("reset");
        m256a(context).edit().clear().putLong(com.umeng.analytics.pro.d.p, j2).putInt("current_screen_state", i2).putLong("current_screen_state_start_time", j2).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, SharedPreferences sharedPreferences, long j2, int i2) {
        ct.a("recordInit");
        sharedPreferences.edit().putLong(com.umeng.analytics.pro.d.p, j2).putInt("current_screen_state", i2).putLong("current_screen_state_start_time", j2).putInt("xmsf_vc", a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    private static void a(Context context, long j2, long j3, int i2, int i3) {
        if (j2 > 0) {
            if (m258a(context) || i2 >= 1073741823 || j3 - j2 >= 86400000) {
                m256a(context).edit().putLong(com.umeng.analytics.pro.d.q, j3).apply();
                a(context, j3, i3);
            }
        }
    }

    private static void a(Context context, long j2, int i2) {
        ct.a("upload");
        new cv().a(context, m257a(context));
        b(context, j2, i2);
    }

    /* JADX INFO: renamed from: a */
    private static cu m257a(Context context) {
        SharedPreferences sharedPreferencesM256a = m256a(context);
        cu cuVar = new cu();
        cuVar.a(sharedPreferencesM256a.getInt("off_up_count", 0));
        cuVar.b(sharedPreferencesM256a.getInt("off_down_count", 0));
        cuVar.c(sharedPreferencesM256a.getInt("off_ping_count", 0));
        cuVar.d(sharedPreferencesM256a.getInt("off_pong_count", 0));
        cuVar.a(sharedPreferencesM256a.getLong("off_duration", 0L));
        cuVar.e(sharedPreferencesM256a.getInt("on_up_count", 0));
        cuVar.f(sharedPreferencesM256a.getInt("on_down_count", 0));
        cuVar.g(sharedPreferencesM256a.getInt("on_ping_count", 0));
        cuVar.h(sharedPreferencesM256a.getInt("on_pong_count", 0));
        cuVar.b(sharedPreferencesM256a.getLong("on_duration", 0L));
        cuVar.c(sharedPreferencesM256a.getLong(com.umeng.analytics.pro.d.p, 0L));
        cuVar.d(sharedPreferencesM256a.getLong(com.umeng.analytics.pro.d.q, 0L));
        cuVar.i(sharedPreferencesM256a.getInt("xmsf_vc", 0));
        cuVar.j(sharedPreferencesM256a.getInt("android_vc", 0));
        return cuVar;
    }

    /* JADX INFO: renamed from: a */
    private static boolean m258a(Context context) {
        boolean z = false;
        if (f290a) {
            f290a = false;
            SharedPreferences sharedPreferencesM256a = m256a(context);
            int i2 = sharedPreferencesM256a.getInt("xmsf_vc", 0);
            int i3 = sharedPreferencesM256a.getInt("android_vc", 0);
            if (i2 != 0 && i3 != 0 && (i2 != a(context) || i3 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        ct.a("isVcChanged = " + z);
        return z;
    }

    private static int a(Context context) {
        if (a <= 0) {
            a = j.b(context);
        }
        return a;
    }
}
