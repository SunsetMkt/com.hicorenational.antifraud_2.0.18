package com.xiaomi.push.service;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.taobao.accs.common.Constants;
import com.umeng.analytics.pro.bh;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.fg;
import com.xiaomi.push.gd;
import com.xiaomi.push.gj;
import com.xiaomi.push.gk;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

/* loaded from: classes2.dex */
public class m {

    /* renamed from: a, reason: collision with root package name */
    @SuppressLint({"StaticFieldLeak"})
    private static volatile m f13425a;

    /* renamed from: a, reason: collision with other field name */
    private long f1045a;

    /* renamed from: a, reason: collision with other field name */
    private final Context f1046a;

    /* renamed from: a, reason: collision with other field name */
    private final SharedPreferences f1047a;

    /* renamed from: b, reason: collision with other field name */
    private final boolean f1053b;

    /* renamed from: c, reason: collision with other field name */
    private final boolean f1054c;

    /* renamed from: a, reason: collision with other field name */
    private final AtomicInteger f1049a = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    private String f1048a = null;

    /* renamed from: a, reason: collision with other field name */
    private volatile boolean f1050a = false;

    /* renamed from: b, reason: collision with other field name */
    private String f1051b = null;

    /* renamed from: b, reason: collision with other field name */
    private final AtomicInteger f1052b = new AtomicInteger(0);

    /* renamed from: c, reason: collision with root package name */
    private final AtomicInteger f13427c = new AtomicInteger(0);

    /* renamed from: a, reason: collision with other field name */
    private int f1044a = -1;

    /* renamed from: b, reason: collision with root package name */
    private long f13426b = -1;

    /* renamed from: d, reason: collision with root package name */
    private final boolean f13428d = m722g();

    private static class a {
        public static String a() {
            return "support_wifi_digest";
        }

        public static String a(String str) {
            return String.format("HB_%s", str);
        }

        public static String b() {
            return "record_support_wifi_digest_reported_time";
        }

        public static String b(String str) {
            return String.format("HB_dead_time_%s", str);
        }

        public static String c() {
            return "record_hb_count_start";
        }

        public static String d() {
            return "record_short_hb_count";
        }

        public static String e() {
            return "record_long_hb_count";
        }

        public static String f() {
            return "record_hb_change";
        }

        public static String g() {
            return "record_mobile_ptc";
        }

        public static String h() {
            return "record_wifi_ptc";
        }

        public static String i() {
            return "record_ptc_start";
        }

        public static String j() {
            return "keep_short_hb_effective_time";
        }
    }

    private m(Context context) {
        this.f1046a = context;
        this.f1054c = com.xiaomi.push.j.m627a(context);
        this.f1053b = ah.a(this.f1046a).a(gk.IntelligentHeartbeatSwitchBoolean.a(), true);
        this.f1047a = this.f1046a.getSharedPreferences("hb_record", 0);
        long currentTimeMillis = System.currentTimeMillis();
        if (this.f1047a.getLong(a.c(), -1L) == -1) {
            this.f1047a.edit().putLong(a.c(), currentTimeMillis).apply();
        }
        this.f1045a = this.f1047a.getLong(a.i(), -1L);
        if (this.f1045a == -1) {
            this.f1045a = currentTimeMillis;
            this.f1047a.edit().putLong(a.i(), currentTimeMillis).apply();
        }
    }

    public static m a(Context context) {
        if (f13425a == null) {
            synchronized (m.class) {
                if (f13425a == null) {
                    f13425a = new m(context);
                }
            }
        }
        return f13425a;
    }

