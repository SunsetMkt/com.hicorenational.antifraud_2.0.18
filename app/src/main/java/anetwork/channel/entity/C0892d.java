package anetwork.channel.entity;

import p000a.p001a.InterfaceC0006g;

/* compiled from: Taobao */
/* renamed from: anetwork.channel.entity.d */
/* loaded from: classes.dex */
public class C0892d implements InterfaceC0006g {

    /* renamed from: a */
    private String f1338a;

    /* renamed from: b */
    private String f1339b;

    public C0892d(String str, String str2) {
        this.f1338a = str;
        this.f1339b = str2;
    }

    @Override // p000a.p001a.InterfaceC0006g
    public String getKey() {
        return this.f1338a;
    }

    @Override // p000a.p001a.InterfaceC0006g
    public String getValue() {
        return this.f1339b;
    }
}
