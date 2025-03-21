package anet.channel.monitor;

import anet.channel.util.ALog;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* compiled from: Taobao */
/* renamed from: anet.channel.monitor.a */
/* loaded from: classes.dex */
public class C0795a {

    /* renamed from: a */
    private static volatile C0795a f878a;

    /* renamed from: b */
    private Map<INetworkQualityChangeListener, C0800f> f879b = new ConcurrentHashMap();

    /* renamed from: c */
    private C0800f f880c = new C0800f();

    private C0795a() {
    }

    /* renamed from: a */
    public static C0795a m521a() {
        if (f878a == null) {
            synchronized (C0795a.class) {
                if (f878a == null) {
                    f878a = new C0795a();
                }
            }
        }
        return f878a;
    }

    /* renamed from: a */
    public void m524a(INetworkQualityChangeListener iNetworkQualityChangeListener, C0800f c0800f) {
        if (iNetworkQualityChangeListener == null) {
            ALog.m715e("BandWidthListenerHelp", "listener is null", null, new Object[0]);
            return;
        }
        if (c0800f == null) {
            this.f880c.f913b = System.currentTimeMillis();
            this.f879b.put(iNetworkQualityChangeListener, this.f880c);
        } else {
            c0800f.f913b = System.currentTimeMillis();
            this.f879b.put(iNetworkQualityChangeListener, c0800f);
        }
    }

    /* renamed from: a */
    public void m523a(INetworkQualityChangeListener iNetworkQualityChangeListener) {
        this.f879b.remove(iNetworkQualityChangeListener);
    }

    /* renamed from: a */
    public void m522a(double d2) {
        boolean m539a;
        for (Map.Entry<INetworkQualityChangeListener, C0800f> entry : this.f879b.entrySet()) {
            INetworkQualityChangeListener key = entry.getKey();
            C0800f value = entry.getValue();
            if (key != null && value != null && !value.m540b() && value.f912a != (m539a = value.m539a(d2))) {
                value.f912a = m539a;
                key.onNetworkQualityChanged(m539a ? NetworkSpeed.Slow : NetworkSpeed.Fast);
            }
        }
    }
}
