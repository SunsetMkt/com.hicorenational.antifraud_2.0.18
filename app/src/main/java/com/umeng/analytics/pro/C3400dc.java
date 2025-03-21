package com.umeng.analytics.pro;

/* compiled from: TMemoryInputTransport.java */
/* renamed from: com.umeng.analytics.pro.dc */
/* loaded from: classes2.dex */
public final class C3400dc extends AbstractC3401dd {

    /* renamed from: a */
    private byte[] f11963a;

    /* renamed from: b */
    private int f11964b;

    /* renamed from: c */
    private int f11965c;

    public C3400dc() {
    }

    /* renamed from: a */
    public void m11196a(byte[] bArr) {
        m11197c(bArr, 0, bArr.length);
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: a */
    public boolean mo11190a() {
        return true;
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: b */
    public void mo11191b() throws C3402de {
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: b */
    public void mo11192b(byte[] bArr, int i2, int i3) throws C3402de {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: c */
    public void mo11193c() {
    }

    /* renamed from: c */
    public void m11197c(byte[] bArr, int i2, int i3) {
        this.f11963a = bArr;
        this.f11964b = i2;
        this.f11965c = i2 + i3;
    }

    /* renamed from: e */
    public void m11198e() {
        this.f11963a = null;
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: f */
    public byte[] mo11199f() {
        return this.f11963a;
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: g */
    public int mo11200g() {
        return this.f11964b;
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: h */
    public int mo11201h() {
        return this.f11965c - this.f11964b;
    }

    public C3400dc(byte[] bArr) {
        m11196a(bArr);
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: a */
    public int mo11189a(byte[] bArr, int i2, int i3) throws C3402de {
        int mo11201h = mo11201h();
        if (i3 > mo11201h) {
            i3 = mo11201h;
        }
        if (i3 > 0) {
            System.arraycopy(this.f11963a, this.f11964b, bArr, i2, i3);
            mo11195a(i3);
        }
        return i3;
    }

    public C3400dc(byte[] bArr, int i2, int i3) {
        m11197c(bArr, i2, i3);
    }

    @Override // com.umeng.analytics.pro.AbstractC3401dd
    /* renamed from: a */
    public void mo11195a(int i2) {
        this.f11964b += i2;
    }
}
