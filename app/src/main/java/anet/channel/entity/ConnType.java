package anet.channel.entity;

import android.text.TextUtils;
import anet.channel.GlobalAppRuntimeInfo;
import anet.channel.strategy.ConnProtocol;
import anet.channel.util.HttpConstant;
import java.util.HashMap;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConnType {
    public static final String H2S = "h2s";
    public static final String HTTP2 = "http2";
    public static final String HTTP3 = "http3";
    public static final String HTTP3_1RTT = "http3_1rtt";
    public static final String HTTP3_PLAIN = "http3plain";
    public static final String PK_ACS = "acs";
    public static final String PK_AUTO = "auto";
    public static final String PK_CDN = "cdn";
    public static final String PK_OPEN = "open";
    public static final String QUIC = "quic";
    public static final String QUIC_PLAIN = "quicplain";
    public static final String RTT_0 = "0rtt";
    public static final String RTT_1 = "1rtt";
    public static final String SPDY = "spdy";
    private String name;
    private String publicKey;
    private int spdyProtocol;
    public static ConnType HTTP = new ConnType(HttpConstant.HTTP);
    public static ConnType HTTPS = new ConnType(HttpConstant.HTTPS);
    private static Map<ConnProtocol, ConnType> connTypeMap = new HashMap();

    /* compiled from: Taobao */
    @Deprecated
    public enum TypeLevel {
        SPDY,
        HTTP
    }

    private ConnType(String str) {
        this.name = "";
        this.name = str;
    }

    public static int compare(ConnType connType, ConnType connType2) {
        return connType.getPriority() - connType2.getPriority();
    }

    private int getPriority() {
        int i2 = this.spdyProtocol;
        if ((i2 & 8) != 0) {
            return 0;
        }
        return (i2 & 2) != 0 ? 1 : 2;
    }

    public static ConnType valueOf(ConnProtocol connProtocol) {
        if (connProtocol == null) {
            return null;
        }
        if (HttpConstant.HTTP.equalsIgnoreCase(connProtocol.protocol)) {
            return HTTP;
        }
        if (HttpConstant.HTTPS.equalsIgnoreCase(connProtocol.protocol)) {
            return HTTPS;
        }
        synchronized (connTypeMap) {
            if (connTypeMap.containsKey(connProtocol)) {
                return connTypeMap.get(connProtocol);
            }
            ConnType connType = new ConnType(connProtocol.toString());
            connType.publicKey = connProtocol.publicKey;
            if (HTTP2.equalsIgnoreCase(connProtocol.protocol)) {
                connType.spdyProtocol |= 8;
            } else if (SPDY.equalsIgnoreCase(connProtocol.protocol)) {
                connType.spdyProtocol |= 2;
            } else if (H2S.equals(connProtocol.protocol)) {
                connType.spdyProtocol = 40;
            } else if (QUIC.equalsIgnoreCase(connProtocol.protocol)) {
                connType.spdyProtocol = 12;
            } else if (QUIC_PLAIN.equalsIgnoreCase(connProtocol.protocol)) {
                connType.spdyProtocol = 32780;
            } else if (HTTP3.equalsIgnoreCase(connProtocol.protocol)) {
                connType.spdyProtocol = 256;
            } else if (HTTP3_1RTT.equalsIgnoreCase(connProtocol.protocol)) {
                connType.spdyProtocol = 8448;
            } else if (HTTP3_PLAIN.equalsIgnoreCase(connProtocol.protocol)) {
                connType.spdyProtocol = 33024;
            }
            if (connType.spdyProtocol == 0) {
                return null;
            }
            if (!TextUtils.isEmpty(connProtocol.publicKey)) {
                connType.spdyProtocol |= 128;
                if (RTT_1.equalsIgnoreCase(connProtocol.rtt)) {
                    connType.spdyProtocol |= 8192;
                } else {
                    if (!RTT_0.equalsIgnoreCase(connProtocol.rtt)) {
                        return null;
                    }
                    connType.spdyProtocol |= 4096;
                }
            }
            connTypeMap.put(connProtocol, connType);
            return connType;
        }
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof ConnType)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        return this.name.equals(((ConnType) obj).name);
    }

    public int getTnetConType() {
        return this.spdyProtocol;
    }

    public int getTnetPublicKey(boolean z) {
        if (PK_CDN.equals(this.publicKey)) {
            return 1;
        }
        if (GlobalAppRuntimeInfo.getEnv() == ENV.TEST) {
            return 0;
        }
        if (PK_OPEN.equals(this.publicKey)) {
            return z ? 11 : 10;
        }
        if (PK_ACS.equals(this.publicKey)) {
            return z ? 4 : 3;
        }
        return -1;
    }

    public int getType() {
        return (equals(HTTP) || equals(HTTPS)) ? C0783c.f844b : C0783c.f843a;
    }

    @Deprecated
    public TypeLevel getTypeLevel() {
        return isHttpType() ? TypeLevel.HTTP : TypeLevel.SPDY;
    }

    public boolean isH2S() {
        return this.spdyProtocol == 40;
    }

    public boolean isHTTP3() {
        int i2 = this.spdyProtocol;
        return i2 == 256 || i2 == 8448 || i2 == 33024;
    }

    public boolean isHttpType() {
        return equals(HTTP) || equals(HTTPS);
    }

    public boolean isPublicKeyAuto() {
        return PK_AUTO.equals(this.publicKey);
    }

    public boolean isQuic() {
        return (this.spdyProtocol & 4) != 0;
    }

    public boolean isSSL() {
        int i2 = this.spdyProtocol;
        return (i2 & 128) != 0 || (i2 & 32) != 0 || i2 == 12 || i2 == 256 || i2 == 8448 || equals(HTTPS);
    }

    public String toString() {
        return this.name;
    }
}
