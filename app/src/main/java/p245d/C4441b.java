package p245d;

import android.text.TextUtils;
import bean.PolicBean;
import util.C7307p1;

/* compiled from: CaseHelper.java */
/* renamed from: d.b */
/* loaded from: classes2.dex */
public class C4441b {

    /* renamed from: a */
    public static final int f16900a = 0;

    /* renamed from: b */
    public static final int f16901b = 1;

    /* renamed from: c */
    public static final int f16902c = 2;

    /* renamed from: d */
    public static final int f16903d = 3;

    /* renamed from: e */
    public static final int f16904e = 4;

    /* renamed from: f */
    public static final int f16905f = 5;

    /* renamed from: g */
    public static final int f16906g = 6;

    /* renamed from: h */
    public static final int f16907h = 7;

    /* renamed from: i */
    public static final int f16908i = 127;

    /* renamed from: a */
    public static void m16413a(PolicBean policBean) {
        C7307p1.m26478a(C7307p1.f25502k, policBean);
    }

    /* renamed from: b */
    public static String m16414b() {
        PolicBean m16412a = m16412a();
        return (m16412a == null || TextUtils.isEmpty(m16412a.getTelNumber())) ? "" : m16412a.getTelNumber();
    }

    /* renamed from: c */
    public static String m16415c() {
        PolicBean m16412a = m16412a();
        return (m16412a == null || TextUtils.isEmpty(m16412a.getPoliceToken())) ? "" : m16412a.getPoliceToken();
    }

    /* renamed from: d */
    public static boolean m16416d() {
        return m16412a() != null;
    }

    /* renamed from: e */
    public static void m16417e() {
        m16413a(null);
    }

    /* renamed from: a */
    public static PolicBean m16412a() {
        return (PolicBean) C7307p1.m26476a(C7307p1.f25502k, PolicBean.class);
    }
}
