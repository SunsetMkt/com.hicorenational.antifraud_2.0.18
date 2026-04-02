package anet.channel.util;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class g {
    public static g a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Proxy f1656b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f1657c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final String f1658d;

    public g(String str, int i2, String str2, String str3) {
        this.f1656b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        this.f1657c = str2;
        this.f1658d = str3;
    }

    public static g a() {
        return a;
    }

    public Proxy b() {
        return this.f1656b;
    }

    public String c() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f1657c);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f1658d);
        String strEncodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Basic ");
        sb2.append(strEncodeToString);
        return sb2.toString();
    }
}
