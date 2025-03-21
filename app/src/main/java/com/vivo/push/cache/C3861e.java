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

/* compiled from: PushConfigSettings.java */
/* renamed from: com.vivo.push.cache.e */
/* loaded from: classes2.dex */
public final class C3861e extends AbstractC3859c<C3925a> {
    public C3861e(Context context) {
        super(context);
    }

    @Override // com.vivo.push.cache.AbstractC3859c
    /* renamed from: a */
    protected final String mo12896a() {
        return "com.vivo.pushservice.other";
    }

    @Override // com.vivo.push.cache.AbstractC3859c
    /* renamed from: a */
    public final List<C3925a> mo12897a(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.trim().split("@#")) {
            String trim = str2.trim();
            String[] split = trim.trim().split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split.length >= 2) {
                try {
                    arrayList.add(new C3925a(split[0], trim.substring(split[0].length() + 1)));
                } catch (Exception e2) {
                    C4010u.m13309d("PushConfigSettings", "str2Clients E: ".concat(String.valueOf(e2)));
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
    public final String m12910c(String str) {
        synchronized (AbstractC3859c.f13967a) {
            for (T t : this.f13968b) {
                if (!TextUtils.isEmpty(t.m13058a()) && t.m13058a().equals(str)) {
                    return t.m13059b();
                }
            }
            return null;
        }
    }
}
