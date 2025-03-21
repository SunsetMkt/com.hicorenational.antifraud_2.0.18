package com.huawei.hms.hatool;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public abstract class e0 {
    private i a(int i2) {
        String str;
        if (i2 != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private i b(int i2) {
        String str;
        if ((i2 & 4) != 0) {
            str = f();
            if (!TextUtils.isEmpty(str)) {
                return new i(d0.UDID, str);
            }
        } else {
            str = "";
        }
        return new i(d0.EMPTY, str);
    }

    private boolean e() {
        g1 b2 = s.c().b();
        if (TextUtils.isEmpty(b2.l())) {
            b2.h(o.a());
        }
        return !TextUtils.isEmpty(b2.l());
    }

    private String f() {
        g1 b2 = s.c().b();
        if (TextUtils.isEmpty(b2.i())) {
            b2.e(x0.c());
        }
        return b2.i();
    }

    public i a(Context context) {
        String c2 = c();
        if (!TextUtils.isEmpty(c2)) {
            return new i(d0.UDID, c2);
        }
        String a2 = a();
        if (!TextUtils.isEmpty(a2)) {
            return new i(d0.IMEI, a2);
        }
        boolean e2 = e();
        String b2 = b();
        return !TextUtils.isEmpty(b2) ? e2 ? new i(d0.SN, b2) : new i(d0.UDID, a(b2)) : e2 ? a(d()) : b(d());
    }

    public abstract String a();

    public abstract String a(String str);

    public abstract String b();

    public abstract String c();

    public abstract int d();
}
