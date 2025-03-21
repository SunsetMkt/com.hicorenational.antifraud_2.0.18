package anetwork.channel.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.e */
/* loaded from: classes.dex */
public class C0893e {

    /* renamed from: a */
    private static final ExecutorService[] f1340a = new ExecutorService[2];

    /* renamed from: b */
    private static AtomicInteger f1341b = new AtomicInteger(0);

    static {
        for (int i2 = 0; i2 < 2; i2++) {
            f1340a[i2] = Executors.newSingleThreadExecutor(new ThreadFactoryC0894f());
        }
    }

    /* renamed from: a */
    public static void m813a(int i2, Runnable runnable) {
        f1340a[Math.abs(i2 % 2)].submit(runnable);
    }
}
