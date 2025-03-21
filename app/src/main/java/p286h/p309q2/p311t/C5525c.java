package p286h.p309q2.p311t;

import java.util.NoSuchElementException;
import p286h.p289g2.AbstractC5306v;
import p324i.p336c.p337a.InterfaceC5816d;

/* compiled from: ArrayIterators.kt */
/* renamed from: h.q2.t.c */
/* loaded from: classes2.dex */
final class C5525c extends AbstractC5306v {

    /* renamed from: a */
    private int f20362a;

    /* renamed from: b */
    private final char[] f20363b;

    public C5525c(@InterfaceC5816d char[] cArr) {
        C5544i0.m22546f(cArr, "array");
        this.f20363b = cArr;
    }

    @Override // p286h.p289g2.AbstractC5306v
    /* renamed from: b */
    public char mo21708b() {
        try {
            char[] cArr = this.f20363b;
            int i2 = this.f20362a;
            this.f20362a = i2 + 1;
            return cArr[i2];
        } catch (ArrayIndexOutOfBoundsException e2) {
            this.f20362a--;
            throw new NoSuchElementException(e2.getMessage());
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.f20362a < this.f20363b.length;
    }
}
