package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5280m0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.e */
/* loaded from: classes2.dex */
final class C5531e extends AbstractC5280m0 {

    /* renamed from: a */
    private int f20366a;

    /* renamed from: b */
    private final float[] f20367b;

    public C5531e(@InterfaceC5816d float[] fArr) {
        C5544i0.m22546f(fArr, "array");
        this.f20367b = fArr;
    }

    @Override // p286h.p289g2.AbstractC5280m0
    /* renamed from: b */
    public float mo20015b() {
        try {
            float[] fArr = this.f20367b;
            int i2 = this.f20366a;
            this.f20366a = i2 + 1;
            return fArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20366a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20366a < this.f20367b.length;
    }
}
