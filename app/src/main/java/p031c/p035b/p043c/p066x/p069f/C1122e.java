package p031c.p035b.p043c.p066x.p069f;

import p031c.p035b.p043c.p072z.C1162a;
import p286h.p323z2.C5736h0;

/* compiled from: SimpleToken.java */
/* renamed from: c.b.c.x.f.e */
/* loaded from: classes.dex */
final class C1122e extends AbstractC1124g {

    /* renamed from: c */
    private final short f2269c;

    /* renamed from: d */
    private final short f2270d;

    C1122e(AbstractC1124g abstractC1124g, int i2, int i3) {
        super(abstractC1124g);
        this.f2269c = (short) i2;
        this.f2270d = (short) i3;
    }

    @Override // p031c.p035b.p043c.p066x.p069f.AbstractC1124g
    /* renamed from: a */
    void mo1971a(C1162a c1162a, byte[] bArr) {
        c1162a.m2148a(this.f2269c, this.f2270d);
    }

    public String toString() {
        short s = this.f2269c;
        short s2 = this.f2270d;
        return C5736h0.f20715d + Integer.toBinaryString((s & ((1 << s2) - 1)) | (1 << s2) | (1 << this.f2270d)).substring(1) + C5736h0.f20716e;
    }
}
