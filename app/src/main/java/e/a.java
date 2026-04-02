package e;

import android.text.TextUtils;
import bean.SurveyH5Bean;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import util.g2;
import util.u1;

/* JADX INFO: compiled from: AppHiConfig.java */
/* JADX INFO: loaded from: classes2.dex */
public class a {
    public static String a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static String f10138b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static String f10139c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static String f10140d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static String f10141e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static String f10142f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static String f10143g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static String f10144h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static String f10145i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static String f10146j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final int f10147k = -1;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final int f10148l = 1;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final int f10149m = 2;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public static final int f10150n = 3;
    public static final int o = 4;
    public static final int p = 5;
    public static final int q = 6;
    public static final int r = 7;
    public static final int s = 8;
    public static final int t = 9;
    public static final int u = 1;

    public static void a() {
        f10139c = g2.A(com.hicorenational.antifraud.a.f3984g);
    }

    public static void b() {
        f10140d = g2.A(com.hicorenational.antifraud.a.f3985h);
    }

    public static String c() {
        RegionMudelBean regionMudelBeanJ = j();
        if (regionMudelBeanJ != null) {
            f10144h = regionMudelBeanJ.getLocalApi();
        } else {
            f10144h = f10139c;
        }
        return f10144h;
    }

    public static String d() {
        RegionMudelBean regionMudelBeanJ = j();
        if (regionMudelBeanJ != null) {
            f10145i = regionMudelBeanJ.getLocalApi();
        } else {
            f10145i = f10141e;
        }
        return f10145i;
    }

    public static void e() {
        a = g2.A(com.hicorenational.antifraud.a.f3989l);
    }

    public static void f() {
        f10138b = g2.A(com.hicorenational.antifraud.a.f3990m);
    }

    public static void g() {
        f10142f = g2.A(com.hicorenational.antifraud.a.f3988k);
        f10143g = f10142f;
    }

    public static void h() {
        f10141e = g2.A(com.hicorenational.antifraud.a.f3986i);
    }

    public static String i() {
        return g2.A("https://fzapp.gjfzpt.cn");
    }

    public static RegionMudelBean j() {
        RegionMudelBean regionMudelBean = (RegionMudelBean) u1.a(LocalModuelConfig.LASTCONFIG, RegionMudelBean.class);
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
        RegionMudelBean regionMudelBeanJ = j();
        return (regionMudelBeanJ == null || regionMudelBeanJ.getModles() == null || (num = regionMudelBeanJ.getModles().get(str)) == null) ? "" : num.toString();
    }

    private static String a(int i2, String str) {
        String strC;
        String strA;
        if (i2 == 4) {
            strC = d();
        } else {
            strC = c();
        }
        if (j() != null) {
            strA = a(i2);
            if (!TextUtils.isEmpty(strA)) {
                str = a(str);
            }
        } else {
            strA = "";
        }
        return strC + strA + str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0028  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static String c(String str) {
        byte b2;
        RegionMudelBean regionMudelBeanJ;
        switch (str.hashCode()) {
            case 49:
                b2 = !str.equals("1") ? (byte) -1 : (byte) 0;
                break;
            case 50:
                if (str.equals("2")) {
                    b2 = 1;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    b2 = 2;
                    break;
                }
                break;
        }
        if (b2 == 0) {
            f10146j = f10144h;
        } else if (b2 == 1) {
            f10146j = f10138b;
        } else if (b2 == 2 && (regionMudelBeanJ = j()) != null) {
            f10146j = regionMudelBeanJ.getIndividuaApi();
        }
        return f10146j;
    }

    public static String b(String str, int i2, String str2) {
        String localApi;
        if (TextUtils.isEmpty(str)) {
            return a(i2, str2);
        }
        String strB = b(str);
        RegionMudelBean regionMudelBeanJ = j();
        String strA = "";
        if (regionMudelBeanJ != null && (TextUtils.isEmpty(strB) || !TextUtils.equals(strB, "0"))) {
            localApi = regionMudelBeanJ.getLocalApi();
            strA = a(i2);
            if (!TextUtils.isEmpty(strA)) {
                str2 = a(str2);
            }
        } else {
            localApi = i2 == 4 ? f10141e : f10139c;
        }
        return localApi + strA + str2;
    }

    public static String a(String str, int i2, String str2) {
        if (TextUtils.isEmpty(str)) {
            return a(i2, str2);
        }
        return f10139c + "" + str2;
    }

    public static String a(String str, String str2) {
        String localApi;
        RegionMudelBean regionMudelBeanJ = j();
        if (regionMudelBeanJ != null) {
            if (regionMudelBeanJ.getModles() != null) {
                Integer num = regionMudelBeanJ.getModles().get(str);
                if (num != null && TextUtils.equals(num.toString(), "0")) {
                    localApi = f10138b;
                } else {
                    localApi = regionMudelBeanJ.getLocalApi();
                }
            } else {
                localApi = "";
            }
        } else {
            localApi = f10138b;
        }
        return localApi + str2;
    }

    private static String a(String str) {
        if (str.toLowerCase().contains(f.b.N.toLowerCase())) {
            return f.b.O;
        }
        if (str.toLowerCase().contains(f.b.D.toLowerCase())) {
            return f.b.E;
        }
        return str.toLowerCase().contains(f.b.N0.toLowerCase()) ? f.b.O0 : str;
    }
}
