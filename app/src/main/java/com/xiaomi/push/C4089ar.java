package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ar */
/* loaded from: classes2.dex */
public class C4089ar implements InterfaceC4091at {

    /* renamed from: a */
    private final String f14567a;

    /* renamed from: b */
    private final String f14568b;

    public C4089ar(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.f14567a = str;
        this.f14568b = str2;
    }

    @Override // com.xiaomi.push.InterfaceC4091at
    /* renamed from: a */
    public String mo13777a() {
        return this.f14567a;
    }

    @Override // com.xiaomi.push.InterfaceC4091at
    /* renamed from: b */
    public String mo13778b() {
        return this.f14568b;
    }
}
