package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.C0842l;
import java.io.Serializable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
class IPConnStrategy implements IConnStrategy, Serializable {
    public static final int SOURCE_AMDC = 0;
    public static final int SOURCE_CUSTOMIZED = 2;
    public static final int SOURCE_LOCAL_DNS = 1;
    public static final int TYPE_IP_TO_HOST = -1;
    public static final int TYPE_NORMAL = 1;
    public static final int TYPE_STATIC_BANDWITDH = 0;

    /* renamed from: a */
    volatile int f1036a = 1;

    /* renamed from: b */
    volatile int f1037b = 1;

    /* renamed from: c */
    transient boolean f1038c;
    public volatile int cto;
    public volatile int heartbeat;

    /* renamed from: ip */
    public final String f1039ip;
    public final int port;
    public final ConnProtocol protocol;
    public volatile int retry;
    public volatile int rto;

    private IPConnStrategy(String str, int i2, ConnProtocol connProtocol, int i3, int i4, int i5, int i6) {
        this.f1039ip = str;
        this.port = i2;
        this.protocol = connProtocol;
        this.cto = i3;
        this.rto = i4;
        this.retry = i5;
        this.heartbeat = i6;
    }

    /* renamed from: a */
    static IPConnStrategy m632a(String str, C0842l.a aVar) {
        ConnProtocol valueOf = ConnProtocol.valueOf(aVar);
        if (valueOf == null) {
            return null;
        }
        return m631a(str, aVar.f1109a, valueOf, aVar.f1111c, aVar.f1112d, aVar.f1113e, aVar.f1114f);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof IPConnStrategy)) {
            return false;
        }
        IPConnStrategy iPConnStrategy = (IPConnStrategy) obj;
        return this.port == iPConnStrategy.port && this.f1039ip.equals(iPConnStrategy.f1039ip) && this.protocol.equals(iPConnStrategy.protocol);
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getConnectionTimeout() {
        return this.cto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getHeartbeat() {
        return this.heartbeat;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public String getIp() {
        return this.f1039ip;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpSource() {
        return this.f1037b;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getIpType() {
        return this.f1036a;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getPort() {
        return this.port;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public ConnProtocol getProtocol() {
        return this.protocol;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getReadTimeout() {
        return this.rto;
    }

    @Override // anet.channel.strategy.IConnStrategy
    public int getRetryTimes() {
        return this.retry;
    }

    public int getUniqueId() {
        return hashCode();
    }

    public int hashCode() {
        return ((((527 + this.f1039ip.hashCode()) * 31) + this.port) * 31) + this.protocol.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(32);
        sb.append('{');
        sb.append(this.f1039ip);
        if (this.f1036a == 0) {
            sb.append("(*)");
        }
        sb.append(' ');
        sb.append(this.port);
        sb.append(' ');
        sb.append(this.protocol);
        sb.append('}');
        return sb.toString();
    }

    /* renamed from: a */
    static IPConnStrategy m631a(String str, int i2, ConnProtocol connProtocol, int i3, int i4, int i5, int i6) {
        if (TextUtils.isEmpty(str) || connProtocol == null || i2 <= 0) {
            return null;
        }
        return new IPConnStrategy(str, i2, connProtocol, i3, i4, i5, i6);
    }
}
