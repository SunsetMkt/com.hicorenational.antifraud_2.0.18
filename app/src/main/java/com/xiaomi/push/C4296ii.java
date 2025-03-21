package com.xiaomi.push;

/* renamed from: com.xiaomi.push.ii */
/* loaded from: classes2.dex */
public class C4296ii extends AbstractC4298ik {

    /* renamed from: a */
    private int f16361a;

    /* renamed from: a */
    private C4279hs f16362a;

    public C4296ii(int i2) {
        this.f16362a = new C4279hs(i2);
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public int mo15662a(byte[] bArr, int i2, int i3) {
        byte[] m15586a = this.f16362a.m15586a();
        if (i3 > this.f16362a.m15585a() - this.f16361a) {
            i3 = this.f16362a.m15585a() - this.f16361a;
        }
        if (i3 > 0) {
            System.arraycopy(m15586a, this.f16361a, bArr, i2, i3);
            this.f16361a += i3;
        }
        return i3;
    }

    @Override // com.xiaomi.push.AbstractC4298ik
    /* renamed from: a */
    public void mo15663a(byte[] bArr, int i2, int i3) {
        this.f16362a.write(bArr, i2, i3);
    }

    /* renamed from: a */
    public int m15664a() {
        return this.f16362a.size();
    }
}