    private void b(String str) {
        if ("WIFI-ID-UNKNOWN".equals(str)) {
            String str2 = this.f1048a;
            if (str2 == null || !str2.startsWith("W-")) {
                if (this.f13428d) {
                    this.f1048a = "W-NETWORK_ID_WIFI_DEFAULT";
                } else {
                    this.f1048a = null;
                }
            }
        } else {
            this.f1048a = str;
        }
        int i2 = this.f1047a.getInt(a.a(this.f1048a), -1);
        long j2 = this.f1047a.getLong(a.b(this.f1048a), -1L);
        long currentTimeMillis = System.currentTimeMillis();
        if (i2 != -1) {
            if (j2 == -1) {
                this.f1047a.edit().putLong(a.b(this.f1048a), currentTimeMillis + d()).apply();
            } else if (currentTimeMillis > j2) {
                this.f1047a.edit().remove(a.a(this.f1048a)).remove(a.b(this.f1048a)).apply();
            }
        }
        this.f1049a.getAndSet(0);
        if (TextUtils.isEmpty(this.f1048a) || a() != -1) {
            this.f1050a = false;
        } else {
            this.f1050a = true;
        }
        com.xiaomi.channel.commonutils.logger.b.m50a(String.format("[HB] network changed, netid:%s, %s", this.f1048a, Boolean.valueOf(this.f1050a)));
    }

    private void e() {
        if (this.f1047a.getBoolean(a.a(), false)) {
            return;
        }
        this.f1047a.edit().putBoolean(a.a(), true).apply();
    }

    private void f() {
        int i2 = this.f1044a;
        String h2 = i2 != 0 ? i2 != 1 ? null : a.h() : a.g();
        if (TextUtils.isEmpty(h2)) {
            return;
        }
        if (this.f1047a.getLong(a.i(), -1L) == -1) {
            this.f1045a = System.currentTimeMillis();
            this.f1047a.edit().putLong(a.i(), this.f1045a).apply();
        }
        this.f1047a.edit().putInt(h2, this.f1047a.getInt(h2, 0) + 1).apply();
    }

