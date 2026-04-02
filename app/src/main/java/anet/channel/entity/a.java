package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class a {
    public final IConnStrategy a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f1440b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f1441c = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private String f1442d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f1443e;

    public a(String str, String str2, IConnStrategy iConnStrategy) {
        this.a = iConnStrategy;
        this.f1442d = str;
        this.f1443e = str2;
    }

    public String a() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    public int b() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    public ConnType c() {
        IConnStrategy iConnStrategy = this.a;
        return iConnStrategy != null ? ConnType.valueOf(iConnStrategy.getProtocol()) : ConnType.HTTP;
    }

    public int d() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.a.getConnectionTimeout();
    }

    public int e() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) {
            return 20000;
        }
        return this.a.getReadTimeout();
    }

    public String f() {
        return this.f1442d;
    }

    public int g() {
        IConnStrategy iConnStrategy = this.a;
        if (iConnStrategy != null) {
            return iConnStrategy.getHeartbeat();
        }
        return 45000;
    }

    public String h() {
        return this.f1443e;
    }

    public String toString() {
        return "ConnInfo [ip=" + a() + ",port=" + b() + ",type=" + c() + ",hb" + g() + "]";
    }
}
