package com.tencent.bugly.crashreport.common.info;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.bugly.C3072b;
import com.tencent.bugly.crashreport.InterfaceC3108a;
import com.tencent.bugly.proguard.C3151an;
import com.tencent.bugly.proguard.C3154aq;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import p000a.p001a.p014u.C0052a;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.crashreport.common.info.a */
/* loaded from: classes2.dex */
public class C3113a {

    /* renamed from: ap */
    private static C3113a f10133ap;

    /* renamed from: H */
    public boolean f10141H;

    /* renamed from: P */
    public SharedPreferences f10149P;

    /* renamed from: Q */
    private final Context f10150Q;

    /* renamed from: R */
    private String f10151R;

    /* renamed from: S */
    private String f10152S;

    /* renamed from: b */
    public final String f10194b;

    /* renamed from: d */
    public String f10196d;

    /* renamed from: e */
    public final String f10197e;

    /* renamed from: f */
    public String f10198f;

    /* renamed from: g */
    public String f10199g;

    /* renamed from: l */
    public final String f10204l;

    /* renamed from: m */
    public final String f10205m;

    /* renamed from: n */
    public final String f10206n;

    /* renamed from: q */
    public int f10209q;

    /* renamed from: r */
    public String f10210r;

    /* renamed from: h */
    public boolean f10200h = true;

    /* renamed from: i */
    public final String f10201i = "com.tencent.bugly";

    /* renamed from: j */
    public String f10202j = "3.1.7(1.4.5)";

    /* renamed from: k */
    public final String f10203k = "";

    /* renamed from: T */
    private String f10153T = "unknown";

    /* renamed from: U */
    private String f10154U = "unknown";

    /* renamed from: V */
    private String f10155V = "";

    /* renamed from: o */
    public long f10207o = 0;

    /* renamed from: W */
    private String f10156W = null;

    /* renamed from: X */
    private String f10157X = null;

    /* renamed from: Y */
    private String f10158Y = null;

    /* renamed from: Z */
    private String f10159Z = null;

    /* renamed from: aa */
    private long f10169aa = -1;

    /* renamed from: ab */
    private long f10170ab = -1;

    /* renamed from: ac */
    private long f10171ac = -1;

    /* renamed from: ad */
    private String f10172ad = null;

    /* renamed from: ae */
    private String f10173ae = null;

    /* renamed from: af */
    private Map<String, PlugInBean> f10174af = null;

    /* renamed from: ag */
    private boolean f10175ag = true;

    /* renamed from: ah */
    private String f10176ah = null;

    /* renamed from: p */
    public String f10208p = null;

    /* renamed from: ai */
    private String f10177ai = null;

    /* renamed from: s */
    public String f10211s = null;

    /* renamed from: aj */
    private Boolean f10178aj = null;

    /* renamed from: ak */
    private String f10179ak = null;

    /* renamed from: al */
    private String f10180al = null;

    /* renamed from: am */
    private String f10181am = null;

    /* renamed from: t */
    public String f10212t = null;

    /* renamed from: u */
    public String f10213u = null;

    /* renamed from: an */
    private Map<String, PlugInBean> f10182an = null;

    /* renamed from: ao */
    private Map<String, PlugInBean> f10183ao = null;

    /* renamed from: v */
    public List<String> f10214v = null;

    /* renamed from: aq */
    private int f10184aq = -1;

    /* renamed from: ar */
    private int f10185ar = -1;

    /* renamed from: as */
    private Map<String, String> f10186as = new HashMap();

    /* renamed from: at */
    private Map<String, String> f10187at = new HashMap();

    /* renamed from: au */
    private Map<String, String> f10188au = new HashMap();

    /* renamed from: av */
    private boolean f10189av = true;

    /* renamed from: w */
    public String f10215w = "unknown";

    /* renamed from: x */
    public long f10216x = 0;

    /* renamed from: y */
    public long f10217y = 0;

    /* renamed from: z */
    public long f10218z = 0;

    /* renamed from: A */
    public long f10134A = 0;

    /* renamed from: B */
    public boolean f10135B = false;

    /* renamed from: C */
    public String f10136C = null;

    /* renamed from: D */
    public String f10137D = null;

    /* renamed from: E */
    public String f10138E = null;

    /* renamed from: F */
    public String f10139F = "";

    /* renamed from: G */
    public boolean f10140G = false;

    /* renamed from: I */
    public Boolean f10142I = null;

    /* renamed from: J */
    public Boolean f10143J = null;

