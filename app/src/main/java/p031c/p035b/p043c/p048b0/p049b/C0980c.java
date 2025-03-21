package p031c.p035b.p043c.p048b0.p049b;

import com.umeng.analytics.pro.C3393cw;
import java.util.Map;
import p031c.p035b.p043c.C0988d;
import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.EnumC1044e;
import p031c.p035b.p043c.p072z.C1163b;
import p031c.p035b.p043c.p072z.C1166e;
import p031c.p035b.p043c.p072z.p074n.C1177a;
import p031c.p035b.p043c.p072z.p074n.C1179c;
import p031c.p035b.p043c.p072z.p074n.C1181e;
import p286h.C5230f1;

/* compiled from: Decoder.java */
/* renamed from: c.b.c.b0.b.c */
/* loaded from: classes.dex */
public final class C0980c {

    /* renamed from: b */
    private static final int f1755b = 0;

    /* renamed from: c */
    private static final int f1756c = 1;

    /* renamed from: d */
    private static final int f1757d = 2;

    /* renamed from: a */
    private final C1179c f1758a = new C1179c(C1177a.f2456o);

    /* renamed from: a */
    public C1166e m1340a(C1163b c1163b) throws C0988d, C1097h {
        return m1341a(c1163b, null);
    }

    /* renamed from: a */
    public C1166e m1341a(C1163b c1163b, Map<EnumC1044e, ?> map) throws C1097h, C0988d {
        byte[] bArr;
        byte[] m1329a = new C0978a(c1163b).m1329a();
        m1339a(m1329a, 0, 10, 10, 0);
        int i2 = m1329a[0] & C3393cw.f11873m;
        if (i2 == 2 || i2 == 3 || i2 == 4) {
            m1339a(m1329a, 20, 84, 40, 1);
            m1339a(m1329a, 20, 84, 40, 2);
            bArr = new byte[94];
        } else {
            if (i2 != 5) {
                throw C1097h.getFormatInstance();
            }
            m1339a(m1329a, 20, 68, 56, 1);
            m1339a(m1329a, 20, 68, 56, 2);
            bArr = new byte[78];
        }
        System.arraycopy(m1329a, 0, bArr, 0, 10);
        System.arraycopy(m1329a, 20, bArr, 10, bArr.length - 10);
        return C0979b.m1333a(bArr, i2);
    }

    /* renamed from: a */
    private void m1339a(byte[] bArr, int i2, int i3, int i4, int i5) throws C0988d {
        int i6 = i3 + i4;
        int i7 = i5 == 0 ? 1 : 2;
        int[] iArr = new int[i6 / i7];
        for (int i8 = 0; i8 < i6; i8++) {
            if (i5 == 0 || i8 % 2 == i5 - 1) {
                iArr[i8 / i7] = bArr[i8 + i2] & C5230f1.f20085c;
            }
        }
        try {
            this.f1758a.m2254a(iArr, i4 / i7);
            for (int i9 = 0; i9 < i3; i9++) {
                if (i5 == 0 || i9 % 2 == i5 - 1) {
                    bArr[i9 + i2] = (byte) iArr[i9 / i7];
                }
            }
        } catch (C1181e unused) {
            throw C0988d.getChecksumInstance();
        }
    }
}
