package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5287o1;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.k */
/* loaded from: classes2.dex */
final class C5549k extends AbstractC5287o1 {

    /* renamed from: a */
    private int f20389a;

    /* renamed from: b */
    private final short[] f20390b;

    public C5549k(@InterfaceC5816d short[] sArr) {
        C5544i0.m22546f(sArr, "array");
        this.f20390b = sArr;
    }

    @Override // p286h.p289g2.AbstractC5287o1
    /* renamed from: b */
    public short mo20129b() {
        try {
            short[] sArr = this.f20390b;
            int i2 = this.f20389a;
            this.f20389a = i2 + 1;
            return sArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20389a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20389a < this.f20390b.length;
    }
}
