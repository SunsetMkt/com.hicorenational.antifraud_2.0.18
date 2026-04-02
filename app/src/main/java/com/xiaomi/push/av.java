package com.xiaomi.push;

import android.net.NetworkInfo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes2.dex */
public class av {
    private final NetworkInfo a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private final ConcurrentHashMap<String, Object> f199a = new ConcurrentHashMap<>();

    public av(NetworkInfo networkInfo) {
        this.a = networkInfo;
    }

    private <T> T a(String str) {
        Object objValueOf;
        if (!this.f199a.containsKey(str)) {
            synchronized (str) {
                if (!this.f199a.contains(str)) {
                    objValueOf = null;
                    switch (str) {
                        case "getType":
                            objValueOf = Integer.valueOf(this.a.getType());
                            break;
                        case "getTypeName":
                            objValueOf = this.a.getTypeName();
                            break;
                        case "getSubtype":
                            objValueOf = Integer.valueOf(this.a.getSubtype());
                            break;
                        case "getSubtypeName":
                            objValueOf = this.a.getSubtypeName();
                            break;
                        case "isConnected":
                            objValueOf = Boolean.valueOf(this.a.isConnected());
                            break;
                        case "getState":
                            objValueOf = this.a.getState();
                            break;
                        case "getDetailedState":
                            objValueOf = this.a.getDetailedState();
                            break;
                    }
                    if (objValueOf != null) {
                        this.f199a.put(str, objValueOf);
                    }
                }
            }
        }
        return (T) this.f199a.get(str);
    }

    public int b() {
        return ((Integer) a("getSubtype")).intValue();
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public String m154b() {
        return (String) a("getSubtypeName");
    }

    public int a() {
        return ((Integer) a("getType")).intValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public String m152a() {
        return (String) a("getTypeName");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public boolean m153a() {
        return ((Boolean) a("isConnected")).booleanValue();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.State m151a() {
        return (NetworkInfo.State) a("getState");
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public NetworkInfo.DetailedState m150a() {
        return (NetworkInfo.DetailedState) a("getDetailedState");
    }
}
