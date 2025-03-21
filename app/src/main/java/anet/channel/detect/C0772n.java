package anet.channel.detect;

import anet.channel.statist.RequestStatistic;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* compiled from: Taobao */
/* renamed from: anet.channel.detect.n */
/* loaded from: classes.dex */
public class C0772n {

    /* renamed from: a */
    private static C0762d f809a = new C0762d();

    /* renamed from: b */
    private static ExceptionDetector f810b = new ExceptionDetector();

    /* renamed from: c */
    private static C0769k f811c = new C0769k();

    /* renamed from: d */
    private static AtomicBoolean f812d = new AtomicBoolean(false);

    /* renamed from: a */
    public static void m482a() {
        try {
            if (f812d.compareAndSet(false, true)) {
                ALog.m716i("awcn.NetworkDetector", "registerListener", null, new Object[0]);
                f809a.m477b();
                f810b.m466a();
                f811c.m481a();
            }
        } catch (Exception e2) {
            ALog.m714e("awcn.NetworkDetector", "[registerListener]error", null, e2, new Object[0]);
        }
    }

    /* renamed from: a */
    public static void m483a(RequestStatistic requestStatistic) {
        if (f812d.get()) {
            f810b.m467a(requestStatistic);
        }
    }
}
