package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class a {

    /* renamed from: a, reason: collision with root package name */
    private static volatile a f1804a;

    /* renamed from: b, reason: collision with root package name */
    private Map<INetworkQualityChangeListener, f> f1805b = new ConcurrentHashMap();

    /* renamed from: c, reason: collision with root package name */
    private f f1806c = new f();

    private a() {
    }

    public static a a() {
        if (f1804a == null) {
            synchronized (a.class) {
                if (f1804a == null) {
                    f1804a = new a();
                }
            }
        }
        return f1804a;
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener, f fVar) {
        if (iNetworkQualityChangeListener == null) {
            ALog.e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
            return;
        }
        if (fVar == null) {
            this.f1806c.f1838b = System.currentTimeMillis();
            this.f1805b.put(iNetworkQualityChangeListener, this.f1806c);
        } else {
            fVar.f1838b = System.currentTimeMillis();
            this.f1805b.put(iNetworkQualityChangeListener, fVar);
        }
    }

    public void a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f1805b.remove(iNetworkQualityChangeListener);
    }

    public void a(double d2) {
        boolean a2;
        for (Map.Entry<INetworkQualityChangeListener, f> entry : this.f1805b.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            f value = entry.getValue();
            if (key != null && value != null && !value.b() && value.f1837a != (a2 = value.a(d2))) {
                value.f1837a = a2;
                key.onNetworkQualityChanged(a2 ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }
}
