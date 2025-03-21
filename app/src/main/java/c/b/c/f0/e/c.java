package c.b.c.f0.e;

import c.b.c.f0.c.h;
import c.b.c.f0.c.j;
import c.b.c.g;
import c.b.c.w;
import h.f1;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* compiled from: Encoder.java */
/* loaded from: classes.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    private static final int[] f2803a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    /* renamed from: b, reason: collision with root package name */
    static final String f2804b = "ISO-8859-1";

    /* compiled from: Encoder.java */
    static /* synthetic */ class a {

        /* renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f2805a = new int[h.values().length];

        static {
            try {
                f2805a[h.NUMERIC.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f2805a[h.ALPHANUMERIC.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f2805a[h.BYTE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f2805a[h.KANJI.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    private c() {
    }

    private static int a(b bVar) {
        return d.a(bVar) + d.b(bVar) + d.c(bVar) + d.d(bVar);
    }

    private static boolean b(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = bytes[i2] & f1.f16099c;
                if ((i3 < 129 || i3 > 159) && (i3 < 224 || i3 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    public static f a(String str, c.b.c.f0.c.f fVar) throws w {
        return a(str, fVar, (Map<g, ?>) null);
    }

    static void b(CharSequence charSequence, c.b.c.z.a aVar) {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int charAt = charSequence.charAt(i2) - '0';
            int i3 = i2 + 2;
            if (i3 < length) {
                aVar.a((charAt * 100) + ((charSequence.charAt(i2 + 1) - '0') * 10) + (charSequence.charAt(i3) - '0'), 10);
                i2 += 3;
            } else {
                i2++;
                if (i2 < length) {
                    aVar.a((charAt * 10) + (charSequence.charAt(i2) - '0'), 7);
                    i2 = i3;
                } else {
                    aVar.a(charAt, 4);
                }
            }
        }
    }

    public static f a(String str, c.b.c.f0.c.f fVar, Map<g, ?> map) throws w {
        c.b.c.z.d characterSetECIByName;
        String str2 = map == null ? null : (String) map.get(g.CHARACTER_SET);
        if (str2 == null) {
            str2 = "ISO-8859-1";
        }
        h a2 = a(str, str2);
        c.b.c.z.a aVar = new c.b.c.z.a();
        if (a2 == h.BYTE && !"ISO-8859-1".equals(str2) && (characterSetECIByName = c.b.c.z.d.getCharacterSetECIByName(str2)) != null) {
            a(characterSetECIByName, aVar);
        }
        a(a2, aVar);
        c.b.c.z.a aVar2 = new c.b.c.z.a();
        a(str, a2, aVar2, str2);
        j a3 = a(aVar.c() + a2.getCharacterCountBits(a(aVar.c() + a2.getCharacterCountBits(j.c(1)) + aVar2.c(), fVar)) + aVar2.c(), fVar);
        c.b.c.z.a aVar3 = new c.b.c.z.a();
        aVar3.a(aVar);
        a(a2 == h.BYTE ? aVar2.d() : str.length(), a3, a2, aVar3);
        aVar3.a(aVar2);
        j.b a4 = a3.a(fVar);
        int d2 = a3.d() - a4.d();
        a(d2, aVar3);
        c.b.c.z.a a5 = a(aVar3, a3.d(), d2, a4.c());
        f fVar2 = new f();
        fVar2.a(fVar);
        fVar2.a(a2);
        fVar2.a(a3);
        int c2 = a3.c();
        b bVar = new b(c2, c2);
        int a6 = a(a5, fVar, a3, bVar);
        fVar2.a(a6);
        e.a(a5, fVar, a3, a6, bVar);
        fVar2.a(bVar);
        return fVar2;
    }

    static int a(int i2) {
        int[] iArr = f2803a;
        if (i2 < iArr.length) {
            return iArr[i2];
        }
        return -1;
    }

    public static h a(String str) {
        return a(str, (String) null);
    }

    private static h a(String str, String str2) {
        if ("Shift_JIS".equals(str2)) {
            return b(str) ? h.KANJI : h.BYTE;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (charAt >= '0' && charAt <= '9') {
                z2 = true;
            } else {
                if (a(charAt) == -1) {
                    return h.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return h.ALPHANUMERIC;
        }
        if (z2) {
            return h.NUMERIC;
        }
        return h.BYTE;
    }

    private static int a(c.b.c.z.a aVar, c.b.c.f0.c.f fVar, j jVar, b bVar) throws w {
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < 8; i4++) {
            e.a(aVar, fVar, jVar, i4, bVar);
            int a2 = a(bVar);
            if (a2 < i2) {
                i3 = i4;
                i2 = a2;
            }
        }
        return i3;
    }

    private static j a(int i2, c.b.c.f0.c.f fVar) throws w {
        for (int i3 = 1; i3 <= 40; i3++) {
            j c2 = j.c(i3);
            if (c2.d() - c2.a(fVar).d() >= (i2 + 7) / 8) {
                return c2;
            }
        }
        throw new w("Data too big");
    }

    static void a(int i2, c.b.c.z.a aVar) throws w {
        int i3 = i2 * 8;
        if (aVar.c() <= i3) {
            for (int i4 = 0; i4 < 4 && aVar.c() < i3; i4++) {
                aVar.a(false);
            }
            int c2 = aVar.c() & 7;
            if (c2 > 0) {
                while (c2 < 8) {
                    aVar.a(false);
                    c2++;
                }
            }
            int d2 = i2 - aVar.d();
            for (int i5 = 0; i5 < d2; i5++) {
                aVar.a((i5 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.c() != i3) {
                throw new w("Bits size does not equal capacity");
            }
            return;
        }
        throw new w("data bits cannot fit in the QR Code" + aVar.c() + " > " + i3);
    }

    static void a(int i2, int i3, int i4, int i5, int[] iArr, int[] iArr2) throws w {
        if (i5 < i4) {
            int i6 = i2 % i4;
            int i7 = i4 - i6;
            int i8 = i2 / i4;
            int i9 = i8 + 1;
            int i10 = i3 / i4;
            int i11 = i10 + 1;
            int i12 = i8 - i10;
            int i13 = i9 - i11;
            if (i12 != i13) {
                throw new w("EC bytes mismatch");
            }
            if (i4 != i7 + i6) {
                throw new w("RS blocks mismatch");
            }
            if (i2 != ((i10 + i12) * i7) + ((i11 + i13) * i6)) {
                throw new w("Total bytes mismatch");
            }
            if (i5 < i7) {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            } else {
                iArr[0] = i11;
                iArr2[0] = i13;
                return;
            }
        }
        throw new w("Block ID too large");
    }

    static c.b.c.z.a a(c.b.c.z.a aVar, int i2, int i3, int i4) throws w {
        if (aVar.d() == i3) {
            ArrayList arrayList = new ArrayList(i4);
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            for (int i8 = 0; i8 < i4; i8++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i2, i3, i4, i8, iArr, iArr2);
                int i9 = iArr[0];
                byte[] bArr = new byte[i9];
                aVar.a(i5 * 8, bArr, 0, i9);
                byte[] a2 = a(bArr, iArr2[0]);
                arrayList.add(new c.b.c.f0.e.a(bArr, a2));
                i6 = Math.max(i6, i9);
                i7 = Math.max(i7, a2.length);
                i5 += iArr[0];
            }
            if (i3 == i5) {
                c.b.c.z.a aVar2 = new c.b.c.z.a();
                for (int i10 = 0; i10 < i6; i10++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] a3 = ((c.b.c.f0.e.a) it.next()).a();
                        if (i10 < a3.length) {
                            aVar2.a(a3[i10], 8);
                        }
                    }
                }
                for (int i11 = 0; i11 < i7; i11++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] b2 = ((c.b.c.f0.e.a) it2.next()).b();
                        if (i11 < b2.length) {
                            aVar2.a(b2[i11], 8);
                        }
                    }
                }
                if (i2 == aVar2.d()) {
                    return aVar2;
                }
                throw new w("Interleaving error: " + i2 + " and " + aVar2.d() + " differ.");
            }
            throw new w("Data bytes does not match offset");
        }
        throw new w("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i2) {
        int length = bArr.length;
        int[] iArr = new int[length + i2];
        for (int i3 = 0; i3 < length; i3++) {
            iArr[i3] = bArr[i3] & f1.f16099c;
        }
        new c.b.c.z.n.d(c.b.c.z.n.a.f3067l).a(iArr, i2);
        byte[] bArr2 = new byte[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            bArr2[i4] = (byte) iArr[length + i4];
        }
        return bArr2;
    }

    static void a(h hVar, c.b.c.z.a aVar) {
        aVar.a(hVar.getBits(), 4);
    }

    static void a(int i2, j jVar, h hVar, c.b.c.z.a aVar) throws w {
        int characterCountBits = hVar.getCharacterCountBits(jVar);
        int i3 = 1 << characterCountBits;
        if (i2 < i3) {
            aVar.a(i2, characterCountBits);
            return;
        }
        throw new w(i2 + " is bigger than " + (i3 - 1));
    }

    static void a(String str, h hVar, c.b.c.z.a aVar, String str2) throws w {
        int i2 = a.f2805a[hVar.ordinal()];
        if (i2 == 1) {
            b(str, aVar);
            return;
        }
        if (i2 == 2) {
            a((CharSequence) str, aVar);
            return;
        }
        if (i2 == 3) {
            a(str, aVar, str2);
        } else {
            if (i2 == 4) {
                a(str, aVar);
                return;
            }
            throw new w("Invalid mode: " + hVar);
        }
    }

    static void a(CharSequence charSequence, c.b.c.z.a aVar) throws w {
        int length = charSequence.length();
        int i2 = 0;
        while (i2 < length) {
            int a2 = a(charSequence.charAt(i2));
            if (a2 == -1) {
                throw new w();
            }
            int i3 = i2 + 1;
            if (i3 < length) {
                int a3 = a(charSequence.charAt(i3));
                if (a3 != -1) {
                    aVar.a((a2 * 45) + a3, 11);
                    i2 += 2;
                } else {
                    throw new w();
                }
            } else {
                aVar.a(a2, 6);
                i2 = i3;
            }
        }
    }

    static void a(String str, c.b.c.z.a aVar, String str2) throws w {
        try {
            for (byte b2 : str.getBytes(str2)) {
                aVar.a(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new w(e2);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0035 A[LOOP:0: B:4:0x0008->B:11:0x0035, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:12:0x0044 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static void a(java.lang.String r6, c.b.c.z.a r7) throws c.b.c.w {
        /*
            java.lang.String r0 = "Shift_JIS"
            byte[] r6 = r6.getBytes(r0)     // Catch: java.io.UnsupportedEncodingException -> L4d
            int r0 = r6.length
            r1 = 0
        L8:
            if (r1 >= r0) goto L4c
            r2 = r6[r1]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r1 + 1
            r3 = r6[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r2 = r2 | r3
            r3 = 33088(0x8140, float:4.6366E-41)
            r4 = -1
            if (r2 < r3) goto L24
            r5 = 40956(0x9ffc, float:5.7392E-41)
            if (r2 > r5) goto L24
        L22:
            int r2 = r2 - r3
            goto L33
        L24:
            r3 = 57408(0xe040, float:8.0446E-41)
            if (r2 < r3) goto L32
            r3 = 60351(0xebbf, float:8.457E-41)
            if (r2 > r3) goto L32
            r3 = 49472(0xc140, float:6.9325E-41)
            goto L22
        L32:
            r2 = -1
        L33:
            if (r2 == r4) goto L44
            int r3 = r2 >> 8
            int r3 = r3 * 192
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r3 = r3 + r2
            r2 = 13
            r7.a(r3, r2)
            int r1 = r1 + 2
            goto L8
        L44:
            c.b.c.w r6 = new c.b.c.w
            java.lang.String r7 = "Invalid byte sequence"
            r6.<init>(r7)
            throw r6
        L4c:
            return
        L4d:
            r6 = move-exception
            c.b.c.w r7 = new c.b.c.w
            r7.<init>(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.f0.e.c.a(java.lang.String, c.b.c.z.a):void");
    }

    private static void a(c.b.c.z.d dVar, c.b.c.z.a aVar) {
        aVar.a(h.ECI.getBits(), 4);
        aVar.a(dVar.getValue(), 8);
    }
}
