package anet.channel.strategy;

import android.text.TextUtils;
import anet.channel.strategy.C0842l;
import anet.channel.util.HttpConstant;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public class ConnProtocol implements Serializable {
    private static final long serialVersionUID = -3523201990674557001L;
    final int isHttp;
    public final String name;
    public final String protocol;
    public final String publicKey;
    public final String rtt;
    private static Map<String, ConnProtocol> protocolMap = new HashMap();
    public static final ConnProtocol HTTP = valueOf(HttpConstant.HTTP, null, null);
    public static final ConnProtocol HTTPS = valueOf(HttpConstant.HTTPS, null, null);

    private ConnProtocol(String str, String str2, String str3, String str4) {
        this.name = str;
        this.protocol = str2;
        this.rtt = str3;
        this.publicKey = str4;
        this.isHttp = (HttpConstant.HTTP.equalsIgnoreCase(str2) || HttpConstant.HTTPS.equalsIgnoreCase(str2)) ? 1 : 0;
    }

    private static String buildName(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        StringBuilder sb = new StringBuilder(18);
        sb.append(str);
        if (TextUtils.isEmpty(str2)) {
            sb.append("_0rtt");
        } else {
            sb.append(AbstractC1191a.f2606s1);
            sb.append(str2);
        }
        sb.append(AbstractC1191a.f2606s1);
        sb.append(str3);
        return sb.toString();
    }

    public static ConnProtocol valueOf(C0842l.a aVar) {
        if (aVar == null) {
            return null;
        }
        return valueOf(aVar.f1110b, aVar.f1115g, aVar.f1116h);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ConnProtocol)) {
            return false;
        }
        return this.name.equals(((ConnProtocol) obj).name);
    }

    public int hashCode() {
        int hashCode = 527 + this.protocol.hashCode();
        String str = this.rtt;
        if (str != null) {
            hashCode = (hashCode * 31) + str.hashCode();
        }
        String str2 = this.publicKey;
        return str2 != null ? (hashCode * 31) + str2.hashCode() : hashCode;
    }

    public String toString() {
        return this.name;
    }

    @Deprecated
    public static ConnProtocol valueOf(String str, String str2, String str3, @Deprecated boolean z) {
        return valueOf(str, str2, str3);
    }

    public static ConnProtocol valueOf(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        String buildName = buildName(str, str2, str3);
        synchronized (protocolMap) {
            if (protocolMap.containsKey(buildName)) {
                return protocolMap.get(buildName);
            }
            ConnProtocol connProtocol = new ConnProtocol(buildName, str, str2, str3);
            protocolMap.put(buildName, connProtocol);
            return connProtocol;
        }
    }
}