    /* renamed from: K */
    public HashMap<String, String> f10144K = new HashMap<>();

    /* renamed from: aw */
    private String f10190aw = null;

    /* renamed from: ax */
    private String f10191ax = null;

    /* renamed from: ay */
    private String f10192ay = null;

    /* renamed from: az */
    private String f10193az = null;

    /* renamed from: aA */
    private String f10161aA = null;

    /* renamed from: L */
    public boolean f10145L = true;

    /* renamed from: M */
    public List<String> f10146M = new ArrayList();

    /* renamed from: N */
    public boolean f10147N = false;

    /* renamed from: O */
    public InterfaceC3108a f10148O = null;

    /* renamed from: aB */
    private final Object f10162aB = new Object();

    /* renamed from: aC */
    private final Object f10163aC = new Object();

    /* renamed from: aD */
    private final Object f10164aD = new Object();

    /* renamed from: aE */
    private final Object f10165aE = new Object();

    /* renamed from: aF */
    private final Object f10166aF = new Object();

    /* renamed from: aG */
    private final Object f10167aG = new Object();

    /* renamed from: aH */
    private final Object f10168aH = new Object();

    /* renamed from: a */
    public final long f10160a = System.currentTimeMillis();

    /* renamed from: c */
    public final byte f10195c = 1;

    private C3113a(Context context) {
        this.f10210r = null;
        this.f10141H = false;
        this.f10150Q = C3154aq.m9946a(context);
        m9533b(context);
        this.f10196d = AppInfo.m9516a(context);
        this.f10197e = AppInfo.m9517a(context, Process.myPid());
        this.f10204l = C3114b.m9620m();
        this.f10205m = C3114b.m9594a();
        this.f10210r = AppInfo.m9522c(context);
        this.f10206n = "Android " + C3114b.m9597b() + ",level " + C3114b.m9599c();
        StringBuilder sb = new StringBuilder();
        sb.append(this.f10205m);
        sb.append(";");
        sb.append(this.f10206n);
        this.f10194b = sb.toString();
        m9534c(context);
        try {
            if (!context.getDatabasePath("bugly_db_").exists()) {
                this.f10141H = true;
                C3151an.m9921c("App is first time to be installed on the device.", new Object[0]);
            }
        } catch (Throwable th) {
            if (C3072b.f9834c) {
                th.printStackTrace();
            }
        }
        this.f10149P = C3154aq.m9947a("BUGLY_COMMON_VALUES", context);
        C3151an.m9921c("com info create end", new Object[0]);
    }

