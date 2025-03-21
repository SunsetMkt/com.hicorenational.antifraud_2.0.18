package anet.channel.security;

/* compiled from: Taobao */
/* renamed from: anet.channel.security.c */
/* loaded from: classes.dex */
public class C0807c {

    /* renamed from: a */
    private static volatile ISecurityFactory f962a;

    /* renamed from: a */
    public static ISecurityFactory m581a() {
        if (f962a == null) {
            f962a = new C0808d();
        }
        return f962a;
    }
}
