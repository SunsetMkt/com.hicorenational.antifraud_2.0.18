package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ij */
/* loaded from: classes2.dex */
public final class C4297ij extends AbstractC4298ik {

    /* renamed from: a */
    private int f16363a;

    /* renamed from: a */
    private byte[] f16364a;

    /* renamed from: b */
    private int f16365b;

    /* renamed from: a */
    public void m15666a(byte[] bArr) {
        m15670b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a_ */
    public int mo15668a_() {
        return this.f16363a;
    }

    /* renamed from: b */
    public void m15670b(byte[] bArr, int i2, int i3) {
        this.f16364a = bArr;
        this.f16363a = i2;
        this.f16365b = i2 + i3;
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public int mo15662a(byte[] bArr, int i2, int i3) {
        int mo15669b = mo15669b();
        if (i3 > mo15669b) {
            i3 = mo15669b;
        }
        if (i3 > 0) {
            System.arraycopy(this.f16364a, this.f16363a, bArr, i2, i3);
            mo15665a(i3);
        }
        return i3;
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: b */
    public int mo15669b() {
        return this.f16365b - this.f16363a;
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public void mo15663a(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public byte[] mo15667a() {
        return this.f16364a;
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public void mo15665a(int i2) {
        this.f16363a += i2;
    }
}
