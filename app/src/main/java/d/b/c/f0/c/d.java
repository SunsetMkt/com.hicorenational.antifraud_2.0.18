package d.b.c.f0.c;

import d.b.c.z.l;
import i.z2.h0;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

/* JADX INFO: compiled from: DecodedBitStreamParser.java */
/* JADX INFO: loaded from: classes.dex */
final class d {
    private static final char[] a = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', ' ', h0.f12422b, '%', '*', '+', '-', '.', '/', ':'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final int f9784b = 1;

    private d() {
    }

    static d.b.c.z.e a(byte[] bArr, j jVar, f fVar, Map<d.b.c.e, ?> map) throws d.b.c.h {
        h hVar;
        d.b.c.z.c cVar = new d.b.c.z.c(bArr);
        StringBuilder sb = new StringBuilder(50);
        int i2 = 1;
        ArrayList arrayList = new ArrayList(1);
        d.b.c.z.d characterSetECIByValue = null;
        boolean z = false;
        int i3 = -1;
        int iA = -1;
        while (true) {
            try {
                h hVarForBits = cVar.a() < 4 ? h.TERMINATOR : h.forBits(cVar.a(4));
                if (hVarForBits == h.TERMINATOR) {
                    hVar = hVarForBits;
                } else if (hVarForBits == h.FNC1_FIRST_POSITION || hVarForBits == h.FNC1_SECOND_POSITION) {
                    hVar = hVarForBits;
                    z = true;
                } else {
                    if (hVarForBits == h.STRUCTURED_APPEND) {
                        if (cVar.a() < 16) {
                            throw d.b.c.h.getFormatInstance();
                        }
                        int iA2 = cVar.a(8);
                        iA = cVar.a(8);
                        i3 = iA2;
                    } else if (hVarForBits == h.ECI) {
                        characterSetECIByValue = d.b.c.z.d.getCharacterSetECIByValue(a(cVar));
                        if (characterSetECIByValue == null) {
                            throw d.b.c.h.getFormatInstance();
                        }
                    } else if (hVarForBits == h.HANZI) {
                        int iA3 = cVar.a(4);
                        int iA4 = cVar.a(hVarForBits.getCharacterCountBits(jVar));
                        if (iA3 == i2) {
                            a(cVar, sb, iA4);
                        }
                    } else {
                        int iA5 = cVar.a(hVarForBits.getCharacterCountBits(jVar));
                        if (hVarForBits == h.NUMERIC) {
                            c(cVar, sb, iA5);
                        } else if (hVarForBits == h.ALPHANUMERIC) {
                            a(cVar, sb, iA5, z);
                        } else if (hVarForBits == h.BYTE) {
                            hVar = hVarForBits;
                            a(cVar, sb, iA5, characterSetECIByValue, arrayList, map);
                        } else {
                            hVar = hVarForBits;
                            if (hVar != h.KANJI) {
                                throw d.b.c.h.getFormatInstance();
                            }
                            b(cVar, sb, iA5);
                        }
                    }
                    hVar = hVarForBits;
                }
                if (hVar == h.TERMINATOR) {
                    return new d.b.c.z.e(bArr, sb.toString(), arrayList.isEmpty() ? null : arrayList, fVar == null ? null : fVar.toString(), i3, iA);
                }
                i2 = 1;
            } catch (IllegalArgumentException unused) {
                throw d.b.c.h.getFormatInstance();
            }
        }
    }

    private static void b(d.b.c.z.c cVar, StringBuilder sb, int i2) throws d.b.c.h {
        if (i2 * 13 > cVar.a()) {
            throw d.b.c.h.getFormatInstance();
        }
        byte[] bArr = new byte[i2 * 2];
        int i3 = 0;
        while (i2 > 0) {
            int iA = cVar.a(13);
            int i4 = (iA % 192) | ((iA / 192) << 8);
            int i5 = i4 + (i4 < 7936 ? 33088 : 49472);
            bArr[i3] = (byte) (i5 >> 8);
            bArr[i3 + 1] = (byte) i5;
            i3 += 2;
            i2--;
        }
        try {
            sb.append(new String(bArr, l.f10030b));
        } catch (UnsupportedEncodingException unused) {
            throw d.b.c.h.getFormatInstance();
        }
    }

