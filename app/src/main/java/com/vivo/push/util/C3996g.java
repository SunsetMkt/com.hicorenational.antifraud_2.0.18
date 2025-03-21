package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* compiled from: ConcurrentUtils.java */
/* renamed from: com.vivo.push.util.g */
/* loaded from: classes2.dex */
public final class C3996g {

    /* renamed from: a */
    private static final int f14246a = Runtime.getRuntime().availableProcessors();

    /* renamed from: b */
    private static final int f14247b = Math.max(2, Math.min(f14246a - 1, 4));

    /* renamed from: c */
    private static final int f14248c = (f14246a * 2) + 1;

    /* renamed from: d */
    private static ExecutorService f14249d = new ThreadPoolExecutor(f14247b, f14248c, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new ThreadFactoryC3997h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());

    /* renamed from: a */
    public static ExecutorService m13250a() {
        return f14249d;
    }
}
