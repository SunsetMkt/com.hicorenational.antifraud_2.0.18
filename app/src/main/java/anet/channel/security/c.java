package anet.channel.security;

/* JADX INFO: compiled from: Taobao */
/* JADX INFO: loaded from: classes.dex */
public class c {
    private static volatile ISecurityFactory a;

    public static ISecurityFactory a() {
        if (a == null) {
            a = new d();
        }
        return a;
    }
}
