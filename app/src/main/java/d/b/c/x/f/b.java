package d.b.c.x.f;

import i.z2.h0;

/* JADX INFO: compiled from: BinaryShiftToken.java */
/* JADX INFO: loaded from: classes.dex */
final class b extends g {

    /* JADX INFO: renamed from: c */
    private final short f9875c;

    /* JADX INFO: renamed from: d */
    private final short f9876d;

    b(g gVar, int i2, int i3) {
        super(gVar);
        this.f9875c = (short) i2;
        this.f9876d = (short) i3;
    }

    @Override // d.b.c.x.f.g
    public void a(d.b.c.z.a aVar, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f9876d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                aVar.a(31, 5);
                short s2 = this.f9876d;
                if (s2 > 62) {
                    aVar.a(s2 - 31, 16);
                } else if (i2 == 0) {
                    aVar.a(Math.min((int) s2, 31), 5);
                } else {
                    aVar.a(s2 - 31, 5);
                }
            }
            aVar.a(bArr[this.f9875c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append((int) this.f9875c);
        sb.append("::");
        sb.append((this.f9875c + this.f9876d) - 1);
        sb.append(h0.f12425e);
        return sb.toString();
    }
}
