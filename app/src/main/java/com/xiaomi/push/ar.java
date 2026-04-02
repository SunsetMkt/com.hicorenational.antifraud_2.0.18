package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class ar implements at {
    private final String a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f8756b;

    public ar(String str, String str2) {
        if (str == null) {
            throw new IllegalArgumentException("Name may not be null");
        }
        this.a = str;
        this.f8756b = str2;
    }

    @Override // com.xiaomi.push.at
    public String a() {
        return this.a;
    }

    @Override // com.xiaomi.push.at
    public String b() {
        return this.f8756b;
    }
}
