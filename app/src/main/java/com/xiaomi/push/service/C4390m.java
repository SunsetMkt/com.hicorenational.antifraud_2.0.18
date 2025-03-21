package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.analytics.pro.C3397d;
import com.xiaomi.channel.commonutils.logger.AbstractC4022b;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.C4093av;
import com.xiaomi.push.C4213fg;
import com.xiaomi.push.C4233g;
import com.xiaomi.push.C4237gd;
import com.xiaomi.push.C4243gj;
import com.xiaomi.push.C4300j;
import com.xiaomi.push.C4301k;
import com.xiaomi.push.EnumC4244gk;
import com.xiaomi.push.EnumC4304n;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* renamed from: com.xiaomi.push.service.m */
/* loaded from: classes2.dex */
public class C4390m {

    /* renamed from: a */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile C4390m f16710a;

    /* renamed from: a */
    private long f16712a;

    /* renamed from: a */
    private final Context f16713a;

    /* renamed from: a */
    private final SharedPreferences f16714a;

    /* renamed from: b */
    private final boolean f16721b;

    /* renamed from: c */
    private final boolean f16723c;

    /* renamed from: a */
    private final AtomicInteger f16716a = new AtomicInteger(0);

    /* renamed from: a */
    private String f16715a = null;

    /* renamed from: a */
    private volatile boolean f16717a = false;

    /* renamed from: b */
    private String f16719b = null;

    /* renamed from: b */
    private final AtomicInteger f16720b = new AtomicInteger(0);

    /* renamed from: c */
    private final AtomicInteger f16722c = new AtomicInteger(0);

    /* renamed from: a */
    private int f16711a = -1;

    /* renamed from: b */
    private long f16718b = -1;

    /* renamed from: d */
    private final boolean f16724d = m16139g();

    /* renamed from: com.xiaomi.push.service.m$a */
    private static class a {
        /* renamed from: a */
        public static String m16149a() {
            return "support_wifi_digest";
        }

        /* renamed from: a */
        public static String m16150a(String str) {
            return String.format("HB_%s", str);
        }

        /* renamed from: b */
        public static String m16151b() {
            return "record_support_wifi_digest_reported_time";
        }

        /* renamed from: b */
        public static String m16152b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        /* renamed from: c */
        public static String m16153c() {
            return "record_hb_count_start";
        }

        /* renamed from: d */
        public static String m16154d() {
            return "record_short_hb_count";
        }

        /* renamed from: e */
        public static String m16155e() {
            return "record_long_hb_count";
        }

        /* renamed from: f */
        public static String m16156f() {
            return "record_hb_change";
        }

        /* renamed from: g */
        public static String m16157g() {
            return "record_mobile_ptc";
        }

        /* renamed from: h */
        public static String m16158h() {
            return "record_wifi_ptc";
        }

        /* renamed from: i */
        public static String m16159i() {
            return "record_ptc_start";
        }

        /* renamed from: j */
        public static String m16160j() {
            return "keep_short_hb_effective_time";
        }
    }

