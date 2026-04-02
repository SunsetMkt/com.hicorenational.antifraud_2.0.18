package d.b.c.d0;

/* JADX INFO: compiled from: UPCEReader.java */
/* JADX INFO: loaded from: classes.dex */
public final class z extends x {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int[] f9672k = {1, 1, 1, 1, 1, 1};

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int[][] f9673l = {new int[]{56, 52, 50, 49, 44, 38, 35, 42, 41, 37}, new int[]{7, 11, 13, 14, 19, 25, 28, 21, 22, 26}};

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final int[] f9674j = new int[4];

    public static String b(String str) {
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
                sb.append(d.c.a.b.a.a.L);
                sb.append(cArr, 3, 2);
                break;
            case '4':
                sb.append(cArr, 0, 4);
                sb.append(d.c.a.b.a.a.L);
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

    @Override // d.b.c.d0.x
    protected int a(d.b.c.z.a aVar, int[] iArr, StringBuilder sb) throws d.b.c.m {
        int[] iArr2 = this.f9674j;
        iArr2[0] = 0;
        iArr2[1] = 0;
        iArr2[2] = 0;
        iArr2[3] = 0;
        int iC = aVar.c();
        int i2 = iArr[1];
        int i3 = 0;
        int i4 = 0;
        while (i3 < 6 && i2 < iC) {
            int iA = x.a(aVar, iArr2, i2, x.f9669i);
            sb.append((char) ((iA % 10) + 48));
            int i5 = i2;
            for (int i6 : iArr2) {
                i5 += i6;
            }
            if (iA >= 10) {
                i4 = (1 << (5 - i3)) | i4;
            }
            i3++;
            i2 = i5;
        }
        a(sb, i4);
        return i2;
    }

    @Override // d.b.c.d0.x
    protected int[] a(d.b.c.z.a aVar, int i2) throws d.b.c.m {
        return x.a(aVar, i2, true, f9672k);
    }

    @Override // d.b.c.d0.x
    protected boolean a(String str) throws d.b.c.h {
        return super.a(b(str));
    }

    private static void a(StringBuilder sb, int i2) throws d.b.c.m {
        for (int i3 = 0; i3 <= 1; i3++) {
            for (int i4 = 0; i4 < 10; i4++) {
                if (i2 == f9673l[i3][i4]) {
                    sb.insert(0, (char) (i3 + 48));
                    sb.append((char) (i4 + 48));
                    return;
                }
            }
        }
        throw d.b.c.m.getNotFoundInstance();
    }

    @Override // d.b.c.d0.x
    d.b.c.a a() {
        return d.b.c.a.UPC_E;
    }
}
