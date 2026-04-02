package d.b.c;

import i.f1;

/* JADX INFO: compiled from: InvertedLuminanceSource.java */
/* JADX INFO: loaded from: classes.dex */
public final class i extends j {

    /* JADX INFO: renamed from: c */
    private final j f9836c;

    public i(j jVar) {
        super(jVar.c(), jVar.a());
        this.f9836c = jVar;
    }

    @Override // d.b.c.j
    public byte[] a(int i2, byte[] bArr) {
        byte[] bArrA = this.f9836c.a(i2, bArr);
        int iC = c();
        for (int i3 = 0; i3 < iC; i3++) {
            bArrA[i3] = (byte) (255 - (bArrA[i3] & f1.f12066c));
        }
        return bArrA;
    }

    @Override // d.b.c.j
    public byte[] b() {
        byte[] bArrB = this.f9836c.b();
        int iC = c() * a();
        byte[] bArr = new byte[iC];
        for (int i2 = 0; i2 < iC; i2++) {
            bArr[i2] = (byte) (255 - (bArrB[i2] & f1.f12066c));
        }
        return bArr;
    }

    @Override // d.b.c.j
    public j d() {
        return this.f9836c;
    }

    @Override // d.b.c.j
    public boolean e() {
        return this.f9836c.e();
    }

    @Override // d.b.c.j
    public boolean f() {
        return this.f9836c.f();
    }

    @Override // d.b.c.j
    public j g() {
        return new i(this.f9836c.g());
    }

    @Override // d.b.c.j
    public j h() {
        return new i(this.f9836c.h());
    }

    @Override // d.b.c.j
    public j a(int i2, int i3, int i4, int i5) {
        return new i(this.f9836c.a(i2, i3, i4, i5));
    }
}
