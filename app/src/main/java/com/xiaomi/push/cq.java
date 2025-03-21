package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.taobao.accs.common.Constants;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/* loaded from: classes2.dex */
public class cq {

    /* renamed from: a, reason: collision with root package name */
    private static int f12584a;

    private static int a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a, reason: collision with other method in class */
    private static SharedPreferences m249a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, String str, boolean z, long j2, int i2, long j3, int i3, String str2, int i4) {
        synchronized (cq.class) {
            SharedPreferences m249a = m249a(context);
            long j4 = m249a.getLong("start_time_for_day", 0L);
            if (j4 == 0) {
                cn.a("recordDisconnection not initialized");
                return;
            }
            if (j2 - m249a.getLong("last_discnt_time", 0L) < com.heytap.mcssdk.constant.a.f5800d) {
                cn.a("recordDisconnection anti-shake");
                return;
            }
            if (j2 - j4 < 86400000) {
                int i5 = m249a.getInt("discnt_count_in_day", 0);
                if (i5 > 100) {
                    cn.a("recordDisconnection count > 100 in 24H cycle,abandon.");
                    return;
                } else {
                    m249a.edit().putInt("discnt_count_in_day", i5 + 1).apply();
                }
            } else {
                cn.a("recordDisconnection with the current time exceeds 24H cycle, go on.");
            }
            int i6 = m249a.getInt("discnt_count", 0);
            if (i6 == m249a.getInt("cnt_count", 0)) {
                a(context, str, a(z), j2, i2, j3, i3, str2, i4);
                m249a.edit().putLong("last_discnt_time", j2).putInt("discnt_count", i6 + 1).apply();
            }
            cn.a("recordDisconnection complete");
        }
    }

    public static void a(final Context context, final String str, final boolean z, final long j2, final int i2, final long j3, final int i3, final String str2, final int i4) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cq.c(context, str, z, j2, i2, j3, i3, str2, i4);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP onDisconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    public static void a(final Context context, final long j2) {
        ae.a(context).a(new Runnable() { // from class: com.xiaomi.push.cq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    cq.c(context, j2);
                } catch (Exception e2) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP onReconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    private static void b(Context context) {
        cn.a("resetAfterUpload");
        m249a(context).edit().putString(Constants.KEY_HOST, null).putString("network_state", null).putString("reason", null).putString("ping_interval", null).putString(com.umeng.analytics.pro.bh.T, null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    private static void a(Context context, String str, int i2, long j2, int i3, long j3, int i4, String str2, int i5) {
        cn.a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), str2, Integer.valueOf(i5)));
        SharedPreferences m249a = m249a(context);
        String string = m249a.getString(Constants.KEY_HOST, null);
        String string2 = m249a.getString("network_state", null);
        String string3 = m249a.getString("reason", null);
        String string4 = m249a.getString("ping_interval", null);
        String string5 = m249a.getString(com.umeng.analytics.pro.bh.T, null);
        String string6 = m249a.getString("wifi_digest", null);
        String string7 = m249a.getString("connected_network_type", null);
        String string8 = m249a.getString("disconnect_time", null);
        String string9 = m249a.getString("xmsf_vc", null);
        String string10 = m249a.getString("android_vc", null);
        String a2 = a(string, str);
        String a3 = a(string2, i2);
        String a4 = a(string3, i3);
        String a5 = a(string4, j3);
        String a6 = a(string5, i4);
        String a7 = a(string6, str2);
        String a8 = a(string7, i5);
        String a9 = a(string8, j2);
        m249a.edit().putString(Constants.KEY_HOST, a2).putString("network_state", a3).putString("reason", a4).putString("ping_interval", a5).putString(com.umeng.analytics.pro.bh.T, a6).putString("wifi_digest", a7).putString("connected_network_type", a8).putString("disconnect_time", a9).putString("xmsf_vc", a(string9, a(context))).putString("android_vc", a(string10, Build.VERSION.SDK_INT)).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void c(Context context, long j2) {
        synchronized (cq.class) {
            SharedPreferences m249a = m249a(context);
            long j3 = m249a.getLong("start_time_for_day", 0L);
            if (j3 == 0) {
                m249a.edit().putLong("start_time_for_day", j2).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
                return;
            }
            int i2 = m249a.getInt("discnt_count", 0);
            int i3 = m249a.getInt("cnt_count", 0);
            if (i2 > i3) {
                m249a.edit().putInt("cnt_count", i3 + 1).putString("connected_time", a(m249a.getString("connected_time", null), j2)).apply();
            }
            if (j2 - j3 >= 86400000) {
                m249a.edit().putLong("start_time_for_day", j2).putInt("discnt_count_in_day", 0).apply();
                m251a(context);
            } else if (i2 >= 10) {
                m251a(context);
            }
        }
    }

    private static String a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = c.c.a.b.a.a.f3101h;
        }
        if (str == null || str.length() <= 0) {
            return str2;
        }
        return str + ";" + str2;
    }

    private static String a(String str, int i2) {
        return a(str, String.valueOf(i2));
    }

    private static String a(String str, long j2) {
        return a(str, String.valueOf(j2));
    }

    /* renamed from: a, reason: collision with other method in class */
    private static void m251a(Context context) {
        cn.a("upload");
        new cp().a(context, m250a(context));
        b(context);
    }

    /* renamed from: a, reason: collision with other method in class */
    private static List<co> m250a(Context context) {
        SharedPreferences m249a = m249a(context);
        String[] a2 = a(m249a.getString(Constants.KEY_HOST, null));
        if (a2 != null && a2.length > 0) {
            String[] a3 = a(m249a.getString("network_state", null));
            String[] a4 = a(m249a.getString("reason", null));
            String[] a5 = a(m249a.getString("ping_interval", null));
            String[] a6 = a(m249a.getString(com.umeng.analytics.pro.bh.T, null));
            String[] a7 = a(m249a.getString("wifi_digest", null));
            String[] a8 = a(m249a.getString("connected_network_type", null));
            String[] a9 = a(m249a.getString("disconnect_time", null));
            String[] a10 = a(m249a.getString("connected_time", null));
            String[] a11 = a(m249a.getString("xmsf_vc", null));
            String[] a12 = a(m249a.getString("android_vc", null));
            if (a3 != null && a4 != null && a5 != null && a6 != null && a7 != null && a8 != null && a9 != null && a10 != null && a11 != null && a12 != null && a2.length == a3.length && a2.length == a4.length && a2.length == a5.length && a2.length == a6.length && a2.length == a7.length && a2.length == a8.length && a2.length == a9.length && a2.length == a10.length && a2.length == a11.length && a2.length == a12.length) {
                ArrayList arrayList = new ArrayList(a2.length);
                int i2 = 0;
                while (i2 < a2.length) {
                    co coVar = new co();
                    coVar.a(1);
                    coVar.a(a2[i2]);
                    coVar.b(s.a(a3[i2], -1));
                    coVar.c(s.a(a4[i2], -1));
                    String[] strArr = a2;
                    String[] strArr2 = a4;
                    coVar.a(s.a(a5[i2], -1L));
                    coVar.d(s.a(a6[i2], -1));
                    coVar.b(a7[i2]);
                    coVar.e(s.a(a8[i2], -1));
                    long a13 = s.a(a9[i2], -1L);
                    long a14 = s.a(a10[i2], -1L);
                    coVar.b(a14 - a13);
                    coVar.c(a13);
                    coVar.d(a14);
                    coVar.f(s.a(a11[i2], -1));
                    coVar.g(s.a(a12[i2], -1));
                    arrayList.add(coVar);
                    i2++;
                    a2 = strArr;
                    a6 = a6;
                    a3 = a3;
                    a4 = strArr2;
                    a5 = a5;
                    a7 = a7;
                }
                return arrayList;
            }
            com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    }

    private static String[] a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    private static int a(Context context) {
        if (f12584a <= 0) {
            f12584a = j.b(context);
        }
        return f12584a;
    }
}
