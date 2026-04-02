package anetwork.channel.entity;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class e {
    private static final ExecutorService[] a = new ExecutorService[2];

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static AtomicInteger f1773b = new AtomicInteger(0);

    static {
        for (int i2 = 0; i2 < 2; i2++) {
            a[i2] = Executors.newSingleThreadExecutor(new f());
        }
    }

    public static void a(int i2, Runnable runnable) {
        a[Math.abs(i2 % 2)].submit(runnable);
    }
}
