package com.umeng.socialize.tracker.utils;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* compiled from: TaskPool.java */
/* renamed from: com.umeng.socialize.tracker.utils.c */
/* loaded from: classes2.dex */
public class C3777c {

    /* renamed from: a */
    private static final int f13813a = 1;

    /* renamed from: b */
    private static ExecutorService f13814b = Executors.newFixedThreadPool(1);

    /* renamed from: a */
    public static void m12714a(Runnable runnable) {
        if (runnable != null) {
            f13814b.execute(runnable);
        }
    }
}
