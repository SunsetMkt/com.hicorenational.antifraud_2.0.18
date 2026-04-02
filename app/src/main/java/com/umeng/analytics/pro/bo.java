package com.umeng.analytics.pro;

/* JADX INFO: compiled from: ShortStack.java */
/* JADX INFO: loaded from: classes2.dex */
public class bo {
    private short[] a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f7111b = -1;

    public bo(int i2) {
        this.a = new short[i2];
    }

    private void d() {
        short[] sArr = this.a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.a = sArr2;
    }

    public short a() {
        short[] sArr = this.a;
        int i2 = this.f7111b;
        this.f7111b = i2 - 1;
        return sArr[i2];
    }

    public short b() {
        return this.a[this.f7111b];
    }

    public void c() {
        this.f7111b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i2 = 0; i2 < this.a.length; i2++) {
            if (i2 != 0) {
                sb.append(d.c.a.b.a.a.f10074g);
            }
            if (i2 == this.f7111b) {
                sb.append(">>");
            }
            sb.append((int) this.a[i2]);
            if (i2 == this.f7111b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    public void a(short s) {
        if (this.a.length == this.f7111b + 1) {
            d();
        }
        short[] sArr = this.a;
        int i2 = this.f7111b + 1;
        this.f7111b = i2;
        sArr[i2] = s;
    }
}
