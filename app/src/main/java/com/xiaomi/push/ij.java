package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public final class ij extends ik {
    private int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private byte[] f907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f9327b;

    public void a(byte[] bArr) {
        b(bArr, 0, bArr.length);
    }

    @Override // com.xiaomi.push.ik
    public int a_() {
        return this.a;
    }

    public void b(byte[] bArr, int i2, int i3) {
        this.f907a = bArr;
        this.a = i2;
        this.f9327b = i2 + i3;
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i2, int i3) {
        int iB = b();
        if (i3 > iB) {
            i3 = iB;
        }
        if (i3 > 0) {
            System.arraycopy(this.f907a, this.a, bArr, i2, i3);
            a(i3);
        }
        return i3;
    }

    @Override // com.xiaomi.push.ik
    public int b() {
        return this.f9327b - this.a;
    }

    @Override // com.xiaomi.push.ik
    /* JADX INFO: renamed from: a */
    public void mo620a(byte[] bArr, int i2, int i3) {
        throw new UnsupportedOperationException("No writing allowed!");
    }

    @Override // com.xiaomi.push.ik
    public byte[] a() {
        return this.f907a;
    }

    @Override // com.xiaomi.push.ik
    public void a(int i2) {
        this.a += i2;
    }
}
