package b.a.q;

import android.content.Context;
import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.monitor.b;
import anet.channel.monitor.f;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    private static final String a = "anet.Monitor";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static AtomicBoolean f1849b = new AtomicBoolean(false);

    @Deprecated
    public static synchronized void a(Context context) {
        d();
    }

    public static void b(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        anet.channel.monitor.a.a().a(iNetworkQualityChangeListener);
    }

    @Deprecated
    public static b.a.q.b.a c() {
        return b.a.q.b.a.valueOfCode(a().getCode());
    }

    public static synchronized void d() {
        if (f1849b.compareAndSet(false, true)) {
            b.a().d();
        }
    }

    public static void e() {
        try {
            b.a().d();
        } catch (Throwable th) {
            ALog.e(a, "start failed", null, th, new Object[0]);
        }
    }

    public static void f() {
        try {
            b.a().e();
        } catch (Throwable th) {
            ALog.e(a, "stop failed", null, th, new Object[0]);
        }
    }

    public static double b() {
        return b.a().c();
    }

    public static NetworkSpeed a() {
        NetworkSpeed networkSpeed = NetworkSpeed.Fast;
        try {
            return NetworkSpeed.valueOfCode(b.a().b());
        } catch (Throwable th) {
            ALog.e(a, "getNetworkSpeed failed", null, th, new Object[0]);
            return networkSpeed;
        }
    }

    public static void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        a(iNetworkQualityChangeListener, null);
    }

    public static void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        anet.channel.monitor.a.a().a(iNetworkQualityChangeListener, fVar);
    }
}
