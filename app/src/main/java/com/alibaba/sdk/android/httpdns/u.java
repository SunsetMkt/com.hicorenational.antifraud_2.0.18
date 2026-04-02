package com.alibaba.sdk.android.httpdns;

import android.content.Context;
import android.content.SharedPreferences;
import androidx.core.app.NotificationCompat;
import com.xiaomi.mipush.sdk.Constants;
import java.net.SocketTimeoutException;

/* JADX INFO: loaded from: classes.dex */
public class u {
    private static SharedPreferences a = null;

    /* JADX INFO: renamed from: a */
    private static a f39a = a.ENABLE;

    /* JADX INFO: renamed from: d */
    private static boolean f2613d = false;

    /* JADX INFO: renamed from: e */
    private static long f2614e = 0;

    /* JADX INFO: renamed from: g */
    private static volatile int f2615g = 0;

    /* JADX INFO: renamed from: h */
    private static volatile int f2616h = 0;

    /* JADX INFO: renamed from: l */
    private static boolean f2617l = false;

    enum a {
        ENABLE,
        PRE_DISABLE,
        DISABLE
    }

    static synchronized String a(s sVar) {
        try {
            if (sVar != s.QUERY_HOST && sVar != s.SNIFF_HOST) {
                return (sVar == s.QUERY_SCHEDULE_CENTER || sVar == s.SNIFF_SCHEDULE_CENTER) ? null : null;
            }
            if (f39a != a.ENABLE && f39a != a.PRE_DISABLE) {
                if (sVar == s.QUERY_HOST) {
                    return null;
                }
                return f.f19a[f2615g];
            }
            return f.f19a[f2615g];
        } catch (Exception e2) {
            e2.printStackTrace();
            return null;
        }
    }

    static synchronized void a(Context context) {
        if (!f2613d) {
            synchronized (u.class) {
                if (!f2613d) {
                    if (context != null) {
                        a = context.getSharedPreferences("httpdns_config_cache", 0);
                    }
                    f2617l = a.getBoolean(NotificationCompat.CATEGORY_STATUS, false);
                    f2615g = a.getInt("activiate_ip_index", 0);
                    f2616h = f2615g;
                    f2614e = a.getLong("disable_modified_time", 0L);
                    if (System.currentTimeMillis() - f2614e >= 86400000) {
                        d(false);
                    }
                    f39a = f2617l ? a.DISABLE : a.ENABLE;
                    f2613d = true;
                }
            }
        }
    }

    static synchronized void a(String str, String str2, long j2) {
        try {
            b(str, str2, j2);
            reportHttpDnsSuccess(str, 1);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        if (f39a != a.ENABLE && str2 != null && str2.equals(f.f19a[f2615g])) {
            StringBuilder sb = new StringBuilder();
            sb.append(f39a == a.DISABLE ? "Disable " : "Pre_disable ");
            sb.append("mode finished. Enter enable mode.");
            i.f(sb.toString());
            f39a = a.ENABLE;
            d(false);
            t.a().g();
            f2616h = f2615g;
        }
    }

    static synchronized void a(String str, String str2, Throwable th) {
        try {
            a(str2, th);
            if (a(th) && str2 != null && str2.equals(f.f19a[f2615g])) {
                h();
                if (f2616h == f2615g) {
                    t.a().c(false);
                    n.a().c();
                }
                if (f39a == a.ENABLE) {
                    f39a = a.PRE_DISABLE;
                    i.f("enter pre_disable mode");
                } else if (f39a == a.PRE_DISABLE) {
                    f39a = a.DISABLE;
                    i.f("enter disable mode");
                    d(true);
                    h(str);
                    t.a().g(str);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static void a(String str, Throwable th) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                int iA = com.alibaba.sdk.android.httpdns.d.c.a(th);
                bVarA.a(str, String.valueOf(iA), com.alibaba.sdk.android.httpdns.d.c.m18a(th), com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.net64.a.a().i() ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    private static boolean a(Throwable th) {
        if (th instanceof SocketTimeoutException) {
            return true;
        }
        if (th instanceof h) {
            h hVar = (h) th;
            if (hVar.getErrorCode() == 403 && hVar.getMessage().equals("ServiceLevelDeny")) {
                return true;
            }
        }
        return false;
    }

    static void b(int i2) {
        if (a == null || i2 < 0 || i2 >= f.f19a.length) {
            return;
        }
        f2615g = i2;
        SharedPreferences.Editor editorEdit = a.edit();
        editorEdit.putInt("activiate_ip_index", i2);
        editorEdit.putLong("activiated_ip_index_modified_time", System.currentTimeMillis());
        editorEdit.commit();
    }

    private static void b(String str, String str2, long j2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.b(str2, j2, com.alibaba.sdk.android.httpdns.d.c.a());
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static synchronized void d(boolean z) {
        if (f2617l != z) {
            f2617l = z;
            if (a != null) {
                SharedPreferences.Editor editorEdit = a.edit();
                editorEdit.putBoolean(NotificationCompat.CATEGORY_STATUS, f2617l);
                editorEdit.putLong("disable_modified_time", System.currentTimeMillis());
                editorEdit.commit();
            }
        }
    }

    static synchronized boolean e() {
        return f2617l;
    }

    private static void h() {
        f2615g = f2615g == f.f19a.length + (-1) ? 0 : f2615g + 1;
        b(f2615g);
    }

    private static void h(String str) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                String strM25d = n.a().m25d();
                int length = f2615g;
                if (length == 0) {
                    length = f.f19a.length;
                }
                int i2 = length - 1;
                int length2 = i2 == 0 ? f.f19a.length - 1 : i2 - 1;
                if (i2 < 0 || i2 >= f.f19a.length || length2 < 0 || length2 >= f.f19a.length) {
                    return;
                }
                String str2 = f.f19a[i2];
                bVarA.b(str, strM25d, f.f19a[length2] + Constants.ACCEPT_TIME_SEPARATOR_SP + str2);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    static void i() {
        b(0);
        f2616h = f2615g;
        t.a().c(true);
    }

    static void j() {
        t.a().c(true);
    }

    public static void reportHttpDnsSuccess(String str, int i2) {
        try {
            com.alibaba.sdk.android.httpdns.d.b bVarA = com.alibaba.sdk.android.httpdns.d.b.a();
            if (bVarA != null) {
                bVarA.a(str, i2, com.alibaba.sdk.android.httpdns.d.c.a(), com.alibaba.sdk.android.httpdns.b.b.m7a() ? 1 : 0);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
