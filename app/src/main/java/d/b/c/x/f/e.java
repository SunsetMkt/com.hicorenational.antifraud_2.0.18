package d.b.c.x.f;

import i.z2.h0;

/* JADX INFO: compiled from: SimpleToken.java */
/* JADX INFO: loaded from: classes.dex */
final class e extends g {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final short f9890c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final short f9891d;

    e(g gVar, int i2, int i3) {
        super(gVar);
        this.f9890c = (short) i2;
        this.f9891d = (short) i3;
    }

    @Override // d.b.c.x.f.g
    void a(d.b.c.z.a aVar, byte[] bArr) {
        aVar.a(this.f9890c, this.f9891d);
    }

    public String toString() {
        short s = this.f9890c;
        short s2 = this.f9891d;
        return h0.f12424d + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f9891d)).substring(1) + h0.f12425e;
    }
}
