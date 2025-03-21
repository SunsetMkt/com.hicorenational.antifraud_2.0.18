package c.b.c.f0.c;

import c.b.c.z.l;
import h.z2.h0;
import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Map;

/* compiled from: DecodedBitStreamParser.java */
/* loaded from: classes.dex */
final class d {

    /* renamed from: a, reason: collision with root package name */
    private static final char[] f2751a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', h0.f16705b, '%', '*', '+', '-', '.', '/', ':'};

    /* renamed from: b, reason: collision with root package name */
    private static final int f2752b = 1;

    private d() {
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00e8 A[LOOP:0: B:2:0x001e->B:47:0x00e8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:48:0x00c6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static c.b.c.z.e a(byte[] r17, c.b.c.f0.c.j r18, c.b.c.f0.c.f r19, java.util.Map<c.b.c.e, ?> r20) throws c.b.c.h {
        /*
            Method dump skipped, instructions count: 240
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: c.b.c.f0.c.d.a(byte[], c.b.c.f0.c.j, c.b.c.f0.c.f, java.util.Map):c.b.c.z.e");
    }

    private static void b(c.b.c.z.c cVar, StringBuilder sb, int i2) throws c.b.c.h {
        if (i2 * 13 > cVar.a()) {
            throw c.b.c.h.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int a2 = cVar.a(13);
            int i4 = (a2 % 192) | ((a2 / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, l.f3046b));
        } catch (UnsupportedEncodingException unused) {
            throw c.b.c.h.getFormatInstance();
        }
    }

    private static void c(c.b.c.z.c cVar, StringBuilder sb, int i2) throws c.b.c.h {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw c.b.c.h.getFormatInstance();
            }
            int a2 = cVar.a(10);
            if (a2 >= 1000) {
                throw c.b.c.h.getFormatInstance();
            }
            sb.append(a(a2 / 100));
            sb.append(a((a2 / 10) % 10));
            sb.append(a(a2 % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw c.b.c.h.getFormatInstance();
            }
            int a3 = cVar.a(7);
            if (a3 >= 100) {
                throw c.b.c.h.getFormatInstance();
            }
            sb.append(a(a3 / 10));
            sb.append(a(a3 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw c.b.c.h.getFormatInstance();
            }
            int a4 = cVar.a(4);
            if (a4 >= 10) {
                throw c.b.c.h.getFormatInstance();
            }
            sb.append(a(a4));
        }
    }

    private static void a(c.b.c.z.c cVar, StringBuilder sb, int i2) throws c.b.c.h {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int a2 = cVar.a(13);
                int i4 = (a2 % 96) | ((a2 / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) ((i5 >> 8) & 255);
                bArr[i3 + 1] = (byte) (i5 & 255);
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, l.f3047c));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw c.b.c.h.getFormatInstance();
            }
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static void a(c.b.c.z.c cVar, StringBuilder sb, int i2, c.b.c.z.d dVar, Collection<byte[]> collection, Map<c.b.c.e, ?> map) throws c.b.c.h {
        String name;
        if (i2 * 8 <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.a(8);
            }
            if (dVar == null) {
                name = l.a(bArr, map);
            } else {
                name = dVar.name();
            }
            try {
                sb.append(new String(bArr, name));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw c.b.c.h.getFormatInstance();
            }
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static char a(int i2) throws c.b.c.h {
        char[] cArr = f2751a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw c.b.c.h.getFormatInstance();
    }

    private static void a(c.b.c.z.c cVar, StringBuilder sb, int i2, boolean z) throws c.b.c.h {
        while (i2 > 1) {
            if (cVar.a() >= 11) {
                int a2 = cVar.a(11);
                sb.append(a(a2 / 45));
                sb.append(a(a2 % 45));
                i2 -= 2;
            } else {
                throw c.b.c.h.getFormatInstance();
            }
        }
        if (i2 == 1) {
            if (cVar.a() >= 6) {
                sb.append(a(cVar.a(6)));
            } else {
                throw c.b.c.h.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        }
                    }
                    sb.setCharAt(length, (char) 29);
                }
            }
        }
    }

    private static int a(c.b.c.z.c cVar) throws c.b.c.h {
        int a2 = cVar.a(8);
        if ((a2 & 128) == 0) {
            return a2 & 127;
        }
        if ((a2 & 192) == 128) {
            return cVar.a(8) | ((a2 & 63) << 8);
        }
        if ((a2 & 224) == 192) {
            return cVar.a(16) | ((a2 & 31) << 16);
        }
        throw c.b.c.h.getFormatInstance();
    }
}
