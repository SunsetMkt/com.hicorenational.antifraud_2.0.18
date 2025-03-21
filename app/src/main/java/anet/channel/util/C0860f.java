package anet.channel.util;

import java.net.Inet6Address;

/* compiled from: Taobao */
/* renamed from: anet.channel.util.f */
/* loaded from: classes.dex */
public class C0860f {

    /* renamed from: a */
    public int f1181a;

    /* renamed from: b */
    public Inet6Address f1182b;

    public C0860f(Inet6Address inet6Address, int i2) {
        this.f1181a = i2;
        this.f1182b = inet6Address;
    }

    public String toString() {
        return this.f1182b.getHostAddress() + "/" + this.f1181a;
    }
}
