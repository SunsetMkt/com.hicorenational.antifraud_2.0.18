package com.umeng.socialize.tracker.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: compiled from: TaskPool.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {
    private static final int a = 1;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExecutorService f8402b = Executors.newFixedThreadPool(1);

    public static void a(Runnable runnable) {
        if (runnable != null) {
            f8402b.execute(runnable);
        }
    }
}
