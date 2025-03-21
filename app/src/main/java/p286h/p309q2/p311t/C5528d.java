package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5265h0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.d */
/* loaded from: classes2.dex */
final class C5528d extends AbstractC5265h0 {

    /* renamed from: a */
    private int f20364a;

    /* renamed from: b */
    private final double[] f20365b;

    public C5528d(@InterfaceC5816d double[] dArr) {
        C5544i0.m22546f(dArr, "array");
        this.f20365b = dArr;
    }

    @Override // p286h.p289g2.AbstractC5265h0
    /* renamed from: b */
    public double mo19960b() {
        try {
            double[] dArr = this.f20365b;
            int i2 = this.f20364a;
            this.f20364a = i2 + 1;
            return dArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20364a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20364a < this.f20365b.length;
    }
}
