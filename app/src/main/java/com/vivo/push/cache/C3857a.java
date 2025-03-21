package com.vivo.push.cache;

import android.content.Context;
import android.text.TextUtils;
import android.util.Base64;
import com.vivo.push.model.C3925a;
import com.vivo.push.util.C3999j;
import com.vivo.push.util.C4010u;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;

/* compiled from: AppConfigSettings.java */
/* renamed from: com.vivo.push.cache.a */
/* loaded from: classes2.dex */
public final class C3857a extends AbstractC3859c<C3925a> {
    public C3857a(Context context) {
        super(context);
    }

    /* renamed from: a */
    public static boolean m12895a(int i2) {
        return (i2 == -1 || (i2 & 1) == 0) ? false : true;
    }

    @Override // com.vivo.push.cache.AbstractC3859c
    /* renamed from: a */
    protected final String mo12896a() {
        return "com.vivo.pushservice.back_up";
    }

    @Override // com.vivo.push.cache.AbstractC3859c
    /* renamed from: a */
    public final List<C3925a> mo12897a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (!TextUtils.isEmpty(str)) {
            for (String str2 : str.trim().split("@#")) {
                String trim = str2.trim();
                String[] split = trim.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (split.length >= 2) {
                    try {
                        arrayList.add(new C3925a(split[0], trim.substring(split[0].length() + 1)));
                    } catch (Exception e2) {
                        C4010u.m13309d("AppConfigSettings", "str2Clients E: ".concat(String.valueOf(e2)));
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.vivo.push.cache.AbstractC3859c
    /* renamed from: b */
    final String mo12899b(String str) throws Exception {
        return new String(C3999j.m13260a(C3999j.m13259a(m12908e()), C3999j.m13259a(m12909f()), Base64.decode(str, 2)), "utf-8");
    }

    /* renamed from: c */
    public final C3925a m12900c(String str) {
        synchronized (AbstractC3859c.f13967a) {
            for (T t : this.f13968b) {
                if (!TextUtils.isEmpty(t.m13058a()) && t.m13058a().equals(str)) {
                    return t;
                }
            }
            return null;
        }
    }

    /* renamed from: b */
    public final int m12898b() {
        C3925a m12900c = m12900c("push_mode");
        if (m12900c != null && !TextUtils.isEmpty(m12900c.m13059b())) {
            try {
                return Integer.parseInt(m12900c.m13059b());
            } catch (Exception unused) {
            }
        }
        return -1;
    }
}
