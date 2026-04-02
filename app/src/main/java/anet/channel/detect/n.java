package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class n {
    private static d a = new d();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static ExceptionDetector f1422b = new ExceptionDetector();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static k f1423c = new k();

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static AtomicBoolean f1424d = new AtomicBoolean(false);

    public static void a() {
        try {
            if (f1424d.compareAndSet(false, true)) {
                ALog.i("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                a.b();
                f1422b.a();
                f1423c.a();
            }
        } catch (Exception e2) {
            ALog.e("awcn.NetworkDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    public static void a(RequestStatistic requestStatistic) {
        if (f1424d.get()) {
            f1422b.a(requestStatistic);
        }
    }
}
