package p031c.p035b.p043c;

import p286h.C5230f1;

/* compiled from: InvertedLuminanceSource.java */
/* renamed from: c.b.c.i */
/* loaded from: classes.dex */
public final class C1098i extends AbstractC1099j {

    /* renamed from: c */
    private final AbstractC1099j f2198c;

    public C1098i(AbstractC1099j abstractC1099j) {
        super(abstractC1099j.m1902c(), abstractC1099j.m1901a());
        this.f2198c = abstractC1099j;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: a */
    public byte[] mo1894a(int i2, byte[] bArr) {
        byte[] mo1894a = this.f2198c.mo1894a(i2, bArr);
        int m1902c = m1902c();
        for (int i3 = 0; i3 < m1902c; i3++) {
            mo1894a[i3] = (byte) (255 - (mo1894a[i3] & C5230f1.f20085c));
        }
        return mo1894a;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: b */
    public byte[] mo1895b() {
        byte[] mo1895b = this.f2198c.mo1895b();
        int m1902c = m1902c() * m1901a();
        byte[] bArr = new byte[m1902c];
        for (int i2 = 0; i2 < m1902c; i2++) {
            bArr[i2] = (byte) (255 - (mo1895b[i2] & C5230f1.f20085c));
        }
        return bArr;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: d */
    public AbstractC1099j mo1896d() {
        return this.f2198c;
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: e */
    public boolean mo1897e() {
        return this.f2198c.mo1897e();
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: f */
    public boolean mo1898f() {
        return this.f2198c.mo1898f();
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: g */
    public AbstractC1099j mo1899g() {
        return new C1098i(this.f2198c.mo1899g());
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: h */
    public AbstractC1099j mo1900h() {
        return new C1098i(this.f2198c.mo1900h());
    }

    @Override // p031c.p035b.p043c.AbstractC1099j
    /* renamed from: a */
    public AbstractC1099j mo1893a(int i2, int i3, int i4, int i5) {
        return new C1098i(this.f2198c.mo1893a(i2, i3, i4, i5));
    }
}
