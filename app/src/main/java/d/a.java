package d;

import android.text.TextUtils;
import bean.SurveyH5Bean;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import util.p1;
import util.y1;

/* compiled from: AppHiConfig.java */
/* loaded from: classes2.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    public static String f13515a = null;

    /* renamed from: b, reason: collision with root package name */
    public static String f13516b = null;

    /* renamed from: c, reason: collision with root package name */
    public static String f13517c = null;

    /* renamed from: d, reason: collision with root package name */
    public static String f13518d = null;

    /* renamed from: e, reason: collision with root package name */
    public static String f13519e = null;

    /* renamed from: f, reason: collision with root package name */
    public static String f13520f = null;

    /* renamed from: g, reason: collision with root package name */
    public static String f13521g = null;

    /* renamed from: h, reason: collision with root package name */
    public static String f13522h = null;

    /* renamed from: i, reason: collision with root package name */
    public static String f13523i = null;

    /* renamed from: j, reason: collision with root package name */
    public static String f13524j = null;

    /* renamed from: k, reason: collision with root package name */
    public static final int f13525k = -1;

    /* renamed from: l, reason: collision with root package name */
    public static final int f13526l = 1;

    /* renamed from: m, reason: collision with root package name */
    public static final int f13527m = 2;
    public static final int n = 3;
    public static final int o = 4;
    public static final int p = 5;
    public static final int q = 6;
    public static final int r = 7;
    public static final int s = 8;
    public static final int t = 9;
    public static final int u = 1;

    public static void a() {
        f13517c = y1.A(com.hicorenational.antifraud.a.f5938g);
    }

    public static void b() {
        f13518d = y1.A(com.hicorenational.antifraud.a.f5939h);
    }

    public static String c() {
        RegionMudelBean j2 = j();
        if (j2 != null) {
            f13522h = j2.getLocalApi();
        } else {
            f13522h = f13517c;
        }
        return f13522h;
    }

    public static String d() {
        RegionMudelBean j2 = j();
        if (j2 != null) {
            f13523i = j2.getLocalApi();
        } else {
            f13523i = f13519e;
        }
        return f13523i;
    }

    public static void e() {
        f13515a = y1.A(com.hicorenational.antifraud.a.f5943l);
    }

    public static void f() {
        f13516b = y1.A(com.hicorenational.antifraud.a.f5944m);
    }

    public static void g() {
        f13520f = y1.A(com.hicorenational.antifraud.a.f5942k);
        f13521g = f13520f;
    }

    public static void h() {
        f13519e = y1.A(com.hicorenational.antifraud.a.f5940i);
    }

    public static String i() {
        return y1.A("https://fzapp.gjfzpt.cn");
    }

    public static RegionMudelBean j() {
        RegionMudelBean regionMudelBean = (RegionMudelBean) p1.a(LocalModuelConfig.LASTCONFIG, RegionMudelBean.class);
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getLocalApi())) {
            return null;
        }
        return regionMudelBean;
    }

    public static boolean k() {
        return j() != null;
    }

    public static void l() {
        e();
        f();
        a();
        h();
        b();
        g();
        c();
        d();
    }

    public static long m() {
        return System.currentTimeMillis() / 3000;
    }

    public static String a(int i2) {
        String str;
        switch (i2) {
            case 1:
                str = "users";
                break;
            case 2:
                str = SurveyH5Bean.SMS;
                break;
            case 3:
                str = "realname";
                break;
            case 4:
                str = "newxcapi";
                break;
            case 5:
                str = "casereport";
                break;
            case 6:
                str = "earlywarning";
                break;
            case 7:
                str = "riskverify";
                break;
            case 8:
                str = "basicapi";
                break;
            case 9:
                str = "feedback";
                break;
            default:
                str = "";
                break;
        }
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str + "/";
    }

    public static String b(String str) {
        Integer num;
        RegionMudelBean j2 = j();
        return (j2 == null || j2.getModles() == null || (num = j2.getModles().get(str)) == null) ? "" : num.toString();
    }

    private static String a(int i2, String str) {
        String c2;
        String str2;
        if (i2 == 4) {
            c2 = d();
        } else {
            c2 = c();
        }
        if (j() != null) {
            str2 = a(i2);
            if (!TextUtils.isEmpty(str2)) {
                str = a(str);
            }
        } else {
            str2 = "";
        }
        return c2 + str2 + str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static String c(String str) {
        char c2;
        RegionMudelBean j2;
        switch (str.hashCode()) {
            case 49:
                if (str.equals("1")) {
                    c2 = 0;
                    break;
                }
                c2 = 65535;
                break;
            case 50:
                if (str.equals("2")) {
                    c2 = 1;
                    break;
                }
                c2 = 65535;
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 2;
                    break;
                }
                c2 = 65535;
                break;
            default:
                c2 = 65535;
                break;
        }
        if (c2 == 0) {
            f13524j = f13522h;
        } else if (c2 == 1) {
            f13524j = f13516b;
        } else if (c2 == 2 && (j2 = j()) != null) {
            f13524j = j2.getIndividuaApi();
        }
        return f13524j;
    }

    public static String a(String str, int i2, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return a(i2, str2);
        }
        String b2 = b(str);
        RegionMudelBean j2 = j();
        String str4 = "";
        if (j2 != null && (TextUtils.isEmpty(b2) || !TextUtils.equals(b2, "0"))) {
            str3 = j2.getLocalApi();
            str4 = a(i2);
            if (!TextUtils.isEmpty(str4)) {
                str2 = a(str2);
            }
        } else {
            str3 = i2 == 4 ? f13519e : f13517c;
        }
        return str3 + str4 + str2;
    }

    public static String a(String str, String str2) {
        String str3;
        RegionMudelBean j2 = j();
        if (j2 != null) {
            if (j2.getModles() != null) {
                Integer num = j2.getModles().get(str);
                if (num != null && TextUtils.equals(num.toString(), "0")) {
                    str3 = f13516b;
                } else {
                    str3 = j2.getLocalApi();
                }
            } else {
                str3 = "";
            }
        } else {
            str3 = f13516b;
        }
        return str3 + str2;
    }

    private static String a(String str) {
        if (str.toLowerCase().contains(e.b.M.toLowerCase())) {
            return e.b.N;
        }
        if (str.toLowerCase().contains(e.b.C.toLowerCase())) {
            return e.b.D;
        }
        return str.toLowerCase().contains(e.b.M0.toLowerCase()) ? e.b.N0 : str;
    }
}
