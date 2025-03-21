package anet.channel.security;

/* compiled from: Taobao */
/* renamed from: anet.channel.security.d */
/* loaded from: classes.dex */
final class C0808d implements ISecurityFactory {
    C0808d() {
    }

    @Override // anet.channel.security.ISecurityFactory
    public ISecurity createNonSecurity(String str) {
        return new C0805a(str);
    }

    @Override // anet.channel.security.ISecurityFactory
    public ISecurity createSecurity(String str) {
        return new C0806b(str);
    }
}
