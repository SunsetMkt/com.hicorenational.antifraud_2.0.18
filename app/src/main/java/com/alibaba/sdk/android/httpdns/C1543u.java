package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.alibaba.sdk.android.httpdns.net64.C1528a;
import com.alibaba.sdk.android.httpdns.p112b.C1505b;
import com.alibaba.sdk.android.httpdns.p114d.C1515b;
import com.alibaba.sdk.android.httpdns.p114d.C1516c;
import com.xiaomi.mipush.sdk.Constants;
import java.net.SocketTimeoutException;

/* renamed from: com.alibaba.sdk.android.httpdns.u */
/* loaded from: classes.dex */
public class C1543u {

    /* renamed from: a */
    private static SharedPreferences f4006a = null;

    /* renamed from: a */
    private static a f4007a = a.ENABLE;

    /* renamed from: d */
    private static boolean f4008d = false;

    /* renamed from: e */
    private static long f4009e = 0;

    /* renamed from: g */
    private static volatile int f4010g = 0;

    /* renamed from: h */
    private static volatile int f4011h = 0;

    /* renamed from: l */
    private static boolean f4012l = false;

    /* renamed from: com.alibaba.sdk.android.httpdns.u$a */
    enum a {
        ENABLE,
        PRE_DISABLE,
        DISABLE
    }

    /* renamed from: a */
    static synchronized String m3586a(EnumC1541s enumC1541s) {
        synchronized (C1543u.class) {
            try {
                if (enumC1541s != EnumC1541s.QUERY_HOST && enumC1541s != EnumC1541s.SNIFF_HOST) {
                    return (enumC1541s == EnumC1541s.QUERY_SCHEDULE_CENTER || enumC1541s == EnumC1541s.SNIFF_SCHEDULE_CENTER) ? null : null;
                }
                if (f4007a != a.ENABLE && f4007a != a.PRE_DISABLE) {
                    if (enumC1541s == EnumC1541s.QUERY_HOST) {
                        return null;
                    }
                    return C1519f.f3922a[f4010g];
                }
                return C1519f.f3922a[f4010g];
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    /* renamed from: a */
    static synchronized void m3587a(Context context) {
        synchronized (C1543u.class) {
            if (!f4008d) {
                synchronized (C1543u.class) {
                    if (!f4008d) {
                        if (context != null) {
                            f4006a = context.getSharedPreferences("httpdns_config_cache", 0);
                        }
                        f4012l = f4006a.getBoolean(NotificationCompat.CATEGORY_STATUS, false);
                        f4010g = f4006a.getInt("activiate_ip_index", 0);
                        f4011h = f4010g;
                        f4009e = f4006a.getLong("disable_modified_time", 0L);
                        if (System.currentTimeMillis() - f4009e >= 86400000) {
                            m3594d(false);
                        }
                        f4007a = f4012l ? a.DISABLE : a.ENABLE;
                        f4008d = true;
                    }
                }
            }
        }
    }

    /* renamed from: a */
    static synchronized void m3588a(String str, String str2, long j2) {
        synchronized (C1543u.class) {
            try {
                m3593b(str, str2, j2);
                reportHttpDnsSuccess(str, 1);
                if (f4007a != a.ENABLE && str2 != null && str2.equals(C1519f.f3922a[f4010g])) {
                    StringBuilder sb = new StringBuilder();
                    sb.append(f4007a == a.DISABLE ? "Disable " : "Pre_disable ");
                    sb.append("mode finished. Enter enable mode.");
                    C1522i.m3527f(sb.toString());
                    f4007a = a.ENABLE;
                    m3594d(false);
                    C1542t.m3580a().m3584g();
                    f4011h = f4010g;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    static synchronized void m3589a(String str, String str2, Throwable th) {
        synchronized (C1543u.class) {
            try {
                m3590a(str2, th);
                if (m3591a(th) && str2 != null && str2.equals(C1519f.f3922a[f4010g])) {
                    m3596h();
                    if (f4011h == f4010g) {
                        C1542t.m3580a().m3583c(false);
                        C1527n.m3536a().m3548c();
                    }
                    if (f4007a == a.ENABLE) {
                        f4007a = a.PRE_DISABLE;
                        C1522i.m3527f("enter pre_disable mode");
                    } else if (f4007a == a.PRE_DISABLE) {
                        f4007a = a.DISABLE;
                        C1522i.m3527f("enter disable mode");
                        m3594d(true);
                        m3597h(str);
                        C1542t.m3580a().m3585g(str);
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    private static void m3590a(String str, Throwable th) {
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                int m3507a = C1516c.m3507a(th);
                m3486a.m3493a(str, String.valueOf(m3507a), C1516c.m3508a(th), C1516c.m3506a(), C1528a.m3551a().m3555i() ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: a */
    private static boolean m3591a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        if (th instanceof C1521h) {
            C1521h c1521h = (C1521h) th;
            if (c1521h.getErrorCode() == 403 && c1521h.getMessage().equals("ServiceLevelDeny")) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    static void m3592b(int i2) {
        if (f4006a == null || i2 < 0 || i2 >= C1519f.f3922a.length) {
            return;
        }
        f4010g = i2;
        SharedPreferences.Editor edit = f4006a.edit();
        edit.putInt("activiate_ip_index", i2);
        edit.putLong("activiated_ip_index_modified_time", System.currentTimeMillis());
        edit.commit();
    }

    /* renamed from: b */
    private static void m3593b(String str, String str2, long j2) {
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                m3486a.m3497b(str2, j2, C1516c.m3506a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: d */
    static synchronized void m3594d(boolean z) {
        synchronized (C1543u.class) {
            if (f4012l != z) {
                f4012l = z;
                if (f4006a != null) {
                    SharedPreferences.Editor edit = f4006a.edit();
                    edit.putBoolean(NotificationCompat.CATEGORY_STATUS, f4012l);
                    edit.putLong("disable_modified_time", System.currentTimeMillis());
                    edit.commit();
                }
            }
        }
    }

    /* renamed from: e */
    static synchronized boolean m3595e() {
        boolean z;
        synchronized (C1543u.class) {
            z = f4012l;
        }
        return z;
    }

    /* renamed from: h */
    private static void m3596h() {
        f4010g = f4010g == C1519f.f3922a.length + (-1) ? 0 : f4010g + 1;
        m3592b(f4010g);
    }

    /* renamed from: h */
    private static void m3597h(String str) {
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                String m3550d = C1527n.m3536a().m3550d();
                int i2 = f4010g;
                if (i2 == 0) {
                    i2 = C1519f.f3922a.length;
                }
                int i3 = i2 - 1;
                int length = i3 == 0 ? C1519f.f3922a.length - 1 : i3 - 1;
                if (i3 < 0 || i3 >= C1519f.f3922a.length || length < 0 || length >= C1519f.f3922a.length) {
                    return;
                }
                String str2 = C1519f.f3922a[i3];
                m3486a.m3498b(str, m3550d, C1519f.f3922a[length] + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    /* renamed from: i */
    static void m3598i() {
        m3592b(0);
        f4011h = f4010g;
        C1542t.m3580a().m3583c(true);
    }

    /* renamed from: j */
    static void m3599j() {
        C1542t.m3580a().m3583c(true);
    }

    public static void reportHttpDnsSuccess(String str, int i2) {
        try {
            C1515b m3486a = C1515b.m3486a();
            if (m3486a != null) {
                m3486a.m3489a(str, i2, C1516c.m3506a(), C1505b.m3438a() ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
