package com.xiaomi.push;

import android.content.Context;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* renamed from: com.xiaomi.push.cx */
/* loaded from: classes2.dex */
public class C4149cx {

    /* renamed from: a */
    private static ThreadPoolExecutor f14837a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static void m14243a(Context context) {
    }
}
