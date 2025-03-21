package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import java.text.SimpleDateFormat;

/* renamed from: com.xiaomi.push.bz */
/* loaded from: classes2.dex */
public class C4124bz {

    /* renamed from: a */
    private static SimpleDateFormat f14691a = new SimpleDateFormat("yyyy/MM/dd");

    /* renamed from: a */
    private static String f14690a = f14691a.format(Long.valueOf(System.currentTimeMillis()));

    /* renamed from: a */
    public static C4243gj m13977a(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        C4243gj c4243gj = new C4243gj();
        c4243gj.m15000d("category_push_stat");
        c4243gj.m14981a("push_sdk_stat_channel");
        c4243gj.m14980a(1L);
        c4243gj.m14992b(str);
        c4243gj.m14983a(true);
        c4243gj.m14991b(System.currentTimeMillis());
        c4243gj.m15008g(C4112bn.m13932a(context).m13939a());
        c4243gj.m15003e("com.xiaomi.xmsf");
        c4243gj.m15006f("");
        c4243gj.m14996c("push_stat");
        return c4243gj;
    }
}
