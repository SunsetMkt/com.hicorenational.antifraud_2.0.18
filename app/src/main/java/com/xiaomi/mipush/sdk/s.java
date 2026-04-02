package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.mipush.sdk.g;
import com.xiaomi.push.aw;

/* JADX INFO: loaded from: classes2.dex */
public class s {
    public static AbstractPushManager a(Context context, d dVar) {
        return b(context, dVar);
    }

    private static AbstractPushManager b(Context context, d dVar) {
        g.a aVarA = g.a(dVar);
        if (aVarA == null || TextUtils.isEmpty(aVarA.a) || TextUtils.isEmpty(aVarA.f8720b)) {
            return null;
        }
        return (AbstractPushManager) aw.a(aVarA.a, aVarA.f8720b, context);
    }
}
