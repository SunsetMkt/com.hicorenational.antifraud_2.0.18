package p251g.p252a.p268y0.p284j;

import java.util.ArrayList;

/* compiled from: LinkedArrayList.java */
/* renamed from: g.a.y0.j.n */
/* loaded from: classes2.dex */
public class C5174n {

    /* renamed from: a */
    final int f20033a;

    /* renamed from: b */
    Object[] f20034b;

    /* renamed from: c */
    Object[] f20035c;

    /* renamed from: d */
    volatile int f20036d;

    /* renamed from: e */
    int f20037e;

    public C5174n(int i2) {
        this.f20033a = i2;
    }

    /* renamed from: a */
    public void m18633a(Object obj) {
        if (this.f20036d == 0) {
            this.f20034b = new Object[this.f20033a + 1];
            Object[] objArr = this.f20034b;
            this.f20035c = objArr;
            objArr[0] = obj;
            this.f20037e = 1;
            this.f20036d = 1;
            return;
        }
        int i2 = this.f20037e;
        int i3 = this.f20033a;
        if (i2 != i3) {
            this.f20035c[i2] = obj;
            this.f20037e = i2 + 1;
            this.f20036d++;
        } else {
            Object[] objArr2 = new Object[i3 + 1];
            objArr2[0] = obj;
            this.f20035c[i3] = objArr2;
            this.f20035c = objArr2;
            this.f20037e = 1;
            this.f20036d++;
        }
    }

    /* renamed from: b */
    public int m18635b() {
        return this.f20036d;
    }

    public String toString() {
        int i2 = this.f20033a;
        int i3 = this.f20036d;
        ArrayList arrayList = new ArrayList(i3 + 1);
        Object[] m18634a = m18634a();
        int i4 = 0;
        while (true) {
            int i5 = 0;
            while (i4 < i3) {
                arrayList.add(m18634a[i5]);
                i4++;
                i5++;
                if (i5 == i2) {
                    break;
                }
            }
            return arrayList.toString();
            m18634a = m18634a[i2];
        }
    }

    /* renamed from: a */
    public Object[] m18634a() {
        return this.f20034b;
    }
}
