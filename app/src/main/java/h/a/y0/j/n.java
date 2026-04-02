package h.a.y0.j;

import java.util.ArrayList;

/* JADX INFO: compiled from: LinkedArrayList.java */
/* JADX INFO: loaded from: classes2.dex */
public class n {
    final int a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object[] f12034b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    Object[] f12035c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    volatile int f12036d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    int f12037e;

    public n(int i2) {
        this.a = i2;
    }

    public void a(Object obj) {
        if (this.f12036d == 0) {
            this.f12034b = new Object[this.a + 1];
            Object[] objArr = this.f12034b;
            this.f12035c = objArr;
            objArr[0] = obj;
            this.f12037e = 1;
            this.f12036d = 1;
            return;
        }
        int i2 = this.f12037e;
        int i3 = this.a;
        if (i2 != i3) {
            this.f12035c[i2] = obj;
            this.f12037e = i2 + 1;
            this.f12036d++;
        } else {
            Object[] objArr2 = new Object[i3 + 1];
            objArr2[0] = obj;
            this.f12035c[i3] = objArr2;
            this.f12035c = objArr2;
            this.f12037e = 1;
            this.f12036d++;
        }
    }

    public int b() {
        return this.f12036d;
    }

    public String toString() {
        int i2 = this.a;
        int i3 = this.f12036d;
        ArrayList arrayList = new ArrayList(i3 + 1);
        Object[] objArrA = a();
        int i4 = 0;
        while (true) {
            int i5 = 0;
            while (i4 < i3) {
                arrayList.add(objArrA[i5]);
                i4++;
                i5++;
                if (i5 == i2) {
                    break;
                }
            }
            return arrayList.toString();
            objArrA = objArrA[i2];
        }
    }

    public Object[] a() {
        return this.f12034b;
    }
}
