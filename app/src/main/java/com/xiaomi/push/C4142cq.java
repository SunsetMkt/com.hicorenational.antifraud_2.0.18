package com.xiaomi.push;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.heytap.mcssdk.constant.C2084a;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.cq */
/* loaded from: classes2.dex */
public class C4142cq {

    /* renamed from: a */
    private static int f14777a;

    /* renamed from: a */
    private static int m14157a(boolean z) {
        return z ? 1 : 0;
    }

    /* renamed from: a */
    private static SharedPreferences m14158a(Context context) {
        return context.getSharedPreferences("sp_disconnect_stats", 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static synchronized void m14172c(Context context, String str, boolean z, long j2, int i2, long j3, int i3, String str2, int i4) {
        synchronized (C4142cq.class) {
            SharedPreferences m14158a = m14158a(context);
            long j4 = m14158a.getLong("start_time_for_day", 0L);
            if (j4 == 0) {
                C4139cn.m14125a("recordDisconnection not initialized");
                return;
            }
            if (j2 - m14158a.getLong("last_discnt_time", 0L) < C2084a.f6122d) {
                C4139cn.m14125a("recordDisconnection anti-shake");
                return;
            }
            if (j2 - j4 < 86400000) {
                int i5 = m14158a.getInt("discnt_count_in_day", 0);
                if (i5 > 100) {
                    C4139cn.m14125a("recordDisconnection count > 100 in 24H cycle,abandon.");
                    return;
                } else {
                    m14158a.edit().putInt("discnt_count_in_day", i5 + 1).apply();
                }
            } else {
                C4139cn.m14125a("recordDisconnection with the current time exceeds 24H cycle, go on.");
            }
            int i6 = m14158a.getInt("discnt_count", 0);
            if (i6 == m14158a.getInt("cnt_count", 0)) {
                m14165a(context, str, m14157a(z), j2, i2, j3, i3, str2, i4);
                m14158a.edit().putLong("last_discnt_time", j2).putInt("discnt_count", i6 + 1).apply();
            }
            C4139cn.m14125a("recordDisconnection complete");
        }
    }

    /* renamed from: a */
    public static void m14166a(final Context context, final String str, final boolean z, final long j2, final int i2, final long j3, final int i3, final String str2, final int i4) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.cq.1
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4142cq.m14172c(context, str, z, j2, i2, j3, i3, str2, i4);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("DisconnectStatsSP onDisconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    /* renamed from: a */
    public static void m14164a(final Context context, final long j2) {
        C4076ae.m13698a(context).m13703a(new Runnable() { // from class: com.xiaomi.push.cq.2
            @Override // java.lang.Runnable
            public void run() {
                try {
                    C4142cq.m14171c(context, j2);
                } catch (Exception e2) {
                    AbstractC4022b.m13347a("DisconnectStatsSP onReconnection exception: " + e2.getMessage());
                }
            }
        });
    }

    /* renamed from: b */
    private static void m14168b(Context context) {
        C4139cn.m14125a("resetAfterUpload");
        m14158a(context).edit().putString(Constants.KEY_HOST, null).putString("network_state", null).putString("reason", null).putString("ping_interval", null).putString(C3351bh.f11568T, null).putString("wifi_digest", null).putString("connected_network_type", null).putString("disconnect_time", null).putString("connected_time", null).putLong("last_discnt_time", 0L).putInt("discnt_count", 0).putInt("cnt_count", 0).putString("xmsf_vc", null).putString("android_vc", null).apply();
    }

    /* renamed from: a */
    private static void m14165a(Context context, String str, int i2, long j2, int i3, long j3, int i4, String str2, int i5) {
        C4139cn.m14125a(String.format(Locale.US, "recordDisconnectInfo host=%s, netState=%d, currentTimeMillis=%d, reason=%d, pingInterval=%d, netType=%d, wifiDigest=%s, connectedNetType=%d", str, Integer.valueOf(i2), Long.valueOf(j2), Integer.valueOf(i3), Long.valueOf(j3), Integer.valueOf(i4), str2, Integer.valueOf(i5)));
        SharedPreferences m14158a = m14158a(context);
        String string = m14158a.getString(Constants.KEY_HOST, null);
        String string2 = m14158a.getString("network_state", null);
        String string3 = m14158a.getString("reason", null);
        String string4 = m14158a.getString("ping_interval", null);
        String string5 = m14158a.getString(C3351bh.f11568T, null);
        String string6 = m14158a.getString("wifi_digest", null);
        String string7 = m14158a.getString("connected_network_type", null);
        String string8 = m14158a.getString("disconnect_time", null);
        String string9 = m14158a.getString("xmsf_vc", null);
        String string10 = m14158a.getString("android_vc", null);
        String m14161a = m14161a(string, str);
        String m14159a = m14159a(string2, i2);
        String m14159a2 = m14159a(string3, i3);
        String m14160a = m14160a(string4, j3);
        String m14159a3 = m14159a(string5, i4);
        String m14161a2 = m14161a(string6, str2);
        String m14159a4 = m14159a(string7, i5);
        String m14160a2 = m14160a(string8, j2);
        m14158a.edit().putString(Constants.KEY_HOST, m14161a).putString("network_state", m14159a).putString("reason", m14159a2).putString("ping_interval", m14160a).putString(C3351bh.f11568T, m14159a3).putString("wifi_digest", m14161a2).putString("connected_network_type", m14159a4).putString("disconnect_time", m14160a2).putString("xmsf_vc", m14159a(string9, m14156a(context))).putString("android_vc", m14159a(string10, Build.VERSION.SDK_INT)).apply();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: c */
    public static synchronized void m14171c(Context context, long j2) {
        synchronized (C4142cq.class) {
            SharedPreferences m14158a = m14158a(context);
            long j3 = m14158a.getLong("start_time_for_day", 0L);
            if (j3 == 0) {
                m14158a.edit().putLong("start_time_for_day", j2).putLong("last_discnt_time", 0L).putInt("discnt_count_in_day", 0).putInt("discnt_count", 0).putInt("cnt_count", 0).apply();
                return;
            }
            int i2 = m14158a.getInt("discnt_count", 0);
            int i3 = m14158a.getInt("cnt_count", 0);
            if (i2 > i3) {
                m14158a.edit().putInt("cnt_count", i3 + 1).putString("connected_time", m14160a(m14158a.getString("connected_time", null), j2)).apply();
            }
            if (j2 - j3 >= 86400000) {
                m14158a.edit().putLong("start_time_for_day", j2).putInt("discnt_count_in_day", 0).apply();
                m14163a(context);
            } else if (i2 >= 10) {
                m14163a(context);
            }
        }
    }

    /* renamed from: a */
    private static String m14161a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            str2 = AbstractC1191a.f2571h;
        }
        if (str == null || str.length() <= 0) {
            return str2;
        }
        return str + ";" + str2;
    }

    /* renamed from: a */
    private static String m14159a(String str, int i2) {
        return m14161a(str, String.valueOf(i2));
    }

    /* renamed from: a */
    private static String m14160a(String str, long j2) {
        return m14161a(str, String.valueOf(j2));
    }

    /* renamed from: a */
    private static void m14163a(Context context) {
        C4139cn.m14125a("upload");
        new C4141cp().m14155a(context, m14162a(context));
        m14168b(context);
    }

    /* renamed from: a */
    private static List<C4140co> m14162a(Context context) {
        SharedPreferences m14158a = m14158a(context);
        String[] m14167a = m14167a(m14158a.getString(Constants.KEY_HOST, null));
        if (m14167a != null && m14167a.length > 0) {
            String[] m14167a2 = m14167a(m14158a.getString("network_state", null));
            String[] m14167a3 = m14167a(m14158a.getString("reason", null));
            String[] m14167a4 = m14167a(m14158a.getString("ping_interval", null));
            String[] m14167a5 = m14167a(m14158a.getString(C3351bh.f11568T, null));
            String[] m14167a6 = m14167a(m14158a.getString("wifi_digest", null));
            String[] m14167a7 = m14167a(m14158a.getString("connected_network_type", null));
            String[] m14167a8 = m14167a(m14158a.getString("disconnect_time", null));
            String[] m14167a9 = m14167a(m14158a.getString("connected_time", null));
            String[] m14167a10 = m14167a(m14158a.getString("xmsf_vc", null));
            String[] m14167a11 = m14167a(m14158a.getString("android_vc", null));
            if (m14167a2 != null && m14167a3 != null && m14167a4 != null && m14167a5 != null && m14167a6 != null && m14167a7 != null && m14167a8 != null && m14167a9 != null && m14167a10 != null && m14167a11 != null && m14167a.length == m14167a2.length && m14167a.length == m14167a3.length && m14167a.length == m14167a4.length && m14167a.length == m14167a5.length && m14167a.length == m14167a6.length && m14167a.length == m14167a7.length && m14167a.length == m14167a8.length && m14167a.length == m14167a9.length && m14167a.length == m14167a10.length && m14167a.length == m14167a11.length) {
                ArrayList arrayList = new ArrayList(m14167a.length);
                int i2 = 0;
                while (i2 < m14167a.length) {
                    C4140co c4140co = new C4140co();
                    c4140co.m14132a(1);
                    c4140co.m14134a(m14167a[i2]);
                    c4140co.m14138b(C4310s.m15725a(m14167a2[i2], -1));
                    c4140co.m14143c(C4310s.m15725a(m14167a3[i2], -1));
                    String[] strArr = m14167a;
                    String[] strArr2 = m14167a3;
                    c4140co.m14133a(C4310s.m15726a(m14167a4[i2], -1L));
                    c4140co.m14147d(C4310s.m15725a(m14167a5[i2], -1));
                    c4140co.m14140b(m14167a6[i2]);
                    c4140co.m14150e(C4310s.m15725a(m14167a7[i2], -1));
                    long m15726a = C4310s.m15726a(m14167a8[i2], -1L);
                    long m15726a2 = C4310s.m15726a(m14167a9[i2], -1L);
                    c4140co.m14139b(m15726a2 - m15726a);
                    c4140co.m14144c(m15726a);
                    c4140co.m14148d(m15726a2);
                    c4140co.m14152f(C4310s.m15725a(m14167a10[i2], -1));
                    c4140co.m14154g(C4310s.m15725a(m14167a11[i2], -1));
                    arrayList.add(c4140co);
                    i2++;
                    m14167a = strArr;
                    m14167a5 = m14167a5;
                    m14167a2 = m14167a2;
                    m14167a3 = strArr2;
                    m14167a4 = m14167a4;
                    m14167a6 = m14167a6;
                }
                return arrayList;
            }
            AbstractC4022b.m13347a("DisconnectStatsSP Cached data incorrect,drop.");
            return null;
        }
        AbstractC4022b.m13347a("DisconnectStatsSP Cached hosts data is empty,drop.");
        return null;
    }

    /* renamed from: a */
    private static String[] m14167a(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        return str.split(";");
    }

    /* renamed from: a */
    private static int m14156a(Context context) {
        if (f14777a <= 0) {
            f14777a = C4300j.m15683b(context);
        }
        return f14777a;
    }
}
