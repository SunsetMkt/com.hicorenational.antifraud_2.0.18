package anetwork.channel.entity;

import p000a.p001a.InterfaceC0000a;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.a */
/* loaded from: classes.dex */
public class C0889a implements InterfaceC0000a {

    /* renamed from: a */
    private final String f1321a;

    /* renamed from: b */
    private final String f1322b;

    public C0889a(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f1321a = str;
        this.f1322b = str2;
    }

    @Override // p000a.p001a.InterfaceC0000a
    public String getName() {
        return this.f1321a;
    }

    @Override // p000a.p001a.InterfaceC0000a
    public String getValue() {
        return this.f1322b;
    }
}
