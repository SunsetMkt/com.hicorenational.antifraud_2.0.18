package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class bc extends m implements Cloneable {
    public String a = "";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6442b = "";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f6443c = "";

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f6444d = "";

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f6445e = "";

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.a(this.a, 0);
        String str = this.f6442b;
        if (str != null) {
            lVar.a(str, 1);
        }
        String str2 = this.f6443c;
        if (str2 != null) {
            lVar.a(str2, 2);
        }
        String str3 = this.f6444d;
        if (str3 != null) {
            lVar.a(str3, 3);
        }
        String str4 = this.f6445e;
        if (str4 != null) {
            lVar.a(str4, 4);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(0, true);
        this.f6442b = kVar.a(1, false);
        this.f6443c = kVar.a(2, false);
        this.f6444d = kVar.a(3, false);
        this.f6445e = kVar.a(4, false);
    }
}
