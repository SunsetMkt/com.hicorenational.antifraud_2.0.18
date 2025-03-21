package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* renamed from: com.huawei.hms.hatool.e0 */
/* loaded from: classes.dex */
public abstract class AbstractC2407e0 {
    /* renamed from: a */
    private C2418i m7086a(int i2) {
        String str;
        if (i2 != 0) {
            str = m7089f();
            if (!TextUtils.isEmpty(str)) {
                return new C2418i(EnumC2404d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new C2418i(EnumC2404d0.EMPTY, str);
    }

    /* renamed from: b */
    private C2418i m7087b(int i2) {
        String str;
        if ((i2 & 4) != 0) {
            str = m7089f();
            if (!TextUtils.isEmpty(str)) {
                return new C2418i(EnumC2404d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new C2418i(EnumC2404d0.EMPTY, str);
    }

    /* renamed from: e */
    private boolean m7088e() {
        C2414g1 m7331b = C2446s.m7326c().m7331b();
        if (TextUtils.isEmpty(m7331b.m7138l())) {
            m7331b.m7131h(AbstractC2436o.m7258a());
        }
        return !TextUtils.isEmpty(m7331b.m7138l());
    }

    /* renamed from: f */
    private String m7089f() {
        C2414g1 m7331b = C2446s.m7326c().m7331b();
        if (TextUtils.isEmpty(m7331b.m7132i())) {
            m7331b.m7125e(C2457x0.m7412c());
        }
        return m7331b.m7132i();
    }

    /* renamed from: a */
    public C2418i m7090a(Context context) {
        String mo7094c = mo7094c();
        if (!TextUtils.isEmpty(mo7094c)) {
            return new C2418i(EnumC2404d0.UDID, mo7094c);
        }
        String mo7091a = mo7091a();
        if (!TextUtils.isEmpty(mo7091a)) {
            return new C2418i(EnumC2404d0.IMEI, mo7091a);
        }
        boolean m7088e = m7088e();
        String mo7093b = mo7093b();
        return !TextUtils.isEmpty(mo7093b) ? m7088e ? new C2418i(EnumC2404d0.SN, mo7093b) : new C2418i(EnumC2404d0.UDID, mo7092a(mo7093b)) : m7088e ? m7086a(mo7095d()) : m7087b(mo7095d());
    }

    /* renamed from: a */
    public abstract String mo7091a();

    /* renamed from: a */
    public abstract String mo7092a(String str);

    /* renamed from: b */
    public abstract String mo7093b();

    /* renamed from: c */
    public abstract String mo7094c();

    /* renamed from: d */
    public abstract int mo7095d();
}
