package e;

import android.text.TextUtils;
import bean.PolicBean;
import util.u1;

/* JADX INFO: compiled from: CaseHelper.java */
/* JADX INFO: loaded from: classes2.dex */
public class b {
    public static final int a = 0;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final int f10151b = 1;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f10152c = 2;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f10153d = 3;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f10154e = 4;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f10155f = 5;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final int f10156g = 6;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final int f10157h = 7;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f10158i = 127;

    public static void a(PolicBean policBean) {
        u1.a(u1.f15088k, policBean);
    }

    public static String b() {
        PolicBean policBeanA = a();
        return (policBeanA == null || TextUtils.isEmpty(policBeanA.getTelNumber())) ? "" : policBeanA.getTelNumber();
    }

    public static String c() {
        PolicBean policBeanA = a();
        return (policBeanA == null || TextUtils.isEmpty(policBeanA.getPoliceToken())) ? "" : policBeanA.getPoliceToken();
    }

    public static boolean d() {
        return a() != null;
    }

    public static void e() {
        a(null);
    }

    public static PolicBean a() {
        return (PolicBean) u1.a(u1.f15088k, PolicBean.class);
    }
}
