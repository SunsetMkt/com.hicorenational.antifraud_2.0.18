package p031c.p035b.p043c.p053d0;

import p031c.p035b.p043c.C1097h;
import p031c.p035b.p043c.C1102m;
import p031c.p035b.p043c.EnumC0953a;
import p031c.p035b.p043c.p072z.C1162a;
import p031c.p075c.p076a.p081b.p082a.AbstractC1191a;

/* compiled from: UPCEReader.java */
/* renamed from: c.b.c.d0.z */
/* loaded from: classes.dex */
public final class C1043z extends AbstractC1041x {

    /* renamed from: k */
    private static final int[] f1959k = {1, 1, 1, 1, 1, 1};

    /* renamed from: l */
    private static final int[][] f1960l = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* renamed from: j */
    private final int[] f1961j = new int[4];

    /* renamed from: b */
    public static String m1536b(String str) {
        char[] cArr = new char[6];
        str.getChars(1, 7, cArr, 0);
        StringBuilder sb = new StringBuilder(12);
        sb.append(str.charAt(0));
        char c2 = cArr[5];
        switch (c2) {
            case '0':
            case '1':
            case '2':
                sb.append(cArr, 0, 2);
                sb.append(c2);
                sb.append("0000");
                sb.append(cArr, 2, 3);
                break;
            case '3':
                sb.append(cArr, 0, 3);
                sb.append(AbstractC1191a.f2515L);
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append(AbstractC1191a.f2515L);
                sb.append(cArr[4]);
                break;
            default:
                sb.append(cArr, 0, 5);
                sb.append("0000");
                sb.append(c2);
                break;
        }
        sb.append(str.charAt(7));
        return sb.toString();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    protected int mo1496a(C1162a c1162a, int[] iArr, StringBuilder sb) throws C1102m {
        int[] iArr2 = this.f1961j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int m2157c = c1162a.m2157c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < m2157c) {
            int m1528a = AbstractC1041x.m1528a(c1162a, iArr2, i2, AbstractC1041x.f1955i);
            sb.append((char) ((m1528a % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (m1528a >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        m1535a(sb, i4);
        return i2;
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    protected int[] mo1534a(C1162a c1162a, int i2) throws C1102m {
        return AbstractC1041x.m1531a(c1162a, i2, true, f1959k);
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    protected boolean mo1533a(String str) throws C1097h {
        return super.mo1533a(m1536b(str));
    }

    /* renamed from: a */
    private static void m1535a(StringBuilder sb, int i2) throws C1102m {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == f1960l[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw C1102m.getNotFoundInstance();
    }

    @Override // p031c.p035b.p043c.p053d0.AbstractC1041x
    /* renamed from: a */
    EnumC0953a mo1497a() {
        return EnumC0953a.UPC_E;
    }
}
