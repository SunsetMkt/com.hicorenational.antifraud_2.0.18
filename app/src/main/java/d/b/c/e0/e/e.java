package d.b.c.e0.e;

import i.z2.h0;
import java.io.ByteArrayOutputStream;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.Arrays;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes.dex */
final class e {
    private static final int a = 900;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f9705b = 901;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f9706c = 902;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int f9707d = 924;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final int f9708e = 925;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final int f9709f = 926;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final int f9710g = 927;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private static final int f9711h = 928;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final int f9712i = 923;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final int f9713j = 922;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final int f9714k = 913;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static final int f9715l = 15;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static final int f9716m = 25;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private static final int f9717n = 27;
    private static final int o = 27;
    private static final int p = 28;
    private static final int q = 28;
    private static final int r = 29;
    private static final int s = 29;
    private static final char[] t = {';', h0.f12424d, h0.f12425e, '@', '[', '\\', ']', '_', '`', '~', '!', '\r', '\t', ',', ':', '\n', '-', '.', h0.f12422b, '/', h0.a, '|', '*', '(', ')', '?', '{', '}', '\''};
    private static final char[] u = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', h0.f12423c, '\r', '\t', ',', ':', '#', '-', '.', h0.f12422b, '/', '+', '%', '*', '=', '^'};
    private static final Charset v = Charset.forName(j.a.a.a.c.a);
    private static final BigInteger[] w = new BigInteger[16];
    private static final int x = 2;

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    static /* synthetic */ class a {
        static final /* synthetic */ int[] a = new int[b.values().length];

        static {
            try {
                a[b.ALPHA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[b.LOWER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[b.MIXED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[b.PUNCT.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[b.ALPHA_SHIFT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[b.PUNCT_SHIFT.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    /* JADX INFO: compiled from: DecodedBitStreamParser.java */
    private enum b {
        ALPHA,
        LOWER,
        MIXED,
        PUNCT,
        ALPHA_SHIFT,
        PUNCT_SHIFT
    }

    static {
        w[0] = BigInteger.ONE;
        BigInteger bigIntegerValueOf = BigInteger.valueOf(900L);
        w[1] = bigIntegerValueOf;
        int i2 = 2;
        while (true) {
            BigInteger[] bigIntegerArr = w;
            if (i2 >= bigIntegerArr.length) {
                return;
            }
            bigIntegerArr[i2] = bigIntegerArr[i2 - 1].multiply(bigIntegerValueOf);
            i2++;
        }
    }

    private e() {
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Removed duplicated region for block: B:17:0x0052  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    static d.b.c.z.e a(int[] iArr, String str) throws d.b.c.h {
        int iB;
        StringBuilder sb = new StringBuilder(iArr.length * 2);
        Charset charset = v;
        int i2 = iArr[1];
        d.b.c.e0.c cVar = new d.b.c.e0.c();
        for (int i3 = 2; i3 < iArr[0]; i3 = iB + 1) {
            if (i2 != f9714k) {
                switch (i2) {
                    case a /* 900 */:
                        iB = b(iArr, i3, sb);
                        break;
                    case f9705b /* 901 */:
                        iB = a(i2, iArr, charset, i3, sb);
                        break;
                    case f9706c /* 902 */:
                        iB = a(iArr, i3, sb);
                        break;
                    default:
                        switch (i2) {
                            case f9713j /* 922 */:
                            case f9712i /* 923 */:
                                throw d.b.c.h.getFormatInstance();
                            case f9707d /* 924 */:
                                break;
                            case f9708e /* 925 */:
                                iB = i3 + 1;
                                break;
                            case f9709f /* 926 */:
                                iB = i3 + 2;
                                break;
                            case f9710g /* 927 */:
                                int i4 = i3 + 1;
                                Charset charsetForName = Charset.forName(d.b.c.z.d.getCharacterSetECIByValue(iArr[i3]).name());
                                iB = i4;
                                charset = charsetForName;
                                break;
                            case 928:
                                iB = a(iArr, i3, cVar);
                                break;
                            default:
                                iB = b(iArr, i3 - 1, sb);
                                break;
                        }
                        break;
                }
            } else {
                sb.append((char) iArr[i3]);
                iB = i3 + 1;
            }
            if (iB >= iArr.length) {
                throw d.b.c.h.getFormatInstance();
            }
            i2 = iArr[iB];
        }
        if (sb.length() == 0) {
            throw d.b.c.h.getFormatInstance();
        }
        d.b.c.z.e eVar = new d.b.c.z.e(null, sb.toString(), null, str);
        eVar.a(cVar);
        return eVar;
    }

    /* JADX WARN: Failed to find 'out' block for switch in B:13:0x0034. Please report as an issue. */
    /* JADX WARN: Failed to find 'out' block for switch in B:14:0x0037. Please report as an issue. */
    /*  JADX ERROR: UnsupportedOperationException in pass: RegionMakerVisitor
        java.lang.UnsupportedOperationException
        	at java.base/java.util.Collections$UnmodifiableCollection.add(Collections.java:1091)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker$1.leaveRegion(SwitchRegionMaker.java:390)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:23)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaksForCase(SwitchRegionMaker.java:370)
        	at jadx.core.dex.visitors.regions.maker.SwitchRegionMaker.insertBreaks(SwitchRegionMaker.java:85)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.leaveRegion(PostProcessRegions.java:33)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:70)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.PostProcessRegions.process(PostProcessRegions.java:23)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:31)
        */
    private static int b(int[] r8, int r9, java.lang.StringBuilder r10) {
        /*
            r0 = 0
            r1 = r8[r0]
            int r1 = r1 - r9
            int r1 = r1 * 2
            int[] r1 = new int[r1]
            r2 = r8[r0]
            int r2 = r2 - r9
            int r2 = r2 * 2
            int[] r2 = new int[r2]
            r3 = 0
            r4 = 0
        L11:
            r5 = r8[r0]
            if (r9 >= r5) goto L53
            if (r3 != 0) goto L53
            int r5 = r9 + 1
            r9 = r8[r9]
            r6 = 900(0x384, float:1.261E-42)
            if (r9 >= r6) goto L2c
            int r6 = r9 / 30
            r1[r4] = r6
            int r6 = r4 + 1
            int r9 = r9 % 30
            r1[r6] = r9
            int r4 = r4 + 2
            goto L3a
        L2c:
            r7 = 913(0x391, float:1.28E-42)
            if (r9 == r7) goto L48
            r7 = 928(0x3a0, float:1.3E-42)
            if (r9 == r7) goto L42
            switch(r9) {
                case 900: goto L3c;
                case 901: goto L42;
                case 902: goto L42;
                default: goto L37;
            }
        L37:
            switch(r9) {
                case 922: goto L42;
                case 923: goto L42;
                case 924: goto L42;
                default: goto L3a;
            }
        L3a:
            r9 = r5
            goto L11
        L3c:
            int r9 = r4 + 1
            r1[r4] = r6
            r4 = r9
            goto L3a
        L42:
            int r5 = r5 + (-1)
            r9 = 1
            r9 = r5
            r3 = 1
            goto L11
        L48:
            r1[r4] = r7
            int r9 = r5 + 1
            r5 = r8[r5]
            r2[r4] = r5
            int r4 = r4 + 1
            goto L11
        L53:
            a(r1, r2, r4, r10)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: d.b.c.e0.e.e.b(int[], int, java.lang.StringBuilder):int");
    }

    private static int a(int[] iArr, int i2, d.b.c.e0.c cVar) throws d.b.c.h {
        if (i2 + 2 <= iArr[0]) {
            int[] iArr2 = new int[2];
            int i3 = i2;
            int i4 = 0;
            while (i4 < 2) {
                iArr2[i4] = iArr[i3];
                i4++;
                i3++;
            }
            cVar.a(Integer.parseInt(a(iArr2, 2)));
            StringBuilder sb = new StringBuilder();
            int iB = b(iArr, i3, sb);
            cVar.a(sb.toString());
            if (iArr[iB] == f9712i) {
                int i5 = iB + 1;
                int[] iArr3 = new int[iArr[0] - i5];
                boolean z = false;
                int i6 = 0;
                while (i5 < iArr[0] && !z) {
                    int i7 = i5 + 1;
                    int i8 = iArr[i5];
                    if (i8 < a) {
                        iArr3[i6] = i8;
                        i5 = i7;
                        i6++;
                    } else if (i8 == f9713j) {
                        cVar.a(true);
                        i5 = i7 + 1;
                        z = true;
                    } else {
                        throw d.b.c.h.getFormatInstance();
                    }
                }
                cVar.a(Arrays.copyOf(iArr3, i6));
                return i5;
            }
            if (iArr[iB] != f9713j) {
                return iB;
            }
            cVar.a(true);
            return iB + 1;
        }
        throw d.b.c.h.getFormatInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private static void a(int[] iArr, int[] iArr2, int i2, StringBuilder sb) {
        char c2;
        b bVar;
        int i3;
        char c3;
        b bVar2 = b.ALPHA;
        b bVar3 = bVar2;
        for (int i4 = 0; i4 < i2; i4++) {
            int i5 = iArr[i4];
            switch (a.a[bVar2.ordinal()]) {
                case 1:
                    if (i5 < 26) {
                        i3 = i5 + 65;
                        c2 = (char) i3;
                    } else {
                        if (i5 != 26) {
                            if (i5 == 27) {
                                bVar2 = b.LOWER;
                            } else if (i5 == 28) {
                                bVar2 = b.MIXED;
                            } else if (i5 == 29) {
                                bVar = b.PUNCT_SHIFT;
                                c2 = 0;
                                b bVar4 = bVar;
                                bVar3 = bVar2;
                                bVar2 = bVar4;
                                break;
                            } else if (i5 == f9714k) {
                                sb.append((char) iArr2[i4]);
                            } else if (i5 == a) {
                                bVar2 = b.ALPHA;
                            }
                            c2 = 0;
                        }
                        c2 = ' ';
                    }
                    break;
                case 2:
                    if (i5 < 26) {
                        i3 = i5 + 97;
                        c2 = (char) i3;
                    } else {
                        if (i5 != 26) {
                            if (i5 != 27) {
                                if (i5 == 28) {
                                    bVar2 = b.MIXED;
                                } else if (i5 == 29) {
                                    bVar = b.PUNCT_SHIFT;
                                } else if (i5 == f9714k) {
                                    sb.append((char) iArr2[i4]);
                                } else if (i5 == a) {
                                    bVar2 = b.ALPHA;
                                }
                                c2 = 0;
                            } else {
                                bVar = b.ALPHA_SHIFT;
                            }
                            c2 = 0;
                            b bVar42 = bVar;
                            bVar3 = bVar2;
                            bVar2 = bVar42;
                        }
                        c2 = ' ';
                    }
                    break;
                case 3:
                    if (i5 < 25) {
                        c2 = u[i5];
                    } else {
                        if (i5 != 25) {
                            if (i5 != 26) {
                                if (i5 == 27) {
                                    bVar2 = b.LOWER;
                                } else if (i5 == 28) {
                                    bVar2 = b.ALPHA;
                                } else if (i5 == 29) {
                                    bVar = b.PUNCT_SHIFT;
                                    c2 = 0;
                                    b bVar422 = bVar;
                                    bVar3 = bVar2;
                                    bVar2 = bVar422;
                                    break;
                                } else if (i5 == f9714k) {
                                    sb.append((char) iArr2[i4]);
                                } else if (i5 == a) {
                                    bVar2 = b.ALPHA;
                                }
                            }
                            c2 = ' ';
                        } else {
                            bVar2 = b.PUNCT;
                        }
                        c2 = 0;
                    }
                    break;
                case 4:
                    if (i5 < 29) {
                        c2 = t[i5];
                    } else {
                        if (i5 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i5 == f9714k) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == a) {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                    }
                    break;
                case 5:
                    if (i5 < 26) {
                        c3 = (char) (i5 + 65);
                        c2 = c3;
                        bVar2 = bVar3;
                    } else if (i5 == 26) {
                        bVar2 = bVar3;
                        c2 = ' ';
                    } else {
                        bVar2 = i5 == a ? b.ALPHA : bVar3;
                        c2 = 0;
                    }
                    break;
                case 6:
                    if (i5 < 29) {
                        c3 = t[i5];
                        c2 = c3;
                        bVar2 = bVar3;
                    } else {
                        if (i5 == 29) {
                            bVar2 = b.ALPHA;
                        } else if (i5 == f9714k) {
                            sb.append((char) iArr2[i4]);
                        } else if (i5 == a) {
                            bVar2 = b.ALPHA;
                        }
                        c2 = 0;
                    }
                    break;
                default:
                    c2 = 0;
                    break;
            }
            if (c2 != 0) {
                sb.append(c2);
            }
        }
    }

    private static int a(int i2, int[] iArr, Charset charset, int i3, StringBuilder sb) {
        int i4;
        int i5;
        int i6;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i7 = f9713j;
        int i8 = f9712i;
        int i9 = 928;
        long j2 = 900;
        if (i2 == f9705b) {
            int[] iArr2 = new int[6];
            i4 = i3 + 1;
            int i10 = iArr[i3];
            boolean z = false;
            loop0: while (true) {
                i5 = 0;
                long j3 = 0;
                while (i4 < iArr[0] && !z) {
                    int i11 = i5 + 1;
                    iArr2[i5] = i10;
                    j3 = (j3 * j2) + ((long) i10);
                    int i12 = i4 + 1;
                    i10 = iArr[i4];
                    if (i10 == a || i10 == f9705b || i10 == f9706c || i10 == f9707d || i10 == 928 || i10 == i8 || i10 == i7) {
                        i4 = i12 - 1;
                        i5 = i11;
                        i7 = f9713j;
                        i8 = f9712i;
                        j2 = 900;
                        z = true;
                    } else if (i11 % 5 != 0 || i11 <= 0) {
                        i4 = i12;
                        i5 = i11;
                        i7 = f9713j;
                        i8 = f9712i;
                        j2 = 900;
                    } else {
                        int i13 = 0;
                        while (i13 < 6) {
                            byteArrayOutputStream.write((byte) (j3 >> ((5 - i13) * 8)));
                            i13++;
                            i7 = f9713j;
                            i8 = f9712i;
                        }
                        i4 = i12;
                        j2 = 900;
                    }
                }
                break loop0;
            }
            if (i4 != iArr[0] || i10 >= a) {
                i6 = i5;
            } else {
                i6 = i5 + 1;
                iArr2[i5] = i10;
            }
            for (int i14 = 0; i14 < i6; i14++) {
                byteArrayOutputStream.write((byte) iArr2[i14]);
            }
        } else if (i2 == f9707d) {
            int i15 = i3;
            int i16 = 0;
            long j4 = 0;
            boolean z2 = false;
            while (i15 < iArr[0] && !z2) {
                int i17 = i15 + 1;
                int i18 = iArr[i15];
                if (i18 < a) {
                    i16++;
                    j4 = (j4 * 900) + ((long) i18);
                    i15 = i17;
                } else {
                    if (i18 != a && i18 != f9705b && i18 != f9706c && i18 != f9707d && i18 != i9) {
                        if (i18 != f9712i && i18 != f9713j) {
                            i15 = i17;
                        }
                    }
                    i15 = i17 - 1;
                    z2 = true;
                }
                if (i16 % 5 == 0 && i16 > 0) {
                    int i19 = 0;
                    for (int i20 = 6; i19 < i20; i20 = 6) {
                        byteArrayOutputStream.write((byte) (j4 >> ((5 - i19) * 8)));
                        i19++;
                    }
                    i16 = 0;
                    j4 = 0;
                }
                i9 = 928;
            }
            i4 = i15;
        } else {
            i4 = i3;
        }
        sb.append(new String(byteArrayOutputStream.toByteArray(), charset));
        return i4;
    }

    private static int a(int[] iArr, int i2, StringBuilder sb) throws d.b.c.h {
        int[] iArr2 = new int[15];
        boolean z = false;
        int i3 = 0;
        while (i2 < iArr[0] && !z) {
            int i4 = i2 + 1;
            int i5 = iArr[i2];
            if (i4 == iArr[0]) {
                z = true;
            }
            if (i5 < a) {
                iArr2[i3] = i5;
                i3++;
            } else if (i5 == a || i5 == f9705b || i5 == f9707d || i5 == 928 || i5 == f9712i || i5 == f9713j) {
                i4--;
                z = true;
            }
            if ((i3 % 15 == 0 || i5 == f9706c || z) && i3 > 0) {
                sb.append(a(iArr2, i3));
                i3 = 0;
            }
            i2 = i4;
        }
        return i2;
    }

    private static String a(int[] iArr, int i2) throws d.b.c.h {
        BigInteger bigIntegerAdd = BigInteger.ZERO;
        for (int i3 = 0; i3 < i2; i3++) {
            bigIntegerAdd = bigIntegerAdd.add(w[(i2 - i3) - 1].multiply(BigInteger.valueOf(iArr[i3])));
        }
        String string = bigIntegerAdd.toString();
        if (string.charAt(0) == '1') {
            return string.substring(1);
        }
        throw d.b.c.h.getFormatInstance();
    }
}
