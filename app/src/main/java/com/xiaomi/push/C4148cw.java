package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.umeng.analytics.pro.C3397d;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;

/* renamed from: com.xiaomi.push.cw */
/* loaded from: classes2.dex */
public class C4148cw {

    /* renamed from: a */
    private static int f14823a = 0;

    /* renamed from: a */
    private static boolean f14824a = true;

    /* renamed from: a */
    private static int m14223a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a */
    private static SharedPreferences m14224a(Context context) {
        return context.getSharedPreferences("sp_power_stats", 0);
    }

    /* renamed from: b */
    public static void m14232b(final Context context, final long j2, final boolean z) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.cw.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4148cw.m14240j(context, j2, z);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("PowerStatsSP onReceiveMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    /* renamed from: c */
    public static void m14233c(final Context context, final long j2, final boolean z) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.cw.3
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4148cw.m14241k(context, j2, z);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("PowerStatsSP onPing exception: " + e2.getMessage());
                }
            }
        });
    }

    /* renamed from: d */
    public static void m14234d(final Context context, final long j2, final boolean z) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.cw.4
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4148cw.m14242l(context, j2, z);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("PowerStatsSP onPong exception: " + e2.getMessage());
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: i */
    public static synchronized void m14239i(Context context, long j2, boolean z) {
        int i2;
        synchronized (C4148cw.class) {
            C4145ct.m14186a("recordSendMsg start");
            int m14223a = m14223a(z);
            SharedPreferences m14224a = m14224a(context);
            long j3 = m14224a.getLong(C3397d.f11950p, 0L);
            if (j3 <= 0) {
                m14229a(context, m14224a, j2, m14223a);
            }
            if (m14223a == 1) {
                i2 = m14224a.getInt("on_up_count", 0) + 1;
                m14224a.edit().putInt("on_up_count", i2).apply();
            } else {
                i2 = m14224a.getInt("off_up_count", 0) + 1;
                m14224a.edit().putInt("off_up_count", i2).apply();
            }
            m14227a(context, j3, j2, i2, m14223a);
            C4145ct.m14186a("recordSendMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: j */
    public static synchronized void m14240j(Context context, long j2, boolean z) {
        int i2;
        synchronized (C4148cw.class) {
            C4145ct.m14186a("recordReceiveMsg start");
            int m14223a = m14223a(z);
            SharedPreferences m14224a = m14224a(context);
            long j3 = m14224a.getLong(C3397d.f11950p, 0L);
            if (j3 <= 0) {
                m14229a(context, m14224a, j2, m14223a);
            }
            if (m14223a == 1) {
                i2 = m14224a.getInt("on_down_count", 0) + 1;
                m14224a.edit().putInt("on_down_count", i2).apply();
            } else {
                i2 = m14224a.getInt("off_down_count", 0) + 1;
                m14224a.edit().putInt("off_down_count", i2).apply();
            }
            m14227a(context, j3, j2, i2, m14223a);
            C4145ct.m14186a("recordReceiveMsg complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: k */
    public static synchronized void m14241k(Context context, long j2, boolean z) {
        int i2;
        synchronized (C4148cw.class) {
            C4145ct.m14186a("recordPing start");
            int m14223a = m14223a(z);
            SharedPreferences m14224a = m14224a(context);
            long j3 = m14224a.getLong(C3397d.f11950p, 0L);
            if (j3 <= 0) {
                m14229a(context, m14224a, j2, m14223a);
            }
            if (m14223a == 1) {
                i2 = m14224a.getInt("on_ping_count", 0) + 1;
                m14224a.edit().putInt("on_ping_count", i2).apply();
            } else {
                i2 = m14224a.getInt("off_ping_count", 0) + 1;
                m14224a.edit().putInt("off_ping_count", i2).apply();
            }
            m14227a(context, j3, j2, i2, m14223a);
            C4145ct.m14186a("recordPing complete");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: l */
    public static synchronized void m14242l(Context context, long j2, boolean z) {
        int i2;
        synchronized (C4148cw.class) {
            C4145ct.m14186a("recordPong start");
            int m14223a = m14223a(z);
            SharedPreferences m14224a = m14224a(context);
            long j3 = m14224a.getLong(C3397d.f11950p, 0L);
            if (j3 <= 0) {
                m14229a(context, m14224a, j2, m14223a);
            }
            if (m14223a == 1) {
                i2 = m14224a.getInt("on_pong_count", 0) + 1;
                m14224a.edit().putInt("on_pong_count", i2).apply();
            } else {
                i2 = m14224a.getInt("off_pong_count", 0) + 1;
                m14224a.edit().putInt("off_pong_count", i2).apply();
            }
            m14227a(context, j3, j2, i2, m14223a);
            C4145ct.m14186a("recordPong complete");
        }
    }

    /* renamed from: a */
    public static void m14228a(final Context context, final long j2, final boolean z) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.cw.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4148cw.m14239i(context, j2, z);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("PowerStatsSP onSendMsg exception: " + e2.getMessage());
                }
            }
        });
    }

    /* renamed from: b */
    private static void m14231b(Context context, long j2, int i2) {
        C4145ct.m14186a("reset");
        m14224a(context).edit().clear().putLong(C3397d.f11950p, j2).putInt("current_screen_state", i2).putLong("current_screen_state_start_time", j2).putInt("xmsf_vc", m14222a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    /* renamed from: a */
    private static void m14229a(Context context, SharedPreferences sharedPreferences, long j2, int i2) {
        C4145ct.m14186a("recordInit");
        sharedPreferences.edit().putLong(C3397d.f11950p, j2).putInt("current_screen_state", i2).putLong("current_screen_state_start_time", j2).putInt("xmsf_vc", m14222a(context)).putInt("android_vc", Build.VERSION.SDK_INT).apply();
    }

    /* renamed from: a */
    private static void m14227a(Context context, long j2, long j3, int i2, int i3) {
        if (j2 > 0) {
            if (m14230a(context) || i2 >= 1073741823 || j3 - j2 >= 86400000) {
                m14224a(context).edit().putLong(C3397d.f11951q, j3).apply();
                m14226a(context, j3, i3);
            }
        }
    }

    /* renamed from: a */
    private static void m14226a(Context context, long j2, int i2) {
        C4145ct.m14186a("upload");
        new C4147cv().m14221a(context, m14225a(context));
        m14231b(context, j2, i2);
    }

    /* renamed from: a */
    private static C4146cu m14225a(Context context) {
        SharedPreferences m14224a = m14224a(context);
        C4146cu c4146cu = new C4146cu();
        c4146cu.m14195a(m14224a.getInt("off_up_count", 0));
        c4146cu.m14199b(m14224a.getInt("off_down_count", 0));
        c4146cu.m14203c(m14224a.getInt("off_ping_count", 0));
        c4146cu.m14207d(m14224a.getInt("off_pong_count", 0));
        c4146cu.m14196a(m14224a.getLong("off_duration", 0L));
        c4146cu.m14210e(m14224a.getInt("on_up_count", 0));
        c4146cu.m14212f(m14224a.getInt("on_down_count", 0));
        c4146cu.m14214g(m14224a.getInt("on_ping_count", 0));
        c4146cu.m14216h(m14224a.getInt("on_pong_count", 0));
        c4146cu.m14200b(m14224a.getLong("on_duration", 0L));
        c4146cu.m14204c(m14224a.getLong(C3397d.f11950p, 0L));
        c4146cu.m14208d(m14224a.getLong(C3397d.f11951q, 0L));
        c4146cu.m14218i(m14224a.getInt("xmsf_vc", 0));
        c4146cu.m14220j(m14224a.getInt("android_vc", 0));
        return c4146cu;
    }

    /* renamed from: a */
    private static boolean m14230a(Context context) {
        boolean z = false;
        if (f14824a) {
            f14824a = false;
            SharedPreferences m14224a = m14224a(context);
            int i2 = m14224a.getInt("xmsf_vc", 0);
            int i3 = m14224a.getInt("android_vc", 0);
            if (i2 != 0 && i3 != 0 && (i2 != m14222a(context) || i3 != Build.VERSION.SDK_INT)) {
                z = true;
            }
        }
        C4145ct.m14186a("isVcChanged = " + z);
        return z;
    }

    /* renamed from: a */
    private static int m14222a(Context context) {
        if (f14823a <= 0) {
            f14823a = C4300j.m15683b(context);
        }
        return f14823a;
    }
}
