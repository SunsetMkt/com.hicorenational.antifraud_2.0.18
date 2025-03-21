package com.tencent.bugly.proguard;

/* compiled from: BUGLY */
/* renamed from: com.tencent.bugly.proguard.be */
/* loaded from: classes2.dex */
public final class C3169be extends AbstractC3188m implements Cloneable {

    /* renamed from: d */
    static byte[] f10624d;

    /* renamed from: a */
    public byte f10625a;

    /* renamed from: b */
    public String f10626b;

    /* renamed from: c */
    public byte[] f10627c;

    public C3169be() {
        this.f10625a = (byte) 0;
        this.f10626b = "";
        this.f10627c = null;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9794a(C3187l c3187l) {
        c3187l.m10118b(this.f10625a, 0);
        c3187l.m10106a(this.f10626b, 1);
        byte[] bArr = this.f10627c;
        if (bArr != null) {
            c3187l.m10111a(bArr, 2);
        }
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9795a(StringBuilder sb, int i2) {
    }

    public C3169be(byte b2, String str, byte[] bArr) {
        this.f10625a = (byte) 0;
        this.f10626b = "";
        this.f10627c = null;
        this.f10625a = b2;
        this.f10626b = str;
        this.f10627c = bArr;
    }

    @Override // com.tencent.bugly.proguard.AbstractC3188m
    /* renamed from: a */
    public void mo9793a(C3186k c3186k) {
        this.f10625a = c3186k.m10070a(this.f10625a, 0, true);
        this.f10626b = c3186k.m10078a(1, true);
        if (f10624d == null) {
            f10624d = new byte[1];
            f10624d[0] = 0;
        }
        this.f10627c = c3186k.m10087a(f10624d, 2, false);
    }
}
