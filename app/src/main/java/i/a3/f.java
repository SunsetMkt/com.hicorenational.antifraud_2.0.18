package i.a3;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes2.dex */
public final /* synthetic */ class f {
    public static final /* synthetic */ int[] a = new int[TimeUnit.values().length];

    static {
        a[TimeUnit.NANOSECONDS.ordinal()] = 1;
        a[TimeUnit.MICROSECONDS.ordinal()] = 2;
        a[TimeUnit.MILLISECONDS.ordinal()] = 3;
        a[TimeUnit.SECONDS.ordinal()] = 4;
        a[TimeUnit.MINUTES.ordinal()] = 5;
        a[TimeUnit.HOURS.ordinal()] = 6;
        a[TimeUnit.DAYS.ordinal()] = 7;
    }
}
