package p245d;

import android.text.TextUtils;
import bean.SurveyH5Bean;
import bean.module.LocalModuelConfig;
import bean.module.RegionMudelBean;
import com.hicorenational.antifraud.C2114a;
import p247e.C4445b;
import util.C7307p1;
import util.C7337y1;

/* compiled from: AppHiConfig.java */
/* renamed from: d.a */
/* loaded from: classes2.dex */
public class C4440a {

    /* renamed from: a */
    public static String f16879a = null;

    /* renamed from: b */
    public static String f16880b = null;

    /* renamed from: c */
    public static String f16881c = null;

    /* renamed from: d */
    public static String f16882d = null;

    /* renamed from: e */
    public static String f16883e = null;

    /* renamed from: f */
    public static String f16884f = null;

    /* renamed from: g */
    public static String f16885g = null;

    /* renamed from: h */
    public static String f16886h = null;

    /* renamed from: i */
    public static String f16887i = null;

    /* renamed from: j */
    public static String f16888j = null;

    /* renamed from: k */
    public static final int f16889k = -1;

    /* renamed from: l */
    public static final int f16890l = 1;

    /* renamed from: m */
    public static final int f16891m = 2;

    /* renamed from: n */
    public static final int f16892n = 3;

    /* renamed from: o */
    public static final int f16893o = 4;

    /* renamed from: p */
    public static final int f16894p = 5;

    /* renamed from: q */
    public static final int f16895q = 6;

    /* renamed from: r */
    public static final int f16896r = 7;

    /* renamed from: s */
    public static final int f16897s = 8;

    /* renamed from: t */
    public static final int f16898t = 9;

    /* renamed from: u */
    public static final int f16899u = 1;

    /* renamed from: a */
    public static void m16397a() {
        f16881c = C7337y1.m26719A(C2114a.f6310g);
    }

    /* renamed from: b */
    public static void m16399b() {
        f16882d = C7337y1.m26719A(C2114a.f6311h);
    }

    /* renamed from: c */
    public static String m16400c() {
        RegionMudelBean m16408j = m16408j();
        if (m16408j != null) {
            f16886h = m16408j.getLocalApi();
        } else {
            f16886h = f16881c;
        }
        return f16886h;
    }

    /* renamed from: d */
    public static String m16402d() {
        RegionMudelBean m16408j = m16408j();
        if (m16408j != null) {
            f16887i = m16408j.getLocalApi();
        } else {
            f16887i = f16883e;
        }
        return f16887i;
    }

    /* renamed from: e */
    public static void m16403e() {
        f16879a = C7337y1.m26719A(C2114a.f6315l);
    }

    /* renamed from: f */
    public static void m16404f() {
        f16880b = C7337y1.m26719A(C2114a.f6316m);
    }

    /* renamed from: g */
    public static void m16405g() {
        f16884f = C7337y1.m26719A(C2114a.f6314k);
        f16885g = f16884f;
    }

    /* renamed from: h */
    public static void m16406h() {
        f16883e = C7337y1.m26719A(C2114a.f6312i);
    }

    /* renamed from: i */
    public static String m16407i() {
        return C7337y1.m26719A("https://fzapp.gjfzpt.cn");
    }

    /* renamed from: j */
    public static RegionMudelBean m16408j() {
        RegionMudelBean regionMudelBean = (RegionMudelBean) C7307p1.m26476a(LocalModuelConfig.LASTCONFIG, RegionMudelBean.class);
        if (regionMudelBean == null || TextUtils.isEmpty(regionMudelBean.getLocalApi())) {
            return null;
        }
        return regionMudelBean;
    }

    /* renamed from: k */
    public static boolean m16409k() {
        return m16408j() != null;
    }

    /* renamed from: l */
    public static void m16410l() {
        m16403e();
        m16404f();
        m16397a();
        m16406h();
        m16399b();
        m16405g();
        m16400c();
        m16402d();
    }

    /* renamed from: m */
    public static long m16411m() {
        return System.currentTimeMillis() / 3000;
    }

    /* renamed from: a */
    public static String m16392a(int i2) {
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

    /* renamed from: b */
    public static String m16398b(String str) {
        Integer num;
        RegionMudelBean m16408j = m16408j();
        return (m16408j == null || m16408j.getModles() == null || (num = m16408j.getModles().get(str)) == null) ? "" : num.toString();
    }

    /* renamed from: a */
    private static String m16393a(int i2, String str) {
        String m16400c;
        String str2;
        if (i2 == 4) {
            m16400c = m16402d();
        } else {
            m16400c = m16400c();
        }
        if (m16408j() != null) {
            str2 = m16392a(i2);
            if (!TextUtils.isEmpty(str2)) {
                str = m16394a(str);
            }
        } else {
            str2 = "";
        }
        return m16400c + str2 + str;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* renamed from: c */
    public static String m16401c(String str) {
        char c2;
        RegionMudelBean m16408j;
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
            f16888j = f16886h;
        } else if (c2 == 1) {
            f16888j = f16880b;
        } else if (c2 == 2 && (m16408j = m16408j()) != null) {
            f16888j = m16408j.getIndividuaApi();
        }
        return f16888j;
    }

    /* renamed from: a */
    public static String m16395a(String str, int i2, String str2) {
        String str3;
        if (TextUtils.isEmpty(str)) {
            return m16393a(i2, str2);
        }
        String m16398b = m16398b(str);
        RegionMudelBean m16408j = m16408j();
        String str4 = "";
        if (m16408j != null && (TextUtils.isEmpty(m16398b) || !TextUtils.equals(m16398b, "0"))) {
            str3 = m16408j.getLocalApi();
            str4 = m16392a(i2);
            if (!TextUtils.isEmpty(str4)) {
                str2 = m16394a(str2);
            }
        } else {
            str3 = i2 == 4 ? f16883e : f16881c;
        }
        return str3 + str4 + str2;
    }

    /* renamed from: a */
    public static String m16396a(String str, String str2) {
        String str3;
        RegionMudelBean m16408j = m16408j();
        if (m16408j != null) {
            if (m16408j.getModles() != null) {
                Integer num = m16408j.getModles().get(str);
                if (num != null && TextUtils.equals(num.toString(), "0")) {
                    str3 = f16880b;
                } else {
                    str3 = m16408j.getLocalApi();
                }
            } else {
                str3 = "";
            }
        } else {
            str3 = f16880b;
        }
        return str3 + str2;
    }

    /* renamed from: a */
    private static String m16394a(String str) {
        if (str.toLowerCase().contains(C4445b.f17021M.toLowerCase())) {
            return C4445b.f17024N;
        }
        if (str.toLowerCase().contains(C4445b.f16991C.toLowerCase())) {
            return C4445b.f16994D;
        }
        return str.toLowerCase().contains(C4445b.f17022M0.toLowerCase()) ? C4445b.f17025N0 : str;
    }
}