    /* renamed from: b */
    private void m9533b(Context context) {
        PackageInfo m9521b = AppInfo.m9521b(context);
        if (m9521b == null) {
            return;
        }
        try {
            this.f10208p = m9521b.versionName;
            this.f10136C = this.f10208p;
            this.f10137D = Integer.toString(m9521b.versionCode);
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: c */
    private void m9534c(Context context) {
        Map<String, String> m9523d = AppInfo.m9523d(context);
        if (m9523d == null) {
            return;
        }
        try {
            this.f10214v = AppInfo.m9519a(m9523d);
            String str = m9523d.get("BUGLY_APPID");
            if (str != null) {
                this.f10177ai = str;
                m9566c("APP_ID", this.f10177ai);
            }
            String str2 = m9523d.get("BUGLY_APP_VERSION");
            if (str2 != null) {
                this.f10208p = str2;
            }
            String str3 = m9523d.get("BUGLY_APP_CHANNEL");
            if (str3 != null) {
                this.f10211s = str3;
            }
            String str4 = m9523d.get("BUGLY_ENABLE_DEBUG");
            if (str4 != null) {
                this.f10135B = str4.equalsIgnoreCase(C0052a.f158j);
            }
            String str5 = m9523d.get("com.tencent.rdm.uuid");
            if (str5 != null) {
                this.f10138E = str5;
            }
            String str6 = m9523d.get("BUGLY_APP_BUILD_NO");
            if (!TextUtils.isEmpty(str6)) {
                this.f10209q = Integer.parseInt(str6);
            }
            String str7 = m9523d.get("BUGLY_AREA");
            if (str7 != null) {
                this.f10139F = str7;
            }
        } catch (Throwable th) {
            if (C3151an.m9916a(th)) {
                return;
            }
            th.printStackTrace();
        }
    }

    /* renamed from: A */
    public String m9535A() {
        if (this.f10181am == null) {
            this.f10181am = "" + C3114b.m9601d();
            C3151an.m9915a("Hardware serial number: %s", this.f10181am);
        }
        return this.f10181am;
    }

    /* renamed from: B */
    public Map<String, String> m9536B() {
        synchronized (this.f10164aD) {
            if (this.f10186as.size() <= 0) {
                return null;
            }
            return new HashMap(this.f10186as);
        }
    }

    /* renamed from: C */
    public void m9537C() {
        synchronized (this.f10164aD) {
            this.f10186as.clear();
        }
    }

    /* renamed from: D */
    public int m9538D() {
        int size;
        synchronized (this.f10164aD) {
            size = this.f10186as.size();
        }
        return size;
    }

    /* renamed from: E */
    public Set<String> m9539E() {
        Set<String> keySet;
        synchronized (this.f10164aD) {
            keySet = this.f10186as.keySet();
        }
        return keySet;
    }

    /* renamed from: F */
    public Map<String, String> m9540F() {
        synchronized (this.f10168aH) {
            if (this.f10187at.size() <= 0) {
                return null;
            }
            return new HashMap(this.f10187at);
        }
    }

    /* renamed from: G */
    public Map<String, String> m9541G() {
        synchronized (this.f10165aE) {
            if (this.f10188au.size() <= 0) {
                return null;
            }
            return new HashMap(this.f10188au);
        }
    }

    /* renamed from: H */
    public int m9542H() {
        int i2;
        synchronized (this.f10166aF) {
            i2 = this.f10184aq;
        }
        return i2;
    }

    /* renamed from: I */
    public int m9543I() {
        return this.f10185ar;
    }

    /* renamed from: J */
    public synchronized Map<String, PlugInBean> m9544J() {
        Map<String, PlugInBean> map;
        map = this.f10182an;
        if (this.f10183ao != null) {
            map.putAll(this.f10183ao);
        }
        return map;
    }

    /* renamed from: K */
    public int m9545K() {
        return C3114b.m9599c();
    }

    /* renamed from: L */
    public String m9546L() {
        if (this.f10190aw == null) {
            this.f10190aw = C3114b.m9623o();
        }
        return this.f10190aw;
    }

    /* renamed from: M */
    public String m9547M() {
        if (this.f10191ax == null) {
            this.f10191ax = C3114b.m9612i(this.f10150Q);
        }
        return this.f10191ax;
    }

    /* renamed from: N */
    public String m9548N() {
        if (this.f10192ay == null) {
            this.f10192ay = C3114b.m9614j(this.f10150Q);
        }
        return this.f10192ay;
    }

    /* renamed from: O */
    public String m9549O() {
        return C3114b.m9616k(this.f10150Q);
    }

    /* renamed from: P */
    public String m9550P() {
        if (this.f10193az == null) {
            this.f10193az = C3114b.m9618l(this.f10150Q);
        }
        return this.f10193az;
    }

    /* renamed from: Q */
    public long m9551Q() {
        return C3114b.m9619m(this.f10150Q);
    }

    /* renamed from: R */
    public boolean m9552R() {
        if (this.f10142I == null) {
            this.f10142I = Boolean.valueOf(C3114b.m9622n(this.f10150Q));
            C3151an.m9915a("Is it a virtual machine? " + this.f10142I, new Object[0]);
        }
        return this.f10142I.booleanValue();
    }

    /* renamed from: S */
    public boolean m9553S() {
        if (this.f10143J == null) {
            this.f10143J = Boolean.valueOf(C3114b.m9626p(this.f10150Q));
            C3151an.m9915a("Does it has hook frame? " + this.f10143J, new Object[0]);
        }
        return this.f10143J.booleanValue();
    }

    /* renamed from: T */
    public String m9554T() {
        if (this.f10199g == null) {
            this.f10199g = AppInfo.m9526g(this.f10150Q);
            C3151an.m9915a("Beacon channel " + this.f10199g, new Object[0]);
        }
        return this.f10199g;
    }

    /* renamed from: a */
    public boolean m9559a() {
        return this.f10189av;
    }

    /* renamed from: d */
    public void m9567d() {
        synchronized (this.f10162aB) {
            this.f10151R = UUID.randomUUID().toString();
        }
    }

    /* renamed from: e */
    public String m9569e() {
        String str;
        synchronized (this.f10162aB) {
            if (this.f10151R == null) {
                m9567d();
            }
            str = this.f10151R;
        }
        return str;
    }

    /* renamed from: f */
    public String m9571f() {
        return !C3154aq.m9970a(this.f10198f) ? this.f10198f : this.f10177ai;
    }

    /* renamed from: g */
    public String m9573g() {
        String str;
        synchronized (this.f10167aG) {
            str = this.f10153T;
        }
        return str;
    }

    /* renamed from: h */
    public String m9575h() {
        String str = this.f10152S;
        if (str != null) {
            return str;
        }
        this.f10152S = m9581n();
        return this.f10152S;
    }

    /* renamed from: i */
    public synchronized String m9576i() {
        return this.f10154U;
    }

    /* renamed from: j */
    public synchronized String m9577j() {
        return this.f10155V;
    }

    /* renamed from: k */
    public String m9578k() {
        if (!this.f10175ag) {
            return "";
        }
        if (this.f10156W == null) {
            this.f10156W = C3114b.m9595a(this.f10150Q);
        }
        return this.f10156W;
    }

    /* renamed from: l */
    public String m9579l() {
        if (!this.f10175ag) {
            return "";
        }
        String str = this.f10157X;
        if (str == null || !str.contains(Constants.COLON_SEPARATOR)) {
            this.f10157X = C3114b.m9602d(this.f10150Q);
        }
        return this.f10157X;
    }

    /* renamed from: m */
    public String m9580m() {
        if (!this.f10175ag) {
            return "";
        }
        if (this.f10158Y == null) {
            this.f10158Y = C3114b.m9598b(this.f10150Q);
        }
        return this.f10158Y;
    }

    /* renamed from: n */
    public String m9581n() {
        if (!this.f10175ag) {
            return "";
        }
        if (this.f10159Z == null) {
            this.f10159Z = C3114b.m9600c(this.f10150Q);
        }
        return this.f10159Z;
    }

    /* renamed from: o */
    public long m9582o() {
        if (this.f10169aa <= 0) {
            this.f10169aa = C3114b.m9605f();
        }
        return this.f10169aa;
    }

    /* renamed from: p */
    public long m9583p() {
        if (this.f10170ab <= 0) {
            this.f10170ab = C3114b.m9609h();
        }
        return this.f10170ab;
    }

    /* renamed from: q */
    public long m9584q() {
        if (this.f10171ac <= 0) {
            this.f10171ac = C3114b.m9613j();
        }
        return this.f10171ac;
    }

    /* renamed from: r */
    public String m9585r() {
        if (this.f10172ad == null) {
            this.f10172ad = C3114b.m9596a(this.f10150Q, true);
        }
        return this.f10172ad;
    }

    /* renamed from: s */
    public String m9586s() {
        if (this.f10173ae == null) {
            this.f10173ae = C3114b.m9610h(this.f10150Q);
        }
        return this.f10173ae;
    }

    /* renamed from: t */
    public String m9587t() {
        try {
            Map<String, ?> all = this.f10150Q.getSharedPreferences("BuglySdkInfos", 0).getAll();
            if (!all.isEmpty()) {
                synchronized (this.f10163aC) {
                    for (Map.Entry<String, ?> entry : all.entrySet()) {
                        try {
                            this.f10144K.put(entry.getKey(), entry.getValue().toString());
                        } catch (Throwable th) {
                            C3151an.m9916a(th);
                        }
                    }
                }
            }
        } catch (Throwable th2) {
            C3151an.m9916a(th2);
        }
        if (this.f10144K.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> entry2 : this.f10144K.entrySet()) {
            sb.append("[");
            sb.append(entry2.getKey());
            sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb.append(entry2.getValue());
            sb.append("] ");
        }
        m9566c("SDK_INFO", sb.toString());
        return sb.toString();
    }

    /* renamed from: u */
    public String m9588u() {
        if (this.f10161aA == null) {
            this.f10161aA = AppInfo.m9524e(this.f10150Q);
        }
        return this.f10161aA;
    }

    /* renamed from: v */
    public synchronized Map<String, PlugInBean> m9589v() {
        if (this.f10174af != null && this.f10174af.size() > 0) {
            HashMap hashMap = new HashMap(this.f10174af.size());
            hashMap.putAll(this.f10174af);
            return hashMap;
        }
        return null;
    }

    /* renamed from: w */
    public String m9590w() {
        if (this.f10176ah == null) {
            this.f10176ah = C3114b.m9617l();
        }
        return this.f10176ah;
    }

    /* renamed from: x */
    public Boolean m9591x() {
        if (this.f10178aj == null) {
            this.f10178aj = Boolean.valueOf(C3114b.m9621n());
        }
        return this.f10178aj;
    }

    /* renamed from: y */
    public String m9592y() {
        if (this.f10179ak == null) {
            this.f10179ak = "" + C3114b.m9608g(this.f10150Q);
            C3151an.m9915a("ROM ID: %s", this.f10179ak);
        }
        return this.f10179ak;
    }

    /* renamed from: z */
    public String m9593z() {
        if (this.f10180al == null) {
            this.f10180al = "" + C3114b.m9603e(this.f10150Q);
            C3151an.m9915a("SIM serial number: %s", this.f10180al);
        }
        return this.f10180al;
    }

    /* renamed from: a */
    public void m9558a(boolean z) {
        this.f10189av = z;
        InterfaceC3108a interfaceC3108a = this.f10148O;
        if (interfaceC3108a != null) {
            interfaceC3108a.setNativeIsAppForeground(z);
        }
    }

    /* renamed from: d */
    public synchronized void m9568d(String str) {
        this.f10154U = "" + str;
    }

    /* renamed from: f */
    public String m9572f(String str) {
        String remove;
        if (C3154aq.m9970a(str)) {
            C3151an.m9922d("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.f10164aD) {
            remove = this.f10186as.remove(str);
        }
        return remove;
    }

    /* renamed from: g */
    public String m9574g(String str) {
        String str2;
        if (C3154aq.m9970a(str)) {
            C3151an.m9922d("key should not be empty %s", "" + str);
            return null;
        }
        synchronized (this.f10164aD) {
            str2 = this.f10186as.get(str);
        }
        return str2;
    }

    /* renamed from: a */
    public static synchronized C3113a m9531a(Context context) {
        C3113a c3113a;
        synchronized (C3113a.class) {
            if (f10133ap == null) {
                f10133ap = new C3113a(context);
            }
            c3113a = f10133ap;
        }
        return c3113a;
    }

    /* renamed from: e */
    public synchronized void m9570e(String str) {
        this.f10155V = "" + str;
    }

    /* renamed from: b */
    public static synchronized C3113a m9532b() {
        C3113a c3113a;
        synchronized (C3113a.class) {
            c3113a = f10133ap;
        }
        return c3113a;
    }

    /* renamed from: a */
    public void m9556a(String str) {
        this.f10177ai = str;
        m9566c("APP_ID", str);
    }

    /* renamed from: b */
    public void m9561b(String str) {
        synchronized (this.f10167aG) {
            if (str == null) {
                str = "10000";
            }
            this.f10153T = "" + str;
        }
    }

    /* renamed from: a */
    public void m9557a(String str, String str2) {
        if (str == null || str2 == null) {
            return;
        }
        synchronized (this.f10163aC) {
            this.f10144K.put(str, str2);
        }
    }

    /* renamed from: b */
    public void m9563b(boolean z) {
        this.f10175ag = z;
    }

    /* renamed from: b */
    public void m9562b(String str, String str2) {
        if (!C3154aq.m9970a(str) && !C3154aq.m9970a(str2)) {
            synchronized (this.f10164aD) {
                this.f10186as.put(str, str2);
            }
            return;
        }
        C3151an.m9922d("key&value should not be empty %s %s", "" + str, "" + str2);
    }

    /* renamed from: a */
    public void m9555a(int i2) {
        synchronized (this.f10166aF) {
            int i3 = this.f10184aq;
            if (i3 != i2) {
                this.f10184aq = i2;
                C3151an.m9915a("user scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.f10184aq));
            }
        }
    }

    /* renamed from: b */
    public void m9560b(int i2) {
        int i3 = this.f10185ar;
        if (i3 != i2) {
            this.f10185ar = i2;
            C3151an.m9915a("server scene tag %d changed to tag %d", Integer.valueOf(i3), Integer.valueOf(this.f10185ar));
        }
    }

    /* renamed from: c */
    public String m9564c() {
        return this.f10202j;
    }

    /* renamed from: c */
    public void m9565c(String str) {
        this.f10152S = str;
        synchronized (this.f10168aH) {
            this.f10187at.put("E8", str);
        }
    }

    /* renamed from: c */
    public void m9566c(String str, String str2) {
        if (!C3154aq.m9970a(str) && !C3154aq.m9970a(str2)) {
            synchronized (this.f10165aE) {
                this.f10188au.put(str, str2);
            }
            return;
        }
        C3151an.m9922d("server key&value should not be empty %s %s", "" + str, "" + str2);
    }
}
