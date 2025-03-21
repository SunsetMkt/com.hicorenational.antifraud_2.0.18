package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* renamed from: com.xiaomi.push.av */
/* loaded from: classes2.dex */
public class C4093av {

    /* renamed from: a */
    private final NetworkInfo f14580a;

    /* renamed from: a */
    private final ConcurrentHashMap<String, Object> f14581a = new ConcurrentHashMap<>();

    public C4093av(NetworkInfo networkInfo) {
        this.f14580a = networkInfo;
    }

    /* renamed from: a */
    private <T> T m13810a(String str) {
        Object obj;
        if (!this.f14581a.containsKey(str)) {
            synchronized (str) {
                if (!this.f14581a.contains(str)) {
                    obj = null;
                    switch (str) {
                        case "getType":
                            obj = Integer.valueOf(this.f14580a.getType());
                            break;
                        case "getTypeName":
                            obj = this.f14580a.getTypeName();
                            break;
                        case "getSubtype":
                            obj = Integer.valueOf(this.f14580a.getSubtype());
                            break;
                        case "getSubtypeName":
                            obj = this.f14580a.getSubtypeName();
                            break;
                        case "isConnected":
                            obj = Boolean.valueOf(this.f14580a.isConnected());
                            break;
                        case "getState":
                            obj = this.f14580a.getState();
                            break;
                        case "getDetailedState":
                            obj = this.f14580a.getDetailedState();
                            break;
                    }
                    if (obj != null) {
                        this.f14581a.put(str, obj);
                    }
                }
            }
        }
        return (T) this.f14581a.get(str);
    }

    /* renamed from: b */
    public int m13816b() {
        return ((Integer) m13810a("getSubtype")).intValue();
    }

    /* renamed from: b */
    public String m13817b() {
        return (String) m13810a("getSubtypeName");
    }

    /* renamed from: a */
    public int m13811a() {
        return ((Integer) m13810a("getType")).intValue();
    }

    /* renamed from: a */
    public String m13814a() {
        return (String) m13810a("getTypeName");
    }

    /* renamed from: a */
    public boolean m13815a() {
        return ((Boolean) m13810a("isConnected")).booleanValue();
    }

    /* renamed from: a */
    public NetworkInfo.State m13813a() {
        return (NetworkInfo.State) m13810a("getState");
    }

    /* renamed from: a */
    public NetworkInfo.DetailedState m13812a() {
        return (NetworkInfo.DetailedState) m13810a("getDetailedState");
    }
}
