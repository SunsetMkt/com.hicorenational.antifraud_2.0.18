package com.huawei.hms.push;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ReceiverThreadPoolExecutor.java */
/* renamed from: com.huawei.hms.push.q */
/* loaded from: classes.dex */
public class C2497q {

    /* renamed from: a */
    private static final Object f7790a = new Object();

    /* renamed from: b */
    private static ThreadPoolExecutor f7791b = new ThreadPoolExecutor(1, 50, 60, TimeUnit.SECONDS, new LinkedBlockingQueue());

    /* renamed from: a */
    public static ThreadPoolExecutor m7629a() {
        ThreadPoolExecutor threadPoolExecutor;
        synchronized (f7790a) {
            threadPoolExecutor = f7791b;
        }
        return threadPoolExecutor;
    }
}
