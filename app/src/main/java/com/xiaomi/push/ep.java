package com.xiaomi.push;

import android.os.SystemClock;
import com.xiaomi.push.em;
import com.xiaomi.push.service.XMPushService;
import com.xiaomi.push.service.am;
import java.util.Hashtable;

/* JADX INFO: loaded from: classes2.dex */
public class ep {
    private static final int a = ei.PING_RTT.a();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static long f460a = 0;

    static class a {
        static Hashtable<Integer, Long> a = new Hashtable<>();
    }

    public static void a(String str, Exception exc) {
        try {
            em.a aVarB = em.b(exc);
            ej ejVarM382a = eo.m380a().m382a();
            ejVarM382a.a(aVarB.a.a());
            ejVarM382a.c(aVarB.f449a);
            ejVarM382a.b(str);
            if (eo.a() != null && eo.a().f452a != null) {
                ejVarM382a.c(au.b(eo.a().f452a) ? 1 : 0);
            }
            eo.m380a().a(ejVarM382a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b(String str, Exception exc) {
        try {
            em.a aVarD = em.d(exc);
            ej ejVarM382a = eo.m380a().m382a();
            ejVarM382a.a(aVarD.a.a());
            ejVarM382a.c(aVarD.f449a);
            ejVarM382a.b(str);
            if (eo.a() != null && eo.a().f452a != null) {
                ejVarM382a.c(au.b(eo.a().f452a) ? 1 : 0);
            }
            eo.m380a().a(ejVarM382a);
        } catch (NullPointerException unused) {
        }
    }

    public static void a(String str, int i2, Exception exc) {
        ej ejVarM382a = eo.m380a().m382a();
        if (eo.a() != null && eo.a().f452a != null) {
            ejVarM382a.c(au.b(eo.a().f452a) ? 1 : 0);
        }
        if (i2 > 0) {
            ejVarM382a.a(ei.GSLB_REQUEST_SUCCESS.a());
            ejVarM382a.b(str);
            ejVarM382a.b(i2);
            eo.m380a().a(ejVarM382a);
            return;
        }
        try {
            em.a aVarA = em.a(exc);
            ejVarM382a.a(aVarA.a.a());
            ejVarM382a.c(aVarA.f449a);
            ejVarM382a.b(str);
            eo.m380a().a(ejVarM382a);
        } catch (NullPointerException unused) {
        }
    }

    public static void b() {
        a(0, a, null, -1);
    }

    public static void a(XMPushService xMPushService, am.b bVar) {
        new el(xMPushService, bVar).a();
    }

    public static synchronized void a(int i2, int i3) {
        if (i3 < 16777215) {
            a.a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key should less than 16777215");
        }
    }

    public static synchronized void a(int i2, int i3, String str, int i4) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        int i5 = (i2 << 24) | i3;
        if (a.a.containsKey(Integer.valueOf(i5))) {
            ej ejVarM382a = eo.m380a().m382a();
            ejVarM382a.a(i3);
            ejVarM382a.b((int) (jCurrentTimeMillis - a.a.get(Integer.valueOf(i5)).longValue()));
            ejVarM382a.b(str);
            if (i4 > -1) {
                ejVarM382a.c(i4);
            }
            eo.m380a().a(ejVarM382a);
            a.a.remove(Integer.valueOf(i3));
        } else {
            com.xiaomi.channel.commonutils.logger.b.d("stats key not found");
        }
    }

    public static void a() {
        if (f460a == 0 || SystemClock.elapsedRealtime() - f460a > com.heytap.mcssdk.constant.a.f3878n) {
            f460a = SystemClock.elapsedRealtime();
            a(0, a);
        }
    }

    public static void a(int i2, int i3, int i4, String str, int i5) {
        ej ejVarM382a = eo.m380a().m382a();
        ejVarM382a.a((byte) i2);
        ejVarM382a.a(i3);
        ejVarM382a.b(i4);
        ejVarM382a.b(str);
        ejVarM382a.c(i5);
        eo.m380a().a(ejVarM382a);
    }

    public static void a(int i2) {
        ej ejVarM382a = eo.m380a().m382a();
        ejVarM382a.a(ei.CHANNEL_STATS_COUNTER.a());
        ejVarM382a.c(i2);
        eo.m380a().a(ejVarM382a);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static byte[] m386a() {
        ek ekVarM383a = eo.m380a().m383a();
        if (ekVarM383a != null) {
            return hp.a(ekVarM383a);
        }
        return null;
    }
}
