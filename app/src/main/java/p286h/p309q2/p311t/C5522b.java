package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5303u;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.b */
/* loaded from: classes2.dex */
final class C5522b extends AbstractC5303u {

    /* renamed from: a */
    private int f20360a;

    /* renamed from: b */
    private final byte[] f20361b;

    public C5522b(@InterfaceC5816d byte[] bArr) {
        C5544i0.m22546f(bArr, "array");
        this.f20361b = bArr;
    }

    @Override // p286h.p289g2.AbstractC5303u
    /* renamed from: b */
    public byte mo21707b() {
        try {
            byte[] bArr = this.f20361b;
            int i2 = this.f20360a;
            this.f20360a = i2 + 1;
            return bArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20360a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20360a < this.f20361b.length;
    }
}
