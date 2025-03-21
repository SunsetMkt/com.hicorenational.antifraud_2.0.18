package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5300t;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.a */
/* loaded from: classes2.dex */
final class C5519a extends AbstractC5300t {

    /* renamed from: a */
    private int f20357a;

    /* renamed from: b */
    private final boolean[] f20358b;

    public C5519a(@InterfaceC5816d boolean[] zArr) {
        C5544i0.m22546f(zArr, "array");
        this.f20358b = zArr;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20357a < this.f20358b.length;
    }

    @Override // p286h.p289g2.AbstractC5300t
    public boolean nextBoolean() {
        try {
            boolean[] zArr = this.f20358b;
            int i2 = this.f20357a;
            this.f20357a = i2 + 1;
            return zArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20357a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }
}
