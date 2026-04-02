package com.tencent.bugly.proguard;

/* JADX INFO: compiled from: BUGLY */
/* JADX INFO: loaded from: classes2.dex */
public final class be extends m implements Cloneable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static byte[] f6448d;
    public byte a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public String f6449b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public byte[] f6450c;

    public be() {
        this.a = (byte) 0;
        this.f6449b = "";
        this.f6450c = null;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(l lVar) {
        lVar.b(this.a, 0);
        lVar.a(this.f6449b, 1);
        byte[] bArr = this.f6450c;
        if (bArr != null) {
            lVar.a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(StringBuilder sb, int i2) {
    }

    public be(byte b2, String str, byte[] bArr) {
        this.a = (byte) 0;
        this.f6449b = "";
        this.f6450c = null;
        this.a = b2;
        this.f6449b = str;
        this.f6450c = bArr;
    }

    @Override // com.tencent.bugly.proguard.m
    public void a(k kVar) {
        this.a = kVar.a(this.a, 0, true);
        this.f6449b = kVar.a(1, true);
        if (f6448d == null) {
            f6448d = new byte[1];
            f6448d[0] = 0;
        }
        this.f6450c = kVar.a(f6448d, 2, false);
    }
}