    private static void c(d.b.c.z.c cVar, StringBuilder sb, int i2) throws d.b.c.h {
        while (i2 >= 3) {
            if (cVar.a() < 10) {
                throw d.b.c.h.getFormatInstance();
            }
            int iA = cVar.a(10);
            if (iA >= 1000) {
                throw d.b.c.h.getFormatInstance();
            }
            sb.append(a(iA / 100));
            sb.append(a((iA / 10) % 10));
            sb.append(a(iA % 10));
            i2 -= 3;
        }
        if (i2 == 2) {
            if (cVar.a() < 7) {
                throw d.b.c.h.getFormatInstance();
            }
            int iA2 = cVar.a(7);
            if (iA2 >= 100) {
                throw d.b.c.h.getFormatInstance();
            }
            sb.append(a(iA2 / 10));
            sb.append(a(iA2 % 10));
            return;
        }
        if (i2 == 1) {
            if (cVar.a() < 4) {
                throw d.b.c.h.getFormatInstance();
            }
            int iA3 = cVar.a(4);
            if (iA3 >= 10) {
                throw d.b.c.h.getFormatInstance();
            }
            sb.append(a(iA3));
        }
    }

    private static void a(d.b.c.z.c cVar, StringBuilder sb, int i2) throws d.b.c.h {
        if (i2 * 13 <= cVar.a()) {
            byte[] bArr = new byte[i2 * 2];
            int i3 = 0;
            while (i2 > 0) {
                int iA = cVar.a(13);
                int i4 = (iA % 96) | ((iA / 96) << 8);
                int i5 = i4 + (i4 < 959 ? 41377 : 42657);
                bArr[i3] = (byte) ((i5 >> 8) & 255);
                bArr[i3 + 1] = (byte) (i5 & 255);
                i3 += 2;
                i2--;
            }
            try {
                sb.append(new String(bArr, l.f10031c));
                return;
            } catch (UnsupportedEncodingException unused) {
                throw d.b.c.h.getFormatInstance();
            }
        }
        throw d.b.c.h.getFormatInstance();
    }

    private static void a(d.b.c.z.c cVar, StringBuilder sb, int i2, d.b.c.z.d dVar, Collection<byte[]> collection, Map<d.b.c.e, ?> map) throws d.b.c.h {
        String strName;
        if (i2 * 8 <= cVar.a()) {
            byte[] bArr = new byte[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                bArr[i3] = (byte) cVar.a(8);
            }
            if (dVar == null) {
                strName = l.a(bArr, map);
            } else {
                strName = dVar.name();
            }
            try {
                sb.append(new String(bArr, strName));
                collection.add(bArr);
                return;
            } catch (UnsupportedEncodingException unused) {
                throw d.b.c.h.getFormatInstance();
            }
        }
        throw d.b.c.h.getFormatInstance();
    }

    private static char a(int i2) throws d.b.c.h {
        char[] cArr = a;
        if (i2 < cArr.length) {
            return cArr[i2];
        }
        throw d.b.c.h.getFormatInstance();
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x006a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private static void a(d.b.c.z.c cVar, StringBuilder sb, int i2, boolean z) throws d.b.c.h {
        while (i2 > 1) {
            if (cVar.a() >= 11) {
                int iA = cVar.a(11);
                sb.append(a(iA / 45));
                sb.append(a(iA % 45));
                i2 -= 2;
            } else {
                throw d.b.c.h.getFormatInstance();
            }
        }
        if (i2 == 1) {
            if (cVar.a() >= 6) {
                sb.append(a(cVar.a(6)));
            } else {
                throw d.b.c.h.getFormatInstance();
            }
        }
        if (z) {
            for (int length = sb.length(); length < sb.length(); length++) {
                if (sb.charAt(length) == '%') {
                    if (length < sb.length() - 1) {
                        int i3 = length + 1;
                        if (sb.charAt(i3) == '%') {
                            sb.deleteCharAt(i3);
                        } else {
                            sb.setCharAt(length, (char) 29);
                        }
                    }
                }
            }
        }
    }

    private static int a(d.b.c.z.c cVar) throws d.b.c.h {
        int iA = cVar.a(8);
        if ((iA & 128) == 0) {
            return iA & 127;
        }
        if ((iA & 192) == 128) {
            return cVar.a(8) | ((iA & 63) << 8);
        }
        if ((iA & 224) == 192) {
            return cVar.a(16) | ((iA & 31) << 16);
        }
        throw d.b.c.h.getFormatInstance();
    }
}
