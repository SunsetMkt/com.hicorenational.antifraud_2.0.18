package p031c.p035b.p043c.p044a0.p045c;

import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;
import p031c.p035b.p043c.p072z.p074n.C1177a;
import p031c.p035b.p043c.p072z.p074n.C1179c;
import p031c.p035b.p043c.p072z.p074n.C1181e;
import p286h.C5230f1;

/* compiled from: Decoder.java */
/* renamed from: c.b.c.a0.c.d */
/* loaded from: classes.dex */
public final class C0959d {

    /* renamed from: a */
    private final C1179c f1662a = new C1179c(C1177a.f2454m);

    /* renamed from: a */
    public C1166e m1215a(boolean[][] zArr) throws C1097h, C0988d {
        int length = zArr.length;
        C1163b c1163b = new C1163b(length);
        for (int i2 = 0; i2 < length; i2++) {
            for (int i3 = 0; i3 < length; i3++) {
                if (zArr[i2][i3]) {
                    c1163b.m2175c(i3, i2);
                }
            }
        }
        return m1214a(c1163b);
    }

    /* renamed from: a */
    public C1166e m1214a(C1163b c1163b) throws C1097h, C0988d {
        C0956a c0956a = new C0956a(c1163b);
        C0957b[] m1201a = C0957b.m1201a(c0956a.m1198b(), c0956a.m1193a());
        int length = m1201a.length;
        int i2 = 0;
        for (C0957b c0957b : m1201a) {
            i2 += c0957b.m1203b();
        }
        byte[] bArr = new byte[i2];
        for (int i3 = 0; i3 < length; i3++) {
            C0957b c0957b2 = m1201a[i3];
            byte[] m1202a = c0957b2.m1202a();
            int m1203b = c0957b2.m1203b();
            m1213a(m1202a, m1203b);
            for (int i4 = 0; i4 < m1203b; i4++) {
                bArr[(i4 * length) + i3] = m1202a[i4];
            }
        }
        return C0958c.m1206a(bArr);
    }

    /* renamed from: a */
    private void m1213a(byte[] bArr, int i2) throws C0988d {
        int length = bArr.length;
        int[] iArr = new int[length];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & C5230f1.f20085c;
        }
        try {
            this.f1662a.m2254a(iArr, bArr.length - i2);
            for (int i4 = 0; i4 < i2; i4++) {
                bArr[i4] = (byte) iArr[i4];
            }
        } catch (C1181e unused) {
            throw C0988d.getChecksumInstance();
        }
    }
}
