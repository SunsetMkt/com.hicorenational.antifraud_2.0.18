package anet.channel.util;

import java.net.Inet6Address;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class f {
    public int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Inet6Address f1655b;

    public f(Inet6Address inet6Address, int i2) {
        this.a = i2;
        this.f1655b = inet6Address;
    }

    public String toString() {
        return this.f1655b.getHostAddress() + "/" + this.a;
    }
}
