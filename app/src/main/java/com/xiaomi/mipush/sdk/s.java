package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.g;
import com.xiaomi.push.aw;

/* loaded from: classes2.dex */
public class s {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        g.a a2 = g.a(dVar);
        if (a2 == null || TextUtils.isEmpty(a2.f12375a) || TextUtils.isEmpty(a2.f12376b)) {
            return null;
        }
        return (AbstractPushManager) aw.a(a2.f12375a, a2.f12376b, context);
    }
}
