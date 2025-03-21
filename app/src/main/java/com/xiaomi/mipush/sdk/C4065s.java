package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.C4053g;
import com.xiaomi.push.C4094aw;

/* renamed from: com.xiaomi.mipush.sdk.s */
/* loaded from: classes2.dex */
public class C4065s {
    /* renamed from: a */
    public static AbstractPushManager m13601a(Context context, EnumC4050d enumC4050d) {
        return m13602b(context, enumC4050d);
    }

    /* renamed from: b */
    private static AbstractPushManager m13602b(Context context, EnumC4050d enumC4050d) {
        C4053g.a m13554a = C4053g.m13554a(enumC4050d);
        if (m13554a == null || TextUtils.isEmpty(m13554a.f14411a) || TextUtils.isEmpty(m13554a.f14412b)) {
            return null;
        }
        return (AbstractPushManager) C4094aw.m13824a(m13554a.f14411a, m13554a.f14412b, context);
    }
}
