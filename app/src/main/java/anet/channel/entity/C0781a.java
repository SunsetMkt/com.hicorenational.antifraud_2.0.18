package anet.channel.entity;

import anet.channel.strategy.IConnStrategy;

/* compiled from: Taobao */
/* renamed from: anet.channel.entity.a */
/* loaded from: classes.dex */
public class C0781a {

    /* renamed from: a */
    public final IConnStrategy f835a;

    /* renamed from: b */
    public int f836b = 0;

    /* renamed from: c */
    public int f837c = 0;

    /* renamed from: d */
    private String f838d;

    /* renamed from: e */
    private String f839e;

    public C0781a(String str, String str2, IConnStrategy iConnStrategy) {
        this.f835a = iConnStrategy;
        this.f838d = str;
        this.f839e = str2;
    }

    /* renamed from: a */
    public String m508a() {
        IConnStrategy iConnStrategy = this.f835a;
        if (iConnStrategy != null) {
            return iConnStrategy.getIp();
        }
        return null;
    }

    /* renamed from: b */
    public int m509b() {
        IConnStrategy iConnStrategy = this.f835a;
        if (iConnStrategy != null) {
            return iConnStrategy.getPort();
        }
        return 0;
    }

    /* renamed from: c */
    public ConnType m510c() {
        IConnStrategy iConnStrategy = this.f835a;
        return iConnStrategy != null ? ConnType.valueOf(iConnStrategy.getProtocol()) : ConnType.HTTP;
    }

    /* renamed from: d */
    public int m511d() {
        IConnStrategy iConnStrategy = this.f835a;
        if (iConnStrategy == null || iConnStrategy.getConnectionTimeout() == 0) {
            return 20000;
        }
        return this.f835a.getConnectionTimeout();
    }

    /* renamed from: e */
    public int m512e() {
        IConnStrategy iConnStrategy = this.f835a;
        if (iConnStrategy == null || iConnStrategy.getReadTimeout() == 0) {
            return 20000;
        }
        return this.f835a.getReadTimeout();
    }

    /* renamed from: f */
    public String m513f() {
        return this.f838d;
    }

    /* renamed from: g */
    public int m514g() {
        IConnStrategy iConnStrategy = this.f835a;
        if (iConnStrategy != null) {
            return iConnStrategy.getHeartbeat();
        }
        return 45000;
    }

    /* renamed from: h */
    public String m515h() {
        return this.f839e;
    }

    public String toString() {
        return "ConnInfo [ip=" + m508a() + ",port=" + m509b() + ",type=" + m510c() + ",hb" + m514g() + "]";
    }
}
