package p000a.p001a.p009q;

import android.content.Context;
import anet.channel.monitor.C0795a;
import anet.channel.monitor.C0796b;
import anet.channel.monitor.C0800f;
import anet.channel.monitor.INetworkQualityChangeListener;
import anet.channel.monitor.NetworkSpeed;
import anet.channel.util.ALog;
import java.util.concurrent.atomic.AtomicBoolean;
import p000a.p001a.p009q.p010b.EnumC0030a;

/* compiled from: Taobao */
/* renamed from: a.a.q.a */
/* loaded from: classes.dex */
public class C0029a {

    /* renamed from: a */
    private static final String f77a = "anet.Monitor";

    /* renamed from: b */
    static AtomicBoolean f78b = new AtomicBoolean(false);

    @Deprecated
    /* renamed from: a */
    public static synchronized void m160a(Context context) {
        synchronized (C0029a.class) {
            m166d();
        }
    }

    /* renamed from: b */
    public static void m164b(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        C0795a.m521a().m523a(iNetworkQualityChangeListener);
    }

    @Deprecated
    /* renamed from: c */
    public static EnumC0030a m165c() {
        return EnumC0030a.valueOfCode(m159a().getCode());
    }

    /* renamed from: d */
    public static synchronized void m166d() {
        synchronized (C0029a.class) {
            if (f78b.compareAndSet(false, true)) {
                C0796b.m526a().m534d();
            }
        }
    }

    /* renamed from: e */
    public static void m167e() {
        try {
            C0796b.m526a().m534d();
        } catch (Throwable th) {
            ALog.m714e(f77a, "start failed", null, th, new Object[0]);
        }
    }

    /* renamed from: f */
    public static void m168f() {
        try {
            C0796b.m526a().m535e();
        } catch (Throwable th) {
            ALog.m714e(f77a, "stop failed", null, th, new Object[0]);
        }
    }

    /* renamed from: b */
    public static double m163b() {
        return C0796b.m526a().m533c();
    }

    /* renamed from: a */
    public static NetworkSpeed m159a() {
        NetworkSpeed networkSpeed = NetworkSpeed.Fast;
        try {
            return NetworkSpeed.valueOfCode(C0796b.m526a().m532b());
        } catch (Throwable th) {
            ALog.m714e(f77a, "getNetworkSpeed failed", null, th, new Object[0]);
            return networkSpeed;
        }
    }

    /* renamed from: a */
    public static void m161a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        m162a(iNetworkQualityChangeListener, null);
    }

    /* renamed from: a */
    public static void m162a(INetworkQualityChangeListener iNetworkQualityChangeListener, C0800f c0800f) {
        C0795a.m521a().m524a(iNetworkQualityChangeListener, c0800f);
    }
}
