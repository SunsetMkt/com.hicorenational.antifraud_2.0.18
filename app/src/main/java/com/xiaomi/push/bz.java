package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* JADX INFO: loaded from: classes2.dex */
public class bz {

    /* JADX INFO: renamed from: a */
    private static SimpleDateFormat f243a = new SimpleDateFormat("yyyy/MM/dd");
    private static String a = f243a.format(Long.valueOf(System.currentTimeMillis()));

    public static gj a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        gj gjVar = new gj();
        gjVar.d("category_push_stat");
        gjVar.a("push_sdk_stat_channel");
        gjVar.a(1L);
        gjVar.b(str);
        gjVar.a(true);
        gjVar.b(System.currentTimeMillis());
        gjVar.g(bn.a(context).m189a());
        gjVar.e("com.xiaomi.xmsf");
        gjVar.f("");
        gjVar.c("push_stat");
        return gjVar;
    }
}
