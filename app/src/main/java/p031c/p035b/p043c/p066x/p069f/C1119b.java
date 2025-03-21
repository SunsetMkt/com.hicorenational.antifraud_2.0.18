package p031c.p035b.p043c.p066x.p069f;

import p031c.p035b.p043c.p072z.C1162a;
import p286h.p323z2.C5736h0;

/* compiled from: BinaryShiftToken.java */
/* renamed from: c.b.c.x.f.b */
/* loaded from: classes.dex */
final class C1119b extends AbstractC1124g {

    /* renamed from: c */
    private final short f2251c;

    /* renamed from: d */
    private final short f2252d;

    C1119b(AbstractC1124g abstractC1124g, int i2, int i3) {
        super(abstractC1124g);
        this.f2251c = (short) i2;
        this.f2252d = (short) i3;
    }

    @Override // p031c.p035b.p043c.p066x.p069f.AbstractC1124g
    /* renamed from: a */
    public void mo1971a(C1162a c1162a, byte[] bArr) {
        int i2 = 0;
        while (true) {
            short s = this.f2252d;
            if (i2 >= s) {
                return;
            }
            if (i2 == 0 || (i2 == 31 && s <= 62)) {
                c1162a.m2148a(31, 5);
                short s2 = this.f2252d;
                if (s2 > 62) {
                    c1162a.m2148a(s2 - 31, 16);
                } else if (i2 == 0) {
                    c1162a.m2148a(Math.min((int) s2, 31), 5);
                } else {
                    c1162a.m2148a(s2 - 31, 5);
                }
            }
            c1162a.m2148a(bArr[this.f2251c + i2], 8);
            i2++;
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("<");
        sb.append((int) this.f2251c);
        sb.append("::");
        sb.append((this.f2251c + this.f2252d) - 1);
        sb.append(C5736h0.f20716e);
        return sb.toString();
    }
}
