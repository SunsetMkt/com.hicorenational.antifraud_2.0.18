package com.umeng.analytics.pro;

import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: ShortStack.java */
/* renamed from: com.umeng.analytics.pro.bo */
/* loaded from: classes2.dex */
public class C3358bo {

    /* renamed from: a */
    private short[] f11742a;

    /* renamed from: b */
    private int f11743b = -1;

    public C3358bo(int i2) {
        this.f11742a = new short[i2];
    }

    /* renamed from: d */
    private void m11025d() {
        short[] sArr = this.f11742a;
        short[] sArr2 = new short[sArr.length * 2];
        System.arraycopy(sArr, 0, sArr2, 0, sArr.length);
        this.f11742a = sArr2;
    }

    /* renamed from: a */
    public short m11026a() {
        short[] sArr = this.f11742a;
        int i2 = this.f11743b;
        this.f11743b = i2 - 1;
        return sArr[i2];
    }

    /* renamed from: b */
    public short m11028b() {
        return this.f11742a[this.f11743b];
    }

    /* renamed from: c */
    public void m11029c() {
        this.f11743b = -1;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<ShortStack vector:[");
        for (int i2 = 0; i2 < this.f11742a.length; i2++) {
            if (i2 != 0) {
                sb.append(AbstractC1191a.f2568g);
            }
            if (i2 == this.f11743b) {
                sb.append(">>");
            }
            sb.append((int) this.f11742a[i2]);
            if (i2 == this.f11743b) {
                sb.append("<<");
            }
        }
        sb.append("]>");
        return sb.toString();
    }

    /* renamed from: a */
    public void m11027a(short s) {
        if (this.f11742a.length == this.f11743b + 1) {
            m11025d();
        }
        short[] sArr = this.f11742a;
        int i2 = this.f11743b + 1;
        this.f11743b = i2;
        sArr[i2] = s;
    }
}
