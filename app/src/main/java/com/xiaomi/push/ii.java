package com.xiaomi.push;

/* JADX INFO: loaded from: classes2.dex */
public class ii extends ik {
    private int a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private hs f906a;

    public ii(int i2) {
        this.f906a = new hs(i2);
    }

    @Override // com.xiaomi.push.ik
    public int a(byte[] bArr, int i2, int i3) {
        byte[] bArrM597a = this.f906a.m597a();
        if (i3 > this.f906a.a() - this.a) {
            i3 = this.f906a.a() - this.a;
        }
        if (i3 > 0) {
            System.arraycopy(bArrM597a, this.a, bArr, i2, i3);
            this.a += i3;
        }
        return i3;
    }

    @Override // com.xiaomi.push.ik
    /* JADX INFO: renamed from: a */
    public void mo620a(byte[] bArr, int i2, int i3) {
        this.f906a.write(bArr, i2, i3);
    }

    public int a() {
        return this.f906a.size();
    }
}
