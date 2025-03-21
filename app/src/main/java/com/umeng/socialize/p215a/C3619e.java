package com.umeng.socialize.p215a;

import android.content.Context;
import android.text.TextUtils;
import com.umeng.analytics.pro.C3351bh;
import com.umeng.socialize.utils.ContextUtil;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: SharedPrefs.java */
/* renamed from: com.umeng.socialize.a.e */
/* loaded from: classes2.dex */
public class C3619e {

    /* renamed from: a */
    private static final String f13483a = "Prefs";

    /* renamed from: c */
    private static volatile C3619e f13484c;

    /* renamed from: b */
    private final Context f13485b;

    /* renamed from: d */
    private final a f13486d = new a("AZX");

    /* compiled from: SharedPrefs.java */
    /* renamed from: com.umeng.socialize.a.e$a */
    private class a {

        /* renamed from: b */
        private final String f13488b;

        public a(String str) {
            if (!TextUtils.isEmpty(str)) {
                str = str + AbstractC1191a.f2606s1;
            }
            this.f13488b = str;
        }

        /* renamed from: b */
        private String m12522b(String str) {
            return this.f13488b + str;
        }

        /* renamed from: c */
        private String m12523c(String str, String str2) {
            try {
                if (C3617c.m12504a(ContextUtil.getContext())) {
                    return C3616b.m12495a().m12499b(str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return str2;
        }

        /* renamed from: d */
        private void m12525d(String str, String str2) {
            try {
                if (C3617c.m12504a(ContextUtil.getContext())) {
                    C3616b.m12495a().m12498a(str, str2);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }

        /* renamed from: a */
        public void m12528a(String str, int i2) {
            m12525d(m12522b(str), String.valueOf(i2));
        }

        /* renamed from: a */
        public void m12529a(String str, long j2) {
            m12525d(m12522b(str), String.valueOf(j2));
        }

        /* renamed from: b */
        public int m12533b(String str, int i2) {
            try {
                return Integer.parseInt(m12523c(m12522b(str), String.valueOf(i2)));
            } catch (Exception unused) {
                return i2;
            }
        }

        /* renamed from: a */
        public void m12527a(String str, float f2) {
            m12525d(m12522b(str), String.valueOf(f2));
        }

        /* renamed from: a */
        public void m12530a(String str, String str2) {
            m12525d(m12522b(str), String.valueOf(str2));
        }

        /* renamed from: b */
        public long m12534b(String str, long j2) {
            try {
                return Long.parseLong(m12523c(m12522b(str), String.valueOf(j2)));
            } catch (Exception unused) {
                return j2;
            }
        }

        /* renamed from: a */
        public void m12531a(String str, boolean z) {
            m12525d(m12522b(str), String.valueOf(z));
        }

        /* renamed from: c */
        private void m12524c(String str) {
            try {
                if (C3617c.m12504a(ContextUtil.getContext())) {
                    C3616b.m12495a().m12497a(str);
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        /* renamed from: a */
        public void m12526a(String str) {
            m12524c(m12522b(str));
        }

        /* renamed from: b */
        public float m12532b(String str, float f2) {
            try {
                return Float.parseFloat(m12523c(m12522b(str), String.valueOf(f2)));
            } catch (Exception unused) {
                return f2;
            }
        }

        /* renamed from: b */
        public boolean m12536b(String str, boolean z) {
            try {
                return Boolean.parseBoolean(m12523c(m12522b(str), String.valueOf(z)));
            } catch (Exception unused) {
                return z;
            }
        }

        /* renamed from: b */
        public String m12535b(String str, String str2) {
            return m12523c(m12522b(str), str2);
        }
    }

    private C3619e(Context context) {
        this.f13485b = context.getApplicationContext();
    }

    /* renamed from: a */
    public static C3619e m12511a(Context context) {
        if (f13484c == null) {
            synchronized (C3619e.class) {
                if (f13484c == null) {
                    f13484c = new C3619e(context);
                }
            }
        }
        return f13484c;
    }

    /* renamed from: b */
    public boolean m12518b() {
        return m12513a(C3615a.f13472e);
    }

    /* renamed from: c */
    public int m12519c() {
        return this.f13486d.m12533b(C3615a.f13473f, 0);
    }

    /* renamed from: d */
    public long m12520d() {
        return this.f13486d.m12534b(C3615a.f13471d, 0L);
    }

    /* renamed from: e */
    public void m12521e() {
        if (C3617c.m12504a(this.f13485b)) {
            this.f13486d.m12529a(C3615a.f13471d, m12520d() + 1);
        }
    }

    /* renamed from: b */
    private void m12514b(String str) {
        this.f13486d.m12526a(str + C3351bh.f11599aX);
        this.f13486d.m12526a(str + "ts");
    }

    /* renamed from: a */
    public void m12517a(long j2) {
        m12512a(C3615a.f13472e, j2);
    }

    /* renamed from: a */
    public long m12515a() {
        return this.f13486d.m12534b("smart_ts", 0L);
    }

    /* renamed from: a */
    public void m12516a(int i2) {
        this.f13486d.m12528a(C3615a.f13473f, i2);
    }

    /* renamed from: a */
    private void m12512a(String str, long j2) {
        this.f13486d.m12529a(str + C3351bh.f11599aX, j2);
        this.f13486d.m12529a(str + "ts", System.currentTimeMillis());
    }

    /* renamed from: a */
    private boolean m12513a(String str) {
        long m12534b = this.f13486d.m12534b(str + C3351bh.f11599aX, 0L);
        if (m12534b <= 0) {
            return true;
        }
        long abs = Math.abs(System.currentTimeMillis() - this.f13486d.m12534b(str + "ts", 0L)) / 1000;
        boolean z = abs >= m12534b;
        if (!z && C3615a.f13470c) {
            C3627m.m12562a(f13483a, "interval deny ", str, " config:", Long.valueOf(m12534b), " current:", Long.valueOf(abs));
        }
        return z;
    }
}
