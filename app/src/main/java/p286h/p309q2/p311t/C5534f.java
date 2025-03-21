package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5304u0;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.f */
/* loaded from: classes2.dex */
final class C5534f extends AbstractC5304u0 {

    /* renamed from: a */
    private int f20368a;

    /* renamed from: b */
    private final int[] f20369b;

    public C5534f(@InterfaceC5816d int[] iArr) {
        C5544i0.m22546f(iArr, "array");
        this.f20369b = iArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20368a < this.f20369b.length;
    }

    @Override // p286h.p289g2.AbstractC5304u0
    public int nextInt() {
        try {
            int[] iArr = this.f20369b;
            int i2 = this.f20368a;
            this.f20368a = i2 + 1;
            return iArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20368a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
