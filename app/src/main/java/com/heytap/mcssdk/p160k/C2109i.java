package com.heytap.mcssdk.p160k;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* renamed from: com.heytap.mcssdk.k.i */
/* loaded from: classes.dex */
public class C2109i {

    /* renamed from: a */
    private static final ExecutorService f6265a = Executors.newSingleThreadExecutor();

    /* renamed from: b */
    private static Handler f6266b = new Handler(Looper.getMainLooper());

    /* renamed from: a */
    public static void m5913a(Runnable runnable) {
        f6265a.execute(runnable);
    }

    /* renamed from: b */
    public static void m5914b(Runnable runnable) {
        f6266b.post(runnable);
    }
}