    private C4390m(Context context) {
        this.f16713a = context;
        this.f16723c = C4300j.m15681a(context);
        this.f16721b = C4356ah.m15923a(this.f16713a).m15935a(EnumC4244gk.IntelligentHeartbeatSwitchBoolean.m15014a(), true);
        this.f16714a = this.f16713a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f16714a.getLong(a.m16153c(), -1L) == -1) {
            this.f16714a.edit().putLong(a.m16153c(), currentTimeMillis).apply();
        }
        this.f16712a = this.f16714a.getLong(a.m16159i(), -1L);
        if (this.f16712a == -1) {
            this.f16712a = currentTimeMillis;
            this.f16714a.edit().putLong(a.m16159i(), currentTimeMillis).apply();
        }
    }

    /* renamed from: a */
    public static C4390m m16121a(Context context) {
        if (f16710a == null) {
            synchronized (C4390m.class) {
                if (f16710a == null) {
                    f16710a = new C4390m(context);
                }
            }
        }
        return f16710a;
    }

    /* renamed from: b */
    private void m16126b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f16715a;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.f16724d) {
                    this.f16715a = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f16715a = null;
                }
            }
        } else {
            this.f16715a = str;
        }
        int i2 = this.f16714a.getInt(a.m16150a(this.f16715a), -1);
        long j2 = this.f16714a.getLong(a.m16152b(this.f16715a), -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 != -1) {
            if (j2 == -1) {
                this.f16714a.edit().putLong(a.m16152b(this.f16715a), currentTimeMillis + m16131d()).apply();
            } else if (currentTimeMillis > j2) {
                this.f16714a.edit().remove(a.m16150a(this.f16715a)).remove(a.m16152b(this.f16715a)).apply();
            }
        }
        this.f16716a.getAndSet(0);
        if (TextUtils.isEmpty(this.f16715a) || m16120a() != -1) {
            this.f16717a = false;
        } else {
            this.f16717a = true;
        }
        AbstractC4022b.m13347a(String.format("[HB] network changed, netid:%s, %s", this.f16715a, Boolean.valueOf(this.f16717a)));
    }

    /* renamed from: e */
    private void m16134e() {
        if (this.f16714a.getBoolean(a.m16149a(), false)) {
            return;
        }
        this.f16714a.edit().putBoolean(a.m16149a(), true).apply();
    }

    /* renamed from: f */
    private void m16136f() {
        int i2 = this.f16711a;
        String m16158h = i2 != 0 ? i2 != 1 ? null : a.m16158h() : a.m16157g();
        if (TextUtils.isEmpty(m16158h)) {
            return;
        }
        if (this.f16714a.getLong(a.m16159i(), -1L) == -1) {
            this.f16712a = System.currentTimeMillis();
            this.f16714a.edit().putLong(a.m16159i(), this.f16712a).apply();
        }
        this.f16714a.edit().putInt(m16158h, this.f16714a.getInt(m16158h, 0) + 1).apply();
    }

    /* renamed from: g */
    private void m16138g() {
        int i2;
        String[] split;
        String[] split2;
        if (m16130c()) {
            String string = this.f16714a.getString(a.m16156f(), null);
            char c2 = 1;
            char c3 = 0;
            if (!TextUtils.isEmpty(string) && (split = string.split("###")) != null) {
                int i3 = 0;
                while (i3 < split.length) {
                    if (!TextUtils.isEmpty(split[i3]) && (split2 = split[i3].split(":::")) != null && split2.length >= 4) {
                        String str = split2[c3];
                        String str2 = split2[c2];
                        String str3 = split2[2];
                        String str4 = split2[3];
                        HashMap hashMap = new HashMap();
                        hashMap.put("event", "change");
                        hashMap.put(Constants.KEY_MODEL, C4301k.m15694a());
                        hashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, str2);
                        hashMap.put("net_name", str);
                        hashMap.put(C3351bh.f11599aX, str3);
                        hashMap.put("timestamp", str4);
                        m16122a("category_hb_change", null, hashMap);
                        AbstractC4022b.m13347a("[HB] report hb changed events.");
                    }
                    i3++;
                    c2 = 1;
                    c3 = 0;
                }
                this.f16714a.edit().remove(a.m16156f()).apply();
            }
            if (this.f16714a.getBoolean(a.m16149a(), false)) {
                long j2 = this.f16714a.getLong(a.m16151b(), 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j2 > AbstractC1191a.f2550a) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("event", "support");
                    hashMap2.put(Constants.KEY_MODEL, C4301k.m15694a());
                    hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                    m16122a("category_hb_change", null, hashMap2);
                    AbstractC4022b.m13347a("[HB] report support wifi digest events.");
                    this.f16714a.edit().putLong(a.m16151b(), currentTimeMillis).apply();
                }
            }
            if (m16135e()) {
                int i4 = this.f16714a.getInt(a.m16154d(), 0);
                int i5 = this.f16714a.getInt(a.m16155e(), 0);
                if (i4 > 0 || i5 > 0) {
                    long j3 = this.f16714a.getLong(a.m16153c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j3);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(C3351bh.f11599aX, valueOf);
                        jSONObject.put("c_short", String.valueOf(i4));
                        jSONObject.put("c_long", String.valueOf(i5));
                        jSONObject.put("count", String.valueOf(i4 + i5));
                        jSONObject.put(C3397d.f11950p, valueOf2);
                        jSONObject.put(C3397d.f11951q, valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        m16122a("category_hb_count", jSONObject2, hashMap3);
                        AbstractC4022b.m13347a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f16714a.edit().putInt(a.m16154d(), 0).putInt(a.m16155e(), 0).putLong(a.m16153c(), System.currentTimeMillis()).apply();
            }
            if (m16137f()) {
                String valueOf4 = String.valueOf(this.f16712a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i6 = this.f16714a.getInt(a.m16157g(), 0);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "M");
                        jSONObject3.put("ptc", i6);
                        jSONObject3.put(C3397d.f11950p, valueOf4);
                        jSONObject3.put(C3397d.f11951q, valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        m16122a("category_lc_ptc", jSONObject4, hashMap4);
                        AbstractC4022b.m13347a("[HB] report ping timeout count events of mobile network.");
                        this.f16714a.edit().putInt(a.m16157g(), 0).apply();
                    } catch (Throwable unused2) {
                        i2 = 0;
                        this.f16714a.edit().putInt(a.m16157g(), 0).apply();
                    }
                }
                i2 = 0;
                int i7 = this.f16714a.getInt(a.m16158h(), i2);
                if (i7 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, ExifInterface.LONGITUDE_WEST);
                        jSONObject5.put("ptc", i7);
                        jSONObject5.put(C3397d.f11950p, valueOf4);
                        jSONObject5.put(C3397d.f11951q, valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        m16122a("category_lc_ptc", jSONObject6, hashMap5);
                        AbstractC4022b.m13347a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f16714a.edit().putInt(a.m16158h(), 0).apply();
                }
                this.f16712a = System.currentTimeMillis();
                this.f16714a.edit().putLong(a.m16159i(), this.f16712a).apply();
            }
        }
    }

    /* renamed from: a */
    public void m16141a() {
    }

    /* renamed from: c */
    public void m16147c() {
        if (m16133d()) {
            this.f16719b = this.f16715a;
        }
    }

    /* renamed from: d */
    public void m16148d() {
        if (m16133d()) {
            m16138g();
            if (this.f16717a) {
                this.f16716a.getAndSet(0);
            }
        }
    }

    /* renamed from: c */
    private long m16128c() {
        return this.f16714a.getLong(a.m16160j(), -1L);
    }

    /* renamed from: e */
    private boolean m16135e() {
        long j2 = this.f16714a.getLong(a.m16153c(), -1L);
        if (j2 == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j2 > currentTimeMillis || currentTimeMillis - j2 >= 259200000;
    }

    /* renamed from: c */
    private void m16129c(String str) {
        if (m16125a(str)) {
            this.f16714a.edit().putInt(a.m16150a(str), 235000).apply();
            this.f16714a.edit().putLong(a.m16152b(this.f16715a), System.currentTimeMillis() + m16131d()).apply();
        }
    }

    /* renamed from: d */
    private long m16131d() {
        return C4356ah.m15923a(this.f16713a).m15929a(EnumC4244gk.ShortHeartbeatEffectivePeriodMsLong.m15014a(), 7776000000L);
    }

    /* renamed from: a */
    public synchronized void m16143a(C4093av c4093av) {
        if (m16133d()) {
            String str = null;
            if (c4093av != null) {
                if (c4093av.m13811a() == 0) {
                    String m13817b = c4093av.m13817b();
                    if (!TextUtils.isEmpty(m13817b) && !"UNKNOWN".equalsIgnoreCase(m13817b)) {
                        str = "M-" + m13817b;
                    }
                    m16126b(str);
                    this.f16711a = 0;
                } else {
                    if (c4093av.m13811a() != 1 && c4093av.m13811a() != 6) {
                        m16126b(null);
                        this.f16711a = -1;
                    }
                    m16126b("WIFI-ID-UNKNOWN");
                    this.f16711a = 1;
                }
            } else {
                m16126b(null);
                this.f16711a = -1;
            }
        }
    }

    /* renamed from: d */
    private void m16132d(String str) {
        String str2;
        String str3;
        if (m16130c() && !TextUtils.isEmpty(str)) {
            if (str.startsWith("W-")) {
                str2 = ExifInterface.LONGITUDE_WEST;
            } else if (!str.startsWith("M-")) {
                return;
            } else {
                str2 = "M";
            }
            String valueOf = String.valueOf(235000);
            String valueOf2 = String.valueOf(System.currentTimeMillis() / 1000);
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append(":::");
            sb.append(str2);
            sb.append(":::");
            sb.append(valueOf);
            sb.append(":::");
            sb.append(valueOf2);
            String string = this.f16714a.getString(a.m16156f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f16714a.edit().putString(a.m16156f(), str3).apply();
        }
    }

    /* renamed from: c */
    private boolean m16130c() {
        return m16133d() && C4356ah.m15923a(this.f16713a).m15935a(EnumC4244gk.IntelligentHeartbeatDataCollectSwitchBoolean.m15014a(), true) && EnumC4304n.China.name().equals(C4375b.m16045a(this.f16713a).m16048a());
    }

    /* renamed from: f */
    private boolean m16137f() {
        if (this.f16712a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f16712a;
        return j2 > currentTimeMillis || currentTimeMillis - j2 >= 259200000;
    }

    /* renamed from: b */
    public void m16146b() {
        if (m16133d()) {
            m16136f();
            if (this.f16717a && !TextUtils.isEmpty(this.f16715a) && this.f16715a.equals(this.f16719b)) {
                this.f16716a.getAndIncrement();
                AbstractC4022b.m13347a("[HB] ping timeout count:" + this.f16716a);
                if (m16124a()) {
                    AbstractC4022b.m13347a("[HB] change hb interval for net:" + this.f16715a);
                    m16129c(this.f16715a);
                    this.f16717a = false;
                    this.f16716a.getAndSet(0);
                    m16132d(this.f16715a);
                }
            }
        }
    }

    /* renamed from: a */
    public synchronized void m16144a(String str) {
        if (!TextUtils.isEmpty(str)) {
            m16134e();
        }
        if (m16133d() && !TextUtils.isEmpty(str)) {
            m16126b("W-" + str);
        }
    }

    /* renamed from: d */
    private boolean m16133d() {
        return this.f16723c && (this.f16721b || this.f16724d || ((m16128c() > System.currentTimeMillis() ? 1 : (m16128c() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    /* renamed from: a */
    public void m16142a(int i2) {
        this.f16714a.edit().putLong(a.m16160j(), System.currentTimeMillis() + (i2 * 1000)).apply();
    }

    /* renamed from: a */
    private boolean m16124a() {
        return this.f16716a.get() >= Math.max(C4356ah.m15923a(this.f16713a).m15927a(EnumC4244gk.IntelligentHeartbeatNATCountInt.m15014a(), 3), 3);
    }

    /* renamed from: b */
    public long m16145b() {
        return this.f16718b;
    }

    /* renamed from: b */
    private boolean m16127b() {
        if (!TextUtils.isEmpty(this.f16715a)) {
            if (this.f16715a.startsWith("M-")) {
                if (!C4356ah.m15923a(this.f16713a).m15935a(EnumC4244gk.IntelligentHeartbeatUseInMobileNetworkBoolean.m15014a(), false)) {
                    return true;
                }
            } else if (this.f16715a.equals("W-NETWORK_ID_WIFI_DEFAULT") && !m16139g()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public long m16140a() {
        int m16120a;
        long m14801b = C4213fg.m14801b();
        if (this.f16723c && !m16127b() && ((C4356ah.m15923a(this.f16713a).m15935a(EnumC4244gk.IntelligentHeartbeatSwitchBoolean.m15014a(), true) || m16128c() >= System.currentTimeMillis()) && (m16120a = m16120a()) != -1)) {
            m14801b = m16120a;
        }
        if (!TextUtils.isEmpty(this.f16715a) && !"WIFI-ID-UNKNOWN".equals(this.f16715a) && this.f16711a == 1) {
            m16123a(m14801b < 300000);
        }
        this.f16718b = m14801b;
        AbstractC4022b.m13347a("[HB] ping interval:" + m14801b);
        return m14801b;
    }

    /* renamed from: a */
    private int m16120a() {
        if (TextUtils.isEmpty(this.f16715a)) {
            return -1;
        }
        try {
            return this.f16714a.getInt(a.m16150a(this.f16715a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    /* renamed from: a */
    private boolean m16125a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    /* renamed from: a */
    private void m16123a(boolean z) {
        String m16155e;
        if (m16130c()) {
            int incrementAndGet = (z ? this.f16720b : this.f16722c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            AbstractC4022b.m13356b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                if (z) {
                    m16155e = a.m16154d();
                } else {
                    m16155e = a.m16155e();
                }
                int i2 = this.f16714a.getInt(m16155e, 0) + incrementAndGet;
                this.f16714a.edit().putInt(m16155e, i2).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i2);
                AbstractC4022b.m13347a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                if (z) {
                    this.f16720b.set(0);
                } else {
                    this.f16722c.set(0);
                }
            }
        }
    }

    /* renamed from: a */
    private void m16122a(String str, String str2, Map<String, String> map) {
        C4243gj c4243gj = new C4243gj();
        c4243gj.m15000d(str);
        c4243gj.m14996c("hb_name");
        c4243gj.m14981a("hb_channel");
        c4243gj.m14980a(1L);
        c4243gj.m14992b(str2);
        c4243gj.m14983a(false);
        c4243gj.m14991b(System.currentTimeMillis());
        c4243gj.m15008g(this.f16713a.getPackageName());
        c4243gj.m15003e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        C4393p m16204a = C4394q.m16204a(this.f16713a);
        if (m16204a != null && !TextUtils.isEmpty(m16204a.f16754a)) {
            String[] split = m16204a.f16754a.split("@");
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put(Constants.KEY_MODEL, C4301k.m15694a());
        Context context = this.f16713a;
        map.put("avc", String.valueOf(C4233g.m14925a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(BuildConfig.VERSION_CODE));
        map.put("cvc", String.valueOf(48));
        c4243gj.m14982a(map);
        C4237gd m14961a = C4237gd.m14961a(this.f16713a);
        if (m14961a != null) {
            m14961a.m14965a(c4243gj, this.f16713a.getPackageName());
        }
    }

    /* renamed from: g */
    private boolean m16139g() {
        return C4356ah.m15923a(this.f16713a).m15935a(EnumC4244gk.IntelligentHeartbeatForUnsupportWifiDigestBoolean.m15014a(), true);
    }
}
