package com.vivo.push.util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: ConcurrentUtils.java */
/* JADX INFO: loaded from: classes2.dex */
public final class g {
    private static final int a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f8669b = Math.max(2, Math.min(a - 1, 4));

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f8670c = (a * 2) + 1;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static ExecutorService f8671d = new ThreadPoolExecutor(f8669b, f8670c, 30, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new h("COMMON_THREAD"), new ThreadPoolExecutor.DiscardPolicy());

    public static ExecutorService a() {
        return f8671d;
    }
}
