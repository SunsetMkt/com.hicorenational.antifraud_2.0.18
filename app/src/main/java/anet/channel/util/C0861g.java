package anet.channel.util;

import android.util.Base64;
import com.xiaomi.mipush.sdk.Constants;
import java.net.InetSocketAddress;
import java.net.Proxy;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.g */
/* loaded from: classes.dex */
public class C0861g {

    /* renamed from: a */
    public static C0861g f1183a;

    /* renamed from: b */
    private final Proxy f1184b;

    /* renamed from: c */
    private final String f1185c;

    /* renamed from: d */
    private final String f1186d;

    public C0861g(String str, int i2, String str2, String str3) {
        this.f1184b = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(str, i2));
        this.f1185c = str2;
        this.f1186d = str3;
    }

    /* renamed from: a */
    public static C0861g m736a() {
        return f1183a;
    }

    /* renamed from: b */
    public Proxy m737b() {
        return this.f1184b;
    }

    /* renamed from: c */
    public String m738c() {
        StringBuilder sb = new StringBuilder(32);
        sb.append(this.f1185c);
        sb.append(Constants.COLON_SEPARATOR);
        sb.append(this.f1186d);
        String encodeToString = Base64.encodeToString(sb.toString().getBytes(), 0);
        StringBuilder sb2 = new StringBuilder(64);
        sb2.append("Basic ");
        sb2.append(encodeToString);
        return sb2.toString();
    }
}
