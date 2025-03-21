package com.xiaomi.push;

import android.os.SystemClock;
import com.heytap.mcssdk.constant.C2084a;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.C4192em;
import com.xiaomi.push.service.C4361am;
import com.xiaomi.push.service.XMPushService;
import java.util.Hashtable;

/* renamed from: com.xiaomi.push.ep */
/* loaded from: classes2.dex */
public class C4195ep {

    /* renamed from: a */
    private static final int f15204a = EnumC4188ei.PING_RTT.m14600a();

    /* renamed from: a */
    private static long f15205a = 0;

    /* renamed from: com.xiaomi.push.ep$a */
    static class a {

        /* renamed from: a */
        static Hashtable<Integer, Long> f15206a = new Hashtable<>();
    }

    /* renamed from: a */
    public static void m14674a(String str, Exception exc) {
        try {
            C4192em.a m14647b = C4192em.m14647b(exc);
            C4189ej m14659a = C4194eo.m14657a().m14659a();
            m14659a.m14603a(m14647b.f15183a.m14600a());
            m14659a.m14616c(m14647b.f15184a);
            m14659a.m14611b(str);
            if (C4194eo.m14656a() != null && C4194eo.m14656a().f15188a != null) {
                m14659a.m14615c(C4092au.m13801b(C4194eo.m14656a().f15188a) ? 1 : 0);
            }
            C4194eo.m14657a().m14662a(m14659a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: b */
    public static void m14677b(String str, Exception exc) {
        try {
            C4192em.a m14649d = C4192em.m14649d(exc);
            C4189ej m14659a = C4194eo.m14657a().m14659a();
            m14659a.m14603a(m14649d.f15183a.m14600a());
            m14659a.m14616c(m14649d.f15184a);
            m14659a.m14611b(str);
            if (C4194eo.m14656a() != null && C4194eo.m14656a().f15188a != null) {
                m14659a.m14615c(C4092au.m13801b(C4194eo.m14656a().f15188a) ? 1 : 0);
            }
            C4194eo.m14657a().m14662a(m14659a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: a */
    public static void m14673a(String str, int i2, Exception exc) {
        C4189ej m14659a = C4194eo.m14657a().m14659a();
        if (C4194eo.m14656a() != null && C4194eo.m14656a().f15188a != null) {
            m14659a.m14615c(C4092au.m13801b(C4194eo.m14656a().f15188a) ? 1 : 0);
        }
        if (i2 > 0) {
            m14659a.m14603a(EnumC4188ei.GSLB_REQUEST_SUCCESS.m14600a());
            m14659a.m14611b(str);
            m14659a.m14610b(i2);
            C4194eo.m14657a().m14662a(m14659a);
            return;
        }
        try {
            C4192em.a m14645a = C4192em.m14645a(exc);
            m14659a.m14603a(m14645a.f15183a.m14600a());
            m14659a.m14616c(m14645a.f15184a);
            m14659a.m14611b(str);
            C4194eo.m14657a().m14662a(m14659a);
        } catch (NullPointerException unused) {
        }
    }

    /* renamed from: b */
    public static void m14676b() {
        m14671a(0, f15204a, null, -1);
    }

    /* renamed from: a */
    public static void m14672a(XMPushService xMPushService, C4361am.b bVar) {
        new C4191el(xMPushService, bVar).m14641a();
    }

    /* renamed from: a */
    public static synchronized void m14669a(int i2, int i3) {
        synchronized (C4195ep.class) {
            if (i3 < 16777215) {
                a.f15206a.put(Integer.valueOf((i2 << 24) | i3), Long.valueOf(System.currentTimeMillis()));
            } else {
                AbstractC4022b.m13361d("stats key should less than 16777215");
            }
        }
    }

    /* renamed from: a */
    public static synchronized void m14671a(int i2, int i3, String str, int i4) {
        synchronized (C4195ep.class) {
            long currentTimeMillis = System.currentTimeMillis();
            int i5 = (i2 << 24) | i3;
            if (a.f15206a.containsKey(Integer.valueOf(i5))) {
                C4189ej m14659a = C4194eo.m14657a().m14659a();
                m14659a.m14603a(i3);
                m14659a.m14610b((int) (currentTimeMillis - a.f15206a.get(Integer.valueOf(i5)).longValue()));
                m14659a.m14611b(str);
                if (i4 > -1) {
                    m14659a.m14615c(i4);
                }
                C4194eo.m14657a().m14662a(m14659a);
                a.f15206a.remove(Integer.valueOf(i3));
            } else {
                AbstractC4022b.m13361d("stats key not found");
            }
        }
    }

    /* renamed from: a */
    public static void m14667a() {
        if (f15205a == 0 || SystemClock.elapsedRealtime() - f15205a > C2084a.f6132n) {
            f15205a = SystemClock.elapsedRealtime();
            m14669a(0, f15204a);
        }
    }

    /* renamed from: a */
    public static void m14670a(int i2, int i3, int i4, String str, int i5) {
        C4189ej m14659a = C4194eo.m14657a().m14659a();
        m14659a.m14602a((byte) i2);
        m14659a.m14603a(i3);
        m14659a.m14610b(i4);
        m14659a.m14611b(str);
        m14659a.m14615c(i5);
        C4194eo.m14657a().m14662a(m14659a);
    }

    /* renamed from: a */
    public static void m14668a(int i2) {
        C4189ej m14659a = C4194eo.m14657a().m14659a();
        m14659a.m14603a(EnumC4188ei.CHANNEL_STATS_COUNTER.m14600a());
        m14659a.m14615c(i2);
        C4194eo.m14657a().m14662a(m14659a);
    }

    /* renamed from: a */
    public static byte[] m14675a() {
        C4190ek m14660a = C4194eo.m14657a().m14660a();
        if (m14660a != null) {
            return C4276hp.m15567a(m14660a);
        }
        return null;
    }
}