    private void g() {
        int i2;
        String[] split;
        String[] split2;
        if (m718c()) {
            String string = this.f1047a.getString(a.f(), null);
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
                        hashMap.put(Constants.KEY_MODEL, com.xiaomi.push.k.a());
                        hashMap.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, str2);
                        hashMap.put("net_name", str);
                        hashMap.put(bh.aX, str3);
                        hashMap.put("timestamp", str4);
                        a("category_hb_change", null, hashMap);
                        com.xiaomi.channel.commonutils.logger.b.m50a("[HB] report hb changed events.");
                    }
                    i3++;
                    c2 = 1;
                    c3 = 0;
                }
                this.f1047a.edit().remove(a.f()).apply();
            }
            if (this.f1047a.getBoolean(a.a(), false)) {
                long j2 = this.f1047a.getLong(a.b(), 0L);
                long currentTimeMillis = System.currentTimeMillis();
                if (currentTimeMillis - j2 > c.c.a.b.a.a.f3094a) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("event", "support");
                    hashMap2.put(Constants.KEY_MODEL, com.xiaomi.push.k.a());
                    hashMap2.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
                    a("category_hb_change", null, hashMap2);
                    com.xiaomi.channel.commonutils.logger.b.m50a("[HB] report support wifi digest events.");
                    this.f1047a.edit().putLong(a.b(), currentTimeMillis).apply();
                }
            }
            if (m720e()) {
                int i4 = this.f1047a.getInt(a.d(), 0);
                int i5 = this.f1047a.getInt(a.e(), 0);
                if (i4 > 0 || i5 > 0) {
                    long j3 = this.f1047a.getLong(a.c(), -1L);
                    String valueOf = String.valueOf(235000);
                    String valueOf2 = String.valueOf(j3);
                    String valueOf3 = String.valueOf(System.currentTimeMillis());
                    try {
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put(bh.aX, valueOf);
                        jSONObject.put("c_short", String.valueOf(i4));
                        jSONObject.put("c_long", String.valueOf(i5));
                        jSONObject.put("count", String.valueOf(i4 + i5));
                        jSONObject.put(com.umeng.analytics.pro.d.p, valueOf2);
                        jSONObject.put(com.umeng.analytics.pro.d.q, valueOf3);
                        String jSONObject2 = jSONObject.toString();
                        HashMap hashMap3 = new HashMap();
                        hashMap3.put("event", "long_and_short_hb_count");
                        a("category_hb_count", jSONObject2, hashMap3);
                        com.xiaomi.channel.commonutils.logger.b.m50a("[HB] report short/long hb count events.");
                    } catch (Throwable unused) {
                    }
                }
                this.f1047a.edit().putInt(a.d(), 0).putInt(a.e(), 0).putLong(a.c(), System.currentTimeMillis()).apply();
            }
            if (m721f()) {
                String valueOf4 = String.valueOf(this.f1045a);
                String valueOf5 = String.valueOf(System.currentTimeMillis());
                int i6 = this.f1047a.getInt(a.g(), 0);
                if (i6 > 0) {
                    try {
                        JSONObject jSONObject3 = new JSONObject();
                        jSONObject3.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, "M");
                        jSONObject3.put("ptc", i6);
                        jSONObject3.put(com.umeng.analytics.pro.d.p, valueOf4);
                        jSONObject3.put(com.umeng.analytics.pro.d.q, valueOf5);
                        String jSONObject4 = jSONObject3.toString();
                        HashMap hashMap4 = new HashMap();
                        hashMap4.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject4, hashMap4);
                        com.xiaomi.channel.commonutils.logger.b.m50a("[HB] report ping timeout count events of mobile network.");
                        this.f1047a.edit().putInt(a.g(), 0).apply();
                    } catch (Throwable unused2) {
                        i2 = 0;
                        this.f1047a.edit().putInt(a.g(), 0).apply();
                    }
                }
                i2 = 0;
                int i7 = this.f1047a.getInt(a.h(), i2);
                if (i7 > 0) {
                    try {
                        JSONObject jSONObject5 = new JSONObject();
                        jSONObject5.put(HiAnalyticsConstant.BI_KEY_NET_TYPE, ExifInterface.LONGITUDE_WEST);
                        jSONObject5.put("ptc", i7);
                        jSONObject5.put(com.umeng.analytics.pro.d.p, valueOf4);
                        jSONObject5.put(com.umeng.analytics.pro.d.q, valueOf5);
                        String jSONObject6 = jSONObject5.toString();
                        HashMap hashMap5 = new HashMap();
                        hashMap5.put("event", "ptc_event");
                        a("category_lc_ptc", jSONObject6, hashMap5);
                        com.xiaomi.channel.commonutils.logger.b.m50a("[HB] report ping timeout count events of wifi network.");
                    } catch (Throwable unused3) {
                    }
                    this.f1047a.edit().putInt(a.h(), 0).apply();
                }
                this.f1045a = System.currentTimeMillis();
                this.f1047a.edit().putLong(a.i(), this.f1045a).apply();
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public void m724a() {
    }

    /* renamed from: c, reason: collision with other method in class */
    public void m728c() {
        if (m719d()) {
            this.f1051b = this.f1048a;
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    public void m729d() {
        if (m719d()) {
            g();
            if (this.f1050a) {
                this.f1049a.getAndSet(0);
            }
        }
    }

    private long c() {
        return this.f1047a.getLong(a.j(), -1L);
    }

    /* renamed from: e, reason: collision with other method in class */
    private boolean m720e() {
        long j2 = this.f1047a.getLong(a.c(), -1L);
        if (j2 == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return j2 > currentTimeMillis || currentTimeMillis - j2 >= 259200000;
    }

    private void c(String str) {
        if (a(str)) {
            this.f1047a.edit().putInt(a.a(str), 235000).apply();
            this.f1047a.edit().putLong(a.b(this.f1048a), System.currentTimeMillis() + d()).apply();
        }
    }

    private long d() {
        return ah.a(this.f1046a).a(gk.ShortHeartbeatEffectivePeriodMsLong.a(), 7776000000L);
    }

    public synchronized void a(com.xiaomi.push.av avVar) {
        if (m719d()) {
            String str = null;
            if (avVar != null) {
                if (avVar.a() == 0) {
                    String m156b = avVar.m156b();
                    if (!TextUtils.isEmpty(m156b) && !"UNKNOWN".equalsIgnoreCase(m156b)) {
                        str = "M-" + m156b;
                    }
                    b(str);
                    this.f1044a = 0;
                } else {
                    if (avVar.a() != 1 && avVar.a() != 6) {
                        b(null);
                        this.f1044a = -1;
                    }
                    b("WIFI-ID-UNKNOWN");
                    this.f1044a = 1;
                }
            } else {
                b(null);
                this.f1044a = -1;
            }
        }
    }

    private void d(String str) {
        String str2;
        String str3;
        if (m718c() && !TextUtils.isEmpty(str)) {
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
            String string = this.f1047a.getString(a.f(), null);
            if (TextUtils.isEmpty(string)) {
                str3 = sb.toString();
            } else {
                str3 = string + "###" + sb.toString();
            }
            this.f1047a.edit().putString(a.f(), str3).apply();
        }
    }

    /* renamed from: c, reason: collision with other method in class */
    private boolean m718c() {
        return m719d() && ah.a(this.f1046a).a(gk.IntelligentHeartbeatDataCollectSwitchBoolean.a(), true) && com.xiaomi.push.n.China.name().equals(b.a(this.f1046a).a());
    }

    /* renamed from: f, reason: collision with other method in class */
    private boolean m721f() {
        if (this.f1045a == -1) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        long j2 = this.f1045a;
        return j2 > currentTimeMillis || currentTimeMillis - j2 >= 259200000;
    }

    /* renamed from: b, reason: collision with other method in class */
    public void m727b() {
        if (m719d()) {
            f();
            if (this.f1050a && !TextUtils.isEmpty(this.f1048a) && this.f1048a.equals(this.f1051b)) {
                this.f1049a.getAndIncrement();
                com.xiaomi.channel.commonutils.logger.b.m50a("[HB] ping timeout count:" + this.f1049a);
                if (m717a()) {
                    com.xiaomi.channel.commonutils.logger.b.m50a("[HB] change hb interval for net:" + this.f1048a);
                    c(this.f1048a);
                    this.f1050a = false;
                    this.f1049a.getAndSet(0);
                    d(this.f1048a);
                }
            }
        }
    }

    /* renamed from: a, reason: collision with other method in class */
    public synchronized void m725a(String str) {
        if (!TextUtils.isEmpty(str)) {
            e();
        }
        if (m719d() && !TextUtils.isEmpty(str)) {
            b("W-" + str);
        }
    }

    /* renamed from: d, reason: collision with other method in class */
    private boolean m719d() {
        return this.f1054c && (this.f1053b || this.f13428d || ((c() > System.currentTimeMillis() ? 1 : (c() == System.currentTimeMillis() ? 0 : -1)) >= 0));
    }

    public void a(int i2) {
        this.f1047a.edit().putLong(a.j(), System.currentTimeMillis() + (i2 * 1000)).apply();
    }

    /* renamed from: a, reason: collision with other method in class */
    private boolean m717a() {
        return this.f1049a.get() >= Math.max(ah.a(this.f1046a).a(gk.IntelligentHeartbeatNATCountInt.a(), 3), 3);
    }

    /* renamed from: b, reason: collision with other method in class */
    public long m726b() {
        return this.f13426b;
    }

    private boolean b() {
        if (!TextUtils.isEmpty(this.f1048a)) {
            if (this.f1048a.startsWith("M-")) {
                if (!ah.a(this.f1046a).a(gk.IntelligentHeartbeatUseInMobileNetworkBoolean.a(), false)) {
                    return true;
                }
            } else if (this.f1048a.equals("W-NETWORK_ID_WIFI_DEFAULT") && !m722g()) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a, reason: collision with other method in class */
    public long m723a() {
        int a2;
        long b2 = fg.b();
        if (this.f1054c && !b() && ((ah.a(this.f1046a).a(gk.IntelligentHeartbeatSwitchBoolean.a(), true) || c() >= System.currentTimeMillis()) && (a2 = a()) != -1)) {
            b2 = a2;
        }
        if (!TextUtils.isEmpty(this.f1048a) && !"WIFI-ID-UNKNOWN".equals(this.f1048a) && this.f1044a == 1) {
            a(b2 < 300000);
        }
        this.f13426b = b2;
        com.xiaomi.channel.commonutils.logger.b.m50a("[HB] ping interval:" + b2);
        return b2;
    }

    private int a() {
        if (TextUtils.isEmpty(this.f1048a)) {
            return -1;
        }
        try {
            return this.f1047a.getInt(a.a(this.f1048a), -1);
        } catch (Throwable unused) {
            return -1;
        }
    }

    private boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("W-") || str.startsWith("M-");
    }

    private void a(boolean z) {
        String e2;
        if (m718c()) {
            int incrementAndGet = (z ? this.f1052b : this.f13427c).incrementAndGet();
            Object[] objArr = new Object[2];
            objArr[0] = z ? "short" : "long";
            objArr[1] = Integer.valueOf(incrementAndGet);
            com.xiaomi.channel.commonutils.logger.b.b(String.format("[HB] %s ping interval count: %s", objArr));
            if (incrementAndGet >= 5) {
                if (z) {
                    e2 = a.d();
                } else {
                    e2 = a.e();
                }
                int i2 = this.f1047a.getInt(e2, 0) + incrementAndGet;
                this.f1047a.edit().putInt(e2, i2).apply();
                Object[] objArr2 = new Object[2];
                objArr2[0] = z ? "short" : "long";
                objArr2[1] = Integer.valueOf(i2);
                com.xiaomi.channel.commonutils.logger.b.m50a(String.format("[HB] accumulate %s hb count(%s) and write to file. ", objArr2));
                if (z) {
                    this.f1052b.set(0);
                } else {
                    this.f13427c.set(0);
                }
            }
        }
    }

    private void a(String str, String str2, Map<String, String> map) {
        gj gjVar = new gj();
        gjVar.d(str);
        gjVar.c("hb_name");
        gjVar.a("hb_channel");
        gjVar.a(1L);
        gjVar.b(str2);
        gjVar.a(false);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(this.f1046a.getPackageName());
        gjVar.e("com.xiaomi.xmsf");
        if (map == null) {
            map = new HashMap<>();
        }
        String str3 = null;
        p m741a = q.m741a(this.f1046a);
        if (m741a != null && !TextUtils.isEmpty(m741a.f1067a)) {
            String[] split = m741a.f1067a.split("@");
            if (split.length > 0) {
                str3 = split[0];
            }
        }
        map.put("uuid", str3);
        map.put(Constants.KEY_MODEL, com.xiaomi.push.k.a());
        Context context = this.f1046a;
        map.put("avc", String.valueOf(com.xiaomi.push.g.a(context, context.getPackageName())));
        map.put("pvc", String.valueOf(BuildConfig.VERSION_CODE));
        map.put("cvc", String.valueOf(48));
        gjVar.a(map);
        gd a2 = gd.a(this.f1046a);
        if (a2 != null) {
            a2.a(gjVar, this.f1046a.getPackageName());
        }
    }

    /* renamed from: g, reason: collision with other method in class */
    private boolean m722g() {
        return ah.a(this.f1046a).a(gk.IntelligentHeartbeatForUnsupportWifiDigestBoolean.a(), true);
    }
}
